package com.beanbot.instrumentus.common.inventory;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, Instrumentus.MODID);

    public static final Supplier<MenuType<KilnMenu>> KILN_MENU = MENU_TYPES.register(
    "kiln", () -> IMenuTypeExtension.create(((windowId, inv, data) -> new KilnMenu(windowId, inv))));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
