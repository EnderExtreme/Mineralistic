package com.rong.mineralistic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreGravel extends ItemBlock {
	
	static final String[] gravelOreTypes = new String[] {
			"coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin" 
		};

	public ItemBlockOreGravel(Block blockItems) {
		super(blockItems);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= gravelOreTypes.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "_" + gravelOreTypes[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}
