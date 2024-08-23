package com.beanbot.instrumentus.common.creative;

import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Objects;

public class InstrumentusCreativeModeTabPopulate {

    public static void populate(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == InstrumentusCreativeModeTab.MOD_ITEM_GROUP.get()) {
            event.accept(InstrumentusItems.KILN_BLOCK_ITEM.get());
            if(Config.PAXELS.get()) {
                event.accept(InstrumentusItems.WOODEN_PAXEL.get());
                event.accept(InstrumentusItems.STONE_PAXEL.get());
                event.accept(InstrumentusItems.IRON_PAXEL.get());
                event.accept(InstrumentusItems.GOLDEN_PAXEL.get());
                event.accept(InstrumentusItems.DIAMOND_PAXEL.get());
                event.accept(InstrumentusItems.NETHERITE_PAXEL.get());
                event.accept(InstrumentusItems.ENERGIZED_PAXEL.get());
                ItemStack fullPaxel = new ItemStack(InstrumentusItems.ENERGIZED_PAXEL.get());
                int paxelCapacity = Objects.requireNonNull(fullPaxel.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullPaxel.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(paxelCapacity, false);
                event.accept(fullPaxel);
            }

            if(Config.SHEARS.get()) {
                event.accept(InstrumentusItems.WOODEN_SHEARS.get());
                event.accept(InstrumentusItems.STONE_SHEARS.get());
                event.accept(InstrumentusItems.GOLDEN_SHEARS.get());
                event.accept(InstrumentusItems.DIAMOND_SHEARS.get());
                event.accept(InstrumentusItems.NETHERITE_SHEARS.get());
                event.accept(InstrumentusItems.ENERGIZED_SHEARS.get());
                ItemStack fullShears = new ItemStack(InstrumentusItems.ENERGIZED_SHEARS.get());
                int shearsCapacity = Objects.requireNonNull(fullShears.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullShears.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(shearsCapacity, false);
                event.accept(fullShears);
            }

            if(Config.SICKLES.get()) {
                event.accept(InstrumentusItems.WOODEN_SICKLE.get());
                event.accept(InstrumentusItems.STONE_SICKLE.get());
                event.accept(InstrumentusItems.IRON_SICKLE.get());
                event.accept(InstrumentusItems.GOLDEN_SICKLE.get());
                event.accept(InstrumentusItems.DIAMOND_SICKLE.get());
                event.accept(InstrumentusItems.NETHERITE_SICKLE.get());
                event.accept(InstrumentusItems.ENERGIZED_SICKLE.get());
                ItemStack fullSickle = new ItemStack(InstrumentusItems.ENERGIZED_SICKLE.get());
                int sickleCapacity = Objects.requireNonNull(fullSickle.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullSickle.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(sickleCapacity, false);
                event.accept(fullSickle);
            }

            if(Config.HAMMERS.get()) {
                event.accept(InstrumentusItems.WOODEN_HAMMER.get());
                event.accept(InstrumentusItems.STONE_HAMMER.get());
                event.accept(InstrumentusItems.IRON_HAMMER.get());
                event.accept(InstrumentusItems.GOLDEN_HAMMER.get());
                event.accept(InstrumentusItems.DIAMOND_HAMMER.get());
                event.accept(InstrumentusItems.NETHERITE_HAMMER.get());
                event.accept(InstrumentusItems.ENERGIZED_HAMMER.get());
                ItemStack fullHammer = new ItemStack(InstrumentusItems.ENERGIZED_HAMMER.get());
                int hammerCapacity = Objects.requireNonNull(fullHammer.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullHammer.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(hammerCapacity, false);
                event.accept(fullHammer);
            }

            if(Config.KNIVES.get()) {
                event.accept(InstrumentusItems.WOODEN_KNIFE.get());
                event.accept(InstrumentusItems.STONE_KNIFE.get());
                event.accept(InstrumentusItems.IRON_KNIFE.get());
                event.accept(InstrumentusItems.GOLDEN_KNIFE.get());
                event.accept(InstrumentusItems.DIAMOND_KNIFE.get());
                event.accept(InstrumentusItems.NETHERITE_KNIFE.get());
                event.accept(InstrumentusItems.ENERGIZED_KNIFE.get());
                ItemStack fullKnife = new ItemStack(InstrumentusItems.ENERGIZED_KNIFE.get());
                int knifeCapacity = Objects.requireNonNull(fullKnife.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullKnife.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(knifeCapacity, false);
                event.accept(fullKnife);
                event.accept(InstrumentusItems.PLANT_FIBER.get());
            }

            if(Config.ENERGIZED.get()) {
                event.accept(InstrumentusItems.ENERGIZED_INGOT.get());
                event.accept(InstrumentusItems.ENERGIZED_BLOCK.get());
                event.accept(InstrumentusItems.CARBON_ROD.get());
                event.accept(InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get());
                ItemStack fullLightningRod = new ItemStack(InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get());
                int lightningRodCapacity = Objects.requireNonNull(fullLightningRod.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullLightningRod.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(lightningRodCapacity, false);
                event.accept(fullLightningRod);
                event.accept(InstrumentusItems.ENERGIZED_PICKAXE.get());
                ItemStack fullPickaxe = new ItemStack(InstrumentusItems.ENERGIZED_PICKAXE.get());
                int pickaxeCapacity = Objects.requireNonNull(fullPickaxe.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullPickaxe.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(pickaxeCapacity, false);
                event.accept(fullPickaxe);
                event.accept(InstrumentusItems.ENERGIZED_AXE.get());
                ItemStack fullAxe = new ItemStack(InstrumentusItems.ENERGIZED_AXE.get());
                int axeCapacity = Objects.requireNonNull(fullAxe.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullAxe.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(axeCapacity, false);
                event.accept(fullAxe);
                event.accept(InstrumentusItems.ENERGIZED_SHOVEL.get());
                ItemStack fullShovel = new ItemStack(InstrumentusItems.ENERGIZED_SHOVEL.get());
                int shovelCapacity = Objects.requireNonNull(fullShovel.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullShovel.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(shovelCapacity, false);
                event.accept(fullShovel);
                event.accept(InstrumentusItems.ENERGIZED_HOE.get());
                ItemStack fullHoe = new ItemStack(InstrumentusItems.ENERGIZED_HOE.get());
                int hoeCapacity = Objects.requireNonNull(fullHoe.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullHoe.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(hoeCapacity, false);
                event.accept(fullHoe);
                event.accept(InstrumentusItems.ENERGIZED_EXCAVATOR.get());
                ItemStack fullExcavator = new ItemStack(InstrumentusItems.ENERGIZED_EXCAVATOR.get());
                int excavatorCapacity = Objects.requireNonNull(fullExcavator.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullExcavator.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(excavatorCapacity, false);
                event.accept(fullExcavator);
            }

            if(Config.SOULCOPPER.get()) {
                event.accept(InstrumentusItems.SOULCOPPER_PICKAXE.get());
                event.accept(InstrumentusItems.SOULCOPPER_INGOT.get());
                event.accept(InstrumentusItems.SOULCOPPER_BLOCK.get());
                event.accept(InstrumentusItems.RAW_SOULCOPPER.get());
                event.accept(InstrumentusItems.RAW_SOULCOPPER_BLOCK.get());
                event.accept(InstrumentusItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get());
                event.accept(InstrumentusItems.SOULCOPPER_TORCH_ITEM.get());
                event.accept(InstrumentusItems.SOULCOPPER_LANTERN_ITEM.get());
                event.accept(InstrumentusItems.SOULCOPPER_BURNER.get());
            }

            if(Config.COPPER_TOOLS.get()) {
                event.accept(InstrumentusItems.COPPER_PICKAXE.get());
                event.accept(InstrumentusItems.COPPER_SHOVEL.get());
                event.accept(InstrumentusItems.COPPER_AXE.get());
                event.accept(InstrumentusItems.COPPER_SWORD.get());
                event.accept(InstrumentusItems.COPPER_HOE.get());
                event.accept(InstrumentusItems.COPPER_PAXEL.get());
                event.accept(InstrumentusItems.COPPER_HAMMER.get());
                event.accept(InstrumentusItems.COPPER_SHEARS.get());
                event.accept(InstrumentusItems.COPPER_SICKLE.get());
                event.accept(InstrumentusItems.COPPER_KNIFE.get());
                event.accept(InstrumentusItems.COPPER_EXCAVATOR.get());
            }

            if(Config.BRUSHES.get()) {
                event.accept(InstrumentusItems.WOODEN_BRUSH.get());
                event.accept(InstrumentusItems.STONE_BRUSH.get());
                event.accept(InstrumentusItems.IRON_BRUSH.get());
                event.accept(InstrumentusItems.GOLDEN_BRUSH.get());
                event.accept(InstrumentusItems.DIAMOND_BRUSH.get());
                event.accept(InstrumentusItems.NETHERITE_BRUSH.get());
                event.accept(InstrumentusItems.ENERGIZED_BRUSH.get());
                ItemStack fullBrush = new ItemStack(InstrumentusItems.ENERGIZED_BRUSH.get());
                int brushCapacity = Objects.requireNonNull(fullBrush.getCapability(Capabilities.EnergyStorage.ITEM)).getMaxEnergyStored();
                Objects.requireNonNull(fullBrush.getCapability(Capabilities.EnergyStorage.ITEM)).receiveEnergy(brushCapacity, false);
                event.accept(fullBrush);
            }

            if(Config.EXCAVATORS.get()) {
                event.accept(InstrumentusItems.WOODEN_EXCAVATOR.get());
                event.accept(InstrumentusItems.STONE_EXCAVATOR.get());
                event.accept(InstrumentusItems.IRON_EXCAVATOR.get());
                event.accept(InstrumentusItems.GOLDEN_EXCAVATOR.get());
                event.accept(InstrumentusItems.DIAMOND_EXCAVATOR.get());
                event.accept(InstrumentusItems.NETHERITE_EXCAVATOR.get());
            }

        }
    }
}
