package soulaire.homod.tabs;

import soulaire.homod.init.BlockInit;
import soulaire.homod.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class HomodBlocks extends CreativeTabs 
{
	public HomodBlocks(String name) {
		super("homodblocks");
		this.setBackgroundImageName("tab.png");
	}
	
	public ItemStack getTabIconItem()
	{
		return new ItemStack(BlockInit.HOMIUM_BLOCK);
	}

}