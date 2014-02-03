package com.gryphonmodding.havicrpg;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.gryphonmodding.havicrpg.common.CommonProxy;
import com.gryphonmodding.havicrpg.common.biome.BambooBiome;
import com.gryphonmodding.havicrpg.common.block.BambooLeaves;
import com.gryphonmodding.havicrpg.common.block.BambooLog;
import com.gryphonmodding.havicrpg.common.block.BambooSapling;
import com.gryphonmodding.havicrpg.common.block.BlockBrimstone;
import com.gryphonmodding.havicrpg.common.block.BlockClearite;
import com.gryphonmodding.havicrpg.common.block.BlockCleariteOre;
import com.gryphonmodding.havicrpg.common.block.BlockEunoOre;
import com.gryphonmodding.havicrpg.common.block.BlockMogite;
import com.gryphonmodding.havicrpg.common.block.BlockMogiteOre;
import com.gryphonmodding.havicrpg.common.block.BlockTeleporter;
import com.gryphonmodding.havicrpg.common.entity.mob.EntityCorthex;
import com.gryphonmodding.havicrpg.common.event.BambooSaplingEventClass;
import com.gryphonmodding.havicrpg.common.item.BluefirePowder;
import com.gryphonmodding.havicrpg.common.item.CleariteIngot;
import com.gryphonmodding.havicrpg.common.item.EarthShard;
import com.gryphonmodding.havicrpg.common.item.EunoIngot;
import com.gryphonmodding.havicrpg.common.item.HavicBasicAxe;
import com.gryphonmodding.havicrpg.common.item.HavicBasicHoe;
import com.gryphonmodding.havicrpg.common.item.HavicBasicPickaxe;
import com.gryphonmodding.havicrpg.common.item.HavicBasicSpade;
import com.gryphonmodding.havicrpg.common.item.HavicBasicSword;
import com.gryphonmodding.havicrpg.common.item.MogiteIngot;
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

@Mod(modid="HavicRPG", name="HavicRPG", version="0.3")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class HavicRPG {
	@Instance("HavicRPG")
    public static HavicRPG instance;
    
	//Tool Materials Name harvestLevel durabiliy efficiency mobDamage encahtibility
	public static EnumToolMaterial ToolMaterialMogite = EnumHelper.addToolMaterial("Mogite", 3, 500, 7.50F, 6, 16);
    public static EnumToolMaterial ToolMaterialEuno = EnumHelper.addToolMaterial("Euno", 4, 750, 8.0F, 9, 16);
    
    /**
     * Creative Tabs
     */
    //Resources
    public static CreativeTabs YargModMaterialsTab = new CreativeTabs("tabMaterials") {
        public ItemStack getIconItemStack() {
            return new ItemStack(MogiteIngot);
        }
    };
    //Blocks
    public static CreativeTabs YargModBlocksTab = new CreativeTabs("tabBlocks") {
        public ItemStack getIconItemStack() {
            return new ItemStack(blockMogite);
        }
    };
    //Tools
    public static CreativeTabs YargModToolsTab = new CreativeTabs("tabTools"){
        public ItemStack getIconItemStack(){
                return new ItemStack(MogitePick);
        }
    };
                    

    //Dimension
	public static final int dimensionIdEmosion = 6;
	//Biomes
	public final static BiomeGenBase BambooForest = new BambooBiome(14).setBiomeName("Bamboo Forest").setMinMaxHeight(0.3F, 0.7F);
   
	//Items
	
    public final static Item MogiteIngot = new MogiteIngot(5001).setMaxStackSize(64).setUnlocalizedName("MogiteIngot").setTextureName("yargmod:MogiteIngot").setCreativeTab(YargModMaterialsTab);
    public final static Item CleariteIngot = new CleariteIngot(5002) .setMaxStackSize(16).setUnlocalizedName("CleariteIngot").setTextureName("yargmod:CleariteIngot").setCreativeTab(YargModMaterialsTab);
    public final static Item BluefirePowder = new BluefirePowder(5003).setMaxStackSize(1).setUnlocalizedName("BluefirePowder").setTextureName("yargmod:BluefirePowder").setCreativeTab(YargModMaterialsTab);
    public final static Item EunoIngot = new EunoIngot(5004) .setMaxStackSize(64).setUnlocalizedName("CleariteIngot").setTextureName("yargmod:CleariteIngot").setCreativeTab(YargModMaterialsTab);
    public final static Item EarthShard = new EarthShard(5005).setMaxStackSize(64).setUnlocalizedName("EarthShard").setTextureName("yargmod:EarthShard").setCreativeTab(YargModMaterialsTab);
   //Foods
   //Tools 
    public final static Item MogitePick = new HavicBasicPickaxe(6003, ToolMaterialMogite) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("MogitePick");
    public final static Item MogiteShovel = new HavicBasicSpade(6004, ToolMaterialMogite) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("MogiteShovel");
    public final static Item MogiteAxe = new HavicBasicAxe(6005, ToolMaterialMogite) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("MogiteAxe");
    public final static Item MogiteHoe = new HavicBasicHoe(6006, ToolMaterialMogite) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("MogiteHoe");
    public final static Item MogiteSword = new HavicBasicSword(6007, ToolMaterialMogite) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("MogiteSword");
    
    public final static Item EunoPick = new HavicBasicPickaxe(6008, ToolMaterialEuno) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("EunoPick");
    public final static Item EunoShovel = new HavicBasicSpade(6009, ToolMaterialEuno) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("EunoShovel");
    public final static Item EunoAxe = new HavicBasicAxe(6010, ToolMaterialEuno) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("EunoAxe");
    public final static Item EunoSword = new HavicBasicSword(6012, ToolMaterialEuno) .setMaxStackSize(1).setCreativeTab(YargModToolsTab).setUnlocalizedName("EunoSword");
    //blocks
    public final static Block blockMogite = new BlockMogite(2002, Material.rock).setUnlocalizedName("blockMogite").setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);
    public final static Block blockMogiteOre = new BlockMogiteOre(2003, Material.rock).setUnlocalizedName("blockMogiteOre").setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);
    
    public final static Block blockClearite = new BlockClearite(2004, Material.iron).setUnlocalizedName("blockClearite").setLightOpacity(6).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);
    public final static Block blockCleariteOre = new BlockCleariteOre(2005, Material.iron).setUnlocalizedName("blockCleariteOre").setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);
    
    public final static Block BambooLeaves = new BambooLeaves(2006, Material.leaves).setUnlocalizedName("BambooLeaves"); 
    public final static Block BambooSapling = new BambooSapling(2007, 0).setUnlocalizedName("SilverSapling");
    public final static Block silverLog = new BambooLog(2008, Material.wood).setUnlocalizedName("silverLog");
    
    public final static Block blockTeleporter = new BlockTeleporter(2009).setUnlocalizedName("blockTeleport");
    
    public final static Block blockBrimstone = new BlockBrimstone(2010, Material.rock).setUnlocalizedName("blockBrimstone").setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);   
    
    public final static Block blockEunoOre = new BlockEunoOre(2011, Material.rock).setUnlocalizedName("blockEunoOre").setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(YargModBlocksTab);
    @SidedProxy(clientSide="ThePlayerHaze.UnnamedMod.client.ClientProxy",
                    serverSide="tutorial.generic.CommonProxy")
    public static CommonProxy proxy;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
		//Creative Tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabMaterials", "en_US", "YargMod Materials");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabBlocks", "en_US", "YargMod Blocks");
		
		//Dimensions
		DimensionManager.registerProviderType(dimensionIdEmosion, WorldProviderEmosion.class, false);
		DimensionManager.registerDimension(dimensionIdEmosion, dimensionIdEmosion);
		 
		//items
		LanguageRegistry.addName(MogiteIngot, "Mogite Ingot");
		
		LanguageRegistry.addName(CleariteIngot, "Clearite Ingot");
		
		LanguageRegistry.addName(EunoIngot, "Euno Ingot");
		
		//tools
		LanguageRegistry.addName(MogitePick, "Mogite Pick");
		
		LanguageRegistry.addName(MogiteHoe, "Mogite Hoe");
		
		LanguageRegistry.addName(MogiteAxe, "Mogite Axe");
		
		LanguageRegistry.addName(MogiteSword, "Mogite Sword");
		
		LanguageRegistry.addName(MogiteShovel, "Mogite Shovel");
		
		
		LanguageRegistry.addName(EunoPick, "Euno Pick");
		
		LanguageRegistry.addName(EunoAxe, "Euno Axe");
		
		LanguageRegistry.addName(EunoSword, "Euno Sword");
		
		LanguageRegistry.addName(EunoShovel, "Euno Shovel");
		
		//blocks
		GameRegistry.registerBlock(blockMogite, "blockMogite");
		LanguageRegistry.addName(blockMogite, "Mogite Block");
		MinecraftForge.setBlockHarvestLevel(blockMogite, "pickaxe", 2);
		
		GameRegistry.registerBlock(BambooLeaves, "BambooLeaves");
		LanguageRegistry.addName(BambooLeaves, "BambooWood Leaves");
		
		GameRegistry.registerBlock(silverLog, "BambooLog");
		LanguageRegistry.addName(silverLog, "Silver Wood");
		
		GameRegistry.registerBlock(BambooSapling, "BambooSapling");
		LanguageRegistry.addName(BambooSapling, "Bamboo Sapling");
		MinecraftForge.EVENT_BUS.register(new BambooSaplingEventClass());
		
		GameRegistry.registerBlock(blockBrimstone, "Brimstone");
		LanguageRegistry.addName(blockBrimstone, "Brimstone");
		
		GameRegistry.registerBlock(blockTeleporter, "blockTeleporter");
		//Ores
		GameRegistry.registerBlock(blockMogiteOre, "MogiteOre");
		LanguageRegistry.addName(blockMogiteOre, "Mogite Ore");
		MinecraftForge.setBlockHarvestLevel(blockMogiteOre, "pickaxe", 2);
		
		GameRegistry.registerBlock(blockCleariteOre, "cleariteOre");
		LanguageRegistry.addName(blockCleariteOre, "Clearite Ore");
		MinecraftForge.setBlockHarvestLevel(blockCleariteOre, "pickaxe", 3);
		
		GameRegistry.registerBlock(blockEunoOre, "Euno Ore");
		LanguageRegistry.addName(blockEunoOre, "Euno Ore");
		MinecraftForge.setBlockHarvestLevel(blockEunoOre, "pickaxe", 3);
		
		//Mobs
		registerEntity(EntityCorthex.class, "Corthex", 0xeaeae9, 0xc99a03);
		LanguageRegistry.instance().addStringLocalization("entity.Corthex.name", "Corthex");
		  
		//Biomes
		GameRegistry.addBiome(BambooForest);
		//Crafting
		//Blocks
		GameRegistry.addRecipe(new ItemStack(blockMogite), "MMM", "MMM", "MMM",
		'M', MogiteIngot);
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(MogitePick), "MMM", " I ", " I ",
		'M', MogiteIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MogiteHoe), "MM ", " I ", " I ",
		'M', MogiteIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MogiteShovel), " M ", " I ", " I ",
		'M', MogiteIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MogiteAxe), " MM", " IM", " I ",
		'M', MogiteIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MogiteSword), "M M", "MMM", " I ",
		'M', MogiteIngot, 'I', Item.stick);
		
		
		GameRegistry.addRecipe(new ItemStack(EunoPick), "MMM", " I ", " I ",
		'M', EunoIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EunoShovel), " M ", " I ", " I ",
		'M', EunoIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EunoAxe), " MM", " IM", " I ",
		'M', EunoIngot, 'I', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EunoSword), " M ", " M ", " I ",
		'M', EunoIngot, 'I', Item.stick);
		    
		    
		//Smelting
		GameRegistry.addSmelting(blockMogiteOre.blockID, new ItemStack(MogiteIngot), 0.1F);
		   
		    
		//Generation
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
