package com.beanbot.instrumentus.common.network.handler;

import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import com.beanbot.instrumentus.common.data.attachments.InstrumentusDataAttachments;
import com.beanbot.instrumentus.common.network.data.WindBlowerPayload;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class WindBlowerPacket {
    public static final WindBlowerPacket INSTANCE = new WindBlowerPacket();

    public static WindBlowerPacket get() {
        return INSTANCE;
    }

    public void handle(WindBlowerPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            Player sender = context.player();
            Level level = sender.level();
            BlockPos blowerLocation = payload.pos();
            BlockState blower = level.getBlockState(blowerLocation);
            if (blower.getBlock() instanceof WindBlowerBlock windBlowerBlock) {
                windBlowerBlock.preventionSoundAndParticles(level, blowerLocation);
            }
        });
    }
}
