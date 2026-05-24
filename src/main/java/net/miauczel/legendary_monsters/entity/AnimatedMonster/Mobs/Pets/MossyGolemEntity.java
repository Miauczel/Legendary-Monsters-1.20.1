package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.*;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class MossyGolemEntity extends IAnimatedTamableMob {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MossyGolemEntity.class, EntityDataSerializers.BOOLEAN);


    private static final EntityDataAccessor<Boolean> STANDING =
            SynchedEntityData.defineId(MossyGolemEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(MossyGolemEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(MossyGolemEntity.class, EntityDataSerializers.INT);


    public MossyGolemEntity(EntityType<? extends IAnimatedTamableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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


    private String getEntityName() {
        if (this.hasCustomName()) {
            return this.getCustomName().getString();
        } else {

            return "legendary_monsters.message.mossy_golem_string_message_name";
        }
    }

    public void stopAttackingAllies() {
        if (this.getTarget() != null) {
            if (getTarget() instanceof TamableAnimal) {
                if (getOwner() != null && ((TamableAnimal) getTarget()).getOwner() == this.getOwner()) {
                    setTarget(null);
                }
            }
        }
    }

    public void setOrderedToSit(boolean sitting) {
        // this.entityData.set(SITTING, sitting);
        if (sitting) {
            this.getNavigation().stop();
            this.setTarget(null);
            if (this.getOwner() instanceof Player player) {
                //setAttackState(3);
                //sendActionBarMessageToPlayer(player,"legendary_monsters.message.pet_sit_enable",getEntityName());
            }
        } else {
            if (this.getOwner() instanceof Player player) {
                setAttackState(0);
                this.getNavigation().recomputePath();
                //  stopAllAnimationStates();
                //   sendActionBarMessageToPlayer(player,"legendary_monsters.message.pet_walk_enable",getEntityName());
            }
            this.getNavigation().stop();
            this.setNoAi(false);
        }
    }

    public boolean isOrderedToSit() {
        return getCommand() == 1;
    }

    public int getCommand() {
        return entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    private void accelerateCropGrowth(int radius, int growthStages) {
        BlockPos entityPos = this.blockPosition();
        for (int dy = -radius; dy <= radius; dy++) {
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos checkPos = entityPos.offset(dx, dy, dz);
                    BlockState state = this.level().getBlockState(checkPos);

                    if (state.hasProperty(BlockStateProperties.AGE_7)) {
                        int currentAge = state.getValue(BlockStateProperties.AGE_7);
                        int maxAge = 7;

                        if (currentAge < maxAge) {
                            int newAge = Math.min(currentAge + growthStages, maxAge);
                            this.level().setBlock(checkPos, state.setValue(BlockStateProperties.AGE_7, newAge), 2);
                        }
                    } else if (state.hasProperty(BlockStateProperties.AGE_3)) {
                        int currentAge = state.getValue(BlockStateProperties.AGE_3);
                        int maxAge = 3;

                        if (currentAge < maxAge) {
                            int newAge = Math.min(currentAge + growthStages, maxAge);
                            this.level().setBlock(checkPos, state.setValue(BlockStateProperties.AGE_3, newAge), 2);
                        }
                    } else if (state.hasProperty(BlockStateProperties.AGE_5)) {
                        int currentAge = state.getValue(BlockStateProperties.AGE_5);
                        int maxAge = 5;

                        if (currentAge < maxAge) {
                            int newAge = Math.min(currentAge + growthStages, maxAge);
                            this.level().setBlock(checkPos, state.setValue(BlockStateProperties.AGE_5, newAge), 2);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public MossyGolemEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        MossyGolemEntity armor = ModEntities.Mossy_Golem.get().create(pLevel);
        if (armor != null) {
            UUID uuid = this.getOwnerUUID();
            if (uuid != null) {
                armor.setOwnerUUID(uuid);
                armor.setTame(true);
            }
        }

        return armor;
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


    private int cropGrowthCooldown = 20;

    @Override
    public void tick() {
        super.tick();
        if (getCommand() == 1 || isStanding()) {
            getNavigation().stop();
            setDeltaMovement(0, 0, 0);
        }
        if (cropGrowthCooldown > 0) {
            cropGrowthCooldown--;
        }
        if (getAttackState() == 0 && cropGrowthCooldown <= 0 && canIncreaseCropGrowth()) {
            cropGrowthCooldown = 260;
            setAttackState(4);
        }
        if (getAttackState() == 0 && getCommand() == 1) {
            setAttackState(3);
        }

        if (this.isOrderedToSit()) {
            this.getNavigation().stop();
            return;
        }

        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0 && !isSitting(), this.tickCount);
        }
    }

    @Override
    public void aiStep() {
        stopAttackingAllies();
        updateWithAttack();
        super.aiStep();
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

        this.entityData.define(STANDING, false);
        this.entityData.define(SITTING, false);

        this.entityData.define(COMMAND, 0);
    }

    public boolean canIncreaseCropGrowth() {
        int radius = 3;
        BlockPos entityPos = MossyGolemEntity.this.blockPosition();

        for (int dy = -radius; dy <= radius; dy++) {
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos checkPos = entityPos.offset(dx, dy, dz);
                    BlockState state = MossyGolemEntity.this.level().getBlockState(checkPos);

                    if (state.getBlock() instanceof CropBlock cropBlock) {
                        if (!cropBlock.isMaxAge(state)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    public boolean isStanding() {
        return getCommand() == 3;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Command", getCommand());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 3, 3, 0, 0, 100) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }
        );
        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 3, 0, 0, 0, 0) {
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
        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 4, 4, 0, 60, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }

                    @Override
                    public boolean canUse() {

                        return canIncreaseCropGrowth() && cropGrowthCooldown <= 0;
                    }

                    @Override
                    public boolean canContinueToUse() {
                        return super.canContinueToUse() && getCommand() != 1;
                    }
                }


        );
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 4.0D, 10.0F, 2.0F, false) {
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !isStanding() && getCommand() != 2;
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !isStanding() && getCommand() != 2;
            }
        });
        this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 2, 0, 35, 20, 3F) {
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1 && getCommand() != 2;

            }

            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() != 1 && getCommand() != 2;
            }
        });

        this.goalSelector.addGoal(2, new ITamableMobMoveGoal(this, false, 3.0D));
    }


    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState smashAnimationState = new AnimationState();

    public AnimationState growthAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "slam") {
            return this.smashAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sit") {
            return this.sitAnimationState;
        } else if (input == "growth") {
            return this.growthAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public void setStanding(boolean standing, Player player) {
        if (isStanding()) {
            sendActionBarMessageToPlayer(player, "legendary_monsters.message.pet_stand_disable", getEntityName());
        } else {
            sendActionBarMessageToPlayer(player, "legendary_monsters.message.pet_stand_enable", getEntityName());
        }
        entityData.set(STANDING, standing);
    }

    public boolean isSitting() {
        return getCommand() == 1;
    }

    public void sendAdvancedHotBarMessage(String message, ChatFormatting chatFormatting, Player player) {
        Component messageComponent =
                Component.literal("<")
                        .append(Component.translatable(getEntityName()).append(">")
                                .append(Component.translatable(message).withStyle(chatFormatting)));
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.level().isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            if (this.isOwnedBy(pPlayer)) {
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
                            sendAdvancedHotBarMessage("legendary_monsters.message.pet_stand_enable", ChatFormatting.RESET, pPlayer);
                        }
                        case 3 -> {
                            setCommand(0);
                            sendAdvancedHotBarMessage("legendary_monsters.message.pet_follow_enable", ChatFormatting.RESET, pPlayer);
                        }
                    }

                    System.out.println("COMMAND: " + getCommand());
                }

                return interactionresult;
            }
            return super.mobInteract(pPlayer, pHand);
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
                        this.smashAnimationState.startIfStopped(this.tickCount);
                    }


                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.sitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.growthAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();

        this.sitAnimationState.stop();

        this.growthAnimationState.stop();
        this.smashAnimationState.stop();
    }

    private void AreaAttack(float range, float height, float arc, float damage) {
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
                if (!isAlliedTo(entityHit) && entityHit != this && !(entityHit instanceof MossyGolemEntity) && !(entityHit instanceof TamableAnimal tamableEntity && tamableEntity.isTame() && tamableEntity.getOwner() == this.getOwner())) {


                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.MossyGolemDamageMutliplier.get())));
                    if (flag) {
                        //   playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(),1,1.5f);
                    }
                }
            }
        }
    }

    public void CircleParticle(int precent, float x, float y, float z) {
        for (int i = 0; i < 360; i++) {
            if (i % precent == 0) {

                this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, Math.cos(i) + x, y, Math.sin(i) + z, 1, 1, 1);
            }
        }
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    public void updateWithAttack() {

        if (getAttackState() == 4) {
            if (attackTicks == 1) {

            }
            if (attackTicks == 14) {
                if (level().isClientSide) {
                    float radius = 2f;
                    CircleParticle(20, (float) this.getX(), (float) (this.getY() + 0.2f), (float) this.getZ());
                }
                playSound(SoundEvents.BONE_MEAL_USE, 2, 0.75f);
                if (!level().isClientSide) {
                    accelerateCropGrowth(4, 5);
                }
            }
        }
        if (getAttackState() == 2) {
            if (attackTicks == 12) {
                AreaAttack(4f, 2f, 180, 7.5f);

                SpawnCircleParticle(1.5f, 0.5f, 5, true, 0.25f, 0.9f, 1, 0.9f, 1);
                SpawnCircleParticle(1.5f, -0.5f, 5, true, 0.25f, 0.9f, 1, 0.9f, 1);
                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1, 1);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5F)
                .add(Attributes.FOLLOW_RANGE, 14D)
                .add(Attributes.ARMOR, 6D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 16D);
    }

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


    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.MossyGolemHealthMultiplier.get());
        this.setPersistenceRequired();
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
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setCommand(compound.getInt("Command"));

    }
}