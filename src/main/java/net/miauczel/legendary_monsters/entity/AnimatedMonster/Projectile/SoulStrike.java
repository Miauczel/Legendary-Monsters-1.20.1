package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class SoulStrike extends ThrowableProjectile {

    private int lifeTime = 20;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(SoulStrike.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Boolean> IS_RED = SynchedEntityData.defineId(SoulStrike.class, EntityDataSerializers.BOOLEAN);

    public SoulStrike(EntityType<? extends SoulStrike> type, Level worldIn) {
        super(type, worldIn);
    }

    public SoulStrike(Level worldIn, double x, double y, double z,Boolean particleOptions) {
        this(ModEntities.SS.get(), worldIn);
        this.setPos(x, y + 1.5, z);

    }

    public SoulStrike(Level worldIn, LivingEntity throwerIn,Boolean particleOptions) {
        this(ModEntities.SS.get(), worldIn);
        this.setOwner(throwerIn);
        this.setDeltaMovement(0.1D, 0D, 0.1D);
        setRed(particleOptions);

    }


    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        Vec3 vector3d = (new Vec3(pX, pY, pZ)).normalize().add(this.random.nextGaussian() * (double) 0.0075F * (double) pInaccuracy, this.random.nextGaussian() * (double) 0.0075F * (double) pInaccuracy, this.random.nextGaussian()
                * (double) 0.0075F * (double) pInaccuracy).scale((double) pVelocity);
        this.setDeltaMovement(vector3d);
        double d0 = vector3d.horizontalDistance();
        this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI)));
        this.setXRot((float) (Mth.atan2(vector3d.y, d0) * (double) (180F / (float) Math.PI)));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    @Override
    public void shootFromRotation(Entity pShooter, float pX, float pY, float pZ, float pVelocity, float pInaccuracy) {
        float f = -Mth.sin(pY * ((float) Math.PI / 180F)) * Mth.cos(pX * ((float) Math.PI / 180F));
        float f1 = -1.0F;// -MathHelper.sin((pX + pZ) * ((float)Math.PI / 180F));
        float f2 = Mth.cos(pY * ((float) Math.PI / 180F)) * Mth.cos(pX * ((float) Math.PI / 180F));
        this.shoot((double) f, (double) f1, (double) f2, pVelocity, pInaccuracy);
        Vec3 vector3d = pShooter.getDeltaMovement();
        this.setDeltaMovement(this.getDeltaMovement().add(vector3d.x, pShooter.onGround() ? 0.0D : vector3d.y, vector3d.z));
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return this.canHitEntity(pEntity);
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public void tick() {
        if (this.getOwner() != null && !this.getOwner().isAlive()) {
            this.discard();
        } else {

            // this.updateMovement();
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.onUpdateInAir();
        }
        super.tick();
    }

    @Override
    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && pTarget != this.getOwner();
    }

    public boolean isOnFire() {
        return false;
    }
    public ParticleOptions soulParticle = ModParticles.GHOSTLY_SOUL.get();
    public ParticleOptions particleOptions() {
        return soulParticle;

    }

    private void onUpdateInAir() {

        this.lifeTime -= 1;

        if (this.lifeTime <= 0) {
            this.discard();
        }
        BlockPos pos = BlockPos.containing(this.getX(), this.getY() - 1, this.getZ());
        BlockState iblockstate = this.level().getBlockState(pos);
        Entity entity1 = this.getOwner();
        LivingEntity livingonwer = entity1 instanceof LivingEntity ? (LivingEntity) entity1 : null;
        for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5, 0.5, 0.5))) {
            if (this.getOwner() != null) {
                if (this.tickCount % 5 == 0) {
                    if (livingentity != this.getOwner() && livingentity.onGround() && !this.getOwner().isAlliedTo(livingentity) && livingentity.isAlive() && !getOwner().isAlliedTo(livingentity)) {
                        if (livingentity.hurt(ModDamageTypes.causeGhostlyDamage(getOwner(), (LivingEntity) getOwner()), this.getDamage() + MathUtils.entityBasedHpDamage(livingentity,3))) {
                            if (!(this.getOwner() instanceof Player)) {
                                livingonwer.heal( 8);
                            }
                        }


                    }
                }
            }
        }

        if (this.level().isClientSide) {
            for (int i = 0; i < 5; ++i) {
                double x = this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                double y = this.getY() + 0.5 + (double) (this.random.nextFloat() * this.getBbHeight());
                double z = this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                double motx = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                double moty = 0.5F + this.random.nextFloat() * 2.0F;
                double motz = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;

                this.level().addParticle(getRed() ? ModParticles.GHOSTLY_SOUL_RED.get() : ModParticles.GHOSTLY_SOUL.get(), x, y, z, 0, 0, 0);

            }
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    double x = this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                    double y = this.getY() + 0.5 + (double) (this.random.nextFloat() * this.getBbHeight());
                    double z = this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth();
                    double motx = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                    double moty = 0.5F + this.random.nextFloat() * 2.0F;
                    double motz = (this.random.nextFloat() - this.random.nextFloat()) * 3.0F;
                    this.level().addParticle(getRed() ? ModParticles.RED_SOUL_FLAME.get() : ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0, 0);

                }

            }
        }
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0f);

        this.entityData.define(IS_RED, false);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public boolean getRed() {
        return entityData.get(IS_RED);
    }

    public void setRed(boolean damage) {
        entityData.set(IS_RED, damage);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
