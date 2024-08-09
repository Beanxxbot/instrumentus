package com.beanbot.instrumentus.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tiers;

public class ModBrushItem extends BrushItem {

    protected Tier tier;
    public ModBrushItem(Tier material) {
        super(new Item.Properties().durability(material.getUses()));
        this.tier = material;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return switch (tier) {
            case Tiers.WOOD, Tiers.STONE -> 300;
            case Tiers.IRON -> 150;
            case Tiers.GOLD, Tiers.DIAMOND, Tiers.NETHERITE -> 50;
            case null, default -> 200;
        };
    }
}
