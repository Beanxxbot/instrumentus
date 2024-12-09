package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InstrumentusBlocks {

    public static final DeferredRegister.Blocks BLOCKS_REGISTER = DeferredRegister.createBlocks(Instrumentus.MODID);

    public static final DeferredHolder<Block, CopperSoulFlameLight> COPPER_SOUL_FLAME_LIGHT = BLOCKS_REGISTER.register("copper_soul_fire_flame", CopperSoulFlameLight::new);
    public static final DeferredHolder<Block, CopperSoulCampfireBlock> COPPER_SOUL_CAMPFIRE = BLOCKS_REGISTER.register("copper_soul_campfire", CopperSoulCampfireBlock::new);
    public static final DeferredHolder<Block, Block> RAW_SOULCOPPER_BLOCK = BLOCKS_REGISTER.register("raw_soulcopper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15)));
    public static final DeferredHolder<Block, Block> SOULCOPPER_BLOCK = BLOCKS_REGISTER.register("soulcopper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15)));
    public static final DeferredHolder<Block, CopperSoulTorchBlock> SOULCOPPER_TORCH = BLOCKS_REGISTER.register("copper_soul_torch", () -> new CopperSoulTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD))); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final DeferredHolder<Block, CopperSoulWallTorchBlock> SOULCOPPER_WALL_TORCH = BLOCKS_REGISTER.register("copper_soul_wall_torch", () -> new CopperSoulWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD).lootFrom(SOULCOPPER_TORCH))); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get()
    public static final DeferredHolder<Block, LanternBlock> SOULCOPPER_LANTERN = BLOCKS_REGISTER.register("copper_soul_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.LANTERN).lightLevel(e -> 15).noOcclusion()));
    public static final DeferredHolder<Block, Block> CUT_SOULCOPPER = BLOCKS_REGISTER.register("cut_soulcopper", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)));
    public static final DeferredHolder<Block, Block> SOULCOPPER_GRATE = BLOCKS_REGISTER.register("soulcopper_grate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)));
    public static final DeferredHolder<Block, DoorBlock> SOULCOPPER_DOOR = BLOCKS_REGISTER.register("soulcopper_door", () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR)));
    public static final DeferredHolder<Block, TrapDoorBlock> SOULCOPPER_TRAPDOOR = BLOCKS_REGISTER.register("soulcopper_trapdoor", () -> new TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_TRAPDOOR)));

    public static final DeferredHolder<Block, Block> ENERGIZED_BLOCK = BLOCKS_REGISTER.register("energy_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).destroyTime(5.0f).explosionResistance(6.0f).sound(SoundType.METAL).lightLevel(e -> 4)));
    public static final DeferredHolder<Block, KilnBlock> KILN = BLOCKS_REGISTER.register("kiln", () -> new KilnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)));
    public static final DeferredHolder<Block, WindBlowerBlock> WIND_BLOWER = BLOCKS_REGISTER.register("wind_blower", WindBlowerBlock::new);
}
