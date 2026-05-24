package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.OldKnights;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.Ancient_GuardianEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OldHauntedGuard extends IAnimatedMonster implements IForgeEntity {
    private final int textureVariant;
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(OldHauntedGuard.class, EntityDataSerializers.BOOLEAN);
    public OldHauntedGuard(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 2;
        this.setNoAi(false);
        this.textureVariant = this.random.nextInt(3); // Assuming you have 3 variants
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
    @Override
    public void tick() {
        super.tick();
        if (slamCooldown >0){
            slamCooldown--;
        }
//updateAttributes();

    }



    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public int slamCooldown = 20;
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Ancient_GuardianEntity.class, true));
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 40, 40, 4F){
            @Override
            public boolean canUse() {
                return super.canUse() && OldHauntedGuard.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && OldHauntedGuard.this.getTarget() != null ;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 40, 40, 4F){
            @Override
            public boolean canUse() {
                return super.canUse() && OldHauntedGuard.this.getRandom().nextFloat() * 35.0F < 16.0F
                        && OldHauntedGuard.this.getTarget() != null ;
            }
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 6, 0, 33, 33, 4F){
            @Override
            public boolean canUse() {
                return super.canUse() && OldHauntedGuard.this.getRandom().nextFloat() * 35.0F < 16.0F && slamCooldown <=0
                        && OldHauntedGuard.this.getTarget() != null ;
            }

            @Override
            public void stop() {
                slamCooldown = 20;
                super.stop();
            }
        });

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 63, 63, 4F){
            @Override
            public boolean canUse() {
                return super.canUse() && OldHauntedGuard.this.getRandom().nextFloat() * 35.0F < 50.0F
                        && OldHauntedGuard.this.getTarget() != null ;
            }
        });
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
    }

    public int getTextureVariant() {
        return this.textureVariant;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        UpdateWithAttack();
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

            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.1) {
                movementSpeedAttribute.setBaseValue(0.1);
            }
        } else {
            AttributeInstance movementSpeedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null && movementSpeedAttribute.getValue() != 0.0) {
                movementSpeedAttribute.setBaseValue(0.0);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30/*ModConfig.COMMON.hauntedGuardDamage.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7F)
                .add(Attributes.FOLLOW_RANGE, 14D)
                .add(Attributes.ARMOR, 4D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 1.3D)
                .add(Attributes.ATTACK_DAMAGE, 11/*ModConfig.COMMON.hauntedGuardDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
    }

    @Nullable

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LIVING_ARMOR_HURT.get();

    }


    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.OVERGROWN_COLOSSUS_DEATH.get();
    }

    protected boolean canDespawn() {
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
        setAttackState(7);
          dragonDeathTime = 0;

}

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.HauntedGuardHealthMultiplier.get());
        this.setPersistenceRequired();
    }


    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (ModConfig.MOB_CONFIG.Guardprojectile.get()) {
            if (source.getDirectEntity() instanceof AbstractArrow) {
                return false;
            }
        }

        if (source.is(DamageTypes.FALL))
            return false;

        if (source.is(DamageTypes.TRIDENT))
            return false;

        return super.hurt(source, amount);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
         //   updateAttributes();
        }
    }
  /*  public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.HauntedGuardHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 35D; // podstawowe zdrowie moba
        double baseAttackDamage = 7D; // podstawowe obrażenia moba

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
    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.POSSESSED_ARMOR_TEAM) || super.isAlliedTo(pEntity);
    }
    public int dragonDeathTime;
    public final AnimationState DeathAnimationState = new AnimationState();
    public int DeathAnimationTimeout = 60;
    private void AreaAttack(float range, float height, float arc, float damage, int maxExtraMobs) {

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);


        int attackedExtraMobCount = 0;

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
            float entityHitDistance = (float) Math.sqrt(
                    (entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ())
                            + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX())
            );


            boolean inRange = entityHitDistance <= range;
            boolean inArc = (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2)
                    || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2);

            if (inRange && inArc) {

                boolean isEnemy = !isAlliedTo(entityHit)
                        && entityHit != this
                        && !(entityHit instanceof OldHauntedGuard)

                        && !(entityHit instanceof HauntedKnightEntityOld)
                        && !isAlliedTo(entityHit)
                        ;

                if (isEnemy) {

                    if (entityHit == this.getTarget()) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get())
                        );
                    }
                    else if (attackedExtraMobCount < maxExtraMobs) {
                        playSound(ModSounds.POSESSED_PALADIN_ATTACK3.get(), 1, 1);
                        entityHit.hurt(
                                this.damageSources().mobAttack(this),
                                (float) (damage * ModConfig.MOB_CONFIG.HauntedGuardDamageMutliplier.get())
                        );
                        attackedExtraMobCount++;
                    }
                }
            }
        }
    }
    public void UpdateWithAttack(){
        int extraMobs = 2;
        if (getAttackState() == 2){
            if (attackTicks == 17){

                calculatedDash(0.2f);
                SoundEvent customAttackSound = ModSounds.GENERIC_ARM_SWING.get();

                playSound(customAttackSound,1,1.5f);
            }
            if (attackTicks == 20){
                AreaAttack(4f,4,180,10,extraMobs);
            }
        }
        if (getAttackState() == 4){
            if (attackTicks == 15){
                calculatedDash(0.2f);
                SoundEvent customAttackSound = ModSounds.GENERIC_ARM_SWING.get();

                playSound(customAttackSound,1,1.5f);
            }
            if (attackTicks == 18){
                AreaAttack(4f,4,100,10,extraMobs);

            }
        }
        if (getAttackState() == 6){

            if (attackTicks == 9){
                SoundEvent customAttackSound = ModSounds.GENERIC_ARM_SWING.get();
                playSound(customAttackSound,1,2);
            }



            if (attackTicks == 13){
                AreaAttack(4f,4,100,11,extraMobs);

            }}
        if (getAttackState() == 5){
            if (attackTicks == 6){


            }
            if (attackTicks == 9){
                SoundEvent customAttackSound = ModSounds.GENERIC_ARM_SWING.get();
                playSound(customAttackSound,1,2);
            }



            if (attackTicks == 13){
                AreaAttack(4f,4,100,11,extraMobs);
            }
            if (attackTicks == 41){
                calculatedDash(0.2f);
                SoundEvent customAttackSound = ModSounds.GENERIC_ARM_SWING.get();

                playSound(customAttackSound,1,1.5f);
            }



            if (attackTicks == 44){
                AreaAttack(4f,4,180,10,extraMobs);
            }
        }

    }
    protected BodyRotationControl createBodyControl()  {
        return new EntityRotationPatcher(this);
    }
    @Override
    protected void tickDeath() {
        ++this.dragonDeathTime;
        if (this.level() instanceof ServerLevel) {
            if (this.dragonDeathTime > 1 && !this.isSilent()) {
                this.setNoAi(true);

            }
        }




        if (this.dragonDeathTime == 60 && this.level() instanceof ServerLevel) {
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stabAnimationState = new AnimationState();

    public AnimationState slamAnimationState = new AnimationState();
    public AnimationState combo2AnimationState = new AnimationState();
    public AnimationState slashAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
        if (input == "slash") {
            return this.slashAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "sit") {
            return this.sitAnimationState;
        }
        else if (input == "stab") {
            return this.stabAnimationState;
        }
        else if (input == "combo2") {
            return this.combo2AnimationState;
        }
        else if (input == "death") {
            return this.DeathAnimationState;
        }

        else {
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
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.slashAnimationState.startIfStopped(this.tickCount);
                    }




                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.sitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4-> {
                        this.stopAllAnimationStates();
                        this.stabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5-> {
                        this.stopAllAnimationStates();
                        this.combo2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 6-> {
                        this.stopAllAnimationStates();
                        this.slamAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7-> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();

        this.sitAnimationState.stop();

        this.DeathAnimationState.stop();
        this.slamAnimationState.stop();
        this.slashAnimationState.stop();
        this.stabAnimationState.stop();
        this.combo2AnimationState.stop();
    }
}




