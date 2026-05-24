package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class SmallCloudEntity extends ThrowableProjectile {

    public SmallCloudEntity(EntityType<SmallCloudEntity> type, Level world) {
        super(type, world);
    }

    public SmallCloudEntity(EntityType<SmallCloudEntity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
        this.setOwner(thrower);
    }

    @Override
    protected void defineSynchedData() {
    }

    public void Particle() {
        for (int i = 0; i < 360; ++i) {
            if (i % 1 == 0) {
                if (this.level().isClientSide) {
                    this.level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), Math.cos(i) * 0.1, 0.0D, Math.sin(i) * 0.1);
                }
            }
        }
    }

    public int damage1;

    public int setDamage(int damage) {
        return this.damage1 = damage;
    }

    @Override
    public void onHit(HitResult result) {
        for (LivingEntity livingEntity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2f, 2f, 2))) {
            double distance = this.distanceTo(livingEntity) / 2;
            double effectiveDistance = Math.max(distance, 1.0);
            float damage = damage1 / (float) effectiveDistance;
            LivingEntity owner = (LivingEntity) this.getOwner();
            if ((livingEntity != this.getOwner()) && !(livingEntity instanceof TamableAnimal animal && animal.getOwner() == getOwner())) {
                livingEntity.hurt(ModDamageTypes.causeCloudDamage(owner, livingEntity), damage);
            }
        }

        super.onHit(result);

        Particle();
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
        if (this.level().isClientSide) {
            Vec3 vec3 = this.getDeltaMovement();
            this.level().addParticle(ParticleTypes.CLOUD, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
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
