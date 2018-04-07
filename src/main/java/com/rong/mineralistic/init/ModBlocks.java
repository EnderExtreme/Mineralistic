package com.rong.mineralistic.init;

import com.rong.mineralistic.blocks.BlockDoneCharcoal;
import com.rong.mineralistic.blocks.BlockLogPile;
import com.rong.mineralistic.blocks.BlockOreGravelEnrichedNaquadah;
import com.rong.mineralistic.blocks.BlockOreGravelZapQuartz;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {

    public static final String gravelName = "gravel_ore";

	public static final String gravelOreUnlocalizedName = "gravel_ore";
	public static final String gravelOre2UnlocalizedName = "gravel_ore2";
	public static final String stoneOreUnlocalizedName = "stone_ore";

	public static BlockOreGravelZapQuartz oreZappy;
	public static BlockOreGravelEnrichedNaquadah oreENaquadah;
	
	public static Block logPile;
	public static Block doneCharcoal;
	
	public static final void init() {

		/*oreZappy = new BlockOreGravelZapQuartz(true);
		oreENaquadah = new BlockOreGravelEnrichedNaquadah(true);

        GameRegistry.registerBlock(oreZappy, gravelOreUnlocalizedName + "zapquartz");
        GameRegistry.registerBlock(oreENaquadah, gravelOreUnlocalizedName + "enrichednaquadah");*/
		
		logPile = new BlockLogPile();
		doneCharcoal = new BlockDoneCharcoal();
		
		GameRegistry.registerBlock(logPile, "log_pile");
		GameRegistry.registerBlock(doneCharcoal, "done_charcoal");	
    }
}
