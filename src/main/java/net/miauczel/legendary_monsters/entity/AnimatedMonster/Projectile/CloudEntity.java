package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class CloudEntity extends ThrowableProjectile {

    public CloudEntity(EntityType<CloudEntity> type, Level world) {
        super(type, world);
    }

    public CloudEntity(EntityType<CloudEntity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
        this.setOwner(thrower);
    }

    @Override
    protected void defineSynchedData() {
    }

    public void Particle() {
        if (!ModConfig.MOB_CONFIG.allowFallingCloudParticles.get())
            return;
        for (int i = 0; i < 360; ++i) {
            if (i % 1 == 0) {
                if (level().isClientSide()) {
                    this.level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), Math.cos(i) * 0.1, 0.0D, Math.sin(i) * 0.1);
                }
            }
        }
    }


    public boolean particleOptimalization = false;

    public boolean setParticleOptimalization(boolean particleOptimalization) {
        return this.particleOptimalization = particleOptimalization;
    }

    public int damage = 5;
    public float attackRange = 2f;

    public float setAttackRange(float input) {
        return attackRange = input;
    }

    public int setDamage(int damage) {
        return this.damage = damage;
    }

    @Override
    public void onHit(HitResult result) {
        for (LivingEntity livingEntity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(attackRange, attackRange, attackRange))) {
            double distance = this.distanceTo(livingEntity) / 2;
            double effectiveDistance = Math.max(distance, 1.0);

            Entity ownerEntity = this.getOwner();
            if (ownerEntity instanceof Player owner  && !(livingEntity instanceof TamableAnimal animal && animal.getOwner() == getOwner())) {
                float damage = this.damage / (float) effectiveDistance;
                if (livingEntity != ownerEntity) {
                    livingEntity.hurt(ModDamageTypes.causeCloudDamage(owner, owner), damage);
                }
            } else if (ownerEntity instanceof LivingEntity owner) {
                float damage = this.damage / (float) effectiveDistance;
                if (ownerEntity instanceof Mob) {
                    LivingEntity target = ((Mob) ownerEntity).getTarget();
                    if (livingEntity != ownerEntity && !(livingEntity instanceof TamableAnimal animal && animal.getOwner() == getOwner())) {
                        if (target != null) {
                            float m = target.getMaxHealth() * 0.01f;
                            livingEntity.hurt(ModDamageTypes.causeCloudDamage(owner, owner), damage + m);
                        } else {

                            livingEntity.hurt(ModDamageTypes.causeCloudDamage(owner, owner), damage);
                        }
                    }
                }
            } else {
            }

        }

        super.onHit(result);
        if (!particleOptimalization) {
            Particle();
        }
        this.playSound(SoundEvents.SHULKER_BULLET_HURT, 3, 1);
        //CameraShakeEntity.cameraShake(this.level(), this.position(), 40.0F, 0.3F, 0, 20);
        this.discard();

    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void tick() {
        super.tick();

        if (!ModConfig.MOB_CONFIG.allowFallingCloudParticles.get()) {
            if (this.level().isClientSide) {
                Vec3 vec3 = this.getDeltaMovement();
                if (level().isClientSide()) {
                    this.level().addParticle(ParticleTypes.CLOUD, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Override
    protected float getGravity() {
        return 0.03F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

