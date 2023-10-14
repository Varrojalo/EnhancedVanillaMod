package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EnhancedVanillaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.FIRE_BRICKABLE).
                add(Blocks.FURNACE,Blocks.BLAST_FURNACE,Blocks.SMOKER);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CLOCK_BLOCK.get(), ModBlocks.FILTERED_HOPPER.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).
                        add(ModBlocks.CLOCK_BLOCK.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).
                add(ModBlocks.FILTERED_HOPPER.get());

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL).
        //        add(ModBlocks.FILTERED_HOPPER.get());
        //this.tag(BlockTags.NEEDS_NETHERITE_TOOL).
        //        add(ModBlocks.FILTERED_HOPPER.get());
    }
}
