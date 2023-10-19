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
        this.tag(ModTags.Blocks.FIRE_BRICKABLE)
                .add(Blocks.FURNACE,Blocks.BLAST_FURNACE,Blocks.SMOKER);
        this.tag(ModTags.Blocks.PULVERIZABLE_BLOCKS)
                .add(
                        Blocks.COBBLESTONE,
                        Blocks.DIRT,
                        Blocks.BLACKSTONE,
                        Blocks.GRAVEL,
                        Blocks.GRANITE,
                        Blocks.DIORITE,
                        Blocks.ANDESITE,
                        Blocks.BONE_BLOCK
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CLOCK_BLOCK.get(), ModBlocks.FILTERED_HOPPER.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).
                        add(ModBlocks.CLOCK_BLOCK.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).
                add(ModBlocks.FILTERED_HOPPER.get());

        //<editor-fold desc="Concrete Fences,Gates & Walls added to Tags">
        this.tag(BlockTags.FENCES)
                .add(
                        ModBlocks.WHITE_CONCRETE_FENCE.get(),
                        ModBlocks.ORANGE_CONCRETE_FENCE.get(),
                        ModBlocks.MAGENTA_CONCRETE_FENCE.get(),
                        ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get(),
                        ModBlocks.YELLOW_CONCRETE_FENCE.get(),
                        ModBlocks.LIME_CONCRETE_FENCE.get(),
                        ModBlocks.PINK_CONCRETE_FENCE.get(),
                        ModBlocks.GRAY_CONCRETE_FENCE.get(),
                        ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get(),
                        ModBlocks.CYAN_CONCRETE_FENCE.get(),
                        ModBlocks.PURPLE_CONCRETE_FENCE.get(),
                        ModBlocks.BLUE_CONCRETE_FENCE.get(),
                        ModBlocks.BROWN_CONCRETE_FENCE.get(),
                        ModBlocks.GREEN_CONCRETE_FENCE.get(),
                        ModBlocks.RED_CONCRETE_FENCE.get(),
                        ModBlocks.BLACK_CONCRETE_FENCE.get()
                );
        this.tag(BlockTags.FENCE_GATES)
                .add(
                        ModBlocks.WHITE_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.ORANGE_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.MAGENTA_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.LIGHT_BLUE_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.YELLOW_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.LIME_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.PINK_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.GRAY_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.LIGHT_GRAY_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.CYAN_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.PURPLE_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.BLUE_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.BROWN_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.GREEN_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.RED_CONCRETE_FENCE_GATE.get(),
                        ModBlocks.BLACK_CONCRETE_FENCE_GATE.get()
                );
        this.tag(BlockTags.WALLS)
                .add(
                        ModBlocks.WHITE_CONCRETE_WALL.get(),
                        ModBlocks.ORANGE_CONCRETE_WALL.get(),
                        ModBlocks.MAGENTA_CONCRETE_WALL.get(),
                        ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get(),
                        ModBlocks.YELLOW_CONCRETE_WALL.get(),
                        ModBlocks.LIME_CONCRETE_WALL.get(),
                        ModBlocks.PINK_CONCRETE_WALL.get(),
                        ModBlocks.GRAY_CONCRETE_WALL.get(),
                        ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get(),
                        ModBlocks.CYAN_CONCRETE_WALL.get(),
                        ModBlocks.PURPLE_CONCRETE_WALL.get(),
                        ModBlocks.BLUE_CONCRETE_WALL.get(),
                        ModBlocks.BROWN_CONCRETE_WALL.get(),
                        ModBlocks.GREEN_CONCRETE_WALL.get(),
                        ModBlocks.RED_CONCRETE_WALL.get(),
                        ModBlocks.BLACK_CONCRETE_WALL.get()
                );
        //</editor-fold>


        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL).
        //        add(ModBlocks.FILTERED_HOPPER.get());
        //this.tag(BlockTags.NEEDS_NETHERITE_TOOL).
        //        add(ModBlocks.FILTERED_HOPPER.get());
    }
}
