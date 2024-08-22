package com.beanbot.instrumentus.common.data.builder;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.recipe.KilnRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class KilnCookingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final CookingBookCategory bookCategory;
    private final Item result;
    private final ItemStack stackResult; // Neo: add stack result support
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @javax.annotation.Nullable
    private String group;
    private final AbstractCookingRecipe.Factory<?> factory;

    private KilnCookingRecipeBuilder(
        RecipeCategory category,
        CookingBookCategory bookCategory,
        ItemLike result,
        Ingredient ingredient,
        float experience,
        int cookingTime,
        AbstractCookingRecipe.Factory<?> factory
    ) {
        this(category, bookCategory, new ItemStack(result), ingredient, experience, cookingTime, factory);
    }

    private KilnCookingRecipeBuilder(
        RecipeCategory category,
        CookingBookCategory bookCategory,
        ItemStack result,
        Ingredient ingredient,
        float experience,
        int cookingTime,
        AbstractCookingRecipe.Factory<?> factory
    ) {
        this.category = category;
        this.bookCategory = bookCategory;
        this.result = result.getItem();
        this.stackResult = result;
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.factory = factory;
    }

    public static KilnCookingRecipeBuilder fire(Ingredient ingredient, RecipeCategory category, ItemStack result, float experience, int cookingTime) {
        return new KilnCookingRecipeBuilder(
            category, determineKilnRecipeCategory(result.getItem()), result, ingredient, experience, cookingTime, KilnRecipe::new
        );
    }

    public static KilnCookingRecipeBuilder fireDefault(Ingredient ingredient, RecipeCategory category, ItemStack result) {
        return new KilnCookingRecipeBuilder(
            category, determineKilnRecipeCategory(result.getItem()), result, ingredient, 0.1f, 100, KilnRecipe::new
        );
    }

    @Override
    public RecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    public void save(@NotNull RecipeOutput recipeOutput) {
        this.save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, BuiltInRegistries.ITEM.getKey(this.result).getPath() + "-kiln"));
    }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        AbstractCookingRecipe abstractcookingrecipe = this.factory
                .create(
                        Objects.requireNonNullElse(this.group, ""), this.bookCategory, this.ingredient, this.stackResult, this.experience, this.cookingTime
                );
        pRecipeOutput.accept(pId, abstractcookingrecipe, advancement$builder.build(pId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private static CookingBookCategory determineKilnRecipeCategory(ItemLike result) {
        return result.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
