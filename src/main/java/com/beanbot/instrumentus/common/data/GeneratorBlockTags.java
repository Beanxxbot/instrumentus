package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class GeneratorBlockTags extends BlockTagsProvider {

    public static final TagKey<Block> MINEABLE_WITH_PAXEL = BlockTags.create(new ResourceLocation("forge", "mineable/paxel"));
    public GeneratorBlockTags(DataGenerator generator, @Nullable ExistingFileHelper helper) {
        super(generator, Instrumentus.MODID, helper);
    }

    @Override
    protected void addTags(){
        this.tag(MINEABLE_WITH_PAXEL).addTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_SHOVEL);
    }
}
