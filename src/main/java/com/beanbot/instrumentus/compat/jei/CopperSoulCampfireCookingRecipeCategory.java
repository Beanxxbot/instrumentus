package com.beanbot.instrumentus.compat.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.recipe.CopperSoulCampfireRecipe;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CopperSoulCampfireCookingRecipeCategory implements IRecipeCategory<CopperSoulCampfireRecipe> {

    public static final RecipeType<CopperSoulCampfireRecipe> TYPE = RecipeType.create(Instrumentus.MODID, "copper_soul_campfire_cooking", CopperSoulCampfireRecipe.class);

    private final IDrawable icon;
    private final Component localizedName;
    protected final IGuiHelper guiHelper;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected int regularCookTime;

    public CopperSoulCampfireCookingRecipeCategory(IGuiHelper guiHelper) {
        icon = guiHelper.createDrawableItemStack(new ItemStack(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get()));
        localizedName = Component.translatable("instrumentus.coppersoulcampfirecookingrecipe.title");
        staticFlame = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png"), 82, 114, 14, 14);
        animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.guiHelper = guiHelper;
        regularCookTime = 1200;
    }

    @Override
    public RecipeType<CopperSoulCampfireRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public final int getWidth() {
        return 82;
    }

    @Override
    public final int getHeight() {
        return 44;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    protected void addCookTime(IRecipeExtrasBuilder builder, CopperSoulCampfireRecipe recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            builder.addText(timeString, getWidth() - 20, 10)
                    .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM)
                    .setTextAlignment(HorizontalAlignment.RIGHT)
                    .setTextAlignment(VerticalAlignment.BOTTOM)
                    .setColor(0xFF808080);
        }
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CopperSoulCampfireRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .setStandardSlotBackground()
                .addIngredients(recipe.input);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .setStandardSlotBackground()
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder acceptor, CopperSoulCampfireRecipe recipe, IFocusGroup focuses) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        acceptor.addAnimatedRecipeArrow(cookTime)
                .setPosition(26, 7);
        acceptor.addAnimatedRecipeFlame(300)
                .setPosition(1, 20);

        addCookTime(acceptor, recipe);
    }

    @Override
    public ResourceLocation getRegistryName(CopperSoulCampfireRecipe recipe) {
        return recipe.getId();
    }
}
