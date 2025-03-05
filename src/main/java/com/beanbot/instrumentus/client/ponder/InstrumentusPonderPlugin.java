package com.beanbot.instrumentus.client.ponder;

import com.beanbot.instrumentus.common.Instrumentus;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class InstrumentusPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return Instrumentus.MODID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        InstrumentusPonderScenes.register(helper);
    }
}
