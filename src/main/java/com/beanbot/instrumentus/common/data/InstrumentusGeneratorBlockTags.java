package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorBlockTags extends BlockTagsProvider {

    public static final TagKey<Block> MINEABLE_WITH_PAXEL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "mineable/paxel"));
    public static final TagKey<Block> CAN_BE_OXIDIZED = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "burnerable/canoxidize"));
    public static final TagKey<Block> CLEAN_COPPER = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "burnerable/canoxidize"));
    public static final TagKey<Block> EXPOSED_COPPER = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "burnerable/canoxidize"));
    public static final TagKey<Block> WEATHERED_COPPER = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "burnerable/canoxidize"));


    public InstrumentusGeneratorBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        //noinspection unchecked
        this.tag(MINEABLE_WITH_PAXEL)
            .addTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_SHOVEL);
        this.tag(CLEAN_COPPER)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.COPPER_BULB)
                .add(Blocks.CHISELED_COPPER)
                .add(Blocks.COPPER_GRATE)
                .add(Blocks.COPPER_DOOR)
                .add(Blocks.COPPER_TRAPDOOR)
                .add(Blocks.CUT_COPPER_SLAB)
                .add(Blocks.CUT_COPPER_STAIRS)
                .add(Blocks.CUT_COPPER);
        this.tag(EXPOSED_COPPER)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.EXPOSED_COPPER_BULB)
                .add(Blocks.EXPOSED_CHISELED_COPPER)
                .add(Blocks.EXPOSED_COPPER_GRATE)
                .add(Blocks.EXPOSED_COPPER_DOOR)
                .add(Blocks.EXPOSED_COPPER_TRAPDOOR)
                .add(Blocks.EXPOSED_CUT_COPPER_SLAB)
                .add(Blocks.EXPOSED_CUT_COPPER_STAIRS)
                .add(Blocks.EXPOSED_CUT_COPPER);
        this.tag(WEATHERED_COPPER)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.WEATHERED_COPPER_BULB)
                .add(Blocks.WEATHERED_CHISELED_COPPER)
                .add(Blocks.WEATHERED_COPPER_GRATE)
                .add(Blocks.WEATHERED_COPPER_DOOR)
                .add(Blocks.WEATHERED_COPPER_TRAPDOOR)
                .add(Blocks.WEATHERED_CUT_COPPER_SLAB)
                .add(Blocks.WEATHERED_CUT_COPPER_STAIRS)
                .add(Blocks.WEATHERED_CUT_COPPER);
        //noinspection unchecked
        this.tag(CAN_BE_OXIDIZED)
                .addTags(CLEAN_COPPER, EXPOSED_COPPER, WEATHERED_COPPER);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.ENERGIZED_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_LANTERN.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_BLOCK.get());

    }
}
