//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
//import com.google.common.collect.ImmutableSet;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemTier;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.util.Direction;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.vector.Vector3d;
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
//import java.util.Set;
//
//public class EnergyHammerItem extends HammerItem {
//
//    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX);
//    protected ItemTier material;
//
//    public EnergyHammerItem(ItemTier material, float attackDamageIn, float attackSpeedIn){
//        super(material, attackSpeedIn, attackDamageIn);
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
//    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entity){
//        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
//            return false;
//
//        boolean isRock;
//        isRock = state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ANVIL;
//
//        int r = isRock ? 0 : 2;
//
//        if(material == ItemTier.WOOD || material == ItemTier.STONE || material == ItemTier.IRON || material == ItemTier.GOLD || material == ItemTier.DIAMOND){
//            r = 1;
//        }
//
//        stack.damageItem(1, entity, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
//
//        int numberTrimmed = 0;
//
//        if(isRock && !entity.isCrouching())
//        {
//            numberTrimmed += trim(stack, entity, world, pos, r, HammerItem.TrimType.TRIM_ROCK, false, 100);
//        }
//        return numberTrimmed > 0;
//    }
//
//    public int trim(ItemStack stack, LivingEntity entity, World world, BlockPos pos, int r, HammerItem.TrimType trimType, boolean cutCorners, int damagePercentChance){
//        int numberTrimmed = 0;
//        int fortune = 0;
//        Vector3d look = entity.getLookVec();
//
//        if(look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75) {
//            for (int dz = -r; dz <= r; dz++) {
//                for (int dy = -r; dy <= r; dy++) {
//                    if (dy == 0 && dz == 0)
//                        continue;
//                    if (trimType.trimAtPos(world, pos.add(0, dy, dz), fortune)) {
//                        numberTrimmed++;
//                            LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                            if(lazy.isPresent()){
//                                IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                                if(world.getBlockState(pos).getBlockHardness(world, pos) != 0.0F){
//                                    storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                                }
//                            }
//                    }
//                }
//            }
//        } else if(look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75) {
//            for (int dx = -r; dx <= r; dx++) {
//                for (int dy = -r; dy <= r; dy++) {
//                    if (dy == 0 && dx == 0)
//                        continue;
//                    if (trimType.trimAtPos(world, pos.add(dx, dy, 0), fortune)) {
//                        numberTrimmed++;
//                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                        if(lazy.isPresent()){
//                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                            if(world.getBlockState(pos).getBlockHardness(world, pos) != 0.0F){
//                                storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                            }
//                        }                     }
//                }
//            }
//        } else if (look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75) {
//            for (int dx = -r; dx <= r; dx++) {
//                for (int dz = -r; dz <= r; dz++) {
//                    if (dz == 0 && dx == 0)
//                        continue;
//                    if (trimType.trimAtPos(world, pos.add(dx, 0, dz), fortune)) {
//                        numberTrimmed++;
//                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//                        if(lazy.isPresent()){
//                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
//                            if(world.getBlockState(pos).getBlockHardness(world, pos) != 0.0F){
//                                storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
//                            }
//                        }                     }
//                }
//            }
//        }
//        return numberTrimmed;
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
//
//
//    public enum TrimType{
//        TRIM_ROCK;
//
//        public boolean trimAtPos(World world, BlockPos pos, int fortune)
//        {
//            BlockState state = world.getBlockState(pos);
//
//            switch (this){
//                case TRIM_ROCK:default:
//                    if(state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ANVIL){
//                        world.destroyBlock(pos, true);
//                        return true;
//                    }
//                    return false;
//            }
//        }
//    }
//}
