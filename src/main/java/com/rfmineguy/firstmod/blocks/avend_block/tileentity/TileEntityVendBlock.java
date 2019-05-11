package com.rfmineguy.firstmod.blocks.avend_block.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

import com.rfmineguy.firstmod.items.MoneyBase;

public class TileEntityVendBlock extends TileEntity implements IInventory {

	private NonNullList<ItemStack> vendItemStacks = NonNullList.<ItemStack>withSize(17, ItemStack.EMPTY);
	private ItemStackHandler inventory = new ItemStackHandler();
	private String customName;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		ItemStackHelper.saveAllItems(compound, this.vendItemStacks);
		
        if (this.hasCustomName())
        {
            compound.setString("Vending Machine", this.customName);
        }
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.vendItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.vendItemStacks);
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		
		if (compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
	}

	@Override
	public String getName() {
		return this.customName;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return this.vendItemStacks.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.vendItemStacks.contains(ItemStack.EMPTY);
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.vendItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.vendItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.vendItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = this.vendItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.vendItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }
        this.markDirty();
        
    }

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }	
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index==16&&stack.getItem() instanceof MoneyBase ? true : false;
	}

	@Override
	public int getField(int id) {
		switch(id)
		{
			default : return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch(id)
		{
			default: 
				break;
		}
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.vendItemStacks.clear();
	}
}