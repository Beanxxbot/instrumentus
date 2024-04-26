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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

public class SickleItem extends DiggerItem
{
    protected Tier material;

    //TODO: Fix 1.20.5
    public SickleItem(Tier material, Item.Properties properties) {
        super(0, -1.9f, material, BlockTags.LEAVES, properties);
        this.material = material;

    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isLeaves;
        isLeaves = state.is(BlockTags.LEAVES);

        int radius = isLeaves ? 0 : 2;
        int height = isLeaves ? 0 : 2;

        if(material == Tiers.WOOD || material == Tiers.STONE)
        {
            radius = 1;
            height = 1;
        }
        if(material == Tiers.IRON || material == Tiers.GOLD || material == ModItemTiers.COPPER || material == Tiers.DIAMOND)
        {
            radius = 2;
            height = 2;
        }
        if(material == Tiers.NETHERITE)
        {
            radius = 3;
            height = 3;
        }
        //TODO: Fix 1.20.5
        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));

        int numberTrimmed = 0;


        if(isLeaves && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, TrimType.TRIM_LEAVES, false, 40);
        }
        else
        {
            numberTrimmed += trim(stack, entity, world, pos, height, radius, TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (world.random.nextInt(3) == 0)
            {
                numberTrimmed += trim(stack, entity, world, pos, height, radius - 1, TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return (numberTrimmed > 0 && isLeaves);

    }
    //TODO: Fix 1.20.5
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
                            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
        return numberTrimmed;
    }

    public enum TrimType
    {
        TRIM_GRASS_AND_FLOWERS, TRIM_LEAVES;

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
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getExpToDrop());
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;

                case TRIM_GRASS_AND_FLOWERS:default:
                if(state.is(Blocks.TALL_GRASS) || state.is(BlockTags.FLOWERS) || state.is(Blocks.SHORT_GRASS))
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
