package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Message.SkeloraptorRoarKeyMessage;
import net.miauczel.legendary_monsters.Message.SkeloraptorTailAttackMessage;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SkeletosaurusEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveEntity;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.IAnimatedTamableMob;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ILookingTamableMobStateGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ITamableMobAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster.ITamableMobStateGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.ChatFormatting;
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
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SkeloraptorEntity extends IAnimatedTamableMob implements PlayerRideableJumping {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(SkeloraptorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(SkeloraptorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ENTITY_STATE =
            SynchedEntityData.defineId(SkeloraptorEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> SCARY_COOLDOWN =
            SynchedEntityData.defineId(SkeloraptorEntity.class, EntityDataSerializers.INT);


    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(SkeloraptorEntity.class, EntityDataSerializers.INT);

    private int walkAnimationTickCounter = 0;
    private static final int MESSAGE_INTERVAL = 15;
    public final int ROAR_COOLDOWN = 300;

    public SkeloraptorEntity(EntityType<? extends IAnimatedTamableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 10;
        this.setNoAi(false);
        this.setPersistenceRequired();
        setMaxUpStep(1.5f);
        this.setPathfindingMalus(BlockPathTypes.LEAVES, 0.0F);
    }

    public final AnimationState idleAnimationState = new AnimationState();


    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    private int regenerationCooldown = 30;

    public boolean canTravel() {
        return this.getAttackState() == 0 && !isSitting();
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public int roarCooldown = ROAR_COOLDOWN;

    @Override
    public void tick() {
        super.tick();

        if (getCommand() == 1 && !isInSittingPose()) this.setOrderedToSit(true);

        if ((getCommand() == 2 || getCommand() == 0) && isOrderedToSit()) this.setOrderedToSit(false);

        if (LegendaryMonsters.PROXY.isKeyDown(4) && isVehicle() && getAttackState() == 0) {
            if (getControllingPassenger() instanceof ServerPlayer player) {
                int b = player.getUUID().hashCode();
                LegendaryMonsters.sendMSGToServer(new SkeloraptorRoarKeyMessage(4, b, 1));
            }

        } else if (LegendaryMonsters.PROXY.isKeyDown(5) && isVehicle() && getAttackState() == 0) {
            if (getControllingPassenger() instanceof ServerPlayer player) {
                int b = player.getUUID().hashCode();
                LegendaryMonsters.sendMSGToServer(new SkeloraptorTailAttackMessage(4, b, 1));
            }
        }
        if (getAttackState() == 0 && getCommand() == 1 && this.getAttackState() != 6) {
            setAttackState(6);

        }
        if (roarCooldown > 0) {
            --roarCooldown;
        }
        if (tickCount % 10 == 0) {
            if (getControllingPassenger() instanceof Player player && roarCooldown > 0) {
                sendActionBarMessage(player);
            }
        }
        if (this.isOrderedToSit()) {
            this.getNavigation().stop();

            return;
        }
        if (this.level().isClientSide()) {
        }
        if (this.level().isClientSide()) {

            this.idleAnimationState.animateWhen(this.getAttackState() == 0 && !this.isSitting(), this.tickCount);

        }
        UpdateWithAttack();
        if (!this.level().isClientSide && this.tickCount % regenerationCooldown == 0) {

            if (this.getHealth() < this.getMaxHealth()) {


                this.heal(1.0F);

            }
        }
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player player) {
            if (this.getY() < this.lastJumpHeight && !this.onGround()) {
                this.reduceFallDamage = true;
            }
        }

        if (this.onGround()) {
            this.reduceFallDamage = false;
        }
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player player) {
            this.yRotO = player.yRotO;
            this.yRotO = player.yRotO;
            this.setYRot(this.yRotO);
            this.setYBodyRot(this.yRotO);

            float forward = player.zza;
            float strafe = player.xxa;
            if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
                this.setSpeed((float) this.getAttribute(Attributes.MOVEMENT_SPEED).getValue() + 0.1f);
            } else {
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
            }
            if (canTravel()) {
                super.travel(new Vec3(strafe, 0, forward));
            }
        }
        handleWalkingMessage();
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player player) {
            if (!this.onGround()) {
                double fallDistance = this.lastY - this.getY();
                if (fallDistance < 10 && fallDistance > 0) {
                    this.reduceFallDamage = true;
                } else {
                    this.reduceFallDamage = false;
                }
            }
        }

        if (this.onGround()) {
            this.reduceFallDamage = false;
        }

        this.lastY = this.getY();
    }

    private double lastY = 0;

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

    public void sendAdvancedHotBarMessage(String message, ChatFormatting chatFormatting, Player player) {
        Component messageComponent =
                Component.literal("<")
                        .append(Component.translatable(getEntityName()).append(">")
                                .append(Component.translatable(message).withStyle(chatFormatting)));
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));

    }

    private boolean isMoving() {
        return this.getDeltaMovement().lengthSqr() > 0.01;
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        if (this.reduceFallDamage && fallDistance < 60) {
            return false;
        }
        return super.causeFallDamage(fallDistance, damageMultiplier, source);
    }


    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    private void sendActionBarMessage(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            Component message =
                    Component.translatable("legendary_monsters.message.skeloraptor_time_until_next_roar")
                            .append(Component.literal(String.valueOf(roarCooldown / 10)));


            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(message));
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

    private String getEntityName() {
        if (this.hasCustomName()) {
            return this.getCustomName().getString();
        } else {
            return "legendary_monsters.message.skeloraptor_string_message_name";
        }
    }
    @Override
    public void setOrderedToSit(boolean sitting) {
        super.setOrderedToSit(sitting);
        //  this.entityData.set(SITTING, sitting);

        if (sitting) {
            this.getNavigation().stop();
            this.setTarget(null);
            if (this.getOwner() instanceof Player player) {
             //   sendActionBarMessageToPlayer(player, "legendary_monsters.message.pet_sit_enable", getEntityName());
            }
        } else {
            if (this.getOwner() instanceof Player player) {
                setAttackState(0);
                this.getNavigation().recomputePath();
                //stopAllAnimationStates();
             //   sendActionBarMessageToPlayer(player, "legendary_monsters.message.pet_walk_enable", getEntityName());
            }
            this.getNavigation().stop();
            this.setNoAi(false);
        }
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(ENTITY_STATE, 0);
        this.entityData.define(ATTACKING, false);

        this.entityData.define(SCARY_COOLDOWN, 0);

        this.entityData.define(COMMAND, 0);
        this.entityData.define(SITTING, false);
    }

    private void launch(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? 1.2F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.5 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, float knockback, boolean BNknockback, float Lstrenght, boolean launch) {


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


                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.SkeloraptorDamageMultiplier.get())));
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

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    private void runawayMobs() {

        List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(16, 10, 16));
        for (LivingEntity e : list) {
            if (!isAlliedTo(e)) {
                if (e instanceof PathfinderMob mob && (!(mob instanceof TamableAnimal) || !((TamableAnimal) mob).isInSittingPose())) {
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

    public void UpdateWithAttack() {
        if (this.getAttackState() == 1) {
            if (attackTicks > 5 && attackTicks < 20) {
                runawayMobs();
            }
            if (this.attackTicks == 1) {

                this.playSound(ModSounds.ANCIENT_GUARDIAN_ROAR.get(), 4, 0.75F);
            }
        }
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 7) {
                this.playSound(ModSounds.WEAPON_SPIN.get(), 2, 1F);
            }
            if (this.attackTicks == 16) {
                this.AreaAttack(5F, 3.0F, 180.0F, 10.0F, 40, false, 0, false, 0.75F, true);

            }
        }


        if (this.getAttackState() == 4) {
            if (this.attackTicks == 12) {
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
                this.AreaAttack(2F, 3.0F, 360.0F, 7.0F, 40, false, 0, false, 0.75F, false);

                SpawnCircleParticle(0.25f, -0.5f, 10, true, 2f, 1f, 1f, 1f, 1);
                Vec3 entityPoesition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 0, 20);


                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 6; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                }


            }

            if (this.attackTicks == 13) {

                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 11; ++k) {
                    float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);

                }
            }
            if (this.attackTicks == 16) {

                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 14; ++k) {
                    float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);

                }
            }

            if (this.attackTicks == 37) {

                this.AreaAttack(2F, 3.0F, 360.0F, 7.0F, 40, false, 0, false, 0.75F, false);
                SpawnCircleParticle(0.25f, -0.5f, 10, true, 2f, 1f, 1f, 1f, 1);
                this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 2, 1);
                Vec3 entityPoesition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPoesition, 20.0F, 0.05F, 0, 20);

                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 6; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);

                }


            }

            if (this.attackTicks == 40) {
                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 11; ++k) {
                    float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 0);
                }
            }
            if (this.attackTicks == 43) {

                int standingOnY = Mth.floor(this.getY());
                for (int k = 0; k < 14; ++k) {
                    float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                    this.spawnShockwaves(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 0);

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
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this;
            this.level().addFreshEntity(new ShockwaveEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, entity1, false, 4));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
       // compound.putBoolean("Sitting", this.isOrderedToSit());

        compound.putInt("Command", getCommand());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        this.setCommand(compound.getInt("Command"));

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
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
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1) {
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() == 2;
            }

            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 2;
            }
        });

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 4, 0, 55, 55, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && SkeloraptorEntity.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && SkeloraptorEntity.this.getTarget() != null && getCommand() != 1 && SkeloraptorEntity.this.getControllingPassenger() == null;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 3, 0, 50, 55, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && SkeloraptorEntity.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && SkeloraptorEntity.this.getTarget() != null && getCommand() != 1 && SkeloraptorEntity.this.getControllingPassenger() == null;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.goalSelector.addGoal(1, new ITamableMobAttackGoal(this, 0, 1, 0, 53, 55, 4F) {
            @Override
            public boolean canUse() {
                return super.canUse() && SkeloraptorEntity.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && SkeloraptorEntity.this.getTarget() != null && getCommand() != 1 && roarCooldown <= 0 && SkeloraptorEntity.this.getControllingPassenger() == null;
            }

            @Override
            public void stop() {
                roarCooldown = ROAR_COOLDOWN;
                super.stop();
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && getCommand() != 1;
            }
        });
        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 1, 1, 0, 53, 53) {
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
        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 4, 4, 0, 55, 55) {
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

        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 3, 3, 0, 50, 50) {
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
        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 7, 7, 0, 20, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }


                }


        );
        this.goalSelector.addGoal(1, new ITamableMobStateGoal(this, 5, 5, 6, 25, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }


                }


        );
        this.goalSelector.addGoal(1, new ILookingTamableMobStateGoal(this, 6, 6, 6, 80, 100) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }


                }


        );

    }


    @Override
    public void aiStep() {
        super.aiStep();
        stopAttackingAllies();
        if (!level().isClientSide) {
            if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                boolean flag = false;
                AABB aabb = this.getBoundingBox().inflate(1D);

                for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    Block block = blockstate.getBlock();
                    if (block instanceof LeavesBlock) {
                        flag = this.level().destroyBlock(blockpos, true, this) || flag;
                    }
                }
            }

        }
    }

    private boolean reduceFallDamage = false;

    public AnimationState sitidleAnimationState = new AnimationState();
    public AnimationState sitstartAnimationState = new AnimationState();

    public AnimationState sitendAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState tailAnimationState = new AnimationState();
    public AnimationState tailmAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState biteAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState roarAnimationState = new AnimationState();
    public AnimationState shockwaveAnimationState = new AnimationState();

    public AnimationState stompsAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "sitidle") {
            return this.sitidleAnimationState;
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
        } else if (input == "stomp") {
            return this.stompsAnimationState;

        } else if (input == "tail") {
            return this.tailAnimationState;

        } else if (input == "sitstart") {

            return this.sitstartAnimationState;

        } else if (input == "sitend") {

            return this.sitendAnimationState;
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
                        this.roarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.shockwaveAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.tailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.stompsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.sitstartAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sitidleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.sitendAnimationState.startIfStopped(this.tickCount);
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
        stompsAnimationState.stop();

        this.sitendAnimationState.stop();
        this.sitstartAnimationState.stop();
        sitidleAnimationState.stop();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 2D)
                .add(Attributes.JUMP_STRENGTH, 0.9D);
    }

    protected int gallopSoundCounter;
    protected boolean canGallop = true;

    protected void playGallopSound(SoundType pSoundType) {
        if (Math.random() < 0.5) {
            this.playSound(ModSounds.STEP_SOUND.get(), pSoundType.getVolume() * 0.15F, pSoundType.getPitch());
        } else {
            this.playSound(ModSounds.STEP_SOUND3.get(), pSoundType.getVolume() * 0.15F, pSoundType.getPitch());
        }
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        if (!pBlock.liquid()) {
            BlockState blockstate = this.level().getBlockState(pPos.above());
            SoundType soundtype = pBlock.getSoundType(level(), pPos, this);
            if (blockstate.is(Blocks.SNOW)) {
                soundtype = blockstate.getSoundType(level(), pPos, this);
            }

            if (this.isVehicle() && this.canGallop) {
                ++this.gallopSoundCounter;
                if (this.gallopSoundCounter > 4 && this.gallopSoundCounter % 2 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopSoundCounter <= 4) {
                    this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            } else if (this.isWoodSoundType(soundtype)) {
                this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundEvents.HORSE_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }

        }
    }

    private boolean isWoodSoundType(SoundType pSoundType) {
        return pSoundType == SoundType.WOOD || pSoundType == SoundType.NETHER_WOOD || pSoundType == SoundType.STEM || pSoundType == SoundType.CHERRY_WOOD || pSoundType == SoundType.BAMBOO_WOOD;
    }

    protected float getWaterSlowDown() {
        return 0.96F;
    }

    public void performAreaAttack() {
        double attackRadius = 3.0; // Promień ataku
        double attackHeight = 3.0; // Wysokość ataku

        // Pobierz listę jednostek w zasięgu hitboxa
        AABB attackBox = new AABB(this.getX() - attackRadius, this.getY(), this.getZ() - attackRadius,
                this.getX() + attackRadius, this.getY() + attackHeight, this.getZ() + attackRadius);
        List<Entity> entities = this.level().getEntities(this, attackBox);

        // Przeprowadź atak na każdą jednostkę w zasięgu
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity && entity != this) {
                this.doHurtTarget((LivingEntity) entity);
            }
        }
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
    }

    private double lastJumpHeight = 0;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.SkeloraptorHealthMutliplier.get());
        this.setPersistenceRequired();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        this.refreshDimensions();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.ON_FIRE))
            return false;
        if (source.is(DamageTypes.FALL) && this.reduceFallDamage && this.isVehicle()) {
            return false; // Całkowicie zablokuj obrażenia od upadku
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

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        return entity instanceof LivingEntity ? (LivingEntity) entity : null;
    }

    @Override
    public void travel(Vec3 travelVector) {

        if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {

            if (!canTravel()) {

                super.travel(new Vec3(0, travelVector.y, 0));
                return;
            } else {


                LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;

                float strafe = livingentity.xxa * 0.1F;
                float forward = livingentity.zza;

                super.travel(new Vec3(strafe, travelVector.y, forward));
                return;
            }
        }


        if (!canTravel()) {

            super.travel(new Vec3(0, travelVector.y, 0));
            return;
        }


        super.travel(travelVector);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean isAffectedByFluids() {
        return true;
    }


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

    public int getCommand() {
        return entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (this.isOwnedBy(player) && player.isShiftKeyDown()) {
            switch (getCommand()) {
                case 0 -> {
                    setCommand(getCommand() + 1);
                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_sit_enable", ChatFormatting.RESET, player);
                }
                case 1 -> {
                    setCommand(getCommand() + 1);
                    setAttackState(0);
                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_wander_enable", ChatFormatting.RESET, player);
                }
                case 2 -> {
                    setCommand(0);
                    sendAdvancedHotBarMessage("legendary_monsters.message.pet_follow_enable", ChatFormatting.RESET, player);
                }
            }
            return InteractionResult.CONSUME;
        }
        if (this.isFood(itemstack) && !isTame()) {
            this.usePlayerItem(player, hand, itemstack);
            if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);

              //  this.setOrderedToSit(true);
                this.level().broadcastEntityEvent(this, (byte) 7);
            } else {
                this.level().broadcastEntityEvent(this, (byte) 6);
            }

            this.setPersistenceRequired();
            return InteractionResult.CONSUME;
        }
        InteractionResult interactionresult1 = super.mobInteract(player, hand);
        if (interactionresult1.consumesAction()) {
            this.setPersistenceRequired();
            return interactionresult1;
        } else if (this.level().isClientSide) {
            if (this.isTame() && this.isOwnedBy(player) && !this.isBaby()) {
                return InteractionResult.SUCCESS;
            } else {
                return !this.isFood(itemstack) || !(this.getHealth() < this.getMaxHealth()) && this.isTame() ? InteractionResult.PASS : InteractionResult.SUCCESS;
            }
        } else {
            if (!this.isBaby() && (this.isOwnedBy(player) || this.isTame()) && getCommand() != 1) {
                player.startRiding(this);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }


    }


    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.BEEF || stack.getItem() == Items.MUTTON || stack.getItem() == Items.PORKCHOP || stack.getItem() == Items.CHICKEN || stack.getItem() == Items.RABBIT; // Define the item to tame with
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

    protected boolean isJumping;
    protected float playerJumpPendingScale;

    public boolean isJumping() {
        return this.isJumping;
    }

    public void setIsJumping(boolean pJumping) {
        this.isJumping = pJumping;
    }

    protected boolean allowStandSliding;

    protected void playJumpSound() {
        this.playSound(SoundEvents.HORSE_JUMP, 0.4F, 1.0F);
    }

    public void onPlayerJump(int pJumpPower) {

        if (pJumpPower < 0) {
            pJumpPower = 0;
        } else {
            this.allowStandSliding = true;
            this.standIfPossible();
        }

        if (pJumpPower >= 90) {
            this.playerJumpPendingScale = 1.0F;
        } else {
            this.playerJumpPendingScale = 0.4F + 0.4F * (float) pJumpPower / 90.0F;
        }


    }

    @Override
    public boolean canJump() {
        return true;
    }

    private int standCounter;

    public void standIfPossible() {


    }

    public void handleStartJump(int pJumpPower) {

        this.allowStandSliding = true;
        this.standIfPossible();
        this.playJumpSound();

    }

    public void handleStopJump() {
    }

    public double getCustomJump() {
        return this.getAttributeValue(Attributes.JUMP_STRENGTH);
    }

    protected void tickRidden(Player pPlayer, Vec3 pTravelVector) {
        super.tickRidden(pPlayer, pTravelVector);
        if (this.onGround()) {
            this.setIsJumping(false);
            if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround()) {
                this.executeRidersJump(this.playerJumpPendingScale, pTravelVector);
            }

            this.playerJumpPendingScale = 0.0F;
        }
    }

    protected void executeRidersJump(float p_248808_, Vec3 p_275435_) {
        double d0 = this.getCustomJump() * (double) p_248808_ * (double) this.getBlockJumpFactor();
        double d1 = d0 + (double) this.getJumpBoostPower();
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, d1, vec3.z);
        this.setIsJumping(true);
        this.hasImpulse = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
        if (p_275435_.z > 0.0D) {
            float f = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
            float f1 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
            this.setDeltaMovement(this.getDeltaMovement().add((double) (-0.4F * f * p_248808_), 0.0D, (double) (0.4F * f1 * p_248808_)));
        }

    }

}
