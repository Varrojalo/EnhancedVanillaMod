package com.varrojalo.enhancedvanillamod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.varrojalo.enhancedvanillamod.block.entity.FeederBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class FeederBlockEntityRenderer implements BlockEntityRenderer<FeederBlockEntity> {

    public FeederBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }
    @Override
    public void render(FeederBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack renderStack = pBlockEntity.getRenderStack();

        pPoseStack.pushPose();

        float scaleY = getRenderBlockYScale(pBlockEntity);
        float translateY = 0.253f * scaleY + 0.127f;

        pPoseStack.translate(.5f,translateY,.5f);
        pPoseStack.scale(1.5f,scaleY,1.5f);

        itemRenderer.renderStatic(renderStack, ItemDisplayContext.FIXED,getLightLevel(pBlockEntity.getLevel(),pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY,pPoseStack,pBuffer,pBlockEntity.getLevel(),1);

        pPoseStack.popPose();
    }

    private float getRenderBlockYScale(FeederBlockEntity blockEntity){
        int foodInSlot = blockEntity.itemStackHandler.getStackInSlot(0).getCount();
        float scale = 1f;
        float translateY = .38f;


        return (float) foodInSlot / 64;

    }
    private int getLightLevel(Level level, BlockPos pos){
        int bLight = level.getBrightness(LightLayer.BLOCK,pos);
        int sLight = level.getBrightness(LightLayer.SKY,pos);
        return LightTexture.pack(bLight,sLight);
    }
}
