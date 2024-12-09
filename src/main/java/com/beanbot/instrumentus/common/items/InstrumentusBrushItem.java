package com.beanbot.instrumentus.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class InstrumentusBrushItem extends BrushItem {

    protected ToolMaterial material;
    public InstrumentusBrushItem(ToolMaterial material) {
        super(new Item.Properties().durability(material.durability()));
        this.material = material;
    }
}
