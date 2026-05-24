package net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.Ancient_GuardianEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.*;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.LMBossInfoServer;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

public class Cloud_GolemEntity extends IAnimatedBoss {


    private static final EntityDataAccessor<Boolean> GAVE_CHANCE =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT2 =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT1 =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.INT);

    public boolean isBroken() {
        return this.entityData.get(BREAK) >= 3;
    }

    public float LayerBrightness, oLayerBrightness;
    private static final EntityDataAccessor<Integer> BREAK =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PTICKS =
            SynchedEntityData.defineId(Cloud_GolemEntity.class, EntityDataSerializers.INT);


    private int stunCooldown = 0;
/*
    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {

       // System.out.println("Interacting");
        if (this.level().isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemStack = pPlayer.getMainHandItem();
            //System.out.println("Item" + itemStack);
           // System.out.println("Works");
            Item item = Items.GLASS_BOTTLE;
            if (itemStack.is(item) && this.isAngry()) {
                if (!pPlayer.getAbilities().instabuild) itemStack.shrink(1);
                pPlayer.addItem(ModItems.BOTTLED_LIGHTNING.get().getDefaultInstance());
            }

         //   System.out.println("Fail");
            return super.mobInteract(pPlayer, pHand);

        }
    }*/

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public boolean canBePushedByEntity(Entity entity) {
        return getAttackState() != 9;
    }

    public Cloud_GolemEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        xpReward = 100;
        this.lastYaw = this.yHeadRot;
        this.lastPitch = this.getXRot();
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();


        }

    }


    public void clearFire() {
        this.setRemainingFireTicks(0); // Ustawia czas trwania płomienia na 0
    }

    public Cloud_GolemEntity.Crackiness getCrackiness() {
        return Cloud_GolemEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
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
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(level().damageSources().mobAttack(this), 11 * damage + Math.min(11 * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    private final LMBossInfoServer bossInfo = new LMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.WHITE, false, 0);

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.65F),
        HIGH(0.25F);
        private static Cloud_GolemEntity entity;
        private static final List<Cloud_GolemEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Cloud_GolemEntity.Crackiness byFraction(float pFraction) {


            for (Cloud_GolemEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;

        }
    }

    public int tornado = 0;
    public int pullCooldown = 160;

    public float LayerTicks;
    public int cooldownTicksThunder = 0;

    public int cooldownStompLeft = 0;

    public int chargeCooldown = 0;
    public final int TICKS_WITHOUT_TARGET  = 60;
    public int ticksWithoutTarget = TICKS_WITHOUT_TARGET;

    public void regainHealthWithoutTarget(float health, float speed) {

        if (ModConfig.MOB_CONFIG.AllowBossNatureHeal.get()) {
            if (!level().isClientSide) {
                if (this.getTarget() == null && ticksWithoutTarget > 0 && getAttackState() == 0) {
                    --ticksWithoutTarget;

                }
                if (ticksWithoutTarget <= 0) {
                    if (tickCount % speed == 0) {
                        this.heal(health);
                    }
                }
                if (this.getTarget() != null) {
                    ticksWithoutTarget = TICKS_WITHOUT_TARGET;
                }
            }
        }
    }

    public boolean hasSwitched = false;
    public int safetyShouldLaserTornadoSwitchCooldown = 60;

    @Override
    public void tick() {

        if (ticksWithoutTarget == 0 && getTarget() == null && ModConfig.MOB_CONFIG.canBossesResetPhases.get()) {
            if (this.getTextureVariant() == 1 && (getCrackiness() == Crackiness.LOW || getCrackiness() == Crackiness.NONE)) {
                entityData.set(TEXTURE_VARIANT, 0);
            }
        }
        if (shouldLaserAfterTornado && getAttackState() != 14 && getAttackState() != 23 && safetyShouldLaserTornadoSwitchCooldown > 0) {
            safetyShouldLaserTornadoSwitchCooldown--;
        }
        if (safetyShouldLaserTornadoSwitchCooldown <= 0) {
            shouldLaserAfterTornado = false;
            safetyShouldLaserTornadoSwitchCooldown = 60;
        }

        if (ArrowDamageCooldown > 0) {
            --ArrowDamageCooldown;
        }
        LivingEntity target = this.getTarget();
        if (target != null) {
            if (target instanceof Player) {
                DamageCap = 6;
            } else {
                DamageCap = 27;
            }
        }

        if (!this.level().isClientSide()) {
            if (!isSleep()) {
                bossInfo.setVisible(true);
            } else {
                bossInfo.setVisible(false);
            }
        }

        regainHealthWithoutTarget(20, 15);

        if (!this.level().isClientSide()) {
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
            if (isAngry()) {
                bossInfo.setRenderType(1);
                bossInfo.setDarkenScreen(true);
            }else {
                bossInfo.setRenderType(0);
                bossInfo.setDarkenScreen(true);
            }
        }

        if ((getAttackState() == 0 && attackLock == 1 && !isAngry())) {
            setAttackState(21);
        }
        super.tick();

        // regainHealthWithoutTarget(10,10);
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
        if (this.level().isClientSide) {
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }
        this.getActiveEffects().clear();
        if (this.isBroken() && !this.isAngry()) {
            this.entityData.set(TEXTURE_VARIANT, 2);
        }

        if (this.isBroken() && this.isAngry()) {
            this.entityData.set(TEXTURE_VARIANT, 3);
        }
        Cloud_GolemEntity.Crackiness crackiness = this.getCrackiness();
        if (crackiness == Cloud_GolemEntity.Crackiness.MEDIUM && !isAngry() && attackLock == 0) {
            attackLock = 1;
        }
        if (this.getAttackState() != 9) {
            particle1 = false;
            this.entityData.set(TEXTURE_VARIANT1, 0);
        }
        if (this.getAttackState() != 11) {
            this.entityData.set(TEXTURE_VARIANT2, 0);

        }

        if (this.getAttackState() != 13) {

            this.setInvulnerable(false);
        }
        updateWithAttack();
        if (laserCooldown > 0 && isAngry()) {
            --laserCooldown;
        }
        if (chargeCooldown > 0) {
            --chargeCooldown;
        }
        if (cloudSwarmCooldown > 0) {
            --cloudSwarmCooldown;
        }
        if (GolemInvulnerabilityTime > 0) {
            --GolemInvulnerabilityTime;
        }

        if (cooldownStompLeft > 0) {
            --cooldownStompLeft;
        }
        if (cooldownTicksThunder > 0) {
            --cooldownTicksThunder;
        }
        if (entityData.get(PTICKS) >= 0) {
            entityData.set(PTICKS, entityData.get(PTICKS) + 1);
        }
        if (electricBurstCooldown > 0) {
            --electricBurstCooldown;
        }
        if (getAttackState() != 27 && getAttackState() != 28 && getAttackState() != 30) {
            shouldDoExtraDashes = true;
            // System.out.println("shouldDoExtraDashes: " + shouldDoExtraDashes);
        }
        if (tornado > 0) {
            --tornado;
        }
        if (blockhitCooldown > 0) {
            --blockhitCooldown;
        }
        if (pullCooldown > 0) {
            --pullCooldown;
        }
        if (flySmashCooldown > 0) {
            --flySmashCooldown;
        }
        if (bigsmashCooldown > 0) {
            --bigsmashCooldown;
        }
        if (bigsmash2Cooldown > 0) {
            --bigsmash2Cooldown;
        }
        if (this.isAngry()) {
            if (stunCooldown > 0) {
                //System.out.println("StunCooldown: " + stunCooldown);
                stunCooldown--;
            }
        }

        if (this.getHealth() <= 0 && !DiedOnce) {

            this.heal(this.getMaxHealth());
            if (this.isOnFire()) {
                this.clearFire();
                this.fireImmune();
            }
        }
    }

    public int GolemInvulnerabilityTime = 0;

    public boolean isAngry() {
        return this.getTextureVariant() == 1 || this.getTextureVariant() == 3;
    }


    @Override
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TEXTURE_VARIANT, 0);
        this.entityData.define(BREAK, 0);

        this.entityData.define(GAVE_CHANCE, false);
        this.entityData.define(PTICKS, 0);
        this.entityData.define(TEXTURE_VARIANT2, 0);
        this.entityData.define(TEXTURE_VARIANT1, 0);
    }

    private int blockhitCooldown = 0;
    private int electricBurstCooldown = 0;
    private int laserCooldown = 300;

    public final int BIG_SMASH_COOLDOWN = 30;
    public int bigsmashCooldown = 0;
    public int bigsmash2Cooldown = 0;

    public int flySmashCooldown = 0;

    public int cloudSwarmCooldown = 0;
    public final int CLOUD_SWARM_SUMMON_COOLDOWN = 40;
    public final int FLY_SMASH_COOLDOWN = 0;
    public final int ELECTRIC_BURST_COOLDOWN = 0;

    public final int TORNADO_SHOOT_COOLDOWN = 40;

    public final int LIGHTNING_STRIKE_COOLDOWN = 0;

    public final int BLOCK_HIT_COOLDOWN = 60;

    public boolean canLaser() {
        return laserCooldown <= 0 && this.getTarget() != null && distanceTo(this.getTarget()) >= 4f;
    }

    public boolean shouldGiveHitChance() {
        LivingEntity target = this.getTarget();
        return target != null && ModConfig.MOB_CONFIG.CloudGolemLosesConsciousness.get();
    }

    public boolean shouldChargeOnceMore() {

        return shouldDoExtraDashes && getCrackiness() == Crackiness.HIGH && ModConfig.MOB_CONFIG.CloudGolemCanCharge2Times.get();

    }

    public boolean shouldDoExtraDashes = true;

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Ancient_GuardianEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));


        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 17, 15, 30, 110, 18.0F, 4f) {
            @Override
            public boolean canUse() {
                return super.canUse() && Math.random() < 0.35f && flySmashCooldown <= 0
                        && Cloud_GolemEntity.this.getTarget() != null && Cloud_GolemEntity.this.getAttackState() != 27 && attackLock == 0 && !shouldLaserAfterTornado && !Cloud_GolemEntity.this.getTarget().isPassenger() && !canLaser();
            }

            @Override
            public void tick() {
                super.tick();
            }

            public void stop() {
                super.stop();
                flySmashCooldown = FLY_SMASH_COOLDOWN;
                Cloud_GolemEntity.this.setNoGravity(false);
                // resetSmashCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 27, 28, 20, 16, 15.0F, 4F) {
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.chargeCooldown <= 0 && attackLock == 0 && !shouldLaserAfterTornado && !canLaser()
                        && Cloud_GolemEntity.this.getTarget() != null && !Cloud_GolemEntity.this.getTarget().isPassenger()
                        ;
            }

        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 30, 27, 28, 20, 100) {
            @Override
            public void start() {
                super.start();
                shouldDoExtraDashes = false;
            }

            @Override
            public boolean canUse() {
                var target = Cloud_GolemEntity.this.getTarget();
                return super.canUse() && shouldChargeOnceMore() && target != null && Cloud_GolemEntity.this.distanceTo(target) >= 5;
            }

        });

        this.goalSelector.addGoal(1, new LaserGoal(this, 0, 14, 33, 107, 107, 15, 8f) {
            @Override
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && Cloud_GolemEntity.this.laserCooldown <= 0 && shouldGiveHitChance()
                        && Cloud_GolemEntity.this.getTarget() != null && Cloud_GolemEntity.this.isAngry() && Cloud_GolemEntity.this.getAttackState() != 13 && Cloud_GolemEntity.this.getAttackState() != 27 && attackLock == 0;
            }

            @Override
            public void tick() {
                super.tick();
            }

            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.shouldLaserAfterTornado = false;
                Cloud_GolemEntity.this.setNoGravity(false);
                // resetSmashCooldown();

                Cloud_GolemEntity.this.laserCooldown = 500;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 33, 33, 32, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new IStateGoal(this, 32, 32, 0, 73, 0) {
            @Override
            public void start() {
                super.start();

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 28, 28, 30, 25, 0) {
            public void tick() {
                if (this.entity.onGround()) {
                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * 0.017453292F;
                    Vec3 vector3d1 = (new Vec3((double) (-Mth.sin(f)), this.entity.getDeltaMovement().y, (double) Mth.cos(f))).scale(0.75).add(vector3d.scale(0.9));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }

            }
        });
        this.goalSelector.addGoal(0, new IAttackGoal(this, 28, 30, 0, 30, 45, 3.0F) {
            public void start() {

                this.entity.setDeltaMovement(0, 0, 0);
            }

            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.chargeCooldown = 220;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 30, 30, 0, 30, 40) {
            public void start() {
                super.start();
                this.entity.setDeltaMovement(0, 0, 0);
            }

            public void stop() {

                super.stop();
                Cloud_GolemEntity.this.chargeCooldown = 220;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 15, 15, 16, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new IStateGoal(this, 21, 21, 0, 50, 0) {
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 16, 16, 0, 30, 0) {
            @Override
            public void start() {
                super.start();

                ParticleUtils.controlledSmashParticles(Cloud_GolemEntity.this,0,0,0,7.5f,3);
                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
            }

            @Override
            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.bigsmash2Cooldown = 80;
            }
        });//chargePreparef
        this.goalSelector.addGoal(1, new LaserGoal(this, 0, 14, 15, 107, 107, 15, 8f) {
            @Override
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && Cloud_GolemEntity.this.laserCooldown <= 0 && !shouldGiveHitChance()
                        && Cloud_GolemEntity.this.getTarget() != null && Cloud_GolemEntity.this.isAngry() && Cloud_GolemEntity.this.getAttackState() != 13 && Cloud_GolemEntity.this.getAttackState() != 27 && attackLock == 0;
            }

            @Override
            public void tick() {
                super.tick();
            }

            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.shouldLaserAfterTornado = false;
                Cloud_GolemEntity.this.setNoGravity(false);
                // resetSmashCooldown();

                Cloud_GolemEntity.this.laserCooldown = 500;
            }
        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 15, 15, 16, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new IStateGoal(this, 16, 16, 0, 30, 0) {
            @Override
            public void start() {
                super.start();

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 26, 26, 0, 45, 20, false) {
            @Override
            public void stop() {
                super.stop();
            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 18, 0, 37, 37, 5.0F) {
            @Override
            public void start() {

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !canLaser() && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 14.0F && Cloud_GolemEntity.this.electricBurstCooldown <= 0 && Cloud_GolemEntity.this.getAttackState() != 13 && attackLock == 0 && !shouldLaserAfterTornado;
            }

            @Override
            public void stop() {
                super.stop();

                Cloud_GolemEntity.this.electricBurstCooldown = BLOCK_HIT_COOLDOWN;
            }
        });


        this.goalSelector.addGoal(1, new MultipleHitGoal(this, 0, 19, 0, 62, 12, 25, 32, 0, 5.0F) {
            @Override
            public void start() {


                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !canLaser() && Cloud_GolemEntity.this.isAngry() && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 20.0F && Cloud_GolemEntity.this.electricBurstCooldown <= 0 && Cloud_GolemEntity.this.getAttackState() != 13 && attackLock == 0 && !shouldLaserAfterTornado;
            }

            @Override
            public void stop() {
                super.stop();

                Cloud_GolemEntity.this.electricBurstCooldown = ELECTRIC_BURST_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 23, 0, 60, 60, 13.0F, 6) {
            @Override
            public void start() {
//50 old
                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !canLaser() &&
                        Cloud_GolemEntity.this.tornado <= 0 && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F &&
                        Cloud_GolemEntity.this.getTarget() != null && !Cloud_GolemEntity.this.getTarget().isPassenger() && Cloud_GolemEntity.this.getAttackState() != 13
                        && attackLock == 0 && !shouldLaserAfterTornado;
            }

            @Override
            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.tornado = TORNADO_SHOOT_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 31, 0, 100, 100, 16.0F) {
            @Override
            public void start() {

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.getAttackState() != 25 && attackLock == 0 && Cloud_GolemEntity.this.cooldownTicksThunder <= 0
                        && Cloud_GolemEntity.this.isAngry() && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && !canLaser() && !shouldLaserAfterTornado;
            }

            @Override
            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.cooldownTicksThunder = LIGHTNING_STRIKE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 20, 0, 50, 80, 18.0F, 7) {
            @Override
            public void start() {

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.getAttackState() != 25
                        && !canLaser() && !shouldLaserAfterTornado && attackLock == 0 && Cloud_GolemEntity.this.cooldownTicksThunder <= 0 && !Cloud_GolemEntity.this.isAngry();
            }

            @Override
            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.cooldownTicksThunder = LIGHTNING_STRIKE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 25, 0, 56, 56, 12, 5F) {
            @Override
            public void start() {

                Cloud_GolemEntity.this.entityData.set(PTICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && Cloud_GolemEntity.this.isAngry()
                        && !shouldLaserAfterTornado && Cloud_GolemEntity.this.getAttackState() != 27 && Cloud_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && !canLaser() && attackLock == 0 && Cloud_GolemEntity.this.cooldownStompLeft <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Cloud_GolemEntity.this.cooldownStompLeft = 30;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 9, 0, 60, 60, 7.0F) {
            @Override
            public void start() {

                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !Cloud_GolemEntity.this.isAngry() && Cloud_GolemEntity.this.getAttackState() != 13 && cloudSwarmCooldown <= 0 && attackLock == 0 && !shouldLaserAfterTornado && !canLaser();
            }

            @Override
            public void stop() {
                super.stop();
                cloudSwarmCooldown = CLOUD_SWARM_SUMMON_COOLDOWN;
            }
        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 50, 8) {
            @Override
            public boolean canUse() {
                return super.canUse();
            }
        });
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            //   itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 3.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    public boolean setInLaserMode(boolean isLaserMode) {
        return isLaserMode;
    }

    private void Sphereparticle(float height, float vec, float size) {

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

                        ParticleOptions type = ParticleTypes.FLAME;
                        if (level().isClientSide) {
                            this.level().addParticle(ParticleTypes.CLOUD, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);
                        }
                        if (i != -size && i != size && j != -size && j != size) {
                            k += size * 2 - 1;
                        }
                    }
                }
            }

        }
    }


    public boolean particle1 = false;

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 28) {
            if (attackTicks >= 0) {
                if (this.level().isClientSide) {
                    float g = (float) Math.toRadians(-getYRot() + 180);
                    double theta = (this.getYRot()) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);

                    double spawnX = this.getX() + vecX * 1.5f;
                    double spawnZ = this.getZ() + vecZ * 1.5f;
                    this.level().addParticle(new Circle.RingData(g, 0, 30, 1, 1, 1, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);
                }
            }
        }
        if (this.getAttackState() != 14 || this.getAttackState() != 17) {
            this.setNoGravity(false);
        }
        if (!this.isAngry()) {
            for (int i = 0; i < 0.5; ++i) {
                if (level().isClientSide) {
                    this.level().addParticle(ParticleTypes.CLOUD, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                }
            }
        } else {
            for (int i = 0; i < 0.5; ++i) {
                if (level().isClientSide) {
                    this.level().addParticle(ModParticles.BEAM.get(), this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                }
            }
        }
        attackParticle();
        float radius = 1F;
        float angle = (0.01745329251F * this.yBodyRot);
        double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
        double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
        //    this.level().addParticle(ModParticles.Circle.get(), this.getX()+extraX,this.getY(),this.getZ()+extraZ,0,0,0);
        if (this.entityData.get(TEXTURE_VARIANT1) == 1) {
            Sphereparticle(0.55f, 0, 1.5f);

        }
        if (this.entityData.get(TEXTURE_VARIANT2) == 1) {
            //  pullP(0.5f, 8);

        }
        if (this.horizontalCollision && this.isInWall()) {

            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }

    }

    public void attackParticle() {

        if (this.getAttackState() == 16) {
            if (this.entityData.get(PTICKS) == 2) {
                if (this.level().isClientSide) {

                    for (int i = 0; i < 360; ++i) {
                        if (i % 1 == 0) {
                            BlockState block = level().getBlockState(blockPosition().below());
                            this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK,
                                            block), this.getX() + Math.cos(i),
                                    this.getY(), this.getZ() + Math.sin(i),
                                    Math.cos(i) * 0.9, 0.0D, Math.sin(i) * 0.9);

                        }
                    }
                    for (int i = 0; i < 360; ++i) {
                        if (i % 1 == 0) {
                            BlockState block = level().getBlockState(blockPosition().below());
                            this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK,
                                            block), this.getX() + Math.cos(i),
                                    this.getY(), this.getZ() + Math.sin(i),
                                    Math.cos(i) * 1.3, 0.0D, Math.sin(i) * 1.3);

                        }
                    }
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 85, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.1f, getZ(), 0, 0, 0);
                }
            }
        }

        if (this.getAttackState() == 25) {
            if (this.entityData.get(PTICKS) == 25) {

                float radius = 0F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) - 0.5;
                double extraZ = radius * Mth.cos(angle) + 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
            if (this.entityData.get(PTICKS) == 41) {

                float radius = 0F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
        }

        if (this.getAttackState() == 23) {
            if (this.entityData.get(PTICKS) == 21) {

                float radius = 0F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
            if (this.entityData.get(PTICKS) == 37) {

                float radius = 0F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
        }
        if (this.getAttackState() == 18) {
            if (this.entityData.get(PTICKS) == 19) {

                float radius = 1.5f;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
        }

        if (this.getAttackState() == 19) {
            if (this.entityData.get(PTICKS) == 19) {

                float radius = 1.5f;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                if (level().isClientSide) {
                    ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                }
                if (this.level().isClientSide) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 20, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ() + extraZ, 0, 0, 0);
                }
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 350D/*ModConfig.COMMON.CloudGolemP1Health.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 90D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 0D);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CGA.get();
    }


    protected boolean canRide(Entity pEntity) {
        return false;
    }

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CGH.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CGD.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }

    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }

    public void launchAOE() {

        //System.out.println("Player is not on ground");
        double knockbackRadius = 5.0;
        List<Entity> nearbyEntities = this.level().getEntities(this, this.getBoundingBox().inflate(knockbackRadius), e -> e instanceof LivingEntity && e != this);
        for (Entity target : nearbyEntities) {
            double dx = target.getX() - this.getX();
            double dz = target.getZ() - this.getZ();
            double distance = Math.sqrt(dx * dx + dz * dz);
            double knockbackStrength = 0.5 + 0.25 * (knockbackRadius - distance);
            if (target.onGround()) {
                target.push(dx / distance * knockbackStrength, 0.3, dz / distance * knockbackStrength);
            } else {
                double knockbackStrength2 = 1.0 + 0.5 * (knockbackRadius - distance);
                target.push(dx / distance * knockbackStrength2, 0.4, dz / distance * knockbackStrength2);
            }
        }

    }

    public int attackLock = 0;
    private boolean DiedOnce = false;

    @Override
    public void die(DamageSource source) {
        this.setAttackState(8);
        super.die(source);
    }


    @Override
    public void onAddedToWorld() {
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.CloudGolemHealthMultiplier.get());
        bossInfo.setVisible(false);
        super.onAddedToWorld();
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("DiedOnce", this.DiedOnce);
        compound.putInt("TextureVariant", this.getTextureVariant());
        compound.putBoolean("gaveChance", this.entityData.get(GAVE_CHANCE));
        compound.putBoolean("is_Sleep", isSleep());
        compound.putInt("break", this.entityData.get(BREAK));
        compound.putInt("StunCooldown", this.stunCooldown);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public boolean canBreak() {
        return (this.getAttackState() == 18 || this.getAttackState() == 19);
    }

    private int ArrowDamageCooldown = 0;
   public boolean isTargetCheesingBoss(){
        return isTargetCheesing(-4,4) &&getAttackState() != 15&&getAttackState() != 16 &&getAttackState() != 17;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (GolemInvulnerabilityTime > 0 && ModConfig.MOB_CONFIG.CloudGolemInvulnerabilityTime.get()) {
            return false;
        }
        if (source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.LAVA) || source.is(DamageTypes.FALL) || source.is(DamageTypes.LIGHTNING_BOLT) || isTargetCheesingBoss()) {
            return false;
        }
        
        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if (getAttackState() == 0) {
                // this.setAttackState(26);
            }
        }
        if (this.entityData.get(BREAK) == 3) {
            this.entityData.set(BREAK, this.entityData.get(BREAK) + 1);
            this.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, 2, 1);
        }
        if (source.getEntity() instanceof Player player) {
            ItemStack itemStack = player.getMainHandItem();
            if (itemStack.getItem() instanceof AxeItem && player.getAttackStrengthScale(0.5f) >= 1 && canBreak()) {
                this.entityData.set(BREAK, this.entityData.get(BREAK) + 1);
                if (!this.isBroken()) {
                    float radius = 1F;
                    float angle = (0.01745329251F * this.yBodyRot);
                    double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                    double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                    ParticleBlock(1, this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                    this.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, 2, 1);
                }
            }

        }
        if (!isBroken() && canBreak()) {
            if (tickCount % 5 == 0) {

            }
        }
        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;
        if (source.getDirectEntity() instanceof AbstractArrow && isAngry()) {
            if (ArrowDamageCooldown > 0) {
                return false;
            } else {
                ArrowDamageCooldown = 30;
            }
        }

        if (source.is(DamageTypes.EXPLOSION))
            return false;
        if (source.is(DamageTypes.LIGHTNING_BOLT))
            return false;

        if (source.is(DamageTypes.PLAYER_EXPLOSION))
            return false;
        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && !source.is(DamageTypeTags.BYPASSES_ARMOR) && canBreak() && !isBroken() && amount > 5) {
            amount = 4;
        }
        if ((this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || getAttackState() == 21)) {
            return false;
        }

        boolean hurt1  = super.hurt(source, amount);
        if (hurt1){
            GolemInvulnerabilityTime = 10;
        }
        return hurt1;
    }

    @Override
    public boolean damageReductionSystem() {
        return true;
    }

    @Override
    public boolean damageAdaptationSystem() {
        return false;
    }

    public double damageCap() {
        return ModConfig.MOB_CONFIG.CloudGolemDamageCap.get();
    }


    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || super.isInvulnerableTo(source);
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();


    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(BREAK, compound.getInt("break"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
        setSleep(compound.getBoolean("is_Sleep"));
        this.stunCooldown = compound.getInt("StunCooldown");

        this.entityData.set(GAVE_CHANCE, compound.getBoolean("gaveChance"));
        this.DiedOnce = compound.getBoolean("DiedOnce");
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));


    }

    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 40;

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.level() instanceof ServerLevel) {


            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);
            }
        }

        if (this.dragonDeathTime == 40 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {

        pStack.addTagElement("Enchantments", new ListTag());


        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);


        if (itemEntity != null) {
            itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }

    public AnimationState BlockHitStunAState = new AnimationState();
    public AnimationState PreFractureFallAnimationState = new AnimationState();
    public AnimationState FractureLandAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState lightningSummonAnimationState = new AnimationState();
    public AnimationState p2AState = new AnimationState();
    public AnimationState landAnimationState = new AnimationState();
    public AnimationState fallAnimationState = new AnimationState();
    public AnimationState runAnimationState = new AnimationState();
    public AnimationState runpreAnimationState = new AnimationState();
    public AnimationState postRunAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargepreAnimationState = new AnimationState();
    public AnimationState chargeEndAnimationState = new AnimationState();

    public AnimationState chargeAggresiveEndAnimationState = new AnimationState();
    public AnimationState ExplodeAnimationState = new AnimationState();
    public AnimationState cloudSummonAnimationState = new AnimationState();

    public AnimationState mhitAnimationState = new AnimationState();
    public AnimationState flipAnimationState = new AnimationState();
    public AnimationState cloudSummonBigAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState bhdbAnimationState = new AnimationState();
    public AnimationState bhAnimationState = new AnimationState();
    public AnimationState laserAnimationState = new AnimationState();

    public AnimationState laser2AnimationState = new AnimationState();

    public AnimationState stompLeftAState = new AnimationState();
    public AnimationState stompAState = new AnimationState();
    public AnimationState respawnAState = new AnimationState();

    public AnimationState flyAState = new AnimationState();

    public AnimationState blockAState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "attackarmright") {
            return this.attackarm1AnimationState;
        } else if (input == "attackarmleft") {
            return this.attackarm2AnimationState;
        } else if (input == "attackarms") {
            return this.attackarmsAnimationState;
        } else if (input == "attacklightning") {
            return this.lightningSummonAnimationState;
        } else if (input == "cloudattack") {
            return this.cloudSummonAnimationState;
        } else if (input == "cloudattackbig") {
            return this.cloudSummonBigAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "explode") {
            return this.ExplodeAnimationState;
        } else if (input == "resp") {
            return this.respawnAState;
        } else if (input == "flip") {
            return this.flipAnimationState;
        } else if (input == "p2") {
            return this.p2AState;
        } else if (input == "fly") {
            return this.flyAState;
        } else if (input == "laser") {
            return this.laserAnimationState;
        } else if (input == "laser2") {
            return this.laser2AnimationState;
        } else if (input == "blockhitdb") {
            return this.bhdbAnimationState;
        } else if (input == "blockhit") {
            return this.bhAnimationState;
        } else if (input == "land") {
            return this.landAnimationState;
        } else if (input == "fall") {
            return this.fallAnimationState;
        } else if (input == "pull") {
            return this.runAnimationState;
        } else if (input == "pullpre") {
            return this.runpreAnimationState;
        } else if (input == "postpull") {
            return this.postRunAnimationState;
        } else if (input == "stompleft") {
            return this.stompLeftAState;
        } else if (input == "stomp") {
            return this.stompAState;
        } else if (input == "block") {
            return this.blockAState;
        } else if (input == "precharge") {
            return this.chargepreAnimationState;
        } else if (input == "charge") {
            return this.chargeAnimationState;
        } else if (input == "endcharge") {
            return this.chargeEndAnimationState;
        } else if (input == "aendcharge") {
            return this.chargeAggresiveEndAnimationState;
        } else if (input == "mhit") {
            return this.mhitAnimationState;
        } else if (input == "fractureland") {
            return this.FractureLandAnimationState;
        } else if (input == "prefracturefall") {
            return this.PreFractureFallAnimationState;
        } else if (input == "blockhitstun") {
            return this.BlockHitStunAState;
        } else {
            return new AnimationState();
        }

    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        bossInfo.setVisible(false);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void setSleep(boolean sleep) {

        bossInfo.setVisible(false);
        this.setAttackState(sleep ? 1 : 0);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {

                    case 0 -> {
                        if (this.getAttackState() != 13) {
                            if (attackTicks == 90) {
                                this.stopAllAnimationStates();
                            }
                        }
                    }

                    case 1 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.sleepAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 2 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.awakeAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 3 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.attackarm1AnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 4 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.attackarm2AnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 5 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.lightningSummonAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 6 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.attackarmsAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 7 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.cloudSummonAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 8 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.deathAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 9 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.ExplodeAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 12 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.postRunAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 11 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.runAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.runpreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.respawnAState.startIfStopped(this.tickCount);
                        attackTicks = 0;
                    }
                    case 14 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.laserAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 15 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.fallAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 16 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.landAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 17 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.flyAState.startIfStopped(this.tickCount);
                        }
                    }

                    case 18 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.bhAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 19 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.bhdbAnimationState.startIfStopped(this.tickCount);
                        }
                    }

                    case 20 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.cloudSummonBigAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 21 -> {

                        this.stopAllAnimationStates();
                        this.p2AState.startIfStopped(this.tickCount);

                    }
                    case 22 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.laser2AnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 23 -> {

                        if (this.getAttackState() != 13) {

                            this.entityData.set(PTICKS, 0);
                            this.stopAllAnimationStates();
                            this.stompAState.startIfStopped(this.tickCount);
                        }
                    }
                    case 24 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.flipAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 25 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.stompLeftAState.startIfStopped(this.tickCount);
                        }
                    }
                    case 26 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.blockAState.startIfStopped(this.tickCount);
                        }
                    }
                    case 27 -> {

                        if (this.getAttackState() != 13) {

                            this.entityData.set(PTICKS, 0);
                            this.stopAllAnimationStates();
                            this.chargepreAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 28 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.chargeAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 29 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.chargeEndAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 30 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.chargeAggresiveEndAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 31 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.mhitAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 32 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.FractureLandAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 33 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.PreFractureFallAnimationState.startIfStopped(this.tickCount);
                        }
                    }
                    case 34 -> {

                        if (this.getAttackState() != 13) {

                            this.stopAllAnimationStates();
                            this.BlockHitStunAState.startIfStopped(this.tickCount);
                        }
                    }

                }

        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.BlockHitStunAState.stop();
        this.sleepAnimationState.stop();
        this.PreFractureFallAnimationState.stop();
        this.FractureLandAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.lightningSummonAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.mhitAnimationState.stop();
        this.chargepreAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargeEndAnimationState.stop();
        this.chargeAggresiveEndAnimationState.stop();
        this.blockAState.stop();
        this.deathAnimationState.stop();
        this.stompLeftAState.stop();
        this.flipAnimationState.stop();
        this.respawnAState.stop();
        this.laserAnimationState.stop();
        this.flyAState.stop();
        this.stompAState.stop();
        this.laser2AnimationState.stop();
        this.p2AState.stop();
        this.cloudSummonBigAnimationState.stop();
        this.bhAnimationState.stop();
        this.bhdbAnimationState.stop();
        this.fallAnimationState.stop();
        this.landAnimationState.stop();
        this.postRunAnimationState.stop();
        this.runAnimationState.stop();
        this.runpreAnimationState.stop();
        this.ExplodeAnimationState.stop();
        this.cloudSummonAnimationState.stop();

    }


    private void launchMini(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? 1.2F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.3 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, float knockback, boolean BNknockback, float Lstrenght, boolean launch) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Cloud_GolemEntity) && !(entityHit instanceof MossyGolemEntity) && entityHit != this) {


                    boolean hurt = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.CloudGolemDamageMutliplier.get())));

                    if (hurt) EntityUtil.cancelBuffs(entityHit);

                    if (this.getAttackState() == 4 || this.getAttackState() == 3) {
                        if (this.attackTicks == 20) {
                            if (BNknockback && !entityHit.isBlocking()) {
                                double knockbackRadius = 5.0;

                                double dx = entityHit.getX() - this.getX();
                                double dz = entityHit.getZ() - this.getZ();
                                double distance = Math.sqrt(dx * dx + dz * dz);
                                double knockbackStrength = knockback + 0.5 * (knockbackRadius - distance);
                                entityHit.push(dx / distance * knockbackStrength, 0.4, dz / distance * knockbackStrength);
                            }

                            Vec3 entityPosition = this.position();
                            CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                        }
                    }
                    if (this.getAttackState() == 4) {
                        this.launchMini(entityHit, true);
                    }

                    if (this.getAttackState() == 30) {
                        if (hurt) {
                            playSound(SoundEvents.ANVIL_PLACE, 2, 1);
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 55, 0));
                        }
                    }
                    if (this.getAttackState() == 9) {
                        this.launchAOE();
                    }

                    if (this.getAttackState() == 16) {
                        this.launchAOE();
                    }

                    if (this.getAttackState() == 21) {
                        this.launchAOE();
                    }
                    if (this.getAttackState() == 12) {
                        this.launchAOE();
                    }
                    if (this.getAttackState() == 3) {
                        this.launchMini(entityHit, true);
                    }
                    if (this.getAttackState() == 6) {
                        this.launch(entityHit, true);
                    }
                    if (this.getAttackState() == 31) {
                        this.launch(entityHit, true);
                    }
                    if (this.getAttackState() == 18) {
                        this.launch(entityHit, true);
                    }

                    if (this.getAttackState() == 19) {

                        this.launch(entityHit, true);
                    }

                    //entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));

                    //entityHit.knockback(knockback,1,1);

                    if (!entityHit.isBlocking()) {
                        // entityHit.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2), this);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    public int DamageCap = 6;

    private void spawnLightningBolts() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * 1.1F;
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * 1.1F;

            for (int l = 0; l < 10; ++l) {
                double d2 = 1.25D * (double) (l + 1);
                double lightningX1 = this.getX() + f2 + (double) Mth.cos(f) * d2;
                double lightningZ1 = this.getZ() + f3 + (double) Mth.sin(f) * d2;
                double lightningX2 = this.getX() - f2 + (double) Mth.cos(f) * d2;
                double lightningZ2 = this.getZ() - f3 + (double) Mth.sin(f) * d2;

                strikeLightning(lightningX1, lightningZ1);
                strikeLightning(lightningX2, lightningZ2);
            }
        }
    }

    private void strikeLightning(double x, double z) {
        if (this.level() instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) this.level();
            BlockPos blockpos = new BlockPos((int) x, (int) this.getY(), (int) z);
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);

            if (lightningBolt != null) {
                lightningBolt.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(), this.getYRot(), 0.0F);
                serverLevel.addFreshEntity(lightningBolt);
            }
        }
    }

    private void spawnLowIceSpikes() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            for (int k = 0; k < 8; ++k) {
                this.createSpellEntity(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 10);
            }
            for (int k = 0; k < 8; ++k) {
                this.createSpellEntity(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 5);
            }


        }
    }

    private void createSpellEntity(double pX, double pZ, double pMinY, double pMaxY, float pYRot, int pWarmupDelay) {
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
            EntityType<CloudEntity> entityType = ModEntities.C.get();
            CloudEntity newEntity = entityType.create(this.level());
            if (newEntity != null) {
                newEntity.setPos(pX, blockpos.getY() + d0 + 3, pZ);
                newEntity.setOwner(this);
                this.level().addFreshEntity(newEntity);
            }
        }

    }

    private void spawnThunder(double x, double z, double minY, double maxY, float rotation, int delay) {

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
            this.level().addFreshEntity(new LightningBoltEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, 20, 7));
        }
    }

    public void ParticleBlock(int precent, double x, double y, double z) {
        for (int i = 0; i < 360; ++i) {
            if (i % precent == 0) {
                BlockState block = level().getBlockState(blockPosition().below());
                if (level().isClientSide) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), x + Math.cos(i), y, z + Math.sin(i), Math.cos(i) * 0.25, 0.0D, Math.sin(i) * 0.25);
                }
            }
        }
    }

    public void Particle(int precent, double x, double y, double z) {
        for (int i = 0; i < 360; ++i) {
            if (i % precent == 0) {
                if (level().isClientSide) {
                    this.level().addParticle(ParticleTypes.CLOUD, x, y, z, Math.cos(i) * 0.25, 0.0D, Math.sin(i) * 0.25);
                }
            }
        }
    }

    private float lastPitch;
    private float lastYaw;

    private void dash(float a1, float a2, float minD) {
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if (this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
        }
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    private void electricSpawn(float spreadarc, int distance, float vec, int delay) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnElectric(hitX + 0.5D, hitZ + 0.5D, this.getY(), this.getY() + 3, (float) theta, delay);

        }
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.CLOUD_GOLEM_MUSIC_STEREO.get();
    }

    @Override
    public boolean canPlayMusic() {
        return super.canPlayMusic() && !this.isSleep();
    }

    private void spawnElectric(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
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
            //   this.level().addFreshEntity(new ElectricityEntity(this.level(), x, (double)blockpos.getY() + d0, z,0,this));
        }
    }

    private void spawnDoubleThunder() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (1.5F);
            float f4 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (-0.5F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.5F);
            float f5 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (-1.1F);
            for (int l = 0; l < 16; ++l) {
                double d2 = 1.25D * (double) (l + 1);
                double d3 = -1.25D * (double) (l + 1);
                int j = (int) (1.25f * l);
                this.spawnThunder(this.getX() + f2 + (double) Mth.cos(f) * d2, this.getZ() + f3 + (double) Mth.sin(f) * d2, d0, d1, f, j);
                this.spawnThunder(this.getX() - f2 + (double) Mth.cos(f) * d2, this.getZ() - f3 + (double) Mth.sin(f) * d2, d0, d1, f, j);

            }


        }

    }

    public boolean shouldLaserAfterTornado = false;

    public boolean getShouldLaserAfterTornado() {
        return shouldLaserAfterTornado;
    }

    public void updateWithAttack() {

        if (this.getAttackState() == 33) {

            if (this.onGround()) {
                this.setAttackState(32);
            } else {
                Particle(30, this.getX(), this.getY(), this.getZ());
            }
        }
        if (this.getAttackState() == 32) {

            this.setPos(this.getX(), Mth.floor(this.getY()), this.getZ());
            if (attackTicks == 1) {
                playSound(ModSounds.CGD.get(), 1, 1);
                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
                LivingEntity t = this.getTarget();
                int standingOnY = Mth.floor(this.getY());
                // this.spawnIceSpikesAdvanced(this.getX(), this.getZ(), standingOnY, this.getY(), 0, 0);

                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(4F, 4F, 130F, 16.0F + a, 0, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(4F, 4F, 130F, 16.0F, 0, false, 0.5F, false, 0.25F, true);
                }
            }
        }
        if (this.getAttackState() == 31) {
            if (attackTicks == 20) {
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(4F, 4F, 130F, 16.0F + a, 0, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(4F, 4F, 130F, 16.0F, 0, false, 0.5F, false, 0.25F, true);
                }

                ParticleUtils.controlledSmashParticles(this, 1.5f, 0, 0, 1.5f, 1);
                playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 10, 1);
                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
                LivingEntity livingentity = this.getTarget();
                if (livingentity != null) {
                    double d0 = Math.min(livingentity.getY(), this.getY());
                    double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
                    float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(), livingentity.getX() - this.getX());
                    double yawRad = Math.toRadians(this.yBodyRot + 15);
                    double pitchRad = Math.toRadians(this.yBodyRot + 15);

                    double distance = 2.0;
                    double newX = this.getX() + distance * Math.cos(yawRad);
                    double newY = this.getY() + distance * Math.sin(pitchRad);
                    double newZ = this.getZ() + distance * Math.sin(yawRad);
                    float f1 = (float) Mth.atan2(newZ - this.getZ(), newX - this.getX());
                    for (int l = 0; l < 16; ++l) {
                        double d2 = 1.25D * (double) (l + 1);
                        int j = 1 * l;

                        this.spawnThunder(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);


                    }

                }
                //      executeThunderClouds(0);
            }
            if (attackTicks == 37) {

                ParticleUtils.controlledSmashParticles(this, 1.5f, 0, 0, 1.5f, 1);
                playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 10, 1);
                float yawRadians = (float) (Math.toRadians(60 + this.getYRot()));
                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
                LivingEntity livingentity = this.getTarget();
                LivingEntity t = this.getTarget();

                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(4F, 4F, 130F, 16.0F + a, 0, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(4F, 4F, 130F, 16.0F, 0, false, 0.5F, false, 0.25F, true);
                }
                if (livingentity != null) {
                    double d0 = Math.min(livingentity.getY(), this.getY());
                    double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
                    float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(), livingentity.getX() - this.getX());
                    double yawRad = Math.toRadians(this.yBodyRot + 15);
                    double pitchRad = Math.toRadians(this.yBodyRot + 15);

                    double distance = 2.0;
                    double newX = this.getX() + distance * Math.cos(yawRad);
                    double newY = this.getY() + distance * Math.sin(pitchRad);
                    double newZ = this.getZ() + distance * Math.sin(yawRad);
                    float f1 = (float) Mth.atan2(newZ - this.getZ(), newX - this.getX());
                    for (int l = 0; l < 16; ++l) {
                        double d2 = 1.25D * (double) (l + 1);
                        int j = 1 * l;
                        float[] f2 = {f - 0.3f, f, f + 0.3f};

                        for (float angle : f2) {

                            this.spawnThunder(this.getX() + (double) Mth.cos(angle) * d2, this.getZ() + (double) Mth.sin(angle) * d2, d0, d1, angle, j);


                        }
                    }

                }

            }
            if (attackTicks == 68) {

                ParticleUtils.controlledSmashParticles(this, 2f, 0, 0, 1.5f, 1);
                playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 10, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(5F, 4F, 130F, 18.0F + a, 0, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5F, 4F, 130F, 18.0F, 0, false, 0.5F, false, 0.25F, true);
                }
                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
                LivingEntity livingentity = this.getTarget();

                if (livingentity != null) {
                    double d0 = Math.min(livingentity.getY(), this.getY());
                    double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
                    float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(), livingentity.getX() - this.getX());
                    double yawRad = Math.toRadians(this.yBodyRot + 15);
                    double pitchRad = Math.toRadians(this.yBodyRot + 15);

                    double distance = 2.0;

                    double newX = this.getX() + distance * Math.cos(yawRad);
                    double newY = this.getY() + distance * Math.sin(pitchRad);
                    double newZ = this.getZ() + distance * Math.sin(yawRad);
                    float f1 = (float) Mth.atan2(newZ - this.getZ(), newX - this.getX());
                    for (int l = 0; l < 16; ++l) {
                        double d2 = 1.25D * (double) (l + 1);
                        int j = 1 * l;
                        // this.spawnThunder(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);
                    }
                    switch (random.nextInt(3)) {

                        case 0 -> {


                            spawnDoubleThunder();
                        }

                        case 1 -> {

                            for (int l = 0; l < 16; ++l) {

                                double d2 = 1.25D * (double) (l + 1);
                                int j = 1 * l;
                                this.spawnThunder(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);

                            }

                            break;
                        }
                        case 2 -> {

                            for (int l = 0; l < 16; ++l) {

                                double d2 = 1.25D * (double) (l + 1);
                                int j = 1 * l;
                                float[] f2 = {f - 0.2025f, f, f + 0.2025f};

                                for (float angle : f2) {

                                    this.spawnThunder(this.getX() + (double) Mth.cos(angle) * d2, this.getZ() + (double) Mth.sin(angle) * d2, d0, d1, angle, j);


                                }

                            }
                        }


                    }
                }

            }
        }

        float power = 20.0F;
        if (this.getAttackState() == 28) {
            Vec3 vector3d = this.getDeltaMovement();
            float f = this.getYRot() * 0.017453292F;
            Vec3 vector3d1 = (new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f))).scale(0.45).add(vector3d.scale(0.6));
            this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);

            if (this.horizontalCollision) {
                this.setAttackState(30);
            }
        }

        if (this.getAttackState() == 30) {
            if (this.attackTicks == 29) {
                if (this.getTarget() != null) {
                    if (distanceTo(this.getTarget()) >= 7 && Math.random() > 0.5f) {
                        //    setAttackState(27);
                    }
                }
            }
            if (attackTicks == 3) {
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));
                    playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 3, 0.25f);
                    this.AreaAttack(5F, 4F, 230F, 22.0F + a, 70, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5F, 4F, 230F, 22.0F, 70, false, 0.5F, false, 0.25F, true);
                }
            }
        }
        if (this.getAttackState() == 25) {
            if (attackTicks == 41) {

                ParticleUtils.controlledSmashParticles(this, 2f, 0, 0, 0.5f, 1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3.0F, 1.0F);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 9;
                float angleStep = 20.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    if (this.getTarget() != null) {

                        float y = Mth.floor(this.getY());
                        float m = (float) (this.getTarget().getMaxHealth() * 0.01);
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 7f, angle, 45);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = y;
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    } else {

                        float y = Mth.floor(this.getY());
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 7, angle, 45);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = y;
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    }
                }
            }
            if (attackTicks == 25) {

                ParticleUtils.controlledSmashParticles(this, 2f, 0, 0, 0.5f, 1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3.0F, 1.0F);
                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 7;
                float angleStep = 30.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    if (this.getTarget() != null) {
                        float m = (float) (this.getTarget().getMaxHealth() * 0.05);
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 7, angle, 45);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = this.getY(0.15D);
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    } else {
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 7, angle, 45);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = this.getY(0.15D);
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    }
                }

            }
        }
        if (this.getAttackState() == 24) {

            if (attackTicks == 15) {
                float radius2 = 2F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                //  spawnBolt((float) ((float) this.getX() + extraX), (float) this.getY(), (float) ((float) this.getZ() + extraZ));
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 3, 1);

                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(5F, 4F, 90F, 16.0F + a, 40, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5F, 4F, 90F, 16.0F, 40, false, 0.5F, false, 0.25F, true);
                }
            }
            if (attackTicks == 17) {
                dash(2, 1.6f, 0f);
            }
            if (attackTicks == 25) {
                float radius2 = 2F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);

                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 3, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.04));

                    this.AreaAttack(5F, 4F, 90F, 18.0F + a, 40, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5F, 4F, 90F, 18.0F, 40, false, 0.5F, false, 0.25F, true);
                }
            }
        }

        if (this.getAttackState() == 23) {
            if (this.entityData.get(PTICKS) == 23) {

                float radius = 1F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) + 0.5;
                double extraZ = radius * Mth.cos(angle) - 0.5 * Mth.sin(angle);
                ParticleBlock(1, this.getX() + extraX, this.getY(), this.getZ() + extraZ);
            }

            if (attackTicks == 23) {//15

                LivingEntity target = this.getTarget();
                if (target != null) {
                    double d0 = target.getX() - this.getX();
                    double d2 = target.getZ() - this.getZ();
                    double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                    double theta = (yBodyRot) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int numberOfSkulls = 1;
                    int numberOfSkulls2 = 3;
                    float angleStep = 30.0f;

                    float angleStep2 = 40.0f;
                    for (int i = 0; i < numberOfSkulls; i++) {
                        float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                        float rad = (float) Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        if (this.getTarget() != null) {
                            float m = (float) (this.getTarget().getMaxHealth() * 0.05);
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        } else {
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        }
                    }

                    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3, 1);
                }
            }
            if (attackTicks == 48) {
                switch (random.nextInt(2)) {
                    case 0 -> {
                        shouldLaserAfterTornado = false;
                    }
                    case 1 -> {
                        if (this.isAngry()) {
                            LivingEntity target = this.getTarget();
                            if (target != null) {
                                if (target.isPassenger() && target.getVehicle() instanceof Tornado && laserCooldown <= 0) {

                                    shouldLaserAfterTornado = true;
                                } else {
                                    shouldLaserAfterTornado = false;
                                }
                            }
                        }
                    }
                }
            }
            if (attackTicks == 38) {//31
                LivingEntity target = this.getTarget();
                if (target != null) {
                    double theta = (yBodyRot) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int numberOfSkulls = 1;
                    float angleStep = 30.0f;
                    for (int i = 0; i < numberOfSkulls; i++) {
                        float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                        float rad = (float) Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        if (this.getTarget() != null) {
                            float m = (float) (this.getTarget().getMaxHealth() * 0.05);
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        } else {
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        }
                    }

                    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3, 1);
                }
            }
        }
        float radius = power * 1.5F;
        if (this.getAttackState() == 18) {
            if (this.attackTicks == 19) {
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

                ParticleUtils.controlledSmashParticles(this, 2f, 0, 0, 1.5f, 1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(5.6F, 4F, 130F, 19.5F + a, 50, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5.6F, 4F, 130F, 19.5F, 50, false, 0.5F, false, 0.25F, true);
                }
            }


        }
        if (this.getAttackState() == 21) {

            if (attackTicks == 25) {
                LivingEntity target = this.getTarget();
                if (target != null) {
                    double theta = (yBodyRot) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int numberOfSkulls = 4;
                    float angleStep = 90.0f;
                    for (int i = 0; i < numberOfSkulls; i++) {
                        float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                        float rad = (float) Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        if (this.getTarget() != null) {
                            float m = (float) (this.getTarget().getMaxHealth() * 0.05);
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        } else {
                            Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 7, angle, 120);
                            double spawnX = this.getX() + vecX * 1;
                            double spawnY = this.getY(0.15D);
                            double spawnZ = this.getZ() + vecZ * 1;
                            witherskull.setPos(spawnX, spawnY, spawnZ);
                            this.level().addFreshEntity(witherskull);
                        }
                    }
                }
                summonBolt(1, 0, 0);
                this.entityData.set(TEXTURE_VARIANT, 1);
                this.playSound(SoundEvents.TRIDENT_THUNDER, 3, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.06));

                    this.AreaAttack(6F, 4F, 180F, 14.0F + a, 60, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6F, 4F, 180F, 14F, 60, false, 0.5F, false, 0.25F, true);
                }
                attackLock = 0;
            }
        }
        if (this.getAttackState() == 20) {

            float angleValue = 0.1f;
            if (this.attackTicks == 25) {
                float radius2 = 2.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 4);
            }

            if (this.attackTicks == 26) {
                float radius2 = 3F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 6);
            }

            if (this.attackTicks == 27) {
                float radius2 = 5.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 8);
            }

            if (this.attackTicks == 28) {
                float radius2 = 7F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 10);
            }

            if (this.attackTicks == 29) {
                float radius2 = 9.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 12);
            }

            if (this.attackTicks == 30) {
                float radius2 = 11F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 14);
            }

            if (this.attackTicks == 31) {
                float radius2 = 12.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 16);
            }

            if (this.attackTicks == 32) {
                float radius2 = 15F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 18);
            }
            if (this.attackTicks == 33) {
                float radius2 = 16.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 20);
            }
            if (this.attackTicks == 34) {
                float radius2 = 18F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 22);
            }
            if (this.attackTicks == 35) {
                float radius2 = 19.5F;
                float angle = (angleValue * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                summonControlledCloud((float) (this.getX()), (float) this.getY(), (float) (this.getZ()), 24);

            }


        }

        if (this.getAttackState() == 19) {
            if (this.attackTicks == 19) {
                Vec3 entityPosition = this.position();
                ParticleUtils.controlledSmashParticles(this, 2f, 0, 0, 1.5f, 1);
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                float radius2 = 1F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius2 * Mth.sin((float) (Math.PI + angle));
                double extraZ = radius2 * Mth.cos(angle) * Mth.sin(angle);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.03));

                    this.AreaAttack(5.6F, 3F, 180F, 18.0F + a, 0, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5.6F, 3F, 180F, 18.0F, 0, false, 0.5F, false, 0.25F, true);
                }
            }

            if (this.attackTicks == 35) {
                dash(1.3f, 0.9f, 4);
            }
            for (int l = 38; l <= 48; l = l + 3) {
                if (this.attackTicks == l) {
                    int d = l - 38;
                    // electricSpawn(0.9f, d, 0.5f,10);
                }
            }

            if (attackTicks == 38) {
                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 5;
                float angleStep = 26.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    if (this.getTarget() != null) {
                        float y = Mth.floor(this.getY());
                        float m = (float) (this.getTarget().getMaxHealth() * 0.01);
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 6, angle, 35);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = y;
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    } else {

                        float y = Mth.floor(this.getY());
                        ElectricityEntity witherskull = new ElectricityEntity(this, dx, 0, dz, this.level(), (float) 6, angle, 35);
                        double spawnX = this.getX() + vecX * 0;
                        double spawnY = y;
                        double spawnZ = this.getZ() + vecZ * 0;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    }
                }


            }
            if (this.attackTicks == 40) {
                float angleValue = 0.1f;
                float angle = (angleValue * this.yBodyRot);
                double extraX = 1 * Mth.sin((float) (Math.PI + angle));

                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                LivingEntity t = this.getTarget();
                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.05));

                    this.AreaAttack(5F, 4F, 180F, 19F + a, 60, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(5F, 4F, 180F, 19F, 60, false, 0.5F, false, 0.25F, true);
                }
            }

        }
        if (this.getAttackState() == 17) {
            if (attackTicks == 30) {
                LivingEntity target = this.getTarget();
                this.setNoGravity(false);
                if (target != null) {
                    double distanceToTarget =
                            this.distanceTo(target);
                    float k = (float) (distanceToTarget * 0.02);
                    if (distanceToTarget < 12) {
                        if (target instanceof Player) {
                            this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                            Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                            this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 1.5D, -0.6 + k, vec3.z * 1.5D));
                        } else {

                            this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                            Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                            this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 2D, vec3.y - (0.2 + k), vec3.z * 2D));

                        }
                    } else {
                        if (target instanceof Player) {
                            this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                            Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                            this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 2D, -0.6 + k, vec3.z * 2D));
                        } else {
                            this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                            Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                            this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 2D, vec3.y - (0.2 + k), vec3.z * 2D));
                        }
                    }
                }
            } else {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.0D, 0.0F));
            }

            if (attackTicks == 11) {

                this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.6D, 0.0F));

            }


            if (attackTicks > 11 && attackTicks < 30) {
                this.yHeadRot = this.yBodyRot;
                this.setNoGravity(true);
//this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }
        }
        if (this.getAttackState() == 15) {
            if (this.onGround()) {
                ParticleUtils.controlledSmashParticles(this,0,0,0,7.5f,3);
                this.setAttackState(16);
            } else {
                Particle(30, this.getX(), this.getY(), this.getZ());
            }
        }
        if (this.getAttackState() == 14) {
            if (attackTicks == 1) {
                setInLaserMode(false);
                spawnBolt((float) this.getX(), (float) this.getY(), (float) this.getZ());
            }
            if (attackTicks == 11) {

                this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.6D, 0.0F));

            }

            if (attackTicks == 20) {
                this.playSound(ModSounds.BEAM_CHARGE.get(), 5, 1);
            }

            if (attackTicks > 11 && attackTicks < 104) {

                this.setNoGravity(true);
//this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }
            if (attackTicks == 39) {
                setInLaserMode(true);
                this.setDeltaMovement(0, 0, 0);
                this.playSound(ModSounds.BEAM_GO.get(), 5, 1);

            }
            if (attackTicks == 19) {
                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                double spawnX = this.getX() + vecX * 1;
                double spawnY = this.getY(0D);
                double spawnZ = this.getZ() + vecZ * 1;
                LivingEntity entity = this;
                EnergyBeamEntity energyBeamEntity = new EnergyBeamEntity(ModEntities.ENERGY_BEAM.get(), entity.level(), entity, spawnX,
                        spawnY + 1, spawnZ, (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 75, 5, 5);
                entity.level().addFreshEntity(energyBeamEntity);

            }
            if (attackTicks == 105) {
                setInLaserMode(false);
                LivingEntity target = this.getTarget();
                this.setNoGravity(false);
                if (target != null) {
                    double distanceToTarget =
                            this.distanceToSqr(target.getX(), target.getY(), target.getZ());

                    this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                    Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                    this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 2D, -0.5, vec3.z * 2D));
                }
            } else {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.0D, 0.0F));
            }
        }
        if (this.getAttackState() == 13) {
            if (attackTicks == 1) {
                this.setInvulnerable(true);
            }
            if (attackTicks == 40) {


                attackLock = 0;

                summonBolt(1, 0, 0);
                this.entityData.set(TEXTURE_VARIANT, 1);
            }
        }
        if (this.getAttackState() == 16) {
            if (this.attackTicks == 3) {
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 3, 1);
                LivingEntity t = this.getTarget();


                if (t != null) {
                    int a = (int) ((t.getMaxHealth() * 0.08));

                    this.AreaAttack(6.5F, 5F, 360F, 25.0F + a, 140, false, 0.5F, false, 0.25F, true);
                } else {
                    this.AreaAttack(6.5F, 5F, 360F, 25.0F, 140, false, 0.5F, false, 0.25F, true);
                }


            }
        }
        if (this.getAttackState() == 11) {

            this.AreaAttack(5.0F, 4.0F, 360.0F, 5.0F, 0, false, 0.5F, false, 0.25F, false);
            this.entityData.set(TEXTURE_VARIANT2, 1);
        }

        int damageCloud = 8;
        float cloudDamageRange = 2f;
        if (this.getAttackState() == 9) {
            if (this.attackTicks == 24) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        EntityType<CloudEntity> entityType = ModEntities.C.get();
                        CloudEntity newEntity = entityType.create(this.level());
                        if (newEntity != null) {
                            newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 2.5D);
                            this.level().addFreshEntity(newEntity);
                            newEntity.setOwner(this);
                            newEntity.setParticleOptimalization(true);
                            newEntity.setDamage(7);
                            newEntity.setAttackRange(cloudDamageRange);
                        }

                    }
                }

                this.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 3, 0.769f);
                particle1 = true;

                this.entityData.set(TEXTURE_VARIANT1, 1);

            }
            if (attackTicks == 25) {
                for (int k = 0; k < 9; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 9.0F + ((float) Math.PI * 2F / 10F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 3.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 3.5D);
                        this.level().addFreshEntity(newEntity);
                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }
                }
            }
            if (attackTicks == 28) {
                for (int k = 0; k < 12; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 12.0F + ((float) Math.PI * 2F / 15F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 4.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 4.5D);
                        this.level().addFreshEntity(newEntity);
                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }

                }
            }
            if (attackTicks == 31) {
                for (int k = 0; k < 15; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 15.0F + ((float) Math.PI * 2F / 20F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 5.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 5.5D);

                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }

                }
            }
            if (attackTicks == 34) {
                for (int k = 0; k < 18; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 18.0F + ((float) Math.PI * 2F / 25F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 6.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 6.5D);
                        this.level().addFreshEntity(newEntity);
                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }
                }
            }
            if (attackTicks == 37) {
                for (int k = 0; k < 21; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 21.0F + ((float) Math.PI * 2F / 30F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 8.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 8.5D);

                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }

                }
            }
            if (attackTicks == 40) {
                for (int k = 0; k < 24; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 24.0F + ((float) Math.PI * 2F / 35F);
                    EntityType<CloudEntity> entityType = ModEntities.C.get();
                    CloudEntity newEntity = entityType.create(this.level());
                    if (newEntity != null) {
                        newEntity.setPos(this.getX() + (double) Mth.cos(f2) * 7.5D, this.getY() + 8, this.getZ() + (double) Mth.sin(f2) * 7.5D);
                        this.level().addFreshEntity(newEntity);
                        newEntity.setParticleOptimalization(true);
                        newEntity.setDamage(damageCloud);
                        newEntity.setOwner(this);

                        newEntity.setAttackRange(cloudDamageRange);
                    }

                }
            }
            if (this.attackTicks == 29) {
                particle1 = false;

                this.entityData.set(TEXTURE_VARIANT1, 0);
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 13) {
                if (this.getTarget() != null) {
                    this.spawnLightningBolts();
                }
            }

        }

    }

    private void summonBolt(float size, float direction, float offset) {

        float cosAngle = (float) Math.cos(this.rotA * 0.017453292F);
        float sinAngle = (float) Math.sin(this.rotA * 0.017453292F);

        double theta = (double) this.rotA * 0.017453292519943295;
        ++theta;

        double directionX = Math.cos(theta);
        double directionZ = Math.sin(theta);

        for (int i = 0; i < 80 + this.random.nextInt(12); ++i) {

            double deltaX = this.getDeltaMovement().x() * 0.07;
            double deltaY = this.getDeltaMovement().y() * 0.07;
            double deltaZ = this.getDeltaMovement().z() * 0.07;

            float angle = 0.017453292F * this.rotA + (float) i;

            double extraX = (double) (size * Math.sin((float) (Math.PI + (double) angle)));
            double extraY = 0.30000001192092896;
            double extraZ = (double) (size * Math.cos(angle));

            int hitX = (int) Math.floor(this.getX() + (double) direction * directionX + extraX);
            int hitY = (int) Math.floor(this.getY());
            int hitZ = (int) Math.floor(this.getZ() + (double) direction * directionZ + extraZ);

            BlockPos hit = new BlockPos(hitX, hitY, hitZ);

            BlockState block = this.level().getBlockState(hit);

            if (block.getRenderShape() != RenderShape.INVISIBLE) {
                this.level().addParticle(
                        new BlockParticleOption(ParticleTypes.BLOCK, block),
                        this.getX() + (double) direction * directionX + extraX + (double) (cosAngle * offset),
                        this.getY() + extraY,
                        this.getZ() + (double) direction * directionZ + extraZ + (double) (sinAngle * offset),
                        deltaX, deltaY, deltaZ
                );
            }
        }

        if (this.level() instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) this.level();
            double lightningX = this.getX() + (double) direction * directionX + (double) (cosAngle * offset);
            double lightningY = this.getY() + 0.20000000298023224;
            double lightningZ = this.getZ() + (double) direction * directionZ + (double) (sinAngle * offset);

            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);

            if (lightningBolt != null) {
                lightningBolt.moveTo(lightningX, lightningY, lightningZ, this.getYRot(), 0.0F);
                serverLevel.addFreshEntity(lightningBolt);

            }
        }
    }

    private void summonControlledCloud(float x, float y, float z, float progress) {
        LivingEntity target = this.getTarget();
        if (target != null && !target.isDeadOrDying()) {

            double dx = target.getX() - this.getX();
            double dz = target.getZ() - this.getZ();
            double distance = Math.sqrt(dx * dx + dz * dz);

            double dirX = dx / distance;
            double dirZ = dz / distance;

            double offsetX = dirX * progress;
            double offsetZ = dirZ * progress;

            double spawnX = this.getX() + offsetX;
            double spawnY = target.getBoundingBox().maxY + 2;
            double spawnZ = this.getZ() + offsetZ;

            EntityType<CloudEntity> entityType = ModEntities.C.get();
            CloudEntity newEntity = entityType.create(this.level());
            if (newEntity != null) {
                newEntity.setDamage(8);
                newEntity.setPos(spawnX, spawnY, spawnZ);
                newEntity.setOwner(this);
                this.level().addFreshEntity(newEntity);
            }
        }
    }


    private void spawnBolt(float x, float y, float z) {
        if (this.getTarget() != null && !this.getTarget().isDeadOrDying()) {
            EntityType<LightningBolt> entityType = EntityType.LIGHTNING_BOLT;
            LightningBolt newEntity = entityType.create(this.level());

            if (newEntity != null) {
                newEntity.setPos(x, y, z);
                this.level().addFreshEntity(newEntity);
            }
        }
        if (this.getTarget() != null) {
            if (!this.getTarget().isBlocking()) {
            }
        }
    }

    public class LaserGoal extends Goal {
        protected final IAnimatedMonster entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        private final float attackrangemin;

        public LaserGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float attackrangemin) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.attackrangemin = attackrangemin;
        }

        public LaserGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float attackrangemin, EnumSet<Flag> interruptFlagTypes) {
            this.entity = entity;
            this.setFlags(interruptFlagTypes);
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.attackrangemin = attackrangemin;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && entity.distanceTo(target) > attackrangemin;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {

            this.entity.setAttackState(this.attackendstate);
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return this.entity.attackTicks < this.attackMaxtick;
        }

        public void tick() {
            float laserSpeed = 0;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                float distanceToTarget = this.entity.distanceTo(target);
                laserSpeed = Math.min(3.76f, Math.max(0.54f, distanceToTarget / 5));
            }

            float yRotSpeed = 1.5F + laserSpeed;
            if (this.entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), yRotSpeed, 90);
                entity.lookAt(target, 15, 15);

            } else {
                this.entity.setYRot(this.entity.yRotO);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }

    public static class MultipleHitGoal extends Goal {
        protected final IAnimatedMonster entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;

        private final int attackseetickattack4;
        private final int attackseetickattack3;
        private final int attackseetickattack2;
        private final float attackrange;

        public MultipleHitGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackseetick3, int attackseetick4, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            attackseetickattack2 = attackseetick2;

            attackseetickattack3 = attackseetick3;

            attackseetickattack4 = attackseetick4;
        }

        public MultipleHitGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackseetick2, int attackseetick3, int attackseetick4, EnumSet<Flag> interruptFlagTypes) {
            this.entity = entity;
            this.setFlags(interruptFlagTypes);
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;

            attackseetickattack4 = attackseetick4;
            attackseetickattack3 = attackseetick3;
            attackseetickattack2 = attackseetick2;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {

            this.entity.setAttackState(this.attackendstate);
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return this.entity.attackTicks < this.attackMaxtick;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (target != null &&
                    ((entity.attackTicks < attackseetick) || (entity.attackTicks > attackseetickattack2 && entity.attackTicks < attackseetickattack3))) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }


        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


}