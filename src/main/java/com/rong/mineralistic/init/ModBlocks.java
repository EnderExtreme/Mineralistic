package com.rong.mineralistic.init;

import com.rong.mineralistic.blocks.BlockOreGravel;
import com.rong.mineralistic.blocks.BlockOreSand;
import com.rong.mineralistic.items.ItemBlockOreGravel;
import com.rong.mineralistic.items.ItemBlockOreSand;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
	public static final String gravelOreUnlocalizedName = "gravel_ore";
	public static final String sandOreUnlocalizedName = "sand_ore";
	
	public static BlockOreGravel gravelOre;
	public static BlockOreSand sandOre; 
	
	public static final void init() {
		//gravelOre = new BlockOreGravel();
		//sandOre = new BlockOreSand();
		
        GameRegistry.registerBlock(gravelOre, ItemBlockOreGravel.class, gravelOreUnlocalizedName);
        
        GameRegistry.registerBlock(sandOre, ItemBlockOreSand.class, sandOreUnlocalizedName);
    }
}
