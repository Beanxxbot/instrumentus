package com.beanbot.instrumentus.common.armor;

import com.beanbot.instrumentus.common.Instrumentus;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {

    //Path to Layer: blank_layer_1 blank_layer_2
    //TODO Change repair material
    SOLAR(Instrumentus.MODID + ":solar", 37, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0f, 0.0f, () -> {return Ingredient.of(Items.BLAZE_ROD);}),
    WARPED(Instrumentus.MODID + ":warped", 37, new int[] { 3, 6, 8, 3 }, 15, SoundEvents.ARMOR_EQUIP_GENERIC, 3.0f, 0.1f, () -> {return Ingredient.of(Items.ENDER_PEARL);});

    //Helm, Chest, Legs, Boots
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{ 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmount;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmount, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }
    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
