package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.EnergyBrushItem;
import com.beanbot.instrumentus.common.items.InstrumentusBrushItem;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import com.beanbot.instrumentus.common.items.InstrumentusShearsItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class InstrumentusGeneratorItemModels extends ItemModelProvider {
    public InstrumentusGeneratorItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Instrumentus.MODID, helper);
    }

    @Override
    protected void registerModels() {
        //Energized
        singleTexture(InstrumentusItems.CARBON_ROD.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/carbon_rod"));
        singleTexture(InstrumentusItems.ENERGIZED_PICKAXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_pickaxe"));
        singleTexture(InstrumentusItems.ENERGIZED_SHOVEL.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_shovel"));
        singleTexture(InstrumentusItems.ENERGIZED_AXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_axe"));
        singleTexture(InstrumentusItems.ENERGIZED_HOE.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_hoe"));
        singleTexture(InstrumentusItems.ENERGIZED_PAXEL.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_paxel"));
        singleTexture(InstrumentusItems.ENERGIZED_HAMMER.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_hammer"));
        singleTexture(InstrumentusItems.ENERGIZED_SICKLE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_sickle"));
        singleTexture(InstrumentusItems.ENERGIZED_KNIFE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_knife"));
        singleTexture(InstrumentusItems.ENERGIZED_SHEARS.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_shears"));
        singleTexture(InstrumentusItems.ENERGIZED_INGOT.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_ingot"));
        singleTexture(InstrumentusItems.ENERGIZED_LIGHTNING_ROD.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_lightning_rod"));
        withExistingParent(InstrumentusItems.ENERGIZED_BLOCK.getId().getPath(), modLoc("block/energy_block"));
        singleTexture(InstrumentusItems.ENERGIZED_EXCAVATOR.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_excavator"));

        //Soulcopper
        singleTexture(InstrumentusItems.SOULCOPPER_PICKAXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/soulcopper_pickaxe"));
        singleTexture(InstrumentusItems.SOULCOPPER_INGOT.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/soulcopper_ingot"));
        singleTexture(InstrumentusItems.RAW_SOULCOPPER.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/raw_soulcopper"));
        withExistingParent(InstrumentusItems.SOULCOPPER_BLOCK.getId().getPath(), modLoc("block/soulcopper_block"));
        withExistingParent(InstrumentusItems.RAW_SOULCOPPER_BLOCK.getId().getPath(), modLoc("block/raw_soulcopper_block"));
        singleTexture(InstrumentusItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/copper_soul_campfire"));
        singleTexture(InstrumentusItems.SOULCOPPER_TORCH_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("block/copper_soul_torch"));
        singleTexture(InstrumentusItems.SOULCOPPER_LANTERN_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/copper_soul_lantern"));
        withExistingParent(InstrumentusItems.COPPER_SOUL_FLAME_LIGHT_ITEM.getId().getPath(), modLoc("block/copper_soul_fire_flame"));
        singleTexture(InstrumentusItems.SOULCOPPER_BURNER.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/soulcopper_burner"));
        singleTexture(InstrumentusItems.BREEZE_ARMOR_BOOTS.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/breeze_boots"));
        singleTexture(InstrumentusItems.SOULCOPPER_DOOR_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/soulcopper_door"));
        withExistingParent(InstrumentusItems.CUT_SOULCOPPER_ITEM.getId().getPath(), modLoc("block/cut_soulcopper"));
        withExistingParent(InstrumentusItems.SOULCOPPER_GRATE_ITEM.getId().getPath(), modLoc("block/soulcopper_grate"));
        withExistingParent(InstrumentusItems.SOULCOPPER_GRATE_ITEM.getId().getPath(), modLoc("block/soulcopper_grate"));
        withExistingParent(InstrumentusItems.SOULCOPPER_TRAPDOOR_ITEM.getId().getPath(), modLoc("block/soulcopper_trapdoor_bottom"));
        stairs(InstrumentusItems.CUT_SOULCOPPER_STAIRS_ITEM.getId().getPath(), modLoc("block/cut_soulcopper"), modLoc("block/cut_soulcopper"), modLoc("block/cut_soulcopper"));
        slab(InstrumentusItems.CUT_SOULCOPPER_SLAB_ITEM.getId().getPath(), modLoc("block/cut_soulcopper"), modLoc("block/cut_soulcopper"), modLoc("block/cut_soulcopper"));
        withExistingParent(InstrumentusItems.CHISELED_SOULCOPPER_ITEM.getId().getPath(), modLoc("block/chiseled_soulcopper"));
        withExistingParent(InstrumentusItems.SOULCOPPER_BULB_ITEM.getId().getPath(), modLoc("block/soulcopper_bulb"));

        withExistingParent(InstrumentusItems.KILN_BLOCK_ITEM.getId().getPath(), modLoc("block/kiln"));
        withExistingParent(InstrumentusItems.WIND_BLOWER.getId().getPath(), modLoc("block/wind_blower"));

        singleTexture(InstrumentusItems.PLANT_FIBER.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/plant_fiber"));

        registerTools();
    }

    public void registerTools() {
        for (var tool : InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (tool.get() instanceof TieredItem) {
                ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
                getBuilder(tool.getId().getPath())
                        .parent(getExistingFile(mcLoc("item/handheld")))
                        .texture("layer0", modelPath);
            } else if (tool.get() instanceof InstrumentusShearsItem) {
                ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
                getBuilder(tool.getId().getPath())
                        .parent(getExistingFile(mcLoc("item/generated")))
                        .texture("layer0", modelPath);
            } else if (tool.get() instanceof InstrumentusBrushItem || tool.get() instanceof EnergyBrushItem) {
                ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
                getBuilder(tool.getId().getPath())
                        .parent(getExistingFile(mcLoc("item/brush")))
                        .texture("layer0", modelPath);
            }
        }
    }
}