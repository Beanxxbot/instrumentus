package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.items.ModItems;
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

public class GeneratorLootTables extends LootTableProvider {
    public GeneratorLootTables(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
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
            add(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get(), noDrop());
            dropSelf(ModBlocks.SOULCOPPER_LANTERN.get());
            dropSelf(ModBlocks.SOULCOPPER_TORCH.get());
            dropSelf(ModBlocks.ENERGIZED_BLOCK.get());
            dropSelf(ModBlocks.RAW_SOULCOPPER_BLOCK.get());
            dropSelf(ModBlocks.SOULCOPPER_BLOCK.get());

            add(ModBlocks.COPPER_SOUL_CAMPFIRE.get(),
                    silkTouchDispatchTable -> this.createSilkTouchDispatchTable(
                            silkTouchDispatchTable,
                            this.applyExplosionCondition(
                                    silkTouchDispatchTable, LootItem.lootTableItem(Items.RAW_COPPER).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            List<Block> knownBlocks = new ArrayList<>();
            knownBlocks.addAll(ModBlocks.ENERGIZED.getEntries().stream().map(DeferredHolder::get).toList());
            knownBlocks.addAll(ModBlocks.SOULCOPPER.getEntries().stream().map(DeferredHolder::get).toList());
            return knownBlocks;
        }
    }

    private record CustomVaultLootProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder) {
            LootPool.Builder commonPool = LootPool.lootPool();
            commonPool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(ModItems.COPPER_SWORD.get(), 2, 1, 1))
                    .add(createEntry(ModItems.COPPER_PAXEL.get(), 2, 1, 1))
                    .add(createEntry(ModItems.RAW_SOULCOPPER.get(), 4, 4, 8));
            LootTable.Builder commonTable = LootTable.lootTable();
            commonTable.withPool(commonPool);
            builder.accept(lootResourceKey("custom/common_vault_loot"), commonTable);

            LootPool.Builder rarePool = LootPool.lootPool();
            rarePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(ModItems.IRON_PAXEL.get(), 1))
                    .add(enchantedTool(ModItems.IRON_HAMMER.get(), 1))
                    .add(createEntry(ModItems.RAW_SOULCOPPER_BLOCK.get(), 2, 1, 3))
                    .add(createEntry(ModItems.SOULCOPPER_INGOT.get(), 3, 4, 6));
            LootTable.Builder rareTable = LootTable.lootTable();
            rareTable.withPool(rarePool);
            builder.accept(lootResourceKey("custom/rare_vault_loot"), rareTable);

            LootPool.Builder uniquePool = LootPool.lootPool();
            uniquePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(ModItems.DIAMOND_PAXEL.get(), 1))
                    .add(enchantedTool(ModItems.DIAMOND_HAMMER.get(), 1))
                    .add(createEntry(ModItems.SOULCOPPER_BURNER.get(), 3, 1, 1))
                    .add(createEntry(ModItems.ENERGIZED_INGOT.get(), 2, 2, 3));
            LootTable.Builder uniqueTable = LootTable.lootTable();
            uniqueTable.withPool(uniquePool);
            builder.accept(lootResourceKey("custom/unique_vault_loot"), uniqueTable);
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, @SuppressWarnings("SameParameterValue") int weight) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, @SuppressWarnings("unused") int weight, int min, int max) {
            return createEntry(new ItemStack(item), 1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
        }

        private LootPoolSingletonContainer.Builder<?> createEntry(ItemStack item, int weight) {
            return LootItem.lootTableItem(item.getItem()).setWeight(weight);
        }
    }

    private record CustomOminousVaultLootProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder) {
            LootPool.Builder commonPool = LootPool.lootPool();
            commonPool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(ModItems.ENERGIZED_INGOT.get(), 4, 2, 6))
                    .add(createEntry(ModItems.SOULCOPPER_BLOCK.get(), 3, 1, 2));
            LootTable.Builder commonTable = LootTable.lootTable();
            commonTable.withPool(commonPool);
            builder.accept(lootResourceKey("custom/common_ominous_vault_loot"), commonTable);

            LootPool.Builder rarePool = LootPool.lootPool();
            rarePool.setRolls(UniformGenerator.between(0, 1))
                    .add(createEntry(ModItems.ENERGIZED_PAXEL.get(), 2, 1, 1))
                    .add(createEntry(ModItems.NETHERITE_SICKLE.get(), 3, 1, 1))
                    .add(enchantedTool(ModItems.ENERGIZED_PICKAXE.get(), 1));
            LootTable.Builder rareTable = LootTable.lootTable();
            rareTable.withPool(rarePool);
            builder.accept(lootResourceKey("custom/rare_ominous_vault_loot"), rareTable);

            LootPool.Builder uniquePool = LootPool.lootPool();
            uniquePool.setRolls(UniformGenerator.between(0, 1))
                    .add(enchantedTool(ModItems.ENERGIZED_PAXEL.get(), 1))
                    .add(createEntry(ModItems.ENERGIZED_BLOCK.get(), 3, 1, 2))
                    .add(createEntry(ModItems.SOULCOPPER_BLOCK.get(), 4, 1, 2))
                    .add(enchantedTool(ModItems.NETHERITE_PAXEL.get(), 2));
            LootTable.Builder uniqueTable = LootTable.lootTable();
            uniqueTable.withPool(uniquePool);
            builder.accept(lootResourceKey("custom/unique_ominous_vault_loot"), uniqueTable);
        }

        private LootPoolEntryContainer.Builder<?> enchantedTool(ItemLike item, int weight) {
            return createEntry(new ItemStack(item), weight)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment(provider));
        }

        private LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, @SuppressWarnings("unused") int weight, int min, int max) {
            return createEntry(new ItemStack(item), 1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
        }

        private LootPoolSingletonContainer.Builder<?> createEntry(ItemStack item, int weight) {
            return LootItem.lootTableItem(item.getItem()).setWeight(weight);
        }
    }

}
