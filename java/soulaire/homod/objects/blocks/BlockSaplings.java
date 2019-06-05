package soulaire.homod.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import soulaire.homod.Main;
import soulaire.homod.init.BlockInit;
import soulaire.homod.init.ItemInit;
import soulaire.homod.util.handlers.EnumHandler;
import soulaire.homod.util.interfaces.IHasModel;
import soulaire.homod.util.interfaces.IMetaName;
import soulaire.homod.world.gen.generators.WorldGenHomiumTree;

public class BlockSaplings extends BlockBush implements IGrowable, IMetaName, IHasModel
{	
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class, new Predicate<EnumHandler.EnumType>()
	{
		public boolean apply(@Nullable EnumHandler.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
    
    private static String type;
    
    public BlockSaplings(String name)
    {
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.HOMIUM).withProperty(STAGE, Integer.valueOf(0)));
		setCreativeTab(Main.homodmaterials);
		
		type = name.replaceAll("_sapling", "").trim();
				
		BlockInit.BLOCK.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
    
    //Sapling Shape
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
    	return SAPLING_AABB;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
    {
    	return NULL_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) 
    {
    	return false;
    }
    
    //Variants
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for(EnumHandler.EnumType enumHandler$enumtype : EnumHandler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, enumHandler$enumtype.getMeta()));
		}
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
    
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
		i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});	
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "sapling_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}
	
	//Tree Code
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		boolean flag = false;
		int i = 0, j = 0;
		
		switch((EnumHandler.EnumType)state.getValue(VARIANT))
		{
		case HOMIUM:
			gen = new WorldGenHomiumTree();
			break;
		case ULTRAHOMIUM:
			//gen = new WorldGenUltraHomiumTree();
			break;
		}
		
		IBlockState iblockstate = Blocks.AIR.getDefaultState();
		if(flag)
		{
			world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
		}
		else
		{
			world.setBlockState(pos, iblockstate, 4);
		}
		
		if(!gen.generate(world, rand, pos.add(i, 0, j)))
		{
			if(flag)
			{
				world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
			}
			else
			{
				world.setBlockState(pos, iblockstate, 4);
			}
		}
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override
	protected boolean canSustainBush(IBlockState state) 
	{
		return state.getMaterial() == Material.GROUND || state.getMaterial() == Material.GRASS// || state.getMaterial() == Material.PLANTS
				
				;
	}
}
