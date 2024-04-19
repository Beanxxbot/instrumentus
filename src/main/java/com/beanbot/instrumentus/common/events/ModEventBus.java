package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegisterEvent event){
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(Instrumentus.MODID, CopperSoulCampfireRecipe.Type.ID), CopperSoulCampfireRecipe.Type.INSTANCE);
        });
    }


}
