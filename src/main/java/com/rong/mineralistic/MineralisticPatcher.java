package com.rong.mineralistic;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class MineralisticPatcher implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModContainerClass() {
		return "com.rong.mineralistic.Mineralistic";
	}

	@Override
	public String getSetupClass() {
		return "com.rong.mineralistic.handlers.fixes.PatchSetup";
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAccessTransformerClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
