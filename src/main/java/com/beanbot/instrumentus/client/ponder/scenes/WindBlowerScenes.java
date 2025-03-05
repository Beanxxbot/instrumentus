package com.beanbot.instrumentus.client.ponder.scenes;

import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.ParticleEmitter;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

public class WindBlowerScenes {
    public static void windBlower(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("wind_blower", "Wind Blower");
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(10);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        BlockPos blower = util.grid().at(2, 1, 2);
        Selection blowerSelection = util.select().position(blower);
        scene.overlay().showText(80).pointAt(blower.getCenter()).text("This is a Wind Blower, designed to prevent Phantoms from spawning.");
        scene.idle(100);

        scene.overlay().showControls(util.vector().blockSurface(blower, Direction.UP), Pointing.DOWN, 60).rightClick();
        scene.overlay().showText(80).pointAt(blower.getCenter()).text("When right clicked, the Wind Blower will be bound to the player.");
        scene.idle(100);
        scene.addKeyframe();

        Vec3 emitterPos = util.vector().of(2.5, 0.5, 2.5);
        ParticleEmitter emitter = scene.effects().simpleParticleEmitter(ParticleTypes.WHITE_SMOKE, util.vector().of(0, 0, 0));

        scene.overlay().showControls(util.vector().blockSurface(blower, Direction.UP), Pointing.DOWN, 60).rightClick().withItem(Items.BREEZE_ROD.getDefaultInstance());
        scene.overlay().showText(80).pointAt(blower.getCenter()).text("When right clicked with a Breeze Rod, the Wind Blower will gain one charge. It can hold up to 4 charges.");
        scene.idle(30);
        scene.world().replaceBlocks(blowerSelection, InstrumentusBlocks.WIND_BLOWER.get().defaultBlockState().setValue(WindBlowerBlock.BLOWER_CHARGE, 1), false);
        scene.idle(100);

        scene.overlay().showControls(util.vector().blockSurface(blower, Direction.UP), Pointing.DOWN, 20).rightClick().withItem(Items.BREEZE_ROD.getDefaultInstance());
        scene.world().replaceBlocks(blowerSelection, InstrumentusBlocks.WIND_BLOWER.get().defaultBlockState().setValue(WindBlowerBlock.BLOWER_CHARGE, 2), false);
        scene.idle(40);

        scene.overlay().showControls(util.vector().blockSurface(blower, Direction.UP), Pointing.DOWN, 20).rightClick().withItem(Items.BREEZE_ROD.getDefaultInstance());
        scene.world().replaceBlocks(blowerSelection, InstrumentusBlocks.WIND_BLOWER.get().defaultBlockState().setValue(WindBlowerBlock.BLOWER_CHARGE, 3), false);
        scene.idle(40);

        scene.overlay().showControls(util.vector().blockSurface(blower, Direction.UP), Pointing.DOWN, 20).rightClick().withItem(Items.BREEZE_ROD.getDefaultInstance());
        scene.world().replaceBlocks(blowerSelection, InstrumentusBlocks.WIND_BLOWER.get().defaultBlockState().setValue(WindBlowerBlock.BLOWER_CHARGE, 4), false);
        scene.idle(40);
        scene.addKeyframe();

        scene.overlay().showText(100).pointAt(util.vector().topOf(blower)).text("When Phantoms attempt to spawn on a player, if they have a charged Wind Blower Bound, they will be prevented from spawning.");
        scene.idle(40);

        scene.world().createEntity(w -> {
            Phantom phantomEntity = EntityType.PHANTOM.create(w);
            Vec3 v = util.vector().of(2, 5, 2);
            phantomEntity.setYRot(180);
            phantomEntity.setPosRaw(v.x, v.y, v.z);
            return phantomEntity;
        });
        scene.idle(60);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 1.25, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 1.5, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 1.75, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 2, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 2.25, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 2.5, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 2.75, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 3, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 3.25, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 3.5, 0)), emitter, 1, 1);
        scene.effects().emitParticles(emitterPos.add(new Vec3(0, 3.75, 0)), emitter, 1, 1);
        scene.world().replaceBlocks(blowerSelection, InstrumentusBlocks.WIND_BLOWER.get().defaultBlockState().setValue(WindBlowerBlock.BLOWER_CHARGE, 3), false);
        scene.world().modifyEntities(Phantom.class, Entity::discard);

    }
}
