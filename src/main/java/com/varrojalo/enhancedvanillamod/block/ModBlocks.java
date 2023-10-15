package com.varrojalo.enhancedvanillamod.block;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.custom.ClockBlock;
import com.varrojalo.enhancedvanillamod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedVanillaMod.MOD_ID);

    public static final RegistryObject<Block> CLOCK_BLOCK = registerBlock("clock_block",
            () -> new ClockBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));
    public static final RegistryObject<Block> FILTERED_HOPPER = registerBlock("filtered_hopper",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HOPPER)));


    //<editor-fold desc="White Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            () -> new StairBlock(Blocks.WHITE_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    //Button, PressurePlate
    public static final RegistryObject<Block> WHITE_CONCRETE_BUTTON = registerBlock("white_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10,true));
    public static final RegistryObject<Block> WHITE_CONCRETE_PRESSURE_PLATE = registerBlock("white_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE),BlockSetType.IRON));
    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> WHITE_CONCRETE_FENCE = registerBlock("white_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> WHITE_CONCRETE_FENCE_GATE = registerBlock("white_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    //Door,Trapdoor
    public static final RegistryObject<Block> WHITE_CONCRETE_DOOR = registerBlock("white_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion(),BlockSetType.STONE));
    public static final RegistryObject<Block> WHITE_CONCRETE_TRAPDOOR = registerBlock("white_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion(),BlockSetType.STONE));
    //</editor-fold>
    //<editor-fold desc="Orange Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            () -> new StairBlock(Blocks.ORANGE_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> ORANGE_CONCRETE_BUTTON = registerBlock("orange_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> ORANGE_CONCRETE_PRESSURE_PLATE = registerBlock("orange_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> ORANGE_CONCRETE_FENCE = registerBlock("orange_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> ORANGE_CONCRETE_FENCE_GATE = registerBlock("orange_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> ORANGE_CONCRETE_DOOR = registerBlock("orange_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> ORANGE_CONCRETE_TRAPDOOR = registerBlock("orange_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    //</editor-fold>
    //<editor-fold desc="Magenta Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            () -> new StairBlock(Blocks.MAGENTA_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> MAGENTA_CONCRETE_BUTTON = registerBlock("magenta_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_PRESSURE_PLATE = registerBlock("magenta_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> MAGENTA_CONCRETE_FENCE = registerBlock("magenta_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_FENCE_GATE = registerBlock("magenta_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> MAGENTA_CONCRETE_DOOR = registerBlock("magenta_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> MAGENTA_CONCRETE_TRAPDOOR = registerBlock("magenta_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE).noOcclusion(), BlockSetType.STONE));
    //</editor-fold>
    //<editor-fold desc="Light Blue Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_BUTTON = registerBlock("light_blue_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("light_blue_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_FENCE = registerBlock("light_blue_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_FENCE_GATE = registerBlock("light_blue_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_DOOR = registerBlock("light_blue_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_TRAPDOOR = registerBlock("light_blue_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    //</editor-fold>
    //<editor-fold desc="Yellow Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            () -> new StairBlock(Blocks.YELLOW_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> YELLOW_CONCRETE_BUTTON = registerBlock("yellow_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> YELLOW_CONCRETE_PRESSURE_PLATE = registerBlock("yellow_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> YELLOW_CONCRETE_FENCE = registerBlock("yellow_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> YELLOW_CONCRETE_FENCE_GATE = registerBlock("yellow_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> YELLOW_CONCRETE_DOOR = registerBlock("yellow_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> YELLOW_CONCRETE_TRAPDOOR = registerBlock("yellow_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).noOcclusion(), BlockSetType.STONE));
    //</editor-fold>
    //<editor-fold desc="Lime Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            () -> new StairBlock(Blocks.LIME_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> LIME_CONCRETE_BUTTON = registerBlock("lime_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> LIME_CONCRETE_PRESSURE_PLATE = registerBlock("lime_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> LIME_CONCRETE_FENCE = registerBlock("lime_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> LIME_CONCRETE_FENCE_GATE = registerBlock("lime_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> LIME_CONCRETE_DOOR = registerBlock("lime_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> LIME_CONCRETE_TRAPDOOR = registerBlock("lime_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Pink Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            () -> new StairBlock(Blocks.PINK_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> PINK_CONCRETE_BUTTON = registerBlock("pink_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> PINK_CONCRETE_PRESSURE_PLATE = registerBlock("pink_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> PINK_CONCRETE_FENCE = registerBlock("pink_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> PINK_CONCRETE_FENCE_GATE = registerBlock("pink_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> PINK_CONCRETE_DOOR = registerBlock("pink_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> PINK_CONCRETE_TRAPDOOR = registerBlock("pink_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Gray Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            () -> new StairBlock(Blocks.GRAY_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> GRAY_CONCRETE_BUTTON = registerBlock("gray_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("gray_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> GRAY_CONCRETE_FENCE = registerBlock("gray_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> GRAY_CONCRETE_FENCE_GATE = registerBlock("gray_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> GRAY_CONCRETE_DOOR = registerBlock("gray_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> GRAY_CONCRETE_TRAPDOOR = registerBlock("gray_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Light Gray Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_BUTTON = registerBlock("light_gray_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("light_gray_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_FENCE = registerBlock("light_gray_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_FENCE_GATE = registerBlock("light_gray_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_DOOR = registerBlock("light_gray_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_TRAPDOOR = registerBlock("light_gray_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Cyan Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            () -> new StairBlock(Blocks.CYAN_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> CYAN_CONCRETE_BUTTON = registerBlock("cyan_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> CYAN_CONCRETE_PRESSURE_PLATE = registerBlock("cyan_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> CYAN_CONCRETE_FENCE = registerBlock("cyan_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CYAN_CONCRETE_FENCE_GATE = registerBlock("cyan_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> CYAN_CONCRETE_DOOR = registerBlock("cyan_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> CYAN_CONCRETE_TRAPDOOR = registerBlock("cyan_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Purple Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            () -> new StairBlock(Blocks.PURPLE_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> PURPLE_CONCRETE_BUTTON = registerBlock("purple_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> PURPLE_CONCRETE_PRESSURE_PLATE = registerBlock("purple_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> PURPLE_CONCRETE_FENCE = registerBlock("purple_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> PURPLE_CONCRETE_FENCE_GATE = registerBlock("purple_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> PURPLE_CONCRETE_DOOR = registerBlock("purple_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> PURPLE_CONCRETE_TRAPDOOR = registerBlock("purple_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Blue Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            () -> new StairBlock(Blocks.BLUE_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> BLUE_CONCRETE_BUTTON = registerBlock("blue_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("blue_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> BLUE_CONCRETE_FENCE = registerBlock("blue_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BLUE_CONCRETE_FENCE_GATE = registerBlock("blue_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> BLUE_CONCRETE_DOOR = registerBlock("blue_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> BLUE_CONCRETE_TRAPDOOR = registerBlock("blue_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Brown Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            () -> new StairBlock(Blocks.BROWN_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> BROWN_CONCRETE_BUTTON = registerBlock("brown_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> BROWN_CONCRETE_PRESSURE_PLATE = registerBlock("brown_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> BROWN_CONCRETE_FENCE = registerBlock("brown_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> BROWN_CONCRETE_FENCE_GATE = registerBlock("brown_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> BROWN_CONCRETE_DOOR = registerBlock("brown_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> BROWN_CONCRETE_TRAPDOOR = registerBlock("brown_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Green Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            () -> new StairBlock(Blocks.GREEN_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> GREEN_CONCRETE_BUTTON = registerBlock("green_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> GREEN_CONCRETE_PRESSURE_PLATE = registerBlock("green_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> GREEN_CONCRETE_FENCE = registerBlock("green_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> GREEN_CONCRETE_FENCE_GATE = registerBlock("green_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> GREEN_CONCRETE_DOOR = registerBlock("green_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> GREEN_CONCRETE_TRAPDOOR = registerBlock("green_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Red Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            () -> new StairBlock(Blocks.RED_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> RED_CONCRETE_BUTTON = registerBlock("red_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> RED_CONCRETE_PRESSURE_PLATE = registerBlock("red_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> RED_CONCRETE_FENCE = registerBlock("red_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> RED_CONCRETE_FENCE_GATE = registerBlock("red_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> RED_CONCRETE_DOOR = registerBlock("red_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> RED_CONCRETE_TRAPDOOR = registerBlock("red_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>
    //<editor-fold desc="Black Concrete Decoration Blocks">
    //Stairs, Slab
    public static final RegistryObject<Block> BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            () -> new StairBlock(Blocks.BLACK_CONCRETE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final RegistryObject<Block> BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Button, PressurePlate
    public static final RegistryObject<Block> BLACK_CONCRETE_BUTTON = registerBlock("black_concrete_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> BLACK_CONCRETE_PRESSURE_PLATE = registerBlock("black_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), BlockSetType.IRON));

    //Fence, Fence Gate, Wall
    public static final RegistryObject<Block> BLACK_CONCRETE_FENCE = registerBlock("black_concrete_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final RegistryObject<Block> BLACK_CONCRETE_FENCE_GATE = registerBlock("black_concrete_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Door, Trapdoor
    public static final RegistryObject<Block> BLACK_CONCRETE_DOOR = registerBlock("black_concrete_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> BLACK_CONCRETE_TRAPDOOR = registerBlock("black_concrete_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE).noOcclusion(), BlockSetType.STONE));

    //</editor-fold>

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> returnedBlock = BLOCKS.register(name, block);
        registerBlockItem(name, returnedBlock);
        return returnedBlock;
    }
    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
