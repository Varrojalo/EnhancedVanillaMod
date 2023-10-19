package com.varrojalo.enhancedvanillamod.datagen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final List<ItemLike> FIRE_BRICk_BLASTABLES = List.of(Items.BRICK);
    public static final List<ItemLike> FIRE_BRICK_SMELTABLES = List.of(Items.NETHER_BRICK);

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, EnhancedVanillaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
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


    }


}
