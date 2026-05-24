package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Message.PlayBossMusicMessage;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class IAnimatedBoss extends IAnimatedMonster {

    public IAnimatedBoss(EntityType entity, Level world) {
        super(entity, world);
        setMaxUpStep(1.5f);
    }

    /// DATA
    // private static final EntityDataAccessor<Float> BACK_X =
    //     SynchedEntityData.defineId(IAnimatedMonster.class, EntityDataSerializers.FLOAT);
    //  private static final EntityDataAccessor<Float> BACK_Y =
    //       SynchedEntityData.defineId(IAnimatedMonster.class, EntityDataSerializers.FLOAT);
    // private static final EntityDataAccessor<Float> BACK_Z =
    //      SynchedEntityData.defineId(IAnimatedMonster.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<BlockPos> SPAWN_POS =
            SynchedEntityData.defineId(IAnimatedMonster.class, EntityDataSerializers.BLOCK_POS);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(SPAWN_POS, BlockPos.ZERO);
        //entityData.define(BACK_X,0f);
        //entityData.define(BACK_Y,0f);
        // entityData.define(BACK_Z,0f);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        float x = pCompound.getInt("posX");
        float y = pCompound.getInt("posY");
        float z = pCompound.getInt("posZ");
        BlockPos blockPos = new BlockPos((int) x, (int) y, (int) z);
        setSpawnBlockPos(blockPos);
        super.readAdditionalSaveData(pCompound);
        // if (this.getHealth() == this.getMaxHealth()) {
        // updateAttributes(); }
        if (pCompound.contains("_td")) {
            long encrypted = pCompound.getLong("_td");
            int bits = (int) (encrypted ^ 0x5F3759DF);
            float loaded = Float.intBitsToFloat(bits);
            totalDamageTaken = Math.max(0.0F, Math.min(loaded, getMaxHealth()));
            loadedFromNBT = true;
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putInt("posX", getSpawnBlockPos().getX());
        pCompound.putInt("posY", getSpawnBlockPos().getY());
        pCompound.putInt("posZ", getSpawnBlockPos().getZ());
        super.addAdditionalSaveData(pCompound);
        int bits = Float.floatToIntBits(totalDamageTaken);
        long encrypted = (long) bits ^ 0x5F3759DF;
        pCompound.putLong("_td", encrypted);
    }

    /// DATA VALUE
    public BlockPos getSpawnBlockPos() {
        return entityData.get(SPAWN_POS);
    }

    public void setSpawnBlockPos(BlockPos blockPos) {
        entityData.set(SPAWN_POS, blockPos);
    }
    /*
    public float getBackX(){
        return entityData.get(BACK_X);
    }
    public float getBackY(){
        return entityData.get(BACK_Y);
    }
    public float getBackZ(){
        return entityData.get(BACK_Z);
    }
    public void setBackX(float x){
        entityData.set(BACK_X,x);
    }
    public void setBackY(float y){
        entityData.set(BACK_Y,y);
    }
    public void setBackZ(float z){
        entityData.set(BACK_Z,z);
    }*/


    /// COOLDOWNS AND TICKING
    public final int REDUCED_DAMAGE_TICKS = 100;

    public final int DAMAGE_ADAPTATION_TICKS = 30; //How much time to reset adaptation
    public int reducedDamageTicks = REDUCED_DAMAGE_TICKS;


    public int damageAdaptationTicks = DAMAGE_ADAPTATION_TICKS;

    public final int INACTIVE_TICKS = 260;
    public final int RETURN_TO_SPAWN_TICKS = 100;
    public int inActiveTicks = INACTIVE_TICKS;
    public int return_to_spawn_ticks = RETURN_TO_SPAWN_TICKS;

    @Override
    public void tick() {
        if (!this.level().isClientSide()) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(getMaxHealth());
            if (hurtCD > 0) hurtCD--;
            if (getHealth() > 0.0F) {
                super.setHealth(getHealth());
            }
        }
        // updateAttributes();
        //Cooldowns
        if (targetIsNotNull()) inActiveTicks = INACTIVE_TICKS;

        if (return_to_spawn_ticks > 0 && inActiveTicks <= 0 && getSpawnBlockPos().distToCenterSqr(position()) >= 225)
            return_to_spawn_ticks--;

        if (reducedDamageTicks > 0) reducedDamageTicks--;
        if (damageAdaptationTicks > 0) damageAdaptationTicks--;

        if (damageAdaptationTicks == 0) {
            setDamageTimeFactor(100);
        }
        if (this.getTarget() == null && !level().isClientSide && inActiveTicks > 0) inActiveTicks--;
        if (inActiveTicks <= 0 && return_to_spawn_ticks <= 0 && !level().isClientSide && getSpawnBlockPos().distToCenterSqr(position()) >= 225) {
            if (ModConfig.MOB_CONFIG.canBossesTeleportBackToSpawn.get()) moveToBlockPos(getSpawnBlockPos());
            return_to_spawn_ticks = RETURN_TO_SPAWN_TICKS;
        }
        //Music Playing
        if (!level().isClientSide && getBossMusic() != null) {
            if (canPlayMusic() && this.getBossMusic() != null) {
                LegendaryMonsters.sendMSGToAll(new PlayBossMusicMessage(this.getId(), true));
            } else {
                LegendaryMonsters.sendMSGToAll(new PlayBossMusicMessage(this.getId(), false));
            }

        }
        super.tick();
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }


    /// ADDING TO WORLD
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        // BlockPos spawnBlockPos = new BlockPos((int) getX(), (int) getY(), (int) getZ());
        ;

        setSpawnBlockPos(this.blockPosition());
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);

    }


    /// CUSTOM INTS EXT.
    public double damageCap() {
        return 21;
    }

    public float damageReduction() {
        return 1f;
    }

    public double healthMult() {
        return 1;
    }

    public double damageMult() {
        return 1;
    }

    public double baseDamage() {
        return 10;
    }

    public double baseHealth() {
        return 20;
    }


    public void moveToBlockPos(BlockPos blockPos) {
        this.moveTo(blockPos, getYRot(), getXRot());
    }


    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        return false;
    }

    public double antiCheeseDistance() {
        return 15;
    }

    public static float entityBasedHpDamage(LivingEntity entity, float precentage) {
        return entity.getMaxHealth() * MathUtils.toPercent(precentage);
    }

    public static float toPercent(float precentage) {
        return (float) (precentage * 0.01);
    }

    public boolean damageReductionSystem() {
        return false;
    }

    public boolean damageAdaptationSystem() {
        return false;
    }

    public int adaptationFactor() {
        return 10;
    }

    public int damageTimeFactor = 100;

    public int DamageTime() {
        return Math.max(20, damageTimeFactor);
    }

    public void setDamageTimeFactor(int amount) {
        damageTimeFactor = amount;
    }

    int hurtCD = 0;
    private static final int HURT_COOLDOWN = 30;
    float totalDamageTaken = 0;
    private boolean loadedFromNBT = false;

    @Override
    public void setHealth(float newHealth) {
        if (this.level().isClientSide()) {
            super.setHealth(newHealth);
            return;
        }
        if (this.tickCount == 0) {
            super.setHealth(getMaxHealth());
        }
    }

    public boolean getInvulnerabilityConfig() {
        return true;
    }

    public void addDamage(float amount, DamageSource source) {
        float maxAllowed = (float) damageCap();
        float clamped = Math.min(amount, maxAllowed);

        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) clamped = amount;

        if (clamped <= 0.0F) return;

        float finalDamage = this.getDamageAfterArmorAbsorb(source, clamped);
        finalDamage = this.getDamageAfterMagicAbsorb(source, finalDamage);
        if (finalDamage <= 0.0F) return;

        totalDamageTaken += finalDamage;
        super.setHealth(getHealth());

        if (getInvulnerabilityConfig()) hurtCD = HURT_COOLDOWN;

      //  System.out.println("Amount before armor: " + amount);
      //  System.out.println("Amount after armor: " + finalDamage);

        if (getHealth() <= 0.0F) {
            this.die(source);
        }
    }

    @Override
    public float getHealth() {
        if (this.level().isClientSide()) {
            return super.getHealth();
        }
        return Math.max(0.0f, getMaxHealth() - totalDamageTaken);
    }

    @Override
    public boolean isDeadOrDying() {
        return getHealth() <= 0.0F;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0.0F && !this.isRemoved();
    }

    @Override
    public void heal(float amount) {
        if (this.level().isClientSide()) {
            super.heal(amount);
            return;
        }
        if (amount <= 0.0F || totalDamageTaken <= 0.0F) return;
        totalDamageTaken = Math.max(0.0F, totalDamageTaken - amount);
        super.setHealth(getHealth());
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        } else {
            amount = (float) Math.min(damageCap(), amount);
        }
        if (reducedDamage()) {
            amount *= Mth.clamp(toPercent(reducedDamageTicks), 0.5f, amount);
        }
        if (source.is(DamageTypes.FALL) || source.is(DamageTypes.DROWN) || source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypes.FREEZE) || source.is(DamageTypes.FREEZE))
            return false;

        if (getTarget() != null && (this.distanceTo(getTarget()) > antiCheeseDistance() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY))) {
            return false;
        }

        boolean hurt1 = super.hurt(source, amount);
        if (hurt1) {

        //    System.out.println("TotalAmount: " + amount);
            damageAdaptationTicks = DAMAGE_ADAPTATION_TICKS;
            damageTimeFactor -= adaptationFactor();
            //  System.out.println("Called Hurt1" + " DamageTime: " + damageTimeFactor + " reducedDamage: " + reducedDamage());
        }
        return hurt1;
    }

    public boolean reducedDamage() {
        return DamageTime() < 100;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public void updateFluidHeightAndDoFluidPushing() {
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.8D));
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    /// MUSIC
    public boolean canPlayerHearMusic(Player player) {
        return player != null
                && canAttack(player)
                && distanceTo(player) < 100;
    }

    protected boolean canPlayMusic() {
        return !isSilent() && getTarget() instanceof Player && getTarget() != null;
    }

    public SoundEvent getBossMusic() {
        return null;
    }


    public Random random1 = new Random();

    public void attractParticles(ParticleOptions particleOptions, int cap, int reps, float vec, float offset, float startY, float endY, float velocity) {
        float f = Mth.cos(yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        int rX = random1.nextInt(-cap, cap);
        int rZ = random1.nextInt(-cap, cap);

        float f2 = (this.random.nextFloat() - 0F) * 0.5F;
        double d1 = getX() + rX;
        double d2 = getY() + startY + f2;

        double d3 = getZ() + rZ;
        Vec3 vec3 = new Vec3(d1, d2, d3);
        Vec3 vec4 = new Vec3(getX() + vec * vecX + f * offset, position().y + endY, getZ() + vec * vecZ + f1 * offset);
        Vec3 vf = vec4.subtract(vec3);
        Vec3 v = vf.scale(velocity);
        for (int i = 0; i <= reps; i++) {
            if (level().isClientSide) {
                this.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);
                //       this.level().addParticle(particleOptions, d1, d2, d3, v.x, v.y, v.z);
            }
        }
    }
}
