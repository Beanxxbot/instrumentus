package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnergyExcavatorItem extends ExcavatorItem implements IItemLightningChargeable, IEnergyItem {
    protected Tier tier;

    public EnergyExcavatorItem(Tier tier, float attackDamageIn, float attackSpeedIn){
        super(tier, attackSpeedIn, attackDamageIn);
        this.tier = tier;
    }

    @Override
    public int getMaxCapacity() {
        return 80000;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity){
        //noinspection ConstantValue
        if (state.getBlock() == null || level.getBlockState(pos).getBlock() == Blocks.AIR) return false;

        boolean isShovelable = state.is(BlockTags.MINEABLE_WITH_SHOVEL);
        int r = isShovelable ? 0 : 2;

        if(tier == Tiers.WOOD || tier == Tiers.STONE || tier == Tiers.IRON || tier == Tiers.GOLD || tier == Tiers.DIAMOND || tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED){
            r = 1;
        }
        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;

        if(isShovelable && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, level, pos, r, TrimType.TRIM_EARTH);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level level, BlockPos blockPos, int r, TrimType trimType){
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
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if(!(energyStorage == null)){
                            if(level.getBlockState(blockPos).getDestroySpeed(level, blockPos) != 0.0F){
                                energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                            }
                        }
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
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if(!(energyStorage == null)){
                            if(level.getBlockState(blockPos).getDestroySpeed(level, blockPos) != 0.0F){
                                energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                            }
                        }
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
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if(!(energyStorage == null)){
                            if(level.getBlockState(blockPos).getDestroySpeed(level, blockPos) != 0.0F){
                                energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                            }
                        }
                    }
                }
            }
        }
        return numberTrimmed;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker){
        return energyDamageEnemy(stack, target, attacker);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, @NotNull BlockState state){
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return 0.0F;
        if(!(energyStorage.getEnergyStored() > 0)) return 0.0F;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn){
        addTooltip(stack, context, tooltip, flagIn);

        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.excavator_1").withStyle(ChatFormatting.GRAY);
        if (Screen.hasShiftDown()) {
            tooltip.add(press);
            tooltip.add(empty);
            tooltip.add(pressed1);
        } else {
            tooltip.add(press);
        }
    }

    @Override
    public int getBarWidth(@NotNull ItemStack stack){
        return getEnergyBarWidth(stack);
    }

    @Override
    public int getBarColor(@NotNull ItemStack stack){
        return getEnergyBarColor(stack);
    }

    @Override
    public boolean isDamaged(@NotNull ItemStack stack){
        return isEnergyBelowZero(stack);
    }
    @Override
    public boolean isBarVisible(@NotNull ItemStack stack){
        return isEnergyBarVisible(stack);
    }

    public enum TrimType{
        TRIM_EARTH;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            //noinspection SwitchStatementWithTooFewBranches
            return switch (this) {
                default -> {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL) && state.canHarvestBlock(world, pos, (Player) entity)) {
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state, blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getState().getExpDrop(world, pos, blockEntity, entity, item));
                        world.removeBlock(pos, false);
                        yield true;
                    }
                    yield false;
                }
            };
        }
    }

}
