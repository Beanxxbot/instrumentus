package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class EnergyPaxelItem extends PaxelItem {
    public EnergyPaxelItem(Tier material, int attackDamageIn, float attackSpeedIn) {
        super(material, attackDamageIn, attackSpeedIn);
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
                LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
                if(lazy.isPresent()){
                    IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
                    storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
                }
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
    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving){
        if(!stack.hasTag()) return false;
        if(entityLiving instanceof Player){
            Player player = (Player) entityLiving;
            if(!player.isCreative()){
                LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
                if(lazy.isPresent()){
                    IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
                    if(state.getDestroySpeed(worldIn, pos) != 0.0F){
                        storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items){
        if(this.getCreativeTabs().contains(group)){
            ItemStack empty = new ItemStack(this);
            items.add(empty);

            ItemStack full = new ItemStack(this);
            full.getOrCreateTag().putInt(EnergyToolCommon.ENERGY_TAG, EnergyToolCommon.CAPACITY);
            items.add(full);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);

        }
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            if(!(storage.getEnergyStored() > 0)) return 0.0F;
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        EnergyToolCommon.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public int getBarWidth(ItemStack stack){
        LazyOptional<IEnergyStorage> cap = stack.getCapability(CapabilityEnergy.ENERGY);
        if (!cap.isPresent())
            return super.getBarWidth(stack);

        return cap.map(e -> Math.min(13 * e.getMaxEnergyStored() / e.getMaxEnergyStored(), 13)).orElse(super.getBarWidth(stack));
    }

    @Override
    public int getBarColor(ItemStack stack){
        LazyOptional<IEnergyStorage> cap = stack.getCapability(CapabilityEnergy.ENERGY);
        if (!cap.isPresent())
            return super.getBarColor(stack);

        Pair<Integer, Integer> energyStorage = cap.map(e -> Pair.of(e.getEnergyStored(), e.getMaxEnergyStored())).orElse(Pair.of(0,0));
        return Mth.hsvToRgb(Math.max(0.0f, energyStorage.getLeft() / (float) energyStorage.getRight()) / 3.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean isDamaged(ItemStack stack){
        LazyOptional<IEnergyStorage> cap = stack.getCapability(CapabilityEnergy.ENERGY);
        if(!cap.isPresent())
            return super.isDamaged(stack);

        Pair<Integer, Integer> energyStorage = cap.map(e -> Pair.of(e.getEnergyStored(), e.getMaxEnergyStored())).orElse(Pair.of(0,0));
        return energyStorage.getLeft() != energyStorage.getRight();
    }
    @Override
    public boolean isBarVisible(ItemStack stack){
        return stack.getCapability(CapabilityEnergy.ENERGY).map(e -> e.getEnergyStored() != e.getMaxEnergyStored()).orElse(super.isBarVisible(stack));
    }
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt){
        if(CapabilityEnergy.ENERGY == null) return null;
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return cap == CapabilityEnergy.ENERGY ? LazyOptional.of(() -> new EnergyStorageItem(stack, EnergyToolCommon.CAPACITY, EnergyToolCommon.MAX_TRANSFER)).cast() : LazyOptional.empty();
            }
        };
    }
}
