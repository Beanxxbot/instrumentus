package com.beanbot.instrumentus.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

public class ExcavatorItem extends DiggerItem {

    protected ToolMaterial material;

    public ExcavatorItem(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn) {
        super(toolMaterial, BlockTags.MINEABLE_WITH_SHOVEL, attackDamageIn, attackSpeedIn,generateItemProperties(toolMaterial, attackDamageIn, attackSpeedIn));
        this.material = toolMaterial;
    }

    private static Item.Properties generateItemProperties(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn) {
        if (toolMaterial == ToolMaterial.NETHERITE || toolMaterial == InstrumentusToolMaterials.ENERGIZED) {
            return new Item.Properties().stacksTo(1).fireResistant();
        }
        return new Item.Properties().stacksTo(1);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility ability) {
        return ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(ability);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
        //noinspection ConstantValue
        if (state.getBlock() == null || level.getBlockState(pos).getBlock() == Blocks.AIR) return false;

        boolean isShovelable = state.is(BlockTags.MINEABLE_WITH_SHOVEL);
        int r = isShovelable ? 0 : 2;

        if (material == ToolMaterial.WOOD || material == ToolMaterial.STONE || material == ToolMaterial.IRON || material == InstrumentusToolMaterials.COPPER || material == ToolMaterial.GOLD || material == ToolMaterial.DIAMOND || material == ToolMaterial.NETHERITE || material == InstrumentusToolMaterials.ENERGIZED) {
            r = 1;
        }

        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;
        if(isShovelable && !entity.isCrouching()) {
            numberTrimmed += trim(stack, entity, level, pos, r, TrimType.TRIM_EARTH);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level level, BlockPos blockPos, int r, TrimType trimType) {
        int numberTrimmed = 0;
        Player player = (Player) entity;

        BlockHitResult blockHitResult = new BlockHitResult(new Vec3(player.getX(), player.getY(), player.getZ()), getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE).getDirection(), blockPos, false);
        Direction blockFaceMined = blockHitResult.getDirection();

        if(blockFaceMined == Direction.EAST || blockFaceMined == Direction.WEST/*look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75*/) {
            for (int dz = -r; dz <= r; dz++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dz == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(0, dy, dz), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if(blockFaceMined == Direction.NORTH || blockFaceMined == Direction.SOUTH/*look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75*/) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(dx, dy, 0), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if (blockFaceMined == Direction.UP || blockFaceMined == Direction.DOWN /*look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75*/) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (dz == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(dx, 0, dz), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        }
        return numberTrimmed;
    }

    public enum TrimType{
        TRIM_EARTH;

        public boolean trimAtPos(Level level, BlockPos pos, LivingEntity entity, ItemStack item) {
            BlockState state = level.getBlockState(pos);
            BlockEntity blockEntity = level.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(level, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            //noinspection SwitchStatementWithTooFewBranches
            return switch (this) {
                default -> {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL) && state.canHarvestBlock(level, pos, (Player) entity)) {
                        state.getBlock().playerDestroy(level, (Player) entity, pos, state, blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) level, pos, event.getState().getExpDrop(level, pos, blockEntity, entity, item));
                        level.removeBlock(pos, false);
                        yield true;
                    }
                    yield false;
                }
            };
        }
    }
}
