package com.rong.mineralistic.handlers;

import java.util.Random;

import com.rong.mineralistic.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod.Metadata;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator implements IWorldGenerator {

	//"copper", "diamond", "emerald", "gold", "iron", "lapis", "lead", "nickel", "redstone", "silver", "tin"
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		if (world.provider.dimensionId == 0) {
			generateOverworld(world, random, chunkX, chunkZ);
		}
	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		//Arguments: block, world, rand, x, z, minVein, maxVein, chance, minY, maxY, block to generate in
		generateOres(ModBlocks.gravelOre, 0, world, rand, x, z, 3, 7, 7, 40, 128, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 1, world, rand, x, z, 1, 6, 2, 4, 40, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 2, world, rand, x, z, 1, 6, 2, 4, 40, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 3, world, rand, x, z, 3, 7, 3, 10, 50, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 4, world, rand, x, z, 3, 7, 6, 45, 80, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 5, world, rand, x, z, 3, 7, 5, 0, 128, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 6, world, rand, x, z, 3, 7, 4, 20, 50, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 7, world, rand, x, z, 2, 4, 4, 10, 40, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 8, world, rand, x, z, 3, 7, 6, 0, 128, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 9, world, rand, x, z, 3, 7, 4, 20, 50, Blocks.stone);
		generateOres(ModBlocks.gravelOre, 10, world, rand, x, z, 3, 7, 7, 40, 64, Blocks.stone);
	}
	
	public void generateOres(Block block, int meta, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block blockToGenerateIn) {
		
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		
		WorldGenMinable generator = new WorldGenMinable(block, meta, veinSize, blockToGenerateIn);
		
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			
			generator.generate(world, random, xRand, yRand, zRand);
		}
	}
}
