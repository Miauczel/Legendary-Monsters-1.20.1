package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WitheredRibcageHurt {
    @SubscribeEvent
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
        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ModItems.WITHERED_RIBCAGE.get()) {
            if (entity instanceof Player player) {
                if (!((Player) entity).isBlocking()) {
                    if (Math.random() < 0.4) {
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2, false, true));
                    }
                }
            }
        }
    }
}