package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.VecUtil;
import net.minecraft.core.Vec3i;

import java.util.List;


import java.util.Random;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BossEffect extends ThrottledBeeEffect {
    private Random r = new Random ();
    public BossEffect() {
        super(false, 500, true, false);
    }
    @SuppressWarnings("null")
    @Override
    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
		List<LivingEntity> entities = ThrottledBeeEffect.getEntitiesInRange(genome, housing, LivingEntity.class);

        Level level = housing.getWorldObj();
		Vec3i area = VecUtil.scale(genome.getActiveValue(BeeChromosomes.TERRITORY), 2);
        int range = area.getX() * 2;
        int radius = area.getX();
        int timingOffset = r.nextInt(96-64);
        while (true) {
            int xOffset = r.nextInt(range-0) - radius;
            int zOffset = r.nextInt(range-0) - radius;
            double actualDistance = Math.sqrt(xOffset * xOffset + zOffset * zOffset);
            if (actualDistance <= radius) {
                for (LivingEntity entity : entities){
                    Vec3 entityPos = entity.position();
                    //like meteor but targets the player
                    //TODO add vector math to make this shoot from the housing to the player directly like a ghast
                    SmallFireball smallFireball = new SmallFireball(level, entityPos.x, entityPos.y + timingOffset, entityPos.z, 0, -0.6, 0);
                    level.addFreshEntity(smallFireball);
                
                }
            }
            return storedData;
        }
                
        
    }



}