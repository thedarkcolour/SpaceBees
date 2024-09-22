package com.example.spacebees.combs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.data.loading.DatagenModLoader;

import forestry.api.core.ItemGroups;
import forestry.core.items.ItemForestry;
import forestry.core.items.definitions.IColoredItem;

public class ItemHoneyComb extends ItemForestry implements IColoredItem {
	private final SBEnumHoneyComb type;

	public ItemHoneyComb(SBEnumHoneyComb type) {
		super(new Item.Properties().tab((type.isUnused() && !DatagenModLoader.isRunningDataGen()) ? null : ItemGroups.tabApiculture));

		this.type = type;
	}

	public boolean isUnused() {
		return this.type.isUnused();
	}

	@Override
	public int getColorFromItemStack(ItemStack itemstack, int tintIndex) {
		SBEnumHoneyComb barrenComb = this.type;
		if (tintIndex == 1) {
			return barrenComb.primaryColor;
		} else {
			return barrenComb.secondaryColor;
		}
	}
}