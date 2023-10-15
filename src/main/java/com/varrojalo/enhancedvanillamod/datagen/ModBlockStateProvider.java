package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedVanillaMod.MOD_ID, exFileHelper);
    }
    public ResourceLocation minecraftBlockTexture(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        return new ResourceLocation(name.getNamespace(), name.getPath());
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithITem(ModBlocks.CLOCK_BLOCK);
        blockWithITem(ModBlocks.FILTERED_HOPPER);

        //<editor-fold desc="White Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.WHITE_CONCRETE_STAIRS.get()),blockTexture(Blocks.WHITE_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.WHITE_CONCRETE_SLAB.get()),blockTexture(Blocks.WHITE_CONCRETE),blockTexture(Blocks.WHITE_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.WHITE_CONCRETE_BUTTON.get()),blockTexture(Blocks.WHITE_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.WHITE_CONCRETE_PRESSURE_PLATE.get()),blockTexture(Blocks.WHITE_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.WHITE_CONCRETE_FENCE.get()),blockTexture(Blocks.WHITE_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.WHITE_CONCRETE_FENCE_GATE.get()),blockTexture(Blocks.WHITE_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.WHITE_CONCRETE_WALL.get()),blockTexture(Blocks.WHITE_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.WHITE_CONCRETE_DOOR.get()),modLoc("block/white_concrete_door_bottom"),modLoc("block/white_concrete_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.WHITE_CONCRETE_TRAPDOOR.get()),modLoc("block/white_concrete_trapdoor"),true,"cutout");
        //</editor-fold>
        //<editor-fold desc="Orange Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.ORANGE_CONCRETE_STAIRS.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.ORANGE_CONCRETE_SLAB.get()), blockTexture(Blocks.ORANGE_CONCRETE), blockTexture(Blocks.ORANGE_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.ORANGE_CONCRETE_BUTTON.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ORANGE_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.ORANGE_CONCRETE_FENCE.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ORANGE_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.ORANGE_CONCRETE_WALL.get()), blockTexture(Blocks.ORANGE_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.ORANGE_CONCRETE_DOOR.get()), modLoc("block/orange_concrete_door_bottom"), modLoc("block/orange_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ORANGE_CONCRETE_TRAPDOOR.get()), modLoc("block/orange_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Magenta Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.MAGENTA_CONCRETE_STAIRS.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.MAGENTA_CONCRETE_SLAB.get()), blockTexture(Blocks.MAGENTA_CONCRETE), blockTexture(Blocks.MAGENTA_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.MAGENTA_CONCRETE_BUTTON.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MAGENTA_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.MAGENTA_CONCRETE_FENCE.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.MAGENTA_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.MAGENTA_CONCRETE_WALL.get()), blockTexture(Blocks.MAGENTA_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.MAGENTA_CONCRETE_DOOR.get()), modLoc("block/magenta_concrete_door_bottom"), modLoc("block/magenta_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MAGENTA_CONCRETE_TRAPDOOR.get()), modLoc("block/magenta_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Light Blue Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.LIGHT_BLUE_CONCRETE_BUTTON.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIGHT_BLUE_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LIGHT_BLUE_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get()), blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.LIGHT_BLUE_CONCRETE_DOOR.get()), modLoc("block/light_blue_concrete_door_bottom"), modLoc("block/light_blue_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LIGHT_BLUE_CONCRETE_TRAPDOOR.get()), modLoc("block/light_blue_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Yellow Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.YELLOW_CONCRETE_STAIRS.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.YELLOW_CONCRETE_SLAB.get()), blockTexture(Blocks.YELLOW_CONCRETE), blockTexture(Blocks.YELLOW_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.YELLOW_CONCRETE_BUTTON.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.YELLOW_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.YELLOW_CONCRETE_FENCE.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.YELLOW_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.YELLOW_CONCRETE_WALL.get()), blockTexture(Blocks.YELLOW_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.YELLOW_CONCRETE_DOOR.get()), modLoc("block/yellow_concrete_door_bottom"), modLoc("block/yellow_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.YELLOW_CONCRETE_TRAPDOOR.get()), modLoc("block/yellow_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Lime Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.LIME_CONCRETE_STAIRS.get()), blockTexture(Blocks.LIME_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.LIME_CONCRETE_SLAB.get()), blockTexture(Blocks.LIME_CONCRETE), blockTexture(Blocks.LIME_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.LIME_CONCRETE_BUTTON.get()), blockTexture(Blocks.LIME_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIME_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.LIME_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.LIME_CONCRETE_FENCE.get()), blockTexture(Blocks.LIME_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LIME_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.LIME_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.LIME_CONCRETE_WALL.get()), blockTexture(Blocks.LIME_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.LIME_CONCRETE_DOOR.get()), modLoc("block/lime_concrete_door_bottom"), modLoc("block/lime_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LIME_CONCRETE_TRAPDOOR.get()), modLoc("block/lime_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Pink Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.PINK_CONCRETE_STAIRS.get()), blockTexture(Blocks.PINK_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.PINK_CONCRETE_SLAB.get()), blockTexture(Blocks.PINK_CONCRETE), blockTexture(Blocks.PINK_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.PINK_CONCRETE_BUTTON.get()), blockTexture(Blocks.PINK_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PINK_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.PINK_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.PINK_CONCRETE_FENCE.get()), blockTexture(Blocks.PINK_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PINK_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.PINK_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.PINK_CONCRETE_WALL.get()), blockTexture(Blocks.PINK_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PINK_CONCRETE_DOOR.get()), modLoc("block/pink_concrete_door_bottom"), modLoc("block/pink_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PINK_CONCRETE_TRAPDOOR.get()), modLoc("block/pink_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Gray Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.GRAY_CONCRETE_STAIRS.get()), blockTexture(Blocks.GRAY_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.GRAY_CONCRETE_SLAB.get()), blockTexture(Blocks.GRAY_CONCRETE), blockTexture(Blocks.GRAY_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.GRAY_CONCRETE_BUTTON.get()), blockTexture(Blocks.GRAY_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GRAY_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.GRAY_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.GRAY_CONCRETE_FENCE.get()), blockTexture(Blocks.GRAY_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GRAY_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.GRAY_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.GRAY_CONCRETE_WALL.get()), blockTexture(Blocks.GRAY_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.GRAY_CONCRETE_DOOR.get()), modLoc("block/gray_concrete_door_bottom"), modLoc("block/gray_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GRAY_CONCRETE_TRAPDOOR.get()), modLoc("block/gray_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Light Gray Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.LIGHT_GRAY_CONCRETE_BUTTON.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIGHT_GRAY_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LIGHT_GRAY_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get()), blockTexture(Blocks.LIGHT_GRAY_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.LIGHT_GRAY_CONCRETE_DOOR.get()), modLoc("block/light_gray_concrete_door_bottom"), modLoc("block/light_gray_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LIGHT_GRAY_CONCRETE_TRAPDOOR.get()), modLoc("block/light_gray_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Cyan Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.CYAN_CONCRETE_STAIRS.get()), blockTexture(Blocks.CYAN_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.CYAN_CONCRETE_SLAB.get()), blockTexture(Blocks.CYAN_CONCRETE), blockTexture(Blocks.CYAN_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.CYAN_CONCRETE_BUTTON.get()), blockTexture(Blocks.CYAN_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CYAN_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.CYAN_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.CYAN_CONCRETE_FENCE.get()), blockTexture(Blocks.CYAN_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CYAN_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.CYAN_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.CYAN_CONCRETE_WALL.get()), blockTexture(Blocks.CYAN_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.CYAN_CONCRETE_DOOR.get()), modLoc("block/cyan_concrete_door_bottom"), modLoc("block/cyan_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CYAN_CONCRETE_TRAPDOOR.get()), modLoc("block/cyan_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Purple Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.PURPLE_CONCRETE_STAIRS.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.PURPLE_CONCRETE_SLAB.get()), blockTexture(Blocks.PURPLE_CONCRETE), blockTexture(Blocks.PURPLE_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.PURPLE_CONCRETE_BUTTON.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PURPLE_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.PURPLE_CONCRETE_FENCE.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PURPLE_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.PURPLE_CONCRETE_WALL.get()), blockTexture(Blocks.PURPLE_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PURPLE_CONCRETE_DOOR.get()), modLoc("block/purple_concrete_door_bottom"), modLoc("block/purple_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PURPLE_CONCRETE_TRAPDOOR.get()), modLoc("block/purple_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Blue Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.BLUE_CONCRETE_STAIRS.get()), blockTexture(Blocks.BLUE_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.BLUE_CONCRETE_SLAB.get()), blockTexture(Blocks.BLUE_CONCRETE), blockTexture(Blocks.BLUE_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.BLUE_CONCRETE_BUTTON.get()), blockTexture(Blocks.BLUE_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLUE_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.BLUE_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.BLUE_CONCRETE_FENCE.get()), blockTexture(Blocks.BLUE_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLUE_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.BLUE_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.BLUE_CONCRETE_WALL.get()), blockTexture(Blocks.BLUE_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLUE_CONCRETE_DOOR.get()), modLoc("block/blue_concrete_door_bottom"), modLoc("block/blue_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLUE_CONCRETE_TRAPDOOR.get()), modLoc("block/blue_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Brown Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.BROWN_CONCRETE_STAIRS.get()), blockTexture(Blocks.BROWN_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.BROWN_CONCRETE_SLAB.get()), blockTexture(Blocks.BROWN_CONCRETE), blockTexture(Blocks.BROWN_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.BROWN_CONCRETE_BUTTON.get()), blockTexture(Blocks.BROWN_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BROWN_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.BROWN_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.BROWN_CONCRETE_FENCE.get()), blockTexture(Blocks.BROWN_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BROWN_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.BROWN_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.BROWN_CONCRETE_WALL.get()), blockTexture(Blocks.BROWN_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.BROWN_CONCRETE_DOOR.get()), modLoc("block/brown_concrete_door_bottom"), modLoc("block/brown_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BROWN_CONCRETE_TRAPDOOR.get()), modLoc("block/brown_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Green Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.GREEN_CONCRETE_STAIRS.get()), blockTexture(Blocks.GREEN_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.GREEN_CONCRETE_SLAB.get()), blockTexture(Blocks.GREEN_CONCRETE), blockTexture(Blocks.GREEN_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.GREEN_CONCRETE_BUTTON.get()), blockTexture(Blocks.GREEN_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GREEN_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.GREEN_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.GREEN_CONCRETE_FENCE.get()), blockTexture(Blocks.GREEN_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GREEN_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.GREEN_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.GREEN_CONCRETE_WALL.get()), blockTexture(Blocks.GREEN_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.GREEN_CONCRETE_DOOR.get()), modLoc("block/green_concrete_door_bottom"), modLoc("block/green_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GREEN_CONCRETE_TRAPDOOR.get()), modLoc("block/green_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Red Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.RED_CONCRETE_STAIRS.get()), blockTexture(Blocks.RED_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.RED_CONCRETE_SLAB.get()), blockTexture(Blocks.RED_CONCRETE), blockTexture(Blocks.RED_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.RED_CONCRETE_BUTTON.get()), blockTexture(Blocks.RED_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.RED_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.RED_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.RED_CONCRETE_FENCE.get()), blockTexture(Blocks.RED_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.RED_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.RED_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.RED_CONCRETE_WALL.get()), blockTexture(Blocks.RED_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.RED_CONCRETE_DOOR.get()), modLoc("block/red_concrete_door_bottom"), modLoc("block/red_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.RED_CONCRETE_TRAPDOOR.get()), modLoc("block/red_concrete_trapdoor"), true, "cutout");
        //</editor-fold>
        //<editor-fold desc="Black Concrete Deco Blocks Blockstate Datagen">
        stairsBlock(((StairBlock) ModBlocks.BLACK_CONCRETE_STAIRS.get()), blockTexture(Blocks.BLACK_CONCRETE));
        slabBlock(((SlabBlock) ModBlocks.BLACK_CONCRETE_SLAB.get()), blockTexture(Blocks.BLACK_CONCRETE), blockTexture(Blocks.BLACK_CONCRETE));
        buttonBlock(((ButtonBlock) ModBlocks.BLACK_CONCRETE_BUTTON.get()), blockTexture(Blocks.BLACK_CONCRETE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLACK_CONCRETE_PRESSURE_PLATE.get()), blockTexture(Blocks.BLACK_CONCRETE));
        fenceBlock(((FenceBlock) ModBlocks.BLACK_CONCRETE_FENCE.get()), blockTexture(Blocks.BLACK_CONCRETE));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLACK_CONCRETE_FENCE_GATE.get()), blockTexture(Blocks.BLACK_CONCRETE));
        wallBlock(((WallBlock) ModBlocks.BLACK_CONCRETE_WALL.get()), blockTexture(Blocks.BLACK_CONCRETE));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLACK_CONCRETE_DOOR.get()), modLoc("block/black_concrete_door_bottom"), modLoc("block/black_concrete_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLACK_CONCRETE_TRAPDOOR.get()), modLoc("block/black_concrete_trapdoor"), true, "cutout");
        //</editor-fold>



    }

    private void blockWithITem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
