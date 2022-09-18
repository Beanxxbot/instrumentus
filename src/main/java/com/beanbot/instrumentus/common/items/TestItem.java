package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;

import com.mojang.math.Vector3d;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;

public class TestItem extends Item {
    public TestItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();

        Vec3 look = player.position();
        Instrumentus.LOGGER.debug("Position: x: " + look.x + " y: " + look.y + " z: " + look.z);

        return super.useOn(context);
    }
}
