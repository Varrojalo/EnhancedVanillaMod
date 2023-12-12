package com.varrojalo.enhancedvanillamod.item.custom;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.util.ModTags;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

public class FireBrickItem extends Item {
    public FireBrickItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide()){
            BlockPos position = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            BlockState state = pContext.getLevel().getBlockState(position);

            if (state.is(ModTags.Blocks.FIRE_BRICKABLE)) {
                player.sendSystemMessage(Component.literal("Object Found"));


                //1. Get the block been clicked
                Block clickedBlock = state.getBlock();
                //2. Get what type of block is
                //3. Get if it is cooking/blasting/smelting something
                //3.1.0. if so update the cooking/blasting/smelting speed to 2x to smelt it faster
                this.tickFurnaces(position, pContext.getLevel());
                //3.1.1. then shrink the stack of firebricks by one
                pContext.getItemInHand().shrink(1);
                //3.2. If not then dont do anything

            }

        }
        return InteractionResult.SUCCESS;
    }

    @SuppressWarnings("unchecked")
    private <T extends BlockEntity> void tickFurnaces(BlockPos frontPos, BlockState frontState, Level level, T tile) {
        if (tile != null) {
            BlockEntityTicker<T> ticker = (BlockEntityTicker<T>) frontState.getTicker(level, tile.getType());
            if (ticker != null) {
                ticker.tick(level, frontPos, frontState, tile);
            }
        }
    }

    private void tickFurnaces(BlockPos pos, Level level) {
        BlockState state = level.getBlockState(pos);
        if (state.is(ModTags.Blocks.FIRE_BRICKABLE)) {
            BlockEntity te = level.getBlockEntity(pos);
            this.tickFurnaces(pos, state, level, te);
        }
        //maybe lower chance
        else if (state instanceof ChangeOverTimeBlock && level instanceof ServerLevel serverLevel) {
            state.randomTick(serverLevel, pos, level.random);
        }
    }
}
