//package com.beanbot.instrumentus.events;
//
//import com.beanbot.instrumentus.common.Instrumentus;
//import com.beanbot.instrumentus.common.items.ModItems;
//import com.beanbot.instrumentus.common.util.VectorHelper;
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.SoundEvents;
//import net.minecraft.util.math.BlockRayTraceResult;
//import net.minecraft.world.World;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.InputEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = Instrumentus.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//public class ModClientEvents {
//
////    @SubscribeEvent
////    public static void onWarpedTeleport(InputEvent.KeyInputEvent event) {
////        PlayerEntity player = Minecraft.getInstance().player;
////        World world = Minecraft.getInstance().world;
////        ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
////        ItemStack leggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
////        ItemStack chestplate = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
////        ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
////
//////        if (world.isRemote) {
//////            if (boots.getItem() == ModItems.WARPED_BOOTS.getItem() && leggings.getItem() == ModItems.WARPED_LEGGINGS.getItem() && chestplate.getItem() == ModItems.WARPED_CHESTPLATE.getItem() && helmet.getItem() == ModItems.WARPED_HELMET.getItem()) {
//////
//////            }
//////        }
////    }
//
//}
