package com.beanbot.instrumentus.common.creative;

import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class ModCreativeTabPopulate {

    static final int ENERGY_CAPACITY = 20000;
    static final String ENERGY_TAG = "Energy";

    public static void populate(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTab.MOD_ITEM_GROUP.get()) {
            event.accept(ModItems.WOODEN_PAXEL);
            event.accept(ModItems.STONE_PAXEL);
            event.accept(ModItems.IRON_PAXEL);
            event.accept(ModItems.GOLDEN_PAXEL);
            event.accept(ModItems.DIAMOND_PAXEL);
            event.accept(ModItems.NETHERITE_PAXEL);
            event.accept(ModItems.ENERGIZED_PAXEL);
            ItemStack fullPaxel = new ItemStack(ModItems.ENERGIZED_PAXEL.get());
            fullPaxel.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullPaxel);

            event.accept(ModItems.WOODEN_SHEARS);
            event.accept(ModItems.STONE_SHEARS);
            event.accept(ModItems.GOLDEN_SHEARS);
            event.accept(ModItems.DIAMOND_SHEARS);
            event.accept(ModItems.NETHERITE_SHEARS);
            event.accept(ModItems.ENERGIZED_SHEARS);
            ItemStack fullShears = new ItemStack(ModItems.ENERGIZED_SHEARS.get());
            fullShears.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullShears);

            event.accept(ModItems.WOODEN_SICKLE);
            event.accept(ModItems.STONE_SICKLE);
            event.accept(ModItems.IRON_SICKLE);
            event.accept(ModItems.GOLDEN_SICKLE);
            event.accept(ModItems.DIAMOND_SICKLE);
            event.accept(ModItems.NETHERITE_SICKLE);
            event.accept(ModItems.ENERGIZED_SICKLE);
            ItemStack fullSickle = new ItemStack(ModItems.ENERGIZED_SICKLE.get());
            fullSickle.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullSickle);

            event.accept(ModItems.WOODEN_HAMMER);
            event.accept(ModItems.STONE_HAMMER);
            event.accept(ModItems.IRON_HAMMER);
            event.accept(ModItems.GOLDEN_HAMMER);
            event.accept(ModItems.DIAMOND_HAMMER);
            event.accept(ModItems.NETHERITE_HAMMER);
            event.accept(ModItems.ENERGIZED_HAMMER);
            ItemStack fullHammer = new ItemStack(ModItems.ENERGIZED_HAMMER.get());
            fullHammer.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullHammer);

            event.accept(ModItems.WOODEN_KNIFE);
            event.accept(ModItems.STONE_KNIFE);
            event.accept(ModItems.IRON_KNIFE);
            event.accept(ModItems.GOLDEN_KNIFE);
            event.accept(ModItems.DIAMOND_KNIFE);
            event.accept(ModItems.NETHERITE_KNIFE);
            event.accept(ModItems.ENERGIZED_KNIFE);
            ItemStack fullKnife = new ItemStack(ModItems.ENERGIZED_KNIFE.get());
            fullKnife.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullKnife);
            event.accept(ModItems.PLANT_FIBER);

            event.accept(ModItems.ENERGIZED_INGOT);
            event.accept(ModItems.ENERGIZED_BLOCK);
            event.accept(ModItems.CARBON_ROD);
            event.accept(ModItems.ENERGY_LIGHTNING_ROD);
            ItemStack fullLightningRod = new ItemStack(ModItems.ENERGY_LIGHTNING_ROD.get());
            fullLightningRod.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullLightningRod);
            event.accept(ModItems.ENERGIZED_PICKAXE);
            ItemStack fullPickaxe = new ItemStack(ModItems.ENERGIZED_PICKAXE.get());
            fullPickaxe.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullPickaxe);
            event.accept(ModItems.ENERGIZED_AXE);
            ItemStack fullAxe = new ItemStack(ModItems.ENERGIZED_AXE.get());
            fullAxe.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullAxe);
            event.accept(ModItems.ENERGIZED_SHOVEL);
            ItemStack fullShovel = new ItemStack(ModItems.ENERGIZED_SHOVEL.get());
            fullShovel.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullShovel);

            event.accept(ModItems.SOULCOPPER_PICKAXE);
            event.accept(ModItems.SOULCOPPER_INGOT);
            event.accept(ModItems.SOULCOPPER_BLOCK);
            event.accept(ModItems.RAW_SOULCOPPER);
            event.accept(ModItems.RAW_SOULCOPPER_BLOCK);
            event.accept(ModItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM);
            event.accept(ModItems.SOULCOPPER_TORCH_ITEM);
            event.accept(ModItems.SOULCOPPER_LANTERN_ITEM);

            event.accept(ModItems.COPPER_PICKAXE);
            event.accept(ModItems.COPPER_SHOVEL);
            event.accept(ModItems.COPPER_AXE);
            event.accept(ModItems.COPPER_SWORD);
            event.accept(ModItems.COPPER_HOE);
            event.accept(ModItems.COPPER_PAXEL);
            event.accept(ModItems.COPPER_HAMMER);
            event.accept(ModItems.COPPER_SHEARS);
            event.accept(ModItems.COPPER_SICKLE);
            event.accept(ModItems.COPPER_KNIFE);

            event.accept(ModItems.WOODEN_BRUSH);
            event.accept(ModItems.STONE_BRUSH);
            event.accept(ModItems.IRON_BRUSH);
            event.accept(ModItems.GOLDEN_BRUSH);
            event.accept(ModItems.DIAMOND_BRUSH);
            event.accept(ModItems.NETHERITE_BRUSH);
            event.accept(ModItems.ENERGIZED_BRUSH);
            ItemStack fullBrush = new ItemStack(ModItems.ENERGIZED_BRUSH.get());
            fullBrush.getOrCreateTag().putInt(ENERGY_TAG, ENERGY_CAPACITY);
            event.accept(fullBrush);


        }
    }
}
