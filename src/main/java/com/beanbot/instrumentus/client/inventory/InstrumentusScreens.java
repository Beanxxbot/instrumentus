package com.beanbot.instrumentus.client.inventory;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.inventory.InstrumentusMenus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Instrumentus.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InstrumentusScreens {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(InstrumentusMenus.KILN_MENU.get(), KilnScreen::new);
    }

}
