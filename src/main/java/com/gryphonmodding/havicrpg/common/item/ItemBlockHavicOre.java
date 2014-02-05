package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.common.block.BlockHavicOre;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockHavicOre extends ItemBlock {
	public ItemBlockHavicOre(int id) {
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "block." + BlockHavicOre.names[itemStack.getItemDamage()];
	}
}
