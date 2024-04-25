package com.beanbot.instrumentus.common.config;

import com.beanbot.instrumentus.common.Instrumentus;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.io.File;

public class Config {
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SERVER;

    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec CLIENT;

    static {
        ItemConfig.init(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER = SERVER_BUILDER.build();
        CLIENT = CLIENT_BUILDER.build();
    }

    public static void loadConfig(ModConfigSpec config, String path){
        Instrumentus.LOGGER.info("Loading Config File: " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        Instrumentus.LOGGER.info("Built Config: " + path);
        file.load();
        Instrumentus.LOGGER.info("Loaded Config: " + path);
        config.setConfig(file);
    }
}
