package com.beanbot.instrumentus.common.data.generator;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.data.builder.CopperSoulCampfireCookingRecipeBuilder;
import com.beanbot.instrumentus.common.data.builder.KilnCookingRecipeBuilder;
import com.beanbot.instrumentus.common.data.conditions.FeatureEnabledCondition;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class InstrumentusGeneratorRecipes extends RecipeProvider {

    public InstrumentusGeneratorRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        //Breeze Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, InstrumentusItems.BREEZE_ARMOR_BOOTS.get())
                .pattern("R R")
                .pattern("RBR")
                .pattern("C C")
                .define('R', Tags.Items.RODS_BREEZE)
                .define('B', Items.DIAMOND_BOOTS)
                .define('C', Items.WIND_CHARGE)
                .group("instrumentus")
                .unlockedBy("has_breeze_rod", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WIND_CHARGE))
                .save(consumer.withConditions(new FeatureEnabledCondition((FeatureEnabledCondition.ConfigFeature.TRIAL))));
        //Wind Blower
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, InstrumentusBlocks.WIND_BLOWER.get())
                .pattern("TDT")
                .pattern("CSC")
                .pattern("TBT")
                .define('T', Blocks.CHISELED_TUFF_BRICKS)
                .define('C', Blocks.WAXED_CUT_COPPER)
                .define('S', Blocks.DAYLIGHT_DETECTOR)
                .define('B', Items.BREEZE_ROD)
                .define('D', Blocks.DISPENSER)
                .group("instrumentus")
                .unlockedBy("has_breeze_rod", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BREEZE_ROD))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.TRIAL)));
        //Kiln
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, InstrumentusBlocks.KILN.get().asItem())
                .pattern("BBB")
                .pattern("BFB")
                .pattern("SLS")
                .define('B', Items.BRICK)
                .define('F', Blocks.FURNACE)
                .define('S', Blocks.SMOOTH_STONE)
                .define('L', Blocks.BRICKS)
                .group("instrumentus")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BRICKS.asItem()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.FIRING)));
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(ItemTags.SAND),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.GLASS.asItem().getDefaultInstance())
                .unlockedBy("has_sand", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SAND.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.DEEPSLATE_TILES.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance())
                .unlockedBy("has_deepslate_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DEEPSLATE_TILES.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.PINK_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.PINK_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_pink_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PINK_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.BLUE_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.BLUE_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_blue_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BLUE_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.DEEPSLATE_BRICKS.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance())
                .unlockedBy("has_deepslate_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DEEPSLATE_BRICKS.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.CLAY.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_clay_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CLAY.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.CYAN_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CYAN_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_cyan_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CYAN_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.MAGENTA_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.MAGENTA_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_magenta_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.MAGENTA_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.POLISHED_BLACKSTONE_BRICKS.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance())
                .unlockedBy("has_polished_blackstone_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_BLACKSTONE_BRICKS.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.BROWN_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.BROWN_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_brown_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BROWN_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.BASALT.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.SMOOTH_BASALT.asItem().getDefaultInstance())
                .unlockedBy("has_basalt", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BASALT.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.RED_SANDSTONE.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.SMOOTH_RED_SANDSTONE.asItem().getDefaultInstance())
                .unlockedBy("has_red_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.RED_SANDSTONE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.COBBLED_DEEPSLATE.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.DEEPSLATE.asItem().getDefaultInstance())
                .unlockedBy("has_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLED_DEEPSLATE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.QUARTZ_BLOCK.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.SMOOTH_QUARTZ.asItem().getDefaultInstance())
                .unlockedBy("has_quartz_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.QUARTZ_BLOCK.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.SANDSTONE.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.SMOOTH_SANDSTONE.asItem().getDefaultInstance())
                .unlockedBy("has_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SANDSTONE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.LIGHT_BLUE_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_light_blue_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.LIGHT_BLUE_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.PURPLE_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.PURPLE_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_purple_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PURPLE_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.STONE_BRICKS.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance())
                .unlockedBy("has_stone_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE_BRICKS.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.GREEN_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.GREEN_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_green_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GREEN_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.CACTUS.asItem()),
                        RecipeCategory.MISC,
                        Items.GREEN_DYE.getDefaultInstance())
                .unlockedBy("has_cactus", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CACTUS.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.SEA_PICKLE.asItem()),
                        RecipeCategory.MISC,
                        Items.LIME_DYE.getDefaultInstance())
                .unlockedBy("has_sea_pickle", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SEA_PICKLE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.ORANGE_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.ORANGE_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_orange_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.ORANGE_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.GRAY_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.GRAY_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_gray_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GRAY_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.NETHERRACK.asItem()),
                        RecipeCategory.MISC,
                        Items.NETHER_BRICK.getDefaultInstance())
                .unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.NETHERRACK.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.BLACK_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.BLACK_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_black_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BLACK_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Items.CLAY_BALL),
                        RecipeCategory.MISC,
                        Items.BRICK.getDefaultInstance())
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLAY_BALL))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.YELLOW_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.YELLOW_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_yellow_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.YELLOW_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.COBBLESTONE.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.STONE.asItem().getDefaultInstance())
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLESTONE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.STONE.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.SMOOTH_STONE.asItem().getDefaultInstance())
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.LIGHT_GRAY_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_light_gray_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.LIGHT_GRAY_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.NETHER_BRICKS.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance())
                .unlockedBy("has_nether_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.NETHER_BRICKS.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.RED_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.RED_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_red_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.RED_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.WHITE_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.WHITE_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_white_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.WHITE_TERRACOTTA.asItem()))
                .save(consumer);
        KilnCookingRecipeBuilder.fireDefault(
                        Ingredient.of(Blocks.LIME_TERRACOTTA.asItem()),
                        RecipeCategory.BUILDING_BLOCKS,
                        Blocks.LIME_GLAZED_TERRACOTTA.asItem().getDefaultInstance())
                .unlockedBy("has_lime_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.LIME_TERRACOTTA.asItem()))
                .save(consumer);

        //Copper Tools
        Instrumentus.LOGGER.info("Registering Copper Tools Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_AXE.get())
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.COPPER_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_HOE.get())
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', InstrumentusItems.COPPER_AXE.get())
                .define('V', InstrumentusItems.COPPER_SHOVEL.get())
                .define('P', InstrumentusItems.COPPER_PICKAXE.get())
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.COPPER_PICKAXE.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_PICKAXE.get())
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', Items.COPPER_INGOT)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_SHOVEL.get())
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("S")
                .define('X', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.COPPER_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', Items.COPPER_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.COPPER_TOOLS), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));

        //Brushes
        Instrumentus.LOGGER.info("Registering Brushes Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_BRUSH.get())
                .pattern("F")
                .pattern("I")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('I', Items.DIAMOND)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_BRUSH.get())
                .pattern("F")
                .pattern("I")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('I', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_BRUSH.get())
                .pattern("F")
                .pattern("I")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_BRUSH.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_BRUSH.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)), "netherite_brush_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_BRUSH.get())
                .pattern("F")
                .pattern("I")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('I', Tags.Items.COBBLESTONES)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_BRUSH.get())
                .pattern("F")
                .pattern("I")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('I', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));

        //Hammers
        Instrumentus.LOGGER.info("Registering Hammers Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.DIAMOND)
                .define('B', Items.DIAMOND_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.GOLD_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_gold_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.IRON_INGOT)
                .define('B', Items.IRON_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_HAMMER.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_HAMMER.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)), "netherite_hammer_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Tags.Items.COBBLESTONES)
                .define('B', Tags.Items.STONES)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ItemTags.PLANKS)
                .define('B', ItemTags.LOGS)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));

        //Knives
        Instrumentus.LOGGER.info("Registering Knives Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', Items.DIAMOND)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_KNIFE.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_KNIFE.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)), "netherite_knife_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', Tags.Items.COBBLESTONES)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STRING, 2)
                .pattern(" X ")
                .pattern("XXX")
                .pattern(" X ")
                .define('X', InstrumentusItems.PLANT_FIBER.get())
                .group("instrumentus")
                .unlockedBy("has_plant_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.PLANT_FIBER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));

        //Paxels
        Instrumentus.LOGGER.info("Registering Paxels Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.DIAMOND_AXE)
                .define('V', Items.DIAMOND_SHOVEL)
                .define('P', Items.DIAMOND_PICKAXE)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_PICKAXE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.GOLDEN_AXE)
                .define('V', Items.GOLDEN_SHOVEL)
                .define('P', Items.GOLDEN_PICKAXE)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_golden_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLDEN_PICKAXE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.IRON_AXE)
                .define('V', Items.IRON_SHOVEL)
                .define('P', Items.IRON_PICKAXE)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_PICKAXE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_PAXEL.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_PAXEL.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)), "netherite_paxel_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.STONE_AXE)
                .define('V', Items.STONE_SHOVEL)
                .define('P', Items.STONE_PICKAXE)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', Items.WOODEN_AXE)
                .define('V', Items.WOODEN_SHOVEL)
                .define('P', Items.WOODEN_PICKAXE)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));

        //Shears
        Instrumentus.LOGGER.info("Registering Shears Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', Items.DIAMOND)
                .group("instrumentus")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', Items.GOLD_INGOT)
                .group("instrumentus")
                .unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_SHEARS.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_SHEARS.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)), "netherite_shears_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', Tags.Items.COBBLESTONES)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', ItemTags.PLANKS)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));

        //Sickles
        Instrumentus.LOGGER.info("Registering Sickles Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', Items.DIAMOND)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_SICKLE.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_SICKLE.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)), "netherite_sickle_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', Tags.Items.COBBLESTONES)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));

        //Energized
        Instrumentus.LOGGER.info("Registering Energized Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.CARBON_ROD.get())
                .pattern("CCC")
                .pattern("CSC")
                .pattern("CCC")
                .define('C', Items.COAL)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_coal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_AXE.get())
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_HOE.get())
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        nineBlockStorageRecipes(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)), RecipeCategory.MISC, InstrumentusItems.ENERGIZED_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.ENERGIZED_BLOCK.get(), InstrumentusItems.ENERGIZED_INGOT.get() + "_9x9", "instrumentus", InstrumentusItems.ENERGIZED_BLOCK.get() + "_9x9", "instrumentus");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_BRUSH.get())
                .pattern("F")
                .pattern("D")
                .pattern("S")
                .define('F', Items.FEATHER)
                .define('D', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.BRUSHES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_HAMMER.get())
                .pattern("ABA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', InstrumentusItems.ENERGIZED_BLOCK.get())
                .define('B', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energized_block", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.HAMMERS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, InstrumentusItems.ENERGIZED_INGOT.get(), 2)
                .pattern("QEQ")
                .pattern("DGD")
                .pattern("QEQ")
                .define('Q', Items.QUARTZ)
                .define('G', Items.GOLD_INGOT)
                .define('E', Items.EMERALD)
                .define('D', Items.DIAMOND)
                .group("instrumentus")
                .unlockedBy("has_quartz", InventoryChangeTrigger.TriggerInstance.hasItems(Items.QUARTZ))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_KNIFE.get())
                .pattern(" XX")
                .pattern("XX ")
                .pattern("S  ")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.KNIVES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get())
                .pattern(" B ")
                .pattern("IRI")
                .pattern(" C ")
                .define('B', InstrumentusItems.ENERGIZED_BLOCK.get())
                .define('I', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('R', Items.LIGHTNING_ROD)
                .define('C', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_PAXEL.get())
                .pattern("AVP")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', InstrumentusItems.ENERGIZED_AXE.get())
                .define('V', InstrumentusItems.ENERGIZED_SHOVEL.get())
                .define('P', InstrumentusItems.ENERGIZED_PICKAXE.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_PICKAXE.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.PAXELS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_PICKAXE.get())
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_SHEARS.get())
                .pattern(" X")
                .pattern("X ")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SHEARS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_SHOVEL.get())
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_SICKLE.get())
                .pattern(" X ")
                .pattern("  X")
                .pattern("SX ")
                .define('X', InstrumentusItems.ENERGIZED_INGOT.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SICKLES)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.ENERGIZED_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', InstrumentusItems.ENERGIZED_BLOCK.get())
                .define('S', InstrumentusItems.CARBON_ROD.get())
                .group("instrumentus")
                .unlockedBy("has_energized_block", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.ENERGIZED_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.ENERGIZED), new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));


        //Soulcopper
        Instrumentus.LOGGER.info("Registering Soulcopper Recipes");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.SOULCOPPER_LANTERN_ITEM.get())
                .pattern("XXX")
                .pattern("XCX")
                .pattern("XXX")
                .define('X', Items.IRON_NUGGET)
                .define('C', InstrumentusItems.SOULCOPPER_TORCH_ITEM.get())
                .group("instrumentus")
                .unlockedBy("has_copper_soul_torch", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.SOULCOPPER_TORCH_ITEM.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.SOULCOPPER_TORCH_ITEM.get(), 4)
                .pattern("X")
                .pattern("S")
                .define('X', InstrumentusItems.RAW_SOULCOPPER.get())
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_raw_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.RAW_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get())
                .pattern(" S ")
                .pattern("SFS")
                .pattern("CCC")
                .define('S', Items.STICK)
                .define('F', Items.SOUL_CAMPFIRE)
                .define('C', Items.RAW_COPPER_BLOCK)
                .group("instrumentus")
                .unlockedBy("has_soul_campfire", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_CAMPFIRE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        nineBlockStorageRecipes(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), RecipeCategory.MISC, InstrumentusItems.RAW_SOULCOPPER.get(), RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.RAW_SOULCOPPER_BLOCK.get(), InstrumentusItems.RAW_SOULCOPPER.get() + "_9x9", "instrumentus", InstrumentusItems.RAW_SOULCOPPER_BLOCK.get() + "_9x9", "instrumentus");
        nineBlockStorageRecipes(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), RecipeCategory.MISC, InstrumentusItems.SOULCOPPER_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, InstrumentusItems.SOULCOPPER_BLOCK.get(), InstrumentusItems.SOULCOPPER_INGOT.get() + "_9x9", "instrumentus", InstrumentusItems.SOULCOPPER_BLOCK.get() + "_9x9", "instrumentus");
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(InstrumentusItems.RAW_SOULCOPPER.get()),
                        RecipeCategory.MISC,
                        InstrumentusItems.SOULCOPPER_INGOT.get(),
                        0.7f,
                        100)
                .unlockedBy("has_raw_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.RAW_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.SOULCOPPER_PICKAXE.get())
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', InstrumentusItems.SOULCOPPER_INGOT.get())
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.SOULCOPPER_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.SOULCOPPER_BURNER.get())
                .pattern("CTC")
                .pattern("CBC")
                .pattern("CBC")
                .define('C', InstrumentusItems.SOULCOPPER_INGOT.get())
                .define('T', InstrumentusItems.SOULCOPPER_TORCH_ITEM.get())
                .define('B', Items.BLAZE_ROD)
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.SOULCOPPER_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        CopperSoulCampfireCookingRecipeBuilder.smelting(
                        ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "raw_copper_block_to_raw_soulcopper"),
                        Ingredient.of(Items.RAW_COPPER_BLOCK.getDefaultInstance()),
                        InstrumentusItems.RAW_SOULCOPPER.get().getDefaultInstance(),
                        300
                )
                .group("instrumentus")
                .unlockedBy("has_raw_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RAW_COPPER_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER.get(), 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', InstrumentusBlocks.SOULCOPPER_BLOCK.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.SOULCOPPER_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER.get(), 4)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "cut_soulcopper_from_stonecutting");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_STAIRS.get(), 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', InstrumentusBlocks.CUT_SOULCOPPER.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.SOULCOPPER_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_STAIRS.get(), 4)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "cut_soulcopper_stairs_from_stonecutting_notcut");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.CUT_SOULCOPPER.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_STAIRS.get(), 1)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "cut_soulcopper_stairs_from_stonecutting_cut");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get(), 3)
                .pattern("SSS")
                .define('S', InstrumentusBlocks.CUT_SOULCOPPER.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.SOULCOPPER_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get(), 8)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "cut_soulcopper_slab_from_stonecutting_notcut");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.CUT_SOULCOPPER.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get(), 2)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "cut_soulcopper_slab_from_stonecutting_cut");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CHISELED_SOULCOPPER.get(), 1)
                .pattern("S")
                .pattern("S")
                .define('S', InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER_SLAB.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.SOULCOPPER_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CHISELED_SOULCOPPER.get(), 4)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "chiseled_soulcopper_from_stonecutting_notcut");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.CUT_SOULCOPPER.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.CHISELED_SOULCOPPER.get(), 1)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.CUT_SOULCOPPER.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "chiseled_soulcopper_from_stonecutting_cut");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.SOULCOPPER_BULB.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" R ")
                .define('S', InstrumentusBlocks.SOULCOPPER_BLOCK.get())
                .define('B', Items.BLAZE_ROD)
                .define('R', Items.REDSTONE)
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.SOULCOPPER_GRATE.get(), 4)
                .pattern(" S ")
                .pattern("S S")
                .pattern(" S ")
                .define('S', InstrumentusBlocks.SOULCOPPER_BLOCK.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(InstrumentusBlocks.SOULCOPPER_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.SOULCOPPER_GRATE.get(), 4)
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusBlocks.SOULCOPPER_BLOCK.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)), "soulcopper_grate_from_stonecutting");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.SOULCOPPER_TRAPDOOR.get(), 2)
                .pattern("SSS")
                .pattern("SSS")
                .define('S', InstrumentusItems.SOULCOPPER_INGOT.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.SOULCOPPER_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, InstrumentusBlocks.SOULCOPPER_DOOR.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .pattern("SS")
                .define('S', InstrumentusItems.SOULCOPPER_INGOT.get())
                .group("instrumentus")
                .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(InstrumentusItems.SOULCOPPER_INGOT.get()))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.SOULCOPPER)));

        //Excavators
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.WOODEN_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', ItemTags.LOGS)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_log", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_LOG))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.STONE_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', Tags.Items.STONES)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.IRON_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', Items.IRON_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_iron_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.GOLDEN_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', Items.GOLD_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_gold_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, InstrumentusItems.DIAMOND_EXCAVATOR.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', Items.DIAMOND_BLOCK)
                .define('S', Items.STICK)
                .group("instrumentus")
                .unlockedBy("has_diamond_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_BLOCK))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)));
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(InstrumentusItems.DIAMOND_EXCAVATOR.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        InstrumentusItems.NETHERITE_EXCAVATOR.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer.withConditions(new FeatureEnabledCondition(FeatureEnabledCondition.ConfigFeature.EXCAVATORS)), "netherite_excavator_smithing");
    }
}
