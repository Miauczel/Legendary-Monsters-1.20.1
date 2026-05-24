package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StunTick {
    public static void execute(Level level, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player player) {
            ItemStack mainhandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            player.stopUsingItem();

            player.setNoActionTime((int) 10);
            player.getCooldowns().addCooldown(mainhandItem.getItem(), 2);
            player.getCooldowns().addCooldown(offhandItem.getItem(), 2);
        }
    }
}
