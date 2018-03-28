package com.rong.mineralistic;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.rong.mineralistic.handlers.OreDictHandler;
import com.rong.mineralistic.handlers.RecipeHandler;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;
import com.rong.mineralistic.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Mineralistic.MODID, name = Mineralistic.NAME, version = Mineralistic.VERSION, acceptedMinecraftVersions = "[1.7.10]", dependencies="after:*")

public class Mineralistic {
	
	public static final String CLIENT_PROXY = "com.rong.mineralistic.proxies.ClientProxy";
	public static final String COMMON_PROXY = "com.rong.mineralistic.proxies.CommonProxy";
	public static final String MODID = "mineralistic";
	public static final String NAME = "Mineralistic";
	public static final String VERSION = "1.9";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;
	
	public static void spawnBlueDustFX(World world, double x, double y, double z) {
		proxy.spawnBlueDustFX(world, x, y, z);
	}
	
	public static void spawnBlackDustFX(World world, double x, double y, double z) {
		proxy.spawnBlackDustFX(world, x, y, z);
	}
	
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		
		ModBlocks.init();
		ModItems.init();
		CommonProxy.init();
		
		LanguageRegistry.instance().addStringLocalization("death.attack.dmgBreakBlockWithHand","%1$s was splintered into pieces");
		//LanguageRegistry.instance().addStringLocalization("death.attack.dmgBreakBlockWithHand","%1$s said Woodbye to the world");
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		
		OreDictHandler.init();
		RecipeHandler.init();

	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		
	}
	
	
}