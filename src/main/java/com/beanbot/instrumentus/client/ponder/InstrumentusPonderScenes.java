package com.beanbot.instrumentus.client.ponder;

import com.beanbot.instrumentus.client.ponder.scenes.*;
import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.*;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.scene.PonderStoryBoard;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;

public class InstrumentusPonderScenes {

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        for (var item: InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (item.get() instanceof PaxelItem) {
                add("paxel/mining", item.getId().getPath(), helper, PaxelScenes::paxelsMining);
                add("paxel/stripping_pathing", item.getId().getPath(), helper, PaxelScenes::paxelsStrippingPathing);
            } else if (item.get() instanceof SickleItem) {
                add("sickle/mining", item.getId().getPath(), helper, SickleScenes::sicklesMining);
                add("sickle/mining_upgraded", item.getId().getPath(), helper, SickleScenes::sicklesMiningUpgraded);
                add("sickle/vegetation", item.getId().getPath(), helper, SickleScenes::sicklesVegetationHarvesting);
            } else if (item.is(InstrumentusItems.WIND_BLOWER.getKey())) {
                add("wind_blower/wind_blower", item.getId().getPath(), helper, WindBlowerScenes::windBlower);
            } else if (item.get() instanceof EnergyLightningRodItem || item.is(InstrumentusItems.ENERGIZED_INGOT.getKey()) || item.is(InstrumentusItems.ENERGIZED_BLOCK.getKey())) {
                add("energized/lightning_rod", item.getId().getPath(), helper, EnergizedScenes::lightningRod);
            } else if (item.is(InstrumentusItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.getKey()) || item.is(InstrumentusItems.SOULCOPPER_INGOT.getKey()) || item.is(InstrumentusItems.RAW_SOULCOPPER.getKey())) {
                add("soulcopper/smelting", item.getId().getPath(), helper, SoulCopperScenes::soulCopperSmelting);
                if (ModList.get().isLoaded("create")) {
                    add("soulcopper/fan_processing", item.getId().getPath(), helper, SoulCopperScenes::soulCopperFanProcessing);
                }
            }
        }
    }

    public static void add(String schematicId, String storyBoardId, PonderSceneRegistrationHelper<ResourceLocation> helper, PonderStoryBoard storyBoard) {
        helper.addStoryBoard(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, storyBoardId), schematicId, storyBoard).highlightAllTags();
    }

    public static void add(String schematicId, int index, String storyBoardId, PonderSceneRegistrationHelper<ResourceLocation> helper, PonderStoryBoard storyBoard) {
        String schematicPath = schematicId + "_" + index;
        helper.addStoryBoard(ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, storyBoardId), schematicPath, storyBoard).highlightAllTags();
    }

}
