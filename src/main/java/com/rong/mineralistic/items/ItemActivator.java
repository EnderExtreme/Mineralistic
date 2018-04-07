package com.rong.mineralistic.items;

import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.tileentities.TileEntityLogPile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;

public class ItemActivator extends Item {

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        if (entityItem.worldObj.getBlock((int) Math.floor(entityItem.posX), (int) Math.floor(entityItem.posY) - 1, (int) Math.floor(entityItem.posZ)) == ModBlocks.logPile) {
            int count = entityItem.getEntityData().getInteger("activatorCount");
            if (count > 160) {
                TileEntityLogPile te = (TileEntityLogPile) entityItem.worldObj.getTileEntity((int) Math.floor(entityItem.posX), (int) Math.floor(entityItem.posY) - 1, (int) Math.floor(entityItem.posZ));
                te.activateCharcoal();
                te.lightNeighbors();
                entityItem.setDead();

            } else {
                if (entityItem.worldObj.rand.nextInt(10) < 2)
                	entityItem.getEntityData().setInteger("activatorCount", count + 1);
                entityItem.worldObj.spawnParticle("lava", entityItem.posX, entityItem.posY, entityItem.posZ, - 0.5F + entityItem.worldObj.rand.nextFloat(), - 0.5F + entityItem.worldObj.rand.nextFloat(), - 0.5F + entityItem.worldObj.rand.nextFloat());
            }
        }
        return false;
    }

}