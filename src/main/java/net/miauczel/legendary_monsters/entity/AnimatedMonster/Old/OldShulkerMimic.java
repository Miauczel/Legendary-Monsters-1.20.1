package net.miauczel.legendary_monsters.entity.AnimatedMonster.Old;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.ai.Shulker_MimicAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.entity.projectile.AbstractArrow;
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

public class OldShulkerMimic extends Monster implements IForgeEntity {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Shulker_MimicEntity.class, EntityDataSerializers.BOOLEAN);
    public OldShulkerMimic(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 20;
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();




        }

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
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    public void performAreaAttack() {
        double attackRadius = 2.0;
        double attackHeight = 2.0;

        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && !(entity == this.getTarget())) {
                if (getTarget() != null) {
                    if (!(entity instanceof CameraShakeEntity)) {
                        if (Math.random() < 0.75f) {
                            Shulker_MimicEntity.Crackiness crackiness = getCrackiness();
                            if (crackiness == Shulker_MimicEntity.Crackiness.MEDIUM) {
                                livingEntity.addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 60, 4));
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 3));
                            } else {
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 2));
                            }
                            if (crackiness == Shulker_MimicEntity.Crackiness.HIGH) {
                                livingEntity.addEffect(new MobEffectInstance(ModEffects.GRAVITY_PULL.get(), 60, 5));
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 10));
                            } else {
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 2));
                            }

                        }
                        this.doHurtTarget(livingEntity);
                    }
                }
            }
        }
    }
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private boolean hasPlayedCrackSound = false;
    private boolean hasPlayedCrackSound1 = false;
    private boolean hasPlayedCrackSound2 = false;
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
    public void tick() {
        super.tick();
        if (DeathAnimationState.isStarted()) {
            DeathAnimationTimeout--;
            if (DeathAnimationTimeout <= 0) {
                DeathAnimationState.stop();
            }
        }
        Shulker_MimicEntity.Crackiness crackiness = this.getCrackiness();
        if (crackiness == Shulker_MimicEntity.Crackiness.LOW && !hasPlayedCrackSound2 ) {
            SoundEvent cracksound = SoundEvents.SHULKER_HURT;

            hasPlayedCrackSound2 = true;

            this.level().playSound(null, this.blockPosition(), cracksound, SoundSource.NEUTRAL, 2.0f, 1.0f);





        }
        if (crackiness == Shulker_MimicEntity.Crackiness.MEDIUM && !hasPlayedCrackSound1) {

            SoundEvent cracksound2 = SoundEvents.SHULKER_HURT;

            hasPlayedCrackSound1 = true;

            this.level().playSound(null, this.blockPosition(), cracksound2, SoundSource.NEUTRAL, 2.0f, 1.0f);



        }
        if (crackiness == Shulker_MimicEntity.Crackiness.HIGH && !hasPlayedCrackSound ) {
            SoundEvent cracksound = SoundEvents.SHULKER_HURT;

            hasPlayedCrackSound = true;

            this.level().playSound(null, this.blockPosition(), cracksound, SoundSource.NEUTRAL, 2.0f, 1.0f);





        }
        //updateAttributes();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
    public Shulker_MimicEntity.Crackiness getCrackiness() {
        return Shulker_MimicEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }
    public static enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<OldShulkerMimic.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double)p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static OldShulkerMimic.Crackiness byFraction(float pFraction) {
            for(OldShulkerMimic.Crackiness shulkermimic$crackiness : BY_DAMAGE) {
                if (pFraction < shulkermimic$crackiness.fraction) {
                    return shulkermimic$crackiness;
                }
            }

            return NONE;
        }
    }
    private void setupAnimationStates() {
        if(DeathAnimationTimeout >= 60) {
            if (this.dragonDeathTime > 0 && !DeathAnimationState.isStarted()) {
                DeathAnimationState.start(this.tickCount);
                --this.DeathAnimationTimeout;
                stopAllOtherAnimations();

            }

            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }

            if (this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationTimeout = 23;
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
        this.goalSelector.addGoal(1, new Shulker_MimicAttackGoal(this, 3D, true));

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
        if (this.horizontalCollision && this.isInWall()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
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
                .add(Attributes.MAX_HEALTH, 150D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 12D);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
           // updateAttributes();
        }
    }
    public void attackTargets(Entity entity1){
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 13D * ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get();
        if(entity1 instanceof LivingEntity livingEntity ) {
                livingEntity.hurt(damageSource,(float) damage);
        }
    }
    /*public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.ShulkerMimicHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.ShulkerMimicDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 180D;
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


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {return SoundEvents.SHULKER_AMBIENT;}


    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SHULKER_HURT_CLOSED;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SHULKER_DEATH;
    }

    protected boolean canDespawn()
    {
        this.setPersistenceRequired();
        return true;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.ShulkerMimicHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }



    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (ModConfig.MOB_CONFIG.Shulkerprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }

        if (source.is(DamageTypes.FALL))
            return false;

        if (source.is(DamageTypes.TRIDENT))
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
