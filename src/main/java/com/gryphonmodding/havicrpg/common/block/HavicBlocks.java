package com.gryphonmodding.havicrpg.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import com.gryphonmodding.havicrpg.common.item.ItemBlockHavicOre;
import com.gryphonmodding.havicrpg.common.item.ItemBlockHavicStorage;

import cpw.mods.fml.common.registry.GameRegistry;

public class HavicBlocks {
	public static Block blockHavicOre;
	public static Block blockHavicStorage;
	
	public static Block leafBamboo;
	public static Block saplingBamboo;
	public static Block logSilver;
	
	public static Block blockBrimstone;
	
	public static ItemStack oreMogite;
	public static ItemStack oreClearite;
	public static ItemStack oreEuno;
	public static ItemStack storageMogite;
	public static ItemStack storageClearite;
	public static ItemStack storageEuno;
	
	public static void init() {
		initializeBlocks();
		registerBlocks();
	}
	
	private static void initializeBlocks() {
		blockHavicOre = new BlockHavicOre(2000);
		blockHavicStorage = new BlockHavicStorage(2001);
		
		leafBamboo = new BambooLeaves(2002, Material.leaves);
		saplingBamboo = new BambooSapling(2003, 0);
		logSilver = new BambooLog(2004, Material.wood);
		
		blockBrimstone = new BlockBrimstone(2005, Material.rock);
		
		oreMogite = new ItemStack(blockHavicOre, 1, 0);
		oreClearite = new ItemStack(blockHavicOre, 1, 1);
		oreEuno = new ItemStack(blockHavicOre, 1, 2);
		storageMogite = new ItemStack(blockHavicStorage, 1, 0);
		storageClearite = new ItemStack(blockHavicStorage, 1, 1);
		storageEuno = new ItemStack(blockHavicStorage, 1, 2);
	}
	
	private static void registerBlocks() {
		GameRegistry.registerBlock(blockHavicOre, ItemBlockHavicOre.class, "blockHavicOre");
		GameRegistry.registerBlock(blockHavicStorage, ItemBlockHavicStorage.class, "blockHavicStorage");
		
		GameRegistry.registerBlock(leafBamboo, "leavesBamboo");
		GameRegistry.registerBlock(saplingBamboo, "saplingBamboo");
		GameRegistry.registerBlock(logSilver, "logSilver");
		
		GameRegistry.registerBlock(blockBrimstone, "blockBrimstone");
	}
}
