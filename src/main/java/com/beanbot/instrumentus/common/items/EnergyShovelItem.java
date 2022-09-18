//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import com.beanbot.instrumentus.common.init.ModItemGroups;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.CampfireBlock;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.world.World;
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
//public class EnergyShovelItem extends ShovelItem {
//    public EnergyShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn) {
//        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().maxDamage(0).maxStackSize(1).group(ModItemGroups.MOD_ITEM_GROUP));
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
//    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker){
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
//    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving){
//        if(!stack.hasTag()) return false;
//        if(entityLiving instanceof PlayerEntity){
//            PlayerEntity player = (PlayerEntity) entityLiving;
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
//    @Override
//    public ActionResultType onItemUse(ItemUseContext context) {
//        World world = context.getWorld();
//        BlockPos blockpos = context.getPos();
//        BlockState blockstate = world.getBlockState(blockpos);
//        if (context.getFace() == Direction.DOWN) {
//            return ActionResultType.PASS;
//        } else {
//            PlayerEntity playerentity = context.getPlayer();
//            BlockState blockstate1 = SHOVEL_LOOKUP.get(blockstate.getBlock());
//            BlockState blockstate2 = null;
//            ItemStack stack = context.getItem();
//            if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
//                world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                blockstate2 = blockstate1;
//            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
//                world.playEvent((PlayerEntity)null, 1009, blockpos, 0);
//                blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
//            }
//
//            if (blockstate2 != null) {
//                if (!world.isRemote) {
//                    world.setBlockState(blockpos, blockstate2, 11);
//                    if (playerentity != null) {
//                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                        if(lazy.isPresent()){
//                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                        }
//                    }
//                }
//
//                return ActionResultType.SUCCESS;
//            } else {
//                return ActionResultType.PASS;
//            }
//        }
//    }
//
//    @Override
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
//        EnergyToolCommon.addInformation(stack, worldIn, tooltip, flagIn);
//    }
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
//    @Nullable
//    @Override
//    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt){
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
