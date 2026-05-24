package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.IceSpikeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.item.ModItems;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
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

public class Frostbitten_GolemEntity extends IAnimatedMiniBoss {
    private static final EntityDataAccessor<Boolean> DROPPEDICE1 =
            SynchedEntityData.defineId(Frostbitten_GolemEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DROPPEDICE2 =
            SynchedEntityData.defineId(Frostbitten_GolemEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LASERED =
            SynchedEntityData.defineId(Frostbitten_GolemEntity.class, EntityDataSerializers.BOOLEAN);
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    public Frostbitten_GolemEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 100;
        this.refreshDimensions();
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();




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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this;
            this.level().addFreshEntity(new IceSpikeEntity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1));
        }
    }
    private void strikeFire(int ice, double time,float distance) {
        for(int i = 0; i < ice; ++i) {
            float throwAngle = (float)i * 3.1415927F / (float)(ice / 2);

            for(int k = 0; k < distance; ++k) {
                double d2 = 1.15 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnFire(this.getX() + (double) Mth.cos(throwAngle) * 1.25 * d2, this.getZ() + (double)Mth.sin(throwAngle) * 1.25 * d2, this.getY(), this.getY() + 2.0, throwAngle, d3);
            }
        }

    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
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
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);


        compound.putBoolean("is_Sleep", isSleep());
        compound.putBoolean("DroppedIce1", this.entityData.get(DROPPEDICE1));
        compound.putBoolean("DroppedIce2", this.entityData.get(DROPPEDICE2));
        compound.putBoolean("lasered", this.entityData.get(LASERED));
    }
    public void attackTargets(Entity entity1){
        DamageSource damageSource = new DamageSource(level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
        double damage = 14F * ModConfig.MOB_CONFIG.FrostbittenGolemDamageMutliplier.get();

        if(entity1 instanceof LivingEntity livingEntity ) {

            if(this.level().getDifficulty() == Difficulty.HARD) {
                livingEntity.hurt(damageSource, (float) (damage - 4));

            } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                livingEntity.hurt(damageSource, (float) damage);

            } else if (this.level().getDifficulty() == Difficulty.EASY) {
                livingEntity.hurt(damageSource, (float) (damage + 13));

            }
        }
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        setSleep(compound.getBoolean("is_Sleep"));
        this.entityData.set(DROPPEDICE1, compound.getBoolean("DroppedIce1"));
        this.entityData.set(DROPPEDICE2, compound.getBoolean("DroppedIce2"));
        this.entityData.set(LASERED, compound.getBoolean("lasered"));
        if (this.getHealth() == this.getMaxHealth()) {
          //  updateAttributes();
        }
    }

    @Override

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DROPPEDICE1, false);
        this.entityData.define(DROPPEDICE2, false);
        this.entityData.define(LASERED, false);
    }
    public void resetSmashAnchorCooldown(){
        if(bigsmashCooldown <=0) {
            this.bigsmashCooldown = SMASH_ANCHOR_COOLDOWN;
        }
    }
    public void resetSmash2Cooldown(){
        if(bigsmash2Cooldown <=0) {
            this.bigsmash2Cooldown = SMASH_ANCHOR2_COOLDOWN;
        }
    }
    public void resetSmashCooldown(){
        if(smashCooldown <=0) {
            this.smashCooldown = SMASH_COOLDOWN;
        }
    }
    private int teleportCooldown = 0;
    private int smashCooldown = 0;
    private final int SMASH_COOLDOWN = 160;
    public int bigsmashCooldown = 0;
    public final int SMASH_ANCHOR_COOLDOWN = 160;
    public final int SMASH_ANCHOR2_COOLDOWN = 100;
    public int bigsmash2Cooldown = 0;

    @Override
    public void tick() {
        super.tick();
        this.updateWithAttack();
        if(smashCooldown > 0){
            --smashCooldown;
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

        Crackiness crackiness = this.getCrackiness();

        if (crackiness == Crackiness.MEDIUM && !this.entityData.get(DROPPEDICE1)) {
            playCrackSound();
            this.entityData.set(DROPPEDICE1, true);
            ItemStack primalIceShard = new ItemStack(ModItems.PRIMAL_ICE_SHARD.get(), 1);
            this.LGspawnatlocation(primalIceShard);
        }
        if (crackiness == Crackiness.HIGH && !this.entityData.get(DROPPEDICE2)) {
            playCrackSound();
            this.entityData.set(DROPPEDICE2, true);
            ItemStack primalIceShard = new ItemStack(ModItems.PRIMAL_ICE_SHARD.get(), 1);
            this.LGspawnatlocation(primalIceShard);
        }

      //  updateAttributes();

        if (this.level().isClientSide()) {

        }
    }

    private void playCrackSound() {
        this.level().playSound(null, this.blockPosition(), SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.NEUTRAL, 3.0f, 1.0f);
        this.level().playSound(null, this.blockPosition(), SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 2.0f, 1.0f);
        this.level().playSound(null, this.blockPosition(), SoundEvents.ITEM_PICKUP, SoundSource.NEUTRAL, 15.0f, 1.0f);
    }

    public Crackiness getCrackiness() {
        return Frostbitten_GolemEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public static enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<Frostbitten_GolemEntity.Crackiness> BY_DAMAGE = Stream.of(values())
                .sorted(Comparator.comparingDouble((p_28904_) -> p_28904_.fraction))
                .collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Frostbitten_GolemEntity.Crackiness byFraction(float pFraction) {
            for (Frostbitten_GolemEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }
    public void performAreaAttack() {
        double attackRadius = 4.0;
        double attackHeight = 3.0;

        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);


        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity && entity != this && !(entity == this.getTarget())) {
                if (!(entity instanceof CameraShakeEntity)) {

                    this.doHurtTarget(livingEntity);
                }
            }
        }
    }
    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {

        pStack.addTagElement("Enchantments", new ListTag());

        ItemEntity itemEntity = this.spawnAtLocation(pStack, 3F);

        if (itemEntity != null) {
            itemEntity.setGlowingTag(true);
        }

        return itemEntity;
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
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Lava_eaterEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 7, 0, 35, 10, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Frostbitten_GolemEntity.this.getRandom().nextFloat() * 45.0F < 16.0F && Frostbitten_GolemEntity.this.bigsmashCooldown <= 0
                        && Frostbitten_GolemEntity.this.getTarget() != null && !(Frostbitten_GolemEntity.this.getAttackState() ==9);
            }

            public void stop() {
                super.stop();
                resetSmashAnchorCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 46, 10, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Frostbitten_GolemEntity.this.getRandom().nextFloat() * 25.0F < 16.0F && Frostbitten_GolemEntity.this.bigsmash2Cooldown <= 0
                        && Frostbitten_GolemEntity.this.getTarget() != null && !(Frostbitten_GolemEntity.this.getAttackState() ==9);
            }

            public void stop() {
                super.stop();
                resetSmash2Cooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 46, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Frostbitten_GolemEntity.this.getRandom().nextFloat() * 35.0F < 16.0F && Frostbitten_GolemEntity.this.smashCooldown <= 0
                        && Frostbitten_GolemEntity.this.getTarget() != null && !(Frostbitten_GolemEntity.this.getAttackState() ==9);
            }

            public void stop() {
                super.stop();
                resetSmashCooldown();

            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 46, 75, 5.0F));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 46, 30, 12.0F) {
            @Override
            public void start(){

                super.start();
            }

            public boolean canUse() {
                return super.canUse() && Frostbitten_GolemEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && Frostbitten_GolemEntity.this.teleportCooldown <= 0 && !(Frostbitten_GolemEntity.this.getAttackState() ==9);
            }
            @Override
            public void stop() {
                super.stop();
                Frostbitten_GolemEntity.this.setInvulnerable(false);
                Frostbitten_GolemEntity.this.teleportCooldown = 60;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15){
            public boolean canUse() {
                return super.canUse() && !(Frostbitten_GolemEntity.this.getAttackState() ==9);
            }
        });
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isDeadOrDying()) {
            this.setYRot(0.0F);
            this.setXRot(0.0F);
            this.yBodyRot = 90.0F;
            this.yHeadRot = 0.0F;

            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 1.0, 1.0));
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
                .add(Attributes.MAX_HEALTH, 220D/*ModConfig.COMMON.FrostbittenGolemHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 16D/*ModConfig.COMMON.FrostbittenGolemDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }



/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.FrostbittenGolemHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.FrostbittenGolemDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 180D; // podstawowe zdrowie moba
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
    }*/


    @Nullable


    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.OVERGROWN_COLOSSUS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.OVERGROWN_COLOSSUS_DEATH.get();
    }

    protected boolean canDespawn()
    {
        this.setPersistenceRequired();
        return true;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        golemDeathTIme = 0;
        this.setAttackState(8);
        this.yBodyRot = 0.0F;
        this.yHeadRot = 0.0F;
        this.setYRot(0.0F);
        this.setXRot(0.0F);
        ItemStack diamond = new ItemStack(ModItems.FROZEN_RUNE.get(), 1);
        ItemStack emerald = new ItemStack(Items.AIR, 1);


        emerald = this.getItemWithLootingEnchant(emerald, source.getEntity());


        this.spawnAtLocation(emerald);
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

        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.FrostbittenGolemHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (ModConfig.MOB_CONFIG.Frostbittenprojectile.get()) {
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


    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState iceSpikeSummonAnimationState = new AnimationState();
    public AnimationState aggresiveIceSpikeSummonAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState laserAnimationState = new AnimationState();

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
        } else if (input == "attackicespike") {
            return this.iceSpikeSummonAnimationState;
        } else if (input == "attackaggresive") {
            return this.aggresiveIceSpikeSummonAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "laser") {
            return this.laserAnimationState;
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
                        this.attackarm1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackarm2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.iceSpikeSummonAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.attackarmsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.aggresiveIceSpikeSummonAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.laserAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.iceSpikeSummonAnimationState.stop();
        this.aggresiveIceSpikeSummonAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.deathAnimationState.stop();
        this.laserAnimationState.stop();
    }

    private void launchMini(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.001);
        float multiplier = huge ? 1.2F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.3 : 0.2, deltaZ / distanceSquared * (double) multiplier);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Frostbitten_GolemEntity) && !(entityHit instanceof MossyGolemEntity) && entityHit != this) {
                    if(!stun) {
                        if(!entityHit.isBlocking() && Math.random() > 0.5) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),40,5));

                        }
                    }

                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FrostbittenGolemDamageMutliplier.get()) ));

                    if(this.getAttackState() == 4 || this.getAttackState() == 3) {
                        if (this.attackTicks == 20) {
                            if(BNknockback && !entityHit.isBlocking()) {
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
                    if(launch){
                        if(this.getAttackState() == 6 || this.getAttackState() == 7) {
                            this.launch(entityHit, true);

                        }
                        if(this.getAttackState() == 4) {
                            this.launchMini(entityHit, true);
                        }
                        if(this.getAttackState() == 3) {
                            this.launchMini(entityHit, true);
                        }
                        //entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));
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
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }
    public void updateWithAttack() {


        if(this.getAttackState() == 3){
            if(this.attackTicks == 16){
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(),1,1);
                this.AreaAttack(6F, 5F, 150F, 12.0F, 40, false, 0.5F,true,0.25F,true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
        }
        if(this.getAttackState() == 4){
            if(this.attackTicks == 16){
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(),1,1);
                this.AreaAttack(6F, 5F, 150F, 12.0F, 40, false, 0.5F,true,0.25F,true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);

            }
        }

        if(this.getAttackState() == 6){
            if(this.attackTicks == 18){

                spawnCircleParticle(3f, 0f,20,true,2f,0.25f,0.5f,1f,1);
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(),1,1);
                this.AreaAttack(7.0F, 6F, 170.0F, 13.0F, 100, false, 0.5F,true,0.25F,true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);


            }
            if (this.attackTicks == 28){
                Frostbitten_GolemEntity.Crackiness crackiness = this.getCrackiness();
                if(crackiness == Crackiness.MEDIUM ){
                if(this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getY());
                    for (int k = 0; k < 6; ++k) {
                        float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnIceSpikesAdvanced(this.getTarget().getX() + (double) Mth.cos(f2) * 2.5D, this.getTarget().getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getTarget().getY() + 1, f2, 0);
                    }
                    for (int k = 0; k < 11; ++k) {
                        float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnIceSpikesAdvanced(this.getTarget().getX() + (double) Mth.cos(f3) * 3.5D, this.getTarget().getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getTarget().getY() + 1, f3, 2);
                    }
                }
                }
                if( crackiness == Crackiness.HIGH){
                    if(this.getTarget() != null) {
                        int standingOnY = Mth.floor(this.getY());
                        for (int k = 0; k < 6; ++k) {
                            float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                            this.spawnIceSpikesAdvanced(this.getTarget().getX() + (double) Mth.cos(f2) * 2.5D, this.getTarget().getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getTarget().getY() + 1, f2, 0);
                        }
                        for (int k = 0; k < 11; ++k) {
                            float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                            this.spawnIceSpikesAdvanced(this.getTarget().getX() + (double) Mth.cos(f3) * 3.5D, this.getTarget().getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getTarget().getY() + 1, f3, 2);
                        }
                        for (int k = 0; k < 14; ++k) {
                            float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                            this.spawnIceSpikesAdvanced(this.getTarget().getX() + (double) Mth.cos(f4) * 4.5D, this.getTarget().getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getTarget().getY() + 1, f4, 4);
                        }

                    }
                }
            }

        }
        if(this.getAttackState() == 7){
            if(this.attackTicks == 12) {
                int standingOnY = Mth.floor(this.getY());
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                this.AreaAttack(4.5F, 5.0F, 100.0F, 13.0F, 80, false, 0.5F, true, 0.25F, true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                Frostbitten_GolemEntity.Crackiness crackiness = this.getCrackiness();
                this.getCrackiness();
                if (crackiness == Crackiness.LOW || crackiness == Crackiness.MEDIUM || crackiness == Crackiness.NONE || crackiness == Crackiness.HIGH) {
                    spawnCircleParticle(1.5f, 0f,15,true,2f,0.25f,0.25f,1f,1);
                    strikeFire(19,2,8);
                }
            }
        }

        if(this.getAttackState() == 5){
            if(this.attackTicks == 14) {
                if (this.getTarget() != null) {
                    this.spawnIceSpikes();

                    Frostbitten_GolemEntity.Crackiness crackiness = this.getCrackiness();
                    this.getCrackiness();
                    if (crackiness == Crackiness.HIGH){
                        strikeFire(7,1,6);
                    }

                }}
        }
    }
    private void createSpellEntity(double pX, double pZ, double pMinY, double pMaxY, float pYRot, int pWarmupDelay) {
        BlockPos blockpos = BlockPos.containing(pX, pMaxY, pZ);
        boolean flag = false;
        double d0 = 0.0;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = Frostbitten_GolemEntity.this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(Frostbitten_GolemEntity.this.level(), blockpos1, Direction.UP)) {
                if (!Frostbitten_GolemEntity.this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = Frostbitten_GolemEntity.this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(Frostbitten_GolemEntity.this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(pMinY) - 1);

        if (flag) {
            this.level().addFreshEntity(new IceSpikeEntity(this.level(), pX, (double)blockpos.getY() + d0, pZ, pYRot, pWarmupDelay, this));
        }

    }



    private void spawnLowIceSpikes() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            for (int k = 0; k < 8; ++k) {
                this.createSpellEntity(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 10);
            }
            for (int k = 0; k < 8; ++k) {
                this.createSpellEntity(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 5);
            }


        }
    }

    private void spawnIceSpikes() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 2D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            float f4 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (-0.5F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.1F);
            float f5 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (-1.1F);
            for(int l = 0; l < 10; ++l) {
                double d2 = 1.25D * (double)(l + 1);
                double d3 = -1.25D * (double)(l + 1);
                int j = (int) (1.25f * l);
                this.createSpellEntity(this.getX() + f2 + (double)Mth.cos(f) * d2, this.getZ() + f3 + (double)Mth.sin(f) * d2, d0, d1, f, j);
                this.createSpellEntity(this.getX() - f2 + (double)Mth.cos(f) * d2, this.getZ() - f3 + (double)Mth.sin(f) * d2, d0, d1, f, j);

            }


        }

    }
    private void spawnIceSpikesAdvanced(double x, double z, double minY, double maxY, float rotation, int delay) {

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
            this.level().addFreshEntity(new IceSpikeEntity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, entity1));
        }
    }

    public int golemDeathTIme;
    @Override
    protected void tickDeath() {
        ++this.golemDeathTIme;

        if (this.level() instanceof ServerLevel) {
            if (this.golemDeathTIme > 1 && !this.isSilent()) {
                this.setNoAi(true);

            }
        }



        if(this.golemDeathTIme == 25){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);

        }
        if (this.golemDeathTIme == 60 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}