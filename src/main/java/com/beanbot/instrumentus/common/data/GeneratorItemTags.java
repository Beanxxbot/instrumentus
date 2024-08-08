package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.CompletableFuture;

public class GeneratorItemTags extends ItemTagsProvider {

    public GeneratorItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addTools();
    }

    public void addTools() {
        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.SOULCOPPER_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.SOULCOPPER_PICKAXE.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.SOULCOPPER_PICKAXE.get());

        for (var tool : ModItems.SHEARS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : ModItems.SICKLES.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : ModItems.PAXELS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : ModItems.HAMMERS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : ModItems.KNIVES.getEntries()) {
            if (tool != ModItems.PLANT_FIBER) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(tool.get());
            }
        }
        for (var tool : ModItems.ENERGIZED.getEntries()) {
            if (tool != ModItems.ENERGIZED_INGOT || tool != ModItems.ENERGIZED_BLOCK || tool != ModItems.CARBON_ROD) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(tool.get());
                if (tool != ModItems.ENERGIZED_LIGHTNING_ROD) {
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(tool.get());
                    if (tool != ModItems.ENERGIZED_SHOVEL || tool != ModItems.ENERGIZED_KNIFE || tool != ModItems.ENERGIZED_SHEARS) {
                        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                                .add(tool.get());
                    }
                }
            }
        }
        for (var tool : ModItems.COPPER.getEntries()) {
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
            if (tool != ModItems.COPPER_SWORD) {
                tag(ItemTags.MINING_ENCHANTABLE)
                        .add(tool.get());
                if (tool != ModItems.COPPER_SHOVEL || tool != ModItems.COPPER_KNIFE || tool != ModItems.COPPER_SHEARS) {
                    tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                            .add(tool.get());
                }
            } else {
                tag(ItemTags.SWORD_ENCHANTABLE)
                        .add(tool.get());
            }
        }
    }
}
