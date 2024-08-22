package com.beanbot.instrumentus.common.blocks.entities;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Instrumentus.MODID);

    public static final Supplier<BlockEntityType<CopperSoulCampfireBlockEntity>> COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY = BLOCK_ENTITIES.register("copper_soul_campfire_block_entity", () ->
            BlockEntityType.Builder.of(CopperSoulCampfireBlockEntity::new, ModBlocks.COPPER_SOUL_CAMPFIRE.get()).build(null));
    public static final Supplier<BlockEntityType<KilnBlockEntity>> KILN_BLOCK_ENTITY = BLOCK_ENTITIES.register("kiln_block_entity", () ->
            BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
