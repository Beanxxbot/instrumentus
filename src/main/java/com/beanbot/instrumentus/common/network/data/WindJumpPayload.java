package com.beanbot.instrumentus.common.network.data;

import com.beanbot.instrumentus.common.Instrumentus;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record WindJumpPayload() implements CustomPacketPayload {
    public static final WindJumpPayload INSTANCE = new WindJumpPayload();
    public static final CustomPacketPayload.Type<WindJumpPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "wind_jump"));

    public static final StreamCodec<ByteBuf, WindJumpPayload> STREAM_CODEC = StreamCodec.unit(INSTANCE);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
