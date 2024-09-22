package com.example.spacebees.bees;

import java.util.List;
import java.util.function.Supplier;

import com.example.spacebees.combs.SBEnumHoneyComb;

import forestry.api.plugin.IForestryPlugin;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import com.example.spacebees.combs.SpaceBeesApicultureItems;

// Use Default Forestry Plugin as an example
// https://github.com/thedarkcolour/ForestryMC/blob/dev/1.19.x/src/main/java/forestry/plugin/DefaultForestryPlugin.java

public class CustomBees implements IForestryPlugin{
    
    public static final ResourceLocation ID = SpaceBeesConstants.spacebees("default");
    
    private static Supplier<List<ItemStack>> getHoneyComb(EnumHoneyComb type) {
		return () -> List.of(ApicultureItems.BEE_COMBS.stack(type));
	}
    private static Supplier<List<ItemStack>> getSBHoneyComb(SBEnumHoneyComb type) {
		return () -> List.of(SpaceBeesApicultureItems.BEE_COMBS.stack(type));
	}
    
    Supplier<List<ItemStack>> honeyComb = getHoneyComb(EnumHoneyComb.HONEY);
    Supplier<List<ItemStack>> barrenComb = getSBHoneyComb(SBEnumHoneyComb.BARREN);

    @Override 
    public void registerApiculture(@SuppressWarnings("null") IApicultureRegistration apiculture){
        CustomBeeSpecies.register(apiculture);
        		apiculture.registerHive(SpaceBeesSpecies.LUNA, SpaceBeesHiveDefinition.LUNA)
               	    .addDrop(0.80, SpaceBeesSpecies.LUNA, barrenComb, 0.7f)
                    .addDrop(0.03, ForestryBeeSpecies.VALIANT, honeyComb);
    }        
    public ResourceLocation id() {
       return ID;
   }

}
