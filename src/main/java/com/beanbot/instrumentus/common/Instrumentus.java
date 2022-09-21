package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.config.ItemConfig;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
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
    private static Instrumentus instance;
    public static final Logger LOGGER = LogManager.getLogger();

    //TODO Do I need this?
//    public static final ISidedReference SIDED_SYSTEM = DistExecutor.safeRunForDist(() -> ClientReference::new, () -> DedicatedServerReference::new);

    public static final CreativeModeTab MOD_ITEM_GROUP = new CreativeModeTab(Instrumentus.MODID) {
        @Override
        public ItemStack makeIcon() {
            ItemStack itemStack = new ItemStack(ModItems.DIAMOND_PAXEL.get());
            return itemStack;
        }
    };
    public Instrumentus()
    {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "instrumentus-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "instrumentus-client.toml");

        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus");

        event.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("instrumentus-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("instrumentus-server.toml").toString());

        if (ItemConfig.enable_shears.get())
            ModItems.SHEARS.register(event);
        if (ItemConfig.enable_sickles.get())
            ModItems.SICKLES.register(event);
        if (ItemConfig.enable_paxels.get())
            ModItems.PAXELS.register(event);
        if (ItemConfig.enable_hammers.get())
            ModItems.HAMMERS.register(event);
        if (ItemConfig.enable_energized.get()) {
            ModItems.ENERGIZED.register(event);
            ModBlocks.ENERGIZED.register(event);
        }
        if (ItemConfig.enable_util.get()) {
            ModItems.UTILITIES.register(event);
            ModBlocks.UTILITIES.register(event);
        }
        if (ItemConfig.enable_armor.get())
            ModItems.ARMOR.register(event);

        event.addListener(this::setup);
        event.addListener(this::setupClient);

    }

    private void setup(final FMLCommonSetupEvent event) {
//        event.enqueueWork(() -> {
//            ToolTags.init();
//        });
    }

    private void setupClient(final FMLClientSetupEvent event) {
//        ModKeys.register();
    }

    public static Instrumentus getInstance() { return instance; }

}
