package net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.UUID;

public class SoulShieldEntity extends IHurtingEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 30;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Boolean> IS_OUTER = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DESTINATION_Z = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_Y = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_X = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_RED = SynchedEntityData.defineId(SoulShieldEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean getRed() {
        return entityData.get(IS_RED);
    }

    public void setRed(boolean damage) {
        entityData.set(IS_RED, damage);
    }

    public float activateProgress;
    public float prevactivateProgress;

    public SoulShieldEntity(EntityType<? extends SoulShieldEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    public SoulShieldEntity(Level worldIn, double x, double y, double z, float yawRad, int p_i47276_9_, LivingEntity casterIn,
                            float damage, float destX, float destY, float destZ, boolean isOuter, boolean isRed) {
        this(ModEntities.SOUL_SHIELD.get(), worldIn);
        setIsOuter(isOuter);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        float yawDeg = yawRad * (180F / (float) Math.PI) - 90F;
        this.setYRot(yawDeg);
        this.setPos(x, y, z);
        if (!isOuter) {
            setDestinationX(destX);
            setDestinationY(destY);
            setDestinationZ(destZ);
        }
        setRed(isRed);
        setDamage(damage);
        setMaxUpStep(1.5f);
        noPhysics = true;
    }

    public boolean isGlowing() {
        return this.getSharedFlag(6);
    }

    public float getDestinationX() {
        return entityData.get(DESTINATION_X);
    }

    public float getDestinationY() {
        return entityData.get(DESTINATION_Y);
    }

    public float getDestinationZ() {
        return entityData.get(DESTINATION_Z);
    }

    public boolean getIsOuter() {
        return entityData.get(IS_OUTER);
    }

    public void setDestinationX(float destination) {
        entityData.set(DESTINATION_X, destination);
    }

    public void setDestinationY(float destination) {
        entityData.set(DESTINATION_Y, destination);
    }

    public void setDestinationZ(float destination) {
        entityData.set(DESTINATION_Z, destination);
    }

    public void setIsOuter(boolean isOuter) {
        entityData.set(IS_OUTER, isOuter);
    }

    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.valueOf(false));

        this.entityData.define(DESTINATION_X, 0f);

        this.entityData.define(DESTINATION_Y, 0f);

        this.entityData.define(DESTINATION_Z, 0f);

        this.entityData.define(IS_OUTER, false);

        this.entityData.define(IS_RED, false);
        super.defineSynchedData();
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
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }

    }

    public AnimationState emergeAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "emerge") {
            return this.emergeAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ANIMATIONSTATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAnimationState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        stopAllAnimationStates();
                        this.emergeAnimationState.startIfStopped(this.tickCount);
                    }


                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.emergeAnimationState.stop();

    }

    /**
     * Called to update the entity's position/logic.
     */
    public final ControlledAnim RendercontrolledAnim = new ControlledAnim(15);

    public final ControlledAnim RendercontrolledAnim2 = new ControlledAnim(15);

    @Override
    public int disappearTicks() {
        return 10;
    }


    public void tick() {
        super.tick();
        if (lifeTicks > 50) {
            controlledAnim.increaseTimer();
            timer = controlledAnim.getTimer();
            // System.out.println("Animation: " + controlledAnim.getTimer());
        }
        for (int i = 0; i < 10; ++i) {
            BlockState block = level().getBlockState(blockPosition().below());
            double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d1 = this.getY() + 0.03D;
            double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d3 = (this.random.nextGaussian() * 0.07D);
            double d4 = (this.random.nextGaussian() * 0.07D);
            double d5 = (this.random.nextGaussian() * 0.07D);

            if (level().isClientSide) {
                if (tickCount % 5 == 0)
                    level().addParticle(getRed() ? ModParticles.GROUNDSOUL_RED.get() : ModParticles.GROUNDSOUL.get(), getX(), getY() + 2, getZ(), 0, 0, 0);
                this.level().addParticle(getRed() ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(), d0, d1, d2, d3, d4, d5);
            }
        }
        if (this.getIsOuter()) {
            float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
            double theta = (getYRot()) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 8f;
            float offset = 0f;
            setDestinationX((float) (getX() + vec * vecX + f * offset));
            setDestinationY((float) getY());
            setDestinationZ((float) (getZ() + vec * vecZ + f1 * offset));
        }
        for (LivingEntity livingEntity : level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.25f))) {
            damage(livingEntity);
        }

        Vec3 toDest = new Vec3(
                getDestinationX() - getX(),
                getDestinationY() - getY(),
                getDestinationZ() - getZ()
        );

        double distance = toDest.length();
        double distancetotarget = toDest.length() * 0.05f;
        double speed = 0.1 + distancetotarget;

        if (distance <= speed) {
        } else {

            Vec3 motion = toDest.normalize().scale(speed);
            this.move(MoverType.SELF, motion);
        }
        RendercontrolledAnim2.increaseTimer();

        Vec3 vec3 = new Vec3(getDestinationX(), getDestinationY(), getDestinationZ());
        lookAt(
                EntityAnchorArgument.Anchor.EYES,
                vec3

        );

        this.prevactivateProgress = this.activateProgress;

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }

            if (++this.lifeTicks > 55) {
                this.discard();
            }
            //  System.out.println("LIFE: " + lifeTicks);

        }

    }

    public int timer;

    public int getTimer() {
        return timer;
    }

    public boolean isActivate() {
        return this.entityData.get(ATTACK);
    }

    public void setActivate(boolean Activate) {
        this.entityData.set(ATTACK, Activate);
    }


    /**
     * Handler for
     */
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;

        }
        if (id <= 0) {
            lifeTicks = 0;
        }

    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    public LivingEntity target() {
        if (caster != null && caster instanceof Mob) {
            return ((Mob) caster).getTarget();
        } else {
            return null;
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (getAnimationState() == 0) {
            this.setAnimationState(1);
        }
    }

    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getCaster();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);
                    boolean flag = ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));
                    if (flag) {
                        if (caster != null) caster.heal(5);
                        EntityUtil.applyStackingEffect(ImpactEntity, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                        //  ImpactEntity.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.85f, getDeltaMovement().z);
                        //  EntityUtil.applyPlayerDeltaMovement(ImpactEntity);
                    }
                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);
                    boolean hurt = ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));
                    if (hurt) {

                        EntityUtil.applyStackingEffect((LivingEntity) ImpactEntity, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                        // ImpactEntity.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.85f, getDeltaMovement().z);
                        //  EntityUtil.applyPlayerDeltaMovement(ImpactEntity);
                        if (caster != null) caster.heal((5));
                    }
                    if (!level().isClientSide) {
                        //  ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(), 60, 0));
                    }
                }
            }
        }
    }

    public float getAnimationProgress(float pPartialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int $$1 = this.lifeTicks - 2;
            return $$1 <= 0 ? 1.0F : 1.0F - ((float) $$1 - pPartialTicks) / 20.0F;
        }
    }

}
