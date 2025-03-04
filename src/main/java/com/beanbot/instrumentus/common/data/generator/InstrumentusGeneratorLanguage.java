package com.beanbot.instrumentus.common.data.generator;

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
        addBlock(InstrumentusBlocks.CUT_SOULCOPPER, "Cut Soulcopper");
        addBlock(InstrumentusBlocks.SOULCOPPER_GRATE, "Soulcopper Grate");
        addBlock(InstrumentusBlocks.SOULCOPPER_TRAPDOOR, "Soulcopper Trapdoor");
        addBlock(InstrumentusBlocks.SOULCOPPER_DOOR, "Soulcopper Door");
        addBlock(InstrumentusBlocks.CUT_SOULCOPPER_STAIRS, "Cut Soulcopper Stairs");
        addBlock(InstrumentusBlocks.CUT_SOULCOPPER_SLAB, "Cut Soulcopper Slab");
        addBlock(InstrumentusBlocks.CHISELED_SOULCOPPER, "Chiseled Soulcopper");
        addBlock(InstrumentusBlocks.SOULCOPPER_BULB, "Soulcopper Bulb");

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

        addItem(InstrumentusItems.BREEZE_ARMOR_BOOTS, "Breeze Boots");

        addBlock(InstrumentusBlocks.KILN, "Kiln");
        add(Instrumentus.MODID + ".container.kiln", "Kiln");

        addBlock(InstrumentusBlocks.WIND_BLOWER, "Wind Blower");
        add(Instrumentus.MODID + ".tooltip.bound_wind_blower", "Bound Wind Blower: %s");

        add(Instrumentus.MODID + ".lore.no_energy", "No Energy");
        add(Instrumentus.MODID + ".lore.energy", "%d FE/%d FE");
        add(Instrumentus.MODID + ".tooltip.energy", "");
        add(Instrumentus.MODID + ".coppersoulcampfirecookingrecipe.title", "Copper-fueled Soul Campfire Cooking");

        add(Instrumentus.MODID + ".creativetab", "Instrumentus");

        add(Instrumentus.MODID + ".ponder.paxel_mining.header", "Paxel Mining");
        add(Instrumentus.MODID + ".ponder.paxel_mining.text_1", "Paxels can be used to mine Shovel Blocks...");
        add(Instrumentus.MODID + ".ponder.paxel_mining.text_2", "Pickaxe Blocks...");
        add(Instrumentus.MODID + ".ponder.paxel_mining.text_3", "and Axe Blocks!");

        add(Instrumentus.MODID + ".ponder.paxel_stripping_pathing.header", "Paxel Stripping and Pathing");
        add(Instrumentus.MODID + ".ponder.paxel_stripping_pathing.text_1", "Paxels can also perform the secondary actions that Axes and Shovels do.");

        add(Instrumentus.MODID + ".ponder.sickle_mining.header", "Sickle Mining");
        add(Instrumentus.MODID + ".ponder.sickle_mining.text_1", "Sickles can be used to harvest large areas of leaves and vegetation in a large area.");

        add(Instrumentus.MODID + ".ponder.sickle_mining_upgraded.header", "Better Sickle Mining");
        add(Instrumentus.MODID + ".ponder.sickle_mining_upgraded.text_1", "Better Sickles have a larger area of effect.");

        add(Instrumentus.MODID + ".ponder.sickle_vegetation_harvesting.header", "Sickle Harvesting");
        add(Instrumentus.MODID + ".ponder.sickle_vegetation_harvesting.text_1", "Sickles can also be used to harvest vegetation in an area.");
        add(Instrumentus.MODID + ".ponder.sickle_vegetation_harvesting.text_2", "Sickles will only harvest fully grown crops.");

        add(Instrumentus.MODID + ".ponder.wind_blower.header", "Wind Blower");
        add(Instrumentus.MODID + ".ponder.wind_blower.text_1", "This is a Wind Blower, designed to prevent Phantoms from spawning.");
        add(Instrumentus.MODID + ".ponder.wind_blower.text_2", "When right clicked, the Wind Blower will be bound to the player.");
        add(Instrumentus.MODID + ".ponder.wind_blower.text_3", "When right clicked with a Breeze Rod, the Wind Blower will gain one charge. It can hold up to 4 charges.");
        add(Instrumentus.MODID + ".ponder.wind_blower.text_4", "When Phantoms attempt to spawn on a player, if they have a charged Wind Blower Bound, they will be prevented from spawning.");

        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.header", "Charging Energized Tools");
        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.text_1", "Energized Tools can be charged using any modded Forge Energy Charger.");
        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.text_2", "When an Energized Tool is struck by Lightning, it will be fully charged!");
        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.text_3", "0 FE/20,000 FE");
        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.text_4", "20,000 FE/20,000 FE");
        add(Instrumentus.MODID + ".ponder.energized_lightning_rod.text_5", "Lightning can be induced using an Energized Di-Emerald Lightning Rod on a Lightning Rod Block. This consumes FE from the Tool.");

        add(Instrumentus.MODID + ".ponder.soulcopper_smelting.header", "Smelting Raw Copper into Raw Soulcopper");
        add(Instrumentus.MODID + ".ponder.soulcopper_smelting.text_1", "Raw Copper can be smelted into Raw Soulcopper using a Copper-Fueled Soul Campfire.");
        add(Instrumentus.MODID + ".ponder.soulcopper_smelting.text_2", "To get Raw Soulcopper, you can use a Copper-Fueled Soul Campfire to smelt Raw Copper Blocks.");
        add(Instrumentus.MODID + ".ponder.soulcopper_smelting.text_3", "After a short while, Raw Soulcopper will be produced.");
        add(Instrumentus.MODID + ".ponder.soulcopper_smelting.text_4", "This Raw Soulcopper can be used to craft a few different things, or be smelted into Soulcopper Ingots in a Blast Furnace.");

        add(Instrumentus.MODID + ".tooltip.press_shift", "Press [SHIFT] for more information");

        add(Instrumentus.MODID + ".tooltip.shears_1", "Can be used for shearing sheep,");
        add(Instrumentus.MODID + ".tooltip.shears_2", "harvesting plants, and breaking cobwebs.");

        add(Instrumentus.MODID + ".tooltip.hammer_1", "3x3 Area Pickaxe");

        add(Instrumentus.MODID + ".tooltip.excavator_1", "3x3 Area Shovel");

        add(Instrumentus.MODID + ".tooltip.knife_1", "Destroying tall grass drops plant fiber");
        add(Instrumentus.MODID + ".tooltip.knife_2", "which can be crafted into string");

        add(Instrumentus.MODID + ".tooltip.wind_boots_1", "Jump again while in the air");
        add(Instrumentus.MODID + ".tooltip.wind_boots_2", "to double jump!");

        add(Instrumentus.MODID + ".tooltip.kiln_1", "Smelts building materials with the");
        add(Instrumentus.MODID + ".tooltip.kiln_2", "same efficiency as a blast furnace.");

        add(Instrumentus.MODID + ".tooltip.soulcopper_pickaxe_1", "Right click to spend one durability");
        add(Instrumentus.MODID + ".tooltip.soulcopper_pickaxe_2", "and place a light source");

        add(Instrumentus.MODID + ".tooltip.soulcopper_burner_1", "Use on any copper block");
        add(Instrumentus.MODID + ".tooltip.soulcopper_burner_2", "to quickly oxidize it.");

        add(Instrumentus.MODID + ".tooltip.brush_1", "A brush with a durability");
        add(Instrumentus.MODID + ".tooltip.brush_2", "matching it's material.");
    }
}
