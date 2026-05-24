package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.BigCannonAttackGoal;

import net.miauczel.legendary_monsters.entity.ai.goal.BigCannonShootGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.BombEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class DuneSentinelEntity extends Monster implements IForgeEntity, RangedAttackMob {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(DuneSentinelEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOOTING =
            SynchedEntityData.defineId(DuneSentinelEntity.class, EntityDataSerializers.BOOLEAN);

    public DuneSentinelEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);

    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState shootAnimationState = new AnimationState();
    public int shootAnimationTimeout = 0;


    public void attackTargets(Entity entity1){
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 16 * ModConfig.MOB_CONFIG.DuneSentinelDamageMutliplier.get();


        //deal damage
        if(entity1 instanceof LivingEntity livingEntity ) {

            if(this.level().getDifficulty() == Difficulty.HARD) {
                livingEntity.hurt(damageSource, (float) (damage - 5));

            } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                livingEntity.hurt(damageSource, (float) damage);

            } else if (this.level().getDifficulty() == Difficulty.EASY) {
                livingEntity.hurt(damageSource, (float) (damage + 14));

            }
        }
    }
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 200;
    @Override
    public void tick() {
        super.tick();
        if (DeathAnimationState.isStarted()) {
            DeathAnimationTimeout--;
            if (DeathAnimationTimeout <= 0) {
                DeathAnimationState.stop();
            }
        }
      //  updateAttributes();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
        if (shootCooldown > 0) {
            shootCooldown--;
        }

        if (shootAnimCooldown > 0) {
            this.entityData.set(SHOOTING, false);
            shootAnimCooldown--;
        } else if (!this.isAttacking() && this.shootAnimCooldown == 0 && this.getTarget() !=null ) {
            this.entityData.set(SHOOTING, true);
        }
    }
    public DuneSentinelEntity.Crackiness getCrackiness() {
        return DuneSentinelEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<DuneSentinelEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double)p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static DuneSentinelEntity.Crackiness byFraction(float pFraction) {
            for (DuneSentinelEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }
    private void setupAnimationStates() {
        if(DeathAnimationTimeout >= 200) {
            if (this.dragonDeathTime > 0 && !DeathAnimationState.isStarted()) {
                DeathAnimationState.start(this.tickCount);
                --this.DeathAnimationTimeout;
                attackAnimationState.stop();
                shootAnimationState.stop();

            }
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }

            if (this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationTimeout = (int) 17.5;
                attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }

            if (!this.isAttacking() && !this.isShooting()) {
                attackAnimationState.stop();
            }

            if (this.isShooting() && shootAnimationTimeout <= 0 && shootCooldown == 0) {
                shootAnimationTimeout = (int) 35;
                shootAnimationState.start(this.tickCount);
            } else {
                --shootAnimationTimeout;
            }

            if (!this.isShooting() && !this.isAttacking()) {
                shootAnimationState.stop();
            }
        }
    }

    public void setShooting(boolean shooting) {
        this.entityData.set(SHOOTING, shooting);
    }

    public boolean isShooting() {
        return this.entityData.get(SHOOTING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(SHOOTING, false);
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
    protected void registerGoals() {
        if(!(this.dragonDeathTime > 0)) {
            this.goalSelector.addGoal(0, new FloatGoal(this));
        }
        if(!(this.dragonDeathTime > 0)) {
            this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        }
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new BigCannonAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(2, new BigCannonShootGoal(this)); // Dodaj cel strzelania strzałami
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, entity -> entity instanceof Player));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide && this.getCrackiness() == Crackiness.HIGH) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 0.5; ++i) {
                this.level().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                this.level().addParticle(ParticleTypes.FLAME, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.0D, 0D);
            }
        }
        if (this.level().isClientSide && this.getCrackiness() == Crackiness.MEDIUM) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 0.5; ++i) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.0D, 0D);
            }
        }
        LivingEntity target = this.getTarget();

        if (target != null) {

            double targetX = target.getX() - this.getX();
            double targetY = target.getEyeY() - this.getEyeY();
            double targetZ = target.getZ() - this.getZ();
            double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

            float yaw = (float) (Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
            float pitch = (float) (-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

            this.yHeadRot = this.yBodyRot = yaw;
            this.yBodyRot = pitch;

            if (this.attackAnimationTimeout <= 0) {
                this.performRangedAttack(target, (float) (horizontalDistance / 20.0));
                this.attackAnimationTimeout = 20;
            }
        }
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {



            BombEntity chorusBomb = new BombEntity(ModEntities.BOMB.get(), this.level(), this);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - chorusBomb.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, 0.8F, 14 - this.level().getDifficulty().getId() * 4);
            chorusBomb.setOwner(this);
            if (Math.random() < 0.5) {
                this.playSound(ModSounds.CANNON_SHOOT_2.get(), 3.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            } else {
                this.playSound(ModSounds.CANNON_SHOOT_1.get(), 3.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }

            this.level().addFreshEntity(chorusBomb);

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 170D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 16D)
                .add(Attributes.MOVEMENT_SPEED, 0F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 16D);
    }

    @Override
    public void push(Entity pEntity) {
    }

    @Override
    public void push(double pX, double pY, double pZ) {
    }

    @Override
    public void knockback(double strength, double x, double z) {

    }
    public void ResetShootCooldown() {
        shootCooldown = SHOOT2_COOLDOWN_DURATION;
    }
    public void ResetShootAnimCooldown() {
        shootAnimCooldown = SHOOT_COOLDOWN_DURATION;
    }
    private static final int SHOOT2_COOLDOWN_DURATION = 40;
    private static final int SHOOT_COOLDOWN_DURATION = 40;

    private int shootCooldown = 0;
    private int shootAnimCooldown = 0;

    public boolean canAnim() {
        return shootAnimCooldown <= 0;
    }
    public boolean canShoot() {
        return shootCooldown <= 0;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
         //   updateAttributes();
        }
        this.shootCooldown = compound.getInt("ShootCooldown");
        this.shootAnimCooldown = compound.getInt("ShootAnimCooldown");
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.DuneSentinelHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.DuneSentinelDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 170D; // podstawowe zdrowie moba
        double baseAttackDamage = 16D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }
*/

    public void performAreaAttack() {
        double attackRadius = 4.0;
        double attackHeight = 3.0;

        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && !(entity == this.getTarget()) && !(entity instanceof MossyGolemEntity)) {
                if (!(entity instanceof CameraShakeEntity)) {


                    this.doHurtTarget((livingEntity));
                }
            }
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.DUNE_SENTINEL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUNE_SENTINEL_DEATH.get();
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("ShootCooldown", this.shootCooldown);
        compound.putInt("ShootAnimCooldown", this.shootAnimCooldown);
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
    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return false;
    }
    @Override
    public void die(DamageSource source) {
        super.die(source);
        this.dragonDeathTime = 0;
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.DuneSentinelHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (ModConfig.MOB_CONFIG.Duneprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }

        if (source.is(DamageTypes.FALL))
            return false;
        if (source.is(DamageTypes.EXPLOSION))
            return false;
        if (source.is(DamageTypes.PLAYER_EXPLOSION))
            return false;
        if (source.is(DamageTypes.MOB_PROJECTILE))
            return false;
        if (source.is(DamageTypes.TRIDENT))
            return false;

        return super.hurt(source, amount);
    }
    public int dragonDeathTime;
    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.dragonDeathTime >= 180 && this.dragonDeathTime <= 200) {
            float f = (this.random.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;


            this.playSound(SoundEvents.GENERIC_EXPLODE,1,0.5F);
            this.level().addParticle(ParticleTypes.EXPLOSION_EMITTER, this.getX() + (double)f, this.getY() + 2.0D + (double)f1, this.getZ() + (double)f2, 0.0D, 0.0D, 0.0D);
        }
        if (this.level() instanceof ServerLevel) {
            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);
                if (this.level().isClientSide) {
                    if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                        this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
                    }

                    for(int i = 0; i < 0.5; ++i) {
                        this.level().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                        this.level().addParticle(ParticleTypes.FLAME, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.0D, 0D);
                    }
                }
            }
        }
        if (this.dragonDeathTime > 100) {
            if (this.level().isClientSide) {


                for(int i = 0; i < 0.5; ++i) {
                    this.level().addParticle(ParticleTypes.ASH, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                    this.level().addParticle(ParticleTypes.LAVA, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
                    this.level().addParticle(ParticleTypes.FLAME, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.0D, 0D);
                }
            }
        }

        if(this.dragonDeathTime == 60){
            this.setRemainingFireTicks(140);
        }
        if(this.dragonDeathTime == 190){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 20, 20);
        }
        if (this.dragonDeathTime == 200 && this.level() instanceof ServerLevel) {

            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
