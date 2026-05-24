package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorPart;
import net.miauczel.legendary_monsters.sound.ModSounds;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class SmallAnnihilationBombEntity extends ThrowableProjectile {

    public SmallAnnihilationBombEntity(EntityType<SmallAnnihilationBombEntity> type, Level world) {
        super(type, world);
    }

    public SmallAnnihilationBombEntity(EntityType<SmallAnnihilationBombEntity> type, Level world, LivingEntity thrower, float damage) {
        super(type, thrower, world);
        this.setOwner(thrower);
        setDamage(damage);
    }

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(SmallAnnihilationBombEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Float> TURN_RATE = SynchedEntityData.defineId(SmallAnnihilationBombEntity.class, EntityDataSerializers.FLOAT);

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0f);

        this.entityData.define(TURN_RATE, 0.075f);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);

    }

    public float getTurnRate() {
        return entityData.get(TURN_RATE);
    }

    public void setTurnRate(float turnRate) {
        entityData.set(TURN_RATE, turnRate);

    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (level().isClientSide) return;

        Entity target = result.getEntity();
        Entity owner = this.getOwner();

        if (owner instanceof LivingEntity livingOwner && (!(target instanceof TamableAnimal animal && animal.getOwner() == owner))) {
            if (target != livingOwner && !(target instanceof TheObliteratorPart)) {
                target.hurt(ModDamageTypes.causeAnnihilationDamage(livingOwner, livingOwner),
                        (float) (getDamage() * (getOwner() instanceof TheObliteratorEntity ? ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get() : ModConfig.MOB_CONFIG.FlameDrifterDamageMutliplier.get())));
            }
        }
    }

    public boolean isTurning() {
        return entityData.get(TURN_RATE) == 0;
    }

    @Override
    public void onHit(HitResult result) {
        super.onHit(result);

        if (!level().isClientSide && level() instanceof ServerLevel server) {

            double d0 = this.getX();
            double d1 = this.getY() + 2.0D;
            double d2 = this.getZ();
            //this.level().addAlwaysVisibleParticle(ModParticles.GREEN_FIRE_STRIKE.get(), d0, d1, d2, 0, 0, 0);

            server.sendParticles(ModParticles.ANNIHILATION_FLAME_STRIKE.get(), d0, d1, d2, 1, 0, 0, 0, 0);
            this.discard();
            //server.sendParticles(ModParticles.DIMENSIONAL_BOMB_EXPLOSION.get(), getX(), getY() + 1, getZ(), 1, 0, 0, 0, 0);

        }
        playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), 0.1f, 1);
        // this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), this.getSoundSource(), 0.25F, 1F, false);
        //  CameraShakeEntity.cameraShake(this.level(), this.position(), 40.0F, 0.3F, 0, 20);

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
        //  System.out.println(getOwner() !=null ? "Caster: " + this.getOwner().getStringUUID() : "Caster is null");
        if (tickCount % 5 == 0) {
            this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
        }
        if (isTurning()) {
            Vec3 motion = this.getDeltaMovement();

            float turnRate = getTurnRate();

            Vec3 newMotion = motion.yRot(turnRate);

            this.setDeltaMovement(newMotion);

            float yaw = (float) (Mth.atan2(newMotion.z, newMotion.x) * (180F / Math.PI)) - 90F;
            float pitch = (float) (Mth.atan2(newMotion.y,
                    Math.sqrt(newMotion.x * newMotion.x + newMotion.z * newMotion.z))
                    * (180F / Math.PI));
            this.setYRot(yaw);
            this.setXRot(pitch);
        }
        if (this.level().isClientSide) {

            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
            float ran = 0.4f;
            float r = 0 / 255F;
            float g = 195 / 255F + random.nextFloat() * ran;
            float b = 0 / 255F;
            this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.2F, 0.5f, this.getId())), dx, dy, dz, 0, 0, 0);

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

