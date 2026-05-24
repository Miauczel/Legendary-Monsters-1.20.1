package net.miauczel.legendary_monsters.util;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class EntityUtil {
    public static void applyPlayerDeltaMovement(LivingEntity entity) {
        if (entity instanceof ServerPlayer) {
            ((ServerPlayer) entity).connection.send(new ClientboundSetEntityMotionPacket(entity));
        }
    }

    public static void applyServerTeleport(LivingEntity entity) {
        if (entity.level() instanceof ServerLevel level) {
            level.addDuringTeleport(entity);
        }
    }

    public static final UUID HEALTH_MULT_UUID =
            UUID.fromString("9513569b-57b6-41f5-814e-bdc49b81799f");


    public static final UUID DAMAGE_MULT_UUID =
            UUID.fromString("22653B89-116E-49DC-9B6B-9971489B5BE5");

    public static void applyHealthMultiplier(LivingEntity livingEntity, double healthMultiplier) {
        if (livingEntity.level().isClientSide) return;
        AttributeInstance maxHp = livingEntity.getAttribute(Attributes.MAX_HEALTH);
        if (maxHp == null) return;
        if (livingEntity.getHealth() != livingEntity.getMaxHealth() || (livingEntity.getHealth() != livingEntity.getMaxHealth() && livingEntity.getHealth() != maxHp.getBaseValue()))
            return;
        if (maxHp.getModifier(HEALTH_MULT_UUID) != null) {
            maxHp.removeModifier(HEALTH_MULT_UUID);
        }
        double amount = healthMultiplier - 1.0;
        if (amount != 0.0) {
            AttributeModifier modifier = new AttributeModifier(
                    HEALTH_MULT_UUID,
                    "config_health_multiplier",
                    amount,
                    AttributeModifier.Operation.MULTIPLY_TOTAL
            );
            maxHp.addPermanentModifier(modifier);
            livingEntity.setHealth(livingEntity.getMaxHealth());
        }

        livingEntity.setHealth(Math.min(livingEntity.getHealth(), livingEntity.getMaxHealth()));
    }

    public static void cancelBuffs(LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player player)) return;

        ItemStack itemStack = player.getUseItem();
        if (itemStack.isEdible() && player.isUsingItem() && player.getUseItem().is(itemStack.getItem()) && ModConfig.MOB_CONFIG.BossesCancelEating.get()) {
            player.getCooldowns().addCooldown(itemStack.getItem(), 20);
            player.stopUsingItem();
        }
        MobEffectInstance mobEffectInstance = player.getEffect(MobEffects.DAMAGE_RESISTANCE);
        if (player.hasEffect(MobEffects.DAMAGE_RESISTANCE) && mobEffectInstance != null && mobEffectInstance.getAmplifier() > 1) {
            player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, mobEffectInstance.getDuration(), 0));
        }

    }


    public static void applyStackingEffect(LivingEntity entity, MobEffect effect, int bonusLevel, int maxLevel, int duration) {

        MobEffectInstance effectInstance = entity.getEffect(effect);

        if (entity.hasEffect(effect) && effectInstance != null) {

            int effectLevel = effectInstance.getAmplifier();
            if (effectLevel < maxLevel) {
                entity.addEffect(new MobEffectInstance(effect, duration, effectLevel + bonusLevel));
            }
        } else if (!(entity.hasEffect(effect) && effectInstance != null)) {
            entity.addEffect(new MobEffectInstance(effect, duration, 0));
        }
    }
}
