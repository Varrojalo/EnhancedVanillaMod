package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.item.ModItems;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final List<ItemLike> FIRE_BRICk_BLASTABLES = List.of(Items.BRICK);
    public static final List<ItemLike> FIRE_BRICK_SMELTABLES = List.of(Items.NETHER_BRICK);

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter,FIRE_BRICk_BLASTABLES,RecipeCategory.MISC,ModItems.FIRE_BRICK.get(),0.2F,100,"fire_brick");
        oreSmelting(pWriter,FIRE_BRICK_SMELTABLES,RecipeCategory.MISC,ModItems.FIRE_BRICK.get(),0.6F,200, "fire_brick");

        oreSmelting(pWriter,List.of(ModItems.ECHO_DUST.get()),RecipeCategory.MISC,ModItems.ECHO_INGOT.get(), 1F, 300,"echo_items");
        oreBlasting(pWriter,List.of(ModItems.ECHO_DUST.get()),RecipeCategory.MISC,ModItems.ECHO_INGOT.get(), 0.8F, 150,"echo_items");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.TELEPORTER.get())
                .pattern(" I ")
                .pattern("IEI")
                .pattern(" I ")
                .define('E',Items.ENDER_PEARL)
                .define('I',ModItems.ECHO_INGOT.get())
                .unlockedBy(getHasName(Items.ENDER_PEARL),has(Items.ENDER_PEARL))
                .unlockedBy(getHasName(ModItems.ECHO_INGOT.get()),has(ModItems.ECHO_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CLOCK_BLOCK.get())
                .pattern("$%$")
                .pattern("%#%")
                .pattern("$%$")
                .define('$',Items.REDSTONE)
                .define('%',Items.COPPER_BLOCK)
                .define('#',Items.CLOCK)
                .unlockedBy(getHasName(Items.REDSTONE),has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.COPPER_BLOCK),has(Items.COPPER_BLOCK))
                .unlockedBy(getHasName(Items.CLOCK),has(Items.CLOCK))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FILTER.get())
                .pattern("$#$")
                .pattern("#M#")
                .pattern("$#$")
                .define('M',ModItems.MESH.get())
                .define('$',Items.DIAMOND)
                .define('#',Items.REDSTONE)
                .unlockedBy(getHasName(Items.DIAMOND),has(Items.DIAMOND))
                .unlockedBy(getHasName(Items.REDSTONE),has(Items.REDSTONE))
                .unlockedBy(getHasName(ModItems.MESH.get()),has(ModItems.MESH.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.MESH.get())
                .pattern("$#$")
                .pattern("###")
                .pattern("$#$")
                .define('#',Items.IRON_INGOT)
                .define('$',Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT),has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET),has(Items.IRON_NUGGET))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.PULVERIZER_BLOCK.get())
                .pattern("B B")
                .pattern("CSC")
                .pattern("CRC")
                .define('B', Blocks.BLACKSTONE)
                .define('C', Items.COPPER_INGOT)
                .define('S', Blocks.SMOOTH_STONE_SLAB)
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(Items.COPPER_INGOT),has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(Items.REDSTONE),has(Items.REDSTONE))
                .unlockedBy(getHasName(Blocks.BLACKSTONE),has(Blocks.BLACKSTONE))
                .unlockedBy(getHasName(Blocks.SMOOTH_STONE_SLAB),has(Blocks.SMOOTH_STONE_SLAB))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.FILTERED_HOPPER.get())
                .requires(Items.HOPPER)
                .requires(ModItems.FILTER.get())
                .unlockedBy(getHasName(ModItems.FILTER.get()),has(ModItems.FILTER.get()))
                .unlockedBy(getHasName(Items.HOPPER),has(Items.HOPPER))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter,RecipeCategory.MISC,ModItems.ECHO_INGOT.get(),RecipeCategory.BUILDING_BLOCKS,ModBlocks.ECHO_BLOCK.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,ModBlocks.COPPER_WIRE.get())
                .pattern("CRC")
                .define('C', Items.COPPER_INGOT)
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(Items.COPPER_INGOT),has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(Items.REDSTONE),has(Items.REDSTONE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.COPPER_FILTER.get())
                .pattern("CCC")
                .pattern("CFC")
                .pattern("CCC")
                .define('C', Items.COPPER_INGOT)
                .define('F', ModItems.FILTER.get())
                .unlockedBy(getHasName(Items.COPPER_INGOT),has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(ModItems.FILTER.get()),has(ModItems.FILTER.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.DIAMOND_FILTER.get())
                .pattern("DDD")
                .pattern("DCD")
                .pattern("DDD")
                .define('C', ModBlocks.COPPER_FILTER.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModBlocks.COPPER_FILTER.get()),has(ModBlocks.COPPER_FILTER.get()))
                .unlockedBy(getHasName(Items.DIAMOND),has(Items.DIAMOND))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.NETHERITE_FILTER.get())
                .pattern("NNN")
                .pattern("NDN")
                .pattern("NNN")
                .define('D', ModBlocks.DIAMOND_FILTER.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(ModBlocks.DIAMOND_FILTER.get()),has(ModBlocks.DIAMOND_FILTER.get()))
                .unlockedBy(getHasName(Items.NETHERITE_INGOT),has(Items.NETHERITE_INGOT))
                .save(pWriter);



        advanceColorConcreteCrafting("white",pWriter);
        advanceColorConcreteCrafting("orange",pWriter);
        advanceColorConcreteCrafting("magenta",pWriter);
        advanceColorConcreteCrafting("light_blue",pWriter);
        advanceColorConcreteCrafting("yellow",pWriter);
        advanceColorConcreteCrafting("lime",pWriter);
        advanceColorConcreteCrafting("pink",pWriter);
        advanceColorConcreteCrafting("gray",pWriter);
        advanceColorConcreteCrafting("light_gray",pWriter);
        advanceColorConcreteCrafting("cyan",pWriter);
        advanceColorConcreteCrafting("purple",pWriter);
        advanceColorConcreteCrafting("blue",pWriter);
        advanceColorConcreteCrafting("brown",pWriter);
        advanceColorConcreteCrafting("green",pWriter);
        advanceColorConcreteCrafting("red",pWriter);
        advanceColorConcreteCrafting("black",pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTIme,
                pGroup,
                "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, EnhancedVanillaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


    protected  static void  stoneCutting(String color, String suffix, Block pBlock, ItemLike pResult, int pCount, Consumer<FinishedRecipe> pWriter){
        String pRecipeId =  color +"_concrete_" + suffix + "_from_stonecutting_" + color + "_concrete";

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pBlock),RecipeCategory.DECORATIONS,pResult,pCount)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter,pRecipeId);
    }
    protected static void concreteTrapdoorCrafting(RecipeCategory category, Block pSlabBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category,pResultBlock)
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .define('#', pSlabBlock)
                .unlockedBy(getHasName(pSlabBlock),has(pSlabBlock))
                .save(pWriter);
    }

    protected static void concreteDoorCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category,pResultBlock,3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', pBlock)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);
    }
    protected static void concreteFenceCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category, pResultBlock, 3)
                .pattern("W#W")
                .pattern("W#W")
                .define('W', pBlock)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);;
    }
    protected static void concreteFenceGateCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category, pResultBlock, 3)
                .pattern("#W#")
                .pattern("#W#")
                .define('W', pBlock)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);;
    }
    protected static void concreteStairsCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category, pResultBlock, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', pBlock)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);;
    }
    protected static void concreteSlabCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category, pResultBlock, 6)
                .pattern("###")
                .define('#', pBlock)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);;
    }
    protected static void concretePressurePlateCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(category, pResultBlock)
                .pattern("##")
                .define('#', pBlock)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);;
    }
    protected static void concreteButtonCrafting(RecipeCategory category, Block pBlock, Block pResultBlock,Consumer<FinishedRecipe> pWriter){
        ShapelessRecipeBuilder.shapeless(category,pResultBlock)
                .requires(pBlock)
                .unlockedBy(getHasName(pBlock),has(pBlock))
                .save(pWriter);
    }
    private void advanceColorConcreteCrafting(String color,Consumer<FinishedRecipe> pWriter){
        Block pBlock = getBaseConcrete(color);
        Block pStair = getDecoConcrete(color, "stairs");
        Block pSlab = getDecoConcrete(color, "slab");
        ItemLike pWall = getDecoConcrete(color, "wall");
        Block pPressurePlate = getDecoConcrete(color, "pressure_plate");
        Block pDoor = getDecoConcrete(color, "door");
        Block pTrapdoor = getDecoConcrete(color, "trapdoor");
        Block pButton = getDecoConcrete(color, "button");
        Block pFence = getDecoConcrete(color, "fence");
        Block pFenceGate = getDecoConcrete(color, "fence_gate");

        stoneCutting(color, "stairs",pBlock,pStair,1,pWriter);
        concreteStairsCrafting(RecipeCategory.DECORATIONS, pBlock, pStair,pWriter);
        stoneCutting(color,"slab",pBlock,pSlab,2,pWriter);
        concreteSlabCrafting(RecipeCategory.DECORATIONS, pBlock, pSlab,pWriter);
        stoneCutting(color,"wall",pBlock,pWall,1,pWriter);
        //wallBuilder(RecipeCategory.DECORATIONS,pWall,Ingredient.of(pBlock));
        concretePressurePlateCrafting(RecipeCategory.DECORATIONS, pBlock, pPressurePlate,pWriter);
        concreteDoorCrafting(RecipeCategory.DECORATIONS, pBlock, pDoor,pWriter);
        concreteTrapdoorCrafting(RecipeCategory.DECORATIONS, pSlab, pTrapdoor,pWriter);
        concreteButtonCrafting(RecipeCategory.DECORATIONS, pBlock, pButton,pWriter);
        concreteFenceCrafting(RecipeCategory.DECORATIONS, pBlock, pFence,pWriter);
        concreteFenceGateCrafting(RecipeCategory.DECORATIONS, pBlock, pFenceGate,pWriter);
    }

    public static Block getBaseConcrete(String color) {
        return ForgeRegistries.BLOCKS.getEntries()
                .stream()
                .filter(entry -> entry.getKey().location().getPath().equals(color + "_concrete"))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalStateException("Failed to find concrete with color: " + color));
    }
    public static Block getDecoConcrete(String color, String suffix) {
        return ForgeRegistries.BLOCKS.getEntries()
                .stream()
                .filter(entry -> entry.getKey().location().getPath().equals(color + "_concrete_" + suffix))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalStateException("Failed to find concrete with color: " + color + "_" + suffix));
    }

}
