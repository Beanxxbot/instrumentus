package com.beanbot.instrumentus.common.data.attachments;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.BlockPos;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class InstrumentusDataAttachments {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Instrumentus.MODID);

    public static final Supplier<AttachmentType<BlockPos>> BOUND_WIND_BLOWER = ATTACHMENT_TYPES.register(
    "bound_wind_blower", () -> AttachmentType.builder(() -> new BlockPos(0, 0, 0)).serialize(BlockPos.CODEC).build());

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }

}
