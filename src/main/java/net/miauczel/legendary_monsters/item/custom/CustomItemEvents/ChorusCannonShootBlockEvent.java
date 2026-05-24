package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChorusCannonShootBlockEvent {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity owner) {
        if (world instanceof Level _level && !_level.isClientSide())
           // _level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    DamageSource damageSource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), owner);

                    _entity.hurt(damageSource, 16);
                    
                    _entity.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,1,1);
                   // _entity.addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 60, 1, false, true));
                }
            }
        }
    }
}