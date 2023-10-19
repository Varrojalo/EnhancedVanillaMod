package com.varrojalo.enhancedvanillamod.screen;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
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
            registerMenuTypes("pulverizer_block_menu",PulverizerBlockMenu::new);


    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory){
        return MENUS.register(name,() -> IForgeMenuType.create(factory));
    }
}
