package net.miauczel.legendary_monsters.mixin;

import net.miauczel.legendary_monsters.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.level.storage.PlayerDataStorage;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;


import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.block.custom.EnderAnchorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Optional;

@Mixin(Player.class)
public abstract class PlayerRespawnMixin {

    @Inject(
            method = "findRespawnPositionAndUseSpawnBlock",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void legendary_monsters$enderAnchorRespawn(
            ServerLevel level,
            BlockPos pos,
            float angle,
            boolean spawnForced,
            boolean keepEverything,
            CallbackInfoReturnable<Optional<Vec3>> cir
    ) {
        BlockState state = level.getBlockState(pos);

        if (!state.is(ModBlocks.ENDER_ANCHOR.get())) {
            return;
        }

        if (level.dimension() != Level.END) {
            return;
        }

        if (state.getValue(EnderAnchorBlock.CHARGES) <= 0 && !spawnForced) {
            cir.setReturnValue(Optional.empty());
            cir.cancel();
            return;
        }

        Optional<Vec3> stand = EnderAnchorBlock.findStandUpPosition(
                EntityType.PLAYER, level, pos
        );

        if (stand.isEmpty()) {
            if (!spawnForced) {
                cir.setReturnValue(Optional.empty());
                cir.cancel();
            }
            return;
        }

        if (!keepEverything) {
            int charges = state.getValue(EnderAnchorBlock.CHARGES);
            if (charges > 0) {
                level.setBlock(pos,
                        state.setValue(EnderAnchorBlock.CHARGES, charges - 1),
                        3);
            }
        }

        cir.setReturnValue(stand);
        cir.cancel();
    }
}
