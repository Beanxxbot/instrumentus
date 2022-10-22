package com.beanbot.instrumentus.common.items;

import net.minecraft.world.item.ItemStack;

public interface IItemLightningChargeable {
    boolean isChargeFull(ItemStack item);

    ItemStack chargeToFull(ItemStack item);
}
