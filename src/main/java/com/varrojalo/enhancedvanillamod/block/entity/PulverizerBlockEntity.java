package com.varrojalo.enhancedvanillamod.block.entity;

import com.varrojalo.enhancedvanillamod.item.ModItems;
import com.varrojalo.enhancedvanillamod.recipe.PulverizerBlockRecipe;
import com.varrojalo.enhancedvanillamod.screen.PulverizerBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PulverizerBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemStackHandler = new ItemStackHandler(2){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            switch (pIndex){
                case 0:
                    return PulverizerBlockEntity.this.progress;
                case 1:
                    return PulverizerBlockEntity.this.maxProgress;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex){
                case 0 -> PulverizerBlockEntity.this.progress = pValue;
                case 1 -> PulverizerBlockEntity.this.maxProgress = pValue;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };;
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public PulverizerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlocksEntities.PULVERIZER_BE.get(), pPos, pBlockState);
    }


    private int progress = 0;
    private int maxProgress = 78;

    public ItemStack getRenderStack(){

        if(itemStackHandler.getStackInSlot(INPUT_SLOT).isEmpty() && itemStackHandler.getStackInSlot(OUTPUT_SLOT).isEmpty())
        {
            return itemStackHandler.getStackInSlot(OUTPUT_SLOT);
        }
        else
        {
            if(itemStackHandler.getStackInSlot(INPUT_SLOT).isEmpty())
            {
                if(Block.byItem(itemStackHandler.getStackInSlot(OUTPUT_SLOT).getItem()) != Blocks.AIR)
                {
                    return itemStackHandler.getStackInSlot(OUTPUT_SLOT);
                }
                else {
                    return new ItemStack(Items.BLACKSTONE);
                }
            }
            else {
                if(Block.byItem(itemStackHandler.getStackInSlot(INPUT_SLOT).getItem()) != Blocks.AIR)
                {
                    return itemStackHandler.getStackInSlot(INPUT_SLOT);
                }
                else {
                    return new ItemStack(Items.BLACKSTONE);
                }

            }
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();

        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i,itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhancedvanillamod.pulverizer_block");
    }


    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory,  Player pPlayer) {
        return new PulverizerBlockMenu(pContainerId,pPlayerInventory,this,this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemStackHandler.serializeNBT());
        pTag.putInt("pulverizer_block.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("pulverizer_block.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()){
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()){
                craftItem();
                resetProgress();
            }
        }
        else
        {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<PulverizerBlockRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(null);
        this.itemStackHandler.extractItem(INPUT_SLOT,1,false);
        this.itemStackHandler.setStackInSlot(OUTPUT_SLOT,new ItemStack(result.getItem(),
                this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));

    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<PulverizerBlockRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }
        ItemStack result = recipe.get().getResultItem(null);

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<PulverizerBlockRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemStackHandler.getSlots());

        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i,this.itemStackHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(PulverizerBlockRecipe.Type.INSTANCE,inventory,level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return  this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();

    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
