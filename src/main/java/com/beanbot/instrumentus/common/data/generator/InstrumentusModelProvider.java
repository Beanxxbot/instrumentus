package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class InstrumentusModelProvider extends ModelProvider {
    public InstrumentusModelProvider(PackOutput output) {
        super(output, Instrumentus.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        Block soulcopperBlock = InstrumentusBlocks.SOULCOPPER_BLOCK.get();
        Block rawSoulcopperBlock = InstrumentusBlocks.RAW_SOULCOPPER_BLOCK.get();
        Block energizedBlock = InstrumentusBlocks.ENERGIZED_BLOCK.get();
        Block copperSoulFlameLight = InstrumentusBlocks.COPPER_SOUL_FLAME_LIGHT.get();
        Block soulcopperTorch = InstrumentusBlocks.SOULCOPPER_TORCH.get();
        Block soulcopperWallTorch = InstrumentusBlocks.SOULCOPPER_WALL_TORCH.get();
        Block cutSoulcopper = InstrumentusBlocks.CUT_SOULCOPPER.get();
        Block soulcopperGrate = InstrumentusBlocks.SOULCOPPER_GRATE.get();
        Block soulcopperDoor = InstrumentusBlocks.SOULCOPPER_DOOR.get();
        Block soulcopperTrapdoor = InstrumentusBlocks.SOULCOPPER_TRAPDOOR.get();
        Block cutSoulcopperStairs = InstrumentusBlocks.CUT_SOULCOPPER_STAIRS.get();
        Block cutSoulcopperSlab = InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get();
        Block chiseledSoulcopper = InstrumentusBlocks.CHISELED_SOULCOPPER.get();
        Block soulcopperBulb = InstrumentusBlocks.SOULCOPPER_BULB.get();
        Block soulcopperLantern = InstrumentusBlocks.SOULCOPPER_LANTERN.get();
        Block kiln = InstrumentusBlocks.KILN.get();
        Block copperSoulCampfire = InstrumentusBlocks.COPPER_SOUL_CAMPFIRE.get();
        Block windBlower = InstrumentusBlocks.WIND_BLOWER.get();

        blockModels.createTrivialCube(soulcopperBlock);
        blockModels.createTrivialCube(rawSoulcopperBlock);
        blockModels.createTrivialCube(energizedBlock);
        blockModels.createTrivialCube(cutSoulcopper);
        blockModels.createTrivialCube(chiseledSoulcopper);
        blockModels.createTrivialCube(soulcopperBulb);
        blockModels.createTrivialBlock(soulcopperGrate,TexturedModel.CUBE.updateTemplate(temp -> temp.extend().renderType("minecraft:cutout").build()));
        blockModels.createTrivialBlock(copperSoulFlameLight, TexturedModel.CUBE.updateTemplate(temp -> temp.extend().renderType("minecraft:cutout").build()));

        blockModels.createNormalTorch(soulcopperTorch, soulcopperWallTorch);
        blockModels.createDoor(soulcopperDoor);
        blockModels.createOrientableTrapdoor(soulcopperTrapdoor);
        createStairs(blockModels, itemModels, cutSoulcopperStairs, new TextureMapping().put(TextureSlot.ALL, TextureMapping.getBlockTexture(cutSoulcopper)));
        createSlab(blockModels, itemModels, cutSoulcopperSlab, cutSoulcopper, new TextureMapping().put(TextureSlot.ALL, TextureMapping.getBlockTexture(cutSoulcopper)));

        blockModels.createLantern(soulcopperLantern);
        blockModels.registerSimpleFlatItemModel(soulcopperLantern);

        blockModels.createFurnace(kiln, TexturedModel.ORIENTABLE_ONLY_TOP);
        blockModels.createCampfires(copperSoulCampfire);
        blockModels.registerSimpleFlatItemModel(copperSoulCampfire);

        createBottomTopWithCharge(blockModels, itemModels, windBlower, WindBlowerBlock.BLOWER_CHARGE);
    }

    private static void createStairs(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block stairs, TextureMapping texture) {
        ResourceLocation stairsStraight = ModelTemplates.STAIRS_STRAIGHT.create(stairs, texture, blockModels.modelOutput);
        ResourceLocation stairsInner = ModelTemplates.STAIRS_INNER.create(stairs, texture, blockModels.modelOutput);
        ResourceLocation stairsOuter = ModelTemplates.STAIRS_OUTER.create(stairs, texture, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, stairsStraight, stairsInner, stairsOuter));
        itemModels.itemModelOutput.accept(stairs.asItem(), ItemModelUtils.plainModel(stairsStraight));
    }

    private static void createSlab(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block slab, Block baseBlock, TextureMapping texture) {
        ResourceLocation slabBottom = ModelTemplates.SLAB_BOTTOM.create(slab, texture, blockModels.modelOutput);
        ResourceLocation slabTop = ModelTemplates.SLAB_TOP.create(slab, texture, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, slabBottom, slabTop, ModelLocationUtils.getModelLocation(baseBlock)));
        itemModels.itemModelOutput.accept(slab.asItem(), ItemModelUtils.plainModel(slabBottom));
    }

    private static void createBottomTopWithCharge(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, IntegerProperty charge) {
        ResourceLocation resourcelocation = TextureMapping.getBlockTexture(block, "_bottom");
        ResourceLocation resourcelocation1 = TextureMapping.getBlockTexture(block, "_top");
        ResourceLocation[] aresourcelocation = new ResourceLocation[5];

        for(int i = 0; i < 5; ++i) {
            TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.BOTTOM, resourcelocation).put(TextureSlot.TOP, resourcelocation1).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side" + i));
            aresourcelocation[i] = ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(block, "_" + i, texturemapping, blockModels.modelOutput);
        }

        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(PropertyDispatch.property(charge).generate((p) -> Variant.variant().with(VariantProperties.MODEL, aresourcelocation[p]))));
        itemModels.itemModelOutput.accept(Blocks.RESPAWN_ANCHOR.asItem(), ItemModelUtils.plainModel(aresourcelocation[0]));
    }
}
