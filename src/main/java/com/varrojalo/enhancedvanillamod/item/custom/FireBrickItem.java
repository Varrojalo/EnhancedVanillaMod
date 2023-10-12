package com.varrojalo.enhancedvanillamod.item.custom;

import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

            if (state.is(Blocks.FURNACE) || state.is(Blocks.BLAST_FURNACE) || state.is(Blocks.SMOKER)) {
                player.sendSystemMessage(Component.literal("Object Found"));


                //1. Get the block been clicked
                Block clickedBlock = state.getBlock();
                //2. Get what type of block is
                //3. Get if it is cooking/blasting/smelting something
                //3.1.0. if so update the cooking/blasting/smelting speed to 2x to smelt it faster
                //3.1.1. then shrink the stack of firebricks by one
                pContext.getItemInHand().shrink(1);
                //3.2. If not then dont do anything

            }

        }
        return InteractionResult.SUCCESS;
    }
}
