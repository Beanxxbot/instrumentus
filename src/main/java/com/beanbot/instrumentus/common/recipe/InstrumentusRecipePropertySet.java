package com.beanbot.instrumentus.common.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class InstrumentusRecipePropertySet {
    public static final ResourceKey<? extends Registry<RecipePropertySet>> RECIPE_TYPE_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "recipe_property_set"));
    public static final ResourceKey<RecipePropertySet> FIRING = ResourceKey.create(RECIPE_TYPE_KEY, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "firing"));
}
