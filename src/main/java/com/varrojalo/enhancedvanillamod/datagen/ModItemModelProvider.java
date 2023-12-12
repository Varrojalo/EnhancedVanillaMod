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

import java.util.Map;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedVanillaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FILTER);
        simpleItem(ModItems.MESH);
        simpleItem(ModItems.FIRE_BRICK);
        simpleItem(ModItems.ECHO_DUST);
        simpleItem(ModItems.ECHO_INGOT);
        simpleItem(ModItems.TELEPORTER);

        simplerBlockItem(ModBlocks.ECHO_BLOCK);
        simplerBlockItem(ModBlocks.COPPER_FILTER);
        simplerBlockItem(ModBlocks.DIAMOND_FILTER);
        simplerBlockItem(ModBlocks.NETHERITE_FILTER);

        registerColoredBlockModels("white","concrete");
        registerColoredBlockModels("orange","concrete");
        registerColoredBlockModels("magenta","concrete");
        registerColoredBlockModels("light_blue","concrete");
        registerColoredBlockModels("yellow","concrete");
        registerColoredBlockModels("lime","concrete");
        registerColoredBlockModels("pink","concrete");
        registerColoredBlockModels("gray","concrete");
        registerColoredBlockModels("light_gray","concrete");
        registerColoredBlockModels("cyan","concrete");
        registerColoredBlockModels("purple","concrete");
        registerColoredBlockModels("blue","concrete");
        registerColoredBlockModels("brown","concrete");
        registerColoredBlockModels("green","concrete");
        registerColoredBlockModels("red","concrete");
        registerColoredBlockModels("black","concrete");

    }

    private void registerColoredBlockModels(String color, String type){
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

        simpleBlockItem(doorBlock);
        fenceItem(fenceBlock, baseBlock);
        buttonItem(buttonBlock, baseBlock);
        wallItemMinecraftTexture(wallBlock, baseBlock);
        simplerBlockItem(stairsBlock);
        simplerBlockItem(slabBlock);
        simplerBlockItem(pressurePlateBlock);
        simplerBlockItem(fenceGateBlock);
        trapdoorItem(trapdoorBlock);
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
    public void fenceItem(Block block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),mcLoc("block/fence_inventory"))
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
    public void buttonItem(Block block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),mcLoc("block/button_inventory"))
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
    public void trapdoorItem(Block block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_bottom"));
    }
    public  void wallItemMinecraftTexture(RegistryObject<Block> block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("wall",new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public  void wallItemMinecraftTexture(Block block, Block baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),mcLoc("block/wall_inventory"))
                .texture("wall",new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedVanillaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(Block block){
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedVanillaMod.MOD_ID,"item/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    public void simplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(EnhancedVanillaMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void simplerBlockItem(Block block){
        this.withExistingParent(EnhancedVanillaMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block).getPath(),
            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

}