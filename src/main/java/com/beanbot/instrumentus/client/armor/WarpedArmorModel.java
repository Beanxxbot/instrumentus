package com.beanbot.instrumentus.client.armor;

import com.beanbot.instrumentus.common.Instrumentus;
import com.beanbot.instrumentus.common.items.WarpedArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WarpedArmorModel extends AnimatedGeoModel<WarpedArmorItem> {
    @Override
    public ResourceLocation getModelLocation(WarpedArmorItem object) {
        return new ResourceLocation(Instrumentus.MODID, "geo/warped_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WarpedArmorItem object) {
        return new ResourceLocation(Instrumentus.MODID, "textures/models/armor/warped_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WarpedArmorItem animatable) {
        return new ResourceLocation(Instrumentus.MODID, "animations/armor_animations.json");
    }
}
