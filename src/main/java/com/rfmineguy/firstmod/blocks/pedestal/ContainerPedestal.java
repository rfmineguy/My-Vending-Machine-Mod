package com.rfmineguy.firstmod.blocks.pedestal;

import com.rfmineguy.firstmod.blocks.pedestal.tileentity.TileEntityPedestal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerPedestal extends Container {
	
	public ContainerPedestal(InventoryPlayer playerInv, final TileEntityPedestal pedestal) {
		 	IItemHandler inventory = pedestal.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		 	/*
		addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35) {
			@Override
			public void onSlotChanged() {
				pedestal.markDirty();
			}
		});
		*/
		
			//THIS MAKES THE NEW GUI SLOTS
		 	int index = 0;
		 	
			for(int x = 0; x < 4; x++){
				for(int y = 0; y < 4; y++){
					addSlotToContainer(new SlotItemHandler(inventory, index, 41 + x * 25, 13 + y * 25));// index value doesnt work correctly, as gui opened game crashes
					index++;
				}
			}
		
		
		//THESE FOR LOOPS MAKE THE BOTTOMG SLOTS IN THE GUI
		//MAKES PLAYER INVENTORY SLOTS
		for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 9; j++) {
	            addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 115 + i * 18));
	        }
	    }

	        //MAKES PLAYER HOTBAR SLOTS
	    for (int k = 0; k < 9; k++) {
	        addSlotToContainer(new Slot(playerInv, k, 8 + k *18, 173));
	    }
	}
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
	
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
	
			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
	
			if (index < containerSlots) {
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
	
			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
	
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
	
			slot.onTake(player, itemstack1);
		}
	
		return itemstack;
	}
}