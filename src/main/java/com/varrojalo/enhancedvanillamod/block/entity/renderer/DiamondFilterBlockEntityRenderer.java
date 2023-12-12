package com.varrojalo.enhancedvanillamod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.varrojalo.enhancedvanillamod.block.entity.DiamondFilterBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

import static com.varrojalo.enhancedvanillamod.block.custom.CopperFilterBlock.FACING;

public class DiamondFilterBlockEntityRenderer implements BlockEntityRenderer<DiamondFilterBlockEntity> {
    double translateX =  0D;
    double translateZ = 0D;
    float rotation = 0;
    public DiamondFilterBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }
    @Override
    public void render(DiamondFilterBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack renderStack = pBlockEntity.getRenderStack();

        Direction facingDirection = pBlockEntity.getBlockState().getValue(FACING);

        switch (facingDirection){
            case EAST: //marron
                this.translateX = 1D;
                this.translateZ = .5D;
                this.rotation = 270;
                break;
            case WEST://rojo
                this.translateX = 0D;
                this.translateZ = .5D;
                this.rotation = 90;
                break;
            case NORTH://azul
                this.translateX = .5D;
                this.translateZ = 0D;
                this.rotation = 0;
                break;
            case SOUTH://cyan
                this.translateX = .5D;
                this.translateZ = 1D;
                this.rotation = 180;
                break;
        }


        pPoseStack.pushPose();


        pPoseStack.translate(translateX,.5,translateZ);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        pPoseStack.scale(.75f,.75f,.75f);

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
