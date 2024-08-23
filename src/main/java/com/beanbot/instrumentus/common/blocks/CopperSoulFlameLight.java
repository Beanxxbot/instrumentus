package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.client.particles.InstrumentusParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CopperSoulFlameLight extends Block {

    protected static final VoxelShape SHAPE = Block.box(6.0D, 6.0D, 6.0D, 10.0D, 10.0D, 10.0D);

    public CopperSoulFlameLight(){
        super(
                Block.Properties
                        .ofFullCopy(Blocks.SCULK)
                        .noCollission()
                        .destroyTime(0.0f)
                        .lightLevel(e -> 14)
        );
    }
    /**
     * @param state blockState
     * @return Render Type
     * @deprecated call via {@link BlockState#getRenderShape()} whenever possible. Implementing/overriding is fine.
     */
    @Override
    @SuppressWarnings("deprecation")
    public RenderShape getRenderShape(BlockState state){
        return RenderShape.INVISIBLE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context){
        return Shapes.empty();
    }

    /**
     * @deprecated call
     */
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext selectionContext){
        return SHAPE;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos){
        return true;
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand){
        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY() + 0.5D;
        double d2 = (double) pos.getZ() + 0.5D;
        worldIn.addParticle((SimpleParticleType) InstrumentusParticles.COPPER_SOUL_FIRE_FLAME_PARTICLE.get(), d0, d1, d2, 0.0d, 0.0d, 0.0d);
    }
}
