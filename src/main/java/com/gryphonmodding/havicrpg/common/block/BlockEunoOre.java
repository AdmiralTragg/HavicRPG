package com.gryphonmodding.havicrpg.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockEunoOre extends Block {

	public BlockEunoOre(int id, Material mat) {
		super(id, mat);

	}

	public void registerIcons(IconRegister reg) { // Make sure to import
													// IconRegister!
		this.blockIcon = reg.registerIcon("yargmod:EunoOre"); // You can also
																// replace
																// blockID and
																// blockIcon
																// with itemID
																// and itemIcon
	}
}
