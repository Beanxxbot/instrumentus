package com.beanbot.instrumentus.client.inventory.recipebook;

import net.minecraft.client.gui.screens.recipebook.FurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractFurnaceMenu;

import java.util.List;

public class FiringRecipeBookComponent extends FurnaceRecipeBookComponent {
    private static final Component FILTER_NAME = Component.translatable("instrumentus.recipebook.toggleRecipes.fireable");

    public FiringRecipeBookComponent(AbstractFurnaceMenu menu, Component recipeFilterName, List<TabInfo> tabInfos) {
        super(menu, recipeFilterName, tabInfos);
    }

    @Override
    protected Component getRecipeFilterName() {
        return FILTER_NAME;
    }
}
