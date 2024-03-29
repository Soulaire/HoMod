package soulaire.homod.world.biomes;

import java.util.Random;

import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import soulaire.homod.init.BlockInit;
import soulaire.homod.objects.blocks.BlockOres;
import soulaire.homod.util.handlers.EnumHandler;
import soulaire.homod.world.gen.generators.WorldGenHomiumTree;

public class BiomeDreamlands extends Biome
{
	protected static final WorldGenAbstractTree TREE = new WorldGenHomiumTree();
	
	public BiomeDreamlands() 
	{
		super(new BiomeProperties("Dream Lands").setBaseHeight(0.50F).setHeightVariation(0.55F).setTemperature(1.0F).setRainfall(0.2F).setWaterColor(16711755));
		
		topBlock = BlockInit.DREAM_GRASS.getDefaultState();
		//fillerBlock = BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.HOMIUM);
		fillerBlock = Blocks.DIRT.getDefaultState();
		
	    int treesPerChunk;
	    float extraTreeChance = 1.0F;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityVillager.class, 10, 1, 5));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityGolem.class, 10, 1, 2));
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	{
		return TREE;
	}
}
