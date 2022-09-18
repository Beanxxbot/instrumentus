//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import com.beanbot.instrumentus.common.init.ModItemGroups;
//import net.minecraft.block.BlockState;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemTier;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.util.ActionResultType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.NonNullList;
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
//public class EnergyShearsItem extends ModShearsItem {
//    public EnergyShearsItem(ItemTier material) {
//        super(material, new Item.Properties().maxStackSize(1).maxDamage(0).group(ModItemGroups.MOD_ITEM_GROUP));
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
//    @SuppressWarnings("deprecation")
//    @Override
//    public ActionResultType itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
//        if (entity.world.isRemote) return ActionResultType.PASS;
//        if (entity instanceof net.minecraftforge.common.IForgeShearable) {
//            net.minecraftforge.common.IForgeShearable target = (net.minecraftforge.common.IForgeShearable)entity;
//            BlockPos pos = new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ());
//            if (target.isShearable(stack, entity.world, pos)) {
//                java.util.List<ItemStack> drops = target.onSheared(playerIn, stack, entity.world, pos,
//                        net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.FORTUNE, stack));
//                java.util.Random rand = new java.util.Random();
//                drops.forEach(d -> {
//                    net.minecraft.entity.item.ItemEntity ent = entity.entityDropItem(d, 1.0F);
//                    ent.setMotion(ent.getMotion().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
//                });
//                LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                if(lazy.isPresent()){
//                    IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                    storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                }
//            }
//            return ActionResultType.SUCCESS;
//        }
//        return ActionResultType.PASS;
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
