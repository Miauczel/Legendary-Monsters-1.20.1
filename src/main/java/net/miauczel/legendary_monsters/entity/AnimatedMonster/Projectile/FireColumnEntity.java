    package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

    import net.miauczel.legendary_monsters.Particle.ModParticles;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
    import net.miauczel.legendary_monsters.entity.ModEntities;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AmbientEntity;
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
    import net.minecraft.world.entity.AnimationState;
    import net.minecraft.world.entity.Entity;
    import net.minecraft.world.entity.EntityType;
    import net.minecraft.world.entity.LivingEntity;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraftforge.api.distmarker.Dist;
    import net.minecraftforge.api.distmarker.OnlyIn;
    import net.minecraftforge.network.NetworkHooks;

    import javax.annotation.Nullable;
    import java.util.UUID;

    public class FireColumnEntity extends INoRendererEntity {
        private int warmupDelayTicks;
        private boolean sentSpikeEvent;
        private final int life = 0;
        private int lifeTicks = 60;
        private boolean clientSideAttackStarted;
        private LivingEntity caster;
        private UUID casterUuid;

        private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(FireColumnEntity.class, EntityDataSerializers.BOOLEAN);
        public float activateProgress;
        public float prevactivateProgress;

        public FireColumnEntity(EntityType<? extends FireColumnEntity> p_i50170_1_, Level p_i50170_2_) {
            super(p_i50170_1_, p_i50170_2_);
        }

        public FireColumnEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn) {
            this(ModEntities.FIRE.get(), worldIn);
            this.warmupDelayTicks = p_i47276_9_;
            this.setCaster(casterIn);
            this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
            this.setPos(x, y, z);
            if(this.getCaster() instanceof Player) {
                this.lifeTicks =40;
            }
        }

        protected void defineSynchedData() {
            this.entityData.define(ATTACK, Boolean.valueOf(false));
            this.entityData.define(ATTACK_STATE, 0);
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

        /**
         * Called to update the entity's position/logic.
         */
        public void tick() {
            for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
                this.damage(livingentity);
            }
            if (tickCount % 5 ==0) {
            for (int i = 0; i < 0.5f; ++i) {
                double x = this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                double y = this.getY() + 0.5 + (double) (this.random.nextFloat() * this.getBbHeight());
                double z = this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                double motx = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                double moty = 0.5F + this.random.nextFloat() * 2.0F;
                double motz = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                this.level().addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
            }
            }
if (tickCount % 5 ==0) {
   // this.level().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
}
            if (tickCount % 6 ==0) {
               // this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
            this.level().addParticle(ModParticles.FLAME.get(), this.getX(), this.getY(), this.getZ(), 0, 1, 0);
            if(this.lifeTicks == 32) {
                if (!this.isSilent()) {
           //         this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.ICE_SPIKE_EMERGE.get(), this.getSoundSource(), 0.5F, this.random.nextFloat() * 0.2F + 0.85F, false);
                }
            }
            super.tick();
            if (this.getAttackState() == 0) {
            this.setAttackState(1);
            }
            if (this.getAttackState() > 0) {
                ++this.attackTicks;
            }

            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
            prevactivateProgress = activateProgress;

            if (isActivate() && this.activateProgress > 0F) {
                this.activateProgress--;
            }

            if (this.level().isClientSide) {
                if (this.clientSideAttackStarted) {
                    --this.lifeTicks;
                    if (!isActivate() && this.activateProgress < 10F) {
                        this.activateProgress++;
                    }
                    if (this.lifeTicks == 37) {


                    }
                    if (this.lifeTicks == 6) {//old 14
                        this.setActivate(true);

                    }
                }
            } else if (--this.warmupDelayTicks < 0) {
                if (this.warmupDelayTicks == -10) {
                    if(isActivate()) {
                        this.setActivate(false);
                    }
                }
                if (this.warmupDelayTicks < -10 && this.warmupDelayTicks > -30) {

                    for (int i = 0; i < 10; ++i) {
                        double x = this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                        double y = this.getY() + 0.5 + (double) (this.random.nextFloat() * this.getBbHeight());
                        double z = this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                        double motx = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                        double moty = 0.5F + this.random.nextFloat() * 2.0F;
                        double motz = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                        this.level().addParticle(ParticleTypes.FLAME, x, y, z, motx, moty, motz);

                    }

                }


                if (!this.sentSpikeEvent) {
                    this.level().broadcastEntityEvent(this, (byte)4);
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
                        DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this);
                        ImpactEntity.hurt(damageSource, 10);
                        ImpactEntity.setRemainingFireTicks(80);
                    } else {
                        if (livingentity.isAlliedTo(ImpactEntity)) {
                            return;
                        }


                        DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK
                        ), this);
                        if(this.getCaster() instanceof Player) {
                            ImpactEntity.hurt(damageSource, 2);
                        }else {

                            ImpactEntity.hurt(damageSource, 10);
                        }
                        ImpactEntity.setRemainingFireTicks(80);
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
        public AnimationState emergeAnimationState = new AnimationState();

        public AnimationState getAnimationState(String input) {
            if (input == "emerge") {
                return this.emergeAnimationState;
            } else {
                return new AnimationState();
            }
        }
        static {
            ATTACK_STATE = SynchedEntityData.defineId(FireColumnEntity.class, EntityDataSerializers.INT);
        }
        public static final EntityDataAccessor<Integer> ATTACK_STATE;
        public void setSleep(boolean sleep) {
            this.setAttackState(sleep ? 1 : 0);
        }


        @Override
        public void onAddedToWorld() {
            super.onAddedToWorld();
            this.setAttackState(1);
            BlockState block = level().getBlockState(blockPosition().below());
            double d0 = this.getX();
            double d1 = this.getY() + 2D;
            double d2 = this.getZ();
            double d3 = (this.random.nextGaussian() * 0.07D);
            double d4 = (this.random.nextGaussian() * 0.07D);
            double d5 = (this.random.nextGaussian() * 0.07D);
            //this.level().addParticle(ModParticles.WARNING.get(), d0, d1, d2, d3, d4, d5);
        }

        public void setAttackState(int input) {
            this.attackTicks = 0;

            this.entityData.set(ATTACK_STATE, input);
        }
        public int attackCooldown;
        public int attackTicks;

        public int getAttackState() {
            return (Integer)this.entityData.get(ATTACK_STATE);
        }
        public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
            if (ATTACK_STATE.equals(p_21104_)) {
                if (this.level().isClientSide)
                    switch (this.getAttackState()) {
                        case 0 -> this.stopAllAnimationStates();
                        case 1 -> {
                            this.stopAllAnimationStates();
                            this.emergeAnimationState.startIfStopped(this.tickCount);
                        }
                    }
            }

            super.onSyncedDataUpdated(p_21104_);
        }
        public void stopAllAnimationStates() {
            this.emergeAnimationState.stop();

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