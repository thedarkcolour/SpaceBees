package com.example.spacebees.bees;


import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

public class TileAlvearyRainShield extends TileAlveary implements IAlvearyComponent.BeeModifier {
	private static final Logger LOGGER = LogUtils.getLogger();
	private static final IBeeModifier MODIFIER = new IBeeModifier() {
		@Override
		public boolean isSealed() {
			LOGGER.info("IBeeModifier Modifier isSealed sent True"); //troubleshooting
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