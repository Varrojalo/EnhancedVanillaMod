package com.varrojalo.enhancedvanillamod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.varrojalo.enhancedvanillamod.block.entity.PulverizerBlockEntity;
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

public class PulverizerBlockEntityRenderer implements BlockEntityRenderer<PulverizerBlockEntity> {

    public PulverizerBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(PulverizerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack renderStack = pBlockEntity.getRenderStack();

        pPoseStack.pushPose();
        pPoseStack.translate(.5f,.58f,.5f);
        pPoseStack.scale(1.5f,1.5f,1.5f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(270f));

        itemRenderer.renderStatic(renderStack, ItemDisplayContext.FIXED,getLightLevel(pBlockEntity.getLevel(),pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY,pPoseStack,pBuffer,pBlockEntity.getLevel(),1);

        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos){
        int bLight = level.getBrightness(LightLayer.BLOCK,pos);
        int sLight = level.getBrightness(LightLayer.SKY,pos);
        return LightTexture.pack(bLight,sLight);
    }
}
