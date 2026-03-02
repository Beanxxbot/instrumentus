package com.beanbot.instrumentus.client.renderer.player;

import com.beanbot.instrumentus.common.items.InstrumentusItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class BadgeRenderLayer extends RenderLayer<PlayerRenderState, PlayerModel> {
    private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

    public static final UUID[] BADGE_UUIDS = new UUID[]{
            UUID.fromString("d1af5f04-c4cc-486f-b187-fcb0a745bda6") /* Beanxxbot */,
            UUID.fromString("7b6d348f-7ee3-4e67-ac03-234b51fe355f") /* Jakeson69 */,
            UUID.fromString("222a5c7c-b225-4a56-9767-d23f40647e24") /* Sirawesomeknight */,
            UUID.fromString("51cc3846-03ae-46d6-a5c4-a9ae923c1822" /* jakeyboydotgov */)};

    public static final String[] BADGE_NAMES = new String[]{
            "Beanxxbot",
            "Jakeson69",
            "Sirawesomeknight",
            "jakeyboydotgov"};

    public BadgeRenderLayer(RenderLayerParent<PlayerRenderState, PlayerModel> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, PlayerRenderState player, float partialTicks, float ageInTicks) {
        if (shouldRenderBadge(player)) {
            poseStack.pushPose();

            this.getParentModel().body.translateAndRotate(poseStack);

            if (player.chestEquipment instanceof ItemStack) {
                poseStack.translate(0.15, 0.15, -0.2);
            } else {
                poseStack.translate(0.15, 0.15, -0.14);
            }

            poseStack.scale(0.2f, 0.2f, 0.2f);

            poseStack.mulPose(Axis.XP.rotationDegrees(180f));
            poseStack.mulPose(Axis.YP.rotationDegrees(180f));

            ItemStack badgeItem = getBadgeItem(player);
            itemRenderer.renderStatic(badgeItem, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, Minecraft.getInstance().level, 0);

            poseStack.popPose();
        }
    }

    private boolean shouldRenderBadge(PlayerRenderState player) {
        for (String badgeName : BADGE_NAMES) {
            if (player.name.equals(badgeName)) {
                return true;
            }
        }
        return false;
    }

    private ItemStack getBadgeItem(PlayerRenderState player) {
        if (player.name.equals(BADGE_NAMES[1])) {
            return new ItemStack(InstrumentusItems.ENERGIZED_PAXEL.get());
        } else if (player.name.equals(BADGE_NAMES[2])) {
            return new ItemStack(InstrumentusItems.ENERGIZED_INGOT.get());
        } else {
            return new ItemStack(InstrumentusItems.DIAMOND_PAXEL.get());
        }
    }
}
