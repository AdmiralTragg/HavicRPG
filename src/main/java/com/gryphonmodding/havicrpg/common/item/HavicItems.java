package com.gryphonmodding.havicrpg.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class HavicItems {
	public static Item itemHavicIngot;
	
	public static ItemStack ingotMogite;
	public static ItemStack ingotClearite;
	public static ItemStack ingotEuno;
	
	public static void init() {
		initializeItems();
		registerItems();
	}
	
	private static void initializeItems() {
		itemHavicIngot = new ItemHavicIngot(5000);
		ingotMogite = new ItemStack(itemHavicIngot, 1, 0);
		ingotClearite = new ItemStack(itemHavicIngot, 1, 1);
		ingotEuno = new ItemStack(itemHavicIngot, 1, 2);
	}
	
	//Future proofing
	private static void registerItems() {
		GameRegistry.registerItem(itemHavicIngot, "itemHavicIngot");
	}
}
