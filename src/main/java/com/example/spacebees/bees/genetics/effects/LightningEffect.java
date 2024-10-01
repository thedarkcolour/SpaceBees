package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.VecUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

import java.util.Random;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;

public class LightningEffect extends ThrottledBeeEffect {
    private static final Logger LOGGER = LogUtils.getLogger();
    private Random r = new Random ();
    public LightningEffect() {
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
                LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                int mobX = housingCoords.getX() + xOffset;
                int mobZ = housingCoords.getZ() + zOffset;
                int groundY = level.getHeight(Heightmap.Types.WORLD_SURFACE, mobX, mobZ);
                lightningBolt.moveTo(mobX, groundY, mobZ,0,0); //TODO add random rotation
                level.addFreshEntity(lightningBolt);
                LOGGER.info("Spawning Lightning Bolt!");
            }
            return storedData; 
        }
                
        
    }



}