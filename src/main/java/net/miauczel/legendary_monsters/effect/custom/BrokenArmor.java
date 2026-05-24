package net.miauczel.legendary_monsters.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class BrokenArmor extends MobEffect {
    public BrokenArmor(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }



    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        FreezeExpires.execute(entity);
    }

}

