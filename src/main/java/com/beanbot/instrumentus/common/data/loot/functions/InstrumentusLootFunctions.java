package com.beanbot.instrumentus.common.data.loot.functions;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class InstrumentusLootFunctions {
    public static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTION_TYPES = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, Instrumentus.MODID);

    public static final Supplier<LootItemFunctionType<SetItemCountWithFeatureEnabledFunction>> SET_ITEM_COUNT_WITH_FEATURE_ENABLED_FUNCTION = LOOT_FUNCTION_TYPES.register("set_item_count_with_feature_enabled", () -> new LootItemFunctionType<>(SetItemCountWithFeatureEnabledFunction.CODEC));

    public static void register(IEventBus bus) {
        LOOT_FUNCTION_TYPES.register(bus);
    }

}
