package com.rong.mineralistic.blocks;

import java.util.List;
import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMaterials extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockMaterials() {
		super(Material.iron);
		this.setBlockName("block");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		
		setHarvestProperties("pickaxe", 0, 0);
	}
	
	static final String[] blockTypes = new String[] {
		"saltpeter", "sulfur"
	};
	
	
	
	//Loops through all the blocks to register its texture
	@Override
    public void registerBlockIcons(IIconRegister iconReg) { 
		textures = new IIcon[blockTypes.length];
		
		for(int i = 0; i < blockTypes.length; i++) {
			textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModBlocks.blockUnlocalizedName + "_" + blockTypes[i]);
		}
	}
	
	public IIcon getIcon(int side, int meta) {
		if (meta > 0 && meta < blockTypes.length) {
		}
		return textures[meta];
	}
	
	//Loop through all the blocks
    @Override 
    @SideOnly(Side.CLIENT) 
    @SuppressWarnings("unchecked") 
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < blockTypes.length; i++) {
	        list.add(new ItemStack(item, 0, i));
	    }
	}
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	public BlockMaterials setHarvestProperties(String toolType, int level, int metadata){
		super.setHarvestLevel(toolType, level, metadata);
		return this;
	}

}

