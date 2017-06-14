/*package com.rong.mineralistic.modcompat;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TiCGregHandler {
	
	float handleModifier = 0.5F;
	float bowDrawSpeed = 10F;

	public void TiCIMC() {
		
		if(Loader.isModLoaded("TConstruct") && Loader.isModLoaded("gregtech")) {
			
			GT_Log.out.println("GT_Mod: Loading TiC materials...");
	        GT_Log.ore.println("GT_Mod: Loading TiC materials...");
	        
			NBTTagCompound lithiumTag = new NBTTagCompound();
			NBTTagCompound itemLithiumTag = new NBTTagCompound();
			
			
			lithiumTag.setInteger("Id", 300);
			lithiumTag.setInteger("MaterialId", 300);
			lithiumTag.setInteger("Value", 2);
			lithiumTag.setString("Name", "Lithium");
			lithiumTag.setInteger("HarvestLevel", 2);
			lithiumTag.setInteger("Durability", Materials.Lithium.mDurability);
			lithiumTag.setInteger("MiningSpeed", (int)Materials.Lithium.mToolSpeed);
			lithiumTag.setInteger("Attack", (int)Materials.Lithium.mToolQuality);
			lithiumTag.setFloat("HandleModifier", (Materials.Lithium.mToolQuality) - handleModifier);
			lithiumTag.setInteger("Color", (Materials.Lithium.getRGBA()[0] << 16) | Materials.Lithium.getRGBA()[1] << 8 | Materials.Lithium.getRGBA()[2]);
			lithiumTag.setInteger("Bow_DrawSpeed", (int)((Materials.Lithium.mToolQuality) * handleModifier));
			lithiumTag.setFloat("Bow_ProjectileSpeed", (Materials.Lithium.mToolQuality) - 0.5F);
			lithiumTag.setFloat("Projectile_Mass", (Materials.Lithium.mToolQuality / bowDrawSpeed));
		
		}
	}
}*/
