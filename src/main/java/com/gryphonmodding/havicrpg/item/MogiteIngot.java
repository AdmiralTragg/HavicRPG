package com.gryphonmodding.havicrpg.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class MogiteIngot extends Item{

	public MogiteIngot(int id) {
		super(id);
		
	}
	public void registerIcons(IconRegister reg) { // Make sure to import IconRegister!
		this.itemIcon = reg.registerIcon("yargmod:MogiteIngot"); // You can also replace blockID and blockIcon with itemID and itemIcon
		}
}

