package com.rong.mineralistic.handlers;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class OreGenerators implements IWorldGenerator {
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.dimensionId) {
	    case 0: //Overworld
	        break;
	    case -1: //Nether
	        break;
	    case 1: //End
	        break;
	    }
	}
	
	private WorldGenerator gravelOre;
	private WorldGenerator sandOre;

	public OreGenerators() {
	    this.gravelOre = new WorldGenMinable(null, 0);
	}

}
