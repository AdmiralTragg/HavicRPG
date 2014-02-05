package com.gryphonmodding.havicrpg.common.block;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBrimstone extends Block {

	public BlockBrimstone(int id, Material mat) {
		super(id, mat);
		this.setHardness(5.0f);
		this.setCreativeTab(HavicRPG.havicTabBlocks);
		this.setUnlocalizedName("blockBrimstone");
	}

	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("havicrpg:" + getUnlocalizedName().substring(6));
	}
}
