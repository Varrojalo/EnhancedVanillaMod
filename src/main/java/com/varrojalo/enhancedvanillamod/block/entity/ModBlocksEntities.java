package com.varrojalo.enhancedvanillamod.block.entity;

import com.varrojalo.enhancedvanillamod.EnhancedVanillaMod;
import com.varrojalo.enhancedvanillamod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnhancedVanillaMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PulverizerBlockEntity>> PULVERIZER_BE =
            BLOCK_ENTITIES.register("pulverizer_be", () ->
                    BlockEntityType.Builder.of(PulverizerBlockEntity::new,
                            ModBlocks.PULVERIZER_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<FeederBlockEntity>> FEEDER_BE =
            BLOCK_ENTITIES.register("feeder_be", () ->
                    BlockEntityType.Builder.of(FeederBlockEntity::new,
                            ModBlocks.FEEDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<CopperFilterBlockEntity>> COPPER_FILTER_BE =
            BLOCK_ENTITIES.register("copper_filter_be", () ->
                    BlockEntityType.Builder.of(CopperFilterBlockEntity::new,
                            ModBlocks.COPPER_FILTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<DiamondFilterBlockEntity>> DIAMOND_FILTER_BE =
            BLOCK_ENTITIES.register("diamond_filter_be", () ->
                    BlockEntityType.Builder.of(DiamondFilterBlockEntity::new,
                            ModBlocks.DIAMOND_FILTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<NetheriteFilterBlockEntity>> NETHERITE_FILTER_BE =
            BLOCK_ENTITIES.register("netherite_filter_be", () ->
                    BlockEntityType.Builder.of(NetheriteFilterBlockEntity::new,
                            ModBlocks.NETHERITE_FILTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ClockBlockEntity>> CLOCK_BLOCK_BE =
            BLOCK_ENTITIES.register("clock_block_be",() ->
                    BlockEntityType.Builder.of(ClockBlockEntity::new,
                            ModBlocks.CLOCK_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<PlacerBlockEntity>> PLACER_BLOCK_BE =
            BLOCK_ENTITIES.register("placer_block_be", () ->
                    BlockEntityType.Builder.of(PlacerBlockEntity::new,
                            ModBlocks.PLACER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
