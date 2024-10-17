package com.example.spacebees.Features;

import com.example.spacebees.Alveary.BlockSpaceBeesAlveary;
import com.example.spacebees.Alveary.SpaceBeesBlockAlvearyType;
import com.example.spacebees.Alveary.tile.TileAlvearyMutator;
import com.example.spacebees.Alveary.tile.TileAlvearyLighting;
import com.example.spacebees.Alveary.tile.TileAlvearyRainShield;
import com.example.spacebees.bees.SpaceBeesModuleIds;

import forestry.apiculture.tiles.TileHive;

import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;


@FeatureProvider
public class SpaceBeesApicultureTiles {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE);
    public static final FeatureTileType<TileHive> HIVE = REGISTRY.tile(TileHive::new, "hive", () -> SpaceBeesApicultureBlocks.BEEHIVE.getBlocks());
    public static final FeatureTileType<TileAlvearyLighting> ALVEARY_LIGHTING = REGISTRY.tile(TileAlvearyLighting::new, "alveary_lighting", () -> SpaceBeesApicultureBlocks.ALVEARY.get(SpaceBeesBlockAlvearyType.LIGHTING).collect());
    public static final FeatureTileType<TileAlvearyRainShield> ALVEARY_RAINSHIELD = REGISTRY.tile(TileAlvearyRainShield::new, "alveary_rainshield", () -> SpaceBeesApicultureBlocks.ALVEARY.get(SpaceBeesBlockAlvearyType.RAINSHIELD).collect());
    public static final FeatureTileType<TileAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.tile(TileAlvearyMutator::new, "alveary_mutator", () -> SpaceBeesApicultureBlocks.ALVEARY.get(SpaceBeesBlockAlvearyType.MUTATOR).collect());



}
