package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;


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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.soulcopper_pickaxe_1").withStyle(ChatFormatting.GRAY);
        Component pressed2 = Component.translatable("instrumentus.tooltip.soulcopper_pickaxe_2").withStyle(ChatFormatting.GRAY);
        if (Screen.hasShiftDown()) {
            tooltip.add(press);
            tooltip.add(empty);
            tooltip.add(pressed1);
            tooltip.add(pressed2);
        } else {
            tooltip.add(press);
        }
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
