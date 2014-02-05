package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class ItemHavicHoe extends ItemHoe {

	public ItemHavicHoe(int id, EnumToolMaterial material, String name) {
		super(id, material);
		this.setCreativeTab(HavicRPG.havicTabTools);
		this.setUnlocalizedName(name);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("havicrpg:" + this.getUnlocalizedName().substring(5));
	}

}