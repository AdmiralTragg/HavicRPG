
package com.gryphonmodding.havicrpg.common.recipe;

import com.gryphonmodding.havicrpg.common.block.HavicBlocks;
import com.gryphonmodding.havicrpg.common.item.HavicItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class HavicRecipes {
	enum ToolType {
		SWORD, PICKAXE, SHOVEL, AXE, HOE
	}
	
	public static void init() {
		addToolRecipe(ToolType.SWORD, new ItemStack(HavicItems.swordMogite), HavicItems.ingotMogite);
		addToolRecipe(ToolType.PICKAXE, new ItemStack(HavicItems.pickaxeMogite), HavicItems.ingotMogite);
		addToolRecipe(ToolType.SHOVEL, new ItemStack(HavicItems.shovelMogite), HavicItems.ingotMogite);
		addToolRecipe(ToolType.AXE, new ItemStack(HavicItems.axeMogite), HavicItems.ingotMogite);
		addToolRecipe(ToolType.HOE, new ItemStack(HavicItems.hoeMogite), HavicItems.ingotMogite);
		
		addStorageRecipe(HavicBlocks.storageMogite, HavicItems.ingotMogite);
		
		addFurnaceRecipe(HavicBlocks.oreMogite, HavicItems.ingotMogite, 0.1f);
	}
	
	private static void addToolRecipe(ToolType type, ItemStack output, ItemStack material) {
		switch (type) {
			case SWORD:
				GameRegistry.addShapedRecipe(output, new Object[]{"X", "X", "S", 'X', material, 'S', Item.stick});
				break;
			case PICKAXE:
				GameRegistry.addShapedRecipe(output, new Object[]{"XXX", " S ", " S ", 'X', material, 'S', Item.stick});
				break;
			case SHOVEL:
				GameRegistry.addShapedRecipe(output, new Object[]{"X", "S", "S", 'X', material, 'S', Item.stick});
				break;
			case AXE:
				GameRegistry.addShapedRecipe(output, new Object[]{"XX", "XS", " S", 'X', material, 'S', Item.stick});
				break;
			case HOE:
				GameRegistry.addShapedRecipe(output, new Object[]{"XX", " S", " S", 'X', material, 'S', Item.stick});
				break;
			default:
				break;
		}
	}
	
	private static void addStorageRecipe(ItemStack output, ItemStack material) {
		GameRegistry.addShapedRecipe(output, new Object[]{"XXX", "XXX", "XXX", 'X', material});
		GameRegistry.addShapelessRecipe(new ItemStack(material.itemID, 9, material.getItemDamage()), new Object[]{output});
	}
	
	private static void addFurnaceRecipe(ItemStack input, ItemStack output, float experience) {
		FurnaceRecipes.smelting().addSmelting(input.itemID, input.getItemDamage(), output, experience);
	}
}
