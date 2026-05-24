    package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold;

    import net.miauczel.legendary_monsters.config.ModConfig;
    import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
    import net.miauczel.legendary_monsters.entity.ModEntities;
    import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
    import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
    import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
    import net.miauczel.legendary_monsters.item.ModItems;
    import net.miauczel.legendary_monsters.sound.ModSounds;
    import net.miauczel.legendary_monsters.util.EntityUtil;
    import net.minecraft.nbt.CompoundTag;
    import net.minecraft.nbt.ListTag;
    import net.minecraft.network.syncher.EntityDataAccessor;
    import net.minecraft.network.syncher.EntityDataSerializers;
    import net.minecraft.network.syncher.SynchedEntityData;
    import net.minecraft.server.level.ServerLevel;
    import net.minecraft.sounds.SoundEvent;
    import net.minecraft.sounds.SoundEvents;
    import net.minecraft.world.damagesource.DamageSource;
    import net.minecraft.world.damagesource.DamageTypes;
    import net.minecraft.world.entity.*;
    import net.minecraft.world.entity.ai.attributes.AttributeInstance;
    import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
    import net.minecraft.world.entity.ai.attributes.Attributes;
    import net.minecraft.world.entity.ai.goal.*;
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
    import net.minecraft.world.item.Items;
    import net.minecraft.world.level.GameRules;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.gameevent.GameEvent;
    import net.minecraftforge.common.extensions.IForgeEntity;
    import org.jetbrains.annotations.Nullable;

    import java.util.List;

    public class AmbusherEntity extends IAnimatedMonster implements IForgeEntity {
        private static final EntityDataAccessor<Boolean> ATTACKING =
                SynchedEntityData.defineId(AmbusherEntity.class, EntityDataSerializers.BOOLEAN);

        public AmbusherEntity(EntityType<? extends IAnimatedMonster> pEntityType, Level pLevel) {
            super(pEntityType, pLevel);
            xpReward = 2;
            this.setNoAi(false);

            {


            }

        }

        @Override
        public ItemEntity spawnAtLocation(ItemStack stack) {
            ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
            if (itementity != null) {
                itementity.setGlowingTag(true);
                itementity.setExtendedLifetime();
            }
            return itementity;
        }

        @Override
        public void tick() {

            super.tick();
            UpdateWithAttack();
            //if (this.getHealth() == this.getMaxHealth()) {
            //updateAttributes();
            //  }
            if (this.level().isClientSide()) {
            }
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

        @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(0, new FloatGoal(this));

            this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
            this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 3f));
            this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

            this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true, false));

            this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, false));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
            this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 2, 0, 15, 48, 3.5F){

            });
        }

        @Override
        public void aiStep() {
            super.aiStep();
            if (this.horizontalCollision && this.isInWall()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.1, 0, 0.1));
            }
            LivingEntity target = this.getTarget();

            if (target != null) {
                double targetX = target.getX() - this.getX();
                double targetY = target.getEyeY() - this.getEyeY();
                double targetZ = target.getZ() - this.getZ();
                double horizontalDistance = Math.sqrt(targetX * targetX + targetZ * targetZ);

                float yaw = (float) (Math.atan2(targetZ, targetX) * (180.0 / Math.PI)) - 90.0F;
                float pitch = (float) (-(Math.atan2(targetY, horizontalDistance) * (180.0 / Math.PI)));

                this.yHeadRot = this.yBodyRot = yaw;
                this.yBodyRot = pitch;
            }
        }

        public static AttributeSupplier.Builder createAttributes() {
            return Monster.createLivingAttributes()
                    .add(Attributes.MAX_HEALTH, 50D /**ModConfig.COMMON.AmbusherHealth.get() * ModConfig.COMMON.HealthMultiplier.get()*/)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.5F)
                    .add(Attributes.FOLLOW_RANGE, 14D)
                    .add(Attributes.ARMOR, 6D)
                    .add(Attributes.MOVEMENT_SPEED, 0.1F)
                    .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                    .add(Attributes.ATTACK_DAMAGE, 8D/**ModConfig.COMMON.AmbusherDamage.get() * ModConfig.COMMON.DamageMultiplier.get()*/);
        }

        @Override
        protected SoundEvent getHurtSound(DamageSource pDamageSource) {
            return ModSounds.ANCIENT_GUARDIAN_HURT.get();
        }

        @Override
        protected SoundEvent getDeathSound() {
            return ModSounds.CHORUSLING_DEATH.get();
        }

        protected boolean canDespawn() {
            this.setPersistenceRequired();
            return true;
        }

        protected PathNavigation createNavigation(Level worldIn) {
            return new ModPathNavigation(this, worldIn);
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
                    if (!isAlliedTo(entityHit) && entityHit != this && !(entityHit instanceof AmbusherEntity) && entityHit == this.getTarget()) {


                        boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.AmbusherDamageMultiplier.get())));
                        if (flag){
                            //   playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(),1,1.5f);
                        }
                    }
                }
            }
        }
public void UpdateWithAttack(){
            if (getAttackState() == 2){
                if (attackTicks == 1){
                    playSound(SoundEvents.SLIME_ATTACK,1,1);
                }
                if (attackTicks == 8 ){
AreaAttack(4,3,150f,8);
                }
            }
}
        @Override
        public void die(DamageSource source) {
            super.die(source);
            dragonDeathTime = 0;
setAttackState(3);

            SpikebugEntity spikebugEntity2 = new SpikebugEntity(ModEntities.Spiky_bug.get(), level());
            SpikebugEntity spikebugEntity1 = new SpikebugEntity(ModEntities.Spiky_bug.get(), level());
            SpikebugEntity spikebugEntity = new SpikebugEntity(ModEntities.Spiky_bug.get(), level());
            spikebugEntity.setPos(this.getX(), this.getY(), this.getZ());
            spikebugEntity.setDeltaMovement(0, 0, 0);
            level().addFreshEntity(spikebugEntity);

            spikebugEntity1.setPos(this.getX(), this.getY(), this.getZ());
            spikebugEntity1.setDeltaMovement(0, 0, 0);
            level().addFreshEntity(spikebugEntity1);
            spikebugEntity2.setPos(this.getX(), this.getY(), this.getZ());
            spikebugEntity2.setDeltaMovement(0, 0, 0);
            level().addFreshEntity(spikebugEntity2);

            ItemStack emerald = new ItemStack(Items.AIR, 1);


            this.spawnAtLocation(emerald);
        }


        @Override
        public void onAddedToWorld() {
            super.onAddedToWorld();

            EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.AmbusherHealthMutliplier.get());
            this.setPersistenceRequired();
        }


        @Override
        public boolean isPushable() {
            return true;
        }


        @Override
        public boolean hurt(DamageSource source, float amount) {
            if (ModConfig.MOB_CONFIG.Ambushprojectile.get()) {
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
               // updateAttributes();
            }
        }
/*
        public void updateAttributes() {
            double healthMultiplier = ModConfig.MOB_CONFIG.AmbusherHealthMutliplier.get();
            double damageMultiplier = ModConfig.MOB_CONFIG.AmbusherDamageMultiplier.get();

            AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
            AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

            double baseHealth = 50D; // podstawowe zdrowie moba
            double baseAttackDamage = 8D; // podstawowe obrażenia moba

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

        public int dragonDeathTime;
        public final AnimationState DeathAnimationState = new AnimationState();
        public int DeathAnimationTimeout = 20;

        @Override
        protected void tickDeath() {
            ++this.dragonDeathTime;

            boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);


            if (this.level() instanceof ServerLevel) {


                if (this.dragonDeathTime > 1 && !this.isSilent()) {
                    this.setNoAi(true);

            if (this.dragonDeathTime == 20 && this.level() instanceof ServerLevel) {
                this.remove(RemovalReason.KILLED);
                this.gameEvent(GameEvent.ENTITY_DIE);
            }
        }




    }


        }
        public AnimationState idleAnimationState = new AnimationState();
        public AnimationState toungueAnimationState = new AnimationState();

        public AnimationState deathAnimationState = new AnimationState();
        public AnimationState getAnimationState(String input) {
            if (input == "idle") {
                return this.idleAnimationState;
            }
                       else if (input == "toungue") {
                return this.toungueAnimationState;
            }
            else if (input == "death") {
                return this.deathAnimationState;
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
                        case 2-> {
                            this.stopAllAnimationStates();
                            this.toungueAnimationState.startIfStopped(this.tickCount);
                        }
                        case 3-> {
                            this.stopAllAnimationStates();
                            this.deathAnimationState.startIfStopped(this.tickCount);
                        }
                    }
            }

            super.onSyncedDataUpdated(p_21104_);
        }
        public void stopAllAnimationStates() {
            this.idleAnimationState.stop();
toungueAnimationState.stop();
            this.deathAnimationState.stop();
        }

    }