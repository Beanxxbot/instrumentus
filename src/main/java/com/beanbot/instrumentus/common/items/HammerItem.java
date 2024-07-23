package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

public class HammerItem extends DiggerItem {

    protected Tier tier;

    public HammerItem(Tier tier, float attackDamageIn, float attackSpeedIn){
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
        this.tier = tier;
    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == ModItemTiers.ENERGIZED) {
            return new Item.Properties().attributes(HammerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Item.Properties().attributes(HammerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility action){
        return ItemAbilities.DEFAULT_PICKAXE_ACTIONS.contains(action);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.getBlock() == null || world.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;
        boolean isStone;
        isStone = state.is(BlockTags.MINEABLE_WITH_PICKAXE);
        int r = isStone ? 0 : 2;

        if(tier == Tiers.WOOD || tier == Tiers.STONE || tier == Tiers.IRON || tier == ModItemTiers.COPPER || tier == Tiers.GOLD || tier == Tiers.DIAMOND || tier == Tiers.NETHERITE || tier == ModItemTiers.ENERGIZED){
            r = 1;
        }

        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;

        if(isStone && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, world, pos, r, TrimType.TRIM_ROCK, false, 100);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level world, BlockPos blockPos, int r, TrimType trimType, boolean cutCorners, int damagePercentChance){
        int numberTrimmed = 0;
        int fortune = 0;
        Player player = (Player) entity;

        BlockHitResult blockHitResult = new BlockHitResult(new Vec3(player.getX(), player.getY(), player.getZ()), getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE).getDirection(), blockPos, false);
        Direction blockFaceMined = blockHitResult.getDirection();

        if(blockFaceMined == Direction.EAST || blockFaceMined == Direction.WEST/*look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75*/) {
            for (int dz = -r; dz <= r; dz++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dz == 0)
                        continue;
                    if (trimType.trimAtPos(world, blockPos.offset(0, dy, dz), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if(blockFaceMined == Direction.NORTH || blockFaceMined == Direction.SOUTH/*look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75*/) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(world, blockPos.offset(dx, dy, 0), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if (blockFaceMined == Direction.UP || blockFaceMined == Direction.DOWN /*look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75*/) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (dz == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(world, blockPos.offset(dx, 0, dz), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        }
        return numberTrimmed;
    }

    public enum TrimType{
        TRIM_ROCK;

        public boolean trimAtPos(Level world, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = world.getBlockState(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            switch (this){
                case TRIM_ROCK:default:
                    if(state.is(BlockTags.MINEABLE_WITH_PICKAXE) && state.canHarvestBlock(world, pos, (Player)entity)){
                        state.getBlock().playerDestroy(world, (Player) entity, pos, state,  blockEntity, item);
                        state.getBlock().popExperience((ServerLevel) world, pos, event.getState().getExpDrop(world, pos, blockEntity, entity, item));
                        world.removeBlock(pos, false);
                        return true;
                    }
                    return false;
            }
        }
    }


}
