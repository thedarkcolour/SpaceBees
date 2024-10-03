package com.example.spacebees.bees;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.climate.IClimateControlled;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyRainShield extends TileAlveary implements IAlvearyComponent.BeeModifier {
	
	private static final IBeeModifier MODIFIER = new IBeeModifier() {
		@Override
		public boolean isSealed() {
			return true;
		}
	};

	
    public TileAlvearyRainShield(BlockPos pos, BlockState state) {
        super(BlockAlvearyType.PLAIN, pos, state);
    }
	@Override
	public IBeeModifier getBeeModifier() {
		return MODIFIER;
	}


   }