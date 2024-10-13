package com.example.spacebees.Alveary;

import com.example.spacebees.Features.SpaceBeesApicultureTiles;

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
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;

    
public class TileAlvearyCreativeMutator extends TileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary>  {
	private final InventoryAlvearyMutator inventory;

	private static final IBeeModifier MUTATIONMODIFIER = new IBeeModifier() {
		@Override
		public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
			return 100.0f; //TODO make this change with items in inventory
		}
	};
    public TileAlvearyCreativeMutator(BlockEntityType<?> type, String translationKey, BlockPos pos, BlockState state) {
        super(type, "alveary_mutator",pos, state);
		this.inventory = new InventoryAlvearyMutator(this);

    }
    public TileAlvearyCreativeMutator( BlockPos pos, BlockState state) {
        super(SpaceBeesApicultureTiles.ALVEARY_MUTATOR.tileType(), "mutator",pos, state);
		this.inventory = new InventoryAlvearyMutator(this);
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
   

