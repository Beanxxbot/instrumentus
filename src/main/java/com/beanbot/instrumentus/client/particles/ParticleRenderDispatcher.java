package com.beanbot.instrumentus.client.particles;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRenderDispatcher {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
//        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), FlameParticle.Provider::new);
//        event.registerSpecial(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), CopperSoulFireFlameParticle.Provider::new);
    }
}
