package com.rong.mineralistic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreStone1 extends ItemBlock {
	
	static final String[] stoneOreTypes1 = new String[] {
			"beryllium", "titanium", "molybdenum", "palladium", "neodymium", "uranium238", "naquadah", "olivine", "lazurite", "almandine", "calcite"
	};

	public ItemBlockOreStone1(Block blockItems) {
		super(blockItems);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= stoneOreTypes1.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "_" + stoneOreTypes1[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}
