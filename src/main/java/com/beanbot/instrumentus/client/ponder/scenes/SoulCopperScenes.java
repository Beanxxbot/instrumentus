package com.beanbot.instrumentus.client.ponder.scenes;

import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.blocks.entities.CopperSoulCampfireBlockEntity;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class SoulCopperScenes {
    public static void soulCopperSmelting(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("soulcopper_smelting", "Copper-fueled Soul Campfire Smelting");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        BlockPos campfirePos = util.grid().at(2, 1, 1);
        Selection campfire = util.select().position(2, 1, 1);

        scene.overlay().showText(80).independent().text("Soulcopper is a useful material for creating tools, and can also be used to craft new Building Blocks.");
        scene.idle(60);
        scene.overlay().showText(60).pointAt(campfire.getCenter()).text("To get Raw Soulcopper, you can use a Copper-Fueled Soul Campfire to smelt Raw Copper Blocks.");
        scene.idle(40);
        scene.overlay().showControls(util.vector().topOf(campfirePos), Pointing.DOWN, 60).rightClick().withItem(Items.RAW_COPPER_BLOCK.getDefaultInstance());
        scene.idle(40);
        scene.world().modifyBlockEntity(campfirePos, CopperSoulCampfireBlockEntity.class, d -> d.placeFood(null, Items.RAW_COPPER_BLOCK.getDefaultInstance(), 200));
        scene.idle(40);
        scene.overlay().showText(60).pointAt(campfire.getCenter()).text("After a short while, Raw Soulcopper will be produced.");
        scene.idle(40);
        scene.world().restoreBlocks(campfire);
        scene.world().createItemEntity(util.vector().topOf(campfirePos), new Vec3(0, 0.2, -0.08), InstrumentusItems.RAW_SOULCOPPER.get().getDefaultInstance());
        scene.idle(40);
        scene.overlay().showText(60).pointAt(new Vec3(2, 1.5, 0)).text("This Raw Soulcopper can be used to craft a few different things, or be smelted into Soulcopper Ingots in a Blast Furnace.");
    }
}
