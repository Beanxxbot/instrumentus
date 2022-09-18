package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.client.ClientReference;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.server.dedicated.DedicatedServerReference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Instrumentus.MODID)
public class Instrumentus {

    public static final String MODID = "instrumentus";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final ISidedReference SIDED_SYSTEM = DistExecutor.safeRunForDist(() -> ClientReference::new, () -> DedicatedServerReference::new);

    public Instrumentus()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "instrumentus-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "instrumentus-client.toml");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus");

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("instrumentus-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("instrumentus-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

}
