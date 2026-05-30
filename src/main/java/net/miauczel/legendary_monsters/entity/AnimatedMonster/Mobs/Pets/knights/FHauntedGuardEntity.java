package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights;

import net.miauczel.legendary_monsters.Particle.custom.KnightSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.IAnimatedTamableMob;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ILookingTamableMobStateGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ITamableMobAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ITamableMobMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static net.miauczel.legendary_monsters.util.MathUtils.toTicks;

public class FHauntedGuardEntity extends IAnimatedTamableMob {


    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(FHauntedGuardEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(FHauntedGuardEntity.class, EntityDataSerializers.BOOLEAN);


    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(FHauntedGuardEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(FHauntedGuardEntity.class, EntityDataSerializers.INT);
    private int regenerationCooldown = 30;


    public FHauntedGuardEntity(EntityType<? extends IAnimatedTamableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        this.entityData.set(TEXTURE_VARIANT, 0);
        this.setTame(false);
        saveTargetPos(getX(), getY(), getZ());
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public final AnimationState idleAnimationState = new AnimationState();


    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    public int slamCooldown = 20;

    public int getCommand() {
        return entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    @Override
    public void tick() {
        super.tick();
        idleAnimationState.animateWhen(getAttackState() == 0 || getAttackState() == 4, tickCount);
        if (getCommand() == 1) {
            getNavigation().stop();
            setDeltaMovement(0, getDeltaMovement().y, 0);
        }
        if (slamCooldown > 0) {
            slamCooldown--;
        }
        if (getCommand() == 1 && !isInSittingPose()) this.setOrderedToSit(true);

        if ((getCommand() == 2 || getCommand() == 0) && isOrderedToSit()) this.setOrderedToSit(false);

        this.setAge(0);
        if (this.level().isClientSide()) {

        }
        if (getAttackState() == 0 && getCommand() == 1 && this.getAttackState() != 3 && this.getAttackState() != 4 && this.getAttackState() != 5 && this.getAttackState() != 2) {
            setAttackState(4);

        }

        if (!this.level().isClientSide && this.tickCount % regenerationCooldown == 0) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.heal(1.0F);
                spawnHeartParticles();
            }
        }
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double) this.distanceTo(e) <= r + (double) (e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
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
                        && entityHit != this
                        && !(entityHit instanceof FHauntedGuardEntity)
                        && !(entityHit instanceof TamableAnimal tamableEntity && tamableEntity.getOwner() == this.getOwner());

                if (isEnemy) {
                    if (entityHit == this.getTarget()) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.TamableGuardDamageMutliplier.get())
                        );
                    } else if (attackedExtraMobCount < maxExtraMobs) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.TamableGuardDamageMutliplier.get())
                        );
                        attackedExtraMobCount++;
                    }
                }
            }
        }
    }

    private void spawnHeartParticles() {
        if (this.level().isClientSide()) {
            double x = this.getX();
            double y = this.getY() + this.getBbHeight() + 0.5;
            double z = this.getZ();

            for (int i = 0; i < 5; i++) {
                double offsetX = this.random.nextGaussian() * 0.02;
                double offsetY = this.random.nextGaussian() * 0.02;
                double offsetZ = this.random.nextGaussian() * 0.02;
                this.level().addParticle(ParticleTypes.HEART, x, y, z, offsetX, offsetY, offsetZ);
            }
        }
    }


    public boolean isOrderedToSit() {
        return getCommand() == 1;
    }

    public FHauntedGuardEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        FHauntedGuardEntity armor = ModEntities.Guard.get().create(pLevel);
        if (armor != null) {
            UUID uuid = this.getOwnerUUID();
            if (uuid != null) {
                armor.setOwnerUUID(uuid);
                armor.setTame(true);
            }
        }

        return armor;
    }


    public AnimationState stabAnimationState = new AnimationState();
    public final AnimationState DeathAnimationState = new AnimationState();
    public AnimationState uppercutAnimationState = new AnimationState();
    public AnimationState slamAnimationState = new AnimationState();
    public AnimationState combo2AnimationState = new AnimationState();
    public AnimationState slashAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "slam") {
            return this.slamAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sit") {
            return this.sitAnimationState;
        } else if (input == "uppercut") {
            return this.uppercutAnimationState;
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
                        this.sitAnimationState.startIfStopped(this.tickCount);
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
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {

        if (pPlayer.isShiftKeyDown()) {
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            Item item = itemstack.getItem();

            if (this.level().isClientSide) {
                if (this.isTame() && this.isOwnedBy(pPlayer)) {
                    return InteractionResult.SUCCESS;
                } else {
                    return !this.isFood(itemstack) || !(this.getHealth() < this.getMaxHealth()) && this.isTame() ? InteractionResult.PASS : InteractionResult.SUCCESS;
                }
            } else {
                if (this.isTame()) {
                    if (this.isOwnedBy(pPlayer)) {
                        int newTextureVariant = -1;

                        if (pPlayer.isShiftKeyDown()) {
                            if (item == Items.GOLD_INGOT && !(this.getTextureVariant() == 1)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_GOLD;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 1;

                            } else if (item == Items.AMETHYST_SHARD && !(this.getTextureVariant() == 2)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_DIAMOND;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 2;

                            } else if (item == Items.EMERALD && !(this.getTextureVariant() == 3)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_DIAMOND;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 3;

                            } else if (item == Items.COPPER_INGOT && !(this.getTextureVariant() == 4)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_CHAIN;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 4;

                            } else if (item == Items.DIAMOND && !(this.getTextureVariant() == 5)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_DIAMOND;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 5;

                            } else if (item == Items.ECHO_SHARD && !(this.getTextureVariant() == 6)) {
                                SoundEvent customAttackSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
                                this.level().playSound(null, this.blockPosition(), customAttackSound, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                SoundEvent customAttackSound2 = SoundEvents.WARDEN_DEATH;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 1.0f, 1.0f);
                                newTextureVariant = 6;

                            } else if (item == Items.IRON_INGOT && !(this.getTextureVariant() == 7)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_IRON;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 7;

                            } else if (item == Items.NETHERITE_INGOT && !(this.getTextureVariant() == 8)) {
                                SoundEvent customAttackSound2 = SoundEvents.ARMOR_EQUIP_NETHERITE;
                                this.level().playSound(null, this.blockPosition(), customAttackSound2, SoundSource.NEUTRAL, 2.0f, 1.0f);
                                newTextureVariant = 8;
                            }


                            if (newTextureVariant != -1) {
                                this.entityData.set(TEXTURE_VARIANT, newTextureVariant);
                                itemstack.shrink(1);
                                return InteractionResult.CONSUME;
                            }
                        }

                        InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
                        if (!interactionresult.consumesAction() || this.isBaby()) {

                            switch (getCommand()) {
                                case 0 -> {
                                    setCommand(getCommand() + 1);
                                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_sit_enable", ChatFormatting.RESET, pPlayer);
                                }
                                case 1 -> {
                                    setCommand(getCommand() + 1);
                                    setAttackState(0);
                                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_wander_enable", ChatFormatting.RESET, pPlayer);
                                }
                                case 2 -> {
                                    setCommand(getCommand() + 1);
                                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_guard_enable", ChatFormatting.RESET, pPlayer);
                                }
                                case 3 -> {
                                    setCommand(0);
                                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_follow_enable", ChatFormatting.RESET, pPlayer);
                                }
                            }
                        }
                        //   System.out.println("COMMAND: " + getCommand());
                        return interactionresult;
                    }
                } else if (this.isFood(itemstack)) {
                    this.usePlayerItem(pPlayer, pHand, itemstack);
                    if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                        this.tame(pPlayer);
                        this.setOrderedToSit(true);
                        this.level().broadcastEntityEvent(this, (byte) 7);
                    } else {
                        this.level().broadcastEntityEvent(this, (byte) 6);
                    }

                    this.setPersistenceRequired();
                    return InteractionResult.CONSUME;
                }
                InteractionResult interactionresult1 = super.mobInteract(pPlayer, pHand);
                if (interactionresult1.consumesAction()) {
                    this.setPersistenceRequired();
                }

                return interactionresult1;
            }
        } else return InteractionResult.FAIL;
    }

    public void setOrderedToSit(boolean sitting) {
        if (sitting) {
            this.getNavigation().stop();
            this.setTarget(null);
        } else {
            setAttackState(0);

        }
    }


    private void sendActionBarMessageToPlayer(Player player, String translationKey, String entityName) {
        if (player instanceof ServerPlayer serverPlayer) {
            Component message =
                    Component.literal("<")
                            .append(Component.translatable(entityName)).append(">")
                            .append(Component.translatable(translationKey));

            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(message));
        }
    }

    public void sendAdvancedHotBarMessage(String message, ChatFormatting chatFormatting, Player player) {
        Component messageComponent =
                Component.literal("<")
                        .append(Component.translatable(getEntityName()).append(">")
                                .append(Component.translatable(message).withStyle(chatFormatting)));
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

    }

    private String getEntityName() {
        if (this.hasCustomName()) {
            return this.getCustomName().getString();
        } else {

            return "legendary_monsters.message.guard_string_message_name";
        }
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
        this.entityData.define(SITTING, false);
        this.entityData.define(TEXTURE_VARIANT, 0);
        this.entityData.define(COMMAND, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 4, 4, 0, 0, 100) {
                    @Override
                    public void tick() {
                        entity.getNavigation().stop();
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );
        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 4, 0, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }

                    @Override
                    public boolean canUse() {
                        return super.canUse();
                    }
                }


        );
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 2;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() == 2;
            }
        });
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Monster.class, true) {
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() == 3;
            }

            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 3;
            }
        });
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 4.0D, 10.0F, 2.0F, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1 && getCommand() != 2;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1 && getCommand() != 2;
            }
        });
        this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });

        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 2, 0, toTicks(2.67f), 15, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 35.0F < 16.0F
                        && getTarget() != null && getCommand() != 1;
            }
        });
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 3, 0, 90, 55, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 35.0F < 16.0F
                        && getTarget() != null && getCommand() != 1;
            }
        });

        this.goalSelector.addGoal(2, new ITamableMobMoveGoal(this, false, 3.0D));
    }

    public int getTextureVariant() {
        return this.entityData.get(TEXTURE_VARIANT);
    }

    private void dash(float a1, float a2, float minD) {
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if (this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
        }
    }

    public void calculatedDash(float Multiplier) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((target.getX() - this.getX()) * Multiplier, 0, (target.getZ() - this.getZ()) * Multiplier);
        }
    }


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

    public LivingEntity target() {
        return getTarget();
    }

    public boolean targetIsNotNull() {
        return getTarget() != null;
    }

    public void launch(LivingEntity entity, boolean huge, float mult) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? mult : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    public void calculatedDashToPositon(float Multiplier, Vec3 position) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((position.x - this.getX()) * Multiplier, 0, (position.z - this.getZ()) * Multiplier);
        }
    }

    private void StraightLineAreaAttack(float boxWidth, float yHeight, float range, int brokenShieldTicks, float damage, boolean launch, float launchPower) {

        double rad = Math.toRadians(this.getYRot() + 90);
        double xRange = range * Math.cos(rad);
        double zRange = range * Math.sin(rad);
        AABB attackRange = this.getBoundingBox().inflate(boxWidth, yHeight, boxWidth).expandTowards(xRange, 0, zRange);
        for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entityHit) && entityHit != this && !(entityHit instanceof TamableAnimal tamableAnimal && tamableAnimal.getOwner() == getOwner())) {

                boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.HauntedKnightDamageMutliplier.get())));

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

    public void UpdateWithAttack() {
        switch (getTextureVariant()) {
            // -1,7,0 iron
            // 1 gold
            //2 amethyst
            //3 emerald
            //4 copper
            //5 diamond
            //6 echo
            //8 netherite
            case 0, -1, 7 -> setRGB(203, 212, 214);
            case 1 -> setRGB(234, 238, 87);
            case 2 -> setRGB(231, 207, 250);
            case 3 -> setRGB(130, 246, 173);
            case 4 -> setRGB(191, 116, 92);
            case 5 -> setRGB(161, 251, 232);
            case 6 -> setRGB(78, 160, 153);
            case 8 -> setRGB(132, 124, 132);
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
                StraightLineAreaAttack(-0.5f, 3f, 3.25f, 100, 20, true, 1.2f);
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
                AreaAttack(3, 3, 180, 20, 10);
            }
            if (attackTicks == slashTick - 3) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1);
                createSweep(1, 0, bigSweepHeight - 1, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
            }
            if (attackTicks == slashTick) {
                AreaAttack(3, 3, 180, 20, 10);
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

    public void setRGB(float r, float g, float b) {
        getR = r / 255;
        getG = g / 255;
        getB = b / 255;
    }

    public float getR;
    public float getG;
    public float getB;

    @Override
    public void aiStep() {
        super.aiStep();
        stopAttackingAllies();
        UpdateWithAttack();
        if (this.isOrderedToSit()) {
            this.getNavigation().stop();
            this.setTarget(null);
            return;
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
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 140)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 14D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                .add(Attributes.ATTACK_DAMAGE, 18);
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
        setAttackState(7);
        dragonDeathTime = 0;
        if (this.hasCustomName()) {
            ItemStack nameTag = new ItemStack(Items.NAME_TAG, 1);
            nameTag.setHoverName(this.getName());
            this.spawnAtLocation(nameTag);
        }
        ItemStack diamond = new ItemStack(ModItems.DEACTIVATED_GUARD_SUMMONER.get(), 1);
        ItemStack txt0 = new ItemStack(Items.IRON_INGOT, 1);
        ItemStack txt1 = new ItemStack(Items.GOLD_INGOT, 1);
        ItemStack txt2 = new ItemStack(Items.AMETHYST_SHARD, 1);
        ItemStack txt3 = new ItemStack(Items.EMERALD, 1);
        ItemStack txt4 = new ItemStack(Items.COPPER_INGOT, 1);
        ItemStack txt5 = new ItemStack(Items.DIAMOND, 1);
        ItemStack txt6 = new ItemStack(Items.ECHO_SHARD, 1);
        ItemStack txt8 = new ItemStack(Items.NETHERITE_INGOT, 1);
        ItemStack tag = new ItemStack(Items.NAME_TAG, 1);
        ItemStack emerald = new ItemStack(Items.AIR, 1);
        if (this.getTextureVariant() == 1) {
            this.LGspawnatlocation(txt1);
        }
        if (this.getTextureVariant() == 7) {
            this.LGspawnatlocation(txt0);
        }
        if (this.getTextureVariant() == 2) {
            this.LGspawnatlocation(txt2);
        }
        if (this.getTextureVariant() == 3) {
            this.LGspawnatlocation(txt3);
        }
        if (this.getTextureVariant() == 4) {
            this.LGspawnatlocation(txt4);
        }
        if (this.getTextureVariant() == 5) {
            this.LGspawnatlocation(txt5);
        }
        if (this.getTextureVariant() == 6) {
            this.LGspawnatlocation(txt6);
        }
        if (this.getTextureVariant() == 8) {
            this.LGspawnatlocation(txt8);
        }
        this.LGspawnatlocation(diamond);
        this.spawnAtLocation(emerald);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.TamableGuardHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {

        if (source.getDirectEntity() instanceof AbstractArrow)
            return false;

        if (source.is(DamageTypes.FALL))
            return false;

        if (source.is(DamageTypes.TRIDENT))
            return false;

        return super.hurt(source, amount);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.IRON_INGOT;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Sitting", this.isOrderedToSit());
        compound.putInt("Command", getCommand());
        compound.putInt("TextureVariant", this.getTextureVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setOrderedToSit(compound.getBoolean("Sitting"));
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));
        this.entityData.set(COMMAND, compound.getInt("Command"));
    }

    public int dragonDeathTime;
    public int DeathAnimationTimeout = 60;

    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;

        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}