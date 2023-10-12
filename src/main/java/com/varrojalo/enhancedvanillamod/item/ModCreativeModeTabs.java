package com.varrojalo.enhancedvanillamod.item;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedVanillaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENHANCED_VANILLA_TAB = CREATIVE_MODE_TABS.register("enhanced_vanilla_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FIRE_BRICK.get()))
                    .title(Component.translatable("creativetab.enhanced_vanilla_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.FIRE_BRICK.get());
                        pOutput.accept(ModItems.MESH.get());
                        pOutput.accept(ModItems.FILTER.get());
                        pOutput.accept(ModBlocks.CLOCK_BLOCK.get());
                        pOutput.accept(ModBlocks.FILTERED_HOPPER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
