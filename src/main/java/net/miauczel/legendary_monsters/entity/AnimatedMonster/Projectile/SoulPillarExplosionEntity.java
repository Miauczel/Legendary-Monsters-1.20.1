package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
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
import java.util.UUID;


public class SoulPillarExplosionEntity extends INoRendererEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 20;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(SoulPillarExplosionEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(SoulPillarExplosionEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(SoulPillarExplosionEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_RED = SynchedEntityData.defineId(SoulPillarExplosionEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean getRed() {
        return entityData.get(IS_RED);
    }

    public void setRed(boolean damage) {
        entityData.set(IS_RED, damage);
    }

    public float activateProgress;
    public float prevactivateProgress;

    public SoulPillarExplosionEntity(EntityType<? extends SoulPillarExplosionEntity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public void setLifeTicks(int lifeTicks) {
        this.lifeTicks = lifeTicks;
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, damage);
    }

    public float getDamage() {
        return this.entityData.get(DAMAGE);
    }

    public SoulPillarExplosionEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, int lifeTicks, float damage, boolean isRed) {
        this(ModEntities.SOUL_PILLAR_EXPLOSION.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * (180F / (float) Math.PI));
        this.setPos(x, y, z);
        setLifeTicks(lifeTicks);
        setDamage(damage);
        setRed(isRed);
    }

    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.valueOf(false));
        this.entityData.define(ATTACK_STATE, 0);
        this.entityData.define(LIFE, 0);
        this.entityData.define(DAMAGE, 0f);
        this.entityData.define(IS_RED, false);
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

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        if (tickCount == 1) {
            level().addParticle(ModParticles.GROUNDSOUL_RED.get(), getX(), (double) getY() + 2, getZ(), 0, 0, 0);
            this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 25, uR,  uG, uB, 0.8f, 20f, false, Circle.EnumRingBehavior.SHRINK), getX(), getY() + 0.2f, getZ(), 0, 0, 0);
        }
        if (lifeTicks == 19) {
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.SOUL_FLY.get(), this.getSoundSource(), 0.3F, 1.25F, false);
            }
        }
        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (lifeTicks == 19) {
                    for (int i = 0; i < 80; ++i) {
                        BlockState block = level().getBlockState(blockPosition().below());
                        double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                        double d1 = this.getY() + 0.03D;
                        double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                        double d3 = (this.random.nextGaussian() * 0.07D);
                        double d4 = (this.random.nextGaussian() * 0.07D);
                        double d5 = (this.random.nextGaussian() * 0.07D);
                      //  this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);

                    }
                    this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 15, uR, uG, uB, 0.8f, 20f, false, Circle.EnumRingBehavior.GROW), getX(), getY() + 0.2f, getZ(), 0, 0, 0);

                    double d0 = this.getX();
                    double d1 = this.getY() + 2.0D;
                    double d2 = this.getZ();

                    this.level().addAlwaysVisibleParticle(ModParticles.SOUL_PILLAR_EXPLOSION.get(), d0, d1, d2, 0, 0, 0);
                }
                if (this.lifeTicks == 15) {


                }

            }
        } else if (--this.warmupDelayTicks < 0) {

            if (this.warmupDelayTicks == -8) {

            }
            if (this.warmupDelayTicks > -8) {
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox()))
                    this.damage(livingentity);
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

    private void damage(LivingEntity ImpactEntity) {
        LivingEntity livingentity = this.getCaster();
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);
                    if (this.getCaster() instanceof Frostbitten_GolemEntity) {
                        boolean flag = ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));
                        if (flag) {
                            ImpactEntity.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.85f, getDeltaMovement().z);
                            EntityUtil.applyPlayerDeltaMovement(ImpactEntity);

                            EntityUtil.applyStackingEffect((LivingEntity) ImpactEntity, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                            caster.heal((3 + MathUtils.entityBasedHpDamage(ImpactEntity, 1)));
                            // caster.heal((ImpactEntity.getMaxHealth()*0.02f) + 3);
                        }

                    } else {
                        boolean flag = ImpactEntity.hurt(damageSource, getDamage() + MathUtils.entityBasedHpDamage(ImpactEntity, 3));
                        if (flag) {
                            //  caster.heal((ImpactEntity.getMaxHealth()*0.02f) + 3);
                        }
                    }

                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.GHOST), livingentity);
                    boolean hurt = ImpactEntity.hurt(damageSource, getDamage());
                    if (hurt) {

                        EntityUtil.applyStackingEffect((LivingEntity) ImpactEntity, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                        ImpactEntity.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.85f, getDeltaMovement().z);
                        EntityUtil.applyPlayerDeltaMovement(ImpactEntity);
                        caster.heal((4));
                    }

                    if (!level().isClientSide) {
                        //  ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(), 60, 0));
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

        if (id == 4) {
            this.clientSideAttackStarted = true;

        } else if (id <= 0) {
            //  warmupDelayTicks = 0;
            lifeTicks = 0;

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

    public AnimationState emergeAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "emerge") {
            return this.emergeAnimationState;
        } else {
            return new AnimationState();
        }
    }

    static {
        ATTACK_STATE = SynchedEntityData.defineId(SoulPillarExplosionEntity.class, EntityDataSerializers.INT);
    }

    public static final EntityDataAccessor<Integer> ATTACK_STATE;

    public void setSleep(boolean sleep) {
    }

    public float uR = 1f;
    public float uG = 0f;
    public float uB = 0f;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        // this.level().addParticle(new Circle.RingData(0f, (float) Math.PI / 2f, 25,  getRed()? uR : 0f, getRed() ? uG : 0.9f, getRed() ? uB : 0.8f, 0.8f, 20f, false, Circle.EnumRingBehavior.SHRINK), getX(), getY() + 0.2f, getZ(), 0, 0, 0);

        //  this.level().addAlwaysVisibleParticle(ModParticles.SOULSTRIKE.get(), getX(), getY() + 2, getZ(), 0, 0, 0);


    }
}