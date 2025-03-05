package com.beanbot.instrumentus.common.items;


import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class BreezeArmorItem extends ArmorItem {
    private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new SimpleExplosionDamageCalculator(
            true, false, Optional.of(0.7F), BuiltInRegistries.BLOCK.getTag(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity())
    );

    public BreezeArmorItem(Type pType) {
        super(InstrumentusArmorMaterials.BREEZE_ARMOR_MATERIAL, pType, new Item.Properties().durability(pType.getDurability(33)));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.wind_boots_1").withStyle(ChatFormatting.GRAY);
        Component pressed2 = Component.translatable("instrumentus.tooltip.wind_boots_2").withStyle(ChatFormatting.GRAY);
        if (Screen.hasShiftDown()) {
            tooltip.add(press);
            tooltip.add(empty);
            tooltip.add(pressed1);
            tooltip.add(pressed2);
        } else {
            tooltip.add(press);
        }
    }

    public void windJump(ItemStack stack, Player player, Level level) {
        if (!player.onGround()) {
            player.getCooldowns().addCooldown(this, 60);
            player.setIgnoreFallDamageFromCurrentImpulse(true);
            WindCharge windCharge = new WindCharge(player, level, player.position().x(), player.position().y(), player.position().z());
            level.addFreshEntity(windCharge);
            level.explode(
                            windCharge,
                            null,
                            EXPLOSION_DAMAGE_CALCULATOR,
                            player.position().x(),
                            player.position().y(),
                            player.position().z(),
                            1.2F,
                            false,
                            Level.ExplosionInteraction.TRIGGER,
                            ParticleTypes.GUST_EMITTER_SMALL,
                            ParticleTypes.GUST_EMITTER_LARGE,
                            SoundEvents.WIND_CHARGE_BURST
            );
            windCharge.discard();
            stack.hurtAndBreak(1, player, EquipmentSlot.FEET);
        }
    }
}
