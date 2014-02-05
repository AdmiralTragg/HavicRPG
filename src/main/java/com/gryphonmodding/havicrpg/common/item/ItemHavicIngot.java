package com.gryphonmodding.havicrpg.common.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.gryphonmodding.havicrpg.HavicRPG;

public class ItemHavicIngot extends Item {
	public Icon[] icons;
	public String[] names = { "ingotMogite", "ingotClearite", "ingotEuno" };
	
	public ItemHavicIngot(int id) {
		super(id);
		this.setUnlocalizedName("itemHavicIngot");
		this.setCreativeTab(HavicRPG.havicTabMaterials);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "item." + names[itemStack.getItemDamage()];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("havicrpg:" + names[i]);
		}
	}
	
	@Override
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
