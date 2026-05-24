package net.miauczel.legendary_monsters.item.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface KeybindArmor {
    void onKeyPacket(Player var1, ItemStack var2, int var3);
}
