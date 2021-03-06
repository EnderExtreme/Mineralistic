package com.rong.mineralistic.handlers;

import com.rong.mineralistic.init.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeHandler {

	
	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintAxe), "FF ", "FS "," S ", 'F', Items.flint, 'S', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintAxe), " FF", " SF"," S ", 'F', Items.flint, 'S', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintPickaxe), "FFF", " S "," S ", 'F', Items.flint, 'S', Items.stick));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintShovel), " F ", " S "," S ", 'F', Items.flint, 'S', Items.stick));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintHoe), "FF ", " S "," S ", 'F', Items.flint, 'S', Items.stick));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintHoe), " FF", " S "," S ", 'F', Items.flint, 'S', Items.stick));
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.flintSword), " F ", " S "," S ", 'F', Items.flint, 'S', Items.stick));
		
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.woodMesh), "SSS", "SSS", "SSS", 'S', "stickWood"));
		//GameRegistry.addRecipe(new ItemStack(ModItems.gravelFilter, ));
		
		for(int i = 0; i <= 16; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.flint), new Object[] {new ItemStack(ModItems.gravelFilter, 1, i), Blocks.gravel});
		}
		
	}
}
