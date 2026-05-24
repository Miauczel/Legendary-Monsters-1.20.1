package net.miauczel.legendary_monsters.Message;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.sound.BossMusicPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayBossMusicMessage {

    private final int entityID;
    private final boolean play;
    public PlayBossMusicMessage(int bossBar, boolean canPlay) {
        this.entityID = bossBar;
        this.play =canPlay;
    }
    public static PlayBossMusicMessage read(FriendlyByteBuf buf) {
        return new PlayBossMusicMessage(buf.readInt(), buf.readBoolean());
    }

    public static void write(PlayBossMusicMessage message, FriendlyByteBuf buf) {
        buf.writeInt(message.entityID);
        buf.writeBoolean(message.play);
    }

    public static class Handler {
        public static boolean onMessage(PlayBossMusicMessage msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                Entity e = Minecraft.getInstance().level.getEntity(msg.entityID);
                if (!(e instanceof IAnimatedBoss boss)) return;


                if (msg.play) {
                        BossMusicPlayer.playBossMusic(boss);
                } else {
                    BossMusicPlayer.stopBossMusic(boss);
                }
            });
            ctx.get().setPacketHandled(true);
            return true;
        }
    }

}
