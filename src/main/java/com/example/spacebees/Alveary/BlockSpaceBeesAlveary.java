package com.example.spacebees.Alveary;

import javax.annotation.Nullable;

import com.example.spacebees.Features.SpaceBeesApicultureTiles;

import java.util.List;
import forestry.apiculture.MaterialBeehive;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.SoundType;
import java.util.Locale;
import forestry.core.blocks.BlockStructure;
import forestry.core.utils.ItemTooltipUtil;
import net.minecraft.network.chat.Component;


public class BlockSpaceBeesAlveary extends BlockStructure implements EntityBlock {
	public static final EnumProperty<State> STATE = EnumProperty.create("state", State.class);

	private final SpaceBeesBlockAlvearyType type;
	public enum State implements StringRepresentable {
		ON, OFF;

		@Override
		public String getSerializedName() {
			return name().toLowerCase(Locale.ENGLISH);
		}
	}
	public BlockSpaceBeesAlveary(SpaceBeesBlockAlvearyType type) {
		super(Block.Properties.of(MaterialBeehive.BEEHIVE_ALVEARY)
				.strength(1f)
				.sound(SoundType.WOOD)
		);

		this.type = type;

	}
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return switch (type) {
			//CRASH IS HERE
			case RAINSHIELD -> new TileAlvearyRainShield(SpaceBeesApicultureTiles.ALVEARY_RAINSHIELD.tileType(), "rainshield", pos, state);
			case LIGHTING -> new TileAlvearyLighting(SpaceBeesApicultureTiles.ALVEARY_LIGHTING.tileType(), "TileAlvearyLighting", pos, state);
			case MUTATOR -> new TileAlvearyCreativeMutator(SpaceBeesApicultureTiles.ALVEARY_MUTATOR.tileType(), "TileAlvearyCreativeMutator", pos, state);

        };

		}
			// todo this method isn't client only
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("block.forestry.alveary_tooltip"));
		} else {
			ItemTooltipUtil.addShiftInformation(stack, world, tooltip, flag);
		}
	}

}
