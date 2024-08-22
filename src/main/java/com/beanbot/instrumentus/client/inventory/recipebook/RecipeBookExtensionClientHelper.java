package com.beanbot.instrumentus.client.inventory.recipebook;

import com.beanbot.instrumentus.common.recipe.ModRecipes;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

import java.util.List;
import java.util.function.Supplier;

public class RecipeBookExtensionClientHelper {
    @SuppressWarnings("unused")
    public static final EnumProxy<RecipeBookCategories> FIRING_SEARCH_ENUM_PARAMS = new EnumProxy<>(
        RecipeBookCategories.class,
            (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS)));
    @SuppressWarnings("unused")
    public static final EnumProxy<RecipeBookCategories> FIRING_BLOCKS_ENUM_PARAMS = new EnumProxy<>(
        RecipeBookCategories.class,
            (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Blocks.GLASS)));
    @SuppressWarnings("unused")
    public static final EnumProxy<RecipeBookCategories> FIRING_MISC_ENUM_PARAMS = new EnumProxy<>(
    RecipeBookCategories.class,
            (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.BRICK)));

    public static final Supplier<RecipeBookCategories> FIRING_CATEGORY_SEARCH = Suppliers.memoize(FIRING_SEARCH_ENUM_PARAMS::getValue);
    public static final Supplier<RecipeBookCategories> FIRING_CATEGORY_BLOCKS = Suppliers.memoize(FIRING_BLOCKS_ENUM_PARAMS::getValue);
    public static final Supplier<RecipeBookCategories> FIRING_CATEGORY_MISC = Suppliers.memoize(FIRING_MISC_ENUM_PARAMS::getValue);

    public static void init(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(RecipeBookType.valueOf("INSTRUMENTUS_FIRING"), ImmutableList.of(FIRING_CATEGORY_SEARCH.get(), FIRING_CATEGORY_BLOCKS.get(), FIRING_CATEGORY_MISC.get()));
        event.registerAggregateCategory(FIRING_CATEGORY_SEARCH.get(), ImmutableList.of(FIRING_CATEGORY_BLOCKS.get(), FIRING_CATEGORY_MISC.get()));
        event.registerRecipeCategoryFinder(ModRecipes.FIRING.get(), r -> {
            if(r.value().getResultItem(Minecraft.getInstance().level.registryAccess()).getItem() instanceof BlockItem) {
                return FIRING_CATEGORY_BLOCKS.get();
            } else {
                return FIRING_CATEGORY_MISC.get();
            }
        });
    }
}
