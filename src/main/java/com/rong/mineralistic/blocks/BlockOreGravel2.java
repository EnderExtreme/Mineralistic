package com.rong.mineralistic.blocks;

import java.util.List;
import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreGravel2 extends BlockFalling {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreGravel2() {
		//super(Material.craftedSnow);
		this.setBlockName("gravel_ore2");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(5.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeGravel);
		
		setHarvestProperties("shovel", 2, 0);
		setHarvestProperties("shovel", 3, 1);
		setHarvestProperties("shovel", 2, 2);
		setHarvestProperties("shovel", 2, 3);
		setHarvestProperties("shovel", 1, 4);
		setHarvestProperties("shovel", 1, 5);
		setHarvestProperties("shovel", 3, 6);
		setHarvestProperties("shovel", 3, 7);
		
			
	}
	
	static final String[] gravelOreTypes = new String[] {
		"bauxite", "chromite", "calcite", "aluminium", "lazurite", "lepidolite", "naquadah", "titanium"
	};
	
	
	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[gravelOreTypes.length];
		
		for(int i = 0; i < gravelOreTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.gravelOre2UnlocalizedName + "_" + gravelOreTypes[i]);
		}
	}
	
	public IIcon getIcon(int side, int meta) {
		if (meta > 0 && meta < gravelOreTypes.length) {
		}
		return textures[meta];
	}
	
	//Loop through all the blocks
    @Override 
    @SideOnly(Side.CLIENT) 
    @SuppressWarnings("unchecked") 
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < gravelOreTypes.length; i++) {
	        list.add(new ItemStack(item, 0, i));
	    }
	}
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	public BlockOreGravel2 setHarvestProperties(String toolType, int level, int metadata){
		super.setHarvestLevel(toolType, level, metadata);
		return this;
	}

}

