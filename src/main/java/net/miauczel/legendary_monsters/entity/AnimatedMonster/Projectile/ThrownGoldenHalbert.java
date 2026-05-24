package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ThrownGoldenHalbert extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(ThrownGoldenHalbert.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownGoldenHalbert.class, EntityDataSerializers.BOOLEAN);
    private ItemStack halbertitem = new ItemStack(ModItems.GOLDEN_HALBERT.get());
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;

    public ThrownGoldenHalbert(EntityType<? extends ThrownGoldenHalbert> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownGoldenHalbert(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.GOLDEN_HALBERT.get(), pShooter, pLevel);
        this.halbertitem = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_FOIL, pStack.hasFoil());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte) 0);
        this.entityData.define(ID_FOIL, false);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
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

    @Override
    protected ItemStack getPickupItem() {
        return this.halbertitem.copy();
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        float damage = 8.0F;
        if (entity instanceof LivingEntity livingEntity) {
            damage += EnchantmentHelper.getDamageBonus(this.halbertitem, livingEntity.getMobType());
        }

        Entity owner = this.getOwner();
        DamageSource damageSource = this.damageSources().trident(this, owner == null ? this : owner);
        this.dealtDamage = true;

        boolean isInvulnerable = entity.isInvulnerableTo(damageSource);

        if (entity instanceof LivingEntity && !isInvulnerable && Math.random() < 0.5) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 80, 0));
        }
        entity.hurt(damageSource, damage);


    SoundEvent soundEvent = SoundEvents.TRIDENT_HIT;
        if (entity.hurt(damageSource, damage)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingEntityHit) {
                if (owner instanceof LivingEntity livingEntityOwner) {
                    EnchantmentHelper.doPostHurtEffects(livingEntityHit, livingEntityOwner);
                    EnchantmentHelper.doPostDamageEffects(livingEntityOwner, livingEntityHit);
                }

                this.doPostHurtEffects(livingEntityHit);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.1D, -0.01D, -0.1D));
        float volume = 1.0F;

        if (this.level() instanceof ServerLevel serverLevel && this.level().isThundering()) {
            BlockPos blockPos = entity.blockPosition();
            if (this.level().canSeeSky(blockPos)) {
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (lightningBolt != null) {
                    lightningBolt.moveTo(Vec3.atBottomCenterOf(blockPos));
                    lightningBolt.setCause(owner instanceof ServerPlayer ? (ServerPlayer) owner : null);
                    this.level().addFreshEntity(lightningBolt);
                    soundEvent = SoundEvents.TRIDENT_THUNDER;
                    volume = 5.0F;
                }
            }
        }

        this.playSound(soundEvent, volume, 1.0F);
    }

    @Override
    protected boolean tryPickup(Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void playerTouch(Player pEntity) {
        if (this.ownedBy(pEntity) || this.getOwner() == null) {
            super.playerTouch(pEntity);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Trident", 10)) {
            this.halbertitem     = ItemStack.of(pCompound.getCompound("Trident"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(this.halbertitem));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Trident", this.halbertitem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }


    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

    @Override
    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }
}
