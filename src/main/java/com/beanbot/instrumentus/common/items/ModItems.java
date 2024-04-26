package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {

    @SuppressWarnings("unused")
    public static final Item.Properties ITEM_CATEGORY = new Item.Properties();
    public static final DeferredRegister<Item> SHEARS = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> SICKLES = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> PAXELS = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> HAMMERS = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> ENERGIZED = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> UTILITIES = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> COPPER = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);
    public static final DeferredRegister<Item> BRUSHES = DeferredRegister.create(BuiltInRegistries.ITEM, Instrumentus.MODID);

    public static final Supplier<Item> WOODEN_SHEARS = SHEARS.register("wooden_shears", () -> new ModShearsItem(Tiers.WOOD, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.WOOD.getUses() * 0.952)))));
    public static final Supplier<Item> STONE_SHEARS = SHEARS.register("stone_shears", () -> new ModShearsItem(Tiers.STONE, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.STONE.getUses() * 0.952)))));
    public static final Supplier<Item> GOLDEN_SHEARS = SHEARS.register("golden_shears", () -> new ModShearsItem(Tiers.GOLD, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.GOLD.getUses() * 0.952)))));
    public static final Supplier<Item> DIAMOND_SHEARS = SHEARS.register("diamond_shears", () -> new ModShearsItem(Tiers.DIAMOND, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.DIAMOND.getUses() * 0.952)))));
    public static final Supplier<Item> NETHERITE_SHEARS = SHEARS.register("netherite_shears", () -> new ModShearsItem(Tiers.NETHERITE, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(Tiers.NETHERITE.getUses() * 0.952))).fireResistant()));

    public static final Supplier<Item> WOODEN_SICKLE = SICKLES.register("wooden_sickle", () -> new SickleItem(Tiers.WOOD, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STONE_SICKLE = SICKLES.register("stone_sickle", () -> new SickleItem(Tiers.STONE, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> IRON_SICKLE = SICKLES.register("iron_sickle", () -> new SickleItem(Tiers.IRON, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> GOLDEN_SICKLE = SICKLES.register("golden_sickle", () -> new SickleItem(Tiers.GOLD, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DIAMOND_SICKLE = SICKLES.register("diamond_sickle", () -> new SickleItem(Tiers.DIAMOND, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHERITE_SICKLE = SICKLES.register("netherite_sickle", () -> new SickleItem(Tiers.NETHERITE, new Item.Properties().stacksTo(1).fireResistant()));

    public static final Supplier<Item> WOODEN_PAXEL = PAXELS.register("wooden_paxel", () -> new PaxelItem(Tiers.WOOD, 6.0f, -3.2f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STONE_PAXEL = PAXELS.register("stone_paxel", () -> new PaxelItem(Tiers.STONE, 7.0f, -3.2f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> IRON_PAXEL = PAXELS.register("iron_paxel", () -> new PaxelItem(Tiers.IRON, 6.0f, -3.2f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> GOLDEN_PAXEL = PAXELS.register("golden_paxel", () -> new PaxelItem(Tiers.GOLD, 6.0f, -3.2f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DIAMOND_PAXEL = PAXELS.register("diamond_paxel", () -> new PaxelItem(Tiers.DIAMOND, 5.0f, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHERITE_PAXEL = PAXELS.register("netherite_paxel", () -> new PaxelItem(Tiers.NETHERITE, 5.0f, -3.0f, new Item.Properties().stacksTo(1).fireResistant()));

    public static final Supplier<Item> WOODEN_HAMMER = HAMMERS.register("wooden_hammer", ()-> new HammerItem(Tiers.WOOD, 1, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STONE_HAMMER = HAMMERS.register("stone_hammer", ()-> new HammerItem(Tiers.STONE, 1, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> IRON_HAMMER = HAMMERS.register("iron_hammer", ()-> new HammerItem(Tiers.IRON, 1, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> GOLDEN_HAMMER = HAMMERS.register("golden_hammer", ()-> new HammerItem(Tiers.GOLD, 1, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DIAMOND_HAMMER = HAMMERS.register("diamond_hammer", ()-> new HammerItem(Tiers.DIAMOND, 1, -3.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHERITE_HAMMER = HAMMERS.register("netherite_hammer", ()-> new HammerItem(Tiers.NETHERITE, 1, -3.0f, new Item.Properties().stacksTo(1).fireResistant()));

    public static final Supplier<Item> ENERGIZED_PICKAXE = ENERGIZED.register("energy_pickaxe", () -> new EnergyPickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> ENERGIZED_SHOVEL = ENERGIZED.register("energy_shovel", () -> new EnergyShovelItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> ENERGIZED_AXE = ENERGIZED.register("energy_axe", () -> new EnergyAxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> ENERGIZED_PAXEL = ENERGIZED.register("energy_paxel", () -> new EnergyPaxelItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> ENERGIZED_HAMMER = ENERGIZED.register("energy_hammer", () -> new EnergyHammerItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> ENERGIZED_SICKLE = ENERGIZED.register("energy_sickle", () -> new EnergySickleItem(Tiers.DIAMOND));
    public static final Supplier<Item> ENERGIZED_SHEARS = ENERGIZED.register("energy_shears", () -> new EnergyShearsItem(Tiers.DIAMOND));
    public static final Supplier<Item> ENERGIZED_KNIFE = ENERGIZED.register("energy_knife", () -> new EnergyKnifeItem(Tiers.DIAMOND, 1, -2.0f, new Item.Properties().stacksTo(1).fireResistant()));
    public static final Supplier<Item> ENERGIZED_INGOT = ENERGIZED.register("energy_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ENERGIZED_BLOCK = ENERGIZED.register("energy_block", () -> new BlockItem(ModBlocks.ENERGY_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> CARBON_ROD = ENERGIZED.register("carbon_rod", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ENERGY_LIGHTNING_ROD = ENERGIZED.register("energy_lightning_rod", () -> new EnergyLightningRodItem(new Item.Properties().stacksTo(1).fireResistant()));

    public static final Supplier<Item> SOULCOPPER_PICKAXE = UTILITIES.register("soulcopper_pickaxe", () -> new SoulcopperPickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final Supplier<Item> SOULCOPPER_INGOT = UTILITIES.register("soulcopper_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> RAW_SOULCOPPER = UTILITIES.register("raw_soulcopper", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> RAW_SOULCOPPER_BLOCK = UTILITIES.register("raw_soulcopper_block", () -> new BlockItem(ModBlocks.RAW_SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> SOULCOPPER_BLOCK = UTILITIES.register("soulcopper_block", () -> new BlockItem(ModBlocks.SOULCOPPER_BLOCK.get(), new Item.Properties().stacksTo(64)));
    @SuppressWarnings("unused")
    public static final Supplier<Item> COPPER_SOUL_FLAME_LIGHT_ITEM = UTILITIES.register("copper_soul_fire_flame", () -> new BlockItem(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> COPPER_SOUL_CAMPFIRE_BLOCK_ITEM = UTILITIES.register("copper_soul_campfire", () -> new BlockItem(ModBlocks.COPPER_SOUL_CAMPFIRE.get(), new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> SOULCOPPER_TORCH_ITEM = UTILITIES.register("copper_soul_torch", () -> new StandingAndWallBlockItem(ModBlocks.SOULCOPPER_TORCH.get(), ModBlocks.SOULCOPPER_WALL_TORCH.get(), (new Item.Properties()).stacksTo(64), Direction.DOWN));
    public static final Supplier<Item> SOULCOPPER_LANTERN_ITEM = UTILITIES.register("copper_soul_lantern", () -> new BlockItem(ModBlocks.SOULCOPPER_LANTERN.get(), new Item.Properties().stacksTo(64)));

    public static final Supplier<Item> WOODEN_KNIFE = UTILITIES.register("wooden_knife", () -> new KnifeItem(Tiers.WOOD, 1, -2.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> STONE_KNIFE = UTILITIES.register("stone_knife", () -> new KnifeItem(Tiers.STONE, 1, -2.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> IRON_KNIFE = UTILITIES.register("iron_knife", () -> new KnifeItem(Tiers.IRON, 1, -2.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> GOLDEN_KNIFE = UTILITIES.register("golden_knife", () -> new KnifeItem(Tiers.GOLD, 1, -2.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> DIAMOND_KNIFE = UTILITIES.register("diamond_knife", () -> new KnifeItem(Tiers.DIAMOND, 1, -2.0f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHERITE_KNIFE = UTILITIES.register("netherite_knife", () -> new KnifeItem(Tiers.NETHERITE, 1, -2.0f, new Item.Properties().stacksTo(1).fireResistant()));
    public static final Supplier<Item> PLANT_FIBER = UTILITIES.register("plant_fiber", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> COPPER_PICKAXE = COPPER.register("copper_pickaxe", () -> new PickaxeItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties()));
    public static final Supplier<Item> COPPER_SHOVEL = COPPER.register("copper_shovel", () -> new ShovelItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties()));
    public static final Supplier<Item> COPPER_AXE = COPPER.register("copper_axe", () -> new AxeItem(ModItemTiers.COPPER, 6.0f, -3.0f, new Item.Properties()));
    public static final Supplier<Item> COPPER_HOE = COPPER.register("copper_hoe", () -> new HoeItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties()));
    public static final Supplier<Item> COPPER_SWORD = COPPER.register("copper_sword", () -> new SwordItem(ModItemTiers.COPPER, 4, -2.2f, new Item.Properties()));
    public static final Supplier<Item> COPPER_PAXEL = COPPER.register("copper_paxel", () -> new PaxelItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> COPPER_HAMMER = COPPER.register("copper_hammer", () -> new HammerItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> COPPER_SICKLE = COPPER.register("copper_sickle", () -> new SickleItem(ModItemTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> COPPER_SHEARS = COPPER.register("copper_shears", () -> new ModShearsItem(ModItemTiers.COPPER, new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(ModItemTiers.COPPER.getUses() * 0.952)))));
    public static final Supplier<Item> COPPER_KNIFE = COPPER.register("copper_knife", () -> new KnifeItem(ModItemTiers.COPPER, 1, -2.8f, new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> WOODEN_BRUSH = BRUSHES.register("wooden_brush", () -> new ModBrushItem(Tiers.WOOD));
    public static final Supplier<Item> STONE_BRUSH = BRUSHES.register("stone_brush", () -> new ModBrushItem(Tiers.STONE));
    public static final Supplier<Item> IRON_BRUSH = BRUSHES.register("iron_brush", () -> new ModBrushItem(Tiers.IRON));
    public static final Supplier<Item> GOLDEN_BRUSH = BRUSHES.register("golden_brush", () -> new ModBrushItem(Tiers.GOLD));
    public static final Supplier<Item> DIAMOND_BRUSH = BRUSHES.register("diamond_brush", () -> new ModBrushItem(Tiers.DIAMOND));
    public static final Supplier<Item> NETHERITE_BRUSH = BRUSHES.register("netherite_brush", () -> new ModBrushItem(Tiers.NETHERITE));
    public static final Supplier<Item> ENERGIZED_BRUSH = BRUSHES.register("energy_brush", EnergyBrushItem::new);




}
