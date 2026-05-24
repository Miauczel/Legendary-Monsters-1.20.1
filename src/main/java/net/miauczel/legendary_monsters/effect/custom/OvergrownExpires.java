package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OvergrownExpires {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).setHealth(((LivingEntity) entity).getMaxHealth());
        }
    }
}


