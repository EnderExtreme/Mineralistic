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

public class BlockOreSand extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreSand(Material material) {
		super(material);
		setBlockName("mineralistic.sand_ore");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("shovel", 1);
		setStepSound(soundTypeSand);
	}
	
	//For metadata, may need a BlockOreSand2
	static final String[] sandOreTypes = new String[] {
		"Diamond", "Gold", "Iron", "Redstone"
	};
	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[sandOreTypes.length];
		
		for(int i = 0; i < sandOreTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.sandOreUnlocalisedName);
		}
	}
	
	//This allows anyone who spawns in a block thats OoR in our metadata to not crash but receive metadata 0 of the block
	public IIcon getIcon(int side, int meta) {
		if(meta > sandOreTypes.length) {
			meta = 0;
		}
		return textures[meta];
	}
	
	//Loop through all the blocks
	public void getMetaBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < sandOreTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	//Self-explanatory
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
}
