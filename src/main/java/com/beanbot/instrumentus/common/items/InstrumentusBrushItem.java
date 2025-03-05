package com.beanbot.instrumentus.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tiers;

import java.util.List;

public class InstrumentusBrushItem extends BrushItem {

    protected Tier tier;
    public InstrumentusBrushItem(Tier material) {
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

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        Component press = Component.translatable("instrumentus.tooltip.press_shift").withStyle(ChatFormatting.GRAY);
        Component empty = Component.literal("");
        Component pressed1 = Component.translatable("instrumentus.tooltip.brush_1").withStyle(ChatFormatting.GRAY);
        Component pressed2 = Component.translatable("instrumentus.tooltip.brush_2").withStyle(ChatFormatting.GRAY);
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
