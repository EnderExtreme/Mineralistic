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

public class ItemPlates extends Item {
	
	static final String[] plates = new String[] {
			"lithium"
		};
	public IIcon[] textures = new IIcon[plates.length];
	
	public ItemPlates(/*String unlocalizedName*/) {
        super();
        this.setHasSubtypes(true);
        this.setUnlocalizedName("plate");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < plates.length; i ++) {
	        this.textures[i] = reg.registerIcon(Mineralistic.MODID + ":" + ModItems.platesUnlocalizedName + "_" + plates[i]);
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > plates.length)
	        meta = 0;

	    return this.textures[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < plates.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}
