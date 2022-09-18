//package com.beanbot.instrumentus.common.items;
//
//import com.google.common.collect.ImmutableMultimap;
//import com.google.common.collect.Multimap;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.enchantment.EnchantmentHelper;
//import net.minecraft.enchantment.IVanishable;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.ai.attributes.Attribute;
//import net.minecraft.entity.ai.attributes.AttributeModifier;
//import net.minecraft.entity.ai.attributes.Attributes;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.projectile.AbstractArrowEntity;
//import net.minecraft.entity.projectile.TridentEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.*;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//public class KnifeItem extends TieredItem implements IVanishable {
//    private final float attackDamage;
//    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
//
//    public KnifeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builderIn){
//        super (tier, builderIn);
//        this.attackDamage = (float)attackDamageIn + tier.getAttackDamage();
//        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
//        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)attackSpeedIn, AttributeModifier.Operation.ADDITION));
//        this.attributeModifiers = builder.build();
//    }
//
//    public float getAttackDamage() { return this.attackDamage;}
//
//    public boolean canPlayerBreakBlocksWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player){
//        if (state.getBlock() == Blocks.TALL_GRASS){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public UseAction getUseAction(ItemStack stack) {return UseAction.SPEAR;}
//
//    public int getUseDuration(ItemStack stack) { return 36000; }
//
//    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
//        if (entityLiving instanceof PlayerEntity) {
//            PlayerEntity playerentity = (PlayerEntity)entityLiving;
//            int i = this.getUseDuration(stack) - timeLeft;
//            if (i >= 10) {
//                int j = EnchantmentHelper.getRiptideModifier(stack);
//                if (j <= 0 || playerentity.isWet()) {
//                    if (!worldIn.isRemote) {
//                        stack.damageItem(1, playerentity, (player) -> {
//                            player.sendBreakAnimation(entityLiving.getActiveHand());
//                        });
//                        if (j == 0) {
//                            TridentEntity tridententity = new TridentEntity(worldIn, playerentity, stack);
//                            tridententity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
//                            if (playerentity.abilities.isCreativeMode) {
//                                tridententity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
//                            }
//
//                            worldIn.addEntity(tridententity);
//                            worldIn.playMovingSound((PlayerEntity)null, tridententity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
//                            if (!playerentity.abilities.isCreativeMode) {
//                                playerentity.inventory.deleteStack(stack);
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        ItemStack itemstack = playerIn.getHeldItem(handIn);
//        if (itemstack.getDamage() >= itemstack.getMaxDamage() - 1) {
//            return ActionResult.resultFail(itemstack);
//        } else {
//            playerIn.setActiveHand(handIn);
//            return ActionResult.resultConsume(itemstack);
//        }
//    }
//
//    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        stack.damageItem(1, attacker, (entity) -> {
//            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
//        });
//        return true;
//    }
//
//    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
//        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D) {
//            stack.damageItem(2, entityLiving, (entity) -> {
//                entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
//            });
//        }
//        return true;
//    }
//
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
//        return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot);
//    }
//
//    public int getItemEnchantability() { return 1; }
//}
