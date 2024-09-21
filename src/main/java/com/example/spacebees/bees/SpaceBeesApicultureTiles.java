package com.example.spacebees.bees;

import forestry.api.modules.ForestryModuleIds;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.apiculture.tiles.TileHive;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@SuppressWarnings("Convert2MethodRef")
@FeatureProvider
public class SpaceBeesApicultureTiles {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE);

	public static final FeatureTileType<TileHive> HIVE = REGISTRY.tile(TileHive::new, "hive", () -> SpaceBeesApicultureBlocks.BEEHIVE.getBlocks());
    
}
