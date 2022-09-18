//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.blocks.IlluminateLight;
//import com.beanbot.instrumentus.common.init.ModItemGroups;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.util.ActionResultType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.World;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.PickaxeItem;
//import net.minecraft.world.item.Tier;
//import net.minecraft.world.item.context.UseOnContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//
//
//public class IlluminatePickaxeItem extends PickaxeItem {
//
//
//    protected Tier material;
//
//    public IlluminatePickaxeItem(Tier material, int attackDamageIn, float attackSpeedIn) {
//        super(material, 1, -2.8f, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP).stacksTo(1).durability(material.getUses()));
//        this.material = material;
//    }
//
//    @Override
//    public InteractionResult useOn(UseOnContext context){
//        Level worldIn = context.getLevel();
//        BlockPos pos = context.getClickedPos();
//        Player player = context.getPlayer();
//
//        if(context.getClickedFace() == Direction.WEST && worldIn.isEmptyBlock(pos.west())) {
//            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), new IlluminateLight().;
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else if(context.getFace() == Direction.EAST && worldIn.isAirBlock(pos.east())) {
//            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), new IlluminateLight().getDefaultState());
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else if(context.getFace() == Direction.NORTH && worldIn.isAirBlock(pos.north())){
//            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), new IlluminateLight().getDefaultState());
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else if(context.getFace() == Direction.SOUTH && worldIn.isAirBlock(pos.south())){
//            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), new IlluminateLight().getDefaultState());
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else if(context.getFace() == Direction.DOWN && worldIn.isAirBlock(pos.down())){
//            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), new IlluminateLight().getDefaultState());
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else if(context.getFace() == Direction.UP && worldIn.isAirBlock(pos.up())){
//            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), new IlluminateLight().getDefaultState());
//            context.getItem().damageItem(1, player, (e) -> { e.sendBreakAnimation(context.getHand());});
//        } else {
//            return ActionResultType.FAIL;
//        }
//        return ActionResultType.PASS;
//    }
//}
