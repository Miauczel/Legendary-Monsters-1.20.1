package net.miauczel.legendary_monsters.Message;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SkeloraptorRoarKeyMessage {
    public int equipmentSlot;
    public int playerId;
    public int type;

    public SkeloraptorRoarKeyMessage(int equipmentSlot, int playerId, int type) {
        this.equipmentSlot = equipmentSlot;
        this.playerId = playerId;
        this.type = type;
    }

    public SkeloraptorRoarKeyMessage() {}

    public static SkeloraptorRoarKeyMessage read(FriendlyByteBuf buf) {
        int equipmentSlot = buf.readInt();
        int playerId = buf.readInt();
        int type = buf.readInt();
        return new SkeloraptorRoarKeyMessage(equipmentSlot, playerId, type);
    }

    public static void write(SkeloraptorRoarKeyMessage message, FriendlyByteBuf buf) {
        buf.writeInt(message.equipmentSlot);
        buf.writeInt(message.playerId);
        buf.writeInt(message.type);
    }

    public static class Handler {
        public static void onMessage(SkeloraptorRoarKeyMessage message, Supplier<NetworkEvent.Context> ctx) {
            NetworkEvent.Context context = ctx.get();
            context.enqueueWork(() -> {
                ServerPlayer sender = context.getSender();
                if (sender != null) {
                    if (sender.getVehicle() instanceof SkeloraptorEntity dino) {
                        if (dino.getAttackState() ==0 && dino.roarCooldown <=0) {
                            dino.roarCooldown = dino.ROAR_COOLDOWN;
                                dino.setAttackState(1);


                        }
                    }
                }
            });
            context.setPacketHandled(true);
        }
    }
}
