package com.example.spacebees.bees;

import forestry.apiculture.tiles.TileHive;

import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;


@FeatureProvider
public class SpaceBeesApicultureTiles {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE);
    public static final FeatureTileType<TileHive> HIVE = REGISTRY.tile(TileHive::new, "hive", () -> SpaceBeesApicultureBlocks.BEEHIVE.getBlocks());
    public static final FeatureTileType<TileAlvearyLighting> ALVEARY_LIGHTING = REGISTRY.tile(TileAlvearyLighting::new, "lighting", () -> SpaceBeesApicultureBlocks.ALVEARY.get(SpaceBeesBlockAlvearyType.LIGHTING).collect());
    public static final FeatureTileType<TileAlvearyRainShield> ALVEARY_RAINSHIELD = REGISTRY.tile(TileAlvearyRainShield::new, "rainshield", () -> SpaceBeesApicultureBlocks.ALVEARY.get(SpaceBeesBlockAlvearyType.RAINSHIELD).collect());



}
