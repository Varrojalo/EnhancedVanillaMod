package com.varrojalo.enhancedvanillamod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ClockBlock extends PoweredBlock {

    private int delayTime = 20; //200 ticks equals 10 seconds so 20 ticks equals a secons
    private boolean isBlockActive = false;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public ClockBlock(Properties pProperties) {
        super(pProperties);

    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        pPlayer.sendSystemMessage(Component.literal("click"));
        isBlockActive = !isBlockActive;
        UpdateClock();
        return InteractionResult.SUCCESS;
    }


    @Override
    public int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        return 15;
    }
    @Override
    public boolean isSignalSource(BlockState pState) {
        return isBlockActive;
    }

    private void UpdateClock() {
    }
}
