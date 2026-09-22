package com.beanbot.instrumentus.common.data.generator;

//import com.beanbot.instrumentus.client.ponder.InstrumentusPonderPlugin;
import com.beanbot.instrumentus.common.Instrumentus;
//import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Instrumentus.MODID)
public class InstrumentusGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.createProvider(InstrumentusGeneratorRecipes.Runner::new);
        generator.addProvider(true, new InstrumentusGeneratorLootTables(output, event.getLookupProvider()));

        InstrumentusGeneratorBlockTags blockTags = new InstrumentusGeneratorBlockTags(output, lookupProvider);
        generator.addProvider(true, blockTags);
        InstrumentusGeneratorItemTags itemTags = new InstrumentusGeneratorItemTags(output, lookupProvider, blockTags);
        generator.addProvider(true, itemTags);

        event.createProvider(InstrumentusModelProvider::new);

        generator.addProvider(true, new InstrumentusGeneratorGlobalLootModifier(output, event.getLookupProvider()));
        generator.addProvider(true, new InstrumentusGeneratorLanguage(output));
    }
}
