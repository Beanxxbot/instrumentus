package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.client.particles.InstrumentusParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BurnerItem extends Item {

    public BurnerItem() {
        super(new Item.Properties().durability(300).stacksTo(1));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            player.startUsingItem(context.getHand());
        }

        return InteractionResult.CONSUME;
    }

    private HitResult calculateHitResult(Player player) {
        return ProjectileUtil.getHitResultOnViewVector(
                player, p -> !p.isSpectator() && p.isPickable(), player.blockInteractionRange());
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 40;
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity entity, @NotNull ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration >= 0 && entity instanceof Player player) {
            HitResult hitResult = this.calculateHitResult(player);
            if (hitResult instanceof BlockHitResult blockHitResult && hitResult.getType() == HitResult.Type.BLOCK) {
                int i = this.getUseDuration(stack, entity) - remainingUseDuration + 1;
                boolean flag = i % 10 == 5;
                if (flag) {
                    BlockPos blockPos = blockHitResult.getBlockPos();
                    BlockState blockState = level.getBlockState(blockPos);
                    HumanoidArm humanoidArm = entity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
                    if (blockState.getRenderShape() != RenderShape.INVISIBLE) {
                        spawnFlameParticle(level, blockHitResult, entity.getViewVector(0.0F), humanoidArm);
                    }
                    SoundEvent soundevent = SoundEvents.CAMPFIRE_CRACKLE;
                    level.playSound(player, blockPos, soundevent, SoundSource.BLOCKS);
                    if (!level.isClientSide() && blockState.getBlock() instanceof WeatheringCopper weatheringCopper) {
                        if (weatheringCopper.getNext(blockState).isPresent()) {
                            if(player.getUseItemRemainingTicks() <= 6) {
                                level.setBlock(blockPos, Objects.requireNonNull(WeatheringCopper.getNext(blockState.getBlock()).map(p -> p.withPropertiesOf(blockState)).orElse(null)), 3);
                                EquipmentSlot equipmentSlot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND))
                                        ? EquipmentSlot.OFFHAND
                                        : EquipmentSlot.MAINHAND;
                                stack.hurtAndBreak(1, entity, equipmentSlot);
                            }
                        }
                    }
                }
                return;
            }
            entity.releaseUsingItem();
        } else {
            entity.releaseUsingItem();
        }
    }

    private void spawnFlameParticle(Level level, BlockHitResult hitResult, @SuppressWarnings("unused") Vec3 pos, HumanoidArm arm) {
        int i = arm == HumanoidArm.RIGHT ? 1 : -1;
        int j = level.getRandom().nextInt(7, 12);
        Direction direction = hitResult.getDirection();
        FlameParticleDelta flameParticleDelta = FlameParticleDelta.fromDirection(direction);
        Vec3 vec3 = hitResult.getLocation();

        double d0 = 0.5;
        for (int k = 0; k < j; k++) {
            level.addParticle(
                    (SimpleParticleType) InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(),
                    vec3.x,
                    vec3.y,
                    vec3.z,
                    flameParticleDelta.x() * (double) i * d0 * level.getRandom().nextDouble(),
                    flameParticleDelta.y() * (double) i * d0 * level.getRandom().nextDouble(),
                    flameParticleDelta.z() * (double) i * d0 * level.getRandom().nextDouble()
            );
        }
    }

    record FlameParticleDelta(double x, double y, double z) {
        public static FlameParticleDelta fromDirection(Direction direction) {
            double d0 = 0.2;
            return switch (direction) {
                case UP -> new FlameParticleDelta(0.0, d0, 0.0);
                case DOWN -> new FlameParticleDelta(0.0, -d0, 0.0);
                case NORTH -> new FlameParticleDelta(0.0, 0.0, -d0);
                case SOUTH -> new FlameParticleDelta(0.0, 0.0, d0);
                case WEST -> new FlameParticleDelta(-d0, 0.0, 0.0);
                case EAST -> new FlameParticleDelta(d0, 0.0, 0.0);
            };
        }
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility itemAbility) {
        return itemAbility == ItemAbilities.AXE_WAX_OFF;
    }
}
