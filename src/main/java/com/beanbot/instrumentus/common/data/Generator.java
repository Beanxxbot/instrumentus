package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Instrumentus.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Generator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new GeneratorRecipes(output, lookupProvider));

        generator.addProvider(event.includeClient(), new GeneratorBlockTags(output, lookupProvider, event.getExistingFileHelper()));


//        if( event.includeServer() )
//            registerCommonProviders(event.getGenerator(), event.getGenerator().getPackOutput(), event.getLookupProvider());
//
//        if( event.includeClient() )
//            registerClientProviders(event.getGenerator(), event.getGenerator().getPackOutput(), event.getLookupProvider(), event.getExistingFileHelper());
    }

    private static void registerCommonProviders(DataGenerator generator, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    }

    private static void registerClientProviders(DataGenerator generator, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper helper) {
    }

}
