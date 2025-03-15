package com.beanbot.instrumentus.compat.jade;

import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum WindBlowerProvider implements IBlockComponentProvider {
    INSTANCE;


    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        int charge = blockAccessor.getBlockState().getValue(WindBlowerBlock.BLOWER_CHARGE);
        tooltip.add(Component.translatable("instrumentus.jade.wind_blower_charge", charge));
    }

    @Override
    public ResourceLocation getUid() {
        return InstrumentusIds.WIND_BLOWER;
    }
}
