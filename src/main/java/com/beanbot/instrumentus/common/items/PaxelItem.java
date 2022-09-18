package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.init.ModItemGroups;
import com.beanbot.instrumentus.common.util.ToolTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PaxelItem extends DiggerItem {

    protected Tier material;

    public PaxelItem(Tier material, int attackDamageIn, float attackSpeedIn) {
        super(attackDamageIn, attackSpeedIn, material, ToolTags.Blocks.MINEABLE_WITH_PAXEL, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(material.getUses()));
        this.material = material;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction){
        return net.minecraftforge.common.ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        Material material = state.getMaterial();
        return material != Material.METAL && material != Material.STONE && material != Material.WOOD && material != Material.PLANT && material != Material.BAMBOO && material != Material.DIRT && material != Material.AMETHYST && material != Material.CLAY && material != Material.GRASS && material != Material.ICE && material != Material.TOP_SNOW && material != Material.HEAVY_METAL && material != Material.ICE_SOLID && material != Material.MOSS && material != Material.NETHER_WOOD && material != Material.PISTON && material != Material.SAND && material != Material.SNOW && material != Material.SHULKER_SHELL? super.getDestroySpeed(stack, state) : this.speed;
    }

    @Nonnull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState resultToSet = useAsAxe(blockstate, context);
        Player player = context.getPlayer();
        if (resultToSet == null){
            if (context.getClickedFace() == Direction.DOWN){
                return InteractionResult.PASS;
            }
            BlockState foundResult = blockstate.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
            if (foundResult != null && world.isEmptyBlock(blockpos.above())){
                world.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!world.isClientSide) {
                    world.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, blockpos, 0);
                }
                CampfireBlock.dowse(player, world, blockpos, blockstate);
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
            }
            if (resultToSet == null) {
                return InteractionResult.PASS;
            }
        }
        if (!world.isClientSide) {
            ItemStack stack = context.getItemInHand();
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockpos, stack);
            }
            world.setBlock(blockpos, resultToSet, Block.UPDATE_ALL_IMMEDIATE);
            if (player != null) {
                stack.hurtAndBreak(1, player, onBroken -> onBroken.broadcastBreakEvent(context.getHand()));
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    @Nullable
    private BlockState useAsAxe(BlockState blockstate, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState resultToSet = blockstate.getToolModifiedState(context, ToolActions.AXE_STRIP, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        resultToSet = blockstate.getToolModifiedState(context, ToolActions.AXE_SCRAPE, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        resultToSet = blockstate.getToolModifiedState(context, ToolActions.AXE_WAX_OFF, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        return null;
    }

}
