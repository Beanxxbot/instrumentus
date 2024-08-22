package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class InstrumentusGeneratorLanguage extends LanguageProvider {
    public InstrumentusGeneratorLanguage(PackOutput output) {
        super(output, Instrumentus.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(InstrumentusItems.WOODEN_SHEARS, "Wooden Shears");
        addItem(InstrumentusItems.STONE_SHEARS, "Stone Shears");
        addItem(InstrumentusItems.GOLDEN_SHEARS, "Golden Shears");
        addItem(InstrumentusItems.COPPER_SHEARS, "Copper Shears");
        addItem(InstrumentusItems.DIAMOND_SHEARS, "Diamond Shears");
        addItem(InstrumentusItems.NETHERITE_SHEARS, "Netherite Shears");
        addItem(InstrumentusItems.ENERGIZED_SHEARS, "Energized Di-Emerald Shears");

        addItem(InstrumentusItems.WOODEN_SICKLE, "Wooden Sickle");
        addItem(InstrumentusItems.STONE_SICKLE, "Stone Sickle");
        addItem(InstrumentusItems.IRON_SICKLE, "Iron Sickle");
        addItem(InstrumentusItems.GOLDEN_SICKLE, "Golden Sickle");
        addItem(InstrumentusItems.COPPER_SICKLE, "Copper Sickle");
        addItem(InstrumentusItems.DIAMOND_SICKLE, "Diamond Sickle");
        addItem(InstrumentusItems.NETHERITE_SICKLE, "Netherite Sickle");
        addItem(InstrumentusItems.ENERGIZED_SICKLE, "Energized Di-Emerald Sickle");

        addItem(InstrumentusItems.WOODEN_PAXEL, "Wooden Paxel");
        addItem(InstrumentusItems.STONE_PAXEL, "Stone Paxel");
        addItem(InstrumentusItems.IRON_PAXEL, "Iron Paxel");
        addItem(InstrumentusItems.GOLDEN_PAXEL, "Golden Paxel");
        addItem(InstrumentusItems.COPPER_PAXEL, "Copper Paxel");
        addItem(InstrumentusItems.DIAMOND_PAXEL, "Diamond Paxel");
        addItem(InstrumentusItems.NETHERITE_PAXEL, "Netherite Paxel");
        addItem(InstrumentusItems.ENERGIZED_PAXEL, "Energized Di-Emerald Paxel");

        addItem(InstrumentusItems.WOODEN_HAMMER, "Wooden Hammer");
        addItem(InstrumentusItems.STONE_HAMMER, "Stone Hammer");
        addItem(InstrumentusItems.IRON_HAMMER, "Iron Hammer");
        addItem(InstrumentusItems.GOLDEN_HAMMER, "Golden Hammer");
        addItem(InstrumentusItems.COPPER_HAMMER, "Copper Hammer");
        addItem(InstrumentusItems.DIAMOND_HAMMER, "Diamond Hammer");
        addItem(InstrumentusItems.NETHERITE_HAMMER, "Netherite Hammer");
        addItem(InstrumentusItems.ENERGIZED_HAMMER, "Energized Di-Emerald Hammer");

        addItem(InstrumentusItems.ENERGIZED_PICKAXE, "Energized Di-Emerald Pickaxe");
        addItem(InstrumentusItems.ENERGIZED_AXE, "Energized Di-Emerald Pickaxe");
        addItem(InstrumentusItems.ENERGIZED_SHOVEL, "Energized Di-Emerald Shovel");
        addItem(InstrumentusItems.ENERGIZED_HOE, "Energized Di-Emerald Hoe");
        addItem(InstrumentusItems.ENERGIZED_LIGHTNING_ROD, "Energized Di-Emerald Lightning Rod");
        addBlock(InstrumentusBlocks.ENERGIZED_BLOCK, "Energized Di-Emerald Block");

        addItem(InstrumentusItems.SOULCOPPER_PICKAXE, "Soulcopper Pickaxe");

        addItem(InstrumentusItems.ENERGIZED_INGOT, "Energized Di-Emerald Ingot");
        addItem(InstrumentusItems.RAW_SOULCOPPER, "Raw Soulcopper");
        addBlock(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK, "Raw Soulcopper Block");
        addItem(InstrumentusItems.SOULCOPPER_INGOT, "Soulcopper Ingot");
        addBlock(InstrumentusBlocks.SOULCOPPER_BLOCK, "Soulcopper Block");
        addItem(InstrumentusItems.CARBON_ROD, "Carbon Rod");

        addBlock(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE, "Copper-fueled Soul Campfire");
        addBlock(InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT, "Copper Soul Fire Flame");
        addBlock(InstrumentusBlocks.SOULCOPPER_TORCH, "Soulcopper Torch");
        addBlock(InstrumentusBlocks.SOULCOPPER_LANTERN, "Soulcopper Lantern");
        addItem(InstrumentusItems.SOULCOPPER_BURNER, "Soulcopper Burner");

        addItem(InstrumentusItems.WOODEN_KNIFE, "Wooden Knife");
        addItem(InstrumentusItems.STONE_KNIFE, "Stone Knife");
        addItem(InstrumentusItems.IRON_KNIFE, "Iron Knife");
        addItem(InstrumentusItems.GOLDEN_KNIFE, "Golden Knife");
        addItem(InstrumentusItems.COPPER_KNIFE, "Copper Knife");
        addItem(InstrumentusItems.DIAMOND_KNIFE, "Diamond Knife");
        addItem(InstrumentusItems.NETHERITE_KNIFE, "Netherite Knife");
        addItem(InstrumentusItems.ENERGIZED_KNIFE, "Energized Di-Emerald Knife");
        addItem(InstrumentusItems.PLANT_FIBER, "Plant Fiber");

        addItem(InstrumentusItems.COPPER_PICKAXE, "Copper Pickaxe");
        addItem(InstrumentusItems.COPPER_AXE, "Copper Axe");
        addItem(InstrumentusItems.COPPER_SHOVEL, "Copper Shovel");
        addItem(InstrumentusItems.COPPER_SWORD, "Copper Sword");
        addItem(InstrumentusItems.COPPER_HOE, "Copper Hoe");

        addItem(InstrumentusItems.WOODEN_BRUSH, "Wooden Brush");
        addItem(InstrumentusItems.STONE_BRUSH, "Stone Brush");
        addItem(InstrumentusItems.IRON_BRUSH, "Iron Brush");
        addItem(InstrumentusItems.GOLDEN_BRUSH, "Golden Brush");
        addItem(InstrumentusItems.DIAMOND_BRUSH, "Diamond Brush");
        addItem(InstrumentusItems.NETHERITE_BRUSH, "Netherite Brush");
        addItem(InstrumentusItems.ENERGIZED_BRUSH, "Energized Di-Emerald Brush");

        addItem(InstrumentusItems.WOODEN_EXCAVATOR, "Wooden Excavator");
        addItem(InstrumentusItems.STONE_EXCAVATOR, "Stone Excavator");
        addItem(InstrumentusItems.IRON_EXCAVATOR, "Iron Excavator");
        addItem(InstrumentusItems.GOLDEN_EXCAVATOR, "Golden Excavator");
        addItem(InstrumentusItems.DIAMOND_EXCAVATOR, "Diamond Excavator");
        addItem(InstrumentusItems.NETHERITE_EXCAVATOR, "Netherite Excavator");
        addItem(InstrumentusItems.COPPER_EXCAVATOR, "Copper Excavator");
        addItem(InstrumentusItems.ENERGIZED_EXCAVATOR, "Energized Di-Emerald Excavator");

        addBlock(InstrumentusBlocks.KILN, "Kiln");
        add(Instrumentus.MODID + ".container.kiln", "Kiln");

        add(Instrumentus.MODID + ".lore.no_energy", "No Energy");
        add(Instrumentus.MODID + ".lore.energy", "%d FE/%d FE");
        add(Instrumentus.MODID + ".tooltip.energy", "");
        add(Instrumentus.MODID + ".coppersoulcampfirecookingrecipe.title", "Copper-fueled Soul Campfire Cooking");

        add(Instrumentus.MODID + ".creativetab", "Instrumentus");
    }
}
