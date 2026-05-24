package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.BombEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class HandCannonItem extends BowItem {
    public HandCannonItem() {
        super(new Properties().durability(300));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        entity.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, entity.getItemInHand(hand));
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(Items.CHISELED_SANDSTONE));
    }
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 72000;
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.sand_cannon1"));


    }
    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
        int useDuration = this.getUseDuration(itemstack) - timeLeft;
        if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity && useDuration > 15) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();

            BombEntity bomb = new BombEntity(ModEntities.BOMB.get(), world, entity);
            bomb.setPos(x, y + entity.getEyeHeight(), z);
            bomb.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1f, 1.0f);
            world.addFreshEntity(bomb);

            itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));



            if (entityLiving instanceof Player player) {
                player.getCooldowns().addCooldown(this, 130);

                System.out.println("Playing sound 1");
                entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_1.get(), SoundSource.PLAYERS, 2.0F, 1.0F);

                if (Math.random() > 0.5) {
                    System.out.println("Playing sound 2");
                    entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_2.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                } else {
                    System.out.println("Playing sound 3");
                    entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_3.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                }
            }
        }
    }
}