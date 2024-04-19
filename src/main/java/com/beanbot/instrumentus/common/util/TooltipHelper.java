package com.beanbot.instrumentus.common.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.Component;

import java.text.NumberFormat;
import java.util.Locale;

public class TooltipHelper {

    public static MutableComponent tipString(String text){
        return Component.translatable(text).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent tipString(String text, ChatFormatting... styles){
        return Component.translatable(text).withStyle(styles);
    }

    public static MutableComponent tipInt(int value){
        return Component.translatable(NumberFormat.getNumberInstance(Locale.US).format(value));
    }

    public static MutableComponent tipInt(int value, ChatFormatting... styles){
        return Component.translatable(NumberFormat.getNumberInstance(Locale.US).format(value)).withStyle(styles);
    }

}
