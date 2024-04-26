package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.items.interfaces.IItemLightningChargeable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

public class EnergyLightningRodItem extends Item implements IItemLightningChargeable, IEnergyItem {

    public EnergyLightningRodItem(Item.Properties builder) {
        super(builder);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        ItemStack stack = context.getItemInHand();
        if (block instanceof LightningRodBlock) {
            LightningRodBlock lightningRodBlock = (LightningRodBlock) block;
                Player player = context.getPlayer();
                ItemStack itemstack = context.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }
            if (player != null) {
                IEnergyStorage energyStorage = stack.getCapability(Capabilities.EnergyStorage.ITEM);
                if(!(energyStorage == null)) {
                    if (energyStorage.getEnergyStored() > 4999) {
                        Entity lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
                        lightningBolt.moveTo(context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
                        level.playSound(player, blockpos, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        level.addFreshEntity(lightningBolt);
                        level.levelEvent(3002, context.getClickedPos(), blockstate.getValue(LightningRodBlock.FACING).getAxis().ordinal());
                        energyStorage.extractEnergy(5000, false);
                    }
                }
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
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
