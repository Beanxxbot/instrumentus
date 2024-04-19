package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EnergyShearsItem extends ModShearsItem implements IItemLightningChargeable {


    public EnergyShearsItem(Tier material) {
        super(material, new Item.Properties().stacksTo(1).durability(0).fireResistant());
    }

    @Override
    public boolean isChargeFull(ItemStack stack) {
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(ForgeCapabilities.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            if (storage.getEnergyStored() == storage.getMaxEnergyStored()); {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack chargeToFull(ItemStack stack) {
        stack.getOrCreateTag().putInt(EnergyToolCommon.ENERGY_TAG, EnergyToolCommon.CAPACITY);
        return stack;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
        if (entity.level().isClientSide) return InteractionResult.PASS;
        if (entity instanceof net.minecraftforge.common.IForgeShearable) {
            LazyOptional<IEnergyStorage> lazy = stack.getCapability(ForgeCapabilities.ENERGY);
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            if(lazy.isPresent()){
                if(!(storage.getEnergyStored() > 0)) return InteractionResult.PASS;
            net.minecraftforge.common.IForgeShearable target = (net.minecraftforge.common.IForgeShearable) entity;
            BlockPos pos = BlockPos.containing(entity.position());
            if (target.isShearable(stack, entity.level(), pos)) {
                java.util.List<ItemStack> drops = target.onSheared(playerIn, stack, entity.level(), pos,
                        net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack));
                java.util.Random rand = new java.util.Random();
                drops.forEach(d -> {
                    net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
                    ent.setDeltaMovement(ent.getDeltaMovement().add((double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double) (rand.nextFloat() * 0.05F), (double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
                });
                if (lazy.isPresent()) {
                    storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
                }
            }
            return InteractionResult.SUCCESS;
        }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(ForgeCapabilities.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);

        }
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(ForgeCapabilities.ENERGY);
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
        LazyOptional<IEnergyStorage> cap = stack.getCapability(ForgeCapabilities.ENERGY);
        if (!cap.isPresent())
            return super.getBarWidth(stack);

        return cap.map(e -> Math.min(13 * e.getMaxEnergyStored() / e.getMaxEnergyStored(), 13)).orElse(super.getBarWidth(stack));
    }

    @Override
    public int getBarColor(ItemStack stack){
        LazyOptional<IEnergyStorage> cap = stack.getCapability(ForgeCapabilities.ENERGY);
        if (!cap.isPresent())
            return super.getBarColor(stack);

        Pair<Integer, Integer> energyStorage = cap.map(e -> Pair.of(e.getEnergyStored(), e.getMaxEnergyStored())).orElse(Pair.of(0,0));
        return Mth.hsvToRgb(Math.max(0.0f, energyStorage.getLeft() / (float) energyStorage.getRight()) / 3.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean isDamaged(ItemStack stack){
        LazyOptional<IEnergyStorage> cap = stack.getCapability(ForgeCapabilities.ENERGY);
        if(!cap.isPresent())
            return super.isDamaged(stack);

        Pair<Integer, Integer> energyStorage = cap.map(e -> Pair.of(e.getEnergyStored(), e.getMaxEnergyStored())).orElse(Pair.of(0,0));
        return energyStorage.getLeft() != energyStorage.getRight();
    }
    @Override
    public boolean isBarVisible(ItemStack stack){
        return stack.getCapability(ForgeCapabilities.ENERGY).map(e -> e.getEnergyStored() != e.getMaxEnergyStored()).orElse(super.isBarVisible(stack));
    }
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt){
        if(ForgeCapabilities.ENERGY == null) return null;
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return cap == ForgeCapabilities.ENERGY ? LazyOptional.of(() -> new EnergyStorageItem(stack, EnergyToolCommon.CAPACITY, EnergyToolCommon.MAX_TRANSFER)).cast() : LazyOptional.empty();
            }
        };
    }

}
