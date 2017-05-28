package com.rong.mineralistic.handlers;

import com.rong.mineralistic.init.ModBlocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	//"coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin"
	
	public static void init() {
		//Gravel Ores
		OreDictionary.registerOre("oreCoal", new ItemStack(ModBlocks.gravelOre, 0, 0));
		OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.gravelOre, 1, 0));
		OreDictionary.registerOre("oreDiamond", new ItemStack(ModBlocks.gravelOre, 2, 0));
		OreDictionary.registerOre("oreEmerald", new ItemStack(ModBlocks.gravelOre, 3, 0));
		OreDictionary.registerOre("oreGold", new ItemStack(ModBlocks.gravelOre, 4, 0));
		OreDictionary.registerOre("oreIron", new ItemStack(ModBlocks.gravelOre, 5, 0));
		OreDictionary.registerOre("oreLapis", new ItemStack(ModBlocks.gravelOre, 6, 0));
		OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.gravelOre, 7, 0));
		OreDictionary.registerOre("oreNickel", new ItemStack(ModBlocks.gravelOre, 8, 0));
		OreDictionary.registerOre("oreRedstone", new ItemStack(ModBlocks.gravelOre, 9, 0));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.gravelOre, 10, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.gravelOre, 11, 0));
		
		//Sand Ores
		OreDictionary.registerOre("oreCoal", new ItemStack(ModBlocks.sandOre, 0, 0));
		OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.sandOre, 1, 0));
		OreDictionary.registerOre("oreDiamond", new ItemStack(ModBlocks.sandOre, 2, 0));
		OreDictionary.registerOre("oreEmerald", new ItemStack(ModBlocks.sandOre, 3, 0));
		OreDictionary.registerOre("oreGold", new ItemStack(ModBlocks.sandOre, 4, 0));
		OreDictionary.registerOre("oreIron", new ItemStack(ModBlocks.sandOre, 5, 0));
		OreDictionary.registerOre("oreLapis", new ItemStack(ModBlocks.sandOre, 6, 0));
		OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.sandOre, 7, 0));
		OreDictionary.registerOre("oreNickel", new ItemStack(ModBlocks.sandOre, 8, 0));
		OreDictionary.registerOre("oreRedstone", new ItemStack(ModBlocks.sandOre, 9, 0));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.sandOre, 10, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.sandOre, 11, 0));
	}
}
