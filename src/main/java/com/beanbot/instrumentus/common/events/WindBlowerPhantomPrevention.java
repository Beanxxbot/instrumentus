package com.beanbot.instrumentus.common.events;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import com.beanbot.instrumentus.common.data.attachments.InstrumentusDataAttachments;
import com.beanbot.instrumentus.common.network.data.WindBlowerPayload;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class WindBlowerPhantomPrevention {

    @SubscribeEvent
    public void onWindBlowerPhantomPrevention(PlayerSpawnPhantomsEvent event) {
        Player player = event.getEntity();
        ServerPlayer serverPlayer = (ServerPlayer) player;
        ServerLevel level = (ServerLevel) event.getEntity().level();
        BlockPos blowerBlockPos = player.getData(InstrumentusDataAttachments.BOUND_WIND_BLOWER);
        BlockPos playerBlockPos = player.getOnPos();
        BlockState blockState = level.getBlockState(blowerBlockPos);
        if (blockState.getBlock() instanceof WindBlowerBlock block) {
            if (blockState.getValue(WindBlowerBlock.BLOWER_CHARGE) > 0) {
                if(event.getResult() == PlayerSpawnPhantomsEvent.Result.DEFAULT && (level.dimensionType().hasSkyLight() || (playerBlockPos.getY() >= level.getSeaLevel() && level.canSeeSky(playerBlockPos)))) {
                    if (event.getPhantomsToSpawn() > 0) {
                        event.setPhantomsToSpawn(0);
                        PacketDistributor.sendToAllPlayers(new WindBlowerPayload(blowerBlockPos));
                        BlockState newState = blockState.setValue(WindBlowerBlock.BLOWER_CHARGE, blockState.getValue(WindBlowerBlock.BLOWER_CHARGE) - 1);
                        level.setBlock(blowerBlockPos, newState, 3);
                    }
                }
            }
        }
    }

}
