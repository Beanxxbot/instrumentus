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

    public static final TagKey<Item> TOOLS_COMMON_KNIVES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/knives"));
    public static final TagKey<Item> TOOLS_KNIVES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "knives"));
    public static final TagKey<Item> TOOLS_SHEARS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/shears"));
    public static final TagKey<Item> TOOLS_SICKLES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/sickles"));
    public static final TagKey<Item> TOOLS_HAMMERS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/hammers"));
    public static final TagKey<Item> TOOLS_BRUSHES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/brushes"));
    public static final TagKey<Item> TOOLS_MINING_TOOLS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/mining_tools"));
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/copper_tool_materials"));
    public static final TagKey<Item> ENERGIZED_TOOL_MATERIALS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/energized_tool_materials"));
    public static final TagKey<Item> REPAIRS_BREEZE_ARMOR = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "tools/breeze_armor_materials"));


    public InstrumentusGeneratorItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags) {
        super(output, lookupProvider, blockTags.contentsGetter(), Instrumentus.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addToolEnchantments();

        for (var item : InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (item.get() instanceof KnifeItem knife) {
                tag(TOOLS_COMMON_KNIVES)
                        .add(knife);
                tag(TOOLS_KNIVES)
                        .add(knife);
            }
            else if (item.get() instanceof InstrumentusShearsItem shears) {
                tag(TOOLS_SHEARS)
                        .add(shears);
            }
            else if (item.get() instanceof SickleItem sickle) {
                tag(TOOLS_SICKLES)
                        .add(sickle);
            }
            else if (item.get() instanceof HammerItem hammer) {
                tag(TOOLS_HAMMERS)
                        .add(hammer);
                tag(TOOLS_MINING_TOOLS)
                        .add(hammer);
            }
            else if (item.get() instanceof InstrumentusBrushItem brush) {
                tag(TOOLS_BRUSHES)
                        .add(brush);
            }
            else if (item.get() instanceof PickaxeItem pickaxeItem) {
                tag(TOOLS_MINING_TOOLS)
                        .add(pickaxeItem);
            }
            else if (item.get() instanceof SoulcopperPickaxeItem pickaxeItem) {
                tag(TOOLS_MINING_TOOLS)
                        .add(pickaxeItem);
            }
        }

        tag(COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);

        tag(ENERGIZED_TOOL_MATERIALS)
                .add(InstrumentusItems.ENERGIZED_INGOT.get());
    }

    public void addToolEnchantments() {
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
                    if (diggerTool == InstrumentusItems.ENERGIZED_AXE.get() || diggerTool == InstrumentusItems.ENERGIZED_PAXEL.get()) {
                        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                                .add(diggerTool);
                    }
                } else if (diggerTool instanceof PaxelItem || diggerTool == InstrumentusItems.COPPER_AXE.get()) {
                    tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.MINING_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                            .add(diggerTool);
                    tag(ItemTags.DURABILITY_ENCHANTABLE)
                            .add(diggerTool);
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
