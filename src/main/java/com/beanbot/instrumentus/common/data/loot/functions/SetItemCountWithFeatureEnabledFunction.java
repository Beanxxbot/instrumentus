package com.beanbot.instrumentus.common.data.loot.functions;

import com.beanbot.instrumentus.common.config.Config;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.function.Supplier;

public class SetItemCountWithFeatureEnabledFunction extends LootItemConditionalFunction {
    private final NumberProvider value;
    private final boolean add;
    private final ConfigFeature feature;

    public static final MapCodec<SetItemCountWithFeatureEnabledFunction> CODEC = RecordCodecBuilder.mapCodec(
        inst -> commonFields(inst)
                .and(
                    inst.group(
                            NumberProviders.CODEC.fieldOf("count").forGetter(c -> c.value),
                            Codec.BOOL.fieldOf("add").orElse(false).forGetter(a -> a.add),
                            ConfigFeature.CODEC.fieldOf("feature").forGetter(f -> f.getConfigFeature())
                    )
                )
                .apply(inst, SetItemCountWithFeatureEnabledFunction::new)
    );

    public SetItemCountWithFeatureEnabledFunction(List<LootItemCondition> conditions, NumberProvider value, Boolean add, ConfigFeature feature) {
        super(conditions);
        this.value = value;
        this.add = add;
        this.feature = feature;
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return InstrumentusLootFunctions.SET_ITEM_COUNT_WITH_FEATURE_ENABLED_FUNCTION.get();
    }

    @Override
    public ItemStack run(ItemStack stack, LootContext context) {
        int i = this.add && this.feature.getFeatureValue().get() ? stack.getCount() : 0;
        if (this.feature.getFeatureValue().get()) {
            stack.setCount(i + this.value.getInt(context));
        } else {
            stack.setCount(0);
        }
        return stack;
    }

    public static LootItemConditionalFunction.Builder<?> setCountWithFeatureEnabled(NumberProvider countValue, ConfigFeature feature) {
        return simpleBuilder(c -> new SetItemCountWithFeatureEnabledFunction(c, countValue, false, feature));
    }

    public static LootItemConditionalFunction.Builder<?> setCountWithFeatureEnabled(NumberProvider countValue, boolean add,ConfigFeature feature) {
        return simpleBuilder(c -> new SetItemCountWithFeatureEnabledFunction(c, countValue, add, feature));
    }

    private ConfigFeature getConfigFeature() {
        return this.feature;
    }

    public enum ConfigFeature implements StringRepresentable {
        HAMMERS(() -> Config.HAMMERS),
        SICKLES(() -> Config.SICKLES),
        PAXELS(() -> Config.PAXELS),
        SHEARS(() -> Config.SHEARS),
        SOULCOPPER(() -> Config.SOULCOPPER),
        ENERGIZED(() -> Config.ENERGIZED),
        KNIVES(() -> Config.KNIVES),
        COPPER_TOOLS(() -> Config.COPPER_TOOLS),
        BRUSHES(() -> Config.BRUSHES),
        EXCAVATORS(() -> Config.EXCAVATORS),
        FIRING(() -> Config.FIRING),
        TRIAL(() -> Config.TRIAL),
        EXPERIMENTAL(() -> Config.EXPERIMENTAL);

        public static final Codec<ConfigFeature> CODEC = StringRepresentable.fromEnum(ConfigFeature::values);

        private Supplier<ModConfigSpec.BooleanValue> feature;

        ConfigFeature(Supplier feature) {
            this.feature = feature;
        }

        public ModConfigSpec.BooleanValue getFeatureValue() {
            return this.feature.get();
        }

        @Override
        public String getSerializedName() {
            return this.name();
        }
    }
}
