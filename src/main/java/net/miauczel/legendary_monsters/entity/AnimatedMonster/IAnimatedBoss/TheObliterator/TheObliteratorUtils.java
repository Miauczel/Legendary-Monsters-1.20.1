package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

public class TheObliteratorUtils {
    public static void applyAnnihilationEffect(LivingEntity entity, MobEffect effect, int bonusLevel, boolean stun) {
        int duration = 200;
        MobEffectInstance effectInstance = entity.getEffect(effect);
        boolean isOn = ModConfig.MOB_CONFIG.TheObliteratorAnnihilationEffect.get();
        if (entity.hasEffect(effect) && effectInstance != null) {
            int effectLevel = effectInstance.getAmplifier();
            if (effectLevel == 4) {
                if (stun) {
                    // entity.playSound(ModSounds.THE_WARPED_ONE_STUN.get(), 1, 1);
                    //entity.removeEffect(effect);

                    //   entity.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 50, 0));
                }
            }
            if (effectLevel < 4) {
                if (isOn) entity.addEffect(new MobEffectInstance(effect, duration, effectLevel + bonusLevel));
            }
        } else if (!(entity.hasEffect(effect) && effectInstance != null)) {
          if (isOn)entity.addEffect(new MobEffectInstance(effect,duration,0));
        }
    }

    public static double opArmorNerf(@NotNull LivingEntity entity, TheObliteratorEntity theObliteratorEntity) {
        double opArmorLevel = 20;

        AttributeInstance attributeInstance = entity.getAttribute(Attributes.ARMOR);

        if (attributeInstance != null && attributeInstance.getValue() > opArmorLevel) {

            double getAttributeLevel = attributeInstance.getValue();
            double difference = getAttributeLevel - opArmorLevel;

            boolean cantScaleDamage = theObliteratorEntity.getAttackState() == 20
                    || theObliteratorEntity.getAttackState() == 14
                    || theObliteratorEntity.getAttackState() == 24
                    || theObliteratorEntity.getAttackState() == 40
                    || theObliteratorEntity.getAttackState() == 50
                    || theObliteratorEntity.getAttackState() == 53
                    && attributeInstance.getValue() < opArmorLevel;

            return cantScaleDamage ? 1 : 1 + (difference * 0.075);

        } else return 1;
    }
}
