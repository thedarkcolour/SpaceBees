package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.VecUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

import java.util.Random;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;



public class AcidEffect extends ThrottledBeeEffect {
    private Random r = new Random ();
    public AcidEffect() {
        super(false, 100, true, false);
    }
    @SuppressWarnings("null")
    @Override
    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
        Level level = housing.getWorldObj();
        BlockPos housingCoords = housing.getCoordinates();
		Vec3i area = VecUtil.scale(genome.getActiveValue(BeeChromosomes.TERRITORY), 2);
        int range = area.getX() * 2;
        int radius = area.getX();
        while (true) {
            int xOffset = r.nextInt(range-0) - radius;
            int zOffset = r.nextInt(range-0) - radius;
            double actualDistance = Math.sqrt(xOffset * xOffset + zOffset * zOffset);
            if (actualDistance <= radius) {
                int mobX = housingCoords.getX() + xOffset;
                int mobZ = housingCoords.getZ() + zOffset;
                int groundY = level.getHeight(Heightmap.Types.WORLD_SURFACE, mobX, mobZ) - 1;
                BlockPos effected = new BlockPos(mobX, groundY, mobZ);
                BlockState state = level.getBlockState(effected);
                Block block = state.getBlock();


                    if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT){
                        BlockState sand = Blocks.SAND.defaultBlockState();
                        level.setBlockAndUpdate(effected, sand);

                    } else if (block == Blocks.COBBLESTONE || block == Blocks.STONE){
                        BlockState gravel = Blocks.GRAVEL.defaultBlockState();
                        level.setBlockAndUpdate(effected, gravel);                       
                    }
                
            }
            return storedData; 
        }
                
        
    }



}