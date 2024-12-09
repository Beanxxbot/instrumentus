package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnergyHammerItem extends HammerItem implements IItemLightningChargeable, IEnergyItem {

    protected ToolMaterial material;

    public EnergyHammerItem(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn){
        super(toolMaterial, attackSpeedIn, attackDamageIn);
        this.material = toolMaterial;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity){
        //noinspection ConstantValue
        if(state.getBlock() == null || level.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isStone = state.is(BlockTags.MINEABLE_WITH_PICKAXE);

        int r = isStone ? 0 : 2;

        if(material == ToolMaterial.WOOD || material == ToolMaterial.STONE || material == ToolMaterial.IRON || material == ToolMaterial.GOLD || material == ToolMaterial.DIAMOND || material == ToolMaterial.NETHERITE || material == InstrumentusToolMaterials.ENERGIZED){
            r = 1;
        }
        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;

        if(isStone && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, level, pos, r, TrimType.TRIM_ROCK);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level level, BlockPos blockPos, int r, TrimType trimType){
        int numberTrimmed = 0;
        Vec3 look = entity.getLookAngle();

        if(look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75) {
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
        } else if(look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75) {
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
        } else if (look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75) {
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
        TRIM_ROCK;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            //noinspection SwitchStatementWithTooFewBranches
            return switch (this) {
                default -> {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) && state.canHarvestBlock(world, pos, (Player) entity)) {
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
