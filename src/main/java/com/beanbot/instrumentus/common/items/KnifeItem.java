package com.beanbot.instrumentus.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeItem extends TieredItem {

    public KnifeItem(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super (tier, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            return new Item.Properties().attributes(DiggerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Item.Properties().attributes(DiggerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState block) {
        return block.is(Blocks.TALL_GRASS) || block.is(Blocks.SHORT_GRASS);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if ((double)state.getDestroySpeed(worldIn, pos) != 0.0D || state.is(Blocks.SHORT_GRASS)) {
            stack.hurtAndBreak(2, entityLiving, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
