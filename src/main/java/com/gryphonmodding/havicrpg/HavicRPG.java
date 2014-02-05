package com.gryphonmodding.havicrpg;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.gryphonmodding.havicrpg.common.CommonProxy;
import com.gryphonmodding.havicrpg.common.biome.BambooBiome;
import com.gryphonmodding.havicrpg.common.block.HavicBlocks;
import com.gryphonmodding.havicrpg.common.entity.mob.EntityCorthex;
import com.gryphonmodding.havicrpg.common.item.HavicItems;
import com.gryphonmodding.havicrpg.common.recipe.HavicRecipes;
import com.gryphonmodding.havicrpg.common.world.WorldGeneratorYM;
import com.gryphonmodding.havicrpg.common.world.WorldProviderEmosion;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HavicRPG", name = "Havic RPG", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HavicRPG {
	@Instance("HavicRPG")
	public static HavicRPG instance;

	// Tool Materials Name harvestLevel durabiliy efficiency mobDamage
	public static EnumToolMaterial ToolMaterialMogite = EnumHelper.addToolMaterial("Mogite", 3, 500, 7.50F, 6, 16);
	public static EnumToolMaterial ToolMaterialEuno = EnumHelper.addToolMaterial("Euno", 4, 750, 8.0F, 9, 16);

	public static CreativeTabs havicTabMaterials = new CreativeTabs("tabMaterials") {
		public ItemStack getIconItemStack() {
			return HavicItems.ingotMogite;
		}
	};

	public static CreativeTabs havicTabBlocks = new CreativeTabs("tabBlocks") {
		public ItemStack getIconItemStack() {
			return HavicBlocks.storageMogite;
		}
	};

	public static CreativeTabs havicTabTools = new CreativeTabs("tabTools") {
		public ItemStack getIconItemStack() {
			return new ItemStack(HavicItems.pickaxeMogite);
		}
	};

	public static final int dimensionIdEmosion = 6;

	public final static BiomeGenBase BambooForest = new BambooBiome(14).setBiomeName("Bamboo Forest").setMinMaxHeight(0.3F, 0.7F);

	@SidedProxy(clientSide = "com.gryphonmodding.havicrpg.client.ClientProxy", serverSide = "com.gryphonmodding.havicrpg.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HavicItems.init();
		HavicBlocks.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		// Dimensions
		DimensionManager.registerProviderType(dimensionIdEmosion, WorldProviderEmosion.class, false);
		DimensionManager.registerDimension(dimensionIdEmosion, dimensionIdEmosion);

		MinecraftForge.setBlockHarvestLevel(HavicBlocks.blockHavicStorage, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(HavicBlocks.blockHavicOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(HavicBlocks.blockHavicOre, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(HavicBlocks.blockHavicOre, 2, "pickaxe", 2);
		
		HavicRecipes.init();

//		GameRegistry.registerBlock(BambooLeaves, "BambooLeaves");
//		LanguageRegistry.addName(BambooLeaves, "BambooWood Leaves");

//		GameRegistry.registerBlock(silverLog, "BambooLog");
//		LanguageRegistry.addName(silverLog, "Silver Wood");

//		GameRegistry.registerBlock(BambooSapling, "BambooSapling");
//		LanguageRegistry.addName(BambooSapling, "Bamboo Sapling");
//		MinecraftForge.EVENT_BUS.register(new BambooSaplingEventClass());

//		GameRegistry.registerBlock(blockBrimstone, "Brimstone");
//		LanguageRegistry.addName(blockBrimstone, "Brimstone");

		// Mobs
		registerEntity(EntityCorthex.class, "Corthex", 0xeaeae9, 0xc99a03);
		LanguageRegistry.instance().addStringLocalization("entity.Corthex.name", "Corthex");

		// Biomes
		GameRegistry.addBiome(BambooForest);

		GameRegistry.registerWorldGenerator(new WorldGeneratorYM());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}

	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
}
