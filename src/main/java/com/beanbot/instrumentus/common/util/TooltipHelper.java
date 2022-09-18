package com.beanbot.instrumentus.common.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import java.awt.*;
import java.text.NumberFormat;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class TooltipHelper {

    public static MutableComponent tipString(String text){
        return new TranslatableComponent(text).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent tipString(String text, ChatFormatting... styles){
        return new TranslatableComponent(text).withStyle(styles);
    }

    public static MutableComponent tipInt(int value){
        return new TranslatableComponent(NumberFormat.getNumberInstance(Locale.US).format(value));
    }

    public static MutableComponent tipInt(int value, ChatFormatting... styles){
        return new TranslatableComponent(NumberFormat.getNumberInstance(Locale.US).format(value)).withStyle(styles);
    }

//    public static MutableComponent chargeRatio(ItemStack stack) {
//        LazyOptional<IEnergyStorage> lazy = stack.getCapability(CapabilityEnergy.ENERGY);
//        if (lazy.isPresent()) {
//            IEnergyStorage storage = lazy.orElse(null);
//            ChatFormatting storedColor = storage.getEnergyStored() != 0 ? ChatFormatting.GREEN : ChatFormatting.RED;
//            TranslatableComponent chargeRatioText =
//                    new TranslatableComponent("instrumentus.tooltip.energy",
//                            tipInt(storage.getEnergyStored(), storedColor),
//                            tipString(" FE / ", ChatFormatting.GRAY),
//                            tipInt(storage.getMaxEnergyStored(), ChatFormatting.GRAY),
//                            tipString(" FE", ChatFormatting.GRAY)
//                    );
//            return chargeRatioText;
//            return tipString("");
//        }
//    }
}
