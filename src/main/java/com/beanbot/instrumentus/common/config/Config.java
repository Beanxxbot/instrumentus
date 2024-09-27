package com.beanbot.instrumentus.common.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

@SuppressWarnings("unused")
public class Config {
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder STARTUP_BUILDER = new ModConfigSpec.Builder();

    public static final String CATEGORY_TOOLS = "tools";
    public static ModConfigSpec.BooleanValue HAMMERS;
    public static ModConfigSpec.BooleanValue SICKLES;
    public static ModConfigSpec.BooleanValue SHEARS;
    public static ModConfigSpec.BooleanValue PAXELS;
    public static ModConfigSpec.BooleanValue SOULCOPPER;
    public static ModConfigSpec.BooleanValue ENERGIZED;
    public static ModConfigSpec.BooleanValue KNIVES;
    public static ModConfigSpec.BooleanValue COPPER_TOOLS;
    public static ModConfigSpec.BooleanValue BRUSHES;
    public static ModConfigSpec.BooleanValue EXCAVATORS;
    public static ModConfigSpec.BooleanValue FIRING;
    public static ModConfigSpec.BooleanValue EXPERIMENTAL;

    public static void register(ModContainer container){
//        registerServerConfig(container);
//        registerClientConfig(container);
        registerCommonConfig(container);
//        registerStartupConfig(container);
    }

    private static void registerServerConfig(ModContainer container){

    }

    private static void registerClientConfig(ModContainer container){

    }

    private static void registerCommonConfig(ModContainer container){
        toolsConfig();
        container.registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build(), "instrumentus-common.toml");
    }

    private static void registerStartupConfig(ModContainer container){

    }

    private static void toolsConfig() {
        COMMON_BUILDER.comment("Enable/Disable the Various Tools included in the Mod").push(CATEGORY_TOOLS);
        HAMMERS = COMMON_BUILDER.comment("Hammers mine in a 3x3 radius, made of every single tool material")
                .define("enable_hammers", true);

        SICKLES = COMMON_BUILDER.comment("Sickles mass harvest leaf and tall-grass blocks, their range increases the higher the tool level")
                .define("enable_sickles", true);

        SHEARS = COMMON_BUILDER.comment("Material variants for iron shears (Wood-Netherite)")
                .define("enable_shears", true);

        PAXELS = COMMON_BUILDER.comment("The original item in the mod! Paxels are a tool able to mine all blocks that an Axe, Pickaxe and Shovel Can")
                .define("enable_paxels", true);

        SOULCOPPER = COMMON_BUILDER.comment("Soulcopper items currently present in instrumentus is the Soul-Infused Pickaxe, which places light blocks on right click")
                .define("enable_soulcopper", true);

        ENERGIZED = COMMON_BUILDER.comment("RF-Powered tools made of diamonds, emeralds and redstone. This will also disable carbon rods.")
                .define("enable_energized", true);

        KNIVES = COMMON_BUILDER.comment("Knives harvest plant fiber from tall grass, which can be used to make string. Disables Knives as well as plant fiber.")
                .define("enable_knives", true);

        COPPER_TOOLS = COMMON_BUILDER.comment("Copper Tools that are slower than iron tools, but have three times the durability")
                .define("enable_copper", true);

        BRUSHES = COMMON_BUILDER.comment("Brushes made of every tool material, including Instrumentus ones - their speed stays the same, however they have different durabilities")
                .define("enable_brushes", true);

        EXCAVATORS = COMMON_BUILDER.comment("Excavators are 3x3 shovels that can mine a bunch of dirt!")
                .define("enable_excavators", true);

        FIRING = COMMON_BUILDER.comment("Enable the Kiln, which is a furnace variant that can be used to smelt the miscellaneous items that the Blast Furnace and Smoker do not smelt.")
                .define("enable_firing", true);

        EXPERIMENTAL = COMMON_BUILDER.comment("Category for experimental features that are not yet fully tested, complete, or may be removed in the future. Use at your own risk!")
                .define("enable_experimental", false);

        COMMON_BUILDER.pop();
    }
}
