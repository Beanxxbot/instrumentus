package com.beanbot.instrumentus.common.items;

import net.minecraft.world.item.*;

public class ModBrushItem extends BrushItem {

    protected Tier material;
    public ModBrushItem(Tier material) {
        super(new Item.Properties().durability(material.getUses()));
        this.material = material;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        if (material == Tiers.WOOD || material == Tiers.STONE) {
            return 300;
        } else if (material == Tiers.IRON) {
            return 250;
        } else if (material == Tiers.GOLD || material == Tiers.DIAMOND || material == Tiers.NETHERITE) {
            return 100;
        } else {
            return 200;
        }
    }
}
