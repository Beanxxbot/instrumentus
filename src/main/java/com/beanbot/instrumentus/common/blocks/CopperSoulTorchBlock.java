package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.client.particles.InstrumentusParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class CopperSoulTorchBlock extends Block implements SimpleWaterloggedBlock {

    public static BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final int AABB_STANDING_OFFSET = 2;
    protected static final VoxelShape AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);

    public CopperSoulTorchBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean isMoving) {
        if(!level.isClientSide) {
            if(state.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = this.defaultBlockState();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());

        return blockState.setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AABB;
    }

    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource randomSource) {
        return direction == Direction.DOWN && !this.canSurvive(state, level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, randomSource);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return canSupportCenter(pLevel, pPos.below(), Direction.UP);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRand) {
        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.7D;
        double d2 = (double)pPos.getZ() + 0.5D;
        pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        pLevel.addParticle((SimpleParticleType) InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
