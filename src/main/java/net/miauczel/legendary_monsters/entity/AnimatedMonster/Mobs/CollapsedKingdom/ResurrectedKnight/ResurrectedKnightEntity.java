package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.BeheadedKnightSweepParticle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSweepParticle;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.goals.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulJavelinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulPillarEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class ResurrectedKnightEntity extends IAnimatedMiniBoss {
    public ResurrectedKnightEntity(EntityType entity, Level world) {
        super(entity, world);
    }

    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(ResurrectedKnightEntity.class, EntityDataSerializers.INT);

    public final int FORWARD_STEP_COOLDOWN = 40;
    public int forwardStepCooldown = FORWARD_STEP_COOLDOWN;

    public final int DOUBLE_STAB_COOLDOWN = 100;
    public int doubleStabCooldown = DOUBLE_STAB_COOLDOWN;

    public final int SHIELD_COMBO_COOLDOWN = 100;
    public int shield_combo_cooldown = SHIELD_COMBO_COOLDOWN;

    public final int SYNERGY_COOLDOWN = 300;
    public int synergyCooldown = SYNERGY_COOLDOWN;

    @Override
    protected boolean canRide(Entity pVehicle) {
        return true;
    }

    public boolean canBreakBlocks() {
        return getAttackState() ==14;
    }

    private void destroy() {
        if (!this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return;
        }
        boolean flag = false;
        float inflate = 1f;
        AABB aabb = this.getBoundingBox().inflate(inflate, inflate, inflate);
        Iterator var3 = BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ)).iterator();

        while (true) {
            while (true) {
                BlockPos blockpos;
                BlockState blockstate;
                do {

                    do {
                        do {
                            if (!var3.hasNext()) {
                                return;
                            }

                            blockpos = (BlockPos) var3.next();
                            blockstate = this.level().getBlockState(blockpos);
                        } while (blockstate.isAir());
                    } while (!blockstate.canEntityDestroy(this.level(), blockpos, this));

                } while (!ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate));

                if (this.random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
                } else {
                    if (!blockstate.is(ModBlocks.INDESTRUCTIBLE_BLOCK.get()) && !blockstate.is(ModBlocks.SOUL_CANDLE.get()) && !blockstate.is(ModBlocks.SOMBER_TRAPDOOR.get()))
                        flag = this.level().destroyBlock(blockpos, false, this) || flag;
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (canBreakBlocks()) {
            if (!this.level().isClientSide) {
                if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
               //     this.destroy();
                }
            }
        }

        // System.out.println("CAN SYNERGY: " + canSynergyAttack() + " SynergyAttack Cooldown: " + synergyCooldown);
        if (forwardStepCooldown > 0) forwardStepCooldown--;
        if (doubleStabCooldown > 0) doubleStabCooldown--;
        if (shield_combo_cooldown > 0) shield_combo_cooldown--;
        if (synergyCooldown > 0) synergyCooldown--;

        if (level().isClientSide) idleAnimationState.animateWhen(getAttackState() == 0, tickCount);
        UpdateWithAttack();
        detectDuoFight(10);
        if (!isSleep()) {
            for (int i = 0; i < 0.5; ++i) {
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.GHOSTLY_SOUL.get(), this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);

                }

            }
        }
    }

    public void regainHealthWithoutTarget(float health, float speed) {
        /*
        if (!level().isClientSide) {
            if (ModConfig.MOB_CONFIG.allowDuoBossRespawnTeammate.get()) {
                if (!targetIsNotNull()) {
                    if (ticksWithoutTarget <= 0 && !targetIsNotNull() && !getIsDuoFight() && synchronisedDuoKnight() == null && !synchronisedDuoKnight().isAlive()) {
                        BeheadedKnightEntity resurrectedKnightEntity = new BeheadedKnightEntity(ModEntities.BEHEADED_KNIGHT.get(), level());
                        resurrectedKnightEntity.setPos(position());
                        level().addFreshEntity(resurrectedKnightEntity);
                    }
                }
            }
        }*/
        if (ModConfig.MOB_CONFIG.AllowBossNatureHeal.get()) {
            if (!level().isClientSide) {
                if (!targetIsNotNull() && ticksWithoutTarget > 0 && getAttackState() == 0) {
                    --ticksWithoutTarget;

                }
                if (ticksWithoutTarget <= 0 && !targetIsNotNull()) {
                    if (tickCount % speed == 0) {
                        this.heal(health);
                    }
                }
                if (targetIsNotNull()) {
                    ticksWithoutTarget = TICKS_WITHOUT_TARGET;
                }
            }
        }
    }

    Random random1 = new Random();

    public void detectDuoFight(float range) {
        List<BeheadedKnightEntity> beheadedKnightEntities = level().getEntitiesOfClass(BeheadedKnightEntity.class, getBoundingBox().inflate(range));
        if (beheadedKnightEntities.isEmpty()) duoFight = false;
        for (BeheadedKnightEntity beheadedKnightEntity : beheadedKnightEntities) {
            if (synchronisedDuoKnight() != null) setTextureVariant(synchronisedDuoKnight().getTextureVariant());
            duoFight = true;
            shouldAttack = beheadedKnightEntity.getAttackState() != 2;
            syncedEntity = beheadedKnightEntity;
        }
    }

    public void attractParticles(ParticleOptions particleOptions, float cap, int reps, float vec, float offset, float startY, float endY, float velocity) {
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        float rX = random1.nextFloat(-cap, cap);
        float rZ = random1.nextFloat(-cap, cap);

        float f2 = (this.random.nextFloat() - 0F) * 0.5F;
        double d1 = getX() + rX;
        double d2 = getY() + startY + f2;

        double d3 = getZ() + rZ;
        double d4 = getX() + 1 * vecX + f * 0;
        double d5 = getZ() + 1 * vecZ + f1 * 0;
        Vec3 vec3 = new Vec3(d4, d2, d5);
        Vec3 vec4 = new Vec3(getX() + vec * vecX + f * offset, position().y + endY, getZ() + vec * vecZ + f1 * offset);
        Vec3 vf = vec4.subtract(vec3);
        Vec3 v = vf.scale(velocity);
        for (int i = 0; i <= reps; i++) {
            if (level().isClientSide) {
                this.level().addParticle(particleOptions, d4, d2, d5, v.x, v.y, v.z);
                //       this.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);
            }
        }
    }

    @Override
    public Vec3 getLookAngle() {
        return super.getLookAngle();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        /// ALERTED STATE
        this.goalSelector.addGoal(1, new RSAlertedStateGoal(this, 2, 2, 0, 20, 20, false, 0) {
            public void start() {
                super.start();

            }

            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 15 && !animationLockedForTests() && canAttack()
                        && target != null;
            }


            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new RSStabGoal(this, 0, 3, 0, toTicks(0.88f), 8, 6, false, 0) {
            public void start() {
                super.start();

            }

            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 25 && !animationLockedForTests() && canAttack() && !isReadyForSynergyAttack()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new RSStateGoal(this, 12, 12, 0, 30, 0, false, 50) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new RSStateGoal(this, 7, 7, 0, toTicks(2.38f), 8, true, 50) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        //Double Stab
        /*this.goalSelector.addGoal(1, new RSDoubleStabGoal(this, 0, 7, 0, toSeconds(3.25f), 8, 7, true, 50) {
            public void start() {
                super.start();

            }

            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20 && !animationLockedForTests() && canAttack() && !getIsDuoFight()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });*/
        this.goalSelector.addGoal(1, new RSAttackGoal(this, 0, 4, 0, 15, 15, 5, false, 25) {
            public void start() {
                super.start();

            }

            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20 && !animationLockedForTests() && !isReadyForSynergyAttack()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new RSAttackGoal(this, 0, 5, 0, 15, 15, 5, false, 25) {
            public void start() {
                super.start();

            }

            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 25 && !animationLockedForTests() && !isReadyForSynergyAttack()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new RSAttackGoal(this, 0, 6, 0, 18, 18, 15, false, 25) {
            public void start() {
                super.start();

            }

            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20 && !animationLockedForTests()
                        && target != null && distanceTo(target) > 6 && forwardStepCooldown <= 0 && canAttack() && getIsDuoFight() && !isReadyForSynergyAttack();
            }

            @Override
            public void stop() {
                super.stop();
                forwardStepCooldown = FORWARD_STEP_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new RSAttackGoal(this, 0, 13, 0, toTicks(5.04f), 60, 6, true, 25) {
            public void start() {
                super.start();

            }

            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20 && !animationLockedForTests()
                        && target != null && shield_combo_cooldown <= 0 && canAttack() && !getIsDuoFight() && !isReadyForSynergyAttack();
            }

            @Override
            public void stop() {
                super.stop();
                shield_combo_cooldown = SHIELD_COMBO_COOLDOWN;
            }
        });
        //Throw
        this.goalSelector.addGoal(1, new RSAttackGoal(this, 0, 11, 0, toTicks(2.63f), 20, 15, false, 50) {
            public void start() {
                super.start();

            }

            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < 25 && !animationLockedForTests() && canAttack() && !isReadyForSynergyAttack()
                        && target != null && distanceTo(target) >= 7;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new RSSynergyGoal(this, 0, 14, 0, toTicks(5.58f), 20, 15, true, 50) {
            public void start() {
                super.start();
                synchronisedDuoKnight().setAttackState(10);
            }

            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && !animationLockedForTests() && canAttack() && canSynergyAttack()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
                synergyCooldown = SYNERGY_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 9, 9, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });

        this.goalSelector.addGoal(0, new IAttackGoal(this, 9, 10, 0, 45, 0, 10.0F));
    }

    public boolean canSynergyAttack() {
        return (synchronisedDuoKnight() != null && getIsDuoFight() && synchronisedDuoKnight().getAttackState() == 0 && synergyCooldown == 0 && synchronisedDuoKnight().synergyCooldown == 0);
    }

    public BeheadedKnightEntity syncedEntity = null;

    public BeheadedKnightEntity synchronisedDuoKnight() {
        return syncedEntity;
    }

    public boolean isReadyForSynergyAttack() {
        return synergyCooldown <= 0 && synchronisedDuoKnight() != null && synchronisedDuoKnight().isAlive() && synchronisedDuoKnight().getAttackState() == 0;
    }

    @Override
    public boolean killedEntity(ServerLevel pLevel, LivingEntity pEntity) {
        return super.killedEntity(pLevel, pEntity);
    }

    @Override
    public int attackDelayTicksValue() {
        return canSynergyAttack() ? 5 : 0;
    }

    @Override
    public @NotNull AABB getBoundingBoxForCulling() {
        return getBoundingBox().inflate(12);
    }

    @Override
    public boolean canBeCollidedWith() {
        return getAttackState() == 14;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        if (getAttackState() == 14) {
            return false;
        } else return super.canCollideWith(pEntity);
    }

    @Override
    public boolean isPushable() {
        return getAttackState() != 14;
    }

    @Override
    public void push(Entity entityIn) {
        if (getAttackState() == 14) {

        } else super.push(entityIn);
    }

    @Override
    public void push(double pX, double pY, double pZ) {
        if (getAttackState() == 14) {

        } else super.push(pX, pY, pZ);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(TEXTURE_VARIANT, 1);
    }


    public void shootSoulJavelin(LivingEntity pTarget, float pDistanceFactor) {
        SoulJavelinEntity soulJavelin = new SoulJavelinEntity(this.level(), this, new ItemStack(Items.TRIDENT));
        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - soulJavelin.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        soulJavelin.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0F, 0.75F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(soulJavelin);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //  this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 9 : 0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 9 || this.getAttackState() == 10;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putBoolean("is_Sleep", isSleep());
        pCompound.putInt("texture_variant", getTextureVariant());
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        setSleep(compound.getBoolean("is_Sleep"));
        setTextureVariant(compound.getInt("texture_variant"));
        super.readAdditionalSaveData(compound);
    }

    public int getTextureVariant() {
        return entityData.get(TEXTURE_VARIANT);
    }

    public void setTextureVariant(int textureVariant) {
        entityData.set(TEXTURE_VARIANT, textureVariant);
    }

    public boolean animationLockedForTests() {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 190f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 12D)
                .add(Attributes.ARMOR_TOUGHNESS, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    public boolean shouldAttack = true;

    public boolean duoFight = false;

    public boolean canAttack() {
        return shouldAttack && !isPassenger() && (synchronisedDuoKnight() != null && synchronisedDuoKnight().getAttackState() != 11) || !getIsDuoFight();
    }

    public boolean getIsDuoFight() {
        return synchronisedDuoKnight() != null && synchronisedDuoKnight().isAlive() && distanceTo(synchronisedDuoKnight()) <= 10;
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState alertedAnimationState = new AnimationState();

    public AnimationState stabAnimationState = new AnimationState();

    public AnimationState rightSideStepAnimationState = new AnimationState();

    public AnimationState leftSideStepAnimationState = new AnimationState();

    public AnimationState forwardStepAnimationState = new AnimationState();

    public AnimationState doubleStabAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState sleepAnimationState = new AnimationState();

    public AnimationState awakenAnimationState = new AnimationState();

    public AnimationState javelinThrowAnimationState = new AnimationState();

    public AnimationState stabEndAnimationState = new AnimationState();

    public AnimationState shieldComboAnimationState = new AnimationState();

    public AnimationState synergyAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "stab") {
            return this.stabAnimationState;
        }
        if (input == "left_sidestep") {
            return this.leftSideStepAnimationState;
        }
        if (input == "right_sidestep") {
            return this.rightSideStepAnimationState;
        }
        if (input == "forwardstep") {
            return this.forwardStepAnimationState;
        }
        if (input == "double_stab") {
            return this.doubleStabAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awaken") {
            return this.awakenAnimationState;
        }
        if (input == "throw") {
            return this.javelinThrowAnimationState;
        }
        if (input == "stab_end") {
            return this.stabEndAnimationState;
        }
        if (input == "shield_combo") {
            return this.shieldComboAnimationState;
        }
        if (input == "synergy") {
            return this.synergyAnimationState;
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
                        this.alertedAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.stabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.leftSideStepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.rightSideStepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.forwardStepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.doubleStabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.awakenAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.javelinThrowAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.stabEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.shieldComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.synergyAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        alertedAnimationState.stop();
        stabAnimationState.stop();
        idleAnimationState.stop();
        leftSideStepAnimationState.stop();
        rightSideStepAnimationState.stop();
        doubleStabAnimationState.stop();
        forwardStepAnimationState.stop();
        idleAnimationState.stop();
        deathAnimationState.stop();
        sleepAnimationState.stop();
        awakenAnimationState.stop();
        javelinThrowAnimationState.stop();
        stabEndAnimationState.stop();
        shieldComboAnimationState.stop();
        synergyAnimationState.stop();
    }

    public ControlledAnim bodyFadeAway = new ControlledAnim(10);

    public ControlledAnim telegraphFadeAway = new ControlledAnim(10);

    public void UpdateWithAttack() {
        float sweepSize = 2f;
        float sweepRot = 20;
        float bigSweepHeight = 3;
        float bigSweepAdditionalY = 1;
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float slashRange = 5f;
        //Stab Once
        if (getAttackState() == 3) {
            int stab = 18;
            if (attackTicks == 8 && targetIsNotNull()) {
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == stab - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.SPEAR_STAB.get(), 1, 0.75f);
            }
            if (attackTicks == stab) {
                // stabHitbox(0.5f,4,2,15,80,true,1,0.1f);
                StraightLineAreaAttackGambit(-0.5f, 1, 4, 80, 15, true, 2f, 0);
            }
        }
        //Stab Double
        if (getAttackState() == 7) {
            int stab = 18;
            if (attackTicks == 8 && targetIsNotNull()) {
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == stab - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.SPEAR_STAB.get(), 1, 0.75f);
            }
            if (attackTicks == stab) {
                // stabHitbox(0.5f,4,2,15,80,true,1,0.1f);
                StraightLineAreaAttack(-0.5f, 1, 4, 80, 15, true, 1.5f, 0);
            }
            /*
            int stab = 18;
            int stab2 = 35;

            if (attackTicks == 8 && targetIsNotNull()) {
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == stab - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1.25f);
            }
            if (attackTicks == stab) {
                // stabHitbox(0.5f,4,2,15,80,true,1,0.1f);
                StraightLineAreaAttack(-0.5f, 1, 4, 80, 15, true, 1.5f, 0);
            }
            if (attackTicks == 25 && targetIsNotNull()) {
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == stab2 - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1.25f);
            }
            if (attackTicks == stab2) {
                // stabHitbox(0.5f,4,2,15,80,true,1,0.1f);
                StraightLineAreaAttack(-0.5f, 1, 4, 80, 15, true, 1.5f, 0);
            }*/
        }
        //SideSteps
        int sideStep = 3;
        if (getAttackState() == 4) {
            if (attackTicks == sideStep) {
                float vec = 0;
                float offset = -2;
                float scale = 1;
                Vec3 rollPos = new Vec3(getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset);
                Vec3 sub = position().subtract(rollPos);
                Vec3 finalPos = sub.scale(scale);
                setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
            }
        }

        if (getAttackState() == 5) {
            if (attackTicks == sideStep) {
                float vec = 0;
                float offset = 2;
                float scale = 1;
                Vec3 rollPos = new Vec3(getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset);
                Vec3 sub = position().subtract(rollPos);
                Vec3 finalPos = sub.scale(scale);
                setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
            }
        }
        //Forward Step
        if (getAttackState() == 6) {
            if (attackTicks == 3) {
                if (targetIsNotNull()) {
                    //  calculatedDash((float) (0.25f - (distanceTo(target()) * 0.01)));
                    calculatedDash(0.25f);
                }
            }
        }
        //Death
        if (getAttackState() == 8) {
            if (attackTicks >= 55) bodyFadeAway.increaseTimer();
        }
        //Awaken
        if (getAttackState() == 10) {
            if (attackTicks == 2) bodyFadeAway.setTimer(5);
            if (attackTicks >= 20 && attackTicks <= 25 && bodyFadeAway.getTimer() > 0) {
                bodyFadeAway.decreaseTimer();
            }

        }
        if (getAttackState() == 11) {
            if (attackTicks == 21) {
                if (targetIsNotNull()) shootSoulJavelin(target(), 1);
            }
        }
        //ShieldCombo
        if (getAttackState() == 13) {
            int shieldTick = 23;
            int javelinSlash = 26;
            int sideStepp = 40;
            int stab = 70;
            if (attackTicks == shieldTick - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get());
                calculatedDash(0.25f);
            }
            if (attackTicks == shieldTick) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize * 0.75f, sweepRot, 0, true);
                SideAreaAttack(3f, 3, 180, 0, 0, 13, 100, false, false, 0, 0, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.8f);
            }
            if (attackTicks == javelinSlash - 3) {
                playSound(ModSounds.SPEAR_STAB.get(), 1, 0.75f);
                calculatedDash(0.20f);
            }
            if (attackTicks == javelinSlash) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, 0, true);
                SideAreaAttack(3.25f, 3, 180, 0, 0, 15, 100, false, false, 0, 0, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == sideStepp) {
                float vec = 0;
                float offset = -2;
                float scale = 1;
                Vec3 rollPos = new Vec3(getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset);
                Vec3 sub = position().subtract(rollPos);
                Vec3 finalPos = sub.scale(scale);
                setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
            }

            if (attackTicks == stab - 6) {
                if (targetIsNotNull()) saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == stab - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1.25f);
                calculatedDashToPositon(0.25f, lastTargetPos());
            }
            if (attackTicks == stab - 3) {
                // stabHitbox(0.5f,4,2,15,80,true,1,0.1f);
                StraightLineAreaAttack(-0.5f, 1, 5, 80, 15, true, 1.5f, 0);
            }
        }
        //Synergy
        if (getAttackState() == 14) {
            int shieldBash = 24;
            int cut1 = 67;
            int cut2 = 73;
            // System.out.println("CAN RENDER LINES: " + canRenderWarningLine() + " TIMER: " + telegraphFadeAway.getTimer());
            if (attackTicks == 1) {
                telegraphFadeAway.setTimer(0);
                telegraphFadeAway.resetTimer();
            }
            if (attackTicks == 14 || attackTicks == 54 || attackTicks == 40 || attackTicks == 115)
                telegraphFadeAway.resetTimer();
            if (((attackTicks >= 14 && attackTicks < 20) || (attackTicks >= 55 && attackTicks < 60)))
                telegraphFadeAway.increaseTimer();

            if (attackTicks == 10 && targetIsNotNull())
                saveTargetPos(target().getX(), target().getY(), target().getZ());

            if (attackTicks == shieldBash - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1.25f);
                calculatedDashToPositon(0.4f, lastTargetPos());
            }
            if (attackTicks == shieldBash) {
                StraightLineAreaAttack(-0.5f, 1, 2.75f, 80, 15, true, 2f, 0.5f);
            }
            if (attackTicks == cut1 - 3 || attackTicks == cut2 - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                basicDash(2f, 2, true);
            }
            if (attackTicks == cut1 || attackTicks == cut2) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                StraightLineAreaAttack(-0.5f, 1, 5, 80, 15, true, 1f, 0);
            }
        }
    }

    public boolean canRenderWarningLine() {
        return getAttackState() == 14 && ((attackTicks < 20) || (attackTicks > 40 && attackTicks < 60));
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }

    public void spawnSoulPillar(float vec, float offset, int amount) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int standingOnY = Mth.floor(getY()) - 1;
        double headY = getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + getYRot()));


        for (int l = 0; l < amount; l++) {
            double d2 = 1.25D * (double) (l + 1);

            int j = 1 * l;
            if (this.spawnSoulPillars((getX() + vec * vecX + f * offset) + (double) Mth.cos(yawRadians) * d2, headY, (getZ() + vec * vecZ + f1 * offset) + (double) Mth.sin(yawRadians) * d2, standingOnY, yawRadians, j, level(), this))
                ;


        }

    }

    private boolean spawnSoulPillars(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
                if (!world.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.addFreshEntity(new SoulPillarEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, this, 20, 8, false));
            return true;
        }
        return false;
    }

    public void createSweep(float pos, float posOffset, float yHeight, double additionalY, boolean reverse, float scale, float rot, int additionalSideAngle, boolean soul) {
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
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? rot + additionalSideAngle : 180 + additionalSideAngle));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
            if (!soul) {
                this.level().addParticle(new BeheadedKnightSweepParticle.SweepData(this.getScale() * scale, yaw, pitch, 1, 1, 1), d0, d1, d2, 0, 0, 0);
            } else {
                this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);

            }
        }
    }

    public void stabHitbox(float width, float r, float h, float damage, int brokenShieldTicks, boolean launch, float Vxz, float Vy) {
        Vec3 start = position().add(0, h, 0);
        Vec3 end = getLookAngle().scale(r);
        AABB aabb = new AABB(start, end).inflate(width, 0, width);
        List<LivingEntity> entityList = level().getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entityHit : entityList) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.ResurrectedKnightDamageMultiplier.get())));
                if (flag && launch) {
                    entityHit.invulnerableTime = 0;
                    launch(entityHit, Vxz, Vy);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (isSleep()) return false;
        return super.hurt(pSource, pAmount);
    }

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float Vxz, float Vy) {
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, yHeight, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.ResurrectedKnightDamageMultiplier.get())));
                if (flag && launch) {
                    entityHit.invulnerableTime = 0;
                    launch(entityHit, Vxz, Vy);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    public boolean gambit = false;

    private void StraightLineAreaAttackGambit(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float Vxz, float Vy) {
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, yHeight, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.ResurrectedKnightDamageMultiplier.get())));
                if (flag && launch) {

                    launch(entityHit, Vxz, Vy);
                }

                if (flag) {
                    EntityUtil.cancelBuffs(entityHit);
                    entityHit.invulnerableTime = 0;
                    gambit = true;
                }

                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

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

            float Vxz, float Vy,
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof BeheadedKnightEntity) && entityHit != this) {

                    boolean flag = entityHit.hurt(
                            this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.ResurrectedKnightDamageMultiplier.get())));

                    if (flag) {
                        EntityUtil.cancelBuffs(entityHit);
                        entityHit.invulnerableTime = 0;
                        entityHit.hurtDuration = 0;
                        if (canlaunch) launch(entityHit, Vxz, Vy);

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

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.ResurrectedKnightHealthMutliplier.get());
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(8);
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 100) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();
    }

}
