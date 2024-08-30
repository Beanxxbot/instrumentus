package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class InstrumentusArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Instrumentus.MODID);

    public static final Holder<ArmorMaterial> BREEZE_ARMOR_MATERIAL =
            ARMOR_MATERIALS.register("breeze", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }),
                    20,
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    () -> Ingredient.of(Tags.Items.RODS_BREEZE),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "breeze"))),
                    0f,
                    0.5f));

    public static void register(IEventBus bus) {
        ARMOR_MATERIALS.register(bus);
    }


}
