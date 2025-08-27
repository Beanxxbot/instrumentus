package com.beanbot.instrumentus.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

public class SickleItem extends DiggerItem
{
    protected Tier tier;

    public SickleItem(Tier tier) {
        super(tier, BlockTags.LEAVES, generateItemProperties(tier, 0, -1.9f));
        this.tier = tier;

    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            return new Item.Properties().attributes(SickleItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Item.Properties().attributes(SickleItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    private static boolean isGrownCrop(BlockState state) {
        if (state.is(BlockTags.CROPS)) {
            if (state.is(Blocks.PITCHER_CROP)) {
                int maxAge = PitcherCropBlock.MAX_AGE;
                return state.getValue(PitcherCropBlock.AGE) == maxAge;
            }
            if (state.is(Blocks.PUMPKIN_STEM) || state.is(Blocks.MELON_STEM)) {
                int maxAge = StemBlock.MAX_AGE;
                return state.getValue(StemBlock.AGE) == maxAge;
            }
            CropBlock cropBlock = (CropBlock) state.getBlock();
            int maxAge = cropBlock.getMaxAge();
            if (state.is(Blocks.BEETROOTS)) {
                return state.getValue(BeetrootBlock.AGE) == maxAge;
            }
            return state.getValue(CropBlock.AGE) == maxAge;
        }
        return false;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isLeaves = state.is(BlockTags.LEAVES);
        boolean isCrops = state.is(BlockTags.CROPS) && isGrownCrop(state);

        int radius = isLeaves ? 0 : 2;
        int height = isLeaves ? 0 : 2;

        if(tier == Tiers.WOOD || tier == Tiers.STONE)
        {
            radius = 1;
            height = 1;
        }
        if(tier == Tiers.IRON || tier == Tiers.GOLD || tier == InstrumentusItemTiers.COPPER || tier == Tiers.DIAMOND)
        {
            radius = 2;
            height = 2;
        }
        if(tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED)
        {
            radius = 3;
            height = 3;
        }
        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;


        if(isLeaves && !entity.isCrouching()) {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, TrimType.TRIM_LEAVES, false, 40);
        } else if (isCrops && !entity.isCrouching()) {
            numberTrimmed += trim(stack, entity, world, pos, 0, 1, TrimType.TRIM_CROPS, false, 40);
        } else {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (world.random.nextInt(3) == 0) {
                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return (numberTrimmed > 0 && isLeaves);

    }
    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int height, int radius, TrimType trimType, boolean cutCorners, int damagePercentChance)
    {
        int numberTrimmed = 0;

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
                        if(world.random.nextInt(100) < damagePercentChance)
                        {
                            stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                        }
                    }
                }
            }
        }
        return numberTrimmed;
    }

    public enum TrimType
    {
        TRIM_GRASS_AND_FLOWERS, TRIM_CROPS,TRIM_LEAVES;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            switch (this)
            {
                case TRIM_LEAVES:
                    if(state.is(BlockTags.LEAVES))
                    {
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getState().getExpDrop(world, pos, blockEntity, entity, item));
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;

                case TRIM_CROPS:
                    if(state.is(BlockTags.CROPS) && isGrownCrop(state))
                    {
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state, blockEntity, item);
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;

                case TRIM_GRASS_AND_FLOWERS:default:
                if(state.is(Blocks.TALL_GRASS) || state.is(BlockTags.FLOWERS) || state.is(Blocks.SHORT_GRASS))
                {
                    state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                    world.removeBlock(pos, false);
                    return true;
                }
                return false;
            }
        }
    }
}
