package com.gryphonmodding.havicrpg.common.world;

import com.gryphonmodding.havicrpg.HavicRPG;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEmosion extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(HavicRPG.BambooForest, 0.4F, 0.3F);
		this.dimensionId = HavicRPG.dimensionIdEmosion;
		}
	
public IChunkProvider createChunkProvider(){
	return new ChunkProviderEmosion(this.worldObj, this.worldObj.getSeed(), true);
}
	
	public String getDimensionName() {
		return "Emosion Dimension";
	}

}
