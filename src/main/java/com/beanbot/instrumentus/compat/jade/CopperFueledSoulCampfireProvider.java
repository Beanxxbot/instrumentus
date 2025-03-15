package com.beanbot.instrumentus.compat.jade;

import com.beanbot.instrumentus.common.blocks.entities.CopperSoulCampfireBlockEntity;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import snownee.jade.api.Accessor;
import snownee.jade.api.theme.IThemeHelper;
import snownee.jade.api.view.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public enum CopperFueledSoulCampfireProvider implements IServerExtensionProvider<ItemStack>, IClientExtensionProvider<ItemStack, ItemView> {
    INSTANCE;

    private static final MapCodec<Integer> COOKING_TIME_CODEC = Codec.INT.fieldOf("jade:cooking");

    @Override
    public ResourceLocation getUid() {
        return InstrumentusIds.COPPER_FUELED_SOUL_CAMPFIRE;
    }

    @Override
    public List<ClientViewGroup<ItemView>> getClientGroups(Accessor<?> accessor, List<ViewGroup<ItemStack>> groups) {
        return ClientViewGroup.map(groups, stack -> {
            CustomData customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
            if (customData.isEmpty()) {
                return null;
            }
            Optional<Integer> result = customData.read(COOKING_TIME_CODEC).result();
            if (result.isEmpty()) {
                return null;
            }
            String text = IThemeHelper.get().seconds(result.get(), accessor.tickRate()).getString();
            return new ItemView(stack).amountText(text);
        }, null);
    }

    @Override
    public @Nullable List<ViewGroup<ItemStack>> getGroups(Accessor<?> accessor) {
        if (accessor.getTarget() instanceof CopperSoulCampfireBlockEntity campfire) {
            List<ItemStack> list = Lists.newArrayList();
            for (int i = 0; i < campfire.cookingTime.length; i++) {
                ItemStack stack = campfire.getItems().get(i);
                if (stack.isEmpty()) {
                    continue;
                }
                stack = stack.copy();
                CustomData customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).update(
                        NbtOps.INSTANCE,
                        COOKING_TIME_CODEC,
                        campfire.cookingTime[i] - campfire.cookingProgress[i]).getOrThrow();
                stack.set(DataComponents.CUSTOM_DATA, customData);
                list.add(stack);
            }
            return List.of(new ViewGroup<>(list));
        }
        return null;
    }

}
