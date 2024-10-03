package com.example.spacebees.bees;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyLighting extends TileAlveary implements IAlvearyComponent.BeeModifier {
    	private static final IBeeModifier MODIFIER = new IBeeModifier() {
		@Override
		public boolean isSelfLighted() {
			return true;
		}
	};
    public TileAlvearyLighting(BlockPos pos, BlockState state) {
        super(BlockAlvearyType.PLAIN, pos, state);
    }
	@Override
	public IBeeModifier getBeeModifier() {
		return MODIFIER;
	}
   }