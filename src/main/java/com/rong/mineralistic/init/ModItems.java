package com.rong.mineralistic.init;

import com.rong.mineralistic.items.ItemNuggets;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static final String nuggetsUnlocalizedName = "nugget";
	
	public static ItemNuggets nugget;
	
	public static final void init() {
		
		nugget = new ItemNuggets();
		
		GameRegistry.registerItem(nugget, nuggetsUnlocalizedName);
		
	}

}
