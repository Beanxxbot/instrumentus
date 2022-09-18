package com.beanbot.instrumentus.common.init;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups {

    public static class ModItemGroup extends CreativeModeTab {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack makeIcon() {
            return iconSupplier.get();
        }
    }

    public static final CreativeModeTab MOD_ITEM_GROUP = new ModItemGroup(Instrumentus.MODID, () -> new ItemStack(ModItems.WOODEN_SHEARS));
}
