package com.beanbot.instrumentus.common.items.interfaces;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

public interface IItemLightningChargeable {

    default boolean isChargeFull(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return true;
        return energyStorage.getEnergyStored() == energyStorage.getMaxEnergyStored();
    }

    default ItemStack chargeToFull(ItemStack stack) {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return stack;
        energyStorage.receiveEnergy(energyStorage.getMaxEnergyStored(), false);
        return stack;
    }
}
