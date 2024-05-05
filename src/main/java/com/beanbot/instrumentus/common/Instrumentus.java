package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.client.ToolRenderEvents;
import com.beanbot.instrumentus.client.particles.ModParticles;
import com.beanbot.instrumentus.client.renderer.CopperSoulCampfireRenderer;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.blocks.entities.ModBlockEntities;
import com.beanbot.instrumentus.common.capability.EnergyItemstack;
import com.beanbot.instrumentus.common.capability.ModCapabilities;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.config.ItemConfig;
import com.beanbot.instrumentus.common.events.EntityStruckByLightningEventHook;
import com.beanbot.instrumentus.common.events.loot.ModLootModifiers;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.common.creative.ModCreativeModeTab;
import com.beanbot.instrumentus.common.creative.ModCreativeTabPopulate;
import com.beanbot.instrumentus.common.items.datacomponents.ModDataComponents;
import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.recipe.ModRecipes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Instrumentus.MODID)
public class Instrumentus {

    public static final String MODID = "instrumentus";
    private static Instrumentus instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ModContainer MOD_CONTAINER = ModLoadingContext.get().getActiveContainer();


    public Instrumentus(IEventBus instrumentusEventBus, Dist dist)
    {
        ModCreativeModeTab.register(instrumentusEventBus);

        MOD_CONTAINER.registerConfig(ModConfig.Type.SERVER, Config.SERVER, "instrumentus-server.toml");
        MOD_CONTAINER.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "instrumentus-client.toml");


        NeoForge.EVENT_BUS.register(new EntityStruckByLightningEventHook());

        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus but on NeoForge");
        ModParticles.PARTICLE_TYPES.register(instrumentusEventBus);

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("instrumentus-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("instrumentus-server.toml").toString());

        if (ItemConfig.enable_shears.get())
            ModItems.SHEARS.register(instrumentusEventBus);
        if (ItemConfig.enable_sickles.get())
            ModItems.SICKLES.register(instrumentusEventBus);
        if (ItemConfig.enable_paxels.get())
            ModItems.PAXELS.register(instrumentusEventBus);
        if (ItemConfig.enable_hammers.get())
            ModItems.HAMMERS.register(instrumentusEventBus);
        if (ItemConfig.enable_energized.get()) {
            ModItems.ENERGIZED.register(instrumentusEventBus);
            ModBlocks.ENERGIZED.register(instrumentusEventBus);
        }
        if (ItemConfig.enable_util.get()) {
            ModItems.UTILITIES.register(instrumentusEventBus);
            ModBlocks.UTILITIES.register(instrumentusEventBus);
        }
        ModItems.COPPER.register(instrumentusEventBus);
        ModItems.BRUSHES.register(instrumentusEventBus);

        instrumentusEventBus.addListener(this::addCreative);

        ModBlockEntities.register(instrumentusEventBus);

        ModRecipes.register(instrumentusEventBus);

        ModLootModifiers.register(instrumentusEventBus);

        ModDataComponents.COMPONENTS.register(instrumentusEventBus);

        instrumentusEventBus.addListener(this::attachCapabilities);

        instrumentusEventBus.addListener(this::setup);
        instrumentusEventBus.addListener(this::setupClient);

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ModCreativeTabPopulate.populate(event);
    }
    private void attachCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(Capabilities.EnergyStorage.ITEM, (itemStack, context) -> {
            int capacity = 20000;
            if (itemStack.getItem() instanceof IEnergyItem energyItem) {
                capacity = energyItem.getMaxCapacity();
            }
            return new EnergyItemstack(capacity, itemStack);
        },
                ModItems.ENERGIZED_AXE.get(),
                ModItems.ENERGIZED_PICKAXE.get(),
                ModItems.ENERGIZED_SHOVEL.get(),
                ModItems.ENERGIZED_PAXEL.get(),
                ModItems.ENERGIZED_SHEARS.get(),
                ModItems.ENERGIZED_SICKLE.get(),
                ModItems.ENERGIZED_HAMMER.get(),
                ModItems.ENERGIZED_KNIFE.get(),
                ModItems.ENERGIZED_BRUSH.get(),
                ModItems.ENERGY_LIGHTNING_ROD.get()
        );
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_SOUL_CAMPFIRE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULCOPPER_WALL_TORCH.get(), RenderType.cutout());
        BlockEntityRenderers.register(ModBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireRenderer::new);

        NeoForge.EVENT_BUS.register(ToolRenderEvents.class);
    }

    public static Instrumentus getInstance() { return instance; }

}
