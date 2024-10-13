package com.example.spacebees.Features;

import com.example.spacebees.bees.SpaceBeesModuleIds;
import com.example.spacebees.combs.ItemHoneyComb;
import com.example.spacebees.combs.SBEnumHoneyComb;

import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import forestry.modules.features.FeatureItem;
import forestry.apiculture.items.ItemHiveFrame;

@FeatureProvider
public class SpaceBeesApicultureItems {
	public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE); 
    public static final FeatureItemGroup<ItemHoneyComb, SBEnumHoneyComb> BEE_COMBS = REGISTRY.itemGroup(ItemHoneyComb::new, "bee_comb", SBEnumHoneyComb.VALUES);
    public static final FeatureItem<ItemHiveFrame> FRAME_AWESOME = REGISTRY.item(() -> new ItemHiveFrame(900, 0.2f), "frame_awesome");

}
