package com.beanbot.instrumentus.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Instrumentus.MODID);
    public static final Supplier<RecipeType<CopperSoulCampfireRecipe>> COPPER_SOUL_CAMPFIRE_COOKING_TYPE =
            RECIPE_TYPES.register("copper_soul_campfire_cooking_recipe", () -> RecipeType.simple(new ResourceLocation(Instrumentus.MODID, "copper_soul_campfire_cooking_recipe")));

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Instrumentus.MODID);
    public static final Supplier<CopperSoulCampfireRecipe.Serializer> COPPER_SOUL_CAMPFIRE_COOKING_SERIALIZER =
            RECIPE_SERIALIZERS.register("copper_soul_campfire_cooking", CopperSoulCampfireRecipe.Serializer::new);

    public static void register(IEventBus eventBus){
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
