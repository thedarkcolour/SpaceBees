package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import net.minecraft.core.BlockPos;

import java.util.Random;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;

public class MeteorEffect extends ThrottledBeeEffect {
    private static final Logger LOGGER = LogUtils.getLogger();
    private Random r = new Random ();

    public MeteorEffect() {
        super(false, 100, true, false);
    }
    @Override
    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
        Level level = housing.getWorldObj();
        BlockPos housingCoords = housing.getCoordinates();
        //TODO change range number to match territory attribute and use a vec3i
        int xOffset = r.nextInt(32-0) - 16;
        int zOffset = r.nextInt(32-0) - 16;

            SmallFireball smallFireball = new SmallFireball(level, housingCoords.getX() + xOffset, housingCoords.getY() + 64, housingCoords.getZ() + zOffset, 0, -0.6, 0);
            level.addFreshEntity(smallFireball);
            LOGGER.info("Spawning Fireball!");
                
        return storedData;
    }



}