package com.rfmineguy.firstmod;

import com.rfmineguy.firstmod.blocks.avend_block.ContainerVendBlock;
import com.rfmineguy.firstmod.blocks.avend_block.GuiVendBlock;
import com.rfmineguy.firstmod.blocks.avend_block.tileentity.TileEntityVendBlock;
import com.rfmineguy.firstmod.blocks.pedestal.ContainerPedestal;
import com.rfmineguy.firstmod.blocks.pedestal.GuiPedestal;
import com.rfmineguy.firstmod.blocks.pedestal.tileentity.TileEntityPedestal;
import com.rfmineguy.firstmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	public static final int PEDESTAL = 0;
	public static final int VEND_BLOCK = 1;
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_VEND_BLOCK) return new GuiVendBlock(player.inventory, (TileEntityVendBlock)world.getTileEntity(new BlockPos(x,y,z)));

		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_VEND_BLOCK) return new ContainerVendBlock(player.inventory, (TileEntityVendBlock)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	
	
	
	/*@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new ContainerPedestal(player.inventory, (TileEntityPedestal)world.getTileEntity(new BlockPos(x, y, z)));
			case VEND_BLOCK:
				return new ContainerVendBlock(player.inventory, (TileEntityVendBlock)world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			case VEND_BLOCK:
				return new GuiVendBlock(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			default:
				return null;
		}
	}
	*/
	
	
}