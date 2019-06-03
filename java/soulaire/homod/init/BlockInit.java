package soulaire.homod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import soulaire.homod.objects.blocks.BlockOres;
import soulaire.homod.objects.blocks.HomiumBlock;
import soulaire.homod.objects.blocks.HomiumOreBlock;

public class BlockInit 
{
	public static final List<Block> BLOCK = new ArrayList<Block>();
	
	public static final Block HOMIUM_BLOCK = new HomiumBlock("homium_block", Material.IRON);
	
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	//public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
}
