package com.beanbot.instrumentus.client.ponder.scenes;

import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;


public class PaxelScenes {
    public static void paxelsMining(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("paxel_mining", "Paxel Mining");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);

        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(5);

        BlockPos grassPos = util.grid().at(1, 1, 1);
        BlockPos stonePos = util.grid().at(2, 1, 1);
        BlockPos logPos = util.grid().at(3, 1, 1);
        scene.overlay().showText(70).independent(10).text("Paxels can be used to mine Shovel Blocks...");
        scene.overlay().showControls(util.vector().topOf(grassPos), Pointing.DOWN, 60).leftClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        for (int i = 0; i < 6; i++) {
            scene.world().incrementBlockBreakingProgress(grassPos);
            scene.idle(10);
        }
        scene.world().destroyBlock(grassPos);
        scene.idle(10);
        scene.addKeyframe();

        scene.overlay().showText(70).independent(10).text("Pickaxe Blocks...");
        scene.overlay().showControls(util.vector().topOf(stonePos), Pointing.DOWN, 60).leftClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        for (int i = 0; i < 6; i++) {
            scene.world().incrementBlockBreakingProgress(stonePos);
            scene.idle(10);
        }
        scene.world().destroyBlock(stonePos);
        scene.idle(10);
        scene.addKeyframe();

        scene.overlay().showText(70).independent(10).text("and Axe Blocks!");
        scene.overlay().showControls(util.vector().topOf(logPos), Pointing.DOWN, 60).leftClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        for (int i = 0; i < 6; i++) {
            scene.world().incrementBlockBreakingProgress(logPos);
            scene.idle(10);
        }
        scene.world().destroyBlock(logPos);
        scene.idle(10);
        scene.addKeyframe();
    }

    public static void paxelsStrippingPathing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("paxel_stripping_pathing", "The Paxel's Secondary Actions");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);

        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        BlockPos grassPos = util.grid().at(1, 1, 1);
        BlockPos copperPos = util.grid().at(2, 1, 1);
        BlockPos logPos = util.grid().at(3, 1, 1);
        scene.overlay().showText(100).independent(10).text("Paxels can also perform the secondary actions that Axes and Shovels do.");
        scene.overlay().showControls(util.vector().topOf(grassPos), Pointing.DOWN, 40).rightClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        scene.idle(20);
        scene.world().replaceBlocks(util.select().position(grassPos), Blocks.DIRT_PATH.defaultBlockState(), true);
        scene.idle(30);

        scene.overlay().showControls(util.vector().topOf(copperPos), Pointing.DOWN, 40).rightClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        scene.idle(20);
        scene.world().replaceBlocks(util.select().position(copperPos), Blocks.EXPOSED_CUT_COPPER.defaultBlockState(), true);
        scene.idle(30);

        scene.overlay().showControls(util.vector().topOf(logPos), Pointing.DOWN, 40).rightClick().withItem(InstrumentusItems.DIAMOND_PAXEL.get().getDefaultInstance());
        scene.idle(20);
        scene.world().replaceBlocks(util.select().position(logPos), Blocks.STRIPPED_OAK_LOG.defaultBlockState(), true);
        scene.idle(30);
    }
}
