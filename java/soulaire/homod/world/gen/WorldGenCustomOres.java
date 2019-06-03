package soulaire.homod.world.gen;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import soulaire.homod.init.BlockInit;
import soulaire.homod.objects.blocks.BlockOres;
import soulaire.homod.util.handlers.EnumHandler;

public class WorldGenCustomOres implements IWorldGenerator 
{
	private WorldGenerator ore_nether_homium, ore_overworld_homium;
	private WorldGenerator ore_nether_ultrahomium, ore_overworld_ultrahomium;
	
	public WorldGenCustomOres()
	{
		ore_nether_homium = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.HOMIUM), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_homium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.HOMIUM), 9, BlockMatcher.forBlock(Blocks.STONE));
	
		ore_nether_ultrahomium = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ULTRAHOMIUM), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_ultrahomium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ULTRAHOMIUM), 9, BlockMatcher.forBlock(Blocks.STONE));
	
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case -1:
			
			runGenerator(ore_nether_homium, world, random, chunkX, chunkZ, 2, 0, 100);
			runGenerator(ore_nether_ultrahomium, world, random, chunkX, chunkZ, 2, 0, 100);
			
			break;
		
		case 0:
			
			runGenerator(ore_overworld_homium, world, random, chunkX, chunkZ, 2, 0, 16);
			runGenerator(ore_overworld_ultrahomium, world, random, chunkX, chunkZ, 1, 0, 5);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 265) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}
