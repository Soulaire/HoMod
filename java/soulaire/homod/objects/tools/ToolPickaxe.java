package soulaire.homod.objects.tools;

import soulaire.homod.init.ItemInit;
import soulaire.homod.util.interfaces.IHasModel;
import net.minecraft.item.ItemPickaxe;
import soulaire.homod.Main;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
	public ToolPickaxe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.homodtools);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
