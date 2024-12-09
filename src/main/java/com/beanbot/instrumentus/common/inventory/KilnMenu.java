package com.beanbot.instrumentus.common.inventory;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.recipe.InstrumentusRecipes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class KilnMenu extends AbstractFurnaceMenu {

    public static final ResourceKey<RecipePropertySet> FIRING_INPUT = ResourceKey.create(RecipePropertySet.TYPE_KEY, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "firing"));
    public KilnMenu(int containerId, Inventory playerInventory) {
        super(InstrumentusMenus.KILN_MENU.get(), InstrumentusRecipes.FIRING.get(), FIRING_INPUT, RecipeBookType.valueOf("INSTRUMENTUS_FIRING"), containerId, playerInventory);
    }

    public KilnMenu(int containerId, Inventory playerInventory, Container kilnContainer, ContainerData kilnData) {
        super(InstrumentusMenus.KILN_MENU.get(), InstrumentusRecipes.FIRING.get(), FIRING_INPUT,RecipeBookType.valueOf("INSTRUMENTUS_FIRING"), containerId, playerInventory, kilnContainer, kilnData);
    }
}
