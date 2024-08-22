package com.beanbot.instrumentus.common.capability;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InstrumentusCapabilities {
    public static final DeferredRegister<DataComponentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Instrumentus.MODID);

//    public static final Supplier<AttachmentType<EnergyStorage>> ENERGYSTORAGE = ATTACHMENT_TYPES.register(
//            "energystorage", () -> AttachmentType.serializable(holder -> {
//                if (holder instanceof ItemStack itemStack) {
//                    int capacity = 20000;
//                    if (itemStack.getItem() instanceof IEnergyItem energyItem) {
//                        capacity = energyItem.getMaxCapacity();
//                    }
//                    return new EnergyStorage(capacity);
//                } else {
//                    throw new IllegalStateException("Cannot attach energy handler item to a non-item");
//                }
//            }).build());

    public static void register(IEventBus event) {
        ATTACHMENT_TYPES.register(event);
    }
}
