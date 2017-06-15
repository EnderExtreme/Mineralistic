package com.rong.mineralistic.init;

import com.rong.mineralistic.items.ItemIngots;
import com.rong.mineralistic.items.ItemPlates;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static String ingotsUnlocalizedName = "ingot";
	public static ItemIngots itemIngots;

	public static String platesUnlocalizedName = "plate";
	public static ItemPlates itemPlates;
	

	public static final void init() {
		
		itemIngots = new ItemIngots();
		itemPlates = new ItemPlates();
		
		GameRegistry.registerItem(itemIngots, ingotsUnlocalizedName);
		GameRegistry.registerItem(itemPlates, platesUnlocalizedName);
	}
}
