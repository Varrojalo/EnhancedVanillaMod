package com.varrojalo.enhancedvanillamod.datagen.loot;

import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CLOCK_BLOCK.get());
        this.dropSelf(ModBlocks.FILTERED_HOPPER.get());
        this.dropSelf(ModBlocks.PULVERIZER_BLOCK.get());
        this.dropSelf(ModBlocks.ECHO_BLOCK.get());

        this.dropSelf(ModBlocks.PLACER_BLOCK.get());
        this.dropSelf(ModBlocks.BREAKER_BLOCK.get());

        this.dropSelf(ModBlocks.COPPER_FILTER.get());
        this.dropSelf(ModBlocks.DIAMOND_FILTER.get());
        this.dropSelf(ModBlocks.NETHERITE_FILTER.get());

        this.dropSelf(ModBlocks.COPPER_WIRE.get());

        //<editor-fold desc="White Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.WHITE_CONCRETE_STAIRS.get());
        this.add(ModBlocks.WHITE_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.WHITE_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.WHITE_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.WHITE_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WHITE_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.WHITE_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WHITE_CONCRETE_WALL.get());
        this.add(ModBlocks.WHITE_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.WHITE_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.WHITE_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Orange Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
        this.add(ModBlocks.ORANGE_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.ORANGE_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_WALL.get());
        this.add(ModBlocks.ORANGE_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.ORANGE_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Magenta Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
        this.add(ModBlocks.MAGENTA_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.MAGENTA_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_WALL.get());
        this.add(ModBlocks.MAGENTA_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.MAGENTA_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Light Blue Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        this.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        this.add(ModBlocks.LIGHT_BLUE_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.LIGHT_BLUE_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Yellow Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
        this.add(ModBlocks.YELLOW_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.YELLOW_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_WALL.get());
        this.add(ModBlocks.YELLOW_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.YELLOW_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Lime Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.LIME_CONCRETE_STAIRS.get());
        this.add(ModBlocks.LIME_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.LIME_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.LIME_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_WALL.get());
        this.add(ModBlocks.LIME_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.LIME_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.LIME_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Pink Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.PINK_CONCRETE_STAIRS.get());
        this.add(ModBlocks.PINK_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.PINK_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.PINK_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_WALL.get());
        this.add(ModBlocks.PINK_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.PINK_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.PINK_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Gray Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.GRAY_CONCRETE_STAIRS.get());
        this.add(ModBlocks.GRAY_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.GRAY_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.GRAY_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_WALL.get());
        this.add(ModBlocks.GRAY_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.GRAY_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.GRAY_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Light Gray Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        this.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        this.add(ModBlocks.LIGHT_GRAY_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.LIGHT_GRAY_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Cyan Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.CYAN_CONCRETE_STAIRS.get());
        this.add(ModBlocks.CYAN_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.CYAN_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.CYAN_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_WALL.get());
        this.add(ModBlocks.CYAN_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.CYAN_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.CYAN_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Purple Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
        this.add(ModBlocks.PURPLE_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.PURPLE_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_WALL.get());
        this.add(ModBlocks.PURPLE_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.PURPLE_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Blue Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.BLUE_CONCRETE_STAIRS.get());
        this.add(ModBlocks.BLUE_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.BLUE_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.BLUE_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_WALL.get());
        this.add(ModBlocks.BLUE_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.BLUE_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.BLUE_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Brown Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.BROWN_CONCRETE_STAIRS.get());
        this.add(ModBlocks.BROWN_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.BROWN_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.BROWN_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_WALL.get());
        this.add(ModBlocks.BROWN_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.BROWN_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.BROWN_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Green Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.GREEN_CONCRETE_STAIRS.get());
        this.add(ModBlocks.GREEN_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.GREEN_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.GREEN_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_WALL.get());
        this.add(ModBlocks.GREEN_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.GREEN_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.GREEN_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Red Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.RED_CONCRETE_STAIRS.get());
        this.add(ModBlocks.RED_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.RED_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.RED_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_WALL.get());
        this.add(ModBlocks.RED_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.RED_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.RED_CONCRETE_TRAPDOOR.get());
        //</editor-fold>
        //<editor-fold desc="Black Concrete Deco Blocks Loot Tables">
        this.dropSelf(ModBlocks.BLACK_CONCRETE_STAIRS.get());
        this.add(ModBlocks.BLACK_CONCRETE_SLAB.get(), block -> createSlabItemTable(ModBlocks.BLACK_CONCRETE_SLAB.get()));
        this.dropSelf(ModBlocks.BLACK_CONCRETE_BUTTON.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_FENCE.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_WALL.get());
        this.add(ModBlocks.BLACK_CONCRETE_DOOR.get(), block -> createDoorTable(ModBlocks.BLACK_CONCRETE_DOOR.get()));
        this.dropSelf(ModBlocks.BLACK_CONCRETE_TRAPDOOR.get());
        //</editor-fold>


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item).
                apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).
                apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
