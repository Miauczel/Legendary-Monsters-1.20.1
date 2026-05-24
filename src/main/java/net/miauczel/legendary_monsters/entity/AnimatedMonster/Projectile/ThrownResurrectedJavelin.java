package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.item.custom.ResurrectedJavelinItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ThrownResurrectedJavelin extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_LOYALTY;
    private static final EntityDataAccessor<Boolean> ID_FOIL;
    private ItemStack tridentItem;
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;

    public ThrownResurrectedJavelin(EntityType<? extends ThrownResurrectedJavelin> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.tridentItem = new ItemStack(ModItems.RESURRECTED_JAVELIN.get());
    }

    public ThrownResurrectedJavelin(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.RESURRECTED_JAVELIN.get(), pShooter, pLevel);
        this.tridentItem = new ItemStack(ModItems.RESURRECTED_JAVELIN.get());
        this.tridentItem = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_FOIL, pStack.hasFoil());

        if (getOwner() !=null) setYRot(getOwner().getYRot());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte)0);
        this.entityData.define(ID_FOIL, false);
    }
    public ParticleOptions getTrailParticle(){
        return ParticleTypes.CLOUD;
    }
    public void tick() {
        if (!inGround) {
            if (this.level().isClientSide) {
                this.level().addParticle(this.getTrailParticle(), getX(), getY() + 0.5D, getZ(), 0.0D, 0.0D, 0.0D);
                if (tickCount % 3 == 0) {
                    float yaw = (float) Math.toRadians(-getYRot() + 180);
                    double theta = (this.getYRot()) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    Vec3 vec3 = getDeltaMovement();
                    double spawnX = this.getX() + vec3.x + vecX * 0.25;
                    double spawnZ = this.getZ() + vec3.z + vecZ * 0.25f;
                    this.level().addParticle(new Circle.RingData(this.horizontalCollision ? 0 : yaw, horizontalCollision ? 90 : 0, 30,
                            1f, 1, 1f, 1f, 10, false, Circle.EnumRingBehavior.GROW_THEN_SHRINK), spawnX, getY(), spawnZ, 0, 0, 0);
                }
            }
        }
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity $$0 = this.getOwner();
        int $$1 = (Byte)this.entityData.get(ID_LOYALTY);
        if ($$1 > 0 && (this.dealtDamage || this.isNoPhysics()) && $$0 != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 $$2 = $$0.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + $$2.y * 0.015 * (double)$$1, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }

                double $$3 = 0.05 * (double)$$1;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add($$2.normalize().scale($$3)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnTridentTickCount;
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity $$0 = this.getOwner();
        if ($$0 != null && $$0.isAlive()) {
            return !($$0 instanceof ServerPlayer) || !$$0.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack getPickupItem() {
        return this.tridentItem.copy();
    }

    public boolean isFoil() {
        return (Boolean)this.entityData.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    protected void onHitEntity(EntityHitResult pResult) {
        Entity $$1 = pResult.getEntity();
        float $$2 = 8.0F;
        if ($$1 instanceof LivingEntity $$3) {
            $$2 += EnchantmentHelper.getDamageBonus(this.tridentItem, $$3.getMobType());
        }

        Entity $$4 = this.getOwner();
        DamageSource $$5 = this.damageSources().trident(this, (Entity)($$4 == null ? this : $$4));
        this.dealtDamage = true;
        SoundEvent $$6 = SoundEvents.TRIDENT_HIT;
        if ($$1.hurt($$5, $$2)) {
            if ($$1.getType() == EntityType.ENDERMAN) {
                return;
            }

            if ($$1 instanceof LivingEntity) {
                LivingEntity $$7 = (LivingEntity)$$1;
                if ($$4 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects($$7, $$4);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)$$4, $$7);
                }

                this.doPostHurtEffects($$7);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        float $$8 = 1.0F;
        if (this.level() instanceof ServerLevel && this.level().isThundering() && this.isChanneling()) {
            BlockPos $$9 = $$1.blockPosition();
            if (this.level().canSeeSky($$9)) {
                LightningBolt $$10 = (LightningBolt)EntityType.LIGHTNING_BOLT.create(this.level());
                if ($$10 != null) {
                    $$10.moveTo(Vec3.atBottomCenterOf($$9));
                    $$10.setCause($$4 instanceof ServerPlayer ? (ServerPlayer)$$4 : null);
                    this.level().addFreshEntity($$10);
                    $$6 = SoundEvents.TRIDENT_THUNDER;
                    $$8 = 5.0F;
                }
            }
        }

        this.playSound($$6, $$8, 1.0F);
    }

    public boolean isChanneling() {
        return EnchantmentHelper.hasChanneling(this.tridentItem);
    }

    protected boolean tryPickup(Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public void playerTouch(Player pEntity) {
        if (this.ownedBy(pEntity) || this.getOwner() == null) {
            super.playerTouch(pEntity);
        }

    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Trident", 10)) {
            this.tridentItem = ItemStack.of(pCompound.getCompound("Trident"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
        this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.tridentItem));
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Trident", this.tridentItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void tickDespawn() {
        int $$0 = (Byte)this.entityData.get(ID_LOYALTY);
        if (this.pickup != Pickup.ALLOWED || $$0 <= 0) {
            super.tickDespawn();
        }

    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }

    static {
        ID_LOYALTY = SynchedEntityData.defineId(ThrownResurrectedJavelin.class, EntityDataSerializers.BYTE);
        ID_FOIL = SynchedEntityData.defineId(ThrownResurrectedJavelin.class, EntityDataSerializers.BOOLEAN);
    }
}
