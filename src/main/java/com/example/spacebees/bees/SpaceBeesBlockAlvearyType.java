package com.example.spacebees.bees;

import forestry.api.core.IBlockSubtype;

import java.util.Locale;

public enum SpaceBeesBlockAlvearyType implements IBlockSubtype {
    RAINSHIELD(false),
    LIGHTING(false);

    	public static final SpaceBeesBlockAlvearyType[] VALUES = values();


        public final boolean activatable;

        SpaceBeesBlockAlvearyType(boolean activatable) {
            this.activatable = activatable;
        }

    @Override
    public String getSerializedName() {
        return super.toString().toLowerCase(Locale.ENGLISH);
    }

}
