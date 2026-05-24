package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractChorusling;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.AbstractFlameborn;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IStateGoal;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.tag.ModEntityTags;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class WanderingEyeEntity extends AbstractFlameborn {
    public WanderingEyeEntity(EntityType entity, Level world) {

        super(entity, world);
        xpReward = 3;
        setPersistenceRequired();
    }
    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypes.FALL))return false;
        return super.hurt(pSource, pAmount);
    }
    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide)idleAnimationState.animateWhen(getAttackState() ==0,tickCount);
        UpdateWithAttack();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.WANDERING_EYE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WANDERING_EYE_AMBIENT.get();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.goalSelector.addGoal(8, new RandomStrollGoal(this,1, MathUtils.toTicks(2)));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractChorusling.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        //death
        this.goalSelector.addGoal(1, new IStateGoal(this, 3, 3, 0, 60, 0){
        });
        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 55, 55, 2.5F){
            @Override
            public void stop() {
                super.stop();
            }
            public boolean canUse() {
                return super.canUse()
                        && getTarget() != null;
            }});
    }
    public void UpdateWithAttack(){
        if  (getAttackState() == 2) {
            if (attackTicks == 19) {
                playSound(ModSounds.GENERIC_ARM_SWING.get(), 1, 1.35f);
                calculatedDash(0.25f);
            }
            if (attackTicks == 22) {
                SideAreaAttack(2.5f, 2.5f, 180, 0, 0, 12, 0, SoundEvents.EMPTY, 1);
            }
        }
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
        double theta = Math.toRadians(this.yBodyRot) + Math.PI/2;
        double forwardX = Math.cos(theta) * forwardOffset;
        double forwardZ = Math.sin(theta) * forwardOffset;

        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            double dx = entityHit.getX() - (this.getX() + forwardX);
            double dz = entityHit.getZ() - (this.getZ() + forwardZ);

            float entityHitAngle = (float)((Math.toDegrees(Math.atan2(dz, dx)) - 90) % 360);
            if (entityHitAngle < 0) entityHitAngle += 360;

            float entityAttackingAngle = (this.yBodyRot - boxOffset) % 360;
            if (entityAttackingAngle < 0) entityAttackingAngle += 360;

            float entityHitDistance = (float)Math.sqrt(dx*dx + dz*dz);

            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            if (entityHitDistance <= range
                    && (entityRelativeAngle <= arc/2 && entityRelativeAngle >= -arc/2
                    || entityRelativeAngle >= 360-arc/2 || entityRelativeAngle <= -360+arc/2)) {
                if (!isAlliedTo(entityHit)  &&!(entityHit instanceof TheObliteratorEntity)&& entityHit != this) {


                    boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.WanderingEyeDamageMutliplier.get())));
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
    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.getType().is(ModEntityTags.ANNIHILATION_TEAM) || super.isAlliedTo(pEntity);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,  30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.34754F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 7D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    @Override
    public void onAddedToWorld() {
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.WanderingEyeHealthMultiplier.get());
    }

    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState RollAnimationState = new AnimationState();

    public AnimationState DeathAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "roll") {
            return this.RollAnimationState;
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
                        this.RollAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.DeathAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();
        this.RollAnimationState.stop();
        DeathAnimationState.stop();
    }
int deathTime;
    @Override
    public void die(DamageSource pDamageSource) {
        super.die(pDamageSource);
        deathTime = 0;
        setAttackState(3);
        stopAllAnimationStates();
    }
    @Override
    protected void tickDeath() {
        deathTime++;
        if (deathTime == 60){
            this.remove(RemovalReason.KILLED);
            this.gameEvent(GameEvent.ENTITY_DIE);
        }
    }
}
