package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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
        generator.addProvider(event.includeServer(), new GeneratorLootTables(output, event.getLookupProvider()));

        GeneratorBlockTags blockTags = new GeneratorBlockTags(output, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        GeneratorItemTags itemTags = new GeneratorItemTags(output, lookupProvider, blockTags ,event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), itemTags);

        generator.addProvider(event.includeClient(), new GeneratorBlockStates(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new GeneratorItemModels(output, event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new GeneratorGlobalLootModifier(output, event.getLookupProvider()));
        generator.addProvider(event.includeClient(), new GeneratorLanguage(output));
    }
}
