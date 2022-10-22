package com.beanbot.instrumentus.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;

public class CopperSoulCampfireRecipe extends CampfireCookingRecipe {
    public CopperSoulCampfireRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(id, group, ingredient, result, experience, cookingTime);
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.SOUL_CAMPFIRE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CopperSoulCampfireRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "copper_soul_campfire_cooking";
    }

    public static class Serializer implements RecipeSerializer<CopperSoulCampfireRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Instrumentus.MODID, "copper_soul_campfire_cooking");

        @Override
        public CopperSoulCampfireRecipe fromJson(ResourceLocation id, JsonObject serializedRecipe) {
            String s = GsonHelper.getAsString(serializedRecipe, "group", "");
            JsonElement jsonelement = (JsonElement)(GsonHelper.isArrayNode(serializedRecipe, "ingredient") ? GsonHelper.getAsJsonArray(serializedRecipe, "ingredient") : GsonHelper.getAsJsonObject(serializedRecipe, "ingredient"));
            Ingredient ingredient = Ingredient.fromJson(jsonelement);
            //Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
            if (!serializedRecipe.has("result")) throw new JsonSyntaxException("Missing result, expected to find a string or object");
            ItemStack itemstack;
            if (serializedRecipe.get("result").isJsonObject()) itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(serializedRecipe, "result"));
            else {
                String s1 = GsonHelper.getAsString(serializedRecipe, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                    return new IllegalStateException("Item: " + s1 + " does not exist");
                }));
            }
            float f = GsonHelper.getAsFloat(serializedRecipe, "experience", 0.0F);
            int i = GsonHelper.getAsInt(serializedRecipe, "cookingtime", 100);
            return new CopperSoulCampfireRecipe(id, s, ingredient, itemstack, f, i);
        }

        @Override
        public CopperSoulCampfireRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            String s = buf.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ItemStack itemstack = buf.readItem();
            float f = buf.readFloat();
            int i = buf.readVarInt();
            return new CopperSoulCampfireRecipe(id, s, ingredient, itemstack, f, i);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CopperSoulCampfireRecipe recipe){
            buf.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buf);
            buf.writeItem(recipe.result);
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.cookingTime);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        // unchecked - need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }
    }
}
