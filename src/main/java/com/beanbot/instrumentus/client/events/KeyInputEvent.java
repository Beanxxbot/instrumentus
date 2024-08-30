package com.beanbot.instrumentus.client.events;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.BreezeArmorItem;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Instrumentus.MODID, value = Dist.CLIENT)
public class KeyInputEvent {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if(mc.player == null || mc.level == null || mc.screen != null)
            return;
        Player player = mc.player;
        Level level = mc.level;
        if(event.getAction() == InputConstants.PRESS && event.getKey() == InputConstants.KEY_SPACE) {
            if(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof BreezeArmorItem armorItem) {
                if (!player.getCooldowns().isOnCooldown(armorItem)) {
                    armorItem.doubleJump(player, level);
                }
            }
        }

    }

}
