//package com.beanbot.instrumentus.common.blocks;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockRenderType;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.material.Material;
//import net.minecraft.particles.ParticleTypes;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.util.math.shapes.VoxelShapes;
//import net.minecraft.world.IBlockReader;
//import net.minecraft.world.World;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.Material;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import java.util.Random;
//
//public class IlluminateLight extends Block {
//
//    protected static final VoxelShape SHAPE = Block.box(6.0D, 6.0D, 6.0D, 10.0D, 10.0D, 10.0D);
//
//    public IlluminateLight(){
//        super(
//                Block.Properties
//                        .create(Material.SCULK)
//                        .doesNotBlockMovement()
//                        .hardnessAndResistance(0.0f)
//                        .setLightLevel(e -> 14)
//        );
//    }
//
//    /**
//     * @param state blockState
//     * @return Render Type
//     * @deprecated call via {@link BlockState#getRenderType()}
//     */
//    @Override
//    @SuppressWarnings("deprecation")
//    public BlockRenderType getRenderType(BlockState state){
//        return BlockRenderType.INVISIBLE;
//    }
//
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
//        return VoxelShapes.empty();
//    }
//
//    /**
//     * @deprecated call via {@link BlockState#getPushReaction()}
//     */
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext selectionContext){
//        return SHAPE;
//    }
//
//    @Override
//    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos){
//        return true;
//    }
//
//    @Override
//    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand){
//        double d0 = (double) pos.getX() + 0.5D;
//        double d1 = (double) pos.getY() + 0.5D;
//        double d2 = (double) pos.getZ() + 0.5D;
//        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0, d1, d2, 0.0d, 0.0d, 0.0d);
////        worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0d, 0.01d, 0.0d);
////        worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0d, 0.01d, 0.0d);
//    }
//}
