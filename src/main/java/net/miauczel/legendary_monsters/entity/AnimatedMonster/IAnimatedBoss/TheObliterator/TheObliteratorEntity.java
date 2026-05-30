package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.*;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneWithArmsEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Chorusling.TheWarpedOne.TheWarpedOneOld;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.goals.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.ai.ITwoHitAttackGoal;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.LMBossInfoServer;
import net.miauczel.legendary_monsters.util.ModSavedData;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class TheObliteratorEntity extends IAnimatedBoss {


    private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(TheObliteratorEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_SECOND_PHASE = SynchedEntityData.defineId(TheObliteratorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_THIRD_PHASE = SynchedEntityData.defineId(TheObliteratorEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_QUAD_BEAM_RIGHT = SynchedEntityData.defineId(TheObliteratorEntity.class, EntityDataSerializers.BOOLEAN);


    public TheObliteratorEntity(EntityType entity, Level world) {
        super(entity, world);
        xpReward = 100;
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();
        }
    }

    public void setBossBarVisible(boolean b) {
        bossInfo.setVisible(b);
    }

    /// DATA
    public boolean canShootTwice = false;
    public boolean gambitParry = false;

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IS_SECOND_PHASE, false);
        entityData.define(PHASE, 1);
        entityData.define(IS_QUAD_BEAM_RIGHT, false);
        entityData.define(IS_THIRD_PHASE, false);
    }

    public boolean getIsQuadBeamRight() {
        return entityData.get(IS_QUAD_BEAM_RIGHT);
    }

    public void setIsQuadBeamRight(boolean right) {
        entityData.set(IS_QUAD_BEAM_RIGHT, right);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("p2", getIsSecondPhase());
        pCompound.putInt("phase", getPhase());
        pCompound.putBoolean("p3", getIsThirdPhase());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setIsSecondPhase(pCompound.getBoolean("p2"));
        setPhase(pCompound.getInt("phase"));
        setIsThirdPhase(pCompound.getBoolean("p3"));
    }


    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    /// COOLDOWNS
    public final int TELEPORT_FALL_COOLDOWN = toTicks(5);//100
    public final int DIMENSIONAL_SHOOT_COOLDOWN = toTicks(3.5f);
    public final int AMBUSH_COOLDOWN = toTicks(0);//3

    public final int TELEPORT_GRAB_COOLDOWN = toTicks(8);//160

    public final int JUMP_TELEPORT_COOLDOWN = toTicks(7.5f);//150

    public final int CLONE_BURST_GRAB_COOLDOWN = toTicks(10);

    public final int KICK_SMASH_GRAB_COOLDOWN = 0;

    public final int BACKSTEP_STOMP_COOLDOWN = toTicks(4);

    public final int SPIN_SMASH_COOLDOWN = 0;

    public final int DOUBLE_SLASH_COOLDOWN = toTicks(5);//100

    public final int STOMP_COOLDOWN = toTicks(0);

    public final int SINGLE_SHOT_LASER_COOLDOWN = toTicks(8);//8

    public final int STOMP_STUN_COOLDOWN = toTicks(8);//160

    public final int ARM_BLOCK_COOLDOWN = toTicks(10);

    public final int QUAD_BEAM_COOLDOWN = 0;

    public final int PARRY_COOLDOWN = toTicks(10);

    public final int ULTIMATE_COOLDOWN = toTicks(30);

    public int stomp_stun_cooldown = 0;
    public int dimensional_shoot_cooldown = 0;
    public int ambush_cooldown = 0;
    public int teleport_fall_cooldown = 0;
    public int kick_smash_grab_cooldown = 0;
    public int jump_teleport_cooldown = 0;
    public int teleport_uppercut_cooldown = 0;

    public int stomp_cooldown = 0;

    public int tracking_ball_charge_cooldown = 0;
    public int double_slash_cooldown = 0;

    public int spin_smash_cooldown = 0;

    public int single_shot_laser_cooldown = 0;
    public int clone_burst_grab_cooldown = 0;

    public int backstep_teleport_slash = 0;

    public int parry_cooldown = 0;

    public int arm_block_cooldown = 0;

    public int ultimate_cooldown = 0;

    public int quad_beam_cooldown = 0;


    /// BOSS EVENT PROCEDURES
    private final LMBossInfoServer bossInfo = new LMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.GREEN, false, 3);

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    private void tickPart(TheObliteratorPart pPart, double pOffsetX, double pOffsetY, double pOffsetZ) {
        pPart.setPos(this.getX() + pOffsetX, this.getY() + pOffsetY, this.getZ() + pOffsetZ);
    }

    public final int TICKS_WITHOUT_TARGET = 40;
    public int ticksWithoutTarget = TICKS_WITHOUT_TARGET;

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
    public boolean isMultipartEntity() {
        return false;
    }


    /// TICKS PROCEDURES
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

    public int InvulnerabilityTime = 0;

    public Random random1 = new Random();

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
    public void tick() {
        AttributeInstance attributeInstance = getAttribute(Attributes.ARMOR_TOUGHNESS);

        if (getPhase() >= 2 && attributeInstance != null) {
            attributeInstance.setBaseValue(2);
        } else if (getPhase() == 1 && attributeInstance != null) {
            attributeInstance.setBaseValue(4);
        }
        if (ticksWithoutTarget == 0 && getTarget() == null && ModConfig.MOB_CONFIG.canBossesResetPhases.get()) {
            if (getIsSecondPhase() && (getCrackiness() == Crackiness.NONE || getCrackiness() == Crackiness.LOW)) {
                setPhase(1);
            } else if (getIsThirdPhase() && (getCrackiness() == Crackiness.MEDIUM)) setPhase(2);
        }
        //   System.out.println("BOOLEAN: " + isTargetCheesing(-4, 4) + " OUTPUT: " + (target().getY() - getY()));

        // System.out.println("State: " + getAttackState());
        // System.out.println("INVUL: "+InvulnerabilityTime);

//        System.out.println("CooldownQuad: " + quad_beam_cooldown);
        if (level() instanceof ServerLevel level) {
            //   System.out.println("SpawnUnlocked: " + ModSavedData.get(level).isDefeatedObliterator());
        }
        if (isVehicle()) {
            if (getFirstPassenger() != null) {
                getFirstPassenger().setShiftKeyDown(false);
            }
        }

        // System.out.println("Animation: " + getAttackState());
        //  System.out.println("JumpCooldown: " + jump_teleport_cooldown);
        if (!bossInfo.getIsDarkenSky() && getIsThirdPhase()) {
            bossInfo.setDarkenScreen(true);
        }
        if (bossInfo.getIsDarkenSky() && !getIsThirdPhase()) {
            bossInfo.setDarkenScreen(false);
        }
        if (getAttackState() == 1 && bossInfo.isVisible()) {
            bossInfo.setVisible(false);
        } else if (!bossInfo.isVisible() && getAttackState() != 1 && tickCount > 5) {
            bossInfo.setVisible(true);
        }
        ;

        //Vertex
        if (this.level().isClientSide) {
            if (getAttackState() == 2) {
            } else {
                this.vertexSize = 0f;
            }

        }
        // System.out.println("hasGrabbed: " + succedGrabbing);
//System.out.println("State: " +getAttackState());
        //Cooldowns

        if (stomp_stun_cooldown > 0) stomp_stun_cooldown--;
        if (teleport_uppercut_cooldown > 0) teleport_uppercut_cooldown--;
        if (single_shot_laser_cooldown > 0) single_shot_laser_cooldown--;
        if (tracking_ball_charge_cooldown > 0) tracking_ball_charge_cooldown--;
        if (dimensional_shoot_cooldown > 0) dimensional_shoot_cooldown--;
        if (teleport_fall_cooldown > 0) teleport_fall_cooldown--;
        if (ambush_cooldown > 0) ambush_cooldown--;
        if (jump_teleport_cooldown > 0) jump_teleport_cooldown--;
        if (clone_burst_grab_cooldown > 0) clone_burst_grab_cooldown--;
        if (kick_smash_grab_cooldown > 0) kick_smash_grab_cooldown--;
        if (backstep_teleport_slash > 0) backstep_teleport_slash--;
        if (spin_smash_cooldown > 0) spin_smash_cooldown--;
        if (double_slash_cooldown > 0) double_slash_cooldown--;
        if (arm_block_cooldown > 0 && getPhase() >= 3) arm_block_cooldown--;
        if (ultimate_cooldown > 0) ultimate_cooldown--;
        if (quad_beam_cooldown > 0) quad_beam_cooldown--;
        if (parry_cooldown > 0) parry_cooldown--;


        if (!this.level().isClientSide()) {
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        }
        if (level().isClientSide) {
            idleAnimationState.animateWhen(getAttackState() == 0, this.tickCount);
        }
        super.tick();

    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (!level().isClientSide)
            regainHealthWithoutTarget(20, 15);

        if (!level().isClientSide && InvulnerabilityTime > 0) InvulnerabilityTime--;
    }

    @Override
    public void aiStep() {
        UpdateWithAttack();
        //teleport trail
        if (isDuringTeleportation(level().isClientSide) && getAttackState() != 13 && getAttackState() != 14 && getAttackState() != 62) {
            float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0;
            float offset = 2;
            float offset2 = -2;

            double dx = getX() + vec * vecX + f * offset;
            double dx2 = getX() + vec * vecX + f * offset2;
            double dy = getY() + 1.5F;
            double dz = getZ() + vec * vecZ + f1 * offset;
            double dz2 = getZ() + vec * vecZ + f1 * offset2;

            float ran = 0.4f;
            float r = 0 / 255F;
            float g = 195 / 255F + random.nextFloat() * ran;
            float b = 0 / 255F;
            if (level().isClientSide) {
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.1F, 2.5f, this.getId())), dx, dy, dz, 0, 0, 0);
                this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.1F, 2.5f, this.getId())), dx2, dy, dz2, 0, 0, 0);
            }
        }
        /*
        for (int k = 0; k < 10; k++) {
            float d1 = Mth.sqrt(k);
            float ran = 0.4f;
            float r = 0 / 255F;
            //   float g = 80 / 255F + random.nextFloat() * ran;
            float b = 75 / 255F;
            // this.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.5f, 0.25f),
            //     getX(), getY(), getZ(), Mth.sin(k), 0, d1*0.01f);
        }
*/

        if (isDuringTeleportation(level().isClientSide) && !isInvisible() && level().isClientSide) {
            setInvisible(true);
        }
        if (!isDuringTeleportation(level().isClientSide) && isInvisible() && level().isClientSide) {
            setInvisible(false);
        }
        if (!isDuringTeleportation(level().isClientSide) && isInvulnerable() && !level().isClientSide) {
            setInvulnerable(false);
        }
        if (!isDuringTeleportation(level().isClientSide)) {
            if (getIsSecondPhase()) {
                if (tickCount % 10 == 0) {
                    for (int i = 0; i < 0.1; ++i) {
                        if (level().isClientSide) {
                            double uniformScale = 0.5f;
                            this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getRandomX(uniformScale), this.getRandomY(), this.getRandomZ(uniformScale), 0D, 0.025D, 0D);
                        }
                    }
                }
            } else if (getIsThirdPhase()) {
                if (tickCount % 3 == 0) {
                    for (int i = 0; i < 0.3; ++i) {
                        if (level().isClientSide) {
                            double uniformScale = 0.5f;
                            this.level().addParticle(ModParticles.BIG_ANNIHILATION_FLAME.get(), this.getRandomX(uniformScale), this.getRandomY(), this.getRandomZ(uniformScale), 0D, 0.025D, 0D);
                        }
                    }
                }
            }
        }
        super.aiStep();
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    /// GOALS
    public int backstepStompRandom = 25;

    public int singleShotLaserRandom = 12;

    public int spinSmashRandom = 32;

    public int doubleSlashRandom = 22;

    public int jumpTeleportRandom = 5;

    public int cloneBurstRandom = 8;

    public int kickSmashRandom = 15;

    public int StompRandom = 20;

    public int teleportGrabRandom = 25;

    public int dimensionalShootRandom = 9;

    public int roarTeleportSmashRandom = 12;

    public int ambushRandom = 5;

    public int parryRandom = 25;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EndersentEntity.class, true));

        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        /// SPAWN
        this.goalSelector.addGoal(0, new IStateGoal(this, 1, 1, 0, toTicks(8), toTicks(8)) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 60, 60, 0, toTicks(5.08f), toTicks(5.08f)) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
            }
        });
/// ULTIMATE
        this.goalSelector.addGoal(0, new UltimateAttackStateGoal(this, 0, 53, 0, 130, 60) {
            @Override
            public boolean canUse() {
                return super.canUse() && canUltimate() && !animationLockedForTests();
            }

            @Override
            public void stop() {
                super.stop();

                ultimate_cooldown = ULTIMATE_COOLDOWN;
            }
        });
        /*
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 53, 0, 123, 123,7f){
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                backstep_teleport_slash = BACKSTEP_STOMP_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && hasTarget() && backstep_teleport_slash <=0 && !animationLockedForTests() && canUltimate();

            }});
*/
        /// PARRY / BLOCK
        this.goalSelector.addGoal(0, new ArmBlockGoal(this, 52, 52, 0, 23, 23) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                arm_block_cooldown = ARM_BLOCK_COOLDOWN;
            }
        });
/// SINGLE - SHOT LASER
        this.goalSelector.addGoal(1, new TeleportAwaySingleLaserShotGoal(this,
                0, 42, 0, 35, 22, 30, 7) {//atkstick 22, new old
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < singleShotLaserRandom
                        && hasTarget() && single_shot_laser_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        //Teleport Away
        this.goalSelector.addGoal(1, new SingleShotLaserGoal(this,
                0, 21, 0, 49, 38, 6) {//atkseetick 36, new old 38
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < singleShotLaserRandom
                        && hasTarget() && single_shot_laser_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        //End
        this.goalSelector.addGoal(0, new IStateGoal(this, 45, 45, 0, 18, 5) {//14
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                single_shot_laser_cooldown = SINGLE_SHOT_LASER_COOLDOWN;
            }
        });
        //Quad Laser End
        this.goalSelector.addGoal(0, new QuadLaserBeamStateGoal(this, 46, 46, 0, 111, 46) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();
                quad_beam_cooldown = QUAD_BEAM_COOLDOWN;
                single_shot_laser_cooldown = SINGLE_SHOT_LASER_COOLDOWN;
            }
        });
        //Teleport End
        this.goalSelector.addGoal(0, new IStateGoal(this, 44, 44, 0, 32, 24) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                single_shot_laser_cooldown = SINGLE_SHOT_LASER_COOLDOWN;
            }
        });
        /// PHASE CHANGE
        //P2
        this.goalSelector.addGoal(0, new SecondPhaseStateGoal(this, 0, 2, 0, 88, 0) {
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
        //P3
        this.goalSelector.addGoal(0, new ThirdPhaseStateGoal(this, 0, 48, 0, 132, 132) {
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

        /// BACKSTEP STOMP
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 28, 0, 68, 38, 5f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                backstep_teleport_slash = BACKSTEP_STOMP_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < backstepStompRandom
                        && hasTarget() && backstep_teleport_slash <= 0 && getNextbackstepStompType() == 1 && !animationLockedForTests() && !canUltimate();

            }
        });

        //RIGHT
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 29, 0, 68, 40, 5f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                backstep_teleport_slash = BACKSTEP_STOMP_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < backstepStompRandom
                        && hasTarget() && backstep_teleport_slash <= 0 && getNextbackstepStompType() == 2 && !animationLockedForTests() && !canUltimate();

            }
        });
        //SPIN
        /// KICK SMASH GRAB
        this.goalSelector.addGoal(1, new KickSmashGoal(this,
                0, 36, 0, 43, 7, 30, 101, 5f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                // kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < kickSmashRandom
                        && hasTarget() && kick_smash_grab_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        /// PARRY
        //PARRY PRE
        this.goalSelector.addGoal(1, new ParryGoal(this, 0, 56, 0, 24, 23, 18f, 7f) {
            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < parryRandom
                        && hasTarget() && parry_cooldown <= 0 && !canUltimate() && getPhase() >= 4;

            }
        });
        //PARRY FRAME
        this.goalSelector.addGoal(1, new ParryFrameStateGoal(this, 57, 57, 58, 30, 30) {
        });
        //PARRY FAIL
        this.goalSelector.addGoal(0, new IStateGoal(this, 58, 58, 0, 20, 20) {
            @Override
            public void stop() {
                super.stop();
                gambitParry = false;
                parry_cooldown = PARRY_COOLDOWN;
            }
        });
        //PARRY SUCCESS
        this.goalSelector.addGoal(0, new IStateGoal(this, 59, 59, 0, 93, 61) {
            @Override
            public void stop() {
                super.stop();
                gambitParry = false;
                parry_cooldown = PARRY_COOLDOWN;
            }
        });
        /// CRUSH GRAB STATES
        //Right
        this.goalSelector.addGoal(0, new TheObliteratorCrushGrabStateGoal(this, 37, 37, 41, 26, 26) {//27,27
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        //Left
        this.goalSelector.addGoal(0, new TheObliteratorCrushGrabStateGoal(this, 49, 49, 51, 26, 26) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        //Grab State
        this.goalSelector.addGoal(0, new IStateGoal(this, 41, 41, 0, 26, 0) {//27
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 40, 40, 0, 85, 0) {//44
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        //Left Grab States
        this.goalSelector.addGoal(0, new IStateGoal(this, 51, 51, 0, 27, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 50, 50, 0, 85, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        //Teleport
        this.goalSelector.addGoal(0, new TheObliteratorCrushGrabStateGoal(this, 39, 39, 41, 31, 31) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 38, 38, 0, 17, 5) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                kick_smash_grab_cooldown = KICK_SMASH_GRAB_COOLDOWN;
            }
        });
        /// STOMP
        this.goalSelector.addGoal(1, new StompGoal(this,
                0, 34, 0, 23, 23, 5f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                if (!level().isClientSide) {
                    if (stomp_stun_cooldown <= 0) {
                        switch (entity.getRandom().nextInt(2)) {
                            case 0 -> entity.setAttackState(33);

                            case 1 -> entity.setAttackState(35);

                            // case 2-> entity.setAttackState(33);
                        }
                    } else {
                        entity.setAttackState(33);
                    }
                }
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < StompRandom
                        && hasTarget() && stomp_cooldown <= 0 && !canUltimate();

            }
        });
        this.goalSelector.addGoal(0, new StompStunGoal(this, 35, 35, 0, 65, 35) {//atkseetick 35
            public void start() {
                super.start();

            }

            @Override
            public void tick() {

                super.tick();
            }

            @Override
            public void stop() {
                super.stop();
                stomp_stun_cooldown = STOMP_STUN_COOLDOWN;
                stomp_cooldown = STOMP_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new StompKickGoal(this, 33, 33, 0, 67, 24) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                stomp_cooldown = STOMP_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new StompKickGoal(this, 43, 43, 0, 53, 33) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                stomp_cooldown = STOMP_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 1, 1, 0, 27, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                stomp_cooldown = STOMP_COOLDOWN;
            }
        });

        /// CLONE BURST GRAB
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 24, 0, 135, 95, 8f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                clone_burst_grab_cooldown = CLONE_BURST_GRAB_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < cloneBurstRandom
                        && hasTarget() && clone_burst_grab_cooldown <= 0 && getPhase() >= 2 && !canUltimate();

            }
        });
        /// JUMP TELEPORT
        this.goalSelector.addGoal(1, new JumpTeleportGoal(this,
                0, 22, 0, 150, 55, 80, 100, 16F) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                super.stop();
                jump_teleport_cooldown = JUMP_TELEPORT_COOLDOWN;

            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < jumpTeleportRandom
                        && hasTarget() && jump_teleport_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });

        /// TELEPORT GRABS
        float distance = 4;
        this.goalSelector.addGoal(1, new CloseTeleportGrabGoal(this, 0, 17, targetIsNotNull() && distanceTo(target()) > distance ? 61 : 30, 30, 14, 8f, 4.6f) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < teleportGrabRandom && TheObliteratorEntity.this.teleport_uppercut_cooldown <= 0
                        && TheObliteratorEntity.this.getTarget() != null && !canUltimate() && !animationLockedForTests();
            }

            @Override
            public void stop() {
                randomizeAllAttackTypes();
                //teleport_uppercut_cooldown = TELEPORT_UPPERCUT_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new TeleportGrabGoal(this, 0, 47, targetIsNotNull() && distanceTo(target()) > distance ? 61 : 30, 70, 53, 4.5f) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < teleportGrabRandom && TheObliteratorEntity.this.teleport_uppercut_cooldown <= 0
                        && TheObliteratorEntity.this.getTarget() != null && !canUltimate() && !animationLockedForTests();
            }

            @Override
            public void stop() {
                randomizeAllAttackTypes();
                //teleport_uppercut_cooldown = TELEPORT_UPPERCUT_COOLDOWN;
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 30, 30, 0, 47, 18) {//aft = 44, ast = 18 | Old 38, 15
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                teleport_uppercut_cooldown = TELEPORT_GRAB_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 61, 61, 0, 20, 20) {//aft = 44, ast = 18 | Old 38, 15
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

                teleport_uppercut_cooldown = TELEPORT_GRAB_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 18, 18, 19, 18, 19) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 19, 19, 20, 9, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                super.stop();

            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 20, 20, 0, 32, 0) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {

                teleport_uppercut_cooldown = TELEPORT_GRAB_COOLDOWN;
                super.stop();

            }
        });

///SLASH COMBO
        int slashComboTick = 68;
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 15, 0, slashComboTick, slashComboTick, 6f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < doubleSlashRandom
                        && hasTarget() && getNextDoubleSlashType() == 1 && double_slash_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this,
                0, 31, 0, slashComboTick, slashComboTick, 6f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < doubleSlashRandom
                        && hasTarget() && getNextDoubleSlashRightType() == 1 && double_slash_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        //Teleport Variant
        this.goalSelector.addGoal(1, new TeleportDoubleSlashGoal(this,
                0, 23, 0, 84, 84, 6f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < doubleSlashRandom
                        && hasTarget() && getNextDoubleSlashType() == 2 && double_slash_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
        //Right
        this.goalSelector.addGoal(1, new TeleportDoubleSlashGoal(this,
                0, 32, 0, 84, 84, 6f) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                double_slash_cooldown = DOUBLE_SLASH_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < doubleSlashRandom
                        && hasTarget() && double_slash_cooldown <= 0 && !canUltimate() && getNextDoubleSlashRightType() == 2 && !animationLockedForTests();

            }
        });
        ///SPIN SMASHES
        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this,
                0, 4, 0, 69, 30, 30, 30, 6F) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                spin_smash_cooldown = SPIN_SMASH_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < spinSmashRandom
                        && hasTarget() && getNextSpinSmashType() == 1 && !animationLockedForTests() && spin_smash_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });

        this.goalSelector.addGoal(1, new ITwoHitAttackGoal(this,
                0, 5, 0, 69, 30, 30, 30, 6F) {
            @Override
            public void stop() {
                randomizeAllAttackTypes();
                spin_smash_cooldown = SPIN_SMASH_COOLDOWN;
                super.stop();
                ;
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < spinSmashRandom
                        && hasTarget() && getNextSpinSmashType() == 2 && !animationLockedForTests() && spin_smash_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }
        });
/// DIMENSIONAL SHOOT
        this.goalSelector.addGoal(1, new BombShootGoal(this, 0, 6, 0, 38, 63, 12) {//atst and max old 63

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < dimensionalShootRandom
                        && hasTarget() && dimensional_shoot_cooldown <= 0 && !canUltimate() && !animationLockedForTests();

            }

            @Override
            public void stop() {
                // dimensional_shoot_cooldown = DIMENSIONAL_SHOOT_COOLDOWN;
                //randomizeAllAttackTypes();
                super.stop();
                ;
            }

        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 54, 54, 0, 24, 10) {
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                randomizeAllAttackTypes();
                dimensional_shoot_cooldown = DIMENSIONAL_SHOOT_COOLDOWN;
                super.stop();

            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 55, 55, 0, 60, 60) {
            public void start() {
                canShootTwice = false;
                super.start();

            }

            @Override
            public void stop() {

                canShootTwice = false;
                randomizeAllAttackTypes();
                dimensional_shoot_cooldown = DIMENSIONAL_SHOOT_COOLDOWN;
                super.stop();

            }
        });
        /*this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 90, 90, 12) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < dimensionalShootRandom
                        && hasTarget() && getNextDimensionalShootType() == 2 && dimensional_shoot_cooldown <= 0 && !animationLockedForTests() && !canUltimate();

            }

            @Override
            public void stop() {

                dimensional_shoot_cooldown = DIMENSIONAL_SHOOT_COOLDOWN;
                randomizeAllAttackTypes();
                super.stop();
                ;
            }


        });*/
        ///ROAR TELEPORT SMASH
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 9, 10, 100, 54, 8) {
            @Override
            public void stop() {
                setNoGravity(false);
                setInvulnerable(false);
                setDeltaMovement(0, -0.1f, 0);
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < roarTeleportSmashRandom && TheObliteratorEntity.this.teleport_fall_cooldown <= 0
                        && TheObliteratorEntity.this.getTarget() != null && !canUltimate() && !animationLockedForTests();
            }
        });

        //teleport idle
        this.goalSelector.addGoal(1, new IStateGoal(this, 10, 10, 11, 100, 100) {
            @Override
            public boolean canUse() {
                return super.canUse() && getNextRoarAttackType() == 1;
            }
        });
        // FOR TELEPORT LAND 2 TIMES
        this.goalSelector.addGoal(1, new IStateGoal(this, 10, 10, 12, 100, 100) {
            @Override
            public void start() {
                hasStartedSecondTeleportSmash = false;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && (getNextRoarAttackType() == 2 && !getHasStartedSecondTeleportSmash());
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 10, 10, 11, 100, 100) {
            @Override
            public boolean canUse() {
                return super.canUse() && (getNextRoarAttackType() == 2 && getHasStartedSecondTeleportSmash());
            }


        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 10, 24, 100) {
            @Override
            public void start() {
                hasStartedSecondTeleportSmash = true;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && getNextRoarAttackType() == 2;
            }
        });

        //teleport smash End
        this.goalSelector.addGoal(0, new IStateGoal(this, 11, 11, 0, 40, 0) {
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
                randomizeAllAttackTypes();
                TheObliteratorEntity.this.teleport_fall_cooldown = TELEPORT_FALL_COOLDOWN;
            }
        });
        /// AMBUSH ATTACKS
        this.goalSelector.addGoal(1, new AmbushGoal(this, 0, 13, 0, 81, 81, 12) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < ambushRandom
                        && hasTarget() && ambush_cooldown <= 0 && getNextAmbushType() == 2 && !canUltimate() && getPhase() <= 1;

            }

            @Override
            public void tick() {
                super.tick();
            }


            @Override
            public void stop() {

                ambush_cooldown = AMBUSH_COOLDOWN;
                randomizeAllAttackTypes();
                super.stop();
                ;
            }


        });
        this.goalSelector.addGoal(1, new AmbushLongerGoal(this, 0, 62, 0, 100, 100, 12) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < ambushRandom
                        && hasTarget() && ambush_cooldown <= 0 && getNextAmbushType() == 2 && !canUltimate() && getPhase() >= 2;

            }

            @Override
            public void tick() {
                super.tick();
            }


            @Override
            public void stop() {

                ambush_cooldown = AMBUSH_COOLDOWN;
                randomizeAllAttackTypes();
                super.stop();
                ;
            }


        });
        //WITH SWAP
        this.goalSelector.addGoal(1, new AmbushSwapGoal(this, 0, 14, 0, 130, 130, 12) {

            public boolean canUse() {
                return super.canUse() && TheObliteratorEntity.this.getRandom().nextFloat() * 100.0F < ambushRandom
                        && hasTarget() && ambush_cooldown <= 0 && getNextAmbushType() == 22;

            }

            @Override
            public void tick() {
                super.tick();
            }


            @Override
            public void stop() {

                ambush_cooldown = AMBUSH_COOLDOWN;
                randomizeAllAttackTypes();
                super.stop();
                ;
            }


        });
    }


    /// RANDOMS
    public void randomizeAllAttackTypes() {
//randomizeDelay();
        randomizeNextSpinSmashType(2);
        randomizeNextDimensionalShootType(2);
        randomizeNextRoarTeleportSmashType(2);
        randomizeNextAmbushType(2);
        randomizeNextDoubleSlashType(2);
        randomizeNextbackstepStompType(2);
        randomizeNextDoubleSlashRightType(2);
    }

    public void randomizeDelay() {
        switch (random.nextInt(3)) {
            case 0 -> delay = 3;

            case 1 -> delay = 1;

            case 2 -> delay = targetIsNotNull() && distanceTo(target()) > 8 ? 15 : 6;
        }
    }

    //Spin Smash
    public int spinSmashAttackType = 1;

    public int getNextSpinSmashType() {
        return spinSmashAttackType;
    }

    public void randomizeNextSpinSmashType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> spinSmashAttackType = 1;

            case 1 -> spinSmashAttackType = 2;

        }
    }

//DIMENSIONAL SHOOT

    public int dimensionalShootType = 2;

    public int getNextDimensionalShootType() {
        return spinSmashAttackType;
    }

    public void randomizeNextDimensionalShootType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> dimensionalShootType = 2;

            case 1 -> dimensionalShootType = 1;
        }
    }
    //DOUBLE SLASH

    public int doubleSlashType = 1;

    public int getNextDoubleSlashType() {
        return doubleSlashType;
    }

    public void randomizeNextDoubleSlashType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> doubleSlashType = 1;

            case 1 -> doubleSlashType = 2;
        }
    }

    //DOUBLE SLASH RIGHT
    public int doubleSlashRightType = 1;

    public int getNextDoubleSlashRightType() {
        return doubleSlashRightType;
    }

    public void randomizeNextDoubleSlashRightType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> doubleSlashRightType = 1;

            case 1 -> doubleSlashRightType = 2;

        }
    }

    //TELEPORT ROAR SMASH

    public boolean hasStartedSecondTeleportSmash = false;

    public boolean getHasStartedSecondTeleportSmash() {
        return hasStartedSecondTeleportSmash;
    }

    public int roar_teleport_type = 1;

    public int getNextRoarAttackType() {
        return roar_teleport_type;
    }

    public void randomizeNextRoarTeleportSmashType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> roar_teleport_type = 1;

            case 1 -> {
                hasStartedSecondTeleportSmash = false;
                roar_teleport_type = 2;
            }
        }
    }

    //AMBUSH
    public int ambushType = 2;

    public int getNextAmbushType() {
        return ambushType;
    }

    public void randomizeNextAmbushType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> ambushType = 2;

            case 1 -> ambushType = 2;
        }
    }
//BACKSTEP STOMP

    public int backstepStompType = 1;

    public int getNextbackstepStompType() {
        return backstepStompType;
    }

    public void randomizeNextbackstepStompType(int rolls) {
        switch (random.nextInt(rolls)) {
            case 0 -> backstepStompType = 1;

            case 1 -> {
                switch (random.nextInt(2)) {
                    case 0 -> backstepStompType = 2;
                    case 1 -> backstepStompType = 3;
                }
            }
        }
    }

    /// ANIMATION STATE REGISTRY
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState spinSmashLeftAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState spinSmashRightAnimationState = new AnimationState();
    public AnimationState shootOnceAnimationState = new AnimationState();

    public AnimationState shootDoubleAnimationState = new AnimationState();

    public AnimationState doubleLeftHookComboAnimationState = new AnimationState();

    public AnimationState roarTeleportAnimationState = new AnimationState();
    public AnimationState landAnimationState = new AnimationState();
    public AnimationState landAgainAnimationState = new AnimationState();

    public AnimationState fallAnimationState = new AnimationState();

    public AnimationState ambushAnimationState = new AnimationState();

    public AnimationState ambushSwapAnimationState = new AnimationState();

    public AnimationState slashComboAnimationState = new AnimationState();

    public AnimationState teleportUppercutAnimationState = new AnimationState();
    public AnimationState teleportGrabPreAnimationState = new AnimationState();
    public AnimationState teleportGrabSuccessAnimationState = new AnimationState();
    public AnimationState teleportGrabFallAnimationState = new AnimationState();
    public AnimationState teleportGrabLandAnimationState = new AnimationState();
    public AnimationState teleportGrabFailRiseUpAnimationState = new AnimationState();

    public AnimationState jumpTeleportAnimationState = new AnimationState();

    public AnimationState teleportSlashComboAnimationState = new AnimationState();

    public AnimationState cloneBurstGrabAnimationState = new AnimationState();

    public AnimationState kickSmashGrabAnimationState = new AnimationState();

    public AnimationState rightSpinTeleportSmashAnimationState = new AnimationState();

    public AnimationState backstepTeleportSlashP2AnimationState = new AnimationState();

    public AnimationState backstepStompLeftAnimationState = new AnimationState();

    public AnimationState backstepStompRightAnimationState = new AnimationState();

    public AnimationState teleportGrabFailCrossSlashAnimationState = new AnimationState();

    public AnimationState teleportSlashComboRightAnimationState = new AnimationState();

    public AnimationState slashComboRightAnimationState = new AnimationState();

    public AnimationState trackingBallChargeAnimationState = new AnimationState();

    public AnimationState smashGroundKickAnimationState = new AnimationState();

    public AnimationState stompAnimationState = new AnimationState();

    public AnimationState stunStompAnimationState = new AnimationState();

    public AnimationState stompKickAnimationState = new AnimationState();

    public AnimationState spawnAnimationState = new AnimationState();

    public AnimationState stompAfterkickLeftAnimationState = new AnimationState();

    public AnimationState kickSmashAnimationState = new AnimationState();

    public AnimationState grabAfterKickSmashAnimationState = new AnimationState();

    public AnimationState kickSmashByeByeAnimationState = new AnimationState();

    public AnimationState p2AnimationState = new AnimationState();
    public AnimationState teleportGrabAfterKickSmashAnimationState = new AnimationState();

    public AnimationState crushGrabSuccessAnimationState = new AnimationState();

    public AnimationState crushGrabFailAnimationState = new AnimationState();

    public AnimationState singleShotLaserAnimationState = new AnimationState();

    public AnimationState singleShotLaserAfterStompAnimationState = new AnimationState();

    public AnimationState singleShotLaserTeleportEndAnimationState = new AnimationState();

    public AnimationState singleShotLaserEndAnimationState = new AnimationState();

    public AnimationState teleportAwaySingleShotLaserAnimationState = new AnimationState();

    public AnimationState singleShotLaserQuadEndAnimationState = new AnimationState();

    public AnimationState closeGrabPreAnimationState = new AnimationState();

    public AnimationState backstepStompRightSpinAnimationState = new AnimationState();

    public AnimationState p3AnimationState = new AnimationState();
    public AnimationState LeftgrabAfterKickSmashAnimationState = new AnimationState();
    public AnimationState LeftcrushGrabSuccessAnimationState = new AnimationState();

    public AnimationState LeftcrushGrabFailAnimationState = new AnimationState();
    public AnimationState ArmBlockAnimationState = new AnimationState();

    public AnimationState PortalUltimateAnimationState = new AnimationState();

    public AnimationState BombShootOnceEndAnimationState = new AnimationState();

    public AnimationState BombShootDoubleEndAnimationState = new AnimationState();

    public AnimationState ParryPreAnimationState = new AnimationState();

    public AnimationState ParryFrameAnimationState = new AnimationState();

    public AnimationState ParryFailAnimationState = new AnimationState();

    public AnimationState ParrySuccessAnimationState = new AnimationState();

    public AnimationState DeathAnimationState = new AnimationState();

    public AnimationState KickAnimationState = new AnimationState();
    public AnimationState KickSmashAnimationState = new AnimationState();
    public AnimationState KickByeAnimationState = new AnimationState();
    ;
    public AnimationState TpGrabFail0AnimationState = new AnimationState();

    public AnimationState AmbushLongerAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "spin_smash") {
            return this.spinSmashRightAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "spin_smash_left") {
            return this.spinSmashLeftAnimationState;
        } else if (input == "shoot_once") {
            return this.shootOnceAnimationState;
        } else if (input == "shoot_double") {
            return this.shootDoubleAnimationState;
        } else if (input == "left_hook_db_combo") {
            return this.doubleLeftHookComboAnimationState;
        } else if (input == "land") {
            return this.landAnimationState;
        } else if (input == "roar_teleport") {
            return this.roarTeleportAnimationState;
        } else if (input == "land_again") {
            return this.landAgainAnimationState;
        } else if (input == "fall") {
            return this.fallAnimationState;
        } else if (input == "ambush") {
            return this.ambushAnimationState;
        } else if (input == "ambush_swap") {
            return this.ambushSwapAnimationState;
        } else if (input == "slash_combo") {
            return this.slashComboAnimationState;
        } else if (input == "teleport_uppercut") {
            return this.teleportUppercutAnimationState;
        } else if (input == "teleport_grab_fall") {
            return this.teleportGrabFallAnimationState;
        } else if (input == "teleport_grab_pre") {
            return this.teleportGrabPreAnimationState;
        } else if (input == "teleport_grab_land") {
            return this.teleportGrabLandAnimationState;
        } else if (input == "teleport_grab_success") {
            return this.teleportGrabSuccessAnimationState;
        } else if (input == "jump_teleport") {
            return this.jumpTeleportAnimationState;
        } else if (input == "teleport_slash_combo") {
            return this.teleportSlashComboAnimationState;
        } else if (input == "clone_burst_grab") {
            return this.cloneBurstGrabAnimationState;
        } else if (input == "kick_smash_grab") {
            return this.kickSmashGrabAnimationState;
        } else if (input == "right_spin_teleport_smash") {
            return this.rightSpinTeleportSmashAnimationState;
        } else if (input == "backstep_teleport_slash_p2") {
            return this.backstepTeleportSlashP2AnimationState;
        } else if (input == "backstep_stomp_left") {
            return this.backstepStompLeftAnimationState;
        } else if (input == "backstep_stomp_right") {
            return this.backstepStompRightAnimationState;
        } else if (input == "teleport_grab_fail_cross_slash") {
            return this.teleportGrabFailCrossSlashAnimationState;
        } else if (input == "slash_combo_right") {
            return this.slashComboRightAnimationState;
        } else if (input == "teleport_slash_combo_right") {
            return this.teleportSlashComboRightAnimationState;
        } else if (input == "stomp_kick") {
            return this.stompKickAnimationState;
        } else if (input == "stomp") {
            return this.stompAnimationState;
        } else if (input == "stomp_stun_teleport") {
            return this.stunStompAnimationState;
        } else if (input == "spawn") {
            return this.spawnAnimationState;
        } else if (input == "kick_smash") {
            return this.kickSmashAnimationState;
        } else if (input == "grab_after_kick_smash") {
            return this.grabAfterKickSmashAnimationState;
        } else if (input == "kick_smash_bye_bye") {
            return this.kickSmashByeByeAnimationState;
        } else if (input == "p2") {
            return this.p2AnimationState;
        } else if (input == "teleport_grab_after_kick_smash") {
            return this.teleportGrabAfterKickSmashAnimationState;
        } else if (input == "crush_grab_success") {
            return this.crushGrabSuccessAnimationState;
        } else if (input == "crush_grab_fail") {
            return this.crushGrabFailAnimationState;
        } else if (input == "single_shot_laser") {
            return this.singleShotLaserAnimationState;
        } else if (input == "single_shot_laser_after_stomp") {
            return this.singleShotLaserAfterStompAnimationState;
        } else if (input == "single_shot_laser_end") {
            return this.singleShotLaserEndAnimationState;
        } else if (input == "single_shot_laser_teleport_end") {
            return this.singleShotLaserTeleportEndAnimationState;
        } else if (input == "teleport_away_single_shot_laser") {
            return this.teleportAwaySingleShotLaserAnimationState;
        } else if (input == "single_shot_laser_quad_end") {
            return this.singleShotLaserQuadEndAnimationState;
        } else if (input == "close_pre_teleport_grab") {
            return this.closeGrabPreAnimationState;
        } else if (input == "left_grab_after_kick_smash") {
            return this.LeftgrabAfterKickSmashAnimationState;
        } else if (input == "left_crush_grab_success") {
            return this.LeftcrushGrabSuccessAnimationState;
        } else if (input == "left_crush_grab_fail") {
            return this.LeftcrushGrabFailAnimationState;
        } else if (input == "p3") {
            return this.p3AnimationState;
        } else if (input == "arm_block") {
            return this.ArmBlockAnimationState;
        } else if (input == "ultimate") {
            return this.PortalUltimateAnimationState;
        } else if (input == "shoot_once_end") {
            return this.BombShootOnceEndAnimationState;
        } else if (input == "shoot_double_end") {
            return this.BombShootDoubleEndAnimationState;
        } else if (input == "parry_pre") {
            return this.ParryPreAnimationState;
        } else if (input == "parry_frame") {
            return this.ParryFrameAnimationState;
        } else if (input == "parry_fail") {
            return this.ParryFailAnimationState;
        } else if (input == "parry_success") {
            return this.ParrySuccessAnimationState;
        } else if (input == "death") {
            return this.DeathAnimationState;
        } else if (input == "teleport_grab_fail_0") {
            return this.TpGrabFail0AnimationState;
        } else if (input == "ambush_longer") {
            return this.AmbushLongerAnimationState;
        } else {
            return new AnimationState();
        }
    }


    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {

                    case 0 -> {
                        this.stopAllAnimationStates();

                    }
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.spawnAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.p2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.spinSmashRightAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.spinSmashLeftAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.shootOnceAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.shootDoubleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.doubleLeftHookComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.roarTeleportAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.fallAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.landAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.landAgainAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.ambushAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.ambushSwapAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.slashComboAnimationState.startIfStopped(this.tickCount);
                    }

                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.teleportUppercutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabFallAnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabLandAnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.teleportAwaySingleShotLaserAnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.jumpTeleportAnimationState.startIfStopped(this.tickCount);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.teleportSlashComboAnimationState.startIfStopped(this.tickCount);
                    }

                    case 24 -> {
                        this.stopAllAnimationStates();
                        this.cloneBurstGrabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 25 -> {
                        this.stopAllAnimationStates();
                        this.kickSmashGrabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 26 -> {
                        this.stopAllAnimationStates();
                        this.rightSpinTeleportSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 27 -> {
                        this.stopAllAnimationStates();
                        this.backstepTeleportSlashP2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 28 -> {
                        this.stopAllAnimationStates();
                        this.backstepStompLeftAnimationState.startIfStopped(this.tickCount);
                    }
                    case 29 -> {
                        this.stopAllAnimationStates();
                        this.backstepStompRightAnimationState.startIfStopped(this.tickCount);
                    }
                    case 30 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabFailCrossSlashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 31 -> {
                        this.stopAllAnimationStates();
                        this.slashComboRightAnimationState.startIfStopped(this.tickCount);
                    }

                    case 32 -> {
                        this.stopAllAnimationStates();
                        this.teleportSlashComboRightAnimationState.startIfStopped(this.tickCount);
                    }
                    case 33 -> {
                        this.stopAllAnimationStates();
                        this.stompKickAnimationState.startIfStopped(this.tickCount);
                    }
                    case 34 -> {
                        this.stopAllAnimationStates();
                        this.stompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 35 -> {
                        this.stopAllAnimationStates();
                        this.stunStompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 36 -> {
                        this.stopAllAnimationStates();
                        this.kickSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 37 -> {
                        this.stopAllAnimationStates();
                        this.grabAfterKickSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 38 -> {
                        this.stopAllAnimationStates();
                        this.kickSmashByeByeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 39 -> {
                        this.stopAllAnimationStates();
                        this.teleportGrabAfterKickSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 40 -> {
                        this.stopAllAnimationStates();
                        this.crushGrabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 41 -> {
                        this.stopAllAnimationStates();
                        this.crushGrabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 42 -> {
                        this.stopAllAnimationStates();
                        this.singleShotLaserAnimationState.startIfStopped(this.tickCount);
                    }
                    case 43 -> {
                        this.stopAllAnimationStates();
                        this.singleShotLaserAfterStompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 44 -> {
                        this.stopAllAnimationStates();
                        this.singleShotLaserTeleportEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 45 -> {
                        this.stopAllAnimationStates();
                        this.singleShotLaserEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 46 -> {
                        this.stopAllAnimationStates();
                        this.singleShotLaserQuadEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 47 -> {
                        this.stopAllAnimationStates();
                        this.closeGrabPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 48 -> {
                        this.stopAllAnimationStates();
                        this.p3AnimationState.startIfStopped(this.tickCount);
                    }
                    case 49 -> {
                        this.stopAllAnimationStates();
                        this.LeftgrabAfterKickSmashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 50 -> {
                        this.stopAllAnimationStates();
                        this.LeftcrushGrabSuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 51 -> {
                        this.stopAllAnimationStates();
                        this.LeftcrushGrabFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 52 -> {
                        this.stopAllAnimationStates();
                        this.ArmBlockAnimationState.startIfStopped(this.tickCount);
                    }
                    case 53 -> {
                        this.stopAllAnimationStates();
                        this.PortalUltimateAnimationState.startIfStopped(this.tickCount);
                    }
                    case 54 -> {
                        this.stopAllAnimationStates();
                        this.BombShootOnceEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 55 -> {
                        this.stopAllAnimationStates();
                        this.BombShootDoubleEndAnimationState.startIfStopped(this.tickCount);
                    }
                    case 56 -> {
                        this.stopAllAnimationStates();
                        this.ParryPreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 57 -> {
                        this.stopAllAnimationStates();
                        this.ParryFrameAnimationState.startIfStopped(this.tickCount);
                    }
                    case 58 -> {
                        this.stopAllAnimationStates();
                        this.ParryFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 59 -> {
                        this.stopAllAnimationStates();
                        this.ParrySuccessAnimationState.startIfStopped(this.tickCount);
                    }
                    case 60 -> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 61 -> {
                        this.stopAllAnimationStates();
                        this.TpGrabFail0AnimationState.startIfStopped(this.tickCount);
                    }
                    case 62 -> {
                        this.stopAllAnimationStates();
                        this.AmbushLongerAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        AmbushLongerAnimationState.stop();
        KickSmashAnimationState.stop();
        TpGrabFail0AnimationState.stop();
        ArmBlockAnimationState.stop();
        awakeAnimationState.stop();
        sleepAnimationState.stop();
        idleAnimationState.stop();
        spinSmashRightAnimationState.stop();
        spinSmashLeftAnimationState.stop();
        shootOnceAnimationState.stop();
        shootDoubleAnimationState.stop();
        doubleLeftHookComboAnimationState.stop();
        teleportUppercutAnimationState.stop();
        fallAnimationState.stop();
        landAnimationState.stop();
        landAgainAnimationState.stop();
        roarTeleportAnimationState.stop();
        ambushAnimationState.stop();
        slashComboAnimationState.stop();
        ambushSwapAnimationState.stop();
        teleportGrabFailRiseUpAnimationState.stop();
        teleportGrabFallAnimationState.stop();
        teleportGrabSuccessAnimationState.stop();
        teleportGrabLandAnimationState.stop();
        teleportGrabPreAnimationState.stop();
        jumpTeleportAnimationState.stop();
        teleportSlashComboAnimationState.stop();
        cloneBurstGrabAnimationState.stop();
        kickSmashGrabAnimationState.stop();
        rightSpinTeleportSmashAnimationState.stop();
        backstepTeleportSlashP2AnimationState.stop();
        backstepStompLeftAnimationState.stop();
        backstepStompRightAnimationState.stop();
        teleportGrabFailCrossSlashAnimationState.stop();
        slashComboRightAnimationState.stop();
        teleportSlashComboRightAnimationState.stop();
        trackingBallChargeAnimationState.stop();
        smashGroundKickAnimationState.stop();
        stompAnimationState.stop();
        stunStompAnimationState.stop();
        stompKickAnimationState.stop();
        spawnAnimationState.stop();
        stompAfterkickLeftAnimationState.stop();
        kickSmashByeByeAnimationState.stop();
        kickSmashAnimationState.stop();
        grabAfterKickSmashAnimationState.stop();
        p2AnimationState.stop();
        teleportGrabAfterKickSmashAnimationState.stop();
        crushGrabFailAnimationState.stop();
        crushGrabSuccessAnimationState.stop();
        singleShotLaserAnimationState.stop();
        singleShotLaserAfterStompAnimationState.stop();
        singleShotLaserEndAnimationState.stop();
        singleShotLaserTeleportEndAnimationState.stop();
        teleportAwaySingleShotLaserAnimationState.stop();
        singleShotLaserQuadEndAnimationState.stop();
        closeGrabPreAnimationState.stop();
        p3AnimationState.stop();
        LeftcrushGrabSuccessAnimationState.stop();
        LeftgrabAfterKickSmashAnimationState.stop();
        LeftcrushGrabFailAnimationState.stop();
        PortalUltimateAnimationState.stop();
        BombShootOnceEndAnimationState.stop();
        BombShootDoubleEndAnimationState.stop();
        ParryPreAnimationState.stop();
        ParryFrameAnimationState.stop();
        ParryFailAnimationState.stop();
        ParrySuccessAnimationState.stop();
        DeathAnimationState.stop();
    }

    @Override
    public void push(Entity entityIn) {
        super.push(entityIn);
    }


    @Override
    public void push(double pX, double pY, double pZ) {
        // super.push(pX,pY,pZ);
    }


    @Override
    public void positionRider(Entity passenger, MoveFunction moveFunc) {
        if (!hasPassenger(passenger)) return;

        if (getAttackState() == 20 || getAttackState() == 18 || getAttackState() == 19) {

            float offset = 0f;
            float startPos = 3.5f;
            float cos = Mth.cos(this.yBodyRot * (float) Math.PI / 180F);
            float sin = Mth.sin(this.yBodyRot * (float) Math.PI / 180F);
            double theta = Math.toRadians(this.yBodyRot + 90);
            double vecX = Math.cos(theta), vecZ = Math.sin(theta);
            int state = this.getAttackState();
            if (state >= 17 && state <= 20) {
                passenger.fallDistance = 0f;

            }

            float yOffset;
            float startYOffset = 3f;
            float endYOffset = 0;
            if (this.getAttackState() == 20) {

                int maxTicks = 5;
                float t = Mth.clamp((float) attackTicks / maxTicks, 0f, 1f);

                yOffset = Mth.lerp(t, startYOffset, endYOffset);

            } else {

                yOffset = startYOffset;
            }

            double riderX = this.getX() + startPos * vecX + cos * offset;
            double riderZ = this.getZ() + startPos * vecZ + sin * offset;
            double riderY = this.getY() + yOffset;
            if (getAttackState() == 20 || getAttackState() == 18 || getAttackState() == 19) {
                moveFunc.accept(passenger, riderX, riderY, riderZ);
            }
        }
        if (getAttackState() == 40 || getAttackState() == 37) {

            double theta = Math.toRadians(this.yBodyRot + 90);
            double forwardX = Math.cos(theta), forwardZ = Math.sin(theta);
            float cosYaw = Mth.cos(this.yBodyRot * ((float) Math.PI / 180));
            float sinYaw = Mth.sin(this.yBodyRot * ((float) Math.PI / 180));

            float startDistance = 3f;
            float endDistance = 2f;
            int distanceTicks = 10;

            float startXOffset = 0f;
            float endXOffset = 1f;
            int sideTicks = 10;

            float startYOffset = 0f;
            float peakYOffset = 5f;
            float endYOffset = 3f;

            int upTicks = 11;
            int pauseTicks = 5;
            int downTicks = 6;
            int verticalTicks = upTicks + pauseTicks + downTicks;

            int tAll = this.attackTicks;
            int tD = Mth.clamp(tAll, 0, distanceTicks);
            int tX = Mth.clamp(tAll, 0, sideTicks);
            int tY = Mth.clamp(tAll, 0, verticalTicks);

            float pD = tD / (float) distanceTicks;
            float pX = tX / (float) sideTicks;

            float distance = Mth.lerp(pD, startDistance, endDistance);

            float xOffset = Mth.lerp(pX, startXOffset, endXOffset);

            float yOffset;
            if (tY < upTicks) {
                float pYup = tY / (float) upTicks;
                yOffset = Mth.lerp(pYup, startYOffset, peakYOffset);

            } else if (tY < upTicks + pauseTicks) {
                yOffset = peakYOffset;

            } else {
                float tDownPhase = tY - (upTicks + pauseTicks);
                float pYdown = tDownPhase / (float) downTicks;
                yOffset = Mth.lerp(pYdown, peakYOffset, endYOffset);
            }

            double riderX = this.getX() + distance * forwardX + cosYaw * xOffset;
            double riderZ = this.getZ() + distance * forwardZ + sinYaw * xOffset;
            double riderY = this.getY() + yOffset;
            if (getAttackState() == 40 || getAttackState() == 37) {


                moveFunc.accept(passenger, riderX, riderY, riderZ);
            }
        }

        if (getAttackState() == 50 || getAttackState() == 49) {
            double theta = Math.toRadians(this.yBodyRot + 90);
            double forwardX = Math.cos(theta), forwardZ = Math.sin(theta);
            float cosYaw = Mth.cos(this.yBodyRot * ((float) Math.PI / 180));
            float sinYaw = Mth.sin(this.yBodyRot * ((float) Math.PI / 180));

            float startDistance = 3f;
            float endDistance = 2f;
            int distanceTicks = 10;

            float startXOffset = 0f;
            float endXOffset = -1f;
            int sideTicks = 10;

            float startYOffset = 0f;
            float peakYOffset = 5f;
            float endYOffset = 3f;

            int upTicks = 11;
            int pauseTicks = 5;
            int downTicks = 6;
            int verticalTicks = upTicks + pauseTicks + downTicks;

            int tAll = this.attackTicks;
            int tD = Mth.clamp(tAll, 0, distanceTicks);
            int tX = Mth.clamp(tAll, 0, sideTicks);
            int tY = Mth.clamp(tAll, 0, verticalTicks);

            float pD = tD / (float) distanceTicks;
            float pX = tX / (float) sideTicks;

            float distance = Mth.lerp(pD, startDistance, endDistance);

            float xOffset = Mth.lerp(pX, startXOffset, endXOffset);

            float yOffset;
            if (tY < upTicks) {
                float pYup = tY / (float) upTicks;
                yOffset = Mth.lerp(pYup, startYOffset, peakYOffset);

            } else if (tY < upTicks + pauseTicks) {
                yOffset = peakYOffset;

            } else {
                float tDownPhase = tY - (upTicks + pauseTicks);
                float pYdown = tDownPhase / (float) downTicks;
                yOffset = Mth.lerp(pYdown, peakYOffset, endYOffset);
            }

            double riderX = this.getX() + distance * forwardX + cosYaw * xOffset;
            double riderZ = this.getZ() + distance * forwardZ + sinYaw * xOffset;
            double riderY = this.getY() + yOffset;
            if (getAttackState() == 50 || getAttackState() == 39) {


                moveFunc.accept(passenger, riderX, riderY, riderZ);
            }
        }
        if (getAttackState() == 20 && attackTicks == 8) {
            passenger.stopRiding();
        }
        if (getAttackState() == 40 || getAttackState() == 37) {
            if (attackTicks == 35) {

                //   passenger.stopRiding();
            }
        }
        if (getAttackState() == 50 || getAttackState() == 39) {
            if (attackTicks == 35) {

                // passenger.stopRiding();
            }
        }
        if (getAttackState() == 0) {
            passenger.stopRiding();
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

    public boolean isRightUppercut;
    public int renderProgress = 0;
    /// UPDATE ATTACK ACTIONS WITH ANIMATION
    public ControlledAnim controlledAnim = new ControlledAnim(15);
    public ControlledAnim QuadLaserShineUp = new ControlledAnim(45);

    public void UpdateWithAttack() {
/// SPIN SMASH

        float doubleSlashFirstArc = 200f;//Old 215
        float teleportDoubleSlashFirstArc = 200f;//Old 215
        float doubleSlashSecondArc = 200f;//Old 215
        float doubleSlashRange = 3.75f;//3.75
        float doubleSlashDamage = 18;

        float spinSmashArc = 290f;//Old 290
        float spinSmashPushDamage = 19;
        float spinSmashSlamDamage = 21;

        float kickRange = 3f;//2.7f
        float flameStompGroundDamage = 5f;
        float removeMeleeDamage = 2f;
        float stunAttackDamage = 21f;

        float plasmaBallDamage = 8f;
        float flamewaveOffset = 1.75f;

        float singleShotLaserDamage = 8.5f;
        //*SpinSmash Right
        SoundEvent spinSmashImpactSound = SoundEvents.EMPTY;
        float KnockAttackRange = 4.5f;
        if (getAttackState() == 4) {
            if (attackTicks == 38) {//Old 41
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 3f;
                float offset = 0f;
                float standingOnY = Mth.floor(getY());
                for (int k = 0; k < 3; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 3.0F + ((float) Math.PI * 2F / 2.5F);
                    this.spawnFlames((getX() + vec * vecX + f * offset) + (double) Mth.cos(f2) * 1.25D, (getZ() + vec * vecZ + f1 * offset) + (double) Mth.sin(f2) * 1.25D, standingOnY, getY() + 1, f2, 0, flameStompGroundDamage, false, ModParticles.GROUND_ANNIHILATION_NUKE.get());
                }
                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 3.5f, 1.5f);
            }
            if (attackTicks == 22) {

                createSweep(3, 1.5f, -5, true, 1f);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1f);
                calculatedDash(0.25f);
            }
            if (attackTicks == 24) {
                SideAreaAttack(KnockAttackRange, 3, 180, 0, spinSmashPushDamage - removeMeleeDamage, 3, 100, false, false, ModSounds.POSESSED_PALADIN_ATTACK3.get(), 0.5f);
                // AreaAttack(KnockAttackRange,3,180,spinSmashPushDamage,100,false,false);
            }

            if (attackTicks == 35) {
                calculatedDash(0.15f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);

            }
            if (attackTicks == 38) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 4.5f;
                float offset = 0f;
                if (level().isClientSide) {

                    float g = (float) Math.toRadians(-getYRot() + 180);
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                            (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }

                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 3.5f, 1.5f);
                this.playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                SideAreaAttack(5, 4, spinSmashArc, -90, spinSmashSlamDamage - removeMeleeDamage, 3, 100, false, false, spinSmashImpactSound, 0.5f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
            }
        }
        //Right Spin Teleport Smash
        if (getAttackState() == 26) {
            if (attackTicks == 38) {//Old 41
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 3f;
                float offset = 0f;
                float standingOnY = Mth.floor(getY());
                for (int k = 0; k < 3; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 3.0F + ((float) Math.PI * 2F / 2.5F);
                    this.spawnFlames((getX() + vec * vecX + f * offset) + (double) Mth.cos(f2) * 1.25D, (getZ() + vec * vecZ + f1 * offset) + (double) Mth.sin(f2) * 1.25D, standingOnY,
                            getY() + 1, f2, 0, flameStompGroundDamage, false, ModParticles.GROUND_ANNIHILATION_NUKE.get());
                }

            }

            if (attackTicks == 22) {

                createSweep(3, 1.5f, -5, true, 1f);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1f);
                calculatedDash(0.25f);
            }
            if (attackTicks == 24) {
                AreaAttack(KnockAttackRange, 3, 180, spinSmashPushDamage - removeMeleeDamage, 3, 100, false, false);
            }
            if (attackTicks == 33) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -5;
                    float offset = 0;

                    teleport(
                            target().getX() + vec * vecX + f * offset,
                            target().getY(),
                            target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }
            if (attackTicks == 43) {
                calculatedDash(0.15f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);

            }
            if (attackTicks == 46) {

                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 4.5f;
                float offset = 0f;
                if (level().isClientSide) {

                    float g = (float) Math.toRadians(-getYRot() + 180);
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                            (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                this.playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                SideAreaAttack(5, 4, spinSmashArc, -90, spinSmashSlamDamage - removeMeleeDamage, 3, 100, false, false, spinSmashImpactSound, 0.5f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
        }
        //*SpinSmashLeft
        if (getAttackState() == 5) {
            if (attackTicks == 38) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 3;
                float offset = 0f;
                float standingOnY = Mth.floor(getY());
                for (int k = 0; k < 3; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 3.0F + ((float) Math.PI * 2F / 2.5F);
                    this.spawnFlames((getX() + vec * vecX + f * offset) + (double) Mth.cos(f2) * 1.25D, (getZ() + vec * vecZ + f1 * offset) + (double) Mth.sin(f2) * 1.25D, standingOnY,
                            getY() + 1, f2, 0, flameStompGroundDamage, false, ModParticles.GROUND_ANNIHILATION_NUKE.get());
                }

                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 3.5f, 1.5f);
            }

            if (attackTicks == 22) {

                createSweep(3, -1.5f, -5, false, 1f);
                playSound(ModSounds.HEAVY_SWING.get(), 1, 1f);
                calculatedDash(0.25f);
            }

            if (attackTicks == 24) {

                SideAreaAttack(KnockAttackRange, 3, 180, 0, spinSmashPushDamage - removeMeleeDamage, 3, 100, false, false, ModSounds.POSESSED_PALADIN_ATTACK3.get(), 0.5f);
                // AreaAttack(KnockAttackRange,3,180,spinSmashPushDamage,100,false,false);
            }

            if (attackTicks == 35) {
                calculatedDash(0.15f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);

            }
            if (attackTicks == 38) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 4.5f;
                float offset = 0f;
                if (level().isClientSide) {

                    float g = (float) Math.toRadians(-getYRot() + 180);
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                            (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                this.playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                SideAreaAttack(5, 4, spinSmashArc, 90, spinSmashSlamDamage - removeMeleeDamage, 3, 100, false, false, spinSmashImpactSound, 0.5f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
            }
        }
        float bombVel = 1F;
        //Shoot Once
        if (getAttackState() == 6) {
            if (attackTicks > 30) {
                List<LivingEntity> entities = getEntitiesNearby(LivingEntity.class, 5.5f, 5.5f, 5.5f, 5f);
                for (LivingEntity livingEntity : entities) {
                    if (livingEntity == target() && targetIsNotNull()) {
                        canShootTwice = true;
                    }
                }
            }
            if (attackTicks == 10) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 20) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 30) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 17) {
                playSound(ModSounds.DIMENSIONAL_SHOOT_CHARGE.get(), 1, 1);
            }
            if (attackTicks > 15 && attackTicks < 30) {
                //   PullEntitiesAwayInFrontOf(0.025f,8);
            }
            if (attackTicks == 37) {
                backStep(-1f, 0);
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0f;
                float offset = 0f;
                if (level() instanceof ServerLevel level) {
                    level.sendParticles(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 1, 0, 0, 0, 0);
                }
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(bombVel, (float) (getX() + vec * vecX + f * offset), (float) (getY() + 1.5), (float) (getZ() + vec * vecZ + f1 * offset));
                playSound(ModSounds.THE_WARPED_ONE_SHOOT.get(), 3, 1);
            }

        }
        //Shoot Double End
        if (getAttackState() == 55) {
            if (attackTicks == 11) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -6;
                    float offset = 0;
                    float vec1 = 2;
                    if (level() instanceof ServerLevel level) {
                        level.sendParticles(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 1, 0, 0, 0, 0);
                    }
                    if (level().isClientSide) {
                        level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec1 * vecX + f * offset), (getY() + 3), (getZ() + vec1 * vecZ + f1 * offset), 0, 0, 0);
                    }
                    if (!level().isClientSide) {
                        teleport((float) (target().getX() + vec * vecX + f * offset), target().getY(), (float) (target().getZ() + vec * vecZ + f1 * offset));
                    }
                }
            }
            if (attackTicks == 33) {
                backStep(-1f, 0);
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0f;
                float offset = 0f;
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(bombVel, (float) (getX() + vec * vecX + f * offset), (float) (getY() + 1.5), (float) (getZ() + vec * vecZ + f1 * offset));
                playSound(ModSounds.THE_WARPED_ONE_SHOOT.get(), 3, 1);
            }
        }
        //Shoot Double
        if (getAttackState() == 7) {
            if (attackTicks == 10) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }
            if (attackTicks == 20) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }
            if (attackTicks == 30) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 80, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }
            if (attackTicks == 17) {
                playSound(ModSounds.DIMENSIONAL_SHOOT_CHARGE.get(), 1, 1);
            }
            if (attackTicks == 37) {

                backStep(-1f, 0);
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0f;
                float offset = 0f;
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(bombVel, (float) (getX() + vec * vecX + f * offset), (float) (getY() + 1.5), (float) (getZ() + vec * vecZ + f1 * offset));
                playSound(ModSounds.THE_WARPED_ONE_SHOOT.get(), 3, 1);

            }
            if (attackTicks >= 51 && attackTicks <= 54) {
                setInvisible(true);
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -6;
                    float offset = 0;
                    float vec1 = 2;
                    if (level().isClientSide) {
                        level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec1 * vecX + f * offset), (getY() + 3), (getZ() + vec1 * vecZ + f1 * offset), 0, 0, 0);
                    }
                    if (!level().isClientSide) {
                        playSound(SoundEvents.ENDERMAN_TELEPORT, 1, 1);
                        setPos((float) (target().getX() + vec * vecX + f * offset), target().getY(), (float) (target().getZ() + vec * vecZ + f1 * offset));
                    }
                }
            }
            if (attackTicks == 56) {
                playSound(ModSounds.DIMENSIONAL_SHOOT_CHARGE.get(), 1, 1);
            }
            if (attackTicks > 15 && attackTicks < 68) {
                //   PullEntitiesAwayInFrontOf(0.025f,8);
            }
            if (attackTicks == 68) {
                backStep(-1f, 0);
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0;
                float offset = 0f;
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), (getY() + 3), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), (float) (getY() + 1.5), (float) (getZ() + vec * vecZ + f1 * offset));
                playSound(ModSounds.THE_WARPED_ONE_SHOOT.get(), 3, 1);
            }

        }
        //Close Teleport Grab
        if (getAttackState() == 47) {
            if (attackTicks == 20) {
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 23) {
                SideAreaAttack(4f, 3, 180, 0, 0, 20 - removeMeleeDamage, 4, 120, false, false, ModSounds.THE_OBLITERATOR_STUN.get(), 1);//4.15 range
            }
            if (getAttackTicks() == 35) {

                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = -4;
                float offset = 0;
                teleport((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));


            }
            if (attackTicks == 47) {
                savePreSwapPositions(targetIsNotNull());
            }
            if (attackTicks == 59) {
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                // setInvisible(false);
                if (targetIsNotNull()) {
                    this.setDeltaMovement(
                            (lastTargetX - this.getX()) * 0.35F,
                            0,
                            (lastTargetZ - this.getZ()) * 0.35F
                    );
                }
            }

            if (attackTicks == 65) {
                this.succedGrabbing = false;
                PreGrab(-0.25f, 2, 3, 100, 18 - removeMeleeDamage);
                //    AreaAttack(5, 4, 180, 18, 100, true);
            }
            if (attackTicks == 39) {
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 0.5f);
            }
            if (attackTicks == 38) {

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(), this.getY() + 3, this.getZ(), 0, 0, 0);
            }
        }
        //Unused Left Hook Combo
        if (getAttackState() == 8) {
            if (attackTicks == 14) {
                calculatedDash(0.15f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            }
            if (attackTicks == 17) {
                //   AreaAttack(KnockAttackRange, 3, 180, 16, 100, false, true);
            }
            if (attackTicks == 31) {
                calculatedDash(0.25f);
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            }
            if (attackTicks == 34) {
                // AreaAttack(KnockAttackRange, 3, 180, 16, 100, false, true);
            }

        }

        /// TELEPORT ROAR SMASH SYSTEM
        //ROAR
        if (getAttackState() == 9) {
            if (targetIsNotNull()) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 3;
                float offset = 0;

                LaserBulletEntity witherskull = new LaserBulletEntity(ModEntities.ENERGY_LASER.get(), this,
                        getX() + vec * vecX + f * offset, getY(), getZ() + vec * vecZ + f1 * offset, level());
                witherskull.setOwner(this);
                Vec3 vec3 = new Vec3(target().getX() - getX(), 0, target().getZ() - getZ());
                witherskull.setDeltaMovement(vec3);
                witherskull.setPosRaw(getX() + vec * vecX + f * offset, getY() + 3, getZ() + vec * vecZ + f1 * offset);
                //  level().addFreshEntity(witherskull);
            }
            if (attackTicks == 20) {
                playSound(ModSounds.THE_WARPED_ONE_ROAR.get(), 2, 1f);

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 30, 0);
            }

            if (attackTicks > 20 && attackTicks < 30) {

            }
            if (attackTicks > 20 && attackTicks < 30) {
                List<LivingEntity> entities = getEntityLivingBaseNearby(10, 3, 10, 10);
                for (LivingEntity entity : entities) {
                    if (entity == this) continue;
                    double angle = (getAngleBetweenEntities(this, entity) + 90) * Math.PI / 180;
                    double distance = distanceTo(entity) - 2f;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(Math.min(1 / (distance * distance), 1) * -1 * Math.cos(angle),
                            0, Math.min(1 / (distance * distance), 1)
                                    * -1 * Math.sin(angle)));
                }
            }
            if (attackTicks >= 55 && attackTicks <= 70) {
                runAway();
            }
            if (attackTicks == 75) {

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), TheObliteratorEntity.this.getX(), TheObliteratorEntity.this.getY() + 3, TheObliteratorEntity.this.getZ(), 0, 0, 0);


            }
            if (attackTicks == 76) {
                //setInvisible(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 0.5f);
                setNoGravity(true);

                if (!level().isClientSide) {
                    if (targetIsNotNull()) {
                        setPos(target().getX(), target().getY() + 10, target().getZ());
                    } else {
                        setPos(getX(), getY() + 10, getZ());
                    }

                }
            }
        }

        //FALL
        if (getAttackState() == 10) {
            // setInvisible(false);
        }
        if (getAttackState() == 10 && onGround()) {
            if (getNextRoarAttackType() == 2 && !hasStartedSecondTeleportSmash && getAttackState() != 8) {
                setAttackState(12);
            } else
                setAttackState(11);

        }


//LAND
        if (getAttackState() == 11) {
            if (attackTicks == 3) {
                Random random = new Random();
                int los = random.nextInt(6 - 3 + 1) + 3;
                shootPlasmaBall(6, 45, true, los, plasmaBallDamage);
            }
            if (attackTicks == 9) {
                Random random = new Random();
                int los = random.nextInt(6 - 3 + 1) + 3;
                shootPlasmaBall(6, 90, false, los, plasmaBallDamage);
            }
            for (int i = 3, j = 2; i <= 14; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    //  SpawnDamagingBlocks(2, j, 4f, 2, 1, (float)1, 0.05F);
                }
            }

            if (attackTicks == 3) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0f;
                if (level().isClientSide) {

                    float g = (float) Math.toRadians(-getYRot() + 180);
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                            (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                this.playSound(ModSounds.THE_OBLITERATOR_STUN.get(), 1, 1);
                AreaAttack(4, 3, 180, 16, 5, 100, false, true);

                ParticleUtils.controlledSmashParticles(this, 0, -1, 0, 7.5f, 3f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
        }
        //LAND AGAIN
        if (getAttackState() == 12) {
            if (attackTicks == 3) {
                Random random = new Random();
                int los = random.nextInt(6 - 3 + 1) + 3;
                shootPlasmaBall(6, 90, true, los, plasmaBallDamage);
            }
            if (attackTicks == 9) {
                Random random = new Random();
                int los = random.nextInt(6 - 3 + 1) + 3;
                shootPlasmaBall(4, 30, true, los, plasmaBallDamage);
            }
            if (attackTicks == 3) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0f;
                if (level().isClientSide) {

                    float g = (float) Math.toRadians(-getYRot() + 180);
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                            (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                this.playSound(ModSounds.THE_OBLITERATOR_STUN.get(), 1, 1);
                AreaAttack(4, 3, 180, 16, 5, 100, false, true);
                ParticleUtils.controlledSmashParticles(this, 0, 1, 0, 7.5f, 3f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
            if (attackTicks == 21) {
                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), TheObliteratorEntity.this.getX(), TheObliteratorEntity.this.getY() + 3, TheObliteratorEntity.this.getZ(), 0, 0, 0);

            }
            if (attackTicks == 18) {
                // setInvisible(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 0.5f);

                if (!level().isClientSide) {
                    if (targetIsNotNull()) {
                        setPos(target().getX(), target().getY() + 10, target().getZ());
                    } else {
                        setPos(getX(), getY() + 10, getZ());
                    }
                }
            }

        }
        //Ambushes
        if (getAttackState() == 13) {
            if (attackTicks == 58) {
                doTeleportEffects(getIsSecondPhase());
            }
            if (attackTicks == 65) {
                setNoGravity(false);
            }
        }
        if (getAttackState() == 62) {
            if (attackTicks == 75) {
                doTeleportEffects(getIsSecondPhase());
            }
            if (attackTicks == 65) {
                setNoGravity(false);
            }
        }
        //With Swap
        /*
        if (getAttackState() == 14) {

            LivingEntity target = getTarget();
            TheObliteratorEntity entity = this;
            if (attackTicks >= 29 && attackTicks <= 30) {
                //entity.saveTeleportPos(entity, entity.isAlive(), -8, 0);
            }
            if (attackTicks == 31) {
                // entity.setInvisible(true);
                // entity.setInvulnerable(true);
                entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                teleportRandomly(entity,10,10);
                //entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);
            }

            if (attackTicks >= 55 && attackTicks <= 56) {
                entity.saveTeleportPos(entity.getTarget(), entity.targetIsNotNull(), 6, 0);
            }
            if (attackTicks == 56) {
                entity.level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(), entity.getY() + 3, entity.getZ(), 0, 0, 0);

            }
            if (attackTicks >= 57 && attackTicks <= 58) {

                entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                if (entity.getTarget() != null) {
                    entity.setInvulnerable(false);

                    entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);

                    entity.setNoGravity(false);
                }
            }


            if (attackTicks == 58) {
                entity.saveTeleportPos(entity.target(), entity.targetIsNotNull(), 6, 0);
            }

            if (attackTicks == 30) {
                entity.saveTeleportPos(entity.target(), entity.targetIsNotNull(), -8, 0);
            }
            if (attackTicks == 30) {
                entity.level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(), entity.getY() + 3, entity.getZ(), 0, 0, 0);

            }
            if (attackTicks == 31) {
                if (entity.getTarget() != null) {
                    entity.getNavigation().stop();
                    //  entity.setInvisible(true);
                    //  entity.setInvulnerable(true);
                    entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                    entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);


                }
            }

            if (attackTicks >= 89 && attackTicks <= 91) {
                entity.saveTeleportPos(entity, entity.isAlive(), -8, 0);
            }
            if (attackTicks == 91) {
                entity.level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(), entity.getY() + 3, entity.getZ(), 0, 0, 0);

            }
            if (attackTicks == 92) {
                if (entity.getTarget() != null) {
                    entity.getNavigation().stop();
                    //  entity.setInvisible(true);
                    // entity.setInvulnerable(true);
                    entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                    entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);


                }
            }
            if (attackTicks >= 112 && attackTicks <= 114) {//Old 119, 121
                entity.saveTeleportPos(entity.target(), entity.targetIsNotNull(), -6, 0);
            }
            if (attackTicks == 122) {
                entity.level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), entity.getX(), entity.getY() + 3, entity.getZ(), 0, 0, 0);

            }
            if (attackTicks >= 115 && attackTicks <= 117) {//Old 122
                //  entity.setInvisible(true);
                entity.getNavigation().stop();
                entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);

                if (entity.getTarget() != null) {
                    entity.setInvulnerable(false);
                    entity.teleport(entity.teleportX, entity.teleportY, entity.teleportZ);
                    entity.setNoGravity(false);
                }
            }
            if (attackTicks == 31) {

                // entity.setInvisible(true);
            }
            if (attackTicks == 32) {
                if (entity.getTarget() != null) {
                    int randomOffset = entity.getRandom().nextInt(3);
                    int bonusClones = entity.getRandom().nextInt(2);
                    int clonesAmount = 10 + bonusClones;
                    for (int k = 0; k < clonesAmount; ++k) {
                        float angleOnCircle = k * (float) Math.PI * -2.0F / 8 + randomOffset + (-(float) Math.PI * 2F / 15F);
                        double spawnX = entity.getTarget().getX() + Math.cos(angleOnCircle) * 8.5D;
                        double spawnZ = entity.getTarget().getZ() + Math.sin(angleOnCircle) * 8.5D;

                        int standingOnY = Mth.floor(entity.getY());
                        float targetY = (float) (entity.target().getY() + (double) entity.target().getBbHeight() * 0.3333333333333333D);
                        double spawnY = standingOnY;
                        double headY = entity.getTarget().getY() + 1;


                        double dx = entity.getTarget().getX() - spawnX;
                        double dz = entity.getTarget().getZ() - spawnZ;

                        float yawRad = (float) Math.atan2(dz, dx);
                        entity.spawnDuplicateVersions(
                                spawnX, spawnZ,
                                spawnY, headY,
                                yawRad,
                                4,
                                (float) entity.getTarget().getX(),
                                (float) entity.getTarget().getY(),
                                (float) entity.getTarget().getZ()
                        );
                    }
                }
            }

            if (attackTicks == 65) {
                entity.playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
                entity.setInvulnerable(false);
                entity.setNoGravity(false);
            }
            if (attackTicks == 92) {
                //entity.setInvisible(true);
            }

            if (attackTicks == 94) {
                if (entity.getTarget() != null) {
                    int randomOffset = entity.getRandom().nextInt(3);
                    int bonusClones = entity.getRandom().nextInt(2);
                    int clonesAmount = 7 + bonusClones;

                    double Cx = entity.getTarget().getX();
                    double Cz = entity.getTarget().getZ();
                    double baseR = 8.5D;
                    double scale = 1.25;
                    double R = baseR * scale;

                    double x1 = Cx + R;
                    double z1 = Cz;
                    double x2 = Cx + (R * -0.5);
                    double z2 = Cz + (R * Math.sqrt(3) / 2.0);
                    double x3 = Cx + (R * -0.5);
                    double z3 = Cz - (R * Math.sqrt(3) / 2.0);


                    double side = R * Math.sqrt(3);
                    double perimeter = 3.0 * side;

                    int standingOnY = Mth.floor(entity.getY());
                    double spawnY = standingOnY;
                    double headY = entity.getTarget().getY() + 1.0D;

                    float destX = (float) Cx;
                    float destY = (float) entity.getTarget().getY();
                    float destZ = (float) Cz;

                    for (int k = 0; k < clonesAmount; ++k) {
                        double d = ((double) k + randomOffset * 0.1) * (perimeter / clonesAmount);

                        int edgeIndex = (int) Math.floor(d / side);
                        if (edgeIndex >= 3) edgeIndex = 2;

                        double distAlongEdge = d - (edgeIndex * side);
                        double t = distAlongEdge / side;

                        double spawnX, spawnZ;
                        switch (edgeIndex) {
                            case 0:
                                spawnX = x1 + t * (x2 - x1);
                                spawnZ = z1 + t * (z2 - z1);
                                break;
                            case 1:
                                spawnX = x2 + t * (x3 - x2);
                                spawnZ = z2 + t * (z3 - z2);
                                break;
                            default:
                                spawnX = x3 + t * (x1 - x3);
                                spawnZ = z3 + t * (z1 - z3);
                                break;
                        }

                        double dx = Cx - spawnX;
                        double dz = Cz - spawnZ;
                        float yawRad = (float) Math.atan2(dz, dx);

                        entity.spawnDuplicateVersions(
                                spawnX,
                                spawnZ,
                                spawnY,
                                headY,
                                yawRad,
                                4,
                                destX,
                                destY,
                                destZ
                        );
                    }

                }
            }
            if (attackTicks == 31) {
                getNavigation().stop();
                // setInvisible(true);
                //  setInvulnerable(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);
            }
            if (attackTicks == 92) {
                getNavigation().stop();
                // setInvisible(true);
                //  setInvulnerable(true);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);

            }
            if (attackTicks == 122) {
                getNavigation().stop();
                //   setInvisible(false);
                setInvulnerable(false);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);

            }
            if (attackTicks == 65) {
                getNavigation().stop();
                // setInvisible(false);
                setInvulnerable(false);
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 1);

            }
            if (attackTicks == 75) {
                savePreSwapPositions(getTarget() != null);

            }
            if (attackTicks >= 77 && attackTicks <= 82) {

                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 2.0f, 3);

            }
            if (attackTicks == 77) {
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2;
                float offset = 0;
                this.level().addParticle(new Circle.RingData(0, 0, 30, 0, 1, 0, 1.0f, 40, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                        (getX() + vec * vecX + f * offset), getY() + 2f, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);

                playSound(SoundEvents.END_PORTAL_SPAWN, 1, 1);

                //   AreaAttack(9, 4, 360, 10, 100, false, false);
            }
        }
*/

        //TELEPORT UPPERCUT
        if (getAttackState() == 16) {
            if (attackTicks == 8) {
                savePreSwapPositions(targetIsNotNull());
            }

            if (attackTicks == 20) {
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                // setInvisible(false);
                if (targetIsNotNull()) {
                    this.setDeltaMovement(
                            (lastTargetX - this.getX()) * 0.35F,
                            0,
                            (lastTargetZ - this.getZ()) * 0.35F
                    );
                }
            }

            if (attackTicks == 26) {
                //   StraightLineAreaAttack(0.75f, 3, 100, 18, true);
            }
            if (attackTicks == 39) {
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 0.5f);
            }

            if (attackTicks >= 36 && attackTicks <= 39) {
                // setInvisible(true);
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = +2;
                    float offset = 0;

                    teleport(
                            target().getX() + vec * vecX + f * offset,
                            target().getY(),
                            target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }

            if (attackTicks == 39) {
                // setInvisible(false);
            }

            if (attackTicks == 42) {
                this.playSound(ModSounds.GROUND_IMPACT.get(), 1, 1);
                //    AreaAttack(4, 4, 180, 18 - removeMeleeDamage, 120, false, true);
            }
        }

        //Teleport Grab System
        if (getAttackState() == 17) {
            if (attackTicks == 8) {
                savePreSwapPositions(targetIsNotNull());
            }
            if (attackTicks == 20) {
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                // setInvisible(false);
                if (targetIsNotNull()) {
                    this.setDeltaMovement(
                            (lastTargetX - this.getX()) * 0.35F,
                            0,
                            (lastTargetZ - this.getZ()) * 0.35F
                    );
                }
            }

            if (attackTicks == 26) {
                this.succedGrabbing = false;
                PreGrab(-0.25f, 2, 3, 100, 19 - removeMeleeDamage);
                //    AreaAttack(5, 4, 180, 18, 100, true);
            }
            if (attackTicks == 39) {
                playSound(SoundEvents.ENDERMAN_TELEPORT, 2, 0.5f);
            }
            if (attackTicks == 38) {

                level().addAlwaysVisibleParticle(ModParticles.TELEPORT_EFFECT.get(), this.getX(), this.getY() + 3, this.getZ(), 0, 0, 0);
            }

        }
        if (getAttackState() == 18) {

            if (attackTicks == 5) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 2;
                    float offset = 0;

                    teleportTo(
                            target().getX() + vec * vecX + f * offset,
                            target().getY() + 1,
                            target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }
            if (attackTicks == 15) {
                Grab(2, 6, 0, 5);
            }

        }
        if (getAttackState() == 19) {
            if (onGround()) {
                setAttackState(20);
            }

        }
        if (getAttackState() == 20) {
            if (attackTicks == 3) {
                playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                spawnCircleParticle(2, 0, 80, true, 7, 0, 1, 0, 1);
                AreaAttack(4, 5, 360, 12, 10, 100, false, false);
                double multiplier = 8D;
                float size = 4F;
                int amountOfFlames = 10;
                for (int k = 0; k < amountOfFlames; ++k) {
                    float f3 = (float) k * (float) Math.PI * size / amountOfFlames + ((float) Math.PI * size / 10F);
                    int standingOnY = Mth.floor(getY());
                    this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, flameStompGroundDamage, false, ModParticles.GROUND_ANNIHILATION_NUKE.get());
                }

                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 10f, 3f);
            }

        }

        //JUMP TELEPORT
        if (getAttackState() == 22) {

            if (attackTicks == 2) {
                switch (random.nextInt(2)) {
                    case 0 -> isRightUppercut = false;
                    case 1 -> isRightUppercut = true;
                }
                // this.isRightUppercut = this.getRandom().nextInt() * 100 <50;
            }
            if (attackTicks == 56) {

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                doSmashEffects(4.5f, 0, ModSounds.HUGE_ENERGY_EXPLOSION.get());
                AreaAttack(5, 4, 180, 23 - removeMeleeDamage, 5, 160, false, true);
                ParticleUtils.controlledSmashParticles(this, 0, 0, 0, 7.5f, 4);
                double multiplier = 4D;
                float size = 2F;
                int amountOfFlames = 6;
                for (int k = 0; k < amountOfFlames; ++k) {
                    float f3 = (float) k * (float) Math.PI * size / amountOfFlames + ((float) Math.PI * size / 10F);
                    int standingOnY = Mth.floor(getY());
                    this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, flameStompGroundDamage, false, ModParticles.GROUND_ANNIHILATION_NUKE.get());
                }
                if (targetIsNotNull()) {
                    float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 0;
                    float offset = isRightUppercut ? -3 : 3;
                    int standingOnY = Mth.floor(getY());
                    spawnArmedClones(getX() + vec * vecX + f * offset, getZ() + vec * vecZ + f1 * offset, standingOnY, getY() + 2, 1, 0, target().getX(), getY(), target().getZ(), isRightUppercut ? 3 : 1, 45);
                }
            }
            if (attackTicks == 81) {
                doTeleportEffects(getIsSecondPhase());

            }
            if (attackTicks == 83) {
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
            }
            if (attackTicks == 88) {
                if (level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 100, false, Circle.EnumRingBehavior.GROW),
                            getX(), getY() + 0.1f, getZ(), 0, 0, 0);
                }
            }
            if (attackTicks == 105) {
                basicDash(2, 2, 0, false);
            }
            if (attackTicks == 108) {
                playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE.get());
                SoundEvent soundEvent = ModSounds.THE_OBLITERATOR_STUN.get();
                SideAreaAttack(4.25f, 5, 90, 0, 21 - removeMeleeDamage, 4, 160, false, true, soundEvent, 0.5f);

                Random random = new Random();
                int randomStrenght = random.nextInt(6 - 3 + 1) + 3;
                shootPlasmaBall(2, 20, true, 1, 4);
                shootPlasmaBall(2, 20, false, 1, 4);

            }
            if (attackTicks == 112) {
                shootPlasmaBall(1, 30, false, 0, 4);
            }
        }

        //DOUBLE SLASH

        //OLD BOX OFFSEt = 90

        int hitTick1 = 25;
        int dashTick1 = hitTick1 - 3;

        int hitTick2 = 39;
        int dashTick2 = hitTick2 - 3;
//Tp Ints
        int tpHit1 = 40;
        int tpDash1 = tpHit1 - 3;

        int tpHit2 = 54;
        int tpDash2 = tpHit2 - 3;

        int tpOffsetRight = -5;
        float tpOffsetLeft = 5;
        float tpVecLeft = 0.5f;
        float tpVecRight = 0.5f;

        if (getAttackState() == 15) {
            SoundEvent swingSound = ModSounds.HEAVY_SWING.get();
            SoundEvent impactSound = ModSounds.WEAPON_IMPACT.get();
            if (attackTicks == dashTick1) {//old 24
                calculatedDash(0.25f);
                // makeSweep(vecX,-5,vecZ,1.5,false,0.95F);
                createSweep(3, -1.5f, -5, false, 1f);
                playSound(swingSound, 1, 1);
            }

            if (attackTicks == hitTick1) {//old 28
                SideAreaAttack(doubleSlashRange, 4, doubleSlashFirstArc, -90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
            if (attackTicks == dashTick2) {// old 38

                createSweep(3, -1f, -5, false, 1f);
                // makeSweep(vecX,-5,vecZ,3,false,0.95F);
                calculatedDash(0.25f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == hitTick2) {// old 41
                SideAreaAttack(doubleSlashRange, 4, doubleSlashSecondArc, -90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
        }
        //Right Variant
        if (getAttackState() == 31) {
            SoundEvent swingSound = ModSounds.HEAVY_SWING.get();
            SoundEvent impactSound = ModSounds.WEAPON_IMPACT.get();
            if (attackTicks == dashTick1) {//old 24
                calculatedDash(0.25f);
                // makeSweep(vecX,-5,vecZ,1.5,false,0.95F);
                createSweep(3, 1.5f, -5, true, 1f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == hitTick1) {//old 28
                SideAreaAttack(doubleSlashRange, 4, doubleSlashFirstArc, 90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
            if (attackTicks == dashTick2) {// old 38

                createSweep(3, 1f, -5, true, 1f);
                // makeSweep(vecX,-5,vecZ,3,false,0.95F);
                calculatedDash(0.25f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == hitTick2) {// old 41/36
                SideAreaAttack(doubleSlashRange, 4, doubleSlashSecondArc, 90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
        }
        //TELEPORT DOUBLE SLASH
        if (getAttackState() == 23) {
            SoundEvent swingSound = ModSounds.HEAVY_SWING.get();
            SoundEvent impactSound = ModSounds.WEAPON_IMPACT.get();
            if (attackTicks == 14) {
                doTeleportEffects(getIsSecondPhase());
            }
            if (attackTicks == 15) {//old 15, new 10
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = tpVecLeft;
                    float offset = tpOffsetLeft;

                    teleport(
                            target().getX() + vec * vecX + f * offset,
                            target().getY(),
                            target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }
            if (attackTicks == tpDash1) {//old 28, new 23
                calculatedDash(0.25f);
                createSweep(3, -1.5f, -5, false, 1f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == tpHit1) {//old 32, new 27
                SideAreaAttack(doubleSlashRange, 4, teleportDoubleSlashFirstArc, -90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
            if (attackTicks == tpDash2) {// old 41, new 37

                createSweep(3, -1f, -5, false, 1f);
                // makeSweep(vecX,-5,vecZ,3,false,0.95F);
                calculatedDash(0.25f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == tpHit2) {//old 45, new 40
                SideAreaAttack(doubleSlashRange, 4, doubleSlashSecondArc, -90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
        }

        //Right variant
        if (getAttackState() == 32) {
            SoundEvent swingSound = ModSounds.HEAVY_SWING.get();
            SoundEvent impactSound = ModSounds.WEAPON_IMPACT.get();
            if (attackTicks == 14) {
                doTeleportEffects(getIsSecondPhase());
            }
            if (attackTicks == 15) {//
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;

                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = tpVecRight;
                    float offset = tpOffsetRight;

                    teleport(
                            target().getX() + vec * vecX + f * offset,
                            target().getY(),
                            target().getZ() + vec * vecZ + f1 * offset
                    );
                }
            }
            if (attackTicks == tpDash1) {//old 28
                calculatedDash(0.25f);
                createSweep(3, 1.5f, -5, true, 1f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == tpHit1) {//old 32
                SideAreaAttack(4, 4, teleportDoubleSlashFirstArc, 90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
            if (attackTicks == tpDash2) {

                createSweep(3, 1f, -5, true, 1f);
                // makeSweep(vecX,-5,vecZ,3,false,0.95F);
                calculatedDash(0.25f);
                playSound(swingSound, 1, 1);
            }
            if (attackTicks == tpHit2) {//old 45
                SideAreaAttack(4, 4, doubleSlashSecondArc, 90, 20 - removeMeleeDamage, 3, 100, false, false, impactSound, 0.5f);
            }
        }
// Clone Burst Grab
        if (getAttackState() == 24) {
            if (attackTicks == 10) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 100, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }
            if (attackTicks == 20) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 100, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }
            float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            int floor = Mth.floor(getY());
            if (attackTicks == 22) {
                float vec = 2;
                float offset = 0;
                this.level().addParticle(new Circle.RingData(0, 0, 30, 0, 1, 0, 1.0f, 40, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                        (getX() + vec * vecX + f * offset), getY() + 2f, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
            }

            if (attackTicks == 28) {

                float vec1 = 2;
                float offset1 = 0;
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(SoundEvents.END_PORTAL_SPAWN, 1, 1);
                AreaAttack(8f, 6, 360, 10, 8, 100, false, false);

                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 0, 20);
                if (targetIsNotNull()) {
                    spawnArmedClones((getX() + vec1 * vecX + f * offset1), (getZ() + vec1 * vecZ + f1 * offset1), floor, getY() + 2, 0, 0, target().getX(), getY(), target().getZ(), 1, 45);
                }

            }
            if (attackTicks < 28) {
                //  attractingParticles(ModParticles.SMALL_GREEN_FLAME.get(), 0.5f,0.5f);
            }
            if (attackTicks >= 28 && attackTicks <= 32) {
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 2.0f, 3);
            }
            if (attackTicks == 46) {
                float vec2 = 0;
                float offset2 = -3;
                if (targetIsNotNull()) {
                    spawnArmedClones((getX() + vec2 * vecX + f * offset2), (getZ() + vec2 * vecZ + f1 * offset2), floor, getY() + 2, 0, 0, target().getX(), getY(), target().getZ(), 1, 45);
                }
            }
            if (attackTicks == 56) {
                float vec2 = 2;
                float offset2 = 0;
                if (getTarget() != null) {

                    float f2 = Mth.cos(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    float f3 = Mth.sin(getTarget().yBodyRot * ((float) Math.PI / 180F));
                    double theta2 = (getTarget().yBodyRot) * (Math.PI / 180);
                    theta2 += Math.PI / 2;
                    double vecX2 = Math.cos(theta2);
                    double vecZ2 = Math.sin(theta2);
                    int floor2 = Mth.floor(getY());

                    float vec3 = 3;
                    float offset3 = -5;

                    spawnArmedClones((getX() + vec2 * vecX + f * offset2), (getZ() + vec2 * vecZ + f1 * offset2), floor,
                            getY() + 2, 0, 0, (getTarget().getX() + vec3 * vecX2 + f2 * offset3), getY(), (getTarget().getZ() + vec3 * vecZ2 + f3 * offset3), 2, 50);
                }
            }
            if (attackTicks == 97) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 100) {
                SoundEvent soundEvent = ModSounds.WEAPON_IMPACT.get();
                SideAreaAttack(5, 4, doubleSlashFirstArc, -90, 20 - removeMeleeDamage, 3, 160, false, true, soundEvent, 0.5f);
            }
        }
        // KICK SMASH GRAB
        if (getAttackState() == 25) {
            if (attackTicks == 7) {
                savePreSwapPositions(targetIsNotNull());
            }
            if (attackTicks == 15) {
                calculatedDashTowardsLocation(0.25f, (float) lastTargetX, (float) lastTargetZ);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 3, 1);
            }
            if (attackTicks == 18) {
                StraightLineAreaAttack(0.00025f, 1, kickRange, 150, 20 - removeMeleeDamage, 4, false, ModSounds.THE_OBLITERATOR_STUN.get());
                //SideAreaAttack(4f,5,85,0,20,150,false,true,ModSounds.THE_WARPED_ONE_STUN.get(),1);
            }
            if (attackTicks == 35) {
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 3, 1);
            }
            if (attackTicks == 38) {
                createCircularLightningParticle(2, 0, 10, 2f);
                doFlamesEffect(3, 2, 7, false, ModParticles.ANNIHILATION_FLAME_STRIKE.get(), 2);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.25F, 0, 20);
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 3, 1);
                AreaAttack(3.8f, 5, 180, 22, 4, 150, false, false);
                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 0.5f, 1);
                //spawnExplosions(10,3,6);
            }
            if (attackTicks == 70) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 73) {
                SideAreaAttack(5, 4, 215, -90, 20 - removeMeleeDamage, 4, 160, false, true, ModSounds.WEAPON_IMPACT.get(), 0.5f);
            }

        }
        //KICK SMASH NO GRAB
        if (getAttackState() == 36) {
            if (attackTicks == 7) {
                savePreSwapPositions(targetIsNotNull());
            }
            if (attackTicks == 15) {

                //playSound(ModSounds.THE_OBLITERATOR_SHORT_ROAR.get(), 1, 1);
                calculatedDashTowardsLocation(0.25f, (float) lastTargetX, (float) lastTargetZ);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 3, 1);
            }
            if (attackTicks == 18) {
                StraightLineAreaAttack(-0.6f, 4f, kickRange, 150, 20 - removeMeleeDamage, 4, false, ModSounds.THE_OBLITERATOR_STUN.get());
                //SideAreaAttack(4f,5,85,0,20,150,false,true,ModSounds.THE_WARPED_ONE_STUN.get(),1);
            }
            if (attackTicks == 35) {

                //playSound(ModSounds.THE_OBLITERATOR_SHORT_ROAR.get(), 1, 1);
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 3, 1);
            }
            if (attackTicks == 38) {
                ParticleUtils.controlledSmashParticles(this, 1, 0, 0, 2.5f, 1.5f);
                doFlamesEffect(3, 2, 7, false, ModParticles.ANNIHILATION_FLAME_STRIKE.get(), 2);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.25F, 0, 20);
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 3, 1);
                AreaAttack(3.8f, 5, 180, 21 - removeMeleeDamage, 4, 150, false, false);
                //spawnExplosions(10,3,6);
            }
        }
        //GRAB AFTER KICK SMASH RIGHT
        if (getAttackState() == 37) {
            if (attackTicks == 24) {
                // playSound(ModSounds.THE_OBLITERATOR_SHORT_ROAR.get(), 1, 1);
                calculatedDash(0.35f);
            }
            if (attackTicks == 27) {
                SideGrab(5, 4, 225, -90, 20 - removeMeleeDamage, 160, SoundEvents.PLAYER_ATTACK_SWEEP, 1f);
            }
        }
        //GRAB AFTER KICK SMASH LEFT
        if (getAttackState() == 49) {
            if (attackTicks == 24) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 27) {
                SideGrab(5, 4, 225, 90, 20 - removeMeleeDamage, 160, SoundEvents.PLAYER_ATTACK_SWEEP, 1f);
            }
        }
        //TELEPORT GRAB AFTER KICK SMASH
        if (getAttackState() == 39) {
            if (attackTicks == 13) {
                doTeleportEffects(getIsSecondPhase());
            }
            if (attackTicks == 14) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int floor = Mth.floor(getY());
                    float vec = -4;
                    float offset = 0;
                    teleport((target().getX() + vec * vecX + f * offset), target().getY(), (target().getZ() + vec * vecZ + f1 * offset));
                }
            }
            if (attackTicks == 28) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 28) {
                calculatedDash(0.35f);
            }
            if (attackTicks == 31) {
                SideGrab(5, 4, 215, -90, 20 - removeMeleeDamage, 160, ModSounds.WEAPON_IMPACT.get(), 0.5f);
            }
        }
        //CRUSH GRAB RIGHT
        if (getAttackState() == 40) {

            if (attackTicks == 18) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0;
                SideAreaAttack(5, 6, 180, 0, 8, 10, 0, false, false, SoundEvents.EMPTY, 1);
                playSound(ModSounds.ENERGY_EXPLOSION.get());

                float g = (float) Math.toRadians(-getYRot() + 180);
                this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 80, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                        (getX() + vec * vecX + f * offset), getY() + 5, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
            }

            if (attackTicks >= 18 && attackTicks <= 22) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0;
                float f3 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f4 = (this.random.nextFloat() - 0.5F) * 2.0F;
                float f5 = (this.random.nextFloat() - 0.5F) * 4.0F;
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 5.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 2.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);

                }
            }
            if (attackTicks == 54) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            }
            if (attackTicks == 57) {

                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);

                float destVec = 15;
                float destoffset = 0;

                float vec = 2.25f;
                float offset = -0.5f;
                if (getFirstPassenger() instanceof LivingEntity livingEntity) {
                    // System.out.println("Activating...");
                    if (getFirstPassenger() != null) {
                        //     System.out.println("Active, Not null");
                        if (!level().isClientSide) {
                            throwAnGravityEntity(0.75f, (getX() + destVec * vecX + f * destoffset), getY() + 1f, (getZ() + destVec * vecZ + f1 * destoffset),
                                    (getX() + vec * vecX + f * offset), getY() + 2, (getZ() + vec * vecZ + f1 * offset), 1, livingEntity);
                        }
                       /*throwAnEntity((getX() + destVec * vecX + f * destoffset), getY() + 1.5f, (getZ() + destVec * vecZ + f1 * destoffset),
                              (getX() + vec * vecX + f * offset), getY() + 2.5, (getZ() + vec * vecZ + f1 * offset),
                              5, 1.2f, livingEntity);*/

                    }
                }
            }
        }
        //CRUSH GRAB LEFT
        if (getAttackState() == 50) {

            if (attackTicks == 18) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0;
                SideAreaAttack(5, 6, 180, 0, 8, 10, 0, false, false, SoundEvents.EMPTY, 1);
                playSound(ModSounds.ENERGY_EXPLOSION.get());

                float g = (float) Math.toRadians(-getYRot() + 180);
                this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 80, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                        (getX() + vec * vecX + f * offset), getY() + 5, (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
            }

            if (attackTicks >= 18 && attackTicks <= 22) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2.5f;
                float offset = 0;
                float f3 = (this.random.nextFloat() - 0.5F) * 4.0F;
                float f4 = (this.random.nextFloat() - 0.5F) * 2.0F;
                float f5 = (this.random.nextFloat() - 0.5F) * 4.0F;
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 5.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 2.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);

                }
            }
            if (attackTicks == 54) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
            }
            if (attackTicks == 57) {

                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);

                float destVec = 15;
                float destoffset = 0;

                float vec = 2.25f;
                float offset = -0.5f;
                if (getFirstPassenger() instanceof LivingEntity livingEntity) {
                    // System.out.println("Activating...");
                    if (getFirstPassenger() != null) {
                        //     System.out.println("Active, Not null");
                        if (!level().isClientSide) {
                            throwAnGravityEntity(0.75f, (getX() + destVec * vecX + f * destoffset), getY() + 1f, (getZ() + destVec * vecZ + f1 * destoffset),
                                    (getX() + vec * vecX + f * offset), getY() + 2, (getZ() + vec * vecZ + f1 * offset), 1, livingEntity);
                        }
                       /*throwAnEntity((getX() + destVec * vecX + f * destoffset), getY() + 1.5f, (getZ() + destVec * vecZ + f1 * destoffset),
                              (getX() + vec * vecX + f * offset), getY() + 2.5, (getZ() + vec * vecZ + f1 * offset),
                              5, 1.2f, livingEntity);*/

                    }
                }
            }
        }
        //PARRY
        if (getAttackState() == 56) {
            if (attackTicks == 7) {
                if (targetIsNotNull()) {
                    Vec3 from = this.position();
                    Vec3 to = target().position();
                    Vec3 delta = to.subtract(from);
                    Vec3 offset = delta.scale(0.65);
                    Vec3 distance = from.add(offset);
                    saveTeleportPositions(distance.x, target().getY(), distance.z);
                }
            }
            if (attackTicks == 8) {
                teleport(lastX, lastY, lastZ);
            }
        }
        //PARRY SUCCESS
        if (getAttackState() == 59) {
            if (attackTicks == 5) {
                calculatedDash(0.25f);
            }
            if (attackTicks == 9) {
                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, 0.1F, 0, 10);
                SideAreaAttack(4.5f, 4, 180, 0, 0, stunAttackDamage - removeMeleeDamage, 6, 100, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1f);
            }
            if (attackTicks == 26) {
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = -5;
                float offset = 0;
                saveTeleportPositions((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));
            }
            if (attackTicks == 27) {
                teleport(lastX, lastY, lastZ);
            }
            for (int i = 49; i <= 60; i = i + 2) {// old 80, 98
                if (attackTicks == i) {
                    int d = i - 47;//old 78
                    flameRadagonShockwave(0.75f, d, 1f, 2, 0, 2, 17, false);
                }
            }
            if (attackTicks == 49) {
                playSound(ModSounds.FLAME_BURST.get(), 1, 1);
            }
            /*
            if (attackTicks == 6) {
                playSound(ModSounds.HEAVY_SWING.get(), 3, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 9) {
                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, 0.1F, 0, 10);
                createSweep(3, -2f, -5, false, 1f);
                createSweep(3, 2f, -5, true, 1f);
                SideAreaAttack(4, 4, 165, 90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_WARPED_ONE_STUN.get(), 1);
                SideAreaAttack(4, 4, 165, -90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_WARPED_ONE_STUN.get(), 1);
                SideAreaAttack(4, 4, 180, 0, 1.25f, stunAttackDamage - removeMeleeDamage, 6, 100, true, true, ModSounds.THE_WARPED_ONE_STUN.get(), 1f);
            }
            if (attackTicks == 26) {
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = -8;
                float offset = 0;
                saveTeleportPositions((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));
            }
            if (attackTicks == 27) {
                teleport(lastX, lastY, lastZ);
            }
            if (attackTicks == 38) {
                playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1.5f);
            }
            if (attackTicks == 61) {
                playSound(ModSounds.ANNIHILATION_LASER_SINGLE_SHOOT.get(), 3, 1);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                double spawnX = this.getX() + vecX * 1;
                double spawnY = this.getY();
                double spawnZ = this.getZ() + vecZ * 1;
                LivingEntity entity = this;
                //test

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 30.0F, 0.25F, 10, 5);
                AnnihilationBeamEntity energyBeamEntity = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, spawnX,
                        getY() + 2, spawnZ, (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 10, 2, 5, 1, false, 0, 0, 0, false, 30);
                entity.level().addFreshEntity(energyBeamEntity);
            }*/
        }
        //BACKSTEP TELEPORT SLASH
        if (getAttackState() == 27) {
            if (attackTicks == 3) {
                backStep(-2, 0);
            }
            if (attackTicks == 34) {
                setDeltaMovement(0, 1.3, 0);

            }

            if (attackTicks == 45) {
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(getY());
                float vec = 2;
                float offset = 0;
                TrackingBombEntity trackingBombEntity = new TrackingBombEntity(ModEntities.TRACKING_BOMB.get(), level(), this, 10, 20);
                trackingBombEntity.setPosRaw((getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset));
                level().addFreshEntity(trackingBombEntity);
            }
            if (attackTicks == 55) {
                setNoGravity(true);
            }
            if (attackTicks == 63) {
                setNoGravity(false);
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int floor = Mth.floor(getY());
                    float vec = 2;
                    float offset = 0;
                    teleport((target().getX() + vec * vecX + f * offset), target().getY(), (target().getZ() + vec * vecZ + f1 * offset));
                }
                if (attackTicks == 71) {
                    StraightLineAreaAttack(0.005f, 1, 4, 100, 20 - removeMeleeDamage, 3, true, ModSounds.THE_OBLITERATOR_STUN.get());
                }
            }
        }

        //BACKSTEP STOMP LEFT
        if (getAttackState() == 28) {
            if (attackTicks >= 6 && attackTicks <= 8) {

                attractingParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 1, 1);
            }
            if (attackTicks == 30) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (this.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(this.getY());
                float vec = 0;
                float offset = 3;
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), this.getY() + 3.0D, (getZ() + vec * vecZ + f1 * offset), 0.0D, 0.0D, 0.0D);
                }
            }
            if (attackTicks == 6) {

                backStep(-1.5f, 0.6f);
            }
            for (int i = 39; i <= 54; i = i + 2) {
                if (attackTicks == i) {
                    int d = i - 37;
                    flameRadagonShockwave(0.25f, d, 1, 2, 0, flamewaveOffset, 7, false);
                }
            }
            if (attackTicks == 39) {
                ParticleUtils.controlledSmashParticles(this, 1, 1.75f, 0, 2.5f, 1.5f);
                createCircularLightningParticle(2, 2, 10, 2f);
                doFlamesEffect(3, 2, 7, false, ModParticles.ANNIHILATION_FLAME_STRIKE.get(), 2);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.25F, 0, 20);
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 3, 1);
                SideAreaAttack(4f, 5, 210, -90, 22 - removeMeleeDamage, 4, 150, false, false, SoundEvents.EMPTY, 1);
            }

        }

        //BACKSTEP STOMP RIGHT
        if (getAttackState() == 29) {
            if (attackTicks >= 6 && attackTicks <= 8) {

                attractingParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 1, 1);
            }
            if (attackTicks == 6) {
                backStep(-1.5f, 0.6f);
            }
            if (attackTicks == 30) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (this.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(this.getY());
                float vec = 0;
                float offset = -3;
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset), this.getY() + 3.0D, (getZ() + vec * vecZ + f1 * offset), 0.0D, 0.0D, 0.0D);
                }
            }
            for (int i = 39; i <= 54; i = i + 2) {
                if (attackTicks == i) {
                    int d = i - 37;
                    flameRadagonShockwave(0.25f, d, 1, 2, 0, -flamewaveOffset, 7, false);
                }
            }
            if (attackTicks == 39) {
                ParticleUtils.controlledSmashParticles(this, 1, -1.75f, 0, 2.5f, 1.5f);
                createCircularLightningParticle(2, -2, 10, 2f);
                doFlamesEffect(3, 2, 7, false, ModParticles.ANNIHILATION_FLAME_STRIKE.get(), 2);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.25F, 0, 20);
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 3, 1);
                SideAreaAttack(4f, 5, 210, 90, 22 - removeMeleeDamage, 4, 150, false, false, SoundEvents.EMPTY, 1);
            }
        }


        //STUN AFTER POWER BOMB
        if (getAttackState() == 30) {
            if (attackTicks == 15) {
                playSound(ModSounds.HEAVY_SWING.get(), 3, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 18) {//Old 14
                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, 0.1F, 0, 10);
                createSweep(3, -2f, -5, false, 1f);
                createSweep(3, 2f, -5, true, 1f);
                SideAreaAttack(4, 4, 160, 90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                SideAreaAttack(4, 4, 160, -90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                SideAreaAttack(4, 4, 180, 0, 1.25f, stunAttackDamage - removeMeleeDamage, 6, 100, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1f);
            }
        }
        /// STOMP SYSTEM
        if (getAttackState() == 34) {

            if (attackTicks == 16) {
                ParticleUtils.controlledSmashParticles(this, 3, 0, 0, 2.5f, 1.5f);
                createCircularLightningParticle(2, 0, 10, 2f);
                doFlamesEffect(3, 2, 7, false, ModParticles.ANNIHILATION_FLAME_STRIKE.get(), 2);
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.25F, 0, 20);
                spawnCircleParticle(0, 0, 100, false, 0, 0f, 1f, 0f, 1);
                playSound(ModSounds.HUGE_ENERGY_EXPLOSION.get(), 3, 1);
                // shootAngledBombs(1f,(float) (getX() + vec * vecX + f * offset), (float) (getY()+0.5f)  ,(float) (getZ() + vec * vecZ + f1 * offset),3,30,9);

                SideAreaAttack(5f, 4, 180, 0, 19, 4, 100, false, false, SoundEvents.EMPTY, 1);
            }
            if (attackTicks == 28) {

                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 31) {

                SideAreaAttack(5f, 4, 180, 0, 18, 4, 100, false, false, SoundEvents.EMPTY, 1);
            }
        }
        //Stun After Stomp
        if (getAttackState() == 35) {
            if (attackTicks == 20) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);
            }

            if (attackTicks == 35) {
                playSound(ModSounds.HEAVY_SWING.get(), 3, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == 38) {//old34

                CameraShakeEntity.cameraShake(this.level(), position(), 10.0F, 0.1F, 0, 10);
                createSweep(3, -2f, -5, false, 1f);
                createSweep(3, 2f, -5, true, 1f);
                SideAreaAttack(3.75f, 4, 160, 90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                SideAreaAttack(3.75f, 4, 160, -90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                SideAreaAttack(3.75f, 4, 180, 0, 1.25f, stunAttackDamage - removeMeleeDamage, 6, 100, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1f);
            }
        }
        //Kick After Stomp
        if (getAttackState() == 33) {
            if (attackTicks == 24) {
                savePreSwapPositions(targetIsNotNull());
            }
            if (attackTicks == 31) {

                calculatedDashTowardsLocation(0.25f, (float) lastTargetX, (float) lastTargetZ);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 3, 1);
            }
            if (attackTicks == 34) {
                StraightLineAreaAttack(-0.6f, 0.95f, kickRange, 150, 18, 4, false, ModSounds.THE_OBLITERATOR_STUN.get());
            }
        }
        //P2
        if (getAttackState() == 2) {
            if (attackTicks > 31 && attackTicks < 41) {
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 4, 1, 5);
            }
            if ((attackTicks > 2 && attackTicks < 30)) {
                int ucap = 5;
                int uReps = 5;

                int uReps2 = 1;
                ParticleOptions small = ModParticles.SMALL_ANNIHILATION_FLAME.get();
                ParticleOptions big = ModParticles.BIG_ANNIHILATION_FLAME.get();

                attractParticles(small, ucap, uReps, 0, 0, 5, 3, 0.075f);
                attractParticles(small, ucap, uReps, 0, 0, 3, 3, 0.075f);
                attractParticles(small, ucap, uReps, 0, 0, 2, 3, 0.075f);

                attractParticles(big, ucap, uReps2, 0, 0, 5, 3, 0.075f);
                attractParticles(big, ucap, uReps2, 0, 0, 3, 3, 0.075f);
                attractParticles(big, ucap, uReps2, 0, 0, 2, 3, 0.075f);

            }
            if (attackTicks == 33) {

                //Flying Armor Stuff

                //Lower
                int lowerArmorAmount = 4;
                for (int i = 0; i < lowerArmorAmount; i++) {

                    float throwAngle = (i * Mth.PI / (lowerArmorAmount / 2)) + 90;

                    double sx = getX() + (Mth.cos(throwAngle) * 1);
                    double sy = getY() + 3;
                    double sz = getZ() + (Mth.sin(throwAngle) * 1);

                    double vx = Mth.cos(throwAngle);
                    double vy = 0 + getRandom().nextFloat() * 0.3F;
                    double vz = Mth.sin(throwAngle);
                    double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                    FlyingArmorEntity projectile = new FlyingArmorEntity(ModEntities.FLYING_ARMOR.get(), level(), this, 12, 1);

                    projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());
                    float speed = 0.7F;
                    projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    level().addFreshEntity(projectile);

                }
                //Upper
                int upperArmorAmount = 4;
                for (int i = 0; i < upperArmorAmount; i++) {

                    float throwAngle = (i * Mth.PI / (upperArmorAmount / 2)) + 90;

                    double sx = getX() + (Mth.cos(throwAngle) * 1);
                    double sy = getY() + 6;
                    double sz = getZ() + (Mth.sin(throwAngle) * 1);

                    double vx = Mth.cos(throwAngle);
                    double vy = 0 + getRandom().nextFloat() * 0.3F;
                    double vz = Mth.sin(throwAngle);
                    double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                    FlyingArmorEntity projectile = new FlyingArmorEntity(ModEntities.FLYING_ARMOR.get(), level(), this, 12, 3);

                    projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());
                    float speed = 0.7F;
                    projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    level().addFreshEntity(projectile);

                }
                //Other

                SideAreaAttack(5, 5, 360, 0, 0, 20, 7, 0, false, false, SoundEvents.EMPTY, 1);


                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 20, 10);
                playSound(SoundEvents.TOTEM_USE, 2, 1);
                setPhase(2);
            }
        }

        int uniformDuration = this.isTargetCheesing(-4, 4) ? 10 : 10;
        /// SINGLE SHOT LASER
        if (getAttackState() == 42) {
            if (attackTicks == 1) {

                playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1.5f);
            }
            if (attackTicks >= 5 && attackTicks <= 23) {
                attractParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 2, 5, 0, 0, 5, 3, 0.075f);
            }
            if (attackTicks == 23) {
                playSound(ModSounds.ANNIHILATION_LASER_SINGLE_SHOOT.get(), 3, 1);
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2;
                float offset = 0;
                double spawnX = getX() + vec * vecX + f * offset;
                double spawnY = this.getY();
                double spawnZ = getZ() + vec * vecZ + f1 * offset;
                LivingEntity entity = this;

                //test

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 30.0F, 0.25F, 10, 5);
                AnnihilationBeamEntity energyBeamEntity = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, spawnX,
                        getY() + 2, spawnZ,
                        (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), uniformDuration, singleShotLaserDamage, 5, 1, false, 0, 0, 0, false, 30);
                entity.level().addFreshEntity(energyBeamEntity);
            }
        }
        /// AFTER STOMP
        if (getAttackState() == 43) {
            if (attackTicks == 1) {

                playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1.5f);
            }

            if (attackTicks == 35) {//35
                playSound(ModSounds.ANNIHILATION_LASER_SINGLE_SHOOT.get(), 3, 1);
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2;
                float offset = 0;
                double spawnX = getX() + vec * vecX + f * offset;
                double spawnY = this.getY();
                double spawnZ = getZ() + vec * vecZ + f1 * offset;
                LivingEntity entity = this;
//test

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 30.0F, 0.25F, 10, 5);
                AnnihilationBeamEntity energyBeamEntity = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, spawnX,
                        getY() + 2, spawnZ, (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), uniformDuration, 12, 5, 1, false, 0, 0, 0, false, 30);
                entity.level().addFreshEntity(energyBeamEntity);
            }
        }
        //Laser teleport End
        if (getAttackState() == 44) {

            if (attackTicks == 10) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -6;
                    float offset = 0;
                    if (!level().isClientSide)
                        teleport((target().getX() + vec * vecX + f * offset), target().getY(), (target().getZ() + vec * vecZ + f1 * offset));

                }
            }
        }
        //Teleport Away Single Laser

        if (getAttackState() == 21) {

            if (attackTicks == 11) {
                playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1.5f);
            }
            if (attackTicks >= 21 && attackTicks <= 39) {
                attractParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 2, 5, 0, 0, 5, 3, 0.075f);
            }
            if (attackTicks == 39) {//39
                playSound(ModSounds.ANNIHILATION_LASER_SINGLE_SHOOT.get(), 3, 1);
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 2;
                float offset = 0;
                double spawnX = getX() + vec * vecX + f * offset;
                double spawnY = this.getY();
                double spawnZ = getZ() + vec * vecZ + f1 * offset;
                LivingEntity entity = this;
                //test

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 30.0F, 0.25F, 10, 5);
                AnnihilationBeamEntity energyBeamEntity = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, spawnX,
                        getY() + 2, spawnZ, (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), uniformDuration, singleShotLaserDamage, 5, 1, false, 0, 0, 0, false, 30);
                entity.level().addFreshEntity(energyBeamEntity);
            }
        }
        //QUAD LASER
        if (getAttackState() == 46) {
            if (attackTicks == 1) {
                QuadLaserShineUp.resetTimer();
            }
            if (attackTicks >= 1 && attackTicks < 46) {
                QuadLaserShineUp.increaseTimer();
            }
            if (attackTicks == 1) renderProgress = 0;
            LivingEntity target = getTarget();
            if (attackTicks > 36) {
                controlledAnim.increaseTimer();
            }

            if (attackTicks > 12) {
                if (getIsQuadBeamRight()) renderProgress++;

                if (!getIsQuadBeamRight()) renderProgress--;
            }
            if (attackTicks == 9) {


                playSound(ModSounds.ANNIHILATION_LASER_CHARGE.get(), 3, 1f);
                if (target != null) {
                    float f = Mth.cos(target.yHeadRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target.yHeadRot * ((float) Math.PI / 180F));
                    double theta = (target.yHeadRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = 3;
                    float uniformOffset = 5;
                    float offset = getRandom().nextInt() * 100 < 50 ? -uniformOffset : uniformOffset;
                    teleport((target.getX() + vec * vecX + f * offset), target.getY(), (target.getZ() + vec * vecZ + f1 * offset));

                }
            }
            //  System.out.println("IsBeamRight: " + getIsQuadBeamRight());
            if ((attackTicks > 10 && attackTicks < 30)) {
                int ucap = 5;
                attractParticles(getIsQuadBeamRight() ? ModParticles.BIG_ANNIHILATION_FLAME.get() : ModParticles.SMALL_ANNIHILATION_FLAME.get(), ucap, 4, 0, 0, 5, 3, 0.075f);
                attractParticles(getIsQuadBeamRight() ? ModParticles.BIG_ANNIHILATION_FLAME.get() : ModParticles.SMALL_ANNIHILATION_FLAME.get(), ucap, 4, 0, 0, 3, 3, 0.075f);
                attractParticles(getIsQuadBeamRight() ? ModParticles.BIG_ANNIHILATION_FLAME.get() : ModParticles.SMALL_ANNIHILATION_FLAME.get(), ucap, 4, 0, 0, 2, 3, 0.075f);
                if (level().isClientSide) {
                    if (tickCount % 5 == 0) {
                        //  pullParticles(ModParticles.BIG_ANNIHILATION_FLAME.get(), 1, 3);
                        //pullParticles(ParticleTypes.SMALL_FLAME, 1, 3);
                        //  pullParticles(ModParticles.BIG_ANNIHILATION_FLAME.get(), 1, 3);
                    }
                }
            }
            if (attackTicks == 6 || attackTicks == 16 || attackTicks == 26 || attackTicks == 36) {
                if (getIsQuadBeamRight()) {
                    //  pullParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 1, 3);
                }
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 100, false, getIsQuadBeamRight() ? Circle.EnumRingBehavior.GROW : Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 0.5f, getZ(), 0, 0, 0);

            }

            if (attackTicks == 46 || attackTicks == 56 || attackTicks == 66 || attackTicks == 76 || attackTicks == 86) {
                if (getIsQuadBeamRight()) {
                    //  pullParticles(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 1, 3);
                }
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 100, true, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY() + 2, getZ(), 0, 0, 0);
            }

            if (attackTicks >= 46 && attackTicks <= 52) {
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 2.0f, 3);
            }

            if (attackTicks == 46) {
                //  System.out.println("isRight: " + isRight);
                LivingEntity entity = this;
                double targetSpeedValue = targetIsNotNull() && target().getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
                        ? target().getAttribute(Attributes.MOVEMENT_SPEED).getValue() * 5 : 0;
                float uniformPrecentage = 0.5f;
                float uniformSpeed = (float) (2.6f + targetSpeedValue);
                float uniformDamage = 7.5f;//Old 12
                playSound(ModSounds.QUAD_ANNIHILATION_LASER_SHOOT.get(), 3, 1f);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 30.0F, 0.15F, 40, 10);
                AnnihilationBeamEntity energyBeamEntity1 = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, getX(),
                        getY() + 2, getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180),
                        50, uniformDamage, 5, 1, true, uniformSpeed, 90, uniformPrecentage, getIsQuadBeamRight(), 30);
                entity.level().addFreshEntity(energyBeamEntity1);

                AnnihilationBeamEntity energyBeamEntity2 = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, getX(),
                        getY() + 2, getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180),
                        50, uniformDamage, 5, 1, true, uniformSpeed, 0, uniformPrecentage, getIsQuadBeamRight(), 30);
                entity.level().addFreshEntity(energyBeamEntity2);

                AnnihilationBeamEntity energyBeamEntity3 = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, getX(),
                        getY() + 2, getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180),
                        50, uniformDamage, 5, 1, true, uniformSpeed, 180, uniformPrecentage, getIsQuadBeamRight(), 30);
                entity.level().addFreshEntity(energyBeamEntity3);

                AnnihilationBeamEntity energyBeamEntity4 = new AnnihilationBeamEntity(ModEntities.ANNIHILATION_BEAM.get(), entity.level(), entity, getX(),
                        getY() + 2, getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180),
                        50, uniformDamage, 5, 1, true, uniformSpeed, 270, uniformPrecentage, getIsQuadBeamRight(), 30);
                entity.level().addFreshEntity(energyBeamEntity4);
            }

        }
        //Phase 3
        if (getAttackState() == 48) {
            if (attackTicks == 30) {
                if (target() instanceof Player player)
                    sendBasicHotBarMessage("legendary_monsters.message.obliterator_p3_1_message", player);
            }
            if (attackTicks == 93) {
                if (target() instanceof Player player)
                    sendBasicHotBarMessage("legendary_monsters.message.obliterator_p3_2_message", player);
            }
            if ((attackTicks >= 30 && attackTicks <= 32) || (attackTicks >= 58 && attackTicks <= 60)) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (this.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(this.getY());
                float vec = 2;
                boolean ticks = attackTicks >= 30 && attackTicks <= 34;
                float offset = ticks ? 3 : -3;
                float f3 = (this.random.nextFloat() - 0F) * 0.5F;
                float f4 = (this.random.nextFloat() - 0F) * 0.5F;
                float f5 = (this.random.nextFloat() - 0F) * 0.5F;
                SideAreaAttack(5, 5, 190, (attackTicks >= 30 && attackTicks <= 32) ? 90 : -90, 0, 8, 8, 0, false, false, SoundEvents.EMPTY, 1);
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 3.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (getX() + vec * vecX + f * offset) + (double) f3, this.getY() + 1.0D + (double) f4, (getZ() + vec * vecZ + f1 * offset) + (double) f5, 0.0D, 0.0D, 0.0D);

                }
            }
            if (attackTicks == 30 || attackTicks == 58) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (this.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(this.getY());
                float vec = 2;
                float offset = attackTicks == 30 ? 3 : -3;
                if (this.level().isClientSide) {
                    this.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (this.getX() + vec * vecX + f * offset), this.getY() + 3, (this.getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }


                this.playSound(ModSounds.OBLITERATOR_ARM_SHOOT.get(), 3, 1);
            }
            if (attackTicks == 80) {
                spawnCircleParticle(0, 0, 100, false, 0, 0, 1, 0, 1, Circle.EnumRingBehavior.SHRINK, 20);
            }
            if (attackTicks == 93) {
                spawnCircleParticle(0, 0, 100, false, 0, 0, 1, 0, 1);
                doFlamesEffect(5, 2, 8, true, ModParticles.ANNIHILATION_NUKE.get(), 4f);
                this.playSound(ModSounds.OMINOUS_EXPLOSION.get(), 3, 1);
                this.playSound(ModSounds.FLAME_BURST.get(), 3, 1);
            }
            if (attackTicks == 96) {
                CameraShakeEntity.cameraShake(this.level(), this.position(), 10.0F, 0.1F, 0, 10);
                this.createSweep(3, -2f, -5, false, 1f);
                this.createSweep(3, 2f, -5, true, 1f);
                this.SideAreaAttack(4, 4, 160, 90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                this.SideAreaAttack(4, 4, 160, -90, stunAttackDamage - removeMeleeDamage, 6, 120, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1);
                this.SideAreaAttack(4, 4, 180, 0, 1.25f, stunAttackDamage - removeMeleeDamage, 6, 100, true, true, ModSounds.THE_OBLITERATOR_STUN.get(), 1f);
            }
        }
        //Arm Block
        if (getAttackState() == 48) {

        }
        //Ultimate
        if (getAttackState() == 53) {
            if (attackTicks == 8) {
                if (target() instanceof Player player)
                    sendBasicHotBarMessage("legendary_monsters.message.obliterator_ultimate", player);
            }
            if (attackTicks < 50) {
                for (int k = 0; k < 3; k++) {
                    float d1 = Mth.sqrt(k);
                    float ran = 0.4f;
                    float r = 0 / 255F;
                    float g = 195 / 255F + random.nextFloat() * ran;
                    float b = 0 / 255F;
                    this.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.2f, 0.1f),
                            getX(), getY(), getZ(), Mth.sin(k), 0, d1 * 0.01f);
                }
            }
            if (attackTicks == 10) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 20) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 30) {
                this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 20, 0, 1, 0, 1.0f, 150, false, Circle.EnumRingBehavior.SHRINK),
                        getX(), getY(), getZ(), 0, 0, 0);

            }
            if (attackTicks == 2) {
                CameraShakeEntity.cameraShake(this.level(), this.position(), 20.0F, 0.15F, 20, 6);
            }
            if (attackTicks == 15) {
                AnnihilationPortalEntity annihilationPortalEntity = new AnnihilationPortalEntity(level(), getX(), getY(), getZ(), 0, 12, this, 50, 20, true, 6);
                level().addFreshEntity(annihilationPortalEntity);
            }
            if (attackTicks == 21) {

                doPortalEffect(15, 2, 5, 7, 3.5f, 50, 15);
                doPortalEffect(8, 2, 5, 7, 3.5f, 50, 15);
            }
            if (attackTicks >= 51 && attackTicks <= 52) {
            }

            if (attackTicks > 2 && attackTicks < 21) {
                for (LivingEntity entity : level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(7))) {
                    if (entity.onGround() && entity != this) {
                        if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                        Vec3 diff = entity.position().subtract(this.position().add(0, 0, 0));
                        diff = diff.normalize().scale(1f * 0.015);
                        entity.setDeltaMovement(entity.getDeltaMovement().subtract(diff));
                        EntityUtil.applyPlayerDeltaMovement(entity);

                    }
                }
            }
            if (attackTicks == 48) {
                doFlamesEffect(5, 2, 6, true, ModParticles.ANNIHILATION_NUKE.get(), 4);
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 3f, 2.0f, 3);

                SideAreaAttack(6, 4, 380, 0, 0, 12, 8, 120, false, false, ModSounds.FLAME_BURST.get(), 1);
                CameraShakeEntity.cameraShake(this.level(), this.position(), 30.0F, 0.2F, 10, 5);
                createCircularLightningParticle(3.5f, 0, 5, 2.5f);
                // createAnnihilationPortal(getX(),getZ(),getY(),getY()+3,0,20);
                this.playSound(ModSounds.ULTIMATE_FLAME_IMPACT.get(), 3, 1);
                // spawnAnnihilationPortalsRandomly(10,0,8,20,25);
                for (LivingEntity entity : level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(25))) {
                    if (entity.onGround() && entity != this) {
                        if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                        entity.setDeltaMovement(0, 0.35f, 0);
                        EntityUtil.applyPlayerDeltaMovement(entity);
                    }
                }
            }
            //Warning
            for (int i = 60; i <= 78; i = i + 2) {
                if (attackTicks == i) {
                    int d = i - 58;
                    flameRadagonShockwave(2f, d, 1f, 2, 0, 2, 17, true);
                }
            }
            //Attack
            for (int i = 80; i <= 98; i = i + 2) {// old 80, 98
                if (attackTicks == i) {
                    int d = i - 78;//old 78
                    flameRadagonShockwave(2f, d, 1f, 2, 0, 2, 17, false);
                }
            }
            if (attackTicks == 80) {
                SideAreaAttack(6, 4, 380, 0, 0, 12, 8, 120, false, false, ModSounds.FLAME_BURST.get(), 1);
                CameraShakeEntity.cameraShake(this.level(), this.position(), 30.0F, 0.15F, 20, 5);
                this.playSound(ModSounds.OMINOUS_EXPLOSION.get(), 3, 1);
                createCircularLightningParticle(3.5f, 0, 5, 2.5f);
            }
            if (attackTicks == 105) {
                if (targetIsNotNull()) {
                    float f = Mth.cos(target().yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target().yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target().yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -4;
                    float offset = 0;
                    if (!level().isClientSide)
                        teleport((target().getX() + vec * vecX + f * offset), target().getY(), (target().getZ() + vec * vecZ + f1 * offset));

                }
            }

        }
        if (getAttackState() == 52) {
            LivingEntity target = getTarget();
            if (attackTicks == 13) {
                if (target != null) {
                    float f = Mth.cos(target.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(target.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (target.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    float vec = -4;
                    float offset = 0;
                    teleport((target.getX() + vec * vecX + f * offset), getY(), (target.getZ() + vec * vecZ + f1 * offset));
                }
            }
        }
        if (getAttackState() == 1) {
            if (attackTicks == 15)
                playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
            if (attackTicks > 82 && attackTicks < 114) {
                if (tickCount % 3 == 0) {
                    playSound(SoundEvents.ENDERMAN_TELEPORT, 1, 1);
                }
            }
        }
        if (getAttackState() == 60) {
            if (attackTicks == 5) teleportRandomly(this, 7, 10);
            if (attackTicks > toTicks(2.17f)) {
                if (tickCount % 10 == 0) {

                    CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 0, 5);
                    if (level().isClientSide) {
                        level().addParticle(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + 3, getZ(), 0, 0, 0);
                    }
                    playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
                }
            }
            if (attackTicks == 15) {
                shootDeathProjectiles(15, 2, 2.5f, false);
            }
            if (attackTicks == 25) {
                shootDeathProjectiles(35, 2, 2, false);
            }
            if (attackTicks == 35) {
                shootDeathProjectiles(90, 2, 1, false);
            }
            if (attackTicks == 45) {
                //    shootDeathProjectiles(54,2,2.2f);
            }
            if (attackTicks == 100) {
                playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                shootDeathProjectiles(90, 4, 1, true);
                //  shootDeathProjectiles(0,2,2);
            }
        }
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

    public void shootDeathProjectiles(float angle, int amount, float y, boolean biggieCheese) {
        int upperArmorAmount = amount;
        for (int i = 0; i < upperArmorAmount; i++) {

            float throwAngle = (i * Mth.PI / (upperArmorAmount / 2)) + angle;

            double sx = getX() + (Mth.cos(throwAngle) * 1);
            double sy = getY() + y;
            double sz = getZ() + (Mth.sin(throwAngle) * 1);

            double vx = Mth.cos(throwAngle);
            double vy = 0 + getRandom().nextFloat() * 0.3F;
            double vz = Mth.sin(throwAngle);
            double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
            if (biggieCheese) {
                if (level().isClientSide) {
                    level().addParticle(ModParticles.GROUND_ANNIHILATION_NUKE.get(), sx, sy + 4, sz, 0, 0, 0);
                }
                AnnihilationBombEntity projectile = new AnnihilationBombEntity(ModEntities.ANNIHILATION_BOMB_ENTITY.get(), level(), this, 10, 16, false);

                CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 10, 5);

                projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());

                float speed = 0.7F;
                projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);

                level().addFreshEntity(projectile);
            } else {
                playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), 1, 1);
                CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
                SmallAnnihilationBombEntity projectile = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), level(), this, 8);
                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), sx, sy, sz, 0, 0, 0);
                }
                projectile.moveTo(sx, sy, sz, i * 11.25F, getXRot());
                float speed = 0.7F;
                projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                projectile.setOwner(this);
                level().addFreshEntity(projectile);
            }
        }
    }

    public void createCircularLightningParticle(float vec, float offset, int part, float size) {
        for (int i = 0; i < 360; i++) {
            if (i % part == 0) {
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                double theta = (this.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int floor = Mth.floor(this.getY());

                double d0 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().x;
                double d1 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().y;
                double d2 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().z;
                double dist = 1F + random.nextFloat() * 0.2F;
                double d3 = d0 * dist;
                double d4 = d1 * dist;
                double d5 = d2 * dist;
                this.level().addParticle(new LightningParticle.OrbData(0, 255, 0),

                        (this.getX() + vec * vecX + f * offset), this.getY(), (this.getZ() + vec * vecZ + f1 * offset), Mth.sin(i) * size, d4, Mth.cos(i) * size);
            }
        }
    }

    private void createAnnihilationPortal(double pX, double pZ, double pMinY, double pMaxY, int life, int pWarmupDelay, float scale, float damage) {
        BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
        boolean flag = false;
        double d0 = 0.0;

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
        } while (blockpos.getY() >= Mth.floor(pMinY) - 1);

        if (flag) {
            this.level().addFreshEntity(new AnnihilationPortalEntity(this.level(), pX, (double) blockpos.getY() + d0, pZ, 0, pWarmupDelay, this, life, damage, true, scale));
        }

    }

    private void flameRadagonShockwave(float spreadarc, int distance, float vec, int delay, float pos, float offset, float damage, boolean warningParticle) {
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
        int arcLen = getAttackState() == 53 ? Mth.ceil(distance * spread * 0.15f) : Mth.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = x + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = z + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnFlames(hitX + 0.5D, hitZ + 0.5D, this.getY() - 5, this.getY() + 3, (float) theta, delay, damage, warningParticle, ModParticles.GROUND_ANNIHILATION_NUKE.get());
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

    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + 3, getZ(), 1, 0, 0, 0, 0);
        }

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {

            EntityTeleportEvent.EnderEntity event = ForgeEventFactory.onEnderTeleport(this, x, y, z);
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
                // EntityUtil.applyServerTeleport(this);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {

            this.teleportTo(d0, d1, d2);
            // EntityUtil.applyServerTeleport(this);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte) 46);
            }
            this.getNavigation().stop();

            return true;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.THE_WARPED_ONE_HURT.get();
    }


    /// USEFUL BOOLEANS AND OTHER STUFF
    //Quad
    public boolean canUltimate() {
        return getIsThirdPhase() && ultimate_cooldown <= 0 && targetIsNotNull() && distanceTo(target()) < 7;
        // return false;
    }


    public int getStunDuration() {
        return 50;
    }

    public boolean canArmBlock() {
        return getAttackState() == 0 && arm_block_cooldown <= 0 && !level().isClientSide && getTarget() != null && distanceTo(this.getTarget()) < 6 && getPhase() >= 3;
    }

    public boolean canParry() {
        return !gambitParry && !level().isClientSide && (getAttackState() == 57 || (getAttackState() == 56 && attackTicks > 20)) && getPhase() >= 3;
    }

    public boolean isParrying() {
        return getAttackState() == 59 && attackTicks < 60;
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.OBLITERATOR_STEREO.get();
    }

    @Override
    public int attackDelayTicksValue() {
        return arm_block_cooldown <= 0 ? 3 : delay;//old 1:3
    }

    public int delay = 1;

    public boolean isHittingWithBlades() {
        return getAttackState() == 59 || getAttackState() == 15 || getAttackState() == 23 || getAttackState() == 31 || getAttackState() == 32 || getAttackState() == 4 || getAttackState() == 5 || getAttackState() == 30 || getAttackState() == 35;
    }

    public boolean succedGrabbing;

    //DATA ATTRIBUTES


    @Override
    public double baseHealth() {
        return getMaxHealth();
    }

    //SWAP POSITIONS


    //Vertex Render

    public float getVertexSize;
    public float vertexSize;
    public float vertexTicks;
    //Target Pos
    public double lastTargetX;
    public double lastTargetY;
    public double lastTargetZ;


    public double teleportX;
    public double teleportZ;
    public double teleportY;

    public void saveTeleportPositions(double x, double y, double z) {
        lastX = x;
        lastY = y;
        lastZ = z;

    }

    public void saveTeleportPos(LivingEntity target, boolean statement, float vec1, float offset1) {

        if (statement) {
            float f = Mth.cos(target.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(target.yBodyRot * ((float) Math.PI / 180F));
            double theta = (target.yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = vec1;
            float offset = offset1;
            //teleport((target().getX() + vec * vecX + f * offset), getY(), (float) (target().getZ() + vec * vecZ + f1 * offset));
            teleportX = (target.getX() + vec * vecX + f * offset);
            teleportZ = (target.getZ() + vec * vecZ + f1 * offset);
            teleportY = target.getY();

        }
    }

    //Boss Pos
    public double lastX;
    public double lastY;
    public double lastZ;

    //Phase Change
    public boolean getIsSecondPhase() {
        return entityData.get(PHASE) == 2;
    }

    public void setPhase(int phase) {
        entityData.set(PHASE, phase);
    }

    public int getPhase() {
        return entityData.get(PHASE);
    }

    public boolean getIsThirdPhase() {
        return entityData.get(PHASE) > 2;
    }

    public void setIsSecondPhase(boolean phase) {
        entityData.set(IS_SECOND_PHASE, phase);
        // setPhase(2);
    }

    public void setIsThirdPhase(boolean phase) {
        entityData.set(IS_THIRD_PHASE, phase);
        // setPhase(3);
    }

    //Other
    public boolean animationLockedForTests() {
        return false;
    }

    public LivingEntity target() {
        return getTarget();
    }

    public boolean hasTarget() {
        return getTarget() != null;
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    public boolean isShootingClusterBomb() {
        return getAttackState() == 6 || getAttackState() == 7 || getAttackState() == 55;
    }

    public boolean isDuringTeleportation(boolean statement) {
        return statement && (getAttackState() == 7 && attackTicks > 51 && attackTicks < 54) || (getAttackState() == 13 && attackTicks > 30 && attackTicks < 61)
                || (getAttackState() == 14 && (attackTicks > 30 && attackTicks < 57)) || (getAttackState() == 14 && (attackTicks > 73 && attackTicks < 100))
                || (getAttackState() == 21 && (attackTicks >= 5 && attackTicks < 8)) || (getAttackState() == 44 && (attackTicks >= 10 && attackTicks < 16))
                || (getAttackState() == 52 && (attackTicks >= 12 && attackTicks < 18)) || (getAttackState() == 53 && (attackTicks >= 105 && attackTicks < 113))
                || (getAttackState() == 47 && (attackTicks >= 34 && attackTicks < 37)) || (getAttackState() == 22 && (attackTicks >= 78 && attackTicks < 86))
                || (getAttackState() == 22 && (attackTicks >= 45 && attackTicks < 50)) || (getAttackState() == 23 && (attackTicks >= 14 && attackTicks < 18))
                || (getAttackState() == 32 && (attackTicks >= 14 && attackTicks < 18)) || (getAttackState() == 55 && (attackTicks >= 11 && attackTicks < 16))
                || (getAttackState() == 35 && (attackTicks >= 16 && attackTicks <= 18)) || (getAttackState() == 33 && (attackTicks >= 13 && attackTicks <= 17))
                || (getAttackState() == 56 && (attackTicks >= 8 && attackTicks <= 13)) || (getAttackState() == 59 && (attackTicks >= 27 && attackTicks <= 32))
                || (getAttackState() == 46 && (attackTicks >= 9 && attackTicks <= 14)) || (getAttackState() == 12 && (attackTicks >= 18 && attackTicks <= 21))
                || (getAttackState() == 62 && attackTicks > 30 && attackTicks < 80)
                ;//23 32 Slash Combo Teleport
    }

    //Swap System
    public void savePreSwapPositions(boolean statement) {
//System.out.println("Saving Swap..");
        if (statement) {
            lastTargetX = target().getX();
            lastTargetY = target().getY();
            lastTargetZ = target().getZ();


            lastX = getX();
            lastY = getY();
            lastZ = getZ();
        }

    }

    //Swap
    public void swapPositions(boolean statement) {
        // System.out.println("Swapping..");
        if (statement) {
            //  System.out.println("Swapped!");
            this.teleport(lastTargetX, lastTargetY, lastTargetZ);

            target().teleportTo(lastX, lastY, lastZ);
        }

    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        setAttackState(60);
        deathTime = 0;
        stopAllAnimationStates();
        if (this.level() instanceof ServerLevel level) {
            ModSavedData.get(level).setDefeatedObliterator(true);
        }
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;

        if (deathTime == 102) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.TheObliteratorHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    private void launch(LivingEntity entity, boolean huge, float launchMultiplier, float yPower) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? launchMultiplier : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? yPower : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    public void calculatedDashTowardsLocation(float Multiplier, float LocX, float LocZ) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((LocX - this.getX()) * Multiplier, 0, (LocZ - this.getZ()) * Multiplier);
        }
    }

    public void backStep(float backstepStrenght, float yStrenght) {

        float yaw = (float) Math.toRadians(this.getYRot() + 90);
        Vec3 dodgePos = this.getDeltaMovement().add(backstepStrenght * Math.cos(yaw), yStrenght, backstepStrenght * Math.sin(yaw));
        this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 46) {
            super.handleEntityEvent(id);
        } else {
            super.handleEntityEvent(id);
        }
    }

    private void runAway() {
        if (!level().isClientSide) {
            if (this.onGround()) {
                Vec3 randomShake = new Vec3(random.nextFloat() - 0.5F, 0, random.nextFloat() - 0.5F).scale(0.1F);
                this.setDeltaMovement(this.getDeltaMovement().multiply(2F, 1, 2F).add(randomShake));
            }
            if (this.getNavigation().isDone()) {
                Vec3 vec = LandRandomPos.getPosAway(this, 15, 7, this.position());
                if (vec != null) {
                    this.getNavigation().moveTo(vec.x, vec.y, vec.z, 2D);
                }
            }

        }
    }

    @Override
    public boolean isPushable() {
        return !isDuringTeleportation(!level().isClientSide);
    }

    @Override
    public boolean fireImmune() {
        return super.fireImmune();
    }

    public boolean canReduceDamageDuringPhaseTransition() {
        Crackiness crackiness = getCrackiness();
        return (getPhase() <= 1 && crackiness == Crackiness.MEDIUM) || (getPhase() <= 2 && crackiness == Crackiness.HIGH);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {

        if (source.is(DamageTypeTags.BYPASSES_ARMOR) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && getAttackState() == 53 || canReduceDamageDuringPhaseTransition()) {
            amount *= 0.5f;
        }
        int cheeseDistance = ModConfig.MOB_CONFIG.TheObliteratorAntiAirborneDistance.get();
        if (!level().isClientSide && (InvulnerabilityTime > 0 && ModConfig.MOB_CONFIG.TheObliteratorInvulnerabilityTime.get()) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || isTargetCheesing(-cheeseDistance, cheeseDistance))
            return false;
        if (((getAttackState() == 52 && attackTicks <= 12) || getAttackState() == 19 || getAttackState() == 40 || getAttackState() == 2 || getAttackState() == 48 || getAttackState() == 1)
                || this.isVehicle()
                || isDuringTeleportation(!level().isClientSide) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || isParrying()) {

            return false;
        }
        if (canParry()) {
            setAttackState(59);
            gambitParry = true;
            CameraShakeEntity.cameraShake(level(), position(), 10, 0.15f, 5, 5);
            playSound(ModSounds.BLOCK.get(), 1, 0.9f);
            return false;
        }

        if (canArmBlock() && amount > 1) {
            setAttackState(52);
            playSound(ModSounds.BLOCK.get(), 1, 1);
            return false;
        }
        if (source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypeTags.IS_FALL)) {
            return false;
        }
        if ((source.is(DamageTypes.ARROW) || source.is(DamageTypes.MOB_PROJECTILE)) && getPhase() == 1) {
            return false;
        }

        boolean hurt1 = super.hurt(source, amount);
        if (hurt1) {
            if (!level().isClientSide) {
                if (InvulnerabilityTime <= 0) {
                    InvulnerabilityTime = 10;
                }
            }
        }
        return hurt1;
    }

    public boolean switchDamageSystems = false;

    @Override
    public boolean damageReductionSystem() {
        return switchDamageSystems;
    }

    @Override
    public boolean damageAdaptationSystem() {
        return !switchDamageSystems;
    }

    @Override
    public int adaptationFactor() {
        return 20 * ModConfig.MOB_CONFIG.TheObliteratorAdaptationFactorMultiplier.get();
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }

    @Override
    public double damageCap() {
        return ModConfig.MOB_CONFIG.TheObliteratorDamageCap.get();
    }


    @Override
    public double antiCheeseDistance() {
        return super.antiCheeseDistance();
    }

    /// RIDING SYSTEM
    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        float math = 0f;
        float vec = 3.5f;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        return new Vec3(getX() + vec * vecX + f * math, getY(), getZ() + vec * vecZ + f1 * math);
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {

        int state = this.getAttackState();
        if (state == 19) {
            return false;
        }
        return super.causeFallDamage(fallDistance, multiplier, source);
    }


    /// HIT BOXES

    private void Grab(float RangeXZ, float range, int brokenShieldTicks, float damage) {

        if (this.level().isClientSide) return;

        boolean hitAny = false;
        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox()
                .inflate(RangeXZ, 4, RangeXZ)
                .expandTowards(xRange, 0, zRange);

        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                hitAny = true;
                float m = entityHit.getMaxHealth() * toPercent(3);
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this),
                        (float) (((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, 3) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get()))));
                boolean entityHitisTarget = entityHit == target();
                boolean mounted = entityHitisTarget && entityHit.startRiding(this, true);

                if (flag && getAttackState() == 17) {

                    EntityUtil.cancelBuffs(entityHit);
                    double x = entityHit.getX() - this.getX();
                    double z = entityHit.getZ() - this.getZ();
                    double d = Math.sqrt(x * x + z * z);
                    entityHit.setDeltaMovement(x / d * 0.8, 1.25, z / d * 0.8);
                    EntityUtil.applyPlayerDeltaMovement(entityHit);
                }
                if (flag && mounted) {

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

    private void PreGrab(float RangeXZ, float y, float range, int brokenShieldTicks, float damage) {

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
                        (float) (((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, 3)) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));


                if (flag && (getAttackState() == 17 || getAttackState() == 47)) {
                    double x = entityHit.getX() - this.getX();
                    double z = entityHit.getZ() - this.getZ();
                    double d = Math.sqrt(x * x + z * z);
                    entityHit.setDeltaMovement(x / d * 0.8, 1.25, z / d * 0.8);
                    EntityUtil.applyPlayerDeltaMovement(entityHit);
                }

                if (flag) {
                    EntityUtil.cancelBuffs(entityHit);
                    TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
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

    private void StraightLineAreaAttack(float boxWidth, float range, int brokenShieldTicks, float damage, float precentage, boolean launch) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, 4f, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) (((damage + TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, precentage)) * ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get())));
                if (flag)
                    TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
                if (flag && getAttackState() == 17) {
                    succedGrabbing = true;

                    double x = entityHit.getX() - this.getX();
                    double z = entityHit.getZ() - this.getZ();
                    double d = Math.sqrt(x * x + z * z);
                    entityHit.setDeltaMovement(x / d * 0.8, 1.25, z / d * 0.8);
                    EntityUtil.applyPlayerDeltaMovement(entityHit);
                } else {
                    succedGrabbing = false;
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

    private void StraightLineAreaAttack(float boxWidth, double inflateY, float range, int brokenShieldTicks, float damage, float precentage, boolean launch, SoundEvent soundEvent) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, inflateY, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage + TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, precentage) * ModConfig.MOB_CONFIG.PosessedPaladinDamageMutliplier.get())));
                if (flag)
                    TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
                if (flag && getAttackState() == 17) {
                    succedGrabbing = true;

                    double x = entityHit.getX() - this.getX();
                    double z = entityHit.getZ() - this.getZ();
                    double d = Math.sqrt(x * x + z * z);
                    entityHit.setDeltaMovement(x / d * 0.8, 1.25, z / d * 0.8);
                    EntityUtil.applyPlayerDeltaMovement(entityHit);
                } else {
                    succedGrabbing = false;
                }
                if (flag && launch) {


                    EntityUtil.cancelBuffs(entityHit);
//launch(entityHit,true,2,0.3f);
                    launch(entityHit, true);
                }
                if (targetIsNotNull() && entityHit == target()) {
                    playSound(soundEvent, 1, 1);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    public void AreaAttack(float range, float height, float arc, float damage, float precentage, int brokenShieldTicks, boolean canStun, boolean canlaunch) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheWarpedOneOld) && entityHit != this) {
                    if (targetIsNotNull() && entityHit == target() && canStun) {

                        CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.15F, 0, 20);
                    }
                    boolean canPlaySound = getAttackState() != 22;
                    double m = Math.min(entityHit.getMaxHealth() * 0.03f, 30);
                    boolean flag = entityHit.hurt(this.getAttackState() == 14 || this.getAttackState() == 20 || this.getAttackState() == 24 ?
                            ModDamageTypes.causeAnnihilationDamage(this, this) :
                            this.damageSources().mobAttack(this), (float) ((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, precentage) * ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get())));
                    if (getAttackState() == 14) {
                        swapPositions(flag && targetIsNotNull());
                    }

                    if (flag) {


                        EntityUtil.cancelBuffs(entityHit);
                        TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
//launch(entityHit,true,2,0.3f);
                        if (canlaunch) {
                            if (getAttackState() == 8) {
                                launch(entityHit, true, 1.5f, 0.25f);
                            } else {
                                launch(entityHit, true, 2f, 0.5f);
                            }
                        }
                        if (!canStun && canPlaySound) {
                            playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 0.5f);
                        }
                        if (canStun) {

                            playSound(ModSounds.THE_OBLITERATOR_STUN.get(), 1, 1f);
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), getStunDuration(), 1));
                        }

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }


    public void SideAreaAttack(float range, float height, float arc, float boxOffset, float damage, float precentage, int brokenShieldTicks, boolean canStun, boolean canlaunch, SoundEvent soundEvent, float pitch) {

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


                    boolean flag = entityHit.hurt((this.getAttackState() == 14 || this.getAttackState() == 40 || this.getAttackState() == 50) ? ModDamageTypes.causeAnnihilationDamage(this, this) :
                            this.damageSources().mobAttack(this), (float) ((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, precentage) * ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get())));
                    if (flag) {

                        EntityUtil.cancelBuffs(entityHit);
                        TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
                        if (isHittingWithBlades() && getIsThirdPhase()) {
                            entityHit.setSecondsOnFire(3);
                        }
                        if (canlaunch) {

                            if (getAttackState() == 8) {
                                launch(entityHit, true, 1.5f, 0.25f);
                            } else {
                                if (getAttackState() != 22) {
                                    launch(entityHit, true, 2f, 0.5f);
                                } else {
                                    Vec3 getDeltaMovement = new Vec3(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z);
                                    entityHit.push(getDeltaMovement.x * 1.1, 0.5f, getDeltaMovement.z * 1.1);
                                }
                            }
                        }
                        if (!canStun) {

                        }
                        playSound(soundEvent, 1, pitch);
                        if (canStun) {

                            //    System.out.println("Detected Using Flag");
                            if (getAttackState() == 59) {//Parry heal
                                //  System.out.println("Detected Anim 59");
                                this.heal(20);
                            }
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), getStunDuration(), 1));
                        }

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
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
                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, 3) * ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get())));
                    if (flag && mounted) {
                        EntityUtil.cancelBuffs(entityHit);
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

    public void SideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            float precentage,
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheObliteratorEntity) && entityHit != this) {

                    float m = entityHit.getMaxHealth() * 0.03f;
                    boolean flag = entityHit.hurt((this.getAttackState() == 14 || this.getAttackState() == 53) ? ModDamageTypes.causeAnnihilationDamage(this, this) :
                            this.damageSources().mobAttack(this), (float) (((damage * TheObliteratorUtils.opArmorNerf(entityHit, this) + entityBasedHpDamage(entityHit, precentage) * ModConfig.MOB_CONFIG.TheObliteratorDamageMutliplier.get()))));
                    if (flag) {
                        EntityUtil.cancelBuffs(entityHit);
                        TheObliteratorUtils.applyAnnihilationEffect(entityHit, ModEffects.ANNIHILATION.get(), 1, true);
                        if (isHittingWithBlades() && getIsThirdPhase()) {
                            entityHit.setSecondsOnFire(3);
                        }
                        if (canlaunch) {
                            if (getAttackState() == 8) {
                                launch(entityHit, true, 1.5f, 0.25f);
                            } else {
                                launch(entityHit, true, 2f, 0.5f);
                            }
                        }

                        playSound(soundEvent, 1, pitch);
                        if (canStun) {

                            // System.out.println("Detected Using Flag");
                            if (getAttackState() == 59) {//Parry heal
                                // System.out.println("Detected Anim 59");
                                this.heal(20);
                            }
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), getStunDuration(), 1));
                        }

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    /// ATTRIBUTES
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 450)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 60D)
                .add(Attributes.ARMOR, 14D)
                .add(Attributes.ARMOR_TOUGHNESS, 4D)
                .add(Attributes.MOVEMENT_SPEED, 0.12F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 6);
    }

    /// PROJECTILES
    public void shootAnnihilationBomb(float velocity, float x, float y, float z) {
        if (targetIsNotNull()) {

            AnnihilationBombEntity chorusBomb = new AnnihilationBombEntity(ModEntities.ANNIHILATION_BOMB_ENTITY.get(), this.level(), this, 10, 16, false);

            chorusBomb.setPosRaw(x, y, z);

            double d0 = target().getX() - x;

            double d4 = (target().getY() - y) * 0.5f;
            double d1 = target().getBoundingBox().minY + target().getBbHeight() / 2 - chorusBomb.getY();
            double d2 = target().getZ() - z;
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            //chorusBomb.shoot(d0, d1, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);
            chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);


            chorusBomb.setOwner(this);
            //chorusBomb.setPos(x, y, z);
            this.level().addFreshEntity(chorusBomb);
        }

    }

    public void shootAngledBombs(float velocity, double x, double y, double z, int bombCount, float angleBetween, float elevationAngle) {
        if (!targetIsNotNull()) return;

        double dx = target().getX() - x;
        double dz = target().getZ() - z;
        Vec3 flatDir = new Vec3(dx, 0, dz).normalize();

        double elevRad = Math.toRadians(elevationAngle);

        double totalSpread = angleBetween * (bombCount - 1);
        double startYaw = -totalSpread * 0.5;

        for (int i = 0; i < bombCount; i++) {

            double yawOffset = startYaw + i * angleBetween;
            Vec3 dirYaw = rotateYaw(flatDir, yawOffset);

            double cosP = Math.cos(elevRad);
            double sinP = Math.sin(elevRad);
            Vec3 finalDir = new Vec3(dirYaw.x * cosP, sinP, dirYaw.z * cosP);

            SmallAnnihilationBombEntity bomb = new SmallAnnihilationBombEntity(
                    ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(),
                    this.level(), this, 3
            );
            bomb.setTurnRate(0);
            bomb.setPosRaw(x, y, z);
            bomb.shoot(finalDir.x, finalDir.y, finalDir.z, velocity, 0);
            bomb.setOwner(this);
            this.level().addFreshEntity(bomb);
        }
    }

    private Vec3 rotateYaw(Vec3 vec, double angleDeg) {
        double rad = Math.toRadians(angleDeg);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double x = vec.x * cos - vec.z * sin;
        double z = vec.x * sin + vec.z * cos;
        return new Vec3(x, vec.y, z);
    }

    public void spawnDuplicateVersions(double x, double z, double minY, double maxY, float rotation, int delay, float destX, float destY, float destZ) {

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
            this.level().addFreshEntity(new TheObliteratorCloneEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, 16, destX, destY, destZ));
        }
    }

    public void spawnArmedClones(double x, double z, double minY, double maxY, float rotation, int delay, double destX, double destY, double destZ, int animation, int life) {

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
            this.level().addFreshEntity(new TheObliteratorCloneWithArmsEntity(this.level(), x, (double) blockpos.getY() + d0,
                    z, rotation, delay, entity1, 16F, (float) destX, (float) destY, (float) destZ, animation, life));
        }
    }

    public Crackiness getCrackiness() {
        return Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.65F),
        HIGH(0.30F);

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

    /// PARTICLES
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

    private void spawnFlames(double x, double z, double minY, double maxY, float rotation, int delay, float damage, boolean particle, ParticleOptions particleOptions) {

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
            if (!particle) {
                if (getAttackState() != 53 && getAttackState() != 59) {
                    this.level().addFreshEntity(new AnnihilationFlameStrike(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, 20, damage + 2));
                } else {
                    this.level().addFreshEntity(new AnnihilationGroundNukeStrikeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this, 20, damage));
                }
            } else {
                if (level().isClientSide)
                    this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 30, 0, 1, 0, 1.0f, 30,
                            false, Circle.EnumRingBehavior.SHRINK), x, (double) blockpos.getY() + d0, z, 0, 0, 0);
            }

        }
    }

    public void shootPlasmaBall(int numberOfProjectiles, float spawnAngle, boolean turnLeft, float turnStrenght, float damage) {
        double theta = (yBodyRot) * (Math.PI / 180);

        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int numberOfSkulls = numberOfProjectiles;
        float angleStep = spawnAngle;
        for (int i = 0; i < numberOfSkulls; i++) {
            float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

            float rad = (float) Math.toRadians(angle);
            double dx = -Math.sin(rad);
            double dz = Math.cos(rad);
            PlasmaOrbEntity witherskull = new PlasmaOrbEntity(this, dx, 0, dz, this.level(), 6, angle, 20);
            double spawnX = this.getX() + vecX * 1;
            double spawnY = this.getY(0.15D);
            double spawnZ = this.getZ() + vecZ * 1;
            witherskull.setTurnLeft(turnLeft);
            witherskull.setTurnStrength(turnStrenght);
            witherskull.setPos(spawnX, spawnY, spawnZ);
            this.level().addFreshEntity(witherskull);
        }
    }

    public void shootAnnihilationGeysers(int numberOfProjectiles, float spawnAngle, boolean turnLeft, float turnStrenght, float damage, int life) {
        double theta = (yBodyRot) * (Math.PI / 180);

        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int numberOfSkulls = numberOfProjectiles;
        float angleStep = spawnAngle;
        for (int i = 0; i < numberOfSkulls; i++) {
            float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

            float rad = (float) Math.toRadians(angle);
            double dx = -Math.sin(rad);
            double dz = Math.cos(rad);
            AnnihilationGeyserEntity witherskull = new AnnihilationGeyserEntity(this, dx, 0, dz, this.level(), damage, angle, life);
            double spawnX = this.getX() + vecX * 1;
            double spawnY = this.getY();
            double spawnZ = this.getZ() + vecZ * 1;
            witherskull.setTurnLeft(turnLeft);
            witherskull.setTurnStrength(turnStrenght);
            witherskull.setPos(spawnX, spawnY, spawnZ);
            this.level().addFreshEntity(witherskull);
        }
    }


    public void doSmashEffects(float circleVec, float circleOffset, SoundEvent soundEvent) {
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = circleVec;
        float offset = circleOffset;
        if (level().isClientSide) {

            float g = (float) Math.toRadians(-getYRot() + 180);
            this.level().addParticle(new Circle.RingData(g, 0, 30, 0, 1, 0, 1.0f, 60, true, Circle.EnumRingBehavior.GROW_THEN_SHRINK),
                    (getX() + vec * vecX + f * offset), getY(), (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
        }
        spawnCircleParticle(2, 0, 80, true, 7, 0, 1, 0, 1);
        this.playSound(soundEvent, 1, 1);

    }

    public void createSweep(float pos, float posOffset, float yHeight, boolean reverse, float scale) {
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
            double d1 = this.getY() + this.getBbHeight() / 2 + 0.4;
            double d2 = z;
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? 180 : 0));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
            this.level().addParticle(new AnnihilationSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);

        }
    }

    public void doTeleportEffects(boolean shouldSendProjectiles) {
        this.playSound(SoundEvents.ENDERMAN_TELEPORT, 3, 1);
    }

    public void doPortalEffect(double multiplier, float size, int amountOfPortals, int warmup, float scale, int life, float damage) {

        for (int k = 0; k < amountOfPortals; ++k) {
            float f3 = (float) k * (float) Math.PI * size / amountOfPortals + ((float) Math.PI * size / 10F);
            int standingOnY = Mth.floor(getY());

            createAnnihilationPortal(getX() + Mth.cos(f3) * multiplier, getZ() + Mth.sin(f3) * multiplier, getY() - 5, getY() + 5, life, warmup, scale, damage);
            //this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, 10);

        }
    }

    public void doFlamesEffect(double multiplier, float size, int amountOfFlames, boolean particle, ParticleOptions particleOptions, double particleAdditionalY) {
        if (particle) {
            for (int k = 0; k < amountOfFlames; ++k) {
                float f3 = (float) k * (float) Math.PI * size / amountOfFlames + ((float) Math.PI * size / 10F);
                int standingOnY = Mth.floor(getY());
                level().addParticle(particleOptions, getX() + Mth.cos(f3) * multiplier, getY() + particleAdditionalY, getZ() + Mth.sin(f3) * multiplier, 0, 0, 0);
                //  this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, 10);
            }
        } else {
            for (int k = 0; k < amountOfFlames; ++k) {
                float f3 = (float) k * (float) Math.PI * size / amountOfFlames + ((float) Math.PI * size / 10F);
                int standingOnY = Mth.floor(getY());
                this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, 5, false, ModParticles.ANNIHILATION_NUKE.get());
            }
        }
    }

    public void attractingParticles(ParticleOptions particleType, float speed, float range) {
        if (level().isClientSide) {

            Vec3 center = position().add(0, getY(), 0);

            for (int i = 0; i < 20; i++) {
                double x = center.x + (level().random.nextDouble() - 0.5) * 2 * range;
                double y = center.y + (level().random.nextDouble() - 0.5) * 2 * range;
                double z = center.z + (level().random.nextDouble() - 0.5) * 2 * range;

                Vec3 from = new Vec3(x, y, z);
                Vec3 dir = center.subtract(from).normalize().scale(speed);

                level().addParticle(particleType, x, y, z, dir.x, dir.y, dir.z);
            }
        }
    }

    public void pullParticles(ParticleOptions particleOptions, float speed, float range) {

        if (level().isClientSide) {
            for (int i = 0; i < 80; i++) {

                double startX = getX() + (random.nextDouble() - 0.5) * (double) range;
                double startY = getY() + (random.nextDouble() - 0.5) * (double) range;
                double startZ = getZ() + (random.nextDouble() - 0.5) * (double) range;

                double dirX = getX() - startX;
                double dirY = getY() - startY;
                double dirZ = getZ() - startZ;
                double length = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);

                dirX /= length;
                dirY /= length;
                dirZ /= length;

                double speedX = dirX * speed;
                double speedY = dirY * speed;
                double speedZ = dirZ * speed;

                level().addParticle(particleOptions, startX, startY, startZ, speedX, speedY, speedZ);
            }
        }

    }


}
