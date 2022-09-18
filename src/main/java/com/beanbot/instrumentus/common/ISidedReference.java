package com.beanbot.instrumentus.common;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.eventbus.api.IEventBus;

public interface ISidedReference {
    void setup(final IEventBus mod, final IEventBus forge);

    default <A> A getSolarArmorMaterial(EquipmentSlot armorSlot) {
        return null;
    }

    default <A> A getWarpedArmorMaterial(EquipmentSlot armorSlot) {
        return null;
    }
}
