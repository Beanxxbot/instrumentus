package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.helper.InstrumentusItemHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.beanbot.instrumentus.common.helper.InstrumentusItemHelper.*;

public class InstrumentusItems {

    @SuppressWarnings("unused")
    public static final Item.Properties ITEM_CATEGORY = new Item.Properties();
    public static final DeferredRegister.Items ITEMS_REGISTRAR = DeferredRegister.createItems(Instrumentus.MODID);

    //Shears
//    public static final DeferredHolder<Item, InstrumentusShearsItem> WOODEN_SHEARS = ITEMS_REGISTRAR.register("wooden_shears", () -> new InstrumentusShearsItem(ToolMaterial.WOOD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> WOODEN_SHEARS = ITEMS_REGISTRAR
        .registerItem("wooden_shears", InstrumentusShearsItem::new, generateShearsItemProperties(ToolMaterial.WOOD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> STONE_SHEARS = ITEMS_REGISTRAR
        .registerItem("stone_shears", InstrumentusShearsItem::new, generateShearsItemProperties(ToolMaterial.STONE));
    public static final DeferredHolder<Item, InstrumentusShearsItem> GOLDEN_SHEARS = ITEMS_REGISTRAR
        .registerItem("golden_shears", InstrumentusShearsItem::new, generateShearsItemProperties(ToolMaterial.GOLD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> DIAMOND_SHEARS = ITEMS_REGISTRAR
        .registerItem("diamond_shears", InstrumentusShearsItem::new, generateShearsItemProperties(ToolMaterial.DIAMOND));
    public static final DeferredHolder<Item, InstrumentusShearsItem> NETHERITE_SHEARS = ITEMS_REGISTRAR
        .registerItem("netherite_shears", InstrumentusShearsItem::new, generateShearsItemProperties(ToolMaterial.NETHERITE));

    //Sickles
    public static final DeferredHolder<Item, SickleItem> WOODEN_SICKLE = ITEMS_REGISTRAR
        .registerItem("wooden_sickle", properties -> new SickleItem(ToolMaterial.WOOD, properties), generateToolItemProperties(ToolMaterial.WOOD, 0, -1.9f));
    public static final DeferredHolder<Item, SickleItem> STONE_SICKLE = ITEMS_REGISTRAR
        .registerItem("stone_sickle", properties -> new SickleItem(ToolMaterial.STONE, properties), generateToolItemProperties(ToolMaterial.STONE, 0, -1.9f));
    public static final DeferredHolder<Item, SickleItem> IRON_SICKLE = ITEMS_REGISTRAR
        .registerItem("iron_sickle", properties -> new SickleItem(ToolMaterial.IRON, properties), generateToolItemProperties(ToolMaterial.IRON, 0, -1.9f));
    public static final DeferredHolder<Item, SickleItem> GOLDEN_SICKLE = ITEMS_REGISTRAR
        .registerItem("golden_sickle", properties -> new SickleItem(ToolMaterial.GOLD, properties), generateToolItemProperties(ToolMaterial.GOLD, 0, -1.9f));
    public static final DeferredHolder<Item, SickleItem> DIAMOND_SICKLE = ITEMS_REGISTRAR
        .registerItem("diamond_sickle", properties -> new SickleItem(ToolMaterial.DIAMOND, properties), generateToolItemProperties(ToolMaterial.DIAMOND, 0, -1.9f));
    public static final DeferredHolder<Item, SickleItem> NETHERITE_SICKLE = ITEMS_REGISTRAR
        .registerItem("netherite_sickle", properties -> new SickleItem(ToolMaterial.NETHERITE, properties), generateToolItemProperties(ToolMaterial.NETHERITE, 0, -1.9f));

    //Paxels
    public static final DeferredHolder<Item, PaxelItem> WOODEN_PAXEL = ITEMS_REGISTRAR
        .registerItem("wooden_paxel", properties -> new PaxelItem(ToolMaterial.WOOD, 6.0f, -3.2f, properties), generateToolItemProperties(ToolMaterial.WOOD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> STONE_PAXEL = ITEMS_REGISTRAR
        .registerItem("stone_paxel", properties -> new PaxelItem(ToolMaterial.STONE, 7.0f, -3.2f, properties), generateToolItemProperties(ToolMaterial.STONE, 7.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> IRON_PAXEL = ITEMS_REGISTRAR
        .registerItem("iron_paxel", properties -> new PaxelItem(ToolMaterial.IRON, 6.0f, -3.2f, properties), generateToolItemProperties(ToolMaterial.IRON, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> GOLDEN_PAXEL = ITEMS_REGISTRAR
        .registerItem("golden_paxel", properties -> new PaxelItem(ToolMaterial.GOLD, 6.0f, -3.2f, properties), generateToolItemProperties(ToolMaterial.GOLD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> DIAMOND_PAXEL = ITEMS_REGISTRAR
        .registerItem("diamond_paxel", properties -> new PaxelItem(ToolMaterial.DIAMOND, 5.0f, -3.0f, properties), generateToolItemProperties(ToolMaterial.DIAMOND, 5.0f, -3.0f));
    public static final DeferredHolder<Item, PaxelItem> NETHERITE_PAXEL = ITEMS_REGISTRAR
        .registerItem("netherite_paxel", properties -> new PaxelItem(ToolMaterial.NETHERITE, 5.0f, -3.0f, properties), generateToolItemProperties(ToolMaterial.NETHERITE, 5.0f, -3.0f));

    //Hammers
    public static final DeferredHolder<Item, HammerItem> WOODEN_HAMMER = ITEMS_REGISTRAR
        .registerItem("wooden_hammer", properties -> new HammerItem(ToolMaterial.WOOD, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> STONE_HAMMER = ITEMS_REGISTRAR
        .registerItem("stone_hammer", properties -> new HammerItem(ToolMaterial.STONE, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> IRON_HAMMER = ITEMS_REGISTRAR
        .registerItem("iron_hammer", properties -> new HammerItem(ToolMaterial.IRON, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> GOLDEN_HAMMER = ITEMS_REGISTRAR
        .registerItem("golden_hammer", properties -> new HammerItem(ToolMaterial.GOLD, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> DIAMOND_HAMMER = ITEMS_REGISTRAR
        .registerItem("diamond_hammer", properties -> new HammerItem(ToolMaterial.DIAMOND, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> NETHERITE_HAMMER = ITEMS_REGISTRAR
        .registerItem("netherite_hammer", properties -> new HammerItem(ToolMaterial.NETHERITE, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.NETHERITE, 1, -3.0f));

    //Energized
    public static final DeferredHolder<Item, EnergyPickaxeItem> ENERGIZED_PICKAXE = ITEMS_REGISTRAR
        .registerItem("energy_pickaxe", properties -> new EnergyPickaxeItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyShovelItem> ENERGIZED_SHOVEL = ITEMS_REGISTRAR
        .registerItem("energy_shovel", properties -> new EnergyShovelItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyAxeItem> ENERGIZED_AXE = ITEMS_REGISTRAR
        .registerItem("energy_axe", properties -> new EnergyAxeItem(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyHoeItem> ENERGIZED_HOE = ITEMS_REGISTRAR
        .registerItem("energy_hoe", properties -> new EnergyHoeItem(InstrumentusToolMaterials.ENERGIZED, 1.0f, -2.8f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyPaxelItem> ENERGIZED_PAXEL = ITEMS_REGISTRAR
        .registerItem("energy_paxel", properties -> new EnergyPaxelItem(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyHammerItem> ENERGIZED_HAMMER = ITEMS_REGISTRAR
        .registerItem("energy_hammer", properties -> new EnergyHammerItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergySickleItem> ENERGIZED_SICKLE = ITEMS_REGISTRAR
        .registerItem("energy_sickle", properties -> new EnergySickleItem(InstrumentusToolMaterials.ENERGIZED, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyShearsItem> ENERGIZED_SHEARS = ITEMS_REGISTRAR
        .registerItem("energy_shears", EnergyShearsItem::new, InstrumentusItemHelper.generateShearsItemProperties(InstrumentusToolMaterials.ENERGIZED));
    public static final DeferredHolder<Item, EnergyKnifeItem> ENERGIZED_KNIFE = ITEMS_REGISTRAR
        .registerItem("energy_knife", EnergyKnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(InstrumentusToolMaterials.ENERGIZED, 1, -2.0f));
    public static final DeferredHolder<Item, Item> ENERGIZED_INGOT = ITEMS_REGISTRAR
        .registerSimpleItem("energy_ingot");
    public static final DeferredHolder<Item, BlockItem> ENERGIZED_BLOCK = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.ENERGIZED_BLOCK);
    public static final DeferredHolder<Item, Item> CARBON_ROD = ITEMS_REGISTRAR
        .registerSimpleItem("carbon_rod");
    public static final DeferredHolder<Item, EnergyLightningRodItem> ENERGIZED_LIGHTNING_ROD = ITEMS_REGISTRAR
        .registerItem("energy_lightning_rod", EnergyLightningRodItem::new, new Item.Properties().stacksTo(1).fireResistant());
    public static final DeferredHolder<Item, EnergyExcavatorItem> ENERGIZED_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("energy_excavator", properties -> new EnergyExcavatorItem(InstrumentusToolMaterials.ENERGIZED, 1, -3.0f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.ENERGIZED, 1, -3.0f));

    //Soulcopper
    public static final DeferredHolder<Item, SoulcopperPickaxeItem> SOULCOPPER_PICKAXE = ITEMS_REGISTRAR
        .registerItem("soulcopper_pickaxe", properties -> new SoulcopperPickaxeItem(ToolMaterial.DIAMOND, 1, -2.8f, properties), generateToolItemProperties(ToolMaterial.DIAMOND, 1, -2.8f));
    public static final DeferredHolder<Item, Item> SOULCOPPER_INGOT = ITEMS_REGISTRAR
        .registerSimpleItem("soulcopper_ingot");
    public static final DeferredHolder<Item, Item> RAW_SOULCOPPER = ITEMS_REGISTRAR
        .registerSimpleItem("raw_soulcopper");
    public static final DeferredHolder<Item, BlockItem> RAW_SOULCOPPER_BLOCK = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BLOCK = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_BLOCK);
    public static final DeferredHolder<Item, BurnerItem> SOULCOPPER_BURNER = ITEMS_REGISTRAR
        .registerItem("soulcopper_burner", BurnerItem::new, new Item.Properties().stacksTo(1).durability(300));
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.CUT_SOULCOPPER);
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_GRATE_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_GRATE);
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_DOOR_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_DOOR);
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_TRAPDOOR_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_TRAPDOOR);
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_STAIRS_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.CUT_SOULCOPPER_STAIRS);
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_SLAB_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.CUT_SOULCOPPER_SLAB);
    public static final DeferredHolder<Item, BlockItem> CHISELED_SOULCOPPER_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.CHISELED_SOULCOPPER);
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BULB_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_BULB);
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_CAMPFIRE_BLOCK_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, StandingAndWallBlockItem> SOULCOPPER_TORCH_ITEM = ITEMS_REGISTRAR
        .registerItem("copper_soul_torch", properties -> new StandingAndWallBlockItem(InstrumentusBlocks.SOULCOPPER_TORCH.get(), InstrumentusBlocks.SOULCOPPER_WALL_TORCH.get(), Direction.DOWN, properties), new Item.Properties().stacksTo(64).useBlockDescriptionPrefix());
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_LANTERN_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.SOULCOPPER_LANTERN);

    //Knives
    public static final DeferredHolder<Item, KnifeItem> WOODEN_KNIFE = ITEMS_REGISTRAR
        .registerItem("wooden_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.WOOD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> STONE_KNIFE = ITEMS_REGISTRAR
        .registerItem("stone_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.STONE, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> IRON_KNIFE = ITEMS_REGISTRAR
        .registerItem("iron_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.IRON, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> GOLDEN_KNIFE = ITEMS_REGISTRAR
        .registerItem("golden_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.GOLD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> DIAMOND_KNIFE = ITEMS_REGISTRAR
        .registerItem("diamond_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.DIAMOND, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> NETHERITE_KNIFE = ITEMS_REGISTRAR
        .registerItem("netherite_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(ToolMaterial.NETHERITE, 1, -2.0f));
    public static final DeferredHolder<Item, Item> PLANT_FIBER = ITEMS_REGISTRAR
        .registerSimpleItem("plant_fiber");

    //Copper Tools
    public static final DeferredHolder<Item, PickaxeItem> COPPER_PICKAXE = ITEMS_REGISTRAR
        .registerItem("copper_pickaxe", properties -> new PickaxeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties));
    public static final DeferredHolder<Item, ShovelItem> COPPER_SHOVEL = ITEMS_REGISTRAR
        .registerItem("copper_shovel", properties -> new ShovelItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties));
    public static final DeferredHolder<Item, AxeItem> COPPER_AXE = ITEMS_REGISTRAR
        .registerItem("copper_axe", properties -> new AxeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties));
    public static final DeferredHolder<Item, HoeItem> COPPER_HOE = ITEMS_REGISTRAR
        .registerItem("copper_hoe", properties -> new HoeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties));
    public static final DeferredHolder<Item, SwordItem> COPPER_SWORD = ITEMS_REGISTRAR
        .registerItem("copper_sword", properties -> new SwordItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties));
    public static final DeferredHolder<Item, PaxelItem> COPPER_PAXEL = ITEMS_REGISTRAR
        .registerItem("copper_paxel", properties -> new PaxelItem(InstrumentusToolMaterials.COPPER, 6.0f, -3.0f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.COPPER, 6.0f, -3.0f));
    public static final DeferredHolder<Item, HammerItem> COPPER_HAMMER = ITEMS_REGISTRAR
        .registerItem("copper_hammer", properties -> new HammerItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.COPPER, 1, -3.0f));
    public static final DeferredHolder<Item, SickleItem> COPPER_SICKLE = ITEMS_REGISTRAR
        .registerItem("copper_sickle", properties -> new SickleItem(InstrumentusToolMaterials.COPPER, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.COPPER, 0, -1.9f));
    public static final DeferredHolder<Item, InstrumentusShearsItem> COPPER_SHEARS = ITEMS_REGISTRAR
        .registerItem("copper_shears", InstrumentusShearsItem::new, generateShearsItemProperties(InstrumentusToolMaterials.COPPER));
    public static final DeferredHolder<Item, KnifeItem> COPPER_KNIFE = ITEMS_REGISTRAR
        .registerItem("copper_knife", KnifeItem::new, InstrumentusItemHelper.generateKnifeItemProperties(InstrumentusToolMaterials.COPPER, 1, -2.0f));
    public static final DeferredHolder<Item, ExcavatorItem> COPPER_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("copper_excavator", properties -> new ExcavatorItem(InstrumentusToolMaterials.COPPER, 1, -3.0f, properties), InstrumentusItemHelper.generateToolItemProperties(InstrumentusToolMaterials.COPPER, 1, -3.0f));

    //Brushes
    public static final DeferredHolder<Item, InstrumentusBrushItem> WOODEN_BRUSH = ITEMS_REGISTRAR
        .registerItem("wooden_brush", properties -> new InstrumentusBrushItem(ToolMaterial.WOOD, properties));
    public static final DeferredHolder<Item, InstrumentusBrushItem> STONE_BRUSH = ITEMS_REGISTRAR
        .registerItem("stone_brush", properties -> new InstrumentusBrushItem(ToolMaterial.STONE, properties));
    public static final DeferredHolder<Item, InstrumentusBrushItem> IRON_BRUSH = ITEMS_REGISTRAR
        .registerItem("iron_brush", properties -> new InstrumentusBrushItem(ToolMaterial.IRON, properties));
    public static final DeferredHolder<Item, InstrumentusBrushItem> GOLDEN_BRUSH = ITEMS_REGISTRAR
        .registerItem("golden_brush", properties -> new InstrumentusBrushItem(ToolMaterial.GOLD, properties));
    public static final DeferredHolder<Item, InstrumentusBrushItem> DIAMOND_BRUSH = ITEMS_REGISTRAR
        .registerItem("diamond_brush", properties -> new InstrumentusBrushItem(ToolMaterial.DIAMOND, properties));
    public static final DeferredHolder<Item, InstrumentusBrushItem> NETHERITE_BRUSH = ITEMS_REGISTRAR
        .registerItem("netherite_brush", properties -> new InstrumentusBrushItem(ToolMaterial.NETHERITE, properties));
    public static final DeferredHolder<Item, EnergyBrushItem> ENERGIZED_BRUSH = ITEMS_REGISTRAR
        .registerItem("energy_brush", EnergyBrushItem::new, new Item.Properties().durability(0).stacksTo(1).fireResistant());

    //Excavators
    public static final DeferredHolder<Item, ExcavatorItem> WOODEN_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("wooden_excavator", properties -> new ExcavatorItem(ToolMaterial.WOOD, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> STONE_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("stone_excavator", properties -> new ExcavatorItem(ToolMaterial.STONE, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> IRON_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("iron_excavator", properties -> new ExcavatorItem(ToolMaterial.IRON, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> GOLDEN_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("golden_excavator", properties -> new ExcavatorItem(ToolMaterial.GOLD, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> DIAMOND_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("diamond_excavator", properties -> new ExcavatorItem(ToolMaterial.DIAMOND, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> NETHERITE_EXCAVATOR = ITEMS_REGISTRAR
        .registerItem("netherite_excavator", properties -> new ExcavatorItem(ToolMaterial.NETHERITE, 1, -3.0f, properties), generateToolItemProperties(ToolMaterial.NETHERITE, 1, -3.0f));

    //Kiln
    public static final DeferredHolder<Item, BlockItem> KILN_BLOCK_ITEM = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.KILN);

    //Trial Tools
    public static final DeferredHolder<Item, BreezeArmorItem> BREEZE_ARMOR_BOOTS = ITEMS_REGISTRAR
        .registerItem("breeze_boots", properties -> new BreezeArmorItem(ArmorType.BOOTS, properties), new Item.Properties().durability(ArmorType.BOOTS.getDurability(33)));
    public static final DeferredHolder<Item, BlockItem> WIND_BLOWER = ITEMS_REGISTRAR
        .registerSimpleBlockItem(InstrumentusBlocks.WIND_BLOWER);

}
