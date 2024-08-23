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
public class InstrumentusGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new InstrumentusGeneratorRecipes(output, lookupProvider));
        generator.addProvider(event.includeServer(), new InstrumentusGeneratorLootTables(output, event.getLookupProvider()));

        InstrumentusGeneratorBlockTags blockTags = new InstrumentusGeneratorBlockTags(output, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        InstrumentusGeneratorItemTags itemTags = new InstrumentusGeneratorItemTags(output, lookupProvider, blockTags ,event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), itemTags);

        generator.addProvider(event.includeClient(), new InstrumentusGeneratorBlockStates(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new InstrumentusGeneratorItemModels(output, event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new InstrumentusGeneratorGlobalLootModifier(output, event.getLookupProvider()));
        generator.addProvider(event.includeClient(), new InstrumentusGeneratorLanguage(output));
    }
}
