package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Stun extends MobEffect {
    public Stun(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Player pPlayer) {
          //  pPlayer.setDeltaMovement(0,0,0);
            sendActionBarMessageToPlayer(pPlayer,"legendary_monsters.message.stun");

        }
        StunTick.execute(pLivingEntity.level(), pLivingEntity);
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
    private void sendActionBarMessageToPlayer(Player player, String message) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable(message)));
        }
    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration > 0;
    }
}
