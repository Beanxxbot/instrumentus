package com.beanbot.instrumentus.common.recipe;

import com.beanbot.instrumentus.client.inventory.recipebook.categories.InstrumentusRecipeBookCategories;
import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.FurnaceRecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CopperSoulCampfireRecipe implements Recipe<SingleRecipeInput> {
    protected final ResourceLocation id;
    public final Ingredient input;
    public final ItemStack result;
    public int cookingTime;
    public PlacementInfo placementInfo;

    public CopperSoulCampfireRecipe(ResourceLocation id, Ingredient input, ItemStack result, int cookingTime) {
        this.id = id;
        this.input = input;
        this.result = result;
        this.cookingTime = cookingTime;
    }

    public boolean matches(SingleRecipeInput input, Level level) {
        return this.input.test(input.item());
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public Ingredient input() { return this.input; }

    public ItemStack result() { return this.result; }

    @Override
    public ItemStack assemble(SingleRecipeInput pInput, HolderLookup.Provider holderProvider) {
        return this.result.copy();
    }

    @Override
    public RecipeType<? extends CopperSoulCampfireRecipe> getType() {
        return InstrumentusRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(this.input);
        }
        return this.placementInfo;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return InstrumentusRecipeBookCategories.COPPER_SOUL_CAMPFIRE_COOKING.get();
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(
            new FurnaceRecipeDisplay(
                this.input.display(),
                    SlotDisplay.AnyFuel.INSTANCE,
                    new SlotDisplay.ItemStackSlotDisplay(this.result()),
                    new SlotDisplay.ItemSlotDisplay(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get().asItem()),
                    this.cookingTime,
                    0
            )
        );
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeSerializer<? extends CopperSoulCampfireRecipe> getSerializer() {
        return InstrumentusRecipes.COPPER_SOUL_CAMPFIRE_COOKING_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<CopperSoulCampfireRecipe> {
        private static final MapCodec<CopperSoulCampfireRecipe> CODEC = RecordCodecBuilder.mapCodec(
                map -> map.group(
                                ResourceLocation.CODEC.fieldOf("id").forGetter(idField -> idField.id),
                                Ingredient.CODEC.fieldOf("input").forGetter(inputField -> inputField.input),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(resultField -> resultField.result),
                                Codec.INT.fieldOf("cookingTime").forGetter(cookingTimeField -> cookingTimeField.cookingTime)
                        )
                        .apply(map, CopperSoulCampfireRecipe::new)
        );;
        private final StreamCodec<RegistryFriendlyByteBuf, CopperSoulCampfireRecipe> STREAM_CODEC = StreamCodec.composite(
                ResourceLocation.STREAM_CODEC,
                rl -> rl.id,
                Ingredient.CONTENTS_STREAM_CODEC,
                input -> input.input,
                ItemStack.STREAM_CODEC,
                result -> result.result,
                ByteBufCodecs.INT,
                cookTime -> cookTime.cookingTime,
                CopperSoulCampfireRecipe::new
        );

        @Override
        public MapCodec<CopperSoulCampfireRecipe> codec() { return CODEC; }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CopperSoulCampfireRecipe> streamCodec() { return STREAM_CODEC; }
    }
}
