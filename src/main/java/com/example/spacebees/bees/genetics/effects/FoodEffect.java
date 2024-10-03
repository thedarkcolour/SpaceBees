package com.example.spacebees.bees.genetics.effects;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;


import java.util.List;


import net.minecraft.world.entity.player.Player;


public class FoodEffect extends ThrottledBeeEffect {
    public FoodEffect() {
        super(false, 500, true, false);
    }
    @Override
    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
		List<Player> players = ThrottledBeeEffect.getEntitiesInRange(genome, housing, Player.class);

        for (Player player : players){
                    player.getFoodData().eat(2,0.2f);
                
                }

            return storedData;

                
        
    }



}