package com.rong.mineralistic.blocks;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOreGravelZapQuartz extends BlockFalling {
	
	private Boolean isGlowing;

	public BlockOreGravelZapQuartz(boolean glowing) {
		super(Material.craftedSnow);
		this.setBlockName("gravel_ore_zapquartz");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(5.0F);
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
    public int tickRate(World worldObj) {
        return 30;
    }

	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldObj, int x, int y, int z, Random random) {
		if(isGlowing) {
            this.sparkle(worldObj, x, y, z);
        }
	}
	
	private void sparkle(World worldObj, int x, int y, int z) {
    }
	
	
	
}
