package com.beanbot.instrumentus.common.events.loot;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.Codec;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;


//TODO: Changed in 1.20.4 see: https://docs.neoforged.net/docs/resources/server/glm/#registering-a-global-loot-modifier
public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Instrumentus.MODID);
    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<PlantFiberFromGrassModifier>> PLANT_FIBER_FROM_GRASS = LOOT_MODIFIER_SERIALIZERS.register("plant_fiber_from_grass", PlantFiberFromGrassModifier.CODEC);

//    public static final Supplier<Codec<? extends IGlobalLootModifier>> PLANT_FIBER_FROM_GRASS =
//            LOOT_MODIFIER_SERIALIZERS.register("plant_fiber_from_grass", PlantFiberFromGrassModifier.CODEC);

    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
