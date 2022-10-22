package com.beanbot.instrumentus.common.events.loot;

import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import org.checkerframework.checker.nullness.qual.NonNull;

import com.google.gson.JsonObject;
import java.util.List;

public class PlantFiberFromGrassModifier extends LootModifier {
    protected PlantFiberFromGrassModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @NonNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(ModItems.PLANT_FIBER.get(), 1));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<PlantFiberFromGrassModifier> {

        @Override
        public PlantFiberFromGrassModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            return new PlantFiberFromGrassModifier(conditionsIn);
        }

        @Override
        public JsonObject write(PlantFiberFromGrassModifier instance) {
            JsonObject json = this.makeConditions(instance.conditions);
            return json;
        }
    }
}
