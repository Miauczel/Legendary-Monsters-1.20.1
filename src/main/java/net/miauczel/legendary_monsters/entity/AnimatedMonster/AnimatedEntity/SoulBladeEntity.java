package net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

public class SoulBladeEntity extends IHurtingEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 34;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(SoulBladeEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_RED = SynchedEntityData.defineId(SoulBladeEntity.class, EntityDataSerializers.BOOLEAN);

    public float uR = 1f;
    public float uG = 0f;
    public float uB = 0f;

    public boolean getRed() {
        return entityData.get(IS_RED);
    }

    public void setRed(boolean damage) {
        entityData.set(IS_RED, damage);
    }

    public float activateProgress;
    public float prevactivateProgress;

    public SoulBladeEntity(EntityType<? extends SoulBladeEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    @Override
    public int disappearTicks() {
        return 15;
    }

    public int randomRot;


    public SoulBladeEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, float damage, boolean isRed) {
        this(ModEntities.SOUL_BLADE_UNDERGROUND.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * (180F / (float) Math.PI));
        this.setPos(x, y, z);
        setDamage(damage);
        setRed(isRed);
    }

    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.FALSE);

        this.entityData.define(IS_RED, Boolean.FALSE);
        super.defineSynchedData();
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity) entity;
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
        } else {
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
    public void tick() {
        super.tick();
        //  System.out.println("ANIMATION: " + getAnimationState());
        if (lifeTicks > 37) {

        }
        if (AnimationTicks > 12) {
            controlledAnim.increaseTimer();
        }
        if (AnimationTicks == 3) {
            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox()))
                this.damage(livingentity);

            //  playSound(SoundEvents.TOTEM_USE,1,2);
            if (level().isClientSide) {
                for (int i = 0; i < 40; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                }
                this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 15,
                        getRed() ? uR : 0f, getRed() ? uG : 0.9f, getRed() ? uB : 0.8f, 0.8f, 26f, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.2f, getZ(), 0, 0, 0);

            }
        }
        this.prevactivateProgress = this.activateProgress;
        if (this.AnimationTicks == 1) {
            // playSound(ModSounds.PP_SWING.get(),1,1.25f);
        }
        if (lifeTicks > 20 && lifeTicks < 32) {

            if (level().isClientSide)
                for (int i = 0; i < 80; ++i) {
                    BlockState block = level().getBlockState(blockPosition().below());
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d1 = this.getY() + 0.03D;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.07D);
                    double d4 = (this.random.nextGaussian() * 0.07D);
                    double d5 = (this.random.nextGaussian() * 0.07D);
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                }
        }

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;


            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if (getAnimationState() == 0) {
                    this.setAnimationState(1);
                }

            }
            if (this.warmupDelayTicks < -16 && this.warmupDelayTicks > -30) {
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {

                    if (tickCount % 15 == 0) {
                        this.damage(livingentity);
                    }
                }
            }


            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }

            if (++this.lifeTicks > 70) {
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


    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getCaster();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (livingentity == null) {
                DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);


                ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));

            } else {
                if (livingentity.isAlliedTo(ImpactEntity)) {
                    return;
                }
                DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);
                boolean hurt = ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));
                if (hurt) {
                    livingentity.heal(5);
                }
            }

        }
    }


    /**
     * Handler for
     */
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {

        if (id == 4) {
            this.clientSideAttackStarted = true;

        } else if (id <= 1) {
            lifeTicks = 0;
            AnimationTicks = 0;

        } else {
            super.handleEntityEvent(id);
        }
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        Random random = new Random();
        randomRot = random.nextInt(-180, 2);
        for (int i = 0; i < 10; ++i) {
            BlockState block = level().getBlockState(blockPosition().below());
            double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d1 = this.getY() + 0.03D;
            double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
            double d3 = (this.random.nextGaussian() * 0.07D);
            double d4 = (this.random.nextGaussian() * 0.07D);
            double d5 = (this.random.nextGaussian() * 0.07D);
            // this.level().addParticle(ModParticles.GHOSTLY_SOUL.get(), d0, d1, d2, d3, d4, d5);

        }

        double d0 = this.getX();
        double d1 = this.getY() + 2.0D;
        double d2 = this.getZ();
        //  this.level().addAlwaysVisibleParticle(ModParticles.GROUNDSOUL.get(), d0, d1, d2, 0, 0, 0);
        // this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 25, 0f, 0.9f, 0.8f, 0.8f, 15f, false, Circle.EnumRingBehavior.SHRINK), getX(), getY() + 0.2f, getZ(), 0, 0, 0);


    }


    public float getAnimationProgress(float pPartialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int $$1 = this.lifeTicks - 2;
            return $$1 <= 0 ? 1.0F : 1.0F - ((float) $$1 - pPartialTicks) / 20.0F;
        }
    }

}
