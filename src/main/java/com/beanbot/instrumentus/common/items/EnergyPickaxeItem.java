package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
import com.beanbot.instrumentus.common.init.ModItemGroups;
import com.beanbot.instrumentus.common.util.ToolTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EnergyPickaxeItem extends DiggerItem {

    public EnergyPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(attackDamageIn, attackSpeedIn, tier, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(tier.getUses()));
    }

    @Override
    public void fillItemList(CreativeModeTab group, NonNullList<ItemStack> items){
        if(this.getCreativeTabs() == group){
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
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        EnergyToolCommon.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            return storage.getEnergyStored() != storage.getMaxEnergyStored();
        }
        return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack){
        return EnergyToolCommon.getDurabilityForDisplay(stack);
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
