package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        if( event.includeServer() )
            registerServerProviders(event.getGenerator());

        if( event.includeClient() )
            registerClientProviders(event.getGenerator(), event.getGenerator().getPackOutput(), event.getLookupProvider(), event);
    }

    private static void registerServerProviders(DataGenerator generator) {
    }

    private static void registerClientProviders(DataGenerator generator, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(true, new GeneratorBlockTags(output, lookupProvider, helper));
    }

}