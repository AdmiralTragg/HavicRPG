package com.gryphonmodding.havicrpg.common.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.gryphonmodding.havicrpg.HavicRPG;
import com.gryphonmodding.havicrpg.common.block.HavicBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorYM implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkx, int chunkz, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0 :
				generateSurface(world, random, chunkx * 16, chunkz * 16);
		}

	}

	private void generateSurface(World world, Random random, int blockx, int blockz) {
		for (int i = 0; i < 10; i++) {
			int xcoord = blockx + random.nextInt(16);
			int zcoord = blockz + random.nextInt(32);
			int ycoord = random.nextInt(46);
			// OreGenerators
			(new WorldGenMinable(HavicBlocks.blockHavicOre.blockID, 0, 9, Block.stone.blockID)).generate(world, random, xcoord, ycoord, zcoord);

		}

	}

	private void generateSurface1(World world, Random random, int blockx, int blockz) {
		for (int i = 0; i < 10; i++) {
			int xcoord = blockx + random.nextInt(16);
			int zcoord = blockz + random.nextInt(16);
			int ycoord = random.nextInt(26);
			// OreGenerators
			(new WorldGenMinable(HavicBlocks.blockHavicOre.blockID, 2, 10, Block.stone.blockID)).generate(world, random, xcoord, ycoord, zcoord);

		}
	}
}