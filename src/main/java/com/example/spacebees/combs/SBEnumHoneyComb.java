package com.example.spacebees.combs;

import java.awt.Color;
import java.util.Locale;

import forestry.api.core.IBlockSubtype;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;

public enum SBEnumHoneyComb implements StringRepresentable, IItemSubtype, IBlockSubtype {

	BARREN(new Color(0x736c44), new Color(0xc2bea7)),
	WATER(new Color(2568911), new Color(7973065)),
	ROTTEN(new Color(4084257), new Color(11652233)),
	BONE(new Color(12895407), new Color(14606017)),
	OIL(new Color(394760), new Color(2894646)),
	COAL(new Color(10392696), new Color(3682590)),
	FUEL(new Color(10252096), new Color(16761856)),
	MILK(new Color(14145991), new Color(16777215)),
	FRUIT(new Color(8202548), new Color(14372706)),
	SEED(new Color(3428147), new Color(7457902)),
	ALCOHOL(new Color(4293921), new Color(14604622)),
	STONE(new Color(9211025), new Color(13027020)),
	REDSTONE(new Color(16422550), new Color(15077392)),
	RESIN(new Color(16762703), new Color(13208064)),
	IC2ENERGY(new Color(15332623), new Color(2143177)),
	IRON(new Color(3552564), new Color(11038808)),
	GOLD(new Color(3552564), new Color(15125515)),
	COPPER(new Color(3552564), new Color(13722376)),
	TIN(new Color(3552564), new Color(12431805)),
	SILVER(new Color(3552564), new Color(14408667)),
	URANIUM(new Color(2031360), new Color(4303667)),
	CLAY(new Color(7034426), new Color(11583702)),
	OLD(new Color(4535060), new Color(11769444)),
	FUNGAL(new Color(7234891), new Color(2856003)),
	CREOSOTE(new Color(10256652), new Color(12429911)),
	LATEX(new Color(5854529), new Color(11051653)),
	ACIDIC(new Color(3441987), new Color(1374014)),
	VENOMOUS(new Color(8198269), new Color(16724991)),
	SLIME(new Color(3884860), new Color(8442245)),
	BLAZE(new Color(16738816), new Color(16763904)),
	COFFEE(new Color(5519389), new Color(11763531)),
	GLACIAL(new Color(5146503), new Color(13366002)),
	SHADOW(new Color(0), new Color(3545141)),
	LEAD(new Color(3552564), new Color(10125468)),
	ZINC(new Color(3552564), new Color(15592447)),
	TITANIUM(new Color(3552564), new Color(11578083)),
	TUNGSTEN(new Color(3552564), new Color(1249812)),
	PLATINUM(new Color(3552564), new Color(10125468)),
	LAPIS(new Color(3552564), new Color(4009179)),
	/* Tech Reborn*/
	SODALITE(new Color(3552564), new Color(1396717)),
	PYRITE(new Color(3552564), new Color(14919481)),
	BAUXITE(new Color(3552564), new Color(10249472)),
	CINNABAR(new Color(3552564), new Color(4665867)),
	SPHALERITE(new Color(3552564), new Color(14406941)),
	/* Gems */
	EMERALD(new Color(3552564), new Color(1900291)),
	RUBY(new Color(3552564), new Color(14024704)),
	SAPPHIRE(new Color(3552564), new Color(673791)),
	DIAMOND(new Color(3552564), new Color(8371706)),
	/* Dyes */
	RED(new Color(13388876), new Color(16711680)),
	YELLOW(new Color(15066419), new Color(16768256)),
	BLUE(new Color(10072818), new Color(8959)),
	GREEN(new Color(6717235), new Color(39168)),
	BLACK(new Color(1644825), new Color(5723991)),
	WHITE(new Color(14079702), new Color(16777215)),
	BROWN(new Color(8349260), new Color(6042895)),
	ORANGE(new Color(15905331), new Color(16751872)),
	CYAN(new Color(5020082), new Color(65509)),
	PURPLE(new Color(11691749), new Color(11403519)),
	GRAY(new Color(5000268), new Color(12237498)),
	LIGHTBLUE(new Color(10072818), new Color(40447)),
	PINK(new Color(15905484), new Color(16744671)),
	LIMEGREEN(new Color(8375321), new Color(65288)),
	MAGENTA(new Color(15040472), new Color(16711884)),
	LIGHTGRAY(new Color(10066329), new Color(13224393)),
	NICKEL(new Color(3552564), new Color(16768764)),
	GLOWSTONE(new Color(10919006), new Color(14730249)),
	SALTPETER(new Color(10919006), new Color(14730249)),
	COMPOST(new Color(4338440), new Color(7036475)),
	SAWDUST(new Color(12561009), new Color(15913854)),
	CERTUS(new Color(13029631), new Color(3755363)),
	ENDERPEARL(new Color(3446662), new Color(206368)),
	YELLORIUM(new Color(2564173), new Color(14019840)),
	CYANITE(new Color(2564173), new Color(34541)),
	BLUTONIUM(new Color(2564173), new Color(1769702));

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
