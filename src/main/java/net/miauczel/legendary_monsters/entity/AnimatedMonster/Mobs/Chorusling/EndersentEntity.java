package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EndersentEntity extends AbstractChorusling {
    public EndersentEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 40;
        this.setNoAi(false);
        this.setPersistenceRequired();
        {
            this.setPersistenceRequired();




        }
    }
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        if (isSleep()) {
            return false;
        } else return super.addEffect(pEffectInstance, pEntity);
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }


    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }
    public void resetSmashCooldown(){
        if(smashCooldown <=0) {
            this.smashCooldown = SMASH_COOLDOWN;
        }
    }
    private int teleportCooldown = 0;
    private int smashCooldown = 0;
    private final int SMASH_COOLDOWN = 60;
    public void resetSmashAnchorCooldown(){
        if(bigsmashCooldown <=0) {
            this.bigsmashCooldown = SMASH_ANCHOR_COOLDOWN;
        }
    }
    public int bigsmashCooldown = 0;
    public final int SMASH_ANCHOR_COOLDOWN = 60;
    @Override
    public void tick() {
        updateWithAttack();
        if(smashCooldown > 0){
            --smashCooldown;
        }
        if (teleportCooldown > 0) {
            --teleportCooldown;
        }
        if(bigsmashCooldown > 0){
            --bigsmashCooldown;
        }
        super.tick();
       // updateAttributes();
    }


    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }
    @Override
    protected void registerGoals() {
        // this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractFlameborn.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 45, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && EndersentEntity.this.getRandom().nextFloat() * 40.0F < 16.0F && EndersentEntity.this.bigsmashCooldown <= 0
                        && EndersentEntity.this.getTarget() != null && !(EndersentEntity.this.getAttackState() == 3);
            }

            public void stop() {
                super.stop();
                resetSmashAnchorCooldown();

            }
        });

        //chargePrepare
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 45, 15, 5.0F) {
            public boolean canUse() {
                return super.canUse() && EndersentEntity.this.getRandom().nextFloat() * 50.0F < 16.0F && EndersentEntity.this.smashCooldown <= 0
                        && EndersentEntity.this.getTarget() != null && !(EndersentEntity.this.getAttackState() == 4);
            }

            public void stop() {
                super.stop();
                resetSmashCooldown();

            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 45, 64, 5.0F));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 45, 30, 12.0F) {
            public boolean canUse() {
                return super.canUse() && EndersentEntity.this.getRandom().nextFloat() * 20.0F < 9.0F && EndersentEntity.this.teleportCooldown <= 0;
            }

            public void stop() {
                super.stop();
                EndersentEntity.this.teleportCooldown = 160;
            }
        });
        this.goalSelector.addGoal(1, new IStateGoal(this, 1, 1, 0, 0, 0) {
                    @Override
                    public void tick() {
                        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
                    }
                }

        );

        this.goalSelector.addGoal(0, new IAttackGoal(this, 1, 2, 0, 20, 0, 15));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide) {
            for(int i = 0; i < 2; ++i) {
                this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5), this.getRandomY() - 0.25, this.getRandomZ(0.5), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
            }
        }
        if (this.horizontalCollision && this.isInWall()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
        }
        LivingEntity target = this.getTarget();

        if (target != null) {
            double targetX = target.getX() - this.getX();
            double targetY = target.getEyeY() - this.getEyeY();
            double targetZ = target.getZ() - this.getZ();
            double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

            float yaw = (float)(Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
            float pitch = (float)(-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

            this.yHeadRot = this.yBodyRot = yaw;
            this.yBodyRot = pitch;
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200D/*ModConfig.COMMON.EndersentHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 16D/*ModConfig.COMMON.EndersentDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        setSleep(compound.getBoolean("is_Sleep"));
        if (this.getHealth() == this.getMaxHealth()) {
          //  updateAttributes();
        }
    }
/*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.EndersentHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.EndersentDamageMultiplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 200D; // podstawowe zdrowie moba
        double baseAttackDamage = 16D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }*/

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENDERSENT_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ENDERSENT_HURT1.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERSENT_DEATH.get();
    }

    protected boolean canDespawn()
    {
        this.setPersistenceRequired();
        return true;
    }
    @Nullable
    public ItemEntity LGspawnatlocation(ItemStack pStack) {

        pStack.addTagElement("Enchantments", new ListTag());


        ItemEntity itemEntity = this.spawnAtLocation(pStack, 0F);


        if (itemEntity != null) {
            itemEntity.setGlowingTag(true);
        }

        return itemEntity;
    }
    @Override
    public void die(DamageSource source) {
        super.die(source);
        this.setAttackState(7);
    }





    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.EndersentHealthMultiplier.get());
        this.setPersistenceRequired();
    }




    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Sleep", isSleep());

    }



    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof Projectile projectile) {

            this.teleportRandomly();

            return false;
        }

        if (source.is(DamageTypes.IN_FIRE))
            return false;



        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        if (source.is(DamageTypes.FALL))
            return false;

        if (source.is(DamageTypes.TRIDENT))
            return false;



        return super.hurt(source, amount);
    }
    // private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.PURPLE, ServerBossEvent.BossBarOverlay.NOTCHED_6);
    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState attackarm1AnimationState = new AnimationState();
    public AnimationState attackarm2AnimationState = new AnimationState();
    public AnimationState attackarmsAnimationState = new AnimationState();
    public AnimationState attackTeleportAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "attackarmright") {
            return this.attackarm1AnimationState;
        } else if (input == "attackarmleft") {
            return this.attackarm2AnimationState;
        } else if (input == "attackarms") {
            return this.attackarmsAnimationState;
        } else if (input == "attackteleport") {
            return this.attackTeleportAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }
    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.attackarm1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.attackarm2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.attackTeleportAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.attackarmsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.attackarmsAnimationState.stop();
        this.attackTeleportAnimationState.stop();
        this.attackarm1AnimationState.stop();
        this.attackarm2AnimationState.stop();
        this.deathAnimationState.stop();
    }
    private void teleportToTarget(LivingEntity target) {
        double targetPosX = targetX;
        double targetPosY = targetY;
        double targetPosZ = targetZ;
        this.teleportTo(targetPosX, targetPosY, targetPosZ);
    }

    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }

    private void teleportRandomly() {

        Vec3 entityPos = this.position();
        double x, y, z;
        Level level = this.level();

        for (int i = 0; i < 10; i++) {
            x = entityPos.x() + (this.getRandom().nextDouble() - 0.5) * 14.0;
            z = entityPos.z() + (this.getRandom().nextDouble() - 0.5) * 14.0;
            y = entityPos.y();

            int ix = Mth.floor(x);
            int iz = Mth.floor(z);
            int iy = Mth.floor(y);

            if (level.isEmptyBlock(new BlockPos(ix, iy, iz)) && !level.getBlockState(new BlockPos(ix, iy - 1,  iz)).isAir()) {
                this.teleportTo(x, y, z);
                return;
            }
        }
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
float targetX;
        float targetZ;
                float targetY;
    private void updateWithAttack(){
        if(this.getAttackState() == 7){
            if(this.attackTicks == 17){
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);

            }
            if(this.attackTicks == 58){
            }
        }
        if(this.getAttackState() == 5){

if (attackTicks == 7){
    LivingEntity target = this.getTarget();

    if (target != null) {
        double targetPosX = target.getX();
        double targetPosY = target.getY();
        double targetPosZ = target.getZ();
        targetX = (float) targetPosX;
        targetZ = (float) targetPosZ;
        targetY = (float) targetPosY;
    }
}if (attackTicks == 1){

                playSound(ModSounds.ENDERSENT_TP_HIT.get(), 2, 1);
            }
            if (this.attackTicks == 20){
                this.setInvulnerable(true);
                LivingEntity target = this.getTarget();
                if (target != null) {
                    teleportToTarget(target);
                }


            }
            if(this.attackTicks == 26 ){

                //this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                this.setInvulnerable(false);
                this.AreaAttack(5.0F, 4.0F, 140.0F, 12.0F, 40, false, 0.5F,true,0.25F,true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
            }
            if(this.attackTicks == 29){
               // this.teleportRandomly();
            }
        }
        if(this.getAttackState() == 6){

            if(this.attackTicks == 26 ){
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                this.setInvulnerable(false);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                this.AreaAttack(7.0F, 4.0F, 120.0F, 15.0F, 40, false, 0.5F,true,0.25F,true);
            }
            if(this.attackTicks == 29){
                this.teleportRandomly();
            }
        }

        if(this.getAttackState() == 4){

            if(this.attackTicks == 26 ){
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                this.setInvulnerable(false);
                this.AreaAttack(7.0F, 4.0F, 120.0F, 12.0F, 40, false, 0.5F,true,0.25F,true);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
            }
            if(this.attackTicks == 29){
                this.teleportRandomly();
            }
        }
        if(this.getAttackState() == 3){

            if(this.attackTicks == 26 ){
                this.playSound(ModSounds.ENDERSENT_ATTACK.get(), 1, 1);
                this.setInvulnerable(false);
                Vec3 entityPosition = this.position();
                CameraShakeEntity.cameraShake(this.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                this.AreaAttack(7.0F, 4.0F, 120.0F, 12.0F, 40, false, 0.5F,true,0.25F,true);
            }
            if(this.attackTicks == 29){
                this.teleportRandomly();
            }
        }
    }
    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean stun, float knockback,boolean BNknockback, float Lstrenght, boolean launch) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof EndersentEntity) && !(entityHit instanceof ChoruslingEntity) && entityHit != this) {
                    if(!stun) {
                        if(!entityHit.isBlocking() && Math.random() > 0.5) {
                            entityHit.addEffect(new MobEffectInstance(ModEffects.CHORUSINFECTION.get(), 40, 2), this);
                        }
                    }

                    entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.EndersentDamageMultiplier.get()) ));

                    if(launch){
                        entityHit.setDeltaMovement(new Vec3(0, Lstrenght, 0));
                    }
                    //entityHit.knockback(knockback,1,1);

                    if(!entityHit.isBlocking()) {
                        // entityHit.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2), this);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        //  this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }
    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public int endersentDeathTime;
    @Override
    protected void tickDeath() {
        ++this.endersentDeathTime;


        if (this.level() instanceof ServerLevel) {


            if (this.endersentDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);
            }
        }
        if(this.endersentDeathTime == 20) {
            Vec3 entityPosition = this.position();
            CameraShakeEntity.cameraShake(this.level(), entityPosition, 40.0F, 0.1F, 0, 20);
        }
        if (this.endersentDeathTime == 60 && this.level() instanceof ServerLevel) {

            this.remove(Entity.RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}