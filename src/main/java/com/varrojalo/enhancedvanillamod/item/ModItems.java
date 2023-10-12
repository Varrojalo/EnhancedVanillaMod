package com.varrojalo.enhancedvanillamod.item;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.item.custom.FireBrickItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedVanillaMod.MOD_ID);

    public static final RegistryObject<Item> FIRE_BRICK = ITEMS.register("fire_brick",
            () -> new FireBrickItem(new Item.Properties()));
    public static final RegistryObject<Item> MESH = ITEMS.register("mesh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
