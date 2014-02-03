package com.gryphonmodding.havicrpg.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class CleariteIngot extends Item{

	public CleariteIngot(int id) {
		super(id);
		
	}
	public void registerIcons(IconRegister reg) { // Make sure to import IconRegister!
		this.itemIcon = reg.registerIcon("yargmod:CleariteIngot"); // You can also replace blockID and blockIcon with itemID and itemIcon
		}
}
