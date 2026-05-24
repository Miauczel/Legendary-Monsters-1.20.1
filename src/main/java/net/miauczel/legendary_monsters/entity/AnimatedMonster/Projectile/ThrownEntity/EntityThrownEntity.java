package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AirTrailParticle;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.ShulkerMimicPart;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AbstractFlyingProjectile;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EntityThrownEntity extends ThrowableProjectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(EntityThrownEntity.class, EntityDataSerializers.FLOAT);
    public EntityThrownEntity(EntityType<? extends EntityThrownEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public EntityThrownEntity(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ, float damage,float interia, LivingEntity passenger) {
        super(ModEntities.ENTITY_THROWN .get(),pLevel);
        setDamage(damage);
        setOwner(pShooter);
        moveTo(pOffsetX,pOffsetY,pOffsetZ);
        setInteria(interia);
        if (passenger != null) {
            passenger.startRiding(this,true);
        }
    }
    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }
    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    float interia = 1f;
    protected float getInertia() {
        return interia;
    }
    public void setInteria(float interia1){
        interia = interia1;
    }

    protected float getDamage() {
        return entityData.get(DAMAGE);
    }
    public void setDamage(float damage){
        entityData.set(DAMAGE,damage);;
    }

    /**
     * Returns {@code true} if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double)this.distanceTo(e) <= r + (double)(e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }
    public boolean isOnFire() {
        return false;
    }
    private void AreaAttack(float range, float height, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.getYRot() % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit)  &&!(entityHit instanceof Shulker_MimicEntity)) {
                    if (getOwner() !=null) {
                        if (getOwner() instanceof LivingEntity livingEntity) {
                            entityHit.setDeltaMovement(getDeltaMovement().x,0.3f,getDeltaMovement().z);
                            float m = entityHit.getMaxHealth() *0.01f;
                            boolean flag = entityHit.hurt(ModDamageTypes.causeGravityDamage(livingEntity,livingEntity), damage);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void tick() {

        if (this.level().isClientSide) {
            this.level().addParticle(this.getTrailParticle(), getX(), getY() + 0.5D, getZ(), 0.0D, 0.0D, 0.0D);
            if (tickCount % 3 == 0) {
                float yaw = (float) Math.toRadians(-getYRot() + 180);

                float yaw2 = (float) Math.toRadians(-getYRot() + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);

                double theta = (this.getYRot()) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                Vec3 vec3 = getDeltaMovement();
                double spawnX = this.getX() + vec3.x + vecX * 1.5f;
                double spawnZ = this.getZ() + vec3.z + vecZ * 1.5f;
                this.level().addParticle(new Circle.RingData(this.horizontalCollision ? 0 : yaw, horizontalCollision ? 90 : 0, 30,
                        1, 1, 1, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);
            }
        }
        if (this.isVehicle()){
            if (getFirstPassenger() instanceof Player player){
                player.setShiftKeyDown(false);
            }
        }
        super.tick();
    }


    /**
     * Explosion resistance of a block relative to this entity
     */

    public float getBlockExplosionResistance(Explosion pExplosion, BlockGetter pLevel, BlockPos pPos, BlockState pBlockState, FluidState pFluidState, float pExplosionPower) {
        return pExplosionPower;
    }

    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.CLOUD;
    }

    /**
     * Called when the arrow hits an entity
     *
     **/
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() == this.getFirstPassenger())return;
        super.onHitEntity(pResult);

        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity livingentity) {

                flag = entity.hurt(this.damageSources().mobAttack(livingentity), 8.0F);
                if (flag) {
                    if (entity.isAlive()) {
                        this.doEnchantDamageEffects(livingentity, entity);
                    }
                }
            }
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId <=0){
            tickCount =0;
        }else if (pId == 1) {
                this.level().addParticle(this.getTrailParticle(), getX(), getY() + 0.5D, getZ(), 0.0D, 0.0D, 0.0D);

                float yaw = (float) Math.toRadians(-getYRot() + 0);
                float pitch = (float) Math.toRadians(-getX() + 0);

                double theta = (this.getYRot()) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                Vec3 vec3 = getDeltaMovement();
                double spawnX = this.getX() + vec3.x + vecX * 1.5f;
                double spawnZ = this.getZ() + vec3.z + vecZ * 1.5f;
                this.level().addParticle(new Circle.RingData((float) 0, (float) (Math.PI/2), 30,
                        1, 1, 1, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);
            this.level().addParticle(new Circle.RingData((float) (Math.PI/2), (float)0 , 30,
                    1, 1, 1, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);


        }else
            super.handleEntityEvent(pId);
    }

    @Override
    protected float getGravity() {
        return super.getGravity();
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */

    protected void onHit(HitResult pResult) {
handleEntityEvent((byte) 1);
        if (pResult instanceof EntityHitResult)return;
        super.onHit(pResult);
        AreaAttack(3,3,360,5);
        CameraShakeEntity.cameraShake(level(),position(),5,0.09f,5,5);
        playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,1,1);
                ParticleOptions particleOptions = new Circle.RingData(0, MathUtils.PI / 2, 30, 1, 1, 1, 1, 100, false, Circle.EnumRingBehavior.GROW);
              //  level.sendParticles(particleOptions, getX(), getY(), getZ(), 1, 0, 0, 0, 0);
                level().addParticle(particleOptions,getX(), getY(), getZ(),0,0,0);



        if (!this.level().isClientSide) {
          //  this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, Level.ExplosionInteraction.MOB);
            this.discard();
        }

    }

    /**
     * Returns {@code true} if other Entities should be prevented from moving through this Entity.
     */
    public boolean isPickable() {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

    protected void defineSynchedData() {
        entityData.define(DAMAGE,0f);
    }

    protected boolean shouldBurn() {
        return false;
    }
}
