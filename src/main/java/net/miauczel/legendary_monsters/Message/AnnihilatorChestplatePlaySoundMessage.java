package net.miauczel.legendary_monsters.Message;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class AnnihilatorChestplatePlaySoundMessage {

    public AnnihilatorChestplatePlaySoundMessage() {
    }


    public static AnnihilatorChestplatePlaySoundMessage read(FriendlyByteBuf buf) {
        return new AnnihilatorChestplatePlaySoundMessage();
    }

    public static void write(AnnihilatorChestplatePlaySoundMessage message, FriendlyByteBuf buf) {
    }

    public static class Handler {
        public static void onMessage(AnnihilatorChestplatePlaySoundMessage message, Supplier<NetworkEvent.Context> ctx) {
            NetworkEvent.Context context = ctx.get();
            context.enqueueWork(() -> {
                ServerPlayer sender = context.getSender();
                if (sender.level() instanceof ServerLevel level) {
                    level.playSound(null, BlockPos.containing(sender.position()), SoundEvents.SHULKER_TELEPORT, SoundSource.PLAYERS, 1, 1);
                }

            });
            context.setPacketHandled(true);
        }
    }
}
