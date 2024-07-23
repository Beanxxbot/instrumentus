package com.beanbot.instrumentus.common.config;

import com.beanbot.instrumentus.common.Instrumentus;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.io.File;

public class Config {
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

    public static final String CATEGORY_TOOLS = "tools";
    public static ModConfigSpec.BooleanValue HAMMERS;
    public static ModConfigSpec.BooleanValue SICKLES;
    public static ModConfigSpec.BooleanValue SHEARS;
    public static ModConfigSpec.BooleanValue PAXELS;
    public static ModConfigSpec.BooleanValue SOULCOPPER;
    public static ModConfigSpec.BooleanValue ENERGIZED;
    public static ModConfigSpec.BooleanValue KNIVES;

    public static void register(ModContainer container){
        registerServerConfig(container);
        registerClientConfig(container);
        registerCommonConfig(container);
    }

    private static void registerServerConfig(ModContainer container){

    }

    private static void registerClientConfig(ModContainer container){

    }

    private static void registerCommonConfig(ModContainer container){
        toolsConfig();
        container.registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }

    private static void toolsConfig() {
        COMMON_BUILDER.comment("Enable/Disable the Various Tools included in the Mod").push(CATEGORY_TOOLS);
        HAMMERS = COMMON_BUILDER.comment("Hammers mine in a 3x3 radius, made of every single tool material")
                .define("enable_hammers", true);
        COMMON_BUILDER.comment("Sickles mass harvest leaf and tall-grass blocks, their range increases the higher the tool level")
                .define("enable_sickles", true);

        COMMON_BUILDER.comment("Material variants for iron shears (Wood-Netherite)")
                .define("enable_shears", true);

        COMMON_BUILDER.comment("Armor with special set-bonus abilities")
                .define("enable_armor", true);

        COMMON_BUILDER.comment("The original item in the mod! Paxels are a tool able to mine all blocks that an Axe, Pickaxe and Shovel Can")
                .define("enable_paxels", true);

        COMMON_BUILDER.comment("Utility items currently present in instrumentus is the Soul-Infused Pickaxe, which places light blocks on right click")
                .define("enable_util", true);

        COMMON_BUILDER.comment("RF-Powered tools made of diamonds, emeralds and redstone. This will also disable carbon rods.")
                .define("enable_energized", true);

        COMMON_BUILDER.comment("Knives harvest plant fiber from tall grass, which can be used to make string. Disables Knives as well as plant fiber.")
                .define("instrumentus.enable_knives", true);

        COMMON_BUILDER.pop();
    }
}
