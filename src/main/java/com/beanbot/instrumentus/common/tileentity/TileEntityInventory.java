//package com.beanbot.instrumentus.common.tileentity;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.ISidedInventory;
//import net.minecraft.inventory.ItemStackHelper;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.INamedContainerProvider;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.network.NetworkManager;
//import net.minecraft.network.play.server.SUpdateTileEntityPacket;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.INameable;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//
//import javax.annotation.Nullable;
//
//public abstract class TileEntityInventory extends TileEntity implements ITileInventory, ISidedInventory, INamedContainerProvider, INameable {
//
//    public NonNullList<ItemStack> inventory;
//    protected ITextComponent name;
//
//    public TileEntityInventory(TileEntityType<?> tileEntityTypeIn, int sizeInventory) {
//        super(tileEntityTypeIn);
//        inventory = NonNullList.withSize(sizeInventory, ItemStack.EMPTY);
//    }
//
//    @Override
//    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
//        this.read(world.getBlockState(pkt.getPos()), pkt.getNbtCompound());
//        world.notifyBlockUpdate(pos, world.getBlockState(pos).getBlock().getDefaultState(), world.getBlockState(pos), 2);
//    }
//
//    @Override
//    public CompoundNBT getUpdateTag() {
//        CompoundNBT compound = new CompoundNBT();
//
//        this.write(compound);
//        return compound;
//    }
//
//    @Override
//    public SUpdateTileEntityPacket getUpdatePacket() {
//        return new SUpdateTileEntityPacket(pos, 1, this.getUpdateTag());
//    }
//
//    @Override
//    public boolean isItemValidForSlot(int index, ItemStack stack) {
//        return this.IIsItemValidForSlot(index, stack);
//    }
//
//    public void setCustomName(ITextComponent name) {
//        this.name = name;
//    }
//
//    @Override
//    public ITextComponent getName() {
//        return (this.name != null ? this.name : new TranslationTextComponent(IGetName()));
//    }
//
//    @Override
//    public int[] getSlotsForFace(Direction side) {
//        return this.IGetSlotsForFace(side);
//    }
//
//    @Override
//    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
//        return ICanExtractItem(index, stack, direction);
//    }
//
//    @Override
//    public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
//        return this.isItemValidForSlot(index, stack);
//    }
//
//    @Override
//    public int getSizeInventory() {
//        return this.inventory.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        for(ItemStack stack : this.inventory) {
//            if (!stack.isEmpty()) {
//                return false;
//            }
//        }
//    return true;
//    }
//
//    @Override
//    public ItemStack getStackInSlot(int index) {
//        return this.inventory.get(index);
//    }
//
//    @Override
//    public ItemStack decrStackSize(int index, int count) {
//        return ItemStackHelper.getAndSplit(this.inventory, index, count);
//    }
//
//    @Override
//    public ItemStack removeStackFromSlot(int index) {
//        return ItemStackHelper.getAndRemove(this.inventory, index);
//    }
//
//    @Override
//    public void setInventorySlotContents(int index, ItemStack stack) {
//        ItemStack itemStack = this.inventory.get(index);
//        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
//        this.inventory.set(index, stack);
//        if (stack.getCount() > this.getInventoryStackLimit()) {
//            stack.setCount(this.getInventoryStackLimit());
//        }
//    }
//
//    @Override
//    public int getInventoryStackLimit() {
//        return 64;
//    }
//
//    @Override
//    public void read(BlockState state, CompoundNBT compound) {
//        super.read(state, compound);
//        this.inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
//        ItemStackHelper.loadAllItems(compound, this.inventory);
//        if (compound.contains("CustomName", 8)) {
//            this.name = ITextComponent.Serializer.getComponentFromJson(compound.getString("CustomName"));
//        }
//    }
//
//    @Override
//    public CompoundNBT write(CompoundNBT compound) {
//        super.write(compound);
//        ItemStackHelper.saveAllItems(compound, this.inventory);
//        if (this.name != null) {
//            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.name));
//        }
//        return compound;
//    }
//
//    @Override
//    public boolean isUsableByPlayer(PlayerEntity player) {
//        if (this.world.getTileEntity(this.pos) != this) {
//            return false;
//        } else {
//            return !(player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) > 64.0D);
//        }
//    }
//
//    @Override
//    public void openInventory(PlayerEntity player) { }
//
//    @Override
//    public void closeInventory(PlayerEntity player) { }
//
//    @Override
//    public void clear() {
//        this.inventory.clear();
//    }
//
//    @Override
//    public boolean hasCustomName() {
//        return this.name != null;
//    }
//
//    @Override
//    public ITextComponent getCustomName() {
//        return this.name;
//    }
//
//    @Override
//    public ITextComponent getDisplayName() {
//        return this.getName();
//    }
//
//    @Nullable
//    @Override
//    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
//        return ICreateMenu(i, playerInventory, playerEntity);
//    }
//}
