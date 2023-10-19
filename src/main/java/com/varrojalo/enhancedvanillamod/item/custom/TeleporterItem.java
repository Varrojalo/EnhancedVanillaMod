package com.varrojalo.enhancedvanillamod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleporterItem extends Item {

    private boolean isInitPositionSet = false;
    private BlockPos initialPosition;
    public TeleporterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide()){
            Player player = pContext.getPlayer();
            BlockPos position = pContext.getClickedPos();

            if(!isInitPositionSet){
                setInitPos(position);
                player.sendSystemMessage(Component.literal("Initial position setted!"));
            }
            else {
                player.sendSystemMessage(Component.literal("Teleporting, please don´t move"));
                pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                        player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));

                pContext.getLevel().gameEvent(GameEvent.TELEPORT,player.position(), GameEvent.Context.of(pContext.getPlayer()));
                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 5f,.5f);
                player.teleportTo(initialPosition.getX(),initialPosition.getY(),initialPosition.getZ());

            }

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        if(isInitPositionSet)
        {
            pTooltipComponents.add(Component.translatable("tooltip.enhancedvanillamod.teleporter_setted.tooltip")
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD).withBold(true)));
            pTooltipComponents.add(Component.literal(initialPosition.getX() + "," +initialPosition.getY() + "," + initialPosition.getZ())
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
    }

    private void setInitPos(BlockPos position) {
        isInitPositionSet = true;

        int xPos = position.getX();
        int yPos = position.getY() + 1;
        int zPos = position.getZ();

        initialPosition = new BlockPos(xPos,yPos,zPos);
    }
}
