package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class HavicItems {
	public static Item itemHavicIngot;
	
	public static ItemStack ingotMogite;
	public static ItemStack ingotClearite;
	public static ItemStack ingotEuno;
	
	public static Item swordMogite;
	public static Item pickaxeMogite;
	public static Item shovelMogite;
	public static Item axeMogite;
	public static Item hoeMogite;
	
	public static Item swordEuno;
	public static Item pickaxeEuno;
	public static Item shovelEuno;
	public static Item axeEuno;
	public static Item hoeEuno;
	
	public static void init() {
		initializeItems();
		registerItems();
	}
	
	private static void initializeItems() {
		itemHavicIngot = new ItemHavicIngot(5000);
		ingotMogite = new ItemStack(itemHavicIngot, 1, 0);
		ingotClearite = new ItemStack(itemHavicIngot, 1, 1);
		ingotEuno = new ItemStack(itemHavicIngot, 1, 2);
		
		swordMogite = new ItemHavicSword(6000, HavicRPG.ToolMaterialMogite, "swordMogite");
		pickaxeMogite = new ItemHavicPickaxe(6001, HavicRPG.ToolMaterialMogite, "pickaxeMogite");
		shovelMogite = new ItemHavicShovel(6002, HavicRPG.ToolMaterialMogite, "shovelMogite");
		axeMogite = new ItemHavicAxe(6003, HavicRPG.ToolMaterialMogite, "axeMogite");
		hoeMogite = new ItemHavicHoe(6004, HavicRPG.ToolMaterialMogite, "hoeMogite");
		
		swordEuno = new ItemHavicSword(6005, HavicRPG.ToolMaterialEuno, "swordEuno");
		pickaxeEuno = new ItemHavicPickaxe(6006, HavicRPG.ToolMaterialEuno, "pickaxeEuno");
		shovelEuno = new ItemHavicShovel(6007, HavicRPG.ToolMaterialEuno, "shovelEuno");
		axeEuno = new ItemHavicAxe(6008, HavicRPG.ToolMaterialEuno, "axeEuno");
		hoeEuno = new ItemHavicHoe(6009, HavicRPG.ToolMaterialEuno, "hoeEuno");
	}
	
	//Future proofing
	private static void registerItems() {
		GameRegistry.registerItem(itemHavicIngot, "itemHavicIngot");
		
		GameRegistry.registerItem(swordMogite, "swordMogite");
		GameRegistry.registerItem(pickaxeMogite, "pickaxeMogite");
		GameRegistry.registerItem(shovelMogite, "shovelMogite");
		GameRegistry.registerItem(axeMogite, "axeMogite");
		GameRegistry.registerItem(hoeMogite, "hoeMogite");
		
		GameRegistry.registerItem(swordEuno, "swordEuno");
		GameRegistry.registerItem(pickaxeEuno, "pickaxeEuno");
		GameRegistry.registerItem(shovelEuno, "shovelEuno");
		GameRegistry.registerItem(axeEuno, "axeEuno");
		GameRegistry.registerItem(hoeEuno, "hoeEuno");
	}
}
