package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorItemTags extends ItemTagsProvider {

    public static final TagKey<Item> TOOLS_KNIVES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("instrumentus", "tools/knives"));
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "copper_tool_materials"));
    public static final TagKey<Item> ENERGIZED_TOOL_MATERIALS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "energized_tool_materials"));
    public static final TagKey<Item> REPAIRS_BREEZE_ARMOR = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "repairs_breeze_armor"));

    public InstrumentusGeneratorItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addTools();

        for (var knife : InstrumentusItems.KNIVES.getEntries()) {
            tag(TOOLS_KNIVES)
                    .add(knife.get());
        }
        tag(TOOLS_KNIVES)
                .add(InstrumentusItems.COPPER_KNIFE.get())
                .add(InstrumentusItems.ENERGIZED_KNIFE.get());

        tag(COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);

        tag(ENERGIZED_TOOL_MATERIALS)
                .add(InstrumentusItems.ENERGIZED_INGOT.get());

        tag(REPAIRS_BREEZE_ARMOR)
                .add(Items.BREEZE_ROD);
    }

    public void addTools() {
        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(InstrumentusItems.SOULCOPPER_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE)
                .add(InstrumentusItems.SOULCOPPER_PICKAXE.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(InstrumentusItems.SOULCOPPER_PICKAXE.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(InstrumentusItems.BREEZE_ARMOR_BOOTS.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(InstrumentusItems.BREEZE_ARMOR_BOOTS.get());

        for (var tool : InstrumentusItems.SHEARS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : InstrumentusItems.SICKLES.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : InstrumentusItems.PAXELS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : InstrumentusItems.HAMMERS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
        for (var tool : InstrumentusItems.KNIVES.getEntries()) {
            if (tool != InstrumentusItems.PLANT_FIBER) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(tool.get());
            }
        }
        for (var tool : InstrumentusItems.ENERGIZED.getEntries()) {
            if (tool != InstrumentusItems.ENERGIZED_INGOT || tool != InstrumentusItems.ENERGIZED_BLOCK || tool != InstrumentusItems.CARBON_ROD) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(tool.get());
                if (tool != InstrumentusItems.ENERGIZED_LIGHTNING_ROD) {
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(tool.get());
                    if (tool != InstrumentusItems.ENERGIZED_SHOVEL || tool != InstrumentusItems.ENERGIZED_KNIFE || tool != InstrumentusItems.ENERGIZED_SHEARS || tool != InstrumentusItems.ENERGIZED_EXCAVATOR) {
                        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                                .add(tool.get());
                    }
                }
            }
        }
        for (var tool : InstrumentusItems.COPPER.getEntries()) {
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
            if (tool != InstrumentusItems.COPPER_SWORD) {
                tag(ItemTags.MINING_ENCHANTABLE)
                        .add(tool.get());
                if (tool != InstrumentusItems.COPPER_SHOVEL || tool != InstrumentusItems.COPPER_KNIFE || tool != InstrumentusItems.COPPER_SHEARS || tool != InstrumentusItems.COPPER_EXCAVATOR) {
                    tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                            .add(tool.get());
                }
            } else {
                tag(ItemTags.SWORD_ENCHANTABLE)
                        .add(tool.get());
            }
        }
        for (var tool : InstrumentusItems.EXCAVATORS.getEntries()) {
            tag(ItemTags.MINING_ENCHANTABLE)
                    .add(tool.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE)
                    .add(tool.get());
        }
    }
}
