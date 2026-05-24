package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
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
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class LightningBoltEntity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 35;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private Entity caster2;
    private UUID casterUuid2;

    private static final EntityDataAccessor<Float> LIFE = SynchedEntityData.defineId(LightningBoltEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(LightningBoltEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Optional<UUID>> CASTER2_UUID = SynchedEntityData.defineId(LightningBoltEntity.class, EntityDataSerializers.OPTIONAL_UUID);

    public float activateProgress;
    public float prevactivateProgress;

    public LightningBoltEntity(EntityType<? extends LightningBoltEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public LightningBoltEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, int life, float setDamage) {
        this(ModEntities.L.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setCaster2(caster2);
        this.setDamage(setDamage);
        lifeTicks = life;
        this.setYRot(p_i47276_8_ * (180F / (float) Math.PI));
        this.setPos(x, y, z);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public float getLife() {
        return entityData.get(LIFE);
    }

    public void setLifeTicks(float lifeTicks) {
        entityData.set(LIFE, lifeTicks);

    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    protected void defineSynchedData() {

        this.entityData.define(LIFE, 0f);
        this.entityData.define(DAMAGE, 0f);
        this.entityData.define(ATTACK, Boolean.valueOf(false));
        this.entityData.define(CASTER2_UUID, Optional.empty());
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

    public void setCaster2(@Nullable Entity caster2) {
        this.caster2 = caster2;
        this.casterUuid2 = (caster2 == null) ? null : caster2.getUUID();
        this.entityData.set(CASTER2_UUID, Optional.ofNullable(this.casterUuid2));

        // System.out.println("setCaster2 called. Server side: " + !this.level().isClientSide + ". Caster2: " + (caster2 != null ? caster2.getName().getString() : "null"));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.hasUUID("Caster2")) {
            this.casterUuid2 = compound.getUUID("Caster2");
            this.entityData.set(CASTER2_UUID, Optional.of(this.casterUuid2)); // Synchronizacja UUID z klientem
        }
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid2 != null) {
            compound.putUUID("Caster2", this.casterUuid2);

        }
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public float heightAB;

    public float GetH() {
        return this.heightAB;
    }

    public boolean GetHH() {
        return this.heightAB > 0;
    }

    public void setH(float h) {
        this.heightAB = h;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (key.equals(CASTER2_UUID)) {
            Optional<UUID> optionalUuid = this.entityData.get(CASTER2_UUID);
            if (optionalUuid.isPresent() && this.level() instanceof ServerLevel serverLevel) {
                Entity entity = serverLevel.getEntity(optionalUuid.get());
                if (entity != null) {
                    this.caster2 = entity;
                    //  System.out.println("Updated caster2 with UUID: " + optionalUuid.get());
                }
            }
        }
    }

    public int getLifeTicks() {
        return this.lifeTicks;
    }

    public boolean ParticleAppeared = false;

    public void tick() {
        if (lifeTicks == 20) {

            if (!this.isSilent()) {
            }
        }
        super.tick();

        prevactivateProgress = activateProgress;

        if (isActivate() && this.activateProgress > 0F) {
            this.activateProgress--;
        }

        if (this.level().isClientSide) {
            if (clientSideAttackStarted) {
                if (!ParticleAppeared) {
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 30, 0.9f, 0.89f, 1, 1.0f, 15, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.1f, getZ(), 0, 0, 0);
                    ParticleAppeared = true;
                }
            }
        }
        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                if (!this.isSilent()) {

                }
                --this.lifeTicks;
                if (!isActivate() && this.activateProgress < 10F) {
                    this.activateProgress++;
                }
                if (this.lifeTicks == 37) {
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
                if (this.lifeTicks == 6) {//old 14
                    this.setActivate(true);

                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -5) {
                if (isActivate()) {
                    this.setActivate(false);
                }
            }
            if (this.warmupDelayTicks < -5 && this.warmupDelayTicks > -30) {
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 6, 0.2D))) {
                    this.damage(livingentity);

                }
            }


            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }

            if (--this.lifeTicks < 0) {
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

    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(LightningBoltEntity.class, EntityDataSerializers.BOOLEAN);


    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getCaster();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null && !(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.INDIRECT_MAGIC), livingentity);
                    if (this.getCaster() instanceof Cloud_GolemEntity) {
                        ImpactEntity.hurt(damageSource, getDamage());

                    } else {
                        ImpactEntity.hurt(damageSource, getDamage());
                    }
                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.INDIRECT_MAGIC), livingentity);
                    if (this.getCaster() instanceof Cloud_GolemEntity && !(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                        ImpactEntity.hurt(damageSource, getDamage());
                    } else {
                        if (!(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster()))
                            ImpactEntity.hurt(damageSource, getDamage());
                    }


                }
            }
        }
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
        if (this.level().isClientSide) {
            // System.out.println("ThunderCloud added to client world");
        } else {
            //   System.out.println("ThunderCloud added to server world");
        }
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