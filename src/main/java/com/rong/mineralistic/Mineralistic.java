package com.rong.mineralistic;

import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.EventBus;

import com.rong.mineralistic.effects.EntityColoredDustFX;
import com.rong.mineralistic.handlers.OreDictHandler;
import com.rong.mineralistic.handlers.RecipeHandler;
import com.rong.mineralistic.handlers.fixes.TEAnvilPatchHandler;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;
import com.rong.mineralistic.proxies.CommonProxy;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

@Mod(modid = Mineralistic.MODID, name = Mineralistic.NAME, version = Mineralistic.VERSION, acceptedMinecraftVersions = "[1.7.10]", dependencies="after:*")
public class Mineralistic extends DummyModContainer {
	
	public static final String CLIENT_PROXY = "com.rong.mineralistic.proxies.ClientProxy";
	public static final String COMMON_PROXY = "com.rong.mineralistic.proxies.CommonProxy";
	public static final String MODID = "mineralistic";
	public static final String NAME = "Mineralistic";
	public static final String VERSION = "2.0";

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
		OreManager.add("copper","Copper", 1);
        OreManager.add("diamond","Diamond", 2);
        OreManager.add("emerald","Emerald", 2);
        OreManager.add("gold","Gold", 2);
        OreManager.add("iron","Iron", 1);
        OreManager.add("lapis","Lapis", 1);
        OreManager.add("lead","Lead", 2);
        OreManager.add("nickel","Nickel", 2);
        OreManager.add("redstone","Redstone", 2);
        OreManager.add("silver","Silver", 2);
        OreManager.add("tin","Tin", 1);
        OreManager.add("iridium", "Iridium", 3);
        OreManager.add("certus_quartz","CertusQuartz", 2);
        OreManager.add("quartzite","Quartzite", 2);
        OreManager.add("ilmenite","Ilmenite", 2);
        OreManager.add("bauxite","Bauxite", 2);
        OreManager.add("chromite","Chromite", 3);
        OreManager.add("calcite","Calcite", 2);
        OreManager.add("aluminium","Aluminium", 2);
        OreManager.add("lazurite","Lazurite", 1);
        OreManager.add("lepidolite","Lepidolite", 1);
        OreManager.add("naquadah","Naquadah", 3);
        OreManager.add("titanium","Titanium", 3);
        OreManager.add(new OreManager.OreType("charged_certus_quartz", "CertusQuartzCharged", 2, 3) {
            @Override
            public void blockDisplayTick(World world, int x, int y, int z, Random random) {
                EntityColoredDustFX.sparkle(world, x, y, z, 0.0F, 1.3F, 2.4F);
            }
        });
        OreManager.add(new OreManager.OreType("enriched_naquadah", "NaquadahEnriched", 3,3) {
            @Override
            public void blockDisplayTick(World world, int x, int y, int z, Random random) {
                EntityColoredDustFX.sparkle(world, x, y, z, 0.0F, 0.0F, 0.0F);
            }
        });

        OreManager.registerBlocks();

		ModBlocks.init();
		ModItems.init();
		CommonProxy.init();
		
		LanguageRegistry.instance().addStringLocalization("death.attack.dmgBreakBlockWithHand","%1$s was splintered into pieces");
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		
		//OreDictHandler.init();
		RecipeHandler.init();
		MinecraftForge.EVENT_BUS.register(new TEAnvilPatchHandler());

	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		
	}
	
	
	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}
}
