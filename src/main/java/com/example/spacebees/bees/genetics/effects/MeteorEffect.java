package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.VecUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

import java.util.Random;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;

public class MeteorEffect extends ThrottledBeeEffect {
    private Random r = new Random ();
    public MeteorEffect() {
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
        int timingOffset = r.nextInt(96-64);
        while (true) {
            int xOffset = r.nextInt(range-0) - radius;
            int zOffset = r.nextInt(range-0) - radius;
            double actualDistance = Math.sqrt(xOffset * xOffset + zOffset * zOffset);
            if (actualDistance <= radius) {
                SmallFireball smallFireball = new SmallFireball(level, housingCoords.getX() + xOffset, housingCoords.getY() + timingOffset, housingCoords.getZ() + zOffset, 0, -0.6, 0);
                level.addFreshEntity(smallFireball);
            }
            return storedData;
        }
                
        
    }



}