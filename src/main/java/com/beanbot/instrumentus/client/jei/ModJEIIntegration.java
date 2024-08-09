package com.beanbot.instrumentus.client.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe;
import com.beanbot.instrumentus.recipe.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class ModJEIIntegration implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        Instrumentus.LOGGER.info("JEI Plugin is Online");
        return ResourceLocation.fromNamespaceAndPath("instrumentus", "jei_plugin");
    }

    //TODO - Fix Recipe not added because the recipe category cannot handle it: com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe@55ab20e1 Failed to get ingredients from recipe wrapper
    @Override
    @SuppressWarnings("unchecked")
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IRecipeManager recipeRegistry = jeiRuntime.getRecipeManager();
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<RecipeHolder<CraftingRecipe>> hiddenRecipes = new ArrayList<>();
        recipeRegistry.hideRecipes(RecipeTypes.CRAFTING, hiddenRecipes);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(
            new CopperSoulCampfireCookingRecipeCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<CopperSoulCampfireRecipe> copperSoulCampfireRecipes = recipeManager.getAllRecipesFor(ModRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());

        registration.addRecipes(CopperSoulCampfireCookingRecipeCategory.TYPE, copperSoulCampfireRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get()), CopperSoulCampfireCookingRecipeCategory.TYPE);
    }

}
