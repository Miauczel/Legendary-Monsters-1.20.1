package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID)
public class FieryJawEventHandler {
    @SubscribeEvent
    public static void onEntityHit(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            if (player.getMainHandItem().getItem() == ModItems.FIERY_JAW.get()) {
                if (event.getEntity() instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) event.getEntity();
                        if (Math.random() < 0.5) {
                           target.setRemainingFireTicks(60);

                        }
                    }
                }
            }
        }
    }

