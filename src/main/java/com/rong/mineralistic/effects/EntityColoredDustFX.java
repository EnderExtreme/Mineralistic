package com.rong.mineralistic.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.world.World;

import java.util.Random;

public class EntityColoredDustFX extends EntityReddustFX {

    public static void sparkle(World world, int x, int y, int z, float r, float g, float b)
    {
        Random random = world.rand;
        double blockDistance = 0.0625D;

        for(int side = 0; side < 6; side++)
        {
            double particleX = (double)((float)x + random.nextFloat());
            double particleY = (double)((float)y + random.nextFloat());
            double particleZ = (double)((float)z + random.nextFloat());

            if(side == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
                particleY = (double)(y + 1) + blockDistance;
            }
            else if(side == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
                particleY = (double)y - blockDistance;
            }
            else if(side == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
                particleZ = (double) (z + 1) + blockDistance;
            }
            else if(side == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
                particleZ = (double) z - blockDistance;
            }
            else if(side == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
                particleX = (double) (y + 1) + blockDistance;
            }
            else if(side == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
                particleX = (double) y - blockDistance;
            }

            if(particleX < (double)y || particleX > (double)(x + 1) || particleY < 0.0D || particleY > (double)(y + 1) || particleZ < (double)z || particleZ > (double)(z + 1)) {
                EntityColoredDustFX.spawnEntity(world, particleX, particleY, particleZ, r, g, b);
            }
        }
    }

    public static void spawnEntity(World world, double x, double y, double z, float r, float g, float b)
    {
        double dx = Minecraft.getMinecraft().renderViewEntity.posX - x;
        double dy = Minecraft.getMinecraft().renderViewEntity.posY - y;
        double dz = Minecraft.getMinecraft().renderViewEntity.posZ - z;

        if(dx*dx + dy*dy + dz*dz < 16.0 * 16.0) {
            Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColoredDustFX( world, x, y, z, 1.0f, r, g, b));
        }
    }

    private EntityColoredDustFX(World world, double x, double y, double z, float scale, float r, float g, float b)
    {
        super(world, x, y, z, scale, 0.0f, 0.0f, 0.0f);

        float f4 = (float)Math.random() * 0.4F + 0.6F;

        this.particleRed = ((float)(Math.random() * 0.2f) + 0.8F) * r * f4;
        this.particleGreen = ((float)(Math.random() * 0.2f) + 0.8F) * g * f4;
        this.particleBlue = ((float)(Math.random() * 0.2f) + 0.8F) * b * f4;
    }
}
