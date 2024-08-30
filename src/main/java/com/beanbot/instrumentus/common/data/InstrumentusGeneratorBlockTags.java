package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorBlockTags extends BlockTagsProvider {

    public static final TagKey<Block> MINEABLE_WITH_PAXEL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "mineable/paxel"));

    public InstrumentusGeneratorBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        //noinspection unchecked
        this.tag(MINEABLE_WITH_PAXEL)
            .addTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.ENERGIZED_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_LANTERN.get())
                .add(InstrumentusBlocks.KILN.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get())
                .add(InstrumentusBlocks.SOULCOPPER_BLOCK.get());

    }
}
