package com.beanbot.instrumentus.common;

import com.beanbot.instrumentus.client.events.ToolRenderEvents;
import com.beanbot.instrumentus.client.inventory.recipebook.RecipeBookExtensionClientHelper;
import com.beanbot.instrumentus.client.ponder.InstrumentusPonderPlugin;
import com.beanbot.instrumentus.common.data.attachments.InstrumentusDataAttachments;
import com.beanbot.instrumentus.common.data.conditions.InstrumentusConditions;
import com.beanbot.instrumentus.common.data.loot.functions.InstrumentusLootFunctions;
import com.beanbot.instrumentus.common.events.WindBlowerPhantomPrevention;
import com.beanbot.instrumentus.common.inventory.InstrumentusMenus;
import com.beanbot.instrumentus.client.particles.InstrumentusParticles;
import com.beanbot.instrumentus.client.renderer.CopperSoulCampfireRenderer;
import com.beanbot.instrumentus.common.blocks.InstrumentusBlocks;
import com.beanbot.instrumentus.common.blocks.entities.InstrumentusBlockEntities;
import com.beanbot.instrumentus.common.capability.EnergyItemstack;
import com.beanbot.instrumentus.common.config.Config;
import com.beanbot.instrumentus.common.events.EntityStruckByLightningEventHook;
import com.beanbot.instrumentus.common.data.loot.InstrumentusLootModifiers;
import com.beanbot.instrumentus.common.items.InstrumentusArmorMaterials;
import com.beanbot.instrumentus.common.items.InstrumentusItems;
import com.beanbot.instrumentus.common.creative.InstrumentusCreativeModeTab;
import com.beanbot.instrumentus.common.creative.InstrumentusCreativeModeTabPopulate;
import com.beanbot.instrumentus.common.items.datacomponents.InstrumentusDataComponents;
import com.beanbot.instrumentus.common.items.interfaces.IEnergyItem;
import com.beanbot.instrumentus.common.network.PacketHandler;
import com.beanbot.instrumentus.common.recipe.InstrumentusRecipes;
import net.createmod.ponder.foundation.PonderIndex;
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
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Instrumentus.MODID)
public class Instrumentus {

    public static final String MODID = "instrumentus";
    @SuppressWarnings("unused")
    private static Instrumentus instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ModContainer MOD_CONTAINER = ModLoadingContext.get().getActiveContainer();


    public Instrumentus(IEventBus instrumentusEventBus, @SuppressWarnings("unused") Dist dist) {
        InstrumentusCreativeModeTab.register(instrumentusEventBus);

        Config.register(MOD_CONTAINER);

        InstrumentusConditions.register(instrumentusEventBus);
        InstrumentusLootFunctions.register(instrumentusEventBus);

        NeoForge.EVENT_BUS.register(new EntityStruckByLightningEventHook());
        NeoForge.EVENT_BUS.register(new WindBlowerPhantomPrevention());

        instrumentusEventBus.addListener(PacketHandler::registerNetworking);
        LOGGER.debug("Yo Yo Yo It's Ya Boi, Instrumentus but on NeoForge");
        InstrumentusParticles.PARTICLE_TYPES.register(instrumentusEventBus);

        InstrumentusArmorMaterials.register(instrumentusEventBus);

        InstrumentusItems.ITEMS_REGISTRAR.register(instrumentusEventBus);
        InstrumentusBlocks.BLOCKS_REGISTER.register(instrumentusEventBus);

        instrumentusEventBus.addListener(this::addCreative);

        InstrumentusMenus.register(instrumentusEventBus);
        instrumentusEventBus.addListener(this::registerRecipeBookCategories);

        InstrumentusBlockEntities.register(instrumentusEventBus);

        InstrumentusDataAttachments.register(instrumentusEventBus);

        InstrumentusRecipes.register(instrumentusEventBus);

        InstrumentusLootModifiers.register(instrumentusEventBus);

        InstrumentusDataComponents.COMPONENTS.register(instrumentusEventBus);

        instrumentusEventBus.addListener(this::attachCapabilities);

        instrumentusEventBus.addListener(this::setup);
        instrumentusEventBus.addListener(this::setupClient);

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        InstrumentusCreativeModeTabPopulate.populate(event);
    }

    private void attachCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(Capabilities.EnergyStorage.ITEM, (itemStack, context) -> {
                    int capacity = 20000;
                    if (itemStack.getItem() instanceof IEnergyItem energyItem) {
                        capacity = energyItem.getMaxCapacity();
                    }
                    return new EnergyItemstack(capacity, itemStack);
                },
                InstrumentusItems.ENERGIZED_AXE.get(),
                InstrumentusItems.ENERGIZED_PICKAXE.get(),
                InstrumentusItems.ENERGIZED_SHOVEL.get(),
                InstrumentusItems.ENERGIZED_PAXEL.get(),
                InstrumentusItems.ENERGIZED_HOE.get(),
                InstrumentusItems.ENERGIZED_SHEARS.get(),
                InstrumentusItems.ENERGIZED_SICKLE.get(),
                InstrumentusItems.ENERGIZED_HAMMER.get(),
                InstrumentusItems.ENERGIZED_KNIFE.get(),
                InstrumentusItems.ENERGIZED_BRUSH.get(),
                InstrumentusItems.ENERGIZED_LIGHTNING_ROD.get(),
                InstrumentusItems.ENERGIZED_EXCAVATOR.get()
        );
    }

    private void setupClient(final FMLClientSetupEvent event) {
        BlockEntityRenderers.register(InstrumentusBlockEntities.COPPER_SOUL_CAMPFIRE_BLOCK_ENTITY.get(), CopperSoulCampfireRenderer::new);
        PonderIndex.addPlugin(new InstrumentusPonderPlugin());
        NeoForge.EVENT_BUS.register(ToolRenderEvents.class);
    }

    private void registerRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        RecipeBookExtensionClientHelper.init(event);
    }

    @SuppressWarnings("unused")
    public static Instrumentus getInstance() {
        return instance;
    }

}
