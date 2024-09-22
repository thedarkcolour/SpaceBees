package com.example.spacebees.bees;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SpaceBeesTags {
    public static class Blocks {
        // Flowers
        public static final TagKey<Block> DEAD_FLOWERS = tag("flowers/dead");
        public static final TagKey<Block> WATER_FLOWERS = tag("flowers/water");
        public static final TagKey<Block> SUGAR_FLOWERS = tag("flowers/sugar");
        public static final TagKey<Block> ROCK_FLOWERS = tag("flowers/rock");
        public static final TagKey<Block> BOOK_FLOWERS = tag("flowers/book");
        public static final TagKey<Block> REDSTONE_FLOWERS = tag("flowers/redstone");
        public static final TagKey<Block> WOOD_FLOWERS = tag("flowers/wood");
        public static final TagKey<Block> LEAVES_FLOWERS = tag("flowers/leaves");
        public static final TagKey<Block> SAPLING_FLOWERS = tag("flowers/sapling");
        public static final TagKey<Block> FRUIT_FLOWERS = tag("flowers/fruit");
        public static final TagKey<Block> MYSTICAL_FLOWERS = tag("flowers/mystical");

}
		private static TagKey<Block> tag(String name) {
			return BlockTags.create(SpaceBeesConstants.spacebees(name));
		}

		private static TagKey<Block> forgeTag(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
}
