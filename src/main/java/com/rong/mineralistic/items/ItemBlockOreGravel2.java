package com.rong.mineralistic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreGravel2 extends ItemBlock {
	
	static final String[] gravelOreTypes = new String[] {
			"bauxite", "chromite", "calcite", "aluminium", "lazurite", "lepidolite", "naquadah", "titanium"
		};

	public ItemBlockOreGravel2(Block blockItems) {
		super(blockItems);
		this.setHasSubtypes(true);
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
