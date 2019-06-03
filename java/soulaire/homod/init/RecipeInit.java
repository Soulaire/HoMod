package soulaire.homod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeInit 
{
	public static void init()
	{
		GameRegistry.addSmelting(BlockInit.ORE_OVERWORLD, new ItemStack(ItemInit.HOMIUM, 1), 1.5F);
	}

}
