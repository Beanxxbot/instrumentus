package com.beanbot.instrumentus.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Instrumentus.MODID);

    public static final RegistryObject<RecipeSerializer<CopperSoulCampfireRecipe>> COPPER_SOUL_CAMPFIRE_COOKING_SERIALIZER = SERIALIZERS.register("copper_soul_campfire_cooking", () -> CopperSoulCampfireRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
