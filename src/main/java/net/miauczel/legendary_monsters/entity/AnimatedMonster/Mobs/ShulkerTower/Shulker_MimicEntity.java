package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.goals.FireworkGrabGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.BigShulkerBulletEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.GravityBigShulkerEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LMFallingBlockEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;

import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Shulker_MimicEntity extends IAnimatedMiniBoss {

    private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(TheObliteratorEntity.class, EntityDataSerializers.INT);

    public Shulker_MimicEntity(EntityType<? extends IAnimatedMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 20;
        setMaxUpStep(1.5f);
        this.head = new ShulkerMimicPart(this, "head", 0.7F, 0.7F);
        this.entityParts = new ShulkerMimicPart[]{this.head};
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();
        }

    }


    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    public final int DOUBLE_SLASH_COOLDOWN = 40;
    public final int FIREWORK_GRAB_COOLDOWN = 100;
    public final int BIG_SHOOT_COOLDOWN = 60;
    public final int REPEL_SLAM_COOLDOWN = 60;
    public final int SHOOT_COOLDOWN = 30;

    public final int BACKSTEP_COOLDOWN = 80;
    public int shoot_cooldown = SHOOT_COOLDOWN;

    public int doubleSlashCooldown = DOUBLE_SLASH_COOLDOWN;
    public int bigShootCooldown = BIG_SHOOT_COOLDOWN;

    public int firework_grab_cooldown = FIREWORK_GRAB_COOLDOWN;
    public int repel_slam_cooldown = REPEL_SLAM_COOLDOWN;

    public int backstep_cooldown = BACKSTEP_COOLDOWN;
    private final ShulkerMimicPart[] entityParts;
    public final ShulkerMimicPart head;

    public ShulkerMimicPart[] getEntityParts() {
        return this.entityParts;
    }

    @Override
    public PartEntity<?>[] getParts() {
        return this.entityParts;
    }

    @Override
    public void setId(int pId) {
        super.setId(pId);
        for (int i = 0; i < this.entityParts.length; i++)
            this.entityParts[i].setId(pId + i + 1);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
        if (true) return;
        ShulkerMimicPart[] aObliteratorParts = this.getEntityParts();

        for (int i = 0; i < aObliteratorParts.length; ++i) {
            aObliteratorParts[i].setId(i + pPacket.getId());
        }

    }

    public float damageNerf() {
        return 5;
    }

    public float partXRot = 0;

    public void setPartXRot(float partXRot) {
        this.partXRot = partXRot;
    }

    public float getPartXRot() {
        return partXRot;
    }

    public float partYRot = 0;

    public void setPartYRot(float partYRot) {
        this.partYRot = partYRot;
    }

    public float getPartYRot() {
        return partYRot;
    }

    private void tickPart(ShulkerMimicPart pPart, double pOffsetX, double pOffsetY, double pOffsetZ) {
        pPart.setPos(this.getX() + pOffsetX, this.getY() + pOffsetY, this.getZ() + pOffsetZ);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    public Crackiness getCrackiness() {
        return Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public boolean isMediumCrackiness() {
        return getCrackiness() == Crackiness.MEDIUM;
    }

    public boolean isHighCrackiness() {
        return getCrackiness() == Crackiness.HIGH;
    }

    public boolean isLowCrackiness() {
        return getCrackiness() == Crackiness.LOW;
    }

    public boolean isNoneCrackiness() {
        return getCrackiness() == Crackiness.NONE;
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Crackiness byFraction(float pFraction) {
            for (Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }

    @Override
    public void tick() {
        if (level().isClientSide) {
            // this.level().addParticle((new TestTrail.TrailData(1, 0, 0, 0.5F, 0.8f, this.getId())), getX(), getY(), getZ(), 0, 0, 0);
        }
        ;
        if (this.isVehicle()) {
            if (getFirstPassenger() instanceof Player player) {
                player.setShiftKeyDown(false);
            }
        }
        if (this.isVehicle() && !(getAttackState() == 14 || getAttackState() == 16)) {
            ejectPassengers();
        }
        if (isMediumCrackiness() && getPhase() != 2) {
            setPhase(2);
            playSound(SoundEvents.SHULKER_HURT, 1, 1);
            // Sphereparticle(ParticleTypes.CLOUD, 0.35f, 2.0f, 3);
        }

        if (isHighCrackiness() && getPhase() != 3) {
            setPhase(3);
            playSound(SoundEvents.SHULKER_HURT, 1, 1);
            // Sphereparticle(ParticleTypes.CLOUD, 0.35f, 2.0f, 3);
        }

        // System.out.println("GetPhase: " + getPhase());
        //Part Entity Position
        float partBodyYaw = getPartYRot() * Mth.DEG_TO_RAD;
        float partBodyRotYaw = yBodyRot - getPartYRot() * Mth.DEG_TO_RAD;
        float partBodyPitch = 1f + getPartXRot() * Mth.DEG_TO_RAD;

        float f = Mth.cos(partBodyRotYaw * ((float) Math.PI / 180F));
        float f1 = Mth.sin(partBodyRotYaw * ((float) Math.PI / 180F));
        double theta = (partBodyRotYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float y = 1.5f;
        float vec = Mth.clamp(y - partBodyPitch, 1, y);
        float offset = Mth.sin(partBodyYaw) * 2;

        this.tickPart(this.head, vec * vecX + f * offset, partBodyPitch, vec * vecZ + f1 * offset);

        Vec3[] avec3 = new Vec3[this.entityParts.length];
        for (int j = 0; j < this.entityParts.length; ++j) {
            avec3[j] = new Vec3(this.entityParts[j].getX(), this.entityParts[j].getY(), this.entityParts[j].getZ());
        }
        for (int l = 0; l < this.entityParts.length; ++l) {
            this.entityParts[l].xo = avec3[l].x;
            this.entityParts[l].yo = avec3[l].y;
            this.entityParts[l].zo = avec3[l].z;
            this.entityParts[l].xOld = avec3[l].x;
            this.entityParts[l].yOld = avec3[l].y;
            this.entityParts[l].zOld = avec3[l].z;
        }


        //Cooldowns
        if (shoot_cooldown > 0) {
            shoot_cooldown--;
        }

        if (backstep_cooldown > 0) {
            backstep_cooldown--;
        }
        if (repel_slam_cooldown > 0) repel_slam_cooldown--;
        if (bigShootCooldown > 0) bigShootCooldown--;
        if (firework_grab_cooldown > 0) firework_grab_cooldown--;
        if (doubleSlashCooldown > 0) doubleSlashCooldown--;

//Animation
        if (level().isClientSide) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, tickCount);
        }

        super.tick();
    }


    public int getPhase() {
        return entityData.get(PHASE);
    }

    public void setPhase(int phase) {
        entityData.set(PHASE, phase);
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(PHASE, 1);
        super.defineSynchedData();
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {

        pCompound.putBoolean("is_Sleep", isSleep());
        pCompound.putInt("phase", getPhase());
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        setPhase(compound.getInt("phase"));
        setSleep(compound.getBoolean("is_Sleep"));
        super.readAdditionalSaveData(compound);
    }

    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 51, 25, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && getNextRandomBackstep() == 2 && !animationLockedForTests() && backstep_cooldown <= 0;

            }

            @Override
            public void stop() {

                backstep_cooldown = BACKSTEP_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 17, 25, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && getNextRandomBackstep() == 1 && !animationLockedForTests() && backstep_cooldown <= 0;

            }

            @Override
            public void stop() {
                backstep_cooldown = BACKSTEP_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 48, 42, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && shoot_cooldown <= 0 && getNextRandomShootType() == 1 && !animationLockedForTests();

            }

            @Override
            public void stop() {
                shoot_cooldown = SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 48, 39, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && shoot_cooldown <= 0 && getNextRandomShootType() == 3 && !animationLockedForTests();

            }

            @Override
            public void stop() {
                shoot_cooldown = SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 9, 0, 67, 60, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && shoot_cooldown <= 0 && getNextRandomShootType() == 2 && !animationLockedForTests();

            }

            public void tick() {
                if (attackTicks == 33) {

                }

                super.tick();
            }

            @Override
            public void stop() {
                shoot_cooldown = SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 10, 0, 67, 60, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && shoot_cooldown <= 0 && getNextRandomShootType() == 3 && !animationLockedForTests();

            }

            public void tick() {
                if (attackTicks == 33) {

                }

                super.tick();
            }

            @Override
            public void stop() {
                shoot_cooldown = SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 11, 0, 42, 38, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && bigShootCooldown <= 0 && !animationLockedForTests();

            }

            public void tick() {
                super.tick();
            }

            @Override
            public void stop() {
                bigShootCooldown = BIG_SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 12, 0, 45, 38, 12.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && bigShootCooldown <= 0 && getNextRandomShootType() == 4 && !animationLockedForTests();

            }

            public void tick() {
                if (attackTicks == 33) {

                }

                super.tick();
            }

            @Override
            public void stop() {
                bigShootCooldown = BIG_SHOOT_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 65, 5, 6.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && repel_slam_cooldown <= 0 && !animationLockedForTests();

            }

            @Override
            public void stop() {
                repel_slam_cooldown = REPEL_SLAM_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 36, 36, 6.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && Shulker_MimicEntity.this.getTarget() != null && !animationLockedForTests();

            }

            @Override
            public void stop() {

                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 8, 0, 50, 20, 6.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && getTarget() != null && getY() - getTarget().getY() >= -1 && !animationLockedForTests() && doubleSlashCooldown <= 0;

            }

            @Override
            public void stop() {
                doubleSlashCooldown = DOUBLE_SLASH_COOLDOWN;
                randomizeAttackPatterns();
                super.stop();
            }
        });
        //DEATH
        this.goalSelector.addGoal(1, new IStateGoal(this, 13, 13, 0, 60, 0) {
            @Override
            public void stop() {
                super.stop();
            }
        });
        //FIREWORK GRAB
        this.goalSelector.addGoal(1, new FireworkGrabGoal(this, 0, 14, 15, 27, 5, 6.0F) {
            public boolean canUse() {
                return super.canUse() && Shulker_MimicEntity.this.getRandom().nextFloat() * 100.0F < 32.0F
                        && getTarget() != null && firework_grab_cooldown <= 0;

            }

            @Override
            public void stop() {
                randomizeAttackPatterns();
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 15, 15, 0, 20, 0) {
            @Override
            public void stop() {
                firework_grab_cooldown = FIREWORK_GRAB_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 16, 16, 0, 44, 0) {
            @Override
            public void stop() {
                firework_grab_cooldown = FIREWORK_GRAB_COOLDOWN;
                super.stop();
            }

        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });
        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 40, 10, 7.0F));
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //   this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public boolean animationLockedForTests() {
        return false;
    }

    public void randomizeAttackPatterns() {
        randomizeNextShootType();
        randomizeNextBackstepType();
    }

    public int backstepType = getPhase() <= 1 ? 2 : 1;

    public int getNextRandomBackstep() {
        return backstepType;
    }

    public void randomizeNextBackstepType() {
        switch (random.nextInt(2)) {
            case 0 -> {
                backstepType = 2;
            }
            case 1 -> {
                backstepType = getPhase() <= 1 ? 2 : 1;
            }
        }
    }

    public int shootType = getPhase() <= 1 ? 4 : 1;

    public int getNextRandomShootType() {
        return shootType;
    }

    public void randomizeNextShootType() {
        switch (random.nextInt(4)) {
            case 0 -> {
                shootType = getPhase() <= 1 ? 4 : 1;
            }
            case 1 -> {
                shootType = getPhase() <= 2 ? getPhase() <= 1 ? 4 : 1 : 2;
            }
            case 2, 4 -> {
                shootType = getPhase() <= 2 ? getPhase() <= 1 ? 4 : 1 : 3;
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 12D);
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SHULKER_AMBIENT;
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SHULKER_HURT_CLOSED;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SHULKER_DEATH;
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }

    @Override
    public int attackDelayTicksValue() {
        return 3;
    }

    @Override
    public void die(DamageSource source) {
        setAttackState(13);
        stopAllAnimationStates();
        deathTime = 0;
        super.die(source);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.ShulkerMimicHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }


    public boolean isDuringTeleportation() {
        return (getAttackState() == 9 && (attackTicks >= 23 && attackTicks <= 28))
                || (getAttackState() == 10 && (attackTicks >= 33 && attackTicks <= 38));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.IS_PROJECTILE) || isDuringTeleportation() || source.is(DamageTypes.FALL) || source.is(DamageTypes.FALL) || isSleep()) {
            return false;
        }
        return super.hurt(source, amount);
    }

    public boolean applyPartDamage(ShulkerMimicPart part, DamageSource source, float amount) {
        return super.hurt(source, amount);
    }


    public boolean hurt(ShulkerMimicPart part, DamageSource source, float amount) {
        return true;
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide) {
            if (isDuringTeleportation() && !isInvisible()) {
                setInvisible(true);
            } else if (!isDuringTeleportation() && isInvisible()) {
                setInvisible(false);
            }
        }

        UpdateWithAttack();
    }

    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState biteAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState backstepDashAnimationState = new AnimationState();
    public AnimationState tripleShootAnimationState = new AnimationState();

    public AnimationState tripleShootTp1AnimationState = new AnimationState();
    public AnimationState tripleShootTp2AnimationState = new AnimationState();

    public AnimationState backstepAnimationState = new AnimationState();

    public AnimationState doubleSlashAnimationState = new AnimationState();
    public AnimationState pullHitAnimationState = new AnimationState();

    public AnimationState bigShootAnimationState = new AnimationState();


    public AnimationState doubleShootAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState fireworkGrabPreAnimationState = new AnimationState();

    public AnimationState fireworkGrabFailAnimationState = new AnimationState();

    public AnimationState fireworkGrabSuccessAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awaken") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "bite") {
            return this.biteAnimationState;
        } else if (input == "backstep_charge") {
            return this.backstepDashAnimationState;
        } else if (input == "backstep") {
            return this.backstepAnimationState;
        } else if (input == "triple_shoot") {
            return this.tripleShootAnimationState;
        } else if (input == "triple_shoot_tp1") {
            return this.tripleShootTp1AnimationState;
        } else if (input == "triple_shoot_tp2") {
            return this.tripleShootTp2AnimationState;
        } else if (input == "pull_hit") {
            return this.pullHitAnimationState;
        } else if (input == "double_slash") {
            return this.doubleSlashAnimationState;
        } else if (input == "big_shoot") {
            return this.bigShootAnimationState;
        } else if (input == "double_shoot") {
            return this.doubleShootAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "firework_grab_pre") {
            return this.fireworkGrabPreAnimationState;
        } else if (input == "firework_grab_fail") {
            return this.fireworkGrabFailAnimationState;
        } else if (input == "firework_grab_success") {
            return this.fireworkGrabSuccessAnimationState;
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
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.biteAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.backstepDashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.backstepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.tripleShootAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.pullHitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.doubleSlashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.tripleShootTp1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.tripleShootTp2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.bigShootAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.doubleShootAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.fireworkGrabPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.fireworkGrabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.fireworkGrabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        doubleShootAnimationState.stop();
        idleAnimationState.stop();
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        biteAnimationState.stop();
        backstepDashAnimationState.stop();
        tripleShootAnimationState.stop();
        backstepAnimationState.stop();
        pullHitAnimationState.stop();
        doubleSlashAnimationState.stop();
        tripleShootTp1AnimationState.stop();
        bigShootAnimationState.stop();
        tripleShootTp2AnimationState.stop();
        deathAnimationState.stop();
        fireworkGrabFailAnimationState.stop();
        fireworkGrabSuccessAnimationState.stop();
        fireworkGrabPreAnimationState.stop();
    }

    public void backStep(float backstepStrenght) {
        float flipStrenght = backstepStrenght;

        float yaw = (float) Math.toRadians(this.getYRot() + 90);
        Vec3 dodgePos = this.getDeltaMovement().add(flipStrenght * Math.cos(yaw), 0.0f, flipStrenght * Math.sin(yaw));
        this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
    }

    public void shootGravityShulkerBullet(float velocity, float x, float y, float z, int inaccuracy, float size) {
        Vec3 vec3 = this.head.position();
        if (level().isClientSide) {
            float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0;
            float offset = 0;
            level().addParticle(ModParticles.SHULKER_EXPLOSION.get(), (vec3.x + vec * vecX + f * offset), vec3.y + 1, vec3.z + vec * vecZ + f1 * offset, 0, 0, 0);
        }
        if (targetIsNotNull()) {

            GravityBigShulkerEntity chorusBomb = new GravityBigShulkerEntity(ModEntities.GRAVITY_BIG_SHULKER_BULLET.get(), this.level()); // Ustaw BigCannonEntity jako właściciela
            chorusBomb.setSize(size);

            chorusBomb.setPosRaw(x, y + 1.5f, z);

            double d0 = target().getX() - x;

            double d4 = (target().getY() - y) * 0.5f;
            double d1 = target().getBoundingBox().minY + target().getBbHeight() / 2 - chorusBomb.getY();
            double d2 = target().getZ() - z;
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, velocity, inaccuracy - this.level().getDifficulty().getId() * 4);

            chorusBomb.setOwner(this);
            this.level().addFreshEntity(chorusBomb);
        }

    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    public void shootBigShulkerBullet(double destX, double destY, double destZ, double x, double y, double z, float size, boolean isFirework, LivingEntity passenger) {
        Vec3 vec3 = this.head.position();
        if (level() instanceof ServerLevel level && !isFirework) {
            float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0f;
            float offset = 0;

            level.sendParticles(ModParticles.SHULKER_EXPLOSION.get(),
                    vec3.x + vec * vecX + f * offset, vec3.y + 1, vec3.z + vec * vecZ + f1 * offset, 1, 0, 0, 0, 0);

            // level().addParticle(ModParticles.SHULKER_EXPLOSION.get(), (vec3.x + vec * vecX + f * offset),vec3.y + 1,vec3.z + vec * vecZ + f1 * offset,0,0,0);
        }

        backStep(-0.5f);
        if (getTarget() != null) {
            double d3 = destX - x;
            double d4 = destY - y;
            double d5 = destZ - z;
            BigShulkerBulletEntity bigShulkerBulletEntity = new BigShulkerBulletEntity(this.level(), this, d3, d4, d5, size, isFirework, passenger);
            bigShulkerBulletEntity.setOwner(this);
            bigShulkerBulletEntity.setPosRaw(x, y, z);
            this.level().addFreshEntity(bigShulkerBulletEntity);
        }
    }

    public void UpdateWithAttack() {
        float smallBulletSize = 0.75f;

        float mediumBulletSize = 1f;

        float biggieCheeseBulletSize = 1.5f;
        if (getAttackState() == 3) {
            if (attackTicks == 11) {
                // calculatedDash(0.15f);
            }
            if (attackTicks == 14) {
                calculatedDash(0.20f);
                playSound(SoundEvents.EVOKER_FANGS_ATTACK, 1, 1f);
            }
            if (attackTicks == 17) {
                AreaAttack(3.9f, 4, 180, 16, 100, true, false);
            }
        }
        if (getAttackState() == 4) {
            if (attackTicks > 23 && attackTicks < 30) {
                if (this.level().isClientSide) {
                    float g = (float) Math.toRadians(-getYRot() + 180);
                    double theta = (this.getYRot()) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);

                    double spawnX = this.getX() + vecX * 1.5f;
                    double spawnZ = this.getZ() + vecZ * 1.5f;
                    this.level().addParticle(new Circle.RingData(g, 0, 30,
                            1, 1, 1, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);
                }
            }
            if (attackTicks > 3 && attackTicks < 7) {
                backStep(-0.75f);
                //
            }
            if (attackTicks == 23) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 31) {
                StraightLineAreaAttack(0.005f, 4, 100, 20, true);
            }
        }
        if (getAttackState() == 5) {
            if (attackTicks > 3 && attackTicks < 7) {
                backStep(-0.75f);
                //
            }

        }
// TRIPLE SHOOT
        if (getAttackState() == 6) {
            if (attackTicks == 10) {

                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), smallBulletSize, false, null);

            }
            if (attackTicks == 21) {


                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), mediumBulletSize, false, null);
            }
            if (attackTicks == 32) {

                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), biggieCheeseBulletSize, false, null);
            }

        }
        if (getAttackState() == 12) {
            if (attackTicks == 10) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), smallBulletSize, false, null);
            }
            if (attackTicks == 21) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), mediumBulletSize, false, null);
            }

        }
        //DOUBLE SHOOT
        if (getAttackState() == 6) {
            if (attackTicks == 10) {

                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), smallBulletSize, false, null);

            }
            if (attackTicks == 21) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), mediumBulletSize, false, null);
            }
        }

        if (getAttackState() == 9) {
            if (attackTicks == 23) {
                if (getTarget() != null) {
                    float f = Mth.cos(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (getTarget().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -5;
                    float offset = 2;
                    if (level() instanceof ServerLevel) {
                        teleport((getTarget().getX() + vec * vecX + f * offset), getTarget().getY(), (float) (getTarget().getZ() + vec * vecZ + f1 * offset));
                    }
                }
            }
            if (attackTicks == 10) {

                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), smallBulletSize, false, null);

            }
            if (attackTicks == 33) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), mediumBulletSize, false, null);

            }
            if (attackTicks == 43) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), biggieCheeseBulletSize, false, null);

            }
        }
        if (getAttackState() == 10) {
            if (attackTicks == 34) {
                if (getTarget() != null) {
                    float f = Mth.cos(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (getTarget().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -5;
                    float offset = 2;
                    if (level() instanceof ServerLevel) {
                        teleport((getTarget().getX() + vec * vecX + f * offset), getTarget().getY(), (float) (getTarget().getZ() + vec * vecZ + f1 * offset));
                    }
                }
            }
            if (attackTicks == 10) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), smallBulletSize, false, null);
            }
            if (attackTicks == 21) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), mediumBulletSize, false, null);
            }
            if (attackTicks == 44) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                if (targetIsNotNull())
                    shootBigShulkerBullet(target().getX(), target().getY() + 1.5f, target().getZ(), getX(), getY() + 2, getZ(), biggieCheeseBulletSize, false, null);
            }

        }
        if (getAttackState() == 7) {

            for (int i = 24, j = 2; i <= 29; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    SpawnDamagingBlocks(0.7f, j, 4f, 2, 1, (float) 1, 0.05F);
                }
                if (attackTicks >= 24 && attackTicks <= 28) {
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 2.5f;
                    float offset1 = 2;
                    float offset = -2;
                    float f3 = (this.random.nextFloat() - 0.5F) * 4.0F;
                    float f4 = (this.random.nextFloat() - 0.5F) * 2.0F;
                    float f5 = (this.random.nextFloat() - 0.5F) * 4.0F;
                    if (level().isClientSide) {

                        this.level().addParticle(ModParticles.SHULKER_EXPLOSION.get(),
                                (getX() + vec * vecX + f * offset1) + (double) f3, this.getY(),
                                (getZ() + vec * vecZ + f1 * offset1) + (double) f5, 0.0D, 0.0D, 0.0D);

                        this.level().addParticle(ModParticles.SHULKER_EXPLOSION.get(),
                                (getX() + vec * vecX + f * offset) + (double) f3, this.getY(),
                                (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);

                    }
                }
                if (attackTicks == 24) {

                    CameraShakeEntity.cameraShake(level(), position(), 10, 0.10f, 10, 5);
                    playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
                    AreaAttack(5, 4, 180, 20, 140, true, false);
                    //  SpawnCircleParticle(2,0,30,true,3,1,1,1,1);
                }
                if (attackTicks > 24 && attackTicks < 46) {
                    if (level().isClientSide) {
                        float yaw = (float) Math.toRadians(-getYRot());
                        float pitch = (float) Math.toRadians(-getXRot());
                        float spread = 0.7f;
                        float speed = 2f;
                        float xComp = (float) (Math.sin(yaw) * Math.cos(pitch));
                        float yComp = (float) (Math.sin(pitch));
                        float zComp = (float) (Math.cos(yaw) * Math.cos(pitch));
                        double theta = (getYRot()) * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double vec = 2;
                        if (level().isClientSide) {
                            for (int g = 0; g < 3; g++) {
                                double xSpeed = speed * xComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - xComp * xComp)));
                                double ySpeed = speed * yComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - yComp * yComp)));
                                double zSpeed = speed * zComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - zComp * zComp)));
                                level().addAlwaysVisibleParticle(ParticleTypes.CLOUD, getX() + vec * vecX, getY() + 2, getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
                            }
                        }


                    }
                    PushEntitiesAwayInFrontOf(-0.5f, 0f, 14, 0, 5);
                }
            }
        }
        if (getAttackState() == 8) {
            if (attackTicks == 14) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 17) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.05f, 5, 5);
                AreaAttack(4.5f, 1.1f, 180, 18, 100, false, false);
            }
            if (attackTicks == 27) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 30) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.05f, 5, 5);
                AreaAttack(4.5f, 1.1f, 180, 18, 100, false, false);
            }
        }
        if (getAttackState() == 11) {
            float y = (float) (getY() + 0.5f);
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0.75f;
            float offset = 0;

            if (attackTicks == 18) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
                shootGravityShulkerBullet(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 15, smallBulletSize);

                //  shootGravityShulkerBullet(1f,(float) (getX() + vec * vecX + f * offset), y  ,(float) (getZ() + vec * vecZ + f1 * offset),0,biggieCheeseBulletSize);

                shootGravityShulkerBullet(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 45, smallBulletSize);
            }
            if (attackTicks == 19) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 1);
            }
        }
        if (getAttackState() == 14) {
            if (attackTicks == 22) {
                calculatedDash(0.20f);
                playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0f, 0.5F);
            }
            if (attackTicks == 25) {
                Grab(0.0025f, 3.5f, 2f, 100, 5);
                // SideGrab(4.5f,4,180,0,5,120,SoundEvents.PLAYER_ATTACK_SWEEP,0.75f);
            }
        }
        if (getAttackState() == 16) {
            if (attackTicks > 20 && attackTicks < 23) {

                float f1 = (this.random.nextFloat() - 0.75F) * 3.0F;
                float f2 = (this.random.nextFloat() - 0.75F) * 2.5F;
                float f3 = (this.random.nextFloat() - 0.7F) * 3.0F;

                float f4 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f5 = (this.random.nextFloat() - 0.5F) * 2.0F;
                float f6 = (this.random.nextFloat() - 0.5F) * 4.0F;

                for (int i = 0; i < 10; i++) {
                    if (this.level() instanceof ServerLevel level) {
                        level.sendParticles(ModParticles.SHULKER_EXPLOSION.get(),
                                getX() + (double) f1, this.getY() + 3 + (double) f2, getZ() + (double) f3, 15, 0, 0, 0, 0);
                        level.sendParticles(ModParticles.PURPLE_SHULKER_EXPLOSION.get(),
                                getX() + (double) f4, this.getY() + 3 + (double) f5, getZ() + (double) f6, 15, 0, 0, 0, 0);
                    }
                }
            }
            if (attackTicks == 22) {
                playSound(SoundEvents.SHULKER_SHOOT, 1, 0.75f);
                if (targetIsNotNull())
                    shootBigShulkerBullet(getX(), getY() + 10, getZ(), getX(), getY() + 0.45f, getZ(), mediumBulletSize, true, target());
            }
        }
    }

    public Direction.Axis getAttachFace() {
        return Direction.Axis.Y;
    }

    public boolean canCollideWith(Entity pEntity) {
        return true;
    }

    private void StraightLineAreaAttack(float RangeXZ, float range, int brokenShieldTicks, float damage, boolean launch) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(RangeXZ, 4, RangeXZ).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) (((damage - damageNerf()) * ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get())));
                if (flag) {
                    playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 0.5f);
                }
                if (flag && launch) {
//launch(entityHit,true,2,0.3f);

                    launch(entityHit, true);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    private void PushEntitiesAwayInFrontOf(float RangeXZ, float y, float range, int brokenShieldTicks, float damage) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(RangeXZ, y, RangeXZ).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) (((damage - damageNerf()) * ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get())));
                if (flag) {
                    addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 100, 2));
                    //       playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(),1,0.5f);
                }


                if (entityHit instanceof Player && ((Player) entityHit).getAbilities().invulnerable) continue;
                if (isAlliedTo(entityHit)) continue;
                Vec3 diff = entityHit.position().subtract(this.position().add(0, 0, 0));
                diff = diff.normalize().scale(-4 * 0.015);
                entityHit.setDeltaMovement(entityHit.getDeltaMovement().subtract(diff));

                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int brokenShieldTicks, boolean canlaunch, boolean canStun) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Shulker_MimicEntity) && entityHit != this) {


                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) (((damage - damageNerf()) * ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get())));

                    if (flag) {
                        if (canStun) {
                            if (entityHit == this.getTarget()) {

                                playSound(SoundEvents.ANVIL_PLACE, 2, 1f);
                            }
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 80, 1));
                        }
                        if (canlaunch) {
                            launch(entityHit, true);
                        }
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }


    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level) {
            // level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + 3, getZ(), 1, 0, 0, 0, 0);
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

    public void SpawnDamagingBlocks(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            LMFallingBlockEntity fallingBlockEntity = new LMFallingBlockEntity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            // level().addFreshEntity(fallingBlockEntity);
            level().addAlwaysVisibleParticle(ModParticles.SHULKER_EXPLOSION.get(), hitX + 0.5D, hitY + 2, hitZ + 0.5D, 0, 0, 0);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(level().damageSources().mobAttack(this), 11 - damageNerf() * damage + Math.min(11 * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    private void Sphereparticle(ParticleOptions particleType, float height, float vec, float size) {
        if (this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;


                            this.level().addParticle(particleType, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 60) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public boolean succedGrabbing;

    private void Grab(float RangeXZ, float range, float y, int brokenShieldTicks, float damage) {

        if (this.level().isClientSide) return;

        boolean hitAny = false;
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox()
                .inflate(RangeXZ, y, RangeXZ)
                .expandTowards(xRange, 0, zRange);

        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                hitAny = true;
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this),
                        (float) ((damage - damageNerf() * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())
                                + (this.getTarget() != null
                                ? this.getTarget().getMaxHealth() * 0.03f
                                : 0f)));
                boolean entityHitisTarget = entityHit == target();
                boolean mounted = entityHitisTarget && entityHit.startRiding(this, true);

                if (flag && getAttackState() == 17) {
                    double x = entityHit.getX() - this.getX();
                    double z = entityHit.getZ() - this.getZ();
                    double d = Math.sqrt(x * x + z * z);
                    entityHit.setDeltaMovement(x / d * 0.8, 1.25, z / d * 0.8);
                    EntityUtil.applyPlayerDeltaMovement(entityHit);
                }
                if (flag && mounted) {
                    playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.75f);
                    succedGrabbing = true;
                } else {
                    succedGrabbing = false;
                }


                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }

                break;
            }
        }

        if (!hitAny) {

            succedGrabbing = false;

        }
    }


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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheObliteratorEntity) && entityHit != this) {
                    hitAny = true;
                    boolean entityHitisTarget = entityHit == target();
                    boolean mounted = entityHitisTarget && entityHit.startRiding(this, true);
                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage - damageNerf() * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
                    if (flag && mounted) {
                        entityHit.setShiftKeyDown(false);
                        playSound(soundEvent, 1, pitch);
                        succedGrabbing = true;
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
}