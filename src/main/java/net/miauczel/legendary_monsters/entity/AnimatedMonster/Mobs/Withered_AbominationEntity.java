package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.PartEntity.WitheredAbominationPartEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveEntity;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Withered_AbominationEntity extends IAnimatedMiniBoss {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Withered_AbominationEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DROPPEDHORN1 =
            SynchedEntityData.defineId(Withered_AbominationEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DROPPEDHORN2 =
            SynchedEntityData.defineId(Withered_AbominationEntity.class, EntityDataSerializers.BOOLEAN);
    public Withered_AbominationEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);


        xpReward = 100;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.head = new WitheredAbominationPartEntity(this, "head", 1.0F, 1.0F);
        this.subEntities = new WitheredAbominationPartEntity[]{this.head};
        this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    @Override
    public void setId(int pId) {
        super.setId(pId);
        for (int i = 0; i < this.subEntities.length; i++)
            this.subEntities[i].setId(pId + i + 1);
    }

    private final UUID uniqueID = UUID.randomUUID();

    public UUID getUniqueID() {
        return uniqueID;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Sleep", isSleep());
        compound.putBoolean("DroppedHorn1", this.entityData.get(DROPPEDHORN1));
        compound.putBoolean("DroppedHorn2", this.entityData.get(DROPPEDHORN2));
        compound.putInt("StunCooldown", this.stunCooldown);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setSleep(compound.getBoolean("is_Sleep"));
        this.entityData.set(DROPPEDHORN1, compound.getBoolean("DroppedHorn1"));
        this.entityData.set(DROPPEDHORN2, compound.getBoolean("DroppedHorn2"));
        this.stunCooldown = compound.getInt("StunCooldown");
        if (this.getHealth() == this.getMaxHealth()) {
         //   updateAttributes();
        }

    }

    public void performAreaAttack() {
        double attackRadius = 5.0;
        double attackHeight = 5.0;


        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.getTarget().level().getEntities(this, attackBox);


        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && !(entity == this.getTarget())) {
                if (!(entity instanceof CameraShakeEntity)) {
                    Vec3 entityPosition = livingEntity.position();
                    livingEntity.setDeltaMovement(new Vec3(0, 0.75, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 2));
                    this.doHurtTarget(livingEntity);
                }
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(DROPPEDHORN1, false);
        this.entityData.define(DROPPEDHORN2, false);
    }

    public boolean canStun() {
        return stunCooldown <= 0;
    }

    private int stunCooldown = 0;



    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    private int arm1attackCooldown = 0;
    private int arm2attackCooldown = 35;

    @Override
    public void tick() {
        super.tick();
        if(runcooldown > 0){
            --runcooldown;
        }
        if(smashCooldown > 0){
            --smashCooldown;
        }
        if (stunCooldown > 0) {
            --stunCooldown;
        }

        if (arm1attackCooldown > 0) {
            --arm1attackCooldown;
        }
        if (arm2attackCooldown > 0) {
            --arm2attackCooldown;
        }
        UpdateWithAttack();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }

        if (this.isDeadOrDying()) {
            this.tickDeath();
        }
        Withered_AbominationEntity.Crackiness crackiness = this.getCrackiness();

        if (crackiness == Withered_AbominationEntity.Crackiness.MEDIUM && !this.entityData.get(DROPPEDHORN1)) {
            playCrackSound();
            this.entityData.set(DROPPEDHORN1, true);
            ItemStack witheredHorn = new ItemStack(ModItems.WITHERED_HORN.get(), 1);
            this.LGspawnatlocation(witheredHorn);
        }
        if (crackiness == Withered_AbominationEntity.Crackiness.HIGH && !this.entityData.get(DROPPEDHORN2)) {
            playCrackSound();
            this.entityData.set(DROPPEDHORN2, true);
            ItemStack witheredHorn = new ItemStack(ModItems.WITHERED_HORN.get(), 1);
            this.LGspawnatlocation(witheredHorn);
        }



    }
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private void playCrackSound() {
        this.level().playSound(null, this.blockPosition(), SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 2.0f, 1.0f);
        this.level().playSound(null, this.blockPosition(), SoundEvents.ITEM_PICKUP, SoundSource.NEUTRAL, 15.0f, 1.0f);
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
    public boolean getCrackinessMedium(){
      return getCrackiness() == Crackiness.MEDIUM;
    }
    public boolean getCrackinessHigh(){
        return getCrackiness() == Crackiness.HIGH;
    }

    public Withered_AbominationEntity.Crackiness getCrackiness() {
        return Withered_AbominationEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }
public boolean isMediumCrackiness(){
        return getCrackiness() == Crackiness.MEDIUM;
}
    public boolean isHighCrackiness(){
        return getCrackiness() == Crackiness.HIGH;
    }
    public boolean isLowCrackiness(){
        return getCrackiness() == Crackiness.LOW;
    }
    public boolean isNoneCrackiness(){
        return getCrackiness() == Crackiness.NONE;
    }
    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<Withered_AbominationEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Withered_AbominationEntity.Crackiness byFraction(float pFraction) {
            for (Withered_AbominationEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }
    public WitheredAbominationPartEntity[] getSubEntities() {
        return this.subEntities;
    }

    private final WitheredAbominationPartEntity[] subEntities;

    @Override
    public boolean isMultipartEntity() {
        return false;
    }


    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    @org.jetbrains.annotations.Nullable


    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    @SubscribeEvent
    @Override

    public void aiStep() {
        super.aiStep();

        if (this.getAttackState() == 11) {
            if (attackTicks >= 0) {
                if (this.level().isClientSide) {
                    float g = (float) Math.toRadians(-getYRot() + 180);
                    double theta = (this.getYRot()) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int numberOfSkulls = 1;
                    float angleStep = 30.0f;
                    float angle = getYRot() + (5 - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                }
            }
        }

        if (this.getAttackState() == 11) {
            if (!this.level().isClientSide) {
                if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    this.destroy();
                }

                }
            }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 190D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 12D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 15D);
    }
    public void attackTargets(Entity entity1) {
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 14 * ModConfig.MOB_CONFIG.WitheredAbominationDamageMutliplier.get();

        //deal damage
        if (entity1 instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof Player || livingEntity instanceof ServerPlayer) {
                if (this.level().getDifficulty() == Difficulty.HARD) {
                    livingEntity.hurt(damageSource, (float) (damage - 5));

                } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    livingEntity.hurt(damageSource, (float) damage);

                } else if (this.level().getDifficulty() == Difficulty.EASY) {
                    livingEntity.hurt(damageSource, (float) (damage + 13));

                }
            }
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.WitheredAbominationHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.WitheredAbominationDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 190D; // podstawowe zdrowie moba
        double baseAttackDamage = 14D; // podstawowe obrażenia moba

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
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.WITHERED_ABOMINATION_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WITHERED_ABOMINATION_DEATH.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }


    private ItemStack getItemWithLootingEnchant(ItemStack stack, Entity killer) {
        if (killer instanceof Player) {
            int lootingLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.MOB_LOOTING, (LivingEntity) killer);

            if (lootingLevel > 0) {
                stack.grow(lootingLevel);
            }
        }
        return stack;
    }


    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.WitheredAbominationHealthMultiplier.get());
        this.setPersistenceRequired();
    }


    @Override
    public boolean isPushable() {
        return true; // Entity nie jest przesuwalne
    }


    public final WitheredAbominationPartEntity head;



    @Override
    public boolean fireImmune() {
        return true;
    }



private int runcooldown = 0;


    private int smashCooldown = 0;
public boolean shouldDoExtraDashes = true;

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, IronGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0));
      this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 35, 15, 5.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 3) && !(Withered_AbominationEntity.this.getAttackState() == 5)
                        && !(Withered_AbominationEntity.this.getAttackState() == 6)&& getNextSweepType() == 1;
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
           //Withered_AbominationEntity.this.arm2attackCooldown = 100;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 35, 15, 5.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 5) && !(Withered_AbominationEntity.this.getAttackState() == 4)
                        && !(Withered_AbominationEntity.this.getAttackState() == 6) && getNextSweepType() == 1;
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
             //   Withered_AbominationEntity.this.arm2attackCooldown = 100;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 14, 0, 40, 40, 5.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 3) && !(Withered_AbominationEntity.this.getAttackState() == 5)
                        && !(Withered_AbominationEntity.this.getAttackState() == 6)&& getNextSweepType() == 2;
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                //Withered_AbominationEntity.this.arm2attackCooldown = 100;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 13, 0, 40, 40, 5.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 5) && !(Withered_AbominationEntity.this.getAttackState() == 4)
                        && !(Withered_AbominationEntity.this.getAttackState() == 6) && getNextSweepType() == 2;
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                //   Withered_AbominationEntity.this.arm2attackCooldown = 100;

            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 35, 15, 6.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Withered_AbominationEntity.this.smashCooldown <= 0
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 3) && !(Withered_AbominationEntity.this.getAttackState() == 4)
                        && !(Withered_AbominationEntity.this.getAttackState() == 5);
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                Withered_AbominationEntity.this.smashCooldown = 40;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 47, 15, 6.0F) {

            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Withered_AbominationEntity.this.arm2attackCooldown <= 0
                        && Withered_AbominationEntity.this.getTarget() != null && !(Withered_AbominationEntity.this.getAttackState() == 3) && !(Withered_AbominationEntity.this.getAttackState() == 4)
                        && !(Withered_AbominationEntity.this.getAttackState() == 6);
            }
            @Override
            public void start(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(Withered_AbominationEntity.this.getTarget() instanceof Player player && Withered_AbominationEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                randomizeAllAttackTypes();
                 Withered_AbominationEntity.this.arm2attackCooldown = 100;

            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 10, 11, 20, 100){
            @Override
            public void start() {
                super.start();
                if (Withered_AbominationEntity.this.timesToUseDash > 0) {
                    Withered_AbominationEntity.this.timesToUseDash--;
                }
            }

            @Override
            public boolean canUse() {
                boolean originalCanUse = super.canUse();
                boolean hasAnyDashLeft = (Withered_AbominationEntity.this.timesToUseDash > 0);

                var target = Withered_AbominationEntity.this.getTarget();
                boolean isTargetFarEnough = (target != null && Withered_AbominationEntity.this.distanceTo(target) >= 5);

                return originalCanUse && hasAnyDashLeft && isTargetFarEnough;
            }

        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 10, 11, 7, 6, 15.0F,2F) {
            public boolean canUse() {
                return super.canUse() && Withered_AbominationEntity.this.getRandom().nextFloat() * 100.0F < 9.0F && Withered_AbominationEntity.this.runcooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Withered_AbominationEntity.this.setTimesToUseDashBasedOnCrackiness();
            }
            @Override
            public void start() {
                shouldDoExtraDashes = true;
                super.start();
            }
        });

        this.goalSelector.addGoal(1, new IStateGoal(this, 11, 11, 12, 20, 0) {
            public void tick() {
                if (this.entity.onGround()) {

                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * 0.017453292F;
                    Vec3 vector3d1 = (new Vec3((double)(-Mth.sin(f)), this.entity.getDeltaMovement().y, (double)Mth.cos(f))).scale(0.5).add(vector3d.scale(0.65));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }

            }
        });
        this.goalSelector.addGoal(0, new IAttackGoal(this, 11, 12, 0, 30, 40, 3.25F) {
            public void stop() {
                super.stop();

                Withered_AbominationEntity.this.runcooldown = 40;
            }
        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 0, 30, 40) {
            public void stop() {
                super.stop();
randomizeAllAttackTypes();
               Withered_AbominationEntity.this.runcooldown = 40;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });
        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 25, 0, 15.0F));
    }
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //   this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }
    private int timesToUseDash = 0;


    public void setTimesToUseDashBasedOnCrackiness() {
        switch (getCrackiness()) {
            case HIGH -> timesToUseDash = 2;
            case MEDIUM -> timesToUseDash = 1;
            default -> timesToUseDash = 0;
        }
    }

    public int ChargeCount = 0;

    public AnimationState sweepComboLeftAnimationState = new AnimationState();

    public AnimationState sweepComboRightAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState attackstunAnimationState = new AnimationState();
    public AnimationState attackComboAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState runAnimationState = new AnimationState();
    public AnimationState runpreAnimationState = new AnimationState();
    public AnimationState postRunAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {

        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "attackarm1") {
            return this.attackarm1AnimationState;
        } else if (input == "attackarm2") {
            return this.attackarm2AnimationState;
        } else if (input == "attackarms") {
            return this.attackarmsAnimationState;
        } else if (input == "attackstun") {
            return this.attackstunAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "attackcombo") {
            return this.attackComboAnimationState;
        } else if (input == "run") {
            return this.runAnimationState;
        }else if (input == "runpre") {
            return this.runpreAnimationState;
        }else if (input == "postrun") {
            return this.postRunAnimationState;
        }
        else if (input == "sweepcomboright") {
            return this.sweepComboRightAnimationState;
        }
        else if (input == "sweepcomboleft") {
            return this.sweepComboLeftAnimationState;
        }
        else {
            return new AnimationState();
        }
    }
    public int nextSweepType = 1;
    public void randomizeAllAttackTypes(){
        getRandomSweepAnimation(2);
    }
    public int getNextSweepType(){
        return nextSweepType;
    }
    public void getRandomSweepAnimation(int rolls){
        if (isNoneCrackiness()){
            nextSweepType = 1;
        } else if (isLowCrackiness() || isHighCrackiness() ||isMediumCrackiness()) {
            switch (random.nextInt(rolls)){
                case 0->{
                    nextSweepType = 1;
                }
                case 1->{
                    nextSweepType = 2;
                }
            }
        }

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
                        this.attackarm1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackarm2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.attackarmsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.attackstunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.attackComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.postRunAnimationState.startIfStopped(this.tickCount);
                    }case 11 -> {
                        this.stopAllAnimationStates();
                        this.runAnimationState.startIfStopped(this.tickCount);
                    }case 10 -> {
                        this.stopAllAnimationStates();
                        this.runpreAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.sweepComboLeftAnimationState.startIfStopped(this.tickCount);
                    }case 14 -> {
                        this.stopAllAnimationStates();
                        this.sweepComboRightAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.attackstunAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.attackComboAnimationState.stop();
        this.deathAnimationState.stop();

        this.sweepComboRightAnimationState.stop();
        this.sweepComboLeftAnimationState.stop();
        this.postRunAnimationState.stop();
        this.runAnimationState.stop();
        this.runpreAnimationState.stop();
    }
    private int abominationDeathTime;
    @Override
    public void die(DamageSource p_21014_) {
        this.abominationDeathTime = 0;
        super.die(p_21014_);
        this.setAttackState(8);
    }

    public int deathtimer() {
        return 60;
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (source.is(DamageTypes.ON_FIRE))
            return false;
        if (source.is(DamageTypes.LAVA))
            return false;
        if (source.is(DamageTypes.HOT_FLOOR))
            return false;


        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;


        if (source.is(DamageTypes.WITHER))
            return false;

        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        return super.hurt(source, amount);
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    private void spawnShockwaves(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this;
            this.level().addFreshEntity(new ShockwaveEntity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1,true,17));
        }
    }

    public void UpdateWithAttack() {
        float sweepRange = 4.5f;
        float sweepDamage = 16.5F;
        if (this.getAttackState() == 13) {
            if (attackTicks == 8){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 13) {
                this.AreaAttack(sweepRange, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,false);



            }
            if (attackTicks == 20){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 25) {
                this.AreaAttack(sweepRange+0.1f, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,true);



            }
        }
        if (this.getAttackState() == 14) {
            if (attackTicks == 8){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 13) {
                this.AreaAttack(sweepRange, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,false);



            }
            if (attackTicks == 20){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 25) {
                this.AreaAttack(sweepRange+0.1f, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,true);



            }
        }
        if (this.getAttackState() == 3) {
            if (attackTicks == 8){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 13) {
                this.AreaAttack(sweepRange, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,true);



            }
        }
        if (this.getAttackState() == 4) {
            if (attackTicks == 8){

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if (this.attackTicks == 13) {
                this.AreaAttack(sweepRange, 6.0F, 150F, sweepDamage, 100, false, 5,false,0.25F,true);



            }
        }
        //Attack
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 24) {
                this.AreaAttack(7F, 6.0F, 160.0F, 21.0F, 140, false, 5,false,0.75F,true);

                spawnCircleParticle(3.5f, 0f,30,true,0.8f,1f,1,1f,1);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                if (this.getTarget() != null) {


                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                    }


                }
            }

            if (this.attackTicks == 27) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 11; ++k) {
                        float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                    }
                }}
            if (this.attackTicks == 30) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 14; ++k) {
                        float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                    }
                }}
            if (this.attackTicks == 33) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 19; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }

            }
            }

        if(this.getAttackState() == 12){
            if(this.attackTicks == 3){
                this.AreaAttack(6.0F, 4.0F, 120.0F, 15.0F, 120, false, 1,false,0.75F,true);

            }}
        if(this.getAttackState() == 8){
            if(this.attackTicks == 20){
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

            }
            if(this.attackTicks == 20){

            }
        }
        //AttackStun
        if (this.getAttackState() == 6) {
            if(this.attackTicks == 16){
                if (this.onGround()) {

                    LivingEntity target = this.getTarget();

                    if(this.getTarget() != null) {
                        assert target != null;
                        double distanceToTarget =
                                this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                        if (distanceToTarget > 16) {

                            Vec3 vector3d = this.getDeltaMovement();
                            float f = this.getYRot() * (float) (Math.PI / 180.0);
                            Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(1.8).add(vector3d.scale(1.5));
                            this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                        }
                    }}
                }
            if (this.attackTicks == 22) {
                this.AreaAttack(6.0F, 4.0F, 180.0F, 15.0F, 60, false, 1,false,0.75F,true);




            }
        }

        //AttackCombo
        if (this.getAttackState() == 9) {
            if (this.attackTicks == 17) {
                this.AreaAttack(6.0F, 4.0F, 60.0F, 10.0F, 30, false, 5,false,0.4F,true);

                Vec3 entityPosition = this.position();

                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);

            }
            if (this.attackTicks == 50) {
                this.AreaAttack(6.0F, 4.0F, 60.0F, 10.0F, 30, false, 5,false,0.4F,true);
                this.Makeparticle(0.5F, 9.0F, 1.2F);
                Vec3 entityPosition = this.position();

                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
            }
            if(this.attackTicks == 57){
                this.playSound(ModSounds.WITHERED_ABOMINATION_DASH2.get(),15,1);
            }
            if(this.attackTicks == 60){
                if(!(this.getTarget() instanceof Player) && this.getTarget() != null){
                    DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
                    this.getTarget().hurt(damageSource,16);
                }
                if (this.onGround()) {
                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(1.5).add(vector3d.scale(1.3));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
            if (this.attackTicks == 66) {

                this.AreaAttack(4.0F, 4.0F, 60.0F, 14.0F, 60, true, 1,true,0.75F,false);
                this.Makeparticle(0.5F, 9.0F, 1.2F);






            }
        }

    }

    private void destroy() {
        if (!this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return;
        }
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5, 0.2, 0.5);
        Iterator var3 = BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ)).iterator();

        while(true) {
            while(true) {
                BlockPos blockpos;
                BlockState blockstate;
                do {

                        do {
                            do {
                                if (!var3.hasNext()) {
                                    return;
                                }

                                blockpos = (BlockPos)var3.next();
                                blockstate = this.level().getBlockState(blockpos);
                            } while(blockstate.isAir());
                        } while(!blockstate.canEntityDestroy(this.level(), blockpos, this));

                } while(!ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate));

                if (this.random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
          } else {
                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                }
            }
        }
    }
    private void Makeparticle(float size, float vec, float math) {
        if (!this.level().isClientSide) {
            for (int i1 = 0; i1 < 80 + random.nextInt(6); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = size * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = size * Mth.cos(angle);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    ((ServerLevel) this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 1, DeltaMovementX, DeltaMovementY, DeltaMovementZ, 0);
                }
            }
        }
    }


    public void launch(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? 2.0F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier,  0.35, deltaZ / distanceSquared * (double) multiplier);}

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, int knockback,boolean BNknockback, float Lstrenght, boolean launch) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Withered_AbominationEntity) && entityHit != this) {

                    boolean hurt =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.WitheredAbominationDamageMutliplier.get()) ));
                    if (!entityHit.isBlocking()) {

                        if (hurt){
                        if (launch){
                            if (getAttackState() !=13 || getAttackState() !=14) {
                                this.launch(entityHit, true);
                            }
                            if (getAttackState() ==13 || getAttackState() ==14) {
                                this.launch(entityHit, true);
                            }

                            if (this.getAttackState() == 12) {this.launch(entityHit,true);
                         //       entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 80, 0), this);
                                       }
                        }
                        }

                        if (hurt) {
                            if (getAttackState() ==4||getAttackState() ==3||getAttackState() ==14||getAttackState() ==13){

                                playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 0.5f);
                            }
                            entityHit.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 1), this);
                        }
                    }


                    //entityHit.knockback(knockback,1,1);

                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
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
    protected void tickDeath() {
        ++this.abominationDeathTime;


        if(this.abominationDeathTime == 35){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);

        }
        if (this.abominationDeathTime == 100 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}


