package com.varrojalo.enhancedvanillamod.block.entity;

import com.varrojalo.enhancedvanillamod.screen.CopperFilterBlockMenu;
import com.varrojalo.enhancedvanillamod.screen.NetheriteFilterBlockMenu;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.varrojalo.enhancedvanillamod.block.custom.CopperFilterBlock.FACING;

public class NetheriteFilterBlockEntity extends BlockEntity implements MenuProvider {
    public static final int FILTER_SLOT_1 = 0;
    public static final int FILTER_SLOT_2 = 1;
    public static final int FILTER_SLOT_3 = 2;
    public static final int INVENTORY_SLOT_1 = 3;
    public static final int INVENTORY_SLOT_2 = 4;
    public static final int INVENTORY_SLOT_3 = 5;
    public static final Direction BACK_DIRECTION = Direction.SOUTH;
    public static final Direction BELLOW_DIRECTION = Direction.DOWN;

    private int timer = 0;
    public final ItemStackHandler itemStackHandler = new ItemStackHandler(6){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };
    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return 0;
        }

        @Override
        public void set(int pIndex, int pValue) {

        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    public NetheriteFilterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlocksEntities.NETHERITE_FILTER_BE.get(),pPos, pBlockState);
    }

    public ItemStack getRenderStack() {
        if(this.itemStackHandler.getStackInSlot(FILTER_SLOT_1).isEmpty())
            return this.itemStackHandler.getStackInSlot(FILTER_SLOT_2);
        else if(this.itemStackHandler.getStackInSlot(FILTER_SLOT_2).isEmpty())
            return this.itemStackHandler.getStackInSlot(FILTER_SLOT_3);
        else
            return this.itemStackHandler.getStackInSlot(FILTER_SLOT_1);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhancedvanillamod.netherite_filter");
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

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new NetheriteFilterBlockMenu(pContainerId,pPlayerInventory,this,this.data);
    }
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemStackHandler.serializeNBT());
        super.saveAdditional(pTag);
    }
    @Override
    public void load(CompoundTag pTag) {
        super.onLoad();
        this.itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(this.itemStackHandler.getSlots());
        for (int i = 0; i < this.itemStackHandler.getSlots(); i++) {
            inventory.setItem(i,this.itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,inventory);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // filter slot = 0, Inventory Slots = 1-3
        if (this.timer % 20 == 0)
        {
            ItemStack inv1Items = this.itemStackHandler.getStackInSlot(INVENTORY_SLOT_1);
            ItemStack inv2Items = this.itemStackHandler.getStackInSlot(INVENTORY_SLOT_2);
            ItemStack inv3Items = this.itemStackHandler.getStackInSlot(INVENTORY_SLOT_3);

            Item filter1Item = this.itemStackHandler.getStackInSlot(FILTER_SLOT_1).getItem();
            Item filter2Item = this.itemStackHandler.getStackInSlot(FILTER_SLOT_2).getItem();
            Item filter3Item = this.itemStackHandler.getStackInSlot(FILTER_SLOT_3).getItem();


            if (!isStackEmpty(inv1Items))
            {
                if(inv1Items.getItem() == filter1Item || inv1Items.getItem() == filter2Item || inv1Items.getItem() == filter3Item)
                {
                    dispense(inv1Items,BELLOW_DIRECTION);
                }
                else
                {
                    dispense(inv1Items,BACK_DIRECTION);
                }
            }
            if (!isStackEmpty(inv2Items))
            {
                if(inv2Items.getItem() == filter1Item || inv2Items.getItem() == filter2Item || inv2Items.getItem() == filter3Item)
                {
                    dispense(inv2Items,BELLOW_DIRECTION);
                }
                else
                {
                    dispense(inv2Items,BACK_DIRECTION);
                }
            }
            if (!isStackEmpty(inv3Items))
            {
                if(inv3Items.getItem() == filter1Item || inv3Items.getItem() == filter2Item || inv3Items.getItem() == filter3Item)
                {
                    dispense(inv3Items,BELLOW_DIRECTION);
                }
                else
                {
                    dispense(inv3Items,BACK_DIRECTION);
                }
            }

            this.timer = 0;
        }
        this.timer++;
    }

    private boolean isStackEmpty(ItemStack itemStack)
    {
        return itemStack.isEmpty();
    }
    public final ItemStack dispense(ItemStack pStack, Direction pDirection) {
        BlockSourceImpl blockSource = new BlockSourceImpl((ServerLevel) this.level,this.getBlockPos());
        Direction facingDirection = blockSource.getBlockState().getValue(FACING);
        Direction dropDirection = pDirection == BACK_DIRECTION ? facingDirection.getOpposite() : BELLOW_DIRECTION;

        ItemStack itemstack = this.execute(pStack, dropDirection);
        this.playSound();
        this.playAnimation(dropDirection);
        return itemstack;
    }
    protected ItemStack execute(ItemStack pStack, Direction pDirection) {

        Position position = getDropPosition(pDirection);
        ItemStack itemstack = pStack.split(1);
        spawnItem(this.level, itemstack, 1, pDirection, position);
        return pStack;
    }
    public Position getDropPosition(Direction pDirection) {
        double offset = 0.7D;
        double dx = this.getBlockPos().getX() + offset * (double)pDirection.getStepX();
        double dy = this.getBlockPos().getY() + offset * (double)pDirection.getStepY();
        double dz = this.getBlockPos().getZ() + offset * (double)pDirection.getStepZ();
        return new PositionImpl(dx, dy, dz);
    }
    public static void spawnItem(Level pLevel, ItemStack pStack, int pSpeed, Direction pFacing, Position pPosition) {
        double dx = pPosition.x() + 0.25D;
        double dy = pPosition.y() + 0.25D;
        double dz = pPosition.z() + 0.25D;


        ItemEntity itementity = new ItemEntity(pLevel, dx, dy, dz, pStack);
        double d3 = 0.3D;
        double triangleX = (double)pFacing.getStepX() * d3;
        double triangleY = (double)pFacing.getStepY() * d3;
        double triangleZ = (double)pFacing.getStepZ() * d3;

        itementity.setDeltaMovement(triangleX,triangleY,triangleZ);
        pLevel.addFreshEntity(itementity);
    }

    /**
     * Play the dispense sound from the specified block.
     */
    protected void playSound() {
        this.level.levelEvent(LevelEvent.SOUND_DISPENSER_DISPENSE,this.getBlockPos(),0);
    }

    /**
     * Order clients to display dispense particles from the specified block and facing.
     */
    protected void playAnimation(Direction pFacing) {
        this.level.levelEvent(LevelEvent.PARTICLES_SHOOT,this.getBlockPos(),pFacing.get3DDataValue());
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
