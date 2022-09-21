package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.armor.ModArmorMaterial;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final Item.Properties ITEM_CATEGORY = new Item.Properties().tab(Instrumentus.MOD_ITEM_GROUP);
    public static final DeferredRegister<Item> SHEARS = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> SICKLES = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> PAXELS = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> HAMMERS = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> ENERGIZED = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> UTILITIES = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);
    public static final DeferredRegister<Item> KNIVES = DeferredRegister.create(ForgeRegistries.ITEMS, Instrumentus.MODID);

    public static final RegistryObject<Item> WOODEN_SHEARS = SHEARS.register("wooden_shears", () -> new ModShearsItem(Tiers.WOOD, new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.WOOD.getUses() * 0.952)))));
    public static final RegistryObject<Item> STONE_SHEARS = SHEARS.register("stone_shears", () -> new ModShearsItem(Tiers.STONE, new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.STONE.getUses() * 0.952)))));
    public static final RegistryObject<Item> GOLDEN_SHEARS = SHEARS.register("golden_shears", () -> new ModShearsItem(Tiers.GOLD, new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.GOLD.getUses() * 0.952)))));
    public static final RegistryObject<Item> DIAMOND_SHEARS = SHEARS.register("diamond_shears", () -> new ModShearsItem(Tiers.DIAMOND, new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.DIAMOND.getUses() * 0.952)))));
    public static final RegistryObject<Item> NETHERITE_SHEARS = SHEARS.register("netherite_shears", () -> new ModShearsItem(Tiers.NETHERITE, new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.NETHERITE.getUses() * 0.952)))));

    public static final RegistryObject<Item> WOODEN_SICKLE = SICKLES.register("wooden_sickle", () -> new SickleItem(Tiers.WOOD));
    public static final RegistryObject<Item> STONE_SICKLE = SICKLES.register("stone_sickle", () -> new SickleItem(Tiers.STONE));
    public static final RegistryObject<Item> IRON_SICKLE = SICKLES.register("iron_sickle", () -> new SickleItem(Tiers.IRON));
    public static final RegistryObject<Item> GOLDEN_SICKLE = SICKLES.register("golden_sickle", () -> new SickleItem(Tiers.GOLD));
    public static final RegistryObject<Item> DIAMOND_SICKLE = SICKLES.register("diamond_sickle", () -> new SickleItem(Tiers.DIAMOND));
    public static final RegistryObject<Item> NETHERITE_SICKLE = SICKLES.register("netherite_sickle", () -> new SickleItem(Tiers.NETHERITE));

    public static final RegistryObject<Item> WOODEN_PAXEL = PAXELS.register("wooden_paxel", () -> new PaxelItem(Tiers.WOOD, 1, -2.8f));
    public static final RegistryObject<Item> STONE_PAXEL = PAXELS.register("stone_paxel", () -> new PaxelItem(Tiers.STONE, 1, -2.8f));
    public static final RegistryObject<Item> IRON_PAXEL = PAXELS.register("iron_paxel", () -> new PaxelItem(Tiers.IRON, 1, -2.8f));
    public static final RegistryObject<Item> GOLDEN_PAXEL = PAXELS.register("golden_paxel", () -> new PaxelItem(Tiers.GOLD, 1, -2.8f));
    public static final RegistryObject<Item> DIAMOND_PAXEL = PAXELS.register("diamond_paxel", () -> new PaxelItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> NETHERITE_PAXEL = PAXELS.register("netherite_paxel", () -> new PaxelItem(Tiers.NETHERITE, 1, -2.8f));

    public static final RegistryObject<Item> WOODEN_HAMMER = HAMMERS.register("wooden_hammer", ()-> new HammerItem(Tiers.WOOD, 1, -3.0f));
    public static final RegistryObject<Item> STONE_HAMMER = HAMMERS.register("stone_hammer", ()-> new HammerItem(Tiers.STONE, 1, -3.0f));
    public static final RegistryObject<Item> IRON_HAMMER = HAMMERS.register("iron_hammer", ()-> new HammerItem(Tiers.IRON, 1, -3.0f));
    public static final RegistryObject<Item> GOLDEN_HAMMER = HAMMERS.register("golden_hammer", ()-> new HammerItem(Tiers.GOLD, 1, -3.0f));
    public static final RegistryObject<Item> DIAMOND_HAMMER = HAMMERS.register("diamond_hammer", ()-> new HammerItem(Tiers.DIAMOND, 1, -3.0f));
    public static final RegistryObject<Item> NETHERITE_HAMMER = HAMMERS.register("netherite_hammer", ()-> new HammerItem(Tiers.NETHERITE, 1, -3.0f));

    public static final RegistryObject<Item> ENERGIZED_PICKAXE = ENERGIZED.register("energy_pickaxe", () -> new EnergyPickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ENERGIZED_SHOVEL = ENERGIZED.register("energy_shovel", () -> new EnergyShovelItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ENERGIZED_AXE = ENERGIZED.register("energy_axe", () -> new EnergyAxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ENERGIZED_PAXEL = ENERGIZED.register("energy_paxel", () -> new EnergyPaxelItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ENERGIZED_HAMMER = ENERGIZED.register("energy_hammer", () -> new EnergyHammerItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ENERGIZED_SICKLE = ENERGIZED.register("energy_sickle", () -> new EnergySickleItem(Tiers.DIAMOND));
    public static final RegistryObject<Item> ENERGIZED_SHEARS = ENERGIZED.register("energy_shears", () -> new EnergyShearsItem(Tiers.DIAMOND));
    public static final RegistryObject<Item> ENERGIZED_INGOT = ENERGIZED.register("energy_ingot", () -> new Item(new Item.Properties().tab(Instrumentus.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ENERGIZED_BLOCK = ENERGIZED.register("energy_block", () -> new BlockItem(ModBlocks.ENERGY_BLOCK.get(), new Item.Properties().stacksTo(64).tab(Instrumentus.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CARBON_ROD = ENERGIZED.register("carbon_rod", () -> new Item(new Item.Properties().tab(Instrumentus.MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> ILLUMINATE_PICKAXE = UTILITIES.register("illuminate_pickaxe", () -> new IlluminatePickaxeItem(Tiers.DIAMOND, 1, -2.8f));
    public static final RegistryObject<Item> ILLUMINATE_INGOT = UTILITIES.register("illuminate_ingot", () -> new Item(new Item.Properties().tab(Instrumentus.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ILLUMINATE_LIGHT_ITEM = UTILITIES.register("illuminate_light", () -> new BlockItem(ModBlocks.ILLUMINATE_LIGHT.get(), new Item.Properties()));

//    public static final RegistryObject<Item> SOLAR_BOOTS = ARMOR.register();
//    public static final RegistryObject<Item> SOLAR_HELMET = ARMOR.register();
//    public static final RegistryObject<Item> SOLAR_CHESTPLATE = ARMOR.register();
//    public static final RegistryObject<Item> SOLAR_LEGGINGS = ARMOR.register();
    public static final RegistryObject<Item> WARPED_HELMET = ARMOR.register("warped_helmet", () -> new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.HEAD, ITEM_CATEGORY));
    public static final RegistryObject<Item> WARPED_CHESTPLATE = ARMOR.register("warped_chestplate", () -> new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.CHEST, ITEM_CATEGORY));
    public static final RegistryObject<Item> WARPED_LEGGINGS = ARMOR.register("warped_leggings", () -> new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.LEGS, ITEM_CATEGORY));
    public static final RegistryObject<Item> WARPED_BOOTS = ARMOR.register("warped_boots", () -> new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.FEET, ITEM_CATEGORY));




}
