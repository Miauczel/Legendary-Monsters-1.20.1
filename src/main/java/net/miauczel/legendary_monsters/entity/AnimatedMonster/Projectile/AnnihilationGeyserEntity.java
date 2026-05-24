package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.UUID;

public class AnnihilationGeyserEntity extends INoRendererEntity {


    public double xPower;
    public double yPower;
    public double zPower;
    private LivingEntity caster;
    private UUID casterUuid;
    private boolean leftOwner;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AnnihilationGeyserEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TRANSPARENCY  = SynchedEntityData.defineId(AnnihilationGeyserEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> TURN_LEFT =
            SynchedEntityData.defineId(AnnihilationGeyserEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> TURN_STRENGTH =
            SynchedEntityData.defineId(AnnihilationGeyserEntity.class, EntityDataSerializers.FLOAT);
    public int maxLife = 20;
    public int lifetick = 0;
    public AnimationState idleAnimationState = new AnimationState();
    public AnnihilationGeyserEntity(EntityType<? extends AnnihilationGeyserEntity> type, Level level) {
        super(type, level);
    }

    public AnnihilationGeyserEntity(EntityType<? extends AnnihilationGeyserEntity> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, Level level, float Yrot) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public AnnihilationGeyserEntity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage, float Yrot, float life) {
        this(ModEntities.ANNIHILATION_GEYSER.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_,Yrot);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setYRot(Yrot);
        maxLife= (int) life;
    }

    public AnnihilationGeyserEntity(EntityType<? extends AnnihilationGeyserEntity> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.5D;
            this.yPower = p_36822_ / d0 * 0.5D;
            this.zPower = p_36823_ / d0 * 0.5D;
        }

    }


    protected void defineSynchedData() {
        this.entityData.define(DAMAGE,0f);
        this.entityData.define(TRANSPARENCY, 0);
        this.entityData.define(TURN_LEFT, true);
        this.entityData.define(TURN_STRENGTH, 4.5f);
    }

    public void setOwner(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity) entity;
            } else {
                this.casterUuid = null;  // Prevents using a deleted entity
            }
        }
        return this.caster;
    }


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public int getTransparency() {
        return this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, trans);
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }
    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getOwner();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                    ImpactEntity.hurt(damageSource, getDamage() );

                    // ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),60,0));
                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }

                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                    float m = ImpactEntity.getMaxHealth() * 0.03f;
                        ImpactEntity.hurt(damageSource, getDamage() + m);
                }
            }
        }
    }
    public void setTurnLeft(boolean left) {
        this.entityData.set(TURN_LEFT, left);
    }
    public boolean isTurnLeft() {
        return this.entityData.get(TURN_LEFT);
    }
    public void setTurnStrength(float strength) {
        this.entityData.set(TURN_STRENGTH, strength);
    }
    public float getTurnStrength() {
        return this.entityData.get(TURN_STRENGTH);
    }
    @Override
    public void tick() {
        if (tickCount %2 == 0) {
            float f = Mth.cos(getYRot() * ((float) Math.PI / 180F));
            float f1 = Mth.sin(getYRot() * ((float) Math.PI / 180F));
            double theta = (getYRot()) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 2;
            float offset = 0;
            if (level().isClientSide) {
                level().addParticle(ModParticles.GROUND_ANNIHILATION_NUKE.get(),
                        (getX() + vec * vecX + f * offset), getY()+2.5f, (getZ() + vec * vecZ + f1 * offset),
                        0, 0, 0);
            }
        }

        super.tick();
        for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox()))
            this.damage(livingentity);


        if (lifetick >= maxLife){
            if (!level().isClientSide) {

                discard();
            }

        }
        if (!level().isClientSide) {
            lifetick++;
            setTransparency(lifetick);
            if (lifetick >= maxLife) {

                return;
            }
        } else {
            idleAnimationState.animateWhen(true, tickCount);
        }

        if (lifetick == maxLife - 3) {
            for (Entity passenger : getPassengers()) {
                passenger.stopRiding();
            }
        }

        if (!leftOwner) {
            leftOwner = checkLeftOwner();
        }

        HitResult hit = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hit.getType() != HitResult.Type.MISS) {
            this.onHit(hit);
        }

        BlockPos posHere  = blockPosition().atY((int) getY());
        BlockPos posBelow = blockPosition().below();
        BlockState stateHere  = level().getBlockState(posHere);
        BlockState stateBelow = level().getBlockState(posBelow);
        if (stateHere.getBlock() instanceof FireBlock || stateBelow.getBlock() instanceof FireBlock) {
            onFire = true;
        }

        LivingEntity owner = getOwner();
        if (owner != null && !owner.isAlive()) {
            if (!level().isClientSide) {
                level().broadcastEntityEvent(this, (byte)10);
                this.discard();
               // System.out.println("AddingEntity");
                AnnihilationPortalEntity portalEntity = new AnnihilationPortalEntity(level(),getX(),getY(),getZ(),0,5,getOwner(),40,15,true,2);
              level().addFreshEntity(portalEntity);
            }
            return;
        }

        float turnStrength = getTurnStrength();
        float deltaYaw      = isTurnLeft() ? -turnStrength : turnStrength;
        float newYaw        = getYRot() + deltaYaw;
        setYRot(newYaw);

        double rad   = Math.toRadians(deltaYaw);
        double cos   = Math.cos(rad);
        double sin   = Math.sin(rad);

        Vec3 oldVel = getDeltaMovement();
        Vec3 drifted = new Vec3(
                oldVel.x * cos - oldVel.z * sin,
                oldVel.y,
                oldVel.x * sin + oldVel.z * cos
        );

        double thrustMag = Math.sqrt(xPower*xPower + zPower*zPower);
        double yawRad    = Math.toRadians(newYaw);
        Vec3 forward = new Vec3(
                -Math.sin(yawRad) * thrustMag,
                0,
                Math.cos(yawRad) * thrustMag
        );
        Vec3 newVel = drifted.scale(getInertia()).add(forward);
        setDeltaMovement(newVel);

        move(MoverType.SELF, newVel);
    }

    boolean hasHurt = false;
    protected void onHitEntity(EntityHitResult p_37626_) {

        if (!this.level().isClientSide) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            if (entity1 instanceof LivingEntity livingentity) {
                entity.hurt(this.damageSources().mobAttack(livingentity), this.getDamage());
                this.setDeltaMovement(0.0D, 0.0D, 0.0D);

                if (entity1 instanceof LivingEntity) {
                }
            }

        }
    }


    protected void onHitBlock(BlockHitResult result) {

    }


    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)p_37260_);
            hasHurt = true;
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, p_37260_.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return canHit(p_36842_) && !p_36842_.noPhysics;
    }


    protected boolean canHit(Entity p_37250_) {
        if (!p_37250_.canBeHitByProjectile()) {
            return false;
        } else {
            Entity entity = this.getOwner();
            return entity == null || this.leftOwner ;
        }
    }



    protected float getInertia() {
        return 0.9F;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.contains("power", 9)) {
            ListTag listtag = compound.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
        compound.put("power", this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));

    }

    private boolean checkLeftOwner() {
        Entity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.level().getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (p_234613_0_) -> {
                return !p_234613_0_.isSpectator() && p_234613_0_.isPickable();
            })) {
                if (entity1.getRootVehicle() == entity.getRootVehicle()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {

        return false;
    }
    @Override
    public boolean shouldRiderSit() {
        return false;
    }
    public boolean inWater() {
        return false;
    }
    public boolean onFire = false;
    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, 0, this.zPower), 0.0D);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
    }

}