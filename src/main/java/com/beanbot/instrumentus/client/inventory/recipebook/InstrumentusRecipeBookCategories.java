package com.beanbot.instrumentus.client.inventory.recipebook;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class InstrumentusRecipeBookCategories {
    public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, Instrumentus.MODID);

    public static final Supplier<RecipeBookCategory> FIRING = RECIPE_BOOK_CATEGORIES.register("firing", RecipeBookCategory::new);

    public static void register(IEventBus eventBus) {
        RECIPE_BOOK_CATEGORIES.register(eventBus);
    }
}
