package com.example.spacebees.bees;
import java.util.Locale;
import forestry.api.core.IBlockSubtype;
import net.minecraft.resources.ResourceLocation;


public enum SpaceBeesBlockHiveType implements IBlockSubtype {
	LUNA(SpaceBeesSpecies.LUNA);

	public static final SpaceBeesBlockHiveType[] VALUES = values();

	private final ResourceLocation speciesUid;

	SpaceBeesBlockHiveType(ResourceLocation speciesUid) {
		this.speciesUid = speciesUid;
	}

	public ResourceLocation getSpeciesId() {
		return this.speciesUid;
	}

	@Override
	public String getSerializedName() {
		return name().toLowerCase(Locale.ENGLISH);
	}

	public int getMeta() {
		return ordinal();
	}
}    
