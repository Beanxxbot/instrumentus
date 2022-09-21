package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.client.ClientReference;
import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.client.RenderProperties;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class WarpedArmorItem extends GeoArmorItem implements IAnimatable {
    protected final Random rand = new Random();

    private AnimationFactory factory = new AnimationFactory(this);

    public WarpedArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<WarpedArmorItem>(this, "controller", 20, this::predicate));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        ItemStack playerBoots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack playerLegs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack playerChest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack playerHelm = player.getItemBySlot(EquipmentSlot.HEAD);

        if (playerBoots.getItem() == ModItems.WARPED_BOOTS.get() && playerLegs.getItem() == ModItems.WARPED_LEGGINGS.get() && playerChest.getItem() == ModItems.WARPED_CHESTPLATE.get() && playerHelm.getItem() == ModItems.WARPED_HELMET.get()) {
            world.addParticle(ParticleTypes.PORTAL, player.getRandomX(0.5D), player.getRandomY() - 0.25D, player.getRandomZ(0.5D), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            if (ClientReference.warpedTeleportBinding.consumeClick() && player.isCrouching()) {
                HitResult lookingAt = player.pick(20.0D, 0.0F, false);
                Instrumentus.LOGGER.debug(lookingAt.getType());
                if (lookingAt.getType().equals(HitResult.Type.BLOCK)) {
                    double x = lookingAt.getLocation().x + 0.5d;
                    double y = lookingAt.getLocation().y + 1.0d;
                    double z = lookingAt.getLocation().z + 0.5d;
                    if(!world.isClientSide){
                        ((ServerPlayer) player).connection.teleport(x, y, z, Mth.wrapDegrees(player.getYRot()), Mth.wrapDegrees(player.getXRot()));
                    } else {
                        player.teleportTo(x,y,z);
                    }
                    player.playSound(SoundEvents.ENDERMAN_TELEPORT, 0.5f, 1.0f);

                    playerBoots.getItem().setDamage(playerBoots, playerBoots.getDamageValue() + 1);
                    if (playerBoots.getItem().getDamage(playerBoots) >= playerBoots.getMaxDamage()) {
                        player.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
                    }
                    playerLegs.getItem().setDamage(playerLegs, playerLegs.getDamageValue() + 1);
                    if (playerLegs.getItem().getDamage(playerLegs) >= playerLegs.getMaxDamage()) {
                        player.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
                    }
                    playerChest.getItem().setDamage(playerChest, playerChest.getDamageValue() + 1);
                    if (playerChest.getItem().getDamage(playerChest) >= playerChest.getMaxDamage()) {
                        player.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                    }
                    playerHelm.getItem().setDamage(playerHelm, playerHelm.getDamageValue() + 1);
                    if (playerHelm.getItem().getDamage(playerHelm) >= playerHelm.getMaxDamage()) {
                        player.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);

                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        TranslatableComponent toolTipText = new TranslatableComponent("instrumentus.lore.warped_armor.line1");
        tooltip.add(toolTipText.withStyle(ChatFormatting.GRAY));
    }
}
