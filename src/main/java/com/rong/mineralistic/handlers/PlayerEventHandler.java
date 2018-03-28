package com.rong.mineralistic.handlers;

import com.rong.mineralistic.damagesource.BlockBreakDamageSource;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class PlayerEventHandler {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void playerBlockPunchingDamage(/*PlayerInteractEvent event*/PlayerEvent.BreakSpeed event)
	{
		//if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
		//{
			EntityPlayer player = event.entityPlayer;
			int x = event.x;
			int y = event.y;
			int z = event.z;
			Block block = event.block;
			//Block block = event.world.getBlock(x, y, z);
			ItemStack itemstack = player.getCurrentEquippedItem();

			if (itemstack == null || itemstack.getItem().isItemTool(itemstack))
			{
				if (block == Blocks.log || block == Blocks.log2)
				{
					player.attackEntityFrom(BlockBreakDamageSource.dmgBreakBlockWithHand, 2.0F);
					event.newSpeed = 0.4F;
				}
			}
		//}
	}

}
