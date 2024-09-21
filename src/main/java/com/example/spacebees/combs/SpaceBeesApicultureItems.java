package com.example.spacebees.combs;

import com.example.spacebees.bees.SpaceBeesModuleIds;

import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;


@FeatureProvider
public class SpaceBeesApicultureItems {
	public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE); 
    public static final FeatureItemGroup<ItemHoneyComb, SBEnumHoneyComb> SBBEE_COMBS = REGISTRY.itemGroup(ItemHoneyComb::new, "bee_comb", SBEnumHoneyComb.VALUES);
}
