package com.beanbot.instrumentus.common.blocks.entities;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;

public class InstrumentusBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Instrumentus.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CopperSoulCampfireBlockEntity>> COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY = BLOCK_ENTITIES.register("copper_soul_campfire_block_entity", () ->
            new BlockEntityType<>(CopperSoulCampfireBlockEntity::new, InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get()));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KilnBlockEntity>> KILN_BLOCK_ENTITY = BLOCK_ENTITIES.register("kiln_block_entity", () ->
            new BlockEntityType<>(KilnBlockEntity::new, InstrumentusBlocks.KILN.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
