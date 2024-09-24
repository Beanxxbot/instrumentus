package com.beanbot.instrumentus.common.data.conditions;

import com.beanbot.instrumentus.common.config.Config;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.StringRepresentable;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.function.Supplier;

public record FeatureEnabledCondition(ConfigFeature feature) implements ICondition {

    public static final MapCodec<FeatureEnabledCondition> CODEC = ConfigFeature.CODEC.fieldOf("feature").xmap(configFeature ->
            new FeatureEnabledCondition(configFeature), condition -> condition.getConfigFeature());

    private ConfigFeature getConfigFeature() {
        return this.feature;
    }

    @Override
    public boolean test(ICondition.IContext context) {
        return this.feature.getFeatureValue().get();
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
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
        UTILITIES(() -> Config.UTIL);

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
