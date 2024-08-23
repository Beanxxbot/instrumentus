package com.beanbot.instrumentus.client.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.recipe.KilnRecipe;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.gui.widgets.IRecipeWidget;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class FiringRecipeCategory implements IRecipeCategory<KilnRecipe> {
    public static final RecipeType<KilnRecipe> TYPE = RecipeType.create(Instrumentus.MODID, "firing", KilnRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;
    protected final IGuiHelper guiHelper;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected int regularCookTime;

    public FiringRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png"), 0, 186, 82, 34)
                .addPadding(0, 10, 0, 0)
                .build();
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
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(KilnRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        animatedFlame.draw(guiGraphics, 1, 20);

        drawCookTime(recipe, guiGraphics, 35);
    }

    protected void drawCookTime(KilnRecipe recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, KilnRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addIngredients(recipe.input);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .addItemStack(recipe.result);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder acceptor, KilnRecipe recipe, IFocusGroup focuses) {
        acceptor.addWidget(createCookingArrowWidget(recipe, new ScreenPosition(24, 8)));
    }

    @Override
    public ResourceLocation getRegistryName(KilnRecipe recipe) {
        return ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, recipe.result.getItem().getDefaultInstance().getHoverName().getString().toLowerCase().replaceAll(" ", "_") + "_firing");
    }

    protected IRecipeWidget createCookingArrowWidget(KilnRecipe recipe, ScreenPosition position) {
        return new FiringRecipeCategory.CookingArrowRecipeWidget<>(guiHelper, recipe, regularCookTime, position);
    }

    private static class CookingArrowRecipeWidget<KilnRecipe> implements IRecipeWidget {
        private final IDrawableAnimated arrow;
        private final ScreenPosition position;

        public CookingArrowRecipeWidget(IGuiHelper guiHelper, com.beanbot.instrumentus.common.recipe.KilnRecipe recipe, int regularCookTime, ScreenPosition position) {
            int cookTime = recipe.getCookingTime();
            if (cookTime <= 0) {
                cookTime = regularCookTime;
            }
            this.arrow = guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png"), 82, 128, 24, 17)
                    .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            this.position = position;
        }

        @Override
        public ScreenPosition getPosition() {
            return position;
        }

        @Override
        public void draw(GuiGraphics guiGraphics, double mouseX, double mouseY) {
            arrow.draw(guiGraphics);
        }
    }
}
