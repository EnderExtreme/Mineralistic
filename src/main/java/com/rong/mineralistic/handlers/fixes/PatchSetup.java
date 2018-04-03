package com.rong.mineralistic.handlers.fixes;

import java.util.Map;
import cpw.mods.fml.relauncher.IFMLCallHook;

public class PatchSetup implements IFMLCallHook {
	
	private static boolean isInRuntime;

    @Override
    public void injectData(Map<String, Object> data) {
        
    	isInRuntime = (Boolean)data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public Void call() throws Exception {
        
    	return null;
    }

    public static boolean isInRuntime() {
        
    	return isInRuntime;
    }

}
