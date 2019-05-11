package com.rfmineguy.firstmod;

import com.rfmineguy.firstmod.init.ModRecipes;
import com.rfmineguy.firstmod.proxy.CommonProxy;
import com.rfmineguy.firstmod.tabs.MoneyTab;
import com.rfmineguy.firstmod.tabs.TestTab;
import com.rfmineguy.firstmod.util.Reference;
import com.rfmineguy.firstmod.util.Handlers.TileEntityHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static final CreativeTabs moneytab = new MoneyTab("moneytab");
	public static final CreativeTabs testtab = new TestTab("testtab");
	
	@Instance
	public static Main Instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
	}
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
