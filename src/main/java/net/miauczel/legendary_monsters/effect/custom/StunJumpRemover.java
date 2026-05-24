package net.miauczel.legendary_monsters.effect.custom;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class StunJumpRemover {
    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(ModEffects.STUN.get())) {
            entity.setDeltaMovement(0, 0, 0);
        }
    }
}

