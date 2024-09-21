package com.example.spacebees.combs;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.data.loading.DatagenModLoader;

import forestry.api.core.ItemGroups;
import com.example.spacebees.combs.BlockHoneyComb;
import forestry.core.items.ItemBlockForestry;
import forestry.core.items.definitions.IColoredItem;

public class ItemBlockHoneyComb  extends ItemBlockForestry<BlockHoneyComb> implements IColoredItem {
	public ItemBlockHoneyComb(BlockHoneyComb block) {
		super(block, new Item.Properties().tab((block.type.isUnused() && !DatagenModLoader.isRunningDataGen()) ? null : ItemGroups.tabApiculture));
	}

	@Override
	public int getColorFromItemStack(ItemStack stack, int tintIndex) {
		SBEnumHoneyComb honeyComb = getBlock().getType();
		if (tintIndex == 1) {
			return honeyComb.primaryColor;
		} else {
			return honeyComb.secondaryColor;
		}
	}
}