package com.rong.mineralistic.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;
import com.rong.mineralistic.items.ItemNuggets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockOreGravel extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreGravel() {
		super(Material.ground);
		this.setBlockName("gravel_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(7.0F);
		this.setStepSound(soundTypeGravel);
		
		//0=wood; 1=stone; 2=iron; 3=diamond
		this.setHarvestLevel("shovel", 1, 0);
		this.setHarvestLevel("shovel", 2, 1);
		this.setHarvestLevel("shovel", 2, 2);
		this.setHarvestLevel("shovel", 2, 3);
		this.setHarvestLevel("shovel", 1, 4);
		this.setHarvestLevel("shovel", 1, 5);
		this.setHarvestLevel("shovel", 2, 6);
		this.setHarvestLevel("shovel", 2, 7);
		this.setHarvestLevel("shovel", 2, 8);
		this.setHarvestLevel("shovel", 2, 9);
		this.setHarvestLevel("shovel", 1, 10);
	}
	
	//For metadata, may need a BlockOreGravel2
	static final String[] gravelOreTypes = new String[] {
		"copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
	};
	

	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[gravelOreTypes.length];
		
		for(int i = 0; i < gravelOreTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.gravelOreUnlocalizedName + "_" + gravelOreTypes[i]);
		}
	}
	
	public IIcon getIcon(int side, int meta) {
		if (meta > 0 && meta < gravelOreTypes.length) {
			
		}
		return textures[meta];
	}
	
	//Loop through all the blocks
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < gravelOreTypes.length; i++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public String getHarvestTool(int metadata)
    {
        return gravelOreTypes[metadata];
    }
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
}

