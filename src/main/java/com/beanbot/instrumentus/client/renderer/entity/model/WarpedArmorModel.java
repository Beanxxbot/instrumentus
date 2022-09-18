//package com.beanbot.instrumentus.client.renderer.entity.model;// Made with Blockbench 3.7.4
//// Exported for Minecraft version 1.15
//// Paste this class into your mod and generate all required imports
//
//
//import net.minecraft.client.model.HumanoidModel;
//import net.minecraft.world.entity.LivingEntity;
//
//public class WarpedArmorModel extends HumanoidModel<LivingEntity> {
//
//	public WarpedArmorModel(float modelSize) {
//		super(modelSize, 0.0f, 64, 64);
//		textureWidth = 64;
//		textureHeight = 64;
//
//		ModelRenderer head = new ModelRenderer(this);
//		head.setRotationPoint(0.0F, 0.0F, 0.0F);
//		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
//		head.setTextureOffset(0, 32).addBox(-1.0F, -9.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
//
//		ModelRenderer tentacleLeft = new ModelRenderer(this);
//		tentacleLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
//		bipedBody.addChild(tentacleLeft);
//
//		ModelRenderer tentacleLeftTop_r1 = new ModelRenderer(this);
//		tentacleLeftTop_r1.setRotationPoint(-4.125F, 3.75F, 8.125F);
//		tentacleLeft.addChild(tentacleLeftTop_r1);
//		setRotationAngle(tentacleLeftTop_r1, 1.789F, 0.0F, -0.6981F);
//		tentacleLeftTop_r1.setTextureOffset(6, 32).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
//
//		ModelRenderer tentacleLeftBottom_r1 = new ModelRenderer(this);
//		tentacleLeftBottom_r1.setRotationPoint(-0.75F, 7.75F, 2.0F);
//		tentacleLeft.addChild(tentacleLeftBottom_r1);
//		setRotationAngle(tentacleLeftBottom_r1, 0.6981F, 0.0F, -0.6981F);
//		tentacleLeftBottom_r1.setTextureOffset(6, 32).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
//
//		ModelRenderer tentacleRight = new ModelRenderer(this);
//		tentacleRight.setRotationPoint(0.0F, 0.0F, 0.0F);
//		bipedBody.addChild(tentacleRight);
//
//		ModelRenderer tentacleRightTop_r1 = new ModelRenderer(this);
//		tentacleRightTop_r1.setRotationPoint(5.875F, -0.125F, 7.125F);
//		tentacleRight.addChild(tentacleRightTop_r1);
//		setRotationAngle(tentacleRightTop_r1, 1.789F, 0.0F, 0.6981F);
//		tentacleRightTop_r1.setTextureOffset(6, 32).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
//
//		ModelRenderer tentacleRightBottom_r1 = new ModelRenderer(this);
//		tentacleRightBottom_r1.setRotationPoint(1.5F, 4.25F, 2.0F);
//		tentacleRight.addChild(tentacleRightBottom_r1);
//		setRotationAngle(tentacleRightBottom_r1, 0.8727F, 0.0F, 0.7854F);
//		tentacleRightBottom_r1.setTextureOffset(6, 32).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
//	}
//
//	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}