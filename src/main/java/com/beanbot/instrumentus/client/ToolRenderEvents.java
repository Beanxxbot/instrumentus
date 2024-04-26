package com.beanbot.instrumentus.client;

import com.beanbot.instrumentus.common.items.HammerItem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

import java.util.ArrayList;
import java.util.List;

public class ToolRenderEvents {

    @SuppressWarnings("unused")
    @SubscribeEvent
    static void renderBlockOutline(RenderHighlightEvent.Block event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        Level world = player.level();

        ItemStack stack = player.getMainHandItem();
        if (stack.isEmpty() || (!(stack.getItem() instanceof HammerItem hammerItem))){
            return;
        }

        BlockHitResult blockTrace = event.getTarget();
        BlockPos origin = blockTrace.getBlockPos();
        BlockState state = world.getBlockState(origin);
        if (!state.canHarvestBlock(world, origin, player)){
            return;
        }

        Vec3 cameraPos = event.getCamera().getPosition();
        double cX = cameraPos.x();
        double cY = cameraPos.y();
        double cZ = cameraPos.z();
        VertexConsumer vertexConsumer = event.getMultiBufferSource().getBuffer(RenderType.LINES);
        if (stack.isCorrectToolForDrops(state)) {
            int range = 3;
            List<BlockPos> affectedBlocks = getAffectedBlocks(world, player);
            for (BlockPos blockPos : affectedBlocks){
                if (blockPos.equals(origin)) continue;
                renderHitOutline(event.getPoseStack(), vertexConsumer, player, cX, cY, cZ, world, blockPos, world.getBlockState(blockPos));
            }
        }
    }
    //Many thanks to Direwolf20 for the code that finally helped me implement this
    private static void renderHitOutline(
            PoseStack poseStack,
            VertexConsumer vertexConsumer,
            Entity player,
            double cX,
            double cY,
            double cZ,
            Level world,
            BlockPos blockPos,
            BlockState blockState) {
        renderShape(poseStack, vertexConsumer, blockState.getShape(world, blockPos, CollisionContext.of(player)), (double) blockPos.getX() - cX, (double) blockPos.getY() - cY, (double) blockPos.getZ() - cZ);
    }

    private static void renderShape(PoseStack poseStack,
                                    VertexConsumer vertexConsumer,
                                    VoxelShape shape,
                                    double x,
                                    double y,
                                    double z) {
        PoseStack.Pose posestack$pose = poseStack.last();
        shape.forAllEdges(
                (p_234280_, p_234281_, p_234282_, p_234283_, p_234284_, p_234285_) -> {
                    float f = (float) (p_234283_ - p_234280_);
                    float f1 = (float) (p_234284_ - p_234281_);
                    float f2 = (float) (p_234285_ - p_234282_);
                    float f3 = Mth.sqrt(f * f + f1 * f1 + f2 * f2);
                    f /= f3;
                    f1 /= f3;
                    f2 /= f3;
                    vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234280_ + x), (float) (p_234281_ + y), (float) (p_234282_ + z))
                            .color((float) 0.0, (float) 0.0, (float) 0.0, (float) 0.2)
                            .normal(posestack$pose.normal(), f, f1, f2)
                            .endVertex();
                    vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234283_ + x), (float) (p_234284_ + y), (float) (p_234285_ + z))
                            .color((float) 0.0, (float) 0.0, (float) 0.0, (float) 0.2)
                            .normal(posestack$pose.normal(), f, f1, f2)
                            .endVertex();
                }
        );
    }

    public static List<BlockPos> getAffectedBlocks(Level world, Player player) {
        List<BlockPos> affectedBlocks = new ArrayList<>();
        double maxDistance = 5.0; // Maximum look distance

        HitResult result = player.pick(maxDistance, 0.0f, false);
        if (result.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHitResult = (BlockHitResult) result;
            BlockPos targetBlockPos = blockHitResult.getBlockPos();
            Direction blockFaceMined = blockHitResult.getDirection();
            int aoeRadius = 1;

            if(blockFaceMined == Direction.EAST || blockFaceMined == Direction.WEST/*look.x >= -1 && look.x <= -0.75 || look.x <= 1 && look.x >= 0.75*/) {
                for (int dz = -aoeRadius; dz <= aoeRadius; dz++) {
                    for (int dy = -aoeRadius; dy <= aoeRadius; dy++) {
                        if (dy == 0 && dz == 0)
                            continue;
                        BlockPos blockPos = targetBlockPos.offset(0, dy, dz);
                        BlockState state = world.getBlockState(blockPos);
                        if (state.getBlock() != Blocks.AIR && state.canHarvestBlock(world, blockPos, player)) {
                            affectedBlocks.add(blockPos);
                        }
                    }
                }
            } else if(blockFaceMined == Direction.NORTH || blockFaceMined == Direction.SOUTH/*look.z >= -1 && look.z <= -0.75 || look.z <= 1 && look.z >= 0.75*/) {
                for (int dx = -aoeRadius; dx <= aoeRadius; dx++) {
                    for (int dy = -aoeRadius; dy <= aoeRadius; dy++) {
                        if (dy == 0 && dx == 0)
                            continue;
                        BlockPos blockPos = targetBlockPos.offset(dx, dy, 0);
                        BlockState state = world.getBlockState(blockPos);
                        if (state.getBlock() != Blocks.AIR && state.canHarvestBlock(world, blockPos, player)) {
                            affectedBlocks.add(blockPos);
                        }
                    }
                }
            } else if (blockFaceMined == Direction.UP || blockFaceMined == Direction.DOWN /*look.y >= -1 && look.y <= -0.75 || look.y <= 1 && look.y >= 0.75*/) {
                for (int dx = -aoeRadius; dx <= aoeRadius; dx++) {
                    for (int dz = -aoeRadius; dz <= aoeRadius; dz++) {
                        if (dz == 0 && dx == 0)
                            continue;
                        BlockPos blockPos = targetBlockPos.offset(dx, 0, dz);
                        BlockState state = world.getBlockState(blockPos);
                        if (state.getBlock() != Blocks.AIR && state.canHarvestBlock(world, blockPos, player)) {
                            affectedBlocks.add(blockPos);
                        }
                    }
                }
            }

        }
        return affectedBlocks;
    }
}
