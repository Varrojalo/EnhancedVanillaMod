package com.varrojalo.enhancedvanillamod.util;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks
    {
        public static final TagKey<Block> FIRE_BRICKABLE = tag("fire_brickable");
        public static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(EnhancedVanillaMod.MOD_ID,name));
        }
    }
    public static class Items
    {
        public static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(EnhancedVanillaMod.MOD_ID,name));
        }
    }
}
