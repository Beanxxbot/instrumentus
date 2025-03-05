package com.beanbot.instrumentus.client.ponder.scenes;

import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class EnergizedScenes {
    public static void lightningRod(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("energized_lightning_rod", "Charging Energized Tools");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        ItemStack itemStack = new ItemStack(InstrumentusItems.ENERGIZED_PICKAXE.get());
        Vec3 entitySpawnPos = util.vector().of(2, 2, 2);
        scene.world().createItemEntity(entitySpawnPos, util.vector().of(0, 0.2, 0), itemStack);
        scene.overlay().showText(80).pointAt(entitySpawnPos).text("Energized Tools can be charged using any modded Forge Energy Charger.");
        scene.idle(100);
        scene.addKeyframe();

        scene.overlay().showText(120).independent(10).text("When an Energized Tool is struck by Lightning, it will be fully charged!");
        scene.idle(20);
        scene.overlay().showText(40).pointAt(entitySpawnPos).text("0 FE/20,000 FE").colored(PonderPalette.RED);
        scene.idle(50);

        scene.world().createEntity(w -> {
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(w);
            Vec3 v = util.vector().of(3, 1, 3);
            lightningBolt.setPosRaw(v.x, v.y, v.z);
            return lightningBolt;
        });
        scene.idle(10);
        scene.world().modifyEntities(LightningBolt.class, Entity::discard);
        scene.overlay().showText(40).pointAt(entitySpawnPos).text("20,000 FE/20,000 FE").colored(PonderPalette.GREEN);
        scene.idle(60);
        scene.addKeyframe();

        scene.overlay().showText(80).pointAt(util.vector().of(2.75, 2, 2.75)).text("Lightning can be induced using an Energized Di-Emerald Lightning Rod. This consumes FE from the Tool.");
        scene.idle(40);
        scene.overlay().showControls(util.vector().of(2.5, 3, 2.5), Pointing.DOWN, 40).rightClick().withItem(InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get().getDefaultInstance());
        scene.idle(20);
        scene.world().createEntity(w -> {
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(w);
            Vec3 v = util.vector().of(3, 1, 3);
            lightningBolt.setPosRaw(v.x, v.y, v.z);
            return lightningBolt;
        });
        scene.idle(10);
        scene.world().modifyEntities(LightningBolt.class, Entity::discard);
        scene.idle(60);
    }
}
