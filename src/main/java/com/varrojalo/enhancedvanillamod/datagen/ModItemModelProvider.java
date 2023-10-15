package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedVanillaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FILTER);
        simpleItem(ModItems.MESH);
        simpleItem(ModItems.FIRE_BRICK);

        //<editor-fold desc="White Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.WHITE_CONCRETE_DOOR);
        fenceItem(ModBlocks.WHITE_CONCRETE_FENCE, Blocks.WHITE_CONCRETE);
        buttonItem(ModBlocks.WHITE_CONCRETE_BUTTON, Blocks.WHITE_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.WHITE_CONCRETE_WALL, Blocks.WHITE_CONCRETE);
        simplerBlockItem(ModBlocks.WHITE_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.WHITE_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.WHITE_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.WHITE_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.WHITE_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Orange Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.ORANGE_CONCRETE_DOOR);
        fenceItem(ModBlocks.ORANGE_CONCRETE_FENCE, Blocks.ORANGE_CONCRETE);
        buttonItem(ModBlocks.ORANGE_CONCRETE_BUTTON, Blocks.ORANGE_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.ORANGE_CONCRETE_WALL, Blocks.ORANGE_CONCRETE);
        simplerBlockItem(ModBlocks.ORANGE_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.ORANGE_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.ORANGE_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.ORANGE_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.ORANGE_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Magenta Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.MAGENTA_CONCRETE_DOOR);
        fenceItem(ModBlocks.MAGENTA_CONCRETE_FENCE, Blocks.MAGENTA_CONCRETE);
        buttonItem(ModBlocks.MAGENTA_CONCRETE_BUTTON, Blocks.MAGENTA_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.MAGENTA_CONCRETE_WALL, Blocks.MAGENTA_CONCRETE);
        simplerBlockItem(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.MAGENTA_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.MAGENTA_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.MAGENTA_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.MAGENTA_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Light Blue Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_DOOR);
        fenceItem(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE, Blocks.LIGHT_BLUE_CONCRETE);
        buttonItem(ModBlocks.LIGHT_BLUE_CONCRETE_BUTTON, Blocks.LIGHT_BLUE_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.LIGHT_BLUE_CONCRETE_WALL, Blocks.LIGHT_BLUE_CONCRETE);
        simplerBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.LIGHT_BLUE_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Yellow Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.YELLOW_CONCRETE_DOOR);
        fenceItem(ModBlocks.YELLOW_CONCRETE_FENCE, Blocks.YELLOW_CONCRETE);
        buttonItem(ModBlocks.YELLOW_CONCRETE_BUTTON, Blocks.YELLOW_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.YELLOW_CONCRETE_WALL, Blocks.YELLOW_CONCRETE);
        simplerBlockItem(ModBlocks.YELLOW_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.YELLOW_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.YELLOW_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.YELLOW_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.YELLOW_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Lime Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.LIME_CONCRETE_DOOR);
        fenceItem(ModBlocks.LIME_CONCRETE_FENCE, Blocks.LIME_CONCRETE);
        buttonItem(ModBlocks.LIME_CONCRETE_BUTTON, Blocks.LIME_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.LIME_CONCRETE_WALL, Blocks.LIME_CONCRETE);
        simplerBlockItem(ModBlocks.LIME_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.LIME_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.LIME_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.LIME_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.LIME_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Pink Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.PINK_CONCRETE_DOOR);
        fenceItem(ModBlocks.PINK_CONCRETE_FENCE, Blocks.PINK_CONCRETE);
        buttonItem(ModBlocks.PINK_CONCRETE_BUTTON, Blocks.PINK_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.PINK_CONCRETE_WALL, Blocks.PINK_CONCRETE);
        simplerBlockItem(ModBlocks.PINK_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.PINK_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.PINK_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.PINK_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.PINK_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Gray Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.GRAY_CONCRETE_DOOR);
        fenceItem(ModBlocks.GRAY_CONCRETE_FENCE, Blocks.GRAY_CONCRETE);
        buttonItem(ModBlocks.GRAY_CONCRETE_BUTTON, Blocks.GRAY_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.GRAY_CONCRETE_WALL, Blocks.GRAY_CONCRETE);
        simplerBlockItem(ModBlocks.GRAY_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.GRAY_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.GRAY_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.GRAY_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.GRAY_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Light Gray Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_DOOR);
        fenceItem(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE, Blocks.LIGHT_GRAY_CONCRETE);
        buttonItem(ModBlocks.LIGHT_GRAY_CONCRETE_BUTTON, Blocks.LIGHT_GRAY_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.LIGHT_GRAY_CONCRETE_WALL, Blocks.LIGHT_GRAY_CONCRETE);
        simplerBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.LIGHT_GRAY_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Cyan Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.CYAN_CONCRETE_DOOR);
        fenceItem(ModBlocks.CYAN_CONCRETE_FENCE, Blocks.CYAN_CONCRETE);
        buttonItem(ModBlocks.CYAN_CONCRETE_BUTTON, Blocks.CYAN_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.CYAN_CONCRETE_WALL, Blocks.CYAN_CONCRETE);
        simplerBlockItem(ModBlocks.CYAN_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.CYAN_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.CYAN_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.CYAN_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.CYAN_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Purple Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.PURPLE_CONCRETE_DOOR);
        fenceItem(ModBlocks.PURPLE_CONCRETE_FENCE, Blocks.PURPLE_CONCRETE);
        buttonItem(ModBlocks.PURPLE_CONCRETE_BUTTON, Blocks.PURPLE_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.PURPLE_CONCRETE_WALL, Blocks.PURPLE_CONCRETE);
        simplerBlockItem(ModBlocks.PURPLE_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.PURPLE_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.PURPLE_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.PURPLE_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.PURPLE_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Blue Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.BLUE_CONCRETE_DOOR);
        fenceItem(ModBlocks.BLUE_CONCRETE_FENCE, Blocks.BLUE_CONCRETE);
        buttonItem(ModBlocks.BLUE_CONCRETE_BUTTON, Blocks.BLUE_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.BLUE_CONCRETE_WALL, Blocks.BLUE_CONCRETE);
        simplerBlockItem(ModBlocks.BLUE_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.BLUE_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.BLUE_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.BLUE_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.BLUE_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Brown Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.BROWN_CONCRETE_DOOR);
        fenceItem(ModBlocks.BROWN_CONCRETE_FENCE, Blocks.BROWN_CONCRETE);
        buttonItem(ModBlocks.BROWN_CONCRETE_BUTTON, Blocks.BROWN_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.BROWN_CONCRETE_WALL, Blocks.BROWN_CONCRETE);
        simplerBlockItem(ModBlocks.BROWN_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.BROWN_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.BROWN_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.BROWN_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.BROWN_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Green Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.GREEN_CONCRETE_DOOR);
        fenceItem(ModBlocks.GREEN_CONCRETE_FENCE, Blocks.GREEN_CONCRETE);
        buttonItem(ModBlocks.GREEN_CONCRETE_BUTTON, Blocks.GREEN_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.GREEN_CONCRETE_WALL, Blocks.GREEN_CONCRETE);
        simplerBlockItem(ModBlocks.GREEN_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.GREEN_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.GREEN_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.GREEN_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.GREEN_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Red Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.RED_CONCRETE_DOOR);
        fenceItem(ModBlocks.RED_CONCRETE_FENCE, Blocks.RED_CONCRETE);
        buttonItem(ModBlocks.RED_CONCRETE_BUTTON, Blocks.RED_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.RED_CONCRETE_WALL, Blocks.RED_CONCRETE);
        simplerBlockItem(ModBlocks.RED_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.RED_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.RED_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.RED_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.RED_CONCRETE_TRAPDOOR);
        //</editor-fold>
        //<editor-fold desc="Black Concrete Door, Fence, Button & Wall items Datagen">
        simpleBlockItem(ModBlocks.BLACK_CONCRETE_DOOR);
        fenceItem(ModBlocks.BLACK_CONCRETE_FENCE, Blocks.BLACK_CONCRETE);
        buttonItem(ModBlocks.BLACK_CONCRETE_BUTTON, Blocks.BLACK_CONCRETE);
        wallItemMinecraftTexture(ModBlocks.BLACK_CONCRETE_WALL, Blocks.BLACK_CONCRETE);
        simplerBlockItem(ModBlocks.BLACK_CONCRETE_STAIRS);
        simplerBlockItem(ModBlocks.BLACK_CONCRETE_SLAB);
        simplerBlockItem(ModBlocks.BLACK_CONCRETE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.BLACK_CONCRETE_FENCE_GATE);
        trapdoorItem(ModBlocks.BLACK_CONCRETE_TRAPDOOR);
        //</editor-fold>


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedVanillaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/fence_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/fence_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }


    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/button_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/button_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("texture",new ResourceLocation(EnhancedVanillaMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public  void wallItemMinecraftTexture(RegistryObject<Block> block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("wall",new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedVanillaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void simplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(EnhancedVanillaMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

}