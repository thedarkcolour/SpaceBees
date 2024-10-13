package com.example.spacebees.Alveary;

import com.example.spacebees.Features.SpaceBeesApicultureMenuTypes;

import forestry.core.gui.ContainerTile;
import forestry.core.gui.slots.SlotFiltered;
import forestry.core.tiles.TileUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class ContainerAlvearyMutator extends ContainerTile<TileAlvearyCreativeMutator>{
    
	public static ContainerAlvearyMutator fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
		TileAlvearyCreativeMutator tile = TileUtil.getTile(inv.player.level, data.readBlockPos(), TileAlvearyCreativeMutator.class);
		return new ContainerAlvearyMutator(windowId, inv, tile);
	}
    public ContainerAlvearyMutator(int windowId, Inventory player, TileAlvearyCreativeMutator tile) {
		super(windowId, SpaceBeesApicultureMenuTypes.ALVEARY_MUTATOR.menuType(), player, tile, 8, 87);
		this.addSlot(new SlotFiltered(tile, 0, 79, 52));
	}
}
