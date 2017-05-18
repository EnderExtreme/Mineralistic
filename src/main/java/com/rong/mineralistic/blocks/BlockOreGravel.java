package com.rong.mineralistic.blocks;

import java.util.ArrayList;
import java.util.List;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockOreGravel extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreGravel(Material material) {
		super(material);
		setBlockName("mineralistic.gravel_ore");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3.0F);
		setResistance(7.0F);
		setHarvestLevel("shovel", 2);
		setStepSound(soundTypeGravel);
	}
	
	//For metadata, may need a BlockOreGravel2
	static final String[] gravelOreTypes = new String[] {
		"Diamond", "Gold", "Iron", "Redstone"
	};
	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[gravelOreTypes.length];
		
		for(int i = 0; i < gravelOreTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.gravelOreUnlocalisedName);
		}
	}
	
	//This allows anyone who spawns in a block thats OoR in our metadata to not crash but receive metadata 0 of the block
	public IIcon getIcon(int side, int meta) {
		if(meta > gravelOreTypes.length) {
			meta = 0;
		}
		return textures[meta];
	}
	
	//Loop through all the blocks
	public void getMetaBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < gravelOreTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	//Self-explanatory
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
}
