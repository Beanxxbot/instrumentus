package com.beanbot.instrumentus.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ItemConfig {
    public static ForgeConfigSpec.BooleanValue enable_hammers;
    public static ForgeConfigSpec.BooleanValue enable_sickles;
    public static ForgeConfigSpec.BooleanValue enable_shears;
    public static ForgeConfigSpec.BooleanValue enable_armor;
    public static ForgeConfigSpec.BooleanValue enable_paxels;
    public static ForgeConfigSpec.BooleanValue enable_util;
    public static ForgeConfigSpec.BooleanValue enable_energized;
    public static ForgeConfigSpec.BooleanValue enable_knives;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client){
        server.comment("Enable/Disable the Various Tools included in the Mod");

        enable_hammers = server
                .comment("Hammers mine in a 3x3 Radius, made of every single tool material.")
                .define("instrumentus.enable_hammers", true);

        enable_sickles = server
                .comment("Sickles mass harvest leaf and tall-grass blocks, their range increases the higher the tool level")
                .define("instrumentus.enable_sickles", true);

        enable_shears = server
                .comment("Material variants for iron shears (Wood-Netherite)")
                .define("instrumentus.enable_shears", true);

        enable_armor = server
                .comment("Armor with special set-bonus abilities")
                .define("instrumentus.enable_armor", true);

        enable_paxels = server
                .comment("The original item in the mod! Paxels are a tool able to mine all blocks that an Axe, Pickaxe and Shovel Can")
                .define("instrumentus.enable_paxels", true);

        enable_util = server
                .comment("Utility items currently present in instrumentus is the Soul-Infused Pickaxe, which places light blocks on right click")
                .define("instrumentus.enable_util", true);

        enable_energized = server
                .comment("RF-Powered tools made of diamonds, emeralds and redstone. This will also disable carbon rods.")
                .define("instrumentus.enable_energized", true);

        enable_knives = server
                .comment("Knives harvest plant fiber from tall grass, which can be used to make string. Disables Knives as well as plant fiber.")
                .define("instrumentus.enable_knives", true);
    }
}
