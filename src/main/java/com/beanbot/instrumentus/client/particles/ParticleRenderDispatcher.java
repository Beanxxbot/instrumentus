package com.beanbot.instrumentus.client.particles;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ParticleRenderDispatcher {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
//        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), FlameParticle.Provider::new);
//        event.registerSpecial(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
    }
}
