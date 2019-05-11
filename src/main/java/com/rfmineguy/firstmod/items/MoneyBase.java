package com.rfmineguy.firstmod.items;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.init.ModItems;
import com.rfmineguy.firstmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MoneyBase extends Item implements IHasModel {

	public MoneyBase(String name, CreativeTabs tab)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "Inventory");
	}
}
