package com.gryphonmodding.havicrpg.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class EarthShard extends Item{

	public EarthShard(int id) {
		super(id);
		
	}
	public void registerIcons(IconRegister reg) { // Make sure to import IconRegister!
		this.itemIcon = reg.registerIcon("yargmod:EarthShard"); // You can also replace blockID and blockIcon with itemID and itemIcon
		}
}
