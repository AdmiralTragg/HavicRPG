package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class ItemHavicSword extends ItemSword {
	public ItemHavicSword(int id, EnumToolMaterial material) {
		super(id, material);
		setCreativeTab(HavicRPG.havicTabTools);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("havicrpg:" + this.getUnlocalizedName().substring(5));
	}
}