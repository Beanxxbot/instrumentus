package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.client.particles.ModParticles;
import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.data.GeneratorBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

public class BurnerItem extends Item {

    private int heatCount;

    public BurnerItem() {
        super(new Item.Properties().durability(300).stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
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
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 40;
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
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
                        spawnFlameParticle(level, blockHitResult, blockState, entity.getViewVector(0.0F), humanoidArm);
                    }
                    SoundEvent soundevent = SoundEvents.CAMPFIRE_CRACKLE;
                    level.playSound(player, blockPos, soundevent, SoundSource.BLOCKS);
                    if (!level.isClientSide() && blockState.getBlock() instanceof WeatheringCopper weatheringCopper) {
                        if (weatheringCopper.getNext(blockState).isPresent()) {
                            if(player.getUseItemRemainingTicks() <= 6) {
                                level.setBlock(blockPos, WeatheringCopper.getNext(blockState.getBlock()).map(p -> p.withPropertiesOf(blockState)).orElse(null), 3);
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

    private void spawnFlameParticle(Level level, BlockHitResult hitResult, BlockState state, Vec3 pos, HumanoidArm arm) {
        int i = arm == HumanoidArm.RIGHT ? 1 : -1;
        int j = level.getRandom().nextInt(7, 12);
        Direction direction = hitResult.getDirection();
        FlameParticleDelta flameParticleDelta = FlameParticleDelta.fromDirection(pos, direction);
        Vec3 vec3 = hitResult.getLocation();

        double d0 = 0.5;
        for (int k = 0; k < j; k++) {
            level.addParticle(
                    (SimpleParticleType) ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(),
                    vec3.x,
                    vec3.y,
                    vec3.z,
                    flameParticleDelta.x() * (double) i * d0 * level.getRandom().nextDouble(),
                    flameParticleDelta.y() * (double) i * d0 * level.getRandom().nextDouble(),
                    flameParticleDelta.z() * (double) i * d0 * level.getRandom().nextDouble()
            );
        }
    }

    static record FlameParticleDelta(double x, double y, double z) {
        public static FlameParticleDelta fromDirection(Vec3 pos, Direction direction) {
            double d0 = 0.2;
            return switch (direction) {
                case UP -> new FlameParticleDelta(0.0, -d0, 0.0);
                case DOWN -> new FlameParticleDelta(0.0, d0, 0.0);
                case NORTH -> new FlameParticleDelta(0.0, 0.0, -d0);
                case SOUTH -> new FlameParticleDelta(0.0, 0.0, d0);
                case WEST -> new FlameParticleDelta(-d0, 0.0, 0.0);
                case EAST -> new FlameParticleDelta(d0, 0.0, 0.0);
            };
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return itemAbility == ItemAbilities.AXE_WAX_OFF;
    }
}
