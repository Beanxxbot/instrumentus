package com.beanbot.instrumentus.common.items;
import com.beanbot.instrumentus.common.data.generator.InstrumentusGeneratorBlockTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;
import static net.neoforged.neoforge.common.ItemAbilities.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class PaxelItem extends DiggerItem {

    private static final ItemAbility PAXEL_DIG = ItemAbility.get("paxel_dig");

    protected Tier material;

    public static final Set<ItemAbility> DEFAULT_PAXEL_ACTIONS = Set.of(
            AXE_DIG, AXE_STRIP, AXE_SCRAPE, AXE_WAX_OFF,
            SHOVEL_DIG, SHOVEL_FLATTEN,
            PICKAXE_DIG);

    public PaxelItem(Tier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, InstrumentusGeneratorBlockTags.MINEABLE_WITH_PAXEL, generateItemProperties(tier, attackDamageIn, attackSpeedIn));
        this.material = tier;
    }

    private static Item.Properties generateItemProperties(Tier tier, float attackDamageIn, float attackSpeedIn) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            return new Item.Properties().attributes(AxeItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        }
        return new Item.Properties().attributes(AxeItem.createAttributes(tier, attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility toolAction){
        return DEFAULT_PAXEL_ACTIONS.contains(toolAction) || toolAction == PAXEL_DIG;
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return super.getDestroySpeed(stack, state) == 1 ? 1 : material.getSpeed();
    }

    @Nonnull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState resultToSet = useAsAxe(blockstate, context);
        Player player = context.getPlayer();
        if (resultToSet == null){
            if (context.getClickedFace() == Direction.DOWN){
                return InteractionResult.PASS;
            }
            BlockState foundResult = blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false);
            if (foundResult != null && world.isEmptyBlock(blockpos.above())){
                world.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!world.isClientSide) {
                    world.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, blockpos, 0);
                }
                CampfireBlock.dowse(player, world, blockpos, blockstate);
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
            }
            if (resultToSet == null) {
                return InteractionResult.PASS;
            }
        }
        if (!world.isClientSide) {
            ItemStack stack = context.getItemInHand();
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockpos, stack);
            }
            world.setBlock(blockpos, resultToSet, Block.UPDATE_ALL_IMMEDIATE);
            if (player != null) {
                stack.hurtAndBreak(1, player, context.getItemInHand().getEquipmentSlot());
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    @Nullable
    private BlockState useAsAxe(BlockState blockstate, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState resultToSet = blockstate.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        resultToSet = blockstate.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        resultToSet = blockstate.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false);
        if (resultToSet != null){
            world.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0f, 1.0f);
            return resultToSet;
        }
        return null;
    }

}
