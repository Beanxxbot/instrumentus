package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class InstrumentusItems {

    @SuppressWarnings("unused")
    public static final Item.Properties ITEM_CATEGORY = new Item.Properties();
    public static final DeferredRegister.Items SHEARS = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items SICKLES = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items PAXELS = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items HAMMERS = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items ENERGIZED = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items KNIVES = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items SOULCOPPER = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items COPPER = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items BRUSHES = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items EXCAVATORS = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items FIRING = DeferredRegister.createItems(Instrumentus.MODID);
    public static final DeferredRegister.Items MISC = DeferredRegister.createItems(Instrumentus.MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Instrumentus.MODID);

    public static final DeferredItem<InstrumentusShearsItem> WOODEN_SHEARS = SHEARS.register("wooden_shears",
            () -> new InstrumentusShearsItem(ToolMaterial.WOOD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> STONE_SHEARS = SHEARS.register("stone_shears", () -> new InstrumentusShearsItem(ToolMaterial.STONE));
    public static final DeferredHolder<Item, InstrumentusShearsItem> GOLDEN_SHEARS = SHEARS.register("golden_shears", () -> new InstrumentusShearsItem(ToolMaterial.GOLD));
    public static final DeferredHolder<Item, InstrumentusShearsItem> DIAMOND_SHEARS = SHEARS.register("diamond_shears", () -> new InstrumentusShearsItem(ToolMaterial.DIAMOND));
    public static final DeferredHolder<Item, InstrumentusShearsItem> NETHERITE_SHEARS = SHEARS.register("netherite_shears", () -> new InstrumentusShearsItem(ToolMaterial.NETHERITE));

    public static final DeferredHolder<Item, SickleItem> WOODEN_SICKLE = SICKLES.register("wooden_sickle", () -> new SickleItem(ToolMaterial.WOOD));
    public static final DeferredHolder<Item, SickleItem> STONE_SICKLE = SICKLES.register("stone_sickle", () -> new SickleItem(ToolMaterial.STONE));
    public static final DeferredHolder<Item, SickleItem> IRON_SICKLE = SICKLES.register("iron_sickle", () -> new SickleItem(ToolMaterial.IRON));
    public static final DeferredHolder<Item, SickleItem> GOLDEN_SICKLE = SICKLES.register("golden_sickle", () -> new SickleItem(ToolMaterial.GOLD));
    public static final DeferredHolder<Item, SickleItem> DIAMOND_SICKLE = SICKLES.register("diamond_sickle", () -> new SickleItem(ToolMaterial.DIAMOND));
    public static final DeferredHolder<Item, SickleItem> NETHERITE_SICKLE = SICKLES.register("netherite_sickle", () -> new SickleItem(ToolMaterial.NETHERITE));

    public static final DeferredHolder<Item, PaxelItem> WOODEN_PAXEL = PAXELS.register("wooden_paxel", () -> new PaxelItem(ToolMaterial.WOOD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> STONE_PAXEL = PAXELS.register("stone_paxel", () -> new PaxelItem(ToolMaterial.STONE, 7.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> IRON_PAXEL = PAXELS.register("iron_paxel", () -> new PaxelItem(ToolMaterial.IRON, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> GOLDEN_PAXEL = PAXELS.register("golden_paxel", () -> new PaxelItem(ToolMaterial.GOLD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> DIAMOND_PAXEL = PAXELS.register("diamond_paxel", () -> new PaxelItem(ToolMaterial.DIAMOND, 5.0f, -3.0f));
    public static final DeferredHolder<Item, PaxelItem> NETHERITE_PAXEL = PAXELS.register("netherite_paxel", () -> new PaxelItem(ToolMaterial.NETHERITE, 5.0f, -3.0f));

    public static final DeferredHolder<Item, HammerItem> WOODEN_HAMMER = HAMMERS.register("wooden_hammer", () -> new HammerItem(ToolMaterial.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> STONE_HAMMER = HAMMERS.register("stone_hammer", () -> new HammerItem(ToolMaterial.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> IRON_HAMMER = HAMMERS.register("iron_hammer", () -> new HammerItem(ToolMaterial.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> GOLDEN_HAMMER = HAMMERS.register("golden_hammer", () -> new HammerItem(ToolMaterial.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> DIAMOND_HAMMER = HAMMERS.register("diamond_hammer", () -> new HammerItem(ToolMaterial.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> NETHERITE_HAMMER = HAMMERS.register("netherite_hammer", () -> new HammerItem(ToolMaterial.NETHERITE, 1, -3.0f));

    public static final DeferredHolder<Item, EnergyPickaxeItem> ENERGIZED_PICKAXE = ENERGIZED.register("energy_pickaxe", () -> new EnergyPickaxeItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyShovelItem> ENERGIZED_SHOVEL = ENERGIZED.register("energy_shovel", () -> new EnergyShovelItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyAxeItem> ENERGIZED_AXE = ENERGIZED.register("energy_axe", () -> new EnergyAxeItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyHoeItem> ENERGIZED_HOE = ENERGIZED.register("energy_hoe", () -> new EnergyHoeItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyPaxelItem> ENERGIZED_PAXEL = ENERGIZED.register("energy_paxel", () -> new EnergyPaxelItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyHammerItem> ENERGIZED_HAMMER = ENERGIZED.register("energy_hammer", () -> new EnergyHammerItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergySickleItem> ENERGIZED_SICKLE = ENERGIZED.register("energy_sickle", () -> new EnergySickleItem(InstrumentusToolMaterials.ENERGIZED));
    public static final DeferredHolder<Item, EnergyShearsItem> ENERGIZED_SHEARS = ENERGIZED.register("energy_shears", () -> new EnergyShearsItem(InstrumentusToolMaterials.ENERGIZED));
    public static final DeferredHolder<Item, EnergyKnifeItem> ENERGIZED_KNIFE = ENERGIZED.register("energy_knife", () -> new EnergyKnifeItem(InstrumentusToolMaterials.ENERGIZED, 1, -2.0f));
    public static final DeferredHolder<Item, Item> ENERGIZED_INGOT = ENERGIZED.register("energy_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ENERGIZED_BLOCK = ENERGIZED.register("energy_block", () -> new BlockItem(InstrumentusBlocks.ENERGIZED_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, Item> CARBON_ROD = ENERGIZED.register("carbon_rod", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, EnergyLightningRodItem> ENERGIZED_LIGHTNING_ROD = ENERGIZED.register("energy_lightning_rod", () -> new EnergyLightningRodItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, EnergyExcavatorItem> ENERGIZED_EXCAVATOR = ENERGIZED.register("energy_excavator", () -> new EnergyExcavatorItem(InstrumentusToolMaterials.ENERGIZED, 1, -3.0f));

    public static final DeferredHolder<Item, SoulcopperPickaxeItem> SOULCOPPER_PICKAXE = SOULCOPPER.register("soulcopper_pickaxe", () -> new SoulcopperPickaxeItem(ToolMaterial.DIAMOND, 1, -2.8f));
    public static final DeferredHolder<Item, Item> SOULCOPPER_INGOT = SOULCOPPER.register("soulcopper_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_SOULCOPPER = SOULCOPPER.register("raw_soulcopper", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RAW_SOULCOPPER_BLOCK = SOULCOPPER.register("raw_soulcopper_block", () -> new BlockItem(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BLOCK = SOULCOPPER.register("soulcopper_block", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BurnerItem> SOULCOPPER_BURNER = SOULCOPPER.register("soulcopper_burner", BurnerItem::new);
    public static final DeferredHolder<Item, BlockItem> CUT_SOULCOPPER_ITEM = SOULCOPPER.register("cut_soulcopper", () -> new BlockItem(InstrumentusBlocks.CUT_SOULCOPPER.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_GRATE_ITEM = SOULCOPPER.register("soulcopper_grate", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_GRATE.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_DOOR_ITEM = SOULCOPPER.register("soulcopper_door", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_DOOR.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_TRAPDOOR_ITEM = SOULCOPPER.register("soulcopper_trapdoor", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_TRAPDOOR.get(), new Item.Properties().stacksTo(64)));
    @SuppressWarnings("unused")
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_FLAME_LIGHT_ITEM = SOULCOPPER.register("copper_soul_fire_flame", () -> new BlockItem(InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_CAMPFIRE_BLOCK_ITEM = SOULCOPPER.register("copper_soul_campfire", () -> new BlockItem(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, StandingAndWallBlockItem> SOULCOPPER_TORCH_ITEM = SOULCOPPER.register("copper_soul_torch", () -> new StandingAndWallBlockItem(InstrumentusBlocks.SOULCOPPER_TORCH.get(), InstrumentusBlocks.SOULCOPPER_WALL_TORCH.get(), Direction.DOWN, new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_LANTERN_ITEM = SOULCOPPER.register("copper_soul_lantern", () -> new BlockItem(InstrumentusBlocks.SOULCOPPER_LANTERN.get(), new Item.Properties().stacksTo(64)));

    public static final DeferredHolder<Item, KnifeItem> WOODEN_KNIFE = KNIVES.register("wooden_knife", () -> new KnifeItem(ToolMaterial.WOOD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> STONE_KNIFE = KNIVES.register("stone_knife", () -> new KnifeItem(ToolMaterial.STONE, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> IRON_KNIFE = KNIVES.register("iron_knife", () -> new KnifeItem(ToolMaterial.IRON, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> GOLDEN_KNIFE = KNIVES.register("golden_knife", () -> new KnifeItem(ToolMaterial.GOLD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> DIAMOND_KNIFE = KNIVES.register("diamond_knife", () -> new KnifeItem(ToolMaterial.DIAMOND, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> NETHERITE_KNIFE = KNIVES.register("netherite_knife", () -> new KnifeItem(ToolMaterial.NETHERITE, 1, -2.0f));
    public static final DeferredHolder<Item, Item> PLANT_FIBER = KNIVES.register("plant_fiber", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, PickaxeItem> COPPER_PICKAXE = COPPER.register("copper_pickaxe", () -> new PickaxeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
    public static final DeferredHolder<Item, ShovelItem> COPPER_SHOVEL = COPPER.register("copper_shovel", () -> new ShovelItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
    public static final DeferredHolder<Item, AxeItem> COPPER_AXE = COPPER.register("copper_axe", () -> new AxeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
    public static final DeferredHolder<Item, HoeItem> COPPER_HOE = COPPER.register("copper_hoe", () -> new HoeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> COPPER_SWORD = COPPER.register("copper_sword", () -> new SwordItem(InstrumentusToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
    public static final DeferredHolder<Item, PaxelItem> COPPER_PAXEL = COPPER.register("copper_paxel", () -> new PaxelItem(InstrumentusToolMaterials.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, HammerItem> COPPER_HAMMER = COPPER.register("copper_hammer", () -> new HammerItem(InstrumentusToolMaterials.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, SickleItem> COPPER_SICKLE = COPPER.register("copper_sickle", () -> new SickleItem(InstrumentusToolMaterials.COPPER));
    public static final DeferredHolder<Item, InstrumentusShearsItem> COPPER_SHEARS = COPPER.register("copper_shears", () -> new InstrumentusShearsItem(InstrumentusToolMaterials.COPPER));
    public static final DeferredHolder<Item, KnifeItem> COPPER_KNIFE = COPPER.register("copper_knife", () -> new KnifeItem(InstrumentusToolMaterials.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, ExcavatorItem> COPPER_EXCAVATOR = COPPER.register("copper_excavator", () -> new ExcavatorItem(InstrumentusToolMaterials.COPPER, 1, -3.0f));

    public static final DeferredHolder<Item, InstrumentusBrushItem> WOODEN_BRUSH = BRUSHES.register("wooden_brush", () -> new InstrumentusBrushItem(ToolMaterial.WOOD));
    public static final DeferredHolder<Item, InstrumentusBrushItem> STONE_BRUSH = BRUSHES.register("stone_brush", () -> new InstrumentusBrushItem(ToolMaterial.STONE));
    public static final DeferredHolder<Item, InstrumentusBrushItem> IRON_BRUSH = BRUSHES.register("iron_brush", () -> new InstrumentusBrushItem(ToolMaterial.IRON));
    public static final DeferredHolder<Item, InstrumentusBrushItem> GOLDEN_BRUSH = BRUSHES.register("golden_brush", () -> new InstrumentusBrushItem(ToolMaterial.GOLD));
    public static final DeferredHolder<Item, InstrumentusBrushItem> DIAMOND_BRUSH = BRUSHES.register("diamond_brush", () -> new InstrumentusBrushItem(ToolMaterial.DIAMOND));
    public static final DeferredHolder<Item, InstrumentusBrushItem> NETHERITE_BRUSH = BRUSHES.register("netherite_brush", () -> new InstrumentusBrushItem(ToolMaterial.NETHERITE));
    public static final DeferredHolder<Item, EnergyBrushItem> ENERGIZED_BRUSH = BRUSHES.register("energy_brush", EnergyBrushItem::new);

    public static final DeferredHolder<Item, ExcavatorItem> WOODEN_EXCAVATOR = EXCAVATORS.register("wooden_excavator", () -> new ExcavatorItem(ToolMaterial.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> STONE_EXCAVATOR = EXCAVATORS.register("stone_excavator", () -> new ExcavatorItem(ToolMaterial.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> IRON_EXCAVATOR = EXCAVATORS.register("iron_excavator", () -> new ExcavatorItem(ToolMaterial.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> GOLDEN_EXCAVATOR = EXCAVATORS.register("golden_excavator", () -> new ExcavatorItem(ToolMaterial.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> DIAMOND_EXCAVATOR = EXCAVATORS.register("diamond_excavator", () -> new ExcavatorItem(ToolMaterial.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, ExcavatorItem> NETHERITE_EXCAVATOR = EXCAVATORS.register("netherite_excavator", () -> new ExcavatorItem(ToolMaterial.NETHERITE, 1, -3.0f));

    public static final DeferredHolder<Item, BlockItem> KILN_BLOCK_ITEM = FIRING.registerSimpleBlockItem(InstrumentusBlocks.KILN);

    public static final DeferredHolder<Item, BreezeArmorItem> BREEZE_ARMOR_BOOTS = MISC.register("breeze_boots", () -> new BreezeArmorItem(ArmorType.BOOTS));
    public static final DeferredHolder<Item, BlockItem> WIND_BLOWER = MISC.registerSimpleBlockItem(InstrumentusBlocks.WIND_BLOWER);

}
