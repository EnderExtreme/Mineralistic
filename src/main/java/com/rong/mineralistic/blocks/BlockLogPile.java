package com.rong.mineralistic.blocks;

import java.util.Random;

import com.rong.mineralistic.Mineralistic;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.tileentities.TileEntityLogPile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import static net.minecraftforge.common.util.ForgeDirection.UP;

public class BlockLogPile extends Block implements ITileEntityProvider {

    public BlockLogPile() {
        super(Material.wood);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3.0F);
        this.setResistance(3.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockTextureName(Mineralistic.MODID + ":" + "log_pile");
    }

    @Override
    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityLogPile) {
            if (((TileEntityLogPile) world.getTileEntity(x, y, z)).isOnFire)
                return true;
        }
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegisterer) {
        this.blockIcon = iconRegisterer.registerIcon(Mineralistic.MODID + ":" + "log_pile");
    }

    public void endLife(World world, int x, int y, int z) {
        if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityLogPile) {
            TileEntityLogPile te = (TileEntityLogPile) world.getTileEntity(x, y, z);
            world.removeTileEntity(x, y, z);
        }
    }

    @Override
    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemById(0);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
        endLife(world, i, j, k);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion ex) {
        endLife(world, x, y, z);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int i) {
        endLife(world, x, y, z);
    }

    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
        endLife(world, x, y, z);
        return world.setBlockToAir(x, y, z); // super.removedByPlayer is deprecated, and causes a loop.
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityLogPile();
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityLogPile) {
            ((TileEntityLogPile) world.getTileEntity(x, y, z)).lightNeighbors();
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityLogPile) {
            TileEntityLogPile te = (TileEntityLogPile) world.getTileEntity(x, y, z);

            if (te.isOnFire && te.fireTimer + 18.0F < TileEntityLogPile.getTotalHours()) {
                te.createCharcoal(x, y, z, true);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityLogPile && ((TileEntityLogPile) world.getTileEntity(x, y, z)).isOnFire) {
            double centerX = x + 0.5F;
            double centerY = y + 2F;
            double centerZ = z + 0.5F;
            //double d3 = 0.2199999988079071D;
            //double d4 = 0.27000001072883606D;
            world.spawnParticle("smoke", centerX + (rand.nextDouble() - 0.5), centerY, centerZ + (rand.nextDouble() - 0.5), 0.0D, 0.1D, 0.0D);
            world.spawnParticle("smoke", centerX + (rand.nextDouble() - 0.5), centerY, centerZ + (rand.nextDouble() - 0.5), 0.0D, 0.15D, 0.0D);
            world.spawnParticle("smoke", centerX + (rand.nextDouble() - 0.5), centerY - 1, centerZ + (rand.nextDouble() - 0.5), 0.0D, 0.1D, 0.0D);
            world.spawnParticle("smoke", centerX + (rand.nextDouble() - 0.5), centerY - 1, centerZ + (rand.nextDouble() - 0.5), 0.0D, 0.15D, 0.0D);
        }
    }
}