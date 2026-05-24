package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.Tornado;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class HoveringHurricaneEntity extends IAnimatedMonster {
    public HoveringHurricaneEntity(EntityType entity, Level world) {
        super(entity, world);
        xpReward = 5;

        this.setPersistenceRequired();
    }
    public int shootCoolown = 0;
    @Override
    public void tick() {
        updateWithAttack();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
if (this.getTarget() instanceof Cloud_GolemEntity) {
    this.setTarget(null);
}
if (shootCoolown >0){
    --shootCoolown;
}
        super.tick();
    }


    protected boolean canDespawn()
    {

        return false;
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
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
          //  updateAttributes();
        }
    }
    /*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.StratlingHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 50D; // podstawowe zdrowie moba
        double baseAttackDamage = 5D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }
*/

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.HoveringHurricaneHealthMultiplier.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new StratlingAttackGoal(this, 0, 2, 0, 40, 40, 3.5F){
            public boolean canUse() {
            return super.canUse() && HoveringHurricaneEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                    && HoveringHurricaneEntity.this.getTarget() != null && HoveringHurricaneEntity.this.getAttackState() !=3;
        }});

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 45, 45, 15F){
            @Override
            public void stop() {
                super.stop();
                HoveringHurricaneEntity.this.shootCoolown =40;
            }

            public boolean canUse() {
                return super.canUse() && HoveringHurricaneEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && HoveringHurricaneEntity.this.getTarget() != null && HoveringHurricaneEntity.this.getAttackState() !=2 && HoveringHurricaneEntity.this.shootCoolown <= 0;

            }});

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,  30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 6);
    }
    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState ShootAnimationState = new AnimationState();
    public AnimationState SlamAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
       if (input == "slam") {
            return this.SlamAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "shoot") {
            return this.ShootAnimationState;
        }

        else {
            return new AnimationState();
        }
    }


    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
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
                        this.SlamAnimationState.startIfStopped(this.tickCount);
                    }




                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.ShootAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();

        this.ShootAnimationState.stop();
        this.SlamAnimationState.stop();
        this.deathAnimationState.stop();
    }
    private void AreaAttack(float range, float height, float arc, float damage) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof HoveringHurricaneEntity) &&!(entityHit instanceof Cloud_GolemEntity)&& entityHit != this) {


                   boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
if (flag){
 //   playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(),1,1.5f);
}
                }
            }
        }
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() !=14 ||this.getAttackState() !=17){
            this.setNoGravity(false);
        }

            for (int i = 0; i < 0.5; ++i) {

                this.level().addParticle(ParticleTypes.CLOUD, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
            }
        }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CGA.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CGH.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CGD.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    public void updateWithAttack(){
        if (getAttackState()==3){

            if (attackTicks ==8){
            }
            if (attackTicks ==13){
                playSound(SoundEvents.WITHER_SHOOT,1,1);
                LivingEntity target = this.getTarget();
                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 1;
                float angleStep = 30.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    if (this.getTarget() != null) {
                        float m = (float) (this.getTarget().getMaxHealth() *0.05);
                        Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 10+m, angle, 120);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = this.getY(0.15D);
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    }else {
                        Tornado witherskull = new Tornado(this, dx, 0, dz, this.level(), (float) 10, angle, 120);
                        double spawnX = this.getX() + vecX * 1;
                        double spawnY = this.getY(0.15D);
                        double spawnZ = this.getZ() + vecZ * 1;
                        witherskull.setPos(spawnX, spawnY, spawnZ);
                        this.level().addFreshEntity(witherskull);
                    }
                }
            }
        }
        if (getAttackState()==2){
            if (attackTicks ==7){

                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,2);
            }
            if (attackTicks ==15){

                playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE,2,1);
                AreaAttack(4.5f,3,180,13);
            }


        }
    }
    public static class StratlingAttackGoal extends Goal {
        protected final IAnimatedMonster entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        public StratlingAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of( Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public StratlingAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
            this.entity = entity;
            this.setFlags(interruptFlagTypes);
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {

            this.entity.setAttackState(this.attackendstate);
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return this.entity.attackTicks < this.attackMaxtick;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


}