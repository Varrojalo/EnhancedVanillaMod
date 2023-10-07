package com.varrojalo.enhancedvanillamod.item;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedVanillaMod.MOD_ID);

    public static final RegistryObject<Item> FIRE_BRICK = ITEMS.register("fire_brick",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
