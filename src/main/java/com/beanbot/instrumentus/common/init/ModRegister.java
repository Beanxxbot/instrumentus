package com.beanbot.instrumentus.common.init;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.armor.ModArmorMaterial;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.config.ItemConfig;
import com.beanbot.instrumentus.common.items.*;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = Instrumentus.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModRegister {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        if (ItemConfig.enable_shears.get()) {
        event.getRegistry().registerAll(
                setup(new ModShearsItem(Tiers.WOOD, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.WOOD.getUses() * 0.952)))), "wooden_shears"),
                setup(new ModShearsItem(Tiers.STONE, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.STONE.getUses() * 0.952)))), "stone_shears"),
                setup(new ModShearsItem(Tiers.GOLD, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.GOLD.getUses() * 0.952)))), "golden_shears"),
                setup(new ModShearsItem(Tiers.DIAMOND, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.DIAMOND.getUses() * 0.952)))), "diamond_shears"),
                setup(new ModShearsItem(Tiers.NETHERITE, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Math.toIntExact(Math.round(Tiers.NETHERITE.getUses() * 0.952)))), "netherite_shears"));
        }
        if (ItemConfig.enable_sickles.get()) {
            event.getRegistry().registerAll(
                    setup(new SickleItem(Tiers.WOOD), "wooden_sickle"),
                    setup(new SickleItem(Tiers.STONE), "stone_sickle"),
                    setup(new SickleItem(Tiers.IRON), "iron_sickle"),
                    setup(new SickleItem(Tiers.GOLD), "golden_sickle"),
                    setup(new SickleItem(Tiers.DIAMOND), "diamond_sickle"),
                    setup(new SickleItem(Tiers.NETHERITE), "netherite_sickle"));
        }
        if (ItemConfig.enable_paxels.get()) {
            event.getRegistry().registerAll(
                    setup(new PaxelItem(Tiers.WOOD, 1, -2.8F), "wooden_paxel"),
                    setup(new PaxelItem(Tiers.STONE, 1, -2.8F), "stone_paxel"),
                    setup(new PaxelItem(Tiers.IRON, 1, -2.8F), "iron_paxel"),
                    setup(new PaxelItem(Tiers.GOLD, 1, -2.8F), "golden_paxel"),
                    setup(new PaxelItem(Tiers.DIAMOND, 1, -2.8F), "diamond_paxel"),
                    setup(new PaxelItem(Tiers.NETHERITE, 1, -2.8f), "netherite_paxel"));
        }
        if (ItemConfig.enable_hammers.get()) {
            event.getRegistry().registerAll(
                    setup(new HammerItem(Tiers.WOOD, 1, -3.0f), "wooden_hammer"),
                    setup(new HammerItem(Tiers.STONE, 1, -3.0f), "stone_hammer"),
                    setup(new HammerItem(Tiers.IRON, 1, -3.0f), "iron_hammer"),
                    setup(new HammerItem(Tiers.GOLD, 1, -3.0f), "golden_hammer"),
                    setup(new HammerItem(Tiers.DIAMOND, 1, -3.0f), "diamond_hammer"),
                    setup(new HammerItem(Tiers.NETHERITE, 1, -3.0f), "netherite_hammer")
                    );
        }
        if (ItemConfig.enable_energized.get()) {
            event.getRegistry().registerAll(
                    setup(new EnergyPickaxeItem(Tiers.DIAMOND, 1, -2.8f), "energy_pickaxe"),
                    setup(new EnergyShovelItem(Tiers.DIAMOND, 1, -2.8f), "energy_shovel"),
                    setup(new EnergyAxeItem(Tiers.DIAMOND, 1, -2.8f), "energy_axe"),
                    setup(new EnergyHammerItem(Tiers.DIAMOND, 1, -2.8f), "energy_hammer"),
                    setup(new EnergySickleItem(Tiers.DIAMOND), "energy_sickle"),
                    setup(new EnergyShearsItem(Tiers.DIAMOND), "energy_shears"),
                    setup(new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "energy_ingot"),
                    setup(new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "carbon_rod")//,
//                    setup(new BlockItem(ModBlocks.ENERGY_BLOCK.getBlock(), new Item.Properties().maxStackSize(64).group(ModItemGroups.MOD_ITEM_GROUP)), "energy_block"),
//                    setup(new EnergyPaxelItem(ItemTier.DIAMOND, 1, -2.8f), "energy_paxel")
                    );
        }
        //https://github.com/Direwolf20-MC/MiningGadgets/blob/1.18/src/main/java/com/direwolf20/mininggadgets/common/blocks/ModBlocks.java
        if (ItemConfig.enable_util.get()) {
            event.getRegistry().registerAll(
                    setup(new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "illuminate_ingot"),
                    setup(new BlockItem(ModBlocks.ILLUMINATE_LIGHT, new Item.Properties().stacksTo(1)), "illuminate_light"),
                    setup(new IlluminatePickaxeItem(Tiers.DIAMOND, 1, -2.8f), "illuminate_pickaxe")
                    );
        }
        if (ItemConfig.enable_armor.get()) {
            event.getRegistry().registerAll(
                    setup(new SolarArmorItem(ModArmorMaterial.SOLAR, EquipmentSlot.HEAD, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "solar_helmet"),
                    setup(new SolarArmorItem(ModArmorMaterial.SOLAR, EquipmentSlot.CHEST, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "solar_chestplate"),
                    setup(new SolarArmorItem(ModArmorMaterial.SOLAR, EquipmentSlot.LEGS, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "solar_leggings"),
                    setup(new SolarArmorItem(ModArmorMaterial.SOLAR, EquipmentSlot.FEET, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "solar_boots"),
                    setup(new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.HEAD, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "warped_helmet"),
                    setup(new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.CHEST, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "warped_chestplate"),
                    setup(new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.LEGS, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "warped_leggings"),
                    setup(new WarpedArmorItem(ModArmorMaterial.WARPED, EquipmentSlot.FEET, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)), "warped_boots"));
        }
        if (ItemConfig.enable_knives.get()) {
            event.getRegistry().registerAll(
//                    setup(new KnifeItem(Tiers.IRON, 2, -1.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(Tiers.IRON.getUses())), "iron_knife")
            );
        }
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event){
        if (ItemConfig.enable_util.get()) {
            event.getRegistry().registerAll(
//                    setup(new IlluminateLight(), "illuminate_light")
                    );
        }
        if (ItemConfig.enable_energized.get()) {
            event.getRegistry().registerAll(
//                    setup(new Block(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).setLightLevel(e -> 4)), "energy_block")
                    );
        }
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Instrumentus.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
