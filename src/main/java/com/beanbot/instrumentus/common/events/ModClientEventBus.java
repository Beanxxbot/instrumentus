package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.client.armor.WarpedArmorRenderer;
import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.WarpedArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = Instrumentus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBus {

    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(WarpedArmorItem.class, new WarpedArmorRenderer());
    }
}
