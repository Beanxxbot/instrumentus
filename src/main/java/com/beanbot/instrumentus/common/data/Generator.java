package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
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
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GeneratorBlockLootTables::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        GeneratorBlockTags blockTags = new GeneratorBlockTags(output, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        GeneratorItemTags itemTags = new GeneratorItemTags(output, lookupProvider, blockTags ,event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), itemTags);

        generator.addProvider(event.includeClient(), new GeneratorBlockStates(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new GeneratorItemModels(output, event.getExistingFileHelper()));

        generator.addProvider(event.includeClient(), new GeneratorLanguage(output));
    }
}
