package com.beanbot.instrumentus.common.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModItemTiers {
    public static final Tier COPPER = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            175,
            5.0f,
            1.0f,
            8,
            () -> Ingredient.of(Items.COPPER_INGOT)
    );

    public static final Tier ENERGIZED = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            9.0F,
            4.0F,
            15,
            () -> Ingredient.of(ModItems.ENERGIZED_INGOT.get())

    );
}
