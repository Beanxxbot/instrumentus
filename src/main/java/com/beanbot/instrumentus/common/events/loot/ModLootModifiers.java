package com.beanbot.instrumentus.common.events.loot;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.Codec;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Instrumentus.MODID);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<PlantFiberFromGrassModifier>> PLANT_FIBER_FROM_GRASS = LOOT_MODIFIER_SERIALIZERS.register("plant_fiber_from_grass", PlantFiberFromGrassModifier.CODEC);



    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
