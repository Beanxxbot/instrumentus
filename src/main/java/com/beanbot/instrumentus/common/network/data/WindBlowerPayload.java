package com.beanbot.instrumentus.common.network.data;

import com.beanbot.instrumentus.common.Instrumentus;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record WindBlowerPayload(BlockPos pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<WindBlowerPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "wind_blow"));

    public static final StreamCodec<ByteBuf, WindBlowerPayload> STREAM_CODEC = BlockPos.STREAM_CODEC.map(WindBlowerPayload::new, WindBlowerPayload::pos);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
