package com.beanbot.instrumentus.common.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ItemConfig {
    public static ModConfigSpec.BooleanValue enable_hammers;
    public static ModConfigSpec.BooleanValue enable_sickles;
    public static ModConfigSpec.BooleanValue enable_shears;
    public static ModConfigSpec.BooleanValue enable_armor;
    public static ModConfigSpec.BooleanValue enable_paxels;
    public static ModConfigSpec.BooleanValue enable_util;
    public static ModConfigSpec.BooleanValue enable_energized;
    public static ModConfigSpec.BooleanValue enable_knives;

    public static final String CATEGORY_TOOLS = "tools";

    public static void init(ModConfigSpec.Builder common, ModConfigSpec.Builder client, ModConfigSpec.Builder server){
        common.comment("Enable/Disable the Various Tools included in the Mod").push(CATEGORY_TOOLS);

        enable_hammers = common
                .comment("Hammers mine in a 3x3 Radius, made of every single tool material.")
                .define("instrumentus.enable_hammers", true);

        enable_sickles = common
                .comment("Sickles mass harvest leaf and tall-grass blocks, their range increases the higher the tool level")
                .define("instrumentus.enable_sickles", true);

        enable_shears = common
                .comment("Material variants for iron shears (Wood-Netherite)")
                .define("instrumentus.enable_shears", true);

        enable_armor = common
                .comment("Armor with special set-bonus abilities")
                .define("instrumentus.enable_armor", true);

        enable_paxels = common
                .comment("The original item in the mod! Paxels are a tool able to mine all blocks that an Axe, Pickaxe and Shovel Can")
                .define("instrumentus.enable_paxels", true);

        enable_util = common
                .comment("Utility items currently present in instrumentus is the Soul-Infused Pickaxe, which places light blocks on right click")
                .define("instrumentus.enable_util", true);

        enable_energized = common
                .comment("RF-Powered tools made of diamonds, emeralds and redstone. This will also disable carbon rods.")
                .define("instrumentus.enable_energized", true);

        enable_knives = common
                .comment("Knives harvest plant fiber from tall grass, which can be used to make string. Disables Knives as well as plant fiber.")
                .define("instrumentus.enable_knives", true);

        common.pop();
    }
}
