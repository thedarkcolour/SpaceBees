package com.example.spacebees.Alveary;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import forestry.core.gui.GuiForestryTitled;


public class GuiAlvearyMutator extends GuiForestryTitled<ContainerAlvearyMutator> {
    private final TileAlvearyCreativeMutator tile;

    public GuiAlvearyMutator(ContainerAlvearyMutator container, Inventory inventory, Component title) {
		super("textures/gui/guimutator.png", container, inventory, title);
		this.tile = container.getTile();
	}
    @Override
	protected void addLedgers() {
		addErrorLedger(tile);
	}
}
