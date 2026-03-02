package com.beanbot.instrumentus.client.inventory;

import com.beanbot.instrumentus.client.inventory.recipebook.FiringRecipeBookComponent;
import com.beanbot.instrumentus.common.inventory.KilnMenu;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");
    private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/furnace.png");

    public KilnScreen(KilnMenu menu, Inventory playerInventory, Component title, Component recipeFilterName, List<RecipeBookComponent.TabInfo> tabInfos) {
        super(menu, playerInventory, recipeFilterName, title, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE, tabInfos);
    }
}
