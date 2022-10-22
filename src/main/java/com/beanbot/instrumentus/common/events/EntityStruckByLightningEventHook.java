package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.items.IItemLightningChargeable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityStruckByLightningEventHook {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        chargeItem(event);
    }

    private void chargeItem(EntityStruckByLightningEvent event) {
        if(event.getEntity() instanceof ItemEntity) {
            ItemEntity entity = (ItemEntity) event.getEntity();
            if(entity.getItem().getItem() instanceof IItemLightningChargeable) {
                IItemLightningChargeable energized = (IItemLightningChargeable) entity.getItem().getItem();
                if(!energized.isChargeFull(entity.getItem())) {
                    entity.setItem(energized.chargeToFull(entity.getItem()));
                    event.setCanceled(true);
                    event.getLightning().remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }
    }
}
