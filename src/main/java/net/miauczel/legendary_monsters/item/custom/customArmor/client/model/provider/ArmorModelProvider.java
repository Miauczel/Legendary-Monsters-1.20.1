package net.miauczel.legendary_monsters.item.custom.customArmor.client.model.provider;

import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.ArmorModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface ArmorModelProvider {

    ArmorModel getModel(LivingEntity living, ItemStack stack, EquipmentSlot slot);
}
