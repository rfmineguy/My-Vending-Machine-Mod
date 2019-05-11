package com.rfmineguy.firstmod.init;

import java.util.ArrayList;
import java.util.List;

import com.rfmineguy.firstmod.Main;
import com.rfmineguy.firstmod.blocks.BlockBase;
import com.rfmineguy.firstmod.blocks.VendBotBlock;
import com.rfmineguy.firstmod.blocks.VendTopBlock;
import com.rfmineguy.firstmod.blocks.avend_block.BlockVendCombined;
import com.rfmineguy.firstmod.blocks.counter.BlockCounter;
import com.rfmineguy.firstmod.blocks.pedestal.BlockPedestal;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//https://minecraftmodcustomstuff.fandom.com/wiki/Hardness
	//https://minecraftmodcustomstuff.fandom.com/wiki/Resistance
	
	//public BlockBase(String name, Material material, CreativeTabs tab, SoundType soundType, float hardness, float resistance, String tool, int harvestLvl, float lightLvl)
	public static final Block VEND_BLOCK_BOT = new VendBotBlock("vend_block_bot");
	public static final Block VEND_BLOCK_TOP = new VendTopBlock("vend_block_top");
	public static final Block VEND_BLOCK_COMBINED = new BlockVendCombined("vend_block_combined", Main.moneytab);
	public static final Block COUNTER = new BlockCounter(Main.testtab);
	public static final Block PEDESTAL = new BlockPedestal(Main.testtab);
}