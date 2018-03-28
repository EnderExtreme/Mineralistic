package com.rong.mineralistic;

import com.rong.mineralistic.blocks.BlockOreGravel;
import com.rong.mineralistic.items.ItemBlockMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreManager {

    public static final String gravelOre = "gravel_ore";

    private static List<OreType> oreTypes = new ArrayList<>(32);

    public static void add(String unlocalizedName, String oredictName, int harvestLevel) {
        oreTypes.add(new OreType(unlocalizedName, oredictName, harvestLevel));
    }

    public static void add(OreType type)
    {
        oreTypes.add(type);
    }

    public static OreType get(int index, int meta) {
        return oreTypes.get(16 * index + meta);
    }

    public static int getBlockCount() {
        return (oreTypes.size() + 15) / 16;
    }

    public static int getSubtypeCount(int index) {
        return index + 1 < getBlockCount() ? 16 : oreTypes.size() % 16;
    }

    public static void registerBlocks() {
        for (int index = 0; index < getBlockCount(); index++) {
            Block gravelOre = new BlockOreGravel(index);

            for (int meta = 0; meta < getSubtypeCount(index); meta++)
            {
                OreType oreType = OreManager.get(index, meta);

                gravelOre.setHarvestLevel("shovel", oreType.harvestLevel, meta);
                OreDictionary.registerOre("ore" + oreType.oredictName, new ItemStack(gravelOre, 1, meta));
            }

            GameRegistry.registerBlock(gravelOre, ItemBlockMeta.class, OreManager.gravelOre + index);
        }
    }

    public static String getTextureName(String name, int index, int meta) {
        return String.format("%s:%s.%s", Mineralistic.MODID, name, OreManager.get(index, meta).unlocalizedName());
    }

    public static class OreType {

        private String unlocalizedName;
        private String oredictName;
        private int harvestLevel;
        private int lightValue;

        public String unlocalizedName() {
            return unlocalizedName;
        }
        public int lightValue() { return lightValue; }

        public OreType(String unlocalizedName, String oredictName, int harvestLevel)
        {
            this.unlocalizedName = unlocalizedName;
            this.oredictName = oredictName;
            this.harvestLevel = harvestLevel;
        }

        public OreType(String unlocalizedName, String oredictName, int harvestLevel, int lightValue)
        {
            this(unlocalizedName, oredictName, harvestLevel);

            this.lightValue = lightValue;
        }

        public void blockDisplayTick(World world, int x, int y, int z, Random random) {
        }
    }
}
