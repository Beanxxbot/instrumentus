package com.beanbot.instrumentus.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.shears_1").withStyle(ChatFormatting.GRAY);
        Component pressed2 = Component.translatable("instrumentus.tooltip.shears_2").withStyle(ChatFormatting.GRAY);
        if (Screen.hasShiftDown()) {
            tooltip.add(press);
            tooltip.add(empty);
            tooltip.add(pressed1);
            tooltip.add(pressed2);
        } else {
            tooltip.add(press);
        }
    }
}
