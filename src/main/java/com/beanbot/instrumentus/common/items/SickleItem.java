package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.init.ModItemGroups;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Set;

public class SickleItem extends DiggerItem
{
    protected Tier material;

    public SickleItem(Tier material) {
        super(material.getAttackDamageBonus(), 1, material, BlockTags.LEAVES, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(material.getUses()));
        this.material = material;

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

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int height, int radius, TrimType trimType, boolean cutCorners, int damagePercentChance)
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

                    if(trimType.trimAtPos(world, pos.subtract(new Vec3i(dx,dy,dz).multiply(-1)), fortune))
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

        public boolean trimAtPos(Level world, BlockPos pos, int fortune)
        {
            BlockState state = world.getBlockState(pos);

            switch (this)
            {
                case TRIM_LEAVES:
                    if(state.getMaterial() == Material.LEAVES)
                    {
                        world.destroyBlock(pos, true);
                        return true;
                    }
                    return false;

                case TRIM_GRASS_AND_FLOWERS:default:
                if(state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.PLANT)
                {
                    world.destroyBlock(pos, true);
                    return true;
                }
                return false;
            }
        }
    }
}
