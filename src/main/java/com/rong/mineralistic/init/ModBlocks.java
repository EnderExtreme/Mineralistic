package com.rong.mineralistic.init;

import com.rong.mineralistic.blocks.BlockOreGravel;
import com.rong.mineralistic.blocks.BlockOreGravelZapQuartz;
import com.rong.mineralistic.blocks.BlockOreStone1;
import com.rong.mineralistic.items.ItemBlockOreGravel;
import com.rong.mineralistic.items.ItemBlockOreStone1;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
	public static final String gravelOreUnlocalizedName = "gravel_ore";
	public static final String stoneOre1UnlocalizedName = "stone_ore1";
	
	public static BlockOreGravel gravelOre;
	public static BlockOreStone1 oreStone1;
	public static BlockOreGravelZapQuartz oreZappy;
	
	public static final void init() {
		gravelOre = new BlockOreGravel();
		oreStone1 = new BlockOreStone1();
		oreZappy = new BlockOreGravelZapQuartz(true);
		
        GameRegistry.registerBlock(gravelOre, ItemBlockOreGravel.class, gravelOreUnlocalizedName);
        GameRegistry.registerBlock(oreStone1, ItemBlockOreStone1.class, stoneOre1UnlocalizedName);
        
        GameRegistry.registerBlock(oreZappy, gravelOreUnlocalizedName + "zapquartz");
    }
}
