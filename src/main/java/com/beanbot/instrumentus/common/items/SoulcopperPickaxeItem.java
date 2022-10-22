package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class SoulcopperPickaxeItem extends DiggerItem {


    protected Tier material;

    public SoulcopperPickaxeItem(Tier material, int attackDamageIn, float attackSpeedIn) {
        super(1, -2.8f, material, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(Instrumentus.MOD_ITEM_GROUP).stacksTo(1).durability(material.getUses()));
        this.material = material;
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level worldIn = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if(context.getClickedFace() == Direction.WEST && worldIn.isEmptyBlock(pos.west())) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else if(context.getClickedFace() == Direction.EAST && worldIn.isEmptyBlock(pos.east())) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else if(context.getClickedFace() == Direction.NORTH && worldIn.isEmptyBlock(pos.north())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else if(context.getClickedFace() == Direction.SOUTH && worldIn.isEmptyBlock(pos.south())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else if(context.getClickedFace() == Direction.DOWN && worldIn.isEmptyBlock(pos.below())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else if(context.getClickedFace() == Direction.UP && worldIn.isEmptyBlock(pos.above())){
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), ModBlocks.COPPER_SOUL_FLAME_LIGHT.get().defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, player, (e) -> { e.broadcastBreakEvent(context.getHand());});
        } else {
            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }
}
