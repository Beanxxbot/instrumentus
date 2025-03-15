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
import net.minecraft.world.level.block.*;
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

    private static boolean isGrownCrop(BlockState state) {
        if (state.is(BlockTags.CROPS)) {
            if (state.is(Blocks.PITCHER_CROP)) {
                int maxAge = PitcherCropBlock.MAX_AGE;
                return state.getValue(PitcherCropBlock.AGE) == maxAge;
            }
            if (state.is(Blocks.PUMPKIN_STEM) || state.is(Blocks.MELON_STEM)) {
                int maxAge = StemBlock.MAX_AGE;
                return state.getValue(StemBlock.AGE) == maxAge;
            }
            CropBlock cropBlock = (CropBlock) state.getBlock();
            int maxAge = cropBlock.getMaxAge();
            if (state.is(Blocks.BEETROOTS)) {
                return state.getValue(BeetrootBlock.AGE) == maxAge;
            }
            return state.getValue(CropBlock.AGE) == maxAge;
        }
        return false;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isLeaves = state.is(BlockTags.LEAVES);
        boolean isCrops = state.is(BlockTags.CROPS) && isGrownCrop(state);

        int radius = isLeaves ? 0 : 2;
        int height = isLeaves ? 0 : 2;

        if (tier == Tiers.WOOD || tier == Tiers.STONE) {
            radius = 1;
            height = 1;
        }
        if (tier == Tiers.IRON || tier == Tiers.GOLD || tier == Tiers.DIAMOND) {
            radius = 2;
            height = 2;
        }
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            radius = 3;
            height = 3;
        }

        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (!(energyStorage == null)) {
            if (state.getDestroySpeed(world, pos) != 0.0F) {
                energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
            }
        }

        int numberTrimmed = 0;


        if (isLeaves && !entity.isCrouching()) {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_LEAVES, false, 40);
        } else if (isCrops && !entity.isCrouching()) {
            numberTrimmed += trim(stack, entity, world, pos, 0, 1, SickleItem.TrimType.TRIM_CROPS, false, 40);
        } else {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (world.random.nextInt(3) == 0) {
                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int height, int radius, SickleItem.TrimType trimType, boolean cutCorners, int damagePercentChance) {
        int numberTrimmed = 0;
        int fortune = 0;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0 || cutCorners && (Math.abs(dz) >= 2 * radius))
                        continue;

                    if (trimType.trimAtPos(world, pos.subtract(new Vec3i(dx, dy, dz).multiply(-1)), entity, stack)) {
                        numberTrimmed++;
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if (!(energyStorage == null)) {
                            energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                        }
                    }
                }
            }
        }
        return numberTrimmed;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return energyDamageEnemy(stack, target, attacker);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return 0.0F;
        if (!(energyStorage.getEnergyStored() > 0)) return 0.0F;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        addTooltip(stack, context, tooltip, flagIn);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return getEnergyBarWidth(stack);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return getEnergyBarColor(stack);
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return isEnergyBelowZero(stack);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return isEnergyBarVisible(stack);
    }
}
