    package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

    import net.miauczel.legendary_monsters.Particle.ModParticles;
    import net.miauczel.legendary_monsters.effect.ModEffects;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;
    import net.miauczel.legendary_monsters.entity.ModEntities;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AmbientEntity;
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
    import net.minecraft.world.effect.MobEffectInstance;
    import net.minecraft.world.entity.*;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraft.world.phys.shapes.VoxelShape;
    import net.minecraftforge.api.distmarker.Dist;
    import net.minecraftforge.api.distmarker.OnlyIn;
    import net.minecraftforge.network.NetworkHooks;

    import javax.annotation.Nullable;
    import java.util.UUID;


    public class ThunderCloud extends AmbientEntity {
        private int warmupDelayTicks;
        private boolean sentSpikeEvent;
        private int lifeTicks = 34;
        private boolean clientSideAttackStarted;
        private LivingEntity caster3;
        private UUID casterUuid3;

        private static final EntityDataAccessor<Integer> ATTACK2 = SynchedEntityData.defineId(ThunderCloud.class, EntityDataSerializers.INT);
        private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(ThunderCloud.class, EntityDataSerializers.BOOLEAN);
        public float activateProgress;
        public float prevactivateProgress;

        public ThunderCloud(EntityType<? extends ThunderCloud> p_i50170_1_, Level p_i50170_2_) {
            super(p_i50170_1_, p_i50170_2_);
        }

        public ThunderCloud(Level worldIn, double x, double y, double z, float p_i47276_8_, int delay, LivingEntity casterIn) {
            this(ModEntities.THUNDER_CLOUD.get(), worldIn);
            this.warmupDelayTicks = delay;
            this.setCaster3(casterIn);
            this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
            this.setPos(x, y, z);
        }
        private final UUID uniqueID = UUID.randomUUID();

        public UUID getUniqueID() {
            return uniqueID;
        }
        protected void defineSynchedData() {
            this.entityData.define(ATTACK, Boolean.valueOf(false));
            this.entityData.define(ATTACK_STATE, 0);

            this.entityData.define(ATTACK2, 0);
        }

        public void setCaster3(@Nullable LivingEntity p_190549_1_) {
            this.caster3 = p_190549_1_;
            this.casterUuid3 = p_190549_1_ == null ? null : p_190549_1_.getUUID();
        }

        @Nullable
        public LivingEntity getCaster3() {
            if (this.caster3 == null && this.casterUuid3 != null && this.level() instanceof ServerLevel) {
                Entity entity = ((ServerLevel)this.level()).getEntity(this.casterUuid3);
                if (entity instanceof LivingEntity) {
                    this.caster3 = (LivingEntity)entity;
                }
            }

            return this.caster3;
        }

        /**
         * (abstract) Protected helper method to read subclass entity data from NBT.
         */
        protected void readAdditionalSaveData(CompoundTag compound) {
            this.warmupDelayTicks = compound.getInt("Warmup");
            if (compound.hasUUID("Owner")) {
                this.casterUuid3 = compound.getUUID("Owner");
            }

        }

        protected void addAdditionalSaveData(CompoundTag compound) {
            compound.putInt("Warmup", this.warmupDelayTicks);
            if (this.casterUuid3 != null) {
                compound.putUUID("Owner", this.casterUuid3);
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
            } while (blockpos.getY() >= Mth.floor(minY) - 1);

            if (flag) {
                if (getCaster3() != null) {
                    Entity entity1 = this;
                    float l = Math.abs((float) this.getY() - (float) this.getCaster3().getY());

                    LightningBoltEntity bolt = new LightningBoltEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this.getCaster3(), 20, l);
                    float p = (float) Math.abs(this.getY() - bolt.getY());
                    bolt.setH(p);// Różnica wysokości
                    this.level().addFreshEntity(bolt);
                }
            }
        }
        public boolean k = false;
        public void tick() {
            if (!this.isAddedToWorld()) {
              //  System.out.println("ThunderCloud is not yet added to the world!");
            }




            if (this.warmupDelayTicks == -22) {
                if (caster3 != null) {
                    EnergyBeamEntity DeathBeam1 = new EnergyBeamEntity(ModEntities.ENERGY_BEAM.get(), this.level(), this.getCaster3(), this.getX(), this.getY(), this.getZ(), (float) ((this.getYRot() - 90) * Math.PI / 180), (float) (90 * Math.PI / 180), 90, 9,6);
                   // this.level().addFreshEntity(DeathBeam1);
                }else{

                }
            }
            if(this.lifeTicks == 32) {
                if (!this.isSilent()) {
                    this.entityData.set(ATTACK2,1);
                    k=true;
                    this.playSound( SoundEvents.LIGHTNING_BOLT_THUNDER,4,1);
                }
            }else {

                this.entityData.set(ATTACK2,0);
            }
            super.tick();
            if (this.getAttackState() == 0) {
            this.setAttackState(1);
            }
            if (this.getAttackState() > 0) {
                ++this.attackTicks;
            }

if (this.entityData.get(ATTACK2)==1) {

}     if (this.attackCooldown > 0) {
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
                        for(int i = 0; i < 80; ++i) {
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
                if (this.warmupDelayTicks == -10) {
                    if (!(getCaster3() instanceof Player)) {
                        if (this.getCaster3() != null) {
                            if (getCaster3() instanceof Mob caster) {
                                if (caster.getTarget() != null) {
                                    int standingOnY = Mth.floor(caster.getTarget().getY());
                                    if (k) {

                                        this.spawnIceSpikesAdvanced(this.getX(), this.getZ(), standingOnY, this.getY(), 0, 0);
                                        k = false;
                                    }
                                }
                            }
                        }
                    }else {
                        if (this.getCaster3() != null) {
                                    int standingOnY = Mth.floor(getCaster3().getY());
                                    if (k) {

                                        this.spawnIceSpikesAdvanced(this.getX(), this.getZ(), standingOnY, this.getY(), 0, 0);
                                        k = false;


                            }
                        }
                    }
                    if(isActivate()) {
                        this.level().addAlwaysVisibleParticle(ModParticles.LB.get(), this.getX(), this.getY() - 2, this.getZ(), 0, 0, 0);
                        this.setActivate(false);
                    }
                }
                if (this.warmupDelayTicks < -10 && this.warmupDelayTicks > -30) {
this.level().addAlwaysVisibleParticle(ModParticles.LB.get(), this.getX(),this.getY() -2 ,this.getZ(),0,0,0);
                    for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {

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
public boolean g = false;
        public boolean isActivate() {
            return this.entityData.get(ATTACK);
        }

        public void setActivate(boolean Activate) {
            this.entityData.set(ATTACK, Activate);
        }

        private void damage(LivingEntity ImpactEntity) {
            LivingEntity livingentity = this.getCaster3();
            if (ImpactEntity.isAlive() && !ImpactEntity.isInvulnerable() && ImpactEntity != livingentity) {
                if (this.tickCount % 5 == 0) {
                    if (livingentity == null) {
                        DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), livingentity);
                        if (this.getCaster3() instanceof Frostbitten_GolemEntity) {
                            ImpactEntity.hurt(damageSource, 5 );

                        }else {ImpactEntity.hurt(damageSource, 3);}
                        ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),60,0));
                    } else {
                        if (livingentity.isAlliedTo(ImpactEntity)) {
                            return;
                        }
                        DamageSource damageSource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), livingentity);
                        if (this.getCaster3() instanceof Frostbitten_GolemEntity) {
                            ImpactEntity.hurt(damageSource, 5);
                           }else {ImpactEntity.hurt(damageSource, 3);}


                        ImpactEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),60,0));
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
            ATTACK_STATE = SynchedEntityData.defineId(ThunderCloud.class, EntityDataSerializers.INT);
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