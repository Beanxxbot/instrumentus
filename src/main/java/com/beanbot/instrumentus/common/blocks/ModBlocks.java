package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> UTILITIES = DeferredRegister.create(ForgeRegistries.BLOCKS, Instrumentus.MODID);
    public static final DeferredRegister<Block> ENERGIZED = DeferredRegister.create(ForgeRegistries.BLOCKS, Instrumentus.MODID);

    public static final RegistryObject<Block> ILLUMINATE_LIGHT = UTILITIES.register("illuminate_light", () -> new IlluminateLight());
    public static final RegistryObject<Block> ENERGY_BLOCK = ENERGIZED.register("energy_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN).destroyTime(5.0f).explosionResistance(6.0f).sound(SoundType.METAL).lightLevel(e -> 4)));
    public static final Block SOUL_BLAST_FURNACE = null;
}
