package com.rong.mineralistic.proxies;

import com.rong.mineralistic.handlers.PlayerEventHandler;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	public static void init() {
		
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		
	}
	
	public void spawnBlueDustFX(World world, double x, double y, double z) {
	}

	public void spawnBlackDustFX(World world, double x, double y, double z) {
		
	}
}
