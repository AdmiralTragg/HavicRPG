package com.gryphonmodding.havicrpg.common.event;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.gryphonmodding.havicrpg.HavicRPG;
import com.gryphonmodding.havicrpg.common.block.BambooSapling;

public class BambooSaplingEventClass {
	private int BlockID;
	
	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlockId(event.X, event.Y, event.Z) == HavicRPG.BambooSapling.blockID) {
			((BambooSapling)HavicRPG.BambooSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}

}