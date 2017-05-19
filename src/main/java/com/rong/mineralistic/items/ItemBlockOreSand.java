package com.rong.mineralistic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreSand extends ItemBlock {
	
	static final String[] sandOreTypes = new String[] {
			"coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
		};

	public ItemBlockOreSand(Block blockItems) {
		super(blockItems);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= sandOreTypes.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "_" + sandOreTypes[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}
