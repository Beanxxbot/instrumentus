package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class GeneratorLanguage extends LanguageProvider {
    public GeneratorLanguage(PackOutput output) {
        super(output, Instrumentus.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.WOODEN_SHEARS, "Wooden Shears");
        addItem(ModItems.STONE_SHEARS, "Stone Shears");
        addItem(ModItems.GOLDEN_SHEARS, "Golden Shears");
        addItem(ModItems.COPPER_SHEARS, "Copper Shears");
        addItem(ModItems.DIAMOND_SHEARS, "Diamond Shears");
        addItem(ModItems.NETHERITE_SHEARS, "Netherite Shears");
        addItem(ModItems.ENERGIZED_SHEARS, "Energized Di-Emerald Shears");

        addItem(ModItems.WOODEN_SICKLE, "Wooden Sickle");
        addItem(ModItems.STONE_SICKLE, "Stone Sickle");
        addItem(ModItems.IRON_SICKLE, "Iron Sickle");
        addItem(ModItems.GOLDEN_SICKLE, "Golden Sickle");
        addItem(ModItems.COPPER_SICKLE, "Copper Sickle");
        addItem(ModItems.DIAMOND_SICKLE, "Diamond Sickle");
        addItem(ModItems.NETHERITE_SICKLE, "Netherite Sickle");
        addItem(ModItems.ENERGIZED_SICKLE, "Energized Di-Emerald Sickle");

        addItem(ModItems.WOODEN_PAXEL, "Wooden Paxel");
        addItem(ModItems.STONE_PAXEL, "Stone Paxel");
        addItem(ModItems.IRON_PAXEL, "Iron Paxel");
        addItem(ModItems.GOLDEN_PAXEL, "Golden Paxel");
        addItem(ModItems.COPPER_PAXEL, "Copper Paxel");
        addItem(ModItems.DIAMOND_PAXEL, "Diamond Paxel");
        addItem(ModItems.NETHERITE_PAXEL, "Netherite Paxel");
        addItem(ModItems.ENERGIZED_PAXEL, "Energized Di-Emerald Paxel");

        addItem(ModItems.WOODEN_HAMMER, "Wooden Hammer");
        addItem(ModItems.STONE_HAMMER, "Stone Hammer");
        addItem(ModItems.IRON_HAMMER, "Iron Hammer");
        addItem(ModItems.GOLDEN_HAMMER, "Golden Hammer");
        addItem(ModItems.COPPER_HAMMER, "Copper Hammer");
        addItem(ModItems.DIAMOND_HAMMER, "Diamond Hammer");
        addItem(ModItems.NETHERITE_HAMMER, "Netherite Hammer");
        addItem(ModItems.ENERGIZED_HAMMER, "Energized Di-Emerald Hammer");

        addItem(ModItems.ENERGIZED_PICKAXE, "Energized Di-Emerald Pickaxe");
        addItem(ModItems.ENERGIZED_AXE, "Energized Di-Emerald Pickaxe");
        addItem(ModItems.ENERGIZED_SHOVEL, "Energized Di-Emerald Shovel");
        addItem(ModItems.ENERGIZED_HOE, "Energized Di-Emerald Hoe");
        addItem(ModItems.ENERGIZED_LIGHTNING_ROD, "Energized Di-Emerald Lightning Rod");
        addBlock(ModBlocks.ENERGIZED_BLOCK, "Energized Di-Emerald Block");

        addItem(ModItems.SOULCOPPER_PICKAXE, "Soulcopper Pickaxe");

        addItem(ModItems.ENERGIZED_INGOT, "Energized Di-Emerald Ingot");
        addItem(ModItems.RAW_SOULCOPPER, "Raw Soulcopper");
        addBlock(ModBlocks.RAW_SOULCOPPER_BLOCK, "Raw Soulcopper Block");
        addItem(ModItems.SOULCOPPER_INGOT, "Soulcopper Ingot");
        addBlock(ModBlocks.SOULCOPPER_BLOCK, "Soulcopper Block");
        addItem(ModItems.CARBON_ROD, "Carbon Rod");

        addBlock(ModBlocks.COPPER_SOUL_CAMPFIRE, "Copper-fueled Soul Campfire");
        addBlock(ModBlocks.COPPER_SOUL_FLAME_LIGHT, "Copper Soul Fire Flame");
        addBlock(ModBlocks.SOULCOPPER_TORCH, "Soulcopper Torch");
        addBlock(ModBlocks.SOULCOPPER_LANTERN, "Soulcopper Lantern");
        addItem(ModItems.SOULCOPPER_BURNER, "Soulcopper Burner");

        addItem(ModItems.WOODEN_KNIFE, "Wooden Knife");
        addItem(ModItems.STONE_KNIFE, "Stone Knife");
        addItem(ModItems.IRON_KNIFE, "Iron Knife");
        addItem(ModItems.GOLDEN_KNIFE, "Golden Knife");
        addItem(ModItems.COPPER_KNIFE, "Copper Knife");
        addItem(ModItems.DIAMOND_KNIFE, "Diamond Knife");
        addItem(ModItems.NETHERITE_KNIFE, "Netherite Knife");
        addItem(ModItems.ENERGIZED_KNIFE, "Energized Di-Emerald Knife");
        addItem(ModItems.PLANT_FIBER, "Plant Fiber");

        addItem(ModItems.COPPER_PICKAXE, "Copper Pickaxe");
        addItem(ModItems.COPPER_AXE, "Copper Axe");
        addItem(ModItems.COPPER_SHOVEL, "Copper Shovel");
        addItem(ModItems.COPPER_SWORD, "Copper Sword");
        addItem(ModItems.COPPER_HOE, "Copper Hoe");

        addItem(ModItems.WOODEN_BRUSH, "Wooden Brush");
        addItem(ModItems.STONE_BRUSH, "Stone Brush");
        addItem(ModItems.IRON_BRUSH, "Iron Brush");
        addItem(ModItems.GOLDEN_BRUSH, "Golden Brush");
        addItem(ModItems.DIAMOND_BRUSH, "Diamond Brush");
        addItem(ModItems.NETHERITE_BRUSH, "Netherite Brush");
        addItem(ModItems.ENERGIZED_BRUSH, "Energized Di-Emerald Brush");

        addItem(ModItems.WOODEN_EXCAVATOR, "Wooden Excavator");
        addItem(ModItems.STONE_EXCAVATOR, "Stone Excavator");
        addItem(ModItems.IRON_EXCAVATOR, "Iron Excavator");
        addItem(ModItems.GOLDEN_EXCAVATOR, "Golden Excavator");
        addItem(ModItems.DIAMOND_EXCAVATOR, "Diamond Excavator");
        addItem(ModItems.NETHERITE_EXCAVATOR, "Netherite Excavator");
        addItem(ModItems.COPPER_EXCAVATOR, "Copper Excavator");
        addItem(ModItems.ENERGIZED_EXCAVATOR, "Energized Di-Emerald Excavator");

        add(Instrumentus.MODID + ".lore.no_energy", "No Energy");
        add(Instrumentus.MODID + ".lore.energy", "%d FE/%d FE");
        add(Instrumentus.MODID + ".tooltip.energy", "");
        add(Instrumentus.MODID + ".coppersoulcampfirecookingrecipe.title", "Copper-fueled Soul Campfire Cooking");

        add(Instrumentus.MODID + ".creativetab", "Instrumentus");
    }
}
