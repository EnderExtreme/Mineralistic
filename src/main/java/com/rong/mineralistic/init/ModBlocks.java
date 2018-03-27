package com.rong.mineralistic.init;

import com.rong.mineralistic.blocks.BlockOreGravel;
import com.rong.mineralistic.blocks.BlockOreGravel2;
import com.rong.mineralistic.blocks.BlockOreGravelEnrichedNaquadah;
import com.rong.mineralistic.blocks.BlockOreGravelZapQuartz;
import com.rong.mineralistic.items.ItemBlockOreGravel;
import com.rong.mineralistic.items.ItemBlockOreGravel2;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
	public static final String gravelOreUnlocalizedName = "gravel_ore";
	public static final String gravelOre2UnlocalizedName = "gravel_ore2";
	public static final String stoneOreUnlocalizedName = "stone_ore";
	
	public static BlockOreGravel gravelOre;
	public static BlockOreGravelZapQuartz oreZappy;
	public static BlockOreGravelEnrichedNaquadah oreENaquadah;
	public static BlockOreGravel2 gravelOre2;
	
	public static final void init() {
		
		gravelOre = new BlockOreGravel();
		gravelOre2 = new BlockOreGravel2();
		oreZappy = new BlockOreGravelZapQuartz(true);
		oreENaquadah = new BlockOreGravelEnrichedNaquadah(true);
		
        GameRegistry.registerBlock(gravelOre, ItemBlockOreGravel.class, gravelOreUnlocalizedName);
        GameRegistry.registerBlock(gravelOre2, ItemBlockOreGravel2.class, gravelOre2UnlocalizedName);
        
        GameRegistry.registerBlock(oreZappy, gravelOreUnlocalizedName + "zapquartz");
        GameRegistry.registerBlock(oreENaquadah, gravelOreUnlocalizedName + "enrichednaquadah");
    }
}
