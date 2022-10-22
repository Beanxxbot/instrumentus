package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.capability.EnergyStorageItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.event.world.BlockEvent;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EnergySickleItem extends SickleItem implements IItemLightningChargeable {

    protected Tier material;

    public EnergySickleItem(Tier material) {
        super(material ,new Item.Properties().stacksTo(1).tab(Instrumentus.MOD_ITEM_GROUP).fireResistant());
        this.material = material;
    }

    @Override
    public boolean isChargeFull(ItemStack stack) {
        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
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
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isLeaves;
        isLeaves = state.getMaterial() == Material.LEAVES;

        int radius = isLeaves ? 0 : 2;
        int height = isLeaves ? 0 : 2;

        if(material == Tiers.WOOD || material == Tiers.STONE)
        {
            radius = 1;
            height = 1;
        }
        if(material == Tiers.IRON || material == Tiers.GOLD || material == Tiers.DIAMOND)
        {
            radius = 2;
            height = 2;
        }
        if(material == Tiers.NETHERITE)
        {
            radius = 3;
            height = 3;
        }

        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
        if(lazy.isPresent()){
            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
            if(state.getDestroySpeed(world, pos) != 0.0F){
                storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
            }
        }

        int numberTrimmed = 0;


        if(isLeaves && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_LEAVES, false, 40);
        }
        else
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (world.random.nextInt(3) == 0)
            {
                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, SickleItem.TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int height, int radius, SickleItem.TrimType trimType, boolean cutCorners, int damagePercentChance)
    {
        int numberTrimmed = 0;
        int fortune = 0;

        for(int dx = -radius; dx <= radius; dx++)
        {
            for(int dy = -radius; dy <= radius; dy++)
            {
                for(int dz = -radius; dz <= radius; dz++)
                {
                    if(dx == 0 && dy == 0 && dz == 0 || cutCorners && (Math.abs(dz) >= 2*radius))
                        continue;

                    if(trimType.trimAtPos(world, pos.subtract(new Vec3i(dx,dy,dz).multiply(-1)), entity, stack))
                    {
                        numberTrimmed++;
                        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
                        if(lazy.isPresent()){
                            IEnergyStorage storage = lazy.orElseThrow(AssertionError::new);
                            storage.extractEnergy(EnergyToolCommon.MAX_TRANSFER - 24, false);
                        }
                    }
                }
            }
        }
        return numberTrimmed;
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

    public enum TrimType
    {
        TRIM_GRASS_AND_FLOWERS, TRIM_LEAVES;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            MinecraftForge.EVENT_BUS.post(event);

            switch (this)
            {
                case TRIM_LEAVES:
                    if(state.getMaterial() == Material.LEAVES)
                    {
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getExpToDrop());
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;

                case TRIM_GRASS_AND_FLOWERS:default:
                if(state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.PLANT)
                {
                    state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                    state.getBlock().popExperience((ServerLevel) world, pos, event.getExpToDrop());
                    world.removeBlock(pos, false);
                    return true;
                }
                return false;
            }
        }
    }
}
