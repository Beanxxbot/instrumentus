package com.beanbot.instrumentus.common.blocks.entities;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.CopperSoulCampfireBlock;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Instrumentus.MODID);

    public static final RegistryObject<BlockEntityType<CopperSoulCampfireBlockEntity>> COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY = BLOCK_ENTITIES.register("copper_soul_campfire_block_entity", () ->
            BlockEntityType.Builder.of(CopperSoulCampfireBlockEntity::new, ModBlocks.COPPER_SOUL_CAMPFIRE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
