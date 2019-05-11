package com.rfmineguy.firstmod.init;

import java.util.ArrayList;
import java.util.List;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.items.ItemBase;
import com.rfmineguy.firstmod.items.MoneyBase;
import com.rfmineguy.firstmod.tabs.MoneyTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item MONEY_1 = new MoneyBase("onedollar", Main.moneytab);
	public static final Item MONEY_5 = new MoneyBase("fivedollar", Main.moneytab);
	public static final Item MONEY_10 = new MoneyBase("tendollar", Main.moneytab);
	public static final Item PULLY = new ItemBase("pully", Main.moneytab);
	public static final Item MONEY_SLOT = new ItemBase("moneyslot", Main.moneytab);
	public static final Item KEYPAD = new ItemBase("keypad", Main.moneytab);
	public static final Item SCREW = new ItemBase("screw", Main.moneytab);
	public static final Item SCREEN = new ItemBase("screen", Main.moneytab);
}
