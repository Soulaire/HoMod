package soulaire.homod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import soulaire.homod.objects.armor.ArmorBase;
import soulaire.homod.objects.items.ItemBase;
import soulaire.homod.objects.tools.ToolAxe;
import soulaire.homod.objects.tools.ToolHoe;
import soulaire.homod.objects.tools.ToolPickaxe;
import soulaire.homod.objects.tools.ToolSpade;
import soulaire.homod.objects.tools.ToolSword;
import soulaire.homod.util.Reference;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_HOMIUM = EnumHelper.addToolMaterial("material_homium", 3, 2000, 12.0F, 4.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_HOMIUM = EnumHelper.addArmorMaterial("armor_material_homium", Reference.MOD_ID + ":homium", 115,
			new int[] {4, 9, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F);
	
	//Items
	public static final Item HOMIUM = new ItemBase("homium");
	public static final Item HOMIUM_STICK = new ItemBase("homium_stick");
	
	
	//Tools
	public static final ItemSword HOMIUM_SWORD = new ToolSword("homium_sword", MATERIAL_HOMIUM);
	public static final ItemSpade HOMIUM_SHOVEL = new ToolSpade("homium_shovel", MATERIAL_HOMIUM);
	public static final ItemPickaxe HOMIUM_PICKAXE = new ToolPickaxe("homium_pickaxe", MATERIAL_HOMIUM);
	public static final ItemAxe HOMIUM_AXE = new ToolAxe("homium_axe", MATERIAL_HOMIUM);
	public static final ItemHoe HOMIUM_HOE = new ToolHoe("homium_hoe", MATERIAL_HOMIUM);
	
	
	//Armor
	public static final Item HOMIUM_HELMET = new ArmorBase("homium_helmet", ARMOR_MATERIAL_HOMIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item HOMIUM_CHESTPLATE = new ArmorBase("homium_chestplate", ARMOR_MATERIAL_HOMIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item HOMIUM_LEGGINGS = new ArmorBase("homium_leggings", ARMOR_MATERIAL_HOMIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item HOMIUM_BOOTS = new ArmorBase("homium_boots", ARMOR_MATERIAL_HOMIUM, 1, EntityEquipmentSlot.FEET);
}
