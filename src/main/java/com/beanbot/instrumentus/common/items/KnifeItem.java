package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.data.generator.InstrumentusGeneratorBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeItem extends Item {

    public KnifeItem(ToolMaterial toolMaterial, int attackDamageIn, float attackSpeedIn) {
        super (toolMaterial.applyToolProperties(generateItemProperties(toolMaterial, attackDamageIn, attackSpeedIn), InstrumentusGeneratorBlockTags.MINEABLE_WITH_KNIFE, attackDamageIn, attackSpeedIn));
    }

    private static Item.Properties generateItemProperties(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn) {
        if (toolMaterial == ToolMaterial.NETHERITE || toolMaterial == InstrumentusToolMaterials.ENERGIZED) {
            return new Item.Properties().stacksTo(1).fireResistant();
        }
        return new Item.Properties().stacksTo(1);
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
