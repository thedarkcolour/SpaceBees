package com.example.spacebees.bees;

import java.awt.Color;

import com.example.spacebees.combs.SBEnumHoneyComb;
import com.example.spacebees.combs.SpaceBeesApicultureItems;

import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.plugin.IApicultureRegistration;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.genetics.ForestryTaxa;


//  See DefaultBeeSpecies for examples
//  https://github.com/thedarkcolour/ForestryMC/blob/dev/1.19.x/src/main/java/forestry/plugin/DefaultBeeSpecies.java

public class CustomBeeSpecies {
    	@SuppressWarnings({ "CodeBlock2Expr", "deprecation" })
	public static void register(IApicultureRegistration apiculture) {
		// apiculture.registerSpecies(resource location, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_XXX, true?, new Color(0xa3999c))
		// Lunar
		apiculture.registerSpecies(SpaceBeesSpecies.LUNA, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LUNA, true, new Color(0xa3999c))
				.addProduct(forestry.apiculture.features.ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.20f)
				.addProduct(SpaceBeesApicultureItems.BEE_COMBS.stack(SBEnumHoneyComb.BARREN), 0.45f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
					genome.set(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_1);
					genome.set(BeeChromosomes.EFFECT, SpaceBeeAlleles.EFFECT_LUNAR);
				})
				.setAuthority("PantyRush");
					

		// Lunatic		
		apiculture.registerSpecies(SpaceBeesSpecies.LUNATIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LUNATIC, true, new Color(0xffffff))
				//.addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.30f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_NONE);
					genome.set(BeeChromosomes.EFFECT, SpaceBeeAlleles.EFFECT_LUNACY);
				})		
				.addMutations(mutations -> {
					mutations.add(SpaceBeesSpecies.LUNA, ForestryBeeSpecies.COMMON, 10);
				})
				.setGlint(true)
				.setAuthority("PantyRush");
		
		// Smedley
		apiculture.registerSpecies(SpaceBeesSpecies.SMEDLEY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SMEDLEY, true, new Color(0x4f10c4))
		//.addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.30f)
				.setBody(new Color(0x281e5c))
				.setStripes(new Color(0x9e7b3a))
				.setGenome(genome -> {
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_NONE);
				})		
				.addMutations(mutations -> {
					mutations.add(SpaceBeesSpecies.LUNA, ForestryBeeSpecies.INDUSTRIOUS, 10);
				})
				.setAuthority("PantyRush");


		//Binnie's 
		// https://github.com/ForestryMC/Binnie/blob/master-MC1.12/extrabees/src/main/java/binnie/extrabees/genetics/ExtraBeeDefinition.java
		//Barren Branch
		apiculture.registerSpecies(SpaceBeesSpecies.ARID, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ARID, true, new Color(0xbee854))
				.setBody(new Color(0xcbe374))
				.setTemperature(TemperatureType.HOT)
				.setHumidity(HumidityType.ARID)
				.addProduct(SpaceBeesApicultureItems.BEE_COMBS.stack(SBEnumHoneyComb.BARREN), 0.30f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
					genome.set(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_2);
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
					genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_2);
					genome.set(BeeChromosomes.FLOWER_TYPE, SpaceBeeAlleles.FLOWER_TYPE_DEAD);
					
			})		
				.addMutations(mutations -> {
					mutations.add(ForestryBeeSpecies.FOREST, ForestryBeeSpecies.FRUGAL, 10);
					mutations.add(ForestryBeeSpecies.MEADOWS, ForestryBeeSpecies.FRUGAL, 10);
				})
				
				.setAuthority("Binnie");
		
				
		//From ExtraBees, Work In Progress TODO: add correct allels 

		apiculture.registerSpecies(SpaceBeesSpecies.BARREN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BARREN, true, new Color(0xe0d263))
		.setBody(new Color(0xcbe374))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.DESOLATE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_DESOLATE, true, new Color(0xd1b890))
		.setBody(new Color(0xcbe374))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.DECOMPOSING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_DECOMPOSING, true, new Color(0x523711))
		.setBody(new Color(0xffffff))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GNAWING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GNAWING, true, new Color(0xe874b0))
		.setBody(new Color(0xcbe374))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ROTTEN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ROTTEN, true, new Color(0xbfe0b6))
		.setBody(new Color(0xcbe374))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BONE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BONE, true, new Color(0xe9ede8))
		.setBody(new Color(0xcbe374))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CREEPER, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CREEPER, true, new Color(0x2ce615))
		.setBody(new Color(0xcbe374))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ROCK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ROCK, true, new Color(0xa8a8a8))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.STONE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_STONE, true, new Color(0x757575))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GRANITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GRANITE, true, new Color(0x695555))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MINERAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MINERAL, true, new Color(0x6e757d))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.COPPER, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_COPPER, true, new Color(0xd16308))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.TIN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_TIN, true, new Color(0xbdb1bd))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.IRON, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_IRON, true, new Color(0xa87058))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LEAD, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LEAD, true, new Color(0xad8bab))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ZINC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ZINC, true, new Color(0xedebff))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.TITANIUM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_TITANIUM, true, new Color(0xb0aae3))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.TUNGSTATE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_TUNGSTATE, true, new Color(0x131214))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.NICKEL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_NICKEL, true, new Color(0xffdefc))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GOLD, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GOLD, true, new Color(0xe6cc0b))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SILVER, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SILVER, true, new Color(0x43455b))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PLATINUM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PLATINUM, true, new Color(0xdbdbdb))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LAPIS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LAPIS, true, new Color(0x3d2cdb))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SODALITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SODALITE, true, new Color(0x154fed))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PYRITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PYRITE, true, new Color(0xe3a739))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BAUXITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BAUXITE, true, new Color(0x9c6500))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CINNABAR, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CINNABAR, true, new Color(0x47320b))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SPHALERITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SPHALERITE, true, new Color(0xdbd51d))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.EMERALD, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_EMERALD, true, new Color(0x1cff03))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RUBY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RUBY, true, new Color(0xd60000))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SAPPHIRE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SAPPHIRE, true, new Color(0x0a47ff))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.DIAMOND, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_DIAMOND, true, new Color(0x7fbdfa))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.UNSTABLE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_UNSTABLE, true, new Color(0x3e8c34))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.NUCLEAR, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_NUCLEAR, true, new Color(0x41cc2f))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RADIOACTIVE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RADIOACTIVE, true, new Color(0x1eff00))
		.setBody(new Color(0x999999))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.YELLORIUM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_YELLORIUM, true, new Color(0xd5ed00))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CYANITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CYANITE, true, new Color(0x0086ed))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BLUTONIUM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BLUTONIUM, true, new Color(0x1b00e6))
		.setBody(new Color(0x999999))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ANCIENT, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ANCIENT, true, new Color(0xf2db8f))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PRIMEVAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PRIMEVAL, true, new Color(0xb3a67b))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PREHISTORIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PREHISTORIC, true, new Color(0x6e5a40))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RELIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RELIC, true, new Color(0x4d3e16))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.COAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_COAL, true, new Color(0x7a7648))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RESIN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RESIN, true, new Color(0xa6731b))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.OIL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_OIL, true, new Color(0x574770))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.DISTILLED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_DISTILLED, true, new Color(0x356356))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.FUEL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_FUEL, true, new Color(0xffc003))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CREOSOTE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CREOSOTE, true, new Color(0x979e13))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LATEX, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LATEX, true, new Color(0x494a3e))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.WATER, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_WATER, true, new Color(0x94a2ff))
		.setBody(new Color(0xffdc16))
		.setHumidity(HumidityType.DAMP)
		.addProduct(SpaceBeesApicultureItems.BEE_COMBS.stack(SBEnumHoneyComb.WATER), 0.30f)

		.setGenome(genome -> {
			genome.set(BeeChromosomes.FLOWER_TYPE, SpaceBeeAlleles.FLOWER_TYPE_WATER);
			genome.set(BeeChromosomes.TOLERATES_RAIN, true);
			genome.set(BeeChromosomes.SPEED, ForestryAlleles.SPEED_SLOWEST);
			genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_BOTH_1);

		})
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RIVER, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RIVER, true, new Color(0x83b3d4))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.OCEAN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_OCEAN, true, new Color(0x1d2ead))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.INK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_INK, true, new Color(0xe1447))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GROWING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GROWING, true, new Color(0x5bebd8))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.FARM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_FARM, true, new Color(0x75db60))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.THRIVING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_THRIVING, true, new Color(0x34e37d))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BLOOMING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BLOOMING, true, new Color(0x0abf34))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SWEET, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SWEET, true, new Color(0xfc51f1))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SUGAR, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SUGAR, true, new Color(0xe6d3e0))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RIPENING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RIPENING, true, new Color(0xb2c75d))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.FRUIT, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_FRUIT, true, new Color(0xdb5876))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ALCOHOL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ALCOHOL, true, new Color(0xe88a61))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MILK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MILK, true, new Color(0xe3e8e8))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.COFFEE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_COFFEE, true, new Color(0x8c5e30))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SWAMP, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SWAMP, true, new Color(0x356933))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.FUNGAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_FUNGAL, true, new Color(0xd16200))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MARBLE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MARBLE, true, new Color(0xd6c9cf))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ROMAN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ROMAN, true, new Color(0xad8bb0))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GREEK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GREEK, true, new Color(0x854c8a))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CLASSICAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CLASSICAL, true, new Color(0x831d8c))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.EMBITTERED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_EMBITTERED, true, new Color(0x8c6969))
		.setBody(new Color(0x9a2323))
		.setTemperature(TemperatureType.HELLISH)
		.setHumidity(HumidityType.ARID)
		.addProduct(SpaceBeesApicultureItems.BEE_COMBS.stack(SBEnumHoneyComb.BARREN), 0.30f)
		.setGenome(genome -> {
			genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
			genome.set(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_2);
			genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_2);
			genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_NONE);
			genome.set(BeeChromosomes.FLOWER_TYPE, SpaceBeeAlleles.FLOWER_TYPE_DEAD);
	
			
	})		
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.TEMPERED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_TEMPERED, true, new Color(0x8a4848))
		.setBody(new Color(0x9a2323))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.VOLCANIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_VOLCANIC, true, new Color(0x4d0c0c))
		.setBody(new Color(0x9a2323))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GLOWSTONE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GLOWSTONE, true, new Color(0xe0c61b))
		.setBody(new Color(0x9a2323))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MALICIOUS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MALICIOUS, true, new Color(0x782a77))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.INFECTIOUS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_INFECTIOUS, true, new Color(0xb82eb5))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.VIRULENT, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_VIRULENT, true, new Color(0xf013ec))
		.setBody(new Color(0x069764))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.VISCOUS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_VISCOUS, true, new Color(0x9470e))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GLUTINOUS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GLUTINOUS, true, new Color(0x1d8c27))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.STICKY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_STICKY, true, new Color(0x17e328))
		.setBody(new Color(0x069764))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CORROSIVE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CORROSIVE, true, new Color(0x4a5c0b))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CAUSTIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CAUSTIC, true, new Color(0x84a11d))
		.setBody(new Color(0x069764))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ACIDIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ACIDIC, true, new Color(0xc0f016))
		.setBody(new Color(0x069764))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.EXCITED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_EXCITED, true, new Color(0xff4545))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ENERGETIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ENERGETIC, true, new Color(0xe835c7))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ECSTATIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ECSTATIC, true, new Color(0xaf35e8))
		.setBody(new Color(0xffdc16))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ARTIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ARTIC, true, new Color(0xade0e0))
		.setBody(new Color(0xdaf5f3))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.FREEZING, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_FREEZING, true, new Color(0x7be3e3))
		.setBody(new Color(0xdaf5f3))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SHADOW, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SHADOW, true, new Color(0x595959))
		.setBody(new Color(0x333333))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.DARKENED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_DARKENED, true, new Color(0x332e33))
		.setBody(new Color(0x333333))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ABYSS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ABYSS, true, new Color(0x210821))
		.setBody(new Color(0x333333))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.RED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_RED, true, new Color(0xff0000))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.YELLOW, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_YELLOW, true, new Color(0xffdd00))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BLUE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BLUE, true, new Color(0x0022ff))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GREEN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GREEN, true, new Color(0x009900))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BLACK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BLACK, true, new Color(0x575757))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.WHITE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_WHITE, true, new Color(0xffffff))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.BROWN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_BROWN, true, new Color(0x5c350f))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.ORANGE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ORANGE, true, new Color(0xff9d00))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CYAN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CYAN, true, new Color(0x00ffe5))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PURPLE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PURPLE, true, new Color(0xae00ff))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.GRAY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_GRAY, true, new Color(0xbababa))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LIGHTBLUE, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LIGHTBLUE, true, new Color(0x009dff))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.PINK, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_PINK, true, new Color(0xff80df))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LIMEGREEN, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LIMEGREEN, true, new Color(0x00ff08))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MAGENTA, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MAGENTA, true, new Color(0xff00cc))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.LIGHTGRAY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LIGHTGRAY, true, new Color(0xc9c9c9))
		.setBody(new Color(0x8cff00))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.CELEBRATORY, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_CELEBRATORY, true, new Color(0xfa0a6a))
		.setBody(new Color(0xd40000))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.JADED, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_JADED, true, new Color(0xfa0a6a))
		.setBody(new Color(0xdc8aeb))
		.setGlint(true)
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.HAZARDOUS, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_HAZARDOUS, true, new Color(0xb06c28))
		.setBody(new Color(0xffdc16))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.QUANTUM, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_QUANTUM, true, new Color(0x37c5db))
		.setBody(new Color(0xd50fdb))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.UNUSUAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_UNUSUAL, true, new Color(0x59a4ba))
		.setBody(new Color(0xbaa2eb))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.SPATIAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_SPATIAL, true, new Color(0x4c1be0))
		.setBody(new Color(0xa44ecc))
		.setAuthority("Binnie");
		apiculture.registerSpecies(SpaceBeesSpecies.MYSTICAL, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_MYSTICAL, true, new Color(0x46a722))
		.setBody(new Color(0xffffff))
		.setAuthority("Binnie");

	
	}
}