package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber

public class ShulkerShieldHurtEvent {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false) && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.SHULKER_SHIELD.get()
                || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.SHULKER_SHIELD.get())) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                if (((LivingEntity) entity).getRandom().nextFloat() < 0.60) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 1, false, false));
                }
        }

    }
    }



