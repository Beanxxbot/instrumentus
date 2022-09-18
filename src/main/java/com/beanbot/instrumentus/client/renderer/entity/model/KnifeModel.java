//package com.beanbot.instrumentus.client.renderer.entity.model;// Made with Blockbench 3.7.5
//// Exported for Minecraft version 1.15
//// Paste this class into your mod and generate all required imports
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.model.Model;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import net.minecraft.util.ResourceLocation;
//
//public class KnifeModel extends Model {
//	private final ModelRenderer Blade;
//	private final ModelRenderer Handle;
//
//	public KnifeModel() {
//		super(RenderType::getEntitySolid);
//		textureWidth = 32;
//		textureHeight = 32;
//
//		Blade = new ModelRenderer(32, 32, 0, 0);
//		Blade.setRotationPoint(0.0F, 24.0F, 0.0F);
//		Blade.setTextureOffset(14, 26).addBox(-2.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(14, 28).addBox(-4.0F, -6.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(0, 27).addBox(-3.0F, -7.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(14, 30).addBox(-2.0F, -8.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(8, 30).addBox(0.0F, -9.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
//		Blade.setTextureOffset(0, 29).addBox(2.0F, -10.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
//
//		Handle = new ModelRenderer(32, 32, 0, 0);
//		Handle.setRotationPoint(0.0F, 24.0F, 0.0F);
//		Handle.setTextureOffset(9, 30).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
//		Handle.setTextureOffset(28, 28).addBox(-3.0F, -5.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
//		Handle.setTextureOffset(28, 28).addBox(-4.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
//		Handle.setTextureOffset(28, 28).addBox(-5.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
//		Handle.setTextureOffset(28, 28).addBox(-6.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
//		Handle.setTextureOffset(28, 30).addBox(-2.0F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
//	}
//
//	@Override
//	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//		Blade.render(matrixStack, buffer, packedLight, packedOverlay);
//		Handle.render(matrixStack, buffer, packedLight, packedOverlay);
//	}
//
//	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}