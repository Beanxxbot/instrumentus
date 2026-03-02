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
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.UUID;

public class BadgeRenderLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

    public static final UUID[] BADGE_UUIDS = new UUID[]{
            UUID.fromString("d1af5f04-c4cc-486f-b187-fcb0a745bda6"), /* Beanxxbot - 0 */
            UUID.fromString("7b6d348f-7ee3-4e67-ac03-234b51fe355f"), /* Jakeson69 - 1 */
            UUID.fromString("222a5c7c-b225-4a56-9767-d23f40647e24"), /* Sirawesomeknight - 2 */
            UUID.fromString("51cc3846-03ae-46d6-a5c4-a9ae923c1822"), /* jakeyboydotgov - 3 */
            UUID.fromString("f97dcd7e-958d-4d84-aa50-99e3265f8950"), /* mibrown715 - 4 */
            UUID.fromString("ab873dbf-a050-4912-8f22-f74f2a638416"), /* Cryptid1 - 5 */
            UUID.fromString("59c36dba-8a94-4545-adce-3fa537876459"), /* Afternoenickx - 6 */
            UUID.fromString("6f744695-c175-4b64-afa3-e854b210c295") /* KingAmerica - 7 */
            };

    public BadgeRenderLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (shouldRenderBadge(player)) {
            poseStack.pushPose();

            this.getParentModel().body.translateAndRotate(poseStack);

            if (player.hasItemInSlot(EquipmentSlot.CHEST)) {
                poseStack.translate(0.15, 0.15, -0.2);
            } else {
                poseStack.translate(0.15, 0.15, -0.14);
            }

            poseStack.scale(0.2f, 0.2f, 0.2f);

            poseStack.mulPose(Axis.XP.rotationDegrees(180f));
            poseStack.mulPose(Axis.YP.rotationDegrees(180f));

            ItemStack badgeItem = getBadgeItem(player);
            itemRenderer.renderStatic(badgeItem, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, player.level(), 0);

            poseStack.popPose();
        }
    }

    private boolean shouldRenderBadge(AbstractClientPlayer player) {
        for (UUID badgeUuid : BADGE_UUIDS) {
            if (player.getUUID().equals(badgeUuid)) {
                return true;
            }
        }
        return false;
    }

    private ItemStack getBadgeItem(AbstractClientPlayer player) {
        if (player.getUUID().equals(BADGE_UUIDS[1])) {
            return new ItemStack(InstrumentusItems.ENERGIZED_PAXEL.get());
        } else if (player.getUUID().equals(BADGE_UUIDS[2])) {
            return new ItemStack(InstrumentusItems.ENERGIZED_INGOT.get());
        } else if (player.getUUID().equals(BADGE_UUIDS[3])) {
            return new ItemStack(Items.IRON_SWORD.asItem());
        } else if (player.getUUID().equals(BADGE_UUIDS[4])) {
            return new ItemStack(Items.GLOW_BERRIES.asItem());
        } else if (player.getUUID().equals(BADGE_UUIDS[5])) {
            return new ItemStack(Items.SPYGLASS.asItem());
        } else if (player.getUUID().equals(BADGE_UUIDS[6])) {
            return new ItemStack(Items.SHEARS.asItem());
        } else if (player.getUUID().equals(BADGE_UUIDS[7])) {
            return new ItemStack(Items.FISHING_ROD.asItem());
        } else {
            return new ItemStack(InstrumentusItems.DIAMOND_PAXEL.get());
        }
    }
}
