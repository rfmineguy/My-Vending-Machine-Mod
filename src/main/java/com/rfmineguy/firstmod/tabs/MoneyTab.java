package com.rfmineguy.firstmod.tabs;

import com.rfmineguy.firstmod.init.ModItems;
import com.rfmineguy.firstmod.items.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MoneyTab extends CreativeTabs {
	public MoneyTab(String label)
	{
		super(label);
	}
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.MONEY_1);
	}
}
