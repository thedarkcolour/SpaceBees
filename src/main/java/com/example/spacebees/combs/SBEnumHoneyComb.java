package com.example.spacebees.combs;

import java.awt.Color;
import java.util.Locale;
import forestry.api.core.IBlockSubtype;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;

public enum SBEnumHoneyComb implements StringRepresentable, IItemSubtype, IBlockSubtype {
    BARREN(new Color(0x736c44), new Color(0xc2bea7)),
	WATER(new Color(2568911), new Color(7973065));

	public static final SBEnumHoneyComb[] VALUES = values();

	public final String name;
	public final int primaryColor;
	public final int secondaryColor;
	private final boolean unused;

	SBEnumHoneyComb(Color primary, Color secondary) {
		this(primary, secondary, false);
	}

	SBEnumHoneyComb(Color primary, Color secondary, boolean unused) {
		this.unused = unused;
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.primaryColor = primary.getRGB();
		this.secondaryColor = secondary.getRGB();
	}

	// todo remove unused combs in 1.20
	public boolean isUnused() {
		return this.unused;
	}

	@Override
	public String getSerializedName() {
		return name;
	}

	public static SBEnumHoneyComb get(int meta) {
		if (meta >= VALUES.length) {
			meta = 0;
		}
		return VALUES[meta];
	}
}
