package com.beanbot.instrumentus.common.config;

import com.beanbot.instrumentus.common.Instrumentus;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER;

    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT;

    static {
        ItemConfig.init(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER = SERVER_BUILDER.build();
        CLIENT = CLIENT_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path){
        Instrumentus.LOGGER.info("Loading Config File: " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        Instrumentus.LOGGER.info("Built Config: " + path);
        file.load();
        Instrumentus.LOGGER.info("Loaded Config: " + path);
        config.setConfig(file);
    }
}
