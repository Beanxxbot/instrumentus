package com.beanbot.instrumentus.common;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.eventbus.api.IEventBus;

public interface ISidedReference {
    void setup(final IEventBus mod, final IEventBus forge);

}
