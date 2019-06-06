package soulaire.homod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import soulaire.homod.world.biomes.BiomeDreamlands;

public class BiomeInit 
{
	public static final Biome DREAMLANDS = new BiomeDreamlands();
	
	public static void registerBiomes()
	{
		//initBiome(DREAMLANDS, "Dream Lands", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		initBiome(DREAMLANDS, "Dream Lands", BiomeType.WARM, Type.FOREST //, Type.MAGICAL, Type.SPOOKY
				);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registered");
		BiomeDictionary.addTypes(biome, types); 
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome Added");
		return biome;
	}
}
