//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import com.beanbot.instrumentus.common.init.ModItemGroups;
//import net.minecraft.block.BlockState;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.core.BlockPos;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.network.chat.TextComponent;
//import net.minecraft.util.Direction;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.world.World;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.*;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ICapabilityProvider;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.energy.CapabilityEnergy;
//import net.minecraftforge.energy.IEnergyStorage;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//import java.util.List;
//
//public class EnergyPickaxeItem extends DiggerItem {
//    public EnergyPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn) {
//        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().durability(0).stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP));
//    }
//
//    @Override
//    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items){
//        if(this.isInGroup(group)){
//            ItemStack empty = new ItemStack(this);
//            items.add(empty);
//
//            ItemStack full = new ItemStack(this);
//            full.getOrCreateTag().putInt(EnergyToolCommon.ENERGY_TAG, EnergyToolCommon.CAPACITY);
//            items.add(full);
//        }
//    }
//
//    @Override
//    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
//        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//        if(lazy.isPresent()){
//            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//
//        }
//        return true;
//    }
//
//    @Override
//    public float getDestroySpeed(ItemStack stack, BlockState state){
//        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//        if(lazy.isPresent()){
//            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//            if(!(storage.getEnergyStored() > 0)) return 0.0F;
//        }
//        return super.getDestroySpeed(stack, state);
//    }
//
//    @Override
//    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving){
//        if(!stack.hasTag()) return false;
//        if(entityLiving instanceof Player){
//            Player player = (Player) entityLiving;
//            if(!player.isCreative()){
//                LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                if(lazy.isPresent()){
//                    IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                    if(state.getBlockHardness(worldIn, pos) != 0.0F){
//                        storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
////    @Override
////    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<TextComponent> tooltip, TooltipFlag flagIn){
////        EnergyToolCommon.addInformation(stack, worldIn, tooltip, flagIn);
////    }
//
//    @Override
//    public boolean showDurabilityBar(ItemStack stack){
//        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//        if(lazy.isPresent()){
//            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//            return storage.getEnergyStored() != storage.getMaxEnergyStored();
//        }
//        return false;
//    }
//
//    @Override
//    public double getDurabilityForDisplay(ItemStack stack){
//        return EnergyToolCommon.getDurabilityForDisplay(stack);
//    }
//
////    @Nullable
////    @Override
////    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt){
////        if(CapabilityEnergy.ENERGY == null) return null;
////        return new ICapabilityProvider() {
////            @Nonnull
////            @Override
////            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
////                return cap == CapabilityEnergy.ENERGY ? LazyOptional.of(() -> new EnergyStorageItem(stack, EnergyToolCommon.CAPACITY, EnergyToolCommon.MAX_TRANSFER)).cast() : LazyOptional.empty();
////            }
////        };
////    }
//}
