package soulaire.homod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import soulaire.homod.init.RecipeInit;
import soulaire.homod.proxy.CommonProxy;
import soulaire.homod.tabs.HomodBlocks;
import soulaire.homod.tabs.HomodCombat;
import soulaire.homod.tabs.HomodMaterials;
import soulaire.homod.tabs.HomodTools;
import soulaire.homod.util.Reference;
import soulaire.homod.util.handlers.RegistryHandler;

@Mod (modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Main 
{
	
	public static final CreativeTabs homodmaterials = new HomodMaterials("homodmaterials");
	public static final CreativeTabs homodcombat = new HomodCombat("homodcombat");
	public static final CreativeTabs homodtools = new HomodTools("homodtools");
	public static final CreativeTabs homodblocks = new HomodBlocks("homodblocks");
	
    @Instance
    public static Main instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    
    
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
    	RegistryHandler.otherRegistries();
    }
    
    @EventHandler
    public static void Init(FMLInitializationEvent event)
    {
    	RecipeInit.init();
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
    	
    }

}
