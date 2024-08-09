package com.beanbot.instrumentus.recipe;

import com.beanbot.instrumentus.common.Instrumentus;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class CopperSoulCampfireRecipe implements Recipe<SingleRecipeInput> {
    private final ResourceLocation id;
    public final ItemStack input;
    public final ItemStack result;
    public int cookingTime;

    public CopperSoulCampfireRecipe(ResourceLocation id, ItemStack input, ItemStack result, int cookingTime) {
        this.id = id;
        this.input = input;
        this.result = result;
        this.cookingTime = cookingTime;
    }

    public boolean matches(SingleRecipeInput pInput, Level pLevel) {
        return this.input.is(pInput.item().getItem());
    }

    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput pInput, HolderLookup.Provider holderProvider) {
        return this.result.copy();
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
    public ItemStack getResultItem(HolderLookup.Provider holderProvider) {
        return this.result;
    }

//    @Override
//    public NonNullList<Ingredient> getIngredients() {
//        NonNullList<Ingredient> nonnulllist = NonNullList.create();
//        nonnulllist.add(this.input);
//        return nonnulllist;
//    }

    public ItemStack getInput() {
        return input;
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

        private static final net.minecraft.resources.ResourceLocation NAME = ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "copper_soul_campfire_cooking");

        private static final MapCodec<CopperSoulCampfireRecipe> CODEC = RecordCodecBuilder.mapCodec(
                map -> map.group(
                        ResourceLocation.CODEC.fieldOf("id").forGetter(idField -> idField.id),
                        ItemStack.STRICT_CODEC.fieldOf("input").forGetter(inputField -> inputField.input),
                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter(resultField -> resultField.result),
                        Codec.INT.fieldOf("cookingTime").forGetter(cookingTimeField -> cookingTimeField.cookingTime)
                )
                        .apply(map, CopperSoulCampfireRecipe::new)
        );

        private final StreamCodec<RegistryFriendlyByteBuf, CopperSoulCampfireRecipe> STREAM_CODEC = StreamCodec.of(this::toNetwork, this::fromNetwork);

        @Override
        public MapCodec<CopperSoulCampfireRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CopperSoulCampfireRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        public CopperSoulCampfireRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            ResourceLocation resourceLocation = buf.readResourceLocation();
            ItemStack input = ItemStack.STREAM_CODEC.decode(buf);
            ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
            int cookingTime = buf.readVarInt();

            return new CopperSoulCampfireRecipe(resourceLocation, input, result, cookingTime);
        }

        public void toNetwork(RegistryFriendlyByteBuf buf, CopperSoulCampfireRecipe recipe){
            buf.writeResourceLocation(recipe.id);
            ItemStack.STREAM_CODEC.encode(buf, recipe.input);
            ItemStack.STREAM_CODEC.encode(buf, recipe.result);
            buf.writeVarInt(recipe.cookingTime);
        }
    }
}
