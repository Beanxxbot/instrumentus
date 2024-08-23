package com.beanbot.instrumentus.common.recipe;

import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class KilnRecipe extends AbstractCookingRecipe {
    public final Ingredient input;
    public final ItemStack result;

    public KilnRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(InstrumentusRecipes.FIRING.get(), group, category, ingredient, result, experience, cookingTime);
        this.input = ingredient;
        this.result = result;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(InstrumentusBlocks.KILN.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return InstrumentusRecipes.FIRING_SERIALIZER.get();
    }
}
