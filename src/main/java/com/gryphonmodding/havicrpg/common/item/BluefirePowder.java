package com.gryphonmodding.havicrpg.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BluefirePowder extends Item {

	public BluefirePowder(int par1) {
		super(par1);
	}

	public void registerIcons(IconRegister reg) { // Make sure to import
													// IconRegister!
		this.itemIcon = reg.registerIcon("yargmod:EunoIngot"); // You can also
																// replace
																// blockID and
																// blockIcon
																// with itemID
																// and itemIcon
	}
}
