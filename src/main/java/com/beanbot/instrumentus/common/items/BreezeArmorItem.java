package com.beanbot.instrumentus.common.items;


import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;

import java.util.Optional;
import java.util.function.Function;


public class BreezeArmorItem extends ArmorItem {
    private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new SimpleExplosionDamageCalculator(
            true, false, Optional.of(0.7F), BuiltInRegistries.BLOCK.get(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity())
    );

    public BreezeArmorItem(ArmorType pType) {
        super(InstrumentusArmorMaterials.breezeArmorMaterial, pType, new Item.Properties().durability(pType.getDurability(33)));
    }

    public void windJump(ItemStack stack, Player player, Level level) {
        if (!player.onGround()) {
            player.getCooldowns().addCooldown(stack, 60);
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
