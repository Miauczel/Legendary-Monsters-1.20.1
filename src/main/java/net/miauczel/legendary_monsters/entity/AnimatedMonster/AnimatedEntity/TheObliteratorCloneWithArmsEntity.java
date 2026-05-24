package net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class TheObliteratorCloneWithArmsEntity extends IHurtingEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 17;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    public float lastYawToDest = 0f;
    public float lastPitchToDest = 0f;
    private static final EntityDataAccessor<Integer> ANIMATION_STATE_SET = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DESTINATION_Z = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_Y = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_X = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(TheObliteratorCloneWithArmsEntity.class, EntityDataSerializers.BOOLEAN);
    public float activateProgress;
    public float prevactivateProgress;

    public final ControlledAnim RendercontrolledAnim = new ControlledAnim(15);

    public TheObliteratorCloneWithArmsEntity(EntityType<? extends TheObliteratorCloneWithArmsEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public TheObliteratorCloneWithArmsEntity(Level worldIn, double x, double y, double z, float yawRad, int p_i47276_9_, LivingEntity casterIn,
                                             float damage, float destX, float destY, float destZ, int animationState, int life) {
        this(ModEntities.THE_WARPED_ONE_DUPLICATE_ARMED.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        float yawDeg = yawRad * (180F / (float) Math.PI) - 90F;
        this.setYRot(yawDeg);
        this.setPos(x, y, z);
        setDestinationX(destX);
        setDestinationY(destY);
        setDestinationZ(destZ);
        setAnimationStateValue(animationState);
        setMaxUpStep(2);
        setDamage(damage);
        setLifeTicks(life);
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

    public void setDestinationX(float destination) {
        entityData.set(DESTINATION_X, destination);
    }

    public void setDestinationY(float destination) {
        entityData.set(DESTINATION_Y, destination);
    }

    public void setDestinationZ(float destination) {
        entityData.set(DESTINATION_Z, destination);
    }

    public int getAnimationStateValue() {
        return entityData.get(ANIMATION_STATE_SET);
    }

    public void setAnimationStateValue(int value) {
        entityData.set(ANIMATION_STATE_SET, value);
    }

    public void setLifeTicks(int amount) {
        entityData.set(LIFE, amount);
    }

    public int getLifeTicks() {
        return entityData.get(LIFE);
    }

    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.valueOf(false));

        this.entityData.define(DESTINATION_X, 0f);

        this.entityData.define(DESTINATION_Y, 0f);

        this.entityData.define(DESTINATION_Z, 0f);

        this.entityData.define(LIFE, 0);

        this.entityData.define(ANIMATION_STATE_SET, 0);
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

    public AnimationState leftHookComboAnimationState = new AnimationState();
    public AnimationState uppercutAnimationState = new AnimationState();

    public AnimationState rightUppercutAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "uppercut") {
            return this.uppercutAnimationState;
        } else if (input == "right_uppercut") {
            return this.rightUppercutAnimationState;
        } else if (input == "left_hook_combo") {
            return this.leftHookComboAnimationState;
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
                        this.uppercutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        stopAllAnimationStates();
                        this.leftHookComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        stopAllAnimationStates();
                        this.rightUppercutAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.uppercutAnimationState.stop();
        leftHookComboAnimationState.stop();
        rightUppercutAnimationState.stop();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public final ControlledAnim controlledAnim = new ControlledAnim(disappearTicks());

    @Override
    public int disappearTicks() {
        return 10;
    }

    public float shakeStrenght = 0.05f;
    public float attackArc = 270f;//290
    public int offsetDegrees;

    public float damage() {
        return 6;
    }

    public void tick() {

        super.tick();

        if (tickCount % 5 == 0) {
            for (int i = 0; i < 0.1; ++i) {
                if (level().isClientSide) {
                    double uniformScale = 0.5f;
                    this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getRandomX(uniformScale), this.getRandomY(), this.getRandomZ(uniformScale), 0D, 0.025D, 0D);
                }
            }
        }
        SoundEvent swingSound = ModSounds.HEAVY_SWING.get();
        SoundEvent impactSound = ModSounds.WEAPON_IMPACT.get();

        double dx = getDestinationX() - getX();
        double dy = getDestinationY() - getY();
        double dz = getDestinationZ() - getZ();

        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
        double stopDistance = 3.0;
        boolean shouldRotate = dist > stopDistance;
        if (shouldRotate) {
            Vec3 vec3 = new Vec3(getDestinationX(), getDestinationY(), getDestinationZ());
            lookAt(
                    EntityAnchorArgument.Anchor.EYES,
                    vec3

            );
        }
        if (getAnimationState() == 2) {

            // System.out.println("X " + getX());
            //System.out.println("Y " + getX());
            //System.out.println("Z " + getZ());
            if (AnimationTicks > 29) {
                controlledAnim.increaseTimer();
            }
            if (AnimationTicks >= 20) {
                RendercontrolledAnim.increaseTimer();
            }
            if (this.AnimationTicks >= 12 && AnimationTicks <= 14) {
                double dx1 = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy1 = getY() + 3F;
                double dz1 = getZ() + 1.5F * (random.nextFloat() - 0.5F);
                float ran = 0.4f;
                float r = 0 / 255F;
                float g = 195 / 255F + random.nextFloat() * ran;
                float b = 0 / 255F;
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 2.25f, this.getId())), dx1, dy1, dz1, 0, 0, 0);
                Vec3 toDest = new Vec3(
                        getDestinationX() - getX(),
                        getDestinationY() - getY(),
                        getDestinationZ() - getZ()
                );
                double distance = toDest.length();
                double distancetotarget = toDest.length() * 0.5f;
                double speed = 0.1 + distancetotarget;

                if (distance <= speed) {
                } else {
                    Vec3 motion = toDest.normalize().scale(speed);
                    this.move(MoverType.SELF, motion);
                }
            }

            if (AnimationTicks == 11) {

                playSound(swingSound, 1, 1);
            }
            if (AnimationTicks == 15) {
                if (target() != null) {
                    float destX = (float) target().getX();
                    float destY = (float) target().getY();
                    float destZ = (float) target().getZ();
                    setDestinationX(destX);
                    setDestinationY(destY);
                    setDestinationZ(destZ);
                }

                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, shakeStrenght, 0, 20);
                SoundEvent soundEvent = ModSounds.WEAPON_IMPACT.get();
                SideAreaAttack(4, 4, attackArc, -90, damage(), 120, false, true, soundEvent);
            }
            if (this.AnimationTicks >= 25) {
                double dx1 = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy1 = getY() + 3F;
                double dz1 = getZ() + 1.5F * (random.nextFloat() - 0.5F);
                float ran = 0.4f;
                float r = 0 / 255F;
                float g = 195 / 255F + random.nextFloat() * ran;
                float b = 0 / 255F;
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 2.25f, this.getId())), dx1, dy1, dz1, 0, 0, 0);
                // System.out.println("currentX=" + getX() + "  destX=" + getDestinationX());
                // System.out.println("currentY=" + getY() + "  destY=" + getDestinationY());
                // System.out.println("currentZ=" + getZ() + "  destZ=" + getDestinationZ());
                Vec3 toDest = new Vec3(
                        getDestinationX() - getX(),
                        getDestinationY() - getY(),
                        getDestinationZ() - getZ()
                );
                double distance = toDest.length();
                double distancetotarget = toDest.length() * 0.5f;
                double speed = 0.1 + distancetotarget;

                if (distance <= speed) {
                } else {
                    Vec3 motion = toDest.normalize().scale(speed);
                    this.move(MoverType.SELF, motion);
                }
            }
            if (AnimationTicks == 24) {
                playSound(swingSound, 1, 1);
            }
            if (AnimationTicks == 28) {

                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, shakeStrenght, 0, 20);
                SoundEvent soundEvent = ModSounds.WEAPON_IMPACT.get();
                SideAreaAttack(5, 4, attackArc, -90, damage(), 120, false, true, soundEvent);
            }
        }
        if (getAnimationState() == 1) {
            if (AnimationTicks > 23) {
                controlledAnim.increaseTimer();
            }
            if (AnimationTicks >= 10) {
                RendercontrolledAnim.increaseTimer();
            }
            if (this.AnimationTicks >= 15) {
                double dx1 = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy1 = getY() + 3F;
                double dz1 = getZ() + 1.5F * (random.nextFloat() - 0.5F);
                float ran = 0.4f;
                float r = 0 / 255F;
                float g = 195 / 255F + random.nextFloat() * ran;
                float b = 0 / 255F;
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 2.25f, this.getId())), dx1, dy1, dz1, 0, 0, 0);
                Vec3 toDest = new Vec3(
                        getDestinationX() - getX(),
                        getDestinationY() - getY(),
                        getDestinationZ() - getZ()
                );
                double distance = toDest.length();
                double distancetotarget = toDest.length() * 0.5f;
                double speed = 0.1 + distancetotarget;

                if (distance <= speed) {
                    this.setPos(getDestinationX(), getDestinationY(), getDestinationZ());
                } else {
                    Vec3 motion = toDest.normalize().scale(speed);
                    this.move(MoverType.SELF, motion);
                }
            }
            if (AnimationTicks == 14) {

                playSound(swingSound, 1, 1);
            }

            if (AnimationTicks == 18) {

                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, shakeStrenght, 0, 20);
                SoundEvent soundEvent = ModSounds.WEAPON_IMPACT.get();
                SideAreaAttack(5, 4, attackArc, 90, damage(), 120, false, true, soundEvent);
            }

        }
        if (getAnimationState() == 3) {
            if (AnimationTicks > 23) {
                controlledAnim.increaseTimer();
            }
            if (AnimationTicks >= 10) {
                RendercontrolledAnim.increaseTimer();
            }
            if (this.AnimationTicks >= 15) {
                double dx1 = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy1 = getY() + 3F;
                double dz1 = getZ() + 1.5F * (random.nextFloat() - 0.5F);
                float ran = 0.4f;
                float r = 0 / 255F;
                float g = 195 / 255F + random.nextFloat() * ran;
                float b = 0 / 255F;
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 2.25f, this.getId())), dx1, dy1, dz1, 0, 0, 0);
                Vec3 toDest = new Vec3(
                        getDestinationX() - getX(),
                        getDestinationY() - getY(),
                        getDestinationZ() - getZ()
                );
                double distance = toDest.length();
                double distancetotarget = toDest.length() * 0.5f;
                double speed = 0.1 + distancetotarget; // tweakuj wedle uznania

                if (distance <= speed) {
                    // jesteśmy blisko celu → snap
                    this.setPos(getDestinationX(), getDestinationY(), getDestinationZ());
                } else {
                    Vec3 motion = toDest.normalize().scale(speed);
                    this.move(MoverType.SELF, motion);
                }
            }
            if (AnimationTicks == 14) {

                playSound(swingSound, 1, 1);
            }

            if (AnimationTicks == 18) {

                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, shakeStrenght, 0, 20);
                SoundEvent soundEvent = ModSounds.WEAPON_IMPACT.get();
                SideAreaAttack(5, 4, attackArc, -90, damage(), 120, false, true, soundEvent);
            }

        }


//Unused but useful later


        this.prevactivateProgress = this.activateProgress;
        if (lifeTicks > 20 && lifeTicks < 32) {
        }
        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
            }
            if (this.warmupDelayTicks < -16 && this.warmupDelayTicks > -30) {
            }
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }
            //Anim 1 = 45
            //Anim 2 = 56
            if (++this.lifeTicks > getLifeTicks()) {
                this.discard();
            }
        }

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
    public void setAnimationState(int Animation) {
        AnimationTicks = 0;
        entityData.set(ANIMATIONSTATE, Animation);
        playSound(SoundEvents.ENDERMAN_TELEPORT, 3, 1);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + 3, getZ(), 1, 0, 0, 0, 0);
        }
        if (level().isClientSide)
            this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 25, 0, 1, 0, 1.0f, 14,
                    false, Circle.EnumRingBehavior.SHRINK), getX(), getY(), getZ(), 0, 0, 0);
        if (getAnimationState() == 0) {
            this.setAnimationState(getAnimationStateValue());

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

    public boolean canBeCollidedWith() {
        return false;
    }

    public void calculatedDash(float Multiplier) {
        Vec3 vec3 = new Vec3((getDestinationX() - this.getX()) * Multiplier, 0, (getDestinationZ() - this.getZ()) * Multiplier);
        this.setDeltaMovement((getDestinationX() - this.getX()) * Multiplier, 0, (getDestinationZ() - this.getZ()) * Multiplier);
        //  this.move(MoverType.SELF,);

    }

    public void SideAreaAttack(float range, float height, float arc, float boxOffset, float damage, int brokenShieldTicks, boolean canStun, boolean canlaunch, SoundEvent soundEvent) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);

            float entityAttackingAngle = (this.getYRot() - boxOffset) % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (getCaster() != null) {
                    if (!isAlliedTo(entityHit) && !(entityHit instanceof TheObliteratorEntity) && entityHit != this.getCaster()) {

                        boolean flag = entityHit.hurt(
                                ModDamageTypes.causeAnnihilationDamage(getCaster(), getCaster()), (float) (((damage + MathUtils.entityBasedHpDamage(entityHit, ModConfig.MOB_CONFIG.TheObliteratorCloneBurstHPDamage.get())))));
                        if (flag) {
                            TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, false);
                            if (canlaunch) {
                                launch(entityHit, true, 0f, 0.5f);
                            }
                            if (!canStun) {
                                playSound(soundEvent, 1, 0.5f);
                            }
                            if (canStun) {
                                playSound(SoundEvents.ANVIL_PLACE, 1, 1f);
                                entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 80, 1));
                            }

                        }
                        if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                            //    disableShield(entityHit, brokenShieldTicks);
                        }
                    }
                }
            }
        }
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player) livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }

    private void launch(LivingEntity entity, boolean huge, float launchMultiplier, float yPower) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? launchMultiplier : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? yPower : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double) this.distanceTo(e) <= r + (double) (e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }

}
