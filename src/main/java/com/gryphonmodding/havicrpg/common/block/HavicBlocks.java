package com.gryphonmodding.havicrpg.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.gryphonmodding.havicrpg.common.item.ItemBlockHavicOre;
import com.gryphonmodding.havicrpg.common.item.ItemBlockHavicStorage;

import cpw.mods.fml.common.registry.GameRegistry;

public class HavicBlocks {
	public static Block blockHavicOre;
	public static Block blockHavicStorage;
	
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
	}
}
