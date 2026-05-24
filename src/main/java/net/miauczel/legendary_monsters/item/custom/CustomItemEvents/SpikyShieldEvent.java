package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;@Mod.EventBusSubscriber
public class SpikyShieldEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityAttacked(LivingAttackEvent event) {


        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        execute(null, world, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false) && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.SPIKY_SHIELD.get()
                || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.SPIKY_SHIELD.get())) {
            if (Math.random() < 0.5) {
                if (!(sourceentity instanceof Fireball) && !(sourceentity instanceof DragonFireball) && !(sourceentity instanceof Arrow) && !(sourceentity instanceof Projectile) ) {
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity livingSourceEntity = (LivingEntity) sourceentity;
                        if (livingSourceEntity.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
                            sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS),entity),
                                    (float) ((25 * ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue()) / 100 + 5));
                        } else{
                            ((LivingEntity) sourceentity).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(),40,0));
                            sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS)), (float) (7 * ModConfig.MOB_CONFIG.SpikyShieldDamageMultiplier.get()));
                        }
                    }

                }

            }
        }
    }
}