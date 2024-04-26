package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;
import net.neoforged.neoforge.energy.IEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

public class EnergyShovelItem extends DiggerItem implements IItemLightningChargeable, IEnergyItem {
//TODO: Fix 1.20.5

    public EnergyShovelItem(Tier tier, float attackDamageIn, float attackSpeedIn) {
        super( attackDamageIn, attackSpeedIn, tier, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().durability(0).stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        } else {
            Player playerentity = context.getPlayer();
            BlockState blockstate1 = blockstate.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            ItemStack stack = context.getItemInHand();
            if (blockstate1 != null && world.isEmptyBlock(blockpos.above())) {
                world.playSound(playerentity, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if(!world.isClientSide())
                    world.levelEvent((Player)null, 1009, blockpos, 0);

                CampfireBlock.dowse(context.getPlayer(), world, blockpos, blockstate);
                blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null) {
                if (!world.isClientSide) {
                    world.setBlock(blockpos, blockstate2, 11);
                    world.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(playerentity, blockstate2));
                    if (playerentity != null) {
                        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                        if(!(energyStorage == null)){
                            energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                        }
                    }
                }

                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        return energyDamageEnemy(stack, target, attacker);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if(energyStorage == null) return 0.0F;
        if(!(energyStorage.getEnergyStored() > 0)) return 0.0F;
        return super.getDestroySpeed(stack, state);
    }

    //TODO: Fix 1.20.5
    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving){
        if(!stack.hasTag()) return false;
        if(entityLiving instanceof Player){
            Player player = (Player) entityLiving;
            if(!player.isCreative()){
                IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                if(!(energyStorage == null)){
                    if(state.getDestroySpeed(worldIn, pos) != 0.0F){
                        energyStorage.extractEnergy(getMaxTransferRate() - 24, false);
                    }
                }
            }
        }
        return true;
    }

    //TODO: Fix 1.20.5
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        addTooltip(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public int getBarWidth(ItemStack stack){
        return getEnergyBarWidth(stack);
    }

    @Override
    public int getBarColor(ItemStack stack){
        return getEnergyBarColor(stack);
    }

    @Override
    public boolean isDamaged(ItemStack stack){
        return isEnergyBelowZero(stack);
    }
    @Override
    public boolean isBarVisible(ItemStack stack){
        return isEnergyBarVisible(stack);
    }
}
