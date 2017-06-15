package com.rong.mineralistic.modcompat;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.rong.mineralistic.init.ModBlocks;
import com.rong.mineralistic.init.ModItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.objects.GT_FluidStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class TiCGregHandler {
	

	public static void TiCIMC() {
		
		float handleModifier = 0.5F;
		float bowDrawSpeed = 10F;
		
		if(Loader.isModLoaded("TConstruct") && Loader.isModLoaded("gregtech")) {
			
			GT_Log.out.println("GT_Mod: Loading TiC materials...");
	        GT_Log.ore.println("GT_Mod: Loading TiC materials...");
	        
			NBTTagCompound lithiumTag = new NBTTagCompound();
			
			NBTTagCompound ingotLithiumTag = new NBTTagCompound();
			(new ItemStack(ModItems.itemIngots, 0, 0)).writeToNBT(ingotLithiumTag);
			lithiumTag.setTag("Item", ingotLithiumTag);
			
			NBTTagCompound blockLithiumTag = new NBTTagCompound();
			(new ItemStack(ModBlocks.gravelOre, 0, 0)).writeToNBT(blockLithiumTag);
			lithiumTag.setTag("Block", blockLithiumTag);
			
			lithiumTag.setInteger("Id", 300);
			lithiumTag.setInteger("MaterialId", 300);
			lithiumTag.setInteger("Value", 2);
			lithiumTag.setString("Name", "Lithium");
			lithiumTag.setInteger("HarvestLevel", 2);
			lithiumTag.setInteger("Durability", Materials.Lithium.mDurability + 150);
			lithiumTag.setInteger("MiningSpeed", (int)Materials.Lithium.mToolSpeed * 5);
			lithiumTag.setInteger("Attack", (int)Materials.Lithium.mToolQuality * 2);
			lithiumTag.setFloat("HandleModifier", (Materials.Lithium.mToolQuality) - handleModifier);
			lithiumTag.setInteger("Color", (Materials.Lithium.getRGBA()[0] << 16) | Materials.Lithium.getRGBA()[1] << 8 | Materials.Lithium.getRGBA()[2]);
			lithiumTag.setInteger("Bow_DrawSpeed", (int)((Materials.Lithium.mToolQuality) * handleModifier));
			lithiumTag.setFloat("Bow_ProjectileSpeed", (Materials.Lithium.mToolQuality) - 0.5F);
			lithiumTag.setFloat("Projectile_Mass", (Materials.Lithium.mToolQuality / bowDrawSpeed));
			lithiumTag.setString("FluidName", "molten.lithium");
			
			for (ItemStack stack : OreDictionary.getOres("ingotLithium")) {
				
				NBTTagCompound ingotLithium = new NBTTagCompound();
				stack.writeToNBT(ingotLithium);
				lithiumTag.setTag("Item", ingotLithium);

			}
			
			new FluidStack(FluidRegistry.getFluid("molten.lithium"), 144).writeToNBT(lithiumTag);
			lithiumTag.setInteger("Temperature", Materials.Lithium.mMeltingPoint);	
			
			FMLInterModComms.sendMessage("TConstruct", "addMaterial", lithiumTag);
			FMLInterModComms.sendMessage("TConstruct", "addMaterialItem", lithiumTag);
			FMLInterModComms.sendMessage("TConstruct", "addPartCastingMaterial", lithiumTag);
			FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", lithiumTag);

		}
	}
}
