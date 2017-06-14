package com.rong.mineralistic.blocks;

import java.util.List;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOreStone1 extends Block {
	
	private IIcon[] textures;

	public BlockOreStone1() {
		super(Material.rock);
		this.setBlockName("stone_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 3, 0);
		this.setResistance(8.5F);
	}
	
	static final String[] stoneOreTypes1 = new String[] {
			"beryllium", "titanium", "molybdenum", "palladium", "neodymium", "uranium238", "naquadah", "olivine", "lazurite", "almandine", "calcite"
	};
	
	//Loops through all the blocks to register its texture
	@Override
	public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[stoneOreTypes1.length];
			
		for(int i = 0; i < stoneOreTypes1.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.stoneOreUnlocalizedName + "_" + stoneOreTypes1[i]);
		}
	}
		
	public IIcon getIcon(int side, int meta) {
		if (meta > 0 && meta < stoneOreTypes1.length) {
		}
		return textures[meta];
	}
		
		//Loop through all the blocks
	@Override
	@SideOnly(Side.CLIENT) 
	@SuppressWarnings("unchecked") 
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < stoneOreTypes1.length; i++) {
			list.add(new ItemStack(item, 0, i));
		}
	}
	
		
	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	public BlockOreStone1 setHarvestProperties(String toolType, int level, int metadata){
		super.setHarvestLevel(toolType, level, metadata);
		return this;
	}
}
