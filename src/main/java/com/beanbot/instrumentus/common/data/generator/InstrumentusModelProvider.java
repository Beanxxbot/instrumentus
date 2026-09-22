package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.blocks.WindBlowerBlock;
import com.beanbot.instrumentus.common.items.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

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

        //Energized
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.CARBON_ROD.get(), modLocation("item/carbon_rod"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_PICKAXE.get(), modLocation("item/energy_pickaxe"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_SHOVEL.get(), modLocation("item/energy_shovel"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_AXE.get(), modLocation("item/energy_axe"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.ENERGIZED_HOE.get(), modLocation("item/energy_hoe"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_PAXEL.get(), modLocation("item/energy_paxel"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_HAMMER.get(), modLocation("item/energy_hammer"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_SICKLE.get(), modLocation("item/energy_sickle"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_KNIFE.get(), modLocation("item/energy_knife"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_SHEARS.get(), modLocation("item/energy_shears"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.ENERGIZED_INGOT.get(), modLocation("item/energy_ingot"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get(), modLocation("item/energy_lightning_rod"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.ENERGIZED_EXCAVATOR.get(), modLocation("item/energy_excavator"));
        blockModels.registerSimpleItemModel(energizedBlock, modLocation("block/energy_block"));

        //Soulcopper
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.SOULCOPPER_PICKAXE.get(), modLocation("item/soulcopper_pickaxe"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.SOULCOPPER_INGOT.get(), modLocation("item/soulcopper_ingot"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.RAW_SOULCOPPER.get(), modLocation("item/raw_soulcopper"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get(), modLocation("item/copper_soul_campfire"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.SOULCOPPER_TORCH_ITEM.get(), modLocation("block/copper_soul_torch"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.SOULCOPPER_LANTERN_ITEM.get(), modLocation("item/copper_soul_lantern"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_HANDHELD_ITEM, InstrumentusItems.SOULCOPPER_BURNER.get(), modLocation("item/soulcopper_burner"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.BREEZE_ARMOR_BOOTS.get(), modLocation("item/breeze_boots"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.SOULCOPPER_DOOR_ITEM.get(), modLocation("item/soulcopper_door"));
        generateFlatItemWithTexture(itemModels, ModelTemplates.FLAT_ITEM, InstrumentusItems.PLANT_FIBER.get(), modLocation("item/plant_fiber"));
        blockModels.registerSimpleItemModel(soulcopperBlock, modLocation("block/soulcopper_block"));
        blockModels.registerSimpleItemModel(rawSoulcopperBlock, modLocation("block/raw_soulcopper_block"));
        blockModels.registerSimpleItemModel(cutSoulcopper, modLocation("block/cut_soulcopper"));
        blockModels.registerSimpleItemModel(soulcopperGrate, modLocation("block/soulcopper_grate"));
        blockModels.registerSimpleItemModel(soulcopperTrapdoor, modLocation("block/soulcopper_trapdoor_bottom"));
        blockModels.registerSimpleItemModel(chiseledSoulcopper, modLocation("block/chiseled_soulcopper"));
        blockModels.registerSimpleItemModel(soulcopperBulb, modLocation("block/soulcopper_bulb"));

        blockModels.registerSimpleItemModel(kiln, modLocation("block/kiln"));
    }

    private void registerTools(ItemModelGenerators itemModels) {
        for (var tool : InstrumentusItems.ITEMS_REGISTRAR.getEntries()) {
            if (tool.get() instanceof DiggerItem) {
                itemModels.generateFlatItem(tool.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
            } else if (tool.get() instanceof InstrumentusShearsItem || tool.get() instanceof KnifeItem) {
                itemModels.generateFlatItem(tool.get(), ModelTemplates.FLAT_ITEM);
            } else if (tool.get() instanceof InstrumentusBrushItem || tool.get() instanceof EnergyBrushItem) {
                itemModels.generateFlatItem(tool.get(), ModelTemplates.createItem("brush", TextureSlot.LAYER0));
            }
        }
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

    private static void generateFlatItemWithTexture(ItemModelGenerators itemModels, ModelTemplate template, Item item, ResourceLocation texture) {
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(template.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(texture), itemModels.modelOutput)));
    }
}
