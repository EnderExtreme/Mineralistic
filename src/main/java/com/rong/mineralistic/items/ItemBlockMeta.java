package com.rong.mineralistic.items;

import com.rong.mineralistic.blocks.IMetaLocalization;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends net.minecraft.item.ItemBlock {

    private IMetaLocalization block;

    public ItemBlockMeta(Block block) {
        super(block);

        this.setHasSubtypes(true);
        this.block = (IMetaLocalization) block;
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        return block.getUnlocalizedName(itemstack.getItemDamage());
    }

    public int getMetadata(int meta) {
        return meta;
    }
}
