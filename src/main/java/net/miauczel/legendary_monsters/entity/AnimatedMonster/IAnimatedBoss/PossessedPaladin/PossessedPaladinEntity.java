package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSweepParticle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSweepRedParticle;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.FallingSoulBladeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulBladeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulShieldEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.goal.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.item.ItemEntity;
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
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static net.miauczel.legendary_monsters.util.MathUtils.rotateYaw;
import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class PossessedPaladinEntity extends IAnimatedBoss {
    private static final Logger log = LoggerFactory.getLogger(PossessedPaladinEntity.class);

    private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(PossessedPaladinEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Boolean> AWAKENED = SynchedEntityData.defineId(PossessedPaladinEntity.class, EntityDataSerializers.BOOLEAN);

    public PossessedPaladinEntity(EntityType entity, Level world) {
        super(entity, world);
        xpReward = 100;
        lastTargetX = getX();
        lastTargetY = getY();
        lastTargetZ = getZ();
        setMaxUpStep(2);
        this.setPersistenceRequired();
    }

    /// data
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(PHASE, 1);
        entityData.define(AWAKENED, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("phase", getPhase());

        pCompound.putBoolean("is_Sleep", isSleep());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setPhase(pCompound.getInt("phase"));
        setSleep(pCompound.getBoolean("is_Sleep"));
    }

    public boolean getIsSecondPhase() {
        return entityData.get(PHASE) == 2;
    }

    public void setPhase(int phase) {
        entityData.set(PHASE, phase);
    }

    public int getPhase() {
        return entityData.get(PHASE);
    }

    public void setAwakened(boolean phase) {
        entityData.set(AWAKENED, phase);
    }

    public boolean getIsAwakened() {
        return entityData.get(AWAKENED);
    }

    @Override
    public void push(Entity entityIn) {
        if (getAttackState() == 20) {

        } else super.push(entityIn);
    }

    public boolean canBreakBlocks() {
        return getAttackState() == 30 || getAttackState() == 29 || getAttackState() == 23;
    }

    @Override
    public void push(double pX, double pY, double pZ) {
        if (getAttackState() == 20) {

        } else super.push(pX, pY, pZ);
    }

    /// Boss
    private final LMBossInfoServer bossInfo = new LMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.RED, false, 2);

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    /// Cooldowns
    public final int PARRY_COOLDOWN = toTicks(5);
    public int parry_cooldown = PARRY_COOLDOWN;


    public final int FLY_AWAY_COOLDOWN = toTicks(4);
    public int fly_away_cooldown = 0;

    public final int THROW_COOLDOWN = toTicks(5);
    public int throw_cooldown = 0;


    public final int STAB_GRAB_COOLDOWN = toTicks(10);
    public int stab_grab_cooldown = 0;

    public final int SLAM_COOLDOWN = toTicks(6);
    public int slam_cooldown = 0;


    public final int FLIP_SMASH_COOLDOWN = toTicks(4);
    public int flip_smash_cooldown = 0;

    public final int SIDE_ROLL_SPIN_COOLDOWN = toTicks(4);
    public int side_roll_spin_cooldown = 0;

    public final int BACKSTEP_COOLDOWN = toTicks(2);
    public int backstep_cooldown = 0;

    public final int SLASH_FROM_COOLDOWN = toTicks(1);
    public int slash_from_cooldown = 0;

    public final int DOUBLE_SLASH_COOLDOWN = toTicks(3);
    public int double_slash_cooldown = 0;

    public final int JUMP_COOLDOWN = toTicks(6);//6
    public int jump_cooldown = 0;


    public final int SHIELD_SMASH_COOLDOWN = toTicks(6);
    public int shield_smash_cooldown = 0;

    public final int FINISHER_COOLDOWN = toTicks(16);
    public int finisher_cooldown = 0;

    public final int TRIDENT_THROW_SPIN = toTicks(8);
    public int trident_throw_spin = 0;

    public final int TICKS_WITHOUT_TARGET = 40;
    public int ticksWithoutTarget = TICKS_WITHOUT_TARGET;

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public void tick() {
        super.tick();
        if (canBreakBlocks()) {
            if (!this.level().isClientSide) {
                if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    this.destroy();
                }
            }
        }
        if (tickCount % 1 == 0) {
            BlockPos pos = BlockUtils.blockPosVec3(position()).below();
            BlockState state = this.level().getBlockState(pos);

            // ParticleUtils.controlledSmashParticles(this, 0, 0, 0, 1.5f, 3);
            //level.sendParticles((new BlockParticleOption(ParticleTypes.BLOCK, state)).setPos(pos), d0, d1, d2, j, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.15F);


            //  if (level() instanceof ServerLevel level) level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), vec3.x,vec3.y,vec3.z, i,0.3f,0.3F, 0.3F,0.15f);

            //spawnChainedStrike(0, 0, 3, 3,15);
            //  spawnSpiralStrike(25, 0.3, 0.5f, 0, 0.75f);
        }
        if (ticksWithoutTarget == 0 && getTarget() == null && ModConfig.MOB_CONFIG.canBossesResetPhases.get()) {
            if (getIsSecondPhase() && (getCrackiness() == Crackiness.NONE || getCrackiness() == Crackiness.LOW)) {
                setPhase(1);
            }
        }

        if (level().isClientSide) idleAnimationState.animateWhen(getAttackState() == 0, tickCount);
        //   System.out.println("Attack: " + getAttackState());
        boolean b = getPhase() >= 2;
        if (!isSleep() && !bossInfo.isVisible()) bossInfo.setVisible(true);
        //System.out.println("PHASE: " + getPhase() + " " + b);

        if (!this.level().isClientSide()) {
            if (bossInfo.getRenderType() == 2 && getIsSecondPhase()) {
                bossInfo.setRenderType(4);
                if (getAttackState() != 26 && getAttackState() != 36 && getAttackState() != 37)
                    bossInfo.setName(Component.translatable("legendary_monsters.bar_name.possessed_paladin_p2"));
            }
            if (bossInfo.getName().equals("legendary_monsters.bar_name.possessed_paladin_p2") && getPhase() == 1) {
                bossInfo.setName(getName());
            }
            if (bossInfo.getRenderType() == 4 && !getIsSecondPhase()) {
                bossInfo.setRenderType(2);
                bossInfo.setName(getName());
            }

        }
        if (!bossInfo.getIsDarkenSky() && getIsSecondPhase()) {
            bossInfo.setDarkenScreen(true);
        }

        if (bossInfo.getIsDarkenSky() && !getIsSecondPhase()) {
            bossInfo.setDarkenScreen(false);
        }
        if (isVehicle()) {
            if (getFirstPassenger() != null) {
                getFirstPassenger().setShiftKeyDown(false);
            }
        }

        if (getAttackState() != 20 && getAttackState() != 19) ejectPassengers();
        // System.out.println("canParry: " + canParry() + "attackState: " + getAttackState());
        if (parry_cooldown > 0) parry_cooldown--;
        if (slam_cooldown > 0) slam_cooldown--;
        if (fly_away_cooldown > 0) fly_away_cooldown--;
        if (backstep_cooldown > 0) backstep_cooldown--;
        if (flip_smash_cooldown > 0) flip_smash_cooldown--;
        if (throw_cooldown > 0) throw_cooldown--;
        if (slash_from_cooldown > 0) slash_from_cooldown--;
        if (double_slash_cooldown > 0) double_slash_cooldown--;
        if (stab_grab_cooldown > 0) stab_grab_cooldown--;
        if (jump_cooldown > 0) jump_cooldown--;
        if (shield_smash_cooldown > 0) shield_smash_cooldown--;
        if (side_roll_spin_cooldown > 0) side_roll_spin_cooldown--;

        if (finisher_cooldown > 0) finisher_cooldown--;

        if (trident_throw_spin > 0) trident_throw_spin--;
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (!level().isClientSide)
            regainHealthWithoutTarget(20, 15);

        if (!level().isClientSide && BossInvulnerabilityTime > 0) BossInvulnerabilityTime--;
    }

    public void regainHealthWithoutTarget(float health, float speed) {
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

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide()) this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        UpdateWithAttack();
    }

    public PossessedPaladinEntity.Crackiness getCrackiness() {
        return PossessedPaladinEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.65F),
        HIGH(0.30F);

        private static final List<PossessedPaladinEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static PossessedPaladinEntity.Crackiness byFraction(float pFraction) {
            for (PossessedPaladinEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }

    int SideRollSpinRandom = 16;
    int FinisherRandom = 25;
    int DoubleSlashRandom = 10;
    int SlashFromRandom = 15;
    int ShieldSmashRandom = 15;
    int JumpRandom = 10;
    int backflipRandom = 10;
    int throwRandom = 10;
    int slamRandom = 10;
    int flipSmashRandom = 10;

    int throwTridentSpinRandom = 15;

    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));

        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        /// Second Phase
        this.goalSelector.addGoal(0, new P_PSecondPhaseStateGoal(this, 0, 26, 0, toTicks(7.38f), 0) {
            @Override
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
        /// DOUBLE SLASH
        this.goalSelector.addGoal(1, new P_PAttackGoal(this, 0, 2, 0, 68, 68, 5.0F, false, 10) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < DoubleSlashRandom && !animationLockedForTests()
                        && target != null && getNextDoubleSlashType() == 1 && double_slash_cooldown <= 0;
            }

            @Override
            public void stop() {

                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
            }
        });
        //WithSlam
        this.goalSelector.addGoal(1, new DoubleSlashSlamAttackGoal(this, 0, 3, 0, toTicks(3.46f), 55, 5.0F, false, 10) {//5.04f
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < DoubleSlashRandom && !animationLockedForTests()
                        && target != null && getNextDoubleSlashType() == 2 && double_slash_cooldown <= 0;
            }

            @Override
            public void stop() {
                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
            }
        });
        /// SLAM
        this.goalSelector.addGoal(1, new SlamAttackGoal(this, 0, 6, 0, toTicks(1.54f), 20, 7F, false, 10) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < slamRandom && !animationLockedForTests() && slam_cooldown <= 0
                        && target != null;
            }

            @Override
            public void stop() {
                slam_cooldown = SLAM_COOLDOWN;
                super.stop();
            }
        });

        this.goalSelector.addGoal(0, new P_PStateGoal(this, 8, 8, 0, toTicks(3.38f), 18, true, 50) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                parry_cooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 31, 31, 0, toTicks(4.17f), 18, true, 50) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                parry_cooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 7, 7, 0, toTicks(1.29f), 0, true, 50) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                parry_cooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        /// PARRY
        this.goalSelector.addGoal(0, new IStateGoal(this, 5, 5, 0, toTicks(2.92f), toTicks(3.71f)) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                hasParried = false;
                parry_cooldown = PARRY_COOLDOWN;
                super.stop();
            }
        });
        /// ALERTED STATE
        this.goalSelector.addGoal(1, new AlertedGoal(this, 9, 9, 0, 20, 20, false, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        /// BACKFLIP
        this.goalSelector.addGoal(1, new P_PAttackGoal(this, 0, 10, 0, toTicks(1.42f), 20, 5F, true, 35) {//1.42f or 0.88f
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < backflipRandom && !animationLockedForTests() && backstep_cooldown <= 0
                        && target != null;
            }

            @Override
            public void stop() {
                backstep_cooldown = BACKSTEP_COOLDOWN;
                super.stop();

            }
        });

        //End
        /*this.goalSelector.addGoal(0, new P_PStateGoal(this, 27, 27, 0, toSeconds(0.88f), 10, true, 35) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                backstep_cooldown = BACKSTEP_COOLDOWN;
                super.stop();
            }
        });
        //Double
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 26, 26, 0, toSeconds(1.46f), 30, true, 35) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                backstep_cooldown = BACKSTEP_COOLDOWN;
                super.stop();
            }
        });
        /// FLY AWAY SLASH
        /*this.goalSelector.addGoal(1, new P_PAttackGoal(this, 0, 11, 0, toSeconds(3.46f), 20, 5F, true, 35) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < 16.0F && fly_away_cooldown <= 0
                        && target != null;
            }

            @Override
            public void stop() {
                fly_away_cooldown = FLY_AWAY_COOLDOWN;
                super.stop();
            }
        });*/
        /// TRIDENT THROW SPIN
        this.goalSelector.addGoal(1, new P_PAttackGoal(this, 0, 38, 0, toTicks(5.42f), 72, 16F, true, 35) {
            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < throwTridentSpinRandom && trident_throw_spin <= 0 && getPhase() >= 2
                        && target != null && distanceTo(target()) >= 7;
            }

            @Override
            public void stop() {
                trident_throw_spin = TRIDENT_THROW_SPIN;
                super.stop();

            }
        });
        /// FLIP SMASH
        this.goalSelector.addGoal(1, new FlipSmashGoal(this, 0, 12, 0, toTicks(1.63f), 13, 16F, false, 10) {//ast
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < flipSmashRandom && !animationLockedForTests() && flip_smash_cooldown <= 0
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });

        this.goalSelector.addGoal(0, new P_PStateGoal(this, 13, 13, 0, toTicks(1.04f), 20, true, 35) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                flip_smash_cooldown = FLIP_SMASH_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 14, 14, 0, toTicks(2.38f), 8, true, 35) {//ast11
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                flip_smash_cooldown = FLIP_SMASH_COOLDOWN;
                super.stop();
            }
        });
        /// THROW
        this.goalSelector.addGoal(1, new ThrowDaggersGoal(this, 0, 15, 0, toTicks(2.04f), 30, 12.0F, true, 25) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < throwRandom && !animationLockedForTests() && throw_cooldown <= 0 && getPhase() < 2
                        && target != null;
            }

            @Override
            public void stop() {
                throw_cooldown = THROW_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new ThrowDaggersGoal(this, 0, 28, 0, toTicks(3.5f), 50, 12.0F, true, 25) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < throwRandom && !animationLockedForTests() && throw_cooldown <= 0 && getPhase() >= 2
                        && target != null;
            }

            @Override
            public void stop() {
                throw_cooldown = THROW_COOLDOWN;
                super.stop();
            }
        });
        /// SLASH FROM
        this.goalSelector.addGoal(1, new SlashFromGoal(this, 0, 16, 0, 20, 20, 5F, false, 10) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < SlashFromRandom &&
                        slash_from_cooldown <= 0
                        && target != null && !animationLockedForTests();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });

        this.goalSelector.addGoal(0, new P_PStateGoal(this, 18, 18, 0, toTicks(2.5f), 10, true, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });


        this.goalSelector.addGoal(0, new P_PStateGoal(this, 17, 17, 0, 30, 11, true, 15) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });

        /// STAB GRAB STATES
        this.goalSelector.addGoal(0, new StabGrabGoal(this, 19, 19, 0, 28, 20, false, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });
        //Success
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 20, 20, 0, toTicks(7.5f), 0, true, 25) {
            public void start() {
                succedGrabbing = false;
                super.start();
            }

            @Override
            public void stop() {
                stab_grab_cooldown = STAB_GRAB_COOLDOWN;
                succedGrabbing = false;
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });
        //Fail
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 21, 21, 0, toTicks(1.5f), 0, true, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                stab_grab_cooldown = STAB_GRAB_COOLDOWN;
                succedGrabbing = false;
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });
        //Fail Stab
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 33, 33, 0, toTicks(2.63f), 12, false, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                stab_grab_cooldown = STAB_GRAB_COOLDOWN;
                succedGrabbing = false;
                slash_from_cooldown = SLASH_FROM_COOLDOWN;
                super.stop();
            }
        });
        //JUMP
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 22, 23, toTicks(1.67f), toTicks(1.67f), 16F, 6) {

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < JumpRandom && jump_cooldown <= 0 && !animationLockedForTests()
                        && getTarget() != null;
            }
        });

        //jump idle
        this.goalSelector.addGoal(1, new JumpFallGoal(this, 23, 23, 24, 100, 0, false, 0));

        //jump End
        this.goalSelector.addGoal(0, new P_PStateGoal(this, 24, 24, 0, toTicks(3.25f), 0, true, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
                jump_cooldown = JUMP_COOLDOWN;
            }
        });
        //Jump Combo
        this.goalSelector.addGoal(0, new JumpSmashComboGoal(this, 32, 32, 0, toTicks(5.79f), 0, true, 25) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
                jump_cooldown = JUMP_COOLDOWN;
            }
        });
        //Shield Smash
        this.goalSelector.addGoal(1, new P_PAttackGoal(this, 0, 25, 0, toTicks(5.04f), toTicks(3.75f), 6F, false, 0) {

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < ShieldSmashRandom
                        && getTarget() != null && shield_smash_cooldown <= 0 && !animationLockedForTests();
            }

            @Override
            public void stop() {
                shield_smash_cooldown = SHIELD_SMASH_COOLDOWN;
                super.stop();
            }
        });
        // SideRollSpin
        this.goalSelector.addGoal(1, new SideRollSpinGoal(this, 0, 29, 0, toTicks(4.88f), 0, 6F, true, 10) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < SideRollSpinRandom && side_roll_spin_cooldown <= 0 && getNextSideRollSpinType() == 1 && !animationLockedForTests()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();

                side_roll_spin_cooldown = SIDE_ROLL_SPIN_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new SideRollSpinGoal(this, 0, 30, 0, toTicks(4.88f), 0, 6F, true, 10) {
            public boolean canUse() {

                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < SideRollSpinRandom && side_roll_spin_cooldown <= 0 && getNextSideRollSpinType() == 2 && !animationLockedForTests()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
                side_roll_spin_cooldown = SIDE_ROLL_SPIN_COOLDOWN;
            }
        });
        //Finisher
        this.goalSelector.addGoal(1, new FinisherAttackGoal(this, 0, 37, 0, toTicks(16.33f), 0, 7f, false, 0) {
            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 100.0F < FinisherRandom && finisher_cooldown <= 0 && getPhase() >= 2 && !animationLockedForTests()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
                finisher_cooldown = FINISHER_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 34, 34, 35, 0, 0) {
                    @Override
                    public boolean canContinueToUse() {
                        return super.canContinueToUse() && !getIsAwakened();
                    }

                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IStateGoal(this, 35, 35, 0, toTicks(10.21f), 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }
        );
        this.goalSelector.addGoal(0, new IStateGoal(this, 36, 36, 0, toTicks(12), 0));
    }

    public void throwSoulTrident(LivingEntity pTarget, float v) {
        SoulTridentEntity soulTrident = new SoulTridentEntity(this.level(), this, new ItemStack(Items.TRIDENT));
        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - soulTrident.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        soulTrident.shoot(d0, d1 + d3 * (double) 0.2F, d2, v, (float) (14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0F, 0.75F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(soulTrident);
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState DoubleSlashAnimationState = new AnimationState();
    public AnimationState DoubleSlashEndAnimationState = new AnimationState();
    public AnimationState DoubleSlashSlamEndAnimationState = new AnimationState();
    public AnimationState ParryAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState SwordSlamAnimationState = new AnimationState();
    public AnimationState SwordSlamEndAnimationState = new AnimationState();
    public AnimationState SwordSlamCounterEndAnimationState = new AnimationState();

    public AnimationState SwordSlamCounterReleaseAnimationState = new AnimationState();

    public AnimationState AllertedAnimationState = new AnimationState();
    public AnimationState BackflipAnimationState = new AnimationState();
    public AnimationState BackflipEndAnimationState = new AnimationState();
    public AnimationState BackflipDoubleAnimationState = new AnimationState();

    public AnimationState FlyAwaySlashAnimationState = new AnimationState();

    public AnimationState FlipSmashAnimationState = new AnimationState();
    public AnimationState FlipSmashEndAnimationState = new AnimationState();
    public AnimationState FlipSmashFlipAnimationState = new AnimationState();

    public AnimationState SlashFromAnimationState = new AnimationState();
    public AnimationState SlashFromEndAnimationState = new AnimationState();
    public AnimationState SlashFromStabAnimationState = new AnimationState();


    public AnimationState SlashFromStabGrabAnimationState = new AnimationState();
    public AnimationState SlashFromStabGrabFailAnimationState = new AnimationState();
    public AnimationState SlashFromStabGrabStabFailAnimationState = new AnimationState();
    public AnimationState SlashFromStabGrabSuccessAnimationState = new AnimationState();

    public AnimationState ThrowAnimationState = new AnimationState();

    public AnimationState ThrowDoubleAnimationState = new AnimationState();

    public AnimationState JumpPreAnimationState = new AnimationState();
    public AnimationState JumpFallAnimationState = new AnimationState();
    public AnimationState JumpSmashAnimationState = new AnimationState();
    public AnimationState JumpSmashComboAnimationState = new AnimationState();


    public AnimationState ShieldSmashAnimationState = new AnimationState();

    public AnimationState SecondPhaseAnimationState = new AnimationState();

    public AnimationState SideRollSpinAnimationState = new AnimationState();

    public AnimationState LeftSideRollSpinAnimationState = new AnimationState();

    public AnimationState SleepAnimationState = new AnimationState();
    public AnimationState AwakenAnimationState = new AnimationState();

    public AnimationState DeathAnimationState = new AnimationState();
    public AnimationState FinisherAnimationState = new AnimationState();

    public AnimationState TridentThrowSpinAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "allerted") {
            return this.AllertedAnimationState;
        } else if (input == "double_slash") {
            return this.DoubleSlashAnimationState;
        } else if (input == "double_slash_end") {
            return this.DoubleSlashEndAnimationState;
        } else if (input == "double_slash_slam_end") {
            return this.DoubleSlashSlamEndAnimationState;
        } else if (input == "parry") {
            return this.ParryAnimationState;
        } else if (input == "sword_slam_cut") {
            return this.SwordSlamAnimationState;
        } else if (input == "sword_slam_end") {
            return this.SwordSlamEndAnimationState;
        } else if (input == "sword_slam_counter_end") {
            return this.SwordSlamCounterEndAnimationState;
        } else if (input == "sword_slam_counter_release") {
            return this.SwordSlamCounterReleaseAnimationState;
        } else if (input == "backflip") {
            return this.BackflipAnimationState;
        } else if (input == "fly_away_slash") {
            return this.FlyAwaySlashAnimationState;
        } else if (input == "flip_smash") {
            return this.FlipSmashAnimationState;
        } else if (input == "flip_smash_end") {
            return this.FlipSmashEndAnimationState;
        } else if (input == "flip_smash_flip") {
            return this.FlipSmashFlipAnimationState;
        } else if (input == "throw") {
            return this.ThrowAnimationState;
        } else if (input == "throw_double") {
            return this.ThrowDoubleAnimationState;
        } else if (input == "slash_from") {
            return this.SlashFromAnimationState;
        } else if (input == "slash_from_end") {
            return this.SlashFromEndAnimationState;
        } else if (input == "slash_from_stab") {
            return this.SlashFromStabAnimationState;
        } else if (input == "slash_from_stab_grab_pre") {
            return this.SlashFromStabGrabAnimationState;
        } else if (input == "slash_from_stab_grab_fail") {
            return this.SlashFromStabGrabFailAnimationState;
        } else if (input == "slash_from_stab_grab_stab_fail") {
            return this.SlashFromStabGrabStabFailAnimationState;
        } else if (input == "slash_from_stab_grab_success") {
            return this.SlashFromStabGrabSuccessAnimationState;
        } else if (input == "jump_pre") {
            return this.JumpPreAnimationState;
        } else if (input == "jump_fall") {
            return this.JumpFallAnimationState;
        } else if (input == "jump_smash") {
            return this.JumpSmashAnimationState;
        } else if (input == "shield_smash") {
            return this.ShieldSmashAnimationState;
        } else if (input == "backflip_double") {
            return this.BackflipDoubleAnimationState;
        } else if (input == "backflip_end") {
            return this.BackflipEndAnimationState;
        } else if (input == "second_phase") {
            return this.SecondPhaseAnimationState;
        } else if (input == "side_roll_spin") {
            return this.SideRollSpinAnimationState;
        } else if (input == "left_side_roll_spin") {
            return this.LeftSideRollSpinAnimationState;
        } else if (input == "jump_smash_combo") {
            return this.JumpSmashComboAnimationState;
        } else if (input == "sleep") {
            return this.SleepAnimationState;
        } else if (input == "awaken") {
            return this.AwakenAnimationState;
        } else if (input == "death") {
            return this.DeathAnimationState;
        } else if (input == "finisher") {
            return this.FinisherAnimationState;
        } else if (input == "trident_throw_spin") {
            return this.TridentThrowSpinAnimationState;
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
                        this.DoubleSlashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.DoubleSlashEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.DoubleSlashSlamEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.ParryAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.SwordSlamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.SwordSlamEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.SwordSlamCounterEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.AllertedAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.BackflipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.FlyAwaySlashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.FlipSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.FlipSmashEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.FlipSmashFlipAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.ThrowAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromStabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromStabGrabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromStabGrabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromStabGrabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.JumpPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.JumpFallAnimationState.startIfStopped(this.tickCount);
                    }
                    case 24 -> {
                        this.stopAllAnimationStates();
                        this.JumpSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 25 -> {
                        this.stopAllAnimationStates();
                        this.ShieldSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 26 -> {
                        this.stopAllAnimationStates();
                        this.SecondPhaseAnimationState.startIfStopped(this.tickCount);
                    }
                    case 27 -> {
                        this.stopAllAnimationStates();
                        this.BackflipEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 28 -> {
                        this.stopAllAnimationStates();
                        this.ThrowDoubleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 29 -> {
                        this.stopAllAnimationStates();
                        this.SideRollSpinAnimationState.startIfStopped(this.tickCount);
                    }
                    case 30 -> {
                        this.stopAllAnimationStates();
                        this.LeftSideRollSpinAnimationState.startIfStopped(this.tickCount);
                    }
                    case 31 -> {
                        this.stopAllAnimationStates();
                        this.SwordSlamCounterReleaseAnimationState.startIfStopped(this.tickCount);
                    }
                    case 32 -> {
                        this.stopAllAnimationStates();
                        this.JumpSmashComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 33 -> {
                        this.stopAllAnimationStates();
                        this.SlashFromStabGrabStabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 34 -> {
                        this.stopAllAnimationStates();
                        this.SleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 35 -> {
                        this.stopAllAnimationStates();
                        this.AwakenAnimationState.startIfStopped(this.tickCount);
                    }
                    case 36 -> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 37 -> {
                        this.stopAllAnimationStates();
                        this.FinisherAnimationState.startIfStopped(this.tickCount);
                    }
                    case 38 -> {
                        this.stopAllAnimationStates();
                        this.TridentThrowSpinAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }


    public void stopAllAnimationStates() {
        ThrowDoubleAnimationState.stop();
        this.idleAnimationState.stop();
        this.DoubleSlashAnimationState.stop();
        this.deathAnimationState.stop();
        DoubleSlashEndAnimationState.stop();
        DoubleSlashSlamEndAnimationState.stop();
        ParryAnimationState.stop();
        SwordSlamEndAnimationState.stop();
        SwordSlamCounterEndAnimationState.stop();
        SwordSlamAnimationState.stop();
        AllertedAnimationState.stop();
        BackflipAnimationState.stop();
        FlyAwaySlashAnimationState.stop();
        FlipSmashEndAnimationState.stop();
        FlipSmashFlipAnimationState.stop();
        FlipSmashAnimationState.stop();
        ThrowAnimationState.stop();
        SlashFromEndAnimationState.stop();
        SlashFromAnimationState.stop();
        SlashFromStabAnimationState.stop();
        SlashFromStabGrabSuccessAnimationState.stop();
        SlashFromStabGrabAnimationState.stop();
        SlashFromStabGrabFailAnimationState.stop();
        JumpPreAnimationState.stop();
        JumpFallAnimationState.stop();
        JumpSmashAnimationState.stop();
        BackflipDoubleAnimationState.stop();
        BackflipEndAnimationState.stop();
        ShieldSmashAnimationState.stop();
        SecondPhaseAnimationState.stop();
        SideRollSpinAnimationState.stop();
        LeftSideRollSpinAnimationState.stop();
        SwordSlamCounterReleaseAnimationState.stop();
        JumpSmashComboAnimationState.stop();
        SlashFromStabGrabStabFailAnimationState.stop();
        AwakenAnimationState.stop();
        SleepAnimationState.stop();
        DeathAnimationState.stop();
        FinisherAnimationState.stop();
        TridentThrowSpinAnimationState.stop();
    }

    public boolean canRenderTelegraph() {
        return (attackTicks >= 48 && attackTicks <= 60 && getAttackState() == 32) || (getAttackState() == 38 && attackTicks >= 48 && attackTicks <= 69);
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        if (this.level().isClientSide() && isSleep()) {
            return InteractionResult.SUCCESS;
        } else {
            if (getAttackState() == 34) {
                setAttackState(35);
                setAwakened(true);
            }
        }
        if (isSleep()) {
            return super.mobInteract(pPlayer, pHand);
        } else return InteractionResult.FAIL;
    }

    public int DoubleSlashType = 1;

    public int SideRollSpinType = 1;

    public int getNextDoubleSlashType() {
        return DoubleSlashType;
    }

    public int getNextSideRollSpinType() {
        return SideRollSpinType;
    }

    public void randomizeNextDoubleSlashType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> DoubleSlashType = 1;
            case 1 -> DoubleSlashType = 2;
        }
    }

    public void randomizeNextSideRollSpinType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> SideRollSpinType = 1;
            case 1 -> SideRollSpinType = 2;
        }
    }

    public void randomizeAttacks() {
        randomizeNextSideRollSpinType(2);
        randomizeNextDoubleSlashType(2);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 400D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.ARMOR, 12D)
                .add(Attributes.ARMOR_TOUGHNESS, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 15D);
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean damageAdaptationSystem() {
        return true;
    }

    @Override
    public int adaptationFactor() {
        return 20;
    }

    public boolean animationLockedForTests() {
        return false;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean hasDagger() {
        return getAttackState() == 15 || getAttackState() == 28;
    }

    public boolean hasShield() {
        return getAttackState() == 25;
    }

    public boolean hasTrident() {
        return getAttackState() == 37 || getAttackState() == 38;
    }

    public boolean hasWings() {
        return getAttackState() == 37;
    }

    public boolean hasHurt = false;

    public float uR = 1f;
    public float uG = 0f;
    public float uB = 0f;
    public ControlledAnim telegraphFadeAway = new ControlledAnim(15);

    public ControlledAnim ghostItemFade = new ControlledAnim(10);


    public void UpdateWithAttack() {
        float sweepSize = 2f;
        float sweepRot = 20;
        float bigSweepHeight = 3;
        float bigSweepAdditionalY = 1;
        float doubleSlashRange = 3.5f;
        float smashRange = 5f;

        float doubleSlashAttack1 = 20;
        float doubleSlashAttack2 = 36;
        float doubleSlashAttack3 = 62;
        float verticalAttackHeight = 2f;


        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        float targetf = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float targetf1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double targettheta = (yBodyRot) * (Math.PI / 180);
        targettheta += Math.PI / 2;
        double targetvecX = Math.cos(targettheta);
        double targetvecZ = Math.sin(targettheta);
        /// DOUBLE SLASH
        if (getAttackState() == 2) {
            if (attackTicks == doubleSlashAttack1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == doubleSlashAttack1) {

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 15, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == doubleSlashAttack2 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == doubleSlashAttack2) {

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 17, 100, SoundEvents.EMPTY, 1, false, 0);
            }
        }
        //With Slam
        if (getAttackState() == 3) {
            if (attackTicks == doubleSlashAttack1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == doubleSlashAttack1) {

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 15, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == doubleSlashAttack2 - 3) {

                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == doubleSlashAttack2) {

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 17, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == doubleSlashAttack3 - 5) {
                saveTargetPos();
            }
            if (attackTicks == doubleSlashAttack3 - 3) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDashToPositon(0.15f, lastTargetPos());
            }
            if (attackTicks == doubleSlashAttack3) {

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnSoulPillar(3, 0, 5);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);
                StraightLineAreaAttack(-0.35f, 2.5f, smashRange, 100, 18, true, 1.5f);
                //  SideAreaAttack(doubleSlashRange,3,180,0,0,17,100, SoundEvents.EMPTY,1);
            }
        }
        /// PARRY
        if (getAttackState() == 5) {
            if (attackTicks == 27) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            for (int i = 28; i <= 30; i++) {
                if (attackTicks == i) {
                    int d = i - 26;
                    //    SoulShockwave(0.9f,d,1.5f,2,0,0);
                }
            }
            if (attackTicks == 30) {
                throwDaggers(1f, getX(), getY(), getZ(), 6, 30, 0, 10);

                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 20, 100, SoundEvents.ANVIL_LAND, 1, true, 2);
            }
        }
        ///SLAM
        int slamAttackTick = toTicks(1.17f);
        //Pre
        if (getAttackState() == 6) {
            if (attackTicks == slamAttackTick - 5) {
                saveTargetPos();
            }
            if (attackTicks == slamAttackTick - 3) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                //   calculatedDashToPositon(0.15f, lastTargetPos());
            }
            if (attackTicks == slamAttackTick) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnSoulPillar(3, 0, 5);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);
                StraightLineAreaAttack(-0.35f, 2.5f, smashRange, 100, 18, true, 1.5f);
                //  SideAreaAttack(doubleSlashRange,3,180,0,0,17,100, SoundEvents.EMPTY,1);
            }
        }
        //Counter
        //
        int counterTick = 24;
        if (getAttackState() == 8) {
            if (attackTicks > 5 && attackTicks < 20) {

                if (targetIsNotNull()) {
                    if (tickCount % 3 == 0) spawnSoulPillar(-1, 0, 1);
                    float distance = distanceTo(target());
                    float multiplier = Math.min(distance * 0.025f, 0.15f);
                    // System.out.println("MULTIPLIER: " + multiplier);
                    this.calculatedDash(multiplier);
                }
            }
            if (attackTicks == counterTick - 4) {
                saveTargetPos();
            }
            if (attackTicks == counterTick - 3) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                // calculatedDashToPositon(0.25f, lastTargetPos());
            }

            if (attackTicks == counterTick) {

                //  SoulStrike(0f, 15, 1.5f);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnCircleParticle(1.5f, 0, 30, true, 1, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.GROW, 20);
                playSound(SoundEvents.TOTEM_USE, 1, 0.65f);
                SideAreaAttack(3.5f, 3, 100, 0, 0, 20, 100, SoundEvents.EMPTY, 1, true, 2);
                randomizedSoulStrike(3, 4, 3);
                randomizedSoulStrike(2, 3, 5);
                randomizedSoulStrike(5, 6, 2);
                ParticleUtils.controlledSmashParticles(this, 2.5f, 0, 0, 0.5f, 1);
            }
        }
        if (getAttackState() == 31) {
            if (attackTicks > 5 && attackTicks < 20) {

                if (targetIsNotNull()) {
                    if (tickCount % 3 == 0) spawnSoulPillar(-1, 0, 1);
                    float distance = distanceTo(target());
                    float multiplier = Math.min(distance * 0.025f, 0.15f);
                    this.calculatedDash(multiplier);
                }
            }
            if (attackTicks == counterTick - 4) {
                saveTargetPos();
            }
            if (attackTicks == counterTick - 3) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            }

            if (attackTicks == counterTick) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnCircleParticle(1.5f, 0, 30, true, 1, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.GROW, 20);
                playSound(SoundEvents.TOTEM_USE, 1, 0.65f);
                SideAreaAttack(3.5f, 3, 100, 0, 0, 20, 100, SoundEvents.EMPTY, 1, true, 2);
                randomizedSoulStrike(3, 4, 3);
                randomizedSoulStrike(2, 3, 5);
                randomizedSoulStrike(5, 6, 2);
                ParticleUtils.controlledSmashParticles(this, 2.5f, 0, 0, 0.5f, 1);
            }
            if (attackTicks == 45)
                spawnCircleParticle(0, 0, 100, true, 2, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.SHRINK, 30);

            if (attackTicks == 53) {
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.10f, 5, 5);
                playSound(ModSounds.WITHER_SHOOT, 1, 1);
                SoulStrike(1f, 15, 0);
            }
        }
        ///Backstep
        if (getAttackState() == 10) {
            if (attackTicks == 8) {
                backStep(-1.5f, 0.2f);
            }
        }
        if (getAttackState() == 11) {
            if (attackTicks == 12) basicDash(0.5f, 0.5f, 0, false);
            if (attackTicks == 15) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.WEAPON_SPIN.get(), 1, 0.75f);
            }

            if (attackTicks == 18) {
                SideAreaAttack(3.5f, 3, 180, 0, 0, 20, 100, SoundEvents.EMPTY, 1, false, 2);
            }

            if (attackTicks == 18) {
                backStep(-2f, 0.5f);

            }
        }

        /// FLIP
        float hitBoxWidth = 0.5f;
        if (getAttackState() == 12) {
            if (attackTicks == 6) {
                if (targetIsNotNull()) {
                    float vec = 0;
                    float offset = 2;

                    double dx = getX() + vec * vecX + f * offset;

                    double dz = getZ() + vec * vecZ + f1 * offset;
                    jumpTowardsPosition(target().getX(), target().getY(), target().getZ());
                }
            }
            if (attackTicks == 16) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
            }
            if (attackTicks == 19) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnSoulPillar(3, 0, 5);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);
                SideAreaAttack(1, 3, 70, -180, -0.5f, 18, 100, ModSounds.EMPTY, 1, true, 1.5f);

                StraightLineAreaAttack(-hitBoxWidth, verticalAttackHeight, smashRange, 100, 18, true, 1.5f);
            }
        }
        if (getAttackState() == 14) {
            if (attackTicks == 2) {
                if (targetIsNotNull()) {
                    float vec = 0;
                    float offset = 2;

                    double dx = getX() + vec * vecX + f * offset;

                    double dz = getZ() + vec * vecZ + f1 * offset;
                    jumpTowardsPosition(target().getX(), target().getY(), target().getZ());

                }
            }
            if (attackTicks == 11) {
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
            }
            if (attackTicks == 14) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 5, 10);
                spawnSoulPillar(3, 0, 5);
                playSound(ModSounds.POWERFUL_SWORD_IMPACT2.get(), 1, 1);

                SideAreaAttack(1, 3, 70, -180, -0.5f, 18, 100, ModSounds.EMPTY, 1, true, 1.5f);
                StraightLineAreaAttack(-hitBoxWidth, verticalAttackHeight, smashRange, 100, 21, true, 1.5f);
            }

        }
        int distance = targetIsNotNull() ? (int) distanceTo(target()) : 0;
        if (getAttackState() == 15) {
            if (attackTicks == 10) {
                backStep(-1f, 0);
                //  basicDash(1, 0, false);
            }
            if (attackTicks == 12) {
                throwDaggers(1f, getX(), getY(), getZ(), 3, 30, 0, 10 + distance);

                playSound(ModSounds.DAGGER_THROW.get(), 1, 0.75f);
            }
        }
        if (getAttackState() == 28) {
            if (attackTicks == 10) {
                backStep(1f, 0);
                //  basicDash(1, 0, false);
            }
            if (attackTicks == 12) {
                throwDaggers(1f, getX(), getY(), getZ(), 3, 30, 0, 10 + distance);

                playSound(ModSounds.DAGGER_THROW.get(), 1, 0.75f);
            }
            if (attackTicks == 28) {
                backStep(1f, 0);
                //  basicDash(1, 0, false);
            }
            if (attackTicks == 30) {
                throwDaggers(1f, getX(), getY(), getZ(), 4, 30F, 0, 15 + distance);

                playSound(ModSounds.DAGGER_THROW.get(), 1, 0.75f);
            }
            if (attackTicks == 32) {
                throwDaggers(1f, getX(), getY(), getZ(), 3, 30, 0, 10 + distance);

            }
        }
        int slashFromAttack = 18;

        int stabAttack = 18;
        if (getAttackState() == 16) {

            if (attackTicks == slashFromAttack - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == slashFromAttack) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                GambitedSideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 17, 100, SoundEvents.EMPTY, 1, false, 0);
            }
        }
        if (getAttackState() == 18) {
            if (attackTicks == stabAttack - 8) {
                saveTargetPos();
            }
            if (attackTicks == stabAttack - 3) {
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.8f);
                calculatedDashToPositon(0.25f, lastTargetPos());
            }
            if (attackTicks == stabAttack) {
                StraightLineAreaAttack(-0.6f, 2.5f, smashRange, 100, 17, true, 1.35f);
            }
        }
        int stabGrabAttack = 28;
        if (getAttackState() == 19) {
            if (attackTicks == stabGrabAttack - 8) {
                saveTargetPos();
            }
            if (attackTicks == stabGrabAttack - 3) {
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.8f);
                calculatedDashToPositon(0.35f, lastTargetPos());
            }
            if (attackTicks >= stabGrabAttack - 3 && attackTicks < stabGrabAttack) {
                float g = (float) Math.toRadians(-getYRot() + 180);
                double spawnX = this.getX() + vecX * 1.5f;
                double spawnZ = this.getZ() + vecZ * 1.5f;
                this.level().addParticle(new Circle.RingData(g, 0, 30, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);

            }
            if (attackTicks == stabGrabAttack) {
                StabGrab(-0.6f, 3, 4f, 100, 17, true, 1.35f);
            }
        }
        //Stab Grab Stab Fail
        int stabStabAttack = 20;
        if (getAttackState() == 33) {
            if (attackTicks == stabStabAttack - 8) {
                saveTargetPos();
            }
            if (attackTicks == stabAttack - 2)
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.8f);
            if (attackTicks == stabAttack - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
            }
            if (attackTicks == stabStabAttack) {
                StraightLineAreaAttack(-0.6f, 2.5f, smashRange, 100, 17, true, 1.35f);
            }
        }
        if (getAttackState() == 20) {
            if (attackTicks < 20) soulRaysCount = 0;
            if (attackTicks == 20 || attackTicks == 30 || attackTicks == 40) {

                CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 0, 10);
                for (Entity entity : getPassengers()) {
                    boolean hurt = entity.hurt(ModDamageTypes.causeGhostlyDamage(this, this), (float) (2 + MathUtils.entityBasedHpDamage((LivingEntity) entity, 5) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get()));
                    if (hurt) heal(3 + MathUtils.entityBasedHpDamage((LivingEntity) entity, 0.25f));
                }

                spawnCircleParticle(2, -1, 30, false, 1, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.GROW, 20, 4, true);
                soulRaysCount++;
            }
            if (attackTicks == 20) playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 0.75f);

            if (attackTicks == 30) playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 1f);

            if (attackTicks == 40) playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 1.25f);

            if (attackTicks == 60) playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);

            if (attackTicks == 63) {
                soulRaysCount = 0;
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    if (getPhase() < 2) {
                        this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                    } else
                        this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * 2.0F, yaw, pitch), d0, d1, d2, 0, 0, 0);
                }
                playSound(SoundEvents.TOTEM_USE, 1, 1);
                Vec3 pos = new Vec3(getX(), getY(), getZ());
                CameraShakeEntity.cameraShake(level(), pos, 20, 0.25f, 0, 20);
                spawnCircleParticle(1.5f, -0.25f, 50, true, 5, getPhase() >= 2 ? uR : 0.25f, getPhase() >= 2 ? uG : 1f, getPhase() >= 2 ? uB : 0.75f, 1);
                SideAreaAttack(4, 4, 360, 0, 1, 10, 0, SoundEvents.EMPTY, 0, false, 0);

                ParticleUtils.controlledSmashParticles(this, 2, 0, 0, 7.5f, 3.5f);
            }
            if (attackTicks >= 63 && attackTicks <= 68) {
                SphereParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(), 0.35f, 2.0f, 3);
            }

            if (attackTicks == 106) playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            if (attackTicks == 109) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                float destVec = 15;
                float destoffset = 0;

                float vec = 3f;
                float offset = 0f;
                if (getFirstPassenger() instanceof LivingEntity livingEntity) {
                    if (getFirstPassenger() != null) {
                        if (!level().isClientSide) {
                            throwAnGravityEntity(1, (getX() + destVec * vecX + f * destoffset), getY() + 2f, (getZ() + destVec * vecZ + f1 * destoffset),
                                    (getX() + vec * vecX + f * offset), getY() + 1, (getZ() + vec * vecZ + f1 * offset), 1, livingEntity);
                        }
                    }
                }
            }
        }
        // JUMP
        LivingEntity target = target();
        if (getAttackState() == 22) {
            if (attackTicks == 24) {
                if (target != null) {
                    //  this.setDeltaMovement((target.getX() - this.getX()) * jumpMult, jumpStrenght, (target.getZ() - this.getZ()) * jumpMult);
                } else {
                    //   this.setDeltaMovement(0, jumpStrenght, 0);
                }
                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getY() - this.getY();
                    double d2 = target.getZ() - this.getZ();
                    double mult = 0.2D;
                    Vec3 vec3 = (new Vec3(d0, 0.7 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(mult, 1D, mult);
                    this.setDeltaMovement(vec3);
                } else {
                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.setDeltaMovement(vec3);
                }
            }
        }
        if (getAttackState() == 23) {
            if (onGround()) {
                setAttackState(getPhase() >= 2 ? 32 : 24);
            }
        }
        if (getAttackState() == 24) {
            if (attackTicks == 4) {
                SideAreaAttack(3, 3, 180, 0, 0, 24, 100, ModSounds.EMPTY, 0, true, 1.5f);
                playSound(SoundEvents.TOTEM_USE, 1, 0.75f);
                strikeZigzagXBlades(12, 1, false, 10, 4f, 1, 2f, true);
                spawnCircleParticle(1.5f, -0.25f, 60, true, 5, getPhase() >= 2 ? uR : 0.25f, getPhase() >= 2 ? uG : 1f, getPhase() >= 2 ? uB : 0.75f, 1);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.25f, 0, 20);
                ParticleUtils.controlledSmashParticles(this, 1, 0, 0, 7.5f, 3);
            }
            if (attackTicks == 7) {
                strikeZigzagXBlades(12, 1, false, 12, 4f, 1, 2f, false);
            }
        }
        //Jump Comboe
        if (getAttackState() == 32) {
            if (attackTicks == 1) {
                telegraphFadeAway.resetTimer();
            }
            if (attackTicks == 4) {
                SideAreaAttack(3, 3, 180, 0, 0, 24, 100, ModSounds.EMPTY, 0, true, 1.5f);
                playSound(SoundEvents.TOTEM_USE, 1, 0.75f);
                strikeZigzagXBlades(12, 1, false, 10, 4f, 1, 2f, true);
                spawnCircleParticle(1.5f, -0.25f, 60, true, 5, getPhase() >= 2 ? uR : 0.25f, getPhase() >= 2 ? uG : 1f, getPhase() >= 2 ? uB : 0.75f, 1);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.25f, 0, 20);
                ParticleUtils.controlledSmashParticles(this, 1, 0, 0, 7.5f, 3);
            }
            if (attackTicks == 7) {
                strikeZigzagXBlades(12, 1, false, 12, 4f, 1, 2f, false);
            }
            if (attackTicks == 30) {
                float offset = -0.5f;
                float vec = targetIsNotNull() ? 5 + (distanceTo(target()) * 0.5f) : 5;
                saveTargetPos((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));
                // saveTargetPos((getX() + vec * targetvecX + targetf * offset), getY() + 2f, (getZ() + vec * targetvecZ + targetf1 * offset));
            }
            if (attackTicks == 38) {
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDashToPositon(0.25f, lastTargetPos());
            }
            if (attackTicks == 41) {
                SideAreaAttack(3, 3, 180, 0, 0, 20, 100, ModSounds.EMPTY, 0, true, 1.5f);
            }
            if (attackTicks >= 40 && attackTicks < 50) {
                // attractParticles(ModParticles.GHOSTLY_SOUL_RED.get(), 5,15,0,0,0,2,0.1f);
            }
            if (attackTicks >= 56) {
                telegraphFadeAway.increaseTimer();
            }
            if (attackTicks >= 55 && attackTicks <= 56) {
                saveTargetPos();
            }
            if (attackTicks == 50) {
                spawnSoulPillar(0, -2, 1);
                spawnSoulPillar(0, 2, 1);
            }
            if (attackTicks >= 58 && attackTicks < 62) {
                spawnSoulPillar(0, -2, 1);
                spawnSoulPillar(0, 2, 1);
                spawnSoulPillar(0, 0, 1);
                calculatedDashToPositon(0.20f, lastTargetPos());
            }

            if (attackTicks == 67) {
                SideAreaAttack(3f, 3, 100, 0, 0, 24, 100, ModSounds.EMPTY, 0, true, 1.5f);
                playSound(SoundEvents.TOTEM_USE, 1, 0.75f);
                strikeZigzagXBlades(12, 1, true, 10, 4f, 1, 2f, true);
                spawnCircleParticle(1.5f, -0.25f, 60, true, 5, getPhase() >= 2 ? uR : 0.25f, getPhase() >= 2 ? uG : 1f, getPhase() >= 2 ? uB : 0.75f, 1);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.25f, 0, 20);
                ParticleUtils.controlledSmashParticles(this, 1, 0, 0, 7.5f, 3);
            }
            if (attackTicks == 70) {
                strikeZigzagXBlades(12, 1, true, 12, 4f, 1, 2f, false);
            }
        }
        //Shield Smash
        if (getAttackState() == 25) {
            double totalRadius = 12;
            int points = 16;
            int smashTick1 = 35;

            int smashTick2 = 59;
            // System.out.println("GetTimer: " + shieldFade.getTimer() + " Difference: " + (1 - Math.min(shieldFade.getAnimationFraction(), 1)));
            if (attackTicks == 1) ghostItemFade.setTimer(5);
            if (attackTicks >= 1 && attackTicks <= 70 && ghostItemFade.getTimer() > 0) {
                ghostItemFade.decreaseTimer();
            }
            if (attackTicks == 64) ghostItemFade.setTimer(0);
            if (attackTicks >= 65) {
                ghostItemFade.increaseTimer();
            }
            if (attackTicks == smashTick1 - 7) {
                spawnSoulShieldRing(0, 2, points, totalRadius, false, true);
            }
            if (attackTicks == smashTick1 - 3) playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            if (attackTicks == smashTick1) {
                // double radius = 8 + distanceTo(target());
                // int totalPoints = (int) (8 + Math.min(distanceTo(target()) * 2, 30));
                SideAreaAttack(3.25f, 3, 180, 0, 0, 20, 100, ModSounds.EMPTY, 0, true, 1f);
                playSound(ModSounds.SOUL_SHIELD_SMASH.get(), 1, 1);
                spawnCircleParticle(0, 0, 100, true, 2, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.SHRINK, 30);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.15f, 5, 5);
                spawnSoulShieldRing(0, 2, points, totalRadius, false, false);
                //  earthquakeEffect(15, 0.2f);
            }
            //     if (attackTicks == smashTick1 + 10) CameraShakeEntity.cameraShake(level(), position(), 20, 0.05f, 13, 0);

            if (attackTicks == smashTick2 - 7) {
                double radius = 2;
                spawnSoulShieldRing(1, 2, points, radius, true, true);
            }

            if (attackTicks == smashTick2 - 3) playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);

            if (attackTicks == smashTick2) {
                double radius = 2;
                playSound(ModSounds.STAB_HIT.get(), 1, 1);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.15f, 5, 5);
                spawnCircleParticle(0, 0, 100, true, 2, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.GROW, 30);
                spawnSoulShieldRing(1, 2, points, radius, true, false);
                //   earthquakeEffect(15,0.2f);
            }
        }
        ///Second Phase
        if (getAttackState() == 26) {
            if (attackTicks == 30)
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk4", ChatFormatting.AQUA, 10);
            if (attackTicks == 49) {
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.15f, 5, 5);
                SideAreaAttack(3, 4, 360, 0, 0, 15, 0, ModSounds.EMPTY, 0, false, 0);
                playSound(ModSounds.TOTEM_USE, 1, 0.75f);
                earthquakeEffect(15, 0.25f);
            }
            if (attackTicks >= 49 && attackTicks < 51) {
                SphereParticle(ModParticles.GHOSTLY_SOUL.get(), 0, 2, 6);
            }
            if (attackTicks >= 51 && attackTicks <= 53) {
                SphereParticle(ModParticles.GHOSTLY_SOUL_RED.get(), 0, 2, 6);
            }
            if (attackTicks >= 51 && attackTicks < 55) {
                float f9 = (this.random.nextFloat() - 0.5F) * 8.0F;
                float f10 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;

                float f8 = (this.random.nextFloat() - 0.75F) * 5.0F;
                float f6 = (this.random.nextFloat() - 0.75F) * 3.0F;
                float f7 = (this.random.nextFloat() - 0.75F) * 5.0F;


                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.0D, 0.0D);
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(),
                        this.getX() + (double) f8, this.getY() + 2.0D + (double) f6, this.getZ() + (double) f7, 0.0D, 0.0D, 0.0D);

                this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.5D, 0.0D);
                this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(),
                        this.getX() + (double) f8, this.getY() + 2.0D + (double) f6, this.getZ() + (double) f7, 0.0D, 0.5D, 0.0D);

            }
            if (attackTicks == toTicks(4.13f)) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk5", ChatFormatting.RED, 10);
                bossInfo.setName(Component.translatable("legendary_monsters.bar_name.possessed_paladin_p2"));
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.10f, 5, 5);
                playSound(ModSounds.WITHER_SHOOT, 1, 1);
                SoulStrike(1f, 15, 0);
            }
        }
        //Side Roll Spin
        if (getAttackState() == 29) {
            float attackTick1 = 41;
            float attackTick2 = 54;
            float dashA = 0.6f;
            int arc = 360;
            if (attackTicks == 4) {
                float vec = 0;
                float offset = 2;
                float scale = 1;
                Vec3 rollPos = new Vec3(getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset);
                Vec3 sub = position().subtract(rollPos);
                Vec3 finalPos = sub.scale(scale);
                setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
                playSound(ModSounds.POSSESSED_PALADIN_ROLL.get(), 1, 1);
            }
            if (attackTicks == attackTick1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
            }
            if (attackTicks >= attackTick1 - 3 && attackTicks < attackTick2) {
                basicDash(dashA, 0, false);
                if (tickCount % 3 == 0) {
                    spawnSoulPillar(-1, 0, 1);

                    spawnSoulPillar(-1, 2, 1);

                    spawnSoulPillar(-1, -2, 1);
                }
            }

            if (attackTicks == attackTick1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, arc, 0, 0, 17, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == attackTick2) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
            }

            if (attackTicks == attackTick2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, arc, 0, 0, 17, 100, SoundEvents.EMPTY, 1, false, 0);

            }
        }
        if (getAttackState() == 30) {
            float attackTick1 = 41;
            float attackTick2 = 54;
            float dashA = 0.6f;
            int arc = 360;
            if (attackTicks == 4) {
                float vec = 0;
                float offset = -2;
                float scale = 1;
                Vec3 rollPos = new Vec3(getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset);
                Vec3 sub = position().subtract(rollPos);
                Vec3 finalPos = sub.scale(scale);
                setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
                playSound(ModSounds.POSSESSED_PALADIN_ROLL.get(), 1, 1);
            }
            if (attackTicks == attackTick1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
            }
            if (attackTicks >= attackTick1 - 3 && attackTicks < attackTick2) {
                basicDash(dashA, 0, false);
                if (tickCount % 3 == 0) {
                    spawnSoulPillar(-1, 0, 1);
                    spawnSoulPillar(-1, 2, 1);
                    spawnSoulPillar(-1, -2, 1);
                }
            }

            if (attackTicks == attackTick1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, arc, 0, 0, 18, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == attackTick2) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
            }

            if (attackTicks == attackTick2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, arc, 0, 0, 18, 100, SoundEvents.EMPTY, 1, false, 0);

            }
        }
        //Sleep&Awakening
        if (getAttackState() == 34) {
            if (tickCount % 30 == 0)
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_snore", ChatFormatting.AQUA, 4);
        }

        float playerHearTalking = 10;
        if (getAttackState() == 35) {


            if (attackTicks == 1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.075F, 0, 20);
            }
            if (attackTicks == 40) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk1", ChatFormatting.AQUA, playerHearTalking);
            }

            if (attackTicks == 80) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk2", ChatFormatting.AQUA, playerHearTalking);
            }

            if (attackTicks == 150) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk3", ChatFormatting.RED, playerHearTalking);
            }
            if (attackTicks == 143) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
            }
            if (attackTicks == 146) {
                SideAreaAttack(doubleSlashRange, 3, 180, 0, 0, 18, 100, SoundEvents.EMPTY, 1, false, 0);
            }
        }
        //Death
        if (getAttackState() == 36) {

            float vec = 1;
            float offset = 0;
            float f3 = (this.random.nextFloat() - 0F) * 0.5F;
            float f4 = (this.random.nextFloat() - 0F) * 0.5F;
            float f5 = (this.random.nextFloat() - 0F) * 0.5F;
            int stab1 = 85;
            int stab2 = 115;
            if (attackTicks >= 1 && tickCount % 10 == 0) {
                float f9 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f10 = (this.random.nextFloat() - 0.5F) * 2.0F;
                float f2 = (this.random.nextFloat() - 0.5F) * 4.0F;
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.0D, 0.0D);

                this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.5D, 0.0D);
            }
            if (attackTicks == 20) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk9", ChatFormatting.RED, playerHearTalking);
            }
            if (attackTicks == 1) rayAmount = 0;
            if (attackTicks == stab1) {
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.75f);
                bossInfo.setName(getName());
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk6", ChatFormatting.AQUA, playerHearTalking);
                if (level().isClientSide) {
                    this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 1.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                }
            }
            if (attackTicks >= stab1) {
                for (int i = 0; i < 0.5; ++i) {
                    if (level().isClientSide) {
                        this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(), this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);

                    }

                }
            }
            if (attackTicks == stab2) {
                if (level().isClientSide) {
                    this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() :
                            ModParticles.SOUL_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 1.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                }
                playSound(ModSounds.STAB_HIT.get(), 1, 1f);
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk7", ChatFormatting.AQUA, playerHearTalking);
            }
            if (attackTicks == 180) {
                rayAmount++;
                playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 0.75f);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.1f, 5, 5);
                bossInfo.setName(Component.translatable("legendary_monsters.bar_name.possessed_paladin_p2"));
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk8", ChatFormatting.RED, playerHearTalking);
            }
            if (attackTicks == 240) {
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 2.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                rayAmount++;
                playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 0.75f);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.1f, 5, 5);
            }
            if (attackTicks == 250) {

                rayAmount++;
                playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 1f);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.1f, 5, 5);
            }
            if (attackTicks == 260) {
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 2.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                rayAmount++;
                playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 1, 1.25f);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.1f, 5, 5);
            }
            if (attackTicks == 270) {
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 2.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                CameraShakeEntity.cameraShake(level(), position(), 20, 0.25f, 5, 10);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 0.5F);
            }
            if (attackTicks >= 270) {
                float f9 = (this.random.nextFloat() - 0.5F) * 8.0F;
                float f10 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;

                float f8 = (this.random.nextFloat() - 0.75F) * 5.0F;
                float f6 = (this.random.nextFloat() - 0.75F) * 3.0F;
                float f7 = (this.random.nextFloat() - 0.75F) * 5.0F;


                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.0D, 0.0D);
                this.level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_EXPLOSION_RED.get() : ModParticles.SOUL_EXPLOSION.get(),
                        this.getX() + (double) f8, this.getY() + 2.0D + (double) f6, this.getZ() + (double) f7, 0.0D, 0.0D, 0.0D);

                this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(),
                        this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.5D, 0.0D);
                this.level().addParticle(getPhase() >= 2 ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(),
                        this.getX() + (double) f8, this.getY() + 2.0D + (double) f6, this.getZ() + (double) f7, 0.0D, 0.5D, 0.0D);

            }
        }
        //Finisher
        if (getAttackState() == 37) {
           /* int crossSlash = 53;
            int tridentSwing1 = 89;
            int swordSwing1 = 92;
            int tridentSwing2 = 112;
            int swordSwing2 = 115;
            int swordSwing3 = 125;
            int swordStab = 137;
            int tridentUppercut = 155;
            int crossSlash2 = 178;
            int landSlam = 252;
            int doubleUppercut = 279;

            */
            int crossSlash = 53;
            int tridentSwing1 = 89;
            int swordSwing1 = 92;
            int tridentSwing2 = 120;
            int swordSwing2 = 123;
            int swordSwing3 = 133;
            int swordStab = 148;
            int tridentUppercut = 168;
            int crossSlash2 = 190;
            int landSlam = 265;
            int doubleUppercut = 292;
            float tridentRange = 4f;
            int chainedStrikeRadius = 4;
            if (attackTicks == 1) ghostItemFade.setTimer(5);
            if (attackTicks >= 5 && attackTicks <= 70 && ghostItemFade.getTimer() > 0) {
                ghostItemFade.decreaseTimer();
            }
            if (attackTicks == 312) ghostItemFade.setTimer(0);
            if (attackTicks >= 312) {
                ghostItemFade.increaseTimer();
            }
            if (tickCount % 10 == 0) {
                for (int k = 0; k < 2; k++) {
                    float d1 = Mth.sqrt(k);
                    float ran = 0.4f;
                    float r = 236 / 255F;
                    float g = 48 / 255F;
                    float b = 48 / 255F;
                    //  this.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.25f, 0.1f),
                    //        getX(), getY(), getZ(), Mth.sin(k), 0, d1 * 0.01f);
                }
            }
            if (attackTicks == 25) {
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_talk10", ChatFormatting.RED, 10);
            }
            if (attackTicks == crossSlash - 3) {

                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                // spawnChainedStrike(0, 0, 3, chainedStrikeRadius,15);
            }
            if (attackTicks == crossSlash) {
                spawnCircleParticle(0, 0, 100, true, 2, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.CONSTANT, 30);
                //  throwDaggers(1f, getX(), getY(), getZ(), 6, 30, 0, 10);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(3.5f, 3.5f, 180, 0, 0, 17, 100, ModSounds.EMPTY, 1, false, 1);
            }

            if (attackTicks == tridentSwing1 - 3) {
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize + 0.5f, sweepRot, false);

            }
            if (attackTicks == tridentSwing1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(tridentRange, tridentRange, 180, 0, 0, 15, 100, ModSounds.EMPTY, 1, false, 1);
            }

            if (attackTicks == swordSwing1 - 3) {
                calculatedDash(0.15f);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
            }
            if (attackTicks == swordSwing1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(3.5f, 3.5f, 180, 0, 0, 17, 100, ModSounds.EMPTY, 1, false, 1);
            }
            if (attackTicks == 100) advancedDash(this, -3f, 2.5f, 0.75f);

            if (attackTicks == tridentSwing2 - 3) {
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize + 0.5f, sweepRot, false);
            }
            if (attackTicks == tridentSwing2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(tridentRange, tridentRange, 180, 0, 0, 15, 100, ModSounds.EMPTY, 1, false, 1);
            }

            if (attackTicks == swordSwing2 - 3) {
                calculatedDash(0.15f);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
            }
            if (attackTicks == swordSwing2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(3.5f, 3.5f, 180, 0, 0, 19, 100, ModSounds.EMPTY, 1, false, 1);
            }

            if (attackTicks == swordSwing3 - 3) {
                //  calculatedDash(0.15f);
                advancedDash(this, -3f, -2.5f, 0.75f);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
            }
            if (attackTicks == swordSwing3) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(3f, 3.5f, 180, 0, 0, 17, 100, ModSounds.EMPTY, 1, false, 1);
            }
            if (attackTicks == swordStab - 8) saveTargetPos();
            if (attackTicks == swordStab - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.POSSESSED_PALADIN_STAB.get(), 1, 0.8f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
            }
            if (attackTicks == swordStab) StraightLineAreaAttack(-0.6f, 2.5f, smashRange, 100, 17, true, 1.35f);

            if (attackTicks == tridentUppercut - 8) saveTargetPos();
            if (attackTicks == tridentUppercut - 3) {
                calculatedDashToPositon(0.25f, lastTargetPos());
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                //    createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
            }

            if (attackTicks == tridentUppercut) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                StraightLineAreaAttack(-0.6f, 2.5f, 5f, 100, 15, true, 1.35f);
            }
            if (attackTicks == crossSlash2 - 3) {
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
            }
            if (attackTicks == crossSlash2) {
                // throwDaggers(1f, getX(), getY(), getZ(), 6, 30, 0, 10);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(3.5f, 3.5f, 180, 0, 0, 18, 100, ModSounds.EMPTY, 1, false, 1);
            }
            if (attackTicks == landSlam - 36) setNoGravity(true);
            if (attackTicks >= landSlam - 36 && attackTicks <= landSlam - 25) {
                setDeltaMovement(getDeltaMovement().x, 0.35f, getDeltaMovement().z);
                //   attractParticles(ModParticles.GHOSTLY_SOUL.get(),7,5,0,0,0,0,0,5,0.1f);
                int ucap = 5;
                float v = 0.075f;
                float endY = 5;
                float startY = 3;
                attractParticles(ModParticles.GHOSTLY_SOUL_RED.get(), ucap, 4, 0, 0, 5, endY, v);
                attractParticles(ModParticles.GHOSTLY_SOUL_RED.get(), ucap, 4, 0, 0, 3, endY, v);
                attractParticles(ModParticles.GHOSTLY_SOUL_RED.get(), ucap, 4, 0, 0, 2, endY, v);
            }
            if (attackTicks == landSlam - 20) {
                playSound(ModSounds.OMINOUS_WIND_UP.get(), 1, 1);
            }
            if (attackTicks == landSlam - 15) {
                saveTargetPos();
            }

            if (attackTicks == landSlam - 10) {

                setNoGravity(false);
                float precent = 0.15f;
                if (targetIsNotNull()) {
                    Vec3 start = position();
                    Vec3 end = lastTargetPos();

                    Vec3 sub = end.subtract(start);
                    Vec3 normal = sub.normalize();
                    float fl1 = distanceTo(target()) * 0.25f;
                    float fl2 = Mth.clamp(distanceTo(target()) * precent, 0, 1);
                    setDeltaMovement(getDeltaMovement().add(normal.x * fl1, normal.y * fl1, normal.z * fl1));
                } else setDeltaMovement(getDeltaMovement().x, -1, getDeltaMovement().z);
            }
            if (attackTicks < landSlam) {
                if (!this.level().isClientSide) {
                    if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                        this.destroy();
                    }

                }
            }
            if (attackTicks == landSlam) {
                spawnChainedStrike(4, 0, 1, 5, 10, true);
                spawnChainedStrike(-4, 0, 1, 5, 10, true);
                spawnChainedStrike(0, -4, 1, 5, 10, true);
                spawnChainedStrike(0, 4, 1, 5, 10, true);

                CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 10, 10);
                playSound(ModSounds.STAB_HIT.get(), 1, 1);
                SideAreaAttack(3f, 3, 360, 0, 0, 25, 150, ModSounds.EMPTY, 0, false, 0);
                spawnCircleParticle(0, 0, 100, true, 2, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, Circle.EnumRingBehavior.GROW, 30);
            }
            if (attackTicks == doubleUppercut - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                basicDash(1.5f, 3, true);
            }
            if (attackTicks == doubleUppercut) {
                spawnChainedStrike(3, 0, 3, 4, 10, true);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                StraightLineAreaAttack(-0.6f, 2.5f, 5f, 100, 17, true, 1.35f);
                //  spawnChainedStrike(0, 0, 3, 2, 15);
            }
        }
        //Trident Throw Spin
        if (getAttackState() == 38) {
            int throwAttack = 28;
            int slash1 = 54;
            int slash2 = 69;
            if (attackTicks == 1) {
                ghostItemFade.setTimer(5);
            }
            if (attackTicks >= 5 && attackTicks <= 70 && ghostItemFade.getTimer() > 0) {
                ghostItemFade.decreaseTimer();
            }

            if (attackTicks == 1) {
                telegraphFadeAway.resetTimer();
            }
            if (attackTicks == throwAttack) {
                if (targetIsNotNull()) {
                    throwSoulTrident(target(), 1);
                }
            }
            if (attackTicks == slash1 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == slash1) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 90, 0, 0, 18, 100, SoundEvents.EMPTY, 1, false, 0);
            }
            if (attackTicks == 62) {
                advancedDash(this, 1.5f, -3f, 0.75f);
            }
            if (attackTicks == slash2 - 3) {
                createSweep(0, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                playSound(ModSounds.POSSESSED_PALADIN_SWING.get(), 1, 0.75f);
                calculatedDash(0.25f);
            }
            if (attackTicks == slash2) {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.05F, 0, 10);
                SideAreaAttack(doubleSlashRange, 3, 90, 0, 0, 18, 100, SoundEvents.EMPTY, 1, false, 0);

            }
            if (attackTicks >= 64 && attackTicks <= 69) telegraphFadeAway.increaseTimer();
            for (int i = 69; i <= 69 + 14; i = i + 2) {
                if (attackTicks == i) {
                    int d = i - 67;
                    flameRadagonShockwave(0.20f, d, 1, 5, 0, 0, 6);
                }
            }
        }
    }

    public int rayAmount = 0;

    public void earthquakeEffect(float range, float amplitude) {
        for (LivingEntity livingEntity : level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(range))) {
            Vec3 delta = livingEntity.getDeltaMovement();
            livingEntity.setDeltaMovement(delta.x, delta.y + amplitude, delta.z);
            EntityUtil.applyPlayerDeltaMovement(livingEntity);
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

            this.spawnSoulPillars(hitX + 0.5D, this.getY(), hitZ + 0.5D, (int) this.getY() - 1, (float) theta, delay, level(), null);
        }
    }

    private void spawnSoulShieldRing(int waveIndex, int wavesTotal, int totalPoints, double radius, boolean isOuter, boolean isWarningParticle) {
        double step = (Math.PI * 2.0) / totalPoints;

        int pointsThisWave = totalPoints / wavesTotal;

        double base = (-(Math.PI * 2.0) / 15.0);

        double waveOffset = waveIndex * step;

        for (int i = 0; i < pointsThisWave; i++) {
            double angle = base + waveOffset + i * (wavesTotal * step);

            double spawnX = getX() + Math.cos(angle) * radius;
            double spawnZ = getZ() + Math.sin(angle) * radius;

            double spawnY = Mth.floor(getY());
            double headY = getY() + 1.0;

            double dx = getX() - spawnX;
            double dz = getZ() - spawnZ;

            float yawRad = (float) Math.atan2(dz, dx);

            float f2 = (float) i * MathUtils.TAU / pointsThisWave + (MathUtils.TAU / pointsThisWave - 1);
            spawnSoulShields(spawnX, spawnZ, spawnY,
                    headY, isOuter ? f2 : yawRad, 4,
                    (float) getX(), (float) getY(), (float) getZ(), isOuter, isWarningParticle
            );
        }
    }

    public void spawnSoulShields(double x, double z, double minY, double maxY, float rotation, int delay, float destX, float destY, float destZ, boolean isOuter, boolean isWarningParticle) {

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
            if (isWarningParticle) {
                if (level().isClientSide) {
                    level().addParticle(getPhase() >= 2 ? ModParticles.GROUNDSOUL_RED.get() : ModParticles.GROUNDSOUL.get(), x, (double) blockpos.getY() + 2 + d0, z, 0, 0, 0);
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 35, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, 15f, false, Circle.EnumRingBehavior.SHRINK),
                            x, (double) blockpos.getY() + 0.25f + d0, z, 0, 0, 0);

                }
            } else
                this.level().addFreshEntity(new SoulShieldEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, 10, destX, destY, destZ, isOuter, getPhase() >= 2));
        }
    }


    private void strikeZigzagXBlades(int rune, double time, boolean isFalling, float damage, float divider,
                                     int offset, double amplitude, boolean particleWarning) {
        for (int i = 0; i < rune; i++) {
            float throwAngle = (float) i * (float) Math.PI / (rune / divider);

            float perpX = -(float) Mth.sin(throwAngle);
            float perpZ = (float) Mth.cos(throwAngle);

            for (int k = 0; k < 8; k++) {
                double forward = 1.25 * (k + 1);

                int group = (k / offset) % 2;
                double lateral = amplitude * (group == 0 ? 1 : -1);

                double xOff = Mth.cos(throwAngle) * forward + perpX * lateral;
                double zOff = Mth.sin(throwAngle) * forward + perpZ * lateral;

                int delay = (int) (time * (k + 1));

                this.spawnBlades(
                        this.getX() + xOff,
                        this.getZ() + zOff,
                        this.getY(),
                        this.getY() + 2.0,
                        throwAngle,
                        delay,
                        isFalling,
                        damage, particleWarning
                );
            }
        }
    }

    private void spawnBlades(double x, double z, double minY, double maxY, float rotation, int delay, boolean falling, float damage, boolean warning) {

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
            if (warning) {
                this.level().addAlwaysVisibleParticle(getPhase() >= 2 ? ModParticles.GROUNDSOUL_RED.get() : ModParticles.GROUNDSOUL.get(), x, (double) blockpos.getY() + 2 + d0, z, 0, 0, 0);
                this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 35, getPhase() >= 2 ? uR : 0f, getPhase() >= 2 ? uG : 0.9f, getPhase() >= 2 ? uB : 0.8f, 0.8f, 15f, false, Circle.EnumRingBehavior.SHRINK),
                        x, (double) blockpos.getY() + 0.25f + d0, z, 0, 0, 0);

            } else {
                if (falling) {
                    this.level().addFreshEntity(new FallingSoulBladeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, damage, getPhase() >= 2));
                } else {

                    this.level().addFreshEntity(new SoulBladeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, damage, getPhase() >= 2));
                }
            }
        }
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !isSleep();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.POSSESSED_PALADIN_STEREO.get();
    }

    @Override
    protected void positionRider(Entity pPassenger, MoveFunction pCallback) {

        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 1f;
        float offset = 0f;
        if (hasPassenger(pPassenger)) {
            pCallback.accept(pPassenger, (getX() + vec * vecX + f * offset), getY() + 1, (getZ() + vec * vecZ + f1 * offset));
        }
    }

    private void SphereParticle(ParticleOptions particleType, float height, float vec, float size) {
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

    public int soulRaysCount;

    public void backStep(float v, float y) {

        float yaw = (float) Math.toRadians(this.getYRot() + 90);
        Vec3 dodgePos = this.getDeltaMovement().add(v * Math.cos(yaw), y, v * Math.sin(yaw));
        this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
    }

    public void jumpTowardsPosition(double x, double y, double z) {
        Vec3 start = new Vec3(getX(), getY(), getZ());
        Vec3 end = new Vec3(x, y, z);
        Vec3 sub = end.subtract(start);
        Vec3 finalPos = sub.scale(0.8);


        double d0 = finalPos.x;
        double d1 = finalPos.y;
        double d2 = finalPos.z;

        Vec3 vec3 = (new Vec3(d0, 0.3 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
        this.setDeltaMovement(vec3);
    }

    @Override
    public boolean canBeCollidedWith() {
        return getAttackState() == 12 || getAttackState() == 14;
        // return !(getAttackState() == 20);
    }

    public LivingEntity target() {
        return getTarget();
    }

    public double lastTargetX;
    public double lastTargetY;
    public double lastTargetZ;

    public Vec3 lastTargetPos() {
        return new Vec3(lastTargetX, lastTargetY, lastTargetZ);
    }

    public boolean isMagicAttack() {
        return getAttackState() == 20 || getAttackState() == 26;
    }

    public void saveTargetPos() {
        if (targetIsNotNull()) {
            lastTargetX = target().getX();

            lastTargetY = target().getY();

            lastTargetZ = target().getZ();
        }
    }

    public void saveTargetPos(double x, double y, double z) {
        if (targetIsNotNull()) {
            lastTargetX = x;

            lastTargetY = y;

            lastTargetZ = z;
        }
    }

    public boolean canParry() {
        return !hasParried && parry_cooldown <= 0 && (getAttackState() == 0 || getAttackState() == 9);
    }

    public boolean isBlockin() {
        return getAttackState() == 5 && attackTicks < toTicks(0.92f);
    }

    @Override
    public int attackDelayTicksValue() {
        return parry_cooldown <= 0 ? 3 : 1;
    }

    public boolean hasParried = false;

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (isTargetCheesing(-4, 4) || getAttackState() == 26 || isSleep()) return false;
        if ((BossInvulnerabilityTime > 0 && ModConfig.MOB_CONFIG.PossessedPaladinInvulnerabilityTime.get()))
            return false;
        if (isBlockin()) {
            playSound(ModSounds.BLOCK.get(), 1, 1);
            CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 5, 5);
            return false;
        }
        if (!level().isClientSide && canParry() && amount > 1) {
            hasParried = true;
            setAttackState(5);
            stopAllAnimationStates();
            playSound(ModSounds.BLOCK.get(), 1, 1);
            CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 5, 5);
            if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY))
                sendAdvancedHotBarMessage("legendary_monsters.message.possessed_paladin_kill_parry", getPhase() >= 2 ? ChatFormatting.RED : ChatFormatting.AQUA, 10);

            return false;

        }
        boolean hurt1 = super.hurt(source, amount);
        if (hurt1) {
            if (!level().isClientSide && ModConfig.MOB_CONFIG.PossessedPaladinInvulnerabilityTime.get()) {
                if (BossInvulnerabilityTime <= 0) {
                    BossInvulnerabilityTime = 10;
                }
            }
        }
        return hurt1;
    }

    public int BossInvulnerabilityTime = 0;

    @Override
    public double damageCap() {
        return ModConfig.MOB_CONFIG.PossessedPaladinDamageCap.get();
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

            if (getPhase() >= 2) {
                this.level().addParticle(new SoulSweepRedParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);
            } else {
                this.level().addParticle(new SoulSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);
            }
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

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.PossessedPaladinHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public boolean shouldAttackMore = false;

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float launchPower) {
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage + MathUtils.entityBasedHpDamage(entityHit, 3f) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));
                if (flag) {
                    EntityUtil.cancelBuffs(entityHit);
                    entityHit.invulnerableTime = 0;
                    shouldAttackMore = true;
                    applyStackingEffect(entityHit, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
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

    public boolean succedGrabbing = false;

    private void StabGrab(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float launchPower) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {

                boolean entityHitIsTarget = entityHit == target();
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage + MathUtils.entityBasedHpDamage(entityHit, 3f) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));
                if (flag) applyStackingEffect(entityHit, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));

                if (flag) {
                    EntityUtil.cancelBuffs(entityHit);
                    boolean mounted = entityHit.startRiding(this, true);
                    if (mounted && flag) {
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

    public int getStunDuration() {
        return 55;
    }

    public void launch(LivingEntity entity, float strenght) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        entity.push(deltaX / distanceSquared * (double) strenght, strenght, deltaZ / distanceSquared * (double) strenght);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return !(getAttackState() == 20);
    }

    public void SideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            int brokenShieldTicks,
            SoundEvent soundEvent,
            float pitch,
            boolean launch,
            float launchPower

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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof PossessedPaladinEntity) && entityHit != this) {
                    boolean flag = entityHit.hurt(isMagicAttack() ? ModDamageTypes.causeGhostlyDamage(this, this) : this.damageSources().mobAttack(this), (float) ((damage + MathUtils.entityBasedHpDamage(entityHit, 3f) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));

                    if (flag) {
                        EntityUtil.cancelBuffs(entityHit);
                        entityHit.invulnerableTime = 0;
                        if (getAttackState() == 20) heal(3 + MathUtils.entityBasedHpDamage(entityHit, 1));
                        if (launch) launch(entityHit, true);
                        if (getAttackState() == 5) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), getStunDuration(), 0));
                        }
                        applyStackingEffect(entityHit, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                        playSound(soundEvent, 1, pitch);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    public void GambitedSideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            int brokenShieldTicks,
            SoundEvent soundEvent,
            float pitch,
            boolean launch,
            float launchPower

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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof PossessedPaladinEntity) && entityHit != this) {
                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage + MathUtils.entityBasedHpDamage(entityHit, 3f) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));

                    if (flag) {
                        EntityUtil.cancelBuffs(entityHit);
                        entityHit.invulnerableTime = 0;
                        hasHurt = true;
                        if (launch) launch(entityHit, true);
                        if (getAttackState() == 5) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), getStunDuration(), 0));
                        }
                        applyStackingEffect(entityHit, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                        playSound(soundEvent, 1, pitch);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
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
            world.addFreshEntity(new SoulPillarEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, this, 20, 8, getIsSecondPhase()));
            return true;
        }
        return false;
    }

    private boolean spawnSoulPillarExplosions(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
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
            world.addFreshEntity(new SoulPillarExplosionEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, this, 20, 8, getIsSecondPhase()));
            return true;
        }
        return false;
    }


    public Random random1 = new Random();

    public Random random2 = new Random();

    public void randomizedSoulStrike(int firstRandomMin, int secondRandomMin, int amount) {
        //Random random1 = new Random();
        // System.out.println("RANDOM1: " + random1.toString() + " Random2: " + random2.toString());
        //  Random random2 = new Random();
        int uCap = 5;
        int rX = random1.nextInt(-uCap, uCap);
        int rX2 = random1.nextInt(-uCap, uCap);
        int rZ = random1.nextInt(-uCap, uCap);
        int rZ2 = random1.nextInt(-uCap, uCap);

        // System.out.println("RX1: " + rX);
        // System.out.println("RX2: " + rX2);

        //System.out.println("RZ1: " + rZ);
        //  System.out.println("RZ2: " + rZ2);

        Vec3 randomPos = new Vec3(getX() + rX, getY(), getZ() + rZ);
        Vec3 atanPos = new Vec3(randomPos.x + rX2, randomPos.y, randomPos.z + rZ2);

        double d0 = Math.min(getY(), this.getY());
        double d1 = Math.max(getY(), getY()) + 1.0D;
        float f = (float) Mth.atan2(atanPos.z - randomPos.z, atanPos.x - randomPos.x);
        for (int l = 0; l < amount; ++l) {
            double d2 = 1.25D * (double) (l + 1);
            int j = 1 * l + 10;
            this.spawnSoulPillars(randomPos.x + (double) Mth.cos(f) * d2, getY(), randomPos.z + (double) Mth.sin(f) * d2, (int) d1, f, j, level(), this);
        }
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

    public void spawnSpiralStrike(double max, double gapFill, double inBetweenGapFill, int constantDelay, double delayFactor) {
        for (double t = 0; t < max; t += gapFill) {

            int delay = (int) (t * delayFactor);
            double r = constantDelay + t * inBetweenGapFill;
            double x = getX() + r * Math.cos(t);
            double y = getY();
            double z = getZ() + r * Math.sin(t);
            this.spawnSoulPillarExplosions(x, y, z, (int) y, 0, delay, level(), this);
        }
    }

    public void spawnChainedStrike(float startVec, float startOffset, int reps, int amount, int delay, boolean centeredStrike) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double d1 = getY() - 1;
        double d0 = Math.min(getY(), this.getY() - 3);
        for (int k = 0; k < reps; k++) {
            float r = amount;
            float rMove = 0;
            float yaw = (float) Math.toRadians(90);
            int squareMove = k * amount * 2;
            double rawX = getX() + (squareMove + startVec) * vecX + f * startOffset;
            double rawZ = getZ() + (squareMove + startVec) * vecZ + f1 * startOffset;
            double x = rawX + rMove * Math.cos(yaw);
            double z = rawZ + rMove * Math.sin(yaw);
            double y = getY();
            double div = r / Math.sqrt(2);
            Vec3 V1 = new Vec3(x + div, y, z + div);
            Vec3 V2 = new Vec3(x - div, y, z + div);
            Vec3 V3 = new Vec3(x - div, y, z - div);
            Vec3 V4 = new Vec3(x + div, y, z - div);
            float v1v2atan2 = (float) Mth.atan2(V2.z - V1.z, V2.x - V1.x);
            float v2v3atan2 = (float) Mth.atan2(V3.z - V2.z, V3.x - V2.x);
            float v1v4atan2 = (float) Mth.atan2(V4.z - V1.z, V4.x - V1.x);
            float v4v3atan2 = (float) Mth.atan2(V3.z - V4.z, V3.x - V4.x);
            int loopDelay = k * 5;
            for (int l = 0; l < amount; ++l) {
                if (l % 2 == 0) {
                    double d2 = 1.25D * (double) (l + 1);
                    double lowestY = getY();
                    this.spawnSoulPillarExplosions(V1.x + (double) Mth.cos(v1v2atan2) * d2, lowestY, V1.z + (double) Mth.sin(v1v2atan2) * d2, (int) d1, f, delay + loopDelay, level(), this);
                    this.spawnSoulPillarExplosions(V2.x + (double) Mth.cos(v2v3atan2) * d2, lowestY, V2.z + (double) Mth.sin(v2v3atan2) * d2, (int) d1, f, delay + loopDelay, level(), this);
                    this.spawnSoulPillarExplosions(V1.x + (double) Mth.cos(v1v4atan2) * d2, lowestY, V1.z + (double) Mth.sin(v1v4atan2) * d2, (int) d1, f, delay + loopDelay, level(), this);
                    this.spawnSoulPillarExplosions(V4.x + (double) Mth.cos(v4v3atan2) * d2, lowestY, V4.z + (double) Mth.sin(v4v3atan2) * d2, (int) d1, f, delay + loopDelay, level(), this);
                }
            }
            if (centeredStrike) {
                if (level().isClientSide) {
                    level().addParticle(ModParticles.SOUL_EXPLOSION_RED.get(), x, getY() + 0.5f, z, 0, 0, 0);
                }
                this.spawnSoulPillarExplosions(x, getY() - 1, z, (int) d1, f, delay, level(), this);
            }
        }
        //   this.spawnSoulPillars(V1.x, getY(), V1.z, (int) d1, f, 1, level(), this);
        //  this.spawnSoulPillars(V2.x, getY(), V2.z, (int) d1, f, 1, level(), this);
        //   this.spawnSoulPillars(V3.x, getY(), V3.z, (int) d1, f, 1, level(), this);
        //this.spawnSoulPillars(V4.x, getY(), V4.z, (int) d1, f, 1, level(), this);
    }


    private void SoulStrike(float vec, int quake, float math) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = 360.0F / quake;
        for (int i = 0; i < quake; i++) {
            SoulStrike peq = new SoulStrike(this.level(), this, getPhase() >= 2);
            peq.setDamage((float) 12);
            peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.45F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * math, this.getY() + 0.3D, getZ() + vec * vecZ + f1 * math);
            this.level().addFreshEntity(peq);

        }
    }

    public void addShootParticle(float vec, float offset) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        level().addParticle(getPhase() >= 2 ? ModParticles.SOUL_SHOOT_RED.get() : ModParticles.SOUL_SHOOT.get(),
                getX() + vec * vecX + f * offset,
                getY() + 1.75,
                getZ() + vec * vecZ + f1 * offset,
                0, 0, 0);
    }


    private void throwPhantomDaggers(float v, float offset, int amount, float throwAngle, float additionalY) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        for (int i = 0; i < amount; i++) {
            float angle = yBodyRot + (i - ((float) amount / 2)) * throwAngle;

            float rad = (float) Math.toRadians(angle);
            double dx = -Math.sin(rad);
            double dz = Math.cos(rad);
            if (this.getTarget() != null) {

                float y = Mth.floor(this.getY());
                float m = (float) (this.getTarget().getMaxHealth() * 0.01);
                //ThrownPhantomDagger witherskull = new ThrownPhantomDagger(this, dx, 0, dz, this.level(), (float) 7f, angle, 45);
                ThrownPhantomDaggerEntity witherskull = new ThrownPhantomDaggerEntity(ModEntities.THROWN_PHANTOM_DAGGER.get(), level());
                witherskull.setOwner(this);
                witherskull.setReturnEntity(this);
                witherskull.setYRot(angle);
                double spawnX = this.getX() + vecX * 1;
                double spawnY = getY() + (getBbHeight() / 2) + additionalY;
                double spawnZ = this.getZ() + vecZ * 1;
                witherskull.setPos(spawnX, spawnY, spawnZ);
                witherskull.shootFromRotation(this, 0, angle * i, 0, v, 0);

                this.level().addFreshEntity(witherskull);
            }
        }
        /*
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = -yBodyRot + throwAngle / amount;
        for (int i = 0; i < amount; i++) {

            float angleStep = 20.0f;
            float angletotal = yBodyRot + (i - (amount / 2)) * angleStep;
            ThrownPhantomDagger peq = new ThrownPhantomDagger(ModEntities.THROWN_PHANTOM_DAGGER.get(), level());
           // peq.setDamage((float) 9);
            peq.setInteria(1);
            peq.setReturnTick(20);
            peq.setYRot(angletotal);
            peq.setYBodyRot(angleStep);
            peq.shootFromRotation(this, 0, angletotal * i, 0.0F, 0.45F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * offset, this.getY() + 0.3D, getZ() + vec * vecZ + f1 * offset);
            this.level().addFreshEntity(peq);

        }*/
    }

    private void SoulShockwave(float spreadarc, int distance, float vec, int delay, float pos, float offset) {
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

            this.spawnSoulPillars(hitX + 0.5D, 1, hitZ + 0.5D, (int) (getY() - 5f), (float) theta, delay, level(), this);
        }
    }

    public void throwDaggers(float velocity, double x, double y, double z, int daggerCount, float angleBetween, float elevationAngle, int returnTick) {
        float offset = 2;
        float vec = 2;
        float behindVec = 0.5f;
        addShootParticle(vec, 0);
        addShootParticle(vec - behindVec, offset);
        addShootParticle(vec - behindVec, -offset);
        if (targetIsNotNull()) {
            double dx = target().getX() - x;
            double dz = target().getZ() - z;
            double dy = target().getY() - y;
            Vec3 flatDir = new Vec3(dx, dy, dz).normalize();

            double elevRad = Math.toRadians(dy);

            double totalSpread = angleBetween * (daggerCount - 1);
            double startYaw = -totalSpread * 0.5;

            for (int i = 0; i < daggerCount; i++) {

                double yawOffset = startYaw + i * angleBetween;
                Vec3 dirYaw = rotateYaw(flatDir, yawOffset);

                double cosP = Math.cos(elevRad);
                double sinP = Math.sin(elevRad);
                Vec3 finalVec = new Vec3(dirYaw.x * cosP, sinP, dirYaw.z * cosP);

                ThrownPhantomDaggerEntity dagger = new ThrownPhantomDaggerEntity(ModEntities.THROWN_PHANTOM_DAGGER.get(), this.level());
                dagger.setPosRaw(x, y + getBbHeight() / 2, z);

                dagger.setReturnEntity(this);
                dagger.setReturnTick(returnTick);
                dagger.setDamage(6);
                dagger.shoot(finalVec.x, finalVec.y, finalVec.z, velocity, 0);
                dagger.setOwner(this);
                dagger.setRed(getPhase() >= 2);
                this.level().addFreshEntity(dagger);
            }
        }
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        bossInfo.setVisible(false);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public boolean isSleep() {
        return this.getAttackState() == 34 || this.getAttackState() == 35;
    }

    public void setSleep(boolean sleep) {
        bossInfo.setVisible(false);
        this.setAttackState(sleep ? 34 : 0);
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(36);
        setNoGravity(false);
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == toTicks(14)) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    private void destroy() {
        if (!this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return;
        }
        boolean flag = false;
        float inflate = 1.5f;
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
                    if (!blockstate.is(ModBlocks.INDESTRUCTIBLE_BLOCK.get()))
                        flag = this.level().destroyBlock(blockpos, false, this) || flag;
                }
            }
        }
    }
}