package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.Particle.custom.SoulSigil;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMob;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownPhantomDaggerEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class FracturedApostleEntity extends IAnimatedMob implements IForgeEntity {
    public FracturedApostleEntity(EntityType<? extends IAnimatedMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        saveTargetPos(getX(), getY(), getZ());
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 4 : 0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 4 || this.getAttackState() == 5;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
       //     itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("is_Sleep", isSleep());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setSleep(compound.getBoolean("is_Sleep"));

    }

    @Override
    public void tick() {
        super.tick();
        if (getAttackState() == 4 && attackTicks > 38){
            setAttackState(0);
        }
        //System.out.println("AnimationState: " + getAttackState() + " AttackTicks: " +attackTicks);
        if (level().isClientSide) idleAnimationState.animateWhen(getAttackState() == 0, tickCount);
        UpdateWithAttack();
        for (int i = 0; i < 0.5; ++i) {
            if (level().isClientSide && getAttackState() != 3) {
                float scale = 0.5f;
                this.level().addParticle(ModParticles.GHOSTLY_SOUL.get(), this.getRandomX(scale), this.getRandomY(), this.getRandomZ(scale), 0D, 0.025D, 0D);

            }

        }
    }


    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0;
        }
        this.walkAnimation.update(f, 0.2f);
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
       // this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 40, 40, 10.0F) {
            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < 16 && !animationLockedForTests()
                        && target != null && distanceTo(target) >=4;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 38, 38, 3.5F) {
            public boolean canUse() {
                var target = getTarget();
                return super.canUse() && getRandom().nextFloat() * 40.0F < 16 && !animationLockedForTests()
                        && target != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 3, 3, 0, 20, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });

    }

    public boolean animationLockedForTests() {
        return false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7F)
                .add(Attributes.FOLLOW_RANGE, 18D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1.3D)
                .add(Attributes.ATTACK_DAMAGE, 11);
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

    public ControlledAnim bodyFadeAway = new ControlledAnim(10);

    public ControlledAnim weaponFade = new ControlledAnim(10);

    @Override
    public void die(DamageSource source) {
        dragonDeathTime = 0;
        setAttackState(3);
        super.die(source);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.FracturedApostleHealthMultiplier.get());
        this.setPersistenceRequired();
    }


    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PHANTOM_HURT;
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }

    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;


    public void saveTargetPos(double x, double y, double z) {
        lastTargetX = x;
        lastTargetY = y;
        lastTargetZ = z;
    }

    public Vec3 lastTargetPos() {
        return new Vec3(lastTargetX, lastTargetY, lastTargetZ);
    }

    public double lastTargetX;
    public double lastTargetY;
    public double lastTargetZ;
    Random random1 = new Random();

    public void attractParticles(LivingEntity player, ParticleOptions particleOptions, int cap, int reps, float vec, float offset, float startY, float endY, float velocity) {
        float yBodyRot = player.yBodyRot;
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        int rX = random1.nextInt(-cap, cap);
        int rZ = random1.nextInt(-cap, cap);

        float f2 = (this.random.nextFloat() - 0F) * 0.5F;
        double d1 = player.getX() + rX;
        double d2 = player.getY() + startY + f2;

        double d3 = player.getZ() + rZ;
        Vec3 vec3 = new Vec3(d1, d2, d3);
        Vec3 vec4 = new Vec3(player.getX() + vec * vecX + f * offset, player.position().y + endY, player.getZ() + vec * vecZ + f1 * offset);
        Vec3 vf = vec4.subtract(vec3);
        Vec3 v = vf.scale(velocity);
        for (int i = 0; i <= reps; i++) {
            // ParticleUtils.sendParticlesToServer(player.level(),particleOptions,d1,d2,d3,1,0,0,0,v.length());
            player.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);

        }
    }

    public void UpdateWithAttack() {
        if (getAttackState() == 2) {
            if (attackTicks < MathUtils.toTicks(0.92f)) {
                if (tickCount % 5 == 0) {
                    int ucap = 5;
                    float v = 0.075f;
                    float endY = 1.5f;
                    attractParticles(this, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 5, endY, v);
                    attractParticles(this, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 3, endY, v);
                    attractParticles(this, ModParticles.GHOSTLY_SOUL.get(), ucap, 4, 0, 0, 2, endY, v);
                }
            }

            if (attackTicks == MathUtils.toTicks(0.42f)) {
                playSound(SoundEvents.VILLAGER_WORK_LIBRARIAN, 1, 1);
                spawnCircleParticle(0, 0, 30, false, 0, 0, 0.9f, 0.8f, 0.5f, Circle.EnumRingBehavior.SHRINK, 20);

            }
            if (attackTicks == MathUtils.toTicks(0.92f)) {
                playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 1, 1);
                if (level().isClientSide) {
                    level().addParticle(ModParticles.SOUL_SHOOT.get(), getX(), getY() + 4, getZ(), 0, 0, 0);
                    level().addParticle(new SoulSigil.RingData(0, 0, 20, 1, 1, 1, 0.5f, 15, true, SoulSigil.EnumRingBehavior.CONSTANT)
                            , getX(), getY() + 4, getZ(), 0, 0, 0);
                }
                if (targetIsNotNull()) {
                    ThrownPhantomDaggerEntity phantomDaggerEntity = new ThrownPhantomDaggerEntity(ModEntities.THROWN_PHANTOM_DAGGER.get(), level());
                    phantomDaggerEntity.setPosRaw(getX(), getY() + 4, getZ());
                    phantomDaggerEntity.setReturnEntity(target());
                    phantomDaggerEntity.setReturnTick(0);
                    phantomDaggerEntity.setDamage(4);
                    phantomDaggerEntity.setOwner(this);
                    phantomDaggerEntity.setInteria(0.9f);
                    phantomDaggerEntity.setLessLifeTicks(50);
                    level().addFreshEntity(phantomDaggerEntity);
                }
            }
        }
        if (getAttackState() == 4) {
            if (attackTicks == 1) {
                weaponFade.resetTimer();
                weaponFade.setTimer(5);
            }
            if (attackTicks >= 2 && attackTicks <= 30 && weaponFade.getTimer() > 0) {
                weaponFade.decreaseTimer();
            }
            if (attackTicks == 29) weaponFade.setTimer(0);
            if (attackTicks >= 30) {
                weaponFade.increaseTimer();
            }

            int attackTick = MathUtils.toTicks(0.67f);
            if (attackTicks == attackTick - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1.25f);
                calculatedDash(0.25f);
            }
            if (attackTicks == attackTick) {
                SideAreaAttack(1.75f, 3, 180, 0, 0, 14, 30, ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 1, false, 0);
            }
        }

    }

    public boolean hasGhostKnife(){
        return getAttackState() == 4;
    }
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
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
                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FracturedApostleDamageMutliplier.get())));

                    if (flag) {
                    //    EntityUtil.cancelBuffs(entityHit);
                      //  entityHit.invulnerableTime = 0;
                        if (launch) launch(entityHit, true);
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
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (dragonDeathTime > 10) {
            bodyFadeAway.increaseTimer();
        }
        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState summonSwordsAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState attackAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "attack") {
            return this.attackAnimationState;
        }
        if (input == "summon") {
            return this.summonSwordsAnimationState;
        }else {
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
                        this.summonSwordsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        summonSwordsAnimationState.stop();
        deathAnimationState.stop();
        attackAnimationState.stop();
    }
}




