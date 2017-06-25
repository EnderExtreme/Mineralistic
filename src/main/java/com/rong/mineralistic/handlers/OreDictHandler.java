package com.rong.mineralistic.handlers;

import com.rong.mineralistic.init.ModBlocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	//"copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin"
	
	public static void init() {
		
		//OreDictionary.registerOre("oreTetrahedrite", new ItemStack(ModBlocks.gravelOre, 0, 0));
		OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.gravelOre, 0, 0));
		OreDictionary.registerOre("oreDiamond", new ItemStack(ModBlocks.gravelOre, 0, 1));
		OreDictionary.registerOre("oreEmerald", new ItemStack(ModBlocks.gravelOre, 0, 2));
		OreDictionary.registerOre("oreGold", new ItemStack(ModBlocks.gravelOre, 0, 3));
		OreDictionary.registerOre("oreIron", new ItemStack(ModBlocks.gravelOre, 0, 4));
		OreDictionary.registerOre("oreLapis", new ItemStack(ModBlocks.gravelOre, 0, 5));
		OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.gravelOre, 0, 6));
		OreDictionary.registerOre("oreNickel", new ItemStack(ModBlocks.gravelOre, 0, 7));
		OreDictionary.registerOre("oreRedstone", new ItemStack(ModBlocks.gravelOre, 0, 8));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.gravelOre, 0, 9));
		//OreDictionary.registerOre("oreCassiterite", new ItemStack(ModBlocks.gravelOre, 0, 10));
		OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.gravelOre, 0, 10));
		OreDictionary.registerOre("oreIridium", new ItemStack(ModBlocks.gravelOre, 0, 11));
		OreDictionary.registerOre("oreCertusQuartz", new ItemStack(ModBlocks.gravelOre, 0, 12));
		OreDictionary.registerOre("oreQuartzite", new ItemStack(ModBlocks.gravelOre, 0, 13));
		OreDictionary.registerOre("oreLigniteCoal", new ItemStack(ModBlocks.gravelOre, 0, 14));

		
		
	
	}
}
