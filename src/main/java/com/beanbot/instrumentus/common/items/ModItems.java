package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

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

    public static final DeferredHolder<Item, ModShearsItem> WOODEN_SHEARS = SHEARS.register("wooden_shears", () -> new ModShearsItem(Tiers.WOOD, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.WOOD.getUses() * 0.952)))));
    public static final DeferredHolder<Item, ModShearsItem> STONE_SHEARS = SHEARS.register("stone_shears", () -> new ModShearsItem(Tiers.STONE, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.STONE.getUses() * 0.952)))));
    public static final DeferredHolder<Item, ModShearsItem> GOLDEN_SHEARS = SHEARS.register("golden_shears", () -> new ModShearsItem(Tiers.GOLD, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.GOLD.getUses() * 0.952)))));
    public static final DeferredHolder<Item, ModShearsItem> DIAMOND_SHEARS = SHEARS.register("diamond_shears", () -> new ModShearsItem(Tiers.DIAMOND, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.DIAMOND.getUses() * 0.952)))));
    public static final DeferredHolder<Item, ModShearsItem> NETHERITE_SHEARS = SHEARS.register("netherite_shears", () -> new ModShearsItem(Tiers.NETHERITE, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.NETHERITE.getUses() * 0.952))).fireResistant()));

    public static final DeferredHolder<Item, SickleItem> WOODEN_SICKLE = SICKLES.register("wooden_sickle", () -> new SickleItem(Tiers.WOOD));
    public static final DeferredHolder<Item, SickleItem> STONE_SICKLE = SICKLES.register("stone_sickle", () -> new SickleItem(Tiers.STONE));
    public static final DeferredHolder<Item, SickleItem> IRON_SICKLE = SICKLES.register("iron_sickle", () -> new SickleItem(Tiers.IRON));
    public static final DeferredHolder<Item, SickleItem> GOLDEN_SICKLE = SICKLES.register("golden_sickle", () -> new SickleItem(Tiers.GOLD));
    public static final DeferredHolder<Item, SickleItem> DIAMOND_SICKLE = SICKLES.register("diamond_sickle", () -> new SickleItem(Tiers.DIAMOND));
    public static final DeferredHolder<Item, SickleItem> NETHERITE_SICKLE = SICKLES.register("netherite_sickle", () -> new SickleItem(Tiers.NETHERITE));

    public static final DeferredHolder<Item, PaxelItem> WOODEN_PAXEL = PAXELS.register("wooden_paxel", () -> new PaxelItem(Tiers.WOOD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> STONE_PAXEL = PAXELS.register("stone_paxel", () -> new PaxelItem(Tiers.STONE, 7.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> IRON_PAXEL = PAXELS.register("iron_paxel", () -> new PaxelItem(Tiers.IRON, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> GOLDEN_PAXEL = PAXELS.register("golden_paxel", () -> new PaxelItem(Tiers.GOLD, 6.0f, -3.2f));
    public static final DeferredHolder<Item, PaxelItem> DIAMOND_PAXEL = PAXELS.register("diamond_paxel", () -> new PaxelItem(Tiers.DIAMOND, 5.0f, -3.0f));
    public static final DeferredHolder<Item, PaxelItem> NETHERITE_PAXEL = PAXELS.register("netherite_paxel", () -> new PaxelItem(Tiers.NETHERITE, 5.0f, -3.0f));

    public static final DeferredHolder<Item, HammerItem> WOODEN_HAMMER = HAMMERS.register("wooden_hammer", ()-> new HammerItem(Tiers.WOOD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> STONE_HAMMER = HAMMERS.register("stone_hammer", ()-> new HammerItem(Tiers.STONE, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> IRON_HAMMER = HAMMERS.register("iron_hammer", ()-> new HammerItem(Tiers.IRON, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> GOLDEN_HAMMER = HAMMERS.register("golden_hammer", ()-> new HammerItem(Tiers.GOLD, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> DIAMOND_HAMMER = HAMMERS.register("diamond_hammer", ()-> new HammerItem(Tiers.DIAMOND, 1, -3.0f));
    public static final DeferredHolder<Item, HammerItem> NETHERITE_HAMMER = HAMMERS.register("netherite_hammer", ()-> new HammerItem(Tiers.NETHERITE, 1, -3.0f));

    public static final DeferredHolder<Item, EnergyPickaxeItem> ENERGIZED_PICKAXE = ENERGIZED.register("energy_pickaxe", () -> new EnergyPickaxeItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyShovelItem> ENERGIZED_SHOVEL = ENERGIZED.register("energy_shovel", () -> new EnergyShovelItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyAxeItem> ENERGIZED_AXE = ENERGIZED.register("energy_axe", () -> new EnergyAxeItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyHoeItem> ENERGIZED_HOE = ENERGIZED.register("energy_hoe", () -> new EnergyHoeItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyPaxelItem> ENERGIZED_PAXEL = ENERGIZED.register("energy_paxel", () -> new EnergyPaxelItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergyHammerItem> ENERGIZED_HAMMER = ENERGIZED.register("energy_hammer", () -> new EnergyHammerItem(ModItemTiers.ENERGIZED, 1, -2.8f));
    public static final DeferredHolder<Item, EnergySickleItem> ENERGIZED_SICKLE = ENERGIZED.register("energy_sickle", () -> new EnergySickleItem(ModItemTiers.ENERGIZED));
    public static final DeferredHolder<Item, EnergyShearsItem> ENERGIZED_SHEARS = ENERGIZED.register("energy_shears", () -> new EnergyShearsItem(ModItemTiers.ENERGIZED));
    public static final DeferredHolder<Item, EnergyKnifeItem> ENERGIZED_KNIFE = ENERGIZED.register("energy_knife", () -> new EnergyKnifeItem(ModItemTiers.ENERGIZED, 1, -2.0f));
    public static final DeferredHolder<Item, Item> ENERGIZED_INGOT = ENERGIZED.register("energy_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ENERGIZED_BLOCK = ENERGIZED.register("energy_block", () -> new BlockItem(ModBlocks.ENERGIZED_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, Item> CARBON_ROD = ENERGIZED.register("carbon_rod", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, EnergyLightningRodItem> ENERGIZED_LIGHTNING_ROD = ENERGIZED.register("energy_lightning_rod", () -> new EnergyLightningRodItem(new Item.Properties().stacksTo(1).fireResistant()));

    public static final DeferredHolder<Item, SoulcopperPickaxeItem> SOULCOPPER_PICKAXE = SOULCOPPER.register("soulcopper_pickaxe", () -> new SoulcopperPickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final DeferredHolder<Item, Item> SOULCOPPER_INGOT = SOULCOPPER.register("soulcopper_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_SOULCOPPER = SOULCOPPER.register("raw_soulcopper", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RAW_SOULCOPPER_BLOCK = SOULCOPPER.register("raw_soulcopper_block", () -> new BlockItem(ModBlocks.RAW_SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_BLOCK = SOULCOPPER.register("soulcopper_block", () -> new BlockItem(ModBlocks.SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, BurnerItem> SOULCOPPER_BURNER = SOULCOPPER.register("soulcopper_burner", BurnerItem::new);
    @SuppressWarnings("unused")
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_FLAME_LIGHT_ITEM = SOULCOPPER.register("copper_soul_fire_flame", () -> new BlockItem(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COPPER_SOUL_CAMPFIRE_BLOCK_ITEM = SOULCOPPER.register("copper_soul_campfire", () -> new BlockItem(ModBlocks.COPPER_SOUL_CAMPFIRE.get(), new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, StandingAndWallBlockItem> SOULCOPPER_TORCH_ITEM = SOULCOPPER.register("copper_soul_torch", () -> new StandingAndWallBlockItem(ModBlocks.SOULCOPPER_TORCH.get(), ModBlocks.SOULCOPPER_WALL_TORCH.get(), (new Item.Properties()).stacksTo(64), Direction.DOWN));
    public static final DeferredHolder<Item, BlockItem> SOULCOPPER_LANTERN_ITEM = SOULCOPPER.register("copper_soul_lantern", () -> new BlockItem(ModBlocks.SOULCOPPER_LANTERN.get(), new Item.Properties().stacksTo(64)));

    public static final DeferredHolder<Item, KnifeItem> WOODEN_KNIFE = KNIVES.register("wooden_knife", () -> new KnifeItem(Tiers.WOOD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> STONE_KNIFE = KNIVES.register("stone_knife", () -> new KnifeItem(Tiers.STONE, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> IRON_KNIFE = KNIVES.register("iron_knife", () -> new KnifeItem(Tiers.IRON, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> GOLDEN_KNIFE = KNIVES.register("golden_knife", () -> new KnifeItem(Tiers.GOLD, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> DIAMOND_KNIFE = KNIVES.register("diamond_knife", () -> new KnifeItem(Tiers.DIAMOND, 1, -2.0f));
    public static final DeferredHolder<Item, KnifeItem> NETHERITE_KNIFE = KNIVES.register("netherite_knife", () -> new KnifeItem(Tiers.NETHERITE, 1, -2.0f));
    public static final DeferredHolder<Item, Item> PLANT_FIBER = KNIVES.register("plant_fiber", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, PickaxeItem> COPPER_PICKAXE = COPPER.register("copper_pickaxe", () -> new PickaxeItem(ModItemTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModItemTiers.COPPER, 1, -2.8f ))));
    public static final DeferredHolder<Item, ShovelItem> COPPER_SHOVEL = COPPER.register("copper_shovel", () -> new ShovelItem(ModItemTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(ModItemTiers.COPPER, 1, -2.8f))));
    public static final DeferredHolder<Item, AxeItem> COPPER_AXE = COPPER.register("copper_axe", () -> new AxeItem(ModItemTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(ModItemTiers.COPPER, 6.0f, -3.0f))));
    public static final DeferredHolder<Item, HoeItem> COPPER_HOE = COPPER.register("copper_hoe", () -> new HoeItem(ModItemTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(ModItemTiers.COPPER, 1, -2.8f))));
    public static final DeferredHolder<Item, SwordItem> COPPER_SWORD = COPPER.register("copper_sword", () -> new SwordItem(ModItemTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(ModItemTiers.COPPER, 4, -2.4f))));
    public static final DeferredHolder<Item, PaxelItem> COPPER_PAXEL = COPPER.register("copper_paxel", () -> new PaxelItem(ModItemTiers.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, HammerItem> COPPER_HAMMER = COPPER.register("copper_hammer", () -> new HammerItem(ModItemTiers.COPPER, 1, -2.8f));
    public static final DeferredHolder<Item, SickleItem> COPPER_SICKLE = COPPER.register("copper_sickle", () -> new SickleItem(ModItemTiers.COPPER));
    public static final DeferredHolder<Item, ModShearsItem> COPPER_SHEARS = COPPER.register("copper_shears", () -> new ModShearsItem(ModItemTiers.COPPER, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(ModItemTiers.COPPER.getUses() * 0.952)))));
    public static final DeferredHolder<Item, KnifeItem> COPPER_KNIFE = COPPER.register("copper_knife", () -> new KnifeItem(ModItemTiers.COPPER, 1, -2.8f));

    public static final DeferredHolder<Item, ModBrushItem> WOODEN_BRUSH = BRUSHES.register("wooden_brush", () -> new ModBrushItem(Tiers.WOOD));
    public static final DeferredHolder<Item, ModBrushItem> STONE_BRUSH = BRUSHES.register("stone_brush", () -> new ModBrushItem(Tiers.STONE));
    public static final DeferredHolder<Item, ModBrushItem> IRON_BRUSH = BRUSHES.register("iron_brush", () -> new ModBrushItem(Tiers.IRON));
    public static final DeferredHolder<Item, ModBrushItem> GOLDEN_BRUSH = BRUSHES.register("golden_brush", () -> new ModBrushItem(Tiers.GOLD));
    public static final DeferredHolder<Item, ModBrushItem> DIAMOND_BRUSH = BRUSHES.register("diamond_brush", () -> new ModBrushItem(Tiers.DIAMOND));
    public static final DeferredHolder<Item, ModBrushItem> NETHERITE_BRUSH = BRUSHES.register("netherite_brush", () -> new ModBrushItem(Tiers.NETHERITE));
    public static final DeferredHolder<Item, EnergyBrushItem> ENERGIZED_BRUSH = BRUSHES.register("energy_brush", EnergyBrushItem::new);




}
