package com.varrojalo.enhancedvanillamod.compat;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.recipe.PulverizerBlockRecipe;
import com.varrojalo.enhancedvanillamod.screen.PulverizerBlockScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIEnhancedVanillaModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EnhancedVanillaMod.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PulverizingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<PulverizerBlockRecipe> pulverizerRecipes = recipeManager.getAllRecipesFor(PulverizerBlockRecipe.Type.INSTANCE);
        registration.addRecipes(PulverizingCategory.PULVERIZING_TYPE,pulverizerRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PulverizerBlockScreen.class, 79,35,16,16,
                PulverizingCategory.PULVERIZING_TYPE);
    }
}
