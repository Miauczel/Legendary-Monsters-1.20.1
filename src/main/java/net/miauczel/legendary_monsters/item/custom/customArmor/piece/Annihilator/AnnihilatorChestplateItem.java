package net.miauczel.legendary_monsters.item.custom.customArmor.piece.Annihilator;

import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
import net.miauczel.legendary_monsters.item.custom.customArmor.armorItem.AnnihilatorArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Rarity;

public class AnnihilatorChestplateItem extends AnnihilatorArmorItem {
    public AnnihilatorChestplateItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(ModArmorMaterials.ANNIHILATOR, pType, new Properties().rarity(Rarity.EPIC));
    }



}
