package com.beanbot.instrumentus.common.network.handler;

import com.beanbot.instrumentus.common.items.BreezeArmorItem;
import com.beanbot.instrumentus.common.network.data.WindJumpPayload;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class WindJumpPacket {
    public static final WindJumpPacket INSTANCE = new WindJumpPacket();

    public static WindJumpPacket get() {
        return INSTANCE;
    }

    public void handle(final WindJumpPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player sender = context.player();
            ItemStack itemStack = sender.getItemBySlot(EquipmentSlot.FEET);
            if (!(itemStack.getItem() instanceof BreezeArmorItem breezeArmorItem)) {
                return;
            }
            breezeArmorItem.windJump(itemStack, sender, context.player().level());
        });
    }
}
