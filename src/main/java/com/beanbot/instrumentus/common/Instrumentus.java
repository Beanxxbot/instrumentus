package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.client.ToolRenderEvents;
import com.beanbot.instrumentus.client.particles.ModParticles;
import com.beanbot.instrumentus.client.renderer.CopperSoulCampfireRenderer;
import com.beanbot.instrumentus.common.blocks.ModBlocks;
import com.beanbot.instrumentus.common.blocks.entities.ModBlockEntities;
import com.beanbot.instrumentus.common.capability.EnergyItemstack;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.events.EntityStruckByLightningEventHook;
import com.beanbot.instrumentus.common.events.loot.ModLootModifiers;
import com.beanbot.instrumentus.common.items.ModItems;
import com.beanbot.instrumentus.common.creative.ModCreativeModeTab;
import com.beanbot.instrumentus.common.creative.ModCreativeModeTabPopulate;
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
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
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

        Config.register(MOD_CONTAINER);

        NeoForge.EVENT_BUS.register(new EntityStruckByLightningEventHook());

        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus but on NeoForge");
        ModParticles.PARTICLE_TYPES.register(instrumentusEventBus);

        if (Config.SHEARS.get())
            ModItems.SHEARS.register(instrumentusEventBus);

        if (Config.SICKLES.get())
            ModItems.SICKLES.register(instrumentusEventBus);

        if (Config.PAXELS.get())
            ModItems.PAXELS.register(instrumentusEventBus);

        if (Config.HAMMERS.get())
            ModItems.HAMMERS.register(instrumentusEventBus);

        if (Config.ENERGIZED.get()) {
            ModItems.ENERGIZED.register(instrumentusEventBus);
            ModBlocks.ENERGIZED.register(instrumentusEventBus);
        }

        if (Config.KNIVES.get())
            ModItems.KNIVES.register(instrumentusEventBus);

        if (Config.SOULCOPPER.get()) {
            ModItems.SOULCOPPER.register(instrumentusEventBus);
            ModBlocks.SOULCOPPER.register(instrumentusEventBus);
        }
        if (Config.COPPER_TOOLS.get())
            ModItems.COPPER.register(instrumentusEventBus);

        if (Config.BRUSHES.get())
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
        ModCreativeModeTabPopulate.populate(event);
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
