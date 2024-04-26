package com.beanbot.instrumentus.common.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

//TODO: Fix 1.20.5
public class ModItemTiers {
    public static final Tier COPPER = new SimpleTier(
            2,
            750,
            5.0f,
            1.5f,
            14,
            BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(Items.COPPER_INGOT)
    );
}
