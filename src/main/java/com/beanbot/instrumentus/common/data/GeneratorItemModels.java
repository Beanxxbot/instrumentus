package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GeneratorItemModels extends ItemModelProvider {
    public GeneratorItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Instrumentus.MODID, helper);
    }

    @Override
    protected void registerModels() {
        //Energized
        singleTexture(ModItems.CARBON_ROD.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/carbon_rod"));
        singleTexture(ModItems.ENERGIZED_PICKAXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_pickaxe"));
        singleTexture(ModItems.ENERGIZED_SHOVEL.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_shovel"));
        singleTexture(ModItems.ENERGIZED_AXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_axe"));
        singleTexture(ModItems.ENERGIZED_HOE.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_hoe"));
        singleTexture(ModItems.ENERGIZED_PAXEL.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_paxel"));
        singleTexture(ModItems.ENERGIZED_HAMMER.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_hammer"));
        singleTexture(ModItems.ENERGIZED_SICKLE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_sickle"));
        singleTexture(ModItems.ENERGIZED_KNIFE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_knife"));
        singleTexture(ModItems.ENERGIZED_SHEARS.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_shears"));
        singleTexture(ModItems.ENERGIZED_INGOT.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_ingot"));
        singleTexture(ModItems.ENERGIZED_LIGHTNING_ROD.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/energy_lightning_rod"));
        withExistingParent(ModItems.ENERGIZED_BLOCK.getId().getPath(), modLoc("block/energy_block"));
        singleTexture(ModItems.ENERGIZED_EXCAVATOR.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/energy_excavator"));

        //Soulcopper
        singleTexture(ModItems.SOULCOPPER_PICKAXE.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/soulcopper_pickaxe"));
        singleTexture(ModItems.SOULCOPPER_INGOT.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/soulcopper_ingot"));
        singleTexture(ModItems.RAW_SOULCOPPER.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/raw_soulcopper"));
        withExistingParent(ModItems.SOULCOPPER_BLOCK.getId().getPath(), modLoc("block/soulcopper_block"));
        withExistingParent(ModItems.RAW_SOULCOPPER_BLOCK.getId().getPath(), modLoc("block/raw_soulcopper_block"));
        singleTexture(ModItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/copper_soul_campfire"));
        singleTexture(ModItems.SOULCOPPER_TORCH_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("block/copper_soul_torch"));
        singleTexture(ModItems.SOULCOPPER_LANTERN_ITEM.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/copper_soul_lantern"));
        withExistingParent(ModItems.COPPER_SOUL_FLAME_LIGHT_ITEM.getId().getPath(), modLoc("block/copper_soul_fire_flame"));
        singleTexture(ModItems.SOULCOPPER_BURNER.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/soulcopper_burner"));

        registerTools();
    }

    public void registerTools() {
        for (var tool : ModItems.SHEARS.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/generated")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.SICKLES.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.PAXELS.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.HAMMERS.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.KNIVES.getEntries()) {
            if (tool == ModItems.PLANT_FIBER) {
                singleTexture(ModItems.PLANT_FIBER.getId().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/plant_fiber"));
            }
            else {
                ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
                getBuilder(tool.getId().getPath())
                        .parent(getExistingFile(mcLoc("item/handheld")))
                        .texture("layer0", modelPath);
            }
        }
        for (var tool : ModItems.COPPER.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.BRUSHES.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
        for (var tool : ModItems.EXCAVATORS.getEntries()) {
            ResourceLocation modelPath = modLoc("item/" + tool.getId().getPath());
            getBuilder(tool.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/handheld")))
                    .texture("layer0", modelPath);
        }
    }
}