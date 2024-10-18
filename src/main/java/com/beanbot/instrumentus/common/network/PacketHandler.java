package com.beanbot.instrumentus.common.network;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.network.data.WindBlowerPayload;
import com.beanbot.instrumentus.common.network.data.WindJumpPayload;
import com.beanbot.instrumentus.common.network.handler.WindBlowerPacket;
import com.beanbot.instrumentus.common.network.handler.WindJumpPacket;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PacketHandler {
    public static void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(Instrumentus.MODID);

        registrar.playToServer(WindJumpPayload.TYPE, WindJumpPayload.STREAM_CODEC, WindJumpPacket.get()::handle);

        registrar.playToClient(WindBlowerPayload.TYPE, WindBlowerPayload.STREAM_CODEC, WindBlowerPacket.get()::handle);
    }
}
