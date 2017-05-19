package com.rong.mineralistic.items;

import java.util.List;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemNuggets extends Item {
	
	public static final String[] nuggets = new String[] {
			"copper", "diamond", "emerald", "iron", "lead", "nickel", "silver", "tin" 
		};

	public ItemNuggets() {
        super();
        this.setUnlocalizedName("nugget");
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	private IIcon[] textures;
	
	public IIcon getIcon(int side, int meta) {
		if (meta > 0 && meta < nuggets.length) {
			
		}
		return textures[meta];
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > nuggets.length)
	        meta = 0;

	    return textures[meta];
	}
	
	@Override
	public void registerIcons(IIconRegister iconReg) {
		textures = new IIcon[nuggets.length];
		
	    for (int i = 0; i < nuggets.length; i++) {
	        textures[i] = iconReg.registerIcon(Mineralistic.MODID + ":" + ModItems.nuggetsUnlocalizedName + "_" + nuggets[i]);
	    }
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < nuggets.length; i++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= nuggets.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "_" + nuggets[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}
}