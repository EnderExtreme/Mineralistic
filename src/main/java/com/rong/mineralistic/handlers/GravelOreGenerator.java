package com.rong.mineralistic.handlers;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class GravelOreGenerator implements IWorldGenerator {

	private int genDim;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		genDim = world.provider.dimensionId;
		
		
	}
	
	

}
