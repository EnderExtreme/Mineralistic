package com.rong.mineralistic;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.rong.mineralistic.handlers.OreDictHandler;
import com.rong.mineralistic.handlers.OreGenerator;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Mineralistic.MODID, name = Mineralistic.NAME, version = Mineralistic.VERSION, acceptedMinecraftVersions = "[1.7.10]", dependencies="after:*")

public class Mineralistic {
	
	public static final String CLIENT_PROXY = "com.rong.mineralistic.proxies.ClientProxy";
	public static final String COMMON_PROXY = "com.rong.mineralistic.proxies.CommonProxy";
	public static final String MODID = "mineralistic";
	public static final String NAME = "Mineralistic";
	public static final String VERSION = "1.7";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;
	
	public static void spawnBlueDustFX(World world, double x, double y, double z) {
		proxy.spawnBlueDustFX(world, x, y, z);
	}
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		
		ModBlocks.init();
		//TiCGregHandler.TiCIMC();
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		
		OreDictHandler.init();
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		
	}
	
	
}