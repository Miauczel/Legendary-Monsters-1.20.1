package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class SoulGreatSwordEventHandler {

    public static void onEntityHit(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            if (player.getMainHandItem().getItem() == ModItems.SOUL_GREAT_SWORD.get()) {
                if (event.getEntity() instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) event.getEntity();
                    if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
                        if (player.fallDistance > 0.0F) {
                            if (Math.random() < 0.5) {
                                target.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 70, 0));
                            }
                        }
                    }
                }
            }
        }
    }
}
