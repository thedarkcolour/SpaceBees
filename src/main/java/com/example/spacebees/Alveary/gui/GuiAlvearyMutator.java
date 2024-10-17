package com.example.spacebees.Alveary.gui;

import net.minecraft.world.entity.player.Inventory;


import net.minecraft.network.chat.Component;
import com.example.spacebees.Alveary.ContainerAlvearyMutator;
import com.example.spacebees.Alveary.tile.TileAlvearyMutator;
import forestry.core.gui.GuiForestryTitled;
import com.example.spacebees.bees.SpaceBeesConstants;


public class GuiAlvearyMutator extends GuiForestryTitled<ContainerAlvearyMutator> {
    private final TileAlvearyMutator tile;

    public GuiAlvearyMutator(ContainerAlvearyMutator container, Inventory inventory, Component title) {
		super(SpaceBeesConstants.spacebees("textures/gui/guimutator.png"), container, inventory, title); 
		this.tile = container.getTile();

	}
    @Override
	protected void addLedgers() {
		addErrorLedger(tile);
	}
		
}
