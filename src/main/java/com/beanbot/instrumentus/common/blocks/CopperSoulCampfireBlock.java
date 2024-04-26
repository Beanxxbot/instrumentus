package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.blocks.entities.CopperSoulCampfireBlockEntity;
import com.beanbot.instrumentus.common.blocks.entities.ModBlockEntities;
import com.beanbot.instrumentus.recipe.CopperSoulCampfireRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.ToIntFunction;

public class CopperSoulCampfireBlock extends CampfireBlock {

    //TODO: 1.20.5 Refactor
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    public CopperSoulCampfireBlock() {
        super(false, 3, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).strength(2.0f).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion());

        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true).setValue(SIGNAL_FIRE, false).setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof CopperSoulCampfireBlockEntity) {
            CopperSoulCampfireBlockEntity soulCampfireBlockEntity = (CopperSoulCampfireBlockEntity) blockentity;
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            Optional<RecipeHolder<CopperSoulCampfireRecipe>> optional = soulCampfireBlockEntity.getCookableRecipe(itemstack);
            if (optional.isPresent()) {
                if (!pLevel.isClientSide && soulCampfireBlockEntity.placeFood(pPlayer, pPlayer.getAbilities().instabuild ? itemstack.copy() : itemstack, ((CopperSoulCampfireRecipe) ((RecipeHolder) optional.get()).value()).getCookingTime())) {
                    pPlayer.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return InteractionResult.SUCCESS;
                }

                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockentity = world.getBlockEntity(pos);
            if (blockentity instanceof CopperSoulCampfireBlockEntity) {
                Containers.dropContents(world, pos, ((CopperSoulCampfireBlockEntity)blockentity).getItems());
            }

            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperSoulCampfireBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> blockEntityType) {
        if (world.isClientSide) {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, ModBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireBlockEntity::particleTick) : null;
        } else {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, ModBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireBlockEntity::cookTick) : createTickerHelper(blockEntityType, ModBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireBlockEntity::cooldownTick);
        }
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (e) -> {
            return e.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }


}
