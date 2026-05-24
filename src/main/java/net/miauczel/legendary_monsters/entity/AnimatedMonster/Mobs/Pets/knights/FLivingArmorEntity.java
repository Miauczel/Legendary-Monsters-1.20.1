package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights;

import net.miauczel.legendary_monsters.Particle.custom.KnightSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.goals.TamableKnightParryFrameGoal;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.goals.TamableKnightParryGoal;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.*;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class FLivingArmorEntity extends IAnimatedTamableMob {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(FLivingArmorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(FLivingArmorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TEXTURE_VARIANT =
            SynchedEntityData.defineId(FLivingArmorEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(FLivingArmorEntity.class, EntityDataSerializers.INT);

    private int regenerationCooldown = 30;

    public int getCommand() {
        return entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }


    public FLivingArmorEntity(EntityType<? extends IAnimatedTamableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        this.entityData.set(TEXTURE_VARIANT, 0);
        this.setTame(false);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public final AnimationState idleAnimationState = new AnimationState();


    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide)
            idleAnimationState.animateWhen(getAttackState() == 0 || getAttackState() == 9, tickCount);
        this.setAge(0);
        if (this.level().isClientSide()) {

        }
        if (getCommand() == 1) {
            getNavigation().stop();
            setDeltaMovement(0, getDeltaMovement().y, 0);
        }

        if (getCommand() == 1 && !isInSittingPose()) this.setOrderedToSit(true);

        if ((getCommand() == 2 || getCommand() == 0) && isOrderedToSit()) this.setOrderedToSit(false);

        sitAnimationState.animateWhen(getCommand() == 1, this.tickCount);

        if (getAttackState() == 0 && getCommand() == 1 && this.getAttackState() != 3 && this.getAttackState() != 4 && this.getAttackState() != 5 && this.getAttackState() != 2) {
            // setAttackState(3);

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
                        && entityHit != this && !(entityHit instanceof TamableAnimal tamableAnimal && tamableAnimal.getOwner() == getOwner());

                if (isEnemy) {
                    if (entityHit == this.getTarget()) {
                        if (getAttackState() == 8) {
                            playSound(ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 1, 0.75f);
                        } else playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt = entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.TamableKnightDamageMutliplier.get())
                        );

                        if (hurt && getAttackState() == 8)
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 15, 0));
                    } else if (attackedExtraMobCount < maxExtraMobs) {
                        if (getAttackState() == 8) {
                            playSound(ModSounds.ZOMBIE_ATTACK_IRON_DOOR, 1, 0.75f);
                        } else playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        boolean hurt = entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.TamableKnightHealthMultiplier.get())
                        );
                        attackedExtraMobCount++;
                        if (hurt && getAttackState() == 8)
                            entityHit.addEffect(new MobEffectInstance(ModEffects.STUN.get(), 15, 0));
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

    @Nullable
    public FLivingArmorEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        FLivingArmorEntity armor = ModEntities.Knights_Armor.get().create(pLevel);
        if (armor != null) {
            UUID uuid = this.getOwnerUUID();
            if (uuid != null) {
                armor.setOwnerUUID(uuid);
                armor.setTame(true);
            }
        }

        return armor;
    }


    public AnimationState sitAnimationState = new AnimationState();
    public AnimationState DeathAnimationState = new AnimationState();
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
        } else if (input == "sit") {
            return this.sitAnimationState;
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
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.sitAnimationState.startIfStopped(this.tickCount);
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
        sitAnimationState.stop();
    }


    public void setOrderedToSit(boolean sitting) {
        this.entityData.set(SITTING, sitting);
        if (sitting) {
            this.getNavigation().stop();
            this.setTarget(null);
        } else {
            setAttackState(0);
        }
    }


    private void sendActionBarMessageToPlayer(Player player, String translationKey, String entityName) {
        if (player instanceof ServerPlayer serverPlayer) {
            // Tworzysz komponent literalny z nazwą entity
            Component message =
                    Component.literal("<")
                            .append(Component.translatable(entityName)).append(">")
                            .append(Component.translatable(translationKey));

            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(message));
        }
    }


    private String getEntityName() {
        if (this.hasCustomName()) {
            return this.getCustomName().getString();
        } else {
            return "legendary_monsters.message.knight_string_message_name";
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

        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 9, 9, 0, 0, 100, true) {
                    @Override
                    public void tick() {
                        entity.getNavigation().stop();
                        entity.setDeltaMovement(0, 0, 0);
                    }
                }

        );


        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
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
        // this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true, false));
        //  this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.goalSelector.addGoal(2, new ITamableMobMoveGoal(this, false, 3.0D) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });

        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 2, 0, 39, 20, 3F) {
            @Override
            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 28.0F
                        && getTarget() != null && getCommand() != 1;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 3, 0, 65, 40, 3F) {
            @Override
            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 28.0F && getCommand() != 1
                        && getTarget() != null;
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new TamableKnightParryGoal(this, 0, 4, 0, 8, 8, 3F) {

            @Override
            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 33.0F && getCommand() != 1
                        && getTarget() != null && getTarget() instanceof Mob mob && mob.getTarget() != getOwner();
            }

            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(1, new TamableKnightParryFrameGoal(this, 5, 5, 0, 25, 25) {
            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new ITamableMobStateGoal(this, 7, 7, 0, 11, 11) {
            @Override
            public void stop() {
                super.stop();
            }
        });
        this.goalSelector.addGoal(0, new ITamableMobStateGoal(this, 8, 8, 0, 27, 27) {

            @Override
            public void stop() {
                super.stop();
            }
        });

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

    public boolean gambitParry = false;

    public void setRGB(float r, float g, float b) {
        getR = r / 255;
        getG = g / 255;
        getB = b / 255;
    }

    public float getR;
    public float getG;
    public float getB;

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
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
                                setCommand(0);
                                sendAdvancedHotBarMessage("legendary_monsters.message.pet_follow_enable", ChatFormatting.RESET, pPlayer);
                            }
                        }

                        System.out.println("COMMAND: " + getCommand());
                    }

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
    }



    public void sendAdvancedHotBarMessage(String message, ChatFormatting chatFormatting, Player player) {
        Component messageComponent =
                Component.literal("<")
                        .append(Component.translatable(getEntityName()).append(">")
                                .append(Component.translatable(message).withStyle(chatFormatting)));
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

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
                AreaAttack(swordSize, 3, 100, 14, extraMobs);
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
                AreaAttack(swordSize, 3, 100, 14, extraMobs);
            }
            if (attackTicks == attack2 - 3) {
                createSweep(1, 0, bigSweepHeight, bigSweepAdditionalY, true, sweepSize, sweepRot, false);
                calculatedDash(0.25f);
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 2);
            }
            if (attackTicks == attack2) {
                AreaAttack(swordSize, 3, 100, 14, extraMobs);
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
                AreaAttack(swordSize, 3, 180, 18, 4);
            }
        }


    }

    public void calculatedDash(float Multiplier) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((target.getX() - this.getX()) * Multiplier, 0, (target.getZ() - this.getZ()) * Multiplier);
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
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 120)
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

    @Override
    public void die(DamageSource source) {
        super.die(source);
        setAttackState(6);
        dragonDeathTime = 0;
        if (this.hasCustomName()) {
            ItemStack nameTag = new ItemStack(Items.NAME_TAG, 1);
            nameTag.setHoverName(this.getName());
            this.spawnAtLocation(nameTag);
        }

        ItemStack diamond = new ItemStack(ModItems.DEACTIVATED_KNIGHT_SUMMONER.get(), 1);
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
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.TamableKnightHealthMultiplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

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

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.IRON_INGOT;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Sitting", this.isOrderedToSit());
        compound.putInt("TextureVariant", this.getTextureVariant());

        compound.putInt("Command", getCommand());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setOrderedToSit(compound.getBoolean("Sitting"));
        this.entityData.set(TEXTURE_VARIANT, compound.getInt("TextureVariant"));
        this.entityData.set(COMMAND, compound.getInt("Command"));
        // this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(ModConfig.COMMON.KnightHealth.get());
        // this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(ModConfig.COMMON.KnightDamage.get());
        //this.setHealth(ModConfig.COMMON.KnightHealth.get().floatValue());
    }
}