package com.beanbot.instrumentus.common.items;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

//HUGE thanks to the NeoArsenal Mod for some guidance on implementing FE-Based tools!

public class EnergyToolCommon {
    static final int CAPACITY = 20000;
    static final int MAX_TRANSFER = 100;

    static final String ENERGY_TAG = "Energy";

    public static float getChargeRatio(ItemStack stack){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if (lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(IllegalStateException::new);
            return (float) storage.getEnergyStored() / storage.getMaxEnergyStored();
        }
        return 0;
    }

    static void addInformation(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        if(CapabilityEnergy.ENERGY == null) return;

        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()) {
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            TranslatableComponent energyText = new TranslatableComponent("instrumentus.lore.energy", String.format("%,d", storage.getEnergyStored()), String.format("%,d", storage.getMaxEnergyStored()));
            if(storage.getEnergyStored() == 0){
                energyText = new TranslatableComponent("instrumentus.lore.no_energy");
                tooltip.add(energyText.withStyle(ChatFormatting.DARK_RED));
            } else {
                tooltip.add(energyText.withStyle(ChatFormatting.DARK_GREEN));
            }
        }
    }

    static boolean showDurabilityBar(ItemStack stack){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            return storage.getEnergyStored() != storage.getMaxEnergyStored();
        }
        return false;
    }

    static double getDurabilityForDisplay(ItemStack stack){
        return 1 - getChargeRatio(stack);
    }

}
