package com.beanbot.instrumentus.common.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ToolMaterial;

public class InstrumentusShearsItem extends ShearsItem {

    public InstrumentusShearsItem(ToolMaterial toolMaterial) {
        super(generateItemProperties(toolMaterial));
    }

    private static Item.Properties generateItemProperties(ToolMaterial tier) {
        if (tier == ToolMaterial.NETHERITE || tier == InstrumentusToolMaterials.ENERGIZED) {
            new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(tier.durability() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties()).fireResistant();
        }
        return new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(tier.durability() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties());
    }
}
