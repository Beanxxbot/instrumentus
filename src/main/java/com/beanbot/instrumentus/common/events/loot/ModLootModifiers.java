package com.beanbot.instrumentus.common.events.loot;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Instrumentus.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> PLANT_FIBER_FROM_GRASS =
            LOOT_MODIFIER_SERIALIZERS.register("plant_fiber_from_grass", PlantFiberFromGrassModifier.CODEC);

    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
