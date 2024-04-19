package com.beanbot.instrumentus.common.capability;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EnergyStorageItem extends EnergyStorage implements ICapabilityProvider {

    private final LazyOptional<EnergyStorageItem> LAZY;
    private final ItemStack STACK;

    public EnergyStorageItem(ItemStack stack, int capacity, int maxReceive, int maxExtract){
        super(capacity, maxReceive, maxExtract);
        this.STACK = stack;
        this.LAZY = LazyOptional.of(() -> this);
    }

    public EnergyStorageItem(ItemStack stack, int capacity, int maxTransfer){
        super(capacity, maxTransfer);
        this.STACK = stack;
        this.LAZY = LazyOptional.of(() -> this);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate){
        if(!canReceive()) return 0;

        int energyStored = getEnergyStored();
        int energyReceived = Math.min(capacity - energyStored, Math.min(this.maxReceive, maxReceive));
        if(!simulate) setEnergyStored(energyStored + energyReceived);
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate){
        if(!canExtract()) return 0;

        int energyStored = getEnergyStored();
        int energyExtracted = Math.min(energyStored, Math.min(this.maxExtract, maxExtract));
        if(!simulate) setEnergyStored(energyStored - energyExtracted);
        return energyExtracted;
    }

    @Override
    public int getEnergyStored(){
        return STACK.getOrCreateTag().getInt("Energy");
    }

    public void setEnergyStored(int amount){
        STACK.getOrCreateTag().putInt("Energy", amount);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side){
        return ForgeCapabilities.ENERGY.orEmpty(cap, LAZY.cast());
    }
}
