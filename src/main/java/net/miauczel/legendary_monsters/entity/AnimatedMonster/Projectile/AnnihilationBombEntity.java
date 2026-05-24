package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Chorusling.TheWarpedOne.TheWarpedOneOld;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;

public class AnnihilationBombEntity extends ThrowableProjectile {

    public AnnihilationBombEntity(EntityType<AnnihilationBombEntity> type, Level world) {
        super(type, world);
    }

    public AnnihilationBombEntity(EntityType<AnnihilationBombEntity> type, Level world, LivingEntity thrower, float damage, int bulletsAmount, boolean silent) {
        super(type, thrower, world);
        this.setOwner(thrower);
        setDamage(damage);
        setBulletsAmount(bulletsAmount);
        setSilent1(silent);
    }

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AnnihilationBombEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Boolean> SILENT = SynchedEntityData.defineId(AnnihilationBombEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> BULLETS_AMOUNT = SynchedEntityData.defineId(AnnihilationBombEntity.class, EntityDataSerializers.INT);

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0f);
        this.entityData.define(BULLETS_AMOUNT, 0);

        this.entityData.define(SILENT, false);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);

    }

    public boolean isSilent1() {
        return entityData.get(SILENT);
    }

    public void setSilent1(boolean silent) {
        entityData.set(SILENT, silent);
    }

    public float getBulletAmount() {
        return entityData.get(BULLETS_AMOUNT);
    }

    public void setBulletsAmount(int bulletsAmount) {
        entityData.set(BULLETS_AMOUNT, bulletsAmount);

    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (level().isClientSide) return;

        Entity target = result.getEntity();
        Entity owner = this.getOwner();

        if (owner != null && target == owner && (!(target instanceof TamableAnimal animal && animal.getOwner() == owner))) {
            return;

        }
        if (target instanceof LivingEntity) {
            if (owner instanceof LivingEntity livingOwner) {
                target.hurt(ModDamageTypes.causeAnnihilationDamage(livingOwner, livingOwner), getDamage());
                TheObliteratorUtils.applyAnnihilationEffect((LivingEntity) target, ModEffects.ANNIHILATION.get(), 1, false);
            }
        }
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double) this.distanceTo(e) <= r + (double) (e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }

    public void AreaAttack(float range, float height, float arc, float damage) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheWarpedOneOld)) {

                    if (getOwner() instanceof LivingEntity) {
                        boolean flag = entityHit.hurt(ModDamageTypes.causeAnnihilationDamage(getOwner(), (LivingEntity) getOwner())
                                , (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
                    }

                }
            }
        }
    }

    @Override
    public void onHit(HitResult result) {
        super.onHit(result);
        if (isSilent1()) {
            level().playLocalSound(getX(), getY(), getZ(), ModSounds.DIMENSIONAL_BOMB_EXPLODE.get(), this.getSoundSource(), 0.3F, 1F, false);
        } else {
            playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE.get(), 1, 1);
        }
        float f3 = (this.random.nextFloat() - 0.5F) * 4.0F;
        float f4 = (this.random.nextFloat() - 0.5F) * 4.0F;
        float f5 = (this.random.nextFloat() - 0.5F) * 4.0F;

        ParticleUtils.sendParticlesToServer(level(), ModParticles.GROUND_ANNIHILATION_NUKE.get(), getX() + f3, getY() + 2 + f4, getZ() + f5, 1, 0, 0, 0, 0);
        ParticleUtils.sendParticlesToServer(level(), ModParticles.GROUND_ANNIHILATION_NUKE.get(), getX() + f3, getY() + 2 + f4, getZ() + f5, 1, 0, 0, 0, 0);


        LivingEntity entity = (LivingEntity) this.getOwner();
        //Small Spread
        float smallBulletAmount = getBulletAmount() * 0.5f;
        for (int i = 0; i < smallBulletAmount; i++) {
            if (entity != null) {
                float throwAngle = i * Mth.PI / (smallBulletAmount / 2);

                double sx = getX() + (Mth.cos(throwAngle) * 1);
                double sy = getY() + (getBbHeight() * 0.2D);
                double sz = getZ() + (Mth.sin(throwAngle) * 1);

                double vx = Mth.cos(throwAngle);
                double vy = 0 + entity.getRandom().nextFloat() * 0.3F;
                double vz = Mth.sin(throwAngle);
                double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                SmallAnnihilationBombEntity projectile = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), entity.level(), entity, 8);

                projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());
                float speed = 0.5F;
                projectile.shoot(vx, vy + v3 * 2, vz, speed, 1.0F);
                entity.level().addFreshEntity(projectile);
            }
        }
        //Big Spread
        for (int i = 0; i < getBulletAmount(); i++) {
            if (entity != null) {
                float throwAngle = i * Mth.PI / (getBulletAmount() / 2);

                double sx = getX() + (Mth.cos(throwAngle) * 1);
                double sy = getY() + (getBbHeight() * 0.2D);
                double sz = getZ() + (Mth.sin(throwAngle) * 1);

                double vx = Mth.cos(throwAngle);
                double vy = 0 + entity.getRandom().nextFloat() * 0.3F;
                double vz = Mth.sin(throwAngle);
                double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                SmallAnnihilationBombEntity projectile = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), entity.level(), (LivingEntity) getOwner(), 8);

                projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());
                float speed = 0.7F;
                projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                entity.level().addFreshEntity(projectile);
            }
        }
        if (!level().isClientSide && level() instanceof ServerLevel server) {
            double d0 = this.getX();
            double d1 = this.getY() + 2.0D;
            double d2 = this.getZ();
            server.sendParticles(ModParticles.ANNIHILATION_FLAME_STRIKE.get(), d0, d1, d2, 1, 0, 0, 0, 0);
            this.discard();
        }
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
            if (tickCount % 3 == 0) {
                for (int i = 0; i < 0.1; ++i) {
                    if (level().isClientSide) {
                        double uniformScale = 0.5f;
                        this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getRandomX(uniformScale), this.getRandomY(), this.getRandomZ(uniformScale), 0D, 0.025D, 0D);
                    }
                }
            }
            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
            float ran = 0.4f;
            float r = 0 / 255F;
            float g = 195 / 255F + random.nextFloat() * ran;
            float b = 0 / 255F;
            if (level().isClientSide) {
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 0.8f, this.getId())), dx, dy, dz, 0, 0, 0);
            }

            double d0 = (random.nextFloat()) + this.getDeltaMovement().x;
            double d1 = (random.nextFloat()) + this.getDeltaMovement().y;
            double d2 = (random.nextFloat()) + this.getDeltaMovement().z;

        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.tickCount = 0;
        } else {
            super.handleEntityEvent(id);
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

