package com.beanbot.instrumentus.common.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.Optional;

public class InstrumentusRecipePropertySet {

    public static final ResourceKey<RecipePropertySet> FIRING = ResourceKey.create(RecipePropertySet.TYPE_KEY, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "firing"));

    public static RecipeManager.IngredientExtractor forSingleFiringInput(RecipeType<KilnRecipe> recipeType) {
        return t -> t.getType() == recipeType && t instanceof KilnRecipe kilnRecipe
            ? Optional.of(kilnRecipe.input())
            : Optional.empty();
    }

}
