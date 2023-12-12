package com.varrojalo.enhancedvanillamod.block.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.PointedDripstoneFeature;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;

public class InsulatedCopperWire extends CopperWire{

    public static final int DEFAULT_COLOR = 16777215;
    private int blockColor = DEFAULT_COLOR;
    public InsulatedCopperWire(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        return;
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        /*if (!pPlayer.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        } else {
            if (super.isCross(pState) || super.isDot(pState)) {
                BlockState blockstate = isCross(pState) ? this.defaultBlockState() : this.crossState;
                blockstate = blockstate.setValue(POWER, pState.getValue(POWER));
                blockstate = this.getConnectionState(pLevel, blockstate, pPos);
                if (blockstate != pState) {
                    pLevel.setBlock(pPos, blockstate, 3);
                    this.updatesOnShapeChange(pLevel, pPos, pState, blockstate);
                    return InteractionResult.SUCCESS;
                }
            }

            return InteractionResult.PASS;
        }*/


        if(!pLevel.isClientSide())
        {
            if(pPlayer.getItemInHand(pHand).getItem() instanceof DyeItem)
            {
                DyeItem clickedWithDye = (DyeItem) pPlayer.getItemInHand(pHand).getItem();
                DyeColor dyeColor = clickedWithDye.getDyeColor();

                pPlayer.playSound(SoundEvents.DYE_USE,1,1);
                this.setColor(dyeColor);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos,GameEvent.Context.of(pState));
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    public void setColor(DyeColor pDyeColor)
    {
        this.blockColor =pDyeColor.getFireworkColor();
    }

}
