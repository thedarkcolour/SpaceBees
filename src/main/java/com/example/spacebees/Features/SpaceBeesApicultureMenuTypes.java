package com.example.spacebees.Features;

import com.example.spacebees.Alveary.ContainerAlvearyMutator;
import com.example.spacebees.bees.SpaceBeesModuleIds;

import forestry.modules.features.FeatureMenuType;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class SpaceBeesApicultureMenuTypes {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE);
    public static final FeatureMenuType<ContainerAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.menuType(ContainerAlvearyMutator::fromNetwork, "alveary_mutator");

    
}
