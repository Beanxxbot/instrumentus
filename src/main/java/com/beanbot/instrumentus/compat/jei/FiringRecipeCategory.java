package com.beanbot.instrumentus.compat.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.recipe.KilnRecipe;
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

public class FiringRecipeCategory implements IRecipeCategory<KilnRecipe> {
    public static final RecipeType<KilnRecipe> TYPE = RecipeType.create(Instrumentus.MODID, "firing", KilnRecipe.class);

    private final IDrawable icon;
    private final Component localizedName;
    protected final IGuiHelper guiHelper;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected int regularCookTime;

    public FiringRecipeCategory(IGuiHelper guiHelper) {
        icon = guiHelper.createDrawableItemStack(new ItemStack(InstrumentusBlocks.KILN.get()));
        localizedName = Component.translatable("instrumentus.container.kiln");
        staticFlame = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png"), 82, 114, 14, 14);
        animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.guiHelper = guiHelper;
        regularCookTime = 1200;
    }

    @Override
    public RecipeType<KilnRecipe> getRecipeType() {
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
        return 54;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, KilnRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .setStandardSlotBackground()
                .addIngredients(recipe.input);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 1, 37)
                .setStandardSlotBackground();
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 19)
                .setOutputSlotBackground()
                .addItemStack(recipe.result);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, KilnRecipe recipe, IFocusGroup focuses) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        builder.addAnimatedRecipeArrow(cookTime)
                .setPosition(26, 17);
        builder.addAnimatedRecipeFlame(cookTime)
                .setPosition(1, 20);

        addExperience(builder, recipe);
        addCookTime(builder, recipe);
    }

    protected void addExperience(IRecipeExtrasBuilder builder, KilnRecipe recipe) {
        float experience = recipe.getExperience();
        if (experience > 0) {
            Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            builder.addText(experienceString, getWidth() - 20, 10)
                    .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.RIGHT, VerticalAlignment.TOP)
                    .setTextAlignment(HorizontalAlignment.RIGHT)
                    .setColor(0xFF808080);
        }
    }

    protected void addCookTime(IRecipeExtrasBuilder builder, KilnRecipe recipe) {
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
    public ResourceLocation getRegistryName(KilnRecipe recipe) {
        return ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, recipe.result.getItem().getDefaultInstance().getHoverName().getString().toLowerCase().replaceAll(" ", "_") + "_firing");
    }
}
