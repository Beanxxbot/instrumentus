package com.beanbot.instrumentus.common.capability;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.EnergyToolCommon;
import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModCapabilities {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Instrumentus.MODID);

    public static final Supplier<AttachmentType<EnergyStorage>> ENERGYSTORAGE = ATTACHMENT_TYPES.register(
            "energystorage", () -> AttachmentType.serializable(holder -> {
                if (holder instanceof ItemStack itemStack) {
                    int capacity = 20000;
                    //TODO: Create EnergyItem Interface
                    if (itemStack.getItem() instanceof IEnergyItem energyItem) {
                        capacity = energyItem.getMaxCapacity();
                    }
                    return new EnergyStorage(capacity);
                } else {
                    throw new IllegalStateException("Cannot attach energy handler item to a non-item");
                }
            }).build());

    public static void register(IEventBus event) {
        ATTACHMENT_TYPES.register(event);
    }
}
