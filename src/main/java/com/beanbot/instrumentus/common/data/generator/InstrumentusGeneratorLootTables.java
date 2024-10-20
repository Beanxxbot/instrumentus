package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.data.loot.functions.SetItemCountWithFeatureEnabledFunction;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class InstrumentusGeneratorLootTables extends LootTableProvider {
    public InstrumentusGeneratorLootTables(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(GeneratorBlockLootTables::new, LootContextParamSets.BLOCK),
            new LootTableProvider.SubProviderEntry(CustomVaultLootProvider::new, LootContextParamSets.CHEST),
            new LootTableProvider.SubProviderEntry(CustomOminousVaultLootProvider::new, LootContextParamSets.CHEST)
        ), lookupProvider);
    }

    private static ResourceKey<LootTable> lootResourceKey(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, id));
    }

    private static class GeneratorBlockLootTables extends BlockLootSubProvider {
        public GeneratorBlockLootTables(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, provider);
        }

        @Override
        protected void generate() {
            add(InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get(), noDrop());
            dropSelf(InstrumentusBlocks.SOULCOPPER_LANTERN.get());
            dropSelf(InstrumentusBlocks.SOULCOPPER_TORCH.get());
            dropSelf(InstrumentusBlocks.ENERGIZED_BLOCK.get());
            dropSelf(InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get());
            dropSelf(InstrumentusBlocks.SOULCOPPER_BLOCK.get());
            dropSelf(InstrumentusBlocks.KILN.get());
            dropSelf(InstrumentusBlocks.CUT_SOULCOPPER.get());
            dropSelf(InstrumentusBlocks.SOULCOPPER_GRATE.get());
            dropSelf(InstrumentusBlocks.SOULCOPPER_TRAPDOOR.get());
            dropSelf(InstrumentusBlocks.SOULCOPPER_DOOR.get());
            dropSelf(InstrumentusBlocks.WIND_BLOWER.get());

            add(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get(),
                    silkTouchDispatchTable -> this.createSilkTouchDispatchTable(
                            silkTouchDispatchTable,
                            this.applyExplosionCondition(
                                    silkTouchDispatchTable, LootItem.lootTableItem(Items.RAW_COPPER).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            List<Block> knownBlocks = new ArrayList<>();
            knownBlocks.addAll(InstrumentusBlocks.ENERGIZED.getEntries().stream().map(DeferredHolder::get).toList());
            knownBlocks.addAll(InstrumentusBlocks.SOULCOPPER.getEntries().stream().map(DeferredHolder::get).toList());
            knownBlocks.addAll(InstrumentusBlocks.FIRING.getEntries().stream().map(DeferredHolder::get).toList());
            knownBlocks.addAll(InstrumentusBlocks.MISC.getEntries().stream().map(DeferredHolder::get).toList());
            return knownBlocks;
        }
    }

    private record CustomVaultLootProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder) {
            LootPool.Builder commonPool = LootPool.lootPool();
            commonPool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(InstrumentusItems.COPPER_SWORD.get(), 2, 1, 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.COPPER_TOOLS))
                    .add(createEntry(InstrumentusItems.COPPER_PAXEL.get(), 2, 1, 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.COPPER_TOOLS))
                    .add(createEntry(InstrumentusItems.RAW_SOULCOPPER.get(), 4, 4, 8, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER));
            LootTable.Builder commonTable = LootTable.lootTable();
            commonTable.withPool(commonPool);
            builder.accept(lootResourceKey("custom/common_vault_loot"), commonTable);

            LootPool.Builder rarePool = LootPool.lootPool();
            rarePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(InstrumentusItems.IRON_PAXEL.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.PAXELS))
                    .add(enchantedTool(InstrumentusItems.IRON_HAMMER.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.HAMMERS))
                    .add(createEntry(InstrumentusItems.RAW_SOULCOPPER_BLOCK.get(), 2, 1, 3, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER))
                    .add(createEntry(InstrumentusItems.SOULCOPPER_INGOT.get(), 3, 4, 6, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER));
            LootTable.Builder rareTable = LootTable.lootTable();
            rareTable.withPool(rarePool);
            builder.accept(lootResourceKey("custom/rare_vault_loot"), rareTable);

            LootPool.Builder uniquePool = LootPool.lootPool();
            uniquePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(InstrumentusItems.DIAMOND_PAXEL.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.PAXELS))
                    .add(enchantedTool(InstrumentusItems.DIAMOND_HAMMER.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.HAMMERS))
                    .add(createEntry(InstrumentusItems.SOULCOPPER_BURNER.get(), 3, 1, 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER))
                    .add(createEntry(InstrumentusItems.ENERGIZED_INGOT.get(), 2, 2, 3, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED));
            LootTable.Builder uniqueTable = LootTable.lootTable();
            uniqueTable.withPool(uniquePool);
            builder.accept(lootResourceKey("custom/unique_vault_loot"), uniqueTable);
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, @SuppressWarnings("SameParameterValue") int weight) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, @SuppressWarnings("SameParameterValue") int weight, SetItemCountWithFeatureEnabledFunction.ConfigFeature feature) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountWithFeatureEnabledFunction.setCountWithFeatureEnabled(ConstantValue.exactly(1), feature))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, @SuppressWarnings("unused") int weight, int min, int max) {
            return createEntry(new ItemStack(item), 1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
        }

        private LootPoolSingletonContainer.Builder<?> createEntry(ItemStack item, int weight) {
            return LootItem.lootTableItem(item.getItem()).setWeight(weight);
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, int weight, int min, int max, SetItemCountWithFeatureEnabledFunction.ConfigFeature feature) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountWithFeatureEnabledFunction.setCountWithFeatureEnabled(UniformGenerator.between(min, max), feature));
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, int weight, SetItemCountWithFeatureEnabledFunction.ConfigFeature feature) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountWithFeatureEnabledFunction.setCountWithFeatureEnabled(ConstantValue.exactly( 1), feature));
        }
    }

    private record CustomOminousVaultLootProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder) {
            LootPool.Builder commonPool = LootPool.lootPool();
            commonPool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(InstrumentusItems.ENERGIZED_INGOT.get(), 4, 2, 6, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED))
                    .add(createEntry(InstrumentusItems.SOULCOPPER_BLOCK.get(), 3, 1, 2, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER));
            LootTable.Builder commonTable = LootTable.lootTable();
            commonTable.withPool(commonPool);
            builder.accept(lootResourceKey("custom/common_ominous_vault_loot"), commonTable);

            LootPool.Builder rarePool = LootPool.lootPool();
            rarePool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(InstrumentusItems.ENERGIZED_PAXEL.get(), 2, 1, 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED))
                    .add(createEntry(InstrumentusItems.NETHERITE_SICKLE.get(), 3, 1, 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SICKLES))
                    .add(enchantedTool(InstrumentusItems.ENERGIZED_PICKAXE.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED));
            LootTable.Builder rareTable = LootTable.lootTable();
            rareTable.withPool(rarePool);
            builder.accept(lootResourceKey("custom/rare_ominous_vault_loot"), rareTable);

            LootPool.Builder uniquePool = LootPool.lootPool();
            uniquePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(InstrumentusItems.ENERGIZED_PAXEL.get(), 1, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED))
                    .add(createEntry(InstrumentusItems.ENERGIZED_BLOCK.get(), 3, 1, 2, SetItemCountWithFeatureEnabledFunction.ConfigFeature.ENERGIZED))
                    .add(createEntry(InstrumentusItems.SOULCOPPER_BLOCK.get(), 4, 1, 2, SetItemCountWithFeatureEnabledFunction.ConfigFeature.SOULCOPPER))
                    .add(enchantedTool(InstrumentusItems.NETHERITE_PAXEL.get(), 2, SetItemCountWithFeatureEnabledFunction.ConfigFeature.PAXELS));
            LootTable.Builder uniqueTable = LootTable.lootTable();
            uniqueTable.withPool(uniquePool);
            builder.accept(lootResourceKey("custom/unique_ominous_vault_loot"), uniqueTable);
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, int weight) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, @SuppressWarnings("SameParameterValue") int weight, SetItemCountWithFeatureEnabledFunction.ConfigFeature feature) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountWithFeatureEnabledFunction.setCountWithFeatureEnabled(ConstantValue.exactly(1), feature))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, @SuppressWarnings("unused") int weight, int min, int max) {
            return createEntry(new ItemStack(item), 1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
        }

        private LootPoolSingletonContainer.Builder<?> createEntry(ItemStack item, int weight) {
            return LootItem.lootTableItem(item.getItem()).setWeight(weight);
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, int weight, int min, int max, SetItemCountWithFeatureEnabledFunction.ConfigFeature feature) {
            return createEntry(new ItemStack(item), weight)
                .apply(SetItemCountWithFeatureEnabledFunction.setCountWithFeatureEnabled(UniformGenerator.between(min, max), feature));
        }
    }

}
