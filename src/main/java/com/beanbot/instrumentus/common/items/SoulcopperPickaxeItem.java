package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class SoulcopperPickaxeItem extends DiggerItem {


    protected Tier material;

    public SoulcopperPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
        this.material = tier;
    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE) {
            return new Item.Properties().attributes(PickaxeItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant().durability(tier.getUses());
        }
        return new Item.Properties().attributes(PickaxeItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).durability(tier.getUses());
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level worldIn = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        if(context.getClickedFace() == Direction.WEST && worldIn.isEmptyBlock(pos.west())) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else if(context.getClickedFace() == Direction.EAST && worldIn.isEmptyBlock(pos.east())) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else if(context.getClickedFace() == Direction.NORTH && worldIn.isEmptyBlock(pos.north())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else if(context.getClickedFace() == Direction.SOUTH && worldIn.isEmptyBlock(pos.south())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else if(context.getClickedFace() == Direction.DOWN && worldIn.isEmptyBlock(pos.below())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else if(context.getClickedFace() == Direction.UP && worldIn.isEmptyBlock(pos.above())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
        } else {
            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }
}
