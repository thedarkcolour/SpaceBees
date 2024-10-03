package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.VecUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

import java.util.Random;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;

public class SpawnSkeletonEffect extends ThrottledBeeEffect {
    private Random r = new Random ();
    public SpawnSkeletonEffect() {
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
                Skeleton skeleton = new Skeleton(EntityType.SKELETON, level);
                int mobX = housingCoords.getX() + xOffset;
                int mobZ = housingCoords.getZ() + zOffset;
                int groundY = level.getHeight(Heightmap.Types.WORLD_SURFACE, mobX, mobZ);
                skeleton.moveTo(mobX, groundY, mobZ,0,0); //TODO add random rotation
                level.addFreshEntity(skeleton);

            }
            return storedData; 
        }
                
        
    }



}