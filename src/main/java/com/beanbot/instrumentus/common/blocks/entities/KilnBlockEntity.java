package com.beanbot.instrumentus.common.blocks.entities;

import com.beanbot.instrumentus.common.inventory.KilnMenu;
import com.beanbot.instrumentus.common.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KILN_BLOCK_ENTITY.get(), pos, state, ModRecipes.FIRING.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("instrumentus.container.kiln");
    }

    @Override
    protected int getBurnDuration(ItemStack fuel) {
        return super.getBurnDuration(fuel) / 2;
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, Inventory player) {
        return new KilnMenu(id, player, this, this.dataAccess);
    }
}
