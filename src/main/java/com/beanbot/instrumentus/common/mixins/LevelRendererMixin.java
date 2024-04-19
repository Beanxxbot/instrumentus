package com.beanbot.instrumentus.common.mixins;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.SortedSet;

@Mixin(LevelRenderer.class)
@OnlyIn(Dist.CLIENT)
public class LevelRendererMixin {

//    @Shadow @Final private MinecraftClient client;
//    @Shadow private ClientLevel level;
//    @Shadow @Final private Long2ObjectMap<SortedSet<Break>>

}
