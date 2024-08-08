package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

public class GeneratorBlockLootTables extends VanillaBlockLoot {

    public GeneratorBlockLootTables(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    protected void generate() {
        add(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get(), noDrop());
        dropSelf(ModBlocks.SOULCOPPER_LANTERN.get());
        dropSelf(ModBlocks.SOULCOPPER_TORCH.get());
        dropSelf(ModBlocks.ENERGIZED_BLOCK.get());
        dropSelf(ModBlocks.RAW_SOULCOPPER_BLOCK.get());
        dropSelf(ModBlocks.SOULCOPPER_BLOCK.get());

        add(ModBlocks.COPPER_SOUL_CAMPFIRE.get(),
            silkTouchDispatchTable -> this.createSilkTouchDispatchTable(
                silkTouchDispatchTable,
                (LootPoolEntryContainer.Builder<?>) this.applyExplosionCondition(
                    silkTouchDispatchTable, LootItem.lootTableItem(Items.RAW_COPPER).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> knownBlocks = new ArrayList<>();
        knownBlocks.addAll(ModBlocks.ENERGIZED.getEntries().stream().map(DeferredHolder::get).toList());
        knownBlocks.addAll(ModBlocks.SOULCOPPER.getEntries().stream().map(DeferredHolder::get).toList());
        return knownBlocks;
    }
}
