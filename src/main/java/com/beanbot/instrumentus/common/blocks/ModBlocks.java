package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> SOULCOPPER = DeferredRegister.create(BuiltInRegistries.BLOCK, Instrumentus.MODID);
    public static final DeferredRegister<Block> ENERGIZED = DeferredRegister.create(BuiltInRegistries.BLOCK, Instrumentus.MODID);

    public static final Supplier<Block> COPPER_SOUL_FLAME_LIGHT = SOULCOPPER.register("copper_soul_fire_flame", () -> new CopperSoulFlameLight());
    public static final Supplier<Block> COPPER_SOUL_CAMPFIRE = SOULCOPPER.register("copper_soul_campfire", () -> new CopperSoulCampfireBlock());
    public static final Supplier<Block> RAW_SOULCOPPER_BLOCK = SOULCOPPER.register("raw_soulcopper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15)));
    public static final Supplier<Block> SOULCOPPER_BLOCK = SOULCOPPER.register("soulcopper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).lightLevel(e -> 15)));
    public static final Supplier<Block> SOULCOPPER_TORCH = SOULCOPPER.register("copper_soul_torch", () -> new CopperSoulTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD))); //(SimpleParticleType)ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final Supplier<Block> SOULCOPPER_WALL_TORCH = SOULCOPPER.register("copper_soul_wall_torch", () -> new CopperSoulWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).noCollission().instabreak().lightLevel(e -> 15).sound(SoundType.WOOD).dropsLike(SOULCOPPER_TORCH.get()))); //(SimpleParticleType)ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get()
    public static final Supplier<Block> SOULCOPPER_LANTERN = SOULCOPPER.register("copper_soul_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.LANTERN).lightLevel(e -> 15).noOcclusion()));
    public static final Supplier<Block> ENERGY_BLOCK = ENERGIZED.register("energy_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).destroyTime(5.0f).explosionResistance(6.0f).sound(SoundType.METAL).lightLevel(e -> 4)));
    public static final Block SOUL_BLAST_FURNACE = null;
}
