package com.gryphonmodding.havicrpg.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BambooTreeWorldGeneration extends WorldGenerator implements IWorldGenerator{

		public BambooTreeWorldGeneration(boolean par1){
			this(par1, 8, 0, 0, false);
		}
	public BambooTreeWorldGeneration(boolean par1, int par2, int par3, int par4, boolean par5){
		super(par1);
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		return false;
	}

}
