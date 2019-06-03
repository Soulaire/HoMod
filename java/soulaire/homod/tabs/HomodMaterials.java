package soulaire.homod.tabs;

import soulaire.homod.init.BlockInit;
import soulaire.homod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class HomodMaterials extends CreativeTabs 
{
	public HomodMaterials(String name) {
		super("homodmaterials");
		this.setBackgroundImageName("tab.png");
	}
	
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ItemInit.HOMIUM);
	}

}