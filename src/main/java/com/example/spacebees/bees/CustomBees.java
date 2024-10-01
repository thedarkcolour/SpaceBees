package com.example.spacebees.bees;

import java.util.List;
import java.util.function.Supplier;

import com.example.spacebees.combs.SBEnumHoneyComb;

import forestry.api.plugin.IForestryPlugin;
import forestry.apiculture.FlowerType;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiculture.genetics.effects.PotionBeeEffect;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import com.example.spacebees.combs.SpaceBeesApicultureItems;
import com.example.spacebees.bees.genetics.effects.*;
// Use Default Forestry Plugin as an example
// https://github.com/thedarkcolour/ForestryMC/blob/dev/1.19.x/src/main/java/forestry/plugin/DefaultForestryPlugin.java

public class CustomBees implements IForestryPlugin{
    
    public static final ResourceLocation ID = SpaceBeesConstants.spacebees("default");
    
    private static Supplier<List<ItemStack>> getHoneyComb(EnumHoneyComb type) {
		return () -> List.of(ApicultureItems.BEE_COMBS.stack(type));
	}
    private static Supplier<List<ItemStack>> getSBHoneyComb(SBEnumHoneyComb type) {
		return () -> List.of(SpaceBeesApicultureItems.BEE_COMBS.stack(type));
	}
    
    Supplier<List<ItemStack>> honeyComb = getHoneyComb(EnumHoneyComb.HONEY);
    Supplier<List<ItemStack>> SBhoneyComb = getSBHoneyComb(SBEnumHoneyComb.BARREN);

    @Override 
    public void registerApiculture(@SuppressWarnings("null") IApicultureRegistration apiculture){
        CustomBeeSpecies.register(apiculture);
        		apiculture.registerHive(SpaceBeesSpecies.LUNA, SpaceBeesHiveDefinition.LUNA)
               	    .addDrop(0.80, SpaceBeesSpecies.LUNA, SBhoneyComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);
                apiculture.registerHive(SpaceBeesSpecies.ROCK, SpaceBeesHiveDefinition.ROCK)
                    .addDrop(0.80, SpaceBeesSpecies.ROCK, SBhoneyComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);
                apiculture.registerHive(SpaceBeesSpecies.WATER, SpaceBeesHiveDefinition.WATER)
                    .addDrop(0.80, SpaceBeesSpecies.WATER, SBhoneyComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);
                apiculture.registerHive(SpaceBeesSpecies.MARBLE, SpaceBeesHiveDefinition.MARBLE)
                    .addDrop(0.80, SpaceBeesSpecies.MARBLE, SBhoneyComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);       
                apiculture.registerHive(SpaceBeesSpecies.EMBITTERED, SpaceBeesHiveDefinition.NETHER)
                    .addDrop(0.80, SpaceBeesSpecies.EMBITTERED, SBhoneyComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);           
                apiculture.registerFlowerType(SpaceBeesFlowerType.WATER, new FlowerType(SpaceBeesTags.Blocks.WATER_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.SUGAR, new FlowerType(SpaceBeesTags.Blocks.SUGAR_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.ROCK, new FlowerType(SpaceBeesTags.Blocks.ROCK_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.BOOK, new FlowerType(SpaceBeesTags.Blocks.BOOK_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.DEAD, new FlowerType(SpaceBeesTags.Blocks.DEAD_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.REDSTONE, new FlowerType(SpaceBeesTags.Blocks.REDSTONE_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.WOOD, new FlowerType(SpaceBeesTags.Blocks.WOOD_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.LEAVES, new FlowerType(SpaceBeesTags.Blocks.LEAVES_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.FRUIT, new FlowerType(SpaceBeesTags.Blocks.FRUIT_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.SAPLING, new FlowerType(SpaceBeesTags.Blocks.SAPLING_FLOWERS, true));
                apiculture.registerFlowerType(SpaceBeesFlowerType.MYSTICAL, new FlowerType(SpaceBeesTags.Blocks.MYSTICAL_FLOWERS, true));

                apiculture.registerBeeEffect(SpaceBeeEffects.LUNAR, new PotionBeeEffect(false, MobEffects.SLOW_FALLING, 1000));
                apiculture.registerBeeEffect(SpaceBeeEffects.LUNACY, new PotionBeeEffect(false, MobEffects.JUMP, 1000));
                apiculture.registerBeeEffect(SpaceBeeEffects.METEOR, new MeteorEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.SPAWN_ZOMBIE, new SpawnMobEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.SPAWN_SKELETON, new SpawnSkeletonEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.SPAWN_CREEPER, new SpawnCreeperEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.LIGHTNING, new LightningEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.ACID, new AcidEffect());
                apiculture.registerBeeEffect(SpaceBeeEffects.BOSS, new BossEffect());






    }       


    public ResourceLocation id() {
       return ID;
   }

}
