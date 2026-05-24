package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FireBreath;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FireColumnEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class Lava_eaterEntity extends IAnimatedMiniBoss {
    public Lava_eaterEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 5;
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();


        }

    }

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
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

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    public void resetSmashAnchorCooldown() {
        if (bigsmashCooldown <= 0) {
            this.bigsmashCooldown = SMASH_ANCHOR_COOLDOWN;
        }
    }

    public int bigsmashCooldown2 = 0;
    public int bigsmashCooldown = 0;
    public final int SMASH_ANCHOR_COOLDOWN = 100;

    @Override
    public void tick() {
        if (bigsmashCooldown > 0) {
            --bigsmashCooldown;

        }

        if (bigsmashCooldown2 > 0) {
            --bigsmashCooldown2;

        }

        if (anger > 0) {

            --anger;
        }
        this.isPushable();
        if (this.getAttackState() == 4) {
            if (this.attackTicks >= 54 && this.attackTicks <= 90) {

            }
        }

        if (!(this.getAttackState() == 4)) {
            this.ejectPassengers();
        }
        UpdateWithAttack();
        super.tick();

        if (teleportCooldown > 0) {
            --teleportCooldown;
        }
        //updateAttributes();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Sleep", isSleep());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

    }

    private int teleportCooldown = 0;

    @Override

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 24, 18, 4.5F) {
            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && Lava_eaterEntity.this.getTarget() != null && !(Lava_eaterEntity.this.getAttackState() == 6) && !(Lava_eaterEntity.this.getAttackState() == 7);
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 48, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Lava_eaterEntity.this.bigsmashCooldown <= 0
                        && Lava_eaterEntity.this.getTarget() != null && !(Lava_eaterEntity.this.getAttackState() == 3) && !(Lava_eaterEntity.this.getAttackState() == 7);
            }

            @Override
            public void start() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.start();
            }

            @Override
            public void tick() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.tick();
            }

            public void stop() {
                super.stop();
                resetSmashAnchorCooldown();

            }
        });
        this.goalSelector.addGoal(1, new FlamethrowerGoal(this, 0, 8, 0, 80, 20, 7.0F, -1) {
            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Lava_eaterEntity.this.k()
                        && Lava_eaterEntity.this.getTarget() != null && !(Lava_eaterEntity.this.getAttackState() == 3) && !(Lava_eaterEntity.this.getAttackState() == 7);
            }

            @Override
            public void start() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.start();
            }

            @Override
            public void tick() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.tick();
            }

            public void stop() {
                super.stop();
                Lava_eaterEntity.this.anger = 160;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 48, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Lava_eaterEntity.this.bigsmashCooldown2 <= 0
                        && Lava_eaterEntity.this.getTarget() != null && !(Lava_eaterEntity.this.getAttackState() == 3) && !(Lava_eaterEntity.this.getAttackState() == 6);
            }

            @Override
            public void start() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.start();
            }

            @Override
            public void tick() {
                if (Lava_eaterEntity.this.getTarget() instanceof Player player && Lava_eaterEntity.this.getTarget() != null) {

                }
                super.tick();
            }

            public void stop() {
                super.stop();
                bigsmashCooldown2 = 200;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 4, 0, 104, 64, 12.0F, 6) {
            @Override
            public void start() {
                Lava_eaterEntity.this.setInvulnerable(true);
                super.start();
            }

            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && Lava_eaterEntity.this.teleportCooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();

                Lava_eaterEntity.this.setInvulnerable(false);
                Lava_eaterEntity.this.teleportCooldown = 300;

            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.horizontalCollision && this.isInWall()) {

            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 170)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 11);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        setSleep(compound.getBoolean("is_Sleep"));
        if (this.getHealth() == this.getMaxHealth()) {
            //  updateAttributes();
        }
    }

    /*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.LavaEaterHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.LavaEaterDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 170D;
        double baseAttackDamage = 12D;

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth);
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }*/
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ENDERSENT_HURT1.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERSENT_DEATH.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
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

    @Override
    public void die(DamageSource source) {
        super.die(source);
        this.setAttackState(5);
        dragonDeathTime = 0;

    }


    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.LavaEaterHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        if (this.getAttackState() == 4) {

            return false;

        } else {

            return true;
        }
    }

    public boolean k() {
        return anger <= 0;
    }

    public int hh() {
        return anger;
    }

    private int anger;

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.is(DamageTypes.IN_FIRE))
            return false;

        if (ModConfig.MOB_CONFIG.Lavaprojectile.get()) {

            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }

        if (source.is(DamageTypes.FALL))
            return false;


        if (source.is(DamageTypes.ON_FIRE))
            return false;

        if (source.is(DamageTypes.HOT_FLOOR))
            return false;
        if (source.is(DamageTypes.LAVA))
            return false;


        return super.hurt(source, amount);
    }

    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;

        boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);


        if (this.level() instanceof ServerLevel) {


            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);
            }
        }
        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {

            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState fAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState attackDigAnimationState = new AnimationState();
    public AnimationState attackBiteAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState slamAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "dig") {
            return this.attackDigAnimationState;
        } else if (input == "bite") {
            return this.attackBiteAnimationState;
        } else if (input == "spin") {
            return this.spinAnimationState;
        } else if (input == "slam") {
            return this.slamAnimationState;
        } else if (input == "fire") {
            return this.fAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
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
                        this.attackBiteAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackDigAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.spinAnimationState.startIfStopped(this.tickCount);
                    }

                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.slamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.fAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    private void launch2(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? 2.0F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.5 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();

        this.fAnimationState.stop();
        this.awakeAnimationState.stop();
        this.deathAnimationState.stop();
        this.attackDigAnimationState.stop();
        this.attackBiteAnimationState.stop();
        this.spinAnimationState.stop();
        this.slamAnimationState.stop();
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Lava_eaterEntity) && entityHit != this) {

                    if (this.getAttackState() == 3) {
                        if (this.attackTicks == 8) {
                            entityHit.setRemainingFireTicks(80);
                        }
                    }
                    if (this.getAttackState() == 3) {
                        if (this.attackTicks == 8) {
                            entityHit.setRemainingFireTicks(80);
                        }
                    }

                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.LavaEaterDamageMutliplier.get())));

                    if (launch) {
                        if (this.getAttackState() == 6) {
                            this.launch(entityHit, true);
                        }
                        if (this.getAttackState() == 7) {
                            this.launch2(entityHit, true);
                        }
                    }
                    if (!entityHit.isBlocking()) {

                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    private void spawnFire(double x, double z, double minY, double maxY, float rotation, int delay) {

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
            this.level().addFreshEntity(new FireColumnEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1));
        }
    }

    private void StrikeFire(int rune, double time) {
        for (int i = 0; i < rune; ++i) {
            float throwAngle = (float) i * 3.1415927F / (float) (rune / 2);

            for (int k = 0; k < 8; ++k) {
                double d2 = 1.15 * (double) (k + 1);
                int d3 = (int) (time * (double) (k + 1));
                this.spawnFire(this.getX() + (double) Mth.cos(throwAngle) * 1.25 * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25 * d2, this.getY(), this.getY() + 2.0, throwAngle, d3);
            }
        }

    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    private void teleportToTarget(LivingEntity target) {
        double targetPosX = target.getX();
        double targetPosY = target.getY();
        double targetPosZ = target.getZ();
        this.teleportTo(targetPosX, targetPosY, targetPosZ);
    }

    private void teleportToTarget2(LivingEntity target) {
        double targetPosX = target.getX();
        double targetPosY = target.getY();
        double targetPosZ = target.getZ();
        this.teleportTo(targetPosX + 2, targetPosY, targetPosZ);
    }

    public void UpdateWithAttack() {
        if (this.getAttackState() == 8) {

            {
                if (this.attackTicks > 5 && this.attackTicks < 60) {
                    this.playSound(SoundEvents.WARDEN_SONIC_CHARGE, 1.0F, 1.0F);
                }
            }
            {
                if (this.attackTicks == 13) {
                    Vec3 mouthPos = new Vec3(0, 1, 0);
                    mouthPos = mouthPos.yRot((float) Math.toRadians(-getYRot() - 90));
                    mouthPos = mouthPos.add(position());
                    mouthPos = mouthPos.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
                    FireBreath breath = new FireBreath(ModEntities.FIRE_B.get(), this.level(), (float) 11
                            , this);
                    //if (Ignited_Revenant_Entity.this.getAnimationTick() == 27) {
                    breath.absMoveTo(mouthPos.x, mouthPos.y, mouthPos.z, this.yHeadRot, this.getXRot());
                    this.level().addFreshEntity(breath);
                }
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 13) {


                this.AreaAttack(6.7F, 3.0F, 140.0F, 12.0F, 40, false, 0.75F, false, 0.75F, true);
                this.playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(), 2, 1);
            }
        }
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 3) {
                this.playSound(SoundEvents.EVOKER_FANGS_ATTACK, 1, 1);
            }
            if (this.attackTicks == 8) {

                this.AreaAttack(4.5F, 3.0F, 100.0F, 8.0F, 40, false, 0.75F, true, 0.75F, false);

            }
        }
        if (this.getAttackState() == 7) {
            if (this.attackTicks == 28) {
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
                this.AreaAttack(7.5F, 6.0F, 200.0F, 16.0F, 40, false, 0.75F, false, 0.75F, true);
                StrikeFire(10, 0.5);

                spawnCircleParticle(2f, 0, 30, true, 5f, 1f, 0.2f, 0.2f, 1);
            }
        }

        if (this.getAttackState() == 4) {
            if (this.attackTicks > 10 && this.attackTicks < 27) {
                if (this.tickCount % 2 == 0) {


                    this.playSound(SoundEvents.ROOTED_DIRT_BREAK, 2, 1);
                }
            }
            if (this.attackTicks == 1) {

                this.setInvulnerable(true);
            }
            if (this.attackTicks == 10) {
                for (int i = 0; i < 80; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);

                }
            }
            if (this.attackTicks == 20) {

                for (int i = 0; i < 80; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                }
            }

            if (this.attackTicks == 25) {
                this.setInvisible(true);

                for (int i = 0; i < 80; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                }
            }

            if (this.attackTicks >= 27 && this.attackTicks <= 50) {

                LivingEntity target = this.getTarget();
                if (target != null) {

                    double distanceToTarget = this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                    if (distanceToTarget < 225) {
                        teleportToTarget(target);
                    }
                }


            }
            if (this.attackTicks > 24 && this.attackTicks < 35) {
                if (this.tickCount % 2 == 0) {
                    this.playSound(SoundEvents.ROOTED_DIRT_BREAK, 2, 1);
                }
            }
            if (this.attackTicks == 50) {
                this.setInvisible(false);
            }
            if (this.attackTicks == 54) {
                LivingEntity target = this.getTarget();

                if (this.getTarget() != null) {
                    assert target != null;
                    if (this.getPassengers().isEmpty()) {
                        if (!target.isBlocking()) {
                            target.startRiding(this, true);
                        } else {
                            if (target instanceof Player p) {
                                disableShield(p, 200);
                            }
                        }
                    }

                    if (!(target instanceof Player)) {
                        if (!(target instanceof ServerPlayer)) {

                        }
                    }
                }

                for (int i = 0; i < 80; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                }
            }

            if (this.attackTicks >= 54 && this.attackTicks <= 90) {

                LivingEntity target = this.getTarget();


                if (this.getTarget() != null) {
                    assert target != null;
                    double distanceToTarget = this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                    if (distanceToTarget < 9) {
                        float m = (float) (target.getMaxHealth() * 0.01);
                        if (!this.getPassengers().isEmpty()) {
                            this.AreaAttack(2.0F, 5.0F, 560.0F, 10.0F + m, 0, false, 0.75F, false, 0.75F, false);

                            if (this.tickCount % 5 == 0) {
                                this.heal(2);
                            }
                        }
                        if (target.isShiftKeyDown()) {
                            target.setShiftKeyDown(false);
                        }
                    }
                }
                this.setInvulnerable(false);

            }
            if (this.attackTicks == 93) {
                LivingEntity target = this.getTarget();
                if (this.getTarget() != null) {
                    assert target != null;
                    target.stopRiding();
                }
            }
            if (this.attackTicks == 95) {
                LivingEntity target = this.getTarget();
                if (this.getTarget() != null) {
                    assert target != null;
                    this.teleportToTarget2(target);
                }


            }
            if (!this.getPassengers().isEmpty()) {
                Entity entity = this.getPassengers().get(0);
                LivingEntity target = this.getTarget();
                if (this.getTarget() != null) {
                    assert target != null;
                    if (target.isShiftKeyDown()) {
                        target.setShiftKeyDown(false);
                    }
                }
            }
        }
    }

    @javax.annotation.Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }


    public boolean canRiderInteract() {
        return true;
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public class FlamethrowerGoal extends Goal {
        protected final IAnimatedMonster entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        private final float attackrangemin;

        public FlamethrowerGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float attackrangemin) {
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

        public FlamethrowerGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float attackrangemin, EnumSet<Flag> interruptFlagTypes) {
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
                this.entity.setYRot(this.entity.yRotO);


            } else if (entity.attackTicks > attackseetick && target != null) {

                entity.getLookControl().setLookAt(target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), yRotSpeed, 90);
            } else if (target == null) {

                this.entity.setYRot(getYRot());
            }

        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }
}