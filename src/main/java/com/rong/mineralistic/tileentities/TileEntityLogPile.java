package com.rong.mineralistic.tileentities;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.vecmath.Vector3f;

import com.rong.mineralistic.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLogPile extends TileEntity {
	
    public boolean isOnFire;
    public int fireTimer;
    private static long time;
    public static final long HOUR_LENGTH = 1000;
    private Queue<Vector3f> blocksToBeSetOnFire;

    public TileEntityLogPile() {
        fireTimer = 100;
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        isOnFire = nbt.getBoolean("isOnFire");
        fireTimer = nbt.getInteger("fireTimer");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("isOnFire", isOnFire);
        nbt.setInteger("fireTimer", fireTimer);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    public void lightNeighbors() {
        if (!isOnFire)
            return;
        Block block;
        blocksToBeSetOnFire = new ArrayDeque<Vector3f>();

        block = worldObj.getBlock(xCoord + 1, yCoord, zCoord);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord + 1, yCoord, zCoord));

        block = worldObj.getBlock(xCoord - 1, yCoord, zCoord);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord - 1, yCoord, zCoord));

        block = worldObj.getBlock(xCoord, yCoord, zCoord + 1);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord, yCoord, zCoord + 1));

        block = worldObj.getBlock(xCoord, yCoord, zCoord - 1);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord, yCoord, zCoord - 1));

        block = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord, yCoord + 1, zCoord));

        block = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
        if (!isValidCharcoalPitCover(block))
            blocksToBeSetOnFire.add(new Vector3f(xCoord, yCoord - 1, zCoord));

        setOnFire(blocksToBeSetOnFire);
    }

    private void setOnFire(Queue<Vector3f> blocksOnFire) {
        while (blocksOnFire.size() > 0) {
            Vector3f blockOnFire = blocksOnFire.poll();
            if (worldObj.getBlock((int) blockOnFire.x, (int) blockOnFire.y, (int) blockOnFire.z) != Blocks.fire) {
                worldObj.setBlock((int) blockOnFire.x, (int) blockOnFire.y, (int) blockOnFire.z, Blocks.fire);
                worldObj.markBlockForUpdate((int) blockOnFire.x, (int) blockOnFire.y, (int) blockOnFire.z);
            }
        }
    }

    public void extinguishFire() {
        if (isOnFire) {
            if (worldObj.getBlock(xCoord + 1, yCoord, zCoord) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord + 1, yCoord, zCoord);
                worldObj.markBlockForUpdate(xCoord + 1, yCoord, zCoord);
            }
            if (worldObj.getBlock(xCoord - 1, yCoord, zCoord) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord - 1, yCoord, zCoord);
                worldObj.markBlockForUpdate(xCoord + 1, yCoord, zCoord);
            }
            if (worldObj.getBlock(xCoord, yCoord, zCoord + 1) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord, yCoord, zCoord + 1);
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord + 1);
            }
            if (worldObj.getBlock(xCoord, yCoord, zCoord - 1) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord + 1, yCoord, zCoord - 1);
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord - 1);
            }
            if (worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);
                worldObj.markBlockForUpdate(xCoord, yCoord + 1, zCoord);
            }
            if (worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire) {
                worldObj.setBlockToAir(xCoord, yCoord - 1, zCoord);
                worldObj.markBlockForUpdate(xCoord, yCoord - 1, zCoord);
            }
            isOnFire = false;
        }
    }

    public void activateCharcoal() {
        this.fireTimer = (int) getTotalHours();
        this.isOnFire = true;

        //Activate the adjacent log piles
        spreadFire(xCoord + 1, yCoord, zCoord); // East
        spreadFire(xCoord - 1, yCoord, zCoord); // West
        spreadFire(xCoord, yCoord + 1, zCoord); // Up
        spreadFire(xCoord, yCoord - 1, zCoord); // Down
        spreadFire(xCoord, yCoord, zCoord + 1); // South
        spreadFire(xCoord, yCoord, zCoord - 1); // North

        lightNeighbors();
    }

    private void spreadFire(int x, int y, int z) {
        if (worldObj.getBlock(x, y, z) == ModBlocks.logPile && worldObj.getTileEntity(x, y, z) instanceof TileEntityLogPile) {
            TileEntityLogPile te = (TileEntityLogPile) worldObj.getTileEntity(x, y, z);
            if (!te.isOnFire) {
                te.activateCharcoal();
            }
        }
    }

    public void createCharcoal(int x, int y, int z, boolean forceComplete) {
        if (worldObj.getBlock(x, y, z) == ModBlocks.logPile) {
            TileEntityLogPile te = (TileEntityLogPile) worldObj.getTileEntity(x, y, z);
            if (te.isOnFire && (te.fireTimer + 18.0F < getTotalHours() || forceComplete)) {
                worldObj.setBlock(x, y, z, ModBlocks.doneCharcoal, 1, 0x2);

                //Activate the surrounding log piles
                createCharcoal(x + 1, y, z, forceComplete);
                createCharcoal(x - 1, y, z, forceComplete);
                createCharcoal(x, y + 1, z, forceComplete);
                createCharcoal(x, y - 1, z, forceComplete);
                createCharcoal(x, y, z + 1, forceComplete);
                createCharcoal(x, y, z - 1, forceComplete);

                worldObj.notifyBlockOfNeighborChange(x, y, z, ModBlocks.doneCharcoal);
            }
        }
    }

    public static long getTotalHours() {
        return time / HOUR_LENGTH;
    }

    //Advertently, we invert these to submit in lightNeighbours, so false here means it will burn, true will not. Since this is 'IsValidCharcoalPitCover'.
    public static boolean isValidCharcoalPitCover(Block block) {
        //If it is log pile or anything that can burn (except log piles), return false.
        if (Blocks.fire.getFlammability(block) > 0 && block != ModBlocks.logPile)
            return false;
        //If it is any of these blocks below, return true.
        return block == ModBlocks.logPile ||
            block == Blocks.glass ||
            block == Blocks.stained_glass ||
            block == Blocks.iron_door ||
            block.isOpaqueCube();
        
    }
    
}