package com.rfmineguy.firstmod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}
}
