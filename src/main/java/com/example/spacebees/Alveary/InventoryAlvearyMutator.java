package com.example.spacebees.Alveary;

import com.example.spacebees.Alveary.tile.TileAlvearyMutator;

import forestry.core.inventory.InventoryAdapterTile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class InventoryAlvearyMutator extends InventoryAdapterTile<TileAlvearyMutator> {

    public InventoryAlvearyMutator (TileAlvearyMutator alvearyMutator) {
		super(alvearyMutator, 1, "Items"); 
	}

    @Override
	public boolean canSlotAccept(int slotIndex, ItemStack stack) {
		if (stack.is(Items.SOUL_SAND)){
			return true;
		} 
		if (stack.is(Items.ENDER_EYE)){
			return true;
		}
		if (stack.is(Items.ENDER_PEARL)){
			return true;
		}
		if (stack.is(Items.NETHER_STAR)){
			return true;
		}
		return false;
    }

}
