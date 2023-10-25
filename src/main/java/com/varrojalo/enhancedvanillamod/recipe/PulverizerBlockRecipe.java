package com.varrojalo.enhancedvanillamod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class PulverizerBlockRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;

    public PulverizerBlockRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide())
        {
            return false;
        }
        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PulverizerBlockRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String id = "pulverizing";
    }

    public static class Serializer implements RecipeSerializer<PulverizerBlockRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation id = new ResourceLocation(EnhancedVanillaMod.MOD_ID,"pulverizing");
        @Override
        public PulverizerBlockRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe,"output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe,"ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1,Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i,Ingredient.fromJson(ingredients.get(i)));
            }

            return new PulverizerBlockRecipe(inputs,output,pRecipeId);
        }

        @Override
        public @Nullable PulverizerBlockRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(),Ingredient.EMPTY);

            for (int i = 0; i < inputs.size() ;i++) {
                inputs.set(i,Ingredient.fromNetwork(pBuffer));
            }
            ItemStack output = pBuffer.readItem();
            return new PulverizerBlockRecipe(inputs,output,pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, PulverizerBlockRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());
            for (Ingredient ing : pRecipe.getIngredients()){
                ing.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(null),false);
        }
    }
}
