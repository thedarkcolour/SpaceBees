package com.example.spacebees.Alveary.tile;

import com.example.spacebees.Features.SpaceBeesApicultureTiles;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyLighting extends TileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary>  {
    	private static final IBeeModifier LIGHTINGMODIFIER = new IBeeModifier() {
		@Override
		public boolean isSelfLighted() {
			return true;
		}
	};
    public TileAlvearyLighting(BlockEntityType<?> type, String translationKey, BlockPos pos, BlockState state) {
        super(type, "alveary_lighting", pos, state);
    }
	public TileAlvearyLighting(BlockPos pos, BlockState state) {
        super(SpaceBeesApicultureTiles.ALVEARY_LIGHTING.tileType(), "Alveary", pos, state);
    }


	@Override
	public IBeeModifier getBeeModifier() {
		return LIGHTINGMODIFIER;
	}
   }