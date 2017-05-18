package com.rong.mineralistic.init;

import com.rong.mineralistic.blocks.BlockOreGravel;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final String gravelOreUnlocalisedName = "gravel_ore";
	public static final String sandOreUnlocalisedName = "sand_ore";
	
	public static Block gravelOre;
	public static Block sandOre; 
	
	public static final void init() {
		                 
        GameRegistry.registerBlock(gravelOre = new BlockOreGravel(Material.sand), gravelOreUnlocalisedName);
        GameRegistry.registerBlock(sandOre = new BlockOreGravel(Material.sand), sandOreUnlocalisedName);
    }
}
