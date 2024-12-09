package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InstrumentusBlocks {

    public static final DeferredRegister.Blocks SOULCOPPER = DeferredRegister.createBlocks(Instrumentus.MODID);
    public static final DeferredRegister.Blocks ENERGIZED = DeferredRegister.createBlocks(Instrumentus.MODID);
    public static final DeferredRegister.Blocks FIRING = DeferredRegister.createBlocks(Instrumentus.MODID);
    public static final DeferredRegister.Blocks MISC = DeferredRegister.createBlocks(Instrumentus.MODID);

    public static final DeferredBlock<CopperSoulFlameLight> COPPER_SOUL_FLAME_LIGHT = SOULCOPPER.register(CopperSoulFlameLight.ID, CopperSoulFlameLight::new);
    public static final DeferredBlock<CopperSoulCampfireBlock> COPPER_SOUL_CAMPFIRE = SOULCOPPER.register(CopperSoulCampfireBlock.ID, CopperSoulCampfireBlock::new);
    public static final DeferredBlock<Block> RAW_SOULCOPPER_BLOCK = SOULCOPPER.registerSimpleBlock("raw_soulcopper_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .lightLevel(e -> 15)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "raw_soulcopper_block"))));
    public static final DeferredBlock<Block> SOULCOPPER_BLOCK = SOULCOPPER.registerSimpleBlock("soulcopper_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .lightLevel(e -> 15)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "soulcopper_block"))));
    public static final DeferredBlock<CopperSoulTorchBlock> SOULCOPPER_TORCH = SOULCOPPER.register("copper_soul_torch",
            () -> new CopperSoulTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)
                    .noCollission()
                    .instabreak()
                    .lightLevel(e -> 15)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "copper_soul_torch"))))); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final DeferredBlock<CopperSoulWallTorchBlock> SOULCOPPER_WALL_TORCH = SOULCOPPER.register("copper_soul_wall_torch",
            () -> new CopperSoulWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH)
                    .noCollission()
                    .instabreak()
                    .lightLevel(e -> 15)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "copper_soul_wall_torch"))))); //(SimpleParticleType)InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get())
    public static final DeferredBlock<LanternBlock> SOULCOPPER_LANTERN = SOULCOPPER.register("copper_soul_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)
                    .requiresCorrectToolForDrops()
                    .strength(3.5f)
                    .sound(SoundType.LANTERN)
                    .lightLevel(e -> 15)
                    .noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "copper_soul_lantern")))));
    public static final DeferredBlock<Block> CUT_SOULCOPPER = SOULCOPPER.registerSimpleBlock("cut_soulcopper",
            BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "cut_soulcopper"))));
    public static final DeferredBlock<Block> SOULCOPPER_GRATE = SOULCOPPER.registerSimpleBlock("soulcopper_grate",
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "soulcopper_grate"))));
    public static final DeferredBlock<DoorBlock> SOULCOPPER_DOOR = SOULCOPPER.register("soulcopper_door",
            () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "soulcopper_door")))));
    public static final DeferredBlock<TrapDoorBlock> SOULCOPPER_TRAPDOOR = SOULCOPPER.register("soulcopper_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_TRAPDOOR)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "soulcopper_trapdoor")))));
    public static final DeferredBlock<Block> ENERGIZED_BLOCK = ENERGIZED.registerSimpleBlock("energized_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).lightLevel(e -> 4).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "energized_block"))));
    public static final DeferredHolder<Block, KilnBlock> KILN = FIRING.register("kiln",
            () -> new KilnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "kiln")))));
    public static final DeferredHolder<Block, WindBlowerBlock> WIND_BLOWER = MISC.register("wind_blower", WindBlowerBlock::new);
}
