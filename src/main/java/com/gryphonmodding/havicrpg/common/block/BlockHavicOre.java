package com.gryphonmodding.havicrpg.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.gryphonmodding.havicrpg.HavicRPG;

public class BlockHavicOre extends Block {
	public static String[] names = { "oreMogite", "oreClearite", "oreEuno" };
	public Icon[] icons;
	
	public BlockHavicOre(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("blockHavicOre");
		this.setCreativeTab(HavicRPG.havicTabBlocks);
		this.setHardness(3.0f);
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
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
