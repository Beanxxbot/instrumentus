package com.beanbot.instrumentus.common.inventory;

import com.beanbot.instrumentus.common.recipe.InstrumentusRecipes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class KilnMenu extends AbstractFurnaceMenu {
    public KilnMenu(int containerId, Inventory playerInventory) {
        super(InstrumentusMenus.KILN_MENU.get(), InstrumentusRecipes.FIRING.get(), RecipeBookType.valueOf("INSTRUMENTUS_FIRING"), containerId, playerInventory);
    }

    public KilnMenu(int containerId, Inventory playerInventory, Container kilnContainer, ContainerData kilnData) {
        super(InstrumentusMenus.KILN_MENU.get(), InstrumentusRecipes.FIRING.get(), RecipeBookType.valueOf("INSTRUMENTUS_FIRING"), containerId, playerInventory, kilnContainer, kilnData);
    }
}
