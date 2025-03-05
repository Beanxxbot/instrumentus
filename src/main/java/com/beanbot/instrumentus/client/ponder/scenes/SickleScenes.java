package com.beanbot.instrumentus.client.ponder.scenes;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class SickleScenes {
    public static void sicklesMining(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("sickle_mining", "Sickle Mining");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);

        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        Selection leaves = util.select().cuboid(new BlockPos(1, 1, 1), new Vec3i(2, 2, 1));
        BlockPos breakingLeaf = util.grid().at(2, 2, 1);
        scene.overlay().showText(70).independent(10).text("Sickles can be used to harvest large areas of leaves");
        scene.overlay().showControls(util.vector().blockSurface(new BlockPos(2, 2, 1), Direction.NORTH), Pointing.RIGHT, 60).leftClick().withItem(InstrumentusItems.STONE_SICKLE.get().getDefaultInstance());
        scene.overlay().showOutline(PonderPalette.BLACK, leaves, leaves, 70);
        for (int i = 0; i < 8; i++) {
            scene.world().incrementBlockBreakingProgress(breakingLeaf);
            scene.idle(10);
        }
        scene.world().setBlocks(leaves, Blocks.AIR.defaultBlockState(), true);
        scene.idle(40);
    }
    public static void sicklesMiningUpgraded(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("sickle_mining_upgraded", "Sickle Mining");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);

        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        Selection leaves = util.select().cuboid(new BlockPos(0, 1, 1), new Vec3i(4, 4, 3));

        scene.overlay().showText(70).independent(10).text("Better Sickles have a larger area of effect");
        scene.overlay().showControls(util.vector().blockSurface(new BlockPos(2, 3, 1), Direction.NORTH), Pointing.RIGHT, 60).leftClick().withItem(InstrumentusItems.NETHERITE_SICKLE.get().getDefaultInstance());
        scene.overlay().showOutline(PonderPalette.BLACK, leaves, leaves, 70);
        BlockPos breakingLeaf = util.grid().at(2, 3, 1);
        for (int i = 0; i < 8; i++) {
            scene.world().incrementBlockBreakingProgress(breakingLeaf);
            scene.idle(10);
        }
        scene.world().setBlocks(leaves, Blocks.AIR.defaultBlockState(), true);
        scene.idle(40);
    }
    public static void sicklesVegetationHarvesting(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("sickle_vegetation_harvesting", "Sickle Harvesting");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(80).pointAt(new Vec3(2, 2, 1)).text("Sickles can also be used to harvest vegetation in an area");
        scene.idle(60);
        scene.overlay().showControls(util.vector().topOf(new BlockPos(2, 2, 1)), Pointing.DOWN, 40).leftClick().withItem(InstrumentusItems.DIAMOND_SICKLE.get().getDefaultInstance());
        scene.idle(20);
        Selection gf1 = util.select().cuboid(new BlockPos(0, 2, 0), new Vec3i(2, 1, 2));
        Selection gf2 = util.select().cuboid(new BlockPos(3, 2, 1), new Vec3i(2, 0, 2));
        Selection grassFlowers = gf1.add(gf2);
        scene.world().replaceBlocks(grassFlowers, Blocks.AIR.defaultBlockState(), true);
        scene.idle(80);
        scene.addKeyframe();

        scene.overlay().showText(80).pointAt(new Vec3(1, 2, 4)).text("Sickles will only harvest fully grown crops");
        scene.idle(40);
        scene.overlay().showControls(util.vector().topOf(new BlockPos(1, 2, 4)), Pointing.DOWN, 40).leftClick().withItem(InstrumentusItems.DIAMOND_SICKLE.get().getDefaultInstance());
        scene.idle(20);
        scene.world().replaceBlocks(util.select().position(new BlockPos(1, 2, 4)),Blocks.AIR.defaultBlockState(), true);

    }
}
