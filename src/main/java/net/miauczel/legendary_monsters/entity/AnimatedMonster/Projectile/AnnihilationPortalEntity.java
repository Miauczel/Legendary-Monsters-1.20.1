package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationBombTrail;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.INoRendererEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.UUID;


public class AnnihilationPortalEntity extends INoRendererEntity {
    public int warmupDelayTicks = 10;
    private boolean sentSpikeEvent;
    private int lifeTicks = 100;

    public int disappearTicks = 20;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    public boolean is75pLife() {
        return lifeTicks >= lifeTicks * 0.75;
    }

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> TYPE_A = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> TYPE_B = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> IS_DANGEROUS = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> IS_BIG = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Float> SCALE = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.FLOAT);

    public float activateProgress;
    public float prevactivateProgress;

    public AnnihilationPortalEntity(EntityType<? extends AnnihilationPortalEntity> p_i50170_1_, Level p_i50170_2_) {
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

    public AnnihilationPortalEntity(Level worldIn, double x, double y, double z, float p_i47276_8_, int warmup, LivingEntity casterIn, int lifeTicks, float damage, boolean dangerous, float scale) {
        this(ModEntities.ANNIHILATION_PORTAL.get(), worldIn);
        this.warmupDelayTicks = warmup;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * (180F / (float) Math.PI));
        this.setPos(x, y, z);
        setLifeTicks(lifeTicks);
        setDamage(damage);
        setDangerous(dangerous);
        // setIsBig(isBig);
        setScale(scale);
        setWarmupValue(warmup);
    }

    public boolean isA() {
        return entityData.get(TYPE_A);
    }

    public boolean isB() {
        return entityData.get(TYPE_B);
    }

    protected void defineSynchedData() {
        this.entityData.define(TYPE_B, Boolean.valueOf(false));
        this.entityData.define(TYPE_A, Boolean.valueOf(false));
        this.entityData.define(ATTACK, Boolean.valueOf(false));

        this.entityData.define(SCALE, 0f);
        this.entityData.define(ATTACK_STATE, 0);
        this.entityData.define(LIFE, 0);
        this.entityData.define(DAMAGE, 0f);
        this.entityData.define(IS_DANGEROUS, false);

        this.entityData.define(IS_BIG, false);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        this.refreshDimensions();

        super.onSyncedDataUpdated(p_21104_);
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

    public void setDangerous(boolean isDangerous) {
        entityData.set(IS_DANGEROUS, isDangerous);
        // if (level().isClientSide) level().addAlwaysVisibleParticle(ModParticles.ANNIHILATION_GEYSER.get(), getX(),getY(),getZ(),0,0,0);
    }

    public boolean isDangerous() {
        return entityData.get(IS_DANGEROUS);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(CompoundTag compound) {

        this.entityData.set(IS_DANGEROUS, compound.getBoolean("danger"));
        this.entityData.set(IS_BIG, compound.getBoolean("big"));
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putBoolean("danger", this.entityData.get(IS_DANGEROUS));
        compound.putBoolean("big", this.entityData.get(IS_BIG));
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }

    }

    public EntityDimensions getDimensions(Pose pPose) {

        return EntityDimensions.scalable(isBig() ? 5 : 3, isDangerous() ? 4f : 0.5f);

    }

    public float getScale() {
        return entityData.get(SCALE);
    }

    public void setScale(float scale) {
        entityData.set(SCALE, scale);
    }

    @Override
    public void refreshDimensions() {
        super.refreshDimensions();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public float matrixScale() {
        return getScale();
    }

    public int warmupValue;

    public int warmupValue() {
        return warmupValue;
    }

    public void setWarmupValue(int warmupValue) {
        this.warmupValue = warmupValue;
    }

    public boolean isBig() {
        return getScale() == 6 || getScale() == 4;
    }

    public void setIsBig(boolean isBig) {
        entityData.set(IS_BIG, isBig);
        ;
    }

    public ControlledAnim anim = new ControlledAnim(10);
    public int lifeTicks1 = 0;

    public void tick() {
        super.tick();
        lifeTicks1++;
        if (matrixScale() == 4) {
            //Warning

            int warningTick = 43;

            int attackTick = 46;

            if (lifeTicks1 == attackTick) playSound(ModSounds.OMINOUS_EXPLOSION.get(), 1, 1);
            for (int i = warningTick; i <= warningTick + 6; i = i + 2) {
                if (lifeTicks1 == i) {
                    int d = i - (warningTick - 2);
                    flameRadagonShockwave(2f, d, 1f, 2, 0, 0, 17, true);
                }
            }
            //Attack
            for (int i = attackTick; i <= attackTick + 6; i = i + 2) {
                if (lifeTicks1 == i) {
                    int d = i - (attackTick - 2);
                    flameRadagonShockwave(2f, d, 1f, 2, 0, 0, 7, false);
                }
            }
        }
        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
        float ran = 0.4f;
        float r = 0 / 255F;
        float g = 195 / 255F + random.nextFloat() * ran;
        float b = 0 / 255F;
        float scale = (Mth.sin(tickCount * 0.2f) * 0.5f + 0.5f) * matrixScale();

        if (level().isClientSide) {
            this.level().addParticle(
                    new AnnihilationBombTrail.OrbData(r, g, b, scale, 0.2f, this.getId()),
                    dx, dy, dz,
                    scale, scale, scale
            );
        }

        refreshDimensions();

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;

                if (this.lifeTicks == 15) {
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
        }
        if (warmupDelayTicks < -12 && this.isDangerous()) {
            for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(isBig() ? 2.5 : 1.5))) {
                if (entity instanceof LivingEntity livingentity && entity != this.getCaster()) {
                    if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                    if (livingentity != getCaster()) {
                        // System.out.println("test");
                        Vec3 diff = livingentity.position().subtract(this.position().add(0, 0, 0));
                        diff = diff.normalize().scale(2f * 0.015);
                        livingentity.setDeltaMovement(livingentity.getDeltaMovement().subtract(diff));

                        EntityUtil.applyPlayerDeltaMovement(livingentity);

                    }
                }
            }
        }
        if (this.warmupDelayTicks <= -16) {
            if (isDangerous()) {
                if (tickCount % 16 == 0) {
                    if (isBig()) {
                        if (level() instanceof ServerLevel level) {
                            level.sendParticles(ModParticles.ANNIHILATION_NUKE.get(), getX(), getY() + 4f, getZ(), 1, 0, 0, 0, 0);
                        }
                    }
                }
                if (tickCount % 5 == 0) {
                    if (isBig()) {
                        if (level() instanceof ServerLevel level) {
                            double dx1 = getX() + (isBig() ? 6F : 4.5f) * (random.nextFloat() - (isBig() ? 1 : 0.5f));
                            double dy1 = getY() + (isBig() ? 6F : 4.5f) * (random.nextFloat() - (isBig() ? 1 : 0.5f));
                            double dz1 = getZ() + (isBig() ? 6F : 4.5f) * (random.nextFloat() - (isBig() ? 1 : 0.5f));
                            level.sendParticles(ModParticles.ANNIHILATION_NUKE.get(), dx1, getY() + 4f, dz1, 1, 0, 0, 0, 0);
                        }
                    }

                }
                if (tickCount % 8 == 0) {
                    if (level() instanceof ServerLevel level) {
                        if (!isBig())
                            level.sendParticles(ModParticles.ANNIHILATION_NUKE.get(), getX(), getY() + 4f, getZ(), 1, 0, 0, 0, 0);


                    }
                }
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    damage(entity);
                }

            }
            if (this.warmupDelayTicks == -8) {

            }
            if (this.warmupDelayTicks > -8) {
                anim.increaseTimer();

            }
            if (!this.sentSpikeEvent) {

                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }

            if (--this.lifeTicks < 0) {
                this.discard();
                if (caster instanceof Player player && getScale() == 4) {
                    //  playSound(ModSounds.ENERGY_EXPLOSION.get(), 1, 1);
                    int standingOnY = Mth.floor(this.getY());
                }
                if (level() instanceof ServerLevel level) {
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                        damage(entity);
                    }
                    level.sendParticles(ModParticles.GROUND_ANNIHILATION_NUKE.get(), getX(), getY() + 3, getZ(), 1, 0, 0, 0, 0);
                }
            }
        }


    }

    public RandomSource getRandom() {
        return this.random;
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

                if (livingentity != null) {
                    if (livingentity.isAlliedTo(ImpactEntity) || (ImpactEntity instanceof TamableAnimal animal && animal.getOwner() == getCaster())) {
                        return;
                    }
                    float m = (matrixScale() == 2 || ( matrixScale() == 4 && getCaster() instanceof Player player)) ? 0 : MathUtils.entityBasedHpDamage(ImpactEntity, ModConfig.MOB_CONFIG.TheObliteratorPortalHPDamage.get());
                    boolean hurt = ImpactEntity.hurt(ModDamageTypes.causeAnnihilationDamage(livingentity, livingentity), getDamage() + m);//IsBig 20 : 15
                    //         System.out.println("Amount: " + (15 + m));
                    if (warmupDelayTicks == -16) {
                        if (hurt) {
                            TheObliteratorUtils.applyAnnihilationEffect(ImpactEntity, ModEffects.ANNIHILATION.get(), 1, false);
                            livingentity.setDeltaMovement(0, 0.5f, 0);
                            EntityUtil.applyPlayerDeltaMovement(livingentity);
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

        if (id <= 0) {
            this.tickCount = 0;
            lifeTicks = 0;

        } else if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                //    this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.BLAZE_SHOOT, this.getSoundSource(), 0.3F, 1.25F, false);
            }

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
        ATTACK_STATE = SynchedEntityData.defineId(AnnihilationPortalEntity.class, EntityDataSerializers.INT);
    }

    public static final EntityDataAccessor<Integer> ATTACK_STATE;

    public void setSleep(boolean sleep) {
    }


    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
    }

    private void spawnFlames(double x, double z, double minY, double maxY, float rotation, int delay, float damage) {

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
            this.level().addFreshEntity(new AnnihilationGroundNukeStrikeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, this.caster, 20, damage));
        }
    }

    public void doPortalEffect(double multiplier, float size, int amountOfPortals, int warmup, float scale, int life, float damage) {

        for (int k = 0; k < amountOfPortals; ++k) {
            float f3 = (float) k * (float) Math.PI * size / amountOfPortals + ((float) Math.PI * size / 10F);
            int standingOnY = Mth.floor(getY());

            spawnFlames(getX() + Mth.cos(f3) * multiplier, getZ() + Mth.sin(f3) * multiplier, getY() - 5, getY() + 5, life, warmup, damage);
            //this.spawnFlames(getX() + (double) Mth.cos(f3) * multiplier, getZ() + (double) Mth.sin(f3) * multiplier, standingOnY, getY() + 1, f3, 2, 10);

        }
    }

    private void flameRadagonShockwave(float spreadarc, int distance, float vec, int delay, float pos, float offset, float damage, boolean warningParticle) {
        float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
        double theta1 = (this.getYRot()) * (Math.PI / 180);
        theta1 += Math.PI / 2;
        double vecX = Math.cos(theta1);
        double vecZ = Math.sin(theta1);
        int floor = Mth.floor(getY());
        double x = (getX() + pos * vecX + f * offset);
        double z = (getZ() + pos * vecZ + f1 * offset);
        double perpFacing = this.getYRot() * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread * 0.35f);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = x + vx * distance + vec * Math.cos((this.getYRot() + 90) * Math.PI / 180);
            double pz = z + vz * distance + vec * Math.sin((this.getYRot() + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnFlames2(hitX + 0.5D, hitZ + 0.5D, this.getY() - 5, this.getY() + 3, (float) theta, delay, damage, warningParticle, ModParticles.GROUND_ANNIHILATION_NUKE.get());
        }

    }

    private void spawnFlames2(double x, double z, double minY, double maxY, float rotation, int delay, float damage, boolean particle, ParticleOptions particleOptions) {

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
            if (!particle) {
                this.level().addFreshEntity(new AnnihilationGroundNukeStrikeEntity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, getCaster(), 20, damage));
            } else {
                if (level().isClientSide)
                    this.level().addParticle(new Circle.RingData(0, (float) Math.PI / 2f, 30, 0, 1, 0, 1.0f, 30,
                            false, Circle.EnumRingBehavior.SHRINK), x, (double) blockpos.getY() + d0, z, 0, 0, 0);
            }

        }
    }
}