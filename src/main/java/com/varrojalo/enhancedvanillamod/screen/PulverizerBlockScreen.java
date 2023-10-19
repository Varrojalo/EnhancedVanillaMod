package com.varrojalo.enhancedvanillamod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class PulverizerBlockScreen extends AbstractContainerScreen<PulverizerBlockMenu> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(EnhancedVanillaMod.MOD_ID, "textures/gui/pulverizer_block_gui.png");
    public PulverizerBlockScreen(PulverizerBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE,x,y,0,0,imageWidth,imageHeight);
        renderProgressArrow(pGuiGraphics,x,y);
    }

    private void renderProgressArrow(GuiGraphics pGuiGraphics, int x, int y) {

        if(menu.isCrafting()){
            pGuiGraphics.blit(TEXTURE,x + 85,y + 30,176,0,8,menu.getScaledProgress());
        }

    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics,pMouseX,pMouseY,pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics,pMouseX,pMouseY);
    }
}
