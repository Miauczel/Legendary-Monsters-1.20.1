package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.UUID;


public class AnnihilationGroundNukeStrikeEntity extends INoRendererEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 20;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(AnnihilationGroundNukeStrikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AnnihilationGroundNukeStrikeEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(AnnihilationGroundNukeStrikeEntity.class, EntityDataSerializers.BOOLEAN);
    public float activateProgress;
    public float prevactivateProgress;

    public AnnihilationGroundNukeStrikeEntity(EntityType<? extends AnnihilationGroundNukeStrikeEntity> p_i50170_1_, Level p_i50170_2_) {
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

    public AnnihilationGroundNukeStrikeEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, int lifeTicks, float damage) {
        this(ModEntities.GROUND_ANNIHILATION_NUKE_STRIKE.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * (180F / (float) Math.PI));
        this.setPos(x, y, z);
        setLifeTicks(lifeTicks);
        setDamage(damage);
    }

    protected void defineSynchedData() {
        this.entityData.define(ATTACK, Boolean.valueOf(false));
        this.entityData.define(ATTACK_STATE, 0);
        this.entityData.define(LIFE, 0);
        this.entityData.define(DAMAGE, 0f);
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

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (lifeTicks == 19) {
                    double d0 = this.getX();
                    double d1 = this.getY() + 4.0D;
                    double d2 = this.getZ();
                    this.level().addAlwaysVisibleParticle(ModParticles.GROUND_ANNIHILATION_NUKE.get(), d0, d1, d2, 0, 0, 0);
                }
                if (this.lifeTicks == 15) {


                }

            }
        } else if (--this.warmupDelayTicks < 0) {

            if (this.warmupDelayTicks == -8) {
                //   AnnihilationPortalEntity portalEntity = new AnnihilationPortalEntity(level(),getX(),getY(),getZ(),0,0,getCaster(),20,15,true,false);
                //  level().addFreshEntity(portalEntity);
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
        if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity && !(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
            if (this.tickCount % 1 == 0) {
                if (livingentity == null) {
                    DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                    float m = ImpactEntity.getMaxHealth() * 0.03f;
                    boolean hurt = ImpactEntity.hurt(damageSource, getDamage() + m);
                    if (hurt) {

                        ImpactEntity.push(0, 1f, 0);
                        EntityUtil.applyPlayerDeltaMovement(ImpactEntity);
                        TheObliteratorUtils.applyAnnihilationEffect(ImpactEntity, ModEffects.ANNIHILATION.get(), 1, false);
                        //ImpactEntity.setDeltaMovement(0,1.3,0);
                        ImpactEntity.setSecondsOnFire(5);
                    }

                } else {
                    if (livingentity.isAlliedTo(ImpactEntity)) {
                        return;
                    }
                    if (!(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                        DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ANNIHILATION), livingentity);
                        float m = getCaster() instanceof Player ? 0 : MathUtils.entityBasedHpDamage(ImpactEntity, ModConfig.MOB_CONFIG.TheObliteratorPortalExplosionHPDamage.get());
                        boolean hurt = ImpactEntity.hurt(damageSource, getDamage() + m);
                        if (hurt) {

                            ImpactEntity.push(0, 1f, 0);
                            EntityUtil.applyPlayerDeltaMovement(ImpactEntity);
                            TheObliteratorUtils.applyAnnihilationEffect(ImpactEntity, ModEffects.ANNIHILATION.get(), 1, false);
                            ImpactEntity.setSecondsOnFire(5);
                            //caster.heal((ImpactEntity.getMaxHealth()*0.001f) + 5);
                        }
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
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.BLAZE_SHOOT, this.getSoundSource(), 0.3F, 1.25F, false);
            }
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
        ATTACK_STATE = SynchedEntityData.defineId(AnnihilationGroundNukeStrikeEntity.class, EntityDataSerializers.INT);
    }

    public static final EntityDataAccessor<Integer> ATTACK_STATE;

    public void setSleep(boolean sleep) {
    }


    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (level().isClientSide)
            this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 15, 0, 1, 0, 1.0f, 30,
                    false, Circle.EnumRingBehavior.SHRINK), getX(), getY(), getZ(), 0, 0, 0);

    }
}