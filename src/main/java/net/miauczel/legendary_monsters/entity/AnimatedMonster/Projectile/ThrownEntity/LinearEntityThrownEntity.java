package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AbstractFlyingProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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


public class LinearEntityThrownEntity extends AbstractFlyingProjectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(LinearEntityThrownEntity.class, EntityDataSerializers.FLOAT);
    public LinearEntityThrownEntity(EntityType<? extends LinearEntityThrownEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LinearEntityThrownEntity(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ, float damage, float interia, LivingEntity passenger) {
        super(null, pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
        setDamage(damage);
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
                            float m = entityHit.getMaxHealth() *0.01f;
                            boolean flag = entityHit.hurt(ModDamageTypes.causeGravityDamage(livingEntity,livingEntity), (float) ((damage * ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get())+m));
                        }
                    }
                }
            }
        }
    }
    @Override
    public void tick() {

        if (level().isClientSide) this.level().addParticle(this.getTrailParticle(), getX(), getY() + 0.5D, getZ(), 0.0D, 0.0D, 0.0D);
        if (this.level().isClientSide) {
            if (tickCount % 3 == 0) {
                float yaw = (float) Math.toRadians(-getYRot() + 180);
                float pitch = (float) Math.toRadians(-getX() + 180);

                double theta = (this.getYRot()) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                Vec3 vec3 = getDeltaMovement();
                double spawnX = this.getX() + vec3.x + vecX * 1.5f;
                double spawnZ = this.getZ() + vec3.z + vecZ * 1.5f;
                this.level().addParticle(new Circle.RingData(yaw, pitch, 30,
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

    @Override
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

    /**
     * Called when this EntityFireball hits a block or entity.
     */

    protected void onHit(HitResult pResult) {

        if (pResult instanceof EntityHitResult)return;
        super.onHit(pResult);
        if (level() instanceof ServerLevel level){
           // level.sendParticles(ModParticles.SHULKER_EXPLOSION.get(), getX(),getY(),getZ(),1,0,0,0,0);
        }
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
