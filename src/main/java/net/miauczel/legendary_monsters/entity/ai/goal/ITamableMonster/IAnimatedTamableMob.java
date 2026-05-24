package net.miauczel.legendary_monsters.entity.ai.goal.ITamableMonster;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

public class IAnimatedTamableMob extends TamableAnimal {
    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(IAnimatedTamableMob.class, EntityDataSerializers.INT);
    protected boolean dropAfterDeathAnim = false;
    private int killDataRecentlyHit;
    private DamageSource killDataCause;
    private Player killDataAttackingPlayer;
    public int attackTicks;
    public int attackCooldown;
    public int customDeathTime;

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }
    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        }else {
            super.handleEntityEvent(id);
        }
    }
    public void stopAttackingAllies(){
        if (this.getTarget() != null ){
            if (getTarget() instanceof TamableAnimal){
                if (getOwner() !=null && ((TamableAnimal)getTarget()).getOwner() == this.getOwner()){
                    setTarget(null);
                }
            }
        }
    }
    public IAnimatedTamableMob(EntityType entity, Level world) {
        super(entity, world);
    }
    public void SpawnCircleParticle(float vec, float math,float size,boolean blockParticles,float blockParticleSize,float r,float g,float b,float a) {
        if (this.level().isClientSide) {

            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = blockParticleSize * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = blockParticleSize * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());

                if (block.getRenderShape() != RenderShape.INVISIBLE && blockParticles) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }

            this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 35, r, g, b, a, 1f * size, false, Circle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }

    public int getAttackState() {
        return (Integer)this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
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

    }
    public int getAttackTicks(){
        return this.attackTicks;
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * 57.29577951308232 + 90.0;
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }

    protected void repelEntities(float x, float y, float z, float radius) {
        List<LivingEntity> nearbyEntities = this.getEntityLivingBaseNearby((double)x, (double)y, (double)z, (double)radius);
        Iterator var6 = nearbyEntities.iterator();

        while(var6.hasNext()) {
            Entity entity = (Entity)var6.next();
            if (entity.isPickable() && !entity.noPhysics) {
                double angle = (this.getAngleBetweenEntities(this, entity) + 90.0) * Math.PI / 180.0;
                entity.setDeltaMovement(-0.1 * Math.cos(angle), entity.getDeltaMovement().y, -0.1 * Math.sin(angle));
            }
        }

    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    public void push(Entity entityIn) {
        if (!this.isSleeping() && !this.isPassengerOfSameVehicle(entityIn) && !entityIn.noPhysics && !this.noPhysics) {
            double d0 = entityIn.getX() - this.getX();
            double d1 = entityIn.getZ() - this.getZ();
            double d2 = Mth.absMax(d0, d1);
            if (d2 >= 0.009999999776482582) {
                d2 = (double)Mth.sqrt((float)d2);
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

    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), (e) -> {
            return e != this && (double)this.distanceTo(e) <= r + (double)(e.getBbWidth() / 2.0F) && e.getY() <= this.getY() + dY;
        });
    }


}
