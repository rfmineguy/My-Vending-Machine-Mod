package com.rfmineguy.firstmod.blocks;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.tabs.MoneyTab;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class VendTopBlock extends BlockBase {
	
	public static final AxisAlignedBB VEND_BLOCK_TOP_AABB = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
	
	public VendTopBlock(String name)
	{
		super(name, Material.IRON, Main.moneytab, SoundType.METAL, 2, 10, "pickaxe", 0, 0);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return VEND_BLOCK_TOP_AABB;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}
