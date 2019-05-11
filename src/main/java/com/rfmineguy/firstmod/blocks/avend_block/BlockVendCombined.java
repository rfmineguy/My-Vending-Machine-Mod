package com.rfmineguy.firstmod.blocks.avend_block;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.ModGuiHandler;
import com.rfmineguy.firstmod.blocks.avend_block.tileentity.TileEntityVendBlock;
import com.rfmineguy.firstmod.blocks.pedestal.tileentity.TileEntityPedestal;
import com.rfmineguy.firstmod.blocks.tileentity.BlockTileEntity;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

//...
public class BlockVendCombined extends BlockTileEntity implements ITileEntityProvider {

	// ...

	public BlockVendCombined(String name, CreativeTabs tab) {
		super(Material.ROCK, "vendBlockCombined");
		setCreativeTab(tab);
	}
	//CHECKS IF THE BLOCK HAS BEEN CLICKED AND USING CONDITION STATEMENTS DETERMINES WHETHER OR NOT TO OPEN GUI
	//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		boolean isHolding = player.getHeldItem(hand).isEmpty();
		if (!world.isRemote) {
			TileEntity inv = world.getTileEntity(pos);
			IItemHandler itemHandler = inv.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
			if (!player.isSneaking()) {
				player.sendMessage(new TextComponentString("not sneaking"));
				if (!isHolding || isHolding) {
					//player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
					//player.sendMessage(new TextComponentString("removed item from block"));
				//} else {
					//player.setHeldItem(hand, itemHandler.insertItem(0, player.getHeldItem(hand), false));
					//player.sendMessage(new TextComponentString("added item to block"));
					player.openGui(Main.Instance, ModGuiHandler.VEND_BLOCK, world, pos.getX(), pos.getY(), pos.getZ());
				}	
				inv.markDirty();
			} else {
				ItemStack stack = itemHandler.getStackInSlot(0);
				if (!stack.isEmpty()) {
					String localized = Main.proxy.localize(stack.getUnlocalizedName() + ".name");
					player.sendMessage(new TextComponentString(stack.getCount() + "x " + localized));
				} else {
					player.sendMessage(new TextComponentString("Empty"));
				}
			}
		}
		return true;
	}
	
	
	//WHEN THE BLOCK IS BROKEN IT RETRIEVES THE ITEM STORED IN 'ITEMHANDLER' AND DROPS IT ON THE GROUND WHERE THE BLOCK WAS BROKEN
	//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		/*TileEntityVendBlock tile = world.getTileEntity(pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		if (!stack.isEmpty()) {
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
			world.spawnEntity(item);
		}
		super.breakBlock(world, pos, state);
		*/
		
		TileEntity inv = world.getTileEntity(pos);
		//IItemHandler itemHandler = inv.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		for(int i = 0; i < ((IInventory) inv).getSizeInventory(); ++i) {
			ItemStack stack = ((IInventory) inv).getStackInSlot(i);
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);

			world.spawnEntity(item);
		}
		super.breakBlock(world, pos, state);
	}

	@Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public TileEntityVendBlock createTileEntity(World world, IBlockState state)
    {
        return new TileEntityVendBlock();
    }
	@Override
	public Class getTileEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class getTileEntityClass1() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityVendBlock();
	}
} 