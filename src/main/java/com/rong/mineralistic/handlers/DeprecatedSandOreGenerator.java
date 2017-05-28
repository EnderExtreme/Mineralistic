package com.rong.mineralistic.handlers;

import java.util.Random;

import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeprecatedSandOreGenerator implements IWorldGenerator {
	
	private int genDim = 0;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		genDim = world.provider.dimensionId;

		int chunk2X = chunkX << 4;
		int chunk2Z = chunkZ << 4;
		
		int count = 100;
		
		int coalRarity = 40;
		int copperRarity = 25;
		int diamondRarity = 3;
		int emeraldRarity = 4;
		int goldRarity = 11;

		//Coal Generation
		//if ((genDim != 1 && genDim != -1))
		if (genDim == 0) {
			for (int i = 0; i < count; i++) {
				int PosX = chunk2X + random.nextInt(16);
				int PosY = 55 + random.nextInt(10);
				int PosZ = chunk2Z + random.nextInt(16);

				if (world.getBlock(PosX, PosY + 1, PosZ).getMaterial() == Material.water && (world.getBlock(PosX, PosY, PosZ) == Blocks.sand || world.getBlock(PosX, PosY, PosZ) == Blocks.dirt)) {
					if (world.rand.nextInt(100) < coalRarity) {
						world.setBlock(PosX, PosY, PosZ, ModBlocks.sandOre, 0, 0);
					}
				}
			}
		}
		
		//Copper Generation
		if (genDim == 0) {
			for (int i = 0; i < count; i++) {
				int PosX = chunk2X + random.nextInt(16);
				int PosY = 55 + random.nextInt(10);
				int PosZ = chunk2Z + random.nextInt(16);

				if (world.getBlock(PosX, PosY + 1, PosZ).getMaterial() == Material.water && (world.getBlock(PosX, PosY, PosZ) == Blocks.sand || world.getBlock(PosX, PosY, PosZ) == Blocks.dirt)) {
					if (world.rand.nextInt(100) < copperRarity) {
						world.setBlock(PosX, PosY, PosZ, ModBlocks.sandOre, 1, 0);
						/*if (random.nextInt(1) < 4) {
							world.setBlock(PosX + 1, PosY - 1, PosZ, ModBlocks.sandOre, 1, 0);
						}
						if (random.nextInt(1) < 4) {
							world.setBlock(PosX, PosY, PosZ + 1, ModBlocks.sandOre, 1, 0);
						}*/
					}
				}
			}
		}
	}
}
