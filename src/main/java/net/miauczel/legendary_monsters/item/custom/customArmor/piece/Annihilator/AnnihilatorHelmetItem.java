package net.miauczel.legendary_monsters.item.custom.customArmor.piece.Annihilator;

import net.miauczel.legendary_monsters.item.custom.customArmor.armorItem.AnnihilatorArmorItem;
import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class AnnihilatorHelmetItem extends AnnihilatorArmorItem {
    public AnnihilatorHelmetItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(ModArmorMaterials.ANNIHILATOR, pType, new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

    }


}
