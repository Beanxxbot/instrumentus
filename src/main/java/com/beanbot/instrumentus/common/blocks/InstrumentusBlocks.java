package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.beanbot.instrumentus.common.blocks.CopperSoulCampfireBlock.litBlockEmission;

public class InstrumentusBlocks {

    public static final DeferredRegister.Blocks BLOCKS_REGISTER = DeferredRegister.createBlocks(Instrumentus.MODID);

    public static final DeferredHolder<Block, CopperSoulFlameLight> COPPER_SOUL_FLAME_LIGHT = BLOCKS_REGISTER
        .registerBlock("copper_soul_fire_flame", CopperSoulFlameLight::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK).noCollission().instabreak().lightLevel(e -> 14).sound(SoundType.METAL));
    public static final DeferredHolder<Block, CopperSoulCampfireBlock> COPPER_SOUL_CAMPFIRE = BLOCKS_REGISTER
        .registerBlock("copper_soul_campfire", CopperSoulCampfireBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).strength(2.0f).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion());
    public static final DeferredHolder<Block, Block> RAW_SOULCOPPER_BLOCK = BLOCKS_REGISTER
        .registerSimpleBlock("raw_soulcopper_block", BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15));
    public static final DeferredHolder<Block, Block> SOULCOPPER_BLOCK = BLOCKS_REGISTER
        .registerSimpleBlock("soulcopper_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15));
    public static final DeferredHolder<Block, CopperSoulTorchBlock> SOULCOPPER_TORCH = BLOCKS_REGISTER
        .registerBlock("copper_soul_torch", CopperSoulTorchBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD)); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final DeferredHolder<Block, CopperSoulWallTorchBlock> SOULCOPPER_WALL_TORCH = BLOCKS_REGISTER
        .registerBlock("copper_soul_wall_torch", CopperSoulWallTorchBlock::new,  BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD).overrideLootTable(SOULCOPPER_TORCH.get().getLootTable())); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final DeferredHolder<Block, LanternBlock> SOULCOPPER_LANTERN = BLOCKS_REGISTER
        .registerBlock("copper_soul_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.LANTERN).lightLevel(e -> 15).noOcclusion());
    public static final DeferredHolder<Block, Block> CUT_SOULCOPPER = BLOCKS_REGISTER
        .registerSimpleBlock("cut_soulcopper", BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER));
    public static final DeferredHolder<Block, StairBlock> CUT_SOULCOPPER_STAIRS = BLOCKS_REGISTER
        .registerBlock("cut_soulcopper_stairs", properties -> new StairBlock(CUT_SOULCOPPER.get().defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_STAIRS));
    public static final DeferredHolder<Block, SlabBlock> CUT_SOULCOPPER_SLAB = BLOCKS_REGISTER
        .registerBlock("soulcopper_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_SLAB));
    public static final DeferredHolder<Block, Block> SOULCOPPER_GRATE = BLOCKS_REGISTER
        .registerSimpleBlock("soulcopper_grate", BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE));
    public static final DeferredHolder<Block, DoorBlock> SOULCOPPER_DOOR = BLOCKS_REGISTER
        .registerBlock("soulcopper_door", properties -> new DoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR));
    public static final DeferredHolder<Block, TrapDoorBlock> SOULCOPPER_TRAPDOOR = BLOCKS_REGISTER
        .registerBlock("soulcopper_trapdoor", properties -> new TrapDoorBlock(BlockSetType.COPPER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_TRAPDOOR));
    public static final DeferredHolder<Block, Block> CHISELED_SOULCOPPER = BLOCKS_REGISTER
        .registerSimpleBlock("chiseled_soulcopper", BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_COPPER));
    public static final DeferredHolder<Block, Block> SOULCOPPER_BULB = BLOCKS_REGISTER
        .registerSimpleBlock("soulcopper_bulb", BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE));
    public static final DeferredHolder<Block, Block> ENERGIZED_BLOCK = BLOCKS_REGISTER
        .registerSimpleBlock("energy_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).destroyTime(5.0f).explosionResistance(6.0f).sound(SoundType.METAL).lightLevel(e -> 4));
    public static final DeferredHolder<Block, KilnBlock> KILN = BLOCKS_REGISTER
        .registerBlock("kiln", KilnBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE));
    public static final DeferredHolder<Block, WindBlowerBlock> WIND_BLOWER = BLOCKS_REGISTER
        .registerBlock("wind_blower", WindBlowerBlock::new, BlockBehaviour.Properties.of().sound(SoundType.POLISHED_TUFF).strength(2.0f).noOcclusion());
}
