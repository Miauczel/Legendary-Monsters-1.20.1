package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import java.util.Random;

public class FreezeTick {
    public static void execute(Level level, Entity entity) {
        if (entity == null)
            return;

        Random random = new Random();
        if (random.nextFloat() < 0.05f) {
            entity.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE)), 2);
        }
        entity.setTicksFrozen(200);
    }
}


