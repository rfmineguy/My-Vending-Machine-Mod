package com.rfmineguy.firstmod.blocks;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.init.ModBlocks;
import com.rfmineguy.firstmod.init.ModItems;
import com.rfmineguy.firstmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material, CreativeTabs tab, SoundType soundType, float hardness, float resistance, String tool, int harvestLvl, float lightLvl)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setSoundType(soundType);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLvl);
		setLightLevel(lightLvl);
		//setLightOpacity(op);
		//setBlockUnbreakable
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels()
	{	
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
