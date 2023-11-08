package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedVanillaMod.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.PULVERIZER_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/pulverizer_block")));
        blockWithITem(ModBlocks.ECHO_BLOCK);

        //<editor-fold desc="Concrete Deco Blocks Blockstate Datagen">
        registerColoredBlock("white","concrete");
        registerColoredBlock("orange","concrete");
        registerColoredBlock("magenta","concrete");
        registerColoredBlock("light_blue","concrete");
        registerColoredBlock("yellow","concrete");
        registerColoredBlock("lime","concrete");
        registerColoredBlock("pink","concrete");
        registerColoredBlock("gray","concrete");
        registerColoredBlock("light_gray","concrete");
        registerColoredBlock("cyan","concrete");
        registerColoredBlock("purple","concrete");
        registerColoredBlock("blue","concrete");
        registerColoredBlock("brown","concrete");
        registerColoredBlock("green","concrete");
        registerColoredBlock("red","concrete");
        registerColoredBlock("black","concrete");
        //</editor-fold>
    }

    private void registerColoredBlock(String color, String type)
    {
        color = color.toLowerCase();
        type = type.toLowerCase();
        Block baseBlock = getBaseColorBlock(color, type);

        Block stairsBlock = getDecoColorBlock(color,type,"stairs");
        Block slabBlock = getDecoColorBlock(color,type,"slab");
        Block buttonBlock = getDecoColorBlock(color,type,"button");
        Block pressurePlateBlock = getDecoColorBlock(color,type,"pressure_plate");
        Block fenceBlock = getDecoColorBlock(color,type,"fence");
        Block fenceGateBlock = getDecoColorBlock(color,type,"fence_gate");
        Block wallBlock = getDecoColorBlock(color,type,"wall");
        Block doorBlock = getDecoColorBlock(color,type,"door");
        Block trapdoorBlock = getDecoColorBlock(color,type,"trapdoor");

        String doorBottomName = "block/" + color + "_" + type + "_door_bottom";
        String doorTopName = "block/" + color + "_" + type + "_door_top";
        String trapdoorName = "block/" + color + "_" + type + "_trapdoor";
        String renderType = "cutout";

        stairsBlock(((StairBlock) stairsBlock), blockTexture(baseBlock));
        slabBlock(((SlabBlock) slabBlock), blockTexture(baseBlock), blockTexture(baseBlock));
        buttonBlock(((ButtonBlock) buttonBlock), blockTexture(baseBlock));
        pressurePlateBlock(((PressurePlateBlock) pressurePlateBlock), blockTexture(baseBlock));
        fenceBlock(((FenceBlock) fenceBlock), blockTexture(baseBlock));
        fenceGateBlock(((FenceGateBlock)fenceGateBlock), blockTexture(baseBlock));
        wallBlock(((WallBlock) wallBlock), blockTexture(baseBlock));
        doorBlockWithRenderType(((DoorBlock) doorBlock), modLoc(doorBottomName), modLoc(doorTopName), renderType);
        trapdoorBlockWithRenderType(((TrapDoorBlock) trapdoorBlock), modLoc(trapdoorName), true, renderType);
    }

    private Block getBaseColorBlock(String color, String type){
        return ForgeRegistries.BLOCKS.getEntries()
                .stream()
                .filter(entry -> entry.getKey().location().getPath().equals(color + "_" +type))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalStateException("Failed to find block with color: " + color));
    }
    public static Block getDecoColorBlock(String color, String type, String suffix) {
        return ForgeRegistries.BLOCKS.getEntries()
                .stream()
                .filter(entry -> entry.getKey().location().getPath().equals(color + "_" + type + "_" + suffix))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalStateException("Failed to find block with color: " + color + "_" + suffix));
    }
    private void blockWithITem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
