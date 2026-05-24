package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.ai.Warped_FungussusAttackGoal;

import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;

public class Warped_FungussusEntity extends Monster implements IForgeEntity {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Warped_FungussusEntity.class, EntityDataSerializers.BOOLEAN);
    public Warped_FungussusEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 4;
        this.setNoAi(false);

        {





        }

    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }


    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {

            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }
    @Override
    public void tick() {
        super.tick();
        if (DeathAnimationState.isStarted()) {
            DeathAnimationTimeout--;
            if (DeathAnimationTimeout <= 0) {
                DeathAnimationState.stop();
            }
        }
//updateAttributes();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (DeathAnimationTimeout >= 60) {
            if (this.dragonDeathTime > 0 && !DeathAnimationState.isStarted()) {
                DeathAnimationState.start(this.tickCount);
                --this.DeathAnimationTimeout;
                stopAllOtherAnimations();

            }
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(80) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }

            if (this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationTimeout = 29;
                attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }

            if (!this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationState.stop();
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
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new Warped_FungussusAttackGoal(this, 3D, true));

        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    @Override
    public void aiStep() {
        super.aiStep();

        LivingEntity target = this.getTarget();

        if (target != null) {
            double targetX = target.getX() - this.getX();
            double targetY = target.getEyeY() - this.getEyeY();
            double targetZ = target.getZ() - this.getZ();
            double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

            float yaw = (float)(Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
            float pitch = (float)(-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

            this.yHeadRot = this.yBodyRot = yaw;
            this.yBodyRot = pitch;
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100/*ModConfig.COMMON.WarpedFungussusHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE,7 /*ModConfig.COMMON.WarpedFungussusDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
          //  updateAttributes();
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.WarpedFungussusHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.WarpedFungussusDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 100D; // podstawowe zdrowie moba
        double baseAttackDamage = 7D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }*/
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected boolean canDespawn()
    {

     return true;
    }
    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {

        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);

        if (itemEntity != null) {
            itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }
    @Override
    public void die(DamageSource source) {
        super.die(source);
        dragonDeathTime = 0;
        }
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.WarpedFungussusHealthMultiplier.get());
        this.setPersistenceRequired();
    }




    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.LAVA))
            return false;

        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (source.is(DamageTypes.ON_FIRE))
            return false;


        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;







        return super.hurt(source, amount);
    }

    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;
    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.level() instanceof ServerLevel) {
            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);
            }
        }

        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
    private void stopAllOtherAnimations() {
        attackAnimationState.stop();
    }
}