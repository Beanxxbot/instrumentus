package com.beanbot.instrumentus.client.inventory.recipebook.categories;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InstrumentusRecipeBookCategories {
    public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(BuiltInRegistries.RECIPE_BOOK_CATEGORY, Instrumentus.MODID);

    public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FIRING_BLOCKS = RECIPE_BOOK_CATEGORIES.register("firing-blocks", RecipeBookCategory::new);
    public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FIRING_MISC = RECIPE_BOOK_CATEGORIES.register("firing-misc", RecipeBookCategory::new);
    public static final ExtendedRecipeBookCategory FIRING_SEARCH = new ExtendedRecipeBookCategory() {};

    public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> COPPER_SOUL_CAMPFIRE_COOKING = RECIPE_BOOK_CATEGORIES.register("copper_soul_campfire_cooking", RecipeBookCategory::new);

    public static void register(IEventBus bus) {
        RECIPE_BOOK_CATEGORIES.register(bus);
    }
}
