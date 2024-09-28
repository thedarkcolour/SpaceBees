package com.example.spacebees.bees.genetics.hives;

import forestry.api.apiculture.hives.IHiveGen;
import net.minecraft.core.BlockPos;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import forestry.core.utils.BlockUtil;

public class HiveGenWater implements IHiveGen {
    
        private final Set<Material> groundMaterials = new HashSet<>();
    
        public HiveGenWater(Block... groundBlocks) {
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
            BlockState possibleHive = world.getBlockState(pos.above());
            Block ph = possibleHive.getBlock();
            if (ph == Blocks.WATER) {
            return groundMaterials.contains(groundBlockMaterial);
            }
            else {
                return false;
            }
        }
    
        @Override
        public BlockPos getPosForHive(WorldGenLevel level, int posX, int posZ) {
            // get to the ground
            int groundY = level.getHeight(Heightmap.Types.OCEAN_FLOOR, posX, posZ);

            int minBuildHeight = level.getMinBuildHeight();
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