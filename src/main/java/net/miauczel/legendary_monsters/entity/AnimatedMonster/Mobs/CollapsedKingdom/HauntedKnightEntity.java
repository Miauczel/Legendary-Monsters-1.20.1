package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom;

import net.miauczel.legendary_monsters.Particle.custom.KnightSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
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
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HauntedKnightEntity extends IAnimatedMonster implements IForgeEntity {
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(HauntedKnightEntity.class, EntityDataSerializers.INT);
    public final int PARRY_COOLDOWN = 20;
    public int parryCooldown = PARRY_COOLDOWN;

    public HauntedKnightEntity(EntityType<? extends IAnimatedMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        //  setTextureVariant(this.random.nextInt(3));
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
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
                        && entityHit != this;

                if (isEnemy) {
                    if (entityHit == this.getTarget()) {
                        if (getAttackState() == 8){
                            playSound(ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 1, 0.75f);
                        }else playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt = entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedKnightDamageMutliplier.get())
                        );

                        if (hurt && getAttackState() == 8)entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(),15,0));
                    } else if (attackedExtraMobCount < maxExtraMobs) {
                        if (getAttackState() == 8){
                            playSound(ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 1, 0.75f);
                        }else playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt =   entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedKnightDamageMutliplier.get())
                        );
                        attackedExtraMobCount++;
                        if (hurt && getAttackState() == 8)entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(),15,0));
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide)idleAnimationState.animateWhen(getAttackState() ==0 ,tickCount);
        if (parryCooldown >= 0) parryCooldown--;
        UpdateWithAttack();
        //   updateAttributes();

    }

    public AnimationState DeathAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState slashAnimationState = new AnimationState();

    public AnimationState sweepSpinAnimationState = new AnimationState();

    public AnimationState parryAnimationState = new AnimationState();

    public AnimationState parryFrameAnimationState = new AnimationState();

    public AnimationState parryFailAnimationState = new AnimationState();

    public AnimationState parrySuccessAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "slash") {
            return this.slashAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sweep_spin") {
            return this.idleAnimationState;
        } else if (input == "parry") {
            return this.parryAnimationState;
        } else if (input == "parry_frame") {
            return this.parryFrameAnimationState;
        } else if (input == "parry_fail") {
            return this.parryFailAnimationState;
        } else if (input == "parry_success") {
            return this.parrySuccessAnimationState;
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
                        this.slashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.sweepSpinAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.parryAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.parryFrameAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.parryFailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.parrySuccessAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.DeathAnimationState.stop();
        this.slashAnimationState.stop();
        sweepSpinAnimationState.stop();
        parryFailAnimationState.stop();
        parryAnimationState.stop();
        parrySuccessAnimationState.stop();
        parryFrameAnimationState.stop();
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

    public void setTextureVariant(int attacking) {
        this.entityData.set(TEXTURE_VARIANT, attacking);
    }

    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TEXTURE_VARIANT, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("texture", getTextureVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setTextureVariant(pCompound.getInt("texture"));
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
      //  this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 39, 20, 3F) {
            @Override
            public boolean canUse() {
                return super.canUse() && HauntedKnightEntity.this.getRandom().nextFloat() * 100.0F < 28.0F
                        && HauntedKnightEntity.this.getTarget() != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 65, 40, 3F) {
            @Override
            public boolean canUse() {
                return super.canUse() && HauntedKnightEntity.this.getRandom().nextFloat() * 100.0F < 28.0F
                        && HauntedKnightEntity.this.getTarget() != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new KnightParryGoal(this, 0, 4, 0, 8, 8, 3F) {
            @Override
            public boolean canUse() {
                return super.canUse() && HauntedKnightEntity.this.getRandom().nextFloat() * 100.0F < 33.0F
                        && HauntedKnightEntity.this.getTarget() != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new KnightParryFrameGoal(this, 5, 5, 0, 25, 25) {
            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 7, 7, 0, 11, 11) {
            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 8, 8, 0, 27, 27) {

            @Override
            public void stop() {
                super.stop();
            }
        });

        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.horizontalCollision && this.isInWall()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
        AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.1) {
            movementSpeedAttribute.setBaseValue(0.1);
        }
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50/*ModConfig.COMMON.HauntedKnightHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7F)
                .add(Attributes.FOLLOW_RANGE, 18D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.7D)
                .add(Attributes.ATTACK_DAMAGE, 11/*ModConfig.COMMON.hauntedKnightDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }


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
      //  pStack.addTagElement("Enchantments", new ListTag());
        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);
        if (itemEntity != null) {
          //  itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        dragonDeathTime = 0;
        setAttackState(6);
        switch (getTextureVariant()) {
            case 0,3 ->{
                for (int i =0; i<=random.nextInt(1,5);i++) {
                    LGspawnatlocation(Items.IRON_INGOT.getDefaultInstance());
                }
            }
            case 1 ->{
                for (int i =0; i<=random.nextInt(1,6);i++) {
                    LGspawnatlocation(Items.GOLD_INGOT.getDefaultInstance());
                }
            }
            case 2 ->{
                for (int i = 0; i<=random.nextInt(-1,2);i++) {
                    LGspawnatlocation(Items.DIAMOND.getDefaultInstance());
                }
            }
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.HauntedKnightHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {

        setTextureVariant(random.nextInt(0, 3));

        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public void calculatedDash(float Multiplier) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((target.getX() - this.getX()) * Multiplier, 0, (target.getZ() - this.getZ()) * Multiplier);
        }
    }

    @Override
    public boolean isPushable() {
        return true;
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
            // 0,3 iron
            // 1 gold
            //2 diamond
            case 0, 3 -> setRGB(203, 212, 214);
            case 1 -> setRGB(234, 238, 87);
            case 2 -> setRGB(161, 251, 232);
        }
        float swordSize = 2.5f;
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
        int extraMobs = 1;
        if (getAttackState() == 2) {
            if (attackTicks == 10) playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 2);
            if (attackTicks == 12) {
                float vec = 0;
                float offset = -0.5f;
                double d0 = getX() + vec * vecX + f * offset;
                double d1 = this.getY() + 1.5;
                double d2 = getZ() + vec * vecZ + f1 * offset;
                float yaw = (float) Math.toRadians(-yBodyRot + 90);
                float pitch = (float) Math.toRadians(-getXRot() + 180);
                this.level().addParticle(new KnightSweepParticle.SweepData(sweepSize, yaw, pitch, getR, getG, getB), d0, d1, d2, 0, 0, 0);
                calculatedDash(0.25f);
            }
            if (attackTicks == 15) {
                AreaAttack(swordSize, 3, 100, 8, extraMobs);
            }
        }
        int attack2 = 36;
        int attack1 = 14;
        if (getAttackState() == 3) {
            if (attackTicks == attack1 - 3) {
                createSweep(1, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 2);
            }
            if (attackTicks == attack1) {
                AreaAttack(swordSize, 3, 100, 8, extraMobs);
            }
            if (attackTicks == attack2 - 3) {
                createSweep(1, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 2);
            }
            if (attackTicks == attack2) {
                AreaAttack(swordSize, 3, 100, 8, extraMobs);
            }
        }
        int parryTick = 8;
        if (getAttackState() == 8) {
            if (attackTicks == parryTick - 3) {
                createSweep(1, 0, bigSweepHeight, bigSweepAdditionalY, false, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 2);
            }
            if (attackTicks == parryTick) {
                AreaAttack(swordSize, 3, 180, 13, 4);
            }
        }


    }

    boolean gambitParry = false;

    public boolean canParry() {
        return !gambitParry && !level().isClientSide && (getAttackState() == 4 && attackTicks > 5 || getAttackState() == 5);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (getAttackState() == 2 && attackTicks <= 13) {
            playSound(ModSounds.SHIELD_BLOCK, 1, 1);
            return false;
        }
        if (canParry()) {
            setAttackState(8);
            gambitParry = true;
            CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
            playSound(ModSounds.SHIELD_BLOCK, 1, 1f);
            return false;
        }
        return super.hurt(source, amount);
    }

    public int dragonDeathTime;
    public int DeathAnimationTimeout = 60;

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.level() instanceof ServerLevel) {


            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                //  this.setNoAi(true);


            }
        }
        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }
}

