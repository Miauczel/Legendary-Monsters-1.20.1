package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class FlamebornWarriorEntity extends AbstractFlameborn {
    public FlamebornWarriorEntity(EntityType entity, Level world) {
        super(entity, world);
        this.setPersistenceRequired();
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }

    @Override
    public void tick() {
        if (level().isClientSide)idleAnimationState.animateWhen(getAttackState() == 0,tickCount);
        super.tick();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypeTags.IS_PROJECTILE)) {
            playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
            teleportRandomly(this,8,10);
            return false;
        }
        if (pSource.is(DamageTypes.FALL))return false;
        return super.hurt(pSource, pAmount);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 49, 49, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && getNextHitType() == 1;
            }});
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 49, 49, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && getNextHitType() == 2;
            }});
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 4, 0, 62, 62, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && getNextDoubleHitType() == 1;
            }});
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 5, 0, 62, 62, 3.5F){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

            public boolean canUse() {
                return super.canUse() && getRandom().nextFloat() * 100.0F < 20.0F
                        && getTarget() != null && getNextDoubleHitType() == 2;
            }});
        this.goalSelector.addGoal(1, new IStateGoal(this, 6, 6, 0, 60, 0){
            @Override
            public void stop() {
                randomizeAttacks();
                super.stop();
            }

        });
    }
    public int HitType = 1;
    public void randomizeAttacks(){
        randomizeNextDoubleHitType(2);
        randomizeNextHitType(2);
    }
    public int getNextHitType(){
        return HitType;
    }
    public void randomizeNextHitType(int rolls){
        switch (random.nextInt(rolls)){
            case 0 -> HitType = 1;

            case 1 -> HitType = 2;
        }
    }

    public int DoubleHitType = 1;
    public int getNextDoubleHitType(){
        return DoubleHitType;
    }
    public void randomizeNextDoubleHitType(int rolls){
        switch (random.nextInt(rolls)){
            case 0 -> DoubleHitType = 1;

            case 1 -> DoubleHitType = 2;
        }
    }
    public void UpdateWithAttack() {
        float range = 2.5f;
        float dash = 0.25f;
        if (getAttackState() == 2 || getAttackState() == 3) {
            if (attackTicks == 13) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1f);
                calculatedDash(dash);
            }
            if (attackTicks == 16) {
                SideAreaAttack(range, 2, 180, 0, 0, 12, 0, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1f);
            }
        }
        if (getAttackState() == 4 || getAttackState() == 5) {
            if (attackTicks == 13) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1f);
                calculatedDash(dash);
            }
            if (attackTicks == 16) {
                SideAreaAttack(range, 2, 180, 0, 0, 12, 0, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1f);
            }
            if (attackTicks == 31) {

                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,1f);
                calculatedDash(dash-0.05f);
            }
            if (attackTicks == 34) {
                SideAreaAttack(range, 4, 180, 0, 0, 12, 0, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1f);
            }
        }
    }

    @Override
    public void aiStep() {
        UpdateWithAttack();
        super.aiStep();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.3F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 4D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    public void SideAreaAttack(
            float range,
            float height,
            float arc,
            float boxOffset,
            float forwardOffset,
            float damage,
            int brokenShieldTicks,
            SoundEvent soundEvent,
            float pitch
    ) {
        double theta = Math.toRadians(this.yBodyRot) + Math.PI / 2;
        double forwardX = Math.cos(theta) * forwardOffset;
        double forwardZ = Math.sin(theta) * forwardOffset;

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            double dx = entityHit.getX() - (this.getX() + forwardX);
            double dz = entityHit.getZ() - (this.getZ() + forwardZ);

            float entityHitAngle = (float) ((Math.toDegrees(Math.atan2(dz, dx)) - 90) % 360);
            if (entityHitAngle < 0) entityHitAngle += 360;

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityAttackingAngle < 0) entityAttackingAngle += 360;

            float entityHitDistance = (float) Math.sqrt(dx * dx + dz * dz);

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            if (entityHitDistance <= range
                    && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2
                    || entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof TheObliteratorEntity) && entityHit != this) {


                    boolean flag = entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.FlamebornGuardDamageMutliplier.get())));
                    if (flag) {
                        playSound(soundEvent, 1, pitch);
                    }
                    if (entityHit instanceof Player && entityHit.isBlocking() && brokenShieldTicks > 0) {
                        disableShield(entityHit, brokenShieldTicks);
                    }
                }
            }
        }
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState HitAnimationState = new AnimationState();
    public AnimationState Hit2AnimationState = new AnimationState();

    public AnimationState HitDoubleAnimationState = new AnimationState();

    public AnimationState HitDouble2AnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();

    public AnimationState getAnimationState(String input) {
        if (input == "hit2") {
            return this.Hit2AnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "hit") {
            return this.HitAnimationState;
        } else if (input == "hit_double2") {
            return this.HitDouble2AnimationState;
        } else if (input == "hit_double") {
            return this.HitDoubleAnimationState;
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
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.HitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.Hit2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.HitDoubleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.HitDouble2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.HitAnimationState.stop();
        this.Hit2AnimationState.stop();
        this.deathAnimationState.stop();
        HitDouble2AnimationState.stop();
        HitDoubleAnimationState.stop();
    }
    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(6);
        stopAllAnimationStates();

    }
    public int deathTime;
    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 60){
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
