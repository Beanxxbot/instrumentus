package com.beanbot.instrumentus.compat.create.recipe;

import com.beanbot.instrumentus.client.particles.InstrumentusParticles;
import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.recipe.CopperSoulCampfireRecipe;
import com.beanbot.instrumentus.common.recipe.InstrumentusRecipes;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.damageTypes.CreateDamageSources;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.createmod.catnip.math.VecHelper;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InstrumentusFanProcessingTypes extends AllFanProcessingTypes {

    public static final CopperSoulHauntingType COPPER_SOUL_HAUNTING = register("copper_soul_haunting", new CopperSoulHauntingType());

    private static final Map<String, FanProcessingType> LEGACY_NAME_MAP;

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("COPPER_SOUL_HAUNTING", COPPER_SOUL_HAUNTING);
        map.trim();
        LEGACY_NAME_MAP = map;
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, name), type);
    }

    @Nullable
    public static FanProcessingType ofLegacyName(String name) {
        return LEGACY_NAME_MAP.get(name);
    }

    public static void init() {

    }

    public static FanProcessingType parseLegacy(String str) {
        FanProcessingType type = ofLegacyName(str);
        if (type != null) {
            return type;
        }
        return FanProcessingType.parse(str);
    }

    public static class CopperSoulHauntingType implements FanProcessingType {
        @Override
        public boolean isValidAt(Level level, BlockPos pos) {
            BlockState blockState = level.getBlockState(pos);
            return blockState.is(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE);
        }

        @Override
        public int getPriority() {
            return 400;
        }

        @Override
        public boolean canProcess(ItemStack stack, Level level) {
            Optional<RecipeHolder<CopperSoulCampfireRecipe>> recipe = level.getRecipeManager()
                    .getRecipeFor(InstrumentusRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get(), new SingleRecipeInput(stack), level);
            return recipe.isPresent();
        }

        @Override
        @Nullable
        public List<ItemStack> process(ItemStack stack, Level level) {
            Optional<RecipeHolder<CopperSoulCampfireRecipe>> recipe = level.getRecipeManager()
                    .getRecipeFor(InstrumentusRecipes.COPPER_SOUL_CAMPFIRE_COOKING_TYPE.get(), new SingleRecipeInput(stack), level);

            if (recipe.isPresent())
                return RecipeApplier.applyRecipeOn(level, stack, recipe.get().value(), false);
            return null;
        }

        @Override
        public void spawnProcessingParticles(Level level, Vec3 pos) {
            if (level.random.nextInt(8) != 0)
                return;
            pos = pos.add(VecHelper.offsetRandomly(Vec3.ZERO, level.random, 1)
                    .multiply(1, 0.05f, 1)
                    .normalize()
                    .scale(0.15f));
            level.addParticle((SimpleParticleType) InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), pos.x, pos.y + .45f, pos.z, 0, 0, 0);
            if (level.random.nextInt(2) == 0)
                level.addParticle(ParticleTypes.SMOKE, pos.x, pos.y + .25f, pos.z, 0, 0, 0);
        }

        @Override
        public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
            particleAccess.setColor(Color.mixColors(0x0, 0x13b360, random.nextFloat()));
            particleAccess.setAlpha(1f);
            if (random.nextFloat() < 1 / 128f)
                particleAccess.spawnExtraParticle((SimpleParticleType) InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), .125f);
            if (random.nextFloat() < 1 / 32f)
                particleAccess.spawnExtraParticle(ParticleTypes.SMOKE, .125f);
        }

        @Override
        public void affectEntity(Entity entity, Level level) {
            if (level.isClientSide)
                return;

            if (!entity.fireImmune()) {
                entity.igniteForSeconds(2);
                entity.hurt(CreateDamageSources.fanFire(level), 2);
            }
        }
    }

}
