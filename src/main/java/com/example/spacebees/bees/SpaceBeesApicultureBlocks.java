package com.example.spacebees.bees;

import forestry.api.core.ItemGroups;
import com.example.spacebees.combs.BlockHoneyComb;
import com.example.spacebees.combs.SBEnumHoneyComb;
import com.example.spacebees.combs.ItemBlockHoneyComb;
import forestry.core.items.ItemBlockForestry;
import forestry.modules.features.FeatureBlockGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.Item;


@FeatureProvider
public class SpaceBeesApicultureBlocks {
    
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(SpaceBeesModuleIds.APICULTURE);
    @SuppressWarnings("null")
    public static final FeatureBlockGroup<BlockSpaceBeeHive, SpaceBeesBlockHiveType> BEEHIVE = REGISTRY.blockGroup(BlockSpaceBeeHive::new, SpaceBeesBlockHiveType.VALUES).itemWithType((block, type) -> new ItemBlockForestry<>(block, new Item.Properties().tab(ItemGroups.tabApiculture))).identifier("beehive").create();
    public static final FeatureBlockGroup<BlockHoneyComb, SBEnumHoneyComb> BEE_COMB = REGISTRY.blockGroup(BlockHoneyComb::new, SBEnumHoneyComb.VALUES).item(ItemBlockHoneyComb::new).identifier("block_bee_comb").create();

}
