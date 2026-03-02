package com.beanbot.instrumentus.common.helper;

import com.beanbot.instrumentus.common.items.InstrumentusToolMaterials;
import com.beanbot.instrumentus.common.items.KnifeItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public interface InstrumentusItemHelper {

     static ItemAttributeModifiers createAttributes(float attackDamageIn, float attackSpeedIn) {
        return ItemAttributeModifiers.builder()
        .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double) attackDamageIn, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
        .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double) attackSpeedIn, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
        .build();
    }

     static Item.Properties generateShearsItemProperties(ToolMaterial toolMaterial) {
        if (toolMaterial == ToolMaterial.NETHERITE || toolMaterial == InstrumentusToolMaterials.ENERGIZED) {
            new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(toolMaterial.durability() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties()).fireResistant();
        }
        return new Item.Properties().stacksTo(1).durability(Math.toIntExact(Math.round(toolMaterial.durability() * 0.952))).component(DataComponents.TOOL, ShearsItem.createToolProperties());
    }

    static Item.Properties generateToolItemProperties(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn) {
        if (toolMaterial == ToolMaterial.NETHERITE) {
            return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant();
        } else if (toolMaterial == InstrumentusToolMaterials.ENERGIZED) {
            return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1).durability(0).fireResistant();
        }
        return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1);
    }

    static Item.Properties generateKnifeItemProperties(ToolMaterial toolMaterial, float attackDamageIn, float attackSpeedIn) {
        if (toolMaterial == ToolMaterial.NETHERITE) {
            return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant().component(DataComponents.TOOL, KnifeItem.createToolProperties(toolMaterial, attackSpeedIn));
        } else if (toolMaterial == InstrumentusToolMaterials.ENERGIZED) {
            return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1).fireResistant().durability(0).component(DataComponents.TOOL, KnifeItem.createToolProperties(toolMaterial, attackSpeedIn));
        }
        return new Item.Properties().attributes(InstrumentusItemHelper.createAttributes(attackDamageIn, attackSpeedIn)).stacksTo(1).component(DataComponents.TOOL, KnifeItem.createToolProperties(toolMaterial, attackSpeedIn));
    }
}
