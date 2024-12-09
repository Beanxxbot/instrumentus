package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.*;
import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorItemTags extends ItemTagsProvider {

    public static final TagKey<Item> TOOLS_KNIVES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("instrumentus", "tools/knives"));

    public InstrumentusGeneratorItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addTools();

        for (var knife : InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (knife.get() instanceof KnifeItem) {
                tag(TOOLS_KNIVES)
                        .add(knife.get());
            }
        }
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

        for (var tool : InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (tool.get() instanceof DiggerItem diggerTool) {
                if (diggerTool instanceof ExcavatorItem || diggerTool instanceof ShovelItem) {
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.DURABILITY_ENCHANTABLE)
                            .add(diggerTool);
                } else if (diggerTool instanceof IEnergyItem) {
                    tag(ItemTags.DURABILITY_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(diggerTool);
                    if (diggerTool != InstrumentusItems.ENERGIZED_SHOVEL.get()) {
                        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                                .add(diggerTool);
                    }
                } else {
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.DURABILITY_ENCHANTABLE)
                            .add(diggerTool);
                }
            } else if (tool.get() instanceof ShearsItem shearsTool) {
                tag(ItemTags.MINING_ENCHANTABLE)
                        .add(shearsTool);
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(shearsTool);
            } else if (tool.get() instanceof KnifeItem knifeTool) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(knifeTool);
            } else if (tool.get() instanceof SwordItem swordTool) {
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .add(swordTool);
                tag(ItemTags.SWORD_ENCHANTABLE)
                        .add(swordTool);
            }
        }
    }
}
