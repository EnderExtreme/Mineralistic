package com.rong.mineralistic.handlers.fixes;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.AnvilUpdateEvent;

public class TEAnvilPatchHandler {
	
	/* Patch for the meantime, couldn't care less.
	 * This fixes a potentially balance/game breaking bug.
	 * Upon 'repairing' things in the anvil, such as repairing something that merely has metadata in TE, such as casings and such. 
	 * Whilst requiring a lot of levels, they can be repaired to their creative block/item variant.
	 */
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onAnvilCraft(AnvilUpdateEvent event) {
		if (event.right.getItem().getClass().getName().startsWith("cofh.thermalexpansion")) {
			event.setCanceled(true);
		}
	}

}
