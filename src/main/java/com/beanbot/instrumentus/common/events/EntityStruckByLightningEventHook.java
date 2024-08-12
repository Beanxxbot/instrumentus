package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;

public class EntityStruckByLightningEventHook {

    @SuppressWarnings("unused")
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        chargeItem(event);
    }

    private void chargeItem(EntityStruckByLightningEvent event) {
        if(event.getEntity() instanceof ItemEntity entity) {
            if(entity.getItem().getItem() instanceof IItemLightningChargeable energized) {
                    entity.setItem(energized.chargeToFull(entity.getItem()));
                    event.setCanceled(true);
            }
        }
    }
}
