package com.beanbot.instrumentus.client.events;

import com.beanbot.instrumentus.client.renderer.player.BadgeRenderLayer;
import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class RenderPlayerModificationsEvents {

    @SubscribeEvent
    public static void registerRenderLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerSkin.Model skinType : event.getSkins()) {
            LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer = event.getSkin(skinType);
            if (renderer instanceof PlayerRenderer) {
                renderer.addLayer(new BadgeRenderLayer(renderer));
            }
        }
    }

}
