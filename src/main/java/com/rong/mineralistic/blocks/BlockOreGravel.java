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

public class BlockOreGravel extends Block {
	
	private IIcon[] textures;

	//Constructor
	public BlockOreGravel() {
		super(Material.craftedSnow);
		this.setBlockName("gravel_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeGravel);
		
		setHarvestProperties("shovel", 1, 0);
	    setHarvestProperties("shovel", 1, 4);
		setHarvestProperties("shovel", 1, 5);
		setHarvestProperties("shovel", 1, 10);
		
		setHarvestProperties("shovel", 2, 1);
		setHarvestProperties("shovel", 2, 2);
		setHarvestProperties("shovel", 2, 3);
		setHarvestProperties("shovel", 2, 6);
		setHarvestProperties("shovel", 2, 7);
		setHarvestProperties("shovel", 2, 8);
		setHarvestProperties("shovel", 2, 9);
		setHarvestProperties("shovel", 2, 12);
		setHarvestProperties("shovel", 2, 14);
		
		setHarvestProperties("shovel", 3, 11);	
	}
	
	//For metadata, may need a BlockOreGravel2
	static final String[] gravelOreTypes = new String[] {
		"copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin", "iridium", "certusquartz", "zapquartz", "quartzite" 
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
    @SideOnly(Side.CLIENT) 
    @SuppressWarnings("unchecked") 
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < gravelOreTypes.length; i++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	public BlockOreGravel setHarvestProperties(String toolType, int level, int metadata){
		super.setHarvestLevel(toolType, level, metadata);
		return this;
	}

}

