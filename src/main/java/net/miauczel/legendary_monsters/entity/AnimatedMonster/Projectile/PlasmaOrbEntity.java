package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.Particle.custom.LightningParticle;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlasmaOrbEntity extends INoRendererEntity {


    public double xPower;
    public double yPower;
    public double zPower;
    private LivingEntity caster;
    private UUID casterUuid;
    private boolean leftOwner;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(PlasmaOrbEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TRANSPARENCY = SynchedEntityData.defineId(PlasmaOrbEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> TURN_LEFT =
            SynchedEntityData.defineId(PlasmaOrbEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> TURN_STRENGTH =
            SynchedEntityData.defineId(PlasmaOrbEntity.class, EntityDataSerializers.FLOAT);
    public int maxLife = 20;
    public int lifetick = 0;
    public AnimationState idleAnimationState = new AnimationState();

    public PlasmaOrbEntity(EntityType<? extends PlasmaOrbEntity> type, Level level) {
        super(type, level);
    }

    public PlasmaOrbEntity(EntityType<? extends PlasmaOrbEntity> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, Level level, float Yrot) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public PlasmaOrbEntity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage, float Yrot, float life) {
        this(ModEntities.ENERGY_DISC.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_, Yrot);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setYRot(Yrot);
        maxLife = (int) life;
    }

    public PlasmaOrbEntity(EntityType<? extends PlasmaOrbEntity> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.5D;
            this.yPower = p_36822_ / d0 * 0.5D;
            this.zPower = p_36823_ / d0 * 0.5D;
        }

    }

    public void applyAnnihilationEffect(LivingEntity entity, MobEffect effect, int bonusLevel) {
        int duration = 200;
        MobEffectInstance effectInstance = entity.getEffect(effect);

        if (entity.hasEffect(effect) && effectInstance != null) {

            int effectLevel = effectInstance.getAmplifier();
            if (effectLevel < 5) {
                entity.addEffect(new MobEffectInstance(effect, duration, effectLevel + bonusLevel));
            }
        } else if (!(entity.hasEffect(effect) && effectInstance != null)) {
            entity.addEffect(new MobEffectInstance(effect, duration, 0));
        }
    }

    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0f);
        this.entityData.define(TRANSPARENCY, 0);
        this.entityData.define(TURN_LEFT, true);
        this.entityData.define(TURN_STRENGTH, 4.5f);
    }

    public void setOwner(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity) entity;
            } else {
                this.casterUuid = null;
            }
        }
        return this.caster;
    }


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public int getTransparency() {
        return this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, trans);
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getOwner();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                    float m = ImpactEntity.getMaxHealth() * 0.03f;
                    boolean flag = ImpactEntity.hurt(damageSource, getDamage() + m);
                    if (flag)
                        TheObliteratorUtils.applyAnnihilationEffect(ImpactEntity, ModEffects.ANNIHILATION.get(), 1, false);
                    // ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),60,0));
                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }

                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                    float m = ImpactEntity.getMaxHealth() * 0.03f;
                    boolean flag = ImpactEntity.hurt(damageSource, getDamage() + m);
                    if (flag)
                        TheObliteratorUtils.applyAnnihilationEffect(ImpactEntity, ModEffects.ANNIHILATION.get(), 1, false);
                }
            }
        }
    }

    public void setTurnLeft(boolean left) {
        this.entityData.set(TURN_LEFT, left);
    }

    public boolean isTurnLeft() {
        return this.entityData.get(TURN_LEFT);
    }

    public void setTurnStrength(float strength) {
        this.entityData.set(TURN_STRENGTH, strength);
    }

    public float getTurnStrength() {
        return this.entityData.get(TURN_STRENGTH);
    }

    @Override
    public void tick() {
        if (tickCount % 4 == 0) {
            for (int i = 0; i < 0.1; ++i) {
                if (level().isClientSide) {
                    double uniformScale = 0.5f;
                    this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getRandomX(uniformScale), this.getRandomY(), this.getRandomZ(uniformScale), 0D, 0.025D, 0D);
                }
            }
        }
        if (this.level().isClientSide) {
            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
            float ran = 0.4f;
            float r = 0 / 255F;
            float g = 195 / 255F + random.nextFloat() * ran;
            float b = 0 / 255F;
            this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 0.8f, this.getId())), dx, dy, dz, 0, 0, 0);


            double d0 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().x;
            double d1 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().y;
            double d2 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().z;
            double dist = 1F + random.nextFloat() * 0.2F;
            double d3 = d0 * dist;
            double d4 = d1 * dist;
            double d5 = d2 * dist;
            this.level().addParticle(new LightningParticle.OrbData(25, 255, 0), this.getX() + d0, this.getY() + 1, this.getZ() + d2, d3, d4, d5);

            this.level().addParticle(new LightningParticle.OrbData(255, 255, 255), this.getX() + d0, this.getY() + 1, this.getZ() + d2, d3, d4, d5);

        }
        super.tick();

        if (tickCount % 2 == 0) {

        }

        for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.25)))
              this.damage(livingentity);
            if (lifetick == maxLife - 2) {
                if (level().isClientSide) {
                    level().addParticle(ModParticles.DIMENSIONAL_EXPLOSION.get(),
                            getX(), getY(), getZ(),
                            0, 0, 0);
                }
            }
        if (lifetick >= maxLife) {
            if (!level().isClientSide) {
                if (caster != null) {
                    AnnihilationExplosionEntity entity = new AnnihilationExplosionEntity(level(), getX(), getY(), getZ(), 0, 0, this.caster, 20, 7, 2);
                    // level().addFreshEntity(entity);
                }
                if (level() instanceof ServerLevel level) {
                    //  level.sendParticles(ModParticles.ANNIHILATION_EXPLOSION.get(), getX(), getY(), getZ(), 1, 0, 0, 0, 0);
                }
                discard();
            }

        }
        if (!level().isClientSide) {
            lifetick++;
            setTransparency(lifetick);
            if (lifetick >= maxLife) {
                // this.discard();

                if (getOwner() instanceof Mob mob && getOwner() != null && mob.getTarget() != null) {
                }
                return;
            }
        } else {
            idleAnimationState.animateWhen(true, tickCount);
        }

        if (lifetick == maxLife - 3) {
            for (Entity passenger : getPassengers()) {
                passenger.stopRiding();
            }
        }

        if (!leftOwner) {
            leftOwner = checkLeftOwner();
        }

        HitResult hit = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hit.getType() != HitResult.Type.MISS) {
            this.onHit(hit);
        }

        BlockPos posHere = blockPosition().atY((int) getY());
        BlockPos posBelow = blockPosition().below();
        BlockState stateHere = level().getBlockState(posHere);
        BlockState stateBelow = level().getBlockState(posBelow);
        if (stateHere.getBlock() instanceof FireBlock || stateBelow.getBlock() instanceof FireBlock) {
            onFire = true;
        }
        LivingEntity owner = getOwner();
        if (owner != null && !owner.isAlive()) {
            if (!level().isClientSide) {
                level().broadcastEntityEvent(this, (byte) 10);
                this.discard();
            }
            return;
        }

        float turnStrength = getTurnStrength();
        float deltaYaw = isTurnLeft() ? -turnStrength : turnStrength;
        float newYaw = getYRot() + deltaYaw;
        setYRot(newYaw);

        double rad = Math.toRadians(deltaYaw);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        Vec3 oldVel = getDeltaMovement();
        Vec3 drifted = new Vec3(
                oldVel.x * cos - oldVel.z * sin,
                oldVel.y,
                oldVel.x * sin + oldVel.z * cos
        );

        double thrustMag = Math.sqrt(xPower * xPower + zPower * zPower);
        double yawRad = Math.toRadians(newYaw);
        Vec3 forward = new Vec3(
                -Math.sin(yawRad) * thrustMag,
                0,
                Math.cos(yawRad) * thrustMag
        );

        Vec3 newVel = drifted.scale(getInertia()).add(forward);
        setDeltaMovement(newVel);

        move(MoverType.SELF, newVel);
    }

    boolean hasHurt = false;

    protected void onHitEntity(EntityHitResult p_37626_) {
        Entity entity2 = p_37626_.getEntity();
        if (entity2 instanceof LivingEntity entity) {
            LivingEntity entity1 = this.getOwner();
            if (entity1 != null)
            // entity.hurt(ModDamageTypes.causeAnnihilationDamage(entity1, entity1), this.getDamage() + MathUtils.entityBasedHpDamage(entity, 3));
            this.setDeltaMovement(0.0D, 0.0D, 0.0D);
            if (entity1 != null) this.doEnchantDamageEffects(entity1, entity);

        }

    }


    protected void onHitBlock(BlockHitResult result) {

    }

    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult) p_37260_);
            hasHurt = true;
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, p_37260_.getLocation(), GameEvent.Context.of(this, null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult) p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return canHit(p_36842_) && !p_36842_.noPhysics;
    }


    protected boolean canHit(Entity p_37250_) {
        if (!p_37250_.canBeHitByProjectile()) {
            return false;
        } else {
            Entity entity = this.getOwner();
            return entity == null || this.leftOwner;
        }
    }


    protected float getInertia() {
        return 0.9F;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.contains("power", 9)) {
            ListTag listtag = compound.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
        compound.put("power", this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));

    }

    private boolean checkLeftOwner() {
        Entity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.level().getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (p_234613_0_) -> {
                return !p_234613_0_.isSpectator() && p_234613_0_.isPickable();
            })) {
                if (entity1.getRootVehicle() == entity.getRootVehicle()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return false;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {

        return false;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    public boolean inWater() {
        return false;
    }

    public boolean onFire = false;

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, 0, this.zPower), 0.0D);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.tickCount = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }
}