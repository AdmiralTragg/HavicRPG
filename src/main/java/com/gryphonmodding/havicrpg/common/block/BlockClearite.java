package com.gryphonmodding.havicrpg.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockClearite extends Block {

	public BlockClearite(int id, Material mat) {
		super(id, mat);
	}

	public void registerIcons(IconRegister reg) { // Make sure to import
													// IconRegister!
		this.blockIcon = reg.registerIcon("yargmod:CleariteBlock"); // You can
																	// also
																	// replace
																	// blockID
																	// and
																	// blockIcon
																	// with
																	// itemID
																	// and
																	// itemIcon
	}
}
