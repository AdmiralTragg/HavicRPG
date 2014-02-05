package com.gryphonmodding.havicrpg.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.gryphonmodding.havicrpg.HavicRPG;

public class BlockHavicStorage extends Block {
	public static String[] names = { "blockMogite", "blockClearite", "blockEuno" };
	public Icon[] icons;
	
	public BlockHavicStorage(int id) {
		super(id, Material.iron);
		this.setCreativeTab(HavicRPG.havicTabBlocks);
		this.setUnlocalizedName("blockHavicStorage");
		this.setHardness(5.0f);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[names.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("havicrpg:" + names[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
		return icons[meta];
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
