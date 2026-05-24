package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.ShulkerMimicPart;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class GravityBigShulkerEntity extends ThrowableProjectile {
    private static final EntityDataAccessor<Boolean> DATA_DANGEROUS = SynchedEntityData.defineId(GravityBigShulkerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(GravityBigShulkerEntity.class, EntityDataSerializers.FLOAT);



    public GravityBigShulkerEntity(EntityType<GravityBigShulkerEntity> gravityBigShulkerEntityEntityType, Level level) {
        super(gravityBigShulkerEntityEntityType,level);
    }


    public EntityDimensions getDimensions(Pose pPose) {
        return EntityDimensions.scalable(1f*(getSize() * 1.25f) , 1F*(getSize() * 1.25f));
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (SIZE.equals(p_21104_)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(p_21104_);
    }
    public float getSize(){
        return entityData.get(SIZE);
    }
    public void setSize(float size){
        entityData.set(SIZE,size);
    }

    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    protected float getInertia() {
        return 1F;
    }

    /**
     * Returns {@code true} if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isOnFire() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount >300 || (getOwner() == null && !level().isClientSide)){
            discard();
        }
        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
        float random1 = 0.25f;
        float random2 = 0.1f;
        float r = 255/255F;
        float g = 255/255F ;
        float b = 255/255F;
        if  (level().isClientSide) {
            this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, (getSize() * 0.5f), (getSize() * 0.75f), this.getId())), dx, dy, dz, 0, 0, 0);
        }
    }


    /**
     * Explosion resistance of a block relative to this entity
     */

    public float getBlockExplosionResistance(Explosion pExplosion, BlockGetter pLevel, BlockPos pPos, BlockState pBlockState, FluidState pFluidState, float pExplosionPower) {
        return this.isDangerous() && pBlockState.canEntityDestroy(pLevel, pPos, this) ? Math.min(0.8F, pExplosionPower) : pExplosionPower;
    }


    /**
     * Called when the arrow hits an entity
     *
     **/

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (pResult.getEntity() == this.getOwner()){
            return;
        }
        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity) {
                if (!(entity instanceof ShulkerMimicPart)) {
                    LivingEntity livingentity = (LivingEntity) entity1;
                    flag = entity.hurt(ModDamageTypes.causeGravityDamage(getOwner(), (LivingEntity) getOwner()), 3.0F + (getSize() * 3));
if (entity instanceof LivingEntity livingEntity){

    livingEntity.addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 100, 1), this.getEffectSource());
    livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 1), this.getEffectSource());
}

                    if (flag) {
                        if (entity.isAlive()) {
                            this.doEnchantDamageEffects(livingentity, entity);
                        }
                    }
                }
            } else {
                if (getOwner() !=null) {
                    if (!(entity instanceof ShulkerMimicPart)){
                        flag = entity.hurt(ModDamageTypes.causeGravityDamage(getOwner(), (LivingEntity) getOwner()), 3.0F + (getSize() * 3));

                        if (flag && entity instanceof LivingEntity) {

                            LivingEntity livingentity1 = (LivingEntity) entity;

                            livingentity1.addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 100, 1), this.getEffectSource());
                            livingentity1.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 1), this.getEffectSource());
                        }
                    }
                }
            }

        }
    }


    /**
     * Called when this EntityFireball hits a block or entity.
     */

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (level() instanceof ServerLevel level){
            level.sendParticles(ModParticles.SHULKER_EXPLOSION.get(), getX(),getY(),getZ(),1,0,0,0,0);
        }
        playSound(SoundEvents.SHULKER_BULLET_HIT,1,1);
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
        this.entityData.define(DATA_DANGEROUS, false);

        this.entityData.define(SIZE, 1f);
    }

    /**
     * Return whether this skull comes from an invulnerable (aura) wither boss.
     */
    public boolean isDangerous() {
        return this.entityData.get(DATA_DANGEROUS);
    }

    /**
     * Set whether this skull comes from an invulnerable (aura) wither boss.
     */
    public void setDangerous(boolean pInvulnerable) {
        this.entityData.set(DATA_DANGEROUS, pInvulnerable);
    }

    protected boolean shouldBurn() {
        return false;
    }
}
