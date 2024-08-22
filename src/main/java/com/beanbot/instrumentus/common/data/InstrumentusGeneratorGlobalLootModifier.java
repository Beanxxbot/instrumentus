package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.events.loot.PlantFiberFromGrassModifier;
import com.beanbot.instrumentus.common.events.loot.ToolsInOminousTrialVaultsModifier;
import com.beanbot.instrumentus.common.events.loot.ToolsInTrialVaultsModifier;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.storage.loot.predicates.*;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorGlobalLootModifier extends GlobalLootModifierProvider {
    public InstrumentusGeneratorGlobalLootModifier(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Instrumentus.MODID);
    }

    @Override
    protected void start() {
        add("plant_fiber_from_grass", new PlantFiberFromGrassModifier(
                new LootItemCondition[]{
                        AnyOfCondition.anyOf(
                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(InstrumentusGeneratorItemTags.TOOLS_KNIVES))).build(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build()
                }, InstrumentusItems.PLANT_FIBER.get()));

        add("vault_loot", new ToolsInTrialVaultsModifier(
                new LootItemCondition[]{
                        getVault("reward")
                }));

        add("ominous_vault_loot", new ToolsInOminousTrialVaultsModifier(
                new LootItemCondition[]{
                        getVault("reward_ominous")
                }));
    }

    private LootItemCondition getVault(String vault) {
        LootTableIdCondition.Builder condition = LootTableIdCondition.builder(ResourceLocation.parse("chests/trial_chambers/" + vault));
        return condition.build();
    }
}
