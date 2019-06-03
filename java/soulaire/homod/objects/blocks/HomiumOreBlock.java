package soulaire.homod.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class HomiumOreBlock extends BlockBase
{

	public HomiumOreBlock(String name, Material material) 
	{
		super(name, material);	
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(5.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
