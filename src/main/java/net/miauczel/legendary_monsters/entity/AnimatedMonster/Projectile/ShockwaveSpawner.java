package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

    import net.miauczel.legendary_monsters.config.ModConfig;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AmbientEntity;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Overgrown_colossusEntity;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
    import net.miauczel.legendary_monsters.entity.ModEntities;
    import net.minecraft.core.BlockPos;
    import net.minecraft.core.Direction;
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
    import net.minecraft.sounds.SoundEvents;
    import net.minecraft.util.Mth;
    import net.minecraft.world.damagesource.DamageSource;
    import net.minecraft.world.damagesource.DamageTypes;
    import net.minecraft.world.entity.*;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.Blocks;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraft.world.phys.shapes.VoxelShape;
    import net.minecraftforge.api.distmarker.Dist;
    import net.minecraftforge.api.distmarker.OnlyIn;
    import net.minecraftforge.network.NetworkHooks;

    import javax.annotation.Nullable;
    import java.util.UUID;


    public class
    ShockwaveSpawner extends INoRendererEntity {
        private int warmupDelayTicks;
        private boolean sentSpikeEvent;
        private int lifeTicks = 9;
        private boolean clientSideAttackStarted;
        private LivingEntity caster;
        private UUID casterUuid;

        private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(ShockwaveSpawner.class, EntityDataSerializers.BOOLEAN);
        public float activateProgress;
        public float prevactivateProgress;

        public ShockwaveSpawner(EntityType<? extends ShockwaveSpawner> p_i50170_1_, Level p_i50170_2_) {
            super(p_i50170_1_, p_i50170_2_);
        }
        private BlockState blockState;




        public ShockwaveSpawner(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, boolean poisonous) {
            this(ModEntities.SHOCKWAVE_SPAWNER.get(), worldIn);
            this.warmupDelayTicks = p_i47276_9_;
            this.setCaster(casterIn);
            this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
            this.setPos(x, y, z);

            for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
                this.playSound(SoundEvents.STONE_BREAK, 1.0F, 0.5F);


                this.damage(livingentity);}

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
        private void spawnIceSpikesAdvanced(double x, double z, double minY, double maxY, float rotation, int delay) {

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
            } while(blockpos.getY() >= Mth.floor(minY) - 1);

            if (flag) {
                Entity entity1 = this;
                if (this.getCaster() instanceof Player) {
                    this.level().addFreshEntity(new ShockwaveEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this.getCaster(), false, (float) (7 * ModConfig.MOB_CONFIG.DinosaurBoneClubAbilityDamageMultiplier.get())));
                }else {
                    this.level().addFreshEntity(new ShockwaveEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this.getCaster(), false, 17));

                }
            }
        }
        private boolean ispoisonous;
        public void tick() {

            int standingOnY = Mth.floor(this.getY());
            if (this.lifeTicks == 7) {

                for (int k = 0; k < 1.5D; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 1.5F + ((float) Math.PI * 2F / 1.5F);
                    this.spawnIceSpikesAdvanced(this.getX() + (double) Mth.cos(f2) * 1.5D, this.getZ() + (double) Mth.sin(f2) * 1.5D, standingOnY, this.getY() + 1, f2, 0);
                }}
            if (this.lifeTicks == 4) {

                for (int k = 0; k < 6; ++k) {
                    float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnIceSpikesAdvanced(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
                }
            }if (this.lifeTicks == 1) {
                for (int k = 0; k < 11; ++k) {
                    float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnIceSpikesAdvanced(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 2);
                }
            }
            LivingEntity livingentity1 = this.getCaster();
            if (livingentity1 instanceof Overgrown_colossusEntity){
                this.ispoisonous = true;
            }else{
                this.ispoisonous = false;
            }
            BlockState block = level().getBlockState(blockPosition().below());
            BlockState block2 = Blocks.BAMBOO_BLOCK.defaultBlockState();



            for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {

                }
            if(this.lifeTicks == 32) {
                if (!this.isSilent()) {
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
                    for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
                        this.damage(livingentity);
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
            if (!this.ispoisonous) {
                if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
                    if (this.tickCount % 5 == 0) {
                        if (livingentity == null  && !(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                            DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this.caster);
                            ImpactEntity.hurt(damageSource, 8);

                        } else {
                            if (livingentity.isAlliedTo(ImpactEntity)) {
                                return;
                            }
                            if (!(ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                                DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), this.caster);
                                ImpactEntity.hurt(damageSource, 8);
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
            super.handleEntityEvent(id);
            if (id == 3) {
                for (int i = 0; i < 60; ++i) {
                    double x = this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                    double y = this.getY() + 0.5 + (double) (this.random.nextFloat() * this.getBbHeight());
                    double z = this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                    double motx = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                    double moty = 0.5F + this.random.nextFloat() * 2.0F;
                    double motz = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.blockState), x, y, z, motx, moty, motz);
                }
            }
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
            ATTACK_STATE = SynchedEntityData.defineId(ShockwaveSpawner.class, EntityDataSerializers.INT);
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