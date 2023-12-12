package com.varrojalo.enhancedvanillamod;

import com.mojang.logging.LogUtils;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import com.varrojalo.enhancedvanillamod.block.entity.ModBlocksEntities;
import com.varrojalo.enhancedvanillamod.item.ModCreativeModeTabs;
import com.varrojalo.enhancedvanillamod.item.ModItems;
import com.varrojalo.enhancedvanillamod.recipe.ModRecipes;
import com.varrojalo.enhancedvanillamod.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedVanillaMod.MOD_ID)
public class EnhancedVanillaMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "enhancedvanillamod";
    // Directly reference a slf4j logg er
    private static final Logger LOGGER = LogUtils.getLogger();
    public EnhancedVanillaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlocksEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.FIRE_BRICK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            MenuScreens.register(ModMenuTypes.PULVERIZER_BLOCK_MENU.get(), PulverizerBlockScreen::new);
            MenuScreens.register(ModMenuTypes.PLACER_BLOCK_MENU.get(), PlacerBlockScreen::new);
            MenuScreens.register(ModMenuTypes.FEEDER_MENU.get(), FeederBlockScreen::new);
            MenuScreens.register(ModMenuTypes.COPPER_FILTER_MENU.get(), CopperFilterBlockScreen::new);
            MenuScreens.register(ModMenuTypes.DIAMOND_FILTER_MENU.get(), DiamondFilterBlockScreen::new);
            MenuScreens.register(ModMenuTypes.NETHERITE_FILTER_MENU.get(), NetheriteFilterBlockScreen::new);
        }
    }
}
