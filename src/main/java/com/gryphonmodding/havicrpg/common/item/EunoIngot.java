package com.gryphonmodding.havicrpg.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class EunoIngot extends Item{

	public EunoIngot(int id) {
		super(id);
		
	}
	public void registerIcons(IconRegister reg) { // Make sure to import IconRegister!
		this.itemIcon = reg.registerIcon("yargmod:EunoIngot"); // You can also replace blockID and blockIcon with itemID and itemIcon
		}
}
