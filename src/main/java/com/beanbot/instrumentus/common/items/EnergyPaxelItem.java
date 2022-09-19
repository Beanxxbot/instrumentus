//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.NonNullList;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TextComponent;
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
//import java.awt.*;
//import java.util.List;
//
//public class EnergyPaxelItem extends PaxelItem {
//    public EnergyPaxelItem(Tier material, int attackDamageIn, float attackSpeedIn) {
//        super(material, attackDamageIn, attackSpeedIn);
//    }
//
//    @Override
//    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items){
//        if(this.getCreativeTabs().contains(group)){
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
//                    if(state.getDestroySpeed(worldIn, pos) != 0.0F){
//                        storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
////    @Override
////    public ActionResultType onItemUse(ItemUseContext context) {
////        World world = context.getWorld();
////        BlockPos blockpos = context.getPos();
////        BlockState blockstate = world.getBlockState(blockpos);
////        Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
////        if (block != null) {
////            PlayerEntity playerentity = context.getPlayer();
////            ItemStack stack = context.getItem();
////            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
////            if (!world.isRemote) {
////                world.setBlockState(blockpos, block.getDefaultState().with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
////                if (playerentity != null) {
////                    LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
////                    if(lazy.isPresent()){
////                        IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
////                        storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
////                    }
////                }
////            }
////
////            return ActionResultType.SUCCESS;
////        } else if (context.getFace() == Direction.DOWN) {
////            return ActionResultType.PASS;
////        } else {
////            PlayerEntity playerentity = context.getPlayer();
////            BlockState blockstate1 = SHOVEL_LOOKUP.get(blockstate.getBlock());
////            BlockState blockstate2 = null;
////            ItemStack stack = context.getItem();
////            if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
////                world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
////                blockstate2 = blockstate1;
////            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
////                world.playEvent((PlayerEntity) null, 1009, blockpos, 0);
////                blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
////            }
////
////            if (blockstate2 != null) {
////                if (!world.isRemote) {
////                    world.setBlockState(blockpos, blockstate2, 11);
////                    if (playerentity != null) {
////                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
////                        if(lazy.isPresent()){
////                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
////                            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
////                        }
////                    }
////                }
////
////                return ActionResultType.SUCCESS;
////            } else {
////                return ActionResultType.PASS;
////            }
////        }
////    }
//
//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
//        EnergyToolCommon.addInformation(stack, worldIn, tooltip, flagIn);
//    }
//
////    @Override
////    public boolean showDurabilityBar(ItemStack stack){
////        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
////        if(lazy.isPresent()){
////            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
////            return storage.getEnergyStored() != storage.getMaxEnergyStored();
////        }
////        return false;
////    }
////
////    @Override
////    public double getDurabilityForDisplay(ItemStack stack){
////        return EnergyToolCommon.getDurabilityForDisplay(stack);
////    }
//
//    @Nullable
//    @Override
//    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt){
//        if(CapabilityEnergy.ENERGY == null) return null;
//        return new ICapabilityProvider() {
//            @Nonnull
//            @Override
//            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
//                return cap == CapabilityEnergy.ENERGY ? LazyOptional.of(() -> new EnergyStorageItem(stack, EnergyToolCommon.CAPACITY, EnergyToolCommon.MAX_TRANSFER)).cast() : LazyOptional.empty();
//            }
//        };
//    }
//}
