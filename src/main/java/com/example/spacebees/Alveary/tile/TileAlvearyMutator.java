package com.example.spacebees.Alveary.tile;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import com.example.spacebees.Alveary.ContainerAlvearyMutator;
import com.example.spacebees.Alveary.InventoryAlvearyMutator;
import com.example.spacebees.Features.SpaceBeesApicultureTiles;
import com.mojang.logging.LogUtils;

import forestry.api.apiculture.IBeeListener;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.apiculture.multiblock.TileAlveary;
import forestry.core.inventory.IInventoryAdapter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import org.slf4j.Logger;


    
public class TileAlvearyMutator extends TileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary>, IAlvearyComponent.BeeListener<MultiblockLogicAlveary>  {
	private final IBeeListener beeListener;
	private final InventoryAlvearyMutator inventory;
	private static final Logger LOGGER = LogUtils.getLogger();
	public static float itemMutationModifier = 1.0f;

	private static final IBeeModifier MUTATIONMODIFIER = new IBeeModifier() {
		@Override
		public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {

			return currentChance * itemMutationModifier; 
			
		}
	};
    public TileAlvearyMutator(BlockEntityType<?> type, String translationKey, BlockPos pos, BlockState state) {
        super(type, "alveary_mutator",pos, state);
		this.inventory = new InventoryAlvearyMutator(this);
		this.beeListener = new AlvearyMutatorListener(inventory);

    }
    public TileAlvearyMutator( BlockPos pos, BlockState state) {
        super(SpaceBeesApicultureTiles.ALVEARY_MUTATOR.tileType(), "Alveary Mutator",pos, state);
		this.inventory = new InventoryAlvearyMutator(this);
		this.beeListener = new AlvearyMutatorListener(inventory);

    }
	static class AlvearyMutatorListener implements IBeeListener {
		private final InventoryAlvearyMutator inventory;

		public AlvearyMutatorListener(InventoryAlvearyMutator inventory) {
		this.inventory = inventory;
	}
	
		@Override
		public void onQueenDeath(){
			if (inventory.countItem(Items.SOUL_SAND)>0){
				itemMutationModifier = 1.5f;
			} else if (inventory.countItem(Items.NETHER_STAR)>0){
				itemMutationModifier = 50.0f;
			} else if (inventory.countItem(Items.ENDER_PEARL)>0){
				itemMutationModifier = 2.0f;
			} else if (inventory.countItem(Items.ENDER_EYE)>0){
				itemMutationModifier = 4.0f;
			} else {
				itemMutationModifier = 1.0f;
			}
			//TODO there must be a better way to do this
			inventory.removeItem(0, 1);
			String s=String.valueOf(itemMutationModifier);
			LOGGER.info("Queen Died: itemMutationModifier:"+s);
			//removes one item when the queen dies
		
		}
	}
	@Override
		public IBeeListener getBeeListener() {
		return this.beeListener;
	}
		@Override
	public IInventoryAdapter getInternalInventory() {
		return this.inventory;
	}
		@Override
	public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
		return new ContainerAlvearyMutator(windowId, inv, this);
	}
	@Override
	public IBeeModifier getBeeModifier() {
		return MUTATIONMODIFIER;
	}
}
   

