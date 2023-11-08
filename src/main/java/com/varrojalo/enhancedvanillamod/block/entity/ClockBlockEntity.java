package com.varrojalo.enhancedvanillamod.block.entity;

import com.varrojalo.enhancedvanillamod.block.custom.ClockBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ClockBlockEntity extends BlockEntity {

    int timer = 0;
    private boolean isActive;

    public ClockBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlocksEntities.CLOCK_BLOCK_BE.get(), pPos, pBlockState);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {

        if(pLevel.isClientSide()){
            this.timer++;

            System.out.println("Timer: " + this.timer);
            if(this.timer > 20)
            {

                ClockBlock clockBlock = (ClockBlock) pState.getBlock();
                if(clockIsActive())
                {
                    switchClockSignal(clockBlock);

                }
                else {
                    clockOff(clockBlock);
                }

                this.timer = 0;
            }
        }
    }

    private void switchClockSignal(ClockBlock clockBlock) {
        clockBlock.isSignalOn = updateClockSignal(clockBlock.isSignalOn);
    }

    private void clockOff(ClockBlock clockBlock) {
        clockBlock.isSignalOn = false;
    }

    public boolean updateClockSignal(boolean prevState){

        return !prevState;
    }

    public void toggleClock(){
        this.isActive = !this.isActive;
    }


    public String getClockState(){
        return this.isActive ? "ON" : "OFF";
    }
    public boolean clockIsActive() {
        return this.isActive;
    }
}
