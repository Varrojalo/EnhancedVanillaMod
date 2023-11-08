package com.varrojalo.enhancedvanillamod.block.custom;

import com.varrojalo.enhancedvanillamod.block.entity.ClockBlockEntity;
import com.varrojalo.enhancedvanillamod.block.entity.ModBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ClockBlock extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Shapes.block();
    public boolean isSignalOn = true;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public ClockBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT,Boolean.valueOf(true)));

    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {


        ClockBlockEntity blockEntity = (ClockBlockEntity) pLevel.getBlockEntity(pPos);

        blockEntity.toggleClock();
        pLevel.setBlock(pPos,pState.cycle(LIT),2);
        this.defaultBlockState().setValue(LIT,blockEntity.clockIsActive());

        if(blockEntity.clockIsActive())
            pPlayer.sendSystemMessage(Component.literal("clock signal: " + this.isSignalOn ));
        return InteractionResult.SUCCESS;
    }
    
    //TODO: Make the clock update the redstone beside it so it turns off when the clock is off
    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (pState.getValue(LIT) == this.hasNeighborSignal(pLevel, pPos, pState) && !pLevel.getBlockTicks().willTickThisTick(pPos, this)) {
            pLevel.scheduleTick(pPos, this, 2);
        }
    }
    protected boolean hasNeighborSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        return pLevel.hasSignal(pPos.north(), Direction.NORTH);
    }
    @Override
    public int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        if(this.defaultBlockState().getValue(LIT))
        {
            return 15;
        }
        else
        {
            return 0;
        }
    }
    @Override
    public boolean isSignalSource(BlockState pState) {
        return this.defaultBlockState().getValue(LIT);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ClockBlockEntity(pPos,pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()){
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlocksEntities.CLOCK_BLOCK_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}
