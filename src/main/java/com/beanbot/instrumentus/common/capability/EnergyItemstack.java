package com.beanbot.instrumentus.common.capability;

import com.beanbot.instrumentus.common.items.datacomponents.ModDataComponents;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.EnergyStorage;

public class EnergyItemstack extends EnergyStorage {
    protected final ItemStack itemStack;

    public EnergyItemstack(int capacity, ItemStack itemStack) {
        super(capacity, capacity, capacity, 0);
        this.itemStack = itemStack;
        this.energy = itemStack.getOrDefault(ModDataComponents.FORGE_ENERGY, 0);
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        itemStack.set(ModDataComponents.FORGE_ENERGY, energy);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate){
        if(!canReceive())
            return 0;

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if(!simulate) {
            energy += energyReceived;
            itemStack.set(ModDataComponents.FORGE_ENERGY, energy);
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract())
            return 0;

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate) {
            energy -= energyExtracted;
            itemStack.set(ModDataComponents.FORGE_ENERGY, energy);
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        return itemStack.getOrDefault(ModDataComponents.FORGE_ENERGY, 0);
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public Tag serializeNBT(HolderLookup.Provider provider) {
        return IntTag.valueOf(this.getEnergyStored());
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, Tag nbt) {
        if (!(nbt instanceof IntTag intNbt))
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        this.energy = intNbt.getAsInt();
    }
}
