package net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.UUID;

public class TheObliteratorCloneEntity extends IHurtingEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 30;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Float> DESTINATION_Z = SynchedEntityData.defineId(TheObliteratorCloneEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_Y = SynchedEntityData.defineId(TheObliteratorCloneEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DESTINATION_X = SynchedEntityData.defineId(TheObliteratorCloneEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(TheObliteratorCloneEntity.class, EntityDataSerializers.BOOLEAN);
    public float activateProgress;
    public float prevactivateProgress;

    public TheObliteratorCloneEntity(EntityType<? extends TheObliteratorCloneEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public TheObliteratorCloneEntity(Level worldIn, double x, double y, double z, float yawRad, int p_i47276_9_, LivingEntity casterIn,
                                     float damage, float destX, float destY, float destZ) {
      this(ModEntities.THE_WARPED_ONE_DUPLICATE.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        float yawDeg = yawRad * (180F / (float)Math.PI) - 90F;
        this.setYRot(yawDeg);
        this.setPos(x, y, z);
        setDestinationX(destX);
        setDestinationY(destY);
        setDestinationZ(destZ);


        setDamage(damage);
    }
    public boolean isGlowing() {
        return this.getSharedFlag(6); // 6 to flaga glowing
    }
public float getDestinationX(){
        return entityData.get(DESTINATION_X);
}
    public float getDestinationY(){
        return entityData.get(DESTINATION_Y);
    }
    public float getDestinationZ(){
        return entityData.get(DESTINATION_Z);
    }
    public void setDestinationX(float destination){
        entityData.set(DESTINATION_X,destination);
    }
    public void setDestinationY(float destination){
        entityData.set(DESTINATION_Y,destination);
    }
    public void setDestinationZ (float destination){
        entityData.set(DESTINATION_Z,destination);
    }
    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.valueOf(false));

        this.entityData.define(DESTINATION_X, 0f);

        this.entityData.define(DESTINATION_Y, 0f);

        this.entityData.define(DESTINATION_Z, 0f);
        super.defineSynchedData();
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }

    }
    public AnimationState emergeAnimationState = new AnimationState();


    public AnimationState getAnimationState(String input) {
        if (input == "emerge") {
            return this.emergeAnimationState;
        }else {
            return new AnimationState();
        }
    }
    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ANIMATIONSTATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAnimationState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        stopAllAnimationStates();
                        this.emergeAnimationState.startIfStopped(this.tickCount);
                    }


                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.emergeAnimationState.stop();

    }
    /**
     * Called to update the entity's position/logic.
     */
    public final ControlledAnim controlledAnim = new ControlledAnim(15);

    public final ControlledAnim RendercontrolledAnim = new ControlledAnim(15);

    public final ControlledAnim RendercontrolledAnim2 = new ControlledAnim(15);

    public final ControlledAnim fade = new ControlledAnim(15);
    @Override
    public int disappearTicks() {
        return 15;
    }
    public void shootDimensionalBomb(float velocity,float x, float y,float z) {
        float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) ;
        double theta = (getYRot()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 1f;
        float offset = 0f;
        if (level().isClientSide){
            level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(),(getX() + vec * vecX + f * offset) ,(getY()+3),(getZ() + vec * vecZ + f1 * offset),0,0,0);
        }
        if (getCaster() instanceof Mob) {
            if (((Mob) getCaster()).getTarget() !=null) {

                AnnihilationBombEntity chorusBomb = new AnnihilationBombEntity(ModEntities.ANNIHILATION_BOMB_ENTITY.get(), this.level(), caster, 12, 0,true);

                chorusBomb.setPosRaw(x, y, z);
                double d0 = getDestinationX() - x;
                double d1 = getDestinationY() - chorusBomb.getY();
                double d2 = getDestinationZ() - z;
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                chorusBomb.shoot(d0, d1 + d3 * 0.2, d2, velocity, 14 - this.level().getDifficulty().getId() * 4);
                chorusBomb.setOwner(this.getCaster());
                //chorusBomb.setPos(x, y, z);
                this.level().addFreshEntity(chorusBomb);
            }
        }
    }
    public void tick() {
        super.tick();
        RendercontrolledAnim2.increaseTimer();
        Vec3 vec3 = new Vec3(getDestinationX(),getDestinationY(),getDestinationZ());
        lookAt(
                EntityAnchorArgument.Anchor.EYES,
                vec3

        );
        float yaw = this.getYRot();
        if (AnimationTicks >23){
            controlledAnim.increaseTimer();
        }
        if (AnimationTicks >13){
            RendercontrolledAnim.increaseTimer();
        }
        if (tickCount > 15){
            fade.increaseTimer();
        }
        if (this.AnimationTicks ==13){

            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.THE_WARPED_ONE_SHOOT.get(), this.getSoundSource(), 0.1F, 1F, false);

            float f = Mth.cos(getYRot() * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(getYRot() * ((float)Math.PI / 180F)) ;
            double theta = (getYRot()) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            float vec = 0f;
            float offset = 0f;
            shootDimensionalBomb(1f,(float) (getX() + vec * vecX + f * offset), (float) (getY()+1.5)  ,(float) (getZ() + vec * vecZ + f1 * offset));
        }
if (AnimationTicks == 6){
    if (level().isClientSide){
        for (int i = 0; i < 40; ++i) {
            BlockState block = level().getBlockState(blockPosition().below());
            double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d1 = this.getY() + 0.03D;
            double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d3 = (this.random.nextGaussian() * 0.07D);
            double d4 = (this.random.nextGaussian() * 0.07D);
            double d5 = (this.random.nextGaussian() * 0.07D);
         //   this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
        }
        //this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 15,
          //      0f, 0.9f, 0.8f, 0.8f, 26f, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.2f, getZ(), 0, 0, 0);

    }
}

        this.prevactivateProgress = this.activateProgress;

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte)4);
                this.sentSpikeEvent = true;
            }

            if (++this.lifeTicks > 55) {
                this.discard();
            }
        }

    }

    public boolean isActivate() {
        return this.entityData.get(ATTACK);
    }

    public void setActivate(boolean Activate) {
        this.entityData.set(ATTACK, Activate);
    }




    /**
     * Handler for
     */
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;

        }
        if (id <= 0){
            lifeTicks = 0;
        }

    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }



    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


public LivingEntity target(){
        if (caster !=null &&  caster instanceof Mob ) {
            return ((Mob) caster).getTarget();
        }else {return null;}
}

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        if(getAnimationState() == 0) {
            this.setAnimationState(1);
        }
    }


    public float getAnimationProgress(float pPartialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int $$1 = this.lifeTicks - 2;
            return $$1 <= 0 ? 1.0F : 1.0F - ((float)$$1 - pPartialTicks) / 20.0F;
        }
    }

}
