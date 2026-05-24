package net.miauczel.legendary_monsters.event;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.util.BlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class Events {

    @SubscribeEvent
    public void onLivingHurt(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        LivingEntity sourceEntity = (LivingEntity) source.getDirectEntity();
        LivingEntity target = (LivingEntity) source.getEntity();
        if (target != null) {

            System.out.println("ATTACKER: " + target);
            boolean itemStack = target.getUseItem().is(ModItems.SPIKY_SHIELD.get());
            if (target.isBlocking() && itemStack) {
                if (sourceEntity != null) {
                    if (sourceEntity.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
                        sourceEntity.hurt(new DamageSource(target.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS), target),
                                (float) ((25 * ((LivingEntity) sourceEntity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue()) / 100 + 5));
                    } else {
                        ((LivingEntity) sourceEntity).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 40, 0));
                        sourceEntity.hurt(new DamageSource(target.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS)), 7);
                    }
                }
            }
        }
        DamageSource damageSource = event.getSource();
        Entity attackedEntity = damageSource.getEntity();
        LivingEntity attacker = (LivingEntity) damageSource.getDirectEntity();

        System.out.println("ATTACKER: " + attacker);
        System.out.println("ATTACKED ENTITY: " + attackedEntity);
        if (attacker instanceof Player player) {

            AttributeInstance attributeInstance = attacker.getAttribute(Attributes.ATTACK_DAMAGE);
            if (attacker.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) && attributeInstance != null) {
                float damage = (float) attributeInstance.getValue();
                float uBox = 3;
                BlockPos blockPos = BlockUtils.blockPosVec3(attacker.position());
                AABB aabb = new AABB(blockPos).inflate(uBox);
                System.out.println("AABB: " + aabb);
                if (attackedEntity instanceof LivingEntity livingEntity) {
                    List<LivingEntity> list = attacker.level().getEntitiesOfClass(LivingEntity.class, aabb);
                    for (LivingEntity entity : list) {
                        System.out.println("ListResult: " + list.get(10));
                        entity.hurt(ModDamageTypes.causeAnnihilationDamage(attacker, attacker), damage);
                    }

                    if (attackedEntity.level() instanceof ServerLevel level) {
                        double d1 = attackedEntity.getX();
                        double d2 = attackedEntity.getY();
                        double d3 = attackedEntity.getZ();
                        ParticleOptions particleOptions = new Circle.RingData((float) (Math.PI / 2), 0, 30, 0, 1, 0, 1, 100, false, Circle.EnumRingBehavior.GROW);
                        level.sendParticles(particleOptions, d1, d2, d3, 1, 0, 0, 0, 0);
                    }
                }
            }
        }

    }


}

