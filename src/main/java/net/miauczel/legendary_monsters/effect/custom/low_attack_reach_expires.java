package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;

public class low_attack_reach_expires {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player || entity instanceof ServerPlayer) {
            ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).setBaseValue(3);
        }
    }
}


