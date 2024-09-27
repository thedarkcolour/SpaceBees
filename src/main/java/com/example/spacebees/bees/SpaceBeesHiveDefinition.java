package com.example.spacebees.bees;

import java.util.List;

import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveDefinition;
import forestry.api.apiculture.hives.IHiveGen;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.core.ToleranceType;
import forestry.api.genetics.ClimateHelper;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.apiculture.hives.HiveGenGround;
import forestry.core.utils.SpeciesUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;


public enum SpaceBeesHiveDefinition implements IHiveDefinition{
	LUNA(SpaceBeesApicultureBlocks.BEEHIVE.get(SpaceBeesBlockHiveType.LUNA).defaultState(), 6.0f, SpaceBeesSpecies.LUNA, new HiveGenGround(Blocks.GRASS_BLOCK)) {
		@Override
		public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
			postGenFlowers(world, rand, pos, flowerStates);
		}

		@Override
		public boolean isGoodBiome(Holder<Biome> biome) {
			//TODO: Add Correct Spawning
			return super.isGoodBiome(biome) && !biome.is(Tags.Biomes.IS_SNOWY);
		}
	},
	WATER(SpaceBeesApicultureBlocks.BEEHIVE.get(SpaceBeesBlockHiveType.WATER).defaultState(), 6.0f, SpaceBeesSpecies.WATER, new HiveGenGround(Blocks.GRASS_BLOCK)) {
		@Override
		public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
			postGenFlowers(world, rand, pos, flowerStates);
		}

		@Override
		public boolean isGoodBiome(Holder<Biome> biome) {
			//TODO: Add Correct Spawning
			return super.isGoodBiome(biome) && !biome.is(Tags.Biomes.IS_SNOWY);
		}
	},
	ROCK(SpaceBeesApicultureBlocks.BEEHIVE.get(SpaceBeesBlockHiveType.ROCK).defaultState(), 6.0f, SpaceBeesSpecies.ROCK, new HiveGenGround(Blocks.GRASS_BLOCK)) {
		@Override
		public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
			postGenFlowers(world, rand, pos, flowerStates);
		}

		@Override
		public boolean isGoodBiome(Holder<Biome> biome) {
			//TODO: Add Correct Spawning
			return super.isGoodBiome(biome) && !biome.is(Tags.Biomes.IS_SNOWY);
		}
	},
	MARBLE(SpaceBeesApicultureBlocks.BEEHIVE.get(SpaceBeesBlockHiveType.MARBLE).defaultState(), 6.0f, SpaceBeesSpecies.MARBLE, new HiveGenGround(Blocks.GRASS_BLOCK)) {
		@Override
		public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
			postGenFlowers(world, rand, pos, flowerStates);
		}

		@Override
		public boolean isGoodBiome(Holder<Biome> biome) {
			//TODO: Add Correct Spawning
			return super.isGoodBiome(biome) && !biome.is(Tags.Biomes.IS_SNOWY);
		}
	},
	NETHER(SpaceBeesApicultureBlocks.BEEHIVE.get(SpaceBeesBlockHiveType.NETHER).defaultState(), 6.0f, SpaceBeesSpecies.EMBITTERED, new HiveGenGround(Blocks.GRASS_BLOCK)) {
		@Override
		public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
			postGenFlowers(world, rand, pos, flowerStates);
		}

		@Override
		public boolean isGoodBiome(Holder<Biome> biome) {
			//TODO: Add Correct Spawning
			return super.isGoodBiome(biome) && !biome.is(Tags.Biomes.IS_SNOWY);
		}
	};
	
	private static final IHiveGen FLOWER_GROUND = new HiveGenGround(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SNOW, Blocks.SAND, Blocks.SANDSTONE);
	private static final List<BlockState> flowerStates = new ArrayList<>();
	private static final List<BlockState> mushroomStates = new ArrayList<>();
	//private static final List<BlockState> cactusStates = Collections.singletonList(Blocks.CACTUS.defaultBlockState());

	static {
		flowerStates.addAll(Blocks.POPPY.getStateDefinition().getPossibleStates());
		flowerStates.addAll(Blocks.DANDELION.getStateDefinition().getPossibleStates());
		mushroomStates.add(Blocks.RED_MUSHROOM.defaultBlockState());
		mushroomStates.add(Blocks.BROWN_MUSHROOM.defaultBlockState());
	}

	private final BlockState blockState;
	private final float genChance;
	private final ResourceLocation speciesId;
	private final IHiveGen hiveGen;

	SpaceBeesHiveDefinition(BlockState hiveState, float genChance, ResourceLocation beeTemplate, IHiveGen hiveGen) {
		this.blockState = hiveState;
		this.genChance = genChance;
		this.speciesId = beeTemplate;
		this.hiveGen = hiveGen;
	}

	@Override
	public IHiveGen getHiveGen() {
		return hiveGen;
	}

	@Override
	public BlockState getBlockState() {
		return blockState;
	}

	@Override
	public boolean isGoodBiome(Holder<Biome> biome) {
		return !biome.is(BiomeTags.IS_NETHER);
	}

	@Override
	public boolean isGoodHumidity(HumidityType humidity) {
		IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
		HumidityType idealHumidity = species.getHumidity();
		ToleranceType humidityTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.HUMIDITY_TOLERANCE);
		return ClimateHelper.isWithinLimits(humidity, idealHumidity, humidityTolerance);
	}

	@Override
	public boolean isGoodTemperature(TemperatureType temperature) {
		IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
		TemperatureType idealTemperature = species.getTemperature();
		ToleranceType temperatureTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.TEMPERATURE_TOLERANCE);
		return ClimateHelper.isWithinLimits(temperature, idealTemperature, temperatureTolerance);
	}

	@Override
	public float getGenChance() {
		return genChance;
	}

	@Override
	public void postGen(WorldGenLevel world, RandomSource rand, BlockPos pos) {
	}

	protected static void postGenFlowers(WorldGenLevel world, RandomSource rand, BlockPos hivePos, List<BlockState> flowerStates) {
		int plantedCount = 0;
		for (int i = 0; i < 10; i++) {
			int xOffset = rand.nextInt(8) - 4;
			int zOffset = rand.nextInt(8) - 4;
			BlockPos blockPos = hivePos.offset(xOffset, 0, zOffset);
			if ((xOffset == 0 && zOffset == 0) || !world.hasChunkAt(blockPos)) {
				continue;
			}

			blockPos = FLOWER_GROUND.getPosForHive(world, blockPos.getX(), blockPos.getZ());
			if (blockPos == null) {
				continue;
			}

			BlockState state = flowerStates.get(rand.nextInt(flowerStates.size()));
			Block block = state.getBlock();
			if (!block.defaultBlockState().canSurvive(world, blockPos)) {
				continue;
			}

			world.setBlock(blockPos, state, Block.UPDATE_CLIENTS);
			plantedCount++;

			if (plantedCount >= 3) {
				break;
			}
		}
	}
}