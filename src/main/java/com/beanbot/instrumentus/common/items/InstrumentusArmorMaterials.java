package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.data.generator.InstrumentusGeneratorItemTags;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class InstrumentusArmorMaterials {

    public static ArmorMaterial breezeArmorMaterial = new ArmorMaterial(
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
        ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "breeze_armor_material")
    );


}
