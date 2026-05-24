package net.miauczel.legendary_monsters.item;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties INFECTED_CHORUS_FRUIT = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 160),100f).build();

    public static final FoodProperties CLOUD_BREAD = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, MathUtils.toTicks(2)),100f).build();


}
