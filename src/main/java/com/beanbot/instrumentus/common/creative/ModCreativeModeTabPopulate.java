package com.beanbot.instrumentus.common.creative;

import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class ModCreativeModeTabPopulate {

    public static void populate(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTab.MOD_ITEM_GROUP.get()) {
            if(Config.PAXELS.get()) {
                event.accept(ModItems.WOODEN_PAXEL.get());
                event.accept(ModItems.STONE_PAXEL.get());
                event.accept(ModItems.IRON_PAXEL.get());
                event.accept(ModItems.GOLDEN_PAXEL.get());
                event.accept(ModItems.DIAMOND_PAXEL.get());
                event.accept(ModItems.NETHERITE_PAXEL.get());
                event.accept(ModItems.ENERGIZED_PAXEL.get());
                ItemStack fullPaxel = new ItemStack(ModItems.ENERGIZED_PAXEL.get());
                int paxelCapacity = fullPaxel.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullPaxel.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(paxelCapacity, false);
                event.accept(fullPaxel);
            }

            if(Config.SHEARS.get()) {
                event.accept(ModItems.WOODEN_SHEARS.get());
                event.accept(ModItems.STONE_SHEARS.get());
                event.accept(ModItems.GOLDEN_SHEARS.get());
                event.accept(ModItems.DIAMOND_SHEARS.get());
                event.accept(ModItems.NETHERITE_SHEARS.get());
                event.accept(ModItems.ENERGIZED_SHEARS.get());
                ItemStack fullShears = new ItemStack(ModItems.ENERGIZED_SHEARS.get());
                int shearsCapacity = fullShears.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullShears.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(shearsCapacity, false);
                event.accept(fullShears);
            }

            if(Config.SICKLES.get()) {
                event.accept(ModItems.WOODEN_SICKLE.get());
                event.accept(ModItems.STONE_SICKLE.get());
                event.accept(ModItems.IRON_SICKLE.get());
                event.accept(ModItems.GOLDEN_SICKLE.get());
                event.accept(ModItems.DIAMOND_SICKLE.get());
                event.accept(ModItems.NETHERITE_SICKLE.get());
                event.accept(ModItems.ENERGIZED_SICKLE.get());
                ItemStack fullSickle = new ItemStack(ModItems.ENERGIZED_SICKLE.get());
                int sickleCapacity = fullSickle.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullSickle.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(sickleCapacity, false);
                event.accept(fullSickle);
            }

            if(Config.HAMMERS.get()) {
                event.accept(ModItems.WOODEN_HAMMER.get());
                event.accept(ModItems.STONE_HAMMER.get());
                event.accept(ModItems.IRON_HAMMER.get());
                event.accept(ModItems.GOLDEN_HAMMER.get());
                event.accept(ModItems.DIAMOND_HAMMER.get());
                event.accept(ModItems.NETHERITE_HAMMER.get());
                event.accept(ModItems.ENERGIZED_HAMMER.get());
                ItemStack fullHammer = new ItemStack(ModItems.ENERGIZED_HAMMER.get());
                int hammerCapacity = fullHammer.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullHammer.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(hammerCapacity, false);
                event.accept(fullHammer);
            }

            if(Config.KNIVES.get()) {
                event.accept(ModItems.WOODEN_KNIFE.get());
                event.accept(ModItems.STONE_KNIFE.get());
                event.accept(ModItems.IRON_KNIFE.get());
                event.accept(ModItems.GOLDEN_KNIFE.get());
                event.accept(ModItems.DIAMOND_KNIFE.get());
                event.accept(ModItems.NETHERITE_KNIFE.get());
                event.accept(ModItems.ENERGIZED_KNIFE.get());
                ItemStack fullKnife = new ItemStack(ModItems.ENERGIZED_KNIFE.get());
                int knifeCapacity = fullKnife.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullKnife.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(knifeCapacity, false);
                event.accept(fullKnife);
                event.accept(ModItems.PLANT_FIBER.get());
            }

            if(Config.ENERGIZED.get()) {
                event.accept(ModItems.ENERGIZED_INGOT.get());
                event.accept(ModItems.ENERGIZED_BLOCK.get());
                event.accept(ModItems.CARBON_ROD.get());
                event.accept(ModItems.ENERGIZED_LIGHTNING_ROD.get());
                ItemStack fullLightningRod = new ItemStack(ModItems.ENERGIZED_LIGHTNING_ROD.get());
                int lightningRodCapacity = fullLightningRod.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullLightningRod.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(lightningRodCapacity, false);
                event.accept(fullLightningRod);
                event.accept(ModItems.ENERGIZED_PICKAXE.get());
                ItemStack fullPickaxe = new ItemStack(ModItems.ENERGIZED_PICKAXE.get());
                int pickaxeCapacity = fullPickaxe.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullPickaxe.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(pickaxeCapacity, false);
                event.accept(fullPickaxe);
                event.accept(ModItems.ENERGIZED_AXE.get());
                ItemStack fullAxe = new ItemStack(ModItems.ENERGIZED_AXE.get());
                int axeCapacity = fullAxe.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullAxe.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(axeCapacity, false);
                event.accept(fullAxe);
                event.accept(ModItems.ENERGIZED_SHOVEL.get());
                ItemStack fullShovel = new ItemStack(ModItems.ENERGIZED_SHOVEL.get());
                int shovelCapacity = fullShovel.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullShovel.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(shovelCapacity, false);
                event.accept(fullShovel);
                event.accept(ModItems.ENERGIZED_HOE.get());
                ItemStack fullHoe = new ItemStack(ModItems.ENERGIZED_HOE.get());
                int hoeCapacity = fullHoe.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullHoe.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(hoeCapacity, false);
                event.accept(fullHoe);
            }

            if(Config.SOULCOPPER.get()) {
                event.accept(ModItems.SOULCOPPER_PICKAXE.get());
                event.accept(ModItems.SOULCOPPER_INGOT.get());
                event.accept(ModItems.SOULCOPPER_BLOCK.get());
                event.accept(ModItems.RAW_SOULCOPPER.get());
                event.accept(ModItems.RAW_SOULCOPPER_BLOCK.get());
                event.accept(ModItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get());
                event.accept(ModItems.SOULCOPPER_TORCH_ITEM.get());
                event.accept(ModItems.SOULCOPPER_LANTERN_ITEM.get());
                event.accept(ModItems.SOULCOPPER_BURNER.get());
            }

            if(Config.COPPER_TOOLS.get()) {
                event.accept(ModItems.COPPER_PICKAXE.get());
                event.accept(ModItems.COPPER_SHOVEL.get());
                event.accept(ModItems.COPPER_AXE.get());
                event.accept(ModItems.COPPER_SWORD.get());
                event.accept(ModItems.COPPER_HOE.get());
                event.accept(ModItems.COPPER_PAXEL.get());
                event.accept(ModItems.COPPER_HAMMER.get());
                event.accept(ModItems.COPPER_SHEARS.get());
                event.accept(ModItems.COPPER_SICKLE.get());
                event.accept(ModItems.COPPER_KNIFE.get());
            }

            if(Config.BRUSHES.get()) {
                event.accept(ModItems.WOODEN_BRUSH.get());
                event.accept(ModItems.STONE_BRUSH.get());
                event.accept(ModItems.IRON_BRUSH.get());
                event.accept(ModItems.GOLDEN_BRUSH.get());
                event.accept(ModItems.DIAMOND_BRUSH.get());
                event.accept(ModItems.NETHERITE_BRUSH.get());
                event.accept(ModItems.ENERGIZED_BRUSH.get());
                ItemStack fullBrush = new ItemStack(ModItems.ENERGIZED_BRUSH.get());
                int brushCapacity = fullBrush.getCapability(Capabilities.EnergyStorage.ITEM).getMaxEnergyStored();
                fullBrush.getCapability(Capabilities.EnergyStorage.ITEM).receiveEnergy(brushCapacity, false);
                event.accept(fullBrush);
            }

        }
    }
}
