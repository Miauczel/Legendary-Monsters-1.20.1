package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold;

import com.google.common.collect.ImmutableList;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveSpawner;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
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

public class Ancient_GuardianEntity extends IAnimatedMiniBoss {
    private static final EntityDataAccessor<Boolean> GRABBING =
            SynchedEntityData.defineId(Ancient_GuardianEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    private static final EntityDataAccessor<Integer> PARTICLE_TICKS =
            SynchedEntityData.defineId(Ancient_GuardianEntity.class, EntityDataSerializers.INT);

    public Ancient_GuardianEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 100;
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();


        }

    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
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


    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public Ancient_GuardianEntity.Crackiness getCrackiness() {
        return Ancient_GuardianEntity.Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public enum Crackiness {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private static final List<Ancient_GuardianEntity.Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        public final float fraction;

        private Crackiness(float pFraction) {
            this.fraction = pFraction;
        }

        public static Ancient_GuardianEntity.Crackiness byFraction(float pFraction) {
            for (Ancient_GuardianEntity.Crackiness crackiness : BY_DAMAGE) {
                if (pFraction < crackiness.fraction) {
                    return crackiness;
                }
            }
            return NONE;
        }
    }


    public boolean canStun() {
        return stunCooldown <= 0;
    }
    private int stunCooldown = 0;

    private void sendActionBarMessageToPlayer(Player player, String message) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.literal(message)));
        }
    }

    public void resetSmashCooldown() {
        if (smashCooldown <= 0) {
            this.smashCooldown = SMASH_COOLDOWN;
        }
    }

    private int smashCooldown = 0;
    private final int SMASH_COOLDOWN = 100;

    public void resetSmashAnchorCooldown() {
        if (smashAnchorCooldown <= 0) {
            this.smashAnchorCooldown = SMASH_ANCHOR_COOLDOWN;
        }
    }

    private int smashAnchorCooldown = 0;
    private final int SMASH_ANCHOR_COOLDOWN = 60;
    @Override
    public void tick() {
        if (entityData.get(PARTICLE_TICKS) >= 0) {
            entityData.set(PARTICLE_TICKS, entityData.get(PARTICLE_TICKS) + 1);
        }
        if (this.getAttackState() != 7) {
            this.setInvulnerable(false);
        }
        if (this.getCrackiness() == Crackiness.MEDIUM && !this.getRoar()) {
            //this.setAttackState(7);
            this.entityData.set(ROAR, true);

        }
        Vec3 b = new Vec3(this.getX(), k, this.getZ());
        if (this.getAttackState() == 8) {
            // Ustaw ruch poziomy na 0
        }
        if (smashCooldown > 0) {
            --smashCooldown;
        }
        if (stunCooldown > 0) {
            --stunCooldown;
        }
        if (smashAnchorCooldown > 0) {
            --smashAnchorCooldown;
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if ((this.getCrackiness() == Crackiness.MEDIUM || this.getCrackiness() == Crackiness.HIGH) && this.getAttribute(Attributes.ARMOR).getBaseValue() == 13.0) {
            this.getAttribute(Attributes.ARMOR).setBaseValue(20.0);
        }
        this.UpdateWithAttack();
        super.tick();

        if (this.getTarget() instanceof Player pPlayer && this.getTarget() != null) {
            if (stunCooldown == 0) {
                //sendActionBarMessageToPlayer(pPlayer, "Overgrown Colosuss is ready to stun!");
                //System.out.println("Overgrown Colosuss is ready to stun!");
                this.entityData.set(TEXTURE_VARIANT, 1);
            } else {
                this.entityData.set(TEXTURE_VARIANT, 0);
            }
        }

        if (stunCooldown > 0) {

            stunCooldown--;
        }
      //  updateAttributes();
        if (this.level().isClientSide()) {
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putBoolean("Attacking", this.isAttacking());
        compound.putBoolean("is_Sleep", isSleep());
        compound.putInt("TextureVariant", this.getTextureVariant());
        compound.putInt("StunCooldown", this.stunCooldown);
        compound.putBoolean("roar", this.getRoar());
    }


    public void setAttacking(boolean attacking) {
        this.entityData.set(GRABBING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(GRABBING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(PARTICLE_TICKS, 0);
        this.entityData.define(GRABBING, false);
        this.entityData.define(ROAR, false);
        this.entityData.define(TEXTURE_VARIANT, 0);
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private boolean isScary;

    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Cloud_GolemEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 15, 16, 20, 10, 6.5F, 5) {

            public boolean canUse() {
                return super.canUse() && Ancient_GuardianEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Ancient_GuardianEntity.this.stunCooldown <= 0
                        && Ancient_GuardianEntity.this.getTarget() != null && !(Ancient_GuardianEntity.this.getAttackState() == 3);
            }
        });

        //jump idle
        this.goalSelector.addGoal(1, new IStateGoal(this, 16, 16, 17, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new IStateGoal(this, 17, 17, 0, 20, 0) {
            public void start() {
                super.start();
                Ancient_GuardianEntity.this.entityData.set(PARTICLE_TICKS, 0);
            }

            @Override
            public void stop() {
                super.stop();
                Ancient_GuardianEntity.this.stunCooldown = 200;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 48, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && Ancient_GuardianEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && Ancient_GuardianEntity.this.smashAnchorCooldown <= 0
                        && Ancient_GuardianEntity.this.getTarget() != null && !(Ancient_GuardianEntity.this.getAttackState() == 3) && !(Ancient_GuardianEntity.this.smashCooldown <= 0);
            }

            @Override
            public void start() {
                if (Ancient_GuardianEntity.this.getTarget() instanceof Player player && Ancient_GuardianEntity.this.getTarget() != null) {
                    sendActionBarMessageToPlayer(player, "§cAncient Guardian is preparing a Stun Attack!");
                }
                super.start();
            }

            @Override
            public void tick() {
                if (Ancient_GuardianEntity.this.getTarget() instanceof Player player && Ancient_GuardianEntity.this.getTarget() != null) {
                    sendActionBarMessageToPlayer(player, "§cAncient Guardian is preparing a Stun Attack!");
                }
                super.tick();
            }

            public void stop() {
                super.stop();
                resetSmashAnchorCooldown();

            }
        });

        //chargePrepare
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 78, 15, 6.0F) {
            public boolean canUse() {
                return super.canUse() && Ancient_GuardianEntity.this.getRandom().nextFloat() * 100.0F < 16.0F && Ancient_GuardianEntity.this.smashCooldown <= 0
                        && Ancient_GuardianEntity.this.getTarget() != null && !(Ancient_GuardianEntity.this.getAttackState() == 4);
            }

            public void stop() {
                super.stop();
                resetSmashCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 90, 64, 5.0F) {
            @Override
            public void start() {
                Ancient_GuardianEntity.this.entityData.set(PARTICLE_TICKS, 0);
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse()
                        ;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 8, 8, 0, 75, 0) {
                    public void start() {
                        super.start();
                        Ancient_GuardianEntity.this.entityData.set(PARTICLE_TICKS, 0);
                    }

                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15));
    }
    private void destroy() {
        if (!this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return;
        }
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5, 0.5, 0.5);
        Iterator var3 = BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ)).iterator();

        while (true) {
            while (true) {
                BlockPos blockpos;
                BlockState blockstate;
                do {

                    do {
                        do {
                            if (!var3.hasNext()) {
                                return;
                            }

                            blockpos = (BlockPos) var3.next();
                            blockstate = this.level().getBlockState(blockpos);
                        } while (blockstate.isAir());
                    } while (!blockstate.canEntityDestroy(this.level(), blockpos, this));

                } while (!ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate));

                if (this.random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
                } else {
                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                }
            }
        }
    }

    public void attackParticle() {

            if (attackTicks == 1){
                entityData.set(PARTICLE_TICKS,1);
            }
            if (level().isClientSide) {

        }
        if (getAttackState() == 17) {
            if (entityData.get(PARTICLE_TICKS) == 2) {
                if (this.level().isClientSide) {
                    Ancient_GuardianEntity.this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 85, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.1f, getZ(), 0, 0, 0);
                }
            }
        }
        if (getAttackState() == 6) {
            if (entityData.get(PARTICLE_TICKS) == 68) {
                float radius = 2F;
                float angle = (0.01745329251F * this.yBodyRot);
                double extraX = radius * Mth.sin((float) (Math.PI + angle)) - 0.5;
                double extraZ = radius * Mth.cos(angle) + 0.5 * Mth.sin(angle);
                if (this.level().isClientSide) {
                    Ancient_GuardianEntity.this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 1, 1, 1, 1.0f, 50, false, Circle.EnumRingBehavior.GROW), getX() + extraX, getY() + 0.1f, getZ()+extraZ, 0, 0, 0);
                }
            }
        }
    }
    @Override
    public void aiStep() {
        super.aiStep();
        attackParticle();
        if (this.getAttackState() == 16) {
            destroy();
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks >= 36 && this.attackTicks <= 41) {
                this.destroy();

                if (!this.level().isClientSide) {

                } else if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    this.destroy();
                }
            }
        }
        if (this.horizontalCollision && this.isInWall()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
        LivingEntity target = this.getTarget();
        if (this.isAttacking()) {
            // this.performAreaAttack();
        }
        if (target != null) {
            double targetX = target.getX() - this.getX();
            double targetY = target.getEyeY() - this.getEyeY();
            double targetZ = target.getZ() - this.getZ();
            double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

            float yaw = (float) (Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
            float pitch = (float) (-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

            this.yHeadRot = this.yBodyRot = yaw;
            this.yBodyRot = pitch;
        }


        if (target != null) {
            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.1) {
                movementSpeedAttribute.setBaseValue(0.1);
            }
        } else {
            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.0) {
                movementSpeedAttribute.setBaseValue(0.0);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 170D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 13D)
                .add(Attributes.MOVEMENT_SPEED, 0.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 20D);
    }

    @Nullable


    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ANCIENT_GUARDIAN_HURT.get();
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
        this.setAttackState(5);
    }
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.AncientGuardianHealthMutliplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        if (this.getAttackState() == 8){return false;}else {
            return true;
        }
    }
    private boolean hasPlayerHurtSound;
    @Override
    public boolean hurt(DamageSource source, float amount) {
        ;
        if (this.getCrackiness() == Crackiness.MEDIUM && hasPlayerHurtSound) {
            this.playSound(SoundEvents.TURTLE_EGG_BREAK, 2.0F, 1.0F);
            hasPlayerHurtSound = true;
        }
        if (ModConfig.MOB_CONFIG.Ancientprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }

        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;

        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        return super.hurt(source, amount);





    }
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(ModSounds.STEP_SOUND.get(), 1.0F, 1.0F);

    }
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(Ancient_GuardianEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ROAR =
            SynchedEntityData.defineId(Ancient_GuardianEntity.class, EntityDataSerializers.BOOLEAN);
    public boolean WantsToStun() {

        return this.getTextureVariant() == 1;
    }
    public boolean getRoar() {
        return this.entityData.get(ROAR);
    }
    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.stunCooldown = compound.getInt("StunCooldown");

        this.entityData.set(GRABBING, compound.getBoolean("Attacking"));
        setSleep(compound.getBoolean("is_Sleep"));
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));
        this.entityData.set(ROAR, compound.getBoolean("roar"));
        super.readAdditionalSaveData(compound);

        if (this.getHealth() == this.getMaxHealth()) {
         //   updateAttributes();
        }
    }
    @Override
    public void setDeltaMovement(Vec3 movement) {
        if (this.getAttackState() != 8) {
           super.setDeltaMovement(movement);
        }
    }
    /*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.AncientGuardianHealthMutliplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.AncientGuardianDamageMultiplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 200D; // podstawowe zdrowie moba
        double baseAttackDamage = 20D; // podstawowe obrażenia moba

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
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState attackstunAnimationState = new AnimationState();
    public AnimationState attackComboAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState roarAnimationState = new AnimationState();
    public AnimationState grabAnimationState = new AnimationState();
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
        } else if (input == "attackarmright") {
            return this.attackarm1AnimationState;
        } else if (input == "attackarmleft") {
            return this.attackarm2AnimationState;
        } else if (input == "attackarms") {
            return this.attackarmsAnimationState;
        } else if (input == "attackstun") {
            return this.attackstunAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "attackcombo") {
            return this.attackComboAnimationState;
        } else if (input == "roar") {
            return this.roarAnimationState;
        }
        else if (input == "grab") {
            return this.grabAnimationState;
        }
        else if (input == "run") {
            return this.runAnimationState;
        }else if (input == "runpre") {
            return this.runpreAnimationState;
        }else if (input == "postrun") {
            return this.postRunAnimationState;
        }
        else {
            return new AnimationState();
        }
    }
    @Override
    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {

            super.positionRider(passenger, moveFunc);

    }

    public boolean shouldRiderSit() {
        return false;
    }

    public boolean canRiderInteract() {
        return true;
    }
    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
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
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.attackComboAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.roarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();

                        this.grabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.postRunAnimationState.startIfStopped(this.tickCount);
                    }case 16 -> {
                        this.stopAllAnimationStates();
                        this.runAnimationState.startIfStopped(this.tickCount);
                    }case 15 -> {
                        this.stopAllAnimationStates();
                        this.runpreAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {

        this.grabAnimationState.stop();
        this.postRunAnimationState.stop();
        this.runAnimationState.stop();
        this.runpreAnimationState.stop();
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.attackstunAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.attackComboAnimationState.stop();
        this.deathAnimationState.stop();
        this.roarAnimationState.stop();
    }
    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ancient_GuardianEntity) && entityHit != this) {

                   boolean hurt =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.AncientGuardianDamageMultiplier.get()) ));
                    if(this.getAttackState() == 4) {

                        this.playSound(SoundEvents.ANVIL_PLACE,1,0.5F);
                        if (hurt) {
                            this.launch(entityHit, true);
                        }
                        if(entityHit instanceof Player && !entityHit.isBlocking()) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 40, 0));
                        }else if (!(entityHit instanceof Player)){
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 80, 0));
                        }

                    }
                    if(this.getAttackState() == 17) {

if (hurt) {
    this.launch(entityHit, true);
}

                    }
                    if(this.getAttackState() == 4) {
                        if (this.attackTicks == 20) {

                            this.playSound(ModSounds.ANCHOR_HIT.get(), 1, 1);

                        }
                    }


                    if(this.getAttackState() == 3) {
                        if (this.attackTicks == 20) {if (this.getTarget() != null) {
                            if (this.getTarget() instanceof Player) {
                                if (!this.getTarget().isBlocking())
                                    if (hurt) {
                                        this.setAttackState(8);
                                        stopAllAnimationStates();
                                        this.entityData.set(GRABBING, true);
                                    }
                            } else {
//this.getTarget().startRiding(this);
                                if (!this.getTarget().isBlocking() && !this.isPassenger()) {
                                    if (hurt) {
                                        this.setAttackState(8);
                                        stopAllAnimationStates();
                                        this.entityData.set(GRABBING, true);
                                    }
                                }
                            }
                        }
                            if (entityHit == this.getTarget()){
                               // this.getTarget().startRiding(this);

                            }
                            if(BNknockback && !entityHit.isBlocking()) {
                                double knockbackRadius = 5.0;

                                double dx = entityHit.getX() - this.getX();
                                double dz = entityHit.getZ() - this.getZ();
                                double distance = Math.sqrt(dx * dx + dz * dz);
                                double knockbackStrength = knockback + 0.5 * (knockbackRadius - distance); // Siła odrzucenia maleje z odległością
                             //  entityHit.push(dx / distance * knockbackStrength, 0.4, dz / distance * knockbackStrength);
                               }
                            this.playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(), 1, 1);
                            Vec3 entityPosition = this.position();
          //                  CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                        }
                    }
                    if(this.getAttackState() == 6) {
                        this.playSound(ModSounds.ANCHOR_HIT.get(), 1, 1);
                        if(this.attackTicks == 18) {
                            Vec3 entityPosition = this.position();
        //                    CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                        }

                        if(this.attackTicks == 41) {
                            this.playSound(ModSounds.ANCHOR_HIT.get(), 1, 1);
                            Vec3 entityPosition = this.position();
                           // CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                            if (stun && !entityHit.isBlocking()) {
                                entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 40, 0), this);
                            }
                        }
                        if(this.attackTicks == 68) {
                            Vec3 entityPosition = this.position();
                            CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.15F, 0, 20);
                            if (hurt) {
                                this.launch(entityHit, true);
                            }


                        }
                    }
                    if(launch){
                        entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));
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
            Entity entity1 = this;
            this.level().addFreshEntity(new ShockwaveSpawner(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay,this,false));
        }
    }
int k;
    public void UpdateWithAttack() {
        if(this.getAttackState() ==15){
            if(this.attackTicks == 17){
                LivingEntity target =this.getTarget();

                if (target != null) {
                    double distanceToTarget =
                            this.distanceToSqr(target.getX(), target.getY(), target.getZ());

                    this.getLookControl().setLookAt(target, 60.0F, 30.0F);
                    Vec3 vec3 = (new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())).normalize();
                    this.setDeltaMovement(this.getDeltaMovement().add(vec3.x * 0.9D, 1, vec3.z * 0.9D));}
            } else {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0F, 0.0D, 0.0F));
                //  this.playSound(ModSounds.ANCIENT_GUARDIAN_ROAR.get(), 2, 1);
            }}
        if(this.getAttackState()== 16){
            if (this.onGround() || !this.getFeetBlockState().getFluidState().isEmpty()) {
                this.setAttackState(17);
            }}
        if(this.getAttackState() ==17){

            if (this.attackTicks == 2) {
                if(this.isScary) {
                  //  this.ApplyEffects(10.0F, 4.0F, 200.0F, 0, 300);
                } else {
                 //   this.ApplyEffects(10.0F, 4.0F, 200.0F, 0, 120);
                }

                int standingOnY = Mth.floor(this.getY());
                this.spawnIceSpikesAdvanced(this.getX() , this.getZ(), standingOnY, this.getY(), 0,0);
                this.AreaAttack(6F, 6F, 360.0F, 16.0F, 100, false, 5,false,0.25F,false);
                this.playSound(ModSounds.ANCHOR_SLAM.get(),1,1);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

                Vec3 entityPoesition = this.position();
               // CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 30, 20);
            }
            if(this.attackTicks == 50){
                this.setInvulnerable(false);

            }
        }
        if(this.getAttackState() == 5){
            if(this.attackTicks == 32){
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

            }
            if(this.attackTicks == 58){
           //     LGspawnatlocation(ModItems.ANCHOR_HANDLE.get().getDefaultInstance());

            }
        }
        if(this.getAttackState() == 3){
            if(this.attackTicks == 15){
                this.playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1);
            }
            if(this.attackTicks == 20){

                this.AreaAttack(6.5f, 4.0F, 180.0F, 5.0F, 0, false, 1,true,0.25F,false);
            }

            if(this.attackTicks == 45){
//stopAllAnimationStates();
            }

        }
        if(this.getAttackState() == 8){
if (attackTicks == 0){
    k = (int) this.getY();

}
            LivingEntity target = this.getTarget();

            if(this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget < 64 ) {
                    if (!(this.getTarget() instanceof Player)) {
                        if (this.attackTicks >= 3 && this.attackTicks <= 6) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 6 && this.attackTicks <= 9) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 9 && this.attackTicks <= 12) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 3, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }


                        } else if (this.attackTicks >= 12 && this.attackTicks <= 13) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 13 && this.attackTicks <= 14) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 14 && this.attackTicks <= 20) {
                            this.yHeadRot = yBodyRot;
                            float radius = 2F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 20 && this.attackTicks <= 23) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 23 && this.attackTicks <= 26) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 26 && this.attackTicks <= 33) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 3, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 33 && this.attackTicks <= 36) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 36 && this.attackTicks <= 39) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 42 && this.attackTicks <= 46) {
                            this.yHeadRot = yBodyRot;
                            float radius = 2F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 46 && this.attackTicks <= 49) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 52 && this.attackTicks <= 55) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 55 && this.attackTicks <= 61) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 3, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 61 && this.attackTicks <= 64) {
                            this.yHeadRot = yBodyRot;
                            float radius = 0.5F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 2, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 64 && this.attackTicks <= 66) {
                            this.yHeadRot = yBodyRot;
                            float radius = 1F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY() + 1, this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        } else if (this.attackTicks >= 66 && this.attackTicks <= 69) {
                            this.yHeadRot = yBodyRot;
                            float radius = 2F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                            double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                            Vec3 p1 = new Vec3(this.getX() + extraX, this.getY(), this.getZ() + extraZ);
                            if (this.getTarget() != null) {
                                this.getTarget().setPos(p1);
                            }
                        }
                    } else {
                        if (this.getAttackState() == 8) {
                            int[][] tickRanges = {
                                    {3, 6, 1}, {6, 9, 2}, {9, 12, 3}, {12, 13, 2}, {13, 14, 1}, {14, 20, -1},
                                    {20, 23, 1}, {23, 26, 2}, {26, 33, 3}, {33, 36, 2}, {36, 39, 1},
                                    {42, 46, -1}, {46, 49, 1}, {52, 55, 2}, {55, 61, 3}, {61, 64, 2},
                                    {64, 66, 1}, {66, 69, -1}
                            };

                            for (int[] range : tickRanges) {
                                int startTick = range[0];
                                int endTick = range[1];
                                int heightOffset = range[2];

                                if (this.attackTicks >= startTick && this.attackTicks <= endTick) {
                                    float radius = heightOffset == 3 ? 1F : 2F;
                                    float angle = (0.01745329251F * this.yBodyRot);
                                    double extraX = radius * Mth.sin((float) (Math.PI + angle)) +0.5;
                                    double extraZ = radius * Mth.cos(angle ) - 0.5 *Mth.sin(angle);
                                    Vec3 targetPosition = new Vec3(this.getX() + extraX, this.getY() + heightOffset, this.getZ() + extraZ);

                                    if (this.getTarget() != null) {
                                        Entity target1 = this.getTarget();
                                        Vec3 currentPosition = target.position();
                                        Vec3 velocity = targetPosition.subtract(currentPosition).scale(0.2);

                                        if (target instanceof ServerPlayer serverPlayer) {
                                            serverPlayer.connection.teleport(
                                                    currentPosition.x + velocity.x,
                                                    currentPosition.y + velocity.y,
                                                    currentPosition.z + velocity.z,
                                                    serverPlayer.getYRot(),
                                                    serverPlayer.getXRot()
                                            );
                                        } else {
                                            // Ustaw prędkość dla innych celów
                                            target.setDeltaMovement(velocity);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }}
            if(this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget < 36 ) {
            if(this.attackTicks == 16){
                if (this.getTarget() != null) {
                    int standingOnY = Mth.floor(this.getTarget().getY());
                    this.spawnIceSpikesAdvanced(this.getTarget().getX(), this.getTarget().getZ(), standingOnY, this.getY(), 0, 0);
                    this.AreaAttack(6F, 6F, 360.0F, 14.0F, 100, false, 5, false, 0.25F, false);
                    entityData.set(PARTICLE_TICKS,1000);
                    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
                }
            }
            if(this.attackTicks == 42){
                if (this.getTarget() != null) {
                    entityData.set(PARTICLE_TICKS,1001);
                    int standingOnY = Mth.floor(this.getTarget().getY());
                    this.spawnIceSpikesAdvanced(this.getTarget().getX(), this.getTarget().getZ(), standingOnY, this.getY(), 0, 0);
                    this.AreaAttack(6F, 6F, 360.0F, 15.0F, 100, false, 5, false, 0.25F, false);
                    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
                }
            }

            if(this.attackTicks == 67){
if (this.getTarget() != null) {
    int standingOnY = Mth.floor(this.getTarget().getY());
    this.spawnIceSpikesAdvanced(this.getTarget().getX(), this.getTarget().getZ(), standingOnY, this.getY(), 0, 0);
    this.AreaAttack(6F, 6F, 360.0F, 16.0F, 100, false, 5, false, 0.25F, false);
    this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
}

        }}}}
        if(this.getAttackState() == 4){
            if(this.attackTicks == 15){
                this.playSound(ModSounds.ANCHOR_SWING1.get(),1,1);
            }
            if(this.attackTicks == 20){

                this.AreaAttack(6.5F, 4.0F, 100.0F, 16.0F, 40, false, 5,false,0.25F,false);
            }
        }
        if(this.getAttackState() == 6) {
            if(this.attackTicks == 18){
                this.AreaAttack(6.5F, 4.0F, 75.0F, 14.0F, 40, false, 5,false,0.25F,false);
            }
            if(this.attackTicks == 13){
                this.playSound(ModSounds.ANCHOR_SWING1.get(),1,1);
            }
            if(this.attackTicks == 36){ if (this.onGround()) {

                LivingEntity target = this.getTarget();

                if(this.getTarget() != null) {
                    assert target != null;
                    double distanceToTarget =
                            this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                    if (distanceToTarget > 16) {

                        Vec3 vector3d = this.getDeltaMovement();
                        float f = this.getYRot() * (float) (Math.PI / 180.0);
                        Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(1.6).add(vector3d.scale(1.3));
                        this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                    }
                }}
                this.playSound(ModSounds.ANCHOR_SWING2.get(),1,1);

                }
            if(this.attackTicks == 41){
                this.AreaAttack(6.5f, 4.0F, 75.0F, 15.0F, 40, false, 0,false,0F,false);
            }
            if(this.attackTicks == 65){
                this.playSound(ModSounds.ANCHOR_SWING2.get(),1,1);
            }
            if(this.attackTicks == 68){
                this.AreaAttack(7F, 4F, 160.0F, 17.0F, 80, false, 5,false,0.25F,false);
                this.playSound(ModSounds.ANCHOR_SLAM.get(),1,1);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
            }
        }


    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        // this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }
    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }
    public int guardianDeathTime;
    @Override
    protected void tickDeath() {
        ++this.guardianDeathTime;
        if (this.level() instanceof ServerLevel) {
            if (this.guardianDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);

            }
        }
        if(this.guardianDeathTime == 30){
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);

        }
        if (this.guardianDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
