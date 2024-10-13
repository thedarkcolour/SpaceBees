package com.example.spacebees.Alveary;

import forestry.api.core.IBlockSubtype;
import forestry.modules.features.FeatureTileType;

import java.util.Locale;

import com.example.spacebees.Features.SpaceBeesApicultureTiles;

public enum SpaceBeesBlockAlvearyType implements IBlockSubtype {
    RAINSHIELD(false),
    LIGHTING(false),
    MUTATOR(true);

    	public static final SpaceBeesBlockAlvearyType[] VALUES = values();


        public final boolean activatable;

        SpaceBeesBlockAlvearyType(boolean activatable) {
            this.activatable = activatable;
        }

    @Override
    public String getSerializedName() {
        return super.toString().toLowerCase(Locale.ENGLISH);
    }
    public FeatureTileType<?> getTileType() {
		return switch (this) {
			case RAINSHIELD -> SpaceBeesApicultureTiles.ALVEARY_RAINSHIELD;
            case LIGHTING -> SpaceBeesApicultureTiles.ALVEARY_LIGHTING;
            case MUTATOR -> SpaceBeesApicultureTiles.ALVEARY_MUTATOR;

	};

}
}
