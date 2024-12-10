package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Objects;

public class KnifeItem extends TieredItem {

    public KnifeItem(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
    }

    private static Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            return new Properties().attributes(DiggerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Properties().attributes(DiggerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            player.startUsingItem(context.getHand());
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH;
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 60;
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
            HitResult hitResult = this.calculateHitResult(player);
            if (hitResult instanceof BlockHitResult blockHitResult) {
                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    int i = this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1;
                    boolean flag = i % 10 == 5;
                    if (flag) {
                        BlockPos blockPos = blockHitResult.getBlockPos();
                        BlockState attachedState = level.getBlockState(blockPos.relative(blockHitResult.getDirection()));
                        if (attachedState.is(Blocks.GLOW_LICHEN)) {
                            level.playSound(player, blockPos, SoundEvents.SLIME_ATTACK, SoundSource.BLOCKS, 0.3F, level.random.nextFloat() * 0.1F + 0.9F);
                            if (player.getUseItemRemainingTicks() <= 6) {
                                if (!level.isClientSide()) {
                                    double d0 = (double) EntityType.ITEM.getWidth();
                                    double d1 = 1.0 - d0;
                                    double d2 = d0 / 2.0;
                                    double d3 = (double) blockPos.getX() + 0.5 * d1 + d2;
                                    double d4 = (double) blockPos.getY() + 0.5 + (double) (EntityType.ITEM.getHeight() / 2.0F);
                                    double d5 = (double) blockPos.getZ() + 0.5 * d1 + d2;
                                    ItemStack droppedStack = new ItemStack(Items.SLIME_BALL);
                                    droppedStack.setCount(1);
                                    ItemEntity itemEntity = new ItemEntity(level, d3, d4, d5, droppedStack.split(level.random.nextInt(21) + 10));
                                    ItemSpawnDelta itemSpawnDelta = ItemSpawnDelta.fromDirection(blockHitResult.getDirection());
                                    itemEntity.setDeltaMovement(itemSpawnDelta.x(), itemSpawnDelta.y(), itemSpawnDelta.z());
                                    level.addFreshEntity(itemEntity);
                                    EquipmentSlot equipmentSlot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND))
                                            ? EquipmentSlot.OFFHAND
                                            : EquipmentSlot.MAINHAND;
                                    stack.hurtAndBreak(1, livingEntity, equipmentSlot);
                                    if (level.random.nextInt(0, 100) > 60) {
                                        level.destroyBlock(blockPos.relative(blockHitResult.getDirection()), false);
                                    }
                                }
                                level.playSound(player, blockPos, SoundEvents.BUCKET_FILL_LAVA, SoundSource.BLOCKS, 3.0f, 2.0f);
                            }
                        } else {
                            level.playSound(player, blockPos, SoundEvents.WOLF_ARMOR_CRACK, SoundSource.BLOCKS, 0.2f, 1.0f);
                        }
                    }
                    return;
                }
            }
            livingEntity.releaseUsingItem();
        } else {
            livingEntity.releaseUsingItem();
        }
    }

    record ItemSpawnDelta(double x, double y, double z) {
        public static ItemSpawnDelta fromDirection(Direction direction) {
            double d0 = 0.2;
            return switch (direction) {
                case UP -> new ItemSpawnDelta(0.0, d0, 0.0);
                case DOWN -> new ItemSpawnDelta(0.0, -d0, 0.0);
                case NORTH -> new ItemSpawnDelta(0.0, 0.0, -d0);
                case SOUTH -> new ItemSpawnDelta(0.0, 0.0, d0);
                case WEST -> new ItemSpawnDelta(-d0, 0.0, 0.0);
                case EAST -> new ItemSpawnDelta(d0, 0.0, 0.0);
            };
        }
    }

    private HitResult calculateHitResult(Player player) {
        return ProjectileUtil.getHitResultOnViewVector(
                player, p -> !p.isSpectator() && p.isPickable(), player.blockInteractionRange());
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState block) {
        return block.is(Blocks.TALL_GRASS) || block.is(Blocks.SHORT_GRASS);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if ((double) state.getDestroySpeed(worldIn, pos) != 0.0D || state.is(Blocks.SHORT_GRASS)) {
            stack.hurtAndBreak(2, entityLiving, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
