package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GeneratorBlockStates extends BlockStateProvider {
    public GeneratorBlockStates(PackOutput output, ExistingFileHelper helper) {
        super(output, Instrumentus.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SOULCOPPER_BLOCK.get(), models().cubeAll(ModBlocks.SOULCOPPER_BLOCK.getId().getPath(), blockTexture(ModBlocks.SOULCOPPER_BLOCK.get())));
        simpleBlock(ModBlocks.RAW_SOULCOPPER_BLOCK.get(), models().cubeAll(ModBlocks.RAW_SOULCOPPER_BLOCK.getId().getPath(), blockTexture(ModBlocks.RAW_SOULCOPPER_BLOCK.get())));
        simpleBlock(ModBlocks.ENERGIZED_BLOCK.get(), models().cubeAll(ModBlocks.ENERGIZED_BLOCK.getId().getPath(), blockTexture(ModBlocks.ENERGIZED_BLOCK.get())));
        simpleBlock(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get(), models().cubeAll(ModBlocks.COPPER_SOUL_FLAME_LIGHT.getId().getPath(), blockTexture(ModBlocks.COPPER_SOUL_FLAME_LIGHT.get())).renderType(RenderType.CUTOUT.name));
        simpleBlock(ModBlocks.SOULCOPPER_TORCH.get(), models().torch(ModBlocks.SOULCOPPER_TORCH.getId().getPath(), modLoc("block/copper_soul_torch")).renderType(RenderType.CUTOUT.name));
        horizontalBlock(ModBlocks.SOULCOPPER_WALL_TORCH.get(), models().torchWall(ModBlocks.SOULCOPPER_WALL_TORCH.getId().getPath(), modLoc("block/copper_soul_torch")).renderType(RenderType.CUTOUT.name), 90);

        getVariantBuilder(ModBlocks.COPPER_SOUL_CAMPFIRE.get()).forAllStates(s -> {
            ModelFile model;
            boolean lit = s.getValue(BlockStateProperties.LIT);
            if (lit) {
                model = models().withExistingParent(ModBlocks.COPPER_SOUL_CAMPFIRE.getId().getPath(), ResourceLocation.parse("minecraft:block/template_campfire"))
                        .texture("fire", modLoc("block/copper_soul_campfire_fire"))
                        .texture("lit_log", modLoc("block/copper_soul_campfire_log_lit"))
                        .renderType(RenderType.CUTOUT.name);
            } else {
                model = models().getExistingFile(mcLoc("block/campfire_off"));
            }
           return ConfiguredModel.builder()
                   .modelFile(model).build();
        });

        getVariantBuilder(ModBlocks.SOULCOPPER_LANTERN.get()).forAllStates(s -> {
            ModelFile model;
            boolean hanging = s.getValue(BlockStateProperties.HANGING);
            if (hanging) {
                model = models().withExistingParent(ModBlocks.SOULCOPPER_LANTERN.getId().getPath() + "_hanging", ResourceLocation.parse("minecraft:block/template_hanging_lantern"))
                        .texture("lantern", modLoc("block/copper_soul_lantern"));
            } else {
                model = models().withExistingParent(ModBlocks.SOULCOPPER_LANTERN.getId().getPath(), ResourceLocation.parse("minecraft:block/template_lantern"))
                        .texture("lantern", modLoc("block/copper_soul_lantern"));
            }
            return ConfiguredModel.builder()
                    .modelFile(model).build();
        });
    }
}
