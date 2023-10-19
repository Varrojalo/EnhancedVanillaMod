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
                        pOutput.accept(ModItems.ECHO_DUST.get());
                        pOutput.accept(ModItems.ECHO_INGOT.get());
                        pOutput.accept(ModItems.TELEPORTER.get());
                        pOutput.accept(ModItems.MESH.get());
                        pOutput.accept(ModItems.FILTER.get());

                        pOutput.accept(ModBlocks.CLOCK_BLOCK.get());
                        pOutput.accept(ModBlocks.FILTERED_HOPPER.get());
                        pOutput.accept(ModBlocks.PULVERIZER_BLOCK.get());

                        //<editor-fold desc="Concrete Deco Blocks">
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.WHITE_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.ORANGE_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.MAGENTA_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.LIGHT_BLUE_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.YELLOW_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.LIME_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.LIME_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.PINK_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.PINK_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.GRAY_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.GRAY_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.LIGHT_GRAY_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.CYAN_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.CYAN_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.PURPLE_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.BLUE_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.BLUE_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.BROWN_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.BROWN_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.GREEN_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.GREEN_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.RED_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.RED_CONCRETE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.BLACK_CONCRETE_STAIRS.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_SLAB.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_BUTTON.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_FENCE.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_DOOR.get());
                        pOutput.accept(ModBlocks.BLACK_CONCRETE_TRAPDOOR.get());
                        //</editor-fold>
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
