//package com.beanbot.instrumentus.common.data.generator;
//
//import com.beanbot.instrumentus.common.Instrumentus;
//import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
//import com.beanbot.instrumentus.common.blocks.KilnBlock;
//import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.core.Direction;
//import net.minecraft.data.PackOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
//import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
//import net.neoforged.neoforge.client.model.generators.ModelFile;
//import net.neoforged.neoforge.common.data.ExistingFileHelper;
//
//import java.util.Objects;
//
//public class InstrumentusGeneratorBlockStates extends BlockStateProvider {
//    public InstrumentusGeneratorBlockStates(PackOutput output, ExistingFileHelper helper) {
//        super(output, Instrumentus.MODID, helper);
//    }
//
//    @Override
//    protected void registerStatesAndModels() {
//
//        getVariantBuilder(InstrumentusBlocks.WIND_BLOWER.get()).forAllStates(s -> {
//            ModelFile model;
//            int charge = s.getValue(WindBlowerBlock.BLOWER_CHARGE);
//            if (charge == 0) {
//                model = models().cubeBottomTop(
//                        Objects.requireNonNull(InstrumentusBlocks.WIND_BLOWER.getId()).getPath(),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_side0"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_bottom"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_top")
//                ).renderType("solid");
//            } else if (charge == 1) {
//                model = models().cubeBottomTop(
//                        Objects.requireNonNull(InstrumentusBlocks.WIND_BLOWER.getId()).getPath() + "_1",
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_side1"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_bottom"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_top")
//                ).renderType("solid");
//            } else if (charge == 2) {
//                model = models().cubeBottomTop(
//                        Objects.requireNonNull(InstrumentusBlocks.WIND_BLOWER.getId()).getPath() + "_2",
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_side2"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_bottom"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_top")
//                ).renderType("solid");
//            } else if (charge == 3) {
//                model = models().cubeBottomTop(
//                        Objects.requireNonNull(InstrumentusBlocks.WIND_BLOWER.getId()).getPath() + "_3",
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_side3"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_bottom"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_top")
//                ).renderType("solid");
//            } else {
//                model = models().cubeBottomTop(
//                        Objects.requireNonNull(InstrumentusBlocks.WIND_BLOWER.getId()).getPath() + "_4",
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_side4"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_bottom"),
//                        modLoc("block/" + InstrumentusBlocks.WIND_BLOWER.getId().getPath() + "_top")
//                ).renderType("solid");
//            }
//            return ConfiguredModel.builder()
//                    .modelFile(model).build();
//        });
//
////        getVariantBuilder(InstrumentusBlocks.KILN.get()).forAllStates(s -> {
////            ModelFile model;
////            boolean active = s.getValue(KilnBlock.LIT);
////            Direction dir = s.getValue(BlockStateProperties.HORIZONTAL_FACING);
////            if (active) {
////                model = models().orientableWithBottom(
////                        Objects.requireNonNull(InstrumentusBlocks.KILN.getId()).getPath() + "_on",
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_side"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_front_on"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_bottom"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_top")
////                ).renderType("solid");
////            } else {
////                model = models().orientableWithBottom(
////                        Objects.requireNonNull(InstrumentusBlocks.KILN.getId()).getPath(),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_side"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_front"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_bottom"),
////                        modLoc("block/" + InstrumentusBlocks.KILN.getId().getPath() + "_top")
////                ).renderType("solid");
////            }
////            return ConfiguredModel.builder()
////                    .modelFile(model)
////                    .rotationY(((int) dir.toYRot() + 180) % 360)
////                    .build();
////        });
//
////        getVariantBuilder(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get()).forAllStates(s -> {
////            ModelFile model;
////            boolean lit = s.getValue(BlockStateProperties.LIT);
////            if (lit) {
////                model = models().withExistingParent(InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.getId().getPath(), ResourceLocation.parse("minecraft:block/template_campfire"))
////                        .texture("fire", modLoc("block/copper_soul_campfire_fire"))
////                        .texture("lit_log", modLoc("block/copper_soul_campfire_log_lit"))
////                        .renderType(RenderType.CUTOUT.name);
////            } else {
////                model = models().getExistingFile(mcLoc("block/campfire_off"));
////            }
////            return ConfiguredModel.builder()
////                    .modelFile(model).build();
////        });
//
//        getVariantBuilder(InstrumentusBlocks.SOULCOPPER_LANTERN.get()).forAllStates(s -> {
//            ModelFile model;
//            boolean hanging = s.getValue(BlockStateProperties.HANGING);
//            if (hanging) {
//                model = models().withExistingParent(InstrumentusBlocks.SOULCOPPER_LANTERN.getId().getPath() + "_hanging", ResourceLocation.parse("minecraft:block/template_hanging_lantern"))
//                        .texture("lantern", modLoc("block/copper_soul_lantern")).renderType(RenderType.CUTOUT.name);
//            } else {
//                model = models().withExistingParent(InstrumentusBlocks.SOULCOPPER_LANTERN.getId().getPath(), ResourceLocation.parse("minecraft:block/template_lantern"))
//                        .texture("lantern", modLoc("block/copper_soul_lantern")).renderType(RenderType.CUTOUT.name);
//            }
//            return ConfiguredModel.builder()
//                    .modelFile(model).build();
//        });
//    }
//}
