package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom;

import net.miauczel.legendary_monsters.Particle.custom.KnightSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.OldKnights.HauntedKnightEntityOld;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class HauntedGuardEntity extends IAnimatedMonster implements IForgeEntity {
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(HauntedGuardEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(HauntedGuardEntity.class, EntityDataSerializers.BOOLEAN);

    public HauntedGuardEntity(EntityType<? extends IAnimatedMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        saveTargetPos(getX(), getY(), getZ());
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSleep(true);
        setTextureVariant(this.random.nextInt(0, 3));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
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
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    public void setTextureVariant(int attacking) {
        this.entityData.set(TEXTURE_VARIANT, attacking);
    }

    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("is_Sleep", isSleep());
        pCompound.putInt("texture", getTextureVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setSleep(compound.getBoolean("is_Sleep"));
        setTextureVariant(compound.getInt("texture"));

    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide) idleAnimationState.animateWhen(getAttackState() == 0, tickCount);
        if (slamCooldown > 0) {
            slamCooldown--;
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

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);

        this.entityData.define(TEXTURE_VARIANT, 0);
    }

    public int slamCooldown = 20;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, toTicks(2.67f), 15, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && HauntedGuardEntity.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && HauntedGuardEntity.this.getTarget() != null;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 90, 55, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && HauntedGuardEntity.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && HauntedGuardEntity.this.getTarget() != null;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 4, 4, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });

        this.goalSelector.addGoal(0, new IAttackGoal(this, 4, 5, 0, 15, 15, 10.0F));

        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
    }


    @Override
    public void aiStep() {
        super.aiStep();
        UpdateWithAttack();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50/*ModConfig.COMMON.hauntedGuardDamage.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7F)
                .add(Attributes.FOLLOW_RANGE, 18D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1.3D)
                .add(Attributes.ATTACK_DAMAGE, 11/*ModConfig.COMMON.hauntedGuardDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }

    @Nullable

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();

    }


    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.OVERGROWN_COLOSSUS_DEATH.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }

    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {
        // pStack.addTagElement("Enchantments", new ListTag());

        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);

        if (itemEntity != null) {
            //     itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }


    @Override
    public void die(DamageSource source) {
        super.die(source);
        setAttackState(7);
        dragonDeathTime = 0;
        if (level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            switch (getTextureVariant()) {
                case 0, 3 -> {
                    for (int i = 0; i <= random.nextInt(1, 5); i++) {
                        LGspawnatlocation(Items.IRON_INGOT.getDefaultInstance());
                    }
                }
                case 1 -> {
                    for (int i = 0; i <= random.nextInt(0, 6); i++) {
                        LGspawnatlocation(Items.GOLD_INGOT.getDefaultInstance());
                    }
                }
                case 2 -> {
                    for (int i = 0; i <= random.nextInt(-1, 2); i++) {
                        LGspawnatlocation(Items.DIAMOND.getDefaultInstance());
                    }
                }
            }
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.HauntedGuardHealthMultiplier.get());
        this.setPersistenceRequired();
    }


    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (ModConfig.MOB_CONFIG.Guardprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }


        if (source.is(DamageTypes.FALL))
            return false;

        if (source.is(DamageTypes.TRIDENT))
            return false;

        return super.hurt(source, amount);
    }

    Random random = new Random();

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }

    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;

    private void AreaAttack(float range, float height, float arc, float damage, int maxExtraMobs) {

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);


        int attackedExtraMobCount = 0;

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
            float entityHitDistance = (float) Math.sqrt(
                    (entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ())
                            + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX())
            );


            boolean inRange = entityHitDistance <= range;
            boolean inArc = (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2)
                    || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2);

            if (inRange && inArc) {

                boolean isEnemy = !isAlliedTo(entityHit)
                        && entityHit != this
                        && !(entityHit instanceof HauntedGuardEntity)

                        && !(entityHit instanceof HauntedKnightEntityOld)
                        && !isAlliedTo(entityHit);

                if (isEnemy) {

                    if (entityHit == this.getTarget()) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt = entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get())
                        );
                        if (hurt) {
                            launch(this, true, 0.25f);
                        }
                    } else if (attackedExtraMobCount < maxExtraMobs) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt = entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get())
                        );
                        if (hurt) {
                            launch(this, true, 0.25f);
                        }
                        attackedExtraMobCount++;
                    }
                }
            }
        }
    }

    public void setRGB(float r, float g, float b) {
        getR = r / 255;
        getG = g / 255;
        getB = b / 255;
    }

    public float getR;
    public float getG;
    public float getB;

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

    public void UpdateWithAttack() {
        switch (getTextureVariant()) {
            // 0,3 iron
            // 1 gold
            //2 diamond
            case 0, 3 -> setRGB(203, 212, 214);
            case 1 -> setRGB(234, 238, 87);
            case 2 -> setRGB(161, 251, 232);
        }
        int extraMobs = 2;
        float axeRange = 3f;
        float sweepSize = 1f;
        float sweepRot = 20;
        float bigSweepHeight = 3;
        float bigSweepAdditionalY = 0;
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        int slamAttack = 20;
        if (getAttackState() == 2) {
            if (attackTicks == slamAttack - 7) {
                if (targetIsNotNull()) saveTargetPos(target().getX(), target().getY(), target().getZ());
            }
            if (attackTicks == slamAttack - 3) {

                calculatedDashToPositon(0.15f, lastTargetPos());
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                double d0 = this.getX();
                double d1 = this.getY() + bigSweepAdditionalY;
                double d2 = this.getZ();
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                if (level().isClientSide) {
                    this.level().addParticle(new KnightSweepParticle.SweepData(sweepSize, yaw, pitch, getR, getG, getB), d0, d1, d2, 0, 0, 0);
                }
            }
            if (attackTicks == slamAttack) {
                playSound(ModSounds.DRAGON_FIREBALL_EXPLODE, 1, 1);
                StraightLineAreaAttack(-0.5f, 3f, 3.25f, 100, 14, true, 1.2f);
            }
        }
        int uppercutTick = toTicks(1.21f);
        int slashTick = toTicks(2.63f);
        if (getAttackState() == 3) {
            if (attackTicks == uppercutTick - 3) {
                createSweep(1, 0, bigSweepHeight + 1, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                calculatedDash(0.25f);
            }
            if (attackTicks == uppercutTick) {
                AreaAttack(3, 3, 180, 14, 10);
            }
            if (attackTicks == slashTick - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                createSweep(1, 0, bigSweepHeight - 1, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
            }
            if (attackTicks == slashTick) {
                AreaAttack(3, 3, 180, 14, 10);
            }

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
            this.level().addParticle(new KnightSweepParticle.SweepData(this.getScale() * scale, yaw, pitch, getR, getG, getB), d0, d1, d2, 0, 0, 0);
        }
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    public void launch(LivingEntity entity, boolean huge, float mult) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? mult : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float launchPower) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this) {
                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get())));

                if (flag && launch) {

//launch(entityHit,true,2,0.3f);
                    launch(entityHit, true, 1);
                }
                if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                    disableShield(entityHit, brokenShieldTicks);
                }
            }
        }
    }

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;

        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState uppercutAnimationState = new AnimationState();

    public AnimationState slamAnimationState = new AnimationState();
    public AnimationState combo2AnimationState = new AnimationState();
    public AnimationState slashAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();

    public AnimationState guardAnimationState = new AnimationState();

    public AnimationState awakenAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "slash") {
            return this.slashAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sit") {
            return this.sitAnimationState;
        } else if (input == "uppercut") {
            return this.uppercutAnimationState;
        } else if (input == "death") {
            return this.DeathAnimationState;
        } else if (input == "awaken") {
            return this.awakenAnimationState;
        } else if (input == "guard") {
            return this.guardAnimationState;
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
                        this.slamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.uppercutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.guardAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.awakenAnimationState.startIfStopped(this.tickCount);
                    }

                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.sitAnimationState.stop();
        this.DeathAnimationState.stop();
        this.slamAnimationState.stop();
        this.slashAnimationState.stop();
        this.uppercutAnimationState.stop();
        this.combo2AnimationState.stop();
        awakenAnimationState.stop();
        guardAnimationState.stop();
    }
}




