package com.gryphonmodding.havicrpg.common.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.block.*;

public class BambooBiome extends BiomeGenBase {

	public BambooBiome(int par1) {
		super(par1);
		topBlock = (byte) Block.grass.blockID;
		fillerBlock = (byte) Block.dirt.blockID;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 50;

	}

}
