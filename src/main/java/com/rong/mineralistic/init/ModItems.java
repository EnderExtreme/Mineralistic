package com.rong.mineralistic.init;

import com.rong.mineralistic.items.ItemIngots;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static String ingotsUnlocalizedName = "ingot";
	
	public static ItemIngots itemIngots;

	public static final void init() {
		
		itemIngots = new ItemIngots();
		
		GameRegistry.registerItem(itemIngots, ingotsUnlocalizedName);
	}
}
