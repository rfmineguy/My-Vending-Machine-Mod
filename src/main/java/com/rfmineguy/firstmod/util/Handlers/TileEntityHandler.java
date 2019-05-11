package com.rfmineguy.firstmod.util.Handlers;

import com.rfmineguy.firstmod.blocks.avend_block.tileentity.TileEntityVendBlock;
import com.rfmineguy.firstmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityVendBlock.class, new ResourceLocation(Reference.MOD_ID+":vend_machine"));
	}
}
