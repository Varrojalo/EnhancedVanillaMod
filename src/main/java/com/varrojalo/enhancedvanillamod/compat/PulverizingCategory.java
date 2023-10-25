package com.varrojalo.enhancedvanillamod.compat;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.recipe.PulverizerBlockRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PulverizingCategory implements IRecipeCategory<PulverizerBlockRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(EnhancedVanillaMod.MOD_ID,"pulverizing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedVanillaMod.MOD_ID,
            "textures/gui/pulverizer_block_gui.png");

    public static final RecipeType<PulverizerBlockRecipe> PULVERIZING_TYPE =
            new RecipeType<>(UID, PulverizerBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public PulverizingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,3,4,170,79);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PULVERIZER_BLOCK.get()));

    }


    @Override
    public RecipeType<PulverizerBlockRecipe> getRecipeType() {
        return PULVERIZING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.enhancedvanillamod.pulverizer_block");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PulverizerBlockRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,77, 13).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT,77, 49).addItemStack(recipe.getResultItem(null));
    }
}
