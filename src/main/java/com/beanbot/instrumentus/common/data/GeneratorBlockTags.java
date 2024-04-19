package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GeneratorBlockTags extends BlockTagsProvider {

    public static final TagKey<Block> MINEABLE_WITH_PAXEL = BlockTags.create(new ResourceLocation("forge", "mineable/paxel"));
    public GeneratorBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MINEABLE_WITH_PAXEL).addTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_SHOVEL);

    }
}
