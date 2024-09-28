package com.example.spacebees.bees.genetics.hives;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import forestry.api.apiculture.hives.IHiveGen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.Direction;
import forestry.core.utils.BlockUtil;

public class HiveGenNether implements IHiveGen{
    	private final Set<Material> groundMaterials = new HashSet<>();

	public HiveGenNether(Block... groundBlocks) {
		for (Block block : groundBlocks) {
			BlockState blockState = block.defaultBlockState();
			Material blockMaterial = blockState.getMaterial();
			groundMaterials.add(blockMaterial);
		}
	}

	@Override
	public boolean isValidLocation(WorldGenLevel world, BlockPos pos) {
		BlockState groundBlockState = world.getBlockState(pos.below());
		Material groundBlockMaterial = groundBlockState.getMaterial();
		return groundMaterials.contains(groundBlockMaterial);
	}

	@Override
	public BlockPos getPosForHive(WorldGenLevel level, int posX, int posZ) {
		// get to the ground
		Random r = new Random ();
        int roof = 127;
		int minBuildHeight = level.getMinBuildHeight();
        int groundY = r.nextInt(roof-minBuildHeight) + minBuildHeight;
		if (groundY == minBuildHeight) {
			return null;
		}

		final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(posX, groundY, posZ);

		BlockState blockState = level.getBlockState(pos);
		while (IHiveGen.isTreeBlock(blockState) || canReplace(blockState, level, pos)) {
			pos.move(Direction.DOWN);
			if (pos.getY() <= minBuildHeight) {
				return null;
			}
			blockState = level.getBlockState(pos);
		}

		return pos.above();
	}

	@Override
	public boolean canReplace(BlockState blockState, WorldGenLevel world, BlockPos pos) {
		return BlockUtil.canReplace(blockState, world, pos);
	}
}

