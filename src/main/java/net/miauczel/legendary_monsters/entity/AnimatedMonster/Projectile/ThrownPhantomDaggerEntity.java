package net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile;

import net.miauczel.legendary_monsters.Particle.custom.PhantomDaggerTrail;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedApostleEntity;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownPhantomDaggerEntity extends AbstractFlyingProjectile {
    public int clientSideReturnTridentTickCount;

    private static final EntityDataAccessor<Integer> RETURN_TICK = SynchedEntityData.defineId(ThrownPhantomDaggerEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(ThrownPhantomDaggerEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Boolean> IS_RED = SynchedEntityData.defineId(ThrownPhantomDaggerEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean getRed() {
        return entityData.get(IS_RED);
    }

    public void setRed(boolean damage) {
        entityData.set(IS_RED, damage);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(RETURN_TICK, 20);

        entityData.define(IS_RED, false);
        entityData.define(DAMAGE, 0f);
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    public ThrownPhantomDaggerEntity(EntityType<? extends ThrownPhantomDaggerEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    LivingEntity rEntity;

    public LivingEntity returnEntity() {
        return rEntity;
    }

    public void setReturnEntity(LivingEntity returnEntity) {
        if (returnEntity != null) rEntity = returnEntity;
    }

    public ThrownPhantomDaggerEntity(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ, float damage, float interia, int returnTick, boolean isRed) {
        super(null, pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
        setInteria(interia);
        setReturnTick(returnTick);
        setRed(isRed);

    }

    float interia = 1f;

    protected float getInertia() {
        return interia;
    }

    public void setInteria(float interia1) {
        interia = interia1;
    }


    protected float getReturnTick() {
        return entityData.get(RETURN_TICK);
    }

    public void setReturnTick(int returnTick) {
        entityData.set(RETURN_TICK, returnTick);
    }

    protected float getDamage() {
        return getOwner() instanceof Player ? (float) (entityData.get(DAMAGE) * ModConfig.MOB_CONFIG.SoulGreatSwordAbilityDamageMultiplier.get()) : entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public void setNoPhysics(boolean pNoPhysics) {
        this.noPhysics = pNoPhysics;
    }

    public float uR = 195f;
    public float uG = 24f;
    public float uB = 30f;
    public int lessLifeTicks = 0;

    public int getLessLifeTicks() {
        return lessLifeTicks;
    }

    public void setLessLifeTicks(int lessLifeTicks) {
        this.lessLifeTicks = lessLifeTicks;
    }

    public ControlledAnim fade = new ControlledAnim(6);

    @Override
    public void tick() {
        super.tick();
        double finalTick = 100 - getLessLifeTicks() + getReturnTick();
        if (tickCount >= finalTick - 6) {
            fade.increaseTimer();
        }
        if (tickCount >= finalTick) {
            if (!level().isClientSide) discard();
        }
        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
        float ran = 0.4f;
        float r = (getRed() ? uR : 57) / 255F;
        float g = (getRed() ? uG : 190) / 255F;
        float b = (getRed() ? uB : 197) / 255F;
        if (level().isClientSide) {
            this.level().addParticle((new PhantomDaggerTrail.OrbData(r, g, b, 0F, 0.25f, this.getId())), dx, dy, dz, 0, 0, 0);
        }
        if (this.tickCount >= getReturnTick() && returnEntity() != null) {
            this.setNoPhysics(true);
            Vec3 returnPos = new Vec3(returnEntity().getX(), returnEntity().getY() + 1, returnEntity().getZ());
            Vec3 vec3 = returnPos.subtract(this.position());
            this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015D * interia, this.getZ());
            if (this.level().isClientSide) {
                this.yOld = this.getY();
            }

            double d0 = 0.05D * interia;
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));

            ++this.clientSideReturnTridentTickCount;
        }
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
        double theta = (getYRot()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float offset = 0;
        float vec = 1;
        //  ParticleUtils.sendParticlesToServer(level(), ModParticles.SOUL_SHOOT.get(), getX() + vec * vecX + f * offset,getY(),getZ() + vec * vecZ + f1 * offset,1,0,0,0,0);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity target = pResult.getEntity();
        Entity owner = this.getOwner();
        Entity trackedEntity = this.returnEntity();

        if (target instanceof TamableAnimal tamableAnimal && tamableAnimal.getOwner() == owner) return;
        if (owner != null && target == owner && (!(target instanceof TamableAnimal animal && animal.getOwner() == owner)))
            return;

        if (owner instanceof LivingEntity livingOwner && target instanceof LivingEntity) {
            if (target.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) && owner.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM))
                return;

            float m = owner instanceof Player ? 0 : MathUtils.toPercent(((LivingEntity) target).getMaxHealth());

            boolean hurt = target.hurt(ModDamageTypes.causeGhostlyDamage(livingOwner, livingOwner), getDamage() + m);
            if (hurt && !(getOwner() instanceof Player || getOwner() instanceof FracturedApostleEntity)) {
                EntityUtil.applyStackingEffect((LivingEntity) target, ModEffects.SOUL_FRACTURE.get(), 1, 4, MathUtils.toTicks(10));
                livingOwner.heal(3);
            }
        }
    }

    @Override
    protected void onHit(HitResult pResult) {

        super.onHit(pResult);
        ;
    }
}
