package com.beanbot.instrumentus.compat.jade;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.resources.ResourceLocation;

public interface InstrumentusIds {
    ResourceLocation WIND_BLOWER = I("wind_blower");
    ResourceLocation COPPER_FUELED_SOUL_CAMPFIRE = I("copper_fueled_soul_campfire");

    static ResourceLocation I(String path) {
        return ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, path);
    }
}
