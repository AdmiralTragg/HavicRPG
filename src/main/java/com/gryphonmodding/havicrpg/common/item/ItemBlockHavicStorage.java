package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.common.block.BlockHavicStorage;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockHavicStorage extends ItemBlock {
	public ItemBlockHavicStorage(int id) {
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	public int getMetadata(int meta) {
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack itemStack) {
		return "block." + BlockHavicStorage.names[itemStack.getItemDamage()];
	}
}
