package com.beanbot.instrumentus.common.data.builder;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.recipe.CopperSoulCampfireRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CopperSoulCampfireCookingRecipeBuilder implements RecipeBuilder {
    @SuppressWarnings("FieldCanBeLocal")
    private String group;

    private final ResourceLocation id;
    protected final Ingredient input;
    protected final ItemStack output;
    protected final int cookingTime;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public CopperSoulCampfireCookingRecipeBuilder(ResourceLocation id, Ingredient input, ItemStack output, int cookingTime) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.cookingTime = cookingTime;
    }

    public static CopperSoulCampfireCookingRecipeBuilder smelting(ResourceLocation id, Ingredient input, ItemStack output, int cookingTime) {
        return new CopperSoulCampfireCookingRecipeBuilder(id, input, output, cookingTime);
    }


    @Override
    public @NotNull RecipeBuilder unlockedBy(@NotNull String pName, @NotNull Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return this.output.getItem();
    }

    //TODO: This May Be Unhappy
    public void save(@NotNull RecipeOutput recipeOutput) {
        this.save(recipeOutput, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, BuiltInRegistries.ITEM.getKey(this.output.getItem()).getPath() + "-copper_soul_campfire_cooking")));
    }

    @Override
    public void save(RecipeOutput recipeOutput, @NotNull ResourceKey<Recipe<?>> pId) {
        this.ensureValid(pId);
        Advancement.Builder advancementBuilder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion);
        CopperSoulCampfireRecipe copperSoulCampfireRecipe = new CopperSoulCampfireRecipe(
            this.id,
            this.input,
            this.output,
            this.cookingTime
        );
        recipeOutput.accept(pId, copperSoulCampfireRecipe, advancementBuilder.build(pId.location().withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }

    private void ensureValid(ResourceKey<Recipe<?>> pId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
