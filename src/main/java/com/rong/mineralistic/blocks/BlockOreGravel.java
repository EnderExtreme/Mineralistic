package com.rong.mineralistic.blocks;

import com.rong.mineralistic.OreManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockOreGravel extends BlockFalling implements IMetaLocalization {

    private int index;
    private IIcon[] textures;

    public BlockOreGravel(int index) {
        super(Material.craftedSnow);

        this.index = index;

        this.setBlockName(OreManager.gravelOre);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(5.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeGravel);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconReg) {
        this.textures = new IIcon[OreManager.getSubtypeCount(this.index)];

        for (int meta = 0; meta < this.textures.length; meta++) {
            textures[meta] = iconReg.registerIcon(OreManager.getTextureName(OreManager.gravelOre, this.index, meta));
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return meta >= 0 && meta < textures.length ? textures[meta] : textures[0];
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        OreManager.get(index, world.getBlockMetadata(x, y, z)).blockDisplayTick(world, x, y, z, random);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int meta = 0; meta < OreManager.getSubtypeCount(index); meta++) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return OreManager.get(index, world.getBlockMetadata(x, y, z)).lightValue();
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName() + "." + OreManager.get(index, meta).unlocalizedName();
    }
}
