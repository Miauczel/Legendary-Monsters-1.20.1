package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Lava_eaterEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class FireBreath extends INoRendererEntity {
    private static final int RANGE = 10;
    private static final int ARC = 45;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(FireBreath.class, EntityDataSerializers.FLOAT);


    public FireBreath(EntityType<? extends FireBreath> type, Level world) {
        super(type, world);

    }


    public FireBreath(EntityType<? extends FireBreath> type, Level world, float damage, LivingEntity caster) {
        super(type, world);
        this.setCaster(caster);
        this.setDamage(damage);

    }

    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    @Override
    public void tick() {
        super.tick();
        if (caster instanceof Player) {
            this.playSound(SoundEvents.WARDEN_SONIC_CHARGE, 1, 1);
        }
        if (caster != null && !caster.isAlive()) this.discard();

        if (caster != null) {

            Vec3 pos = new Vec3(this.caster.getX(), this.caster.getY() + 1, this.caster.getZ());
            this.setYRot(caster.yHeadRot);
            this.setPos(pos);
            this.setXRot(caster.getXRot());
        }

        float yaw = (float) Math.toRadians(-getYRot());
        float pitch = (float) Math.toRadians(-getXRot());
        float spread = 0.25f;
        float speed = 0.56f;
        float xComp = (float) (Math.sin(yaw) * Math.cos(pitch));
        float yComp = (float) (Math.sin(pitch));
        float zComp = (float) (Math.cos(yaw) * Math.cos(pitch));
        double theta = (getYRot()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double vec = 0.9;
        if (level().isClientSide) {
            for (int i = 0; i < 80; i++) {
                double xSpeed = speed * xComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - xComp * xComp)));
                double ySpeed = speed * yComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - yComp * yComp)));
                double zSpeed = speed * zComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - zComp * zComp)));
                level().addAlwaysVisibleParticle(ModParticles.FLAME_STATIC
                        .get(), getX() + vec * vecX, getY(), getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
            }
        }
        if (tickCount > 2 && caster != null) {
            hitEntities();
        }
        if (tickCount > 50) discard();
    }

    public void hitEntities() {
        List<LivingEntity> entitiesHit = getEntityLivingBaseNearby(RANGE, RANGE, RANGE, RANGE);
        ;
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitYaw = (float) ((Math.atan2(entityHit.getZ() - getZ(), entityHit.getX() - getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingYaw = getYRot() % 360;
            if (entityHitYaw < 0) {
                entityHitYaw += 360;
            }
            if (entityAttackingYaw < 0) {
                entityAttackingYaw += 360;
            }
            float entityRelativeYaw = entityHitYaw - entityAttackingYaw;

            float xzDistance = (float) Math.sqrt((entityHit.getZ() - getZ()) * (entityHit.getZ() - getZ()) + (entityHit.getX() - getX()) * (entityHit.getX() - getX()));
            double hitY = entityHit.getY() + entityHit.getBbHeight() / 2.0;
            float entityHitPitch = (float) ((Math.atan2((hitY - getY()), xzDistance) * (180 / Math.PI)) % 360);
            float entityAttackingPitch = -getXRot() % 360;
            if (entityHitPitch < 0) {
                entityHitPitch += 360;
            }
            if (entityAttackingPitch < 0) {
                entityAttackingPitch += 360;
            }
            float entityRelativePitch = entityHitPitch - entityAttackingPitch;

            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - getZ()) * (entityHit.getZ() - getZ()) + (entityHit.getX() - getX()) * (entityHit.getX() - getX()) + (hitY - getY()) * (hitY - getY()));
            int distance = this.tickCount / 2;
            boolean inRange = entityHitDistance <= distance + 1.0F;
            boolean yawCheck = (entityRelativeYaw <= ARC / 2f && entityRelativeYaw >= -ARC / 2f) || (entityRelativeYaw >= 360 - ARC / 2f || entityRelativeYaw <= -360 + ARC / 2f);
            boolean pitchCheck = (entityRelativePitch <= ARC / 2f && entityRelativePitch >= -ARC / 2f) || (entityRelativePitch >= 360 - ARC / 2f || entityRelativePitch <= -360 + ARC / 2f);
            boolean CloseCheck = caster instanceof Lava_eaterEntity && entityHitDistance <= 2;
            boolean CloseCheck2 = caster instanceof Player && entityHitDistance <= 2;

            if (inRange && yawCheck && pitchCheck || CloseCheck) {
                if (this.tickCount % 3 == 0) {
                    if (!isAlliedTo(entityHit) && entityHit != caster && !(entityHit instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                        boolean flag = entityHit.hurt(this.damageSources().mobAttack(this.caster), (this.getDamage()));
                        if (flag) {
                            entityHit.setRemainingFireTicks(60);
                            entityHit.setDeltaMovement(entityHit.getDeltaMovement().multiply(0.25, 1, 0.25));
                        }
                    }
                }
            }

        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity) entity;
            }
        }

        return this.caster;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }


    @Override
    public boolean isPickable() {
        return false;
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    public void push(Entity entityIn) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return level().getEntitiesOfClass(entityClass, getBoundingBox().inflate(dX, dY, dZ), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f && e.getY() <= getY() + dY);
    }

    @Override
    public boolean isPushable() {
        return false;
    }


}
