package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.FlameDrifter;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.*;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SmallAnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoalMin;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class FlameDrifterEntity extends AbstractFlameborn {

    public FlameDrifterEntity(EntityType entity, Level world) {
        super(entity, world);
        xpReward = 5;
        lastX = getX();
        lastY = getY();
        lastZ = getZ();
        this.setPersistenceRequired();
        setMaxUpStep(2);
    }

    public final int SPIN_COOLDOWN = 80;
    public int spin_cooldown = SPIN_COOLDOWN;
    @Override
    public void tick() {
        if (spin_cooldown >0) spin_cooldown--;
        if (level().isClientSide) {
            idleAnimationState.animateWhen(getAttackState() == 0, this.tickCount);
            if (isDuringTeleportation() && !isInvisible()) setInvisible(true);
            if (!isDuringTeleportation() && isInvisible()) setInvisible(false);
        }
        super.tick();
    }

    @Override
    public void aiStep() {
        UpdateWithAttack();
        super.aiStep();
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EndersentEntity.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));


        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 40, 54, 12F) {
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && FlameDrifterEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && FlameDrifterEntity.this.getTarget() != null && getNextShootType() == 1;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 76, 76, 5F) {
            @Override
            public void stop() {
                randomizeAttacks();
                spin_cooldown = SPIN_COOLDOWN;
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && FlameDrifterEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && FlameDrifterEntity.this.getTarget() != null && spin_cooldown <=0;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 40, 54, 12F) {
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && FlameDrifterEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && FlameDrifterEntity.this.getTarget() != null && getNextShootType() == 2;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoalMin(this, 0, 5, 0, 53, 53, 12F,5) {
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();

            }

            public boolean canUse() {
                return super.canUse() && FlameDrifterEntity.this.getRandom().nextFloat() * 100.0F < 16.0F
                        && FlameDrifterEntity.this.getTarget() != null;
            }
        });
    }

    public void randomizeAttacks() {
        setRandomNextShootType(2);
    }

    public int nextShootType = 1;

    public int getNextShootType() {
        return nextShootType;
    }

    public void setRandomNextShootType(int rolls) {
        switch (getRandom().nextInt(rolls)) {
            case 0 -> nextShootType = 1;
            case 1 -> nextShootType = 2;
        }
    }

    public void backStep(float backstepStrenght, float yStrenght) {

        float yaw = (float) Math.toRadians(this.getYRot() + 90);
        Vec3 dodgePos = this.getDeltaMovement().add(backstepStrenght * Math.cos(yaw), yStrenght, backstepStrenght * Math.sin(yaw));
        this.setDeltaMovement(dodgePos.x, dodgePos.y, dodgePos.z);
    }

    public double lastX;
    public double lastY;
    public double lastZ;

    public void saveLastPosition(LivingEntity entity) {
        lastX = entity.getX();
        lastY = entity.getY();
        lastZ = entity.getZ();
    }

    public void teleportToLastPosition() {
        teleport(lastX, lastY, lastZ);
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }

    public void UpdateWithAttack() {

        if (getAttackState() == 2 || getAttackState() == 3) {
            if (attackTicks == 4) {
                playSound(ModSounds.FLAME_DRIFTER_CHARGE_SHOOT.get(), 1, 1.25f);
            }
            float y = (float) (getY() + 0.5f);
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0.75f;
            float offset = getAttackState() == 2 ? 1.75f : -1.75f;

            if (attackTicks == 13) {
                for (int k = 0; k < 3; k++) {
                    float d1 = Mth.sqrt(k);
                    float ran = 0.4f;
                    float r = 0 / 255F;
                    float g = 195 / 255F + random.nextFloat() * ran;
                    float b = 0 / 255F;
                    if (level().isClientSide) {
                        this.level().addParticle(new MovingTrailParticle.TrailData(r, g, b, 0.1f, 0.1f),
                                (getX() + vec * vecX + f * offset), y, (getZ() + vec * vecZ + f1 * offset), Mth.sin(k), 0, d1 * 0.01f);
                    }
                }
            }
            if (attackTicks == 20) {

                if (level().isClientSide) {
                    level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 0, 0, 0);
                }
                playSound(ModSounds.OBLITERATOR_ARM_SHOOT.get(), 1, 1.25f);
                backStep(-0.75f, 0);


                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 15);
                //shootAnnihilationBomb(1f,(float) (getX() + vec * vecX + f * offset), y  ,(float) (getZ() + vec * vecZ + f1 * offset),0);
                shootAnnihilationBomb(1f, (float) (getX() + vec * vecX + f * offset), y, (float) (getZ() + vec * vecZ + f1 * offset), 30);
            }
        }

        if (getAttackState() == 5) {
            if (attackTicks == 10) {
                saveLastPosition(this);

            }
            if (attackTicks == 15) {
                // basicDash(1,1,0,false);
                playSound(ModSounds.CANNON_SHOOT_1.get(), 2, 0.75f);
                calculatedDash(0.55f);
            }
            if (attackTicks > 15 && attackTicks < 22) {
                if (this.level().isClientSide) {
                    float yaw = (float) Math.toRadians(-getYRot() + 180);
                    double theta = (this.getYRot()) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    double spawnX = this.getX() + vecX * 1.5f;
                    double spawnZ = this.getZ() + vecZ * 1.5f;

                    double d0 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().x;
                    double d1 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().y;
                    double d2 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().z;
                    double dist = 2F + random.nextFloat() * 0.2F;
                    double d3 = d0 * dist;
                    double d4 = d1 * dist;
                    double d5 = d2 * dist;
                    this.level().addParticle(new LightningParticle.OrbData(25, 255, 0), this.getX() + d0, this.getY() + 1, this.getZ() + d2, d3, d4, d5);
                    this.level().addParticle(new LightningParticle.OrbData(255, 255, 255), this.getX() + d0, this.getY() + 1, this.getZ() + d2, d3, d4, d5);

                    this.level().addParticle(new Circle.RingData(yaw, 0, 30,
                            0, 1, 0, 1.0f, 40, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY() + 1f, spawnZ, 0, 0, 0);
                }
                float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0;
                float offset = 2;
                float offset2 = -2;

                double dx = getX() + vec * vecX + f * offset;
                double dx2 = getX() + vec * vecX + f * offset2;
                double dy = getY() + 1.5F;
                double dz = getZ() + vec * vecZ + f1 * offset;
                double dz2 = getZ() + vec * vecZ + f1 * offset2;

                float ran = 0.4f;
                float r = 0 / 255F;
                float g = 195 / 255F + random.nextFloat() * ran;
                float b = 0 / 255F;
                if (level().isClientSide) {

                    this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 1f, this.getId())), dx, dy, dz, 0, 0, 0);
                    this.level().addParticle((new AnnihilationBombTrail.OrbData(r, g, b, 0.5F, 1f, this.getId())), dx2, dy, dz2, 0, 0, 0);
                }

                SideAreaAttack(1f, 2, 360, 0, 10, 60, false, true, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.5f);
            }
            if (attackTicks == 34) {
                teleportToLastPosition();
            }
        }
        if (getAttackState() == 6) {
            if (attackTicks > 20 && attackTicks < 50) {
                float a = 0.275f;
                basicDash(a,a,0,false);
                if (tickCount % 5 == 0) {
                    playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.5f);
                    float sweepSize = 1.25f;
                    float sweepRot = 0;
                    createSweep(0, 0, 3, getRandom().nextInt() * 100 < 50, sweepSize, sweepRot);
                    createSweep(0, 0, -3, getRandom().nextInt() * 100 < 50, sweepSize, sweepRot);
                }
                SideAreaAttack(3, 3, 360, 0, 13, 100, false, true, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.5f);
            }


        }
    }

    @Override
    public int attackDelayTicksValue() {
        return 3;
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState leftCannonShootAnimationState = new AnimationState();

    public AnimationState rightCannonShootAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState spinChargeAnimationState = new AnimationState();

    public AnimationState spinAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "left_cannon_shoot") {
            return this.leftCannonShootAnimationState;
        } else if (input == "right_cannon_shoot") {
            return this.rightCannonShootAnimationState;
        } else if (input == "spin_charge") {
            return this.spinChargeAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "spin") {
            return this.spinAnimationState;
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
                        this.leftCannonShootAnimationState.startIfStopped(this.tickCount);
                    }

                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.rightCannonShootAnimationState.startIfStopped(this.tickCount);
                    }

                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.spinChargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.spinAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.leftCannonShootAnimationState.stop();
        this.deathAnimationState.stop();
        rightCannonShootAnimationState.stop();
        spinChargeAnimationState.stop();
        spinAnimationState.stop();
    }

    public void createSweep(float pos, float posOffset, float yHeight, boolean reverse, float scale, float rot) {
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
            double d1 = this.getY() + this.getBbHeight() / 2 + 0.4;
            double d2 = z;
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? rot : 180));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
            this.level().addParticle(new BigAnnihilationSweepParticle.SweepData(this.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);

        }
    }

    public void shootAnnihilationBomb(float velocity, float x, float y, float z, int inaccuracy) {
        if (targetIsNotNull()) {

            SmallAnnihilationBombEntity chorusBomb = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), this.level(), this, 8); // Ustaw BigCannonEntity jako właściciela

            chorusBomb.setPosRaw(x, y, z);

            double d0 = target().getX() - x;

            double d4 = (target().getY() - y) * 0.5f;
            double d1 = target().getBoundingBox().minY + target().getBbHeight() / 2 - chorusBomb.getY();
            double d2 = target().getZ() - z;
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            //chorusBomb.shoot(d0, d1, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);
            chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, velocity, inaccuracy - this.level().getDifficulty().getId() * 4);


            chorusBomb.setOwner(this);
            //chorusBomb.setPos(x, y, z);
            this.level().addFreshEntity(chorusBomb);
        }

    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 8D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    public int deathTime;

    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 45) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(4);
        stopAllAnimationStates();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.THE_WARPED_ONE_HURT2.get();
    }

    public void SideAreaAttack(float range, float height, float arc, float boxOffset, float damage, int brokenShieldTicks, boolean canStun, boolean canlaunch, SoundEvent soundEvent, float pitch) {

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheObliteratorEntity) && entityHit != this) {


                    boolean flag = entityHit.hurt((this.getAttackState() == 14 || this.getAttackState() == 40) ? ModDamageTypes.causeAnnihilationDamage(this, this) :
                            this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FlameDrifterDamageMutliplier.get())));
                    if (flag) {
                        playSound(soundEvent, 1, pitch);
                        if (canlaunch) {
                            entityHit.push(entityHit.getDeltaMovement().x, 0.5f, entityHit.getDeltaMovement().z);
                        }
                        if (getAttackState() == 5) {
                            entityHit.setSecondsOnFire(3);
                        }
                    }

                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    public boolean teleport(double x, double y, double z) {
        if (level() instanceof ServerLevel level) {
            level.sendParticles(ModParticles.TELEPORT_EFFECT.get(), getX(), getY() + this.getBbHeight() / 2, getZ(), 1, 0, 0, 0, 0);
        }

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {

            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.teleportBoolean(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    CameraShakeEntity.cameraShake(level(), position(), 10, 0.1f, 5, 5);
                    this.playSound(SoundEvents.SHULKER_TELEPORT, 4.0F, 1.0F);
                }
            }

            return flag2;

        } else {
            return false;
        }

    }

    public boolean teleportBoolean(double x, double y, double z, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = y;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(x, y, z);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }


            if (flag1) {
                this.teleportTo(x, d3, z);
                EntityUtil.applyServerTeleport(this);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {

            this.teleportTo(d0, d1, d2);
            EntityUtil.applyServerTeleport(this);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte) 46);
            }
            this.getNavigation().stop();

            return true;
        }
    }

    @Override
    public void onAddedToWorld() {
        EntityUtil.applyHealthMultiplier(this, ModConfig.MOB_CONFIG.FlameDrifterHealthMultiplier.get());
        super.onAddedToWorld();
    }

    public boolean isDuringTeleportation() {
        return getAttackState() == 5 && attackTicks >= 34 && attackTicks <= 41;
    }
}
