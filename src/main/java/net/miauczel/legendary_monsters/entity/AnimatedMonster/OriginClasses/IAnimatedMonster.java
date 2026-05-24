package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LMFallingBlockEntity;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.util.ParticleUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Iterator;
import java.util.List;


public class IAnimatedMonster extends Monster {
    public static void applyEffectTo(LivingEntity livingEntity, MobEffect mobEffect, int timeInSeconds, int amplifier) {
        int i = timeInSeconds * 20;
        livingEntity.addEffect(new MobEffectInstance(mobEffect, i, amplifier));
    }

    public void sendBasicHotBarMessage(String message, Player player) {
        net.minecraft.network.chat.Component messageComponent =
                Component.translatable(message);
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));
    }

    public void sendAdvancedHotBarMessage(String message, ChatFormatting chatFormatting, float PlayerRange) {
        List<Player> list = level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(PlayerRange));
        for (Player player : list) {
            net.minecraft.network.chat.Component messageComponent =
                    Component.translatable(message).withStyle(chatFormatting);
            if (player instanceof ServerPlayer serverPlayer)
                serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(messageComponent));
        }
    }

    public void advancedDash(LivingEntity livingEntity, float vec, float offset, float Vscale) {
        float f = Mth.cos(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(livingEntity.yBodyRot * ((float) Math.PI / 180F));
        double theta = (livingEntity.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        Vec3 rollPos = new Vec3(livingEntity.getX() + vec * vecX + f * offset, getY(), livingEntity.getZ() + vec * vecZ + f1 * offset);
        Vec3 sub = position().subtract(rollPos);
        Vec3 finalPos = sub.scale(Vscale);
        setDeltaMovement(finalPos.x, getDeltaMovement().y, finalPos.z);
    }

    @Override
    protected boolean canRide(Entity pVehicle) {
        return false;
    }

    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(IAnimatedMonster.class, EntityDataSerializers.INT);
    protected boolean dropAfterDeathAnim = false;
    private int killDataRecentlyHit;
    private DamageSource killDataCause;
    private Player killDataAttackingPlayer;
    public int attackTicks;
    public int attackDelayTicks;
    public int attackCooldown;
    public int customDeathTime;

    public int attackDelayTicksValue() {
        return 0;
    }

    public int getAttackDelayTicks() {
        return attackDelayTicks;
    }

    public void applyStackingEffect(LivingEntity entity, MobEffect effect, int bonusLevel, int maxLevel, int duration) {

        MobEffectInstance effectInstance = entity.getEffect(effect);

        if (entity.hasEffect(effect) && effectInstance != null) {

            int effectLevel = effectInstance.getAmplifier();
            if (effectLevel < maxLevel) {
                entity.addEffect(new MobEffectInstance(effect, duration, effectLevel + bonusLevel));
            }
        } else if (!(entity.hasEffect(effect) && effectInstance != null)) {
            entity.addEffect(new MobEffectInstance(effect, duration, 0));
        }
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    public boolean targetIsNotNull() {
        return this.getTarget() != null;
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }

    public void SpawnDamagingBlocks(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            LMFallingBlockEntity fallingBlockEntity = new LMFallingBlockEntity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(level().damageSources().mobAttack(this), 11 * damage + Math.min(11 * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        } else if (id <= 1) {
            this.attackDelayTicks = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }

    public LivingEntity target() {
        return getTarget();
    }

    public double yaw() {
        return Math.toRadians(-yBodyRot + 90);
    }

    public double pitch() {
        return Math.toRadians(-getXRot() + 90);
    }

    public boolean isTargetCheesing(float minHeight, float maxHeight) {
        /**
         * Difference between target y and boss y
         * maxHeight = the output of the difference for the value above the boss
         * minHeight = the output of the difference for the value below the boss
         * */
        return targetIsNotNull() && (target().getY() - getY() >= maxHeight || target().getY() - getY() <= minHeight);

        // return targetIsNotNull() && (target().getY() - target().getY() >= maxHeight);
    }

    public void launch(LivingEntity entity, boolean huge) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = huge ? 2.0F : 0.5F;
        entity.push(deltaX / distanceSquared * (double) multiplier, huge ? 0.5 : 0.2, deltaZ / distanceSquared * (double) multiplier);
    }

    public void launch(LivingEntity entity, float Vxz, float Vy) {
        double deltaX = entity.getX() - this.getX();
        double deltaZ = entity.getZ() - this.getZ();
        double distanceSquared = Math.max(deltaX * deltaX + deltaZ * deltaZ, 0.0001);
        float multiplier = Vxz;
        entity.push(deltaX / distanceSquared * (double) multiplier, Vy, deltaZ / distanceSquared * (double) multiplier);
    }

    public void calculatedDash(float Multiplier) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((target.getX() - this.getX()) * Multiplier, 0, (target.getZ() - this.getZ()) * Multiplier);
        }
    }

    public void calculatedDashToPositon(float Multiplier, Vec3 position) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.setDeltaMovement((position.x - this.getX()) * Multiplier, 0, (position.z - this.getZ()) * Multiplier);
        }
    }

    public void calculatedDashToScaledVec(float scale, Vec3 position) {
        LivingEntity target = this.getTarget();
        if (target != null) {
            Vec3 start = position().subtract(position);
            Vec3 end = start.scale(scale);
            this.setDeltaMovement((position.x - end.x), 0, (position.z - end.x));
        }
    }

    public void basicDash(float a1, float a2, float minD, boolean cap) {
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if (this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD && cap) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                } else {
                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
        }
    }

    public void basicDash(float a, float minD, boolean cap) {
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if (this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD && cap) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a).add(vector3d.scale(a));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                } else {
                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a).add(vector3d.scale(a));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }
        }
    }

    public void spawnCircleParticle(float vec, float math, float size, boolean blockParticles, float blockParticleSize, float r, float g, float b, float a) {
        if (this.level().isClientSide) {

            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = 1 + getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = blockParticleSize * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = blockParticleSize * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());

                if (block.getRenderShape() != RenderShape.INVISIBLE && blockParticles) {
                  // ParticleUtils.controlledSmashParticles(level(), hit, (int) (size * 2), size);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }

            this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 35, r, g, b, a, 1f * size, false, Circle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    public void spawnCircleParticle(float vec, float math, float size, boolean blockParticles, float blockParticleSize, float r, float g, float b, float a, Circle.EnumRingBehavior enumRingBehavior, int life) {
        if (this.level().isClientSide) {

            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = 1 + getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = blockParticleSize * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = blockParticleSize * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());

                if (block.getRenderShape() != RenderShape.INVISIBLE && blockParticles) {
                  //  ParticleUtils.controlledSmashParticles(level(), hit, (int) (size * 2), size);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }

            this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, life, r, g, b, a, 1f * size, false, enumRingBehavior), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    public void spawnCircleParticle(float vec, float math, float size, boolean blockParticles, float blockParticleSize, float r, float g, float b, float a, Circle.EnumRingBehavior enumRingBehavior, int life, double y, boolean facing) {
        if (this.level().isClientSide) {

            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = 1 + getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = blockParticleSize * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = blockParticleSize * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());

                if (block.getRenderShape() != RenderShape.INVISIBLE && blockParticles) {
                    // ParticleUtils.controlledSmashParticles(level(), hit, (int) (size * 2), size);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }

            this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, life, r, g, b, a, 1f * size, facing, enumRingBehavior), getX() + vec * vecX + f * math, getY() + y, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    public IAnimatedMonster(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }

    public int getAttackState() {
        return (Integer) this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.attackDelayTicks = attackDelayTicksValue();
        this.entityData.set(ATTACK_STATE, input);

        this.level().broadcastEntityEvent(this, (byte) -input);
    }


    public void tick() {
        super.tick();
        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }

        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (this.attackDelayTicks > 0) {
            --this.attackDelayTicks;
        }

    }


    public int getAttackTicks() {
        return this.attackTicks;
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * 57.29577951308232 + 90.0;
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player) livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }

    protected void repelEntities(float x, float y, float z, float radius) {
        List<LivingEntity> nearbyEntities = this.getEntityLivingBaseNearby((double) x, (double) y, (double) z, (double) radius);
        Iterator var6 = nearbyEntities.iterator();

        while (var6.hasNext()) {
            Entity entity = (Entity) var6.next();
            if (entity.isPickable() && !entity.noPhysics) {
                double angle = (this.getAngleBetweenEntities(this, entity) + 90.0) * Math.PI / 180.0;
                entity.setDeltaMovement(-0.1 * Math.cos(angle), entity.getDeltaMovement().y, -0.1 * Math.sin(angle));
            }
        }

    }

    public boolean canBePushedByEntity(Entity entity) {
        return !isVehicle();
    }

    @Override
    public void push(double pX, double pY, double pZ) {
        if (!isVehicle()) {
            super.push(pX, pY, pZ);
        } else {
        }

    }

    public void push(Entity entityIn) {
        if (!isVehicle()) {
            if (!this.isSleeping() && !this.isPassengerOfSameVehicle(entityIn) && !entityIn.noPhysics && !this.noPhysics) {
                double d0 = entityIn.getX() - this.getX();
                double d1 = entityIn.getZ() - this.getZ();
                double d2 = Mth.absMax(d0, d1);
                if (d2 >= 0.009999999776482582) {
                    d2 = (double) Mth.sqrt((float) d2);
                    d0 /= d2;
                    d1 /= d2;
                    double d3 = 1.0 / d2;
                    if (d3 > 1.0) {
                        d3 = 1.0;
                    }

                    d0 *= d3;
                    d1 *= d3;
                    d0 *= 0.05000000074505806;
                    d1 *= 0.05000000074505806;
                    if (!this.isVehicle() && this.canBePushedByEntity(entityIn)) {
                        this.push(-d0, 0.0, -d1);
                    }

                    if (!entityIn.isVehicle()) {
                        entityIn.push(d0, 0.0, d1);
                    }
                }
            }
        } else {

        }

    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {

        if (this.isVehicle()) return false;
        return super.hurt(pSource, pAmount);
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double) this.distanceTo(e) <= r + (double) (e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }


}
