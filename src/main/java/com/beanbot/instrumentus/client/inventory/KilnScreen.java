package com.beanbot.instrumentus.client.inventory;

import com.beanbot.instrumentus.client.inventory.recipebook.FiringRecipeBookComponent;
import com.beanbot.instrumentus.client.inventory.recipebook.categories.InstrumentusRecipeBookCategories;
import com.beanbot.instrumentus.common.inventory.KilnMenu;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;

import java.util.List;

public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");
    private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/furnace.png");
    private static final Component FILTER_NAME = Component.translatable("instrumentus.gui.recipebook.toggleRecipes.kiln");

    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(
            new RecipeBookComponent.TabInfo((SearchRecipeBookCategory) InstrumentusRecipeBookCategories.FIRING_SEARCH),
            new RecipeBookComponent.TabInfo(Items.GLASS, InstrumentusRecipeBookCategories.FIRING_BLOCKS.get()),
            new RecipeBookComponent.TabInfo(Items.BRICK, InstrumentusRecipeBookCategories.FIRING_MISC.get())
    );

    public KilnScreen(KilnMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, FILTER_NAME, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE, TABS);
    }
}
