package com.beanbot.instrumentus.common.recipe;

import com.beanbot.instrumentus.client.inventory.recipebook.categories.InstrumentusRecipeBookCategories;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class KilnRecipe extends AbstractCookingRecipe {
    public final Ingredient input;
    public final ItemStack result;

    public KilnRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
        this.input = ingredient;
        this.result = result;
    }

    @Override
    protected Item furnaceIcon() {
        return InstrumentusBlocks.KILN.get().asItem();
    }

    @Override
    public RecipeType<KilnRecipe> getType() {
        return InstrumentusRecipes.FIRING.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return switch(this.category()) {
            case BLOCKS -> InstrumentusRecipeBookCategories.FIRING_BLOCKS.get();
            case FOOD, MISC -> InstrumentusRecipeBookCategories.FIRING_MISC.get();
        };
    }

    @Override
    public RecipeSerializer<KilnRecipe> getSerializer() {
        return InstrumentusRecipes.FIRING_SERIALIZER.get();
    }
}
