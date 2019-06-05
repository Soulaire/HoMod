package soulaire.homod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import soulaire.homod.objects.blocks.BlockGrass;
import soulaire.homod.objects.blocks.BlockLeaf;
import soulaire.homod.objects.blocks.BlockLogs;
import soulaire.homod.objects.blocks.BlockOres;
import soulaire.homod.objects.blocks.BlockPlank;
import soulaire.homod.objects.blocks.BlockSaplings;
import soulaire.homod.objects.blocks.HomiumBlock;

public class BlockInit 
{
	public static Block planks, leaves, log;
	
	public static final List<Block> BLOCK = new ArrayList<Block>();
	
	public static final Block HOMIUM_BLOCK = new HomiumBlock("homium_block", Material.IRON);
	
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	//public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	
	//Tree
	public static final Block PLANKS = new BlockPlank("planks");
	public static final Block LOG = new BlockLogs("log");
	public static final Block SAPLINGS = new BlockSaplings("saplings");
	public static final Block LEAVES = new BlockLeaf("leaves");
	
	public static final Block DREAM_GRASS = new BlockGrass("dream_grass", Material.GRASS);
	
	
}
