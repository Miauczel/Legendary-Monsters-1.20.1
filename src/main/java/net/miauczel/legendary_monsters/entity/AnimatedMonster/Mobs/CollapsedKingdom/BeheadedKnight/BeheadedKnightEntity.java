package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.BeheadedKnightSweepParticle;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSweepParticle;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals.BHGrabAndThrowGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals.BHSynergyStateGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.goals.GhostUppercutGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.ResurrectedKnightEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulPillarEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.ThrownResurrectedKnightEntity;
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
import net.minecraft.sounds.SoundEvent;
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
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class BeheadedKnightEntity extends IAnimatedMiniBoss {
    public BeheadedKnightEntity(EntityType entity, Level world) {
        super(entity, world);
    }

    /// Data
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(BeheadedKnightEntity.class, EntityDataSerializers.INT);


    public final int UPPERCUT_COOLDOWN = 0;
    public int upperCutCooldown = UPPERCUT_COOLDOWN;

    public final int GHOST_COMBO_COOLDOWN = 100;
    public int ghostComboCooldown = GHOST_COMBO_COOLDOWN;

    public final int GHOST_UPPERCUT_COOLDOWN = 40;
    public int ghostUppercutCooldown = GHOST_UPPERCUT_COOLDOWN;

    public final int GRAB_AND_THROW_COOLDOWN = 100;
    public int grab_and_throw_cooldown = GRAB_AND_THROW_COOLDOWN;

    public final int SYNERGY_COOLDOWN = 300;
    public int synergyCooldown = SYNERGY_COOLDOWN;

    public final int STAB_COOLDOWN = 40;
    public int stab_cooldown = STAB_COOLDOWN;

    public boolean canBreakBlocks() {
        return getAttackState() == 10;
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
                 //   this.destroy();
                }
            }
        }
        if (getAttackState() != 11 && getAttackState() != 12) ejectPassengers();
        // System.out.println("BH_ATTACK_STATE: " + getAttackState());
        if (tickCount % 15 == 0) attractParticles(ModParticles.GHOSTLY_SOUL.get(), 0.5f, 3, 4, 0, 1, 0, 3, 6, 0.025f);
        if (upperCutCooldown > 0) upperCutCooldown--;
        if (ghostComboCooldown > 0) ghostComboCooldown--;

        if (ghostUppercutCooldown > 0) ghostUppercutCooldown--;

        if (synergyCooldown > 0) synergyCooldown--;

        if (stab_cooldown > 0) stab_cooldown--;

        if (grab_and_throw_cooldown > 0) grab_and_throw_cooldown--;
        //  System.out.println("Cooldown: " + grab_and_throw_cooldown);
        detectDuoFight(10);
        if (level().isClientSide) idleAnimationState.animateWhen(getAttackState() == 0, tickCount);
        UpdateWithAttack();
    }

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }

    public void regainHealthWithoutTarget(float health, float speed) {
        /*
        if (!level().isClientSide) {
            if (ModConfig.MOB_CONFIG.allowDuoBossRespawnTeammate.get()) {
                if (!targetIsNotNull()) {
                    if (ticksWithoutTarget <= 0 && !targetIsNotNull() && !getIsDuoFight() && synchronisedDuoKnight() == null && !synchronisedDuoKnight().isAlive()) {
                        ResurrectedKnightEntity resurrectedKnightEntity = new ResurrectedKnightEntity(ModEntities.RESURRECTED_KNIGHT.get(), level());
                        resurrectedKnightEntity.setPos(position());
                        level().addFreshEntity(resurrectedKnightEntity);
                    }
                }
            }
        }
        
         */
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
    boolean duoFight = false;

    public void detectDuoFight(float range) {
        List<ResurrectedKnightEntity> resurrectedKnightEntities = level().getEntitiesOfClass(ResurrectedKnightEntity.class, getBoundingBox().inflate(range));
        for (ResurrectedKnightEntity duoKnight : resurrectedKnightEntities) {
            duoFight = true;
            shouldAttack = duoKnight.getAttackState() != 3;
            syncedEntity = duoKnight;
        }
    }

    public void attractParticles(ParticleOptions particleOptions, float cap, int reps, float vec, float offset, float startVec, float startOffset, float startY, float endY, float velocity) {
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
        double d4 = getX() + startVec * vecX + f * startOffset;
        double d5 = getZ() + startVec * vecZ + f1 * startOffset;
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

    public void attractParticles(ParticleOptions particleOptions, int cap, int reps, float vec, float offset, float startY, float endY, float velocity) {
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        int rX = random1.nextInt(-cap, cap);
        int rZ = random1.nextInt(-cap, cap);

        float f2 = (this.random.nextFloat() - 0F) * 0.5F;
        double d1 = getX() + rX;
        double d2 = getY() + startY + f2;

        double d3 = getZ() + rZ;
        Vec3 vec3 = new Vec3(d1, d2, d3);
        Vec3 vec4 = new Vec3(getX() + vec * vecX + f * offset, position().y + endY, getZ() + vec * vecZ + f1 * offset);
        Vec3 vf = vec4.subtract(vec3);
        Vec3 v = vf.scale(velocity);
        for (int i = 0; i <= reps; i++) {
            if (level().isClientSide) {
                this.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);
                //       this.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);
            }
        }
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return getAttackState() != 10 || getAttackState() != 3;
    }

    @Override
    public boolean isPickable() {
        return getAttackState() != 14 || getAttackState() != 3;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isPushable() {
        return getAttackState() != 4 || getAttackState() != 10 || getAttackState() != 3;
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
        //Uppercut
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, toTicks(2.38f), 15, 5.5f) {
            @Override
            public void stop() {
                upperCutCooldown = UPPERCUT_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 16.0F
                        && getTarget() != null && upperCutCooldown <= 0 && !animationLockedForTests() && canAttack() && !isReadyForSynergyAttack();
            }
        });
        //Stab
        /*
        this.goalSelector.addGoal(1, new DoubleStabGoal(this, 0, 6, 0, toSeconds(3.88f), 0, 6) {
            @Override
            public void stop() {
                ghostComboCooldown = GHOST_COMBO_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {fb
                return super.canUse() && getRandom().nextFloat() * 100.0F < 16.0F
                        && getTarget() != null && ghostComboCooldown <= 0 && !animationLockedForTests();
            }
        });*/
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, toTicks(2.71f), 10, 6) {
            @Override
            public void stop() {
                stab_cooldown = STAB_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 16.0F
                        && getTarget() != null && stab_cooldown <= 0 && !animationLockedForTests() && !isReadyForSynergyAttack();
            }
        });
        //Ghost Combo
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, toTicks(6.46f), 63, 6) {
            @Override
            public void stop() {
                ghostComboCooldown = GHOST_COMBO_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 16.0F
                        && getTarget() != null && ghostComboCooldown <= 0 && !animationLockedForTests() && !isReadyForSynergyAttack();
            }
        });
        //Ghost Uppercut
        this.goalSelector.addGoal(1, new GhostUppercutGoal(this, 0, 4, 0, toTicks(5.58f), 70, 5) {
            @Override
            public void stop() {
                ghostUppercutCooldown = GHOST_UPPERCUT_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && ghostUppercutCooldown <= 0 && !animationLockedForTests() && !isReadyForSynergyAttack();
            }
        });
        //Grab n Throw
        this.goalSelector.addGoal(1, new BHGrabAndThrowGoal(this, 0, 11, 0, toTicks(1.08f), toTicks(1.08f), 5) {
            @Override
            public void stop() {
                //grab_and_throw_cooldown = GRAB_AND_THROW_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && grab_and_throw_cooldown <= 0 && !animationLockedForTests() && !isReadyForSynergyAttack();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 0, toTicks(5.04f), toTicks(2.58f)) {
            @Override
            public void stop() {
                grab_and_throw_cooldown = GRAB_AND_THROW_COOLDOWN;
                super.stop();

            }

        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 13, 13, 0, toTicks(0.92f), 0) {
            @Override
            public void stop() {
                grab_and_throw_cooldown = GRAB_AND_THROW_COOLDOWN;
                super.stop();

            }
        });

        //Synergy
        this.goalSelector.addGoal(0, new BHSynergyStateGoal(this, 10, 10, 0, toTicks(9.92f), 100) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });

        this.goalSelector.addGoal(0, new IStateGoal(this, 5, 5, 0, 60, 0));

        this.goalSelector.addGoal(1, new IStateGoal(this, 8, 8, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });

        this.goalSelector.addGoal(0, new IAttackGoal(this, 8, 9, 0, 45, 0, 10.0F));
    }

    public boolean animationLockedForTests() {
        return false;
    }

    @Override
    public @NotNull AABB getBoundingBoxForCulling() {
        return getBoundingBox().inflate(12);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 195)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 14D)
                .add(Attributes.ARMOR_TOUGHNESS, 4)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState upperCutAnimationState = new AnimationState();

    public AnimationState ghostComboAnimationState = new AnimationState();

    public AnimationState ghostUppercutAnimationState = new AnimationState();

    public AnimationState stabDoubleAnimationState = new AnimationState();

    public AnimationState stabAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState sleepAnimationState = new AnimationState();

    public AnimationState awakenAnimationState = new AnimationState();

    public AnimationState synergyAnimationState = new AnimationState();

    public AnimationState grabAndThrowAnimationState = new AnimationState();
    public AnimationState grabAndThrowSuccessAnimationState = new AnimationState();
    public AnimationState grabAndThrowFailAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "uppercut") {
            return this.upperCutAnimationState;
        }
        if (input == "ghost_combo") {
            return this.ghostComboAnimationState;
        }
        if (input == "ghost_uppercut") {
            return this.ghostUppercutAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "stab_double") {
            return this.stabDoubleAnimationState;
        }
        if (input == "stab") {
            return this.stabAnimationState;
        }
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awaken") {
            return this.awakenAnimationState;
        }
        if (input == "synergy") {
            return this.synergyAnimationState;
        }
        if (input == "grab_and_throw") {
            return this.grabAndThrowAnimationState;
        }
        if (input == "grab_and_throw_success") {
            return this.grabAndThrowSuccessAnimationState;
        }
        if (input == "grab_and_throw_fail") {
            return this.grabAndThrowFailAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    public int attackDelayTicksValue() {
        return canSynergyAttack() ? 5 : 0;
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
                        this.upperCutAnimationState.startIfStopped(this.tickCount);

                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.ghostComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.ghostUppercutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.stabDoubleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.stabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.awakenAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.synergyAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.grabAndThrowAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.grabAndThrowSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.grabAndThrowFailAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        upperCutAnimationState.stop();
        idleAnimationState.stop();
        ghostComboAnimationState.stop();
        ghostUppercutAnimationState.stop();
        deathAnimationState.stop();
        stabDoubleAnimationState.stop();
        stabAnimationState.stop();
        sleepAnimationState.stop();
        awakenAnimationState.stop();
        synergyAnimationState.stop();
        grabAndThrowSuccessAnimationState.stop();
        grabAndThrowAnimationState.stop();
        grabAndThrowFailAnimationState.stop();
    }

    public boolean canSynergyAttack() {
        return (synchronisedDuoKnight() != null && getIsDuoFight() && synchronisedDuoKnight().getAttackState() == 0 && synergyCooldown == 0 && synchronisedDuoKnight().synergyCooldown == 0);
    }

    public boolean shouldAttack = true;


    public boolean getIsDuoFight() {
        return synchronisedDuoKnight() != null && synchronisedDuoKnight().isAlive() && distanceTo(synchronisedDuoKnight()) <= 10;
    }

    public ResurrectedKnightEntity syncedEntity = null;

    public ResurrectedKnightEntity synchronisedDuoKnight() {
        return syncedEntity;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 8 : 0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 8 || this.getAttackState() == 9;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(TEXTURE_VARIANT, 1);
    }

    public int getTextureVariant() {
        return entityData.get(TEXTURE_VARIANT);
    }

    public void setTextureVariant(int textureVariant) {
        entityData.set(TEXTURE_VARIANT, textureVariant);
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

    public boolean hasGhostArm() {
        return getAttackState() == 3 || getAttackState() == 4 || getAttackState() == 10;
    }

    public ControlledAnim armFade = new ControlledAnim(10);

    public ControlledAnim telegraphFadeAway = new ControlledAnim(10);

    public boolean canAttack() {
        return shouldAttack;
    }

    public boolean isReadyForSynergyAttack() {
        return getIsDuoFight() && synchronisedDuoKnight().synergyCooldown <= 0;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (isSleep()) return false;
        return super.hurt(pSource, pAmount);
    }

    public void setRGB(float r, float g, float b) {
        getR = r / 255;
        getG = g / 255;
        getB = b / 255;
    }

    public float getR;
    public float getG;
    public float getB;

    public void UpdateWithAttack() {
        switch (getTextureVariant()) {
            // 1 iron
            // 2 gold
            //3 diamond

            case 0 -> setRGB(203, 212, 214);
            case 1 -> setRGB(203, 212, 214);
            case 2 -> setRGB(234, 238, 87);
            case 3 -> setRGB(161, 251, 232);
        }
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
        float sweepShakeAmount = 0.075f;
        int duration = 10;
        float swordWidth = -1f;

        //Uppercut
        if (getAttackState() == 2) {
            int upperCut = 18;
            if (attackTicks == upperCut - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, -90, false);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == upperCut) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 220, -90, 0, 17, 100, false, true, 0.5f, 0.75f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
        }
        //Ghost Uppercut
        if (getAttackState() == 4) {
            int upperCut = 22;
            int slash1 = 52;
            int slash2 = 55;
            int disappearTick = 100;
            int ARC = 120;

            if (attackTicks == 2) {
                armFade.setTimer(5);
                telegraphFadeAway.resetTimer();
            }

            if (attackTicks >= 3 && attackTicks <= 100 && armFade.getTimer() > 0) {
                armFade.decreaseTimer();
            }
            if (attackTicks == disappearTick - 2) armFade.setTimer(0);
            if (attackTicks >= disappearTick) {
                armFade.increaseTimer();
            }
            if (attackTicks >= 35) telegraphFadeAway.increaseTimer();

            if (attackTicks == upperCut - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, -70, true);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1.25f);
                calculatedDash(0.25f);
            }
            if (attackTicks == upperCut) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 220, -90, 0, 15, 100, false, true, 0.5f, 0.75f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }

            if (attackTicks == slash1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, 0, false);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                basicDash(2, 2, true);
                //  calculatedDash(0.25f);
            }

            if (attackTicks == slash1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, ARC, 0, 0, 17, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }

            if (attackTicks == slash2 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, 0, true);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                basicDash(2, 2, true);
            }
            if (attackTicks == slash2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, ARC, 0, 0, 15, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks >= slash1 - 3 && attackTicks < slash2) {
                if (tickCount % 3 == 0) {
                    // spawnSoulPillar(-1, 0, 1);

                    spawnSoulPillar(-1, 2, 1);

                    //   spawnSoulPillar(-1, -2, 1);
                }
            }
        }
        //Ghost Combo
        if (getAttackState() == 3) {
            int headSlash1 = 26;
            int headSlash2 = 40;
            int swordSlash = 45;
            int swordSlam = 75;
            int headSlam = 81;
            if (attackTicks == 2) armFade.setTimer(5);
            if (attackTicks >= 3 && attackTicks <= 100 && armFade.getTimer() > 0) {
                armFade.decreaseTimer();
            }
            if (attackTicks == 98) armFade.setTimer(0);
            if (attackTicks >= 100) {
                armFade.increaseTimer();
            }
            // System.out.println("GetTimer: " + armFade.getTimer() + " Difference: " + (1 - Math.min(armFade.getAnimationFraction(), 1)));
            if (attackTicks == headSlash1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, 20, true);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1.25f);
                calculatedDash(0.25f);
            }
            if (attackTicks == headSlash1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 180, 0, 0, 15, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == headSlash2 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, 20, true);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1.25f);
                calculatedDash(0.25f);
            }
            if (attackTicks == headSlash2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 180, 0, 0, 15, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }

            if (attackTicks == swordSlash - 3) {

                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, 20, false);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                calculatedDash(0.15f);
            }

            if (attackTicks == swordSlash) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.25f, 5, 180, 0, 0, 17, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == 67 && targetIsNotNull())
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            if (attackTicks == swordSlam - 3) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    this.level().addParticle(new BeheadedKnightSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch, getR, getG, getB), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                calculatedDashToPositon(0.2f, lastTargetPos());
            }
            if (attackTicks == headSlam - 3) {

                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1.25f);
                basicDash(1, 3, true);
            }
            if (attackTicks == swordSlam) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 5, 5);
                StraightLineAreaAttack(swordWidth, 2f, 5.5f, 120, 17, true, 0.5f, 0.4f);
            }
            if (attackTicks == headSlam) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 5, 5);
                StraightLineAreaAttack(swordWidth, 2f, 5.5f, 120, 15, true, 0.5f, 0.4f);
            }

        }
        //Double Stab
        if (getAttackState() == 6) {
            int stab1 = 21;
            int stab2 = 45;
            if (attackTicks == 15 && targetIsNotNull())
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            if (attackTicks == stab1 - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.9f);
            }
            if (attackTicks == stab1) {
                StraightLineAreaAttack(swordWidth, 2f, 5.5f, 120, 17, true, 0.5f, 0.4f);
            }

            if (attackTicks == 40 && targetIsNotNull())
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            if (attackTicks == stab2 - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.9f);
            }
            if (attackTicks == stab2) {
                StraightLineAreaAttack(swordWidth, 2f, 5.5f, 120, 17, true, 0.5f, 0.4f);
            }

        }
        if (getAttackState() == 7) {
            int stab1 = 25;
            if (attackTicks == 10 && targetIsNotNull())
                saveTargetPos(target().getX(), target().getY(), target().getZ());
            if (attackTicks == stab1 - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.75f);
            }

            if (attackTicks == stab1) {
                StraightLineAreaAttack(swordWidth, 2f, 5.5f, 120, 17, true, 1, 0.2f);
            }
        }
        //Synergy
        if (getAttackState() == 10) {

            //  System.out.println("CAN RENDER LINES: " + canRenderWarningLines() + " TIMER: " + telegraphFadeAway.getTimer() + " ATTACK TICKS:  " + attackTicks);
            int slash1 = 36;
            int slash2 = 41;
            int slash3 = 82;
            int slash4 = 86;
            int ARC = 120;
            if (attackTicks == 1) {
                telegraphFadeAway.setTimer(0);
                telegraphFadeAway.resetTimer();
            }
            if (attackTicks == 2) {
                telegraphFadeAway.resetTimer();
                armFade.setTimer(5);
            }
            if (attackTicks >= 5 && attackTicks <= 183 && armFade.getTimer() > 0) {
                armFade.decreaseTimer();
            }
            if (attackTicks == 182) armFade.setTimer(0);
            if (attackTicks >= 183) {
                armFade.increaseTimer();
            }


            if (attackTicks == slash1 - 3 || attackTicks == slash4 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, 0, false);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                basicDash(2, 2, true);
                //  calculatedDash(0.25f);
            }

            if (attackTicks == slash1 || attackTicks == slash4) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, ARC, 0, 0, 17, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }

            if (attackTicks == slash2 - 3 || attackTicks == slash3 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, 0, true);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                basicDash(2, 2, true);
            }
            if (attackTicks == slash2 || attackTicks == slash3) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, ARC, 0, 0, 15, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }

            if ((attackTicks >= slash1 - 3 && attackTicks < slash2) || (attackTicks >= slash3 - 3 && attackTicks < slash4)) {
                if (tickCount % 3 == 0) {
                    spawnSoulPillar(-1, 2, 1);
                }
            }
            if (attackTicks == 115) setNoGravity(true);
            if (attackTicks >= 115 && attackTicks <= 125) {
                setDeltaMovement(getDeltaMovement().x, 0.25f, getDeltaMovement().z);
                //   attractParticles(ModParticles.GHOSTLY_SOUL.get(),7,5,0,0,0,0,0,5,0.1f);
                int ucap = 5;
                float v = 0.075f;
                float endY = 5;
                float startY = 3;
                attractParticles(ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 5, endY, v);
                attractParticles(ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 3, endY, v);
                attractParticles(ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 2, endY, v);
            }
            if (attackTicks == 115) {
                playSound(ModSounds.OMINOUS_WIND_UP.get(), 1, 1);
            }
            if (attackTicks == 135) {
                setNoGravity(false);
                if (targetIsNotNull()) {
                    Vec3 start = position();
                    Vec3 end = target().position();

                    Vec3 sub = end.subtract(start);
                    Vec3 normal = sub.normalize();

                    setDeltaMovement(normal.x, normal.y, normal.z);
                } else setDeltaMovement(getDeltaMovement().x, -0.5f, getDeltaMovement().z);
            }

            if (attackTicks == 145) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 10, 10);
                playSound(ModSounds.STAB_HIT.get(), 1, 1);
                SideAreaAttack(2.75f, 3, 360, 0, 2, 18, 150, false, true, 1, 0.5f, ModSounds.EMPTY, 0);
                xPillars(6, 3, 8);
                spawnCircleParticle(0, 0, 100, true, 2, 0.25f, 1, 0.75f, 0.8f, Circle.EnumRingBehavior.GROW, 30);
            }

            if (attackTicks == 15 || attackTicks == 55) telegraphFadeAway.resetTimer();
            if (((attackTicks >= 25 && attackTicks < 30) || (attackTicks >= 75 && attackTicks < 80)))
                telegraphFadeAway.increaseTimer();
        }
        //Grab n Throw
        if (getAttackState() == 11) {
            if (attackTicks == 1) grab = false;
            int grab = 20;
            if (attackTicks == grab - 4 && synchronisedDuoKnight() != null && synchronisedDuoKnight().isAlive()) {
                saveTargetPos(synchronisedDuoKnight().getX(), synchronisedDuoKnight().getY(), synchronisedDuoKnight().getZ());
            }
            if (attackTicks == grab - 3) {
                playSound(ModSounds.PLAYER_ATTACK_SWEEP, 1, 0.5f);
                calculatedDashToPositon(0.25f, lastTargetPos());
            }
            if (attackTicks == grab) {
                SyncedKnightGrab(4, 4, 180, 0, 0);
            }

        }
        //Success
        if (getAttackState() == 12) {
            int Rattack = 29;
            int attack = 31;
            if (attackTicks == Rattack - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, 0, true);
                calculatedDash(0.25f);
            }
            if (attackTicks == Rattack) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 180, 0, 0, 17, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == attack - 3) {
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, 0, false);
                //calculatedDash(0.2f);
            }
            if (attackTicks == 33) {
                advancedDash(this, -3f, 2.5f, 1f);
            }
            if (attackTicks == attack) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, sweepShakeAmount, 0, duration);
                SideAreaAttack(3.5f, 5, 180, 0, 0, 17, 100, false, true, 0.5f, 0f, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 0.75f);
            }
            if (attackTicks == 57) {
                //  ejectPassengers();
                if (targetIsNotNull()) {
                    if (getFirstPassenger() != null && getFirstPassenger() instanceof ResurrectedKnightEntity livingEntity)
                        throwAnGravityEntity(1,
                                target().getX(), target().getY(),
                                target().getZ(), getX(), getY() + 3, getZ(),
                                8, livingEntity);
                }
            }
        }
    }

    public boolean canRenderWarningLines() {
        return ((attackTicks >= 25 && attackTicks <= 40) && getAttackState() == 4) || (getAttackState() == 10 && ((attackTicks >= 15 && attackTicks <= 30) || (attackTicks >= 55 && attackTicks <= 80)
        ));
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

    private void xPillars(int pillar, double delay, float distance) {
        for (int i = 0; i < pillar; ++i) {
            float throwAngle = (float) i * 3.1415927F / (float) (pillar / 2);
            for (int k = 0; k < distance; ++k) {
                double d2 = 1.15 * (double) (k + 1);
                int d3 = (int) (delay * (double) (k + 1));
                this.spawnSoulPillars(this.getX() + (double) Mth.cos(throwAngle) * 1.25 * d2, getY(), this.getZ() + (double) Mth.sin(throwAngle) * 1.25 * d2, this.getY() - 2, throwAngle, d3, level(), this);
            }
        }

    }

    private boolean spawnSoulPillars(double x, double y, double z, double lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
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
                this.level().addParticle(new BeheadedKnightSweepParticle.SweepData(this.getScale() * scale, yaw, pitch, getR, getG, getB), d0, d1, d2, 0, 0, 0);
            } else {
                this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);

            }
        }
    }

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float Vxz, float Vy) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, yHeight, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.BeheadedKnightDamageMultiplier.get())));
                if (flag && launch) {
                    EntityUtil.cancelBuffs(entityHit);
                    entityHit.invulnerableTime = 0;
                    launch(entityHit, Vxz, Vy);
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
                            this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.BeheadedKnightDamageMultiplier.get())));

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

    public List<ResurrectedKnightEntity> getResurrectedKnightBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getResurrectedKnightEntitiesNearby(ResurrectedKnightEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getResurrectedKnightEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double) this.distanceTo(e) <= r + (double) (e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }

    public boolean grab = false;

    public void SyncedKnightGrab(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset
    ) {
        double theta = Math.toRadians(this.yBodyRot) + Math.PI / 2;
        double forwardX = Math.cos(theta) * forwardOffset;
        double forwardZ = Math.sin(theta) * forwardOffset;

        List<ResurrectedKnightEntity> entitiesHit = this.getResurrectedKnightBaseNearby(range, height, range, range);
        for (ResurrectedKnightEntity entityHit : entitiesHit) {
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
                //   System.out.println("SYNC: " + synchronisedDuoKnight() + " entityHIT" + entityHit);
                if (entityHit == synchronisedDuoKnight()) {
                    //   System.out.println("WORKS");
                    grab = entityHit.startRiding(this);

                }
            }
        }
    }

    public void throwAnGravityEntity(float velocity, double destX, double destY, double destZ, double x, double y, double z, float damage, ResurrectedKnightEntity passenger) {
        if (passenger != null) {
            ThrownResurrectedKnightEntity thrownEntity = new ThrownResurrectedKnightEntity(this.level(), this, x, y, z, damage, 1, passenger);

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

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.BeheadedKnightHealthMutliplier.get());
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(5);
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

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();
    }
}
