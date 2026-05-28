package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.BigAnnihilationSweepParticle;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.GiantAnnihilationSweepParticle;
import net.miauczel.legendary_monsters.Particle.custom.MovingTrailParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.goals.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationExplosionEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationFlameStrike;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SmallAnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AnnihilationPursuerEntity extends IAnimatedMiniBoss {
    public AnnihilationPursuerEntity(EntityType entity, Level world) {

        super(entity, world);
        xpReward = 15;
        this.setPersistenceRequired();
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    private static final EntityDataAccessor<Integer> IDLE_STATE = SynchedEntityData.defineId(AnnihilationPursuerEntity.class, EntityDataSerializers.INT);
    public final int TELEPORT_SLAM_COOLDOWN = 100;
    public final int SHIELD_STUN_COOLDOWN = 100;

    public final int STAB_FINISHER_COOLDOWN = 200;

    public final int BUCKSHOT_COOLDOWN = 40;//200
    public final int STOMP_COMBO_COOLDOWN = 100;
    public int stomp_combo_cooldown = 0;

    public int teleport_slam_cooldown = 0;
    public int shield_stun_cooldown = 0;

    public int stab_finisher_cooldown = 0;

    public int buckshot_cooldown = 0;

    @Override
    public void tick() {
        if (!level().isClientSide && isVehicle() && (getAttackState() != 14 && getAttackState() != 15 && getAttackState() != 19)) {
            ejectPassengers();
        }
        if (isVehicle()) {
            if (getFirstPassenger() != null) {
                getFirstPassenger().setShiftKeyDown(false);
            }
        }
        // System.out.println("Has Hit: " + hasHit + " GetAttackState: " + getAttackState());
        if (teleport_slam_cooldown > 0) teleport_slam_cooldown--;
        if (stomp_combo_cooldown > 0) stomp_combo_cooldown--;
        if (shield_stun_cooldown > 0) shield_stun_cooldown--;
        if (stab_finisher_cooldown > 0) stab_finisher_cooldown--;
        if (buckshot_cooldown > 0) buckshot_cooldown--;
        if (level().isClientSide) {
            if (isDuringTeleportation() && !isInvisible()) setInvisible(true);
            if (!isDuringTeleportation() && isInvisible()) setInvisible(false);
        }
        UpdateWithAttack();
        if (level().isClientSide) {
            idleAnimationState.animateWhen(getAttackState() == 0, this.tickCount);
        }

        super.tick();
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    public int getIdleState() {
        return entityData.get(IDLE_STATE);
    }

    public void setIdleState(int state) {
        entityData.set(IDLE_STATE, state);
    }

    public boolean isDuringTeleportation() {
        return (getAttackState() == 4 && attackTicks > 8 && attackTicks < 13) || (getAttackState() == 13 && attackTicks > 12 && attackTicks < 18)
                || (getAttackState() == 18 && attackTicks > 8 && attackTicks < 14) || (getAttackState() == 19 && attackTicks > 8 && attackTicks < 14) || (getAttackState() == 14 && attackTicks > 12 && attackTicks < 18)
                || (getAttackState() == 23 && attackTicks > 10 && attackTicks < MathUtils.toTicks(0.83f));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        /// BUCKSHOT
        this.goalSelector.addGoal(1, new BuckshotGoal(this, 0, 21, 0, MathUtils.toTicks(1.42f), MathUtils.toTicks(1.42f), 15) {
            @Override
            public void stop() {
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 32.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && buckshot_cooldown <=0;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 22, 22, 0, MathUtils.toTicks(1.08f), 10) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                buckshot_cooldown = BUCKSHOT_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 23, 23, 0, MathUtils.toTicks(1.33f), MathUtils.toTicks(1.33f)) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                buckshot_cooldown = BUCKSHOT_COOLDOWN;
                super.stop();
            }
        });
        ///TELEPORT SLAM
        this.goalSelector.addGoal(1, new SwordTeleportSlamGoal(this, 0, 13, 0, 70, 25, 13, 3) {
            @Override
            public void stop() {
                teleport_slam_cooldown = TELEPORT_SLAM_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && teleport_slam_cooldown <= 0 && !animationLockedForTests();
            }
        });
        /// TELEPORT CHASE
        this.goalSelector.addGoal(1, new TeleportChaseGoal(this, 0, 18, 0, 21, 25, 20, 6) {
            @Override
            public void stop() {
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 32.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && !animationLockedForTests();
            }
        });

        this.goalSelector.addGoal(0, new StabFinisherGrabStateGoal(this, 19, 19, 0, 38, 35) {
            public void start() {
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        /// SINGLE SLASH FROM
        this.goalSelector.addGoal(1, new SingleSlashFromGoal(this, 0, 8, 10, 29, 29, 7F) {
            @Override
            public void stop() {
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && !animationLockedForTests();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 9, 9, 0, 48, 25) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                shield_stun_cooldown = SHIELD_STUN_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 10, 10, 0, 19, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        /// SINGLE SLASH
        this.goalSelector.addGoal(1, new SingleSlashGoal(this, 0, 5, 12, 28, 28, 7F) {
            @Override
            public void stop() {
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && !animationLockedForTests();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 11, 11, 0, 37, 30) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 0, 21, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });

        /// GRAB STATES:
        //Single Slash
        this.goalSelector.addGoal(0, new StabFinisherGrabStateGoal(this, 14, 14, 0, 39, 30) {
            public void start() {
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        //Success
        this.goalSelector.addGoal(0, new IStateGoal(this, 15, 15, 0, 112, 0) {//112 without throw 72
            public void start() {
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {

                stab_finisher_cooldown = STAB_FINISHER_COOLDOWN;
                super.stop();
            }
        });
        //Fail
        this.goalSelector.addGoal(0, new IStateGoal(this, 16, 16, 0, 23, 0) {
            public void start() {
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                stab_finisher_cooldown = STAB_FINISHER_COOLDOWN;
                super.stop();
            }
        });
        ///STOMP COMBO
        this.goalSelector.addGoal(1, new StompComboGoal(this, 0, 2, 0, 46, 34, 7F) {
            @Override
            public void stop() {
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && AnnihilationPursuerEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && AnnihilationPursuerEntity.this.getTarget() != null && stomp_combo_cooldown <= 0;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 3, 3, 0, 22, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                stomp_combo_cooldown = STOMP_COMBO_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 4, 4, 0, 28, 0) {
            public void start() {
                super.start();

            }

            @Override
            public boolean canUse() {
                return super.canUse();
            }

            @Override
            public void stop() {
                stomp_combo_cooldown = STOMP_COMBO_COOLDOWN;
                super.stop();
            }
        });

        //Sleep & Awaken
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });

        this.goalSelector.addGoal(0, new IAttackGoal(this, 6, 7, 0, 30, 0, 10.0F));
        //Death
        this.goalSelector.addGoal(1, new IStateGoal(this, 17, 17, 0, 85, 0) {
        });
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 6 : 0);
    }

    @Override
    public int attackDelayTicksValue() {
        return 2;
    }

    public boolean isSleep() {
        return this.getAttackState() == 6 || this.getAttackState() == 7;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IDLE_STATE, 0);
    }

    @Override
    public void onAddedToWorld() {
        setPersistenceRequired();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.AnnihilationPursuerHealthMultiplier.get());
        super.onAddedToWorld();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {

        pCompound.putBoolean("is_Sleep", isSleep());
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        setSleep(compound.getBoolean("is_Sleep"));
        super.readAdditionalSaveData(compound);
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public void dismountTo(double pX, double pY, double pZ) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 3;
        float offset = 2;
        super.dismountTo((getX() + vec * vecX + f * offset), getY() + 5, (getZ() + vec * vecZ + f1 * offset));
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 2f;
        float offset = 1f;
        return new Vec3((getX() + vec * vecX + f * offset), getY() + 4, (getZ() + vec * vecZ + f1 * offset));
    }

    @Override
    protected void positionRider(Entity pPassenger, MoveFunction pCallback) {

        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 2.25f;
        float offset = 0.25f;
        if (hasPassenger(pPassenger)) {
            pCallback.accept(pPassenger, (getX() + vec * vecX + f * offset), getY() + 3, (getZ() + vec * vecZ + f1 * offset));
        }
    }

    public void UpdateWithAttack() {
        float sweepSize = 2f;
        float sweepRot = 20;
        float bigSweepHeight = 3;
        float bigSweepAdditionalY = 1;
        float dmgred = 1.5f;
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float slashRange = 5f;


        //Awaken
        if (getAttackState() == 7) {
            if (attackTicks == 1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.075F, 0, 20);
            }
        }
        //Stomp Combo
        if (getAttackState() == 2) {
            for (int i = 20; i <= 26; i = i + 2) {
                if (attackTicks == i) {
                    int d = i - 18;
                    flameRadagonShockwave(0.20f, d, 1, 2, 0, -1.5f, 6);
                }
            }
            // if (attackTicks == 17)basicDash(0.5f,0.5f,2,true);
            if (attackTicks == 20) {
                if (level().isClientSide) {
                    spawnCircleParticle(1.5f, -1, 30, true, 1, 0, 1, 0, 1, Circle.EnumRingBehavior.GROW, 35);
                }
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 0, 10);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 1, 1);
                SideAreaAttack(3.5f, 3, 180, -90, 0, 18, 70, false, false, SoundEvents.EMPTY, 1f);
            }
            if (attackTicks == 25)
                calculatedDash(0.15f);

            if (attackTicks == 33) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
            }

            if (attackTicks == 28) {
                createSweep(2, -1, 3, 0.4f, true, 1.25f, sweepRot, true);
                playSound(ModSounds.HEAVY_SWING.get(), 2, 1.25f);
                SideAreaAttack(4, 4, 180, 0, 0, 18 - dmgred, 100, false, false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == 36) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.1F, 0, 20);
                playSound(ModSounds.HEAVY_SWING.get(), 2, 0.8f);
                SideAreaAttack(5, 5, 220, -90, 0, 18, 120, false, false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
        }
        //Teleport End
        if (getAttackState() == 4) {
            if (attackTicks == 8) {
                float vec = -4;
                float offset = 0;
                teleport((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));
            }
        }
        //Single Slash
        if (getAttackState() == 5) {
            if (attackTicks == 23) {

                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                calculatedDash(0.20f);
                playSound(ModSounds.HEAVY_SWING.get(), 2, 0.8f);
            }
            if (attackTicks == 26) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.1F, 0, 20);
                nextSideAreaAttack(slashRange, 5, 220, 0, 18 - dmgred, 120, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
                //SideAreaAttack(5.25f,5,220,0,0,20,120,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
            }
        }
        if (getAttackState() == 11) {
            if (attackTicks == 10) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.20f);
                playSound(ModSounds.HEAVY_SWING.get(), 2, 0.8f);
            }
            if (attackTicks == 13) {
                SideAreaAttack(slashRange, 5, 220, 0, 0, 18 - dmgred, 120, false, false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
        }
        //Single Slash From
        if (getAttackState() == 8) {
            if (attackTicks == 23) {

                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.20f);
                playSound(ModSounds.HEAVY_SWING.get(), 2, 0.8f);
            }
            if (attackTicks == 26) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.1F, 0, 20);
                nextSideAreaAttack(slashRange, 5, 220, 0, 18 - dmgred, 120, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
                // SideAreaAttack(5,5,220,0,0,20,120,false,false, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR,0.75f);
            }
        }
        //Single Slash Double
        if (getAttackState() == 9) {
            if (attackTicks == 22) {
                calculatedDash(0.35f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 2, 1f);
            }
            if (attackTicks == 25) {
                SideAreaAttack(4.25f, 5, 210, 90, 0, 18 - dmgred, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1f);
            }
        }
        //Sword Teleport Slam
        if (getAttackState() == 13) {
            if (attackTicks == 13) {
                //   System.out.println("ExecutingTeleport: ");
                teleport(lastX, lastY, lastZ);
            }
            if (attackTicks == 10) {
                if (targetIsNotNull()) {

                    float f2 = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f3 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta1 = (yBodyRot) * (Math.PI / 180);
                    theta1 += Math.PI / 2;
                    double vecX1 = Math.cos(theta1);
                    double vecZ1 = Math.sin(theta1);

                    float vec = 3;
                    float offset = 0;
                    saveTeleportPositions((target().getX() + vec * vecX1 + f2 * offset), getY(), (target().getZ() + vec * vecZ1 + f3 * offset));
                }
            }
            /*if (attackTicks == 13) {
                if (targetIsNotNull()) {
                    //double distanceToTarget = distanceTo(target()) * 0.75f;
                    //Vec3 vec3 = new Vec3(getX() - distanceToTarget, target().getY(), getZ() - distanceToTarget);
                    teleport(lastX, lastY, lastZ);
                }

            }*/
            if (attackTicks == 30) {
                double vec = 1.5;
                double d0 = this.getX();
                double d1 = this.getY() + this.getBbHeight() / 2 + 0.3;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);

                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    this.level().addParticle(new GiantAnnihilationSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.HEAVY_SWING.get(), 2, 0.8f);
            }
            if (attackTicks == 33) {
                StraightLineAreaAttack(-0.5f, 2f, 5.5f, 120, 17, true);
                playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                spawnExplosions(8, 2, 2, 3, 0);
            }
        }
//Teleport Chase
        if (getAttackState() == 18) {
            if (attackTicks == 3) {
                if (targetIsNotNull()) {
                    Vec3 distance = new Vec3(target().position().x + position().x, target().getY(), target().position().z + position().z).scale(0.5);
                    saveTeleportPositions(distance.x, target().getY(), distance.z);
                }
            }
            if (attackTicks == 8) {
                teleport(lastX, lastY, lastZ);
            }
        }

        //Grab Prepare
        if (getAttackState() == 14) {
            if (attackTicks == 13) {
                if (targetIsNotNull()) {
                    float ft = Mth.cos(this.target().yHeadRot * ((float) Math.PI / 180F));
                    float f1t = Mth.sin(target().yHeadRot * ((float) Math.PI / 180F));
                    double thetat = (target().yHeadRot) * (Math.PI / 180);
                    thetat += Math.PI / 2;
                    double vecXt = Math.cos(thetat);
                    double vecZt = Math.sin(thetat);
                    float vec = 5;
                    float offset = 3f;
                    teleport((target().getX() + vec * vecXt + ft * offset), target().getY(), (target().getZ() + vec * vecZt + f1t * offset));
                }
            }
            if (attackTicks == 36) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 39) {
                SideGrab(4.5f, 4, 225, 90, 5, 100, SoundEvents.PLAYER_ATTACK_SWEEP, 0.8f);
            }
        }
        //Chase Pre Variant
        if (getAttackState() == 19) {
            if (attackTicks == 8) {
                if (targetIsNotNull()) {
                    float ft = Mth.cos(this.target().yHeadRot * ((float) Math.PI / 180F));
                    float f1t = Mth.sin(target().yHeadRot * ((float) Math.PI / 180F));
                    double thetat = (target().yHeadRot) * (Math.PI / 180);
                    thetat += Math.PI / 2;
                    double vecXt = Math.cos(thetat);
                    double vecZt = Math.sin(thetat);
                    float vec = 4;
                    float offset = 0f;
                    teleport((target().getX() + vec * vecXt + ft * offset), target().getY(), (target().getZ() + vec * vecZt + f1t * offset));
                }
            }
            if (attackTicks == 35) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 38) {
                SideGrab(4.5f, 4, 225, 90, 5, 100, SoundEvents.PLAYER_ATTACK_SWEEP, 0.8f);
            }
        }
        if (getAttackState() == 15) {
            if (attackTicks == 17) {
                playSound(ModSounds.HEAVY_STAB.get());
            }

            if (attackTicks == 21 || attackTicks == 45) {
                if (this.isVehicle()) {
                    if (getFirstPassenger() != null)
                        getFirstPassenger().hurt(ModDamageTypes.causeAnnihilationDamage(this, this), 8);
                }
            }

            //Particles
            if (attackTicks == 21) {
                float vec = 2.5f;
                float offset = 1.5f;
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), getY() + 5, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }

            }
            if (attackTicks == 45) {
                float vec = 2.75f;
                float offset = -1f;
                playSound(ModSounds.STAB_HIT.get());
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), getY() + 4, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }

            }
            if (attackTicks == 82) playSound(ModSounds.GENERIC_ARM_SWING.get(), 2, 1);

            if (attackTicks == 84) {
                float destVec = 15;
                float destoffset = 0;

                float vec = 2.25f;
                float offset = 0.25f;
                if (getFirstPassenger() instanceof LivingEntity livingEntity) {
                    // System.out.println("Activating...");
                    if (getFirstPassenger() != null) {
                        //     System.out.println("Active, Not null");
                        if (!level().isClientSide) {
                            throwAnGravityEntity(1, (getX() + destVec * vecX + f * destoffset), getY() + 2f, (getZ() + destVec * vecZ + f1 * destoffset),
                                    (getX() + vec * vecX + f * offset), getY() + 3, (getZ() + vec * vecZ + f1 * offset), 1, livingEntity);
                        }
                       /*throwAnEntity((getX() + destVec * vecX + f * destoffset), getY() + 1.5f, (getZ() + destVec * vecZ + f1 * destoffset),
                              (getX() + vec * vecX + f * offset), getY() + 2.5, (getZ() + vec * vecZ + f1 * offset),
                              5, 1.2f, livingEntity);*/

                    }
                }
            }
        }
        if (getAttackState() == 21) {

            float y = (float) (getY() + 3);
            if (attackTicks == 17) {
                for (int k = 0; k < 3; k++) {
                    float d1 = Mth.sqrt(k);
                    float ran = 0.4f;
                    float r = 0 / 255F;
                    float g = 195 / 255F + random.nextFloat() * ran;
                    float b = 0 / 255F;
                    float vec = 2;
                    float offset = -0.5f;
                    if (level().isClientSide) {
                        this.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.1f, 0.1f),
                                (getX() + vec * vecX + f * offset), y, (getZ() + vec * vecZ + f1 * offset), Mth.sin(k), 0, d1 * 0.01f);
                    }
                }
            }
            if (attackTicks == 18) {
                playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), 1, 1);
                float vec = 0;
                float vec2 = 2;
                float offset = 0;
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (float) (getX() + vec2 * vecX + f * offset), y, (float) (getZ() + vec2 * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 15);
                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 0);
                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 30);
            }

        }
        if (getAttackState() == 23) {
            if (targetIsNotNull()) {
                if (attackTicks == 10) teleportRandomly(this.target(), 7, 10);
            }
        }

    }

    public double lastX;
    public double lastY;
    public double lastZ;

    public void saveTeleportPositions(double x, double y, double z) {
        lastX = x;
        lastY = y;
        lastZ = z;

    }

    public void shootAnnihilationBomb(float velocity, float x, float y, float z, int inaccuracy) {
        if (targetIsNotNull()) {

            SmallAnnihilationBombEntity chorusBomb = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), this.level(), this, 8); // Ustaw BigCannonEntity jako właściciela

            chorusBomb.setPosRaw(x, y, z);

            double d0 = target().getX() - x;

            double d4 = (target().getY() - y) * 0.5f;
            double d1 = target().getBoundingBox().minY + target().getBbHeight() / 2 - chorusBomb.getY();
            double d2 = target().getZ() - z;
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            //chorusBomb.shoot(d0, d1, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);
            chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, velocity, inaccuracy - this.level().getDifficulty().getId() * 4);


            chorusBomb.setOwner(this);
            //chorusBomb.setPos(x, y, z);
            this.level().addFreshEntity(chorusBomb);
        }

    }

    public void createSweep(float pos, float posOffset, float yHeight, double additionalY, boolean reverse, float scale, float rot, boolean small) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = pos;
        float offset = posOffset;
        double x = (getX() + vec * vecX + f * offset);
        double z = (getZ() + vec * vecZ + f1 * offset);
        if (this.level().isClientSide) {
            double d0 = x;
            double d1 = this.getY() + this.getBbHeight() / 2 + additionalY;
            double d2 = z;
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? rot : 180));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
            if (small) {
                this.level().addParticle(new BigAnnihilationSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);
            } else {

                this.level().addParticle(new GiantAnnihilationSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 210)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 13D)

                .add(Attributes.ARMOR_TOUGHNESS, 4)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }
    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {

        if (pSource.is(DamageTypes.FALL)) return
                false;
        if (pSource.is(DamageTypeTags.IS_PROJECTILE) && !isSleep()) {
            playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
            teleportRandomly(10);
            return false;
        } else if (isDuringTeleportation() && !pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || isSleep())
            return false;
        return super.hurt(pSource, pAmount);
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState idle2AnimationState = new AnimationState();

    public AnimationState idle1to2AnimationState = new AnimationState();

    public AnimationState stompComboAnimationState = new AnimationState();

    public AnimationState stompComboEndAnimationState = new AnimationState();
    public AnimationState stompComboTeleportEndAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState singleSlashAnimationState = new AnimationState();

    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakenAnimationState = new AnimationState();


    public AnimationState singleSlashFromAnimationState = new AnimationState();
    public AnimationState singleSlashFromParryAnimationState = new AnimationState();
    public AnimationState singleSlashFromFailAnimationState = new AnimationState();


    public AnimationState singleSlashCutAnimationState = new AnimationState();
    public AnimationState singleSlashDoubleAnimationState = new AnimationState();
    public AnimationState singleSlashFailAnimationState = new AnimationState();

    public AnimationState grabPreAnimationState = new AnimationState();
    public AnimationState grabSuccessAnimationState = new AnimationState();
    public AnimationState grabFailAnimationState = new AnimationState();

    public AnimationState teleportChaseAnimationState = new AnimationState();

    public AnimationState teleportSlamAnimationState = new AnimationState();

    public AnimationState teleportChaseNextAnimationState = new AnimationState();

    public AnimationState buckshotAnimationState = new AnimationState();
    public AnimationState buckshotEndAnimationState = new AnimationState();
    public AnimationState buckshotTPAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "idle2") {
            return this.idle2AnimationState;
        }
        if (input == "idle1to2") {
            return this.idle1to2AnimationState;
        } else if (input == "stomp_combo") {
            return this.stompComboAnimationState;
        } else if (input == "stomp_combo_end") {
            return this.stompComboEndAnimationState;
        } else if (input == "stomp_combo_teleport_end") {
            return this.stompComboTeleportEndAnimationState;
        } else if (input == "single_slash") {
            return this.singleSlashCutAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awaken") {
            return this.awakenAnimationState;
        } else if (input == "single_slash_from") {
            return this.singleSlashFromAnimationState;
        } else if (input == "single_slash_from_parry") {
            return this.singleSlashFromParryAnimationState;
        } else if (input == "single_slash_from_fail") {
            return this.singleSlashFromFailAnimationState;
        } else if (input == "single_slash_double") {
            return this.singleSlashDoubleAnimationState;
        } else if (input == "single_slash_fail") {
            return this.singleSlashFailAnimationState;
        } else if (input == "teleport_slam") {
            return this.teleportSlamAnimationState;
        } else if (input == "grab_pre") {
            return this.grabPreAnimationState;
        } else if (input == "grab_success") {
            return this.grabSuccessAnimationState;
        } else if (input == "grab_fail") {
            return this.grabFailAnimationState;
        } else if (input == "teleport_chase") {
            return this.teleportChaseAnimationState;
        } else if (input == "teleport_chase_next") {
            return this.teleportChaseNextAnimationState;
        } else if (input == "buckshot") {
            return this.buckshotAnimationState;
        } else if (input == "buckshot_end") {
            return this.buckshotEndAnimationState;
        } else if (input == "buckshot_tp") {
            return this.buckshotTPAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.stompComboAnimationState.startIfStopped(this.tickCount);
                    }

                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.stompComboEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.stompComboTeleportEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashCutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.awakenAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashFromAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashFromParryAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashFromFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashDoubleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.singleSlashFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.teleportSlamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.grabPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.grabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.grabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.teleportChaseAnimationState.startIfStopped(this.tickCount);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.teleportChaseNextAnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.idle1to2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.buckshotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.buckshotEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.buckshotTPAnimationState.startIfStopped(this.tickCount);
                    }


                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.stompComboAnimationState.stop();
        this.deathAnimationState.stop();
        stompComboEndAnimationState.stop();
        stompComboTeleportEndAnimationState.stop();
        singleSlashAnimationState.stop();
        sleepAnimationState.stop();
        awakenAnimationState.stop();
        singleSlashFromAnimationState.stop();
        singleSlashFromFailAnimationState.stop();
        singleSlashFromParryAnimationState.stop();
        singleSlashFailAnimationState.stop();
        singleSlashCutAnimationState.stop();
        singleSlashDoubleAnimationState.stop();
        teleportSlamAnimationState.stop();
        grabSuccessAnimationState.stop();
        grabFailAnimationState.stop();
        grabPreAnimationState.stop();
        teleportChaseAnimationState.stop();
        teleportChaseNextAnimationState.stop();
        idle1to2AnimationState.stop();
        idle2AnimationState.stop();
        buckshotAnimationState.stop();
        buckshotTPAnimationState.stop();
        buckshotEndAnimationState.stop();
    }

    public void throwAnEntity(double destX, double destY, double destZ, double x, double y, double z, float damage, float interia, LivingEntity passenger) {
        if (getTarget() != null) {
            double d3 = destX - x;
            double d4 = destY - y;
            double d5 = destZ - z;
            EntityThrownEntity bigShulkerBulletEntity = new EntityThrownEntity(this.level(), this, d3, d4, d5, damage, interia, passenger);
            bigShulkerBulletEntity.setOwner(this);
            bigShulkerBulletEntity.setPosRaw(x, y, z);
            this.level().addFreshEntity(bigShulkerBulletEntity);
        }
    }

    public void throwAnGravityEntity(float velocity, double destX, double destY, double destZ, double x, double y, double z, float damage, LivingEntity passenger) {
        if (passenger != null) {
            EntityThrownEntity thrownEntity = new EntityThrownEntity(this.level(), this, x, y, z, damage, 1, passenger);

            thrownEntity.setPosRaw(x, y, z);

            double d0 = destX - x;
            double d1 = destY + 0.5f - thrownEntity.getY();
            double d2 = destZ - z;
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            double d4 = (destX - y) * 0.5f;
            thrownEntity.shoot(d0, d1 + d3 * 0.2, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);

            thrownEntity.setOwner(this);
            this.level().addFreshEntity(thrownEntity);
        }
    }

    public void spawnExplosions(float damage, int bulletamount, double amount, double range, int tickDelay) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float offset = 0;
        double endPosX = (getX() + range * vecX + f * offset);
        double endPosZ = (getZ() + range * vecZ + f1 * offset);
        double d3 = Mth.floor(getY());
        double d0 = Math.min(getY(), this.getY());
        double d1 = Math.max(getY(), this.getY()) + 1.0D;
        float f2 = (float) Mth.atan2(endPosZ - this.getZ(), endPosX - this.getX());
        for (int l = 0; l < amount; ++l) {
            double d2 = 4D * (double) (l + 1);
            int j = 1 * l;
            this.spawnEnergyExplosions(this.getX() + (double) Mth.cos(f2) * d2, this.getZ() + (double) Mth.sin(f2) * d2, d3, d1, f2, tickDelay, damage, bulletamount);


        }
    }

    public boolean animationLockedForTests() {
        return false;
    }

    public void teleportRandomly(LivingEntity entity, float range, float iteractions) {

        Vec3 entityPos = entity.position();
        double x, y, z;
        Level level = this.level();

        for (int i = 0; i < iteractions; i++) {
            x = entityPos.x() + (this.getRandom().nextDouble() - 0.5) * range;
            z = entityPos.z() + (this.getRandom().nextDouble() - 0.5) * range;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1, iz)).isAir()) {
                this.teleport(x, y, z);
                return;
            }
        }
    }

    private void spawnEnergyExplosions(double x, double z, double minY, double maxY, float rotation, int delay, float damage, int bulletamount) {

        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);

            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {

            this.level().addFreshEntity(new AnnihilationExplosionEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, 20, damage, bulletamount));


        }
    }

    public boolean getHasHit() {
        return hasHit;
    }

    public boolean hasHit = false;

    public void SideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            int brokenShieldTicks,
            boolean canStun,
            boolean canlaunch,
            SoundEvent soundEvent,
            float pitch
    ) {
        double theta = Math.toRadians(this.yBodyRot) + Math.PI / 2;
        double forwardX = Math.cos(theta) * forwardOffset;
        double forwardZ = Math.sin(theta) * forwardOffset;

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            double dx = entityHit.getX() - (this.getX() + forwardX);
            double dz = entityHit.getZ() - (this.getZ() + forwardZ);

            float entityHitAngle = (float) ((Math.toDegrees(Math.atan2(dz, dx)) - 90) % 360);
            if (entityHitAngle < 0) entityHitAngle += 360;

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityAttackingAngle < 0) entityAttackingAngle += 360;

            float entityHitDistance = (float) Math.sqrt(dx * dx + dz * dz);

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            if (entityHitDistance <= range
                    && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2
                    || entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof AnnihilationPursuerEntity) && entityHit != this) {

                    boolean flag = entityHit.hurt(getAttackState() == 15 ? ModDamageTypes.causeAnnihilationDamage(this, this)
                            : this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.AnnihilationPursuerDamageMutliplier.get())));

                    if (flag) {
                        EntityUtil.cancelBuffs(entityHit);
                        entityHit.invulnerableTime = 0;
                        hasHit = true;
                        if (canlaunch) {
                            if (getAttackState() == 8) {
                                launch(entityHit, true);
                            } else {
                                launch(entityHit, true);
                            }
                        } else {
                        }

                        playSound(soundEvent, 1, pitch);
                        if (canStun) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 40, 1));
                        }

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.AnnihilationPursuerDamageMutliplier.get())));
                if (flag && launch) {
                    EntityUtil.cancelBuffs(entityHit);
//launch(entityHit,true,2,0.3f);
                    launch(entityHit, true);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    private void flameRadagonShockwave(float spreadarc, int distance, float vec, int delay, float pos, float offset, float damage) {
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta1 = (yBodyRot) * (Math.PI / 180);
        theta1 += Math.PI / 2;
        double vecX = Math.cos(theta1);
        double vecZ = Math.sin(theta1);
        int floor = Mth.floor(getY());
        double x = (getX() + pos * vecX + f * offset);
        double z = (getZ() + pos * vecZ + f1 * offset);
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = x + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = z + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnFlames(hitX + 0.5D, hitZ + 0.5D, this.getY() - 5, this.getY() + 3, (float) theta, delay, damage);
        }
    }

    private void spawnFlames(double x, double z, double minY, double maxY, float rotation, int delay, float damage) {

        BlockPos blockpos = new BlockPos((int) x, (int) maxY, (int) z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);

            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this;
            this.level().addFreshEntity(new AnnihilationFlameStrike(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, 20, damage));
        }
    }

    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + this.getBbHeight() / 2, getZ(), 1, 0, 0, 0, 0);
        }

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {

            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.teleportBoolean(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
                    this.playSound(SoundEvents.SHULKER_TELEPORT, 4.0F, 1.0F);
                }
            }

            return flag2;

        } else {
            return false;
        }

    }

    public boolean teleportBoolean(double x, double y, double z, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = y;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(x, y, z);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }


            if (flag1) {
                this.teleportTo(x, d3, z);
                EntityUtil.applyServerTeleport(this);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {

            this.teleportTo(d0, d1, d2);
            EntityUtil.applyServerTeleport(this);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte) 46);
            }
            this.getNavigation().stop();

            return true;
        }
    }

    private void teleportRandomly(double area) {
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + this.getBbHeight() / 2, getZ(), 1, 0, 0, 0, 0);
        }
        Vec3 entityPos = this.position();
        double x, y, z;
        Level level = this.level();

        for (int i = 0; i < 10; i++) {
            x = entityPos.x() + (this.getRandom().nextDouble() - 0.5) * area;
            z = entityPos.z() + (this.getRandom().nextDouble() - 0.5) * area;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1, iz)).isAir()) {
                this.teleportTo(x, y, z);
                return;
            }
        }
    }

    @Override
    public double damageCap() {
        return 21;
    }

    @Override
    public float damageReduction() {
        return 1;
    }

    public void nextSideAreaAttack(float range, float height, float arc, float boxOffset, float damage, int brokenShieldTicks, SoundEvent soundEvent, float pitch) {
        if (this.level().isClientSide) return;

        boolean hitAny = false;
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof AnnihilationPursuerEntity) && entityHit != this) {
                    hitAny = true;
                    boolean entityHitisTarget = entityHit == target();
                    // boolean mounted = entityHitisTarget && entityHit.startRiding(this, true);
                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.AnnihilationPursuerDamageMutliplier.get())));
                    if (flag) {
                        entityHit.setShiftKeyDown(false);
                        playSound(soundEvent, 1, pitch);
                        hasHit = true;
                        //System.out.println( "Changed hasHit to: " + hasHit);
                    } else {
                        hasHit = false;
                        //System.out.println( "Changed hasHit to: " + hasHit);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
        if (!hitAny) {
            hasHit = false;
        }
    }

    public boolean succedGrabbing = false;

    public void SideGrab(float range, float height, float arc, float boxOffset, float damage, int brokenShieldTicks, SoundEvent soundEvent, float pitch) {
        if (this.level().isClientSide) return;

        boolean hitAny = false;
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof AnnihilationPursuerEntity) && entityHit != this) {
                    hitAny = true;
                    boolean entityHitisTarget = entityHit == target();
                    DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
                    //   boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
                    if (entityHit.isDamageSourceBlocked(damageSource)) {
                        succedGrabbing = false;
                        //  return;
                    }
                    ;
                    boolean flag = entityHit.hurt(damageSource, (float) ((damage * ModConfig.MOB_CONFIG.AnnihilationPursuerDamageMutliplier.get())));

                    if (flag) {
                        playSound(soundEvent, 1, pitch);
                        boolean mounted = entityHitisTarget && entityHit.startRiding(this, true);
                        if (mounted) {
                            entityHit.setShiftKeyDown(false);


                            succedGrabbing = true;
                        } else {
                            succedGrabbing = false;
                        }
                    } else {
                        succedGrabbing = false;
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
        if (!hitAny) {
            succedGrabbing = false;
        }
    }

    @Override
    public void die(DamageSource pDamageSource) {
        deathTime = 0;
        stopAllAnimationStates();
        setAttackState(17);
        super.die(pDamageSource);
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 85) {
            if (target() instanceof Player player) sendBasicHotBarMessage("' ... '", player);
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
