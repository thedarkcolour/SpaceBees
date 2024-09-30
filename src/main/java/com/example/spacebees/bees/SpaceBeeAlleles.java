package com.example.spacebees.bees;

import forestry.api.IForestryApi;
import forestry.api.apiculture.IFlowerType;
import forestry.api.apiculture.genetics.IBeeEffect;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.IAlleleManager;
import forestry.api.genetics.alleles.IRegistryAllele;
import com.example.spacebees.bees.genetics.effects.*;


public class SpaceBeeAlleles {
    public static final IAlleleManager REGISTRY = IForestryApi.INSTANCE.getAlleleManager();
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_WATER = REGISTRY.registryAllele(SpaceBeesFlowerType.WATER, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_SUGAR = REGISTRY.registryAllele(SpaceBeesFlowerType.SUGAR, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_ROCK = REGISTRY.registryAllele(SpaceBeesFlowerType.ROCK, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_BOOK = REGISTRY.registryAllele(SpaceBeesFlowerType.BOOK, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_DEAD = REGISTRY.registryAllele(SpaceBeesFlowerType.DEAD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_REDSTONE = REGISTRY.registryAllele(SpaceBeesFlowerType.REDSTONE, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_WOOD = REGISTRY.registryAllele(SpaceBeesFlowerType.WOOD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_LEAVES = REGISTRY.registryAllele(SpaceBeesFlowerType.LEAVES, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_SAPLING = REGISTRY.registryAllele(SpaceBeesFlowerType.SAPLING, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_FRUIT = REGISTRY.registryAllele(SpaceBeesFlowerType.FRUIT, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_MYSTICAL = REGISTRY.registryAllele(SpaceBeesFlowerType.MYSTICAL, BeeChromosomes.FLOWER_TYPE);

    public static final IRegistryAllele<IBeeEffect> EFFECT_LUNAR = REGISTRY.registryAllele(SpaceBeeEffects.LUNAR, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_LUNACY = REGISTRY.registryAllele(SpaceBeeEffects.LUNACY, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_METEOR = REGISTRY.registryAllele(SpaceBeeEffects.METEOR, BeeChromosomes.EFFECT);





}
