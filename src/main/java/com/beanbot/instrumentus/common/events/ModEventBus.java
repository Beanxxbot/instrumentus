package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.events.loot.PlantFiberFromGrassModifier;
import com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, CopperSoulCampfireRecipe.Type.ID, CopperSoulCampfireRecipe.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new PlantFiberFromGrassModifier.Serializer().setRegistryName(new ResourceLocation(Instrumentus.MODID, "plant_fiber_from_grass"))
        );
    }

}
