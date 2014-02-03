package com.gryphonmodding.havicrpg.common.block;

import java.util.Random;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BambooLeaves extends Block {

	public BambooLeaves(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(HavicRPG.YargModBlocksTab);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
		this.setStepSound(soundGrassFootstep);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("yargmod:BambooLeaves");
	}

}
