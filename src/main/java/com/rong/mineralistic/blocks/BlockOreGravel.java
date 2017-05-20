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
		super(Material.sand);
		this.setBlockName("gravel_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(7.0F);
		//this.setHarvestLevel("shovel", 2);
		this.setHarvestLevel("pickaxe", 3);
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
	

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		//If copper gravel ore is mined, drops less than 7 copper nuggets
		if (metadata == 1) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 0));
		}
		
		//If diamond gravel ore is mined, drops less than 7 diamond nuggets. 40% Chance of dropping a whole diamond
		else if (metadata == 2) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 1));
			if (world.rand.nextFloat() < 0.4F)
		        drops.add(new ItemStack(Items.diamond));
		}
		
		//If emerald gravel ore is mined, drops less than 7 emerald nuggets. 40% Chance of dropping a whole emerald
		else if (metadata == 3) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 2));
			if (world.rand.nextFloat() < 0.4F)
		        drops.add(new ItemStack(Items.diamond));
		}
		
		//If gold gravel ore is mined, drops less than 7 gold nuggets. Chance of dropping a whole gold ingot
		else if (metadata == 4) {
			drops.add(new ItemStack(Items.gold_nugget, world.rand.nextInt(7)));
			drops.add(new ItemStack(Items.gold_ingot, world.rand.nextInt(1)));
		}
		
		//If iron gravel ore is mined, drops less than 7 iron nuggets
		else if (metadata == 5) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 3));
		}
		
		//If lapis gravel ore is mined, drops less than 8 lapis gems
		else if (metadata == 6) {
			drops.add(new ItemStack(Items.dye, world.rand.nextInt(9), 4));
		}
		
		//If lead gravel ore is mined, drops less than 7 lead nuggets
		else if (metadata == 7) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 4));
		}
		
		//If nickel gravel ore is mined, drops less than 7 nickel nuggets
		else if (metadata == 8) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 5));
		}
		
		//If redstone gravel ore is mined, drops less than 9 redstone dust
		else if (metadata == 9) {
			drops.add(new ItemStack(Items.redstone, world.rand.nextInt(9)));
		}
		
		//If silver gravel ore is mined, drops less than 7 silver nuggets
		else if (metadata == 10) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 6));
		}
		
		//If tin gravel ore is mined, drops less than 7 tin nuggets
		else if (metadata == 11) {
			drops.add(new ItemStack(ModItems.nugget, world.rand.nextInt(7), 7));
		}
		
        return drops;
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
}

