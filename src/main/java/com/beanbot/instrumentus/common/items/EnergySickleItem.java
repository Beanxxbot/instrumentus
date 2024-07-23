package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class EnergySickleItem extends SickleItem implements IItemLightningChargeable, IEnergyItem {

    protected Tier tier;

    public EnergySickleItem(Tier tier) {
        super(tier);
        this.tier = tier;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isLeaves = state.is(BlockTags.LEAVES);

        int radius = isLeaves ? 0 : 2;
        int height = isLeaves ? 0 : 2;

        if(tier == Tiers.WOOD || tier == Tiers.STONE)
        {
            radius = 1;
            height = 1;
        }
        if(tier == Tiers.IRON || tier == Tiers.GOLD || tier == Tiers.DIAMOND)
        {
            radius = 2;
            height = 2;
        }
        if(tier == Tiers.NETHERITE || tier == ModItemTiers.ENERGIZED)
        {
            radius = 3;
            height = 3;
        }

        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(!(energyStorage == null)){
            if(state.getDestroySpeed(world, pos) != 0.0F){
                energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
            }
        }

        int numberTrimmed = 0;


        if(isLeaves && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_LEAVES, false, 40);
        }
        else
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (world.random.nextInt(3) == 0)
            {
                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int height, int radius, SickleItem.TrimType trimType, boolean cutCorners, int damagePercentChance)
    {
        int numberTrimmed = 0;
        int fortune = 0;

        for(int dx = -radius; dx <= radius; dx++)
        {
            for(int dy = -radius; dy <= radius; dy++)
            {
                for(int dz = -radius; dz <= radius; dz++)
                {
                    if(dx == 0 && dy == 0 && dz == 0 || cutCorners && (Math.abs(dz) >= 2*radius))
                        continue;

                    if(trimType.trimAtPos(world, pos.subtract(new Vec3i(dx,dy,dz).multiply(-1)), entity, stack))
                    {
                        numberTrimmed++;
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if(!(energyStorage == null)){
                            energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                        }
                    }
                }
            }
        }
        return numberTrimmed;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        return energyDamageEnemy(stack, target, attacker);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return 0.0F;
        if(!(energyStorage.getEnergyStored() > 0)) return 0.0F;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn){
        addTooltip(stack, context, tooltip, flagIn);
    }

    @Override
    public int getBarWidth(ItemStack stack){
        return getEnergyBarWidth(stack);
    }

    @Override
    public int getBarColor(ItemStack stack){
        return getEnergyBarColor(stack);
    }

    @Override
    public boolean isDamaged(ItemStack stack){
        return isEnergyBelowZero(stack);
    }
    @Override
    public boolean isBarVisible(ItemStack stack){
        return isEnergyBarVisible(stack);
    }

    public enum TrimType
    {
        TRIM_GRASS_AND_FLOWERS, TRIM_LEAVES;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            switch (this)
            {
                case TRIM_LEAVES:
                    if(state.is(BlockTags.LEAVES))
                    {
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getState().getExpDrop(world, pos, blockEntity, entity, item));
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;

                case TRIM_GRASS_AND_FLOWERS:default:
                if(state.is(Blocks.TALL_GRASS) || state.is(BlockTags.FLOWERS) || state.is(Blocks.SHORT_GRASS))
                {
                    state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                    state.getBlock().popExperience((ServerLevel) world, pos, event.getState().getExpDrop(world, pos, blockEntity, entity, item));
                    world.removeBlock(pos, false);
                    return true;
                }
                return false;
            }
        }
    }
}
