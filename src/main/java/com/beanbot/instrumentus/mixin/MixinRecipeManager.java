package com.beanbot.instrumentus.mixin;

import com.beanbot.instrumentus.common.recipe.InstrumentusRecipePropertySet;
import com.beanbot.instrumentus.common.recipe.InstrumentusRecipes;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipePropertySet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


import java.util.HashMap;
import java.util.Map;

@Mixin(RecipeManager.class)
public class MixinRecipeManager {

    @WrapOperation(method = "<clinit>",
    at = @At(value = "INVOKE", target = "Ljava/util/Map;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;"))
    private static Map<ResourceKey<RecipePropertySet>, RecipeManager.IngredientExtractor> addCustomPropertySet(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3, Object k4, Object v4, Object k5, Object v5, Object k6, Object v6, Object k7, Object v7, Operation<Map<ResourceKey<RecipePropertySet>, RecipeManager.IngredientExtractor>> operation) {
        Map<ResourceKey<RecipePropertySet>, RecipeManager.IngredientExtractor> map = operation.call(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
        map = new HashMap<>(map);
        map.put(InstrumentusRecipePropertySet.FIRING, InstrumentusRecipePropertySet.forSingleFiringInput(InstrumentusRecipes.FIRING.get()));
        return Map.copyOf(map);
    }

}
