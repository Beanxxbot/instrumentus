package com.beanbot.instrumentus.client.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.common.recipe.CopperSoulCampfireRecipe;
import com.beanbot.instrumentus.common.recipe.KilnRecipe;
import com.beanbot.instrumentus.common.recipe.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class ModJEIIntegration implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath("instrumentus", "jei_plugin");
    }

    private static final IIngredientSubtypeInterpreter<ItemStack> INSTRUMENTUS_ENERGY_INTERPRETER = (stack, context) -> {
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energyStorage == null) return IIngredientSubtypeInterpreter.NONE;
        int maxEnergy = energyStorage.getMaxEnergyStored();
        return String.valueOf(maxEnergy);
    };

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerSubtypeInterpreter(ModItems.ENERGIZED_AXE.get().asItem(), INSTRUMENTUS_ENERGY_INTERPRETER);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(
                new CopperSoulCampfireCookingRecipeCategory(guiHelper),
                new FiringRecipeCategory(guiHelper)
        );
        Instrumentus.LOGGER.info("Registered JEI Categories");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.COPPER_SOUL_CAMPFIRE.get().asItem()), CopperSoulCampfireCookingRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.KILN.get().asItem()), FiringRecipeCategory.TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<CopperSoulCampfireRecipe> copperSoulCampfireRecipes = recipeManager.getAllRecipesFor(ModRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());
        List<KilnRecipe> firingRecipes = recipeManager.getAllRecipesFor(ModRecipes.FIRING.get())
                .stream().map(RecipeHolder::value).collect(Collectors.toList());

        registration.addRecipes(CopperSoulCampfireCookingRecipeCategory.TYPE, copperSoulCampfireRecipes);
        registration.addRecipes(FiringRecipeCategory.TYPE, firingRecipes);
    }
}
