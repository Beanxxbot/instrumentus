package com.beanbot.instrumentus.compat.jade;

import com.beanbot.instrumentus.common.blocks.CopperSoulCampfireBlock;
import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class InstrumentusJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerItemStorage(CopperFueledSoulCampfireProvider.INSTANCE, CopperSoulCampfireBlock.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(WindBlowerProvider.INSTANCE, WindBlowerBlock.class);
        registration.registerItemStorageClient(CopperFueledSoulCampfireProvider.INSTANCE);
    }

}
