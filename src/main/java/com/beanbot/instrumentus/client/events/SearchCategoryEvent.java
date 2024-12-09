package com.beanbot.instrumentus.client.events;

import com.beanbot.instrumentus.client.inventory.recipebook.categories.InstrumentusRecipeBookCategories;
import com.beanbot.instrumentus.common.Instrumentus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterRecipeBookSearchCategoriesEvent;

@EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SearchCategoryEvent {

    @SubscribeEvent
    public static void registerSearchCategories(RegisterRecipeBookSearchCategoriesEvent event) {
        event.register(InstrumentusRecipeBookCategories.FIRING_SEARCH, InstrumentusRecipeBookCategories.FIRING_BLOCKS.get(), InstrumentusRecipeBookCategories.FIRING_MISC.get());
    }

}
