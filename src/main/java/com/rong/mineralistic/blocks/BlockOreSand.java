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
	public BlockOreSand() {
		super(Material.sand);
		this.setBlockName("sand_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("shovel", 1);
		this.setStepSound(soundTypeSand);
	}
	
	//For metadata, may need a BlockOreSand2
	static final String[] sandOreTypes = new String[] {
			"coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
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
	
	//Self-explanatory
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
}
