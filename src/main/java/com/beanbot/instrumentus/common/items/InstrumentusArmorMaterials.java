package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.data.generator.InstrumentusGeneratorItemTags;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public interface InstrumentusArmorMaterials {

    ResourceKey<? extends Registry<EquipmentAsset>> ARMOR_MATERIALS_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "equipment_assets"));

    ArmorMaterial BREEZE_ARMOR_MATERIAL = new ArmorMaterial(
        20,
        Util.make(new EnumMap<>(ArmorType.class), map -> {
            map.put(ArmorType.BOOTS, 3);
            map.put(ArmorType.LEGGINGS, 6);
            map.put(ArmorType.CHESTPLATE, 8);
            map.put(ArmorType.HELMET, 3);
            map.put(ArmorType.BODY, 11);
        }),
        20,
        SoundEvents.ARMOR_EQUIP_GENERIC,
        0f,
        0.5f,
        InstrumentusGeneratorItemTags.REPAIRS_BREEZE_ARMOR,
        ResourceKey.create(ARMOR_MATERIALS_KEY, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "breeze"))
        );
}
