package com.beanbot.instrumentus.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

//TODO: Fix 1.20.5
public class CopperSoulCampfireRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected int cookingTime;

    public CopperSoulCampfireRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result, int cookingTime) {
        this.id = id;
        this.ingredient = ingredient;
        this.result = result;
        this.cookingTime = cookingTime;
    }

    public boolean matches(Container pInv, Level pLevel) {
        return this.ingredient.test(pInv.getItem(0));
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get();
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.SOUL_CAMPFIRE);
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.COPPER_SOUL_CAMPFIRE_COOKING_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<CopperSoulCampfireRecipe> {

        private static final ResourceLocation NAME = new ResourceLocation(Instrumentus.MODID, "copper_soul_campfire_cooking");
        private static final Codec<CopperSoulCampfireRecipe> CODEC = RecordCodecBuilder.create(
                p_311734_ -> p_311734_.group(
                        ResourceLocation.CODEC.fieldOf("id").forGetter(p_301134_ -> p_301134_.id),
                        Ingredient.CODEC.fieldOf("ingredient").forGetter(p_301135_ -> p_301135_.ingredient),
                        ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(p_301136_ -> p_301136_.result),
                        Codec.INT.fieldOf("cookingTime").forGetter(p_301137_ -> p_301137_.cookingTime)
                )
                        .apply(p_311734_, CopperSoulCampfireRecipe::new)
        );

        @Override
        public Codec<CopperSoulCampfireRecipe> codec() {
            return CODEC;
        }

        @Override
        public CopperSoulCampfireRecipe fromNetwork(FriendlyByteBuf buf) {
            ResourceLocation resourceLocation = buf.readResourceLocation();
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ItemStack result = buf.readItem();
            int cookingTime = buf.readVarInt();

            return new CopperSoulCampfireRecipe(resourceLocation, ingredient, result, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CopperSoulCampfireRecipe recipe){
            buf.writeResourceLocation(recipe.id);
            recipe.ingredient.toNetwork(buf);
            buf.writeItem(recipe.result);
            buf.writeVarInt(recipe.cookingTime);
        }
    }
}
