package com.rong.mineralistic.blocks;

import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.proxies.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockOreGravelZapQuartz extends Block {
	
	private Boolean isGlowing;

	public BlockOreGravelZapQuartz(boolean glowing) {
		super(Material.craftedSnow);
		this.setBlockName("gravel_ore_zapquartz");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeGravel);
		this.setBlockTextureName(Mineralistic.MODID + ":" + ModBlocks.gravelOreUnlocalizedName + "_" + "zapquartz");
		
		setHarvestProperties("shovel", 1);
		
		isGlowing = glowing;
		
		if(isGlowing) {
			this.setLightLevel(3F);
			this.setTickRandomly(true);
		}
	
	}

	public BlockOreGravelZapQuartz setHarvestProperties(String toolType, int level) {
		super.setHarvestLevel(toolType, level);
		return this;
	}
	
	@Override
    public int tickRate(World par1World)
    {
        return 30;
    }

	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldObj, int x, int y, int z, Random random) {
		if(isGlowing)
        {
            this.sparkle(worldObj, x, y, z);
        }
	}
	
	private void sparkle(World worldObj, int x, int y, int z) {
        if(!worldObj.isRemote) {
            return;
        }

        Random random = worldObj.rand;
        double d0 = 0.0625D;

        for(int l = 0; l < 6; ++l)
        {
            double d1 = (double)((float)x + random.nextFloat());
            double d2 = (double)((float)y + random.nextFloat());
            double d3 = (double)((float)z + random.nextFloat());

            if(l == 0 && !worldObj.getBlock(x, y + 1, z).isOpaqueCube()) {
                d2 = (double)(y + 1) + d0;
            }
            if(l == 1 && !worldObj.getBlock(x, y - 1, z).isOpaqueCube()) {           
                d2 = (double)(y + 0) - d0;
            }
            if(l == 2 && !worldObj.getBlock(x, y, z + 1).isOpaqueCube()) {
                d3 = (double) (z + 1) + d0;
            }
            if(l == 3 && !worldObj.getBlock(x, y, z - 1).isOpaqueCube()) {
                d3 = (double) (z + 0) - d0;
            }
            if(l == 4 && !worldObj.getBlock(x + 1, y, z).isOpaqueCube()) {
                d1 = (double) (y + 1) + d0;
            }

            if(l == 5 && !worldObj.getBlock(x - 1, y, z).isOpaqueCube()) {
                d1 = (double) (y + 0) - d0;
            }
            if(d1 < (double)y || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
                Mineralistic.spawnBlueDustFX(worldObj, d1, d2, d3);
            }
        }
    }
	
	
	
}
