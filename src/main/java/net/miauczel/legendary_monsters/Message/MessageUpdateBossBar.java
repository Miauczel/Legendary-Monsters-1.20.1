package net.miauczel.legendary_monsters.Message;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class MessageUpdateBossBar {

    private final UUID bossBar;
    private final int  renderType;

    public MessageUpdateBossBar(UUID bossBar, int renderType) {
        this.bossBar = bossBar;
        this.renderType = renderType;
    }


    public static MessageUpdateBossBar read(FriendlyByteBuf buf) {
        return new MessageUpdateBossBar(buf.readUUID(), buf.readInt());
    }

    public static void write(MessageUpdateBossBar message, FriendlyByteBuf buf) {
        buf.writeUUID(message.bossBar);
        buf.writeInt(message.renderType);
    }


    public static void handle(MessageUpdateBossBar message, Supplier<NetworkEvent.Context> context) {
        context.get().setPacketHandled(true);
        Player playerSided = context.get().getSender();
        if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            playerSided = LegendaryMonsters.PROXY.getClientSidePlayer();
        }
        if(message.renderType == -1){
            LegendaryMonsters.PROXY.removeBossBarRender(message.bossBar);
        }else{
            LegendaryMonsters.PROXY.setBossBarRender(message.bossBar, message.renderType);
        }
    }
}