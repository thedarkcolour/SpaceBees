package com.example.spacebees.Alveary;

import forestry.core.features.CoreItems;
import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.items.definitions.EnumCraftingMaterial;
import forestry.core.utils.ItemStackUtil;
import net.minecraft.world.item.ItemStack;

public class InventoryAlvearyMutator extends InventoryAdapterTile<TileAlvearyCreativeMutator> {

    public InventoryAlvearyMutator (TileAlvearyCreativeMutator alvearyMutator) {
		super(alvearyMutator, 1, "Items"); //changed to 5 to see if I can stop crashing, this causes the crash index X is out of bounds for length X
	}

    @Override
	public boolean canSlotAccept(int slotIndex, ItemStack stack) {
		return ItemStackUtil.isIdenticalItem(CoreItems.CRAFTING_MATERIALS.stack(EnumCraftingMaterial.WOVEN_SILK, 1), stack); //TODO change this to being correct
    }

}
