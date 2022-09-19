package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.init.ModItemGroups;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;


public class HammerItem extends DiggerItem {

    protected Tier material;

    public HammerItem(Tier material, float attackDamageIn, float attackSpeedIn){
        super(attackDamageIn, attackSpeedIn, material, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().stacksTo(1).tab(ModItemGroups.MOD_ITEM_GROUP).durability(material.getUses()));
        this.material = material;
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction action){
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(action);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity){
        if(state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;

        boolean isStone;
        isStone = state.getMaterial() == Material.STONE || state.getMaterial() == Material.METAL;

        int r = isStone ? 0 : 2;

        if(material == Tiers.WOOD || material == Tiers.STONE || material == Tiers.IRON || material == Tiers.GOLD || material == Tiers.DIAMOND || material == Tiers.NETHERITE){
            r = 1;
        }

        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));

        int numberTrimmed = 0;

        if(isStone && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, world, pos, r, TrimType.TRIM_ROCK, false, 100);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos pos, int r, TrimType trimType, boolean cutCorners, int damagePercentChance){
        int numberTrimmed = 0;
        int fortune = 0;
        Vec3 look = entity.getLookAngle();

        if(look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75) {
            for (int dz = -r; dz <= r; dz++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dz == 0)
                        continue;
                    if (trimType.trimAtPos(world, pos.offset(0, dy, dz), fortune)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    }
                }
            }
        } else if(look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(world, pos.offset(dx, dy, 0), fortune)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    }
                }
            }
        } else if (look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (dz == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(world, pos.offset(dx, 0, dz), fortune)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    }
                }
            }
        }
        return numberTrimmed;
    }

    public enum TrimType{
        TRIM_ROCK;

        public boolean trimAtPos(Level world, BlockPos pos, int fortune)
        {
            BlockState state = world.getBlockState(pos);

            switch (this){
                case TRIM_ROCK:default:
                    if(state.getMaterial() == Material.STONE || state.getMaterial() == Material.METAL){
                        world.destroyBlock(pos, true);
                        return true;
                    }
                    return false;
            }
        }
    }


}
