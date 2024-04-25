package com.beanbot.instrumentus.common.items;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

//HUGE thanks to the NeoArsenal Mod for some guidance on implementing FE-Based tools!

public class EnergyToolCommon {
    static final int CAPACITY = 20000;
    static final int MAX_TRANSFER = 100;

    static final String ENERGY_TAG = "Energy";

    public static float getChargeRatio(ItemStack stack){
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return 0;
        return (float) energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
    }

    static void addInformation(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        if(Capabilities.EnergyStorage.ITEM == null) return;
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return;
        Component energyText =  Component.translatable("instrumentus.lore.energy", String.format("%,d", energyStorage.getEnergyStored()), String.format("%,d", energyStorage.getMaxEnergyStored())).withStyle(ChatFormatting.DARK_GREEN);
        if(energyStorage.getEnergyStored() == 0){
            energyText = Component.translatable("instrumentus.lore.no_energy").withStyle(ChatFormatting.DARK_RED);
        }
        tooltip.add(energyText);
    }

    static boolean showDurabilityBar(ItemStack stack){
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return false;
        return energyStorage.getEnergyStored() != energyStorage.getMaxEnergyStored();
    }

    static double getDurabilityForDisplay(ItemStack stack){
        return 1 - getChargeRatio(stack);
    }

}
