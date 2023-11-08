package com.varrojalo.enhancedvanillamod;

import com.varrojalo.enhancedvanillamod.block.entity.ModBlocksEntities;
import com.varrojalo.enhancedvanillamod.block.entity.renderer.PulverizerBlockEntityRenderer;
import com.varrojalo.enhancedvanillamod.util.ModTags;
import net.minecraft.util.thread.BlockableEventLoop;
import net.minecraft.world.level.BlockEventData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.levelgen.feature.PointedDripstoneFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedVanillaMod.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        //event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlocksEntities.PULVERIZER_BE.get(),PulverizerBlockEntityRenderer::new);
    }


}
