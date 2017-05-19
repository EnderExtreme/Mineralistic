package com.rong.mineralistic;

import net.minecraft.init.Blocks;

import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;
import com.rong.mineralistic.proxies.CommonProxy;
import com.rong.mineralistic.recipes.FurnaceSmeltingRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Mineralistic.MODID, name = Mineralistic.NAME, version = Mineralistic.VERSION, acceptedMinecraftVersions = "[1.7.10]")

public class Mineralistic {
	
	public static final String CLIENT_PROXY = "com.rong.mineralistic.proxies.ClientProxy";
	public static final String COMMON_PROXY = "com.rong.mineralistic.proxies.CommonProxy";
	public static final String MODID = "mineralistic";
	public static final String NAME = "Mineralistic";
	public static final String VERSION = "1.2";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		
		ModBlocks.init();
		ModItems.init();
		FurnaceSmeltingRecipes.init();
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		
	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		
	}
}