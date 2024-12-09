package com.beanbot.instrumentus.common.blocks;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.data.attachments.InstrumentusDataAttachments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class WindBlowerBlock extends Block {

    public static final int MIN_CHARGES = 0;
    public static final int MAX_CHARGES = 4;
    public static final IntegerProperty BLOWER_CHARGE = IntegerProperty.create("blower_charges", MIN_CHARGES, MAX_CHARGES);

    public WindBlowerBlock() {
        super(Properties.of().sound(SoundType.POLISHED_TUFF).strength(2.0f).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "wind_blower"))));
        this.registerDefaultState(this.stateDefinition.any().setValue(BLOWER_CHARGE, Integer.valueOf(0)));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(Items.BREEZE_ROD) && state.getValue(BLOWER_CHARGE) < 4) {
            BlockState blockState = state.setValue(BLOWER_CHARGE, state.getValue(BLOWER_CHARGE) + 1);
            level.setBlock(pos, blockState, 3);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            player.setData(InstrumentusDataAttachments.BOUND_WIND_BLOWER, hitResult.getBlockPos());
            if (state.getValue(BLOWER_CHARGE) == 0) {
                level.playLocalSound(pos, SoundEvents.BREEZE_CHARGE, SoundSource.BLOCKS, 1.0f, 0.5f, false);
            } else if (state.getValue(BLOWER_CHARGE) == 1) {
                level.playLocalSound(pos, SoundEvents.BREEZE_CHARGE, SoundSource.BLOCKS, 1.0f, 0.75f, false);
            } else if (state.getValue(BLOWER_CHARGE) == 2) {
                level.playLocalSound(pos, SoundEvents.BREEZE_CHARGE, SoundSource.BLOCKS, 1.0f, 1.25f, false);
            } else if (state.getValue(BLOWER_CHARGE) == 3) {
                level.playLocalSound(pos, SoundEvents.BREEZE_CHARGE, SoundSource.BLOCKS, 1.0f, 1.75f, false);
            }
            level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5, 0, 0, 0);
            stack.consume(1, player);
            return InteractionResult.SUCCESS;
        } else if(stack.is(Items.IRON_INGOT)) {
            return InteractionResult.SUCCESS;
        } else {
            return hand == InteractionHand.MAIN_HAND && player.getItemInHand(InteractionHand.OFF_HAND).is(Items.BREEZE_ROD) && state.getValue(BLOWER_CHARGE) < 4
                    ? InteractionResult.PASS
                    : InteractionResult.TRY_WITH_EMPTY_HAND;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(BLOWER_CHARGE) == 0) {
            return InteractionResult.PASS;
        } else {
            if (player.getData(InstrumentusDataAttachments.BOUND_WIND_BLOWER).equals(hitResult.getBlockPos())) {
                return InteractionResult.PASS;
            }
            player.setData(InstrumentusDataAttachments.BOUND_WIND_BLOWER, hitResult.getBlockPos());
            return InteractionResult.SUCCESS_SERVER;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BLOWER_CHARGE, 0);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BLOWER_CHARGE);
    }

    public void preventionSoundAndParticles(Level level, BlockPos pos) {
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 1.75, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 2, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 2.25, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 2.75, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 3, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.WHITE_SMOKE, pos.getX() + 0.5, pos.getY() + 3.25, pos.getZ() + 0.5, 0, 0, 0);
        level.addParticle(ParticleTypes.GUST, pos.getX() + 0.5, pos.getY() + 3.5, pos.getZ() + 0.5, 0, 0, 0);
        level.playLocalSound(pos, SoundEvents.WIND_CHARGE_BURST.value(), SoundSource.BLOCKS, 1.0f, 0.5f, false);
        level.playLocalSound(pos, SoundEvents.PHANTOM_DEATH, SoundSource.BLOCKS, 0.25f, 1.0f, false);
    }
}
