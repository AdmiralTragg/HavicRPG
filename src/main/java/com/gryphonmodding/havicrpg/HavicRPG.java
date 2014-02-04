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

import com.gryphonmodding.havicrpg.common.CommonProxy;
import com.gryphonmodding.havicrpg.common.biome.BambooBiome;
import com.gryphonmodding.havicrpg.common.block.HavicBlocks;
import com.gryphonmodding.havicrpg.common.entity.mob.EntityCorthex;
import com.gryphonmodding.havicrpg.common.item.HavicItems;
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
	// encahtibility
	public static EnumToolMaterial ToolMaterialMogite = EnumHelper.addToolMaterial("Mogite", 3, 500, 7.50F, 6, 16);
	public static EnumToolMaterial ToolMaterialEuno = EnumHelper.addToolMaterial("Euno", 4, 750, 8.0F, 9, 16);

	/**
	 * Creative Tabs
	 */
	// Resources
	public static CreativeTabs havicTabMaterials = new CreativeTabs("tabMaterials") {
		public ItemStack getIconItemStack() {
			return HavicItems.ingotMogite;
		}
	};
	// Blocks
	public static CreativeTabs havicTabBlocks = new CreativeTabs("tabBlocks") {
		public ItemStack getIconItemStack() {
			return HavicBlocks.storageMogite;
		}
	};
	// Tools
	public static CreativeTabs havicTabTools = new CreativeTabs("tabTools") {
//		public ItemStack getIconItemStack() {
//			return new ItemStack(MogitePick);
//		}
	};

	// Dimension
	public static final int dimensionIdEmosion = 6;
	// Biomes
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

//		// tools
//		LanguageRegistry.addName(MogitePick, "Mogite Pick");
//
//		LanguageRegistry.addName(MogiteHoe, "Mogite Hoe");
//
//		LanguageRegistry.addName(MogiteAxe, "Mogite Axe");
//
//		LanguageRegistry.addName(MogiteSword, "Mogite Sword");
//
//		LanguageRegistry.addName(MogiteShovel, "Mogite Shovel");
//
//		LanguageRegistry.addName(EunoPick, "Euno Pick");
//
//		LanguageRegistry.addName(EunoAxe, "Euno Axe");
//
//		LanguageRegistry.addName(EunoSword, "Euno Sword");
//
//		LanguageRegistry.addName(EunoShovel, "Euno Shovel");
//
//		// blocks
//		GameRegistry.registerBlock(blockMogite, "blockMogite");
//		LanguageRegistry.addName(blockMogite, "Mogite Block");
//		MinecraftForge.setBlockHarvestLevel(blockMogite, "pickaxe", 2);
//
//		GameRegistry.registerBlock(BambooLeaves, "BambooLeaves");
//		LanguageRegistry.addName(BambooLeaves, "BambooWood Leaves");
//
//		GameRegistry.registerBlock(silverLog, "BambooLog");
//		LanguageRegistry.addName(silverLog, "Silver Wood");
//
//		GameRegistry.registerBlock(BambooSapling, "BambooSapling");
//		LanguageRegistry.addName(BambooSapling, "Bamboo Sapling");
//		MinecraftForge.EVENT_BUS.register(new BambooSaplingEventClass());
//
//		GameRegistry.registerBlock(blockBrimstone, "Brimstone");
//		LanguageRegistry.addName(blockBrimstone, "Brimstone");
//
//		GameRegistry.registerBlock(blockTeleporter, "blockTeleporter");
//		// Ores
//		GameRegistry.registerBlock(blockMogiteOre, "MogiteOre");
//		LanguageRegistry.addName(blockMogiteOre, "Mogite Ore");
//		MinecraftForge.setBlockHarvestLevel(blockMogiteOre, "pickaxe", 2);
//
//		GameRegistry.registerBlock(blockCleariteOre, "cleariteOre");
//		LanguageRegistry.addName(blockCleariteOre, "Clearite Ore");
//		MinecraftForge.setBlockHarvestLevel(blockCleariteOre, "pickaxe", 3);
//
//		GameRegistry.registerBlock(blockEunoOre, "Euno Ore");
//		LanguageRegistry.addName(blockEunoOre, "Euno Ore");
//		MinecraftForge.setBlockHarvestLevel(blockEunoOre, "pickaxe", 3);

		// Mobs
		registerEntity(EntityCorthex.class, "Corthex", 0xeaeae9, 0xc99a03);
		LanguageRegistry.instance().addStringLocalization("entity.Corthex.name", "Corthex");

		// Biomes
		GameRegistry.addBiome(BambooForest);
		// Crafting
		// Blocks
//		GameRegistry.addRecipe(new ItemStack(blockMogite), "MMM", "MMM", "MMM", 'M', MogiteIngot);
//
//		// Tools
//		GameRegistry.addRecipe(new ItemStack(MogitePick), "MMM", " I ", " I ", 'M', MogiteIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(MogiteHoe), "MM ", " I ", " I ", 'M', MogiteIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(MogiteShovel), " M ", " I ", " I ", 'M', MogiteIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(MogiteAxe), " MM", " IM", " I ", 'M', MogiteIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(MogiteSword), "M M", "MMM", " I ", 'M', MogiteIngot, 'I', Item.stick);
//
//		GameRegistry.addRecipe(new ItemStack(EunoPick), "MMM", " I ", " I ", 'M', EunoIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(EunoShovel), " M ", " I ", " I ", 'M', EunoIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(EunoAxe), " MM", " IM", " I ", 'M', EunoIngot, 'I', Item.stick);
//		GameRegistry.addRecipe(new ItemStack(EunoSword), " M ", " M ", " I ", 'M', EunoIngot, 'I', Item.stick);
//
//		// Smelting
//		GameRegistry.addSmelting(blockMogiteOre.blockID, new ItemStack(MogiteIngot), 0.1F);

//		// Generation
//		GameRegistry.registerWorldGenerator(new WorldGeneratorYM());
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
