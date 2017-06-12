package com.rong.mineralistic.effects;

import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.world.World;

public class EntityParticleBlueDustFX extends EntityReddustFX
{
    public EntityParticleBlueDustFX(World world, double par2, double par4, double par6, float par8 )
    {
        super(world, par2, par4, par6, par8, 0.0f, 0.0f, 0.0f);

        float f4 = (float)Math.random() * 0.4F + 0.6F;
        this.particleRed = ((float)(Math.random() * 0.2f) + 0.8F) * 0.0f * f4;
        this.particleGreen = ((float)(Math.random() * 0.2f) + 0.8F) * 1.3f * f4;
        this.particleBlue = ((float)(Math.random() * 0.2f) + 0.8F) * 2.4f * f4;
    }
}
