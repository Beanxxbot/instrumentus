package com.beanbot.instrumentus.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class InstrumentusShearsItem extends ShearsItem {

    public InstrumentusShearsItem(Tier tier) {
        super(generateItemProperties(tier));
    }

    private static Item.Properties generateItemProperties(Tier tier) {
        if (tier == Tiers.NETHERITE || tier == InstrumentusItemTiers.ENERGIZED) {
            new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(tier.getUses() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties()).fireResistant();
        }
        return new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(tier.getUses() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties());
    }
}
