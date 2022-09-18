package com.beanbot.instrumentus.common.items;

import com.beanbot.instrumentus.client.ClientReference;
import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
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

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class WarpedArmorItem extends ArmorItem implements IItemRenderProperties {
    protected final Random rand = new Random();

    public WarpedArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlot armorSlot, A _default) {
//        A model = RenderProperties.get(stack).getArmorModel(entityLiving, stack, armorSlot, _default);
//        return Instrumentus.SIDED_SYSTEM.getWarpedArmorMaterial(armorSlot);
//    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        ItemStack playerBoots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack playerLegs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack playerChest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack playerHelm = player.getItemBySlot(EquipmentSlot.HEAD);

        if (playerBoots.getItem() == ModItems.WARPED_BOOTS.asItem() && playerLegs.getItem() == ModItems.WARPED_LEGGINGS.asItem() && playerChest.getItem() == ModItems.WARPED_CHESTPLATE.asItem() && playerHelm.getItem() == ModItems.WARPED_HELMET.asItem()) {
            world.addParticle(ParticleTypes.PORTAL, player.getRandomX(0.5D), player.getRandomY() - 0.25D, player.getRandomZ(0.5D), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            if (ClientReference.warpedTeleportBinding.isDown() && player.isCrouching()) {
                HitResult lookingAt = player.pick(20.0D, 0.0F, false);
                if (lookingAt.getType().equals(HitResult.Type.BLOCK)) {
                    double x = lookingAt.getLocation().x + 0.5d;
                    double y = lookingAt.getLocation().y + 1.0d;
                    double z = lookingAt.getLocation().z + 0.5d;
                    player.setPos(x, y, z);
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
