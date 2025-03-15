package com.beanbot.instrumentus.compat.create;

import com.beanbot.instrumentus.common.Instrumentus;

import com.beanbot.instrumentus.compat.create.recipe.InstrumentusFanProcessingTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = Instrumentus.MODID, bus = EventBusSubscriber.Bus.MOD)
public class InstrumentusCreateCompat {

    @SubscribeEvent
    public static void onModLoad(RegisterEvent event) {
        if (ModList.get().isLoaded("create")) {
            InstrumentusFanProcessingTypes.init();
        }
    }
}
