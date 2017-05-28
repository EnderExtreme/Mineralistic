package com.rong.mineralistic.blocks;

import java.util.ArrayList;
import java.util.List;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockOreSand extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreSand() {
		super(Material.ground);
		this.setBlockName("sand_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeSand);
		
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
	
	//For metadata, may need a BlockOreSand2
	static final String[] sandOreTypes = new String[] {
			"copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
		};
	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[sandOreTypes.length];
		
		for(int i = 0; i < sandOreTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.sandOreUnlocalizedName + "_" + sandOreTypes[i]);
		}
	}
	
	public IIcon getIcon(int side, int meta) {
		return textures[meta];
	}
	
	//Loop through all the blocks
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < sandOreTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public String getHarvestTool(int metadata)
    {
        return sandOreTypes[metadata];
    }
	
	//Self-explanatory
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
}
