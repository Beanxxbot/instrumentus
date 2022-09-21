//package com.beanbot.instrumentus.common.items;
//
//import com.beanbot.instrumentus.common.Instrumentus;
//import net.minecraft.ChatFormatting;
//import net.minecraft.client.model.HumanoidModel;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ArmorItem;
//import net.minecraft.world.item.ArmorMaterial;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.TooltipFlag;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.client.IItemRenderProperties;
//import net.minecraftforge.client.RenderProperties;
//
//import javax.annotation.Nullable;
//import java.awt.*;
//import java.util.List;
//import java.util.Random;
//
//public class SolarArmorItem extends ArmorItem implements IItemRenderProperties {
//    public SolarArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
//        super(materialIn, slot, builderIn);
//    }
//
////    @OnlyIn(Dist.CLIENT)
////    @Override
////    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlot armorSlot, A _default) {
////        A model = RenderProperties.get(stack).getArmorModel(entityLiving, stack, armorSlot, _default);
////        return Instrumentus.SIDED_SYSTEM.getSolarArmorMaterial(armorSlot);
////    }
//
//    @Override
//    public void onArmorTick(ItemStack stack, Level world, Player player) {
//        double dx = player.getX();
//        double dy = player.getY() + 0.25d;
//        double dz = player.getZ();
//        Random rand = new Random();
//
//        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SOLAR_BOOTS.asItem()) {
//            world.addParticle(ParticleTypes.FLAME, dx, dy, dz, 0.0d, 0.0d, 0.0d);
//        }
//
//        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SOLAR_BOOTS.asItem() && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.SOLAR_LEGGINGS.asItem() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.SOLAR_CHESTPLATE.asItem() && player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SOLAR_HELMET.asItem()) {
//            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2, 1, false, false));
//        }
//    }
//
//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        TranslatableComponent toolTipText = new TranslatableComponent("instrumentus.lore.solar_armor.line1");
//        tooltip.add(toolTipText.withStyle(ChatFormatting.GRAY));
//    }
//}
