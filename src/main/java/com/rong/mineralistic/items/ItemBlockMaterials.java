package com.rong.mineralistic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMaterials extends ItemBlock {
	
	static final String[] blockTypes = new String[] {
			"saltpeter", "sulfur"
		};

	public ItemBlockMaterials(Block blockItems) {
		super(blockItems);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= blockTypes.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "_" + blockTypes[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}
