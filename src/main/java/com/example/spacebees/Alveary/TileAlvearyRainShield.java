package com.example.spacebees.Alveary;


import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import com.example.spacebees.Features.SpaceBeesApicultureTiles;

public class TileAlvearyRainShield extends TileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {
	private static final IBeeModifier RAINMODIFIER = new IBeeModifier() {
		@Override
		public boolean isSealed() {
			return true;
			
		}
	};
    public TileAlvearyRainShield(BlockEntityType<?> type, String translationKey, BlockPos pos, BlockState state) {
        super(type, "alveary_rainshield", pos, state);
		
    }
	public TileAlvearyRainShield(BlockPos pos, BlockState state) {
        super(SpaceBeesApicultureTiles.ALVEARY_RAINSHIELD.tileType(), "alveary_rainshield", pos, state);
		
    }
	@Override
	public IBeeModifier getBeeModifier() {
		return RAINMODIFIER;
	}

   }