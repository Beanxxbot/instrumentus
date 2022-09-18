//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemTier;
//import net.minecraft.nbt.CompoundNBT;
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
//public class EnergySickleItem extends SickleItem {
//
//    protected ItemTier material;
//
//    public EnergySickleItem(ItemTier material) {
//        super(material);
//        this.material = material;
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
//
//    @Override
//    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entity)
//    {
//        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
//            return false;
//
//        boolean isLeaves;
//        isLeaves = state.getMaterial() == Material.LEAVES;
//
//        int radius = isLeaves ? 0 : 2;
//        int height = isLeaves ? 0 : 2;
//
//        if(material == ItemTier.WOOD || material == ItemTier.STONE)
//        {
//            radius = 1;
//            height = 1;
//        }
//        if(material == ItemTier.IRON || material == ItemTier.GOLD || material == ItemTier.DIAMOND)
//        {
//            radius = 2;
//            height = 2;
//        }
//
//        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//        if(lazy.isPresent()){
//            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//            if(state.getBlockHardness(world, pos) != 0.0F){
//                storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//            }
//        }
//
//        int numberTrimmed = 0;
//
//
//        if(isLeaves && !entity.isCrouching())
//        {
//            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_LEAVES, false, 40);
//        }
//        else
//        {
//            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
//            if (world.rand.nextInt(3) == 0)
//            {
//                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
//            }
//        }
//        return numberTrimmed > 0;
//    }
//
//    public int trim(ItemStack stack, LivingEntity entity, World world, BlockPos pos, int height, int radius, SickleItem.TrimType trimType, boolean cutCorners, int damagePercentChance)
//    {
//        int numberTrimmed = 0;
//        int fortune = 0;
//
//        for(int dx = -radius; dx <= radius; dx++)
//        {
//            for(int dy = -radius; dy <= radius; dy++)
//            {
//                for(int dz = -radius; dz <= radius; dz++)
//                {
//                    if(dx == 0 && dy == 0 && dz == 0 || cutCorners && (Math.abs(dz) >= 2*radius))
//                        continue;
//
//                    if(trimType.trimAtPos(world, pos.add(dx,dy,dz), fortune))
//                    {
//                        numberTrimmed++;
//                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                        if(lazy.isPresent()){
//                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                        }
//                    }
//                }
//            }
//        }
//        return numberTrimmed;
//    }
//
//    public enum TrimType
//    {
//        TRIM_GRASS_AND_FLOWERS, TRIM_LEAVES;
//
//        public boolean trimAtPos(World world, BlockPos pos, int fortune)
//        {
//            BlockState state = world.getBlockState(pos);
//
//            switch (this)
//            {
//                case TRIM_LEAVES:
//                    if(state.getMaterial() == Material.LEAVES)
//                    {
//                        world.destroyBlock(pos, true);
//                        return true;
//                    }
//                    return false;
//
//                case TRIM_GRASS_AND_FLOWERS:default:
//                if(state.getMaterial() == Material.TALL_PLANTS)
//                {
//                    world.destroyBlock(pos, true);
//                    return true;
//                }
//                else if (state.getMaterial() == Material.PLANTS){
//                    world.destroyBlock(pos, true);
//                    return true;
//                }
//                return false;
//            }
//        }
//    }
//}
