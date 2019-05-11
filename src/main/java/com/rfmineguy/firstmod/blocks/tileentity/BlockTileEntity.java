package com.rfmineguy.firstmod.blocks.tileentity;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.blocks.BlockBase;
import com.rfmineguy.firstmod.blocks.avend_block.tileentity.TileEntityVendBlock;

public abstract class BlockTileEntity<TE extends TileEntity> extends BlockBase {

	public BlockTileEntity(Material material, String name) {
		super(name, Material.IRON, Main.moneytab, SoundType.METAL, 2, 10, "pickaxe", 0, 0);
	}
	
	public abstract Class<TE> getTileEntityClass();
	public abstract Class<TileEntityVendBlock> getTileEntityClass1();
	
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);

}