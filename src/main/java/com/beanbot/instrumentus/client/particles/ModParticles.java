package com.beanbot.instrumentus.client.particles;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Instrumentus.MODID);

    public static final RegistryObject<ParticleType<SimpleParticleType>> COPPER_SOUL_FIRE_FLAME_PARTICLE = PARTICLE_TYPES.register("copper_soul_fire_flame", () -> new SimpleParticleType(true));
}
