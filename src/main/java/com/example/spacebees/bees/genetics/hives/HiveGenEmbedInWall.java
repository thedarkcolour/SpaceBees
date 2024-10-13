package com.example.spacebees.bees.genetics.hives;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import forestry.api.apiculture.hives.IHiveGen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.Direction;
import forestry.core.utils.BlockUtil;



public class HiveGenEmbedInWall implements IHiveGen{
    	private final Set<Material> groundMaterials = new HashSet<>();
		private static final Logger LOGGER = LogUtils.getLogger();

	public HiveGenEmbedInWall(Block... groundBlocks) {
		for (Block block : groundBlocks) {
			BlockState blockState = block.defaultBlockState();
			Material blockMaterial = blockState.getMaterial();
			groundMaterials.add(blockMaterial);
		}
	}
	private boolean hasAirOnOneSide (WorldGenLevel world, BlockPos pos){
		BlockState west = world.getBlockState(pos.west());
		BlockState east = world.getBlockState(pos.east());
		BlockState north = world.getBlockState(pos.north());
		BlockState south = world.getBlockState(pos.south());
		int airSides = 0;
		//TODO there must be a smart way to do this
		if (west.getBlock() == Blocks.AIR || east.getBlock() == Blocks.AIR || north.getBlock() == Blocks.AIR || south.getBlock() == Blocks.AIR) {
			return true;
		}else{
		
		return false;
		}
	}

	@Override
	public boolean isValidLocation(WorldGenLevel world, BlockPos pos) {
		BlockState targetBlock = world.getBlockState(pos);
		String blockPos = pos.toString();
		if (groundMaterials.contains(targetBlock.getMaterial())) {
			if (hasAirOnOneSide(world, pos)){
				LOGGER.info("isValidLocation Returned True: "+blockPos); //troubleshooting
				return true;
			};
		}
		return false;
		
	}

	@Override
	public BlockPos getPosForHive(WorldGenLevel level, int posX, int posZ) {
		Random r = new Random ();
		final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(posX, 0, posZ);
		for (int i = 0; i < 10; i++){
			pos.setY(r.nextInt(level.getMaxBuildHeight()));
			if (isValidLocation(level, pos)){
				String posAbove = pos.above().toString(); //troubleshooting
				LOGGER.info("Pos for hive "+ posAbove); //troubleshooting
				return pos;
			}
		}
			return null;
		}
		
			
		

	@Override
	public boolean canReplace(BlockState blockState, WorldGenLevel world, BlockPos pos) {
		return groundMaterials.contains(blockState.getMaterial());
	}
}

