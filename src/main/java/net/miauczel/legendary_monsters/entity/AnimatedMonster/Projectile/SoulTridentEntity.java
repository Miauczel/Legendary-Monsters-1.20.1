package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SoulTridentEntity extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(SoulTridentEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(SoulTridentEntity.class, EntityDataSerializers.BOOLEAN);
    private ItemStack tridentItem = new ItemStack(Items.TRIDENT);
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;

    public SoulTridentEntity(EntityType<? extends SoulTridentEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SoulTridentEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.SOUL_TRIDENT.get(), pShooter, pLevel);
        this.tridentItem = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_FOIL, pStack.hasFoil());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte) 0);
        this.entityData.define(ID_FOIL, false);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }

    public void tick() {

        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        for (int i = 0; i < 0.5; ++i) {
            if (level().isClientSide) {
                this.level().addParticle(ModParticles.GHOSTLY_SOUL.get(), this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);

            }

        }
        Entity entity = this.getOwner();
        int i = this.entityData.get(ID_LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 vec3 = entity.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015D * (double) i, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }

                double d0 = 0.05D * (double) i;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnTridentTickCount;
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayer) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack getPickupItem() {
        return this.tridentItem.copy();
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    /**
     * Gets the EntityHitResult representing the entity hit
     */
    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onHitEntity(EntityHitResult pResult) {

        Entity entity = pResult.getEntity();

        float f = entity instanceof LivingEntity livingEntity ? 8.0F + MathUtils.entityBasedHpDamage(livingEntity, 3) : 8.0F;
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getDamageBonus(this.tridentItem, livingentity.getMobType());
        }

        Entity entity1 = this.getOwner();
        if (entity instanceof LivingEntity livingEntity && !isAlliedTo(livingEntity)) {
            DamageSource damagesource = ModDamageTypes.causeGhostlyDamage(getOwner(), (LivingEntity) getOwner());

            this.dealtDamage = true;
            SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
            if (entity.hurt(damagesource, f)) {
                if (entity instanceof LivingEntity livingEntity1) {
                    if (getOwner() != null && getOwner() instanceof LivingEntity livingEntity2)  livingEntity2.heal(8);
                    EntityUtil.applyStackingEffect(livingEntity1, ModEffects.SOUL_FRACTURE.get(), 1, 5, MathUtils.toTicks(10));
                }
                if (entity.getType() == EntityType.ENDERMAN) {
                    return;
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity livingentity1 = (LivingEntity) entity;
                    if (entity1 instanceof LivingEntity) {
                        EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                        EnchantmentHelper.doPostDamageEffects((LivingEntity) entity1, livingentity1);
                    }

                    this.doPostHurtEffects(livingentity1);
                }
            }

            this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
            float f1 = 1.0F;
            if (this.level() instanceof ServerLevel && this.level().isThundering() && this.isChanneling()) {
                BlockPos blockpos = entity.blockPosition();
                if (this.level().canSeeSky(blockpos)) {
                    LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
                    if (lightningbolt != null) {
                        lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                        lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer) entity1 : null);
                        this.level().addFreshEntity(lightningbolt);
                        soundevent = SoundEvents.TRIDENT_THUNDER;
                        f1 = 5.0F;
                    }
                }
            }

            this.playSound(soundevent, f1, 1.0F);
        }
    }
    public void spawnSpiralStrike(double max, double gapFill, double inBetweenGapFill, int constantDelay, double delayFactor) {
        for (double t = 0; t < max; t += gapFill) {
            int delay = constantDelay + (int) (t * delayFactor);
            double r =  t * inBetweenGapFill;
            double x = getX() + r * Math.cos(t);
            double y = getY();
            double z = getZ() + r * Math.sin(t);
            this.spawnSoulPillarExplosions(x, y, z, (int) y-1, 0, delay, level());
        }
    }
    private boolean spawnSoulPillarExplosions(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
                if (!world.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.addFreshEntity(new SoulPillarExplosionEntity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, (LivingEntity) this.getOwner(), 20, 8, true));
            return true;
        }
        return false;
    }
    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        spawnSpiralStrike(18, 0.3, 0.65f, 3, 1);
        CameraShakeEntity.cameraShake(level(),position(),10,0.15f,10,5);
        float f9 = (this.random.nextFloat() - 0.5F) * 8.0F;
        float f10 = (this.random.nextFloat() - 0.5F) * 4.0F;
        float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;

        float f8 = (this.random.nextFloat() - 0.75F) * 5.0F;
        float f6 = (this.random.nextFloat() - 0.75F) * 3.0F;
        float f7 = (this.random.nextFloat() - 0.75F) * 5.0F;


        this.level().addParticle(ModParticles.SOUL_EXPLOSION_RED.get(),
                this.getX() + (double) f9, this.getY() + (double) f10, this.getZ() + (double) f2, 0.0D, 0.0D, 0.0D);
        this.level().addParticle(ModParticles.SOUL_EXPLOSION_RED.get(),
                this.getX() + (double) f8, this.getY() + (double) f6, this.getZ() + (double) f7, 0.0D, 0.0D, 0.0D);

        this.level().addParticle(ModParticles.SOUL_EXPLOSION_RED.get(),
                this.getX() + (double) f9, this.getY() + 2.0D + (double) f10, this.getZ() + (double) f2, 0.0D, 0.5D, 0.0D);
        this.level().addParticle(ModParticles.SOUL_EXPLOSION_RED.get(),
                this.getX() + (double) f8, this.getY() + 2.0D + (double) f6, this.getZ() + (double) f7, 0.0D, 0.5D, 0.0D);
        if (!level().isClientSide) {
            if ((pResult instanceof EntityHitResult result && result.getEntity() instanceof BeheadedKnightEntity)) {

            } else {
                if (pResult instanceof BlockHitResult) {
                    discard();
                }
            }
        }
    }

    public boolean isChanneling() {
        return EnchantmentHelper.hasChanneling(this.tridentItem);
    }

    protected boolean tryPickup(Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }

    /**
     * The sound made when an entity is hit by this projectile
     */
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.DRAGON_FIREBALL_EXPLODE;
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void playerTouch(Player pEntity) {
        if (this.ownedBy(pEntity) || this.getOwner() == null) {
            super.playerTouch(pEntity);
        }

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Trident", 10)) {
            this.tridentItem = ItemStack.of(pCompound.getCompound("Trident"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(this.tridentItem));
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Trident", this.tridentItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void tickDespawn() {
        int i = this.entityData.get(ID_LOYALTY);
        if (this.pickup != Pickup.ALLOWED || i <= 0) {
            super.tickDespawn();
        }

    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }
}