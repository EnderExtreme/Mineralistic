package com.rong.mineralistic.damagesource;

import net.minecraft.util.DamageSource;

public class BlockBreakDamageSource extends DamageSource {

	public static DamageSource dmgBreakBlockWithHand = new BlockBreakDamageSource("dmgBreakBlockWithHand");
	
	public BlockBreakDamageSource(String string) {
		super(string);
		setDamageBypassesArmor();
		setDamageIsAbsolute();
	}	

}
