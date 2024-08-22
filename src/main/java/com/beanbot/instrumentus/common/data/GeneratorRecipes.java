package com.beanbot.instrumentus.common.data;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.data.builder.CopperSoulCampfireCookingRecipeBuilder;
import com.beanbot.instrumentus.common.data.builder.KilnCookingRecipeBuilder;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class GeneratorRecipes extends RecipeProvider {

    public GeneratorRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        //Kiln
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KILN.get().asItem())
                .pattern("BBB")
                .pattern("BFB")
                .pattern("SLS")
                .define('B', Items.BRICK)
                .define('F', Blocks.FURNACE)
                .define('S', Blocks.SMOOTH_STONE)
                .define('L', Blocks.BRICKS)
                .group("instrumentus")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BRICKS.asItem()))
                .save(consumer);
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
                        Ingredient.of(Blocks.CLAY.asItem()),
                        RecipeCategory.MISC,
                        Items.BRICK.getDefaultInstance())
                .unlockedBy("has_clay_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CLAY.asItem()))
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
        if (Config.COPPER_TOOLS.get()) {
            Instrumentus.LOGGER.info("Registering Copper Tools Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                    .pattern("XX")
                    .pattern("XS")
                    .pattern(" S")
                    .define('X', Items.COPPER_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                    .save(consumer);
            if (Config.HAMMERS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HAMMER.get())
                        .pattern("ABA")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.COPPER_BLOCK)
                        .define('S', Items.STICK)
                        .group("instrumentus")
                        .unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_BLOCK))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                    .pattern("XX")
                    .pattern(" S")
                    .pattern(" S")
                    .define('X', Items.COPPER_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                    .save(consumer);
            if (Config.KNIVES.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_KNIFE.get())
                        .pattern(" XX")
                        .pattern("XX ")
                        .pattern("S  ")
                        .define('X', Items.COPPER_INGOT)
                        .define('S', Items.STICK)
                        .group("instrumentus")
                        .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                        .save(consumer);
            if (Config.PAXELS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PAXEL.get())
                        .pattern("AVP")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('A', ModItems.COPPER_AXE.get())
                        .define('V', ModItems.COPPER_SHOVEL.get())
                        .define('P', ModItems.COPPER_PICKAXE.get())
                        .define('S', Items.STICK)
                        .group("instrumentus")
                        .unlockedBy("has_copper_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PICKAXE.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                    .pattern("XXX")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('X', Items.COPPER_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                    .save(consumer);
            if (Config.SHEARS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHEARS.get())
                        .pattern(" X")
                        .pattern("X ")
                        .define('X', Items.COPPER_INGOT)
                        .group("instrumentus")
                        .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get())
                    .pattern("X")
                    .pattern("S")
                    .pattern("S")
                    .define('X', Items.COPPER_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                    .save(consumer);
            if (Config.SICKLES.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SICKLE.get())
                        .pattern(" X ")
                        .pattern("  X")
                        .pattern("SX ")
                        .define('X', Items.COPPER_INGOT)
                        .define('S', Items.STICK)
                        .group("instrumentus")
                        .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SWORD.get())
                    .pattern("X")
                    .pattern("X")
                    .pattern("S")
                    .define('X', Items.COPPER_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                    .save(consumer);
            if (Config.EXCAVATORS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_EXCAVATOR.get())
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .define('I', Items.COPPER_BLOCK)
                        .define('S', Items.STICK)
                        .group("instrumentus")
                        .unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_BLOCK))
                        .save(consumer);
        }

        //Brushes
        if (Config.BRUSHES.get()) {
            Instrumentus.LOGGER.info("Registering Brushes Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_BRUSH.get())
                    .pattern("F")
                    .pattern("I")
                    .pattern("S")
                    .define('F', Items.FEATHER)
                    .define('I', Items.DIAMOND)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_BRUSH.get())
                    .pattern("F")
                    .pattern("I")
                    .pattern("S")
                    .define('F', Items.FEATHER)
                    .define('I', Items.GOLD_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_BRUSH.get())
                    .pattern("F")
                    .pattern("I")
                    .pattern("S")
                    .define('F', Items.FEATHER)
                    .define('I', Items.IRON_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_BRUSH.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_BRUSH.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_brush_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_BRUSH.get())
                    .pattern("F")
                    .pattern("I")
                    .pattern("S")
                    .define('F', Items.FEATHER)
                    .define('I', Tags.Items.COBBLESTONES)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_BRUSH.get())
                    .pattern("F")
                    .pattern("I")
                    .pattern("S")
                    .define('F', Items.FEATHER)
                    .define('I', ItemTags.PLANKS)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Hammers
        if (Config.HAMMERS.get()) {
            Instrumentus.LOGGER.info("Registering Hammers Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER.get())
                    .pattern("ABA")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.DIAMOND)
                    .define('B', Items.DIAMOND_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_BLOCK))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_HAMMER.get())
                    .pattern("ABA")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.GOLD_INGOT)
                    .define('B', Items.GOLD_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_gold_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_BLOCK))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_HAMMER.get())
                    .pattern("ABA")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.IRON_INGOT)
                    .define('B', Items.IRON_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_HAMMER.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_HAMMER.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_hammer_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HAMMER.get())
                    .pattern("ABA")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Tags.Items.COBBLESTONES)
                    .define('B', Tags.Items.STONES)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_HAMMER.get())
                    .pattern("ABA")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', ItemTags.PLANKS)
                    .define('B', ItemTags.LOGS)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Knives
        if (Config.KNIVES.get()) {
            Instrumentus.LOGGER.info("Registering Knives Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_KNIFE.get())
                    .pattern(" XX")
                    .pattern("XX ")
                    .pattern("S  ")
                    .define('X', Items.DIAMOND)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_KNIFE.get())
                    .pattern(" XX")
                    .pattern("XX ")
                    .pattern("S  ")
                    .define('X', Items.GOLD_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_KNIFE.get())
                    .pattern(" XX")
                    .pattern("XX ")
                    .pattern("S  ")
                    .define('X', Items.IRON_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_KNIFE.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_KNIFE.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_knife_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_KNIFE.get())
                    .pattern(" XX")
                    .pattern("XX ")
                    .pattern("S  ")
                    .define('X', Tags.Items.COBBLESTONES)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STRING, 2)
                    .pattern(" X ")
                    .pattern("XXX")
                    .pattern(" X ")
                    .define('X', ModItems.PLANT_FIBER.get())
                    .group("instrumentus")
                    .unlockedBy("has_plant_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLANT_FIBER.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_KNIFE.get())
                    .pattern(" XX")
                    .pattern("XX ")
                    .pattern("S  ")
                    .define('X', ItemTags.PLANKS)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Paxels
        if (Config.PAXELS.get()) {
            Instrumentus.LOGGER.info("Registering Paxels Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_PAXEL.get())
                    .pattern("AVP")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.DIAMOND_AXE)
                    .define('V', Items.DIAMOND_SHOVEL)
                    .define('P', Items.DIAMOND_PICKAXE)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_PICKAXE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_PAXEL.get())
                    .pattern("AVP")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.GOLDEN_AXE)
                    .define('V', Items.GOLDEN_SHOVEL)
                    .define('P', Items.GOLDEN_PICKAXE)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_golden_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLDEN_PICKAXE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_PAXEL.get())
                    .pattern("AVP")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.IRON_AXE)
                    .define('V', Items.IRON_SHOVEL)
                    .define('P', Items.IRON_PICKAXE)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_PICKAXE))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_PAXEL.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_PAXEL.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_paxel_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_PAXEL.get())
                    .pattern("AVP")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.STONE_AXE)
                    .define('V', Items.STONE_SHOVEL)
                    .define('P', Items.STONE_PICKAXE)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_PAXEL.get())
                    .pattern("AVP")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('A', Items.WOODEN_AXE)
                    .define('V', Items.WOODEN_SHOVEL)
                    .define('P', Items.WOODEN_PICKAXE)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Shears
        if (Config.SHEARS.get()) {
            Instrumentus.LOGGER.info("Registering Shears Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_SHEARS.get())
                    .pattern(" X")
                    .pattern("X ")
                    .define('X', Items.DIAMOND)
                    .group("instrumentus")
                    .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_SHEARS.get())
                    .pattern(" X")
                    .pattern("X ")
                    .define('X', Items.GOLD_INGOT)
                    .group("instrumentus")
                    .unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_SHEARS.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_SHEARS.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_shears_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_SHEARS.get())
                    .pattern(" X")
                    .pattern("X ")
                    .define('X', Tags.Items.COBBLESTONES)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_SHEARS.get())
                    .pattern(" X")
                    .pattern("X ")
                    .define('X', ItemTags.PLANKS)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Sickles
        if (Config.SICKLES.get()) {
            Instrumentus.LOGGER.info("Registering Sickles Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_SICKLE.get())
                    .pattern(" X ")
                    .pattern("  X")
                    .pattern("SX ")
                    .define('X', Items.DIAMOND)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_SICKLE.get())
                    .pattern(" X ")
                    .pattern("  X")
                    .pattern("SX ")
                    .define('X', Items.GOLD_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_SICKLE.get())
                    .pattern(" X ")
                    .pattern("  X")
                    .pattern("SX ")
                    .define('X', Items.IRON_INGOT)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_SICKLE.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_SICKLE.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_sickle_smithing");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_SICKLE.get())
                    .pattern(" X ")
                    .pattern("  X")
                    .pattern("SX ")
                    .define('X', Tags.Items.COBBLESTONES)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_SICKLE.get())
                    .pattern(" X ")
                    .pattern("  X")
                    .pattern("SX ")
                    .define('X', ItemTags.PLANKS)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS))
                    .save(consumer);
        }

        //Energized
        if (Config.ENERGIZED.get()) {
            Instrumentus.LOGGER.info("Registering Energized Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CARBON_ROD.get())
                    .pattern("CCC")
                    .pattern("CSC")
                    .pattern("CCC")
                    .define('C', Items.COAL)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_coal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_AXE.get())
                    .pattern("XX")
                    .pattern("XS")
                    .pattern(" S")
                    .define('X', ModItems.ENERGIZED_INGOT.get())
                    .define('S', ModItems.CARBON_ROD.get())
                    .group("instrumentus")
                    .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_HOE.get())
                    .pattern("XX")
                    .pattern(" S")
                    .pattern(" S")
                    .define('X', ModItems.ENERGIZED_INGOT.get())
                    .define('S', ModItems.CARBON_ROD.get())
                    .group("instrumentus")
                    .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                    .save(consumer);
            nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.ENERGIZED_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.ENERGIZED_BLOCK.get(), ModItems.ENERGIZED_INGOT.get() + "_9x9", "instrumentus", ModItems.ENERGIZED_BLOCK.get() + "_9x9", "instrumentus");
            if (Config.BRUSHES.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_BRUSH.get())
                        .pattern("F")
                        .pattern("D")
                        .pattern("S")
                        .define('F', Items.FEATHER)
                        .define('D', ModItems.ENERGIZED_INGOT.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energized_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                        .save(consumer);
            if (Config.HAMMERS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_HAMMER.get())
                        .pattern("ABA")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('A', ModItems.ENERGIZED_BLOCK.get())
                        .define('B', ModItems.ENERGIZED_INGOT.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energized_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_BLOCK.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENERGIZED_INGOT.get(), 2)
                    .pattern("QEQ")
                    .pattern("DGD")
                    .pattern("QEQ")
                    .define('Q', Items.QUARTZ)
                    .define('G', Items.GOLD_INGOT)
                    .define('E', Items.EMERALD)
                    .define('D', Items.DIAMOND)
                    .group("instrumentus")
                    .unlockedBy("has_quartz", InventoryChangeTrigger.TriggerInstance.hasItems(Items.QUARTZ))
                    .save(consumer);
            if (Config.KNIVES.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_KNIFE.get())
                        .pattern(" XX")
                        .pattern("XX ")
                        .pattern("S  ")
                        .define('X', ModItems.ENERGIZED_INGOT.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_LIGHTNING_ROD.get())
                    .pattern(" B ")
                    .pattern("IRI")
                    .pattern(" C ")
                    .define('B', ModItems.ENERGIZED_BLOCK.get())
                    .define('I', ModItems.ENERGIZED_INGOT.get())
                    .define('R', Items.LIGHTNING_ROD)
                    .define('C', ModItems.CARBON_ROD.get())
                    .group("instrumentus")
                    .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                    .save(consumer);
            if (Config.PAXELS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_PAXEL.get())
                        .pattern("AVP")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('A', ModItems.ENERGIZED_AXE.get())
                        .define('V', ModItems.ENERGIZED_SHOVEL.get())
                        .define('P', ModItems.ENERGIZED_PICKAXE.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energy_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_PICKAXE.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_PICKAXE.get())
                    .pattern("XXX")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('X', ModItems.ENERGIZED_INGOT.get())
                    .define('S', ModItems.CARBON_ROD.get())
                    .group("instrumentus")
                    .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                    .save(consumer);
            if (Config.SHEARS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_SHEARS.get())
                        .pattern(" X")
                        .pattern("X ")
                        .define('X', ModItems.ENERGIZED_INGOT.get())
                        .group("instrumentus")
                        .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_SHOVEL.get())
                    .pattern("X")
                    .pattern("S")
                    .pattern("S")
                    .define('X', ModItems.ENERGIZED_INGOT.get())
                    .define('S', ModItems.CARBON_ROD.get())
                    .group("instrumentus")
                    .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                    .save(consumer);
            if (Config.SICKLES.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_SICKLE.get())
                        .pattern(" X ")
                        .pattern("  X")
                        .pattern("SX ")
                        .define('X', ModItems.ENERGIZED_INGOT.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_INGOT.get()))
                        .save(consumer);
            if (Config.EXCAVATORS.get())
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENERGIZED_EXCAVATOR.get())
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .define('I', ModItems.ENERGIZED_BLOCK.get())
                        .define('S', ModItems.CARBON_ROD.get())
                        .group("instrumentus")
                        .unlockedBy("has_energized_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGIZED_BLOCK.get()))
                        .save(consumer);
        }


        //Soulcopper
        if (Config.SOULCOPPER.get()) {
            Instrumentus.LOGGER.info("Registering Soulcopper Recipes");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SOULCOPPER_LANTERN_ITEM.get())
                    .pattern("XXX")
                    .pattern("XCX")
                    .pattern("XXX")
                    .define('X', Items.IRON_NUGGET)
                    .define('C', ModItems.SOULCOPPER_TORCH_ITEM.get())
                    .group("instrumentus")
                    .unlockedBy("has_copper_soul_torch", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOULCOPPER_TORCH_ITEM.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SOULCOPPER_TORCH_ITEM.get(), 4)
                    .pattern("X")
                    .pattern("S")
                    .define('X', ModItems.RAW_SOULCOPPER.get())
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_raw_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SOULCOPPER.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.COPPER_SOUL_CAMPFIRE_BLOCK_ITEM.get())
                    .pattern(" S ")
                    .pattern("SFS")
                    .pattern("CCC")
                    .define('S', Items.STICK)
                    .define('F', Items.SOUL_CAMPFIRE)
                    .define('C', Items.RAW_COPPER_BLOCK)
                    .group("instrumentus")
                    .unlockedBy("has_soul_campfire", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_CAMPFIRE))
                    .save(consumer);
            nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.RAW_SOULCOPPER.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SOULCOPPER_BLOCK.get(), ModItems.RAW_SOULCOPPER.get() + "_9x9", "instrumentus", ModItems.RAW_SOULCOPPER_BLOCK.get() + "_9x9", "instrumentus");
            nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.SOULCOPPER_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.SOULCOPPER_BLOCK.get(), ModItems.SOULCOPPER_INGOT.get() + "_9x9", "instrumentus", ModItems.SOULCOPPER_BLOCK.get() + "_9x9", "instrumentus");
            SimpleCookingRecipeBuilder.blasting(
                            Ingredient.of(ModItems.RAW_SOULCOPPER.get()),
                            RecipeCategory.MISC,
                            ModItems.SOULCOPPER_INGOT.get(),
                            0.7f,
                            100)
                    .unlockedBy("has_raw_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SOULCOPPER.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOULCOPPER_PICKAXE.get())
                    .pattern("XXX")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('X', ModItems.SOULCOPPER_INGOT.get())
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOULCOPPER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOULCOPPER_BURNER.get())
                    .pattern("CTC")
                    .pattern("CBC")
                    .pattern("CBC")
                    .define('C', ModItems.SOULCOPPER_INGOT.get())
                    .define('T', ModItems.SOULCOPPER_TORCH_ITEM.get())
                    .define('B', Items.BLAZE_ROD)
                    .group("instrumentus")
                    .unlockedBy("has_soulcopper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOULCOPPER_INGOT.get()))
                    .save(consumer);
            CopperSoulCampfireCookingRecipeBuilder.smelting(
                            ResourceLocation.fromNamespaceAndPath(Instrumentus.MODID, "raw_copper_block_to_raw_soulcopper"),
                            Ingredient.of(Items.RAW_COPPER_BLOCK.getDefaultInstance()),
                            ModItems.RAW_SOULCOPPER.get().getDefaultInstance(),
                            1200
                    )
                    .group("instrumentus")
                    .unlockedBy("has_raw_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RAW_COPPER_BLOCK))
                    .save(consumer);
        }
        if (Config.EXCAVATORS.get()) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_EXCAVATOR.get())
                    .pattern("I")
                    .pattern("S")
                    .pattern("S")
                    .define('I', ItemTags.LOGS)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_log", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_LOG))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_EXCAVATOR.get())
                    .pattern("I")
                    .pattern("S")
                    .pattern("S")
                    .define('I', Tags.Items.STONES)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_EXCAVATOR.get())
                    .pattern("I")
                    .pattern("S")
                    .pattern("S")
                    .define('I', Items.IRON_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_iron_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BLOCK))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_EXCAVATOR.get())
                    .pattern("I")
                    .pattern("S")
                    .pattern("S")
                    .define('I', Items.GOLD_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_gold_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_BLOCK))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_EXCAVATOR.get())
                    .pattern("I")
                    .pattern("S")
                    .pattern("S")
                    .define('I', Items.DIAMOND_BLOCK)
                    .define('S', Items.STICK)
                    .group("instrumentus")
                    .unlockedBy("has_diamond_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_BLOCK))
                    .save(consumer);
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(ModItems.DIAMOND_EXCAVATOR.get()),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.TOOLS,
                            ModItems.NETHERITE_EXCAVATOR.get())
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(consumer, "netherite_excavator_smithing");
        }
    }
}
