package com.rong.mineralistic.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.items.ItemNuggets;

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
	public BlockOreGravel() {
		super(Material.sand);
		this.setBlockName("gravel_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(7.0F);
		this.setHarvestLevel("shovel", 2);
		this.setStepSound(soundTypeGravel);
	}
	
	//For metadata, may need a BlockOreGravel2
	static final String[] gravelOreTypes = new String[] {
		"coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
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
	
	//Self-explanatory
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(ItemNuggets.nuggets[1]));
		
		int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++)
        {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null)
            {
                drops.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }
        return drops;
	}
	
}

