package com.example.spacebees.bees;

import java.awt.Color;

import com.example.spacebees.combs.SBEnumHoneyComb;

import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.plugin.IApicultureRegistration;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.genetics.ForestryTaxa;
import static forestry.apiculture.features.ApicultureItems.BEE_COMBS;
import static com.example.spacebees.combs.SpaceBeesApicultureItems.SBBEE_COMBS;


//  See DefaultBeeSpecies for examples
//  https://github.com/thedarkcolour/ForestryMC/blob/dev/1.19.x/src/main/java/forestry/plugin/DefaultBeeSpecies.java

public class CustomBeeSpecies {
    	@SuppressWarnings({ "CodeBlock2Expr", "deprecation" })
	public static void register(IApicultureRegistration apiculture) {
		// apiculture.registerSpecies(resource location, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_XXX, true?, new Color(0xa3999c))
		// Lunar
		apiculture.registerSpecies(SpaceBeesSpecies.LUNA, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LUNA, true, new Color(0xa3999c))
				.addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.20f)
				.addProduct(SBBEE_COMBS.stack(SBEnumHoneyComb.BARREN), 0.45f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
					genome.set(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_1);
				})
				.setAuthority("PantyRush");
					

		// Lunatic		
		apiculture.registerSpecies(SpaceBeesSpecies.LUNATIC, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_LUNATIC, true, new Color(0xffffff))
				//.addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.30f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_NONE);
				})		
				.addMutations(mutations -> {
					mutations.add(SpaceBeesSpecies.LUNA, ForestryBeeSpecies.COMMON, 10);
				})
				.setGlint(true)
				.setAuthority("PantyRush");

		//Binnie's 
		// https://github.com/ForestryMC/Binnie/blob/master-MC1.12/extrabees/src/main/java/binnie/extrabees/genetics/ExtraBeeDefinition.java
		//Barren Branch
		apiculture.registerSpecies(SpaceBeesSpecies.ARID, ForestryTaxa.GENUS_HONEY, SpaceBeesTaxa.SPECIES_ARID, true, new Color(0xbee854))
				.setBody(new Color(0xcbe374))
				.setTemperature(TemperatureType.HOT)
				.setHumidity(HumidityType.ARID)
				.addProduct(SBBEE_COMBS.stack(SBEnumHoneyComb.BARREN), 0.30f)
				.setGenome(genome -> {
					genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
					genome.set(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
					genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
					genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_2);
					
			})		
				.addMutations(mutations -> {
					mutations.add(ForestryBeeSpecies.FOREST, ForestryBeeSpecies.FRUGAL, 10);
					mutations.add(ForestryBeeSpecies.MEADOWS, ForestryBeeSpecies.FRUGAL, 10);
				})
				
				.setAuthority("Binnie");

			
	
	}
}