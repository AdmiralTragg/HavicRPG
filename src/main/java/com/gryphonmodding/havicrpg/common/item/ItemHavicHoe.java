package com.gryphonmodding.havicrpg.common.item;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class ItemHavicHoe extends ItemHoe {

	public ItemHavicHoe(int id, EnumToolMaterial material) {
		super(id, material);
		setCreativeTab(HavicRPG.havicTabTools);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("yargmod:" + this.getUnlocalizedName().substring(5));
	}

}