package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.crafting.Ingredient;
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
