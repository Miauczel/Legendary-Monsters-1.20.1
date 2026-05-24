package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownAnnihilationBottle;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;

public class BottleOfAnnihilationItem extends Item {
    public BottleOfAnnihilationItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            ThrownAnnihilationBottle thrownAnnihilationBottle = new ThrownAnnihilationBottle(pLevel, pPlayer);
            thrownAnnihilationBottle.setItem(itemstack);
            thrownAnnihilationBottle.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), -20.0F, 0.5F, 1.0F);
            pLevel.addFreshEntity(thrownAnnihilationBottle);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}