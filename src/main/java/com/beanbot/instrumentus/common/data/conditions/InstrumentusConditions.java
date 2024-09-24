package com.beanbot.instrumentus.common.data.conditions;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class InstrumentusConditions {

    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, Instrumentus.MODID);

    public static final Supplier<MapCodec<FeatureEnabledCondition>> FEATURE_ENABLED_CONDITION =
            CONDITION_CODECS.register("config_feature_enabled", () -> FeatureEnabledCondition.CODEC);

    public static void register(IEventBus bus) {
        CONDITION_CODECS.register(bus);
    }

}
