package com.rong.mineralistic.items;

import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGravelFilter extends Item {

	public ItemGravelFilter() {

		super();
		maxStackSize = 1;
		setMaxDamage(15);
	}
	
	@Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
            return false;
    }
	
	@Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return stack.getItemDamage() < 16;
    }
	
	@Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
       ItemStack stack = itemStack.copy();
       stack.setItemDamage(stack.getItemDamage() + 1);
       stack.stackSize = 1;
       return stack;
    }
	
	
}
