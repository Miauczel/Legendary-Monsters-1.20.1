package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.Chorus_BombEntity;
import net.miauczel.legendary_monsters.item.ModItems;
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

public class ChorusCannonItem extends BowItem {
    public ChorusCannonItem() {
        super(new Item.Properties().durability(300));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        entity.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, entity.getItemInHand(hand));
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ModItems.INFECTED_CHORUS_FRUIT.get()));
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
        list.add(Component.translatable("item.legendary_monsters.chorus_cannon1"));
        list.add(Component.translatable("item.legendary_monsters.chorus_cannon2"));


    }
    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
        int useDuration = this.getUseDuration(itemstack) - timeLeft;
        if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity && useDuration > 15) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();

            Chorus_BombEntity chorusBombEntity = new Chorus_BombEntity(ModEntities.CHORUS_BOMB .get(), world, entity);
            chorusBombEntity.setPos(x, y + entity.getEyeHeight(), z);
            chorusBombEntity.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1f, 1.0f);
            world.addFreshEntity(chorusBombEntity);

            itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));



            if (entityLiving instanceof Player player) {
                player.getCooldowns().addCooldown(this,     130);

                entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_1.get(), SoundSource.PLAYERS, 2.0F, 1.0F);

                if (Math.random() > 0.5) {
                    entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_2.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                } else {
                    entity.level().playSound(null, entity.blockPosition(), ModSounds.CANNON_SHOOT_3.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                }
            }
        }
    }
}