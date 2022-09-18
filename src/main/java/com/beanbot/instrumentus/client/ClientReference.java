package com.beanbot.instrumentus.client;

//import com.beanbot.instrumentus.client.renderer.entity.model.SolarArmorModel;
//import com.beanbot.instrumentus.client.renderer.entity.model.WarpedArmorModel;
import com.beanbot.instrumentus.common.ISidedReference;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

public class ClientReference implements ISidedReference {

//    private final SolarArmorModel solarArmorModel = new SolarArmorModel(1.0f);
//    private final SolarArmorModel solarArmorLeggings = new SolarArmorModel(0.5f);

//    private final WarpedArmorModel warpedArmorModel = new WarpedArmorModel(1.0f);
//    private final WarpedArmorModel warpedArmorLeggings = new WarpedArmorModel(0.5f);

    //public static final KeyMapping warpedTeleportBinding = new KeyMapping("key.instrumentus.warpedTeleport", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.instrumentus.categories.main");
    public static final KeyMapping warpedTeleportBinding = new KeyMapping("instrumentus.key.warpedTeleport", InputConstants.KEY_V, KeyMapping.CATEGORY_GAMEPLAY);

    @Override
    public void setup(final IEventBus mod, final IEventBus forge) {
        mod.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(warpedTeleportBinding);
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public <A> A getSolarArmorMaterial(EquipmentSlot armorSlot) {
//        return (A) (armorSlot == EquipmentSlot.LEGS ? solarArmorLeggings : solarArmorModel);
//    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public <A> A getWarpedArmorMaterial(EquipmentSlot armorSlot) {
//        return (A) (armorSlot == EquipmentSlot.LEGS ? warpedArmorLeggings : warpedArmorModel);
//    }
}
