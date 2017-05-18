package com.rong.mineralistic.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class FurnaceSmeltingRecipes {
	
	public static void init(){
		
	GameRegistry.addSmelting(new ItemStack(ModBlocks.gravelOre, 0, 0), new ItemStack(Items.coal, 5), 3.5F);
	//GameRegistry.addSmelting(new ItemStack(ModBlocks.gravelOre, 1), new ItemStack(ModItems.copperNugget), 1.25F);
	GameRegistry.addSmelting(new ItemStack(ModBlocks.gravelOre, 0, 2), new ItemStack(Items.diamond, 1), 7.0F);
	GameRegistry.addSmelting(new ItemStack(ModBlocks.gravelOre, 0, 3), new ItemStack(Items.emerald, 1), 7.0F);
	GameRegistry.addSmelting(new ItemStack(ModBlocks.gravelOre, 0, 4), new ItemStack(Items.gold_nugget, 6), 7.0F);
	}
}
