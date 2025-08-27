package com.beanbot.instrumentus.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
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
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HammerItem extends DiggerItem {

    protected Tier tier;

    public HammerItem(Tier tier, float attackDamageIn, float attackSpeedIn){
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
        this.tier = tier;
    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            return new Item.Properties().attributes(HammerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Item.Properties().attributes(HammerItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.hammer_1").withStyle(ChatFormatting.GRAY);
        if (Screen.hasShiftDown()) {
            tooltip.add(press);
            tooltip.add(empty);
            tooltip.add(pressed1);
        } else {
            tooltip.add(press);
        }
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility ability){
        return ItemAbilities.DEFAULT_PICKAXE_ACTIONS.contains(ability);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
        //noinspection ConstantValue
        if (state.getBlock() == null || level.getBlockState(pos).getBlock() == Blocks.AIR)
            return false;
        boolean isPickaxeable = state.is(BlockTags.MINEABLE_WITH_PICKAXE);
        int r = isPickaxeable ? 0 : 2;

        if(tier == Tiers.WOOD || tier == Tiers.STONE || tier == Tiers.IRON || tier == InstrumentusItemTiers.COPPER || tier == Tiers.GOLD || tier == Tiers.DIAMOND || tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED){
            r = 1;
        }

        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);

        int numberTrimmed = 0;

        if(isPickaxeable && !entity.isCrouching())
        {
            numberTrimmed += trim(stack, entity, level, pos, r, TrimType.TRIM_ROCK);
        }
        return numberTrimmed > 0;
    }

    public int trim(ItemStack stack, LivingEntity entity, Level level, BlockPos blockPos, int r, TrimType trimType){
        int numberTrimmed = 0;
        Player player = (Player) entity;

        BlockHitResult blockHitResult = new BlockHitResult(new Vec3(player.getX(), player.getY(), player.getZ()), getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE).getDirection(), blockPos, false);
        Direction blockFaceMined = blockHitResult.getDirection();

        if(blockFaceMined == Direction.EAST || blockFaceMined == Direction.WEST) {
            for (int dz = -r; dz <= r; dz++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dz == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(0, dy, dz), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if(blockFaceMined == Direction.NORTH || blockFaceMined == Direction.SOUTH) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dy = -r; dy <= r; dy++) {
                    if (dy == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(dx, dy, 0), entity, stack)) {
                        numberTrimmed++;
                        stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    }
                }
            }
        } else if (blockFaceMined == Direction.UP || blockFaceMined == Direction.DOWN) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (dz == 0 && dx == 0)
                        continue;
                    if (trimType.trimAtPos(level, blockPos.offset(dx, 0, dz), entity, stack)) {
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

        public boolean trimAtPos(Level level, BlockPos pos, LivingEntity entity, ItemStack item)
        {
            BlockState state = level.getBlockState(pos);
            BlockEntity blockEntity = level.getBlockEntity(pos);

            BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(level, pos, state, (Player) entity);
            NeoForge.EVENT_BUS.post(event);

            //noinspection SwitchStatementWithTooFewBranches
            return switch (this) {
                default -> {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) && state.canHarvestBlock(level, pos, (Player) entity)) {
                        state.getBlock().playerDestroy(level, (Player) entity, pos, state, blockEntity, item);
                        level.removeBlock(pos, false);
                        yield true;
                    }
                    yield false;
                }
            };
        }
    }


}
