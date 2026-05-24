package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SkeletosaurusEntity extends IAnimatedMiniBoss {
    private static final EntityDataAccessor<Boolean> SPEED =
            SynchedEntityData.defineId(SkeletosaurusEntity.class, EntityDataSerializers.BOOLEAN);

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    public SkeletosaurusEntity.Crackiness getCrackiness() {
        return SkeletosaurusEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    @Override
    public boolean fireImmune() {
        return true;
    }

    private void runawayMobs() {
        List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(30, 10, 30));
        for (LivingEntity e : list) {
            if (!isAlliedTo(e)) {
                if (e instanceof PathfinderMob mob && (!(mob instanceof TamableAnimal) || !((TamableAnimal) mob).isInSittingPose()) && e !=this) {
                    mob.setTarget(null);
                    mob.setLastHurtByMob(null);
                    if (mob.onGround()) {
                        Vec3 randomShake = new Vec3(random.nextFloat() - 0.5F, 0, random.nextFloat() - 0.5F).scale(0.1F);
                        mob.setDeltaMovement(mob.getDeltaMovement().multiply(0.7F, 1, 0.7F).add(randomShake));
                    }

                    mob.getNavigation().stop();

                    if (mob.getNavigation().isDone()) {
                        Vec3 vec = LandRandomPos.getPosAway(mob, 15, 7, this.position());
                        if (vec != null) {
                            mob.getNavigation().moveTo(vec.x, vec.y, vec.z, 2D);
                        }
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
    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<SkeletosaurusEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static SkeletosaurusEntity.Crackiness byFraction(float pFraction) {
            for (SkeletosaurusEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }




    private int walkAnimationTickCounter = 0;
    private static final int MESSAGE_INTERVAL = 15;

    public SkeletosaurusEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 10;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.refreshDimensions();
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private int speedDuration = 0;
    @Override
    public void tick() {

        super.tick();
        updateWithAttack();
        if(this.isSpeedy()){
            AttributeInstance attributeInstance = this.getAttribute(Attributes.MOVEMENT_SPEED);

            assert attributeInstance != null;
            attributeInstance.setBaseValue(0.15F);
        } else {
            AttributeInstance attributeInstance = this.getAttribute(Attributes.MOVEMENT_SPEED);

            assert attributeInstance != null;
            attributeInstance.setBaseValue(0.1F);
        }
        if(speedDuration <= 0){
            speedDuration = 0;
            this.isSpeed = false;
        }
        if (speedDuration > 0) {
            --speedDuration;
        }
        if (roarCooldown > 0) {
            --roarCooldown;
        }
        if (shockCooldown
                > 0) {
            --shockCooldown;
        }

        if (tailCooldown
                > 0) {
            --tailCooldown;
        }
        if (tailmCooldown
                > 0) {
            --tailmCooldown;
        }
       // updateAttributes();
        handleWalkingMessage();
    }

    private void handleWalkingMessage() {
        if (this.isMoving()) {
            walkAnimationTickCounter++;
            if (walkAnimationTickCounter >= MESSAGE_INTERVAL) {
                walkAnimationTickCounter = 0;
            }
        } else {
            walkAnimationTickCounter = 0;
        }
    }

    private boolean isMoving() {
        return this.getDeltaMovement().lengthSqr() > 0.01;
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPEED, false);

    }
    private int tailmCooldown = 0;
    private int roarCooldown = 0;
    private int shockCooldown = 0;
    private int tailCooldown = 0;
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 80, 80, 7.0F) {
            public boolean canUse() {
                return super.canUse() && SkeletosaurusEntity.this.getRandom().nextFloat() * 42.0F < 16.0F && SkeletosaurusEntity.this.shockCooldown <= 0
                        && SkeletosaurusEntity.this.getTarget() != null && !(SkeletosaurusEntity.this.getAttackState() == 8 )&& !(SkeletosaurusEntity.this.getAttackState() == 3)&& !(SkeletosaurusEntity.this.getAttackState() == 6);
            }
            @Override
            public void start(){
                if(SkeletosaurusEntity.this.getTarget() instanceof Player player && SkeletosaurusEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(SkeletosaurusEntity.this.getTarget() instanceof Player player && SkeletosaurusEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                SkeletosaurusEntity.this.shockCooldown = 100;

            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 50, 50, 7.0F) {
            public boolean canUse() {
                return super.canUse() && SkeletosaurusEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && SkeletosaurusEntity.this.tailCooldown <= 0  && (SkeletosaurusEntity.this.getCrackiness() == Crackiness.NONE || (SkeletosaurusEntity.this.getCrackiness() == Crackiness.LOW ) )
                        && SkeletosaurusEntity.this.getTarget() != null && !(SkeletosaurusEntity.this.getAttackState() == 6) && !(SkeletosaurusEntity.this.getAttackState() == 3) && !(SkeletosaurusEntity.this.getAttackState() == 8 );
            }
            @Override
            public void start(){
                if(SkeletosaurusEntity.this.getTarget() instanceof Player player && SkeletosaurusEntity.this.getTarget() != null){

                }
                super.start();
            }
            @Override
            public void tick(){
                if(SkeletosaurusEntity.this.getTarget() instanceof Player player && SkeletosaurusEntity.this.getTarget() != null){

                }
                super.tick();
            }
            public void stop() {
                super.stop();
                SkeletosaurusEntity.this.tailCooldown = 100;

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 8, 0, 48, 48, 7.0F){


            public void stop() {
                super.stop();
                SkeletosaurusEntity.this.tailmCooldown = 180;

            }

            public boolean canUse() {


            return super.canUse() && SkeletosaurusEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                    && SkeletosaurusEntity.this.getTarget() != null && !(SkeletosaurusEntity.this.getAttackState() == 6 ) && (SkeletosaurusEntity.this.getCrackiness() == Crackiness.HIGH || (SkeletosaurusEntity.this.getCrackiness() == Crackiness.MEDIUM )) &&  !(SkeletosaurusEntity.this.getAttackState() == 6 ) && SkeletosaurusEntity.this.tailmCooldown <= 0&& !(SkeletosaurusEntity.this.getAttackState() == 3 ) && !(SkeletosaurusEntity.this.getAttackState() == 7);
        }});

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 20, 20, 6.0F){

           public boolean canUse() {


                return super.canUse() && SkeletosaurusEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && SkeletosaurusEntity.this.getTarget() != null ;
            }});

        /*this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 104, 64, 4.0F) {
            @Override
            public void start(){
                Lava_eaterEntity.this.setInvulnerable(true);
                super.start();
            }

            public boolean canUse() {
                return super.canUse() && Lava_eaterEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && Lava_eaterEntity.this.bigsmashCooldown <= 0;
            }
            @Override
            public void stop() {
stopAllAnimationStates();
                super.stop();
                Lava_eaterEntity.this.setInvulnerable(false);
                Lava_eaterEntity.this.bigsmashCooldown = 360;
            }
        });*/
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 5, 0, 50, 64, 12.0F,9) {
            @Override
            public void start(){
                isSpeed = false;

                super.start();
            }

            public boolean canUse() {
                return super.canUse() && SkeletosaurusEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && SkeletosaurusEntity.this.roarCooldown <= 0 && !(SkeletosaurusEntity.this.getAttackState() == 6 )
                        && !(SkeletosaurusEntity.this.getAttackState() == 7) && !(SkeletosaurusEntity.this.getAttackState() == 3)





                        ;
            }
            @Override
            public void stop() {
                super.stop();
                isSpeed = true;
                SkeletosaurusEntity.this.speedDuration = 40;
                SkeletosaurusEntity.this.setInvulnerable(false);
                SkeletosaurusEntity.this.roarCooldown = 300;

            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 70, 0, 15));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.horizontalCollision && this.isInWall()) {
            // Odsuń entity od ściany
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1)); // Dodaj niewielki ruch w przeciwnym kierunku
        }
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 150D /*ModConfig.COMMON.SkeletosaurusHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 13D /*ModConfig.COMMON.SkeletosaurusDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(ModSounds.STEP_SOUND.get(), 1.0F, 1.0F);
        Vec3 entityPosition = this.position();
        CameraShakeEntity.cameraShake(this.level(), entityPosition, 10.0F, 0.05F, 0, 20);
    }

    public void performAreaAttack() {
        double attackRadius = 3.0;
        double attackHeight = 3.0;

        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);


        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && entity !=this.getTarget()) {
                if (!(entity instanceof CameraShakeEntity)) {
                    MobEffectInstance brokenArmorEffect = livingEntity.getEffect(ModEffects.BROKEN_ARMOR.get());
                    if (brokenArmorEffect != null) {
                        int currentLevel = brokenArmorEffect.getAmplifier();
                        if (currentLevel < 4) {
                            livingEntity.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, currentLevel + 1));
                        } else {
                            livingEntity.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 4));
                        }
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.BROKEN_ARMOR.get(), 60, 0));
                    }
                }

            }
        }
    }


    public void attackTargets(Entity entity1){
        //deal damage
        if(entity1 instanceof LivingEntity livingEntity ) {

            DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
            double damage = 9.5D * ModConfig.MOB_CONFIG.SkeletosaurusDamageMutliplier.get();
            if(this.level().getDifficulty() == Difficulty.HARD) {
                livingEntity.hurt(damageSource, (float) (damage - 2));

            } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                livingEntity.hurt(damageSource, (float) damage);

            } else if (this.level().getDifficulty() == Difficulty.EASY) {
                livingEntity.hurt(damageSource, (float) (damage + 9));

            }
        }
    }
    public boolean isSpeedy(){
        return isSpeed;
    }
    private boolean isSpeed = false;
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putBoolean("is_Sleep", isSleep());
        this.isSpeed = pCompound.getBoolean("isSpeed");
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {

        super.readAdditionalSaveData(compound);

        setSleep(compound.getBoolean("is_Sleep"));
        this.isSpeed = compound.getBoolean("isSpeed");
        if (this.getHealth() == this.getMaxHealth()) {
          //  updateAttributes();
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.SkeletosaurusHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.SkeletosaurusDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 200D; // podstawowe zdrowie moba
        double baseAttackDamage = 9.5D; // podstawowe obrażenia moba

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
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.SKELETOSAURUS_HURT3.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SKELETOSAURUS_DEATH.get();
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
        this.setAttackState(4);
        dragonDeathTime = 0;
    }
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.SkeletosaurusHealthMultiplier.get());
        this.setPersistenceRequired();
    }



    @Override
    public void baseTick() {
        super.baseTick();
        this.refreshDimensions();
    }
    public boolean isSleep() {
        return this.getAttackState() == 1;
    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //  this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }
    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.is(DamageTypes.ON_FIRE))
            return false;

        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;

        return super.hurt(source, amount);
    }

    @Override
    public boolean isPushable() {
        return true;
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



        if(this.dragonDeathTime == 20){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);

        }
        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState tailAnimationState = new AnimationState();
    public AnimationState tailmAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState biteAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState roarAnimationState = new AnimationState();
    public AnimationState shockwaveAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "biteattack") {
            return this.biteAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "roar") {
            return this.roarAnimationState;
        } else if (input == "shockwaves") {
            return this.shockwaveAnimationState;

        } else if (input == "tail") {
            return this.tailAnimationState;

        } else if (input == "tailm") {
            return this.tailmAnimationState;

        } else {
            return new AnimationState();
        }
    }
    private void ApplyEffects(float range, float height, float arc, int shieldbreakticks, int Duration) {
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
                if (!isAlliedTo(entityHit) && entityHit != this) {
                    if (!level().isClientSide) {
                        entityHit.addEffect(new MobEffectInstance(ModEffects.FEAR.get(), Duration, 0));
                    }
                    //entityHit.knockback(knockback,1,1);
                    if(!entityHit.isBlocking()) {
                        // entityHit.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2), this);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
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
                        this.biteAnimationState.startIfStopped(this.tickCount);
                    }

                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);

                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.roarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.shockwaveAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.tailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.tailmAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.tailAnimationState.stop();
        this.tailmAnimationState.stop();
        this.deathAnimationState.stop();
        this.shockwaveAnimationState.stop();
        this.roarAnimationState.stop();
        this.biteAnimationState.stop();
    }

    public void updateWithAttack(){
        if(this.getAttackState() == 6) {
            if (this.attackTicks == 12) {

                spawnCircleParticle(0.25f, -1,20,true,2f,1f,1f,1f,1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,2,1);
                Vec3 entityPoesition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 0, 20);
                if (this.getTarget() != null) {


                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                    }


                }
            }

            if (this.attackTicks == 13) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 11; ++k) {
                        float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                    }
                }}
            if (this.attackTicks == 16) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 14; ++k) {
                        float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                    }
                }}
            if (this.attackTicks == 19) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 19; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
            if (this.attackTicks == 21) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 26; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
            if (this.attackTicks == 37) {

                spawnCircleParticle(0.25f, -1,20,true,2f,1f,1f,1f,1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,2,1);
                Vec3 entityPoesition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 0, 20);
                if (this.getTarget() != null) {


                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                    }
                }


            }

            if (this.attackTicks == 40) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 11; ++k) {
                        float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                    }
                }}
            if (this.attackTicks == 43) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 14; ++k) {
                        float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                    }
                }}
            if (this.attackTicks == 46) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 19; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
            if (this.attackTicks == 49) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 26; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
            if (this.attackTicks == 62) {

                spawnCircleParticle(0.25f, -1,20,true,2f,1f,1f,1f,1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,2,1);
                Vec3 entityPoesition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 0, 20);
                if (this.getTarget() != null) {


                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                    }

                }


            }

            if (this.attackTicks == 65) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 11; ++k) {
                        float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                    }
                }}
            if (this.attackTicks == 68) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 14; ++k) {
                        float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                    }
                }}
            if (this.attackTicks == 71) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 19; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
            if (this.attackTicks == 74) {
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 26; ++k) {
                        float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                        this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                    }
                }}
        }
        if(this.getAttackState() == 7){
            if(this.attackTicks == 7){
                this.playSound(ModSounds.WEAPON_SPIN.get(),2,1F);
            }
            if(this.attackTicks == 16){
                this.AreaAttack(8.0F, 7.0F, 380.0F, 14.0F, 40, false,0, false, 0.75F, true);

            }
        }

        if(this.getAttackState() == 8){
            if(this.attackTicks == 7){
                this.playSound(ModSounds.WEAPON_SPIN.get(),2,1F);
            }
            if(this.attackTicks == 16){
                this.AreaAttack(8.0F, 7.0F, 380.0F, 14.0F, 40, false,0, false, 0.75F, true);

            }
            if(this.attackTicks == 33){
                this.playSound(ModSounds.WEAPON_SPIN.get(),2,1F);
            }
            if(this.attackTicks == 36){
                this.AreaAttack(8.0F, 7.0F, 380.0F, 14.0F, 40, false,0, false, 0.75F, true);

            }
        }
        if(this.getAttackState() == 3){
            if(this.attackTicks == 3){
                this.playSound(SoundEvents.EVOKER_FANGS_ATTACK,1,1);
            }
            if(this.attackTicks == 8){
                this.AreaAttack(8.0F, 5.0F, 380.0F, 9.0F, 40, false,0, false, 0.75F, false);

            }
        }
        if(this.getAttackState() == 5) {
            if (this.attackTicks == 1) {
                this.playSound(ModSounds.ANCIENT_GUARDIAN_ROAR.get(), 4, 0.75F);

            }
            if (attackTicks >1 &&attackTicks <10){
                runawayMobs();
            }

            if (this.attackTicks == 6) {

                this.ApplyEffects(16.0F, 10.0F, 360.0F, 0, 240);


            }
        }
            if(this.getAttackState() == 2){
                if (attackTicks >23 && attackTicks<33){
                    runawayMobs();
                }

                if (this.attackTicks ==23) {

                this.playSound(ModSounds.ANCIENT_GUARDIAN_ROAR.get(), 4, 0.75F);
                runawayMobs();
            }
            if(this.attackTicks == 45){

                this.ApplyEffects(16.0F, 10.0F, 360.0F, 0, 140);

            }
        }


    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }   
    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, float knockback,boolean BNknockback, float Lstrenght, boolean launch) {





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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof SkeletosaurusEntity) && entityHit != this) {


                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.SkeletosaurusDamageMutliplier.get()) ));
                    if (launch) {
                        this.playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(), 2, 1);
                        this.launch(entityHit, true);
                    }

                        if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                            disableShield(entityHit, shieldbreakticks);
                        }
                }
            }
        }
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
            this.level().addFreshEntity(new ShockwaveEntity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1,false,17));
        }
    }

}
