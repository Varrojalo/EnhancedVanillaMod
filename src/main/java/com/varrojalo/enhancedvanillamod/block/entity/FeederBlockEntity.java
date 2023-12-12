package com.varrojalo.enhancedvanillamod.block.entity;

import com.varrojalo.enhancedvanillamod.screen.FeederBlockMenu;
import com.varrojalo.enhancedvanillamod.screen.PulverizerBlockMenu;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FeederBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemStackHandler = new ItemStackHandler(2){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };
    private int tickCounter = 0;
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return 0;
        }

        @Override
        public void set(int pIndex, int pValue) {

        }

        @Override
        public int getCount() {
            return 1;
        }
    };
    private static final float FEEDING_RANGE = 2f;
    public static final int FOOD_SLOT = 0;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public FeederBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlocksEntities.FEEDER_BE.get(), pPos, pBlockState);
    }
    public ItemStack getRenderStack(){

        if(itemStackHandler.getStackInSlot(FOOD_SLOT).isEmpty())
        {
            return itemStackHandler.getStackInSlot(FOOD_SLOT);
        }
        else
        {
            return new ItemStack(Items.HAY_BLOCK);
        }

    }
    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhancedvanillamod.feeder");
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
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FeederBlockMenu(pContainerId,pPlayerInventory,this,this.data);
    }
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemStackHandler.serializeNBT());
        super.saveAdditional(pTag);
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(this.tickCounter % 20 == 0)
        {
            if(!isEmpty())
            {
                List<Animal> nearbyAnimals = getNearbyAnimals(pPos);
                feedAnimals(nearbyAnimals);
            }
        }
        this.tickCounter ++;
    }

    private List<Animal> getNearbyAnimals(BlockPos pPos) {
        AABB boundingBox = AABB.ofSize(pPos.getCenter(),FEEDING_RANGE, FEEDING_RANGE,FEEDING_RANGE);
        return  this.level.getEntitiesOfClass(Animal.class,boundingBox);
    }

    private boolean isEmpty(){
        return this.itemStackHandler.getStackInSlot(0).isEmpty();
    }
    private void shrinkFoodInInventory() {
        this.itemStackHandler.getStackInSlot(0).shrink(1);
    }

    private void feedAnimals(List<Animal> animalsList) {
        ItemStack slotFood = this.itemStackHandler.getStackInSlot(0);
        for (int i = 0; i < animalsList.size() ; i++) {
            Animal animalI = animalsList.get(i);
            if(animalI.isFood(slotFood) && !animalI.isBaby() && animalI.canFallInLove()) {
                animalI.eat(this.level, slotFood);
                animalI.setInLove(null);
                shrinkFoodInInventory();
            }
        }

        animalsList.forEach(Animal::resetLove);

    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i,itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,inventory);
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
