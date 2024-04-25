package com.beanbot.instrumentus.client.particles;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Instrumentus.MODID);

    public static final Supplier<ParticleType<SimpleParticleType>> COPPER_SOUL_FIRE_FLAME_PARTICLE =
            PARTICLE_TYPES.register("copper_soul_fire_flame", () -> new SimpleParticleType(true));
}
