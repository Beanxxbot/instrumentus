package com.beanbot.instrumentus.common.data.loot;

import com.beanbot.instrumentus.common.Instrumentus;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ToolsInTrialVaultsModifier extends LootModifier {
    public static final Supplier<MapCodec<ToolsInTrialVaultsModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.mapCodec(
            inst -> codecStart(inst).apply(inst, ToolsInTrialVaultsModifier::new)));

    public ToolsInTrialVaultsModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        generatedLoot.addAll(CustomPools.roll(context));
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() { return CODEC.get(); }

    private static class CustomPools {
        private static LootPool commonPool = null;
        private static LootPool rarePool = null;
        private static LootPool uniquePool = null;

        private static List<ItemStack> roll(LootContext context) {
            if(commonPool == null) {
                commonPool = buildLootPool("common");
                rarePool = buildLootPool("rare");
                uniquePool = buildLootPool("unique");
            }
            List<ItemStack> res = new ArrayList<>();
            commonPool.addRandomItems(res::add, context);
            rarePool.addRandomItems(res::add, context);
            uniquePool.addRandomItems(res::add, context);
            return res;
        }

        private static LootPool buildLootPool(String name) {
            ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "custom/" + name + "_vault_loot"));
            return LootPool.lootPool()
                    .add(NestedLootTable.lootTableReference(key).setWeight(1))
                    .name("instrumentus_custom_" + name)
                    .build();
        }
    }

}
