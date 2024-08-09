package com.beanbot.instrumentus.client.jei;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
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
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Arrays;

public class CopperSoulCampfireCookingRecipeCategory implements IRecipeCategory<CopperSoulCampfireRecipe> {
    public static final RecipeType<CopperSoulCampfireRecipe> TYPE = RecipeType.create(Instrumentus.MODID, "copper_soul_campfire_cooking", CopperSoulCampfireRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;
    protected final IGuiHelper guiHelper;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected int regularCookTime;

    public CopperSoulCampfireCookingRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png"), 0, 186, 82, 34)
                .addPadding(0, 10, 0, 0)
                .build();
        icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.COPPER_SOUL_CAMPFIRE.get()));
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
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(CopperSoulCampfireRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        animatedFlame.draw(guiGraphics, 1, 20);

        drawCookTime(recipe, guiGraphics, 45);
    }

    protected void drawCookTime(CopperSoulCampfireRecipe recipe, GuiGraphics guiGraphics, int y) {
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
    public void setRecipe(IRecipeLayoutBuilder builder, CopperSoulCampfireRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 0, 0)
            .addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 8)
            .addItemStack(getResultItem(recipe));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder acceptor, CopperSoulCampfireRecipe recipe, IFocusGroup focuses) {
        acceptor.addWidget(createCookingArrowWidget(recipe, new ScreenPosition(24, 18)));
    }

    @Override
    public boolean isHandled(CopperSoulCampfireRecipe recipe) {
        return !recipe.isSpecial();
    }

    @Override
    public ResourceLocation getRegistryName(CopperSoulCampfireRecipe recipe) {
        return recipe.getId();
    }

    public static ItemStack getResultItem(Recipe<?> recipe) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) {
            throw new NullPointerException("level must not be null.");
        }
        RegistryAccess registryAccess = level.registryAccess();
        return recipe.getResultItem(registryAccess);
    }

    protected IRecipeWidget createCookingArrowWidget(CopperSoulCampfireRecipe recipe, ScreenPosition position) {
        return new CookingArrowRecipeWidget<>(guiHelper, recipe, regularCookTime, position);
    }

    private static class CookingArrowRecipeWidget<CopperSoulCampfireRecipe> implements IRecipeWidget {
        private final IDrawableAnimated arrow;
        private final ScreenPosition position;

        public CookingArrowRecipeWidget(IGuiHelper guiHelper, com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe recipe, int regularCookTime, ScreenPosition position) {
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
