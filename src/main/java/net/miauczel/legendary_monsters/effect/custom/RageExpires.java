package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.world.entity.Entity;

public class RageExpires {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.setTicksFrozen(0);
    }
}


