package com.beanbot.instrumentus.common.items.interfaces;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.List;

public interface IEnergyItem {

    default int getCharge(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return -1;
        return energyStorage.getEnergyStored();
    }

    default float getChargeRatio(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return 0;
        return (float) energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
    }

    default boolean energyDamageEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return false;
        energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
        return true;
    }

    default int getEnergyBarWidth(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return 13;
        return Math.min(13 * energyStorage.getMaxEnergyStored() / energyStorage.getMaxEnergyStored(), 13);
    }

    default boolean isEnergyBarVisible(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return false;
        return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
    }

    default int getEnergyBarColor(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return -1;
        return Mth.hsvToRgb(Math.max(0.0f, energyStorage.getEnergyStored() / (float) energyStorage.getMaxEnergyStored()) / 3.0f, 1.0f, 1.0f);
    }

    default boolean isEnergyBelowZero(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return false;
        return energyStorage.getEnergyStored() != energyStorage.getMaxEnergyStored();
    }

    default void addTooltip(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn){
        if(Capabilities.EnergyStorage.ITEM == null) return;
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return;
        Component energyText =  Component.translatable("instrumentus.lore.energy", String.format("%,d", energyStorage.getEnergyStored()), String.format("%,d", energyStorage.getMaxEnergyStored())).withStyle(ChatFormatting.DARK_GREEN);
        if(energyStorage.getEnergyStored() == 0){
            energyText = Component.translatable("instrumentus.lore.no_energy").withStyle(ChatFormatting.DARK_RED);
        }
        tooltip.add(energyText);
    }

    default int getMaxCapacity() {
        return 20000;
    }

    default int getMaxTransferRate() {
        return 100;
    }
}
