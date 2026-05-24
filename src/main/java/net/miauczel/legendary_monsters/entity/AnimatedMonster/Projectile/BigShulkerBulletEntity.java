package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.ShulkerMimicPart;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BigShulkerBulletEntity extends AbstractFlyingProjectile {
    private static final EntityDataAccessor<Boolean> DATA_DANGEROUS = SynchedEntityData.defineId(BigShulkerBulletEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(BigShulkerBulletEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> IS_FIREWORK = SynchedEntityData.defineId(BigShulkerBulletEntity.class, EntityDataSerializers.BOOLEAN);
    public BigShulkerBulletEntity(EntityType<? extends BigShulkerBulletEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BigShulkerBulletEntity(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ,float size,boolean isFirework,LivingEntity passenger) {
        super(ModEntities.BIG_SHULKER_BULLET.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
        setSize(size);
        setIsFirework(isFirework);
        if (passenger != null) {
            passenger.startRiding(this,true);
        }
    }
public boolean getIsFirework(){
        return entityData.get(IS_FIREWORK);
}
public void setIsFirework(boolean isFirework){
        entityData.set(IS_FIREWORK,isFirework);
}
    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
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
    float interia = 1f;
    protected float getInertia() {
        return interia;
    }
    public void setInteria(float interia1){
        interia = interia1;
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
        super.tick();
        if (this.isVehicle()){
            if (getFirstPassenger() instanceof Player player){
                player.setShiftKeyDown(false);
            }
        }
        if (getIsFirework() && this.tickCount >12) {
     playSound(SoundEvents.SHULKER_BULLET_HIT,1,0.75f);
            float f1 = (this.random.nextFloat() - 0.75F) * 3.0F;
            float f2 = (this.random.nextFloat() - 0.75F) * 2.5F;
            float f3 = (this.random.nextFloat() - 0.7F) * 3.0F;

            float f4 = (this.random.nextFloat() - 0.5F) * 4.0F;
            float f5 = (this.random.nextFloat() - 0.5F) * 2.0F;
            float f6 = (this.random.nextFloat() - 0.5F) * 4.0F;

            for (int i = 0; i < 10; i++) {
                if (this.level() instanceof ServerLevel level) {
                   // System.out.println("Adding Particles");

                    level.sendParticles(ModParticles.SHULKER_EXPLOSION.get(),
                            getX() + (double) f1, this.getY() + 1 + (double) f2, getZ() + (double) f3, 15, 0, 0, 0, 0);

                    level.sendParticles(ModParticles.PURPLE_SHULKER_EXPLOSION.get(),
                            getX() + (double) f4, this.getY() + 1 + (double) f5, getZ() + (double) f6, 15, 0, 0, 0, 0);
                }
            }
        }

        if ((getIsFirework() ?this.tickCount >16: this.tickCount >300) || (getOwner() == null && !level().isClientSide)){
            if (getIsFirework()) {
                AreaAttack(5,5,360,8);
                discard();
            }else {
                discard();
            }
        }
        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
        float random1 = 0.25f;
        float r = 255/255F;
        float g = 255/255F ;
        float b =  255/255F + this.random.nextFloat() * random1 ;
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

    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.END_ROD;
    }

    /**
     * Called when the arrow hits an entity
     *
     **/

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (getIsFirework())return;
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
if (entity instanceof LivingEntity livingEntity){ livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (40*getSize()), 1), this.getEffectSource());}

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

        if (getIsFirework())return;
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

        this.entityData.define(IS_FIREWORK, false);
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
