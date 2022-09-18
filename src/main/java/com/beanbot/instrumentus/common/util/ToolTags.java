package com.beanbot.instrumentus.common.util;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ToolTags {

    public static void init(){
        Blocks.init();
    }

    private ToolTags(){}

    public static class Blocks {
        private static void init(){}

        private Blocks() {
        }

        public static final TagKey<Block> MINEABLE_WITH_PAXEL = tag("mineable/paxel");

        private static TagKey tag(String name){
            return BlockTags.create(new ResourceLocation(Instrumentus.MODID, name));
        }
    }
}
