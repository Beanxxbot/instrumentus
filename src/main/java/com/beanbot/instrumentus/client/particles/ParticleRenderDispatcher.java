package com.beanbot.instrumentus.client.particles;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRenderDispatcher {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
//        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), FlameParticle.Provider::new);
//        event.registerSpecial(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
    }
}
