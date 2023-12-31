package com.varrojalo.enhancedvanillamod.screen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.custom.PlacerBlock;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, EnhancedVanillaMod.MOD_ID);


    public static final RegistryObject<MenuType<PulverizerBlockMenu>> PULVERIZER_BLOCK_MENU =
            registerMenuTypes("pulverizer_block_menu", PulverizerBlockMenu::new);
    public static final RegistryObject<MenuType<FeederBlockMenu>> FEEDER_MENU =
            registerMenuTypes("feeder_menu", FeederBlockMenu::new);
    public static final RegistryObject<MenuType<CopperFilterBlockMenu>> COPPER_FILTER_MENU =
            registerMenuTypes("copper_filter_menu", CopperFilterBlockMenu::new);
    public static final RegistryObject<MenuType<DiamondFilterBlockMenu>> DIAMOND_FILTER_MENU =
            registerMenuTypes("diamond_filter_menu", DiamondFilterBlockMenu::new);
    public static final RegistryObject<MenuType<NetheriteFilterBlockMenu>> NETHERITE_FILTER_MENU =
            registerMenuTypes("netherite_filter_menu", NetheriteFilterBlockMenu::new);
    public static final RegistryObject<MenuType<PlacerBlockMenu>> PLACER_BLOCK_MENU =
            registerMenuTypes("placer_block_menu", PlacerBlockMenu::new);


    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory){
        return MENUS.register(name,() -> IForgeMenuType.create(factory));
    }
}
