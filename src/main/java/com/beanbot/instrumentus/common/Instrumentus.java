package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.client.ToolRenderEvents;
import com.beanbot.instrumentus.client.particles.ModParticles;
import com.beanbot.instrumentus.client.renderer.CopperSoulCampfireRenderer;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.blocks.entities.ModBlockEntities;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.config.ItemConfig;
import com.beanbot.instrumentus.common.events.EntityStruckByLightningEventHook;
import com.beanbot.instrumentus.common.events.loot.ModLootModifiers;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.common.creative.ModCreativeModeTab;
import com.beanbot.instrumentus.common.creative.ModCreativeTabPopulate;
import com.beanbot.instrumentus.recipe.ModRecipes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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


    public Instrumentus()
    {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(event);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "instrumentus-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "instrumentus-client.toml");

        MinecraftForge.EVENT_BUS.register(new EntityStruckByLightningEventHook());

        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus");
        ModParticles.PARTICLE_TYPES.register(event);

        event.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        event.addListener(this::addCreative);

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
        ModItems.COPPER.register(event);
        ModItems.BRUSHES.register(event);

        ModBlockEntities.register(event);

        ModRecipes.register(event);

        ModLootModifiers.register(event);

        event.addListener(this::setup);
        event.addListener(this::setupClient);

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ModCreativeTabPopulate.populate(event);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_SOUL_CAMPFIRE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_WALL_TORCH.get(), RenderType.cutout());
        BlockEntityRenderers.register(ModBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireRenderer::new);

        MinecraftForge.EVENT_BUS.register(new ToolRenderEvents());
    }

    public static Instrumentus getInstance() { return instance; }

}
