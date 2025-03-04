package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InstrumentusItems {

    @SuppressWarnings("unused")
    public static final Item.Properties ITEM_CATEGORY = new Item.Properties();
    public static final DeferredRegister.Items ITEMS_REGISTRAR = DeferredRegister.createItems(Instrumentus.MODID);

    //Shears
    public static final DeferredHolder<Item, InstrumentusShearsItem> WOODEN_SHEARS = ITEMS_REGISTRAR.register("wooden_shears", () -> new InstrumentusShearsItem(Tiers.WOOD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> STONE_SHEARS = ITEMS_REGISTRAR.register("stone_shears", () -> new InstrumentusShearsItem(Tiers.STONE));
    public static final DeferredHolder<Item, InstrumentusShearsItem> GOLDEN_SHEARS = ITEMS_REGISTRAR.register("golden_shears", () -> new InstrumentusShearsItem(Tiers.GOLD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> DIAMOND_SHEARS = ITEMS_REGISTRAR.register("diamond_shears", () -> new InstrumentusShearsItem(Tiers.DIAMOND));
    public static final DeferredHolder<Item, InstrumentusShearsItem> NETHERITE_SHEARS = ITEMS_REGISTRAR.register("netherite_shears", () -> new InstrumentusShearsItem(Tiers.NETHERITE));

    //Sickles
    public static final DeferredHolder<Item, SickleItem> WOODEN_SICKLE = ITEMS_REGISTRAR.register("wooden_sickle", () -> new SickleItem(Tiers.WOOD));
    public static final DeferredHolder<Item, SickleItem> STONE_SICKLE = ITEMS_REGISTRAR.register("stone_sickle", () -> new SickleItem(Tiers.STONE));
    public static final DeferredHolder<Item, SickleItem> IRON_SICKLE = ITEMS_REGISTRAR.register("iron_sickle", () -> new SickleItem(Tiers.IRON));
    public static final DeferredHolder<Item, SickleItem> GOLDEN_SICKLE = ITEMS_REGISTRAR.register("golden_sickle", () -> new SickleItem(Tiers.GOLD));
    public static final DeferredHolder<Item, SickleItem> DIAMOND_SICKLE = ITEMS_REGISTRAR.register("diamond_sickle", () -> new SickleItem(Tiers.DIAMOND));
    public static final DeferredHolder<Item, SickleItem> NETHERITE_SICKLE = ITEMS_REGISTRAR.register("netherite_sickle", () -> new SickleItem(Tiers.NETHERITE));

    //Paxels
    public static final DeferredHolder<Item, PaxelItem> WOODEN_PAXEL = ITEMS_REGISTRAR.register("wooden_paxel", () -> new PaxelItem(Tiers.WOOD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> STONE_PAXEL = ITEMS_REGISTRAR.register("stone_paxel", () -> new PaxelItem(Tiers.STONE, 7.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> IRON_PAXEL = ITEMS_REGISTRAR.register("iron_paxel", () -> new PaxelItem(Tiers.IRON, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> GOLDEN_PAXEL = ITEMS_REGISTRAR.register("golden_paxel", () -> new PaxelItem(Tiers.GOLD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> DIAMOND_PAXEL = ITEMS_REGISTRAR.register("diamond_paxel", () -> new PaxelItem(Tiers.DIAMOND, 5.0f, -3.0f));
    public static final DeferredHolder<Item, PaxelItem> NETHERITE_PAXEL = ITEMS_REGISTRAR.register("netherite_paxel", () -> new PaxelItem(Tiers.NETHERITE, 5.0f, -3.0f));

    //Hammers
    public static final DeferredHolder<Item, HammerItem> WOODEN_HAMMER = ITEMS_REGISTRAR.register("wooden_hammer", ()-> new HammerItem(Tiers.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> STONE_HAMMER = ITEMS_REGISTRAR.register("stone_hammer", ()-> new HammerItem(Tiers.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> IRON_HAMMER = ITEMS_REGISTRAR.register("iron_hammer", ()-> new HammerItem(Tiers.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> GOLDEN_HAMMER = ITEMS_REGISTRAR.register("golden_hammer", ()-> new HammerItem(Tiers.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> DIAMOND_HAMMER = ITEMS_REGISTRAR.register("diamond_hammer", ()-> new HammerItem(Tiers.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> NETHERITE_HAMMER = ITEMS_REGISTRAR.register("netherite_hammer", ()-> new HammerItem(Tiers.NETHERITE, 1, -3.0f));

    //Energized
    public static final DeferredHolder<Item, EnergyPickaxeItem> ENERGIZED_PICKAXE = ITEMS_REGISTRAR.register("energy_pickaxe", () -> new EnergyPickaxeItem(InstrumentusItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyShovelItem> ENERGIZED_SHOVEL = ITEMS_REGISTRAR.register("energy_shovel", () -> new EnergyShovelItem(InstrumentusItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyAxeItem> ENERGIZED_AXE = ITEMS_REGISTRAR.register("energy_axe", () -> new EnergyAxeItem(InstrumentusItemTiers.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyHoeItem> ENERGIZED_HOE = ITEMS_REGISTRAR.register("energy_hoe", () -> new EnergyHoeItem(InstrumentusItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyPaxelItem> ENERGIZED_PAXEL = ITEMS_REGISTRAR.register("energy_paxel", () -> new EnergyPaxelItem(InstrumentusItemTiers.ENERGIZED, 5.0f, -3.0f));
    public static final DeferredHolder<Item, EnergyHammerItem> ENERGIZED_HAMMER = ITEMS_REGISTRAR.register("energy_hammer", () -> new EnergyHammerItem(InstrumentusItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergySickleItem> ENERGIZED_SICKLE = ITEMS_REGISTRAR.register("energy_sickle", () -> new EnergySickleItem(InstrumentusItemTiers.ENERGIZED));
    public static final DeferredHolder<Item, EnergyShearsItem> ENERGIZED_SHEARS = ITEMS_REGISTRAR.register("energy_shears", () -> new EnergyShearsItem(InstrumentusItemTiers.ENERGIZED));
    public static final DeferredHolder<Item, EnergyKnifeItem> ENERGIZED_KNIFE = ITEMS_REGISTRAR.register("energy_knife", () -> new EnergyKnifeItem(InstrumentusItemTiers.ENERGIZED, 1, -2.0f));
    public static final DeferredHolder<Item, Item> ENERGIZED_INGOT = ITEMS_REGISTRAR.register("energy_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ENERGIZED_BLOCK = ITEMS_REGISTRAR.register("energy_block", () -> new BlockItem(InstrumentusBlocks.ENERGIZED_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, Item> CARBON_ROD = ITEMS_REGISTRAR.register("carbon_rod", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, EnergyLightningRodItem> ENERGIZED_LIGHTNING_ROD = ITEMS_REGISTRAR.register("energy_lightning_rod", () -> new EnergyLightningRodItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, EnergyExcavatorItem> ENERGIZED_EXCAVATOR = ITEMS_REGISTRAR.register("energy_excavator", () -> new EnergyExcavatorItem(InstrumentusItemTiers.ENERGIZED, 1, -3.0f));

    //Soulcopper
    public static final DeferredHolder<Item, SoulcopperPickaxeItem> SOULCOPPER_PICKAXE = ITEMS_REGISTRAR.register("soulcopper_pickaxe", () -> new SoulcopperPickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final DeferredHolder<Item, Item> SOULCOPPER_INGOT = ITEMS_REGISTRAR.register("soulcopper_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_SOULCOPPER = ITEMS_REGISTRAR.register("raw_soulcopper", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RAW_SOULCOPPER_BLOCK = ITEMS_REGISTRAR.register("raw_soulcopper_block", () -> new BlockItem(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BLOCK = ITEMS_REGISTRAR.register("soulcopper_block", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BurnerItem> SOULCOPPER_BURNER = ITEMS_REGISTRAR.register("soulcopper_burner", BurnerItem::new);
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_ITEM = ITEMS_REGISTRAR.register("cut_soulcopper", () -> new BlockItem(InstrumentusBlocks.CUT_SOULCOPPER.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_GRATE_ITEM = ITEMS_REGISTRAR.register("soulcopper_grate", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_GRATE.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_DOOR_ITEM = ITEMS_REGISTRAR.register("soulcopper_door", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_DOOR.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_TRAPDOOR_ITEM = ITEMS_REGISTRAR.register("soulcopper_trapdoor", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_TRAPDOOR.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_STAIRS_ITEM = ITEMS_REGISTRAR.register("cut_soulcopper_stairs", () -> new BlockItem(InstrumentusBlocks.CUT_SOULCOPPER_STAIRS.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_SLAB_ITEM = ITEMS_REGISTRAR.register("cut_soulcopper_slab", () -> new BlockItem(InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> CHISELED_SOULCOPPER_ITEM = ITEMS_REGISTRAR.register("chiseled_soulcopper", () -> new BlockItem(InstrumentusBlocks.CHISELED_SOULCOPPER.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BULB_ITEM = ITEMS_REGISTRAR.register("soulcopper_bulb", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_BULB.get(), new Item.Properties().stacksTo(64)));
    @SuppressWarnings("unused")
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_FLAME_LIGHT_ITEM = ITEMS_REGISTRAR.register("copper_soul_fire_flame", () -> new BlockItem(InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_CAMPFIRE_BLOCK_ITEM = ITEMS_REGISTRAR.register("copper_soul_campfire", () -> new BlockItem(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, StandingAndWallBlockItem> SOULCOPPER_TORCH_ITEM = ITEMS_REGISTRAR.register("copper_soul_torch", () -> new StandingAndWallBlockItem(InstrumentusBlocks.SOULCOPPER_TORCH.get(), InstrumentusBlocks.SOULCOPPER_WALL_TORCH.get(), (new Item.Properties()).stacksTo(64), Direction.DOWN));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_LANTERN_ITEM = ITEMS_REGISTRAR.register("copper_soul_lantern", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_LANTERN.get(), new Item.Properties().stacksTo(64)));

    //Knives
    public static final DeferredHolder<Item, KnifeItem> WOODEN_KNIFE = ITEMS_REGISTRAR.register("wooden_knife", () -> new KnifeItem(Tiers.WOOD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> STONE_KNIFE = ITEMS_REGISTRAR.register("stone_knife", () -> new KnifeItem(Tiers.STONE, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> IRON_KNIFE = ITEMS_REGISTRAR.register("iron_knife", () -> new KnifeItem(Tiers.IRON, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> GOLDEN_KNIFE = ITEMS_REGISTRAR.register("golden_knife", () -> new KnifeItem(Tiers.GOLD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> DIAMOND_KNIFE = ITEMS_REGISTRAR.register("diamond_knife", () -> new KnifeItem(Tiers.DIAMOND, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> NETHERITE_KNIFE = ITEMS_REGISTRAR.register("netherite_knife", () -> new KnifeItem(Tiers.NETHERITE, 1, -2.0f));
    public static final DeferredHolder<Item, Item> PLANT_FIBER = ITEMS_REGISTRAR.register("plant_fiber", () -> new Item(new Item.Properties()));

    //Copper Tools
    public static final DeferredHolder<Item, PickaxeItem> COPPER_PICKAXE = ITEMS_REGISTRAR.register("copper_pickaxe", () -> new PickaxeItem(InstrumentusItemTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(InstrumentusItemTiers.COPPER, 1, -2.8f ))));
    public static final DeferredHolder<Item, ShovelItem> COPPER_SHOVEL = ITEMS_REGISTRAR.register("copper_shovel", () -> new ShovelItem(InstrumentusItemTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(InstrumentusItemTiers.COPPER, 1, -2.8f))));
    public static final DeferredHolder<Item, AxeItem> COPPER_AXE = ITEMS_REGISTRAR.register("copper_axe", () -> new AxeItem(InstrumentusItemTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(InstrumentusItemTiers.COPPER, 6.0f, -3.0f))));
    public static final DeferredHolder<Item, HoeItem> COPPER_HOE = ITEMS_REGISTRAR.register("copper_hoe", () -> new HoeItem(InstrumentusItemTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(InstrumentusItemTiers.COPPER, 1, -2.8f))));
    public static final DeferredHolder<Item, SwordItem> COPPER_SWORD = ITEMS_REGISTRAR.register("copper_sword", () -> new SwordItem(InstrumentusItemTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(InstrumentusItemTiers.COPPER, 4, -2.4f))));
    public static final DeferredHolder<Item, PaxelItem> COPPER_PAXEL = ITEMS_REGISTRAR.register("copper_paxel", () -> new PaxelItem(InstrumentusItemTiers.COPPER, 6.0f, -3.0f));
    public static final DeferredHolder<Item, HammerItem> COPPER_HAMMER = ITEMS_REGISTRAR.register("copper_hammer", () -> new HammerItem(InstrumentusItemTiers.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, SickleItem> COPPER_SICKLE = ITEMS_REGISTRAR.register("copper_sickle", () -> new SickleItem(InstrumentusItemTiers.COPPER));
    public static final DeferredHolder<Item, InstrumentusShearsItem> COPPER_SHEARS = ITEMS_REGISTRAR.register("copper_shears", () -> new InstrumentusShearsItem(InstrumentusItemTiers.COPPER));
    public static final DeferredHolder<Item, KnifeItem> COPPER_KNIFE = ITEMS_REGISTRAR.register("copper_knife", () -> new KnifeItem(InstrumentusItemTiers.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, ExcavatorItem> COPPER_EXCAVATOR = ITEMS_REGISTRAR.register("copper_excavator", () -> new ExcavatorItem(InstrumentusItemTiers.COPPER, 1, -3.0f));

    //Brushes
    public static final DeferredHolder<Item, InstrumentusBrushItem> WOODEN_BRUSH = ITEMS_REGISTRAR.register("wooden_brush", () -> new InstrumentusBrushItem(Tiers.WOOD));
    public static final DeferredHolder<Item, InstrumentusBrushItem> STONE_BRUSH = ITEMS_REGISTRAR.register("stone_brush", () -> new InstrumentusBrushItem(Tiers.STONE));
    public static final DeferredHolder<Item, InstrumentusBrushItem> IRON_BRUSH = ITEMS_REGISTRAR.register("iron_brush", () -> new InstrumentusBrushItem(Tiers.IRON));
    public static final DeferredHolder<Item, InstrumentusBrushItem> GOLDEN_BRUSH = ITEMS_REGISTRAR.register("golden_brush", () -> new InstrumentusBrushItem(Tiers.GOLD));
    public static final DeferredHolder<Item, InstrumentusBrushItem> DIAMOND_BRUSH = ITEMS_REGISTRAR.register("diamond_brush", () -> new InstrumentusBrushItem(Tiers.DIAMOND));
    public static final DeferredHolder<Item, InstrumentusBrushItem> NETHERITE_BRUSH = ITEMS_REGISTRAR.register("netherite_brush", () -> new InstrumentusBrushItem(Tiers.NETHERITE));
    public static final DeferredHolder<Item, EnergyBrushItem> ENERGIZED_BRUSH = ITEMS_REGISTRAR.register("energy_brush", EnergyBrushItem::new);

    //Excavators
    public static final DeferredHolder<Item, ExcavatorItem> WOODEN_EXCAVATOR = ITEMS_REGISTRAR.register("wooden_excavator", () -> new ExcavatorItem(Tiers.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> STONE_EXCAVATOR = ITEMS_REGISTRAR.register("stone_excavator", () -> new ExcavatorItem(Tiers.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> IRON_EXCAVATOR = ITEMS_REGISTRAR.register("iron_excavator", () -> new ExcavatorItem(Tiers.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> GOLDEN_EXCAVATOR = ITEMS_REGISTRAR.register("golden_excavator", () -> new ExcavatorItem(Tiers.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> DIAMOND_EXCAVATOR = ITEMS_REGISTRAR.register("diamond_excavator", () -> new ExcavatorItem(Tiers.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> NETHERITE_EXCAVATOR = ITEMS_REGISTRAR.register("netherite_excavator", () -> new ExcavatorItem(Tiers.NETHERITE, 1, -3.0f));

    //Kiln
    public static final DeferredHolder<Item, KilnBlockItem> KILN_BLOCK_ITEM = ITEMS_REGISTRAR.register("kiln", () -> new KilnBlockItem(InstrumentusBlocks.KILN.get(), new Item.Properties().stacksTo(64)));

    //Trial Tools
    public static final DeferredHolder<Item, BreezeArmorItem> BREEZE_ARMOR_BOOTS = ITEMS_REGISTRAR.register("breeze_boots", () -> new BreezeArmorItem(ArmorItem.Type.BOOTS));
    public static final DeferredHolder<Item, BlockItem> WIND_BLOWER = ITEMS_REGISTRAR.registerSimpleBlockItem(InstrumentusBlocks.WIND_BLOWER);

}
