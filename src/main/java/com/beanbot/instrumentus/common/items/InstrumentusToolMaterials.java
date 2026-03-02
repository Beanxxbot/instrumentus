package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.common.data.generator.InstrumentusGeneratorItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class InstrumentusToolMaterials {
    public static final ToolMaterial COPPER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            175,
            5.0f,
            1.0f,
            8,
            InstrumentusGeneratorItemTags.COPPER_TOOL_MATERIALS
    );

    public static final ToolMaterial ENERGIZED = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            9.0F,
            4.0F,
            15,
            InstrumentusGeneratorItemTags.ENERGIZED_TOOL_MATERIALS

    );
}
