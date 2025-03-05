package com.beanbot.instrumentus.client.ponder;

import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.foundation.PonderScene;
import net.createmod.ponder.foundation.PonderSceneBuilder;

public class InstrumentusSceneBuilder extends PonderSceneBuilder {

    public InstrumentusSceneBuilder(SceneBuilder baseSceneBuilder) {
        this(baseSceneBuilder.getScene());
    }

    private InstrumentusSceneBuilder(PonderScene ponderScene) {
        super(ponderScene);
    }
}
