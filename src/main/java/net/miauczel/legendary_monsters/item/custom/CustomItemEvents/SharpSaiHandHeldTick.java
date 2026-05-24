package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SharpSaiHandHeldTick {
    public static void execute(Entity entity) {
        if (entity == null || !(entity instanceof LivingEntity))
            return;

        LivingEntity livingEntity = (LivingEntity) entity;
        boolean hasMainHandSai = ModItems.SHARP_SAI.get().equals(livingEntity.getMainHandItem().getItem());
        boolean hasOffhandSai = ModItems.SHARP_SAI.get().equals(livingEntity.getOffhandItem().getItem());

        if (hasMainHandSai || hasOffhandSai) {
            updateLowAttackReachEffect(livingEntity);
        } else {
            removeLowAttackReachEffect(livingEntity);
        }
    }

    private static void updateLowAttackReachEffect(LivingEntity livingEntity) {
        if (!livingEntity.level().isClientSide()) {
            MobEffectInstance existingEffect = livingEntity.getEffect(ModEffects.low_attack_reach.get());
            if (existingEffect == null) {
                MobEffectInstance effectInstance = new MobEffectInstance(ModEffects.low_attack_reach.get(), 21, 0, false, false);
                livingEntity.addEffect(effectInstance);
            }
        }
    }

    private static void removeLowAttackReachEffect(LivingEntity livingEntity) {
        if (!livingEntity.level().isClientSide()) {
            MobEffectInstance existingEffect = livingEntity.getEffect(ModEffects.low_attack_reach.get());
            if (existingEffect != null) {
                livingEntity.removeEffect(ModEffects.low_attack_reach.get());
            }
        }
    }
}
