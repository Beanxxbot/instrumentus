//package com.beanbot.instrumentus.client.renderer.entity.model;// Made with Blockbench 3.7.4
//// Exported for Minecraft version 1.15
//// Paste this class into your mod and generate all required imports
//
//
//import net.minecraft.client.renderer.entity.model.BipedModel;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import net.minecraft.entity.LivingEntity;
//
//public class SolarArmorModel extends BipedModel<LivingEntity> {
//
//	public SolarArmorModel(float modelSize) {
//		super(modelSize, 0.0f, 64, 64);
//		textureWidth = 64;
//		textureHeight = 64;
//
//		//BOOT FLAME LEFT
//		ModelRenderer lBootFlameTop = new ModelRenderer(this);
//		lBootFlameTop.setRotationPoint(0.7F, 7.8901F, 2.8124F);
//		bipedLeftLeg.addChild(lBootFlameTop);
//
//		ModelRenderer bootFlameTop_r1 = new ModelRenderer(this);
//		bootFlameTop_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		lBootFlameTop.addChild(bootFlameTop_r1);
//		setRotationAngle(bootFlameTop_r1, -0.733F, 0.0F, 0.0F);
//		bootFlameTop_r1.setTextureOffset(0, 37).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
//
//		ModelRenderer lBootFlameBottom = new ModelRenderer(this);
//		lBootFlameBottom.setRotationPoint(0.7F, 9.62F, 2.7468F);
//		bipedLeftLeg.addChild(lBootFlameBottom);
//
//		ModelRenderer bootFlameBottom_r1 = new ModelRenderer(this);
//		bootFlameBottom_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		lBootFlameBottom.addChild(bootFlameBottom_r1);
//		setRotationAngle(bootFlameBottom_r1, -0.733F, 0.0F, 0.0F);
//		bootFlameBottom_r1.setTextureOffset(0, 37).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
//
//		ModelRenderer rBootFlameTop = new ModelRenderer(this);
//		rBootFlameTop.setRotationPoint(-0.7F, 8.2687F, 0.924F);
//		bipedRightLeg.addChild(rBootFlameTop);
//		setRotationAngle(rBootFlameTop, -0.3491F, 0.0F, 0.0F);
//
//		ModelRenderer bootFlameTop_r2 = new ModelRenderer(this);
//		bootFlameTop_r2.setRotationPoint(0.0F, -1.0203F, 1.5917F);
//		rBootFlameTop.addChild(bootFlameTop_r2);
//		setRotationAngle(bootFlameTop_r2, -0.384F, 0.0F, 0.0F);
//		bootFlameTop_r2.setTextureOffset(0, 37).addBox(-1.0F, -0.4984F, -1.5157F, 2.0F, 1.0F, 3.0F, 0.0F, false);
//
//		ModelRenderer rBootFlameBottom = new ModelRenderer(this);
//		rBootFlameBottom.setRotationPoint(4.4F, 9.5F, 2.5F);
//		bipedRightLeg.addChild(rBootFlameBottom);
//
//		ModelRenderer bootFlameBottom_r2 = new ModelRenderer(this);
//		bootFlameBottom_r2.setRotationPoint(-5.1F, 0.3277F, -0.1528F);
//		rBootFlameBottom.addChild(bootFlameBottom_r2);
//		setRotationAngle(bootFlameBottom_r2, -0.733F, 0.0F, 0.0F);
//		bootFlameBottom_r2.setTextureOffset(0, 37).addBox(-1.0F, -0.8277F, -1.3472F, 2.0F, 1.0F, 3.0F, 0.0F, false);
//
//		//HEAD SPIKES
//		ModelRenderer headSpikesRight = new ModelRenderer(this);
//		headSpikesRight.setRotationPoint(3.5F, -9.0F, 4.5F);
//		bipedHead.addChild(headSpikesRight);
//		setRotationAngle(headSpikesRight, 0.5236F, 0.5672F, 0.0F);
//		headSpikesRight.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
//
//		ModelRenderer headSpikesLeft = new ModelRenderer(this);
//		headSpikesLeft.setRotationPoint(-4.0F, -9.0F, 6.5F);
//		bipedHead.addChild(headSpikesLeft);
//		setRotationAngle(headSpikesLeft, 0.5236F, -0.5672F, 0.0F);
//		headSpikesLeft.setTextureOffset(0, 32).addBox(-1.6193F, -2.0F, -3.2349F, 2.0F, 2.0F, 3.0F, 0.0F, false);
//
//	}
//
//	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}