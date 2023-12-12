package com.varrojalo.enhancedvanillamod.item.custom;

import net.minecraft.commands.arguments.ResourceOrTagKeyArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.commands.LocateCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.Optional;

public class StructureFinderItem extends Item {
    public StructureFinderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        /*Registry<Structure> registry = pLevel.registryAccess().registryOrThrow(Registries.STRUCTURE);
        BlockPos blockPos = pPlayer.getOnPos();
        HolderSet<Structure> holderSet = getHolders(ResourceOrTagKeyArgument.resourceOrTagKey(Registries.STRUCTURE),registry);
        ServerLevel serverLevel = pLevel.getServer().getLevel(pLevel.dimension());
        serverLevel.getChunkSource().getGenerator().findNearestMapStructure(serverLevel,holderSet,blockPos, 100,true);
        */
        return super.use(pLevel, pPlayer, pUsedHand);
    }
    private static Optional<? extends HolderSet.ListBacked<Structure>> getHolders(ResourceOrTagKeyArgument.Result<Structure> pStructure, Registry<Structure> pStructureRegistry) {
        return pStructure.unwrap().map((sIndex) -> {
            return pStructureRegistry.getHolder(sIndex).map((rIndex) -> {
                return HolderSet.direct(rIndex);
            });
        }, pStructureRegistry::getTag);
    }
}
