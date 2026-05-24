
package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnnihilationBeamEntity extends Entity {
    public double RADIUS = entityData.get(B_RADIUS);
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;

    public ControlledAnim appear = new ControlledAnim(3);

    public ControlledAnim appearVisual = new ControlledAnim(3);
    public ControlledAnim disappear = new ControlledAnim(3);
    public boolean on = true;

    public Direction blockSide = null;

    public void setRadius(float radius) {
        entityData.set(B_RADIUS, radius);
        // RADIUS =radius;
    }

    private static final EntityDataAccessor<Integer> DELAY = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HEAD = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FIRE = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Float> B_RADIUS = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Float> ADDITIONAL_ROTATION = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Boolean> RIGHT_TURN_FIRST = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Float> PRECENTAGE = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> FOLLOW_SPEED = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> IS_QUAD = SynchedEntityData.defineId(AnnihilationBeamEntity.class, EntityDataSerializers.BOOLEAN);

    public void setDelay(int delay) {
        entityData.set(DELAY, delay);
    }

    public int getDelay() {
        return entityData.get(DELAY);
    }

    public void setFollowSpeed(float followSpeed) {
        entityData.set(FOLLOW_SPEED, followSpeed);
    }

    public float getAdditionalRotation() {
        return entityData.get(ADDITIONAL_ROTATION);
    }

    public void setAdditionalRotation(float additionalRotation) {
        entityData.set(ADDITIONAL_ROTATION, additionalRotation);
    }

    public float getTurnBackPrecentage() {
        return entityData.get(PRECENTAGE);
    }

    public void setTurnBackPrecentage(float additionalRotation) {
        entityData.set(PRECENTAGE, additionalRotation);
    }

    public float getFollowSpeed() {
        return  entityData.get(FOLLOW_SPEED);
    }

    public void setIsQuad(boolean isQuad) {
        entityData.set(IS_QUAD, isQuad);
    }

    public boolean getIsQuad() {
        return entityData.get(IS_QUAD);
    }

    public float prevYaw;
    public float prevPitch;

    @OnlyIn(Dist.CLIENT)
    private Vec3[] attractorPos;

    public AnnihilationBeamEntity(EntityType<? extends AnnihilationBeamEntity> type, Level world) {
        super(type, world);
        noCulling = true;
        if (world.isClientSide) {
            attractorPos = new Vec3[]{new Vec3(0, 0, 0)};
        }
    }


    public AnnihilationBeamEntity(EntityType<? extends AnnihilationBeamEntity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration,
                                  float damage, float Hpdamage, int delay, boolean isQuad, float followSpeed, float additionalRotation, float turnBackAtDurationPrecentage, boolean rightTurnFirst, float r) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setPos(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
        setIsQuad(isQuad);
        setFollowSpeed(followSpeed);
        setDelay(delay);
        setAdditionalRotation(additionalRotation);
        setIsTurningRightFirst(rightTurnFirst);
        setTurnBackPrecentage(turnBackAtDurationPrecentage);
        setRadius(r);
        if (!world.isClientSide) {
            this.setCasterID(caster.getId());
        }
    }

    public float turnBackMoment() {
        return getDuration() * getTurnBackPrecentage();
    }

    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    private void updateWithCaster() {

        if (caster != null) {
            float f = Mth.cos(caster.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(caster.yBodyRot * ((float) Math.PI / 180F));
            double theta = (caster.yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = caster instanceof Player player ? 0 : 1f;
            float offset = 0f;
            if (!getIsQuad()) {
                if (!(caster instanceof Player)) {
                    this.setYaw((float) ((caster.yHeadRot + 90) * Math.PI / 180.0d));
                    this.setPitch((float) (-caster.getXRot() * Math.PI / 180.0d));
                }
            }
            if (!getIsQuad()) {
                if (!(caster instanceof Player)) {
                    this.setPos((caster.getX() + vec * vecX + f * offset), caster instanceof Player player ? player.getY() + 1 : caster.getY() + 2, (caster.getZ() + vec * vecZ + f1 * offset));
                }
            } else {

                this.setPos(caster.getX(), caster.getY() + 2, caster.getZ());
            }
        }
    }

    public void spawnExplosions(float damage, int bulletamount, double amount) {
        if (caster instanceof Mob caster1) {
            LivingEntity livingentity = caster1.getTarget();
            if (livingentity != null) {
                double d3 = Mth.floor(caster1.getY());
                double d0 = Math.min(getY(), this.getY());
                double d1 = Math.max(getY(), this.getY()) + 1.0D;
                float f = (float) Mth.atan2(endPosZ - this.getZ(), endPosX - this.getX());
                for (int l = 0; l < amount; ++l) {
                    double d2 = 4D * (double) (l + 1);
                    int j = 1 * l;
                    float delay = getDuration() * 0.75f;
                    this.spawnEnergyExplosions(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d3, d1, caster1.getYRot(), (int) (getDuration() - delay), damage, bulletamount);
                }
            }
        } else if (caster instanceof Player caster1) {
            System.out.println("ROT: " + caster1.getXRot());
            if (caster1.getXRot() > -20 && caster1.getXRot() < 10) {
                double d3 = Mth.floor(caster1.getY());
                double d0 = Math.min(getY(), this.getY());
                double d1 = Math.max(getY(), this.getY()) + 1.0D;
                float f = (float) Mth.atan2(endPosZ - this.getZ(), endPosX - this.getX());
                for (int l = 0; l < amount; ++l) {
                    double d2 = 4D * (double) (l + 1);
                    int j = 1 * l;
                    float delay = getDuration() * 0.75f;
                    this.spawnEnergyExplosions(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d3, d1, caster1.getYRot(), (int) (getDuration() - delay), damage, bulletamount);
                }
            }
        }

    }

    private void spawnEnergyExplosions(double x, double z, double minY, double maxY, float rotation, int delay, float damage, int bulletamount) {

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

            this.level().addFreshEntity(new AnnihilationExplosionEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, caster, 20, damage, bulletamount));


        }
    }

    @Override
    public void onAddedToWorld() {
        if (getIsQuad()) {
            if (caster != null) {
                setYaw(caster.yBodyRot + getAdditionalRotation());
                setYRot(caster.yBodyRot + getAdditionalRotation());
            }
        }
        if (!getIsQuad()) {
            System.out.println("DistanceToVec3: " + MathUtils.distanceToVec(position(), endPos()));
            // spawnExplosions(10, 2, getRadius());
            Vec3 collidePos = new Vec3(collidePosX, collidePosY, collidePosZ);
            spawnExplosions(8, 2, MathUtils.distanceToVec(position(), endPos()) / MathUtils.PI);
        }
        super.onAddedToWorld();
    }

    public int NextSound = 0;

    public double getRadius() {
        return RADIUS;
    }

    @Override
    public void tick() {
        super.tick();
      //  System.out.println("FLW: " +getFollowSpeed());
        // System.out.println("turnBackMoment: " + turnBackMoment());

        // System.out.println("Duration: " + getDuration());
        // System.out.println("YRot: " + getYRot());
        if (getIsQuad()) {
            if (tickCount >= turnBackMoment()) {

               // setFollowSpeed(Mth.clamp(getFollowSpeed() +0.2f,1,4));
                float newYawDeg = Mth.wrapDegrees(getIsTurningRightFirst() ? getYaw() + getFollowSpeed() : getYaw() - getFollowSpeed());
                setYaw(newYawDeg);
                this.setYRot(newYawDeg);
                renderYaw = (float) Math.toRadians(newYawDeg);
            } else {

            //    setFollowSpeed(Mth.clamp(getFollowSpeed() -0.1f,1,4));
                float newYawDeg = Mth.wrapDegrees(getIsTurningRightFirst() ? getYaw() - getFollowSpeed() : getYaw() + getFollowSpeed());
                setYaw(newYawDeg);
                this.setYRot(newYawDeg);
                renderYaw = (float) Math.toRadians(newYawDeg);
            }
        }

        if (NextSound == 0 && tickCount >= 20) {
            NextSound = 10;
        }
        if (NextSound <= 0) {
            --NextSound;
        }
        if (this.tickCount >= getDuration()) {
            discard();
        }
        if (caster != null) {
            updateWithCaster();
            calculateEndPos();
        }

        if (!on && appear.getTimer() == 0) {


            this.discard();
        }

        if (on && tickCount > getDelay()) {
            appear.increaseTimer();
        } else {
            appear.decreaseTimer();
        }
        if (tickCount - getDelay() > getDuration()) {
            on = false;
        }
        prevCollidePosX = collidePosX;
        prevCollidePosY = collidePosY;
        prevCollidePosZ = collidePosZ;
        prevYaw = renderYaw;
        prevPitch = renderPitch;
        xo = getX();
        yo = getY();
        zo = getZ();
        if (tickCount == 1 && level().isClientSide) {
            caster = (LivingEntity) level().getEntity(getCasterID());
        }
        if (caster != null) {
            if (!(caster instanceof Player)) {
                if (!getIsQuad()) {
                    renderYaw = (float) ((caster.yHeadRot + 90.0d) * Math.PI / 180.0d);
                    renderPitch = (float) (-caster.getXRot() * Math.PI / 180.0d);
                } else {
                    if (!getIsQuad()) {
                        renderYaw = (float) (getYRot() * Math.PI / 180.0d);
                    }
                    renderPitch = (float) (getXRot() * Math.PI / 180.0d);


                }
            } else if (tickCount == 1) {
                if (!getIsQuad()) {
                    renderYaw = (float) ((caster.yHeadRot + 90.0d) * Math.PI / 180.0d);
                    renderPitch = (float) (-caster.getXRot() * Math.PI / 180.0d);
                } else {
                    if (!getIsQuad()) {
                        renderYaw = (float) (getYRot() * Math.PI / 180.0d);
                    }
                    renderPitch = (float) (getXRot() * Math.PI / 180.0d);


                }
            }
        }
        if (caster != null && !caster.isAlive()) discard();

        if (tickCount > getDelay()) {
            if (caster != null) {
                if (caster instanceof Mob caster1) {
                    if (caster1.getTarget() != null) {
                        //  CameraShakeEntity.cameraShake(this.level(), caster1.getTarget().position(), 20.0F, 0.2F, 0, 2);
                    }
                }
            } else {
                CameraShakeEntity.cameraShake(this.level(), position(), 20.0F, 0.2F, 0, 2);
            }
            this.calculateEndPos();
            List<LivingEntity> hit = raytraceEntities(level(), new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ), false, true, true).entities;
            if (blockSide != null) {
                spawnExplosionParticles(5);
                if (!this.level().isClientSide) {
                    for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(collidePosX - 2.5F), Mth.floor(collidePosY - 2.5F), Mth.floor(collidePosZ - 2.5F), Mth.floor(collidePosX + 2.5F), Mth.floor(collidePosY + 2.5F), Mth.floor(collidePosZ + 2.5F))) {
                        BlockState block = level().getBlockState(pos);

                    }
                    if (this.getFire()) {


                    }
                }
            }



            if (!level().isClientSide) {
                for (LivingEntity target : hit) {
                    if (caster != null) {

                        if (!this.caster.isAlliedTo(target) && target != caster) {
                            if (!(target instanceof TamableAnimal animal && animal.getOwner() == caster)) {

                            boolean flag = target.hurt(ModDamageTypes.causeAnnihilationDamage(this, caster), (float) (this.getDamage() + target.getMaxHealth() * (getHpDamage() * 0.01)));
                            if (flag) {
                                TheObliteratorUtils.applyAnnihilationEffect(target, ModEffects.ANNIHILATION.get(),1,false);
                                if (caster instanceof Mob) {
                                }

                                target.setSecondsOnFire(2);
                            }

                            }
                        }
                    }
                }
            }
        }
        if (tickCount - 20 > getDuration() && getIsQuad()) {
            on = false;

        }else {
            on = true;
        }
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 1.5F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);
            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * Mth.cos(yaw);
            float motionZ = velocity * Mth.sin(yaw);
            level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), collidePosX, collidePosY + 0.1, collidePosZ, motionX, motionY, motionZ);
        }

    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(YAW, 0F);
        this.entityData.define(PITCH, 0F);
        this.entityData.define(DURATION, 0);
        this.entityData.define(CASTER, -1);
        this.entityData.define(HEAD, 0);
        this.entityData.define(FIRE, false);
        this.entityData.define(DAMAGE, 0F);
        this.entityData.define(HPDAMAGE, 0F);

        this.entityData.define(B_RADIUS, 30F);

        this.entityData.define(RIGHT_TURN_FIRST, false);
        this.entityData.define(PRECENTAGE, 0F);
        this.entityData.define(ADDITIONAL_ROTATION, 0f);
        this.entityData.define(FOLLOW_SPEED, 0f);
        this.entityData.define(IS_QUAD, false);
        this.entityData.define(DELAY, 0);
    }

    public boolean getIsTurningRightFirst() {
        return entityData.get(RIGHT_TURN_FIRST);
    }

    public void setIsTurningRightFirst(boolean turn) {
        entityData.set(RIGHT_TURN_FIRST, turn);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public float getHpDamage() {
        return entityData.get(HPDAMAGE);
    }

    public void setHpDamage(float damage) {
        entityData.set(HPDAMAGE, damage);
    }


    public float getYaw() {
        return entityData.get(YAW);
    }

    public void setYaw(float yaw) {
        entityData.set(YAW, yaw);
        if (caster instanceof Player) {
            renderYaw = (float) ((caster.yHeadRot + 90.0d) * Math.PI / 180.0d);
            // renderYaw = (float) (getYRot() * Math.PI / 180.0d);
            // renderYaw = entityData.get(YAW);
        }
    }

    public float getPitch() {
        return entityData.get(PITCH);
    }

    public void setPitch(float pitch) {
        entityData.set(PITCH, pitch);
        if (caster instanceof Player) {
            renderPitch = (float) (-caster.getXRot() * Math.PI / 180.0d);
            //renderPitch = (float) (getXRot() * Math.PI / 180.0d);
            //renderPitch = entityData.get(PITCH);
        }
    }

    public int getDuration() {
        return entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        entityData.set(DURATION, duration);
    }

    public int getHead() {
        return entityData.get(HEAD);
    }

    public void setHead(int head) {
        entityData.set(HEAD, head);
    }


    public int getCasterID() {
        return entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        entityData.set(CASTER, id);
    }

    public boolean getFire() {
        return this.entityData.get(FIRE);
    }

    public void setFire(boolean fire) {
        this.entityData.set(FIRE, fire);
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        nbt.putInt("int",getDuration());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        setDuration(nbt.getInt("int"));
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private void calculateEndPos() {
        float r = (caster instanceof Player ? entityData.get(B_RADIUS) / 2 : entityData.get(B_RADIUS));
        if (getIsQuad()) {
            double yawRad = Math.toRadians(getYaw());
            double pitchRad = Math.toRadians(getPitch());
            endPosX = getX() + r * Math.cos(yawRad) * Math.cos(pitchRad);
            endPosZ = getZ() + r * Math.sin(yawRad) * Math.cos(pitchRad);
            endPosY = getY() + r * Math.sin(pitchRad);
        } else {
            if (level().isClientSide()) {
                endPosX = getX() + r * Math.cos(renderYaw) * Math.cos(renderPitch);
                endPosZ = getZ() + r * Math.sin(renderYaw) * Math.cos(renderPitch);
                endPosY = getY() + r * Math.sin(renderPitch);
            } else {
                endPosX = getX() + r * Math.cos(getYaw()) * Math.cos(getPitch());
                endPosZ = getZ() + r * Math.sin(getYaw()) * Math.cos(getPitch());
                endPosY = getY() + r * Math.sin(getPitch());
            }
        }
    }
    private void calculateFakeEndPos() {
        if (getIsQuad()) {
            float r = (caster instanceof Player ? entityData.get(B_RADIUS) / 2 : entityData.get(B_RADIUS));
                double yawRad = Math.toRadians(getYaw());
                double pitchRad = Math.toRadians(getPitch());
                endPosX = getX() + r * Math.cos(yawRad) * Math.cos(pitchRad);
                endPosZ = getZ() + r * Math.sin(yawRad) * Math.cos(pitchRad);
                endPosY = getY() + r * Math.sin(pitchRad);
            }
    }

    private Vec3 endPos() {
        return new Vec3(endPosX, endPosY, endPosZ);
    }
    public LaserbeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) {
        LaserbeamHitResult result = new LaserbeamHitResult();
        result.setBlockHit(world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
        if (result.blockHit != null) {
            Vec3 hitVec = result.blockHit.getLocation();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.blockHit.getDirection();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX),
                Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(1, 1, 1));
        for (LivingEntity entity : entities) {
            if (entity == caster) {
                continue;
            }
            float pad = entity.getPickRadius() + 0.5f;
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    @Override
    public void push(Entity entityIn) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return distance < 1024;
    }

    public static class LaserbeamHitResult {
        private BlockHitResult blockHit;

        public final List<LivingEntity> entities = new ArrayList<>();

        public BlockHitResult getBlockHit() {
            return blockHit;
        }


        public void setBlockHit(HitResult rayTraceResult) {
            if (rayTraceResult.getType() == HitResult.Type.BLOCK)
                this.blockHit = (BlockHitResult) rayTraceResult;
        }

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);

        }
    }
}
