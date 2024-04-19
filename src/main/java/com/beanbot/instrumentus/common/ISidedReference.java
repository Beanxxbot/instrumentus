package com.beanbot.instrumentus.common;

import net.minecraftforge.eventbus.api.IEventBus;

@SuppressWarnings("unused")
public interface ISidedReference {
    void setup(final IEventBus mod, final IEventBus forge);

}
