package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.PoisonousShockwave;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Overgrown_colossusEntity extends IAnimatedMiniBoss {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Overgrown_colossusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RAGE =
            SynchedEntityData.defineId(Overgrown_colossusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SPAWNED_ENTITIES =
            SynchedEntityData.defineId(Overgrown_colossusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SPAWNED_ENTITIES2 =
            SynchedEntityData.defineId(Overgrown_colossusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(Overgrown_colossusEntity.class, EntityDataSerializers.INT);
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    public boolean WantsToStun() {
        return this.getTextureVariant() == 1;
    }
    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }
    public Overgrown_colossusEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 100;
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

    public void performAreaAttack() {
        double attackRadius = 4.0;
        double attackHeight = 3.0;


        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.getTarget().level().getEntities(this, attackBox);


        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this  && !(entity instanceof MossyGolemEntity) && entity != this.getTarget()) {
                if (!(entity instanceof CameraShakeEntity)) {

                    if (!livingEntity.isBlocking()){
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 2));
                    }

                }
            }
        }
    }
    public Overgrown_colossusEntity.Crackiness getCrackiness() {
        return Overgrown_colossusEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<Overgrown_colossusEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double)p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Overgrown_colossusEntity.Crackiness byFraction(float pFraction) {
            for (Overgrown_colossusEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }




    public void attackTargets(Entity entity1){
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 14 * ModConfig.MOB_CONFIG.OvergrownColosussDamageMutliplier.get();


        if(entity1 instanceof LivingEntity livingEntity  ) {
            if(livingEntity instanceof Player || livingEntity instanceof  ServerPlayer) {
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
    public boolean canStun() {
        return stunCooldown <= 0;
    }

    protected BodyRotationControl createBodyControl()  {
        return new EntityRotationPatcher(this);
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(TEXTURE_VARIANT, 0);
        this.entityData.define(RAGE, false);
        this.entityData.define(SPAWNED_ENTITIES, false);
        this.entityData.define(SPAWNED_ENTITIES2, false);
    }
    public void resetSmashCooldown(){
        if(smashCooldown <=0) {
            this.smashCooldown = SMASH_COOLDOWN;
        }
    }
    private int teleportCooldown = 0;
    private int smashCooldown = 0;
    private final int SMASH_COOLDOWN = 160;
    public void resetSmash2Cooldown(){
        if(bigsmash2Cooldown <=0) {
            this.bigsmash2Cooldown = SMASH_ANCHOR2_COOLDOWN;
        }
    }
    public int bigsmashCooldown = 0;
    public final int SMASH_ANCHOR_COOLDOWN = 160;
    public final int SMASH_ANCHOR2_COOLDOWN = 100;

    public final int CHARGE_COOLDOWN = 160;
    public int bigsmash2Cooldown = 0;

    public int chargeCooldown = 0;

    @Override
    public void tick() {

        super.tick();
if (tickCount %25 == 0){
    this.heal(1);
}
        if(smashCooldown > 0){
            --smashCooldown;
        }
        if(chargeCooldown > 0){
            --chargeCooldown;
        }
        if (teleportCooldown > 0) {
            --teleportCooldown;
        }
        if(bigsmashCooldown > 0){
            --bigsmashCooldown;
        }
        if(bigsmash2Cooldown > 0){
            --bigsmash2Cooldown;
        }
    }

    private void launchMini(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? 1.2F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.3 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }
    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 9, 0, 44, 44, 3.75F) {
            public boolean canUse() {
                return super.canUse() && Overgrown_colossusEntity.this.getRandom().nextFloat() * 25.0F < 16.0F && Overgrown_colossusEntity.this.bigsmash2Cooldown <= 0
                        && Overgrown_colossusEntity.this.getTarget() != null;
            }

            public void stop() {
                super.stop();
                resetSmash2Cooldown();

            }
        });
        //chargePrepare
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 13, 0, 37, 37, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Overgrown_colossusEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && Overgrown_colossusEntity.this.smashCooldown <= 0
                        && Overgrown_colossusEntity.this.getTarget() != null;
            }

            public void stop() {
                super.stop();
                resetSmashCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 46, 75, 5.0F));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 85, 100, 8.0F) {
            @Override
            public void start(){

                super.start();
            }

            public boolean canUse() {
                return super.canUse() && Overgrown_colossusEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && Overgrown_colossusEntity.this.teleportCooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Overgrown_colossusEntity.this.setInvulnerable(false);
                Overgrown_colossusEntity.this.teleportCooldown = 160;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15
        ));
        this.goalSelector.addGoal(0, new IAttackGoal(this, 0, 10, 11, 20, 20, 15
        ){
            @Override
            public void start() {
                super.start();

            }

            public boolean canUse() {
                return super.canUse() && Overgrown_colossusEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && chargeCooldown <=0 ;
            }

        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 11, 11, 12, 25, 100){
            @Override
            public void start() {
                super.start();

            }

            @Override
            public void stop() {
                PoisonousShockwave entity2 = new PoisonousShockwave(ModEntities.POISONOUS_SHOCKWAVE.get(),level());
                entity2.setCaster(Overgrown_colossusEntity.this);
                entity2.setRadius(6);
                entity2.setDamage(4);
                entity2.setCanHealOwner(false);
                entity2.setLifeTicks(60);
                entity2.setPos(getX(),getY(),getZ());
               // level().addFreshEntity(entity2);
                super.stop();
            }

            public void tick() {
                if (this.entity.onGround()) {

                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * 0.017453292F;
                    Vec3 vector3d1 = (new Vec3((double)(-Mth.sin(f)), this.entity.getDeltaMovement().y, (double)Mth.cos(f))).scale(0.45).add(vector3d.scale(0.6));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }

            }


        });
        this.goalSelector.addGoal(0, new IStateGoal(this, 12, 12, 0, 20, 100){
            @Override
            public void start() {
                super.start();

            }


            @Override
            public void stop() {
                chargeCooldown = CHARGE_COOLDOWN;
                super.stop();
            }
        });
    }



    private void destroy() {
        if (!this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return;
        }
        if (level().isClientSide()){
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
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 6) {
            if (this.attackTicks ==17) {


                spawnCircleParticle(3.5f, 1.5f,16,true,1f,0.9f,1,0.9f,1);
                spawnCircleParticle(3.5f, -1.5f,16,true,1f,0.9f,1,0.9f,1);
            }}
        updateWithAttack();
        if (this.horizontalCollision && this.isInWall()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 170D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .add(Attributes.ATTACK_DAMAGE, 14D);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.OVERGROWN_COLOSSUS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.OVERGROWN_COLOSSUS_DEATH.get();
    }

    protected boolean canDespawn() {
        this.setPersistenceRequired();
        return true;
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
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
        colossusDeathTime = 0;
        this.setAttackState(8);
    }
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.OvergrownColosussHealthMultiplier.get());
        this.setPersistenceRequired();
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (source.is(DamageTypes.MAGIC))
            return false;
        if (ModConfig.MOB_CONFIG.Overgrownprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }


        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;

        return super.hurt(source, amount);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putBoolean("is_Sleep", isSleep());
        compound.putInt("TextureVariant", this.getTextureVariant());
        compound.putInt("StunCooldown", this.stunCooldown);

    }
    private static final int STUN_COOLDOWN_DURATION = 160;
    private int stunCooldown = 0;

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        setSleep(compound.getBoolean("is_Sleep"));
        this.stunCooldown = compound.getInt("StunCooldown");
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));
        this.entityData.set(RAGE, compound.getBoolean("rage"));
        this.entityData.set(SPAWNED_ENTITIES, compound.getBoolean("SpawnedEntities"));
        this.entityData.set(SPAWNED_ENTITIES2, compound.getBoolean("SpawnedEntities2"));
        if (this.getHealth() == this.getMaxHealth()) {
           // updateAttributes();
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.OvergrownColosussHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.OvergrownColosussDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 190D;
        double baseAttackDamage = 14D;

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


    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState chargestartAnimationState = new AnimationState();
    public AnimationState upperCutAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState attackPoisonCloudAnimationState = new AnimationState();
    public AnimationState attackComboAnimationState = new AnimationState();

    public AnimationState slashAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

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
        } else if (input == "attackpoison") {
            return this.attackPoisonCloudAnimationState;
        } else if (input == "attackcombo") {
            return this.attackComboAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        }
        else if (input == "uppercut") {
            return this.upperCutAnimationState;
        }
        else if (input == "chargeend") {
            return this.chargeendAnimationState;
        }
        else if (input == "charge") {
            return this.chargeAnimationState;
        }
        else if (input == "chargestart") {
            return this.chargestartAnimationState;
        }
        else if (input == "slash") {
            return this.slashAnimationState;
        }
        else {
            return new AnimationState();
        }
    }
    public int deathtimer() {
        return 60;
    }
    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
      //  this.setSleep(true);
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
                        this.attackarm1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackarm2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.attackPoisonCloudAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.attackarmsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.attackComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.upperCutAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.chargestartAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.chargeendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.slashAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        upperCutAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.attackPoisonCloudAnimationState.stop();
        this.attackComboAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.deathAnimationState.stop();
        chargeAnimationState.stop();
        chargestartAnimationState.stop();
        chargeendAnimationState.stop();
        slashAnimationState.stop();
    }
    private void dash(float a1,float a2,float minD){
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if(this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }}
    }


    @Override
    public boolean canCollideWith(Entity entity) {
        return true;
    }

    private void updateWithAttack(){
        if (this.getAttackState() == 13) {
            if (this.attackTicks == 15) {

                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
if (attackTicks == 18) {
    this.AreaAttack(5F, 5F, 180F, 15.0F, 120, false, 0.75F, false, 0.75F, true);
} }
        if(this.getAttackState() == 11){
            if (attackTicks <= 3) {
                if (this.getTarget() !=null)  lookAt(this.getTarget(),90,90);

            }
            if (!this.level().isClientSide) {

                    this.destroy();

            }
if (tickCount % 5 ==0){

    Vec3 entityPosition = this.position();
    CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.075F, 0, 20);
    playSound(ModSounds.STEP_SOUND.get());
    PoisonousShockwave entity2 = new PoisonousShockwave(ModEntities.POISONOUS_SHOCKWAVE.get(),this.level());
    entity2.setCaster(this);
    entity2.setRadius(3);
    entity2.setDamage(4);
    entity2.setCanHealOwner(false);
    entity2.setLifeTicks(60);
    entity2.setPos(this.getX(),this.getY(),this.getZ());
    level().addFreshEntity(entity2);
}
           AreaAttack(2.5f,4,360f,10,100,false,0,false,0,false);
        }
        if(this.getAttackState() == 9){
            if (!this.level().isClientSide) {

                this.destroy();
            } else if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                this.destroy();
            }
            if(this.attackTicks == 17){
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
                dash(1.1f,1.1f,4);

            }
            if(this.attackTicks == 20){
                this.AreaAttack(4.75F, 5F, 120F, 15F, 100, false, 1F, false, 0F, true);

            }
        }



        if(this.getAttackState() == 8){
            if(this.attackTicks == 32){
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

            }
        }

        if(!(this.getAttackState() == 8)) {

            if (this.getAttackState() == 3) {
                if (this.attackTicks == 17) {
                    this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                    if (this.getTarget() != null) {

                        this.AreaAttack(5.5F, 5F, 150F, 12F, 40, false, 1F, false, 0F, true);
                    }
                }
            }
            if (this.getAttackState() == 4) {
                if (this.attackTicks == 17) {
                    this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                    if (this.getTarget() != null) {

                        this.AreaAttack(5.5F, 5F, 150F, 12F, 40, false, 1F, false, 0F, true);
                    }
                }
            }

            if (this.getAttackState() == 5) {




                 if (this.attackTicks == 14) {
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

                if (this.attackTicks == 17) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 11; ++k) {
                            float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                        }
                    }}
                if (this.attackTicks == 20) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 14; ++k) {
                            float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                        }
                    }}

                if (this.attackTicks == 23) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 19; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}
                if (this.attackTicks == 26) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 26; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}
                if (this.attackTicks == 42) {
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

                if (this.attackTicks == 45) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 11; ++k) {
                            float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                        }
                    }}
                if (this.attackTicks == 48) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 14; ++k) {
                            float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                        }
                    }}
                if (this.attackTicks == 51) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 19; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}
                if (this.attackTicks == 54) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 26; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}
                if (this.attackTicks == 70) {
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

                if (this.attackTicks == 73) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 11; ++k) {
                            float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                        }
                    }}
                if (this.attackTicks == 76) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 14; ++k) {
                            float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);
                        }
                    }}
                if (this.attackTicks == 79) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 19; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 5.5D, this.getZ() + (double) Mth.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}
                if (this.attackTicks == 81) {
                    if (this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 26; ++k) {
                            float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                            this.spawnShockwaves(this.getX() + (double) Mth.cos(f5) * 6.5D, this.getZ() + (double) Mth.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 0);
                        }
                    }}

            }



            if (this.getAttackState() == 6) {
                if (this.attackTicks == 12) {

                    this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
                }
                if (this.attackTicks == 17) {
                    if (this.getTarget() != null) {
                        if (Math.random() > 0.5F) {
                          //  this.spawnPoisonCloud(this.getTarget().level(), this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 1F, 40);
                        }
                    }
                    Vec3 entityPosition = this.position();
                    CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

                    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);

                    this.AreaAttack(6.25F, 6F, 180F, 16.0F, 120, false, 0.75F, false, 0.75F, true);
                }
    }
        }
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Overgrown_colossusEntity) && !(entityHit instanceof MossyGolemEntity) && entityHit != this) {
                    if (!stun) {
                        if (!entityHit.isBlocking() && Math.random() > 0.5) {


                        }
                    }

                    boolean hurt = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.OvergrownColosussDamageMutliplier.get())));

                    if (this.getAttackState() == 4 || this.getAttackState() == 3) {
                        if (this.attackTicks == 20) {
                            if (BNknockback && !entityHit.isBlocking()) {
                                double knockbackRadius = 5.0;

                                double dx = entityHit.getX() - this.getX();
                                double dz = entityHit.getZ() - this.getZ();
                                double distance = Math.sqrt(dx * dx + dz * dz);
                                double knockbackStrength = knockback + 0.5 * (knockbackRadius - distance); // Siła odrzucenia maleje z odległością
                                entityHit.push(dx / distance * knockbackStrength, 0.4, dz / distance * knockbackStrength);
                            }

                            Vec3 entityPosition = this.position();
                            CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                        }
                    }

                    if (hurt) {
                        if (getAttackState() == 11){
                            launchMini(entityHit,true);
                        }
                        if (getAttackState() == 9 || getAttackState() ==13) {

                            playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 0.5f);
                        }
                        if (getAttackState() != 11) {
                            this.launch(entityHit, true);
                        }
                    }

                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }
    public int colossusDeathTime;
    @Override
    protected void tickDeath() {
        ++this.colossusDeathTime;
        if (this.level() instanceof ServerLevel) {
            if (this.colossusDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);

            }
        }



        if(this.colossusDeathTime == 25){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);
        }
        if (this.colossusDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
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
            this.level().addFreshEntity(new PoisonousShockwave(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1,6,1,7));
        }
    }
}
