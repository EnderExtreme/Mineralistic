package com.rong.mineralistic.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.items.tools.ItemFlintShovel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockDoneCharcoal extends Block {
	
    public BlockDoneCharcoal() {
        super(Material.ground);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.4F);
        this.setResistance(0.9F);
        this.setStepSound(soundTypeGravel);
        this.setBlockTextureName(Mineralistic.MODID + ":" + "done_charcoal");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return blockIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegisterer) {
        this.blockIcon = iconRegisterer.registerIcon(Mineralistic.MODID + ":" + "charcoal_done");
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
        return false;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(Items.coal, world.rand.nextInt(3) + 1, 1));
        return drops;
    }

    /*@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
    	if(!world.isRemote)
    	{
    		if(world.isAirBlock(x, y - 1, z))
    		{
    			int meta = world.getBlockMetadata(x, y, z);
    			world.setBlock(x, y - 1, z, this, meta, 0x2);
    			world.setBlockToAir(x, y, z);
    		}
    	}
    }*/

    @Override
    public boolean canDropFromExplosion(Explosion ex) {
        return false;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        return null;
    }
}