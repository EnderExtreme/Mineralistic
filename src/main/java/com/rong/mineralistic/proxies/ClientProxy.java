package com.rong.mineralistic.proxies;

import com.rong.mineralistic.effects.EntityParticleBlueDustFX;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void spawnBlueDustFX(World world, double x, double y, double z) {
	    double dx = Minecraft.getMinecraft().renderViewEntity.posX - x;
	    double dy = Minecraft.getMinecraft().renderViewEntity.posY - y;
	    double dz = Minecraft.getMinecraft().renderViewEntity.posZ - z;
	    
	    if(dx*dx + dy*dy + dz*dz < 16.0 * 16.0) {
	            EntityFX fx = new EntityParticleBlueDustFX( world, x, y, z, 1.0f );
	            Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	        }
	    }
	
}
