package com.gryphonmodding.havicrpg;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
public class ChunkProviderEmosion implements IChunkProvider {

	private Random rand;
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	private MapGenVillage villageGenerator = new MapGenVillage();
	private MapGenRavine ravineGenerator = new MapGenRavine();
	
	private BiomeGenBase[] biomesforGeneration;
	
	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);
		ravineGenerator = (MapGenRavine) TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
		
		
	}
	
	
	public ChunkProviderEmosion(World worldObj, long seed, boolean features) {
		this.worldObj = worldObj;
		this.mapFeaturesEnabled = features;
		this.rand = new  Random(seed);
	}


	public boolean chunkExists(int i, int j) {
		return false;
	}

	
	public Chunk provideChunk(int i, int j) {
		return null;
	}

	
	public Chunk loadChunk(int i, int j) {
		return null;
	}

	
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		BlockSand.fallInstantly = true;
		int k = i * 16;
		int l = j * 16;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = rand.nextLong() / 2L * 2L + 1L;
		long j1 = rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)i*i1 + (long)j*j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(ichunkprovider, worldObj, rand, i, j, flag));
		
		
		if(mapFeaturesEnabled){
		flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, rand, i, j);
		}
		
		int k1;
		int l1;
		int i2;
		
		if(biome != BiomeGenBase.desert && biome != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(ichunkprovider, worldObj, rand, i, j, flag, LAKE)){
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(128);
			i2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);
		}
		
		
	}

	
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return false;
	}

	
	public boolean unloadQueuedChunks() {
		return false;
	}

	
	public boolean canSave() {
		return false;
	}

	
	public String makeString() {
		return null;
	}

	
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,
			int j, int k) {
		return null;
	}

	
	public ChunkPosition findClosestStructure(World world, String s, int i,
			int j, int k) {
		return null;
	}

	
	public int getLoadedChunkCount() {
		return 0;
	}

	
	public void recreateStructures(int i, int j) {

	}

	
	public void saveExtraData() {

	}

}
